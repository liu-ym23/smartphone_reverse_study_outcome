package com.bytedance.android.livesdkapi.depend.live.vs.fragment;

import com.bytedance.android.livesdkapi.depend.live.vs.listener.IVSVideoListener;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;

/* JADX INFO: loaded from: classes12.dex */
public interface IVSVideoFragment extends IVSItemBaseFragment {
    Episode getCurrentEpisode();

    long getEpisodeId();

    IVSVideoListener getVSVideoListener();

    void prepareHybridMore(int r100);

    void prepareWidget();

    void setVSVideoListener(IVSVideoListener r100);

    void startPlayDuringScroll(Episode r100);

    void startPlayWithEpisode(Episode r100);
}
