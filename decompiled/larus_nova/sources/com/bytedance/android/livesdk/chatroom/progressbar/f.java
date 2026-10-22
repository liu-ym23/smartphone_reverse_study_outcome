package com.bytedance.android.livesdk.chatroom.progressbar;

import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements IProgressCastService {
    public f() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService
    public final b getProgressCastStreamShiftService() {
        return r.b().f();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService
    public final void liveGoRealTime() {
        r.b().liveClarityStrategy();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService
    public final void pause() {
        r.b().J();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService
    public final void resume() {
        r.b().h();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService
    public final m<Boolean> castScreenMode(DataCenter r100) {
        return r.b().castScreenMode(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService
    public final boolean isByteMatchCasting(DataCenter r100) {
        return r.b().isByteMatchCasting(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService
    public final void seekTo(long r100) {
        r.b().i(r100);
    }
}
