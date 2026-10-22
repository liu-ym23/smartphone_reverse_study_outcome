package com.bytedance.android.ec.window.base.utils.playable.impl.video;

import com.ss.ttvideoengine.utils.Error;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements com.bytedance.android.shopping.widget.ecvideoplayer.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f49751a;

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void E() {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onIdle() {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onPaused() {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onPlaying() {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onRelease() {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onVideoSizeChanged(int r100, int r101) {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void w() {
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void g() {
        d r100 = this.f49751a;
        if (r100.f49759i == true) goto L7;
        tp.b r101 = r100.f49755e;
        if (r101 == null) goto L7;
        r101.b(r100);
    L7:
        e r102 = this.f49751a.f49760a;
        if (r102 == null) goto L11;
        r102.e();
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onRenderStart() {
        e r100 = this.f49751a.f49760a;
        if (r100 == null) goto L6;
        r100.onStartPlay();
        return;
    }

    public c(d r100) {
        this.f49751a = r100;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onError(Error r100) {
        e r101 = this.f49751a.f49760a;
        if (r101 == null) goto L6;
        r101.e();
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void h(int r100, int r101) {
        long r102 = r100;
        this.f49751a.f49754d = Long.valueOf(r102);
        e r103 = this.f49751a.f49760a;
        if (r103 == null) goto L6;
        r103.a(r102, r101);
        return;
    }
}
