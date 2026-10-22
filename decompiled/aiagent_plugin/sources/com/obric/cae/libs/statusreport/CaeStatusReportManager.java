package com.obric.cae.libs.statusreport;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.libs.utils.LogUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class CaeStatusReportManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static CaeStatusReportManager f31771d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICaeStatusReportManager f31772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f31773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f31774c;

    public interface LinkLayerQualityChangedListener {
        void onAverLinkLayerLevelChanged(LinkLayerQuality r1);

        void onLinkLayerLevelChanged(LinkLayerQuality r1);

        void onLinkLayerQualityChanged(LinkLayerQuality r1);
    }

    public class LinkLayerQualityChangedListenerProxy extends ILinkLayerQualityListener.Stub {
        private final LinkLayerQualityChangedListener mListener;
        final /* synthetic */ CaeStatusReportManager this$0;

        public LinkLayerQualityChangedListenerProxy(CaeStatusReportManager r3, LinkLayerQualityChangedListener r4) {
            LinkLayerQualityChangedListener r5 = (LinkLayerQualityChangedListener) ZeusTransformUtils.wrapperContextForParams(r4, LinkLayerQualityChangedListener.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.mListener = r5;
        }

        public LinkLayerQualityChangedListener getListener() {
            return this.mListener;
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onAverLinkLayerLevelChanged(LinkLayerQuality r1) {
            this.mListener.onAverLinkLayerLevelChanged(r1);
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerLevelChanged(LinkLayerQuality r1) {
            this.mListener.onLinkLayerLevelChanged(r1);
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerQualityChanged(LinkLayerQuality r1) {
            this.mListener.onLinkLayerQualityChanged(r1);
        }
    }

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeStatusReportManager f31775a;

        public a(CaeStatusReportManager r1) {
            this.f31775a = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int r1 = 0;
        L4:
            if (r1 >= 50) goto L30;
            SystemClock.sleep(100);
            this.f31775a.f31772a = ICaeStatusReportManager.Stub.asInterface((IBinder) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.aiagent.plugin").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_status_report"}), IBinder.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L8
        L10:
            CaeStatusReportManager r2 = this.f31775a;
            if (r2.f31772a != null) goto L12;
            r1 = r1 + 1;
            goto L4
        L12:
            r2.a();
            CaeStatusReportManager r10 = this.f31775a;
            HashMap r0 = r10.f31774c;
            if (r0 != null) goto L15;
            return;
        L15:
            if (r0.size() <= 0) goto L64;
            Iterator r3 = r10.f31774c.keySet().iterator();
        L18:
            if (r3.hasNext() == false) goto L66;
            LinkLayerQualityChangedListenerProxy r4 = (LinkLayerQualityChangedListenerProxy) ZeusTransformUtils.preCheckCast(r10.f31774c.get((Integer) ZeusTransformUtils.preCheckCast(r3.next(), Integer.class, "com.obric.aiagent.plugin")), LinkLayerQualityChangedListenerProxy.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L18;
            ICaeStatusReportManager r5 = r10.f31772a;
            if (r5 == null) goto L24;
            r5.registerLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(r10.f31773b), r4);     // Catch: RemoteException -> L27
        L27:
            LogUtil.e("CaeStatusReportManager", "RemoteException !!!");
            goto L18
        L24:
            LogUtil.e("CaeStatusReportManager", "autoRegisterListenerOnRetryBindSuccess, mIStatusReportMgr is null");
            return;
        L66:
            return;
        L64:
            return;
        L8:
            e = move-exception;
            LogUtil.e("CaeStatusReportManager", "Get service failed: " + e);
            goto L10
        L30:
            LogUtil.e("CaeStatusReportManager", "get status report service error!!!");
            CaeStatusReportManager r11 = this.f31775a;
            HashMap r6 = r11.f31774c;
            if (r6 != null) goto L33;
            return;
        L33:
            if (r6.size() <= 0) goto L67;
            Iterator r7 = r11.f31774c.keySet().iterator();
        L36:
            if (r7.hasNext() == false) goto L68;
            Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r7.next(), Integer.class, "com.obric.aiagent.plugin");
            LinkLayerQualityChangedListenerProxy r9 = (LinkLayerQualityChangedListenerProxy) ZeusTransformUtils.preCheckCast(r11.f31774c.get(r8), LinkLayerQualityChangedListenerProxy.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L36;
            if (r9.getListener() == null) goto L36;
            r9.getListener().onLinkLayerQualityChanged(null);
            r9.getListener().onLinkLayerLevelChanged(null);
            r9.getListener().onAverLinkLayerLevelChanged(null);
            r11.f31774c.remove(r8);
            goto L36
        L68:
            return;
        }
    }

    public class b implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeStatusReportManager f31776a;

        public b(CaeStatusReportManager r1) {
            this.f31776a = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeStatusReportManager", "statusReport service is dead!");
            CaeStatusReportManager r2 = this.f31776a;
            r2.f31772a = null;
            r2.retryGetServiceThread();
        }
    }

    public CaeStatusReportManager(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        this.f31774c = new HashMap();
        this.f31773b = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.f31772a = ICaeStatusReportManager.Stub.asInterface((IBinder) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.aiagent.plugin").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_status_report"}), IBinder.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L5
    L8:
        if (this.f31772a == null) goto L10;
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
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L16;
        monitor-enter(CaeStatusReportManager.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f31771d != null) goto L9;
        f31771d = new CaeStatusReportManager(r3);     // Catch: Throwable -> L12
    L9:
        monitor-exit(CaeStatusReportManager.class);     // Catch: Throwable -> L12
        return f31771d;
    L16:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void a() {
        this.f31772a.asBinder().linkToDeath(new b(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.nfc.a.a("CaeStatusReportManager linkToDeath! :", e, "CaeStatusReportManager");
    }

    public String getCaeVersion() {
        ICaeStatusReportManager r4 = this.f31772a;
        if (r4 != null) goto L11;
        LogUtil.e("CaeStatusReportManager", "getCaeVersion, mIStatusReportMgr is null");
        return null;
    L11:
        return r4.getCaeVersion();
    L8:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "getCaeVersion fail, e=" + e);
        return null;
    }

    public LinkLayerQuality getLinkLayerQuality() {
        ICaeStatusReportManager r0 = this.f31772a;
        if (r0 != null) goto L11;
        LogUtil.e("CaeStatusReportManager", "getLinkLayerQuality, mIStatusReportMgr is null");
        return null;
    L11:
        return r0.getLinkLayerQuality(CaelibUtils.getCallingPackageName(this.f31773b));
    L8:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "getLinkLayerQuality fail, e=" + e);
        return null;
    }

    public boolean registerLinkLayerQualityChangedListener(LinkLayerQualityChangedListener r6) {
        LinkLayerQualityChangedListener r7 = (LinkLayerQualityChangedListener) ZeusTransformUtils.wrapperContextForParams(r6, LinkLayerQualityChangedListener.class, "com.obric.aiagent.plugin");
        if (this.f31772a != null) goto L6;
        LogUtil.e("CaeStatusReportManager", "registerLinkLayerQualityChangedListener, mIStatusReportMgr is null");
        return false;
    L6:
        if (r7 == null) goto L18;
        if (this.f31774c.containsKey(Integer.valueOf(r7.hashCode())) == false) goto L19;
        return false;
    L19:
        LinkLayerQualityChangedListenerProxy r0 = new LinkLayerQualityChangedListenerProxy(this, r7);     // Catch: RemoteException -> L15
        if (this.f31772a.registerLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(this.f31773b), r0) == false) goto L21;
        this.f31774c.put(Integer.valueOf(r7.hashCode()), r0);     // Catch: RemoteException -> L15
        return true;
    L21:
        return true;
    L15:
        LogUtil.e("CaeStatusReportManager", "RemoteException !!!");
        return false;
    L18:
        throw new IllegalArgumentException("callback cannot be null");
    }

    public void retryGetServiceThread() {
        new a(this).start();
    }

    public boolean unregisterLinkLayerQualityChangedListener(LinkLayerQualityChangedListener r6) {
        LinkLayerQualityChangedListener r7 = (LinkLayerQualityChangedListener) ZeusTransformUtils.wrapperContextForParams(r6, LinkLayerQualityChangedListener.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
    L17:
        LogUtil.e("CaeStatusReportManager", "unregisterLinkLayerQualityChangedListener, listener:" + r7 + ", mStatusReportManager:" + this.f31772a + ", mLinkLayerListenerMap:" + this.f31774c);
        return false;
    L5:
        if (this.f31772a == null) goto L17;
        if (this.f31774c == null) goto L17;
        int r8 = r7.hashCode();     // Catch: RemoteException -> L14
        if (this.f31774c.containsKey(Integer.valueOf(r8)) == true) goto L12;
        return false;
    L12:
        return this.f31772a.unregisterLinkLayerQualityChangedListener(CaelibUtils.getCallingPackageName(this.f31773b), (LinkLayerQualityChangedListenerProxy) ZeusTransformUtils.preCheckCast(this.f31774c.remove(Integer.valueOf(r8)), LinkLayerQualityChangedListenerProxy.class, "com.obric.aiagent.plugin"));
    L14:
        e = move-exception;
        LogUtil.e("CaeStatusReportManager", "RemoteException, ", e);
        return false;
    }
}
