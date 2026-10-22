package com.bytedance.frameworks.baselib.network;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import com.bytedance.common.utility.collection.WeakHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class LifeCycleMonitor implements Application.ActivityLifecycleCallbacks {
    private static boolean mAppAlive;
    private static WeakHandler sHandler;
    private List<a> mListeners;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Runnable f7954b;

        public abstract void c();

        public abstract void d();

        public a() {
            this.f7953a = 30000;
            this.f7954b = new AnonymousClass1(this);
        }

        public a(int r2) {
            this.f7953a = 30000;
            this.f7954b = new AnonymousClass1(this);
            this.f7953a = r2;
        }

        public Runnable a() {
            return this.f7954b;
        }

        public int b() {
            return this.f7953a;
        }

        public void a(int r1) {
            this.f7953a = r1;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    static /* synthetic */ boolean access$000() {
        return mAppAlive;
    }

    static /* synthetic */ boolean access$002(boolean r0) {
        mAppAlive = r0;
        return r0;
    }

    static {
        sHandler = new WeakHandler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public LifeCycleMonitor() {
        this.mListeners = new CopyOnWriteArrayList();
        if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin")) == null) goto L6;
        mAppAlive = true;
        return;
    }

    private static Activity getActivity() {
        Class r2 = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Object r3 = r2.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L14
        Field r4 = r2.getDeclaredField("mActivities");     // Catch: Throwable -> L14
        r4.setAccessible(true);     // Catch: Throwable -> L14
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r4.get(r3), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r5 != null) goto L6;
        return null;
    L6:
        Iterator r6 = r5.values().iterator();     // Catch: Throwable -> L14
    L8:
        if (r6.hasNext() == false) goto L13;
        Object r7 = r6.next();     // Catch: Throwable -> L14
        Class<?> r8 = r7.getClass();     // Catch: Throwable -> L14
        Field r9 = r8.getDeclaredField("paused");     // Catch: Throwable -> L14
        r9.setAccessible(true);     // Catch: Throwable -> L14
        if (r9.getBoolean(r7) == true) goto L8;
        Field r10 = r8.getDeclaredField("activity");     // Catch: Throwable -> L14
        r10.setAccessible(true);     // Catch: Throwable -> L14
        return (Activity) ZeusTransformUtils.preCheckCast(r10.get(r7), Activity.class, "com.obric.aiagent.plugin");
    L13:
        return null;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void addListener(a r1) {
        this.mListeners.add(r1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (mAppAlive == true) goto L8;
        mAppAlive = true;
        Iterator<a> r2 = this.mListeners.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        ((a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.aiagent.plugin")).c();
    L8:
        sHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
        if (mAppAlive == false) goto L8;
        Iterator<a> r5 = this.mListeners.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.aiagent.plugin");
        sHandler.postDelayed(r8.a(), r8.b());
        goto L6
    L10:
        return;
    }
}
