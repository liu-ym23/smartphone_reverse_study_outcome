package com.bytedance.android.livesdkapi.depend.live.vs.listener;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;

/* JADX INFO: loaded from: classes12.dex */
public interface IVSVideoListener extends IVsVideoListManager {
    boolean dislike(Episode r100, boolean r101);

    void dislikeOrFollow(Episode r100, boolean r101, String r102, boolean r103);

    boolean dislikeOrHideScreen(Episode r100, boolean r101);

    void douyinDislike(Episode r100, boolean r101);

    void exitEpisodeFragment(long r100);

    void hideAllTips();

    void jump2Other(long r100, String r101, Bundle r102, String r103, boolean r104);

    void leave4Profile(long r100);

    void onHybridMoreLoaded(int r100);

    void onInputStateChange(boolean r100);

    void onInteractionLayerShow(Episode r100);

    boolean onInterceptUserClose();

    void onWidgetLoadEnd(String r100, int r101);

    void showClearScreenTips();

    void triggerPreload();

    void updatePlayItem(Episode r100);
}
