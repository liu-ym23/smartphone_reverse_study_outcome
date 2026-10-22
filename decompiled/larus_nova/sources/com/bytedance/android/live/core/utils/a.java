package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<Activity> f66107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedList<Activity> f66108b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f66109c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1095a f66110d = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.utils.a$a, reason: collision with other inner class name */
    public static final class C1095a implements Application.ActivityLifecycleCallbacks {
        public C1095a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            WeakReference<Activity> r101 = a.f66107a;
            Object r102 = a.f66109c;
            monitor-enter(r102);
            a.f66108b.remove(r100);     // Catch: Throwable -> L7
            monitor-exit(r102);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            WeakReference<Activity> r101 = a.f66107a;
            WeakReference<Activity> r102 = a.f66107a;
            if (r102 == null) goto L5;
            Activity r103 = r102.get();
        L7:
            if (Intrinsics.areEqual(r103, r100) == false) goto L10;
            a.f66107a = null;
            return;
        L10:
            return;
        L5:
            r103 = null;
            goto L7
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            WeakReference<Activity> r101 = a.f66107a;
            a.f66107a = new WeakReference(r100);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            WeakReference<Activity> r102 = a.f66107a;
            Object r103 = a.f66109c;
            monitor-enter(r103);
            LinkedList<Activity> r104 = a.f66108b;     // Catch: Throwable -> L7
            r104.remove(r100);     // Catch: Throwable -> L7
            r104.add(r100);     // Catch: Throwable -> L7
            monitor-exit(r103);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        f66108b = new LinkedList();
        f66109c = new Object();
        f66110d = new C1095a();
    }

    public static Activity b() {
        Object r100 = f66109c;
        monitor-enter(r100);
        LinkedList<Activity> r101 = f66108b;     // Catch: Throwable -> L11
        if (r101.size() < 2) goto L8;
        Activity r102 = r101.get(r101.size() - 2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);
        return r102;
    L8:
        r102 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public static Activity d() {
        Object r100 = f66109c;
        monitor-enter(r100);
        IMiddlewareHostApp r101 = (IMiddlewareHostApp) jc1.k.f(IMiddlewareHostApp.class);     // Catch: Throwable -> L16
        if (r101 == null) goto L7;
        Activity r102 = r101.getTopActivity();     // Catch: Throwable -> L16
    L8:
        if (r102 != null) goto L10;
    L14:
        monitor-exit(r100);
        return r102;
    L10:
        if (r102.isFinishing() == false) goto L14;
        LinkedList<Activity> r103 = f66108b;     // Catch: Throwable -> L16
        if ((!r103.isEmpty()) == false) goto L14;
        r103.removeLast();     // Catch: Throwable -> L16
        r102 = d();     // Catch: Throwable -> L16
        goto L14
    L7:
        r102 = null;
    L16:
        th = move-exception;
        throw th;
    }

    public static boolean e(Context r100) {
        if ((r100 instanceof Activity) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r100, d());
    }

    public static Intent a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "packageName");
        PackageManager r102 = r100.getPackageManager();
        Intent r103 = new Intent("android.intent.action.MAIN");
        r103.addCategory("android.intent.category.LAUNCHER");
        r103.setFlags(270532608);
        List<ResolveInfo> r104 = r102.queryIntentActivities(r103, 1);
        int r105 = r104.size();
        int r106 = 0;
    L4:
        if (r106 >= r105) goto L9;
        ResolveInfo r107 = (ResolveInfo) ListProtector.get(r104, r106);
        if (Intrinsics.areEqual(r107.activityInfo.packageName, r101) == true) goto L7;
        r106 = r106 + 1;
        goto L4
    L7:
        String r108 = r107.activityInfo.name;
    L11:
        if (TextUtils.isEmpty(r108) == false) goto L13;
        return null;
    L13:
        if (r108 == null) goto L15;
        r103.setComponent(new ComponentName(r101, r108));
    L15:
        return r103;
    L9:
        r108 = null;
        goto L11
    }

    @JvmStatic
    public static final Context c(Context r100, boolean r101) {
        if (r101 == false) goto L11;
        Activity r102 = b();
        if (r102 == null) goto L6;
        return r102;
    L6:
        if (f66108b.size() == 0) goto L8;
        return r102;
    L8:
        if (d() != null) goto L10;
        return r102;
    L10:
        return d();
    L11:
        if (r100 != null) goto L13;
    L16:
        Context r103 = d();
    L17:
        if (r103 != null) goto L19;
        return r100;
    L19:
        if ((r103 instanceof Activity) == true) goto L21;
        return r100;
    L21:
        if (((Activity) r103).isFinishing() == false) goto L23;
        return r100;
    L23:
        return r103;
    L13:
        if ((r100 instanceof Activity) == false) goto L16;
        r103 = r100;
        goto L17
    }
}
