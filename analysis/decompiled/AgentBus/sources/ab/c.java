package ab;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f501n = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f502a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f503b;

    /* renamed from: c, reason: collision with root package name */
    public final int f504c;

    /* renamed from: d, reason: collision with root package name */
    public final int f505d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f506e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f507f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f508g;

    /* renamed from: h, reason: collision with root package name */
    public final int f509h;

    /* renamed from: i, reason: collision with root package name */
    public final int f510i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f511j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f512k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f513l;

    /* renamed from: m, reason: collision with root package name */
    public String f514m;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        q7.k.e(timeUnit, "timeUnit");
        timeUnit.toSeconds(Integer.MAX_VALUE);
    }

    public c(boolean z4, boolean z10, int i2, int i10, boolean z11, boolean z12, boolean z13, int i11, int i12, boolean z14, boolean z15, boolean z16, String str) {
        this.f502a = z4;
        this.f503b = z10;
        this.f504c = i2;
        this.f505d = i10;
        this.f506e = z11;
        this.f507f = z12;
        this.f508g = z13;
        this.f509h = i11;
        this.f510i = i12;
        this.f511j = z14;
        this.f512k = z15;
        this.f513l = z16;
        this.f514m = str;
    }

    public final String toString() {
        String str = this.f514m;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f502a) {
            sb2.append("no-cache, ");
        }
        if (this.f503b) {
            sb2.append("no-store, ");
        }
        int i2 = this.f504c;
        if (i2 != -1) {
            sb2.append("max-age=");
            sb2.append(i2);
            sb2.append(", ");
        }
        int i10 = this.f505d;
        if (i10 != -1) {
            sb2.append("s-maxage=");
            sb2.append(i10);
            sb2.append(", ");
        }
        if (this.f506e) {
            sb2.append("private, ");
        }
        if (this.f507f) {
            sb2.append("public, ");
        }
        if (this.f508g) {
            sb2.append("must-revalidate, ");
        }
        int i11 = this.f509h;
        if (i11 != -1) {
            sb2.append("max-stale=");
            sb2.append(i11);
            sb2.append(", ");
        }
        int i12 = this.f510i;
        if (i12 != -1) {
            sb2.append("min-fresh=");
            sb2.append(i12);
            sb2.append(", ");
        }
        if (this.f511j) {
            sb2.append("only-if-cached, ");
        }
        if (this.f512k) {
            sb2.append("no-transform, ");
        }
        if (this.f513l) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        this.f514m = string;
        return string;
    }
}
