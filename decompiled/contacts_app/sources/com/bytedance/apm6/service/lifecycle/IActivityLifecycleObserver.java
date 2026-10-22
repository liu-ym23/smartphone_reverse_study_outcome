package com.bytedance.apm6.service.lifecycle;

import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
public interface IActivityLifecycleObserver {
    void onActivityCreated(Activity r1);

    void onActivityPause(Activity r1);

    void onActivityResume(Activity r1);

    void onActivityStarted(Activity r1);

    void onBackground(Activity r1);

    void onFront(Activity r1);
}
