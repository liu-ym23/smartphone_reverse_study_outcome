package com.bytedance.android.live.profile.ui.base;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.WhiteCategoryCert;
import com.bytedance.android.live.profile.event.EventHub;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.p004enum.ProfileMode;
import com.bytedance.android.live.profile.p004enum.TrackArea;
import com.bytedance.android.live.profile.ui.util.DressType;
import com.bytedance.android.live.profile.usecase.NewProfileTrackUseCase;
import com.bytedance.android.live.profile.usecase.q;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public interface h {
    void dismiss();

    void enterWaitFor(Observable<Object> r100);

    py.k getDressImageModelWithFallback(DressType r100);

    com.bytedance.android.live.core.arch.mvvm.d<com.bytedance.android.live.profile.model.a> getEnterExitState();

    EventHub getEventHub();

    com.bytedance.android.live.core.arch.mvvm.d<sh6.b<NewProfileUser>> getFinalProfileUser();

    String getFlashCardAsset();

    com.bytedance.android.live.core.arch.mvvm.d<com.bytedance.android.live.profile.model.b> getLifecycleState();

    NewProfileTrackUseCase getLogUseCase();

    q getPageTypeUseCase();

    String getParallaxAsset();

    NewProfileUser getPreTargetUser();

    ProfileMode getProfileMode();

    ProfileMonitor getProfileMonitor();

    int getProfileWidth(Boolean r100);

    ps0.b getRoom();

    DataCenter getRoomDataCenter();

    IBaseUser getRoomUser();

    NewProfileUser getTargetUser();

    UserProfileEvent getUserProfileEvent();

    boolean isMyLive();

    boolean isPad();

    boolean isVertical();

    void logSubscribeVIPCardShow();

    void recordBusinessClick(String r100, Map<? extends String, String> r101);

    void recordBusinessShow(TrackArea r100, String r101);

    void recordShowMap(Map<String, String> r100);

    void sendLog(String r100, Map<String, String> r101, Object... r102);

    void showFansClub(FragmentActivity r100, String r101, boolean r102);

    void showKtvPanel(FragmentActivity r100);

    void showSubscribePanel(FragmentActivity r100, boolean r101);

    void showWhiteCertPageNoLog(Context r100, WhiteCategoryCert.SubCertInfo r101);
}
