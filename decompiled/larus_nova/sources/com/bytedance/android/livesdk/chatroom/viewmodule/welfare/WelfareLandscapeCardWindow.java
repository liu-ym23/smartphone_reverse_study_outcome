package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import android.animation.Animator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.right.WelfareProjectBottomRightCardWidget;
import com.bytedance.android.livesdk.config.qy0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class WelfareLandscapeCardWindow extends v61.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ScaleAnimation f117584m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f117585n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DataCenter f117586o;

    public static final class a implements t61.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WelfareLandscapeCardWindow f117587a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.welfare.WelfareLandscapeCardWindow$a$a, reason: collision with other inner class name */
        public static final class RunnableC1744a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f117588a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f117589b;

            public RunnableC1744a(a r100, View r101) {
                this.f117588a = r100;
                this.f117589b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                WelfareLandscapeCardWindow.S(this.f117588a.f117587a, this.f117589b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Animation.AnimationListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ t61.c f117590a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f117591b;

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation r100) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation r100) {
                this.f117591b.setVisibility(8);
                Function0<Unit> r101 = this.f117590a.f544657b;
                if (r101 == null) goto L6;
                Unit r102 = r101.invoke();
                return;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation r100) {
                Function0<Unit> r101 = this.f117590a.f544656a;
                if (r101 == null) goto L6;
                Unit r102 = r101.invoke();
                return;
            }

            public b(t61.c r100, View r101) {
                this.f117590a = r100;
                this.f117591b = r101;
            }
        }

        @Override // t61.a
        public final Animator a(View r100) {
            return null;
        }

        @Override // t61.a
        public final Animator c(View r100) {
            return null;
        }

        public a(WelfareLandscapeCardWindow r100) {
            this.f117587a = r100;
        }

        @Override // t61.a
        public final boolean b(View r110, boolean r111, t61.c r112) {
            Intrinsics.checkNotNullParameter(r110, "animView");
            Intrinsics.checkNotNullParameter(r112, "listener");
            ScaleAnimation r100 = this.f117587a.f117584m;
            if (r100 == null) goto L5;
            r100.cancel();
        L5:
            if (r111 == true) goto L7;
            WelfareLandscapeCardWindow r113 = this.f117587a;
            if (r113.f117585n == false) goto L30;
            ScaleAnimation r101 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.0f, 1, 0.8f);
            r101.setDuration(360);
            Unit r102 = Unit.INSTANCE;
            r113.f117584m = r101;
            ScaleAnimation r114 = this.f117587a.f117584m;
            if (r114 == null) goto L29;
            r114.setAnimationListener(new b(r112, r110));
        L29:
            r110.startAnimation(this.f117587a.f117584m);
            return true;
        L30:
            UtilityKotlinExtentionsKt.t(r110);
            Function0<Unit> r115 = r112.f544656a;
            if (r115 == null) goto L33;
            Unit r116 = r115.invoke();
        L33:
            Function0<Unit> r117 = r112.f544657b;
            if (r117 == null) goto L43;
            Unit r118 = r117.invoke();
            return true;
        L43:
            return true;
        L7:
            if (this.f117587a.f117585n == false) goto L18;
            Function0<Unit> r119 = r112.f544656a;
            if (r119 == null) goto L11;
            Unit r120 = r119.invoke();
        L11:
            Function0<Unit> r121 = r112.f544657b;
            if (r121 == null) goto L14;
            Unit r122 = r121.invoke();
        L14:
            UtilityKotlinExtentionsKt.t(r110);
            if (qy0.f121092a.getValue().h() == true) goto L17;
            WelfareLandscapeCardWindow.S(this.f117587a, r110);
            return true;
        L17:
            i0.c().postDelayed(new RunnableC1744a(this, r110), 500);
            return true;
        L18:
            UtilityKotlinExtentionsKt.w(r110);
            r110.setScaleX(1.0f);
            r110.setScaleY(1.0f);
            r110.setAlpha(1.0f);
            Function0<Unit> r123 = r112.f544656a;
            if (r123 == null) goto L21;
            Unit r124 = r123.invoke();
        L21:
            Function0<Unit> r125 = r112.f544657b;
            if (r125 == null) goto L40;
            Unit r126 = r125.invoke();
            return true;
        L40:
            return true;
        }
    }

    @Override // v61.a
    public final void I() {
        CardConstraint r100 = this.f553371b;
        r100.getClass();
        CardConstraint r101 = new CardConstraint(r100);
        r101.b(CardConstraint.Position.BottomRight);
        r101.a(new WelfareLandscapeCardWindow$bottomRightConstraint$1(this));
        P(r101);
        c(new a(this));
    }

    @Override // v61.a
    public final void K() {
        DataCenter r100 = this.f117586o;
        if (r100 == null) goto L6;
        r100.put("data_live_welfare_component_show", Boolean.FALSE);
        return;
    }

    @Override // v61.a
    public final void L() {
        DataCenter r100 = this.f117586o;
        if (r100 == null) goto L6;
        r100.put("data_live_welfare_component_show", Boolean.TRUE);
        return;
    }

    @Override // v61.c
    public final x61.h<?, ?> content() {
        x61.h.a r100 = x61.h.f562592a;
        Function1<WelfareProjectBottomRightCardWidget, Unit> r101 = new AnonymousClass1(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(WelfareProjectBottomRightCardWidget.class, "widgetClz");
        return new x61.g(r101, WelfareProjectBottomRightCardWidget.class);
    }

    @Override // v61.a, r61.b
    public final DataCenter getDataCenter() {
        return this.f117586o;
    }

    public WelfareLandscapeCardWindow(DataCenter r100) {
        CardTypeAndPriority r101 = CardTypeAndPriority.WelfareProject;
        super(r100, r101.getType(), r101.getPriority());
        this.f117586o = r100;
        this.f117585n = true;
    }

    public static final void S(WelfareLandscapeCardWindow r110, View r111) {
        r110.getClass();
        if (r111 == null) goto L7;
        ScaleAnimation r100 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.0f, 1, 0.8f);
        r100.setDuration(440);
        Unit r101 = Unit.INSTANCE;
        r110.f117584m = r100;
        UtilityKotlinExtentionsKt.w(r111);
        r111.startAnimation(r110.f117584m);
        return;
    }
}
