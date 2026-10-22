package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/LifecycleDispatcher;", "", "<init>", "()V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "DispatcherActivityCallback", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifecycleDispatcher {
    public static final LifecycleDispatcher INSTANCE = null;
    private static final AtomicBoolean initialized = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Landroidx/lifecycle/LifecycleDispatcher$DispatcherActivityCallback;", "Landroidx/lifecycle/EmptyActivityLifecycleCallbacks;", "<init>", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "lifecycle-process_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        public DispatcherActivityCallback() {
        }

        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ReportFragment.Companion.injectIfNeededIn(r100);
        }
    }

    private LifecycleDispatcher() {
    }

    static {
        INSTANCE = new LifecycleDispatcher();
        initialized = new AtomicBoolean(false);
    }

    @JvmStatic
    public static final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (initialized.getAndSet(true) == false) goto L5;
        return;
    L5:
        Context r101 = r100.getApplicationContext();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.app.Application");
        ((Application) r101).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
    }
}
