package com.bytedance.android.live.liveinteract.revenue.starwish;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import gj0.i;
import ih0.b;
import java.util.ArrayList;
import java.util.HashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import tlc.d;
import vlc.l;
import xh0.f;
import xh0.h;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/starwish/StarWishWidget;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/AbsPlayModeWidget;", "Lvlc/l;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StarWishWidget extends AbsPlayModeWidget implements l {

    public static final class a {
    }

    static {
    }

    @Override // vlc.l
    public final void onMessage(d r100) {
    }

    @Override // xh0.b
    public final ArrayList<f> getIncompatibleSourceList() {
        return new ArrayList();
    }

    @Override // xh0.b
    public final h getPlayModeInfo() {
        return new h(34, s1.B(R.string.ttlive_star_wish_name));
    }

    @Override // xh0.b
    public final boolean isOpen() {
        IInteractService r100 = (IInteractService) k.f(IInteractService.class);
        if (r100 == null) goto L9;
        b r101 = r100.dynamicService(this.dataCenter);
        if (r101 == null) goto L9;
        if (r101.jl("star_wish") != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        i.a("StarWishWidget", WidgetCostModule.TYPE_ON_CREATE);
        super.onCreate();
        n<ArrayList<Integer>> r100 = m.e(this).a();
        if (r100 == null) goto L15;
        ArrayList<Integer> r101 = r100.getValue();
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.contains(34) != true) goto L17;
        n<ArrayList<Integer>> r102 = m.e(this).a();
        if (r102 == null) goto L13;
        ArrayList<Integer> r103 = r102.getValue();
        if (r103 == null) goto L13;
        r103.remove(34);
    L13:
        int r104 = gj0.h.f481492a;
        gj0.h.b(jc1.a.b(), MapsKt.mapOf(TuplesKt.to("request_page", "link_playmode_panel")), 4);
        return;
    L17:
        return;
    }

    public StarWishWidget() {
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // xh0.b
    public final void tryStartPlayMode(HashMap<String, Object> r100) {
        int r101 = gj0.h.f481492a;
        gj0.h.b(getContext(), null, 6);
    }

    @Override // xh0.b
    public final void tryStopPlayMode(HashMap<String, Object> r100) {
        int r101 = gj0.h.f481492a;
        gj0.h.b(getContext(), null, 6);
    }
}
