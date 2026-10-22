package okio;

import Mb.C0963a;
import Mb.C0966d;
import Mb.E;
import Nb.g;
import Z8.C1168p;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.auth.HttpAuthHeader;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u000eH\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u001cH\u0010¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001cH\u0010¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010(J'\u0010.\u001a\u00020-2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001cH\u0010¢\u0006\u0004\b.\u0010/J/\u00102\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001cH\u0016¢\u0006\u0004\b2\u00103J/\u00104\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001cH\u0016¢\u0006\u0004\b4\u00105J!\u00107\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u001cH\u0016¢\u0006\u0004\b7\u00108J!\u00109\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u001cH\u0016¢\u0006\u0004\b9\u00108J\u000f\u0010:\u001a\u00020\u0003H\u0010¢\u0006\u0004\b:\u0010(J\u001a\u0010<\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u00010;H\u0096\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u001cH\u0016¢\u0006\u0004\b>\u0010&J\u000f\u0010?\u001a\u00020\u000eH\u0016¢\u0006\u0004\b?\u0010\u0016J\u000f\u0010@\u001a\u00020\u0001H\u0002¢\u0006\u0004\b@\u0010\u0018R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H¨\u0006I"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "", "", "segments", "", "directory", "<init>", "([[B[I)V", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", "Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "", "M", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "", "includePadding", Const.INTENT_KEY_PKGNAME, "(Z)Ljava/lang/String;", "t", "()Ljava/lang/String;", "P", "()Lokio/ByteString;", "algorithm", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)Lokio/ByteString;", "", "beginIndex", "endIndex", "N", "(II)Lokio/ByteString;", "pos", "", "y", "(I)B", "q", "()I", "U", "()[B", "LMb/d;", "buffer", "offset", "byteCount", "LY8/t;", "R", "(LMb/d;II)V", "other", "otherOffset", "D", "(ILokio/ByteString;II)Z", ExifInterface.LONGITUDE_EAST, "(I[BII)Z", "fromIndex", "v", "([BI)I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "x", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "f", "[[B", ExifInterface.GPS_DIRECTION_TRUE, "()[[B", Const.INTENT_KEY_BACKGROUND_COMMAND, "[I", ExifInterface.LATITUDE_SOUTH, "()[I", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SegmentedByteString extends ByteString {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final transient byte[][] segments;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final transient int[] directory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(byte[][] segments, int[] directory) {
        super(ByteString.f37756e.getData());
        p.i(segments, "segments");
        p.i(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final Object writeReplace() {
        ByteString byteStringV = V();
        p.g(byteStringV, "null cannot be cast to non-null type java.lang.Object");
        return byteStringV;
    }

    @Override // okio.ByteString
    public int A(byte[] other, int fromIndex) {
        p.i(other, "other");
        return V().A(other, fromIndex);
    }

    @Override // okio.ByteString
    public boolean D(int offset, ByteString other, int otherOffset, int byteCount) {
        p.i(other, "other");
        if (offset < 0 || offset > K() - byteCount) {
            return false;
        }
        int i10 = byteCount + offset;
        int iB = g.b(this, offset);
        while (offset < i10) {
            int i11 = iB == 0 ? 0 : getDirectory()[iB - 1];
            int i12 = getDirectory()[iB] - i11;
            int i13 = getDirectory()[getSegments().length + iB];
            int iMin = Math.min(i10, i12 + i11) - offset;
            if (!other.E(otherOffset, getSegments()[iB], i13 + (offset - i11), iMin)) {
                return false;
            }
            otherOffset += iMin;
            offset += iMin;
            iB++;
        }
        return true;
    }

    @Override // okio.ByteString
    public boolean E(int offset, byte[] other, int otherOffset, int byteCount) {
        p.i(other, "other");
        if (offset < 0 || offset > K() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int i10 = byteCount + offset;
        int iB = g.b(this, offset);
        while (offset < i10) {
            int i11 = iB == 0 ? 0 : getDirectory()[iB - 1];
            int i12 = getDirectory()[iB] - i11;
            int i13 = getDirectory()[getSegments().length + iB];
            int iMin = Math.min(i10, i12 + i11) - offset;
            if (!C0963a.a(getSegments()[iB], i13 + (offset - i11), other, otherOffset, iMin)) {
                return false;
            }
            otherOffset += iMin;
            offset += iMin;
            iB++;
        }
        return true;
    }

    @Override // okio.ByteString
    public String M(Charset charset) {
        p.i(charset, "charset");
        return V().M(charset);
    }

    @Override // okio.ByteString
    public ByteString N(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new IllegalArgumentException(("beginIndex=" + beginIndex + " < 0").toString());
        }
        if (endIndex > K()) {
            throw new IllegalArgumentException(("endIndex=" + endIndex + " > length(" + K() + ')').toString());
        }
        int i10 = endIndex - beginIndex;
        if (i10 < 0) {
            throw new IllegalArgumentException(("endIndex=" + endIndex + " < beginIndex=" + beginIndex).toString());
        }
        if (beginIndex == 0 && endIndex == K()) {
            return this;
        }
        if (beginIndex == endIndex) {
            return ByteString.f37756e;
        }
        int iB = g.b(this, beginIndex);
        int iB2 = g.b(this, endIndex - 1);
        byte[][] bArr = (byte[][]) C1168p.q(getSegments(), iB, iB2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iB <= iB2) {
            int i11 = iB;
            int i12 = 0;
            while (true) {
                iArr[i12] = Math.min(getDirectory()[i11] - beginIndex, i10);
                int i13 = i12 + 1;
                iArr[i12 + bArr.length] = getDirectory()[getSegments().length + i11];
                if (i11 == iB2) {
                    break;
                }
                i11++;
                i12 = i13;
            }
        }
        int i14 = iB != 0 ? getDirectory()[iB - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (beginIndex - i14);
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.ByteString
    public ByteString P() {
        return V().P();
    }

    @Override // okio.ByteString
    public void R(C0966d buffer, int offset, int byteCount) {
        p.i(buffer, "buffer");
        int i10 = offset + byteCount;
        int iB = g.b(this, offset);
        while (offset < i10) {
            int i11 = iB == 0 ? 0 : getDirectory()[iB - 1];
            int i12 = getDirectory()[iB] - i11;
            int i13 = getDirectory()[getSegments().length + iB];
            int iMin = Math.min(i10, i12 + i11) - offset;
            int i14 = i13 + (offset - i11);
            E e10 = new E(getSegments()[iB], i14, i14 + iMin, true, false);
            E e11 = buffer.head;
            if (e11 == null) {
                e10.prev = e10;
                e10.next = e10;
                buffer.head = e10;
            } else {
                p.f(e11);
                E e12 = e11.prev;
                p.f(e12);
                e12.c(e10);
            }
            offset += iMin;
            iB++;
        }
        buffer.a1(buffer.getSize() + byteCount);
    }

    /* renamed from: S, reason: from getter */
    public final int[] getDirectory() {
        return this.directory;
    }

    /* renamed from: T, reason: from getter */
    public final byte[][] getSegments() {
        return this.segments;
    }

    public byte[] U() {
        byte[] bArr = new byte[K()];
        int length = getSegments().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = getDirectory()[length + i10];
            int i14 = getDirectory()[i10];
            int i15 = i14 - i11;
            C1168p.e(getSegments()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    public final ByteString V() {
        return new ByteString(U());
    }

    @Override // okio.ByteString
    public String b(boolean includePadding) {
        return V().b(includePadding);
    }

    @Override // okio.ByteString
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.K() == K() && D(0, byteString, 0, K())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = getSegments().length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int i13 = getDirectory()[length + i10];
            int i14 = getDirectory()[i10];
            byte[] bArr = getSegments()[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        F(i11);
        return i11;
    }

    @Override // okio.ByteString
    public ByteString i(String algorithm) throws NoSuchAlgorithmException {
        p.i(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = getDirectory()[length + i10];
            int i13 = getDirectory()[i10];
            messageDigest.update(getSegments()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
        byte[] bArrDigest = messageDigest.digest();
        p.f(bArrDigest);
        return new ByteString(bArrDigest);
    }

    @Override // okio.ByteString
    public int q() {
        return getDirectory()[getSegments().length - 1];
    }

    @Override // okio.ByteString
    public String t() {
        return V().t();
    }

    @Override // okio.ByteString
    public String toString() {
        return V().toString();
    }

    @Override // okio.ByteString
    public int v(byte[] other, int fromIndex) {
        p.i(other, "other");
        return V().v(other, fromIndex);
    }

    @Override // okio.ByteString
    public byte[] x() {
        return U();
    }

    @Override // okio.ByteString
    public byte y(int pos) {
        C0963a.b(getDirectory()[getSegments().length - 1], pos, 1L);
        int iB = g.b(this, pos);
        return getSegments()[iB][(pos - (iB == 0 ? 0 : getDirectory()[iB - 1])) + getDirectory()[getSegments().length + iB]];
    }
}
