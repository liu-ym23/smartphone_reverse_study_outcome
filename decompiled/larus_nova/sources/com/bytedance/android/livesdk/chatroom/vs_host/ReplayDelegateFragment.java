package com.bytedance.android.livesdk.chatroom.vs_host;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.livesdk.chatroom.backroom.LiveBackRoomStackManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragmentForSaas;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.live.IPreviewController;
import com.bytedance.android.livesdkapi.depend.live.IRelateLiveInsertPresenter;
import com.bytedance.android.livesdkapi.depend.live.IRoomAction;
import com.bytedance.android.livesdkapi.depend.live.IRoomEventListener;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.distribution.ExternalRoomExitReason;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.LiveExternalConfig;
import com.bytedance.android.livesdkapi.feed.IMultiTabProviderCallback;
import com.bytedance.android.livesdkapi.view.IBackPress;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import j40.j2;
import jm1.d;
import jm1.e;
import jm1.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_host/ReplayDelegateFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRoomPageFragment;", "Lcom/bytedance/android/livesdkapi/view/IBackPress;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-host_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayDelegateFragment extends BaseFragment implements ILiveRoomPageFragment, IBackPress {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f118253e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f118254d;

    public static final class a {
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IRoomAction f118255a;

        @Override // jm1.d
        public final void exitRoom() {
            this.f118255a.exitRoom();
        }

        @Override // jm1.d
        public final boolean interceptRoomClose() {
            return this.f118255a.interceptRoomClose();
        }

        public b(IRoomAction r100) {
            this.f118255a = r100;
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IRoomEventListener f118256a;

        @Override // jm1.e
        public final void onFirsFrame() {
            this.f118256a.onFirsFrame();
        }

        @Override // jm1.e
        public final void onNotSmoothLeave() {
            this.f118256a.onNotSmoothLeave();
        }

        @Override // jm1.e
        public final void onSmoothLeaveRoom() {
            this.f118256a.onSmoothLeaveRoom();
        }

        public c(IRoomEventListener r100) {
            this.f118256a = r100;
        }

        @Override // jm1.e
        public final void a(IRoom r100) {
            IRoomEventListener r101 = this.f118256a;
            if ((r100 instanceof Room) == false) goto L5;
            Room r102 = (Room) r100;
        L6:
            r101.onEnterRoom(r102);
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // jm1.e
        public final void onConfigurationChanged(Configuration r100) {
            this.f118256a.onConfigurationChanged(r100);
        }

        @Override // jm1.e
        public final void onDislikeItem(long r100) {
            this.f118256a.onDislikeItem(r100);
        }

        @Override // jm1.e
        public final void onLiveEnd(View r100, View r101) {
            this.f118256a.onLiveEnd(r100, r101);
        }

        @Override // jm1.e
        public final void onMaskLayerChanged(String r100, boolean r101) {
            this.f118256a.onMaskLayerChanged(r100, r101);
        }

        @Override // jm1.e
        public final void onInteractionViewsAdapt(boolean r100, View r101, View r102, View r110, View r111) {
            this.f118256a.onInteractionViewsAdapt(r100, r101, r102, r110, r111);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ void createExternalConfigJudger(String r100, LiveExternalConfig r101) {
        ILiveRoomPageFragment.CC.$default$createExternalConfigJudger(this, r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ void deleteRoomFromList(Room r100) {
        ILiveRoomPageFragment.CC.$default$deleteRoomFromList(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final void forceSmoothExit() {
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final ILiveRoomPlayFragment getCurrentFragment() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final int getCurrentPosition() {
        return -1;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ IExternalConfigJudger getExternalConfigJudger() {
        return ILiveRoomPageFragment.CC.$default$getExternalConfigJudger(this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final ILiveRoomPageFragment getRealAction() {
        return this;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ IRelateLiveInsertPresenter getRelateLiveInsertPresenter() {
        return ILiveRoomPageFragment.CC.$default$getRelateLiveInsertPresenter(this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final String getRoomSetTag() {
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ void initLogger() {
        ILiveRoomPageFragment.CC.$default$initLogger(this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ boolean invokeBackPress() {
        return ILiveRoomPageFragment.CC.$default$invokeBackPress(this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final boolean isSmoothEnter() {
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final void notifyDataSetChange() {
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ void onOuterPageScrollStateChanged(int r100) {
        ILiveRoomPageFragment.CC.$default$onOuterPageScrollStateChanged(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final void onUserLeaveHint() {
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ void prePrepare(String r100) {
        ILiveRoomPageFragment.CC.$default$prePrepare(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ void prePullStream(boolean r100, String r101) {
        ILiveRoomPageFragment.CC.$default$prePullStream(this, r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragmentForSaas
    public final /* synthetic */ IPreviewController previewController() {
        return ILiveRoomPageFragmentForSaas.CC.$default$previewController(this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ void removeCurrentRoom(long r100, ExternalRoomExitReason r101) {
        ILiveRoomPageFragment.CC.$default$removeCurrentRoom(this, r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final void saveBackRoomInfo(Bundle r100, Bundle r101) {
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
    public final Fragment self() {
        return this;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ void setCurrentPosition(String r100, int r101, ExternalRoomExitReason r102) {
        ILiveRoomPageFragment.CC.$default$setCurrentPosition(this, r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ void setRoomListProvider(IMultiTabProviderCallback r100) {
        ILiveRoomPageFragment.CC.$default$setRoomListProvider(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ void stopPrePullStream() {
        ILiveRoomPageFragment.CC.$default$stopPrePullStream(this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragmentForSaas
    public final /* synthetic */ void stopRoom() {
        ILiveRoomPageFragmentForSaas.CC.$default$stopRoom(this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final void updateRoomSession(long r100) {
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final /* synthetic */ void updateStartTimeForLog(long r100) {
        ILiveRoomPageFragment.CC.$default$updateStartTimeForLog(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final boolean isNestedOutside() {
        f r100 = this.f118254d;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isNestedOutside() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.view.IBackPress
    public final boolean onBackPressed() {
        f r100 = this.f118254d;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.onBackPressed() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.view.IBackPress
    public final void onScrollAway() {
        f r100 = this.f118254d;
        if (r100 == null) goto L6;
        r100.onScrollAway();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final IRoomAction roomAction() {
        f r100 = this.f118254d;
        d r101 = null;
        if (r100 == null) goto L5;
        d r102 = r100.roomAction();
    L6:
        if (r102 == null) goto L12;
        f r103 = this.f118254d;
        if (r103 == null) goto L11;
        r101 = r103.roomAction();
    L11:
        return new IRoomAction.ReplayDelegate(r101);
    L12:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final IRoomEventListener roomEventListener() {
        f r100 = this.f118254d;
        e r101 = null;
        if (r100 == null) goto L5;
        e r102 = r100.roomEventListener();
    L6:
        if (r102 == null) goto L12;
        f r103 = this.f118254d;
        if (r103 == null) goto L11;
        r101 = r103.roomEventListener();
    L11:
        return new IRoomEventListener.ReplayDelegate(r101);
    L12:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    public ReplayDelegateFragment() {
        if (getArguments() != null) goto L6;
        setArguments(new Bundle());
        Unit r100 = Unit.INSTANCE;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        f r101 = this.f118254d;
        if (r101 == null) goto L17;
        Fragment r102 = r101.self();
        if (r102 == null) goto L18;
        Bundle r103 = getArguments();
        if (r103 == null) goto L11;
        Bundle r104 = r102.getArguments();
        if (r104 == null) goto L11;
        r104.putAll(r103);
    L11:
        FragmentTransaction r105 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r105, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "ReplayPlayFragment", R.id.play_fragment_container) == true) goto L15;
        r105 = r105.add(R.id.play_fragment_container, r102, "ReplayPlayFragment");
    L15:
        r105.commitNowAllowingStateLoss();
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final void setNestedOutside(boolean r100) {
        f r101 = this.f118254d;
        if (r101 == null) goto L6;
        r101.setNestedOutside(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final void setRoomAction(IRoomAction r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        f r101 = this.f118254d;
        if (r101 == null) goto L8;
        r101.TC(new b(r100));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final void setRoomEventListener(IRoomEventListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        f r101 = this.f118254d;
        if (r101 == null) goto L8;
        r101.Ad(new c(r100));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final void startRoom(String r100) {
        f r101 = this.f118254d;
        if (r101 == null) goto L6;
        r101.startRoom(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment
    public final void stopRoom(String r100) {
        f r101 = this.f118254d;
        if (r101 == null) goto L6;
        r101.stopRoom();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (j2.f497245a.getValue().booleanValue() == false) goto L6;
        LiveBackRoomStackManager.c().clear();
    L6:
        return r100.inflate(R.layout.ttlive_fragment_replay_room, r101, false);
    }
}
