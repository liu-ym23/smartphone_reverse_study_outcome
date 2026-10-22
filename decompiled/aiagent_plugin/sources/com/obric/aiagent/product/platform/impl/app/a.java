package com.obric.aiagent.product.platform.impl.app;

import android.app.ActivityManager;
import android.app.AssistantActivityManager;
import android.app.AssistantDisplayInfoCallback;
import android.app.AssistantTaskStackListener;
import android.app.IAssistantBackNavigationListener;
import android.app.ITopActivityAssistDataReceiver;
import android.content.AssistantIntentController;
import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.app.IObricActivityManager;
import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.obric.aiagent.product.platform.api.app.ObricBackNavigationListener;
import com.obric.aiagent.product.platform.api.app.ObricDisplayInfoCallback;
import com.obric.aiagent.product.platform.api.app.ObricTaskStackListener;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: AssistantActivityManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements IObricActivityManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0400a f18804a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.app.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistantActivityManagerImpl.kt */
    public static final class C0400a {
        public /* synthetic */ C0400a(d.h.b.h r1) {
            this();
        }

        private C0400a() {
        }
    }

    static {
        f18804a = new C0400a(null);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public Boolean isAutoActionTopActivityInSystemAnimation() {
        return null;
    }

    public a() {
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public int getAutoDisplayId() {
        return AssistantActivityManager.getAutoDisplayId();
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public ActivityManager.RunningTaskInfo getCurrentTaskInfo(int r1) {
        return AssistantActivityManager.getCurrentTaskInfo(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean isPackageVisibleOnDisplay(String r1, int r2) {
        o.e(r1, "packageName");
        return AssistantActivityManager.isPackageVisibleOnDisplay(r1, r2);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean requestTopActivityAssistData(int r9, int r10, ITopActivityAssistDataReceiver r11) {
        ITopActivityAssistDataReceiver r8 = (ITopActivityAssistDataReceiver) ZeusTransformUtils.wrapperContextForParams(r11, ITopActivityAssistDataReceiver.class, "com.obric.aiagent.plugin");
        o.e(r8, "receiver");
        Method r1 = AssistantActivityManager.class.getMethod("requestTopActivityAssistData", new Class[]{Integer.TYPE, Integer.TYPE, ITopActivityAssistDataReceiver.class});     // Catch: Throwable -> L9
        Object[] r2 = {Integer.valueOf(r9), Integer.valueOf(r10), r8};     // Catch: Throwable -> L9
        Boolean r12 = null;
        Object r13 = r1.invoke(null, r2);     // Catch: Throwable -> L9
        if (ZeusTransformUtils.instanceOf(r13, Boolean.class) == false) goto L6;
        r12 = (Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
    L6:
        if (r12 == null) goto L14;
        return r12.booleanValue();
    L14:
        return false;
    L9:
        th = move-exception;
        ILogDepend.Companion.e("AssistantActivityManagerImpl", "requestTopActivityAssistData failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean supportsAutoVirtualDisplayRecordSet() {
        return c.f18806a.a();
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public long beginAutoVirtualDisplayRecordSet(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3) {
        o.e(r3, "listener");
        return c.f18806a.a(r1, r2, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean addAutoVirtualDisplayRecordPackages(long r1, String[] r3) {
        o.e(r3, "packageNames");
        return c.f18806a.a(r1, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void endAutoVirtualDisplayRecordSet(long r1) {
        c.f18806a.a(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerTaskStackListenerEx(ObricTaskStackListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.AssistantTaskStackListener");
        return AssistantActivityManager.registerTaskStackListenerEx((AssistantTaskStackListener) ZeusTransformUtils.preCheckCast(r1, AssistantTaskStackListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterTaskStackListenerEx(ObricTaskStackListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.AssistantTaskStackListener");
        return AssistantActivityManager.unregisterTaskStackListenerEx((AssistantTaskStackListener) ZeusTransformUtils.preCheckCast(r1, AssistantTaskStackListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean moveTaskToDisplay(int r1, int r2, boolean r3) {
        return AssistantActivityManager.moveTaskToDisplay(r1, r2, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void tryToMute(boolean r1) {
        AssistantActivityManager.tryToMute(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void enableCallUser(boolean r1) {
        AssistantActivityManager.enableCallUser(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void addDisablePackage(String[] r1) {
        o.e(r1, "packageName");
        AssistantActivityManager.addDisablePackage(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IAssistantBackNavigationListener");
        return AssistantActivityManager.registerBackNavigationInVirtualDisplayListenerEx((IAssistantBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IAssistantBackNavigationListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IAssistantBackNavigationListener");
        return AssistantActivityManager.unregisterBackNavigationInVirtualDisplayListenerEx((IAssistantBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IAssistantBackNavigationListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerObricDisplayInfoCallback(ObricDisplayInfoCallback r3) {
        o.e(r3, "listener");
        Object r2 = r3.getAssistantStub();     // Catch: Throwable -> L5
        o.a(r2, "null cannot be cast to non-null type android.app.AssistantDisplayInfoCallback");     // Catch: Throwable -> L5
        return AssistantActivityManager.registerAssistantDisplayInfoCallback((AssistantDisplayInfoCallback) ZeusTransformUtils.preCheckCast(r2, AssistantDisplayInfoCallback.class, "com.obric.aiagent.plugin"));
    L5:
        th = move-exception;
        ILogDepend.Companion.e("AssistantActivityManagerImpl", "registerObricDisplayInfoCallback failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterObricDisplayInfoCallback(ObricDisplayInfoCallback r3) {
        o.e(r3, "listener");
        Object r2 = r3.getAssistantStub();     // Catch: Throwable -> L5
        o.a(r2, "null cannot be cast to non-null type android.app.AssistantDisplayInfoCallback");     // Catch: Throwable -> L5
        return AssistantActivityManager.unregisterAssistantDisplayInfoCallback((AssistantDisplayInfoCallback) ZeusTransformUtils.preCheckCast(r2, AssistantDisplayInfoCallback.class, "com.obric.aiagent.plugin"));
    L5:
        th = move-exception;
        ILogDepend.Companion.e("AssistantActivityManagerImpl", "unregisterObricDisplayInfoCallback failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerBackNavigationListener(ObricBackNavigationListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IAssistantBackNavigationListener");
        return AssistantActivityManager.registerBackNavigationListener((IAssistantBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IAssistantBackNavigationListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterBackNavigationListener(ObricBackNavigationListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getAssistantStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IAssistantBackNavigationListener");
        return AssistantActivityManager.unregisterBackNavigationListener((IAssistantBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IAssistantBackNavigationListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean forceStopPackageOfCaller(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        Object r10 = r9.getSystemService("activity");     // Catch: Throwable -> L19
        if (ZeusTransformUtils.instanceOf(r10, ActivityManager.class) == false) goto L6;
        ActivityManager r11 = (ActivityManager) ZeusTransformUtils.preCheckCast(r10, ActivityManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
    L7:
        if (r11 != null) goto L10;
        ILogDepend.Companion.e("AssistantActivityManagerImpl", "get ActivityManagerService failed");     // Catch: Throwable -> L19
        return false;
    L10:
        String r2 = IAppContext.Companion.getPackageName();     // Catch: Throwable -> L19
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L17;
        ILogDepend.Companion.e("AssistantActivityManagerImpl", "packageName empty");     // Catch: Throwable -> L19
        return false;
    L17:
        Method r3 = r11.getClass().getDeclaredMethod("forceStopPackage", new Class[]{String.class});     // Catch: Throwable -> L19
        r3.setAccessible(true);     // Catch: Throwable -> L19
        ILogDepend.Companion.i("AssistantActivityManagerImpl", "try forceStopPackage " + r2);     // Catch: Throwable -> L19
        r3.invoke(r11, new Object[]{r2});     // Catch: Throwable -> L19
        return true;
    L13:
        r1 = false;
        goto L14
    L6:
        r11 = null;
    L19:
        th = move-exception;
        ILogDepend.Companion.e("AssistantActivityManagerImpl", "forceStopPackage exception", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void setMuteWhitelist(List<String> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "whiteList");
        AssistantActivityManager.setMuteWhitelist(r4);     // Catch: Throwable -> L5
        ILogDepend.Companion.i("AssistantActivityManagerImpl", "setMuteWhitelist called");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ILogDepend.Companion.e("AssistantActivityManagerImpl", "setMuteWhitelist exception", th);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void addExtraTaskNotTrimFlag(Intent r3) {
        o.e(r3, MemorySourceLinkType.INTENT);
        AssistantIntentController.setAssistantFlags(r3, 16);     // Catch: Throwable -> L5
        ILogDepend.Companion.i("AssistantActivityManagerImpl", "addExtraTaskNotTrimFlag called");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ILogDepend.Companion.e("AssistantActivityManagerImpl", "addExtraTaskNotTrimFlag exception", th);
    }
}
