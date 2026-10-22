package com.bytedance.android.livesdkapi.depend.live;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.distribution.ExternalRoomExitReason;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.LiveExternalConfig;
import com.bytedance.android.livesdkapi.feed.IMultiTabProviderCallback;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveRoomPageFragment extends ILiveRoomPageFragmentConstant, ILiveRoomPageFragmentForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$createExternalConfigJudger(ILiveRoomPageFragment r100, String r101, LiveExternalConfig r102) {
        }

        public static void $default$deleteRoomFromList(ILiveRoomPageFragment r100, Room r101) {
        }

        public static IExternalConfigJudger $default$getExternalConfigJudger(ILiveRoomPageFragment r100) {
            return null;
        }

        public static void $default$initLogger(ILiveRoomPageFragment r100) {
        }

        public static boolean $default$invokeBackPress(ILiveRoomPageFragment r100) {
            return false;
        }

        public static void $default$onOuterPageScrollStateChanged(ILiveRoomPageFragment r100, int r101) {
        }

        public static void $default$prePrepare(ILiveRoomPageFragment r100, String r101) {
        }

        public static void $default$prePullStream(ILiveRoomPageFragment r100, boolean r101, String r102) {
        }

        public static void $default$removeCurrentRoom(ILiveRoomPageFragment r100, long r101, ExternalRoomExitReason r102) {
        }

        public static void $default$setCurrentPosition(ILiveRoomPageFragment r100, String r101, int r102, ExternalRoomExitReason r103) {
        }

        public static void $default$setRoomListProvider(ILiveRoomPageFragment r100, IMultiTabProviderCallback r101) {
        }

        public static void $default$stopPrePullStream(ILiveRoomPageFragment r100) {
        }

        public static void $default$updateStartTimeForLog(ILiveRoomPageFragment r100, long r101) {
        }

        public static IRelateLiveInsertPresenter $default$getRelateLiveInsertPresenter(final ILiveRoomPageFragment r100) {
            return new AnonymousClass1(r100);
        }
    }

    public static class Default implements ILiveRoomPageFragment {
        public Default() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public final /* synthetic */ void createExternalConfigJudger(String r100, LiveExternalConfig r101) {
            CC.$default$createExternalConfigJudger(this, r100, r101);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public final /* synthetic */ void deleteRoomFromList(Room r100) {
            CC.$default$deleteRoomFromList(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public void forceSmoothExit() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public ILiveRoomPlayFragment getCurrentFragment() {
            return null;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public int getCurrentPosition() {
            return 0;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public final /* synthetic */ IExternalConfigJudger getExternalConfigJudger() {
            return CC.$default$getExternalConfigJudger(this);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public ILiveRoomPageFragment getRealAction() {
            return this;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public String getRoomSetTag() {
            return "";
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public final /* synthetic */ void initLogger() {
            CC.$default$initLogger(this);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public final /* synthetic */ boolean invokeBackPress() {
            return CC.$default$invokeBackPress(this);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public boolean isNestedOutside() {
            return false;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public boolean isSmoothEnter() {
            return false;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public void notifyDataSetChange() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public final /* synthetic */ void onOuterPageScrollStateChanged(int r100) {
            CC.$default$onOuterPageScrollStateChanged(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public void onUserLeaveHint() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public final /* synthetic */ void prePrepare(String r100) {
            CC.$default$prePrepare(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public final /* synthetic */ void prePullStream(boolean r100, String r101) {
            CC.$default$prePullStream(this, r100, r101);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragmentForSaas
        public final /* synthetic */ IPreviewController previewController() {
            return ILiveRoomPageFragmentForSaas.CC.$default$previewController(this);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public final /* synthetic */ void removeCurrentRoom(long r100, ExternalRoomExitReason r101) {
            CC.$default$removeCurrentRoom(this, r100, r101);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public IRoomAction roomAction() {
            return null;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public IRoomEventListener roomEventListener() {
            return null;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public void saveBackRoomInfo(Bundle r100, Bundle r101) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragmentForSaas
        public final /* synthetic */ void saveBackRoomInfo(String r100) {
            ILiveRoomPageFragmentForSaas.CC.$default$saveBackRoomInfo(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragmentForSaas
        public final /* synthetic */ void saveBackRoomInfo(String r100, Bundle r101) {
            ILiveRoomPageFragmentForSaas.CC.$default$saveBackRoomInfo(this, r100, r101);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public Fragment self() {
            return null;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public final /* synthetic */ void setCurrentPosition(String r100, int r101, ExternalRoomExitReason r102) {
            CC.$default$setCurrentPosition(this, r100, r101, r102);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public void setNestedOutside(boolean r100) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public void setRoomAction(IRoomAction r100) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public void setRoomEventListener(IRoomEventListener r100) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public final /* synthetic */ void setRoomListProvider(IMultiTabProviderCallback r100) {
            CC.$default$setRoomListProvider(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public void startRoom(String r100) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public final /* synthetic */ void stopPrePullStream() {
            CC.$default$stopPrePullStream(this);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragmentForSaas
        public final /* synthetic */ void stopRoom() {
            ILiveRoomPageFragmentForSaas.CC.$default$stopRoom(this);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public void stopRoom(String r100) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public void updateRoomSession(long r100) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public void updateStartTimeForLog(long r100) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
        public IRelateLiveInsertPresenter getRelateLiveInsertPresenter() {
            return new AnonymousClass1(this);
        }
    }

    void createExternalConfigJudger(String r100, LiveExternalConfig r101);

    void deleteRoomFromList(Room r100);

    void forceSmoothExit();

    ILiveRoomPlayFragment getCurrentFragment();

    int getCurrentPosition();

    IExternalConfigJudger getExternalConfigJudger();

    ILiveRoomPageFragment getRealAction();

    IRelateLiveInsertPresenter getRelateLiveInsertPresenter();

    String getRoomSetTag();

    void initLogger();

    boolean invokeBackPress();

    boolean isNestedOutside();

    boolean isSmoothEnter();

    void notifyDataSetChange();

    void onOuterPageScrollStateChanged(int r100);

    void onUserLeaveHint();

    void prePrepare(String r100);

    void prePullStream(boolean r100, String r101);

    void removeCurrentRoom(long r100, ExternalRoomExitReason r101);

    IRoomAction roomAction();

    IRoomEventListener roomEventListener();

    void saveBackRoomInfo(Bundle r100, Bundle r101);

    Fragment self();

    void setCurrentPosition(String r100, int r101, ExternalRoomExitReason r102);

    void setNestedOutside(boolean r100);

    void setRoomAction(IRoomAction r100);

    void setRoomEventListener(IRoomEventListener r100);

    void setRoomListProvider(IMultiTabProviderCallback r100);

    void startRoom(String r100);

    void stopPrePullStream();

    void stopRoom(String r100);

    void updateRoomSession(long r100);

    void updateStartTimeForLog(long r100);
}
