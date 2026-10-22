package org.bouncycastle.util.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes.dex */
public class FixedSecureRandom extends SecureRandom {
    private static final boolean isAndroidStyle;
    private static final boolean isClasspathStyle;
    private static final boolean isRegularStyle;
    private byte[] _data;
    private int _index;
    private static java.math.BigInteger REGULAR = new java.math.BigInteger("01020304ffffffff0506070811111111", 16);
    private static java.math.BigInteger ANDROID = new java.math.BigInteger("1111111105060708ffffffff01020304", 16);
    private static java.math.BigInteger CLASSPATH = new java.math.BigInteger("3020104ffffffff05060708111111", 16);

    public static class BigInteger extends Source {
        public BigInteger(int i8, String str) {
            super(FixedSecureRandom.expandToBitLength(i8, Hex.decode(str)));
        }

        public BigInteger(int i8, byte[] bArr) {
            super(FixedSecureRandom.expandToBitLength(i8, bArr));
        }

        public BigInteger(String str) {
            this(Hex.decode(str));
        }

        public BigInteger(byte[] bArr) {
            super(bArr);
        }
    }

    public static class Data extends Source {
        public Data(byte[] bArr) {
            super(bArr);
        }
    }

    public static class DummyProvider extends Provider {
        public DummyProvider() {
            super("BCFIPS_FIXED_RNG", 1.0d, "BCFIPS Fixed Secure Random Provider");
        }
    }

    public static class RandomChecker extends SecureRandom {
        byte[] data;
        int index;

        public RandomChecker() {
            super(null, new DummyProvider());
            this.data = Hex.decode("01020304ffffffff0506070811111111");
            this.index = 0;
        }

        @Override // java.security.SecureRandom, java.util.Random
        public void nextBytes(byte[] bArr) {
            System.arraycopy(this.data, this.index, bArr, 0, bArr.length);
            this.index += bArr.length;
        }
    }

    public static class Source {
        byte[] data;

        public Source(byte[] bArr) {
            this.data = bArr;
        }
    }

    static {
        java.math.BigInteger bigInteger = new java.math.BigInteger(128, new RandomChecker());
        java.math.BigInteger bigInteger2 = new java.math.BigInteger(120, new RandomChecker());
        isAndroidStyle = bigInteger.equals(ANDROID);
        isRegularStyle = bigInteger.equals(REGULAR);
        isClasspathStyle = bigInteger2.equals(CLASSPATH);
    }

    public FixedSecureRandom(byte[] bArr) {
        this(new Source[]{new Data(bArr)});
    }

    private static Data[] buildDataArray(byte[][] bArr) {
        Data[] dataArr = new Data[bArr.length];
        for (int i8 = 0; i8 != bArr.length; i8++) {
            dataArr[i8] = new Data(bArr[i8]);
        }
        return dataArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] expandToBitLength(int i8, byte[] bArr) {
        int i9;
        int i10;
        int i11 = (i8 + 7) / 8;
        if (i11 <= bArr.length) {
            if (isAndroidStyle && i8 < bArr.length * 8 && (i9 = i8 % 8) != 0) {
                Pack.intToBigEndian(Pack.bigEndianToInt(bArr, 0) << (8 - i9), bArr, 0);
            }
            return bArr;
        }
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, 0, bArr2, i11 - bArr.length, bArr.length);
        if (isAndroidStyle && (i10 = i8 % 8) != 0) {
            Pack.intToBigEndian(Pack.bigEndianToInt(bArr2, 0) << (8 - i10), bArr2, 0);
        }
        return bArr2;
    }

    private int nextValue() {
        byte[] bArr = this._data;
        int i8 = this._index;
        this._index = i8 + 1;
        return bArr[i8] & 255;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i8) {
        byte[] bArr = new byte[i8];
        nextBytes(bArr);
        return bArr;
    }

    public boolean isExhausted() {
        return this._index == this._data.length;
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        System.arraycopy(this._data, this._index, bArr, 0, bArr.length);
        this._index += bArr.length;
    }

    @Override // java.util.Random
    public int nextInt() {
        return nextValue() | (nextValue() << 24) | (nextValue() << 16) | (nextValue() << 8);
    }

    @Override // java.util.Random
    public long nextLong() {
        return (nextValue() << 56) | (nextValue() << 48) | (nextValue() << 40) | (nextValue() << 32) | (nextValue() << 24) | (nextValue() << 16) | (nextValue() << 8) | nextValue();
    }

    public FixedSecureRandom(Source[] sourceArr) throws IOException {
        super(null, new DummyProvider());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i8 = 0;
        if (!isRegularStyle) {
            if (!isAndroidStyle) {
                throw new IllegalStateException("Unrecognized BigInteger implementation");
            }
            for (int i9 = 0; i9 != sourceArr.length; i9++) {
                try {
                    Source source = sourceArr[i9];
                    if (source instanceof BigInteger) {
                        byte[] bArr = source.data;
                        int length = bArr.length - (bArr.length % 4);
                        int i10 = 0;
                        while (i10 < length) {
                            i10 += 4;
                            byteArrayOutputStream.write(bArr, bArr.length - i10, 4);
                        }
                        if (bArr.length - length != 0) {
                            for (int i11 = 0; i11 != 4 - (bArr.length - length); i11++) {
                                byteArrayOutputStream.write(0);
                            }
                        }
                        for (int i12 = 0; i12 != bArr.length - length; i12++) {
                            byteArrayOutputStream.write(bArr[length + i12]);
                        }
                    } else {
                        byteArrayOutputStream.write(source.data);
                    }
                } catch (IOException unused) {
                    throw new IllegalArgumentException("can't save value source.");
                }
            }
        } else if (isClasspathStyle) {
            while (i8 != sourceArr.length) {
                try {
                    Source source2 = sourceArr[i8];
                    if (source2 instanceof BigInteger) {
                        byte[] bArr2 = source2.data;
                        int length2 = bArr2.length - (bArr2.length % 4);
                        for (int length3 = (bArr2.length - length2) - 1; length3 >= 0; length3--) {
                            byteArrayOutputStream.write(bArr2[length3]);
                        }
                        for (int length4 = bArr2.length - length2; length4 < bArr2.length; length4 += 4) {
                            byteArrayOutputStream.write(bArr2, length4, 4);
                        }
                    } else {
                        byteArrayOutputStream.write(source2.data);
                    }
                    i8++;
                } catch (IOException unused2) {
                    throw new IllegalArgumentException("can't save value source.");
                }
            }
        } else {
            while (i8 != sourceArr.length) {
                try {
                    byteArrayOutputStream.write(sourceArr[i8].data);
                    i8++;
                } catch (IOException unused3) {
                    throw new IllegalArgumentException("can't save value source.");
                }
            }
        }
        this._data = byteArrayOutputStream.toByteArray();
    }

    public FixedSecureRandom(byte[][] bArr) {
        this(buildDataArray(bArr));
    }
}
