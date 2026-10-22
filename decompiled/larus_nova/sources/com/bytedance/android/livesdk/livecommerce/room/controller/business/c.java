package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.coupon.CouponGrowProvider;
import com.bytedance.android.livesdk.livecommerce.room.coupon.ReferralCoupon;
import com.bytedance.android.livesdk.livecommerce.room.coupon.ShortTouchLynxCoupon;
import com.bytedance.android.livesdk.livecommerce.room.coupon.ShortTouchLynxCouponV2;
import com.bytedance.android.livesdk.livecommerce.room.model.ShortTouchCouponMsgEvent;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;
import vi2.v0;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends c0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f151617i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final sg2.h f151618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f151619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f151620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ih2.d f151621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ih2.h f151622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public el2.n f151623h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0
    public final void F() {
        sg2.h r100 = this.f151618c;
        r100.f541799a = 1;
        r100.f541802d = null;
        WeakReference<v0<xi2.p>> r101 = r100.f541800b;
        if (r101 == null) goto L5;
        r101.clear();
    L5:
        WeakReference<v0<xi2.r>> r102 = r100.f541801c;
        if (r102 == null) goto L9;
        r102.clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0
    public final void n() {
        el2.n r100 = this.f151623h;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        this.f151623h = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroyView() {
        CouponGrowProvider.f151736l.getClass();     // Catch: Throwable -> L4
        CouponGrowProvider.f151730f.f(B(), true);     // Catch: Throwable -> L4
        return;
    }

    public final String H() {
        if (t() == false) goto L9;
        String r100 = p().get(ILiveRoomPlayFragmentConstant.EXTRA_PREVIEW_COUPON_ID);
        if (r100 != null) goto L8;
        return "";
    L8:
        return r100;
    L9:
        return "";
    }

    public final void I() {
        ECContext r100 = o();
        ShortTouchLynxCouponV2 r101 = null;
        if (r100 == null) goto L5;
        H();
        ShortTouchLynxCoupon r102 = new ShortTouchLynxCoupon(ShortTouchLynxCoupon.b.a.f151791a, th.a.e(m(), true), r100, H(), A().f151422m);
    L6:
        if (r102 == null) goto L8;
        E().H(r102);
    L8:
        ECContext r110 = o();
        if (r110 == null) goto L11;
        H();
        r101 = new ShortTouchLynxCouponV2(ShortTouchLynxCouponV2.b.a.f151816a, th.a.e(m(), true), r110, H(), A().f151422m);
    L11:
        if (r101 == null) goto L14;
        E().N(r101);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void J() {
        if (hh2.f.d() == false) goto L12;
        CouponGrowProvider.Companion r100 = CouponGrowProvider.f151736l;
        Context r101 = m();
        Map<String, String> r102 = p();
        String r103 = B();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "ecomParams");
        Intrinsics.checkNotNullParameter(r103, "roomId");
        CouponGrowProvider.Companion.a("oacfgs");
        int r104 = RoomContextController.f151593h;
        if (RoomContextController.a.a().M() == true) goto L7;
        CouponGrowProvider.Companion.a("noln");
        return;
    L7:
        HashMap<String, JSONObject> r105 = com.bytedance.android.ec.core.hybrid.utils.j.f44312a;
        JSONObject r106 = com.bytedance.android.ec.core.hybrid.utils.j.i(r102.get("enter_request"));
        boolean r107 = CouponGrowProvider.Companion.e(r106);
        if (r107 == true) goto L10;
        CouponGrowProvider.Companion.g(r101, r106, r103, false, null);
    L10:
        CouponGrowProvider.Companion.a("hgc: " + r107);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
        super.onDestroy();
        s0.e(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        s0.e(this);
        this.f151619d = false;
        this.f151620e = false;
        CouponGrowProvider.f151736l.getClass();     // Catch: Throwable -> L5
        CouponGrowProvider.f151730f.f(B(), true);     // Catch: Throwable -> L5
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onWidgetLoadFinished() {
        F();
        if (s() == false) goto L5;
    L7:
        Context r100 = m();
        com.bytedance.android.ec.adapter.api.state.a r101 = C();
        if (this.f151620e == true) goto L21;
        this.f151620e = true;
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L21
    L11:
        if (s() == true) goto L21;
        ReferralCoupon.b(r101, r100, false);     // Catch: Exception -> L14
    L21:
        CouponGrowProvider.f151736l.getClass();     // Catch: Exception -> L18
        CouponGrowProvider r102 = CouponGrowProvider.f151730f;     // Catch: Exception -> L18
        Context r103 = m();     // Catch: Exception -> L18
        String r104 = B();     // Catch: Exception -> L18
        HashMap<String, JSONObject> r105 = com.bytedance.android.ec.core.hybrid.utils.j.f44312a;     // Catch: Exception -> L18
        r102.e(r103, r104, com.bytedance.android.ec.core.hybrid.utils.j.i(p().get("enter_request")), true, A().f151427r);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L5:
        if (t() == false) goto L7;
        new com.bytedance.android.livesdk.livecommerce.room.coupon.a(C(), m(), this.f151686b.d()).b();
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onCreate() {
        s0.c(this);
    }

    public c(RealRoomController$roomResources$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "roomResources");
        super(r100);
        this.f151618c = sg2.h.a.f541804a;
    }

    @Subscribe
    public final void updateShortTouchCouponMsg(ShortTouchCouponMsgEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (w() == true) goto L6;
        return;
    L6:
        if (ECLiveABUtils.INSTANCE.getECOM_DISABLE_LEGACY_LOAD_COUPON_LOGIC() == true) goto L8;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == true) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r100.getRoomId(), o().getRoomId().getValue()) == false) goto L21;
        int r102 = ECContextContainer.f151896b;
        ECContext r103 = ECContextContainer.a.b();
        if (r103 == null) goto L22;
        com.bytedance.live.datacontext.n<ShortTouchCouponMsgEvent> r104 = r103.getShortTouchCouponInfo();
        if (r104 == null) goto L23;
        r104.setValue(r100);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L8:
        if (ECAppInfoService.h() == false) goto L10;
        r101 = true;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r100, com.bytedance.android.ec.adapter.api.state.a r101) {
        super.c(r100, r101);
        s0.e(this);
        boolean r102 = true;
        if (r101 == null) goto L35;
        if (r100 == null) goto L35;
        if (this.f151620e == true) goto L35;
        this.f151620e = true;
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L35
    L9:
        if (s() == true) goto L35;
        ReferralCoupon.b(r101, r100, true);     // Catch: Exception -> L12
    L35:
        CouponGrowProvider.f151736l.getClass();     // Catch: Throwable -> L34
        CouponGrowProvider r103 = CouponGrowProvider.f151730f;     // Catch: Throwable -> L34
        String r104 = B();     // Catch: Throwable -> L34
        r103.getClass();     // Catch: Throwable -> L34
        Intrinsics.checkNotNullParameter(r104, "roomId");     // Catch: Throwable -> L34
        CouponGrowProvider.f151735k.remove(r104);     // Catch: Throwable -> L34
        r103.f151738b.remove(r104);     // Catch: Throwable -> L34
        if (r103.f151739c.length() > 0) goto L18;
        r102 = false;
    L18:
        if (r102 == true) goto L20;
    L22:
        ih2.d r105 = this.f151621f;     // Catch: Throwable -> L34
        if (r105 != null) goto L39;
    L25:
        ih2.h r106 = this.f151622g;     // Catch: Throwable -> L34
        if (r106 == null) goto L28;
        ih2.h.a(r106);     // Catch: Throwable -> L34
        goto L28
    L39:
        ih2.d.a(r105);     // Catch: Throwable -> L33
        goto L25
    L20:
        if (Intrinsics.areEqual(r103.f151739c, r104) == false) goto L22;
        r103.b();     // Catch: Throwable -> L34
    L28:
        el2.n r107 = this.f151623h;
        if (r107 == null) goto L31;
        r107.destroy();
    L31:
        this.f151623h = null;
    }
}
