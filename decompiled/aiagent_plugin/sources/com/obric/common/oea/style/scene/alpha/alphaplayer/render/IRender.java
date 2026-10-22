package com.obric.common.oea.style.scene.alpha.alphaplayer.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.Surface;
import com.obric.common.oea.style.scene.alpha.alphaplayer.a.d;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView;

/* JADX INFO: compiled from: IRender.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IRender extends SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, GLTextureView.m {

    /* JADX INFO: compiled from: IRender.kt */
    public interface a {
        void a();

        void a(Surface r1);
    }

    void measureInternal(float r1, float r2, float r3, float r4);

    void onCompletion();

    void onFirstFrame();

    void setScaleType(d r1);

    void setSurfaceListener(a r1);
}
