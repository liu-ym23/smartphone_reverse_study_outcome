package okio;

import B7.a;
import D7.q;
import H4.o;
import V9.g;
import W9.b;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import j9.AbstractC1607a;
import j9.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "Ljava/io/ObjectInputStream;", "in", "LC7/r;", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "", "a", "[B", "getData$okio", "()[B", SettingsConfig.KEY_DATA, "s2/a", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final ByteString d = new ByteString(new byte[0]);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final byte[] data;
    public transient int b;
    public transient String c;

    public ByteString(byte[] data) {
        k.f(data, "data");
        this.data = data;
    }

    private final void readObject(ObjectInputStream in) throws IllegalAccessException, NoSuchFieldException, IOException, SecurityException, IllegalArgumentException {
        int i = in.readInt();
        if (i < 0) {
            throw new IllegalArgumentException(a.h(i, "byteCount < 0: ").toString());
        }
        byte[] bArr = new byte[i];
        int i6 = 0;
        while (i6 < i) {
            int i10 = in.read(bArr, i6, i - i6);
            if (i10 == -1) {
                throw new EOFException();
            }
            i6 += i10;
        }
        ByteString byteString = new ByteString(bArr);
        Field declaredField = ByteString.class.getDeclaredField("a");
        declaredField.setAccessible(true);
        declaredField.set(this, byteString.data);
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    public String a() {
        byte[] bArr = this.data;
        byte[] map = V9.a.f1412a;
        k.f(bArr, "<this>");
        k.f(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i6 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i10 = i + 2;
            byte b5 = bArr[i + 1];
            i += 3;
            byte b10 = bArr[i10];
            bArr2[i6] = map[(b & 255) >> 2];
            bArr2[i6 + 1] = map[((b & 3) << 4) | ((b5 & 255) >> 4)];
            int i11 = i6 + 3;
            bArr2[i6 + 2] = map[((b5 & 15) << 2) | ((b10 & 255) >> 6)];
            i6 += 4;
            bArr2[i11] = map[b10 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b11 = bArr[i];
            bArr2[i6] = map[(b11 & 255) >> 2];
            bArr2[i6 + 1] = map[(b11 & 3) << 4];
            bArr2[i6 + 2] = 61;
            bArr2[i6 + 3] = 61;
        } else if (length2 == 2) {
            int i12 = i + 1;
            byte b12 = bArr[i];
            byte b13 = bArr[i12];
            bArr2[i6] = map[(b12 & 255) >> 2];
            bArr2[i6 + 1] = map[((b12 & 3) << 4) | ((b13 & 255) >> 4)];
            bArr2[i6 + 2] = map[(b13 & 15) << 2];
            bArr2[i6 + 3] = 61;
        }
        return new String(bArr2, AbstractC1607a.f4778a);
    }

    public ByteString b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.data, 0, c());
        byte[] bArrDigest = messageDigest.digest();
        k.c(bArrDigest);
        return new ByteString(bArrDigest);
    }

    public int c() {
        return this.data.length;
    }

    @Override // java.lang.Comparable
    public final int compareTo(ByteString byteString) {
        ByteString other = byteString;
        k.f(other, "other");
        int iC = c();
        int iC2 = other.c();
        int iMin = Math.min(iC, iC2);
        for (int i = 0; i < iMin; i++) {
            int iF = f(i) & 255;
            int iF2 = other.f(i) & 255;
            if (iF != iF2) {
                return iF < iF2 ? -1 : 1;
            }
        }
        if (iC == iC2) {
            return 0;
        }
        return iC < iC2 ? -1 : 1;
    }

    public String d() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i6 = i + 1;
            char[] cArr2 = b.f1497a;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i6] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: e, reason: from getter */
    public byte[] getData() {
        return this.data;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int iC = byteString.c();
            byte[] bArr = this.data;
            if (iC == bArr.length && byteString.g(0, 0, bArr, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte f(int i) {
        return this.data[i];
    }

    public boolean g(int i, int i6, byte[] other, int i10) {
        k.f(other, "other");
        if (i < 0) {
            return false;
        }
        byte[] bArr = this.data;
        return i <= bArr.length - i10 && i6 >= 0 && i6 <= other.length - i10 && o.l(bArr, i, i6, other, i10);
    }

    public boolean h(ByteString other, int i) {
        k.f(other, "other");
        return other.g(0, 0, this.data, i);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.data);
        this.b = iHashCode;
        return iHashCode;
    }

    public ByteString i() {
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                k.e(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i] = (byte) (b + 32);
                for (int i6 = i + 1; i6 < bArrCopyOf.length; i6++) {
                    byte b5 = bArrCopyOf[i6];
                    if (b5 >= 65 && b5 <= 90) {
                        bArrCopyOf[i6] = (byte) (b5 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
            i++;
        }
    }

    public final String j() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        byte[] data = getData();
        k.f(data, "<this>");
        String str2 = new String(data, AbstractC1607a.f4778a);
        this.c = str2;
        return str2;
    }

    public void k(g gVar, int i) {
        gVar.m1write(this.data, 0, i);
    }

    public String toString() {
        byte b;
        int i;
        ByteString byteString = this;
        byte[] bArr = byteString.data;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i6 = 0;
        int i10 = 0;
        int i11 = 0;
        loop0: while (true) {
            if (i6 >= length) {
                break;
            }
            byte b5 = bArr[i6];
            if (b5 >= 0) {
                int i12 = i11 + 1;
                if (i11 == 64) {
                    break;
                }
                if ((b5 != 10 && b5 != 13 && ((b5 >= 0 && b5 < 32) || (127 <= b5 && b5 < 160))) || b5 == 65533) {
                    break;
                }
                i10 += b5 < 65536 ? 1 : 2;
                i6++;
                while (true) {
                    i11 = i12;
                    if (i6 < length && (b = bArr[i6]) >= 0) {
                        i6++;
                        i12 = i11 + 1;
                        if (i11 == 64) {
                            break loop0;
                        }
                        if ((b != 10 && b != 13 && ((b >= 0 && b < 32) || (127 <= b && b < 160))) || b == 65533) {
                            break loop0;
                        }
                        i10 += b < 65536 ? 1 : 2;
                    } else {
                        break;
                    }
                }
            } else if ((b5 >> 5) == -2) {
                int i13 = i6 + 1;
                if (length > i13) {
                    byte b10 = bArr[i13];
                    if ((b10 & 192) == 128) {
                        int i14 = (b10 ^ 3968) ^ (b5 << 6);
                        if (i14 >= 128) {
                            i = i11 + 1;
                            if (i11 == 64) {
                                break;
                            }
                            if ((i14 != 10 && i14 != 13 && ((i14 >= 0 && i14 < 32) || (127 <= i14 && i14 < 160))) || i14 == 65533) {
                                break;
                            }
                            i10 += i14 < 65536 ? 1 : 2;
                            i6 += 2;
                            i11 = i;
                        } else if (i11 != 64) {
                            break;
                        }
                    } else if (i11 != 64) {
                        break;
                    }
                } else if (i11 != 64) {
                    break;
                }
            } else if ((b5 >> 4) == -2) {
                int i15 = i6 + 2;
                if (length > i15) {
                    byte b11 = bArr[i6 + 1];
                    if ((b11 & 192) == 128) {
                        byte b12 = bArr[i15];
                        if ((b12 & 192) == 128) {
                            int i16 = ((b12 ^ (-123008)) ^ (b11 << 6)) ^ (b5 << 12);
                            if (i16 < 2048) {
                                if (i11 != 64) {
                                    break;
                                }
                            } else if (55296 > i16 || i16 >= 57344) {
                                i = i11 + 1;
                                if (i11 == 64) {
                                    break;
                                }
                                if ((i16 != 10 && i16 != 13 && ((i16 >= 0 && i16 < 32) || (127 <= i16 && i16 < 160))) || i16 == 65533) {
                                    break;
                                }
                                i10 += i16 < 65536 ? 1 : 2;
                                i6 += 3;
                                i11 = i;
                            } else if (i11 != 64) {
                                break;
                            }
                        } else if (i11 != 64) {
                            break;
                        }
                    } else if (i11 != 64) {
                        break;
                    }
                } else if (i11 != 64) {
                    break;
                }
            } else if ((b5 >> 3) == -2) {
                int i17 = i6 + 3;
                if (length > i17) {
                    byte b13 = bArr[i6 + 1];
                    if ((b13 & 192) == 128) {
                        byte b14 = bArr[i6 + 2];
                        if ((b14 & 192) == 128) {
                            byte b15 = bArr[i17];
                            if ((b15 & 192) == 128) {
                                int i18 = (((b15 ^ 3678080) ^ (b14 << 6)) ^ (b13 << 12)) ^ (b5 << 18);
                                if (i18 > 1114111) {
                                    if (i11 != 64) {
                                        break;
                                    }
                                } else if (55296 > i18 || i18 >= 57344) {
                                    if (i18 >= 65536) {
                                        i = i11 + 1;
                                        if (i11 == 64) {
                                            break;
                                        }
                                        if ((i18 != 10 && i18 != 13 && ((i18 >= 0 && i18 < 32) || (127 <= i18 && i18 < 160))) || i18 == 65533) {
                                            break;
                                        }
                                        i10 += i18 < 65536 ? 1 : 2;
                                        i6 += 4;
                                        i11 = i;
                                    } else if (i11 != 64) {
                                        break;
                                    }
                                } else if (i11 != 64) {
                                    break;
                                }
                            } else if (i11 != 64) {
                                break;
                            }
                        } else if (i11 != 64) {
                            break;
                        }
                    } else if (i11 != 64) {
                        break;
                    }
                } else if (i11 != 64) {
                    break;
                }
            } else if (i11 != 64) {
                break;
            }
        }
        i10 = -1;
        if (i10 != -1) {
            String strJ = byteString.j();
            String strSubstring = strJ.substring(0, i10);
            k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strC0 = t.c0(t.c0(t.c0(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i10 >= strJ.length()) {
                return androidx.compose.foundation.b.m(']', "[text=", strC0);
            }
            return "[size=" + byteString.data.length + " text=" + strC0 + "…]";
        }
        if (byteString.data.length <= 64) {
            return "[hex=" + byteString.d() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(byteString.data.length);
        sb.append(" hex=");
        byte[] bArr2 = byteString.data;
        if (64 > bArr2.length) {
            throw new IllegalArgumentException(a.o(new StringBuilder("endIndex > length("), byteString.data.length, ')').toString());
        }
        if (64 != bArr2.length) {
            byteString = new ByteString(q.c0(bArr2, 0, 64));
        }
        sb.append(byteString.d());
        sb.append("…]");
        return sb.toString();
    }
}
