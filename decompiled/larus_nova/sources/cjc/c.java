package cjc;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes40.dex */
public interface c {
    void a(int r100);

    void b(Bitmap r100);

    void c();

    View getBlackCoverView();

    int getTextureLayout();

    ViewGroup getVideoContainer();

    int getVideoHeight();

    com.ss.android.videoshop.mediaview.a getVideoView();

    int getVideoViewMarginTop();

    int getVideoWidth();

    void setCropStrategy(gjc.a r100);

    void setOptimizeBlackSide(boolean r100);

    void setOptimizeNormalFillScreen(boolean r100);

    void setVideoSize(int r100, int r101);

    void setZoomingEnabled(boolean r100);
}
