package com.obric.cae.libs.statusreport;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.libs.utils.LogUtil;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class CaeStatusReportManager {
    public static CaeStatusReportManager d;
    public ICaeStatusReportManager a;
    public final Context b;
    public final HashMap c;

    public interface LinkLayerQualityChangedListener {
        void onAverLinkLayerLevelChanged(LinkLayerQuality r1);

        void onLinkLayerLevelChanged(LinkLayerQuality r1);

        void onLinkLayerQualityChanged(LinkLayerQuality r1);
    }

    public class LinkLayerQualityChangedListenerProxy extends ILinkLayerQualityListener.Stub {
        private final LinkLayerQualityChangedListener mListener;
        final /* synthetic */ CaeStatusReportManager this$0;

        public LinkLayerQualityChangedListenerProxy(CaeStatusReportManager r1, LinkLayerQualityChangedListener r2) {
            this.this$0 = r1;
            this.mListener = r2;
        }

        public LinkLayerQualityChangedListener getListener() {
            return this.mListener;
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onAverLinkLayerLevelChanged(LinkLayerQuality r2) {
            this.mListener.onAverLinkLayerLevelChanged(r2);
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerLevelChanged(LinkLayerQuality r2) {
            this.mListener.onLinkLayerLevelChanged(r2);
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerQualityChanged(LinkLayerQuality r2) {
            this.mListener.onLinkLayerQualityChanged(r2);
        }
    }

    public class a extends Thread {
        public final /* synthetic */ CaeStatusReportManager a;

        public a(CaeStatusReportManager r1) {
            this.a = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int r2 = 0;
        L4:
            if (r2 >= 50) goto L31;
            SystemClock.sleep(100);
            this.a.a = ICaeStatusReportManager.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_status_report"}));     // Catch: Exception -> L8
        L10:
            CaeStatusReportManager r3 = this.a;
            if (r3.a != null) goto L12;
            r2 = r2 + 1;
            goto L4
        L12:
            r3.a();
            CaeStatusReportManager r0 = this.a;
            HashMap r1 = r0.c;
            if (r1 != null) goto L15;
            return;
        L15:
            if (r1.size() <= 0) goto L65;
            Iterator r4 = r0.c.keySet().iterator();
        L18:
            if (r4.hasNext() == false) goto L67;
            LinkLayerQualityChangedListenerProxy r5 = (LinkLayerQualityChangedListenerProxy) r0.c.get((Integer) r4.next());
            if (r5 == null) goto L18;
            ICaeStatusReportManager r6 = r0.a;
            if (r6 == null) goto L24;
            r6.registerLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(r0.b), r5);     // Catch: RemoteException -> L27
        L28:
            LogUtil.e("CaeStatusReportManager", "RemoteException !!!");
            goto L18
        L24:
            LogUtil.e("CaeStatusReportManager", "autoRegisterListenerOnRetryBindSuccess, mIStatusReportMgr is null");
            return;
        L67:
            return;
        L65:
            return;
        L8:
            e = move-exception;
            LogUtil.e("CaeStatusReportManager", "Get service failed: " + e);
            goto L10
        L31:
            LogUtil.e("CaeStatusReportManager", "get status report service error!!!");
            CaeStatusReportManager r7 = this.a;
            HashMap r8 = r7.c;
            if (r8 != null) goto L34;
            return;
        L34:
            if (r8.size() <= 0) goto L68;
            Iterator r9 = r7.c.keySet().iterator();
        L37:
            if (r9.hasNext() == false) goto L69;
            Integer r10 = (Integer) r9.next();
            LinkLayerQualityChangedListenerProxy r11 = (LinkLayerQualityChangedListenerProxy) r7.c.get(r10);
            if (r11 == null) goto L37;
            if (r11.getListener() == null) goto L37;
            r11.getListener().onLinkLayerQualityChanged(null);
            r11.getListener().onLinkLayerLevelChanged(null);
            r11.getListener().onAverLinkLayerLevelChanged(null);
            r7.c.remove(r10);
            goto L37
        L69:
            return;
        }
    }

    public class b implements IBinder.DeathRecipient {
        public final /* synthetic */ CaeStatusReportManager a;

        public b(CaeStatusReportManager r1) {
            this.a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeStatusReportManager", "statusReport service is dead!");
            CaeStatusReportManager r0 = this.a;
            r0.a = null;
            r0.retryGetServiceThread();
        }
    }

    public CaeStatusReportManager(Context r5) {
        this.c = new HashMap();
        this.b = r5;
        this.a = ICaeStatusReportManager.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_status_report"}));     // Catch: Exception -> L5
    L8:
        if (this.a == null) goto L10;
        a();
        return;
    L10:
        retryGetServiceThread();
        return;
    L5:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "Get service failed: " + e);
        goto L8
    }

    public static CaeStatusReportManager getInstance(Context r2) {
        if (r2 == null) goto L16;
        monitor-enter(CaeStatusReportManager.class);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (d != null) goto L10;
        d = new CaeStatusReportManager(r2);     // Catch: Throwable -> L8
    L10:
        monitor-exit(CaeStatusReportManager.class);     // Catch: Throwable -> L8
        return d;
    L16:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void a() {
        this.a.asBinder().linkToDeath(new b(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("CaeStatusReportManager linkToDeath! :", e, "CaeStatusReportManager");
    }

    public String getCaeVersion() {
        ICaeStatusReportManager r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("CaeStatusReportManager", "getCaeVersion, mIStatusReportMgr is null");
        return null;
    L11:
        return r0.getCaeVersion();
    L8:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "getCaeVersion fail, e=" + e);
        return null;
    }

    public LinkLayerQuality getLinkLayerQuality() {
        ICaeStatusReportManager r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("CaeStatusReportManager", "getLinkLayerQuality, mIStatusReportMgr is null");
        return null;
    L11:
        return r0.getLinkLayerQuality(CaelibUtils.getCallingPackageName(this.b));
    L8:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "getLinkLayerQuality fail, e=" + e);
        return null;
    }

    public boolean registerLinkLayerQualityChangedListener(LinkLayerQualityChangedListener r6) {
        if (this.a != null) goto L6;
        LogUtil.e("CaeStatusReportManager", "registerLinkLayerQualityChangedListener, mIStatusReportMgr is null");
        return false;
    L6:
        if (r6 == null) goto L21;
        if (this.c.containsKey(Integer.valueOf(r6.hashCode())) == false) goto L22;
        return false;
    L22:
        LinkLayerQualityChangedListenerProxy r0 = new LinkLayerQualityChangedListenerProxy(this, r6);     // Catch: RemoteException -> L14
        if (this.a.registerLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(this.b), r0) == false) goto L16;
        this.c.put(Integer.valueOf(r6.hashCode()), r0);     // Catch: RemoteException -> L14
        return true;
    L16:
        return true;
    L18:
        LogUtil.e("CaeStatusReportManager", "RemoteException !!!");
        return false;
    L21:
        throw new IllegalArgumentException("callback cannot be null");
    }

    public void retryGetServiceThread() {
        new a(this).start();
    }

    public boolean unregisterLinkLayerQualityChangedListener(LinkLayerQualityChangedListener r5) {
        if (r5 != null) goto L5;
    L17:
        LogUtil.e("CaeStatusReportManager", "unregisterLinkLayerQualityChangedListener, listener:" + r5 + ", mStatusReportManager:" + this.a + ", mLinkLayerListenerMap:" + this.c);
        return false;
    L5:
        if (this.a == null) goto L17;
        if (this.c == null) goto L17;
        int r6 = r5.hashCode();     // Catch: RemoteException -> L14
        if (this.c.containsKey(Integer.valueOf(r6)) == true) goto L12;
        return false;
    L12:
        return this.a.unregisterLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(this.b), (LinkLayerQualityChangedListenerProxy) this.c.remove(Integer.valueOf(r6)));
    L14:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "RemoteException, ", e);
        return false;
    }
}
