package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.view.View;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes12.dex */
public interface k {
    void attach();

    void b(boolean r100);

    ECVideoView getECVideoView();

    View getView();

    boolean isPlaying();

    void pause();

    void r(zb3.e r100, int r101, int r102, com.bytedance.android.shopping.anchorv3.comment.a r103, Function2<? super Integer, ? super Integer, Unit> r104);

    void stop();
}
