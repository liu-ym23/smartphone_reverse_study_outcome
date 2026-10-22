package com.bytedance.apm.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.apm.api.IActivityLifeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
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

    static {
        mInstance = new ActivityLifeObserver();
    }

    private ActivityLifeObserver() {
        this.mObservers = new ArrayList(8);
        this.mLifecycleObservers = new ArrayList(8);
        this.mTopActivityClassName = null;
    }

    private Object[] collectObservers() {
        ArrayList<IActivityLifeObserver> r10 = this.mObservers;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservers.size() <= 0) goto L9;
        Object[] r11 = this.mObservers.toArray();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L7
        if (r11 == null) goto L13;
        return r11;
    L13:
        return new Object[0];
    L9:
        r11 = null;
        goto L10
    }

    private String getActivityHash(Activity r10) {
        return r10.getClass().getName() + r10.hashCode();
    }

    public static ActivityLifeObserver getInstance() {
        return mInstance;
    }

    public static void init(Application r10) {
        mInstance.initWithApp(r10);
    }

    private void initWithApp(@NonNull Application r10) {
        if (r10 == null) goto L5;
        r10.unregisterActivityLifecycleCallbacks(this);
        r10.registerActivityLifecycleCallbacks(this);
        return;
    }

    private void notifyBackground(Activity r10) {
        Object[] r11 = collectObservers();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((IActivityLifeObserver) r11[r13]).onBackground(r10);
        r13 = r13 + 1;
        goto L3
    L5:
        Iterator<ILifecycle> r14 = this.mLifecycleObservers.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        r14.next().onBackground(r10);
        goto L7
    }

    private void notifyFront(Activity r10) {
        Object[] r11 = collectObservers();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((IActivityLifeObserver) r11[r13]).onFront(r10);
        r13 = r13 + 1;
        goto L3
    L5:
        Iterator<ILifecycle> r14 = this.mLifecycleObservers.iterator();
    L7:
        if (r14.hasNext() == false) goto L9;
        r14.next().onFront(r10);
        goto L7
    }

    public String getTopActivityClassName() {
        WeakReference<Activity> r10 = this.mTopActivityRef;
        if (r10 != null) goto L5;
        return "";
    L5:
        Activity r11 = r10.get();
        if (r11 == null) goto L11;
        String r12 = this.mTopActivityClassName;
        if (r12 == null) goto L10;
        return r12;
    L10:
        return r11.getClass().getName();
    L11:
        return "";
    }

    public WeakReference<Activity> getTopActivityRef() {
        return this.mTopActivityRef;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public boolean isForeground() {
        return this.mIsFrontV2;
    }

    public boolean isV2Foreground() {
        return this.mIsFrontV2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
        Object[] r12 = collectObservers();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        ((IActivityLifeObserver) r12[r14]).onActivityCreated(r10, r11);
        r14 = r14 + 1;
        goto L3
    L5:
        Iterator<ILifecycle> r15 = this.mLifecycleObservers.iterator();
    L7:
        if (r15.hasNext() == false) goto L9;
        r15.next().onActivityCreated(r10, r11);
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
        if (getActivityHash(r10).equals(this.mCurActivityHash) == false) goto L5;
        this.mCurActivityHash = null;
    L5:
        Iterator<ILifecycle> r11 = this.mLifecycleObservers.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r11.next().onActivityDestroyed(r10);
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        Object[] r11 = collectObservers();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ((IActivityLifeObserver) r11[r13]).onActivityPause(r10);
        r13 = r13 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        this.mTopActivityRef = new WeakReference(r10);
        this.mTopActivityClassName = null;
        Object[] r11 = collectObservers();
        int r12 = r11.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        ((IActivityLifeObserver) r11[r14]).onActivityResume(r10);
        r14 = r14 + 1;
        goto L3
    L5:
        Iterator<ILifecycle> r15 = this.mLifecycleObservers.iterator();
    L7:
        if (r15.hasNext() == false) goto L9;
        r15.next().onActivityResumed(r10);
        goto L7
    L9:
        String r16 = getActivityHash(r10);
        if (r16.equals(this.mCurActivityHash) == true) goto L19;
        int r17 = r11.length;
    L12:
        if (r13 >= r17) goto L14;
        ((IActivityLifeObserver) r11[r13]).onChange(r10, null);
        r13 = r13 + 1;
        goto L12
    L14:
        this.mCurActivityHash = r16;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r10) {
        Object[] r11 = collectObservers();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        ((IActivityLifeObserver) r11[r13]).onActivityStarted(r10);
        r13 = r13 + 1;
        goto L3
    L6:
        if (this.mChangingConfigActivity == false) goto L9;
        this.mChangingConfigActivity = false;
        return;
    L9:
        int r14 = this.mFrontActivityCount + 1;
        this.mFrontActivityCount = r14;
        if (r14 != 1) goto L14;
        this.mIsFrontV2 = true;
        notifyFront(r10);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r10) {
        if (r10.isChangingConfigurations() == false) goto L6;
        this.mChangingConfigActivity = true;
        return;
    L6:
        int r11 = this.mFrontActivityCount - 1;
        this.mFrontActivityCount = r11;
        if (r11 != 0) goto L10;
        this.mIsFrontV2 = false;
        notifyBackground(r10);
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void register(IActivityLifeObserver r10) {
        ArrayList<IActivityLifeObserver> r11 = this.mObservers;
        if (r11 == null) goto L11;
        monitor-enter(r11);
        this.mObservers.add(r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void unregister(IActivityLifeObserver r10) {
        ArrayList<IActivityLifeObserver> r11 = this.mObservers;
        if (r11 == null) goto L11;
        monitor-enter(r11);
        this.mObservers.remove(r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void register(ILifecycle r10) {
        ArrayList<ILifecycle> r11 = this.mLifecycleObservers;
        if (r11 == null) goto L11;
        monitor-enter(r11);
        this.mLifecycleObservers.add(r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unregister(ILifecycle r10) {
        ArrayList<ILifecycle> r11 = this.mLifecycleObservers;
        if (r11 == null) goto L11;
        monitor-enter(r11);
        this.mLifecycleObservers.remove(r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
