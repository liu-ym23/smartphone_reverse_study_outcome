package com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.cache.ui.ReplayCacheDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayAdaptiveDialogUIState;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f110011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f110012b;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r100, DataCenter r101) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        HashMap r100 = new HashMap();
        r100.put("is_vs", "1");
        r100.put("action_type", "click");
        com.bytedance.android.livesdk.chatroom.replay.cache.c.b(this.f110012b, "download_icon_click", r100);
        if (fq1.t.a().isLogin() == false) goto L5;
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r101 = ReplayRoomFragmentScopeUtil.f117917a;
        int r102 = s1.f(ReplayAdaptiveDialogUIState.q((ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class)));
        mq1.c r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.q.a();
        if (r103 == null) goto L27;
        ReplayCacheDialog r104 = r103.f(this.f110011a, this.f110012b, Integer.valueOf(r102));
        if (r104 == null) goto L28;
        Context r105 = this.f110011a;
        if (r105 == null) goto L22;
        FragmentManager r106 = ((FragmentActivity) r105).getSupportFragmentManager();
        LandscapeRestrictionOperation r107 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r104, "VSCache", r107);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r106, r104, r107) == true) goto L30;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L20:
        r104.show(r106, "VSCache");
        return;
    L30:
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L28:
        return;
    L27:
        return;
    L5:
        if (((Boolean) this.f110012b.get("data_is_portrait", Boolean.TRUE)).booleanValue() == true) goto L9;
        mq1.o r108 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.d();
        if (r108 == null) goto L9;
        mq1.o.a.a(r108, 1, 0, 0, "Cache", 22);
    L9:
        com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m.a.a(fq1.t.a(), this.f110011a, fq1.t.a().k(), null, null, fq1.t.a().s(), 0, null, 108);
    }

    public d(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f110011a = r100;
        this.f110012b = r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        HashMap r102 = new HashMap();
        r102.put("is_vs", "1");
        r102.put("action_type", "click");
        com.bytedance.android.livesdk.chatroom.replay.cache.c.b(this.f110012b, "download_icon_show", r102);
    }
}
