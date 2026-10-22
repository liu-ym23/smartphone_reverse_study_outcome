package F9;

import java.util.concurrent.TimeUnit;

/* renamed from: F9.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0227e {
    public static final /* synthetic */ int n = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f639a;
    public final boolean b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final int h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f640j;
    public final boolean k;
    public final boolean l;
    public String m;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        kotlin.jvm.internal.k.f(timeUnit, "timeUnit");
        timeUnit.toSeconds(Integer.MAX_VALUE);
    }

    public C0227e(boolean z10, boolean z11, int i, int i6, boolean z12, boolean z13, boolean z14, int i10, int i11, boolean z15, boolean z16, boolean z17, String str) {
        this.f639a = z10;
        this.b = z11;
        this.c = i;
        this.d = i6;
        this.e = z12;
        this.f = z13;
        this.g = z14;
        this.h = i10;
        this.i = i11;
        this.f640j = z15;
        this.k = z16;
        this.l = z17;
        this.m = str;
    }

    public final String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f639a) {
            sb.append("no-cache, ");
        }
        if (this.b) {
            sb.append("no-store, ");
        }
        int i = this.c;
        if (i != -1) {
            sb.append("max-age=");
            sb.append(i);
            sb.append(", ");
        }
        int i6 = this.d;
        if (i6 != -1) {
            sb.append("s-maxage=");
            sb.append(i6);
            sb.append(", ");
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        int i10 = this.h;
        if (i10 != -1) {
            sb.append("max-stale=");
            sb.append(i10);
            sb.append(", ");
        }
        int i11 = this.i;
        if (i11 != -1) {
            sb.append("min-fresh=");
            sb.append(i11);
            sb.append(", ");
        }
        if (this.f640j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "StringBuilder().apply(builderAction).toString()");
        this.m = string;
        return string;
    }
}
