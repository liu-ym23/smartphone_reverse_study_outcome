package com.bytedance.apm.core;

import B.c;
import L.e;
import L.f;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.bytedance.services.apm.api.IActivityLifeManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ActivityLifeObserver implements Application.ActivityLifecycleCallbacks, IActivityLifeManager {
    private static final long CHECK_DELAY = 600;
    private static final String TAG = "ActivityLifeObserver";
    private static final ActivityLifeObserver mInstance = new ActivityLifeObserver();
    private boolean mChangingConfigActivity;
    private String mCurActivityHash;
    private int mFrontActivityCount;
    private boolean mHasInit;
    private boolean mIsFrontV2;
    private ArrayList<c> mObservers;
    private WeakReference<Activity> mTopActivityRef;

    private ActivityLifeObserver() {
    }

    private Object[] collectObservers() {
        Object[] array;
        synchronized (this.mObservers) {
            try {
                array = this.mObservers.size() > 0 ? this.mObservers.toArray() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return array == null ? new Object[0] : array;
    }

    private String getActivityHash(Activity activity) {
        return activity.getClass().getName() + activity.hashCode();
    }

    public static ActivityLifeObserver getInstance() {
        return mInstance;
    }

    public static void init(Application application) {
        mInstance.initWithApp(application);
    }

    private void initWithApp(@NonNull Application application) {
        if (application == null || this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        this.mObservers = new ArrayList<>(8);
        application.unregisterActivityLifecycleCallbacks(this);
        application.registerActivityLifecycleCallbacks(this);
        f fVar = new f();
        fVar.c = true;
        getInstance().register(new e(fVar));
    }

    private void notifyBackground(Activity activity) {
        for (Object obj : collectObservers()) {
            ((c) obj).f(activity);
        }
    }

    private void notifyFront(Activity activity) {
        for (Object obj : collectObservers()) {
            ((c) obj).mo0c();
        }
    }

    public String getTopActivityClassName() {
        Activity activity;
        WeakReference<Activity> weakReference = this.mTopActivityRef;
        return (weakReference == null || (activity = weakReference.get()) == null) ? "" : activity.getClass().getCanonicalName();
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
    public void onActivityCreated(Activity activity, Bundle bundle) {
        for (Object obj : collectObservers()) {
            ((c) obj).g(bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (getActivityHash(activity).equals(this.mCurActivityHash)) {
            this.mCurActivityHash = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        for (Object obj : collectObservers()) {
            ((c) obj).c(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.mTopActivityRef = new WeakReference<>(activity);
        Object[] objArrCollectObservers = collectObservers();
        for (Object obj : objArrCollectObservers) {
            ((c) obj).getClass();
        }
        String activityHash = getActivityHash(activity);
        if (activityHash.equals(this.mCurActivityHash)) {
            return;
        }
        for (Object obj2 : objArrCollectObservers) {
            ((c) obj2).getClass();
        }
        this.mCurActivityHash = activityHash;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        for (Object obj : collectObservers()) {
            ((c) obj).onActivityStarted(activity);
        }
        if (this.mChangingConfigActivity) {
            this.mChangingConfigActivity = false;
            return;
        }
        int i = this.mFrontActivityCount + 1;
        this.mFrontActivityCount = i;
        if (i == 1) {
            this.mIsFrontV2 = true;
            notifyFront(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.mChangingConfigActivity = true;
            return;
        }
        int i = this.mFrontActivityCount - 1;
        this.mFrontActivityCount = i;
        if (i == 0) {
            this.mIsFrontV2 = false;
            notifyBackground(activity);
        }
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void register(c cVar) {
        ArrayList<c> arrayList = this.mObservers;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mObservers.add(cVar);
            }
        }
    }

    @Override // com.bytedance.services.apm.api.IActivityLifeManager
    public void unregister(c cVar) {
        ArrayList<c> arrayList = this.mObservers;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mObservers.remove(cVar);
            }
        }
    }
}
