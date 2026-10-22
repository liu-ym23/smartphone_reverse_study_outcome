package com.stepos.ailauncher.common.utils;

import Z8.C1173v;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.J;
import com.stepos.ailauncher.common.utils.r;
import com.stepos.ailauncher.common.utils.y;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002LMB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u0014J\u0015\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0005¢\u0006\u0004\b#\u0010\u0003J\u001f\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020\u0012¢\u0006\u0004\b'\u0010(J'\u0010,\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010+\u001a\u00020\n¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\n¢\u0006\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u001f068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010E\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u00104R\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010J¨\u0006N"}, d2 = {"Lcom/stepos/ailauncher/common/utils/r;", "", "<init>", "()V", "Lkotlin/Function0;", "LY8/t;", "action", "B", "(Lp9/a;)V", "z", "", "t", "()Z", "u", "Q", "p", "I", "v", "", "R", "()Ljava/lang/String;", "packageName", "w", "(Ljava/lang/String;)V", "M", "(Ljava/lang/String;)Ljava/lang/String;", "q", "Landroid/app/Application;", "app", "r", "(Landroid/app/Application;)V", "Lcom/stepos/ailauncher/common/utils/r$b;", "listener", "o", "(Lcom/stepos/ailauncher/common/utils/r$b;)V", "x", "", "durationMs", "reason", "O", "(JLjava/lang/String;)V", "hostForeground", "panelOpen", "returningHome", "D", "(ZZZ)V", "visible", "G", "(Z)V", "TAG", "Ljava/lang/String;", "POLL_START_DELAY_MS", "J", "POLL_INTERVAL_MS", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Landroid/content/Context;", "appContext", "Landroid/content/Context;", "Lcom/stepos/ailauncher/common/utils/u;", "session", "Lcom/stepos/ailauncher/common/utils/u;", "overlayVisible", "Ljava/lang/Boolean;", "suppressLeaveUntilElapsed", "Ljava/lang/Runnable;", "pollRunnable", "Ljava/lang/Runnable;", "settleRunnable", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class r {
    private static final long POLL_INTERVAL_MS = 200;
    private static final long POLL_START_DELAY_MS = 600;
    private static final String TAG = "ForegroundAppSwitchMonitor";
    private static Context appContext;
    private static Boolean overlayVisible;
    private static long suppressLeaveUntilElapsed;
    public static final r INSTANCE = new r();
    private static final CopyOnWriteArraySet<b> listeners = new CopyOnWriteArraySet<>();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final u session = new u();
    private static final Runnable pollRunnable = new Runnable() { // from class: com.stepos.ailauncher.common.utils.g
        @Override // java.lang.Runnable
        public final void run() {
            r.L();
        }
    };
    private static final Runnable settleRunnable = new Runnable() { // from class: com.stepos.ailauncher.common.utils.i
        @Override // java.lang.Runnable
        public final void run() {
            r.N();
        }
    };

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/common/utils/r$a;", "", "", "packageName", "label", "", "isHomeLauncher", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "getLabel", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.common.utils.r$a, reason: from toString */
    public static final /* data */ class ForegroundApp {
        private final boolean isHomeLauncher;
        private final String label;
        private final String packageName;

        public ForegroundApp(String packageName, String str, boolean z10) {
            kotlin.jvm.internal.p.i(packageName, "packageName");
            this.packageName = packageName;
            this.label = str;
            this.isHomeLauncher = z10;
        }

        /* renamed from: a, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsHomeLauncher() {
            return this.isHomeLauncher;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ForegroundApp)) {
                return false;
            }
            ForegroundApp foregroundApp = (ForegroundApp) other;
            return kotlin.jvm.internal.p.d(this.packageName, foregroundApp.packageName) && kotlin.jvm.internal.p.d(this.label, foregroundApp.label) && this.isHomeLauncher == foregroundApp.isHomeLauncher;
        }

        public int hashCode() {
            int iHashCode = this.packageName.hashCode() * 31;
            String str = this.label;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isHomeLauncher);
        }

        public String toString() {
            return "ForegroundApp(packageName=" + this.packageName + ", label=" + this.label + ", isHomeLauncher=" + this.isHomeLauncher + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/common/utils/r$b;", "", "Lcom/stepos/ailauncher/common/utils/r$a;", "app", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/common/utils/r$a;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
        void a(ForegroundApp app);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"com/stepos/ailauncher/common/utils/r$c", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "(Landroid/app/Activity;)V", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements Application.ActivityLifecycleCallbacks {
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
            r.INSTANCE.z();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
            r.INSTANCE.z();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            kotlin.jvm.internal.p.i(activity, "activity");
            kotlin.jvm.internal.p.i(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.p.i(activity, "activity");
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/common/utils/r$d", "Lcom/stepos/ailauncher/common/utils/J$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements J.a {
        public static final Y8.t d() {
            r.INSTANCE.p();
            return Y8.t.f7040a;
        }

        @Override // com.stepos.ailauncher.common.utils.J.a
        public void a() {
            r.INSTANCE.z();
        }

        @Override // com.stepos.ailauncher.common.utils.J.a
        public void b() {
            r.INSTANCE.B(new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.utils.s
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return r.d.d();
                }
            });
        }
    }

    public static final void A() {
        INSTANCE.Q();
    }

    public static final void C(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public static /* synthetic */ void E(r rVar, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z12 = false;
        }
        rVar.D(z10, z11, z12);
    }

    public static final Y8.t F(boolean z10, boolean z11, boolean z12) {
        boolean z13 = false;
        boolean z14 = z10 && z11;
        if (kotlin.jvm.internal.p.d(overlayVisible, Boolean.TRUE) && z10 && !z11) {
            z13 = true;
        }
        if (!kotlin.jvm.internal.p.d(overlayVisible, Boolean.valueOf(z14))) {
            overlayVisible = Boolean.valueOf(z14);
            Log.d(TAG, "overlay visible=" + z14 + " host=" + z10 + " panel=" + z11);
            if (initialized.get()) {
                INSTANCE.Q();
            }
        }
        if (initialized.get() && z12 && z13 && session.f()) {
            Handler handler = mainHandler;
            Runnable runnable = pollRunnable;
            handler.removeCallbacks(runnable);
            handler.post(runnable);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t H(boolean z10) {
        session.i(z10, SystemClock.elapsedRealtime());
        if (initialized.get()) {
            INSTANCE.Q();
        }
        return Y8.t.f7040a;
    }

    public static final String J(boolean z10) {
        if (z10) {
            return null;
        }
        return INSTANCE.R();
    }

    public static final String K() {
        return INSTANCE.q();
    }

    public static final void L() {
        INSTANCE.I();
    }

    public static final void N() {
        INSTANCE.Q();
    }

    public static final Y8.t P(long j10, String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j10;
        if (jElapsedRealtime > suppressLeaveUntilElapsed) {
            suppressLeaveUntilElapsed = jElapsedRealtime;
        }
        if (initialized.get()) {
            INSTANCE.Q();
        }
        if (str.length() > 0) {
            Log.d(TAG, "suppress leave " + j10 + "ms reason=" + str);
        }
        return Y8.t.f7040a;
    }

    public static final void s(boolean z10) {
        INSTANCE.z();
    }

    public static final Y8.t y() {
        session.g();
        if (initialized.get()) {
            INSTANCE.Q();
        }
        return Y8.t.f7040a;
    }

    public final void B(final InterfaceC5063a<Y8.t> action) {
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            action.invoke();
        } else {
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.common.utils.m
                @Override // java.lang.Runnable
                public final void run() {
                    r.C(action);
                }
            });
        }
    }

    public final void D(final boolean hostForeground, final boolean panelOpen, final boolean returningHome) {
        B(new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.utils.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return r.F(hostForeground, panelOpen, returningHome);
            }
        });
    }

    public final void G(final boolean visible) {
        B(new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.utils.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return r.H(visible);
            }
        });
    }

    public final void I() {
        Q();
        u uVar = session;
        if (!uVar.getDetecting() || uVar.getInRecents()) {
            return;
        }
        final boolean zT = t();
        String strK = uVar.k(com.stepos.ailauncher.common.privacy.b.INSTANCE.b(), SystemClock.elapsedRealtime(), new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.utils.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return r.J(zT);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.utils.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return r.K();
            }
        });
        if (!uVar.getDetecting()) {
            Handler handler = mainHandler;
            handler.removeCallbacks(pollRunnable);
            handler.removeCallbacks(settleRunnable);
            if (strK == null) {
                Log.d(TAG, "departure cancelled or timed out");
            }
        }
        if (strK != null) {
            w(strK);
        }
    }

    public final String M(String packageName) {
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            return null;
        }
        try {
            Context context = appContext;
            if (context == null) {
                kotlin.jvm.internal.p.A("appContext");
                context = null;
            }
            PackageManager packageManager = context.getPackageManager();
            String string = packageManager.getApplicationInfo(packageName, 0).loadLabel(packageManager).toString();
            if (La.H.x0(string)) {
                return null;
            }
            return string;
        } catch (Throwable th) {
            Log.w(TAG, "resolve label failed: " + th.getMessage());
            return null;
        }
    }

    public final void O(final long durationMs, final String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        B(new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.utils.q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return r.P(durationMs, reason);
            }
        });
    }

    public final void Q() {
        u uVar = session;
        if (!uVar.getHasEnteredHome()) {
            p();
            return;
        }
        if (!v()) {
            p();
            return;
        }
        if (u()) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (t()) {
                uVar.h(true, jElapsedRealtime);
            } else {
                p();
            }
            Handler handler = mainHandler;
            handler.removeCallbacks(pollRunnable);
            handler.removeCallbacks(settleRunnable);
            return;
        }
        boolean zC = uVar.getDetecting();
        boolean zT = t();
        uVar.h(zT, SystemClock.elapsedRealtime());
        if (zT && uVar.getDetecting()) {
            Handler handler2 = mainHandler;
            Runnable runnable = settleRunnable;
            if (!handler2.hasCallbacks(runnable)) {
                handler2.postDelayed(runnable, 400L);
            }
        } else {
            mainHandler.removeCallbacks(settleRunnable);
        }
        if (!uVar.getDetecting() || uVar.getInRecents()) {
            mainHandler.removeCallbacks(pollRunnable);
            return;
        }
        Handler handler3 = mainHandler;
        Runnable runnable2 = pollRunnable;
        if (handler3.hasCallbacks(runnable2)) {
            return;
        }
        handler3.postDelayed(runnable2, zC ? 200L : POLL_START_DELAY_MS);
        if (zC) {
            return;
        }
        Log.d(TAG, "host left, start polling");
    }

    public final String R() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        ComponentName componentName;
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            return null;
        }
        try {
            Context context = appContext;
            if (context == null) {
                kotlin.jvm.internal.p.A("appContext");
                context = null;
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            String packageName = (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || (runningTaskInfo = (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks)) == null || (componentName = runningTaskInfo.topActivity) == null) ? null : componentName.getPackageName();
            t tVar = t.INSTANCE;
            List<String> listQ = C1173v.q(packageName);
            Context context2 = appContext;
            if (context2 == null) {
                kotlin.jvm.internal.p.A("appContext");
                context2 = null;
            }
            String packageName2 = context2.getPackageName();
            kotlin.jvm.internal.p.h(packageName2, "getPackageName(...)");
            return tVar.d(listQ, packageName2);
        } catch (Throwable th) {
            Log.w(TAG, "getRunningTasks failed: " + th.getMessage());
            return null;
        }
    }

    public final void o(b listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        listeners.add(listener);
    }

    public final void p() {
        session.a();
        Handler handler = mainHandler;
        handler.removeCallbacks(pollRunnable);
        handler.removeCallbacks(settleRunnable);
    }

    public final String q() {
        ActivityInfo activityInfo;
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            return null;
        }
        try {
            Intent intentAddCategory = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
            kotlin.jvm.internal.p.h(intentAddCategory, "addCategory(...)");
            Context context = appContext;
            if (context == null) {
                kotlin.jvm.internal.p.A("appContext");
                context = null;
            }
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intentAddCategory, 65536);
            if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) {
                return null;
            }
            return activityInfo.packageName;
        } catch (Throwable th) {
            Log.w(TAG, "resolve home package failed: " + th.getMessage());
            return null;
        }
    }

    public final void r(Application app) {
        kotlin.jvm.internal.p.i(app, "app");
        if (initialized.compareAndSet(false, true)) {
            Context applicationContext = app.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            appContext = applicationContext;
            app.registerActivityLifecycleCallbacks(new c());
            y.INSTANCE.c(new y.a() { // from class: com.stepos.ailauncher.common.utils.o
                @Override // com.stepos.ailauncher.common.utils.y.a
                public final void a(boolean z10) {
                    r.s(z10);
                }
            });
            J j10 = J.INSTANCE;
            Context context = appContext;
            if (context == null) {
                kotlin.jvm.internal.p.A("appContext");
                context = null;
            }
            J.c(j10, context, new d(), false, 4, null);
            z();
            Log.i(TAG, "initialized");
        }
    }

    public final boolean t() {
        return t.INSTANCE.a(C3202f.INSTANCE.e(), y.INSTANCE.d(), overlayVisible, session.getInRecents());
    }

    public final boolean u() {
        return SystemClock.elapsedRealtime() < suppressLeaveUntilElapsed;
    }

    public final boolean v() {
        J j10 = J.INSTANCE;
        Context context = appContext;
        if (context == null) {
            kotlin.jvm.internal.p.A("appContext");
            context = null;
        }
        boolean zF = j10.f(context);
        boolean z10 = false;
        if (zF) {
            return false;
        }
        Context context2 = appContext;
        if (context2 == null) {
            kotlin.jvm.internal.p.A("appContext");
            context2 = null;
        }
        Object systemService = context2.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
            z10 = true;
        }
        return true ^ z10;
    }

    public final void w(String packageName) {
        Object objB;
        if (session.getHasEnteredHome()) {
            ForegroundApp foregroundApp = new ForegroundApp("", "", false);
            ForegroundApp foregroundApp2 = (packageName.length() <= 0 || !com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) ? foregroundApp : new ForegroundApp(packageName, M(packageName), kotlin.jvm.internal.p.d(packageName, q()));
            Log.i(TAG, "host departure confirmed");
            for (b bVar : listeners) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    bVar.a(com.stepos.ailauncher.common.privacy.b.INSTANCE.b() ? foregroundApp2 : foregroundApp);
                    objB = Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    Log.w(TAG, "listener callback failed", thE);
                }
            }
        }
    }

    public final void x() {
        B(new InterfaceC5063a() { // from class: com.stepos.ailauncher.common.utils.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return r.y();
            }
        });
    }

    public final void z() {
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.common.utils.h
            @Override // java.lang.Runnable
            public final void run() {
                r.A();
            }
        });
    }
}
