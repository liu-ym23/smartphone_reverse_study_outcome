package com.bytedance.android.live.liveinteract.plantform.base;

import android.content.DialogInterface;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.paid.profilecard.PaidProfileCardWidget;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.Widget;
import com.google.gson.JsonObject;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public interface g {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final PublishSubject<g> f75491m0 = null;

    void Cj(String r100);

    void Hm(String r100);

    void I1(int r100, boolean r101);

    void Ik(boolean r100);

    void K7(String r100);

    void Lp(boolean r100);

    void Nf();

    void Sc();

    boolean Sd();

    BehaviorSubject<Boolean> U4();

    boolean W1();

    void Zc(int r100, String r101);

    void Zl(int r100);

    void a5(int r100, boolean r101);

    void d9(int r100);

    Widget em();

    void fastMatchJump(long r100, String r101, String r102);

    int getCurrentMode();

    i<ILinkPlayerInfoBridge> getLinkUserInfoCenter();

    void getUserWaitingInfo(String r100, int r101, i.c r102);

    void handleInteractClick();

    void id(int r100, String r101);

    void initAndTurnOnChorusKTV();

    void initAndTurnOnKTV();

    void initAndTurnOnRadioLinkmicRoom(Runnable r100, Runnable r101);

    void initAndTurnOnVideoLinkmicRoom(Runnable r100, Runnable r101, int r102, int r103, String r104);

    void initAndTurnOnVoiceChatRoom();

    boolean isMicRoomHost(String r100);

    View j();

    boolean j7();

    boolean k0(int r100);

    void ld(int r100, int r101, int r102, String r103);

    void mq(Disposable r100);

    void multiAnchorLoadVideoTalk();

    void multiAnchorUnloadVideoTalk();

    void nb(int r100);

    boolean nd();

    void o6(String r100, boolean r101);

    void oa(String r100, int r101, int r102, DialogInterface.OnDismissListener r103);

    void permitPrepareApply(long r100, String r101);

    void pkInviteFailLoadWidget();

    void pkInviteUnloadWidget();

    void prepareApply(String r100);

    void prepareInvite(long r100, IBaseUser r101, String r102);

    void s4();

    boolean s8();

    void ua(long r100, String r101, int r102, String r103);

    void uo();

    void updateLinkMicStatus(ih0.f r100, ih0.h r101, IJsBridgeManager r102);

    void updateViewInLiveBg(String r100, JsonObject r101, ih0.h r102);

    void v7(boolean r100, int r101, int r102, String r103);

    void xh(PaidProfileCardWidget r100);

    com.bytedance.android.live.ui.c y4();

    void y6(boolean r100, int r101, int r102, int r103, String r104, int r105);

    void ye();

    void yg(int r100, int r101, List<Integer> r102);

    static {
        f75491m0 = PublishSubject.create();
    }
}
