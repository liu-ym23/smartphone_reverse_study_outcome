package com.obric.aiagent.product.platform.api.app;

import android.app.ActivityManager;
import android.app.ITopActivityAssistDataReceiver;
import android.content.Context;
import android.content.Intent;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.a.b;
import com.obric.aiagent.product.platform.impl.app.a;
import com.obric.aiagent.product.platform.impl.app.g;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.util.List;

/* JADX INFO: compiled from: ObricActivityManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricActivityManager {
    public static final Companion Companion = null;
    public static final int FLAG_SM_TASK_NOT_TRIMMABLE = 16;
    private static final String TAG = "ObricActivityManager";
    private static IObricActivityManager instance;

    /* JADX INFO: compiled from: ObricActivityManager.kt */
    public static final class Companion implements IObricActivityManager {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public int getAutoDisplayId() {
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getAutoDisplayId();
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public ActivityManager.RunningTaskInfo getCurrentTaskInfo(int r1) {
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            ActivityManager.RunningTaskInfo r2 = r0.getCurrentTaskInfo(r1);
            if (r2 == null) goto L6;
            return r2;
        L6:
            return null;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean isPackageVisibleOnDisplay(String r1, int r2) {
            o.e(r1, "packageName");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isPackageVisibleOnDisplay(r1, r2);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public Boolean isAutoActionTopActivityInSystemAnimation() {
            Object r1 = null;
            n.a r2 = n.f38560a;     // Catch: Throwable -> L9
            Companion r5 = (Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            IObricActivityManager r6 = ObricActivityManager.access$getInstance$cp();     // Catch: Throwable -> L9
            if (r6 == null) goto L6;
            Boolean r7 = r6.isAutoActionTopActivityInSystemAnimation();     // Catch: Throwable -> L9
        L7:
            Object r8 = n.f(r7);     // Catch: Throwable -> L9
        L11:
            Throwable r3 = n.c(r8);
            if (r3 != null) goto L14;
            r1 = r8;
        L16:
            return (Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.aiagent.plugin");
        L14:
            ILogDepend.Companion.e(ObricActivityManager.TAG, "isAutoActionTopActivityInSystemAnimation failed", r3);
            goto L16
        L6:
            r7 = null;
        L9:
            th = move-exception;
            n.a r4 = n.f38560a;
            r8 = n.f(d.o.a(th));
            goto L11
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean supportsAutoVirtualDisplayRecordSet() {
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();     // Catch: Exception -> L7
            if (r0 == null) goto L12;
            return r0.supportsAutoVirtualDisplayRecordSet();
        L12:
            return false;
        L7:
            e = move-exception;
            ILogDepend.Companion.e(ObricActivityManager.TAG, "supportsAutoVirtualDisplayRecordSet failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return false;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public long beginAutoVirtualDisplayRecordSet(int r3, int r4, ObricAutoVirtualDisplayRecordSetListener r5) {
            o.e(r5, "listener");
            IObricActivityManager r2 = ObricActivityManager.access$getInstance$cp();     // Catch: Exception -> L7
            if (r2 == null) goto L12;
            return r2.beginAutoVirtualDisplayRecordSet(r3, r4, r5);
        L12:
            return 0;
        L7:
            e = move-exception;
            ILogDepend.Companion.e(ObricActivityManager.TAG, "beginAutoVirtualDisplayRecordSet failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return 0;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean addAutoVirtualDisplayRecordPackages(long r2, String[] r4) {
            o.e(r4, "packageNames");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();     // Catch: Exception -> L7
            if (r0 == null) goto L12;
            return r0.addAutoVirtualDisplayRecordPackages(r2, r4);
        L12:
            return false;
        L7:
            e = move-exception;
            ILogDepend.Companion.e(ObricActivityManager.TAG, "addAutoVirtualDisplayRecordPackages failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return false;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public void endAutoVirtualDisplayRecordSet(long r2) {
            IObricActivityManager r1 = ObricActivityManager.access$getInstance$cp();     // Catch: Exception -> L6
            if (r1 == null) goto L11;
            r1.endAutoVirtualDisplayRecordSet(r2);     // Catch: Exception -> L6
            return;
        L11:
            return;
        L6:
            e = move-exception;
            ILogDepend.Companion.e(ObricActivityManager.TAG, "endAutoVirtualDisplayRecordSet failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean requestTopActivityAssistData(int r2, int r3, ITopActivityAssistDataReceiver r4) {
            ITopActivityAssistDataReceiver r1 = (ITopActivityAssistDataReceiver) ZeusTransformUtils.wrapperContextForParams(r4, ITopActivityAssistDataReceiver.class, "com.obric.aiagent.plugin");
            o.e(r1, "receiver");
            IObricActivityManager r5 = ObricActivityManager.access$getInstance$cp();
            if (r5 != null) goto L7;
            return false;
        L7:
            return r5.requestTopActivityAssistData(r2, r3, r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean registerTaskStackListenerEx(ObricTaskStackListener r1) {
            o.e(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerTaskStackListenerEx(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean unregisterTaskStackListenerEx(ObricTaskStackListener r1) {
            o.e(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterTaskStackListenerEx(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean moveTaskToDisplay(int r1, int r2, boolean r3) {
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.moveTaskToDisplay(r1, r2, r3);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public void tryToMute(boolean r1) {
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.tryToMute(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public void enableCallUser(boolean r1) {
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.enableCallUser(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public void addDisablePackage(String[] r1) {
            o.e(r1, "packageName");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.addDisablePackage(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean registerBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r1) {
            o.e(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerBackNavigationInVirtualDisplayListenerEx(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean unregisterBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r1) {
            o.e(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterBackNavigationInVirtualDisplayListenerEx(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean registerObricDisplayInfoCallback(ObricDisplayInfoCallback r1) {
            o.e(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerObricDisplayInfoCallback(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean unregisterObricDisplayInfoCallback(ObricDisplayInfoCallback r1) {
            o.e(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterObricDisplayInfoCallback(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean registerBackNavigationListener(ObricBackNavigationListener r1) {
            o.e(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerBackNavigationListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean unregisterBackNavigationListener(ObricBackNavigationListener r1) {
            o.e(r1, "listener");
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterBackNavigationListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public boolean forceStopPackageOfCaller(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            IObricActivityManager r3 = ObricActivityManager.access$getInstance$cp();
            if (r3 != null) goto L7;
            return false;
        L7:
            return r3.forceStopPackageOfCaller(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public void setMuteWhitelist(List<String> r2) {
            List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            o.e(r1, "whiteList");
            IObricActivityManager r3 = ObricActivityManager.access$getInstance$cp();
            if (r3 == null) goto L6;
            r3.setMuteWhitelist(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityManager
        public void addExtraTaskNotTrimFlag(Intent r1) {
            o.e(r1, MemorySourceLinkType.INTENT);
            IObricActivityManager r0 = ObricActivityManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.addExtraTaskNotTrimFlag(r1);
            return;
        }
    }

    public static boolean addAutoVirtualDisplayRecordPackages(long r1, String[] r3) {
        return Companion.addAutoVirtualDisplayRecordPackages(r1, r3);
    }

    public static void addDisablePackage(String[] r1) {
        Companion.addDisablePackage(r1);
    }

    public static void addExtraTaskNotTrimFlag(Intent r1) {
        Companion.addExtraTaskNotTrimFlag(r1);
    }

    public static long beginAutoVirtualDisplayRecordSet(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3) {
        return Companion.beginAutoVirtualDisplayRecordSet(r1, r2, r3);
    }

    public static void enableCallUser(boolean r1) {
        Companion.enableCallUser(r1);
    }

    public static void endAutoVirtualDisplayRecordSet(long r1) {
        Companion.endAutoVirtualDisplayRecordSet(r1);
    }

    public static boolean forceStopPackageOfCaller(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return Companion.forceStopPackageOfCaller(r3);
    }

    public static int getAutoDisplayId() {
        return Companion.getAutoDisplayId();
    }

    public static ActivityManager.RunningTaskInfo getCurrentTaskInfo(int r1) {
        return Companion.getCurrentTaskInfo(r1);
    }

    public static Boolean isAutoActionTopActivityInSystemAnimation() {
        return Companion.isAutoActionTopActivityInSystemAnimation();
    }

    public static boolean isPackageVisibleOnDisplay(String r1, int r2) {
        return Companion.isPackageVisibleOnDisplay(r1, r2);
    }

    public static /* synthetic */ Object lambda$VOPFpbbh89SYb3uLIzYGJVTngCo() {
        return _init_$lambda$1();
    }

    public static /* synthetic */ Object lambda$__RfqksKogegVI6YzGYuH8dw4nk() {
        return _init_$lambda$0();
    }

    public static boolean moveTaskToDisplay(int r1, int r2, boolean r3) {
        return Companion.moveTaskToDisplay(r1, r2, r3);
    }

    public static boolean registerBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r1) {
        return Companion.registerBackNavigationInVirtualDisplayListenerEx(r1);
    }

    public static boolean registerBackNavigationListener(ObricBackNavigationListener r1) {
        return Companion.registerBackNavigationListener(r1);
    }

    public static boolean registerObricDisplayInfoCallback(ObricDisplayInfoCallback r1) {
        return Companion.registerObricDisplayInfoCallback(r1);
    }

    public static boolean registerTaskStackListenerEx(ObricTaskStackListener r1) {
        return Companion.registerTaskStackListenerEx(r1);
    }

    public static boolean requestTopActivityAssistData(int r2, int r3, ITopActivityAssistDataReceiver r4) {
        ITopActivityAssistDataReceiver r5 = (ITopActivityAssistDataReceiver) ZeusTransformUtils.wrapperContextForParams(r4, ITopActivityAssistDataReceiver.class, "com.obric.aiagent.plugin");
        return Companion.requestTopActivityAssistData(r2, r3, r5);
    }

    public static void setMuteWhitelist(List<String> r2) {
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        Companion.setMuteWhitelist(r3);
    }

    public static boolean supportsAutoVirtualDisplayRecordSet() {
        return Companion.supportsAutoVirtualDisplayRecordSet();
    }

    public static void tryToMute(boolean r1) {
        Companion.tryToMute(r1);
    }

    public static boolean unregisterBackNavigationInVirtualDisplayListenerEx(ObricBackNavigationListener r1) {
        return Companion.unregisterBackNavigationInVirtualDisplayListenerEx(r1);
    }

    public static boolean unregisterBackNavigationListener(ObricBackNavigationListener r1) {
        return Companion.unregisterBackNavigationListener(r1);
    }

    public static boolean unregisterObricDisplayInfoCallback(ObricDisplayInfoCallback r1) {
        return Companion.unregisterObricDisplayInfoCallback(r1);
    }

    public static boolean unregisterTaskStackListenerEx(ObricTaskStackListener r1) {
        return Companion.unregisterTaskStackListenerEx(r1);
    }

    public ObricActivityManager() {
    }

    public static final /* synthetic */ IObricActivityManager access$getInstance$cp() {
        return instance;
    }

    static {
        Companion = new Companion(null);
    L9:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind CommonActivityManager failed", th);
    L11:
        instance = (IObricActivityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IObricActivityManager.class, false), IObricActivityManager.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "ObricActivityManager instance: " + instance);
        return;
    L4:
        if (b.f18770a.a() == false) goto L6;
        ServiceManager.get().bind(IObricActivityManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricActivityManager$__RfqksKogegVI6YzGYuH8dw4nk.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
    L7:
        ILogDepend.Companion.i(TAG, "bind ActivityManager assistantApi= " + b.f18770a.a());     // Catch: Throwable -> L9
        goto L11
    L6:
        ServiceManager.get().bind(IObricActivityManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricActivityManager$VOPFpbbh89SYb3uLIzYGJVTngCo.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
        goto L7
    }

    private static final Object _init_$lambda$0() {
        return new a();
    }

    private static final Object _init_$lambda$1() {
        return new g();
    }
}
