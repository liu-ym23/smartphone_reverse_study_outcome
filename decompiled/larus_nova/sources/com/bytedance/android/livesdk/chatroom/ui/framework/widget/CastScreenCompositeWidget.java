package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.livesdk.castscreen.bytecast.LiveByteCastManager;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;
import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.android.livesdk.castscreen.views.bytecast.LiveCastControlLayout;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.pj;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/CastScreenCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CastScreenCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.c f113058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.d f113059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.a f113060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f113061d;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CastScreenCompositeWidget f113062a;

        public a(CastScreenCompositeWidget r100) {
            this.f113062a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            h80.c r101 = (h80.c) r100;
            MiddlewareRoomContext r102 = this.f113062a.getMiddlewareRoomContext();
            if ((r102 instanceof RoomContext) == true) goto L5;
            r102 = null;
        L5:
            RoomContext r103 = (RoomContext) r102;
            if (r103 != null) goto L8;
            return;
        L8:
            if (r103.isVSRoom() == false) goto L10;
            return;
        L10:
            if (((n.a) r101.a()).f113446b == true) goto L12;
            return;
        L12:
            if (((n.a) r101.a()).f113445a.orientation != 2) goto L18;
            xs2.b.a().post(new com.bytedance.android.livesdk.castscreen.utils.b(true));
            return;
        }
    }

    public final void wq() {
        boolean r100 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.dataCenter).isPaidLive();
        boolean r101 = xq();
        boolean r102 = VrUtils.c(this.dataCenter);
        if (r101 == true) goto L6;
        if (r100 == true) goto L6;
        return;
    L6:
        if (y3.f(this.dataCenter).n(ToolbarButton.CAST_SCREEN) == true) goto L21;
        if (r102 == true) goto L22;
        int r103 = com.bytedance.android.livesdk.castscreen.api.b.f104452a;
        Room r104 = com.bytedance.android.live.core.utils.z.o(this.dataCenter);
        DataContext r105 = this.dataContext;
        com.bytedance.android.livesdk.castscreen.views.bytecast.k r106 = null;
        if ((r105 instanceof RoomContext) == true) goto L11;
        r105 = null;
    L11:
        RoomContext r107 = (RoomContext) r105;
        Intrinsics.checkNotNullParameter(r104, "room");
        String r108 = LiveByteCastUIManager.f104549a;
        if (LiveByteCastUIManager.r() == false) goto L17;
        if (LiveByteCastManager.a() == false) goto L17;
        r106 = new com.bytedance.android.livesdk.castscreen.views.bytecast.k(null);
    L17:
        if ((r106 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == false) goto L23;
        y3.f(this.dataCenter).k(ToolbarButton.CAST_SCREEN, r106);
        return;
    L23:
        return;
    L22:
        return;
    }

    public final boolean xq() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L11;
        Room r101 = com.bytedance.android.live.core.utils.z.o(r100);
        if (r101 == null) goto L11;
        RoomAuthStatus r102 = r101.getRoomAuthStatus();
        if (r102 == null) goto L11;
        if (r102.getCastScreen() != 1) goto L11;
        return true;
    L11:
        return false;
    }

    public CastScreenCompositeWidget() {
        this.f113061d = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.f113058a = ho1.a.d(getComponentContext());
        this.f113059b = ho1.a.i(getComponentContext());
        this.f113060c = ho1.a.c(getComponentContext());
        com.bytedance.android.livesdk.chatroom.ui.framework.d r100 = this.f113059b;
        n r101 = null;
        if (r100 == null) goto L5;
        LiveCastControlLayout r102 = r100.Vo();
    L7:
        if ((r102 instanceof LiveCastControlLayout) == true) goto L9;
        r102 = null;
    L9:
        boolean r103 = false;
        if (r102 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r104 = this.f113058a;
        if (r104 == null) goto L15;
        boolean r105 = r104.o5();
    L16:
        if (r105 == false) goto L35;
        pj r106 = pj.f120984a;
        if (r106.getValue().booleanValue() == false) goto L21;
        r102.setEnable(r106.getValue().booleanValue());
    L21:
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r107 = CastScreenViewModel.a.a();
        if (r107 != null) goto L24;
    L26:
        r102.setVisibility(8);
    L27:
        if (r107 == null) goto L35;
        com.bytedance.live.datacontext.m<Boolean> r108 = r107.getCastOrMirrorScreenMode();
        if (r108 == null) goto L35;
        Observable<Boolean> r109 = r108.a();
        if (r109 == null) goto L35;
        Disposable r110 = r109.subscribe(new c(r102));
        if (r110 == null) goto L35;
        RxUtilKt.c(r110, this.f113061d);
        goto L35
    L24:
        if (r107.getCastOrMirrorScreenMode().getValue().booleanValue() == false) goto L26;
        r102.setVisibility(0);
        goto L27
    L15:
        r105 = false;
    L35:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r111 = this.f113058a;
        if (r111 == null) goto L38;
        r103 = r111.o5();
    L38:
        if (r103 == false) goto L74;
        DataCenter r112 = this.dataCenter;
        if (r112 == null) goto L74;
        Room r113 = com.bytedance.android.live.core.utils.z.o(r112);
        if (r113 == null) goto L74;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r114 = y3.i(this.dataCenter);
        int r115 = com.bytedance.android.livesdk.castscreen.api.b.f104452a;
        com.bytedance.android.livesdk.castscreen.api.a r116 = new com.bytedance.android.livesdk.castscreen.api.a();
        if (r113.isThirdParty() == true) goto L50;
        if (r113.isScreenshot() == true) goto L50;
    L52:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.dataCenter).e1(PaidSceneEnum.PAID_ROOM) == false) goto L74;
    L53:
        f r117 = new f(this);
        if (LiveByteCastManager.b() == true) goto L74;
        if (xq() == false) goto L74;
        Intrinsics.checkNotNull(r116);
        Intrinsics.checkNotNullParameter(r113, "room");
        if (LiveByteCastUIManager.r() == true) goto L60;
    L62:
        com.bytedance.android.livesdk.castscreen.views.bytecast.k r118 = null;
    L64:
        if ((r118 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) == false) goto L66;
        r114.k(ToolbarButton.GAME_CAST_SCREEN, r118);
    L66:
        lk1.c.a r119 = lk1.c.f509546i2;
        DataCenter r120 = this.dataCenter;
        r119.getClass();
        com.bytedance.android.live.core.arch.mvvm.d<mk1.a> r121 = lk1.c.a.a(r120).observeStatusChanged("room_auth_cast_screen");
        if (r121 == null) goto L71;
        Disposable r122 = r121.observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r118, r114));
        if (r122 == null) goto L71;
        this.f113061d.add(r122);
    L71:
        ILiveExpOptService r123 = (ILiveExpOptService) jc1.k.f(ILiveExpOptService.class);
        if (r123 == null) goto L74;
        this.f113061d.add(r123.registerExpBizListener(l61.d.a.f.f507612e, new d(r114, r118)));
        goto L74
    L60:
        if (LiveByteCastManager.a() == false) goto L62;
        r118 = new com.bytedance.android.livesdk.castscreen.views.bytecast.k(r117);
    L50:
        if (xq() == true) goto L53;
    L74:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r124 = this.f113058a;
        if (r124 == null) goto L77;
        boolean r125 = r124.V9();
    L78:
        if (r125 == false) goto L97;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r126 = this.f113060c;
        if (r126 == null) goto L87;
        PropertyOwner r127 = r126.getLoadState();
        if (r127 == null) goto L87;
        Disposable r128 = com.bytedance.android.livesdk.chatroom.ui.framework.b.f(r127, new CastScreenCompositeWidget$preparePortraitCastScreenToolbarButton$1(this));
        if (r128 == null) goto L87;
        RxUtilKt.c(r128, this.f113061d);
    L87:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r129 = this.f113060c;
        if (r129 == null) goto L94;
        PropertyOwner r130 = r129.Na();
        if (r130 == null) goto L94;
        Disposable r131 = r130.subscribe(new g(this));
        if (r131 == null) goto L94;
        RxUtilKt.c(r131, this.f113061d);
    L94:
        DataCenter r132 = this.dataCenter;
        if (r132 == null) goto L97;
        r132.observe("paid_live_paid_info_update", this);
    L97:
        h70.b r133 = getComponentContext();
        if (r133 == null) goto L100;
        r101 = ho1.a.e(r133);
    L100:
        if (r101 == null) goto L107;
        PropertyOwner r134 = r101.sa();
        if (r134 == null) goto L108;
        Disposable r135 = r134.subscribe(new a(this));
        if (r135 == null) goto L109;
        RxUtilKt.c(r135, this.f113061d);
        return;
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L77:
        r125 = true;
        goto L78
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.f113061d.dispose();
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        r100.removeObserver(this);
    L5:
        this.f113058a = null;
        this.f113059b = null;
        this.f113060c = null;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r102 = this.f113058a;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.hq() != true) goto L21;
        if (r101 == null) goto L9;
        String r103 = r101.getKey();
    L10:
        if (r103 != null) goto L13;
        return;
    L13:
        if (r103.hashCode() == (-1060623801)) goto L16;
        return;
    L16:
        if (r103.equals("paid_live_paid_info_update") == false) goto L20;
        wq();
        return;
    L20:
        return;
    L9:
        r103 = null;
        goto L10
    }
}
