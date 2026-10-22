package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.view.View;
import android.view.ViewGroup;
import com.obric.common.oea.style.scene.alpha.alphaplayer.a.d;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b;
import com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender;

/* JADX INFO: compiled from: IAlphaVideoView.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface a {
    void addParentView(ViewGroup r1);

    void bringToFront();

    int getMeasuredHeight();

    int getMeasuredWidth();

    d getScaleType();

    View getView();

    boolean isSurfaceCreated();

    void measureInternal(float r1, float r2);

    void onCompletion();

    void onFirstFrame();

    void onPause();

    void release();

    void removeParentView(ViewGroup r1);

    void requestRender();

    void setLayoutParams(ViewGroup.LayoutParams r1);

    void setPlayerController(b r1);

    void setScaleType(d r1);

    void setVideoRenderer(IRender r1);

    void setVisibility(int r1);
}
