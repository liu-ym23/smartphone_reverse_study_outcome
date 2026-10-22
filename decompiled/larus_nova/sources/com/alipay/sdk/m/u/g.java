package com.alipay.sdk.m.u;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes28.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f25811c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f25812d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f25813e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f25814f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f25815g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f25816h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g f25817i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g f25818j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final g f25819k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final g f25820l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final g f25821m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final g f25822n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final g f25823o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final g f25824p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final g f25825q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final g f25826r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ g[] f25827s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25829b;

    static {
        g r100 = new g("WIFI", 0, 0, "WIFI");
        f25811c = r100;
        g r101 = new g("NETWORK_TYPE_1", 1, 1, "unicom2G");
        f25812d = r101;
        g r102 = new g("NETWORK_TYPE_2", 2, 2, "mobile2G");
        f25813e = r102;
        g r103 = new g("NETWORK_TYPE_4", 3, 4, "telecom2G");
        f25814f = r103;
        g r104 = new g("NETWORK_TYPE_5", 4, 5, "telecom3G");
        f25815g = r104;
        g r105 = new g("NETWORK_TYPE_6", 5, 6, "telecom3G");
        f25816h = r105;
        g r110 = new g("NETWORK_TYPE_12", 6, 12, "telecom3G");
        f25817i = r110;
        g r111 = new g("NETWORK_TYPE_8", 7, 8, "unicom3G");
        f25818j = r111;
        g r112 = new g("NETWORK_TYPE_3", 8, 3, "unicom3G");
        f25819k = r112;
        g r106 = new g("NETWORK_TYPE_13", 9, 13, "LTE");
        f25820l = r106;
        g r113 = new g("NETWORK_TYPE_11", 10, 11, "IDEN");
        f25821m = r113;
        g r107 = new g("NETWORK_TYPE_9", 11, 9, "HSUPA");
        f25822n = r107;
        g r108 = new g("NETWORK_TYPE_10", 12, 10, "HSPA");
        f25823o = r108;
        g r109 = new g("NETWORK_TYPE_15", 13, 15, "HSPAP");
        f25824p = r109;
        g r114 = new g("NETWORK_TYPE_20", 14, 20, "5G");
        f25825q = r114;
        g r115 = new g(UserProfileEvent.POSITION_NONE, 15, -1, "none");
        f25826r = r115;
        f25827s = new g[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r106, r113, r107, r108, r109, r114, r115};
    }

    public static g[] values() {
        return (g[]) f25827s.clone();
    }

    public final int a() {
        return this.f25828a;
    }

    public final String b() {
        return this.f25829b;
    }

    public static g a(int r100) {
        g[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        g r104 = r101[r103];
        if (r104.a() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return f25826r;
    }

    public static g valueOf(String r100) {
        return (g) r27.a.a(g.class, r100);
    }

    public g(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.f25828a = r102;
        this.f25829b = r103;
    }
}
