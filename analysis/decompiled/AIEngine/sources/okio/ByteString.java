package okio;

import androidx.datastore.preferences.protobuf.b1;
import gc.o;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import lb.n;
import sd.e;
import td.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f11312d = new ByteString(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f11313a;

    /* renamed from: b, reason: collision with root package name */
    public transient int f11314b;

    /* renamed from: c, reason: collision with root package name */
    public transient String f11315c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static ByteString a(String str) {
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                bArr[i10] = (byte) (b.a(str.charAt(i11 + 1)) + (b.a(str.charAt(i11)) << 4));
            }
            return new ByteString(bArr);
        }

        public static ByteString b(String str) {
            g.f(str, "<this>");
            byte[] bytes = str.getBytes(gc.a.f9106b);
            g.e(bytes, "getBytes(...)");
            ByteString byteString = new ByteString(bytes);
            byteString.f11315c = str;
            return byteString;
        }

        public static ByteString c(byte[] bArr) {
            ByteString byteString = ByteString.f11312d;
            e.a aVar = sd.a.f11899a;
            int length = bArr.length;
            sd.a.b(bArr.length, 0, length);
            return new ByteString(b1.u(bArr, 0, length));
        }
    }

    public ByteString(byte[] data) {
        g.f(data, "data");
        this.f11313a = data;
    }

    public static int h(ByteString byteString, ByteString other) {
        byteString.getClass();
        g.f(other, "other");
        return byteString.g(other.i(), 0);
    }

    public static int l(ByteString byteString, ByteString other) {
        int i10 = sd.a.f11900b;
        byteString.getClass();
        g.f(other, "other");
        return byteString.k(other.i(), i10);
    }

    public static ByteString p(ByteString byteString, int i10, int i11, int i12) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = sd.a.f11900b;
        }
        return byteString.o(i10, i11);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException, SecurityException, IllegalArgumentException {
        int i10 = objectInputStream.readInt();
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "byteCount < 0: ").toString());
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        while (i11 < i10) {
            int i12 = objectInputStream.read(bArr, i11, i10 - i11);
            if (i12 == -1) {
                throw new EOFException();
            }
            i11 += i12;
        }
        ByteString byteString = new ByteString(bArr);
        Field declaredField = ByteString.class.getDeclaredField("a");
        declaredField.setAccessible(true);
        declaredField.set(this, byteString.f11313a);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f11313a.length);
        objectOutputStream.write(this.f11313a);
    }

    public String a() {
        byte[] bArr = this.f11313a;
        byte[] map = okio.a.f11317a;
        g.f(bArr, "<this>");
        g.f(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = bArr[i10];
            int i12 = i10 + 2;
            byte b11 = bArr[i10 + 1];
            i10 += 3;
            byte b12 = bArr[i12];
            bArr2[i11] = map[(b10 & 255) >> 2];
            bArr2[i11 + 1] = map[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            int i13 = i11 + 3;
            bArr2[i11 + 2] = map[((b11 & 15) << 2) | ((b12 & 255) >> 6)];
            i11 += 4;
            bArr2[i13] = map[b12 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b13 = bArr[i10];
            bArr2[i11] = map[(b13 & 255) >> 2];
            bArr2[i11 + 1] = map[(b13 & 3) << 4];
            bArr2[i11 + 2] = 61;
            bArr2[i11 + 3] = 61;
        } else if (length2 == 2) {
            int i14 = i10 + 1;
            byte b14 = bArr[i10];
            byte b15 = bArr[i14];
            bArr2[i11] = map[(b14 & 255) >> 2];
            bArr2[i11 + 1] = map[((b14 & 3) << 4) | ((b15 & 255) >> 4)];
            bArr2[i11 + 2] = map[(b15 & 15) << 2];
            bArr2[i11 + 3] = 61;
        }
        return new String(bArr2, gc.a.f9106b);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(ByteString other) {
        g.f(other, "other");
        int iD = d();
        int iD2 = other.d();
        int iMin = Math.min(iD, iD2);
        for (int i10 = 0; i10 < iMin; i10++) {
            int iJ = j(i10) & 255;
            int iJ2 = other.j(i10) & 255;
            if (iJ != iJ2) {
                return iJ < iJ2 ? -1 : 1;
            }
        }
        if (iD == iD2) {
            return 0;
        }
        return iD < iD2 ? -1 : 1;
    }

    public ByteString c(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f11313a, 0, d());
        byte[] bArrDigest = messageDigest.digest();
        g.c(bArrDigest);
        return new ByteString(bArrDigest);
    }

    public int d() {
        return this.f11313a.length;
    }

    public String e() {
        byte[] bArr = this.f11313a;
        char[] cArr = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = b.f13074a;
            cArr[i10] = cArr2[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int iD = byteString.d();
            byte[] bArr = this.f11313a;
            if (iD == bArr.length && byteString.n(bArr, 0, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int g(byte[] other, int i10) {
        g.f(other, "other");
        int length = this.f11313a.length - other.length;
        int iMax = Math.max(i10, 0);
        if (iMax > length) {
            return -1;
        }
        while (!sd.a.a(iMax, 0, other.length, this.f11313a, other)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public int hashCode() {
        int i10 = this.f11314b;
        if (i10 != 0) {
            return i10;
        }
        int iHashCode = Arrays.hashCode(this.f11313a);
        this.f11314b = iHashCode;
        return iHashCode;
    }

    public byte[] i() {
        return this.f11313a;
    }

    public byte j(int i10) {
        return this.f11313a[i10];
    }

    public int k(byte[] other, int i10) {
        g.f(other, "other");
        if (i10 == sd.a.f11900b) {
            i10 = d();
        }
        for (int iMin = Math.min(i10, this.f11313a.length - other.length); -1 < iMin; iMin--) {
            if (sd.a.a(iMin, 0, other.length, this.f11313a, other)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean m(int i10, ByteString other, int i11) {
        g.f(other, "other");
        return other.n(this.f11313a, 0, i10, i11);
    }

    public boolean n(byte[] other, int i10, int i11, int i12) {
        g.f(other, "other");
        if (i10 < 0) {
            return false;
        }
        byte[] bArr = this.f11313a;
        return i10 <= bArr.length - i12 && i11 >= 0 && i11 <= other.length - i12 && sd.a.a(i10, i11, i12, bArr, other);
    }

    public ByteString o(int i10, int i11) {
        if (i11 == sd.a.f11900b) {
            i11 = d();
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f11313a;
        if (i11 > bArr.length) {
            throw new IllegalArgumentException(a0.a.l(new StringBuilder("endIndex > length("), this.f11313a.length, ')').toString());
        }
        if (i11 - i10 >= 0) {
            return (i10 == 0 && i11 == bArr.length) ? this : new ByteString(b1.u(bArr, i10, i11));
        }
        throw new IllegalArgumentException("endIndex < beginIndex");
    }

    public ByteString q() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f11313a;
            if (i10 >= bArr.length) {
                return this;
            }
            byte b10 = bArr[i10];
            if (b10 >= 65 && b10 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                g.e(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i10] = (byte) (b10 + 32);
                for (int i11 = i10 + 1; i11 < bArrCopyOf.length; i11++) {
                    byte b11 = bArrCopyOf[i11];
                    if (b11 >= 65 && b11 <= 90) {
                        bArrCopyOf[i11] = (byte) (b11 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
            i10++;
        }
    }

    public final String r() {
        String str = this.f11315c;
        if (str != null) {
            return str;
        }
        byte[] bArrI = i();
        g.f(bArrI, "<this>");
        String str2 = new String(bArrI, gc.a.f9106b);
        this.f11315c = str2;
        return str2;
    }

    public void s(e eVar, int i10) {
        eVar.m177write(this.f11313a, 0, i10);
    }

    public String toString() {
        byte b10;
        int i10;
        ByteString byteString = this;
        byte[] bArr = byteString.f11313a;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        loop0: while (true) {
            if (i11 >= length) {
                break;
            }
            byte b11 = bArr[i11];
            if (b11 >= 0) {
                int i14 = i13 + 1;
                if (i13 == 64) {
                    break;
                }
                if ((b11 != 10 && b11 != 13 && ((b11 >= 0 && b11 < 32) || (127 <= b11 && b11 < 160))) || b11 == 65533) {
                    break;
                }
                i12 += b11 < 65536 ? 1 : 2;
                i11++;
                while (true) {
                    i13 = i14;
                    if (i11 < length && (b10 = bArr[i11]) >= 0) {
                        i11++;
                        i14 = i13 + 1;
                        if (i13 == 64) {
                            break loop0;
                        }
                        if ((b10 != 10 && b10 != 13 && ((b10 >= 0 && b10 < 32) || (127 <= b10 && b10 < 160))) || b10 == 65533) {
                            break loop0;
                        }
                        i12 += b10 < 65536 ? 1 : 2;
                    } else {
                        break;
                    }
                }
            } else if ((b11 >> 5) == -2) {
                int i15 = i11 + 1;
                if (length > i15) {
                    byte b12 = bArr[i15];
                    if ((b12 & 192) == 128) {
                        int i16 = (b12 ^ 3968) ^ (b11 << 6);
                        if (i16 >= 128) {
                            i10 = i13 + 1;
                            if (i13 == 64) {
                                break;
                            }
                            if ((i16 != 10 && i16 != 13 && ((i16 >= 0 && i16 < 32) || (127 <= i16 && i16 < 160))) || i16 == 65533) {
                                break;
                            }
                            i12 += i16 < 65536 ? 1 : 2;
                            n nVar = n.f10413a;
                            i11 += 2;
                            i13 = i10;
                        } else if (i13 != 64) {
                            break;
                        }
                    } else if (i13 != 64) {
                        break;
                    }
                } else if (i13 != 64) {
                    break;
                }
            } else if ((b11 >> 4) == -2) {
                int i17 = i11 + 2;
                if (length > i17) {
                    byte b13 = bArr[i11 + 1];
                    if ((b13 & 192) == 128) {
                        byte b14 = bArr[i17];
                        if ((b14 & 192) == 128) {
                            int i18 = ((b14 ^ (-123008)) ^ (b13 << 6)) ^ (b11 << 12);
                            if (i18 < 2048) {
                                if (i13 != 64) {
                                    break;
                                }
                            } else if (55296 > i18 || i18 >= 57344) {
                                i10 = i13 + 1;
                                if (i13 == 64) {
                                    break;
                                }
                                if ((i18 != 10 && i18 != 13 && ((i18 >= 0 && i18 < 32) || (127 <= i18 && i18 < 160))) || i18 == 65533) {
                                    break;
                                }
                                i12 += i18 < 65536 ? 1 : 2;
                                n nVar2 = n.f10413a;
                                i11 += 3;
                                i13 = i10;
                            } else if (i13 != 64) {
                                break;
                            }
                        } else if (i13 != 64) {
                            break;
                        }
                    } else if (i13 != 64) {
                        break;
                    }
                } else if (i13 != 64) {
                    break;
                }
            } else if ((b11 >> 3) == -2) {
                int i19 = i11 + 3;
                if (length > i19) {
                    byte b15 = bArr[i11 + 1];
                    if ((b15 & 192) == 128) {
                        byte b16 = bArr[i11 + 2];
                        if ((b16 & 192) == 128) {
                            byte b17 = bArr[i19];
                            if ((b17 & 192) == 128) {
                                int i20 = (((b17 ^ 3678080) ^ (b16 << 6)) ^ (b15 << 12)) ^ (b11 << 18);
                                if (i20 > 1114111) {
                                    if (i13 != 64) {
                                        break;
                                    }
                                } else if (55296 > i20 || i20 >= 57344) {
                                    if (i20 >= 65536) {
                                        i10 = i13 + 1;
                                        if (i13 == 64) {
                                            break;
                                        }
                                        if ((i20 != 10 && i20 != 13 && ((i20 >= 0 && i20 < 32) || (127 <= i20 && i20 < 160))) || i20 == 65533) {
                                            break;
                                        }
                                        i12 += i20 < 65536 ? 1 : 2;
                                        n nVar3 = n.f10413a;
                                        i11 += 4;
                                        i13 = i10;
                                    } else if (i13 != 64) {
                                        break;
                                    }
                                } else if (i13 != 64) {
                                    break;
                                }
                            } else if (i13 != 64) {
                                break;
                            }
                        } else if (i13 != 64) {
                            break;
                        }
                    } else if (i13 != 64) {
                        break;
                    }
                } else if (i13 != 64) {
                    break;
                }
            } else if (i13 != 64) {
                break;
            }
        }
        i12 = -1;
        if (i12 != -1) {
            String strR = byteString.r();
            String strSubstring = strR.substring(0, i12);
            g.e(strSubstring, "substring(...)");
            String strI0 = o.i0(o.i0(o.i0(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i12 >= strR.length()) {
                return "[text=" + strI0 + ']';
            }
            return "[size=" + byteString.f11313a.length + " text=" + strI0 + "…]";
        }
        if (byteString.f11313a.length <= 64) {
            return "[hex=" + byteString.e() + ']';
        }
        StringBuilder sb2 = new StringBuilder("[size=");
        sb2.append(byteString.f11313a.length);
        sb2.append(" hex=");
        int iD = 64 == sd.a.f11900b ? byteString.d() : 64;
        byte[] bArr2 = byteString.f11313a;
        if (iD > bArr2.length) {
            throw new IllegalArgumentException(a0.a.l(new StringBuilder("endIndex > length("), byteString.f11313a.length, ')').toString());
        }
        if (iD < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (iD != bArr2.length) {
            byteString = new ByteString(b1.u(bArr2, 0, iD));
        }
        sb2.append(byteString.e());
        sb2.append("…]");
        return sb2.toString();
    }
}
