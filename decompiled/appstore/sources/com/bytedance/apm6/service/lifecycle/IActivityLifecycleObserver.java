package com.bytedance.apm6.service.lifecycle;

import android.app.Activity;

/* JADX INFO: loaded from: classes.dex */
public interface IActivityLifecycleObserver {
    void onActivityCreated(Activity r10);

    void onActivityPause(Activity r10);

    void onActivityResume(Activity r10);

    void onActivityStarted(Activity r10);

    void onBackground(Activity r10);

    void onFront(Activity r10);
}
