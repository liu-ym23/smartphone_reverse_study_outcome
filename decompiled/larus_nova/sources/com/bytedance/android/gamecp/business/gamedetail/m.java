package com.bytedance.android.gamecp.business.gamedetail;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes44.dex */
public final class m implements dw.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageVideoAndLiveProcessor f55309a;

    @Override // dw.h
    public final void a() {
    }

    @Override // dw.h
    public final void onReturnClick() {
    }

    @Override // dw.h
    public final void onShow() {
    }

    @Override // dw.h
    public final void onClick() {
        if (this.f55309a.f53458j.isDetached() == true) goto L17;
        dw.g r100 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getLiveFloatViewService();
        if (r100 == null) goto L15;
        r100.stopFloatView();
    L15:
        this.f55309a.f53458j.dismissAllowingStateLoss();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L18;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L18:
        return;
    }

    public m(PageVideoAndLiveProcessor r100) {
        this.f55309a = r100;
    }

    @Override // dw.h
    public final void onClose(boolean r100) {
        if (r100 == false) goto L7;
        PageVideoAndLiveProcessor.f53446p = r100;
        this.f55309a.getClass();
        PageVideoAndLiveProcessor.f();
        dw.g r101 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getLiveFloatViewService();
        if (r101 == null) goto L8;
        r101.stopFloatView();
        return;
    L8:
        return;
    }
}
