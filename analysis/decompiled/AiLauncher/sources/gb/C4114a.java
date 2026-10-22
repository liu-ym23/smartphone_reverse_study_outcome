package gb;

import Y8.k;
import Z8.C1168p;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B%\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010!R\u0011\u0010#\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0011¨\u0006$"}, d2 = {"Lgb/a;", "", "", "data", "", "dummy", "<init>", "([BLjava/lang/Object;)V", "", "startIndex", "endIndex", "([BII)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "index", "", "c", "(I)B", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(II)Lgb/a;", Const.INTENT_KEY_PKGNAME, "(Lgb/a;)I", "", "toString", "()Ljava/lang/String;", "e", "()[B", Const.INTENT_KEY_APIKEY, "[B", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, ContentDisposition.Parameters.Size, "kotlinx-io-bytestring"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: gb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4114a implements Comparable<C4114a> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final C4114a f32868d = new C4114a(new byte[0], null);

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f32869e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final byte[] data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int hashCode;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lgb/a$a;", "", "<init>", "()V", "", "byteArray", "Lgb/a;", Const.INTENT_KEY_PKGNAME, "([B)Lgb/a;", "EMPTY", "Lgb/a;", Const.INTENT_KEY_APIKEY, "()Lgb/a;", "", "HEX_DIGITS", "[C", "kotlinx-io-bytestring"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: gb.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final C4114a a() {
            return C4114a.f32868d;
        }

        public final C4114a b(byte[] byteArray) {
            p.i(byteArray, "byteArray");
            i iVar = null;
            return new C4114a(byteArray, iVar, iVar);
        }

        public Companion() {
        }
    }

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        p.h(charArray, "toCharArray(...)");
        f32869e = charArray;
    }

    public /* synthetic */ C4114a(byte[] bArr, Object obj, i iVar) {
        this(bArr, obj);
    }

    public static /* synthetic */ C4114a k(C4114a c4114a, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = c4114a.i();
        }
        return c4114a.j(i10, i11);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4114a other) {
        p.i(other, "other");
        if (other == this) {
            return 0;
        }
        byte[] bArr = this.data;
        byte[] bArr2 = other.data;
        int iMin = Math.min(i(), other.i());
        for (int i10 = 0; i10 < iMin; i10++) {
            int iK = p.k(k.b(bArr[i10]) & 255, k.b(bArr2[i10]) & 255);
            if (iK != 0) {
                return iK;
            }
        }
        return p.k(i(), other.i());
    }

    public final byte c(int index) {
        if (index >= 0 && index < i()) {
            return this.data[index];
        }
        throw new IndexOutOfBoundsException("index (" + index + ") is out of byte string bounds: [0.." + i() + ')');
    }

    /* renamed from: e, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    public boolean equals(Object other) {
        int i10;
        if (this == other) {
            return true;
        }
        if (other == null || C4114a.class != other.getClass()) {
            return false;
        }
        C4114a c4114a = (C4114a) other;
        byte[] bArr = c4114a.data;
        int length = bArr.length;
        byte[] bArr2 = this.data;
        if (length != bArr2.length) {
            return false;
        }
        int i11 = c4114a.hashCode;
        if (i11 == 0 || (i10 = this.hashCode) == 0 || i11 == i10) {
            return Arrays.equals(bArr2, bArr);
        }
        return false;
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int iHashCode = Arrays.hashCode(this.data);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public final int i() {
        return this.data.length;
    }

    public final C4114a j(int startIndex, int endIndex) {
        return startIndex == endIndex ? f32868d : new C4114a(this.data, startIndex, endIndex);
    }

    public String toString() {
        if (c.c(this)) {
            return "ByteString(size=0)";
        }
        String strValueOf = String.valueOf(i());
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 22 + (i() * 2));
        sb2.append("ByteString(size=");
        sb2.append(strValueOf);
        sb2.append(" hex=");
        byte[] bArr = this.data;
        int i10 = i();
        for (int i11 = 0; i11 < i10; i11++) {
            byte b10 = bArr[i11];
            char[] cArr = f32869e;
            sb2.append(cArr[(b10 >>> 4) & 15]);
            sb2.append(cArr[b10 & 15]);
        }
        sb2.append(')');
        String string = sb2.toString();
        p.h(string, "toString(...)");
        return string;
    }

    public C4114a(byte[] bArr, Object obj) {
        this.data = bArr;
    }

    public /* synthetic */ C4114a(byte[] bArr, int i10, int i11, int i12, i iVar) {
        this(bArr, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? bArr.length : i11);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C4114a(byte[] data, int i10, int i11) {
        this(C1168p.o(data, i10, i11), null);
        p.i(data, "data");
    }
}
