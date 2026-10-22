package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.CountDownView;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.ji;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.security.SecureRandom;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/ShowCountDownWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowCountDownWidget extends MiddlewareRoomWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.a f113251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.d f113252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.c f113253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CountDownView f113254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f113255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f113256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f113257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f113258h;

    public ShowCountDownWidget() {
        this.f113258h = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.f113251a = ho1.a.c(getComponentContext());
        this.f113252b = ho1.a.i(getComponentContext());
        this.f113253c = ho1.a.d(getComponentContext());
        com.bytedance.android.livesdk.chatroom.ui.framework.d r100 = this.f113252b;
        Room r101 = null;
        if (r100 == null) goto L5;
        View r102 = r100.Bc();
    L7:
        if ((r102 instanceof CountDownView) == true) goto L9;
        r102 = null;
    L9:
        this.f113254d = (CountDownView) r102;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r103 = this.f113252b;
        if (r103 == null) goto L12;
        TextView r104 = r103.ch();
    L13:
        this.f113255e = r104;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r105 = this.f113253c;
        if (r105 == null) goto L16;
        LiveMode r106 = r105.getLiveMode();
    L17:
        boolean r107 = true;
        if (r106 == null) goto L22;
        if (r106.isStreamingBackground() != true) goto L22;
    L111:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r108 = this.f113251a;
        if (r108 == null) goto L119;
        PropertyOwner r109 = r108.getLoadState();
        if (r109 == null) goto L120;
        Disposable r110 = com.bytedance.android.livesdk.chatroom.ui.framework.b.b(r109, new AnonymousClass1(this));
        if (r110 == null) goto L121;
        RxUtilKt.c(r110, this.f113258h);
        return;
    L121:
        return;
    L120:
        return;
    L119:
        return;
    L22:
        if (ji.f120527a.getValue().booleanValue() == false) goto L24;
        boolean r111 = false;
    L25:
        if (r111 == true) goto L111;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r112 = this.f113253c;
        if (r112 == null) goto L29;
        Bundle r113 = r112.Wl();
    L30:
        if (r113 == null) goto L39;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r114 = this.f113253c;
        if (r114 == null) goto L34;
        Bundle r115 = r114.Wl();
    L35:
        if (r115 == null) goto L39;
        if (r115.getBoolean("extra_start_live_optimization", false) != true) goto L39;
        boolean r116 = true;
    L40:
        if (r116 == false) goto L48;
        h70.b r117 = getComponentContext();
        if (r117 == null) goto L111;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r118 = ho1.a.i(r117);
        if (r118 == null) goto L111;
        View r119 = r118.getRootView();
        if (r119 == null) goto L111;
        r119.postDelayed(new h1(this), 3000);
        goto L111
    L48:
        com.bytedance.android.livesdk.log.filter.o r120 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r120 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L51;
        ((com.bytedance.android.livesdk.log.filter.n0) r120).getClass();
    L51:
        CountDownView r121 = this.f113254d;
        if (r121 == null) goto L54;
        r121.setVisibility(0);
    L54:
        CountDownView r122 = this.f113254d;
        if (r122 == null) goto L57;
        r122.setNeedAccessibility(true);
    L57:
        CountDownView r123 = this.f113254d;
        if (r123 == null) goto L60;
        r123.setCountDownListener(new i1(this));
    L60:
        CountDownView r124 = this.f113254d;
        if (r124 == null) goto L64;
        r124.c(true);
    L64:
        if (ms1.h.a() == false) goto L90;
        RoomContext r125 = RoomContext.a.c(RoomContext.Companion, this.dataCenter, 0, 2);
        if (r125 == null) goto L74;
        com.bytedance.live.datacontext.j<nz.l> r126 = r125.getAnchorRoomScopeViewModel();
        if (r126 == null) goto L74;
        nz.l r127 = r126.getValue();
        if (r127 == null) goto L74;
        com.bytedance.android.live.broadcast.api.scope.service.f r128 = (com.bytedance.android.live.broadcast.api.scope.service.f) r127.a();
        if (r128 == null) goto L74;
        String r129 = r128.a();
    L75:
        if (r129 != null) goto L77;
    L80:
        if (r107 == true) goto L87;
        TextView r130 = this.f113255e;
        if (r130 == null) goto L84;
        r130.setText(r129);
    L84:
        TextView r131 = this.f113255e;
        if (r131 == null) goto L90;
        r131.setVisibility(0);
        goto L90
    L87:
        TextView r132 = this.f113255e;
        if (r132 == null) goto L90;
        r132.setVisibility(8);
        goto L90
    L77:
        if (r129.length() == 0) goto L80;
        r107 = false;
    L74:
        r129 = null;
    L90:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r133 = this.f113253c;
        if (r133 == null) goto L93;
        Room r134 = r133.getRoom();
    L94:
        if (r134 == null) goto L111;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r135 = this.f113253c;
        if (r135 == null) goto L98;
        r101 = r135.getRoom();
    L98:
        if (r101 == null) goto L111;
        if (r101.getVisibilityRange() != 11) goto L111;
        String[] r136 = s1.D();
        if (r136 != null) goto L104;
    L108:
        TextView r137 = this.f113255e;
        if (r137 == null) goto L111;
        r137.setVisibility(0);
        goto L111
    L104:
        if (r136.length <= 0) goto L108;
        String r138 = r136[new SecureRandom().nextInt(r136.length)];
        TextView r139 = this.f113255e;
        if (r139 == null) goto L108;
        r139.setText("小贴士：" + r138);
        goto L108
    L93:
        r134 = null;
        goto L94
    L34:
        r115 = null;
    L39:
        r116 = false;
        goto L40
    L29:
        r113 = null;
        goto L30
    L24:
        r111 = com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.f162410c;
        goto L25
    L16:
        r106 = null;
        goto L17
    L12:
        r104 = null;
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.f113258h.dispose();
        this.f113257g = false;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onPause() {
        super.onPause();
        this.f113256f = false;
        NewBroadcastMonitor.f(NewBroadcastMonitor.SERVICE.SERVICE_INTERACTION_PAUSE);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        this.f113256f = true;
        NewBroadcastMonitor.a r100 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_INTERACTION_RESUME, null, null, 14);
        r100.i("send_live_start_on_resume", Boolean.valueOf(this.f113257g));
        r100.a().report();
        if (this.f113257g == false) goto L6;
        NewBroadcastMonitor.a r101 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_SEND_START_EVENT, null, null, 14);
        r101.i("style", "delay");
        r101.a().report();
        zg1.h1 r102 = new zg1.h1(3);
        xs2.b.a().post(r102);
        this.f113257g = false;
        return;
    }

    public static final void wq(ShowCountDownWidget r100) {
        jo1.g r101 = null;
        if (r100.f113256f == false) goto L5;
        NewBroadcastMonitor.a r102 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_SEND_START_EVENT, null, null, 14);
        r102.i("style", "immediately");
        r102.a().report();
        zg1.h1 r103 = new zg1.h1(3);
        xs2.b.a().post(r103);
    L6:
        h70.b r104 = r100.getComponentContext();
        if (r104 == null) goto L11;
        IAbilityCenter r105 = r104.a();
        if (r105 == null) goto L11;
        r101 = (jo1.g) r105.getAbility(jo1.g.class);
    L11:
        if (r101 == null) goto L13;
        r101.fetch();
    L13:
        TextView r106 = r100.f113255e;
        if (r106 == null) goto L17;
        r106.setVisibility(8);
        return;
    L17:
        return;
    L5:
        NewBroadcastMonitor.f(NewBroadcastMonitor.SERVICE.SERVICE_DELAY_SEND_START_EVENT);
        r100.f113257g = true;
        goto L6
    }
}
