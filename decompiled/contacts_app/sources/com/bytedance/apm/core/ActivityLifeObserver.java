package com.bytedance.apm.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityLifeObserver implements Application.ActivityLifecycleCallbacks, IActivityLifeManager {
    private static final long CHECK_DELAY = 600;
    private static final String TAG = "ActivityLifeObserver";
    private static final ActivityLifeObserver mInstance = null;
    private boolean mChangingConfigActivity;
    private String mCurActivityHash;
    private int mFrontActivityCount;
    private volatile boolean mIsFrontV2;
    private ArrayList<ILifecycle> mLifecycleObservers;
    private ArrayList<IActivityLifeObserver> mObservers;
    private String mTopActivityClassName;
    private WeakReference<Activity> mTopActivityRef;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    static {
        mInstance = new ActivityLifeObserver();
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public boolean isForeground() {
        return this.mIsFrontV2;
    }

    public boolean isV2Foreground() {
        return this.mIsFrontV2;
    }

    private ActivityLifeObserver() {
        this.mObservers = new ArrayList(8);
        this.mLifecycleObservers = new ArrayList(8);
        this.mTopActivityClassName = null;
    }

    private void initWithApp(Application r1) {
        if (r1 == null) goto L5;
        r1.unregisterActivityLifecycleCallbacks(this);
        r1.registerActivityLifecycleCallbacks(this);
        return;
    }

    public static void init(Application r1) {
        mInstance.initWithApp(r1);
    }

    public static ActivityLifeObserver getInstance() {
        return mInstance;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void register(IActivityLifeObserver r2) {
        ArrayList<IActivityLifeObserver> r0 = this.mObservers;
        if (r0 == null) goto L11;
        monitor-enter(r0);
        this.mObservers.add(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void unregister(IActivityLifeObserver r2) {
        ArrayList<IActivityLifeObserver> r0 = this.mObservers;
        if (r0 == null) goto L11;
        monitor-enter(r0);
        this.mObservers.remove(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void register(ILifecycle r2) {
        ArrayList<ILifecycle> r0 = this.mLifecycleObservers;
        if (r0 == null) goto L11;
        monitor-enter(r0);
        this.mLifecycleObservers.add(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unregister(ILifecycle r2) {
        ArrayList<ILifecycle> r0 = this.mLifecycleObservers;
        if (r0 == null) goto L11;
        monitor-enter(r0);
        this.mLifecycleObservers.remove(r2);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r7) {
        this.mTopActivityRef = new WeakReference(r7);
        this.mTopActivityClassName = null;
        Object[] r1 = collectObservers();
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        ((IActivityLifeObserver) r1[r4]).onActivityResume(r7);
        r4 = r4 + 1;
        goto L3
    L5:
        Iterator<ILifecycle> r5 = this.mLifecycleObservers.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r5.next().onActivityResumed(r7);
        goto L7
    L9:
        String r6 = getActivityHash(r7);
        if (r6.equals(this.mCurActivityHash) == true) goto L19;
        int r8 = r1.length;
    L12:
        if (r3 >= r8) goto L14;
        ((IActivityLifeObserver) r1[r3]).onChange(r7, null);
        r3 = r3 + 1;
        goto L12
    L14:
        this.mCurActivityHash = r6;
        return;
    }

    private void notifyFront(Activity r5) {
        Object[] r0 = collectObservers();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        ((IActivityLifeObserver) r0[r2]).onFront(r5);
        r2 = r2 + 1;
        goto L3
    L5:
        Iterator<ILifecycle> r4 = this.mLifecycleObservers.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r4.next().onFront(r5);
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r4) {
        Object[] r3 = collectObservers();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((IActivityLifeObserver) r3[r1]).onActivityPause(r4);
        r1 = r1 + 1;
        goto L3
    }

    private void notifyBackground(Activity r5) {
        Object[] r0 = collectObservers();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        ((IActivityLifeObserver) r0[r2]).onBackground(r5);
        r2 = r2 + 1;
        goto L3
    L5:
        Iterator<ILifecycle> r4 = this.mLifecycleObservers.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r4.next().onBackground(r5);
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r5, Bundle r6) {
        Object[] r0 = collectObservers();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        ((IActivityLifeObserver) r0[r2]).onActivityCreated(r5, r6);
        r2 = r2 + 1;
        goto L3
    L5:
        Iterator<ILifecycle> r4 = this.mLifecycleObservers.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r4.next().onActivityCreated(r5, r6);
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r6) {
        Object[] r0 = collectObservers();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        ((IActivityLifeObserver) r0[r3]).onActivityStarted(r6);
        r3 = r3 + 1;
        goto L3
    L6:
        if (this.mChangingConfigActivity == false) goto L9;
        this.mChangingConfigActivity = false;
        return;
    L9:
        int r2 = this.mFrontActivityCount + 1;
        this.mFrontActivityCount = r2;
        if (r2 != 1) goto L14;
        this.mIsFrontV2 = true;
        notifyFront(r6);
        return;
    }

    private Object[] collectObservers() {
        ArrayList<IActivityLifeObserver> r0 = this.mObservers;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservers.size() <= 0) goto L7;
        Object[] r2 = this.mObservers.toArray();     // Catch: Throwable -> L12
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
        if (r3.isChangingConfigurations() == false) goto L6;
        this.mChangingConfigActivity = true;
        return;
    L6:
        int r0 = this.mFrontActivityCount - 1;
        this.mFrontActivityCount = r0;
        if (r0 != 0) goto L10;
        this.mIsFrontV2 = false;
        notifyBackground(r3);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r3) {
        if (getActivityHash(r3).equals(this.mCurActivityHash) == false) goto L5;
        this.mCurActivityHash = null;
    L5:
        Iterator<ILifecycle> r2 = this.mLifecycleObservers.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r2.next().onActivityDestroyed(r3);
        goto L7
    }

    private String getActivityHash(Activity r2) {
        return r2.getClass().getName() + r2.hashCode();
    }

    public WeakReference<Activity> getTopActivityRef() {
        return this.mTopActivityRef;
    }

    public String getTopActivityClassName() {
        WeakReference<Activity> r0 = this.mTopActivityRef;
        if (r0 != null) goto L5;
        return "";
    L5:
        Activity r1 = r0.get();
        if (r1 == null) goto L11;
        String r2 = this.mTopActivityClassName;
        if (r2 == null) goto L10;
        return r2;
    L10:
        return r1.getClass().getName();
    L11:
        return "";
    }
}
