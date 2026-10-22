package bo4;

import java.util.HashMap;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f19815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f19816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f19817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f19818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f19819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f19820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f19821k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashMap<String, String> f19822l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f19823m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f19824n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f19825o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f19826p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f19827q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f19828r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f19829s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f19830t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f19831u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f19832v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f19833w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f19834x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f19835y;

    public final a a() {
        return (a) super.clone();
    L4:
        e = move-exception;
        tt5.a.e("At", "clone at failed", e, false);
        return null;
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public a(int r100, int r101, int r102, int r103, String r104, String r105, String r110, String r111, String r112, String r113, HashMap r114, String r115, String r116, String r117, int r118, boolean r119, String r210, boolean r211, boolean r212, String r213, String r214, String r215, String r216, String r217, int r218) {
        this.f19811a = r100;
        this.f19812b = r101;
        this.f19813c = r102;
        this.f19814d = r103;
        this.f19815e = r104;
        String r106 = "";
        if (r105 != null) goto L5;
        String r107 = "";
    L6:
        this.f19816f = r107;
        this.f19817g = r110;
        if (r111 != null) goto L9;
        String r108 = "";
    L10:
        this.f19819i = r108;
        if (r112 != null) goto L13;
        String r109 = "";
    L14:
        this.f19820j = r109;
        if (r113 != null) goto L17;
        String r120 = "";
    L18:
        this.f19821k = r120;
        this.f19822l = r114;
        this.f19834x = r115;
        this.f19824n = r116;
        this.f19825o = r117;
        this.f19826p = r118;
        this.f19827q = r119;
        this.f19828r = r210;
        this.f19829s = r211;
        this.f19831u = r212;
        if (r213 != null) goto L21;
        String r121 = "";
    L22:
        this.f19832v = r121;
        if (r214 != null) goto L25;
        String r122 = "";
    L26:
        this.f19833w = r122;
        if (r215 == null) goto L30;
        r106 = r215;
    L30:
        this.f19830t = r106;
        this.f19818h = r216;
        this.f19823m = r217;
        this.f19835y = r218;
        return;
    L25:
        r122 = r214;
        goto L26
    L21:
        r121 = r213;
        goto L22
    L17:
        r120 = r113;
        goto L18
    L13:
        r109 = r112;
        goto L14
    L9:
        r108 = r111;
        goto L10
    L5:
        r107 = r105;
        goto L6
    }
}
