package com.bytedance.android.livesdkapi.depend.live.gift;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.depend.IDependency;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveGiftPlayController extends IDependency {
    void attachAlphaView(ViewGroup r100);

    void cancel();

    void detachAlphaView(ViewGroup r100);

    View getAlphaView();

    int getDuration();

    String getPlayerType();

    void initialize(LifecycleOwner r100);

    boolean isPlaying();

    void release();

    void removeMonitor();

    void removePlayerActionListener();

    void setImageMask(String r100, Bitmap r101);

    void setMonitor(IResultMonitor r100);

    void setPlayerActionListener(IPlayerActionListener r100);

    void setPlayerProgressListener(IPlayerProgressListener r100, long r101);

    void setSuperResolutionModel(SuperResolutionModel r100);

    void setTextMask(String r100, String r101, String r102, int r103, boolean r104);

    int start(String r100, long r101);

    void stop();

    void stopWhenSlideSwitch();
}
