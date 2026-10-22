package com.bytedance.android.live.soloktv.karaokestation.viewmodel;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.soloktv.karaokestation.model.AddSongSourceType;
import com.bytedance.android.live.soloktv.model.m;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public interface a {
    void addFavorite(MusicPanel r100, ic0.a r101);

    void addSong(Context r100, MusicPanel r101, RecyclerView.ViewHolder r102, AddSongSourceType r103);

    void anchorGetSongInfo(long r100);

    void delFavorite(MusicPanel r100, ic0.a r101);

    int getSungSongCount();

    void initKtvRoomData(Function1<? super List<m>, Unit> r100);

    void jumpToChorusRoom(MusicPanel r100);

    void observeJumpMusic(LifecycleOwner r100, Observer<MusicPanel> r101);

    String obtainCurrentSortType();

    String obtainEnterFrom();

    void postGoBackPersonalKaraokeEvent(boolean r100);

    void requestPersonalSingInfo();

    void resetRecentlyMusicListBySingTime();

    void sortSecondLevelTab(String r100, y r101);

    void syncPersonalKaraokeTabList();
}
