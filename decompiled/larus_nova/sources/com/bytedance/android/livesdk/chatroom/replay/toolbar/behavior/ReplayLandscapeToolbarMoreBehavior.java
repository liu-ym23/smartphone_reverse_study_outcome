package com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/behavior/ReplayLandscapeToolbarMoreBehavior;", "Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/behavior/ReplayAbsToolbarMoreBehavior;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayLandscapeToolbarMoreBehavior extends ReplayAbsToolbarMoreBehavior {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f109981l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f109982m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View.OnClickListener f109983n;

    public static final class a implements js0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayLandscapeToolbarMoreBehavior f109984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f109985b;

        @Override // js0.b
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
            int r101 = com.bytedance.android.livesdk.chatroom.replay.toolbar.d.f110090a;
            ReplayLandscapeToolbarMoreBehavior r102 = this.f109984a;
            List r103 = com.bytedance.android.livesdk.chatroom.replay.toolbar.d.b(r102.f109979j, r102.f109978i);
            ((ArrayList) this.f109984a.f109971b).clear();
            ((ArrayList) this.f109984a.f109971b).addAll(r103);
            this.f109984a.onClick(this.f109985b);
        }

        public a(ReplayLandscapeToolbarMoreBehavior r100, View r101) {
            this.f109984a = r100;
            this.f109985b = r101;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.ReplayAbsToolbarMoreBehavior, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        if ((r100 instanceof pp1.j) == false) goto L6;
        b();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.ReplayAbsToolbarMoreBehavior, android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r101 = ReplayRoomFragmentScopeUtil.f117917a;
        ((com.bytedance.android.livesdk.chatroom.replay.ui.e) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.e.class)).getClass();
        if (com.bytedance.android.livesdk.chatroom.replay.ui.e.o() == false) goto L5;
        return;
    L5:
        ReplayDataContext.a r102 = ReplayDataContext.Companion;
        DataCenter r103 = this.f109979j;
        r102.getClass();
        ReplayDataContext r104 = ReplayDataContext.a.b(r103);
        if (r104 == null) goto L12;
        com.bytedance.live.datacontext.m<Boolean> r105 = r104.isFromCache();
        if (r105 == null) goto L12;
        Boolean r106 = r105.getValue();
        if (r106 == null) goto L12;
        boolean r107 = r106.booleanValue();
    L13:
        if (r107 == false) goto L18;
        Context r108 = this.f109978i;
        int r109 = ita.i.f495747a;
        if (NetworkUtils.isNetworkAvailable(r108) == true) goto L18;
        String r110 = rm3.c.f538539a;
        rm3.c.f(this.f109978i, R.string.ttlive_vs_from_cache_net_error, false, 28);
        return;
    L18:
        List<ToolbarButton> r111 = this.f109971b;
        ArrayList r112 = (ArrayList) r111;
        if (r112.contains(ToolbarButton.VS_VISIBILITY_SETTING) == false) goto L24;
        LivePluginSPIManager.f85856e.getClass();
        if (LivePluginSPIManager.c() == true) goto L24;
        LivePluginSPIManager.a().addOnSuccess(new a(this, r100)).callbackOnMainThread().syncCallbackIfReady(true).requireByUser("ReplayAbsToolbarMoreBehavior");
        return;
    L24:
        View.OnClickListener r113 = this.f109983n;
        if (r113 == null) goto L27;
        r113.onClick(r100);
    L27:
        Iterator r114 = ((ArrayList) this.f109970a).iterator();
    L29:
        if (r114.hasNext() == false) goto L40;
        ToolbarButton r115 = (ToolbarButton) r114.next();
        int r116 = e.f110013a[r115.ordinal()];
        if (r116 != 1) goto L33;
        r115.setDrawableFolded(R.drawable.ttlive_vs_cache_video_opt);
        goto L29
    L33:
        if (r116 != 2) goto L35;
        r115.setDrawableFolded(R.drawable.ttlive_vs_ic_report_anchor_opt);
        goto L29
    L35:
        if (r116 != 3) goto L29;
        r115.setDrawableFolded(R.drawable.ttlive_vs_ic_float_window_switch_landscape_opt);
        goto L29
    L40:
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r117 = ReplayRoomFragmentScopeUtil.f117917a;
        this.f109972c = ((com.bytedance.android.livesdk.chatroom.replay.ui.l) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.l.class)).q(this.f109978i, this.f109970a, this.f109979j, this.f109971b);
        if (((com.bytedance.android.livesdk.chatroom.replay.ui.l) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.replay.ui.l.class)).l() == false) goto L45;
        Dialog r118 = this.f109972c;
        if (r118 == null) goto L45;
        r118.setOnShowListener(new f(this));
    L45:
        Dialog r119 = this.f109972c;
        Intrinsics.checkNotNull(r119);
        r119.setOnDismissListener(g.f110015a);
        super.onClick(r100);
        return;
    L12:
        r107 = false;
        goto L13
    }

    public ReplayLandscapeToolbarMoreBehavior(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super(r100, r101, false);
        this.f109983n = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.ReplayAbsToolbarMoreBehavior, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super.R9(r100, r101);
        this.f109979j.removeObserver(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.ReplayAbsToolbarMoreBehavior, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super.p4(r100, r101);
        this.f109981l = r100;
        ImageView r102 = (ImageView) r100.findViewById(R.id.more_toolbar_icon);
        this.f109982m = r102;
        if (r102 == null) goto L5;
        r102.setBackgroundResource(0);
    L5:
        ImageView r103 = this.f109982m;
        if (r103 == null) goto L9;
        r103.setImageResource(R.drawable.ttlive_replay_more_behavior_icon_landscape);
        return;
    }
}
