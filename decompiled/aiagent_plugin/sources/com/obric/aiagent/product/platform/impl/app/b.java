package com.obric.aiagent.product.platform.impl.app;

import android.app.ActivityManager;
import android.app.AssistantActivityTaskManager;
import android.app.IAssistantActivitySwitchListener;
import android.app.IAssistantAppSwitchListener;
import android.app.ObricActivityTaskManager;
import android.content.Context;
import android.os.Build;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager;
import com.obric.aiagent.product.platform.api.app.ObricActivitySwitchListener;
import com.obric.aiagent.product.platform.api.app.ObricAppSwitchListener;
import com.obric.aiagent.product.platform.api.app.ObricFocusListener;
import com.obric.aiagent.product.platform.api.app.ObricSystemAnimationListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AssistantActivityTaskManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements IObricActivityTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18805a = null;

    /* JADX INFO: compiled from: AssistantActivityTaskManagerImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f18805a = new a(null);
    }

    public b() {
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean registerAppSwitchListener(ObricAppSwitchListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IAssistantAppSwitchListener");
        return AssistantActivityTaskManager.registerAppSwitchListener((IAssistantAppSwitchListener) ZeusTransformUtils.preCheckCast(r1, IAssistantAppSwitchListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean unregisterAppSwitchListener(ObricAppSwitchListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IAssistantAppSwitchListener");
        return AssistantActivityTaskManager.unregisterAppSwitchListener((IAssistantAppSwitchListener) ZeusTransformUtils.preCheckCast(r1, IAssistantAppSwitchListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean registerActivitySwitchListener(ObricActivitySwitchListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IAssistantActivitySwitchListener");
        return AssistantActivityTaskManager.registerActivitySwitchListener((IAssistantActivitySwitchListener) ZeusTransformUtils.preCheckCast(r1, IAssistantActivitySwitchListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean unregisterActivitySwitchListener(ObricActivitySwitchListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IAssistantActivitySwitchListener");
        return AssistantActivityTaskManager.unregisterActivitySwitchListener((IAssistantActivitySwitchListener) ZeusTransformUtils.preCheckCast(r1, IAssistantActivitySwitchListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean registerFocusListener(ObricFocusListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type android.app.ObricFocusListener");
        return ObricActivityTaskManager.registerFocusListener((android.app.ObricFocusListener) ZeusTransformUtils.preCheckCast(r1, android.app.ObricFocusListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean unregisterFocusListener(ObricFocusListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type android.app.ObricFocusListener");
        return ObricActivityTaskManager.unregisterFocusListener((android.app.ObricFocusListener) ZeusTransformUtils.preCheckCast(r1, android.app.ObricFocusListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean registerSystemAnimationListener(ObricSystemAnimationListener r3) {
        o.e(r3, "listener");
        ObricActivityTaskManager.registerSystemAnimationListener(r3.getObricStub());     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        ILogDepend.Companion.e("AssistantActivityTaskManagerImpl", "registerSystemAnimationListener failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean unregisterSystemAnimationListener(ObricSystemAnimationListener r3) {
        o.e(r3, "listener");
        ObricActivityTaskManager.unregisterSystemAnimationListener(r3.getObricStub());     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        ILogDepend.Companion.e("AssistantActivityTaskManagerImpl", "unregisterSystemAnimationListener failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
    public boolean finishAndRemoveAllTask(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        Object r7 = r6.getSystemService("activity");     // Catch: Throwable -> L20
        if (ZeusTransformUtils.instanceOf(r7, ActivityManager.class) == false) goto L6;
        ActivityManager r8 = (ActivityManager) ZeusTransformUtils.preCheckCast(r7, ActivityManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
    L7:
        if (r8 != null) goto L11;
        ILogDepend.Companion.e("CommonActivityManager", "get ActivityManagerService failed");     // Catch: Throwable -> L20
        return false;
    L11:
        if (Build.VERSION.SDK_INT < 21) goto L19;
        ILogDepend.Companion.i("AssistantActivityTaskManagerImpl", "finishAndRemoveAllTask on Android 5.0+");     // Catch: Throwable -> L20
        List<ActivityManager.AppTask> r9 = r8.getAppTasks();     // Catch: Throwable -> L20
        o.c(r9, "getAppTasks(...)");     // Catch: Throwable -> L20
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L20
    L14:
        if (r10.hasNext() == false) goto L17;
        ((ActivityManager.AppTask) ZeusTransformUtils.preCheckCast(r10.next(), ActivityManager.AppTask.class, "com.obric.aiagent.plugin")).finishAndRemoveTask();     // Catch: Throwable -> L20
        goto L14
    L17:
        return true;
    L19:
        return false;
    L6:
        r8 = null;
    L20:
        th = move-exception;
        ILogDepend.Companion.e("AssistantActivityTaskManagerImpl", "finishAndRemoveAllTask failed", th);
        return false;
    }
}
