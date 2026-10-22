package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.liveinteract.banner.LabelBannerUrl;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.RTChorusOperateType;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void c(d r100) {
            r100.syncMineWantSingSongList(false, null);
        }

        public static /* synthetic */ void b(d r100, MusicPanel r101, Boolean r102, int r103) {
            if ((r103 & 2) == 0) goto L5;
            boolean r104 = true;
        L7:
            if ((r103 & 4) == 0) goto L9;
            r102 = null;
        L9:
            r100.removeMusic(r101, r104, r102);
            return;
        L5:
            r104 = false;
            goto L7
        }

        public static /* synthetic */ void a(d r100, Throwable r101, int r102, RTChorusOperateType r110, MusicPanel r111) {
            r100.checkRTChorusPermissionInfoIfNeed(r101, r102, r110, r111, null, null);
        }
    }

    void addFavorite(MusicPanel r100, ic0.a r101);

    void addSong(Context r100, MusicPanel r101, RecyclerView.ViewHolder r102, com.bytedance.android.live.ktv.common.music.control.b r103);

    void applyWantListen(Context r100, MusicPanel r101, RecyclerView.ViewHolder r102);

    void beginWifiDownload(y r100);

    boolean canSelectMore();

    boolean checkMidiDataInRecentlyLabel(y r100);

    void checkRTChorusPermissionInfoIfNeed(Throwable r100, int r101, RTChorusOperateType r102, MusicPanel r103, String r104, String r105);

    void clearSelectedSongList();

    void cutMusic();

    void delFavorite(MusicPanel r100, ic0.a r101);

    void deleteSelfDownloadMusicById(String r100);

    String getCurSortType();

    boolean getForceUpdateBannerState();

    Map<String, LabelBannerUrl> getLabelBannerMap();

    ModeType getModeType();

    td2.b getOrderSongExtraInfo();

    MutableLiveData<vb0.a> getOrderSongUiState();

    OrderedSongDataContext getOrderedSongDataContext();

    void getOrderedSongList(boolean r100);

    String getRequiredSongInfo();

    Integer getSungOrderCount();

    int getWantSingSongThreshold();

    boolean inSelfDownloadMusicById(String r100);

    void initData();

    boolean isAudienceEnableSing();

    boolean isOnlyAcceptFollowerApply();

    void jumpToChorusRoom(MusicPanel r100);

    void moveOrderedSongToOtherRoom(long r100);

    void observeCurFavoriteMusic(LifecycleOwner r100, Observer<MusicPanel> r101);

    void observeCurOrderedMusic(LifecycleOwner r100, Observer<MusicPanel> r101);

    void observeMusicPlayerState(LifecycleOwner r100, Observer<Boolean> r101);

    void observeSecondLevelTabBanner(LifecycleOwner r100, Observer<Map<String, LabelBannerUrl>> r101);

    void observeSingUserChange(LifecycleOwner r100, boolean r101, Consumer<Boolean> r102);

    void observeSungOrderCount(LifecycleOwner r100, Observer<Integer> r101);

    void onDialogDismiss();

    void onDialogShow(int[] r100);

    void onItemClick(Context r100, MusicPanel r101, RecyclerView.ViewHolder r102);

    void onSearchEnter();

    void onSearchExit();

    void onSearchReset();

    void orderPlayAllSong(List<MusicPanel> r100, y r101);

    void permitWaitingSongUser(com.bytedance.android.live.ktv.common.model.bean.d r100, y r101);

    void pinMusic(MusicPanel r100);

    void postSyncSongListData(y r100);

    void postSyncTabListData(com.bytedance.android.live.ktv.common.karaokestation.model.d r100);

    void removeMusic(MusicPanel r100, boolean r101, Boolean r102);

    void removeWaitingSongUser(com.bytedance.android.live.ktv.common.model.bean.d r100, y r101);

    void removeWantSingSong(KtvMusic r100);

    void setForceUpdateBannerState(boolean r100);

    void sortSecondLevelTabByType(String r100, y r101);

    void stopWifiDownload();

    void syncHighScoreSongList(boolean r100);

    void syncMineWantSingSongList(boolean r100, Function1<? super Boolean, Unit> r101);

    void syncMultiChorusWaitingList(boolean r100, Function1<? super Boolean, Unit> r101);

    void syncSongWaitingList(boolean r100, Function1<? super Boolean, Unit> r101);

    void syncSungSongList(boolean r100, Function1<? super Boolean, Unit> r101);

    void syncWantListenSongList(boolean r100, Function1<? super Boolean, Unit> r101);

    void togglePause(boolean r100);

    void updateCurrentTabData();

    void updateMusicPanelState(MusicPanel r100);

    void updateOrderSongExtraInfo(td2.b r100);

    void updateRequiredSongInfo(String r100);
}
