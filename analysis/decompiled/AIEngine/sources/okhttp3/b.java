package okhttp3;

import androidx.datastore.preferences.protobuf.b1;
import kotlin.time.DurationUnit;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f10932n = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10933a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10934b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10935c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10936d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f10937e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f10938f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f10939g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final int f10940i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f10941j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f10942k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f10943l;

    /* renamed from: m, reason: collision with root package name */
    public String f10944m;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: okhttp3.b$b, reason: collision with other inner class name */
    public static final class C0120b {
    }

    static {
        new a();
        new a();
        int i10 = hc.a.f9403d;
        DurationUnit unit = DurationUnit.f10101d;
        kotlin.jvm.internal.g.f(unit, "unit");
        long jG = hc.a.g(unit.compareTo(unit) <= 0 ? b1.C(a4.a.j(Integer.MAX_VALUE, unit, DurationUnit.f10099b)) : b1.W(Integer.MAX_VALUE, unit), unit);
        if (jG < 0) {
            throw new IllegalArgumentException(com.stepos.core.ota.d.f(jG, "maxStale < 0: ").toString());
        }
    }

    public b(boolean z, boolean z3, int i10, int i11, boolean z10, boolean z11, boolean z12, int i12, int i13, boolean z13, boolean z14, boolean z15, String str) {
        this.f10933a = z;
        this.f10934b = z3;
        this.f10935c = i10;
        this.f10936d = i11;
        this.f10937e = z10;
        this.f10938f = z11;
        this.f10939g = z12;
        this.h = i12;
        this.f10940i = i13;
        this.f10941j = z13;
        this.f10942k = z14;
        this.f10943l = z15;
        this.f10944m = str;
    }

    public final String toString() {
        String str = this.f10944m;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f10933a) {
            sb2.append("no-cache, ");
        }
        if (this.f10934b) {
            sb2.append("no-store, ");
        }
        int i10 = this.f10935c;
        if (i10 != -1) {
            sb2.append("max-age=");
            sb2.append(i10);
            sb2.append(", ");
        }
        int i11 = this.f10936d;
        if (i11 != -1) {
            sb2.append("s-maxage=");
            sb2.append(i11);
            sb2.append(", ");
        }
        if (this.f10937e) {
            sb2.append("private, ");
        }
        if (this.f10938f) {
            sb2.append("public, ");
        }
        if (this.f10939g) {
            sb2.append("must-revalidate, ");
        }
        int i12 = this.h;
        if (i12 != -1) {
            sb2.append("max-stale=");
            sb2.append(i12);
            sb2.append(", ");
        }
        int i13 = this.f10940i;
        if (i13 != -1) {
            sb2.append("min-fresh=");
            sb2.append(i13);
            sb2.append(", ");
        }
        if (this.f10941j) {
            sb2.append("only-if-cached, ");
        }
        if (this.f10942k) {
            sb2.append("no-transform, ");
        }
        if (this.f10943l) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        kotlin.jvm.internal.g.e(sb2.delete(sb2.length() - 2, sb2.length()), "delete(...)");
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        this.f10944m = string;
        return string;
    }
}
