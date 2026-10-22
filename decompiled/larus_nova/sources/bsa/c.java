package bsa;

import android.graphics.SurfaceTexture;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f20351a;

    public c(b r100) {
        this.f20351a = r100;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r100) {
        b r101 = this.f20351a;
        if (r101.f20339q == true) goto L6;
        r101.f20329g.requestRender();
        return;
    }
}
