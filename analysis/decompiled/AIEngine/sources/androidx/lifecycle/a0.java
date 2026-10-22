package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a0 extends g {
    final /* synthetic */ b0 this$0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends g {
        final /* synthetic */ b0 this$0;

        public a(b0 b0Var) {
            this.this$0 = b0Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            kotlin.jvm.internal.g.f(activity, "activity");
            b0 b0Var = this.this$0;
            int i10 = b0Var.f2249b + 1;
            b0Var.f2249b = i10;
            if (i10 == 1) {
                if (b0Var.f2250c) {
                    b0Var.h.f(Lifecycle.Event.ON_RESUME);
                    b0Var.f2250c = false;
                } else {
                    Handler handler = b0Var.f2252e;
                    kotlin.jvm.internal.g.c(handler);
                    handler.removeCallbacks(b0Var.f2253j);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            kotlin.jvm.internal.g.f(activity, "activity");
            b0 b0Var = this.this$0;
            int i10 = b0Var.f2248a + 1;
            b0Var.f2248a = i10;
            if (i10 == 1 && b0Var.f2251d) {
                b0Var.h.f(Lifecycle.Event.ON_START);
                b0Var.f2251d = false;
            }
        }
    }

    public a0(b0 b0Var) {
        this.this$0 = b0Var;
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        kotlin.jvm.internal.g.f(activity, "activity");
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        kotlin.jvm.internal.g.f(activity, "activity");
        b0 b0Var = this.this$0;
        int i10 = b0Var.f2249b - 1;
        b0Var.f2249b = i10;
        if (i10 == 0) {
            Handler handler = b0Var.f2252e;
            kotlin.jvm.internal.g.c(handler);
            handler.postDelayed(b0Var.f2253j, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        kotlin.jvm.internal.g.f(activity, "activity");
        activity.registerActivityLifecycleCallbacks(new a(this.this$0));
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        kotlin.jvm.internal.g.f(activity, "activity");
        b0 b0Var = this.this$0;
        int i10 = b0Var.f2248a - 1;
        b0Var.f2248a = i10;
        if (i10 == 0 && b0Var.f2250c) {
            b0Var.h.f(Lifecycle.Event.ON_STOP);
            b0Var.f2251d = true;
        }
    }
}
