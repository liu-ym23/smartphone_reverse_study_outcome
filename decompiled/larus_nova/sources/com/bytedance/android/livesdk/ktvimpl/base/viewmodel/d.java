package com.bytedance.android.livesdk.ktvimpl.base.viewmodel;

import com.bytedance.android.livesdk.ktvimpl.base.i;
import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: classes10.dex */
public interface d {
    void clearData();

    void cutFromChallenge(String r100);

    void cutMusic();

    void initLiveStreamWrapper(String r100);

    boolean isNeedMusicDownload(MusicPanel r100);

    i lazyInitKtvCoreController();

    void onPageCreate();

    void onPageResume();

    void onPageStop();

    void toggleOrigin(boolean r100);

    void togglePause(boolean r100);

    void updateCurrentLyricsLine(int r100);
}
