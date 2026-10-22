package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.message.model.MemberMessage;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.UnLoginFeatureUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/UserCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvlc/l;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserCompositeWidget extends MiddlewareRoomWidget implements vlc.l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f113266f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public User f113267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.c f113268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.a f113269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f113270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f113271e;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.UserCompositeWidget$onCreate$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserCompositeWidget f113272a;

        public AnonymousClass1(UserCompositeWidget r100) {
            this.f113272a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UserCompositeWidget r100 = this.f113272a;     // Catch: Throwable -> L10
            int r101 = UserCompositeWidget.f113266f;     // Catch: Throwable -> L10
            RoomContext r102 = (RoomContext) r100.getMiddlewareRoomContext();     // Catch: Throwable -> L10
            if (r102 == null) goto L13;
            com.bytedance.live.datacontext.j<com.bytedance.android.live.user.api.a> r103 = r102.getUserContext();     // Catch: Throwable -> L10
            if (r103 == null) goto L17;
            Disposable r104 = n32.a.a(r103, new C16741(this));     // Catch: Throwable -> L10
            if (r104 == null) goto L18;
            RxUtilKt.c(r104, this.f113272a.f113271e);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.UserCompositeWidget$onCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/k1;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lzg1/k1;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<zg1.k1, Unit> {
        public AnonymousClass3(UserCompositeWidget r100) {
            super(1, r100, UserCompositeWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/LiveLoginEvent;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(zg1.k1 r100) {
            UserCompositeWidget r101 = (UserCompositeWidget) this.receiver;
            int r102 = UserCompositeWidget.f113266f;
            IBaseUser r103 = null;
            Room r104 = null;
            if (r100 == null) goto L24;
            r101.getClass();
            if (r100.f571866a != true) goto L24;
            if (r101.f113270d == true) goto L24;
            UnLoginFeatureUtils r105 = UnLoginFeatureUtils.INSTANCE;
            com.bytedance.android.livesdk.chatroom.ui.framework.c r106 = r101.f113268b;
            if (r106 == null) goto L11;
            Room r107 = r106.getRoom();
        L13:
            if (r105.restartWhenLogin(r107) == false) goto L24;
            com.bytedance.android.livesdk.chatroom.ui.framework.c r108 = r101.f113268b;
            if (r108 == null) goto L17;
            Bundle r109 = r108.Wl();
        L18:
            com.bytedance.android.livesdk.chatroom.ui.framework.c r110 = r101.f113268b;
            if (r110 == null) goto L21;
            r104 = r110.getRoom();
        L21:
            if (r109 == null) goto L38;
            if (r104 == null) goto L39;
            r109.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_REENTER_ROOM, true);
            r109.putBoolean("finish_current_activity", true);
            TTLiveSDK.hostService().action().startLive(r101.getContext(), r104.f162599id, r109);
            return;
        L39:
            return;
        L38:
            return;
        L17:
            r109 = null;
            goto L18
        L11:
            r107 = null;
        L24:
            r101.dataCenter.put("data_login_event", r100);
            if (r100 == null) goto L27;
            r103 = r100.f571867b;
        L27:
            if (r103 == null) goto L41;
            StringBuilder r111 = new StringBuilder("loginInRoom, ");
            String r112 = "succ: ";
            if (r100.f571866a == false) goto L31;
            String r113 = "succ: ";
        L32:
            r111.append(r113);
            r111.append(r100.f571867b.getIdString());
            ALogger.d("UserCompositeWidget", r111.toString());
            xs2.b r114 = xs2.b.a();
            if (r100.f571866a == true) goto L36;
            r112 = "fail: " + r100.f571867b.getIdString();
        L36:
            r114.post(new zg1.h("login", r112));
            return;
        L31:
            r113 = "fail: ";
            goto L32
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(zg1.k1 r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public UserCompositeWidget() {
        this.f113271e = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.f113268b = ho1.a.d(getComponentContext());
        this.f113269c = ho1.a.c(getComponentContext());
        this.f113270d = ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h().isLogin();
        int r100 = com.bytedance.android.live.room.y.f100451a;
        com.bytedance.android.live.room.y.a(this.dataCenter, this.f113271e, "UserCompositeWidget", new AnonymousClass1(this));
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L7;
        vlc.d r102 = (vlc.d) r101.get("data_message_manager", null);
        if (r102 == null) goto L7;
        r102.addMessageListener(MessageType.MEMBER.getIntType(), this);
    L7:
        L7(zg1.k1.class, new AnonymousClass4.a(new AnonymousClass3(this)));
        com.bytedance.android.livesdk.chatroom.ui.framework.a r103 = this.f113269c;
        if (r103 == null) goto L15;
        PropertyOwner r104 = r103.getLoadState();
        if (r104 == null) goto L16;
        Disposable r105 = com.bytedance.android.livesdk.chatroom.ui.framework.b.f(r104, new AnonymousClass4(this));
        if (r105 == null) goto L17;
        RxUtilKt.c(r105, this.f113271e);
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.f113271e.dispose();
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L7;
        vlc.d r101 = (vlc.d) r100.get("data_message_manager", null);
        if (r101 == null) goto L7;
        r101.removeMessageListener(this);
    L7:
        this.f113268b = null;
        this.f113267a = null;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof MemberMessage) == false) goto L23;
        MemberMessage r101 = (MemberMessage) r100;
        if (r101.getAction() != 6) goto L25;
        DataCenter r102 = this.dataCenter;
        if (r102 == null) goto L24;
        Room r103 = com.bytedance.android.live.core.utils.z.o(r102);
        if (r103 != null) goto L13;
        return;
    L13:
        if (r101.isCurrentRoom(r103.f162599id) == false) goto L27;
        User r104 = r101.getUser();
        if (r104 == null) goto L28;
        com.bytedance.android.live.base.model.user.o0.a r105 = com.bytedance.android.live.base.model.user.o0.f58946a;
        String r106 = r104.getIdStr();
        String r107 = ((com.bytedance.android.livesdk.user.f0) ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h()).n();
        r105.getClass();
        if (com.bytedance.android.live.base.model.user.o0.a.a(r106, r107) == false) goto L29;
        this.dataCenter.put("data_interact_number_dot_show", "");
        this.dataCenter.put("data_audio_talk_dot_with_number_show", "");
        this.dataCenter.put("data_video_talk_dot_with_number_show", "");
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L24:
        return;
    L25:
        return;
    }

    public final void wq(String r100) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r101 = this.f113268b;
        if (r101 == null) goto L5;
        boolean r102 = r101.dg();
    L6:
        if (r102 == false) goto L13;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r103 = this.f113268b;
        if (r103 == null) goto L14;
        nz.r r104 = ho1.b.a(r103);
        if (r104 == null) goto L15;
        r104.d();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final <T> void L7(Class<T> r100, Consumer<T> r101) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r100).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r101);
    }
}
