package com.obric.aiagent.product.platform.impl.app;

import android.app.ActivityManager;
import android.app.IObricBackNavigationListener;
import android.app.ITopActivityAssistDataReceiver;
import android.app.ObricActivityManager;
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

/* JADX INFO: compiled from: CommonObricActivityManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements IObricActivityManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18816a = null;

    /* JADX INFO: compiled from: CommonObricActivityManager.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f18816a = new a(null);
    }

    public g() {
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public int getAutoDisplayId() {
        return ObricActivityManager.getAutoDisplayId();
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public ActivityManager.RunningTaskInfo getCurrentTaskInfo(int r1) {
        return ObricActivityManager.getCurrentTaskInfo(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean isPackageVisibleOnDisplay(String r1, int r2) {
        o.e(r1, "packageName");
        return ObricActivityManager.isPackageVisibleOnDisplay(r1, r2);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public Boolean isAutoActionTopActivityInSystemAnimation() {
        return Boolean.valueOf(ObricActivityManager.isAutoActionTopActivityInSystemAnimation());
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean supportsAutoVirtualDisplayRecordSet() {
        return i.f18818a.a();
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public long beginAutoVirtualDisplayRecordSet(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3) {
        o.e(r3, "listener");
        return i.f18818a.a(r1, r2, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean addAutoVirtualDisplayRecordPackages(long r1, String[] r3) {
        o.e(r3, "packageNames");
        return i.f18818a.a(r1, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void endAutoVirtualDisplayRecordSet(long r1) {
        i.f18818a.a(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean requestTopActivityAssistData(int r2, int r3, ITopActivityAssistDataReceiver r4) {
        ITopActivityAssistDataReceiver r1 = (ITopActivityAssistDataReceiver) ZeusTransformUtils.wrapperContextForParams(r4, ITopActivityAssistDataReceiver.class, "com.obric.aiagent.plugin");
        o.e(r1, "receiver");
        return ObricActivityManager.requestTopActivityAssistData(r2, r3, r1);
    L5:
        th = move-exception;
        ILogDepend.Companion.e("CommonActivityManager", "requestTopActivityAssistData failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerTaskStackListenerEx(ObricTaskStackListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type android.app.ObricTaskStackListener");
        return ObricActivityManager.registerTaskStackListenerEx((android.app.ObricTaskStackListener) ZeusTransformUtils.preCheckCast(r1, android.app.ObricTaskStackListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterTaskStackListenerEx(ObricTaskStackListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type android.app.ObricTaskStackListener");
        return ObricActivityManager.unregisterTaskStackListenerEx((android.app.ObricTaskStackListener) ZeusTransformUtils.preCheckCast(r1, android.app.ObricTaskStackListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean moveTaskToDisplay(int r1, int r2, boolean r3) {
        return ObricActivityManager.moveTaskToDisplay(r1, r2, r3);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void tryToMute(boolean r1) {
        ObricActivityManager.tryToMute(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void enableCallUser(boolean r1) {
        ObricActivityManager.enableCallUser(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void addDisablePackage(String[] r1) {
        o.e(r1, "packageName");
        ObricActivityManager.addDisablePackage(r1);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IObricBackNavigationListener");
        return ObricActivityManager.registerBackNavigationInVirtualDisplayListenerEx((IObricBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IObricBackNavigationListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IObricBackNavigationListener");
        return ObricActivityManager.unregisterBackNavigationInVirtualDisplayListenerEx((IObricBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IObricBackNavigationListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerObricDisplayInfoCallback(ObricDisplayInfoCallback r3) {
        o.e(r3, "listener");
        Object r2 = r3.getObricStub();     // Catch: Throwable -> L5
        o.a(r2, "null cannot be cast to non-null type android.app.ObricDisplayInfoCallback");     // Catch: Throwable -> L5
        return ObricActivityManager.registerObricDisplayInfoCallback((android.app.ObricDisplayInfoCallback) ZeusTransformUtils.preCheckCast(r2, android.app.ObricDisplayInfoCallback.class, "com.obric.aiagent.plugin"));
    L5:
        th = move-exception;
        ILogDepend.Companion.e("CommonActivityManager", "registerObricDisplayInfoCallback failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterObricDisplayInfoCallback(ObricDisplayInfoCallback r3) {
        o.e(r3, "listener");
        Object r2 = r3.getObricStub();     // Catch: Throwable -> L5
        o.a(r2, "null cannot be cast to non-null type android.app.ObricDisplayInfoCallback");     // Catch: Throwable -> L5
        return ObricActivityManager.unregisterObricDisplayInfoCallback((android.app.ObricDisplayInfoCallback) ZeusTransformUtils.preCheckCast(r2, android.app.ObricDisplayInfoCallback.class, "com.obric.aiagent.plugin"));
    L5:
        th = move-exception;
        ILogDepend.Companion.e("CommonActivityManager", "unregisterObricDisplayInfoCallback failed", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean registerBackNavigationListener(ObricBackNavigationListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IObricBackNavigationListener");
        return ObricActivityManager.registerBackNavigationListener((IObricBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IObricBackNavigationListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public boolean unregisterBackNavigationListener(ObricBackNavigationListener r2) {
        o.e(r2, "listener");
        Object r1 = r2.getObricStub();
        o.a(r1, "null cannot be cast to non-null type android.app.IObricBackNavigationListener");
        return ObricActivityManager.unregisterBackNavigationListener((IObricBackNavigationListener) ZeusTransformUtils.preCheckCast(r1, IObricBackNavigationListener.class, "com.obric.aiagent.plugin"));
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
        ILogDepend.Companion.e("CommonActivityManager", "get ActivityManagerService failed");     // Catch: Throwable -> L19
        return false;
    L10:
        String r2 = IAppContext.Companion.getPackageName();     // Catch: Throwable -> L19
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L17;
        ILogDepend.Companion.e("CommonActivityManager", "packageName empty");     // Catch: Throwable -> L19
        return false;
    L17:
        Method r3 = r11.getClass().getDeclaredMethod("forceStopPackage", new Class[]{String.class});     // Catch: Throwable -> L19
        r3.setAccessible(true);     // Catch: Throwable -> L19
        ILogDepend.Companion.i("CommonActivityManager", "try forceStopPackage " + r2);     // Catch: Throwable -> L19
        r3.invoke(r11, new Object[]{r2});     // Catch: Throwable -> L19
        return true;
    L13:
        r1 = false;
        goto L14
    L6:
        r11 = null;
    L19:
        th = move-exception;
        ILogDepend.Companion.e("CommonActivityManager", "forceStopPackage exception", th);
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void setMuteWhitelist(List<String> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r2, "whiteList");
        ObricActivityManager.setMuteWhitelist(r2);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ILogDepend.Companion.e("CommonActivityManager", "setMuteWhitelist failed", th);
    }

    @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
    public void addExtraTaskNotTrimFlag(Intent r2) {
        o.e(r2, MemorySourceLinkType.INTENT);
        a(r2);
    }

    private final void a(Intent r7) {
        ILogDepend.Companion.i("CommonActivityManager", "addExtraFlag");     // Catch: Throwable -> L5
        Object r8 = r7.getClass().getMethod("getSmtEx", new Class[0]).invoke(r7, new Object[0]);     // Catch: Throwable -> L5
        r8.getClass().getMethod("addSmFlags", new Class[]{Integer.TYPE}).invoke(r8, new Object[]{16});     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ILogDepend.Companion.e("CommonActivityManager", "addExtraFlag failed", th);
    }
}
