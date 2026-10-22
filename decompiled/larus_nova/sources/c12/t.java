package c12;

/* JADX INFO: loaded from: classes9.dex */
public final class t implements fd6.a<String> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f22058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static h f22059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static fd6.b<String> f22060d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.f f22061a;

    public t() {
        kjc.a.call(new o(this));
    }

    @Override // fd6.a
    public final fd6.b<String> a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r100, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.d r101) {
        if (r100 != null) goto L4;
    L10:
        a r102 = f22058b;
        if (r102 == null) goto L13;
        return r102;
    L13:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r103 = r101.f252397a;
        fd6.b<String> r104 = this.f22061a.a(r103);
        f22060d = r104;
        a r105 = new a(new h(r104));
        f22058b = r105;
        return r105;
    L4:
        if (r100.f129103m == true) goto L10;
        h r106 = f22059c;
        if (r106 == null) goto L8;
        return r106;
    L8:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r107 = r101.f252397a;
        fd6.b<String> r108 = this.f22061a.a(r107);
        f22060d = r108;
        h r109 = new h(r108);
        f22059c = r109;
        return r109;
    }
}
