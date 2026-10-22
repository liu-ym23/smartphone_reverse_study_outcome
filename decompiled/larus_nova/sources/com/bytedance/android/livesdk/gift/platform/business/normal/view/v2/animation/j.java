package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import com.bytedance.android.live.core.utils.i0;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    public static final class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f129960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f129961b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.j$a$a, reason: collision with other inner class name */
        public static final class RunnableC2075a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f129962a;

            public RunnableC2075a(a r100) {
                this.f129962a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f129962a.f129960a.invoke();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f129963a;

            public b(a r100) {
                this.f129963a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f129963a.f129961b.invoke();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
            i0.h(new RunnableC2075a(this));
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            i0.h(new b(this));
        }

        public a(Function0 r100, Function0 r101) {
            this.f129960a = r100;
            this.f129961b = r101;
        }
    }

    public static final void a(AnimatedDrawable2 r100, Function0<Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindListener");
        Intrinsics.checkNotNullParameter(r101, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r102, "onEnd");
        r100.setAnimationListener(new a(r101, r102));
    }
}
