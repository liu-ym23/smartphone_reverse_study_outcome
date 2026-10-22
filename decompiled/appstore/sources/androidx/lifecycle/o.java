package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f3565a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f3566b = null;

    public static final class a extends i {
        public a() {
        }

        @Override // androidx.lifecycle.i, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity r10, @Nullable Bundle r11) {
            kotlin.jvm.internal.q.g(r10, "activity");
            ReportFragment.f3473b.b(r10);
        }
    }

    static {
        f3565a = new o();
        f3566b = new AtomicBoolean(false);
    }

    public o() {
    }

    public static final void a(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        if (f3566b.getAndSet(true) == false) goto L5;
        return;
    L5:
        Context r11 = r10.getApplicationContext();
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type android.app.Application");
        ((Application) r11).registerActivityLifecycleCallbacks(new a());
    }
}
