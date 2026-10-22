package ak7;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends ni7.a<a> implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f4079b = null;

    @Override // ni7.a
    public final String i0() {
        return "com.bytedance.ug.sdk.luckycat.offline.LuckyCatGeckoClientManager";
    }

    static {
        f4079b = new c();
    }

    @Override // ak7.a
    public final String J() {
        a r100 = h0();
        if (r100 == null) goto L7;
        String r101 = r100.J();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return "";
    }

    @Override // ak7.a
    public final b b0() {
        a r100 = h0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b0();
    }

    @Override // ak7.a
    public final void m() {
        a r100 = h0();
        if (r100 == null) goto L6;
        r100.m();
        return;
    }

    public c() {
    }

    @Override // ak7.a
    public final void f0(String r100) {
        a r101 = h0();
        if (r101 == null) goto L6;
        r101.f0(r100);
        return;
    }
}
