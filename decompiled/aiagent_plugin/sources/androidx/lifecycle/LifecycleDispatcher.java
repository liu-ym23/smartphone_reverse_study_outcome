package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: LifecycleDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LifecycleDispatcher f1928a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f1929b = null;

    /* JADX INFO: compiled from: LifecycleDispatcher.kt */
    public static final class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        public DispatcherActivityCallback() {
        }

        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
            Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r0, "activity");
            ReportFragment.Companion.a(r0);
        }
    }

    private LifecycleDispatcher() {
    }

    static {
        f1928a = new LifecycleDispatcher();
        f1929b = new AtomicBoolean(false);
    }

    public static final void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        if (f1929b.getAndSet(true) == false) goto L5;
        return;
    L5:
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r5, "null cannot be cast to non-null type android.app.Application");
        ((Application) ZeusTransformUtils.preCheckCast(r5, Application.class, "com.obric.aiagent.plugin")).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks) ZeusTransformUtils.preCheckCast(new DispatcherActivityCallback(), Application.ActivityLifecycleCallbacks.class, "com.obric.aiagent.plugin"));
    }
}
