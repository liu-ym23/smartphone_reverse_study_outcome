package com.bytedance.android.livesdk.chatroom.roommanage.common;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomTabLayout f111377a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f111377a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        LiveRoomTabLayout r100 = this.f111377a;
        r100.f111354h = r100.f111348b.getCurrentItem();
        LiveRoomTabLayout r101 = this.f111377a;
        r101.b(r101.f111354h);
    }

    public a(LiveRoomTabLayout r100) {
        this.f111377a = r100;
    }
}
