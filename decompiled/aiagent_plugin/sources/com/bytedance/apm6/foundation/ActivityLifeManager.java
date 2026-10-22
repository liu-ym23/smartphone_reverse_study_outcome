package com.bytedance.apm6.foundation;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.apm6.service.d.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ActivityLifeManager implements Application.ActivityLifecycleCallbacks, com.bytedance.apm6.service.d.a {
    private boolean changingConfigActivity;
    private int frontActivityCount;
    private volatile boolean isFront;
    private final ArrayList<c> observers;
    private String topActivityClassName;
    private WeakReference<Activity> topActivityRef;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    public ActivityLifeManager() {
        this.observers = new ArrayList();
        this.topActivityClassName = null;
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        r0.unregisterActivityLifecycleCallbacks(this);
        r0.registerActivityLifecycleCallbacks(this);
    }

    @Override // com.bytedance.apm6.service.d.a
    public boolean isForeground() {
        return this.isFront;
    }

    @Override // com.bytedance.apm6.service.d.a
    public void register(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        ArrayList<c> r0 = this.observers;
        monitor-enter(r0);
        this.observers.add(r4);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm6.service.d.a
    public void unregister(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        ArrayList<c> r0 = this.observers;
        monitor-enter(r0);
        this.observers.remove(r4);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm6.service.d.a
    public String getTopActivityClassName() {
        WeakReference<Activity> r0 = this.topActivityRef;
        if (r0 != null) goto L5;
        return "";
    L5:
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(r0.get(), Activity.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        String r4 = this.topActivityClassName;
        if (r4 == null) goto L10;
        return r4;
    L10:
        return r1.getClass().getCanonicalName();
    L11:
        return "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
        this.topActivityRef = new WeakReference(r7);
        this.topActivityClassName = null;
        Object[] r5 = collectObservers();
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((c) ZeusTransformUtils.preCheckCast(r5[r2], c.class, "com.obric.aiagent.plugin")).e(r7);
        r2 = r2 + 1;
        goto L3
    }

    private void notifyFront(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
        Object[] r5 = collectObservers();
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((c) ZeusTransformUtils.preCheckCast(r5[r2], c.class, "com.obric.aiagent.plugin")).a(r7);
        r2 = r2 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
        Object[] r5 = collectObservers();
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((c) ZeusTransformUtils.preCheckCast(r5[r2], c.class, "com.obric.aiagent.plugin")).d(r7);
        r2 = r2 + 1;
        goto L3
    }

    private void notifyBackground(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
        Object[] r5 = collectObservers();
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((c) ZeusTransformUtils.preCheckCast(r5[r2], c.class, "com.obric.aiagent.plugin")).b(r7);
        r2 = r2 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r5, Bundle r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin");
        Object[] r4 = collectObservers();
        int r8 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L5;
        ((c) ZeusTransformUtils.preCheckCast(r4[r1], c.class, "com.obric.aiagent.plugin")).c(r7);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.aiagent.plugin");
        Object[] r0 = collectObservers();
        int r2 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L6;
        ((c) ZeusTransformUtils.preCheckCast(r0[r4], c.class, "com.obric.aiagent.plugin")).f(r9);
        r4 = r4 + 1;
        goto L3
    L6:
        if (this.changingConfigActivity == false) goto L9;
        this.changingConfigActivity = false;
        return;
    L9:
        int r1 = this.frontActivityCount + 1;
        this.frontActivityCount = r1;
        if (r1 != 1) goto L14;
        this.isFront = true;
        notifyFront(r9);
        return;
    }

    private Object[] collectObservers() {
        ArrayList<c> r0 = this.observers;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.observers.size() <= 0) goto L7;
        Object[] r2 = this.observers.toArray();     // Catch: Throwable -> L12
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (r2 == null) goto L11;
        return r2;
    L11:
        return new Object[0];
    L7:
        r2 = null;
        goto L8
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (r4.isChangingConfigurations() == false) goto L6;
        this.changingConfigActivity = true;
        return;
    L6:
        int r0 = this.frontActivityCount - 1;
        this.frontActivityCount = r0;
        if (r0 != 0) goto L10;
        this.isFront = false;
        notifyBackground(r4);
        return;
    }
}
