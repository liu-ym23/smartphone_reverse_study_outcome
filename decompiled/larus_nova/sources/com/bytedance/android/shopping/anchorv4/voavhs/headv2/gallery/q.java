package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.bytedance.android.ec.model.ECUrlModel;

/* JADX INFO: loaded from: classes13.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECUrlModel f169363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f169364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f169365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b f169366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f169367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f169368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f169369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f169370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p f169371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f169372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f169373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f169374l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c0 f169375m;

    public q(ECUrlModel r110, String r111, String r112, com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r113, String r114, String r210, String r211, int r212, p r213, int r214, Integer r215, boolean r216, int r217) {
        if ((r217 & 1) == 0) goto L5;
        ECUrlModel r100 = null;
    L7:
        if ((r217 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r217 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r217 & 8) == 0) goto L17;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r103 = null;
    L19:
        if ((r217 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r217 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r217 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r217 & 256) == 0) goto L33;
        p r115 = null;
    L34:
        boolean r116 = false;
        if ((r217 & 512) == 0) goto L37;
        int r117 = 0;
    L39:
        if ((r217 & 1024) == 0) goto L41;
        Integer r118 = null;
    L43:
        if ((r217 & 2048) != 0) goto L46;
        r116 = r216;
    L46:
        this.f169363a = r100;
        this.f169364b = r101;
        this.f169365c = r102;
        this.f169366d = r103;
        this.f169367e = r104;
        this.f169368f = r105;
        this.f169369g = r106;
        this.f169370h = r212;
        this.f169371i = r115;
        this.f169372j = r117;
        this.f169373k = r118;
        this.f169374l = r116;
        this.f169375m = null;
        return;
    L41:
        r118 = r215;
        goto L43
    L37:
        r117 = r214;
        goto L39
    L33:
        r115 = r213;
        goto L34
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
