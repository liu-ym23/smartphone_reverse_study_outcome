package com.bytedance.android.livesdk.chatroom.newcontainer.business.common.ai;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.feature.api.IFeatureService;
import ls2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements z90.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IFeatureService f107185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f107186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long[] f107187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f107188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Runnable f107189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Long f107190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f107191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f107192h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f107193i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean[] f107194j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f107195k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int[] f107196l;

    @Override // z90.a.b
    public final void a(String r110, Object r111) {
        if ("will_quit_room".equals(r110) == false) goto L51;
        long r100 = ((Long) this.f107185a.getFeatureManager().getFeature("will_quit_room_id", 0L)).longValue();
        this.f107186b.a(qj1.a.class);
        ((qj1.a) this.f107186b.a(qj1.a.class)).I9(false);
        if (r100 == this.f107187c[0]) goto L9;
        ((qj1.a) this.f107186b.a(qj1.a.class)).l9();
        if (this.f107188d == false) goto L9;
        this.f107186b.f510530s.removeCallbacks(this.f107189e);
        ALogger.e("LAI-feedOpt", "60s后发送mRefreshQuitRoomTimer");
        this.f107186b.f510530s.postDelayed(this.f107189e, this.f107190f.longValue() * 1000);
    L9:
        int r112 = this.f107191g;
        if (r112 != 2) goto L45;
        int r113 = ((Integer) this.f107185a.getFeatureManager().getFeature("will_quit_room_sec", 10000)).intValue();
        long r101 = this.f107192h / ((long) r113);
        Boolean r114 = (Boolean) r111;
        if (r114.booleanValue() == false) goto L29;
        if (this.f107193i != 2) goto L16;
        ((qj1.a) this.f107186b.a(qj1.a.class)).l9();
        ((qj1.a) this.f107186b.a(qj1.a.class)).Fd(this.f107195k);
        this.f107196l[0] = 3;
    L34:
        boolean[] r115 = this.f107194j;
        if (r115[0] == true) goto L37;
    L41:
        boolean[] r116 = this.f107194j;
        r116[0] = r116[1];
    L42:
        this.f107194j[1] = r114.booleanValue();
        if (r100 == this.f107187c[0]) goto L49;
        this.f107194j[0] = false;
    L49:
        this.f107187c[0] = r100;
        return;
    L37:
        if (r115[1] == false) goto L41;
        if (r114.booleanValue() == false) goto L41;
        this.f107194j[0] = false;
        goto L42
    L16:
        if (r100 == 0) goto L25;
        if (r100 != this.f107187c[0]) goto L25;
        boolean[] r117 = this.f107194j;
        if (r117[1] == true) goto L22;
    L23:
        ((qj1.a) this.f107186b.a(qj1.a.class)).l9();
        ((qj1.a) this.f107186b.a(qj1.a.class)).Fd(this.f107195k);
        this.f107196l[0] = 3;
        goto L34
    L22:
        if (r117[0] == false) goto L34;
    L25:
        if (r100 == this.f107187c[0]) goto L34;
        ((qj1.a) this.f107186b.a(qj1.a.class)).l9();
        ((qj1.a) this.f107186b.a(qj1.a.class)).Fd(this.f107195k);
        this.f107196l[0] = 3;
        goto L34
    L29:
        if (this.f107193i == 1) goto L34;
        if ((((long) this.f107196l[0]) % (r101 + 1)) != 1) goto L33;
        ((qj1.a) this.f107186b.a(qj1.a.class)).Fd(this.f107195k);
        this.f107196l[0] = 2;
    L33:
        int[] r118 = this.f107196l;
        r118[0] = r118[0] + 1;
        goto L34
    L45:
        if (r112 != 1) goto L49;
        if (((Boolean) r111).booleanValue() == false) goto L49;
        ((qj1.a) this.f107186b.a(qj1.a.class)).l9();
        ((qj1.a) this.f107186b.a(qj1.a.class)).Fd(this.f107195k);
        goto L49
    }

    public a(IFeatureService r100, d r101, long[] r102, boolean r103, Runnable r104, Long r105, int r106, long r107, int r110, boolean[] r111, long r112, int[] r113) {
        this.f107185a = r100;
        this.f107186b = r101;
        this.f107187c = r102;
        this.f107188d = r103;
        this.f107189e = r104;
        this.f107190f = r105;
        this.f107191g = r106;
        this.f107192h = r107;
        this.f107193i = r110;
        this.f107194j = r111;
        this.f107195k = r112;
        this.f107196l = r113;
    }
}
