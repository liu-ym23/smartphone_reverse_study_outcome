package com.bytedance.android.livesdk.player.surfacecontrol.dbr;

import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements LivePlayerView.AttachSurfaceViewListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SurfaceControlRenderManager f156164a;

    @Override // com.bytedance.android.livesdkapi.roomplayer.LivePlayerView.AttachSurfaceViewListener
    public final void onDetachSurfaceView() {
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.LivePlayerView.AttachSurfaceViewListener
    public final void onAttachSurfaceView() {
        SurfaceControlRenderManager.b r100 = this.f156164a.f156110a;
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    public d(SurfaceControlRenderManager r100) {
        this.f156164a = r100;
    }
}
