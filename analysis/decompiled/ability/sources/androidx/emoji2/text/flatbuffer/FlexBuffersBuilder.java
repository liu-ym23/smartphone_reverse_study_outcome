package androidx.emoji2.text.flatbuffer;

import androidx.collection.SieveCacheKt;
import androidx.emoji2.text.flatbuffer.FlexBuffers;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class FlexBuffersBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8 = 0;
    private final ReadWriteBuf bb;
    private boolean finished;
    private final int flags;
    private Comparator<Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<Value> stack;
    private final HashMap<String, Integer> stringPool;

    public static class Value {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;

        public Value(int i, int i6, int i10, long j5) {
            this.key = i;
            this.type = i6;
            this.minBitWidth = i10;
            this.iValue = j5;
            this.dValue = Double.MIN_VALUE;
        }

        public static Value blob(int i, int i6, int i10, int i11) {
            return new Value(i, i10, i11, i6);
        }

        public static Value bool(int i, boolean z10) {
            return new Value(i, 26, 0, z10 ? 1L : 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int elemWidth(int i, int i6) {
            return elemWidth(this.type, this.minBitWidth, this.iValue, i, i6);
        }

        public static Value float32(int i, float f) {
            return new Value(i, 3, 2, f);
        }

        public static Value float64(int i, double d) {
            return new Value(i, 3, 3, d);
        }

        public static Value int16(int i, int i6) {
            return new Value(i, 1, 1, i6);
        }

        public static Value int32(int i, int i6) {
            return new Value(i, 1, 2, i6);
        }

        public static Value int64(int i, long j5) {
            return new Value(i, 1, 3, j5);
        }

        public static Value int8(int i, int i6) {
            return new Value(i, 1, 0, i6);
        }

        private static byte packedType(int i, int i6) {
            return (byte) (i | (i6 << 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int paddingBytes(int i, int i6) {
            return ((~i) + 1) & (i6 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte storedPackedType() {
            return storedPackedType(0);
        }

        private int storedWidth(int i) {
            return FlexBuffers.isTypeInline(this.type) ? Math.max(this.minBitWidth, i) : this.minBitWidth;
        }

        public static Value uInt16(int i, int i6) {
            return new Value(i, 2, 1, i6);
        }

        public static Value uInt32(int i, int i6) {
            return new Value(i, 2, 2, i6);
        }

        public static Value uInt64(int i, long j5) {
            return new Value(i, 2, 3, j5);
        }

        public static Value uInt8(int i, int i6) {
            return new Value(i, 2, 0, i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int elemWidth(int i, int i6, long j5, int i10, int i11) {
            if (FlexBuffers.isTypeInline(i)) {
                return i6;
            }
            for (int i12 = 1; i12 <= 32; i12 *= 2) {
                int iWidthUInBits = FlexBuffersBuilder.widthUInBits((int) (((i11 * i12) + (paddingBytes(i10, i12) + i10)) - j5));
                if ((1 << iWidthUInBits) == i12) {
                    return iWidthUInBits;
                }
            }
            return 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte storedPackedType(int i) {
            return packedType(storedWidth(i), this.type);
        }

        public Value(int i, int i6, int i10, double d) {
            this.key = i;
            this.type = i6;
            this.minBitWidth = i10;
            this.dValue = d;
            this.iValue = Long.MIN_VALUE;
        }
    }

    public FlexBuffersBuilder(int i) {
        this(new ArrayReadWriteBuf(i), 1);
    }

    private int align(int i) {
        int i6 = 1 << i;
        int iPaddingBytes = Value.paddingBytes(this.bb.writePosition(), i6);
        while (true) {
            int i10 = iPaddingBytes - 1;
            if (iPaddingBytes == 0) {
                return i6;
            }
            this.bb.put((byte) 0);
            iPaddingBytes = i10;
        }
    }

    private Value createKeyVector(int i, int i6) {
        long j5 = i6;
        int iMax = Math.max(0, widthUInBits(j5));
        int i10 = i;
        while (i10 < this.stack.size()) {
            int i11 = i10 + 1;
            iMax = Math.max(iMax, Value.elemWidth(4, 0, this.stack.get(i10).key, this.bb.writePosition(), i11));
            i10 = i11;
        }
        int iAlign = align(iMax);
        writeInt(j5, iAlign);
        int iWritePosition = this.bb.writePosition();
        while (i < this.stack.size()) {
            int i12 = this.stack.get(i).key;
            writeOffset(this.stack.get(i).key, iAlign);
            i++;
        }
        return new Value(-1, FlexBuffers.toTypedVector(4, 0), iMax, iWritePosition);
    }

    private Value createVector(int i, int i6, int i10, boolean z10, boolean z11, Value value) {
        int i11;
        int typedVector;
        int i12 = i10;
        long j5 = i12;
        int iMax = Math.max(0, widthUInBits(j5));
        if (value != null) {
            iMax = Math.max(iMax, value.elemWidth(this.bb.writePosition(), 0));
            i11 = 3;
        } else {
            i11 = 1;
        }
        int i13 = 4;
        int iMax2 = iMax;
        for (int i14 = i6; i14 < this.stack.size(); i14++) {
            iMax2 = Math.max(iMax2, this.stack.get(i14).elemWidth(this.bb.writePosition(), i14 + i11));
            if (z10 && i14 == i6) {
                i13 = this.stack.get(i14).type;
                if (!FlexBuffers.isTypedVectorElementType(i13)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i15 = i6;
        int iAlign = align(iMax2);
        if (value != null) {
            writeOffset(value.iValue, iAlign);
            writeInt(1 << value.minBitWidth, iAlign);
        }
        if (!z11) {
            writeInt(j5, iAlign);
        }
        int iWritePosition = this.bb.writePosition();
        for (int i16 = i15; i16 < this.stack.size(); i16++) {
            writeAny(this.stack.get(i16), iAlign);
        }
        if (!z10) {
            while (i15 < this.stack.size()) {
                this.bb.put(this.stack.get(i15).storedPackedType(iMax2));
                i15++;
            }
        }
        if (value != null) {
            typedVector = 9;
        } else if (z10) {
            if (!z11) {
                i12 = 0;
            }
            typedVector = FlexBuffers.toTypedVector(i13, i12);
        } else {
            typedVector = 10;
        }
        return new Value(i, typedVector, iMax2, iWritePosition);
    }

    private int putKey(String str) {
        if (str == null) {
            return -1;
        }
        int iWritePosition = this.bb.writePosition();
        if ((this.flags & 1) == 0) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.bb.put(bytes, 0, bytes.length);
            this.bb.put((byte) 0);
            this.keyPool.put(str, Integer.valueOf(iWritePosition));
            return iWritePosition;
        }
        Integer num = this.keyPool.get(str);
        if (num != null) {
            return num.intValue();
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.bb.put(bytes2, 0, bytes2.length);
        this.bb.put((byte) 0);
        this.keyPool.put(str, Integer.valueOf(iWritePosition));
        return iWritePosition;
    }

    public static int widthUInBits(long j5) {
        if (j5 <= FlexBuffers.Unsigned.byteToUnsignedInt((byte) -1)) {
            return 0;
        }
        if (j5 <= FlexBuffers.Unsigned.shortToUnsignedInt((short) -1)) {
            return 1;
        }
        return j5 <= FlexBuffers.Unsigned.intToUnsignedLong(-1) ? 2 : 3;
    }

    private void writeAny(Value value, int i) {
        int i6 = value.type;
        if (i6 != 0 && i6 != 1 && i6 != 2) {
            if (i6 == 3) {
                writeDouble(value.dValue, i);
                return;
            } else if (i6 != 26) {
                writeOffset(value.iValue, i);
                return;
            }
        }
        writeInt(value.iValue, i);
    }

    private Value writeBlob(int i, byte[] bArr, int i6, boolean z10) {
        int iWidthUInBits = widthUInBits(bArr.length);
        writeInt(bArr.length, align(iWidthUInBits));
        int iWritePosition = this.bb.writePosition();
        this.bb.put(bArr, 0, bArr.length);
        if (z10) {
            this.bb.put((byte) 0);
        }
        return Value.blob(i, iWritePosition, i6, iWidthUInBits);
    }

    private void writeDouble(double d, int i) {
        if (i == 4) {
            this.bb.putFloat((float) d);
        } else if (i == 8) {
            this.bb.putDouble(d);
        }
    }

    private void writeInt(long j5, int i) {
        if (i == 1) {
            this.bb.put((byte) j5);
            return;
        }
        if (i == 2) {
            this.bb.putShort((short) j5);
        } else if (i == 4) {
            this.bb.putInt((int) j5);
        } else {
            if (i != 8) {
                return;
            }
            this.bb.putLong(j5);
        }
    }

    private void writeOffset(long j5, int i) {
        writeInt((int) (this.bb.writePosition() - j5), i);
    }

    private Value writeString(int i, String str) {
        return writeBlob(i, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String str, int i) {
        int iPutKey = putKey(str);
        ArrayList<Value> arrayList = this.stack;
        Collections.sort(arrayList.subList(i, arrayList.size()), this.keyComparator);
        Value valueCreateVector = createVector(iPutKey, i, this.stack.size() - i, false, false, createKeyVector(i, this.stack.size() - i));
        while (this.stack.size() > i) {
            this.stack.remove(r8.size() - 1);
        }
        this.stack.add(valueCreateVector);
        return (int) valueCreateVector.iValue;
    }

    public int endVector(String str, int i, boolean z10, boolean z11) {
        Value valueCreateVector = createVector(putKey(str), i, this.stack.size() - i, z10, z11, null);
        while (this.stack.size() > i) {
            this.stack.remove(r8.size() - 1);
        }
        this.stack.add(valueCreateVector);
        return (int) valueCreateVector.iValue;
    }

    public ByteBuffer finish() {
        int iAlign = align(this.stack.get(0).elemWidth(this.bb.writePosition(), 0));
        writeAny(this.stack.get(0), iAlign);
        this.bb.put(this.stack.get(0).storedPackedType());
        this.bb.put((byte) iAlign);
        this.finished = true;
        return ByteBuffer.wrap(this.bb.data(), 0, this.bb.writePosition());
    }

    public ReadWriteBuf getBuffer() {
        return this.bb;
    }

    public int putBlob(byte[] bArr) {
        return putBlob(null, bArr);
    }

    public void putBoolean(boolean z10) {
        putBoolean(null, z10);
    }

    public void putFloat(float f) {
        putFloat((String) null, f);
    }

    public void putInt(int i) {
        putInt((String) null, i);
    }

    public int putString(String str) {
        return putString(null, str);
    }

    public void putUInt(int i) {
        putUInt(null, i);
    }

    public void putUInt64(BigInteger bigInteger) {
        putUInt64(null, bigInteger.longValue());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    private void putUInt64(String str, long j5) {
        this.stack.add(Value.uInt64(putKey(str), j5));
    }

    public int putBlob(String str, byte[] bArr) {
        Value valueWriteBlob = writeBlob(putKey(str), bArr, 25, false);
        this.stack.add(valueWriteBlob);
        return (int) valueWriteBlob.iValue;
    }

    public void putBoolean(String str, boolean z10) {
        this.stack.add(Value.bool(putKey(str), z10));
    }

    public void putFloat(String str, float f) {
        this.stack.add(Value.float32(putKey(str), f));
    }

    public void putInt(String str, int i) {
        putInt(str, i);
    }

    public int putString(String str, String str2) {
        int iPutKey = putKey(str);
        if ((this.flags & 2) == 0) {
            Value valueWriteString = writeString(iPutKey, str2);
            this.stack.add(valueWriteString);
            return (int) valueWriteString.iValue;
        }
        Integer num = this.stringPool.get(str2);
        if (num != null) {
            this.stack.add(Value.blob(iPutKey, num.intValue(), 5, widthUInBits(str2.length())));
            return num.intValue();
        }
        Value valueWriteString2 = writeString(iPutKey, str2);
        this.stringPool.put(str2, Integer.valueOf((int) valueWriteString2.iValue));
        this.stack.add(valueWriteString2);
        return (int) valueWriteString2.iValue;
    }

    public void putUInt(long j5) {
        putUInt(null, j5);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int i) {
        this(new ArrayReadWriteBuf(byteBuffer.array()), i);
    }

    private void putUInt(String str, long j5) {
        Value valueUInt64;
        int iPutKey = putKey(str);
        int iWidthUInBits = widthUInBits(j5);
        if (iWidthUInBits == 0) {
            valueUInt64 = Value.uInt8(iPutKey, (int) j5);
        } else if (iWidthUInBits == 1) {
            valueUInt64 = Value.uInt16(iPutKey, (int) j5);
        } else if (iWidthUInBits == 2) {
            valueUInt64 = Value.uInt32(iPutKey, (int) j5);
        } else {
            valueUInt64 = Value.uInt64(iPutKey, j5);
        }
        this.stack.add(valueUInt64);
    }

    public void putFloat(double d) {
        putFloat((String) null, d);
    }

    public void putInt(String str, long j5) {
        int iPutKey = putKey(str);
        if (-128 <= j5 && j5 <= 127) {
            this.stack.add(Value.int8(iPutKey, (int) j5));
            return;
        }
        if (-32768 <= j5 && j5 <= 32767) {
            this.stack.add(Value.int16(iPutKey, (int) j5));
        } else if (SieveCacheKt.NodeMetaAndPreviousMask <= j5 && j5 <= SieveCacheKt.NodeLinkMask) {
            this.stack.add(Value.int32(iPutKey, (int) j5));
        } else {
            this.stack.add(Value.int64(iPutKey, j5));
        }
    }

    public FlexBuffersBuilder(ReadWriteBuf readWriteBuf, int i) {
        this.stack = new ArrayList<>();
        this.keyPool = new HashMap<>();
        this.stringPool = new HashMap<>();
        this.finished = false;
        this.keyComparator = new Comparator<Value>() { // from class: androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.1
            @Override // java.util.Comparator
            public int compare(Value value, Value value2) {
                byte b;
                byte b5;
                int i6 = value.key;
                int i10 = value2.key;
                do {
                    b = FlexBuffersBuilder.this.bb.get(i6);
                    b5 = FlexBuffersBuilder.this.bb.get(i10);
                    if (b == 0) {
                        return b - b5;
                    }
                    i6++;
                    i10++;
                } while (b == b5);
                return b - b5;
            }
        };
        this.bb = readWriteBuf;
        this.flags = i;
    }

    public void putFloat(String str, double d) {
        this.stack.add(Value.float64(putKey(str), d));
    }

    public void putInt(long j5) {
        putInt((String) null, j5);
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }
}
