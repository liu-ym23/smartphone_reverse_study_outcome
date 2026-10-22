package com.bytedance.platform.godzilla.crash.deadsystemexception;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.bytedance.platform.godzilla.common.c;
import com.bytedance.platform.godzilla.common.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class ViewRootImplHandlerHook implements Application.ActivityLifecycleCallbacks {
    private Field mAttachInfoField;
    private Field mHandlerField;

    private static class PreventHandlerCallback implements Handler.Callback {
        private Handler mTargetHandler;

        PreventHandlerCallback(Handler r1) {
            this.mTargetHandler = r1;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r4) {
            g.a("ViewRootImplHandlerHook", "Handle message " + r4);     // Catch: Throwable -> L5
            this.mTargetHandler.handleMessage(r4);     // Catch: Throwable -> L5
            return true;
        L8:
            return true;
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
    public void onActivityPaused(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    public ViewRootImplHandlerHook() {
    }

    static /* synthetic */ Field access$000(ViewRootImplHandlerHook r0) {
        return r0.mAttachInfoField;
    }

    static /* synthetic */ Field access$100(ViewRootImplHandlerHook r0) {
        return r0.mHandlerField;
    }

    static /* synthetic */ Field access$102(ViewRootImplHandlerHook r0, Field r1) {
        r0.mHandlerField = r1;
        return r1;
    }

    public void onHook(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        Field r0 = c.a(View.class, "mAttachInfo");     // Catch: Throwable -> L7
        this.mAttachInfoField = r0;     // Catch: Throwable -> L7
        if (r0 == null) goto L10;
        r0.setAccessible(true);     // Catch: Throwable -> L7
        r4.registerActivityLifecycleCallbacks(this);     // Catch: Throwable -> L7
        g.a("ViewRootImplHandlerHook", "Hook success ");     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        g.a("ViewRootImplHandlerHook", "onActivityStarted！");
        if (this.mAttachInfoField != null) goto L8;
        return;
    L8:
        final View r6 = ZeusTransformUtils.getWindow(r5, "com.obric.aiagent.plugin").getDecorView();     // Catch: Throwable -> L7
        r6.addOnAttachStateChangeListener(new AnonymousClass1(this, r6));     // Catch: Throwable -> L7
        return;
    }
}
