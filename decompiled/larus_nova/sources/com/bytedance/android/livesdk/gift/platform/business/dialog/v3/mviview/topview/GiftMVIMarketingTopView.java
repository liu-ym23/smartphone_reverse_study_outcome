package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopMarketingViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SendGiftSuccess;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVIMarketingTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopMarketingViewState, GiftAction> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f128110m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public zy0.b f128111n;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return R.layout.ttlive_top_gift_marketing_lynx_view;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        zy0.b r100 = this.f128111n;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        ViewGroup r101 = this.f128110m;
        if (r101 == null) goto L8;
        r101.removeAllViews();
    L8:
        this.f128111n = null;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        this.f128110m = (ViewGroup) r().findViewById(R.id.gift_panel_marketing_lynx_view_container);
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVIMarketingTopView$bindToParent$1 r101 = GiftMVIMarketingTopView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final boolean d(com.bytedance.android.anya.a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if ((r100 instanceof SendGiftSuccess) == false) goto L11;
        JSONObject r101 = new JSONObject();
        SendGiftSuccess r102 = (SendGiftSuccess) r100;
        r101.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, r102.getGiftId());
        r101.put("send_count", r102.getSendCount());
        zy0.b r103 = this.f128111n;
        if (r103 == null) goto L12;
        xy0.a<?> r104 = r103.g();
        if (r104 == null) goto L13;
        r104.sendJsEvent("H5_sendGiftSucceed", r101);
        return false;
    L13:
        return false;
    L12:
        return false;
    L11:
        return false;
    }

    public GiftMVIMarketingTopView(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        super(r100, r101);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r100, MVIState r101) {
        GiftTopMarketingViewState r102 = (GiftTopMarketingViewState) r101;
        Intrinsics.checkNotNullParameter(r100, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r102, "state");
        r0<GiftTopMarketingViewState, Pair<Map<String, Object>, Boolean>> r103 = r102.getGiftMarketingInfo();
        Object r104 = r100.f41740c.a(r103);
        if (r104 == null) goto L34;
        r100.f41739b.f41563a.invoke(r103);
        Pair r105 = (Pair) r104;
        Map<String, ? extends Object> r106 = (Map) r105.getFirst();
        boolean r107 = ((Boolean) r105.getSecond()).booleanValue();
        if (r106.isEmpty() == false) goto L15;
        if (r107 == true) goto L35;
        zy0.b r108 = this.f128111n;
        if (r108 == null) goto L10;
        r108.dispose();
    L10:
        ViewGroup r109 = this.f128110m;
        if (r109 == null) goto L13;
        r109.removeAllViews();
    L13:
        this.f128111n = null;
        return;
    L35:
        return;
    L15:
        if (this.f128111n == null) goto L22;
        HashMap r110 = new HashMap();
        r110.put("eventName", "gift_marketing_data_update");
        r110.put("eventParams", r106);
        zy0.b r111 = this.f128111n;
        if (r111 == null) goto L37;
        xy0.a<?> r112 = r111.g();
        if (r112 == null) goto L38;
        r112.sendJsEvent("H5_webcastNotification", r110);
        return;
    L38:
        return;
    L37:
        return;
    L22:
        if (com.bytedance.android.live.revenue.common.b0.a().h() == false) goto L24;
        zy0.b r113 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(getContext(), UriProtector.parse(nz1.a.l().c()), null);
    L25:
        this.f128111n = r113;
        if (r113 == null) goto L40;
        ViewGroup r114 = this.f128110m;
        if (r114 == null) goto L30;
        r114.addView(r113.c());
    L30:
        xy0.a<?> r115 = r113.g();
        if (r115 == null) goto L41;
        r115.load(null, r106);
        return;
    L41:
        return;
    L40:
        return;
    L24:
        r113 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(getContext(), UriProtector.parse(nz1.a.l().c()), null);
        goto L25
    }
}
