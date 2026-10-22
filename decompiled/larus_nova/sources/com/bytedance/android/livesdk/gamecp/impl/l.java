package com.bytedance.android.livesdk.gamecp.impl;

import com.bytedance.android.livesdkapi.view.IVideoFloatManager;

/* JADX INFO: loaded from: classes8.dex */
public final class l implements IVideoFloatManager.VideoFloatManagerListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dw.h f125446a;

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onClick() {
        this.f125446a.onClick();
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onReturnClick() {
        this.f125446a.onReturnClick();
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onShow() {
        this.f125446a.onShow();
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onViewReleased() {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onViewReleased(this);
    }

    public l(com.bytedance.android.gamecp.business.gamedetail.m r100) {
        this.f125446a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onClose(boolean r100) {
        this.f125446a.onClose(r100);
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onMuteButtonClick(boolean r100) {
        this.f125446a.a();
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onShow(int r100, int r101, int r102, int r103) {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onShow(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.livesdkapi.view.IVideoFloatManager.VideoFloatManagerListener
    public final void onViewPositionChanged(int r100, int r101, int r102, int r103) {
        IVideoFloatManager.VideoFloatManagerListener.DefaultImpls.onViewPositionChanged(this, r100, r101, r102, r103);
    }
}
