package okio;

import La.D;
import Mb.C0963a;
import Mb.C0966d;
import Mb.M;
import Nb.b;
import Nb.c;
import Z8.C1168p;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0016\u0018\u0000 `2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001QB\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0010H\u0016¢\u0006\u0004\b!\u0010\u0012J\u000f\u0010\"\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\"\u0010\u001cJ#\u0010&\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020#H\u0017¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020#H\u0010¢\u0006\u0004\b*\u0010+J\u0018\u0010-\u001a\u00020)2\u0006\u0010,\u001a\u00020#H\u0087\u0002¢\u0006\u0004\b-\u0010+J\u000f\u0010.\u001a\u00020#H\u0010¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0003H\u0010¢\u0006\u0004\b0\u00101J'\u00106\u001a\u00020\t2\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020#H\u0010¢\u0006\u0004\b6\u00107J/\u0010:\u001a\u00020\u00172\u0006\u00104\u001a\u00020#2\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020#2\u0006\u00105\u001a\u00020#H\u0016¢\u0006\u0004\b:\u0010;J/\u0010<\u001a\u00020\u00172\u0006\u00104\u001a\u00020#2\u0006\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020#2\u0006\u00105\u001a\u00020#H\u0016¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u0000¢\u0006\u0004\b?\u0010@J\u0015\u0010B\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u0000¢\u0006\u0004\bB\u0010@J!\u0010D\u001a\u00020#2\u0006\u00108\u001a\u00020\u00002\b\b\u0002\u0010C\u001a\u00020#H\u0007¢\u0006\u0004\bD\u0010EJ!\u0010F\u001a\u00020#2\u0006\u00108\u001a\u00020\u00032\b\b\u0002\u0010C\u001a\u00020#H\u0017¢\u0006\u0004\bF\u0010GJ!\u0010H\u001a\u00020#2\u0006\u00108\u001a\u00020\u00002\b\b\u0002\u0010C\u001a\u00020#H\u0007¢\u0006\u0004\bH\u0010EJ!\u0010I\u001a\u00020#2\u0006\u00108\u001a\u00020\u00032\b\b\u0002\u0010C\u001a\u00020#H\u0017¢\u0006\u0004\bI\u0010GJ\u001a\u0010K\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010JH\u0096\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020#H\u0016¢\u0006\u0004\bM\u0010/J\u0018\u0010N\u001a\u00020#2\u0006\u00108\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0010H\u0016¢\u0006\u0004\bP\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u00101R\"\u0010M\u001a\u00020#8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010T\u001a\u0004\bU\u0010/\"\u0004\bV\u0010WR$\u0010]\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010\u0012\"\u0004\b[\u0010\\R\u0011\u0010_\u001a\u00020#8G¢\u0006\u0006\u001a\u0004\b^\u0010/¨\u0006a"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "", "data", "<init>", "([B)V", "Ljava/io/ObjectInputStream;", "in", "LY8/t;", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "", "Q", "()Ljava/lang/String;", "Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "M", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "", "includePadding", Const.INTENT_KEY_PKGNAME, "(Z)Ljava/lang/String;", "H", "()Lokio/ByteString;", "J", "algorithm", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)Lokio/ByteString;", "t", "P", "", "beginIndex", "endIndex", "N", "(II)Lokio/ByteString;", "pos", "", "y", "(I)B", "index", "l", "q", "()I", "x", "()[B", "LMb/d;", "buffer", "offset", "byteCount", "R", "(LMb/d;II)V", "other", "otherOffset", "D", "(ILokio/ByteString;II)Z", ExifInterface.LONGITUDE_EAST, "(I[BII)Z", "prefix", "L", "(Lokio/ByteString;)Z", "suffix", "k", "fromIndex", "u", "(Lokio/ByteString;I)I", "v", "([BI)I", "z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "e", "(Lokio/ByteString;)I", "toString", Const.INTENT_KEY_APIKEY, "[B", "m", "I", "n", "F", "(I)V", "c", "Ljava/lang/String;", "s", "G", "(Ljava/lang/String;)V", "utf8", "K", ContentDisposition.Parameters.Size, Const.INTENT_KEY_UMID, "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static final ByteString f37756e = new ByteString(new byte[0]);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final byte[] data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public transient int hashCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public transient String utf8;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00020\u0004\"\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00020\u0007*\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\u0007*\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u0007*\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0007*\u00020\u000fH\u0007¢\u0006\u0004\b\u0016\u0010\u0011J\u0013\u0010\u0017\u001a\u00020\u0007*\u00020\u000fH\u0007¢\u0006\u0004\b\u0017\u0010\u0011J\u001b\u0010\u0019\u001a\u00020\u0007*\u00020\u00182\u0006\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lokio/ByteString$a;", "", "<init>", "()V", "", "", "data", "Lokio/ByteString;", "e", "([B)Lokio/ByteString;", "", "offset", "byteCount", "f", "([BII)Lokio/ByteString;", "", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Lokio/ByteString;", "Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "c", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/ByteString;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Ljava/io/InputStream;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/io/InputStream;I)Lokio/ByteString;", "", "serialVersionUID", "J", "EMPTY", "Lokio/ByteString;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: okio.ByteString$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ ByteString g(Companion companion, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = bArr.length;
            }
            return companion.f(bArr, i10, i11);
        }

        public final ByteString a(String str) {
            p.i(str, "<this>");
            byte[] bArrA = a.a(str);
            if (bArrA != null) {
                return new ByteString(bArrA);
            }
            return null;
        }

        public final ByteString b(String str) {
            p.i(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                bArr[i10] = (byte) ((c.b(str.charAt(i11)) << 4) + c.b(str.charAt(i11 + 1)));
            }
            return new ByteString(bArr);
        }

        public final ByteString c(String str, Charset charset) {
            p.i(str, "<this>");
            p.i(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            p.h(bytes, "getBytes(...)");
            return new ByteString(bytes);
        }

        public final ByteString d(String str) {
            p.i(str, "<this>");
            ByteString byteString = new ByteString(M.a(str));
            byteString.G(str);
            return byteString;
        }

        public final ByteString e(byte... data) {
            p.i(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            p.h(bArrCopyOf, "copyOf(...)");
            return new ByteString(bArrCopyOf);
        }

        public final ByteString f(byte[] bArr, int i10, int i11) {
            p.i(bArr, "<this>");
            C0963a.b(bArr.length, i10, i11);
            return new ByteString(C1168p.o(bArr, i10, i11 + i10));
        }

        public final ByteString h(InputStream inputStream, int i10) throws IOException {
            p.i(inputStream, "<this>");
            if (i10 < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + i10).toString());
            }
            byte[] bArr = new byte[i10];
            int i11 = 0;
            while (i11 < i10) {
                int i12 = inputStream.read(bArr, i11, i10 - i11);
                if (i12 == -1) {
                    throw new EOFException();
                }
                i11 += i12;
            }
            return new ByteString(bArr);
        }

        public Companion() {
        }
    }

    public ByteString(byte[] data) {
        p.i(data, "data");
        this.data = data;
    }

    public static /* synthetic */ int C(ByteString byteString, ByteString byteString2, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i11 & 2) != 0) {
            i10 = byteString.K();
        }
        return byteString.z(byteString2, i10);
    }

    public static /* synthetic */ ByteString O(ByteString byteString, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = byteString.K();
        }
        return byteString.N(i10, i11);
    }

    public static /* synthetic */ String c(ByteString byteString, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: base64");
        }
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return byteString.b(z10);
    }

    public static final ByteString j(String str) {
        return INSTANCE.d(str);
    }

    private final void readObject(ObjectInputStream in) throws IllegalAccessException, NoSuchFieldException, IOException, SecurityException, IllegalArgumentException {
        ByteString byteStringH = INSTANCE.h(in, in.readInt());
        Field declaredField = ByteString.class.getDeclaredField(Const.INTENT_KEY_APIKEY);
        declaredField.setAccessible(true);
        declaredField.set(this, byteStringH.data);
    }

    public static /* synthetic */ int w(ByteString byteString, ByteString byteString2, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return byteString.u(byteString2, i10);
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    public int A(byte[] other, int fromIndex) {
        p.i(other, "other");
        for (int iMin = Math.min(fromIndex, getData().length - other.length); -1 < iMin; iMin--) {
            if (C0963a.a(getData(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean D(int offset, ByteString other, int otherOffset, int byteCount) {
        p.i(other, "other");
        return other.E(otherOffset, getData(), offset, byteCount);
    }

    public boolean E(int offset, byte[] other, int otherOffset, int byteCount) {
        p.i(other, "other");
        return offset >= 0 && offset <= getData().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && C0963a.a(getData(), offset, other, otherOffset, byteCount);
    }

    public final void F(int i10) {
        this.hashCode = i10;
    }

    public final void G(String str) {
        this.utf8 = str;
    }

    public final ByteString H() {
        return i("SHA-1");
    }

    public final ByteString J() {
        return i("SHA-256");
    }

    public final int K() {
        return q();
    }

    public final boolean L(ByteString prefix) {
        p.i(prefix, "prefix");
        return D(0, prefix, 0, prefix.K());
    }

    public String M(Charset charset) {
        p.i(charset, "charset");
        return new String(this.data, charset);
    }

    public ByteString N(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (endIndex <= getData().length) {
            if (endIndex - beginIndex >= 0) {
                return (beginIndex == 0 && endIndex == getData().length) ? this : new ByteString(C1168p.o(getData(), beginIndex, endIndex));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
    }

    public ByteString P() {
        for (int i10 = 0; i10 < getData().length; i10++) {
            byte b10 = getData()[i10];
            if (b10 >= 65 && b10 <= 90) {
                byte[] data = getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                p.h(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i10] = (byte) (b10 + 32);
                for (int i11 = i10 + 1; i11 < bArrCopyOf.length; i11++) {
                    byte b11 = bArrCopyOf[i11];
                    if (b11 >= 65 && b11 <= 90) {
                        bArrCopyOf[i11] = (byte) (b11 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    public String Q() {
        String utf8 = getUtf8();
        if (utf8 != null) {
            return utf8;
        }
        String strC = M.c(x());
        G(strC);
        return strC;
    }

    public void R(C0966d buffer, int offset, int byteCount) {
        p.i(buffer, "buffer");
        b.c(this, buffer, offset, byteCount);
    }

    public final String a() {
        return c(this, false, 1, null);
    }

    public String b(boolean includePadding) {
        return a.c(getData(), includePadding, null, 2, null);
    }

    @Override // java.lang.Comparable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(ByteString other) {
        p.i(other, "other");
        int iK = K();
        int iK2 = other.K();
        int iMin = Math.min(iK, iK2);
        for (int i10 = 0; i10 < iMin; i10++) {
            int iL = l(i10) & 255;
            int iL2 = other.l(i10) & 255;
            if (iL != iL2) {
                return iL < iL2 ? -1 : 1;
            }
        }
        if (iK == iK2) {
            return 0;
        }
        return iK < iK2 ? -1 : 1;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.K() == getData().length && byteString.E(0, getData(), 0, getData().length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int iHashCode = Arrays.hashCode(getData());
        F(iHashCode);
        return iHashCode;
    }

    public ByteString i(String algorithm) throws NoSuchAlgorithmException {
        p.i(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.data, 0, K());
        byte[] bArrDigest = messageDigest.digest();
        p.f(bArrDigest);
        return new ByteString(bArrDigest);
    }

    public final boolean k(ByteString suffix) {
        p.i(suffix, "suffix");
        return D(K() - suffix.K(), suffix, 0, suffix.K());
    }

    public final byte l(int index) {
        return y(index);
    }

    /* renamed from: m, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: n, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    public int q() {
        return getData().length;
    }

    /* renamed from: s, reason: from getter */
    public final String getUtf8() {
        return this.utf8;
    }

    public String t() {
        char[] cArr = new char[getData().length * 2];
        int i10 = 0;
        for (byte b10 : getData()) {
            int i11 = i10 + 1;
            cArr[i10] = b.d()[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = b.d()[b10 & 15];
        }
        return D.B(cArr);
    }

    public String toString() {
        if (getData().length == 0) {
            return "[size=0]";
        }
        int iB = b.b(getData(), 64);
        if (iB != -1) {
            String strQ = Q();
            String strSubstring = strQ.substring(0, iB);
            p.h(strSubstring, "substring(...)");
            String strT = D.T(D.T(D.T(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (iB >= strQ.length()) {
                return "[text=" + strT + ']';
            }
            return "[size=" + getData().length + " text=" + strT + "…]";
        }
        if (getData().length <= 64) {
            return "[hex=" + t() + ']';
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[size=");
        sb2.append(getData().length);
        sb2.append(" hex=");
        if (64 <= getData().length) {
            sb2.append((64 == getData().length ? this : new ByteString(C1168p.o(getData(), 0, 64))).t());
            sb2.append("…]");
            return sb2.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
    }

    public final int u(ByteString other, int fromIndex) {
        p.i(other, "other");
        return v(other.x(), fromIndex);
    }

    public int v(byte[] other, int fromIndex) {
        p.i(other, "other");
        int length = getData().length - other.length;
        int iMax = Math.max(fromIndex, 0);
        if (iMax > length) {
            return -1;
        }
        while (!C0963a.a(getData(), iMax, other, 0, other.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public byte[] x() {
        return getData();
    }

    public byte y(int pos) {
        return getData()[pos];
    }

    public final int z(ByteString other, int fromIndex) {
        p.i(other, "other");
        return A(other.x(), fromIndex);
    }
}
