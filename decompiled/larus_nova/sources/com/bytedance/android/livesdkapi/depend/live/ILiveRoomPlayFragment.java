package com.bytedance.android.livesdkapi.depend.live;

import android.graphics.Bitmap;
import android.os.Bundle;
import as0.a;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdkapi.depend.live.vs.listener.IVsVideoListManager;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.android.livesdkapi.feed.DrawOperate;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mz.b;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveRoomPlayFragment extends IMiddlewareLiveRoomPlayFragment, ILiveRoomPlayFragmentConstant, ILiveRoomPlayFragmentForSaas {
    public static final int REPLAY_ITEM = 23;

    public interface CaptureBitmapListener {
        Bitmap onCaptureBitmap();
    }

    public interface LiveRoomListener extends IVsVideoListManager {
        void canViewPagerScroll(boolean r100);

        void disableViewPagerCache();

        boolean dislike(Room r100, boolean r101);

        void dislikeOrFollow(Room r100, boolean r101, String r102, boolean r103);

        boolean dislikeOrHideScreen(Room r100, boolean r101);

        void douyinDislike(Room r100, boolean r101, Long r102, Long r103);

        void enableViewPagerCache(long r100, String r101);

        int getCurrentScrollState();

        void hideAllTips();

        void insertFeedItem(FeedItem r100, Room r101, Bundle r102, Long r103);

        void insertFeedItem(FeedItem r100, Room r101, Bundle r102, Long r103, int r104, Function1<Boolean, Unit> r105);

        boolean isLiveRoomFragment();

        void jump2Other(JumpToOtherRoomEvent r100);

        void leave4Profile(String r100);

        void onInputStateChange(boolean r100);

        void onInteractionLayerShow(Room r100);

        @Override // com.bytedance.android.livesdkapi.depend.live.vs.listener.IVsVideoListManager
        boolean onInterceptBackRoom();

        boolean onInterceptUserClose();

        @Override // com.bytedance.android.livesdkapi.depend.live.vs.listener.IVsVideoListManager
        void playNext(boolean r100);

        void playPreview();

        void removeFeedItem(FeedItem r100);

        void removeRoom(long r100);

        void showClearScreenTips();
    }

    void addDoChangePageDelayTime(long r100);

    void attachSurfaceView();

    void detachSurfaceView();

    void ensureMute(boolean r100);

    void enterWormhole(boolean r100);

    void exitWormhole();

    void forceSmoothExit();

    LiveRoomState getCurState();

    b getExplicitInfo();

    LiveRoomListener getLiveRoomListener();

    double getPullStreamAvg();

    ILiveRoomPlayFragment getRealAction();

    LiveMode getStreamType();

    void goneOnPageSelected(int r100);

    void initLogger(Bundle r100);

    void injectOperateRecorder(DrawOperate r100);

    boolean isAllWidgetLoaded();

    boolean isInWormhole();

    boolean isP1WidgetLoaded();

    boolean isP2WidgetLoaded();

    boolean isRoomEnd();

    boolean isSmoothLeaveDoubleRenderSurface();

    void mutePlayerClient(boolean r100);

    void notifyToolbarWidgetClearData();

    boolean onBackPressed();

    void onOuterPageScrollStateChanged(int r100);

    void onPageScrollStateChanged(int r100);

    void onPageSelected(int r100, ILiveRoomPlayFragment r101);

    void onScrolling();

    void onSelected(boolean r100);

    void onSlide();

    void onUserLeaveHint();

    ILiveRoomPageFragment parentPage();

    void playerPreload();

    void preBackendRoom();

    void preEnterRoom();

    void preInitLandscapeRoomUIContext();

    void prePlaySwitchRes();

    void preRequestRoomEnter();

    void resetSmoothDoubleRenderSurface();

    /* synthetic */ a roomPlayerContext();

    void scrollEnd(boolean r100);

    void setLinkShareInviteId(String r100, String r101, long r102);

    void setLiveRoomListener(LiveRoomListener r100);

    void setRefreshStatusObservable(PublishSubject<Boolean> r100);

    void setScrollStatusObservable(PublishSubject<Boolean> r100);

    void setUserVisibleHint(boolean r100);

    void showPlayerBackground(String r100);

    void startRoom();

    void stopInteractionLoad();

    void stopPlayerForNextRoomPrePullStream();

    void stopRoom(String r100);

    void stopRoomWithoutReleasePlayer(boolean r100);

    void tryPauseStream(String r100);

    void updateCurrentController();

    void updateEnterRoomMonitor();

    void updateRoomSession(long r100);

    void updateStartTimeForLog(long r100);

    void wormholeNoStreamCheck();
}
