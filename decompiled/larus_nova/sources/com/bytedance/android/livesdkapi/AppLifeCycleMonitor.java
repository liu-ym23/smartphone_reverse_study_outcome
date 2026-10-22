package com.bytedance.android.livesdkapi;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.base.BaseNextLiveData;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0007J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0019\u001a\u00020\tJ\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0006\u0010\u001d\u001a\u00020\tJ\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0006H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/AppLifeCycleMonitor;", "", "()V", "activityStack", "Ljava/util/Stack;", "Ljava/lang/ref/SoftReference;", "Landroid/app/Activity;", "appEnterBackgroundSubject", "Lcom/bytedance/android/livesdkapi/base/BaseNextLiveData;", "", "isInit", "lifecycleCallbacks", "", "Landroid/app/Application$ActivityLifecycleCallbacks;", "mIsAppBackground", "mLastTimeEnterBackground", "", "mTopActivityRef", "Ljava/lang/ref/WeakReference;", "addLifecycleCallback", "", "callback", "getAppEnterBackgroundOb", "Landroidx/lifecycle/MutableLiveData;", "getTopActivity", "hasWindowFocus", "init", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isAppBackground", "removeActivityFromStack", "activity", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppLifeCycleMonitor {
    public static final AppLifeCycleMonitor INSTANCE = null;
    private static Stack<SoftReference<Activity>> activityStack;
    private static final BaseNextLiveData<Boolean> appEnterBackgroundSubject = null;
    private static boolean isInit;
    private static final Set<Application.ActivityLifecycleCallbacks> lifecycleCallbacks = null;
    private static volatile boolean mIsAppBackground;
    private static volatile long mLastTimeEnterBackground;
    private static WeakReference<Activity> mTopActivityRef;

    private AppLifeCycleMonitor() {
    }

    static {
        INSTANCE = new AppLifeCycleMonitor();
        BaseNextLiveData<Boolean> r100 = new BaseNextLiveData();
        r100.setValue(Boolean.FALSE);
        appEnterBackgroundSubject = r100;
        activityStack = new Stack();
        lifecycleCallbacks = new LinkedHashSet();
    }

    public final Activity getTopActivity() {
        WeakReference<Activity> r100 = mTopActivityRef;
        if (r100 == null) goto L5;
        Activity r101 = r100.get();
    L6:
        if (r101 != null) goto L8;
    L10:
        Stack<SoftReference<Activity>> r102 = activityStack;
        monitor-enter(r102);
    L31:
    L28:
        th = move-exception;
        throw th;
    L13:
        if (activityStack.empty() == true) goto L25;
        SoftReference<Activity> r103 = activityStack.peek();     // Catch: Throwable -> L28
        if (r103 == null) goto L17;
        Activity r104 = r103.get();     // Catch: Throwable -> L28
    L18:
        if (r104 == null) goto L24;
        if (r104.isDestroyed() == true) goto L24;
        monitor-exit(r102);
        return r104;
    L24:
        activityStack.pop();     // Catch: Throwable -> L28
        goto L31
    L17:
        r104 = null;
        goto L18
    L25:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r102);
        return null;
    L8:
        if (r101.isDestroyed() == true) goto L10;
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean hasWindowFocus() {
        WeakReference<Activity> r100 = mTopActivityRef;
        if (r100 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNull(r100);
        Activity r101 = r100.get();
        if (r101 != null) goto L8;
        return false;
    L8:
        Window r102 = r101.getWindow();
        if (r102 != null) goto L12;
        return false;
    L12:
        return INVOKEVIRTUAL_com_bytedance_android_livesdkapi_AppLifeCycleMonitor_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r102).hasWindowFocus();
    }

    public final MutableLiveData<Boolean> getAppEnterBackgroundOb() {
        return appEnterBackgroundSubject;
    }

    public final boolean isAppBackground() {
        return mIsAppBackground;
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_livesdkapi_AppLifeCycleMonitor_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ Stack access$getActivityStack$p(AppLifeCycleMonitor r100) {
        return activityStack;
    }

    public static final /* synthetic */ BaseNextLiveData access$getAppEnterBackgroundSubject$p(AppLifeCycleMonitor r100) {
        return appEnterBackgroundSubject;
    }

    public static final /* synthetic */ Set access$getLifecycleCallbacks$p(AppLifeCycleMonitor r100) {
        return lifecycleCallbacks;
    }

    public static final /* synthetic */ boolean access$getMIsAppBackground$p(AppLifeCycleMonitor r100) {
        return mIsAppBackground;
    }

    public static final /* synthetic */ long access$getMLastTimeEnterBackground$p(AppLifeCycleMonitor r100) {
        return mLastTimeEnterBackground;
    }

    public static final /* synthetic */ WeakReference access$getMTopActivityRef$p(AppLifeCycleMonitor r100) {
        return mTopActivityRef;
    }

    private final void removeActivityFromStack(Activity r100) {
        Stack<SoftReference<Activity>> r101 = activityStack;
        monitor-enter(r101);
        Iterator<SoftReference<Activity>> r102 = activityStack.iterator();     // Catch: Throwable -> L19
    L6:
        if (r102.hasNext() == false) goto L16;
        SoftReference<Activity> r103 = r102.next();     // Catch: Throwable -> L19
        if (r103 == null) goto L10;
        Activity r104 = r103.get();     // Catch: Throwable -> L19
    L11:
        if (r104 == null) goto L15;
        if (r104 == r100) goto L15;
        if (r104.isDestroyed() == false) goto L6;
    L15:
        r102.remove();     // Catch: Throwable -> L19
        goto L6
    L10:
        r104 = null;
        goto L11
    L16:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r101);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final void addLifecycleCallback(Application.ActivityLifecycleCallbacks r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        lifecycleCallbacks.add(r100);
    }

    public final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (isInit == false) goto L5;
        return;
    L5:
        if ((r100.getApplicationContext() instanceof Application) == false) goto L16;
        Context r101 = r100.getApplicationContext();
        if ((r101 instanceof Application) == true) goto L10;
        r101 = null;
    L10:
        Application r102 = (Application) r101;
        if (r102 != null) goto L13;
        return;
    L13:
        isInit = true;
        r102.registerActivityLifecycleCallbacks(new AnonymousClass1());
        return;
    }

    public static final /* synthetic */ void access$removeActivityFromStack(AppLifeCycleMonitor r100, Activity r101) {
        r100.removeActivityFromStack(r101);
    }

    public static final /* synthetic */ void access$setActivityStack$p(AppLifeCycleMonitor r100, Stack r101) {
        activityStack = r101;
    }

    public static final /* synthetic */ void access$setMIsAppBackground$p(AppLifeCycleMonitor r100, boolean r101) {
        mIsAppBackground = r101;
    }

    public static final /* synthetic */ void access$setMLastTimeEnterBackground$p(AppLifeCycleMonitor r100, long r101) {
        mLastTimeEnterBackground = r101;
    }

    public static final /* synthetic */ void access$setMTopActivityRef$p(AppLifeCycleMonitor r100, WeakReference r101) {
        mTopActivityRef = r101;
    }
}
