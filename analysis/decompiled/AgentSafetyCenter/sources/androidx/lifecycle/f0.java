package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 extends i {
    final /* synthetic */ g0 this$0;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class a extends i {
        final /* synthetic */ g0 this$0;

        public a(g0 g0Var) {
            this.this$0 = g0Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            activity.getClass();
            g0 g0Var = this.this$0;
            int i = g0Var.f1383f + 1;
            g0Var.f1383f = i;
            if (i == 1) {
                if (g0Var.f1384g) {
                    g0Var.f1386j.f(o.ON_RESUME);
                    g0Var.f1384g = false;
                } else {
                    Handler handler = g0Var.i;
                    handler.getClass();
                    handler.removeCallbacks(g0Var.f1387k);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            activity.getClass();
            g0 g0Var = this.this$0;
            int i = g0Var.f1382c + 1;
            g0Var.f1382c = i;
            if (i == 1 && g0Var.f1385h) {
                g0Var.f1386j.f(o.ON_START);
                g0Var.f1385h = false;
            }
        }
    }

    public f0(g0 g0Var) {
        this.this$0 = g0Var;
    }

    @Override // androidx.lifecycle.i, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        activity.getClass();
    }

    @Override // androidx.lifecycle.i, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        activity.getClass();
        g0 g0Var = this.this$0;
        int i = g0Var.f1383f - 1;
        g0Var.f1383f = i;
        if (i == 0) {
            Handler handler = g0Var.i;
            handler.getClass();
            handler.postDelayed(g0Var.f1387k, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.getClass();
        activity.registerActivityLifecycleCallbacks(new a(this.this$0));
    }

    @Override // androidx.lifecycle.i, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        activity.getClass();
        g0 g0Var = this.this$0;
        int i = g0Var.f1382c - 1;
        g0Var.f1382c = i;
        if (i == 0 && g0Var.f1384g) {
            g0Var.f1386j.f(o.ON_STOP);
            g0Var.f1385h = true;
        }
    }
}
