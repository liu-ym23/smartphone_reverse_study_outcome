package com.obric.cae.libs.smartnetwork;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.cae.libs.appscene.AppSceneInfo;
import com.obric.cae.libs.appscene.BaseAppScene;
import com.obric.cae.libs.appscene.IAppSceneCallback;
import com.obric.cae.libs.appscene.IAppSceneQueueCallback;
import com.obric.cae.libs.statusreport.CaeStatusReportManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.wifi.ICaeSmartNetworkManager;
import com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CaeSmartNetworkManager {
    public static CaeSmartNetworkManager e;
    public ICaeSmartNetworkManager a;
    public final HashMap b;
    public final HashMap c;
    public final HashMap d;

    public interface AppSceneCallback {
        void onAppSceneChanged(AppSceneInfo r1);

        default void onAppSceneChangedEnter(AppSceneInfo r1) {
        }

        default void onAppSceneChangedExit(AppSceneInfo r1) {
        }
    }

    public static abstract class AppSceneCallbackAdapter implements AppSceneCallback {
        public AppSceneCallbackAdapter() {
        }

        @Override // com.obric.cae.libs.smartnetwork.CaeSmartNetworkManager.AppSceneCallback
        public void onAppSceneChanged(AppSceneInfo r1) {
        }
    }

    public static class AppSceneCallbackProxy extends IAppSceneCallback.Stub {
        private final AppSceneCallback mCallback;

        public AppSceneCallbackProxy(AppSceneCallback r1) {
            this.mCallback = r1;
        }

        @Override // com.obric.cae.libs.appscene.IAppSceneCallback
        public void onAppSceneChanged(AppSceneInfo r2) {
            this.mCallback.onAppSceneChanged(r2);
        }

        @Override // com.obric.cae.libs.appscene.IAppSceneCallback
        public void onAppSceneChangedEnter(AppSceneInfo r2) {
            this.mCallback.onAppSceneChangedEnter(r2);
        }

        @Override // com.obric.cae.libs.appscene.IAppSceneCallback
        public void onAppSceneChangedExit(AppSceneInfo r2) {
            this.mCallback.onAppSceneChangedExit(r2);
        }
    }

    public interface AppSceneQueueCallback {
        void onAppSceneQueueChanged(List<BaseAppScene> r1);
    }

    public static class AppSceneQueueCallbackProxy extends IAppSceneQueueCallback.Stub {
        private final AppSceneQueueCallback mCallback;

        public AppSceneQueueCallbackProxy(AppSceneQueueCallback r1) {
            this.mCallback = r1;
        }

        @Override // com.obric.cae.libs.appscene.IAppSceneQueueCallback
        public void onAppSceneQueueChanged(List<BaseAppScene> r2) {
            this.mCallback.onAppSceneQueueChanged(r2);
        }
    }

    public interface CaeWifiLinkThroughputListener {
        void onSecondaryThroughputReported(int r1, int r2);

        void onThroughputReported(int r1, int r2);
    }

    public class CaeWifiLinkThroughputListenerProxy extends ICaeWifiLinkThroughputListener.Stub {
        private final CaeWifiLinkThroughputListener mListener;
        final /* synthetic */ CaeSmartNetworkManager this$0;

        public CaeWifiLinkThroughputListenerProxy(CaeSmartNetworkManager r1, CaeWifiLinkThroughputListener r2) {
            this.this$0 = r1;
            this.mListener = r2;
        }

        public CaeWifiLinkThroughputListener getListener() {
            return this.mListener;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener
        public void onSecondaryThroughputReported(int r2, int r3) {
            CaeWifiLinkThroughputListener r0 = this.mListener;
            if (r0 == null) goto L6;
            r0.onSecondaryThroughputReported(r2, r3);
            return;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener
        public void onThroughputReported(int r2, int r3) {
            CaeWifiLinkThroughputListener r0 = this.mListener;
            if (r0 == null) goto L6;
            r0.onThroughputReported(r2, r3);
            return;
        }
    }

    public class a extends Thread {
        public final /* synthetic */ CaeSmartNetworkManager a;

        public a(CaeSmartNetworkManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int r2 = 0;
        L4:
            if (r2 >= 50) goto L61;
            SystemClock.sleep(100);
            this.a.a = ICaeSmartNetworkManager.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_wifi"}));     // Catch: Exception -> L8
        L10:
            CaeSmartNetworkManager r3 = this.a;
            if (r3.a != null) goto L12;
            r2 = r2 + 1;
            goto L4
        L12:
            r3.a();
            CaeSmartNetworkManager r0 = this.a;
            HashMap r1 = r0.b;
            if (r1 != null) goto L15;
        L29:
            HashMap r4 = r0.c;
            monitor-enter(r4);
            Iterator r5 = r0.c.values().iterator();     // Catch: Throwable -> L37
        L33:
            if (r5.hasNext() == false) goto L41;
            r0.a.registerAppSceneCallback((IAppSceneCallback) r5.next());     // Catch: Throwable -> L37 RemoteException -> L39
        L39:
            e = move-exception;
            LogUtil.e("CaeSmartNetworkManager", "Failed to restore app scene callback: " + e);     // Catch: Throwable -> L37
            goto L33
        L41:
            monitor-exit(r4);     // Catch: Throwable -> L37
            HashMap r6 = r0.d;
            monitor-enter(r6);
            Iterator r7 = r0.d.values().iterator();     // Catch: Throwable -> L50
        L46:
            if (r7.hasNext() == false) goto L54;
            r0.a.registerAppSceneQueueCallback((IAppSceneQueueCallback) r7.next());     // Catch: Throwable -> L50 RemoteException -> L52
        L52:
            e = move-exception;
            LogUtil.e("CaeSmartNetworkManager", "Failed to restore app scene queue callback: " + e);     // Catch: Throwable -> L50
            goto L46
        L54:
            monitor-exit(r6);     // Catch: Throwable -> L50
            return;
        L50:
            th = move-exception;
            throw th;
        L37:
            th = move-exception;
            throw th;
        L15:
            if (r1.size() <= 0) goto L29;
            Iterator r8 = r0.b.keySet().iterator();
        L18:
            if (r8.hasNext() == false) goto L29;
            CaeWifiLinkThroughputListenerProxy r9 = (CaeWifiLinkThroughputListenerProxy) r0.b.get((Integer) r8.next());
            if (r9 == null) goto L18;
            ICaeSmartNetworkManager r10 = r0.a;
            if (r10 == null) goto L24;
            r10.registerLinkThroughputListener(r9);     // Catch: RemoteException -> L27
        L28:
            LogUtil.e("CaeSmartNetworkManager", "RemoteException !!!");
            goto L18
        L24:
            LogUtil.e("CaeSmartNetworkManager", "autoRegisterListenerOnRetryBindSuccess, mISmartNetworkMgr is null");
            return;
        L8:
            e = move-exception;
            LogUtil.e("CaeSmartNetworkManager", "Get service failed: " + e);
            goto L10
        L61:
            LogUtil.e("CaeSmartNetworkManager", "get smart network service error!!!");
            CaeSmartNetworkManager r11 = this.a;
            HashMap r12 = r11.b;
            if (r12 != null) goto L64;
            return;
        L64:
            if (r12.size() <= 0) goto L112;
            Iterator r13 = r11.b.keySet().iterator();
        L67:
            if (r13.hasNext() == false) goto L113;
            Integer r14 = (Integer) r13.next();
            CaeWifiLinkThroughputListenerProxy r15 = (CaeWifiLinkThroughputListenerProxy) r11.b.get(r14);
            if (r15 == null) goto L67;
            if (r15.getListener() == null) goto L67;
            r15.getListener().onThroughputReported(0, 0);
            r15.getListener().onSecondaryThroughputReported(0, 0);
            r11.b.remove(r14);
            goto L67
        L113:
            return;
        }
    }

    public class b implements IBinder.DeathRecipient {
        public final /* synthetic */ CaeSmartNetworkManager a;

        public b(CaeSmartNetworkManager r1) {
            this.a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeSmartNetworkManager", "statusReport service is dead!");
            CaeSmartNetworkManager r0 = this.a;
            r0.a = null;
            r0.retryGetServiceThread();
        }
    }

    public CaeSmartNetworkManager(Context r5) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.a = ICaeSmartNetworkManager.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_wifi"}));     // Catch: Exception -> L5
    L8:
        if (this.a == null) goto L10;
        a();
        return;
    L10:
        retryGetServiceThread();
        return;
    L5:
        e = move-exception;
        LogUtil.e("CaeSmartNetworkManager", "Get service failed: " + e);
        goto L8
    }

    public static CaeSmartNetworkManager getInstance(Context r2) {
        if (r2 == null) goto L16;
        monitor-enter(CaeStatusReportManager.class);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (e != null) goto L10;
        e = new CaeSmartNetworkManager(r2);     // Catch: Throwable -> L8
    L10:
        monitor-exit(CaeStatusReportManager.class);     // Catch: Throwable -> L8
        return e;
    L16:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void a() {
        this.a.asBinder().linkToDeath(new b(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("CaeStatusReportManager linkToDeath! :", e, "CaeSmartNetworkManager");
    }

    public int getLinkThroughput() {
        ICaeSmartNetworkManager r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("CaeSmartNetworkManager", "getLinkThroughput, mISmartNetworkMgr is null");
        return 0;
    L11:
        return r0.getLinkThroughput();
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("getLinkThroughput failed: ", e, "CaeSmartNetworkManager");
        return 0;
    }

    public void registerAppSceneCallback(AppSceneCallback r4) {
        if (r4 == null) goto L25;
        HashMap r0 = this.c;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L6:
        if (this.c.containsKey(r4) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        AppSceneCallbackProxy r1 = new AppSceneCallbackProxy(r4);     // Catch: Throwable -> L9
        this.c.put(r4, r1);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        ICaeSmartNetworkManager r5 = this.a;
        if (r5 != null) goto L26;
        LogUtil.w("CaeSmartNetworkManager", "App scene service is not connected; callback will be restored later");
        return;
    L26:
        r5.registerAppSceneCallback(r1);     // Catch: RemoteException -> L19
        return;
    L19:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("registerAppSceneCallback failed: ", e, "CaeSmartNetworkManager");
        return;
    L25:
        throw new IllegalArgumentException("callback cannot be null");
    }

    public void registerAppSceneQueueCallback(AppSceneQueueCallback r4) {
        if (r4 == null) goto L25;
        HashMap r0 = this.d;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L6:
        if (this.d.containsKey(r4) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        AppSceneQueueCallbackProxy r1 = new AppSceneQueueCallbackProxy(r4);     // Catch: Throwable -> L9
        this.d.put(r4, r1);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        ICaeSmartNetworkManager r5 = this.a;
        if (r5 != null) goto L26;
        LogUtil.w("CaeSmartNetworkManager", "App scene service is not connected; queue callback will be restored later");
        return;
    L26:
        r5.registerAppSceneQueueCallback(r1);     // Catch: RemoteException -> L19
        return;
    L19:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("registerAppSceneQueueCallback failed: ", e, "CaeSmartNetworkManager");
        return;
    L25:
        throw new IllegalArgumentException("callback cannot be null");
    }

    public void registerLinkThroughputListener(CaeWifiLinkThroughputListener r4) {
        if (this.a != null) goto L6;
        LogUtil.e("CaeSmartNetworkManager", "registerLinkThroughputListener, mISmartNetworkMgr is null");
        return;
    L6:
        CaeWifiLinkThroughputListenerProxy r0 = new CaeWifiLinkThroughputListenerProxy(this, r4);
        this.b.put(Integer.valueOf(r0.hashCode()), r0);
        this.a.registerLinkThroughputListener(r0);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("registerLinkThroughputListener failed: ", e, "CaeSmartNetworkManager");
    }

    public void retryGetServiceThread() {
        new a(this).start();
    }

    public void unregisterAppSceneCallback(AppSceneCallback r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        HashMap r0 = this.c;
        monitor-enter(r0);
        IAppSceneCallback r4 = (IAppSceneCallback) this.c.remove(r3);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        if (r4 == null) goto L24;
        ICaeSmartNetworkManager r1 = this.a;
        if (r1 == null) goto L25;
        r1.unregisterAppSceneCallback(r4);     // Catch: RemoteException -> L14
        return;
    L14:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("unregisterAppSceneCallback failed: ", e, "CaeSmartNetworkManager");
        return;
    L25:
        return;
    L24:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void unregisterAppSceneQueueCallback(AppSceneQueueCallback r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        HashMap r0 = this.d;
        monitor-enter(r0);
        IAppSceneQueueCallback r4 = (IAppSceneQueueCallback) this.d.remove(r3);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        if (r4 == null) goto L24;
        ICaeSmartNetworkManager r1 = this.a;
        if (r1 == null) goto L25;
        r1.unregisterAppSceneQueueCallback(r4);     // Catch: RemoteException -> L14
        return;
    L14:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("unregisterAppSceneQueueCallback failed: ", e, "CaeSmartNetworkManager");
        return;
    L25:
        return;
    L24:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void unregisterLinkThroughputListener(CaeWifiLinkThroughputListener r3) {
        if (this.a != null) goto L6;
        LogUtil.e("CaeSmartNetworkManager", "unregisterLinkThroughputListener, mISmartNetworkMgr is null");
        return;
    L6:
        CaeWifiLinkThroughputListenerProxy r4 = (CaeWifiLinkThroughputListenerProxy) this.b.get(Integer.valueOf(r3.hashCode()));
        if (r4 != null) goto L15;
        LogUtil.e("CaeSmartNetworkManager", "unregisterLinkThroughputListener failed: proxy is null");
        return;
    L15:
        this.a.unregisterLinkThroughputListener(r4);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("unregisterLinkThroughputListener failed: ", e, "CaeSmartNetworkManager");
    }
}
