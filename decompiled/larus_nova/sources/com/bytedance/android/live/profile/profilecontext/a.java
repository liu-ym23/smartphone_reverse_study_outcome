package com.bytedance.android.live.profile.profilecontext;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.WhiteCategoryCert;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.customview.ProfileNestedScrollView;
import com.bytedance.android.live.profile.event.EventHub;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.p004enum.ProfileMode;
import com.bytedance.android.live.profile.p004enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.base.m;
import com.bytedance.android.live.profile.ui.base.n;
import com.bytedance.android.live.profile.ui.util.DressType;
import com.bytedance.android.live.profile.usecase.NewProfileTrackUseCase;
import com.bytedance.android.live.profile.usecase.q;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements h, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f86124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f86125b;

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final void a(ProfileNestedScrollView.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f86125b.a(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final Integer b() {
        return this.f86125b.b();
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final Integer c() {
        return this.f86125b.c();
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final void d(ProfileNestedScrollView.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f86125b.d(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void dismiss() {
        this.f86124a.dismiss();
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final int e() {
        return this.f86125b.e();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void enterWaitFor(Observable<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "wait");
        this.f86124a.enterWaitFor(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final n findView(int r100) {
        return this.f86125b.findView(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final k getDressImageModelWithFallback(DressType r100) {
        Intrinsics.checkNotNullParameter(r100, "dressType");
        return this.f86124a.getDressImageModelWithFallback(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final com.bytedance.android.live.core.arch.mvvm.d<com.bytedance.android.live.profile.model.a> getEnterExitState() {
        return this.f86124a.getEnterExitState();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final EventHub getEventHub() {
        return this.f86124a.getEventHub();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final com.bytedance.android.live.core.arch.mvvm.d<sh6.b<NewProfileUser>> getFinalProfileUser() {
        return this.f86124a.getFinalProfileUser();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final String getFlashCardAsset() {
        return this.f86124a.getFlashCardAsset();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final com.bytedance.android.live.core.arch.mvvm.d<com.bytedance.android.live.profile.model.b> getLifecycleState() {
        return this.f86124a.getLifecycleState();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final NewProfileTrackUseCase getLogUseCase() {
        return this.f86124a.getLogUseCase();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final q getPageTypeUseCase() {
        return this.f86124a.getPageTypeUseCase();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final String getParallaxAsset() {
        return this.f86124a.getParallaxAsset();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final NewProfileUser getPreTargetUser() {
        return this.f86124a.getPreTargetUser();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final ProfileMode getProfileMode() {
        return this.f86124a.getProfileMode();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final ProfileMonitor getProfileMonitor() {
        return this.f86124a.getProfileMonitor();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final int getProfileWidth(Boolean r100) {
        return this.f86124a.getProfileWidth(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final ps0.b getRoom() {
        return this.f86124a.getRoom();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final DataCenter getRoomDataCenter() {
        return this.f86124a.getRoomDataCenter();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final IBaseUser getRoomUser() {
        return this.f86124a.getRoomUser();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final NewProfileUser getTargetUser() {
        return this.f86124a.getTargetUser();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final UserProfileEvent getUserProfileEvent() {
        return this.f86124a.getUserProfileEvent();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final boolean isMyLive() {
        return this.f86124a.isMyLive();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final boolean isPad() {
        return this.f86124a.isPad();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final boolean isVertical() {
        return this.f86124a.isVertical();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void logSubscribeVIPCardShow() {
        this.f86124a.logSubscribeVIPCardShow();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void recordBusinessClick(String r100, Map<? extends String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f86124a.recordBusinessClick(r100, r101);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void recordBusinessShow(TrackArea r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "area");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f86124a.recordBusinessShow(r100, r101);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void recordShowMap(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f86124a.recordShowMap(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void sendLog(String r100, Map<String, String> r101, Object... r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "logMap");
        Intrinsics.checkNotNullParameter(r102, "args");
        this.f86124a.sendLog(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void showFansClub(FragmentActivity r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter("mini_card", "from");
        this.f86124a.showFansClub(r100, "mini_card", r102);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void showKtvPanel(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f86124a.showKtvPanel(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void showSubscribePanel(FragmentActivity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f86124a.showSubscribePanel(r100, false);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public final void showWhiteCertPageNoLog(Context r100, WhiteCategoryCert.SubCertInfo r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f86124a.showWhiteCertPageNoLog(r100, r101);
    }

    public a(NewProfileInfoViewModel r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "profileContext");
        Intrinsics.checkNotNullParameter(r101, "viewProfileContext");
        this.f86124a = r100;
        this.f86125b = r101;
    }
}
