package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.revlink.impl.control.LinkRevControlWidget;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.framework.LoadState;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/LinkDelegateWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/p;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkDelegateWidget extends MiddlewareRoomWidget implements p {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f113132i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kc0.r f113133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f113134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.revenue.core.b f113135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f113136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f113137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f113138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a0 f113139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f113140h;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkDelegateWidget f113141a;

        public static final class a<T> implements h80.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f113142a;

            public a(b r100) {
                this.f113142a = r100;
            }

            @Override // h80.a
            public final void accept(Object r100) {
                IRoom r101 = (IRoom) r100;
                LinkDelegateWidget r102 = this.f113142a.f113141a;
                if (r101 != null) goto L6;
                int r103 = LinkDelegateWidget.f113132i;
                r102.getClass();
                return;
            L6:
                if (r102.f113134b == true) goto L8;
                r102.f113139g = new a0(r102, r101);
                return;
            L8:
                kc0.r r104 = r102.f113133a;
                if (r104 == null) goto L14;
                r104.p3(r101);
                return;
            }
        }

        public b(LinkDelegateWidget r100) {
            this.f113141a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f113141a.runWithRoomEntered(new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkDelegateWidget f113143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f113144b;

        public c(LinkDelegateWidget r100, String r101) {
            this.f113143a = r100;
            this.f113144b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            kc0.r r100 = this.f113143a.f113133a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onSei(this.f113144b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkDelegateWidget f113145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ hh1.v0 f113146b;

        public d(LinkDelegateWidget r100, hh1.v0 r101) {
            this.f113145a = r100;
            this.f113146b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            kc0.r r100 = this.f113145a.f113133a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.q3(new vc0.a(this.f113146b));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.p
    public final kf1.a cf() {
        kc0.r r100 = this.f113133a;
        if (r100 == null) goto L5;
        LinkRevControlWidget r101 = r100.getWidget();
    L7:
        if ((r101 instanceof kf1.a) == true) goto L10;
        return null;
    L10:
        return r101;
    L5:
        r101 = null;
        goto L7
    }

    public final void wq() {
        if (this.f113134b == false) goto L6;
        return;
    L6:
        if (this.f113135c != null) goto L8;
        return;
    L8:
        kc0.r r100 = this.f113133a;
        if (r100 == null) goto L30;
        LinkRevControlWidget r101 = r100.getWidget();
        if (r101 == null) goto L31;
        h70.b r102 = getComponentContext();
        if (r102 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r103 = ho1.a.c(r102);
    L17:
        if (r103 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C1672a.a(r103, R.id.interact_revenue_container, r101, this.f113136d, 8);
    L19:
        this.f113134b = true;
        a0 r104 = this.f113139g;
        if (r104 == null) goto L22;
        r104.run();
    L22:
        this.f113139g = null;
        d r105 = this.f113138f;
        if (r105 == null) goto L25;
        r105.run();
    L25:
        this.f113138f = null;
        c r106 = this.f113137e;
        if (r106 == null) goto L28;
        r106.run();
    L28:
        this.f113137e = null;
        return;
    L16:
        r103 = null;
        goto L17
    L31:
        return;
    }

    public LinkDelegateWidget() {
        this.f113136d = true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r100 = ho1.a.d(getComponentContext());
        if (r100 == null) goto L7;
        hh1.v0 r101 = r100.getLiveVideoClientFactory();
        if (r101 == null) goto L7;
        vq(r101);
    L7:
        h70.b r102 = getComponentContext();
        RoomContext r103 = null;
        if ((r102 instanceof com.bytedance.android.livesdk.widgetdescriptor.e0) == true) goto L10;
        r102 = null;
    L10:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r104 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r102;
        if (r104 == null) goto L14;
        r103 = r104.b();
    L14:
        if (com.bytedance.android.livesdk.e1.f123284a.getValue().booleanValue() == false) goto L19;
        if (r103 == null) goto L23;
        com.bytedance.live.datacontext.i<Boolean> r105 = r103.getRevenueInstanceInitialized();
        if (r105 == null) goto L23;
        r105.c(new LinkDelegateWidget$onRoomContextReady$1(this));
    L23:
        h70.b r106 = getComponentContext();
        if (r106 == null) goto L49;
        IAbilityCenter r107 = r106.a();
        if (r107 == null) goto L49;
        final com.bytedance.android.livesdk.chatroom.ui.framework.c r108 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r107.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r108 == null) goto L49;
        h70.b r109 = getComponentContext();
        if (r109 == null) goto L49;
        IAbilityCenter r110 = r109.a();
        if (r110 == null) goto L49;
        final com.bytedance.android.livesdk.chatroom.ui.framework.a r111 = (com.bytedance.android.livesdk.chatroom.ui.framework.a) r110.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.a.class);
        if (r111 == null) goto L49;
        if (r108.V9() == false) goto L42;
        int r112 = LoadState.P0_BEGIN.getValue();
    L40:
        final int r113 = r112;
        final Ref.BooleanRef r114 = new Ref.BooleanRef();
        r114.element = false;
        this.f113140h = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p.a(r111.getLoadState(), new LinkDelegateWidget$onLoadBatchReady$1(this, r114, r113, r108, r111));
        goto L49
    L42:
        if (r108.o5() == false) goto L45;
        r112 = LoadState.P3_END.getValue();
        goto L40
    L45:
        if (r108.dg() == false) goto L47;
        r112 = LoadState.P0_BEGIN.getValue();
        goto L40
    L47:
        r112 = LoadState.P3_END.getValue();
    L49:
        MainThreadPostUtils.b(new b(this));
        h70.b r115 = getComponentContext();
        if (r115 == null) goto L55;
        IAbilityCenter r116 = r115.a();
        if (r116 == null) goto L56;
        r116.registerAbility(p.class, this);
        return;
    L56:
        return;
    L55:
        return;
    L19:
        if (r103 == null) goto L23;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revenue.core.b> r117 = r103.getRevenueInstance();
        if (r117 == null) goto L23;
        r117.c(new LinkDelegateWidget$onRoomContextReady$2(this));
        goto L23
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r100 = getComponentContext();
        if (r100 == null) goto L7;
        IAbilityCenter r101 = r100.a();
        if (r101 == null) goto L7;
        r101.unregisterAbility(p.class);
    L7:
        Disposable r102 = this.f113140h;
        if (r102 == null) goto L11;
        r102.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.p
    public final void b0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        if (this.f113134b == true) goto L5;
        return;
    L5:
        kc0.r r101 = this.f113133a;
        if (r101 == null) goto L9;
        r101.b0(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.p
    public final void onSei(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sei");
        if (this.f113134b == true) goto L6;
        this.f113137e = new c(this, r100);
        return;
    L6:
        kc0.r r101 = this.f113133a;
        if (r101 == null) goto L10;
        r101.onSei(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.p
    public final void vq(hh1.v0 r100) {
        Intrinsics.checkNotNullParameter(r100, "videoClientFactory");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r101 = ho1.a.d(getComponentContext());
        if (r101 == null) goto L5;
        LiveMode r102 = r101.getLiveMode();
    L7:
        if (r102 == LiveMode.SCREEN_RECORD) goto L10;
        return;
    L10:
        if (this.f113134b == true) goto L13;
        this.f113138f = new d(this, r100);
        return;
    L13:
        kc0.r r103 = this.f113133a;
        if (r103 == null) goto L17;
        r103.q3(new vc0.a(r100));
        return;
    L17:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.p
    public final void a(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "event");
        if (this.f113134b == true) goto L5;
        return;
    L5:
        kc0.r r102 = this.f113133a;
        if (r102 == null) goto L9;
        r102.a(r100, r101);
        return;
    }
}
