package ad;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: n, reason: collision with root package name */
    public static final c f439n = new c(true, false, -1, -1, false, false, false, -1, -1, false, false, false, null);

    /* renamed from: o, reason: collision with root package name */
    public static final c f440o;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f441a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f442b;

    /* renamed from: c, reason: collision with root package name */
    public final int f443c;

    /* renamed from: d, reason: collision with root package name */
    public final int f444d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f445e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f446f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f447g;

    /* renamed from: h, reason: collision with root package name */
    public final int f448h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f449j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f450k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f451l;

    /* renamed from: m, reason: collision with root package name */
    public String f452m;

    static {
        TimeUnit.SECONDS.getClass();
        int i = Reader.READ_DONE;
        long j10 = Reader.READ_DONE;
        if (j10 <= 2147483647L) {
            i = (int) j10;
        }
        f440o = new c(false, false, -1, -1, false, false, false, i, -1, true, false, false, null);
    }

    public c(boolean z10, boolean z11, int i, int i3, boolean z12, boolean z13, boolean z14, int i10, int i11, boolean z15, boolean z16, boolean z17, String str) {
        this.f441a = z10;
        this.f442b = z11;
        this.f443c = i;
        this.f444d = i3;
        this.f445e = z12;
        this.f446f = z13;
        this.f447g = z14;
        this.f448h = i10;
        this.i = i11;
        this.f449j = z15;
        this.f450k = z16;
        this.f451l = z17;
        this.f452m = str;
    }

    public final String toString() {
        String str = this.f452m;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f441a) {
            sb2.append("no-cache, ");
        }
        if (this.f442b) {
            sb2.append("no-store, ");
        }
        int i = this.f443c;
        if (i != -1) {
            sb2.append("max-age=");
            sb2.append(i);
            sb2.append(", ");
        }
        int i3 = this.f444d;
        if (i3 != -1) {
            sb2.append("s-maxage=");
            sb2.append(i3);
            sb2.append(", ");
        }
        if (this.f445e) {
            sb2.append("private, ");
        }
        if (this.f446f) {
            sb2.append("public, ");
        }
        if (this.f447g) {
            sb2.append("must-revalidate, ");
        }
        int i10 = this.f448h;
        if (i10 != -1) {
            sb2.append("max-stale=");
            sb2.append(i10);
            sb2.append(", ");
        }
        int i11 = this.i;
        if (i11 != -1) {
            sb2.append("min-fresh=");
            sb2.append(i11);
            sb2.append(", ");
        }
        if (this.f449j) {
            sb2.append("only-if-cached, ");
        }
        if (this.f450k) {
            sb2.append("no-transform, ");
        }
        if (this.f451l) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        String string = sb2.toString();
        this.f452m = string;
        return string;
    }
}
