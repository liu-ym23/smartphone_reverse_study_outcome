package k6;

import a8.b;
import c5.l;
import java.util.Arrays;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements Comparable {

    /* renamed from: c, reason: collision with root package name */
    public static final a f3655c = new a(new byte[0]);
    public static final char[] d;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3656a;

    /* renamed from: b, reason: collision with root package name */
    public int f3657b;

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        p.d(charArray, "toCharArray(...)");
        d = charArray;
    }

    public a(byte[] bArr) {
        this.f3656a = bArr;
    }

    public final byte a(int i8) {
        byte[] bArr = this.f3656a;
        if (i8 >= 0 && i8 < bArr.length) {
            return bArr[i8];
        }
        StringBuilder sbS = b.s(i8, "index (", ") is out of byte string bounds: [0..");
        sbS.append(bArr.length);
        sbS.append(')');
        throw new IndexOutOfBoundsException(sbS.toString());
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        a other = (a) obj;
        p.e(other, "other");
        byte[] bArr = other.f3656a;
        if (other == this) {
            return 0;
        }
        byte[] bArr2 = this.f3656a;
        int iMin = Math.min(bArr2.length, bArr.length);
        for (int i8 = 0; i8 < iMin; i8++) {
            int iG = p.g(bArr2[i8] & 255, bArr[i8] & 255);
            if (iG != 0) {
                return iG;
            }
        }
        return p.g(bArr2.length, bArr.length);
    }

    public final boolean equals(Object obj) {
        int i8;
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        byte[] bArr = aVar.f3656a;
        int length = bArr.length;
        byte[] bArr2 = this.f3656a;
        if (length != bArr2.length) {
            return false;
        }
        int i9 = aVar.f3657b;
        if (i9 == 0 || (i8 = this.f3657b) == 0 || i9 == i8) {
            return Arrays.equals(bArr2, bArr);
        }
        return false;
    }

    public final int hashCode() {
        int i8 = this.f3657b;
        if (i8 != 0) {
            return i8;
        }
        int iHashCode = Arrays.hashCode(this.f3656a);
        this.f3657b = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        byte[] bArr = this.f3656a;
        if (bArr.length == 0) {
            return "ByteString(size=0)";
        }
        String strValueOf = String.valueOf(bArr.length);
        StringBuilder sb = new StringBuilder((bArr.length * 2) + strValueOf.length() + 22);
        sb.append("ByteString(size=");
        sb.append(strValueOf);
        sb.append(" hex=");
        for (byte b9 : bArr) {
            char[] cArr = d;
            sb.append(cArr[(b9 >>> 4) & 15]);
            sb.append(cArr[b9 & 15]);
        }
        sb.append(')');
        String string = sb.toString();
        p.d(string, "toString(...)");
        return string;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(byte[] data, int i8, int i9) {
        this(l.Z(data, i8, i9));
        p.e(data, "data");
    }
}
