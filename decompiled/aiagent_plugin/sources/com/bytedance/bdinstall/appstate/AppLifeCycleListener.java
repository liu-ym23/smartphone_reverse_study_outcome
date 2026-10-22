package com.bytedance.bdinstall.appstate;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AppLifeCycleListener implements Application.ActivityLifecycleCallbacks, a {
    private int mForegroundActivityNum;
    private boolean mIsForeground;
    private a.InterfaceC0144a mOnResumeListener;
    private boolean mResumed;

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

    public AppLifeCycleListener() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (this.mForegroundActivityNum >= 0) goto L6;
        this.mForegroundActivityNum = 0;
    L6:
        if (this.mForegroundActivityNum != 0) goto L8;
        onEnterForeground();
    L8:
        this.mForegroundActivityNum++;
        this.mResumed = true;
        a.InterfaceC0144a r2 = this.mOnResumeListener;
        if (r2 == null) goto L12;
        r2.a();
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        int r5 = this.mForegroundActivityNum - 1;
        this.mForegroundActivityNum = r5;
        if (r5 > 0) goto L6;
        onEnterBackground();
    L6:
        if (this.mForegroundActivityNum >= 0) goto L9;
        this.mForegroundActivityNum = 0;
        return;
    }

    @Override // com.bytedance.bdinstall.appstate.a
    public boolean isForeground() {
        return this.mIsForeground;
    }

    private void onEnterBackground() {
        this.mIsForeground = false;
    }

    private void onEnterForeground() {
        this.mIsForeground = true;
    }

    @Override // com.bytedance.bdinstall.appstate.a
    public void setOnResumeListener(a.InterfaceC0144a r3) {
        this.mOnResumeListener = (a.InterfaceC0144a) ZeusTransformUtils.wrapperContextForParams(r3, a.InterfaceC0144a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.bdinstall.appstate.a
    public boolean isActive() {
        return this.mResumed;
    }
}
