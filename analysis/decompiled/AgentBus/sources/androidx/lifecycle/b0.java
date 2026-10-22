package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

/* loaded from: classes.dex */
public final class b0 extends i {
    final /* synthetic */ c0 this$0;

    public static final class a extends i {
        final /* synthetic */ c0 this$0;

        public a(c0 c0Var) {
            this.this$0 = c0Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            q7.k.e(activity, "activity");
            c0 c0Var = this.this$0;
            int i2 = c0Var.f982g + 1;
            c0Var.f982g = i2;
            if (i2 == 1) {
                if (c0Var.f983h) {
                    c0Var.f986k.d(p.ON_RESUME);
                    c0Var.f983h = false;
                } else {
                    Handler handler = c0Var.f985j;
                    q7.k.b(handler);
                    handler.removeCallbacks(c0Var.f987l);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            q7.k.e(activity, "activity");
            c0 c0Var = this.this$0;
            int i2 = c0Var.f981f + 1;
            c0Var.f981f = i2;
            if (i2 == 1 && c0Var.f984i) {
                c0Var.f986k.d(p.ON_START);
                c0Var.f984i = false;
            }
        }
    }

    public b0(c0 c0Var) {
        this.this$0 = c0Var;
    }

    @Override // androidx.lifecycle.i, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        q7.k.e(activity, "activity");
    }

    @Override // androidx.lifecycle.i, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        q7.k.e(activity, "activity");
        c0 c0Var = this.this$0;
        int i2 = c0Var.f982g - 1;
        c0Var.f982g = i2;
        if (i2 == 0) {
            Handler handler = c0Var.f985j;
            q7.k.b(handler);
            handler.postDelayed(c0Var.f987l, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        q7.k.e(activity, "activity");
        activity.registerActivityLifecycleCallbacks(new a(this.this$0));
    }

    @Override // androidx.lifecycle.i, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        q7.k.e(activity, "activity");
        c0 c0Var = this.this$0;
        int i2 = c0Var.f981f - 1;
        c0Var.f981f = i2;
        if (i2 == 0 && c0Var.f983h) {
            c0Var.f986k.d(p.ON_STOP);
            c0Var.f984i = true;
        }
    }
}
