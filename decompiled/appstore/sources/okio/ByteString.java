package okio;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import fg.b;
import fg.c;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0016\u0018\u0000 r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001sB\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u0019J\u0017\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0016¢\u0006\u0004\b$\u0010#J\u0017\u0010%\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0016¢\u0006\u0004\b%\u0010#J\u001f\u0010(\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0000H\u0010¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020\u0010H\u0016¢\u0006\u0004\b)\u0010\u0012J\u000f\u0010*\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010\u0012J\u000f\u0010+\u001a\u00020\u0000H\u0016¢\u0006\u0004\b+\u0010\u0019J\u000f\u0010,\u001a\u00020\u0000H\u0016¢\u0006\u0004\b,\u0010\u0019J#\u00100\u001a\u00020\u00002\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u00020-H\u0017¢\u0006\u0004\b0\u00101J\u0017\u00106\u001a\u0002032\u0006\u00102\u001a\u00020-H\u0010¢\u0006\u0004\b4\u00105J\u0018\u00109\u001a\u0002032\u0006\u00107\u001a\u00020-H\u0087\u0002¢\u0006\u0004\b8\u00105J\u000f\u0010<\u001a\u00020-H\u0010¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u00020\u0003H\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020\u0003H\u0010¢\u0006\u0004\b?\u0010>J\u000f\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020\t2\u0006\u0010\r\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010E\u001a\u00020\t2\u0006\u0010H\u001a\u00020GH\u0010¢\u0006\u0004\bI\u0010JJ/\u0010P\u001a\u00020O2\u0006\u0010K\u001a\u00020-2\u0006\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020-H\u0016¢\u0006\u0004\bP\u0010QJ/\u0010P\u001a\u00020O2\u0006\u0010K\u001a\u00020-2\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020-H\u0016¢\u0006\u0004\bP\u0010RJ\u0015\u0010T\u001a\u00020O2\u0006\u0010S\u001a\u00020\u0000¢\u0006\u0004\bT\u0010UJ\u0015\u0010T\u001a\u00020O2\u0006\u0010S\u001a\u00020\u0003¢\u0006\u0004\bT\u0010VJ\u0015\u0010X\u001a\u00020O2\u0006\u0010W\u001a\u00020\u0000¢\u0006\u0004\bX\u0010UJ\u0015\u0010X\u001a\u00020O2\u0006\u0010W\u001a\u00020\u0003¢\u0006\u0004\bX\u0010VJ!\u0010Z\u001a\u00020-2\u0006\u0010L\u001a\u00020\u00002\b\b\u0002\u0010Y\u001a\u00020-H\u0007¢\u0006\u0004\bZ\u0010[J!\u0010Z\u001a\u00020-2\u0006\u0010L\u001a\u00020\u00032\b\b\u0002\u0010Y\u001a\u00020-H\u0017¢\u0006\u0004\bZ\u0010\\J!\u0010]\u001a\u00020-2\u0006\u0010L\u001a\u00020\u00002\b\b\u0002\u0010Y\u001a\u00020-H\u0007¢\u0006\u0004\b]\u0010[J!\u0010]\u001a\u00020-2\u0006\u0010L\u001a\u00020\u00032\b\b\u0002\u0010Y\u001a\u00020-H\u0017¢\u0006\u0004\b]\u0010\\J\u001a\u0010_\u001a\u00020O2\b\u0010L\u001a\u0004\u0018\u00010^H\u0096\u0002¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020-H\u0016¢\u0006\u0004\ba\u0010;J\u0018\u0010b\u001a\u00020-2\u0006\u0010L\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\u0010H\u0016¢\u0006\u0004\bd\u0010\u0012J\u0017\u00108\u001a\u0002032\u0006\u00107\u001a\u00020-H\u0007¢\u0006\u0004\be\u00105J\u000f\u0010g\u001a\u00020-H\u0007¢\u0006\u0004\bf\u0010;R\"\u0010a\u001a\u00020-8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\ba\u0010h\u001a\u0004\bi\u0010;\"\u0004\bj\u0010kR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010l\u001a\u0004\bm\u0010\u0012\"\u0004\bn\u0010oR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010p\u001a\u0004\bq\u0010>R\u0011\u0010g\u001a\u00020-8G¢\u0006\u0006\u001a\u0004\bg\u0010;¨\u0006t"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "", "data", "<init>", "([B)V", "Ljava/io/ObjectInputStream;", "in", "", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "", "utf8", "()Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "string", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", ServerElements.MD5, "()Lokio/ByteString;", "sha1", "sha256", "sha512", "algorithm", "digest$jvm", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "key", "hmacSha1", "(Lokio/ByteString;)Lokio/ByteString;", "hmacSha256", "hmacSha512", "hmac$jvm", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "hex", "toAsciiLowercase", "toAsciiUppercase", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", "", "internalGet$jvm", "(I)B", "internalGet", SlideCard.KEY_INDEX, "getByte", "get", "getSize$jvm", "()I", "getSize", "toByteArray", "()[B", "internalArray$jvm", "internalArray", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "write", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "write$jvm", "(Lokio/Buffer;)V", "offset", AppInfo.SEARCH_SOURCE_EXTENAL, "otherOffset", "byteCount", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "prefix", "startsWith", "(Lokio/ByteString;)Z", "([B)Z", "suffix", "endsWith", "fromIndex", "indexOf", "(Lokio/ByteString;I)I", "([BI)I", "lastIndexOf", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "compareTo", "(Lokio/ByteString;)I", "toString", "-deprecated_getByte", "-deprecated_size", "size", "I", "getHashCode$jvm", "setHashCode$jvm", "(I)V", "Ljava/lang/String;", "getUtf8$jvm", "setUtf8$jvm", "(Ljava/lang/String;)V", "[B", "getData$jvm", "Companion", "a", "jvm"}, k = 1, mv = {1, 4, 0})
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final a Companion = null;

    @JvmField
    @NotNull
    public static final ByteString EMPTY = null;
    private static final long serialVersionUID = 1;

    @NotNull
    private final byte[] data;
    private transient int hashCode;

    @Nullable
    private transient String utf8;

    public static final class a {
        public a() {
        }

        public final ByteString a(String r10) {
            q.h(r10, "$receiver");
            return gg.a.e(r10);
        }

        public final ByteString b(String r10) {
            q.h(r10, "$receiver");
            return gg.a.f(r10);
        }

        public final ByteString c(String r10, Charset r11) {
            q.h(r10, "$receiver");
            q.h(r11, "charset");
            byte[] r12 = r10.getBytes(r11);
            q.c(r12, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(r12);
        }

        public final ByteString d(String r10) {
            q.h(r10, "$receiver");
            return gg.a.g(r10);
        }

        public final ByteString e(ByteBuffer r10) {
            q.h(r10, "$receiver");
            byte[] r11 = new byte[r10.remaining()];
            r10.get(r11);
            return new ByteString(r11);
        }

        public final ByteString f(byte... r10) {
            q.h(r10, "data");
            return gg.a.r(r10);
        }

        public final ByteString g(byte[] r10, int r11, int r12) {
            q.h(r10, "$receiver");
            c.b(r10.length, r11, r12);
            byte[] r13 = new byte[r12];
            b.a(r10, r11, r13, 0, r12);
            return new ByteString(r13);
        }

        public final ByteString h(InputStream r10, int r11) {
            q.h(r10, "$receiver");
            if (r11 < 0) goto L14;
            byte[] r12 = new byte[r11];
            int r13 = 0;
        L5:
            if (r13 >= r11) goto L12;
            int r14 = r10.read(r12, r13, r11 - r13);
            if (r14 == (-1)) goto L10;
            r13 = r13 + r14;
            goto L5
        L10:
            throw new EOFException();
        L12:
            return new ByteString(r12);
        L14:
            throw new IllegalArgumentException(("byteCount < 0: " + r11).toString());
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new a(null);
        EMPTY = gg.a.D();
    }

    public ByteString(@NotNull byte[] r10) {
        q.h(r10, "data");
        this.data = r10;
    }

    @JvmStatic
    @Nullable
    public static final ByteString decodeBase64(@NotNull String r10) {
        return Companion.a(r10);
    }

    @JvmStatic
    @NotNull
    public static final ByteString decodeHex(@NotNull String r10) {
        return Companion.b(r10);
    }

    @JvmStatic
    @JvmName(name = "encodeString")
    @NotNull
    public static final ByteString encodeString(@NotNull String r10, @NotNull Charset r11) {
        return Companion.c(r10, r11);
    }

    @JvmStatic
    @NotNull
    public static final ByteString encodeUtf8(@NotNull String r10) {
        return Companion.d(r10);
    }

    @JvmOverloads
    public static /* bridge */ /* synthetic */ int indexOf$default(ByteString r10, ByteString r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        return r10.indexOf(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    @JvmOverloads
    public static /* bridge */ /* synthetic */ int lastIndexOf$default(ByteString r10, ByteString r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = r10.size();
    L7:
        return r10.lastIndexOf(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull ByteBuffer r10) {
        return Companion.e(r10);
    }

    @JvmStatic
    @JvmName(name = "read")
    @NotNull
    public static final ByteString read(@NotNull InputStream r10, int r11) throws IOException {
        return Companion.h(r10, r11);
    }

    private final void readObject(ObjectInputStream r10) throws IOException {
        int r11 = r10.readInt();
        ByteString r12 = Companion.h(r10, r11);
        Field r13 = ByteString.class.getDeclaredField("data");
        q.c(r13, "field");
        r13.setAccessible(true);
        r13.set(this, r12.data);
    }

    @JvmOverloads
    @NotNull
    public static /* bridge */ /* synthetic */ ByteString substring$default(ByteString r10, int r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L12;
        if ((r13 & 1) == 0) goto L7;
        r11 = 0;
    L7:
        if ((r13 & 2) == 0) goto L10;
        r12 = r10.size();
    L10:
        return r10.substring(r11, r12);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream r10) throws IOException {
        r10.writeInt(this.data.length);
        r10.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m58deprecated_getByte(int r10) {
        return getByte(r10);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m59deprecated_size() {
        return size();
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer r10 = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        q.c(r10, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return r10;
    }

    @NotNull
    public String base64() {
        return gg.a.b(this);
    }

    @NotNull
    public String base64Url() {
        return gg.a.c(this);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ByteString r10) {
        return compareTo2(r10);
    }

    @NotNull
    public ByteString digest$jvm(@NotNull String r10) {
        q.h(r10, "algorithm");
        byte[] r11 = MessageDigest.getInstance(r10).digest(this.data);
        q.c(r11, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(r11);
    }

    public final boolean endsWith(@NotNull ByteString r10) {
        q.h(r10, "suffix");
        return gg.a.h(this, r10);
    }

    public boolean equals(@Nullable Object r10) {
        return gg.a.j(this, r10);
    }

    @JvmName(name = "getByte")
    public final byte getByte(int r10) {
        return internalGet$jvm(r10);
    }

    @NotNull
    public final byte[] getData$jvm() {
        return this.data;
    }

    public final int getHashCode$jvm() {
        return this.hashCode;
    }

    public int getSize$jvm() {
        return gg.a.l(this);
    }

    @Nullable
    public final String getUtf8$jvm() {
        return this.utf8;
    }

    public int hashCode() {
        return gg.a.m(this);
    }

    @NotNull
    public String hex() {
        return gg.a.n(this);
    }

    @NotNull
    public ByteString hmac$jvm(@NotNull String r10, @NotNull ByteString r11) {
        q.h(r10, "algorithm");
        q.h(r11, "key");
        Mac r12 = Mac.getInstance(r10);     // Catch: InvalidKeyException -> L5
        r12.init(new SecretKeySpec(r11.toByteArray(), r10));     // Catch: InvalidKeyException -> L5
        byte[] r13 = r12.doFinal(this.data);     // Catch: InvalidKeyException -> L5
        q.c(r13, "mac.doFinal(data)");     // Catch: InvalidKeyException -> L5
        return new ByteString(r13);
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @NotNull
    public ByteString hmacSha1(@NotNull ByteString r10) {
        q.h(r10, "key");
        return hmac$jvm("HmacSHA1", r10);
    }

    @NotNull
    public ByteString hmacSha256(@NotNull ByteString r10) {
        q.h(r10, "key");
        return hmac$jvm("HmacSHA256", r10);
    }

    @NotNull
    public ByteString hmacSha512(@NotNull ByteString r10) {
        q.h(r10, "key");
        return hmac$jvm("HmacSHA512", r10);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString r10) {
        return indexOf$default(this, r10, 0, 2, null);
    }

    @NotNull
    public byte[] internalArray$jvm() {
        return gg.a.p(this);
    }

    public byte internalGet$jvm(int r10) {
        return gg.a.k(this, r10);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString r10) {
        return lastIndexOf$default(this, r10, 0, 2, null);
    }

    @NotNull
    public ByteString md5() {
        return digest$jvm("MD5");
    }

    public boolean rangeEquals(int r10, @NotNull ByteString r11, int r12, int r13) {
        q.h(r11, AppInfo.SEARCH_SOURCE_EXTENAL);
        return gg.a.s(this, r10, r11, r12, r13);
    }

    public final void setHashCode$jvm(int r10) {
        this.hashCode = r10;
    }

    public final void setUtf8$jvm(@Nullable String r10) {
        this.utf8 = r10;
    }

    @NotNull
    public ByteString sha1() {
        return digest$jvm("SHA-1");
    }

    @NotNull
    public ByteString sha256() {
        return digest$jvm("SHA-256");
    }

    @NotNull
    public ByteString sha512() {
        return digest$jvm("SHA-512");
    }

    @JvmName(name = "size")
    public final int size() {
        return getSize$jvm();
    }

    public final boolean startsWith(@NotNull ByteString r10) {
        q.h(r10, "prefix");
        return gg.a.u(this, r10);
    }

    @NotNull
    public String string(@NotNull Charset r10) {
        q.h(r10, "charset");
        return new String(this.data, r10);
    }

    @JvmOverloads
    @NotNull
    public ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        return gg.a.x(this);
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        return gg.a.y(this);
    }

    @NotNull
    public byte[] toByteArray() {
        return gg.a.z(this);
    }

    @NotNull
    public String toString() {
        return gg.a.A(this);
    }

    @NotNull
    public String utf8() {
        return gg.a.B(this);
    }

    public void write(@NotNull OutputStream r10) throws IOException {
        q.h(r10, "out");
        r10.write(this.data);
    }

    public void write$jvm(@NotNull Buffer r10) {
        q.h(r10, "buffer");
        byte[] r11 = this.data;
        r10.s(r11, 0, r11.length);
    }

    @JvmStatic
    @NotNull
    public static final ByteString of(@NotNull byte... r10) {
        return Companion.f(r10);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NotNull ByteString r10) {
        q.h(r10, AppInfo.SEARCH_SOURCE_EXTENAL);
        return gg.a.d(this, r10);
    }

    public final boolean endsWith(@NotNull byte[] r10) {
        q.h(r10, "suffix");
        return gg.a.i(this, r10);
    }

    @JvmOverloads
    public int indexOf(@NotNull byte[] r10) {
        return indexOf$default(this, r10, 0, 2, null);
    }

    @JvmOverloads
    public int lastIndexOf(@NotNull byte[] r10) {
        return lastIndexOf$default(this, r10, 0, 2, null);
    }

    public boolean rangeEquals(int r10, @NotNull byte[] r11, int r12, int r13) {
        q.h(r11, AppInfo.SEARCH_SOURCE_EXTENAL);
        return gg.a.t(this, r10, r11, r12, r13);
    }

    public final boolean startsWith(@NotNull byte[] r10) {
        q.h(r10, "prefix");
        return gg.a.v(this, r10);
    }

    @JvmOverloads
    @NotNull
    public ByteString substring(int r10) {
        return substring$default(this, r10, 0, 2, null);
    }

    @JvmOverloads
    public static /* bridge */ /* synthetic */ int indexOf$default(ByteString r10, byte[] r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        return r10.indexOf(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    @JvmOverloads
    public static /* bridge */ /* synthetic */ int lastIndexOf$default(ByteString r10, byte[] r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = r10.size();
    L7:
        return r10.lastIndexOf(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull byte[] r10, int r11, int r12) {
        return Companion.g(r10, r11, r12);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString r10, int r11) {
        q.h(r10, AppInfo.SEARCH_SOURCE_EXTENAL);
        return indexOf(r10.internalArray$jvm(), r11);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString r10, int r11) {
        q.h(r10, AppInfo.SEARCH_SOURCE_EXTENAL);
        return lastIndexOf(r10.internalArray$jvm(), r11);
    }

    @JvmOverloads
    @NotNull
    public ByteString substring(int r10, int r11) {
        return gg.a.w(this, r10, r11);
    }

    @JvmOverloads
    public int indexOf(@NotNull byte[] r10, int r11) {
        q.h(r10, AppInfo.SEARCH_SOURCE_EXTENAL);
        return gg.a.o(this, r10, r11);
    }

    @JvmOverloads
    public int lastIndexOf(@NotNull byte[] r10, int r11) {
        q.h(r10, AppInfo.SEARCH_SOURCE_EXTENAL);
        return gg.a.q(this, r10, r11);
    }
}
