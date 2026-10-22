package com.stepos.ailauncher.homegesture;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.container.m0;
import h8.C4148a;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.IntUnaryOperator;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import v9.C5685n;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001DB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u0003J\r\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\u0003J\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0006J\u0015\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0003J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018JG\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#J'\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u0004¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010\u0006J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b*\u0010+J!\u0010.\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b.\u0010/J\u0011\u00101\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00104R\u0014\u00106\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010\u001d\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010=R\u0014\u0010?\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010:R\u0014\u0010@\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010:R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/stepos/ailauncher/homegesture/J;", "", "<init>", "()V", "", "r", "()Z", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "l", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "f", "yielding", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "t", "()J", "", "reason", "fromSheet", "n", "(Ljava/lang/String;Z)V", "overlayOpen", "hostForeground", "topPackage", "selfPackage", "minusOneSheetForeground", "minusOneHasLayer", Const.INTENT_KEY_UMID, "(ZZLjava/lang/String;Ljava/lang/String;ZZ)Z", "topIsThirdParty", "c", "(Z)Z", "yieldMinusOne", "enteringOverview", "yieldHeldForGesture", "q", "(ZZZ)Z", "p", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "pkg", "self", "e", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lcom/stepos/ailauncher/homegesture/J$a;", "s", "()Lcom/stepos/ailauncher/homegesture/J$a;", "TAG", "Ljava/lang/String;", "LAUNCHER_PACKAGE", "SHEET_RESUME_PEEK_FLICKER_MS", "J", "Ljava/util/concurrent/atomic/AtomicBoolean;", "yieldingLatched", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicInteger;", "minusOneLayerCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "resumedMinusOneSheets", "gestureInFlight", "yieldAtGestureStart", "Ljava/util/concurrent/atomic/AtomicLong;", "yieldGestureStartedElapsed", "Ljava/util/concurrent/atomic/AtomicLong;", Const.INTENT_KEY_APIKEY, "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class J {
    private static final String LAUNCHER_PACKAGE = "com.android.launcher3";
    private static final long SHEET_RESUME_PEEK_FLICKER_MS = 280;
    private static final String TAG = "MinusOneCovering";
    public static final J INSTANCE = new J();
    private static final AtomicBoolean yieldingLatched = new AtomicBoolean(false);
    private static final AtomicBoolean minusOneSheetForeground = new AtomicBoolean(false);
    private static final AtomicInteger minusOneLayerCount = new AtomicInteger(0);
    private static final AtomicInteger resumedMinusOneSheets = new AtomicInteger(0);
    private static final AtomicBoolean gestureInFlight = new AtomicBoolean(false);
    private static final AtomicBoolean yieldAtGestureStart = new AtomicBoolean(false);
    private static final AtomicLong yieldGestureStartedElapsed = new AtomicLong(0);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/homegesture/J$a;", "", "", "packageName", "", "taskId", "<init>", "(Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "I", "getTaskId", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.homegesture.J$a, reason: from toString */
    public static final /* data */ class TopTask {
        private final String packageName;
        private final int taskId;

        public TopTask(String packageName, int i10) {
            kotlin.jvm.internal.p.i(packageName, "packageName");
            this.packageName = packageName;
            this.taskId = i10;
        }

        /* renamed from: a, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TopTask)) {
                return false;
            }
            TopTask topTask = (TopTask) other;
            return kotlin.jvm.internal.p.d(this.packageName, topTask.packageName) && this.taskId == topTask.taskId;
        }

        public int hashCode() {
            return (this.packageName.hashCode() * 31) + Integer.hashCode(this.taskId);
        }

        public String toString() {
            return "TopTask(packageName=" + this.packageName + ", taskId=" + this.taskId + ")";
        }
    }

    public static final int m(int i10) {
        return C5685n.f(i10 - 1, 0);
    }

    public static /* synthetic */ void o(J j10, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        j10.n(str, z10);
    }

    public final void b(String reason) {
        if (yieldingLatched.compareAndSet(true, false)) {
            C4148a.k(TAG, "clear yield latch reason=" + reason, false, 4, null);
        }
    }

    public final boolean c(boolean topIsThirdParty) {
        AtomicBoolean atomicBoolean = yieldingLatched;
        if (!atomicBoolean.get() && !gestureInFlight.get() && !yieldAtGestureStart.get()) {
            C4148a.d(TAG, "stale-yield-recheck skip not-stuck", false, 4, null);
            return false;
        }
        if (topIsThirdParty) {
            C4148a.k(TAG, "stale-yield-recheck still covering 3rd latched=" + atomicBoolean.get() + " yieldElapsed=" + t() + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
            return false;
        }
        C4148a.k(TAG, "stale-yield-recheck → landed sheetFg=" + minusOneSheetForeground.get() + " layers=" + minusOneLayerCount.get() + " latched=" + atomicBoolean.get() + " inFlight=" + gestureInFlight.get() + " yieldElapsed=" + t() + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
        g();
        b("stale-yield-peek-landing");
        return true;
    }

    public final boolean d(boolean overlayOpen, boolean hostForeground, String topPackage, String selfPackage, boolean minusOneSheetForeground2, boolean minusOneHasLayer) {
        if (!overlayOpen && !minusOneSheetForeground2 && !minusOneHasLayer) {
            b("no-minus-one-world");
            return false;
        }
        AtomicBoolean atomicBoolean = gestureInFlight;
        boolean z10 = atomicBoolean.get() && yieldAtGestureStart.get();
        if (hostForeground) {
            o(this, "overlay-host", false, 2, null);
            b("host-foreground");
            return false;
        }
        if (topPackage != null && topPackage.length() != 0 && e(topPackage, selfPackage)) {
            if (atomicBoolean.get() && !yieldAtGestureStart.get()) {
                C4148a.d(TAG, "ignore third-party top during dismiss gesture topPkg=" + topPackage, false, 4, null);
                return false;
            }
            if (yieldingLatched.compareAndSet(false, true)) {
                C4148a.k(TAG, "latch yield HOME topPkg=" + topPackage, false, 4, null);
            }
            return true;
        }
        if (!z10 && selfPackage != null && selfPackage.length() != 0 && kotlin.jvm.internal.p.d(topPackage, selfPackage)) {
            b("self-foreground");
            return false;
        }
        if (minusOneSheetForeground2 && !z10) {
            b("minus-one-sheet-foreground");
            return false;
        }
        if (!yieldingLatched.get()) {
            return false;
        }
        C4148a.k(TAG, "keep yield latch hostFg=" + hostForeground + " overlayOpen=" + overlayOpen + " holdingGesture=" + z10 + " sheetFg=" + minusOneSheetForeground2 + " layers=" + minusOneHasLayer + " inFlight=" + atomicBoolean.get() + " yieldStart=" + yieldAtGestureStart.get() + " yieldElapsed=" + t() + "ms topPkg=" + topPackage, false, 4, null);
        return true;
    }

    public final boolean e(String pkg, String self) {
        if (pkg.length() == 0 || kotlin.jvm.internal.p.d(pkg, "com.android.launcher3") || self == null || self.length() == 0) {
            return false;
        }
        return !kotlin.jvm.internal.p.d(pkg, self);
    }

    public final boolean f() {
        return yieldingLatched.get();
    }

    public final void g() {
        AtomicBoolean atomicBoolean = gestureInFlight;
        if (atomicBoolean.get() || yieldAtGestureStart.get()) {
            C4148a.k(TAG, "gesture ended latched=" + yieldingLatched.get() + " yieldElapsed=" + t() + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
        }
        atomicBoolean.set(false);
        yieldAtGestureStart.set(false);
    }

    public final void h(boolean yielding) {
        boolean z10 = true;
        gestureInFlight.set(true);
        if (!yielding && !yieldingLatched.get()) {
            z10 = false;
        }
        yieldAtGestureStart.set(z10);
        if (z10) {
            yieldGestureStartedElapsed.set(SystemClock.elapsedRealtime());
        } else {
            yieldGestureStartedElapsed.set(0L);
        }
        C4148a.k(TAG, "gesture started yield=" + z10 + " latched=" + yieldingLatched.get() + " sheetFg=" + minusOneSheetForeground.get() + " layers=" + minusOneLayerCount.get(), false, 4, null);
    }

    public final void i() {
        AtomicInteger atomicInteger = resumedMinusOneSheets;
        if (atomicInteger.decrementAndGet() <= 0) {
            atomicInteger.set(0);
            minusOneSheetForeground.set(false);
        }
    }

    public final void j() {
        minusOneLayerCount.incrementAndGet();
    }

    public final void k() {
        if (resumedMinusOneSheets.incrementAndGet() > 0) {
            minusOneSheetForeground.set(true);
        }
    }

    public final void l() {
        minusOneLayerCount.updateAndGet(new IntUnaryOperator() { // from class: com.stepos.ailauncher.homegesture.I
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i10) {
                return J.m(i10);
            }
        });
    }

    public final void n(String reason, boolean fromSheet) {
        kotlin.jvm.internal.p.i(reason, "reason");
        AtomicBoolean atomicBoolean = yieldingLatched;
        if (!atomicBoolean.get() && !yieldAtGestureStart.get() && !gestureInFlight.get()) {
            C4148a.d(TAG, "panel foreground skip (no stuck yield) reason=" + reason + " fromSheet=" + fromSheet, false, 4, null);
            return;
        }
        if (fromSheet && p()) {
            C4148a.k(TAG, "ignore sheet foreground during yield peek reason=" + reason + " dt=" + t() + "ms hostFg=" + m0.INSTANCE.g(), false, 4, null);
            return;
        }
        C4148a.k(TAG, "panel foreground → end stuck yield reason=" + reason + " latched=" + atomicBoolean.get() + " inFlight=" + gestureInFlight.get() + " yieldStart=" + yieldAtGestureStart.get(), false, 4, null);
        g();
        b("panel-foreground");
    }

    public final boolean p() {
        return gestureInFlight.get() && yieldAtGestureStart.get() && !m0.INSTANCE.g() && SystemClock.elapsedRealtime() - yieldGestureStartedElapsed.get() < 280;
    }

    public final boolean q(boolean yieldMinusOne, boolean enteringOverview, boolean yieldHeldForGesture) {
        if (enteringOverview) {
            return true;
        }
        return (yieldMinusOne || yieldHeldForGesture) ? false : true;
    }

    public final boolean r() {
        Object obj;
        Object objB;
        TopTask topTaskS;
        m0 m0Var = m0.INSTANCE;
        boolean zH = m0Var.h();
        boolean z10 = minusOneSheetForeground.get();
        boolean z11 = minusOneLayerCount.get() > 0;
        boolean z12 = zH || z10 || z11;
        boolean zG = m0Var.g();
        String packageName = null;
        if (!z12 || (topTaskS = s()) == null) {
            obj = null;
        } else {
            obj = null;
            packageName = topTaskS.getPackageName();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C3197a.INSTANCE.a().getPackageName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        boolean zG2 = Result.g(objB);
        Object obj2 = objB;
        if (zG2) {
            obj2 = obj;
        }
        return d(zH, zG, packageName, (String) obj2, z10, z11);
    }

    public final TopTask s() {
        Object objB;
        String packageName;
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            C4148a.d(TAG, "skip getRunningTasks: privacy not granted", false, 4, null);
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C3197a.INSTANCE.a());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Application application = (Application) objB;
        if (application == null) {
            return null;
        }
        try {
            activityManager = (ActivityManager) application.getSystemService(ActivityManager.class);
        } catch (Throwable unused) {
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null) ? null : (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks);
        if (runningTaskInfo == null) {
            return null;
        }
        ComponentName componentName = runningTaskInfo.topActivity;
        if (componentName == null || (packageName = componentName.getPackageName()) == null) {
            ComponentName componentName2 = runningTaskInfo.baseActivity;
            packageName = componentName2 != null ? componentName2.getPackageName() : null;
            if (packageName == null) {
                packageName = "";
            }
        }
        if (packageName.length() == 0 || kotlin.jvm.internal.p.d(packageName, "com.android.launcher3")) {
            return null;
        }
        Intent intent = runningTaskInfo.baseIntent;
        if (intent == null || !intent.hasCategory("android.intent.category.HOME")) {
            return new TopTask(packageName, runningTaskInfo.id);
        }
        return null;
    }

    public final long t() {
        if (!gestureInFlight.get() || !yieldAtGestureStart.get()) {
            return -1L;
        }
        long j10 = yieldGestureStartedElapsed.get();
        if (j10 <= 0) {
            return -1L;
        }
        return SystemClock.elapsedRealtime() - j10;
    }
}
