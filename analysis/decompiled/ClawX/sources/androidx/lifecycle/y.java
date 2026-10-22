package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y extends f {
    final /* synthetic */ z this$0;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    public static final class a extends f {
        final /* synthetic */ z this$0;

        public a(z zVar) {
            this.this$0 = zVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            kotlin.jvm.internal.p.e(activity, "activity");
            z zVar = this.this$0;
            int i8 = zVar.f736b + 1;
            zVar.f736b = i8;
            if (i8 == 1) {
                if (zVar.f737c) {
                    zVar.f739f.d(l.ON_RESUME);
                    zVar.f737c = false;
                } else {
                    Handler handler = zVar.f738e;
                    kotlin.jvm.internal.p.b(handler);
                    handler.removeCallbacks(zVar.f740g);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            kotlin.jvm.internal.p.e(activity, "activity");
            z zVar = this.this$0;
            int i8 = zVar.f735a + 1;
            zVar.f735a = i8;
            if (i8 == 1 && zVar.d) {
                zVar.f739f.d(l.ON_START);
                zVar.d = false;
            }
        }
    }

    public y(z zVar) {
        this.this$0 = zVar;
    }

    @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        kotlin.jvm.internal.p.e(activity, "activity");
    }

    @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        kotlin.jvm.internal.p.e(activity, "activity");
        z zVar = this.this$0;
        int i8 = zVar.f736b - 1;
        zVar.f736b = i8;
        if (i8 == 0) {
            Handler handler = zVar.f738e;
            kotlin.jvm.internal.p.b(handler);
            handler.postDelayed(zVar.f740g, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        kotlin.jvm.internal.p.e(activity, "activity");
        x.a(activity, new a(this.this$0));
    }

    @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        kotlin.jvm.internal.p.e(activity, "activity");
        z zVar = this.this$0;
        int i8 = zVar.f735a - 1;
        zVar.f735a = i8;
        if (i8 == 0 && zVar.f737c) {
            zVar.f739f.d(l.ON_STOP);
            zVar.d = true;
        }
    }
}
