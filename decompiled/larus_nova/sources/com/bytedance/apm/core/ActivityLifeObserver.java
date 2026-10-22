package com.bytedance.apm.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.services.apm.api.IActivityLifeManager;
import gs3.c;
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
    private ArrayList<c> mLifecycleObservers;
    private ArrayList<ff7.c> mObservers;
    private String mTopActivityClassName;
    private WeakReference<Activity> mTopActivityRef;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    static {
        mInstance = new ActivityLifeObserver();
    }

    private Object[] collectObservers() {
        ArrayList<ff7.c> r100 = this.mObservers;
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservers.size() <= 0) goto L7;
        Object[] r101 = this.mObservers.toArray();     // Catch: Throwable -> L13
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        return r101;
    L11:
        return new Object[0];
    L7:
        r101 = null;
        goto L8
    }

    public String getTopActivityClassName() {
        WeakReference<Activity> r100 = this.mTopActivityRef;
        String r101 = "";
        if (r100 != null) goto L5;
        return "";
    L5:
        Activity r102 = r100.get();
        if (r102 == null) goto L11;
        r101 = this.mTopActivityClassName;
        if (r101 != null) goto L11;
        return r102.getClass().getName();
    L11:
        return r101;
    }

    private ActivityLifeObserver() {
        this.mObservers = new ArrayList(8);
        this.mLifecycleObservers = new ArrayList(8);
        this.mTopActivityClassName = null;
    }

    public static ActivityLifeObserver getInstance() {
        return mInstance;
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

    private String getActivityHash(Activity r100) {
        return r100.getClass().getName() + r100.hashCode();
    }

    public static void init(Application r100) {
        mInstance.initWithApp(r100);
    }

    private void initWithApp(Application r100) {
        if (r100 == null) goto L5;
        r100.unregisterActivityLifecycleCallbacks(this);
        r100.registerActivityLifecycleCallbacks(this);
        return;
    }

    private void notifyBackground(Activity r100) {
        Object[] r101 = collectObservers();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ((ff7.c) r101[r103]).onBackground(r100);
        r103 = r103 + 1;
        goto L3
    L5:
        Iterator<c> r104 = this.mLifecycleObservers.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        r104.next().onBackground();
        goto L7
    }

    private void notifyFront(Activity r100) {
        Object[] r101 = collectObservers();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ((ff7.c) r101[r103]).onFront(r100);
        r103 = r103 + 1;
        goto L3
    L5:
        Iterator<c> r104 = this.mLifecycleObservers.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        r104.next().onFront();
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r100) {
        if (getActivityHash(r100).equals(this.mCurActivityHash) == false) goto L5;
        this.mCurActivityHash = null;
    L5:
        Iterator<c> r101 = this.mLifecycleObservers.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().onActivityDestroyed(r100);
        goto L7
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r100) {
        Object[] r101 = collectObservers();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ((ff7.c) r101[r103]).onActivityPause(r100);
        r103 = r103 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r100) {
        this.mTopActivityRef = new WeakReference(r100);
        this.mTopActivityClassName = null;
        Object[] r101 = collectObservers();
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        ((ff7.c) r101[r104]).onActivityResume(r100);
        r104 = r104 + 1;
        goto L3
    L5:
        Iterator<c> r105 = this.mLifecycleObservers.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        r105.next().onActivityResumed(r100);
        goto L7
    L9:
        String r106 = getActivityHash(r100);
        if (r106.equals(this.mCurActivityHash) == true) goto L19;
        int r107 = r101.length;
    L12:
        if (r103 >= r107) goto L14;
        ((ff7.c) r101[r103]).onChange(r100, null);
        r103 = r103 + 1;
        goto L12
    L14:
        this.mCurActivityHash = r106;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r100) {
        Object[] r101 = collectObservers();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        ((ff7.c) r101[r103]).onActivityStarted(r100);
        r103 = r103 + 1;
        goto L3
    L6:
        if (this.mChangingConfigActivity == false) goto L9;
        this.mChangingConfigActivity = false;
        return;
    L9:
        int r104 = this.mFrontActivityCount + 1;
        this.mFrontActivityCount = r104;
        if (r104 != 1) goto L14;
        this.mIsFrontV2 = true;
        notifyFront(r100);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r100) {
        if (r100.isChangingConfigurations() == false) goto L6;
        this.mChangingConfigActivity = true;
        return;
    L6:
        int r101 = this.mFrontActivityCount - 1;
        this.mFrontActivityCount = r101;
        if (r101 != 0) goto L10;
        this.mIsFrontV2 = false;
        notifyBackground(r100);
        return;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void register(ff7.c r100) {
        ArrayList<ff7.c> r101 = this.mObservers;
        if (r101 == null) goto L11;
        monitor-enter(r101);
        this.mObservers.add(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void unregister(ff7.c r100) {
        ArrayList<ff7.c> r101 = this.mObservers;
        if (r101 == null) goto L11;
        monitor-enter(r101);
        this.mObservers.remove(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void register(c r100) {
        ArrayList<c> r101 = this.mLifecycleObservers;
        if (r101 == null) goto L11;
        monitor-enter(r101);
        this.mLifecycleObservers.add(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unregister(c r100) {
        ArrayList<c> r101 = this.mLifecycleObservers;
        if (r101 == null) goto L11;
        monitor-enter(r101);
        this.mLifecycleObservers.remove(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r100, Bundle r101) {
        Object[] r102 = collectObservers();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        ((ff7.c) r102[r104]).onActivityCreated(r100, r101);
        r104 = r104 + 1;
        goto L3
    L5:
        Iterator<c> r105 = this.mLifecycleObservers.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        r105.next().onActivityCreated(r100);
        goto L7
    }
}
