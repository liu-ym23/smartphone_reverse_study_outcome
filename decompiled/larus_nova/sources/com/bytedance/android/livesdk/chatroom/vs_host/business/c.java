package com.bytedance.android.livesdk.chatroom.vs_host.business;

import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.CastStreamTimeShiftContext;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements com.bytedance.android.livesdk.chatroom.progressbar.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CastStreamTimeShiftContext f118259a;

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.b
    public final com.bytedance.live.datacontext.m<Long> a() {
        return this.f118259a.getCurrentDisplayTime();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.b
    public final com.bytedance.live.datacontext.m<Boolean> b() {
        return this.f118259a.isCastPlaying();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.b
    public final com.bytedance.live.datacontext.m<mf1.b> c() {
        return this.f118259a.getAtLatest();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.b
    public final com.bytedance.live.datacontext.m<Boolean> d() {
        return this.f118259a.isSupportStreamTimeShift();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.b
    public final com.bytedance.live.datacontext.m<Long> getCurrentTime() {
        return this.f118259a.getCurrentTime();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.b
    public final com.bytedance.live.datacontext.m<Long> getTotalTime() {
        return this.f118259a.getTotalTime();
    }

    public c() {
        String r100 = LiveByteCastUIManager.f104549a;
        this.f118259a = LiveByteCastUIManager.f104555g;
    }
}
