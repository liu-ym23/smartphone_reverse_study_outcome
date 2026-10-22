package okio;

import com.bytedanceos.common.model.AppInfo;
import fg.b;
import fg.c;
import fg.p;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\r\b\u0000\u0018\u0000 `2\u00020\u0001:\u0001aB\u001f\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000eJ]\u0010\u0017\u001a\u00020\u00152K\u0010\u0016\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u000fH\u0082\b¢\u0006\u0004\b\u0017\u0010\u0018Jm\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2K\u0010\u0016\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u000fH\u0082\b¢\u0006\u0004\b\u0017\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020!H\u0016¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u00020\u0001H\u0016¢\u0006\u0004\b'\u0010\u000eJ\u000f\u0010(\u001a\u00020\u0001H\u0016¢\u0006\u0004\b(\u0010\u000eJ\u0017\u0010,\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0010¢\u0006\u0004\b*\u0010+J\u001f\u00100\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!2\u0006\u0010-\u001a\u00020\u0001H\u0010¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u00020!H\u0016¢\u0006\u0004\b1\u0010%J\u001f\u00102\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b2\u00103J\u0017\u00107\u001a\u0002042\u0006\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b5\u00106J\u000f\u0010:\u001a\u00020\tH\u0010¢\u0006\u0004\b8\u00109J\u000f\u0010;\u001a\u00020\u0003H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\n >*\u0004\u0018\u00010=0=H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\u00152\u0006\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bC\u0010DJ\u0017\u0010C\u001a\u00020\u00152\u0006\u0010F\u001a\u00020EH\u0010¢\u0006\u0004\bG\u0010HJ/\u0010L\u001a\u00020K2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u00012\u0006\u0010J\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\bL\u0010MJ/\u0010L\u001a\u00020K2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\bL\u0010NJ\u001f\u0010P\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\tH\u0016¢\u0006\u0004\bP\u0010QJ\u001f\u0010R\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\tH\u0016¢\u0006\u0004\bR\u0010QJ\u000f\u0010T\u001a\u00020\u0003H\u0010¢\u0006\u0004\bS\u0010<J\u001a\u0010V\u001a\u00020K2\b\u0010I\u001a\u0004\u0018\u00010UH\u0096\u0002¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\tH\u0016¢\u0006\u0004\bX\u00109J\u000f\u0010Y\u001a\u00020!H\u0016¢\u0006\u0004\bY\u0010%R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010Z\u001a\u0004\b[\u0010\\R\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010]\u001a\u0004\b^\u0010_¨\u0006b"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "", "", "segments", "", "directory", "<init>", "([[B[I)V", "", "pos", "segment", "(I)I", "toByteString", "()Lokio/ByteString;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "offset", "byteCount", "", "action", "forEachSegment", "(Lkotlin/jvm/functions/Function3;)V", "beginIndex", "endIndex", "(IILkotlin/jvm/functions/Function3;)V", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "", "string", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", "()Ljava/lang/String;", "hex", "toAsciiLowercase", "toAsciiUppercase", "algorithm", "digest$jvm", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "key", "hmac$jvm", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "substring", "(II)Lokio/ByteString;", "", "internalGet$jvm", "(I)B", "internalGet", "getSize$jvm", "()I", "getSize", "toByteArray", "()[B", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "out", "write", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "write$jvm", "(Lokio/Buffer;)V", AppInfo.SEARCH_SOURCE_EXTENAL, "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "fromIndex", "indexOf", "([BI)I", "lastIndexOf", "internalArray$jvm", "internalArray", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "[[B", "getSegments", "()[[B", "[I", "getDirectory", "()[I", "Companion", "a", "jvm"}, k = 1, mv = {1, 4, 0})
public final class SegmentedByteString extends ByteString {
    public static final a Companion = null;

    @NotNull
    private final transient int[] directory;

    @NotNull
    private final transient byte[][] segments;

    public static final class a {
        public a() {
        }

        public final ByteString a(Buffer r10, int r11) {
            q.h(r10, "buffer");
            c.b(r10.size(), 0, r11);
            p r12 = r10.f23020a;
            int r13 = 0;
            int r14 = 0;
            int r15 = 0;
        L3:
            if (r14 >= r11) goto L11;
            if (r12 != null) goto L6;
            q.s();
        L6:
            int r16 = r12.f19718c;
            int r17 = r12.f19717b;
            if (r16 == r17) goto L10;
            r14 = r14 + (r16 - r17);
            r15 = r15 + 1;
            r12 = r12.f19721f;
            goto L3
        L10:
            throw new AssertionError("s.limit == s.pos");
        L11:
            byte[][] r18 = new byte[r15][];
            int[] r19 = new int[r15 * 2];
            p r20 = r10.f23020a;
            int r21 = 0;
        L12:
            if (r13 >= r11) goto L17;
            if (r20 != null) goto L15;
            q.s();
        L15:
            r18[r21] = r20.f19716a;
            r13 = r13 + (r20.f19718c - r20.f19717b);
            r19[r21] = Math.min(r13, r11);
            r19[r21 + r15] = r20.f19717b;
            r20.f19719d = true;
            r21 = r21 + 1;
            r20 = r20.f19721f;
            goto L12
        L17:
            return new SegmentedByteString(r18, r19, null);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public /* synthetic */ SegmentedByteString(@NotNull byte[][] r10, @NotNull int[] r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    public static final /* synthetic */ int access$segment(SegmentedByteString r10, int r11) {
        return r10.segment(r11);
    }

    private final void forEachSegment(Function3<? super byte[], ? super Integer, ? super Integer, Unit> r10) {
        int r11 = getSegments().length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        int r14 = getDirectory()[r11 + r12];
        int r15 = getDirectory()[r12];
        r10.invoke(getSegments()[r12], Integer.valueOf(r14), Integer.valueOf(r15 - r13));
        r12 = r12 + 1;
        r13 = r15;
        goto L3
    }

    private final int segment(int r10) {
        int r11 = Arrays.binarySearch(this.directory, 0, this.segments.length, r10 + 1);
        if (r11 < 0) goto L6;
        return r11;
    L6:
        return ~r11;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString r10 = toByteString();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    @NotNull
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    @NotNull
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString digest$jvm(@NotNull String r10) {
        q.h(r10, "algorithm");
        MessageDigest r11 = MessageDigest.getInstance(r10);
        int r12 = getSegments().length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        int r15 = getDirectory()[r12 + r13];
        int r16 = getDirectory()[r13];
        r11.update(getSegments()[r13], r15, r16 - r14);
        r13 = r13 + 1;
        r14 = r16;
        goto L3
    L5:
        byte[] r17 = r11.digest();
        q.c(r17, "digest.digest()");
        return new ByteString(r17);
    }

    @Override // okio.ByteString
    public boolean equals(@Nullable Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ByteString) == false) goto L13;
        ByteString r11 = (ByteString) r10;
        if (r11.size() != size()) goto L13;
        if (rangeEquals(0, r11, 0, size()) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @NotNull
    public final int[] getDirectory() {
        return this.directory;
    }

    @NotNull
    public final byte[][] getSegments() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$jvm() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int r10 = getHashCode$jvm();
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = getSegments().length;
        int r12 = 0;
        int r13 = 1;
        int r14 = 0;
    L6:
        if (r12 >= r11) goto L11;
        int r15 = getDirectory()[r11 + r12];
        int r16 = getDirectory()[r12];
        byte[] r17 = getSegments()[r12];
        int r18 = (r16 - r14) + r15;
    L8:
        if (r15 >= r18) goto L10;
        r13 = (r13 * 31) + r17[r15];
        r15 = r15 + 1;
        goto L8
    L10:
        r12 = r12 + 1;
        r14 = r16;
        goto L6
    L11:
        setHashCode$jvm(r13);
        return r13;
    }

    @Override // okio.ByteString
    @NotNull
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString hmac$jvm(@NotNull String r10, @NotNull ByteString r11) {
        q.h(r10, "algorithm");
        q.h(r11, "key");
        Mac r12 = Mac.getInstance(r10);     // Catch: InvalidKeyException -> L6
        r12.init(new SecretKeySpec(r11.toByteArray(), r10));     // Catch: InvalidKeyException -> L6
        int r13 = getSegments().length;     // Catch: InvalidKeyException -> L6
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r14 >= r13) goto L8;
        int r16 = getDirectory()[r13 + r14];     // Catch: InvalidKeyException -> L6
        int r17 = getDirectory()[r14];     // Catch: InvalidKeyException -> L6
        r12.update(getSegments()[r14], r16, r17 - r15);     // Catch: InvalidKeyException -> L6
        r14 = r14 + 1;     // Catch: InvalidKeyException -> L6
        r15 = r17;
        goto L4
    L8:
        byte[] r18 = r12.doFinal();     // Catch: InvalidKeyException -> L6
        q.c(r18, "mac.doFinal()");     // Catch: InvalidKeyException -> L6
        return new ByteString(r18);
    L6:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Override // okio.ByteString
    public int indexOf(@NotNull byte[] r10, int r11) {
        q.h(r10, AppInfo.SEARCH_SOURCE_EXTENAL);
        return toByteString().indexOf(r10, r11);
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] internalArray$jvm() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$jvm(int r10) {
        c.b(this.directory[this.segments.length - 1], r10, 1);
        int r11 = segment(r10);
        if (r11 != 0) goto L5;
        int r12 = 0;
    L6:
        int[] r13 = this.directory;
        byte[][] r14 = this.segments;
        return r14[r11][(r10 - r12) + r13[r14.length + r11]];
    L5:
        r12 = this.directory[r11 - 1];
        goto L6
    }

    @Override // okio.ByteString
    public int lastIndexOf(@NotNull byte[] r10, int r11) {
        q.h(r10, AppInfo.SEARCH_SOURCE_EXTENAL);
        return toByteString().lastIndexOf(r10, r11);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r10, @NotNull ByteString r11, int r12, int r13) {
        q.h(r11, AppInfo.SEARCH_SOURCE_EXTENAL);
        if (r10 >= 0) goto L5;
    L18:
        return false;
    L5:
        if (r10 > (size() - r13)) goto L18;
        int r14 = r13 + r10;
        int r15 = access$segment(this, r10);
    L8:
        if (r10 >= r14) goto L16;
        if (r15 != 0) goto L11;
        int r16 = 0;
    L12:
        int r17 = getDirectory()[r15] - r16;
        int r18 = getDirectory()[getSegments().length + r15];
        int r19 = Math.min(r14, r17 + r16) - r10;
        if (r11.rangeEquals(r12, getSegments()[r15], r18 + (r10 - r16), r19) == false) goto L14;
        r12 = r12 + r19;
        r10 = r10 + r19;
        r15 = r15 + 1;
        goto L8
    L14:
        return false;
    L11:
        r16 = getDirectory()[r15 - 1];
        goto L12
    L16:
        return true;
    }

    @Override // okio.ByteString
    @NotNull
    public String string(@NotNull Charset r10) {
        q.h(r10, "charset");
        return toByteString().string(r10);
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString substring(int r11, int r12) {
        if (r11 < 0) goto L30;
        if (r12 > size()) goto L28;
        int r10 = r12 - r11;
        if (r10 < 0) goto L26;
        if (r11 == 0) goto L9;
    L11:
        if (r11 == r12) goto L13;
        int r13 = segment(r11);
        int r14 = segment(r12 - 1);
        Object[] r15 = Arrays.copyOfRange(this.segments, r13, r14 + 1);
        q.c(r15, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        byte[][] r16 = (byte[][]) r15;
        int[] r17 = new int[r16.length * 2];
        int r18 = 0;
        if (r13 > r14) goto L20;
        int r19 = r13;
        int r20 = 0;
    L17:
        r17[r20] = Math.min(this.directory[r19] - r11, r10);
        int r21 = r20 + 1;
        r17[r20 + r16.length] = this.directory[this.segments.length + r19];
        if (r19 == r14) goto L20;
        r19 = r19 + 1;
        r20 = r21;
    L20:
        if (r13 == 0) goto L23;
        r18 = this.directory[r13 - 1];
    L23:
        int r110 = r16.length;
        r17[r110] = r17[r110] + (r11 - r18);
        return new SegmentedByteString(r16, r17);
    L13:
        return ByteString.EMPTY;
    L9:
        if (r12 != size()) goto L11;
        return this;
    L26:
        throw new IllegalArgumentException(("endIndex=" + r12 + " < beginIndex=" + r11).toString());
    L28:
        throw new IllegalArgumentException(("endIndex=" + r12 + " > length(" + size() + ')').toString());
    L30:
        throw new IllegalArgumentException(("beginIndex=" + r11 + " < 0").toString());
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] toByteArray() {
        byte[] r10 = new byte[size()];
        int r11 = getSegments().length;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r12 >= r11) goto L5;
        int r15 = getDirectory()[r11 + r12];
        int r16 = getDirectory()[r12];
        int r17 = r16 - r13;
        b.a(getSegments()[r12], r15, r10, r14, r17);
        r14 = r14 + r17;
        r12 = r12 + 1;
        r13 = r16;
        goto L3
    L5:
        return r10;
    }

    @Override // okio.ByteString
    @NotNull
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(@NotNull OutputStream r10) throws IOException {
        q.h(r10, "out");
        int r11 = getSegments().length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        int r14 = getDirectory()[r11 + r12];
        int r15 = getDirectory()[r12];
        r10.write(getSegments()[r12], r14, r15 - r13);
        r12 = r12 + 1;
        r13 = r15;
        goto L3
    }

    @Override // okio.ByteString
    public void write$jvm(@NotNull Buffer r12) {
        q.h(r12, "buffer");
        int r10 = getSegments().length;
        int r11 = 0;
        int r13 = 0;
    L3:
        if (r11 >= r10) goto L14;
        int r14 = getDirectory()[r10 + r11];
        int r15 = getDirectory()[r11];
        p r16 = new p(getSegments()[r11], r14, r14 + (r15 - r13), true, false);
        p r17 = r12.f23020a;
        if (r17 != null) goto L7;
        r16.f19722g = r16;
        r16.f19721f = r16;
        r12.f23020a = r16;
    L13:
        r11 = r11 + 1;
        r13 = r15;
        goto L3
    L7:
        if (r17 != null) goto L9;
        q.s();
    L9:
        p r18 = r17.f19722g;
        if (r18 != null) goto L12;
        q.s();
    L12:
        r18.c(r16);
        goto L13
    L14:
        r12.m(r12.size() + ((long) size()));
    }

    private SegmentedByteString(byte[][] r10, int[] r11) {
        super(ByteString.EMPTY.getData$jvm());
        this.segments = r10;
        this.directory = r11;
    }

    private final void forEachSegment(int r10, int r11, Function3<? super byte[], ? super Integer, ? super Integer, Unit> r12) {
        int r13 = access$segment(this, r10);
    L3:
        if (r10 >= r11) goto L8;
        if (r13 != 0) goto L6;
        int r14 = 0;
    L7:
        int r15 = getDirectory()[r13] - r14;
        int r16 = getDirectory()[getSegments().length + r13];
        int r17 = Math.min(r11, r15 + r14) - r10;
        r12.invoke(getSegments()[r13], Integer.valueOf(r16 + (r10 - r14)), Integer.valueOf(r17));
        r10 = r10 + r17;
        r13 = r13 + 1;
        goto L3
    L6:
        r14 = getDirectory()[r13 - 1];
        goto L7
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int r10, @NotNull byte[] r11, int r12, int r13) {
        q.h(r11, AppInfo.SEARCH_SOURCE_EXTENAL);
        if (r10 >= 0) goto L5;
    L21:
        return false;
    L5:
        if (r10 > (size() - r13)) goto L21;
        if (r12 < 0) goto L21;
        if (r12 > (r11.length - r13)) goto L21;
        int r14 = r13 + r10;
        int r15 = access$segment(this, r10);
    L11:
        if (r10 >= r14) goto L19;
        if (r15 != 0) goto L14;
        int r16 = 0;
    L15:
        int r17 = getDirectory()[r15] - r16;
        int r18 = getDirectory()[getSegments().length + r15];
        int r19 = Math.min(r14, r17 + r16) - r10;
        if (c.a(getSegments()[r15], r18 + (r10 - r16), r11, r12, r19) == false) goto L17;
        r12 = r12 + r19;
        r10 = r10 + r19;
        r15 = r15 + 1;
        goto L11
    L17:
        return false;
    L14:
        r16 = getDirectory()[r15 - 1];
        goto L15
    L19:
        return true;
    }
}
