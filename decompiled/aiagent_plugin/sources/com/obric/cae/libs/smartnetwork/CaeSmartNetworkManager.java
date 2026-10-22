package com.obric.cae.libs.smartnetwork;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.cae.libs.statusreport.CaeStatusReportManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.wifi.ICaeSmartNetworkManager;
import com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class CaeSmartNetworkManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static CaeSmartNetworkManager f31766c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICaeSmartNetworkManager f31767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f31768b;

    public interface CaeWifiLinkThroughputListener {
        void onSecondaryThroughputReported(int r1, int r2);

        void onThroughputReported(int r1, int r2);
    }

    public class CaeWifiLinkThroughputListenerProxy extends ICaeWifiLinkThroughputListener.Stub {
        private final CaeWifiLinkThroughputListener mListener;
        final /* synthetic */ CaeSmartNetworkManager this$0;

        public CaeWifiLinkThroughputListenerProxy(CaeSmartNetworkManager r3, CaeWifiLinkThroughputListener r4) {
            CaeWifiLinkThroughputListener r5 = (CaeWifiLinkThroughputListener) ZeusTransformUtils.wrapperContextForParams(r4, CaeWifiLinkThroughputListener.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.mListener = r5;
        }

        public CaeWifiLinkThroughputListener getListener() {
            return this.mListener;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener
        public void onSecondaryThroughputReported(int r1, int r2) {
            CaeWifiLinkThroughputListener r0 = this.mListener;
            if (r0 == null) goto L6;
            r0.onSecondaryThroughputReported(r1, r2);
            return;
        }

        @Override // com.obric.cae.libs.wifi.ICaeWifiLinkThroughputListener
        public void onThroughputReported(int r1, int r2) {
            CaeWifiLinkThroughputListener r0 = this.mListener;
            if (r0 == null) goto L6;
            r0.onThroughputReported(r1, r2);
            return;
        }
    }

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeSmartNetworkManager f31769a;

        public a(CaeSmartNetworkManager r1) {
            this.f31769a = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int r1 = 0;
        L4:
            if (r1 >= 50) goto L30;
            SystemClock.sleep(100);
            this.f31769a.f31767a = ICaeSmartNetworkManager.Stub.asInterface((IBinder) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.aiagent.plugin").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_wifi"}), IBinder.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L8
        L10:
            CaeSmartNetworkManager r2 = this.f31769a;
            if (r2.f31767a != null) goto L12;
            r1 = r1 + 1;
            goto L4
        L12:
            r2.a();
            CaeSmartNetworkManager r9 = this.f31769a;
            HashMap r0 = r9.f31768b;
            if (r0 != null) goto L15;
            return;
        L15:
            if (r0.size() <= 0) goto L64;
            Iterator r3 = r9.f31768b.keySet().iterator();
        L18:
            if (r3.hasNext() == false) goto L66;
            CaeWifiLinkThroughputListenerProxy r4 = (CaeWifiLinkThroughputListenerProxy) ZeusTransformUtils.preCheckCast(r9.f31768b.get((Integer) ZeusTransformUtils.preCheckCast(r3.next(), Integer.class, "com.obric.aiagent.plugin")), CaeWifiLinkThroughputListenerProxy.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L18;
            ICaeSmartNetworkManager r5 = r9.f31767a;
            if (r5 == null) goto L24;
            r5.registerLinkThroughputListener(r4);     // Catch: RemoteException -> L27
        L27:
            LogUtil.e("CaeSmartNetworkManager", "RemoteException !!!");
            goto L18
        L24:
            LogUtil.e("CaeSmartNetworkManager", "autoRegisterListenerOnRetryBindSuccess, mISmartNetworkMgr is null");
            return;
        L66:
            return;
        L64:
            return;
        L8:
            e = move-exception;
            LogUtil.e("CaeSmartNetworkManager", "Get service failed: " + e);
            goto L10
        L30:
            LogUtil.e("CaeSmartNetworkManager", "get smart network service error!!!");
            CaeSmartNetworkManager r10 = this.f31769a;
            HashMap r6 = r10.f31768b;
            if (r6 != null) goto L33;
            return;
        L33:
            if (r6.size() <= 0) goto L67;
            Iterator r7 = r10.f31768b.keySet().iterator();
        L36:
            if (r7.hasNext() == false) goto L68;
            Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r7.next(), Integer.class, "com.obric.aiagent.plugin");
            CaeWifiLinkThroughputListenerProxy r11 = (CaeWifiLinkThroughputListenerProxy) ZeusTransformUtils.preCheckCast(r10.f31768b.get(r8), CaeWifiLinkThroughputListenerProxy.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L36;
            if (r11.getListener() == null) goto L36;
            r11.getListener().onThroughputReported(0, 0);
            r11.getListener().onSecondaryThroughputReported(0, 0);
            r10.f31768b.remove(r8);
            goto L36
        L68:
            return;
        }
    }

    public class b implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeSmartNetworkManager f31770a;

        public b(CaeSmartNetworkManager r1) {
            this.f31770a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeSmartNetworkManager", "statusReport service is dead!");
            CaeSmartNetworkManager r2 = this.f31770a;
            r2.f31767a = null;
            r2.retryGetServiceThread();
        }
    }

    public CaeSmartNetworkManager(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        this.f31768b = new HashMap();
        this.f31767a = ICaeSmartNetworkManager.Stub.asInterface((IBinder) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.aiagent.plugin").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_wifi"}), IBinder.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L5
    L8:
        if (this.f31767a == null) goto L10;
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
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L16;
        monitor-enter(CaeStatusReportManager.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f31766c != null) goto L9;
        f31766c = new CaeSmartNetworkManager(r3);     // Catch: Throwable -> L12
    L9:
        monitor-exit(CaeStatusReportManager.class);     // Catch: Throwable -> L12
        return f31766c;
    L16:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void a() {
        this.f31767a.asBinder().linkToDeath(new b(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.nfc.a.a("CaeStatusReportManager linkToDeath! :", e, "CaeSmartNetworkManager");
    }

    public int getLinkThroughput() {
        ICaeSmartNetworkManager r3 = this.f31767a;
        if (r3 != null) goto L11;
        LogUtil.e("CaeSmartNetworkManager", "getLinkThroughput, mISmartNetworkMgr is null");
        return 0;
    L11:
        return r3.getLinkThroughput();
    L8:
        e = move-exception;
        com.obric.cae.libs.nfc.a.a("getLinkThroughput failed: ", e, "CaeSmartNetworkManager");
        return 0;
    }

    public void registerLinkThroughputListener(CaeWifiLinkThroughputListener r4) {
        CaeWifiLinkThroughputListener r5 = (CaeWifiLinkThroughputListener) ZeusTransformUtils.wrapperContextForParams(r4, CaeWifiLinkThroughputListener.class, "com.obric.aiagent.plugin");
        if (this.f31767a != null) goto L6;
        LogUtil.e("CaeSmartNetworkManager", "registerLinkThroughputListener, mISmartNetworkMgr is null");
        return;
    L6:
        CaeWifiLinkThroughputListenerProxy r0 = new CaeWifiLinkThroughputListenerProxy(this, r5);
        this.f31768b.put(Integer.valueOf(r0.hashCode()), r0);
        this.f31767a.registerLinkThroughputListener(r0);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        com.obric.cae.libs.nfc.a.a("registerLinkThroughputListener failed: ", e, "CaeSmartNetworkManager");
    }

    public void retryGetServiceThread() {
        new a(this).start();
    }

    public void unregisterLinkThroughputListener(CaeWifiLinkThroughputListener r4) {
        CaeWifiLinkThroughputListener r5 = (CaeWifiLinkThroughputListener) ZeusTransformUtils.wrapperContextForParams(r4, CaeWifiLinkThroughputListener.class, "com.obric.aiagent.plugin");
        if (this.f31767a != null) goto L6;
        LogUtil.e("CaeSmartNetworkManager", "unregisterLinkThroughputListener, mISmartNetworkMgr is null");
        return;
    L6:
        CaeWifiLinkThroughputListenerProxy r6 = (CaeWifiLinkThroughputListenerProxy) ZeusTransformUtils.preCheckCast(this.f31768b.get(Integer.valueOf(r5.hashCode())), CaeWifiLinkThroughputListenerProxy.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L15;
        LogUtil.e("CaeSmartNetworkManager", "unregisterLinkThroughputListener failed: proxy is null");
        return;
    L15:
        this.f31767a.unregisterLinkThroughputListener(r6);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        com.obric.cae.libs.nfc.a.a("unregisterLinkThroughputListener failed: ", e, "CaeSmartNetworkManager");
    }
}
