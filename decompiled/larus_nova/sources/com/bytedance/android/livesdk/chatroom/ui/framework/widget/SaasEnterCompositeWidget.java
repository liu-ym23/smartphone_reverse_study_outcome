package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.ui.framework.LoadState;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/SaasEnterCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/r;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SaasEnterCompositeWidget extends MiddlewareRoomWidget implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.c f113202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.a f113203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f113204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Widget f113205d;

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    public SaasEnterCompositeWidget() {
        this.f113204c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.f113202a = ho1.a.d(getComponentContext());
        this.f113203b = ho1.a.c(getComponentContext());
        DataCenter r100 = this.dataCenter;
        Widget r101 = null;
        if (r100 == null) goto L5;
        Room r102 = com.bytedance.android.live.core.utils.z.o(r100);
    L7:
        if (r102 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r103 = this.f113202a;
        if (r103 == null) goto L12;
        boolean r104 = r103.R7();
    L13:
        if (r104 == false) goto L27;
        IRoomCart r105 = r102.getRoomCart();
        if (r105 == null) goto L17;
        Boolean r106 = Boolean.valueOf(r105.getContainCart());
    L19:
        if (r106.booleanValue() == false) goto L27;
        IEnterGuideService r107 = (IEnterGuideService) jc1.k.f(IEnterGuideService.class);
        if (r107 == null) goto L23;
        Widget r108 = r107.createCouponDialogWidget(getContext());
    L24:
        this.f113205d = r108;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r109 = this.f113203b;
        if (r109 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C1672a.b(r109, r108, 6);
        goto L27
    L23:
        r108 = null;
        goto L24
    L17:
        r106 = null;
        goto L19
    L12:
        r104 = true;
    L27:
        h70.b r110 = getComponentContext();
        if (r110 == null) goto L32;
        IAbilityCenter r111 = r110.a();
        if (r111 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.e r112 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.e) r111.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.e.class);
    L33:
        if (r112 == null) goto L45;
        List<kf1.a> r113 = r112.op();
        if (r113 == null) goto L45;
        IEnterGuideService r114 = (IEnterGuideService) jc1.k.f(IEnterGuideService.class);
        if (r114 == null) goto L40;
        Widget r115 = r114.createSlideTaskWidget(r113);
    L41:
        if (r115 == null) goto L45;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r116 = this.f113203b;
        if (r116 == null) goto L45;
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C1672a.b(r116, r115, 6);
        goto L45
    L40:
        r115 = null;
    L45:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r117 = this.f113202a;
        if (r117 == null) goto L57;
        com.bytedance.android.live.room.l r118 = r117.ef();
        if (r118 == null) goto L57;
        IEnterGuideService r119 = (IEnterGuideService) jc1.k.f(IEnterGuideService.class);
        if (r119 == null) goto L53;
        r101 = r119.createUgCouponWidget(r118);
    L53:
        if (r101 == null) goto L57;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r120 = this.f113203b;
        if (r120 == null) goto L57;
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C1672a.b(r120, r101, 6);
    L57:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r121 = this.f113203b;
        if (r121 == null) goto L64;
        PropertyOwner r122 = r121.getLoadState();
        if (r122 == null) goto L64;
        Disposable r123 = com.bytedance.android.livesdk.chatroom.ui.framework.b.e(r122, new AnonymousClass1(this));
        if (r123 == null) goto L64;
        RxUtilKt.c(r123, this.f113204c);
    L64:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r124 = this.f113203b;
        if (r124 == null) goto L71;
        PropertyOwner r125 = r124.getLoadState();
        if (r125 == null) goto L71;
        Function0<Unit> r126 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r125, "$this$runWithP3RealLoaded");
        Intrinsics.checkNotNullParameter(r126, "callback");
        Disposable r127 = com.bytedance.android.livesdk.chatroom.ui.framework.b.g(r125, LoadState.P3_REAL_END, r126);
        if (r127 == null) goto L71;
        RxUtilKt.c(r127, this.f113204c);
    L71:
        ho1.a.p(getComponentContext(), r.class, this);
        return;
    L32:
        r112 = null;
        goto L33
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        ho1.a.q(getComponentContext(), r.class);
        this.f113204c.dispose();
        this.f113205d = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.r
    public final Widget pq() {
        return this.f113205d;
    }
}
