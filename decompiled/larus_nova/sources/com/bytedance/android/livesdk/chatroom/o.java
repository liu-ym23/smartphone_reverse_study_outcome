package com.bytedance.android.livesdk.chatroom;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.config.ge1;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdkapi.depend.live.vs.listener.IVsVideoListManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface o {
    com.bytedance.live.datacontext.m<Boolean> A1();

    com.bytedance.live.datacontext.j<DataCenter> A2();

    com.bytedance.live.datacontext.m<MutableLiveData<Boolean>> B1();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.widget.schedule.c> B2();

    com.bytedance.live.datacontext.m<Map<String, String>> C1();

    com.bytedance.live.datacontext.n<Integer> C2();

    com.bytedance.live.datacontext.m<Boolean> D1();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.service.monitor.d> D2();

    com.bytedance.live.datacontext.j<yt1.n> E1();

    com.bytedance.live.datacontext.m<Boolean> E2();

    com.bytedance.live.datacontext.k<Boolean> F1();

    Map<String, String> F2();

    com.bytedance.live.datacontext.j<zt1.c> G1();

    com.bytedance.live.datacontext.m<zg1.x0> G2();

    com.bytedance.live.datacontext.m<Boolean> H1();

    boolean H2();

    com.bytedance.live.datacontext.m<Boolean> I1();

    com.bytedance.live.datacontext.m<Long> I2();

    String J1();

    Completable J2();

    com.bytedance.live.datacontext.j<vlc.d> K1();

    com.bytedance.live.datacontext.m<String> K2();

    RoomContext L1();

    com.bytedance.live.datacontext.j<ViewModel> L2();

    com.bytedance.live.datacontext.j<ViewModel> M1();

    void M2(Boolean r100);

    void N1();

    com.bytedance.live.datacontext.m<Boolean> N2();

    List O1(byte[] r100, long r101);

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.widget.i0> O2();

    com.bytedance.live.datacontext.m<Boolean> P1();

    Boolean P2();

    com.bytedance.live.datacontext.n<WeakReference<ViewGroup>> Q1();

    Class<?> Q2();

    LinkedList<BusinessConfigure> R1();

    com.bytedance.live.datacontext.m<Boolean> R2();

    Room S1();

    com.bytedance.live.datacontext.n<Rect> T1();

    com.bytedance.live.datacontext.m<Integer> U1();

    ILivePlayerClient V1();

    com.bytedance.live.datacontext.m<Boolean> W1();

    com.bytedance.live.datacontext.m<Boolean> X1();

    com.bytedance.live.datacontext.m<String> Y1();

    com.bytedance.live.datacontext.n<lh1.b> Z1();

    Long a();

    com.bytedance.live.datacontext.j<l> a2();

    com.bytedance.live.datacontext.n<com.bytedance.android.live.base.model.live.a> b2();

    com.bytedance.live.datacontext.m<Boolean> c2();

    com.bytedance.live.datacontext.n<ge1> d2();

    com.bytedance.live.datacontext.m<Boolean> e2();

    com.bytedance.live.datacontext.n<RoomPermissionContext> f2();

    com.bytedance.live.datacontext.m<List<IBaseUser>> g2();

    com.bytedance.live.datacontext.m<Long> getCameraId();

    com.bytedance.live.datacontext.m<Integer> getCleanMode();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m> getCompactTbLoader();

    com.bytedance.live.datacontext.i<CompositeDisposable> getCompositeDisposable();

    Room getCurrentRoom();

    DataCenter getDataCenter();

    com.bytedance.live.datacontext.m<Map<String, String>> getEnterRoomParams();

    com.bytedance.live.datacontext.n<IRoom> getInteractionDataPrepared();

    com.bytedance.live.datacontext.i<LiveMode> getLiveMode();

    com.bytedance.live.datacontext.j<com.bytedance.android.live.pushstream.d> getLiveStream();

    com.bytedance.live.datacontext.j<vlc.d> getMessageManager();

    com.bytedance.live.datacontext.j<ViewModel> getMultiCameraContext();

    com.bytedance.live.datacontext.n<bn0.b> getMultiLinkRoomScope();

    com.bytedance.live.datacontext.n<PadOrientation> getPadOrientation();

    com.bytedance.live.datacontext.m<IRoom> getRoom();

    com.bytedance.live.datacontext.m<z0> getSeiTimePair();

    com.bytedance.live.datacontext.n<z70.b> getTemplateContext();

    User getUser();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> getVideoTalkRoomSubScene();

    float getVsVerticalProgressBarHeight();

    boolean h2();

    com.bytedance.live.datacontext.m<List<IBaseUser>> i2();

    Boolean isAnchor();

    com.bytedance.live.datacontext.m<Boolean> isCleanMode();

    Boolean isMatchRoom();

    boolean isMediaRoom();

    Boolean isMultiPkState();

    Boolean isPortraitInteraction();

    boolean isVSFirstShow();

    boolean isVSLive();

    Boolean isVSRoom();

    Boolean isVSVerticalStream();

    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p j2();

    com.bytedance.live.datacontext.m<Long> k2();

    com.bytedance.live.datacontext.m<Boolean> l2();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.widget.m0> m2();

    com.bytedance.live.datacontext.m<Boolean> n2();

    Room o2();

    JsonElement p2();

    com.bytedance.live.datacontext.m<Long> q2();

    com.bytedance.live.datacontext.j<IDynamicStrategyContext> r2();

    com.bytedance.live.datacontext.j<com.bytedance.android.live.broadcast.api.model.z0> s2();

    com.bytedance.live.datacontext.j<ViewModel> t2();

    com.bytedance.live.datacontext.j<IVsVideoListManager> u1();

    com.bytedance.live.datacontext.m<Map<String, String>> u2();

    com.bytedance.live.datacontext.m<Boolean> v1();

    com.bytedance.live.datacontext.m<Integer> v2();

    com.bytedance.live.datacontext.j<ylc.e> w1();

    com.bytedance.live.datacontext.m<Boolean> w2();

    com.bytedance.live.datacontext.m<Boolean> x1();

    com.bytedance.live.datacontext.j<ViewModel> x2();

    com.bytedance.live.datacontext.m<Boolean> y1();

    com.bytedance.live.datacontext.m<Boolean> y2();

    com.bytedance.live.datacontext.m<Boolean> z1();

    com.bytedance.live.datacontext.j<com.bytedance.live.kmp.core.a> z2();
}
