package com.bytedance.bdturing;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class OnDialogBackgroundListener implements Application.ActivityLifecycleCallbacks {
    private int count;
    private Activity mActivity;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r2) {
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

    OnDialogBackgroundListener(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        this.count = 1;
        this.mActivity = ZeusTransformUtils.wrapperContext2Activity(r4, "com.obric.aiagent.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r3) {
        if (((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin")) != this.mActivity) goto L6;
        this.count++;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r3) {
        if (((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin")) != this.mActivity) goto L8;
        int r4 = this.count - 1;
        this.count = r4;
        if (r4 != 0) goto L9;
        e.c();
        return;
    L9:
        return;
    }

    public void registerListener() {
        Activity r0 = this.mActivity;
        if (r0 == null) goto L6;
        ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).registerActivityLifecycleCallbacks(this);
        return;
    }

    public void unregisterListener() {
        Activity r0 = this.mActivity;
        if (r0 == null) goto L6;
        ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).unregisterActivityLifecycleCallbacks(this);
        return;
    }
}
