package com.bytedance.android.livesdkapi.depend.live;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.IDependency;
import com.bytedance.android.livesdkapi.view.IRenderView;

/* JADX INFO: loaded from: classes12.dex */
public interface ILivePlayController extends IDependency {
    void destroy(Context r100);

    String getPullStreamData();

    String getUrl();

    int getVideoSize();

    IRenderView getVideoView();

    boolean isPlaying();

    boolean releaseAll(Context r100);

    void setMute(boolean r100, Context r101);

    void setShouldDestory(boolean r100);

    void stop(Context r100);

    void switchResolution(String r100);
}
