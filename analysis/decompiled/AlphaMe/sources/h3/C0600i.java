package h3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: h3.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0600i {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f12920n = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f12921a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12922b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12923c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12924d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f12925e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f12926f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f12927g;

    /* renamed from: h, reason: collision with root package name */
    public final int f12928h;

    /* renamed from: i, reason: collision with root package name */
    public final int f12929i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f12930j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f12931k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f12932l;

    /* renamed from: m, reason: collision with root package name */
    public String f12933m;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        timeUnit.toSeconds(Integer.MAX_VALUE);
    }

    public C0600i(boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, int i6, int i7, boolean z9, boolean z10, boolean z11, String str) {
        this.f12921a = z4;
        this.f12922b = z5;
        this.f12923c = i4;
        this.f12924d = i5;
        this.f12925e = z6;
        this.f12926f = z7;
        this.f12927g = z8;
        this.f12928h = i6;
        this.f12929i = i7;
        this.f12930j = z9;
        this.f12931k = z10;
        this.f12932l = z11;
        this.f12933m = str;
    }

    public final String toString() {
        String str = this.f12933m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f12921a) {
            sb.append("no-cache, ");
        }
        if (this.f12922b) {
            sb.append("no-store, ");
        }
        int i4 = this.f12923c;
        if (i4 != -1) {
            sb.append("max-age=");
            sb.append(i4);
            sb.append(", ");
        }
        int i5 = this.f12924d;
        if (i5 != -1) {
            sb.append("s-maxage=");
            sb.append(i5);
            sb.append(", ");
        }
        if (this.f12925e) {
            sb.append("private, ");
        }
        if (this.f12926f) {
            sb.append("public, ");
        }
        if (this.f12927g) {
            sb.append("must-revalidate, ");
        }
        int i6 = this.f12928h;
        if (i6 != -1) {
            sb.append("max-stale=");
            sb.append(i6);
            sb.append(", ");
        }
        int i7 = this.f12929i;
        if (i7 != -1) {
            sb.append("min-fresh=");
            sb.append(i7);
            sb.append(", ");
        }
        if (this.f12930j) {
            sb.append("only-if-cached, ");
        }
        if (this.f12931k) {
            sb.append("no-transform, ");
        }
        if (this.f12932l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        this.f12933m = string;
        return string;
    }
}
