package com.stepos.ailauncher.amap.route;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0004*\u0001 \bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R&\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/amap/route/w;", "", "<init>", "()V", "Landroid/app/Application;", "app", "LY8/t;", "f", "(Landroid/app/Application;)V", "Lkotlin/Function1;", "", "listener", Const.INTENT_KEY_UMID, "(Lp9/l;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, com.stepos.ailauncher.chat.trace.h.APP_FOREGROUND, "e", "(Z)V", "", "TAG", "Ljava/lang/String;", "", "listeners", "Ljava/util/List;", "installed", "Z", "", "startedCount", "I", UxipConstants.f30680s, "isForeground", "()Z", "com/stepos/ailauncher/amap/route/w$a", "callbacks", "Lcom/stepos/ailauncher/amap/route/w$a;", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.amap.route.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2411w {
    private static final String TAG = "AppForegroundMonitor";
    private static boolean installed;
    private static int startedCount;
    public static final C2411w INSTANCE = new C2411w();
    private static final List<InterfaceC5074l<Boolean, Y8.t>> listeners = new ArrayList();
    private static boolean isForeground = true;
    private static final a callbacks = new a();

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"com/stepos/ailauncher/amap/route/w$a", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "LY8/t;", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityStopped", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityResumed", "onActivityPaused", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.amap.route.w$a */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            kotlin.jvm.internal.p.i(activity, "activity");
            kotlin.jvm.internal.p.i(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            C2411w.startedCount++;
            if (C2411w.startedCount == 1) {
                C2411w.INSTANCE.e(true);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            C2411w.startedCount = C5685n.f(C2411w.startedCount - 1, 0);
            if (C2411w.startedCount == 0) {
                C2411w.INSTANCE.e(false);
            }
        }
    }

    public final void d(InterfaceC5074l<? super Boolean, Y8.t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        List<InterfaceC5074l<Boolean, Y8.t>> list = listeners;
        if (list.contains(listener)) {
            return;
        }
        list.add(listener);
    }

    public final void e(boolean foreground) {
        if (isForeground == foreground) {
            return;
        }
        isForeground = foreground;
        List<InterfaceC5074l<Boolean, Y8.t>> list = listeners;
        C4148a.k(TAG, "foreground=" + foreground + " listeners=" + list.size(), false, 4, null);
        for (InterfaceC5074l interfaceC5074l : Z8.F.m1(list)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5074l.invoke(Boolean.valueOf(foreground));
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void f(Application app) {
        kotlin.jvm.internal.p.i(app, "app");
        if (installed) {
            return;
        }
        installed = true;
        app.registerActivityLifecycleCallbacks(callbacks);
        C4148a.k(TAG, "installed", false, 4, null);
    }

    public final void g(InterfaceC5074l<? super Boolean, Y8.t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        listeners.remove(listener);
    }
}
