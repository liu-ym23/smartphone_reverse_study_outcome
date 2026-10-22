package com.bytedance.android.ec.store.utils.playable.impl.video;

import com.ss.ttvideoengine.utils.Error;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements com.bytedance.android.shopping.widget.ecvideoplayer.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f48678a;

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
        b r100 = this.f48678a;
        if (r100.f48685h == true) goto L7;
        ln.b r101 = r100.f48681d;
        if (r101 == null) goto L7;
        r101.c(r100);
    L7:
        c r102 = this.f48678a.f48686a;
        if (r102 == null) goto L11;
        r102.e();
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onRenderStart() {
        c r100 = this.f48678a.f48686a;
        if (r100 == null) goto L6;
        r100.onStartPlay();
        return;
    }

    public a(b r100) {
        this.f48678a = r100;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void onError(Error r100) {
        c r101 = this.f48678a.f48686a;
        if (r101 == null) goto L6;
        r101.e();
        return;
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
    public final void h(int r100, int r101) {
        long r102 = r100;
        this.f48678a.getClass();
        c r103 = this.f48678a.f48686a;
        if (r103 == null) goto L6;
        r103.f(r102);
        return;
    }
}
