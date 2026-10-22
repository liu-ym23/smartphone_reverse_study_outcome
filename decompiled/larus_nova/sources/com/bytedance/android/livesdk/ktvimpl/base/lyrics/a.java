package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.graphics.Paint;
import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface a {
    void addLyrics(List<com.bytedance.component.lyric.model.b> r100, long r101);

    void adjustAddLyricsLine(com.bytedance.component.lyric.model.b r100, boolean r101);

    View asView();

    int getCurrentIndex();

    ArrayList<com.bytedance.component.lyric.model.b> getCurrentLyrics();

    LyricsDisplayConfig getDisplayConfig();

    Paint.Align getTextAlign();

    boolean isFinishDrawLastLine();

    void onConfigComplete();

    void release();

    void renderLyricsByPlayTime(long r100);

    void resetCurrMusicProcess();

    void setLyricOneLineMaxWidth(float r100);

    void setLyricVisible(int r100);

    void updateCurrentState(KtvRoomLyricsStateMachineConfig.d r100);

    void updateDynamicPaintColor();
}
