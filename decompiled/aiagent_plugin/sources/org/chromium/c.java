package org.chromium;

import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CronetAppProviderManager.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f40526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f40527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ICronetAppProvider f40528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ICronetDepend f40529d;

    private c() {
    }

    public static c a() {
        if (f40526a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f40526a != null) goto L9;
        f40526a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f40526a;
    }

    public void a(Object r5) {
        if (r5 == null) goto L23;
        Class<?> r1 = r5.getClass();     // Catch: Throwable -> L29
        if (r1 != null) goto L7;
        return;
    L7:
        List r2 = h.a(r1);     // Catch: Throwable -> L29
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.isEmpty() == true) goto L37;
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L29
    L14:
        if (r3.hasNext() == false) goto L23;
        if ("com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider".equals(((Class) ZeusTransformUtils.preCheckCast(r3.next(), Class.class, "com.obric.aiagent.plugin")).getName()) == false) goto L14;
        if (d.a().loggerDebug() == false) goto L20;
        d.a().loggerD("CronetAppProviderManager", "inject CronetAppProviderManager success");     // Catch: Throwable -> L29
    L20:
        this.f40527b = r5;     // Catch: Throwable -> L29
        goto L23
    L37:
        return;
    L29:
        th = move-exception;
        th.printStackTrace();
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(r5, ICronetAppProvider.class) == false) goto L26;
        this.f40528c = (ICronetAppProvider) ZeusTransformUtils.preCheckCast(r5, ICronetAppProvider.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
    L26:
        if (ZeusTransformUtils.instanceOf(r5, ICronetDepend.class) == false) goto L38;
        this.f40529d = (ICronetDepend) ZeusTransformUtils.preCheckCast(r5, ICronetDepend.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        return;
    }

    public void a(String r7, String r8) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "Send monitor json = " + r7 + ", log type =" + r8);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r6 = this.f40528c;     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        return;
    L10:
        r6.sendAppMonitorEvent(r7, r8);     // Catch: Throwable -> L16
        return;
    L11:
        Object r9 = this.f40527b;     // Catch: Throwable -> L16
        if (r9 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r9).call("sendAppMonitorEvent", new Class[]{String.class, String.class}, new Object[]{r7, r8});     // Catch: Throwable -> L16
    }

    public void a(String r7, String r8, String r9) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onServerConfigUpdated json = " + r7);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r0 = this.f40528c;     // Catch: Throwable -> L16
        if (r0 != null) goto L10;
        return;
    L10:
        r0.onServerConfigEtagChanged(r8);     // Catch: Throwable -> L16
        this.f40528c.onServerConfigABTestChanged(r9);     // Catch: Throwable -> L16
        this.f40528c.onServerConfigUpdated(r7);     // Catch: Throwable -> L16
        return;
    L11:
        Object r1 = this.f40527b;     // Catch: Throwable -> L16
        if (r1 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r1).call("onServerConfigEtagChanged", new Class[]{String.class}, new Object[]{r8});     // Catch: Throwable -> L16
        com.bytedance.frameworks.baselib.network.h.a.a(this.f40527b).call("onServerConfigABTestChanged", new Class[]{String.class}, new Object[]{r9});     // Catch: Throwable -> L16
        com.bytedance.frameworks.baselib.network.h.a.a(this.f40527b).call("onServerConfigUpdated", new Class[]{String.class}, new Object[]{r7});     // Catch: Throwable -> L16
    }

    public void a(String r6) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onTTNetDetectInfoChanged info str = " + r6);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r5 = this.f40528c;     // Catch: Throwable -> L16
        if (r5 != null) goto L10;
        return;
    L10:
        r5.onTTNetDetectInfoChanged(r6);     // Catch: Throwable -> L16
        return;
    L11:
        Object r7 = this.f40527b;     // Catch: Throwable -> L16
        if (r7 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r7).call("onTTNetDetectInfoChanged", new Class[]{String.class}, new Object[]{r6});     // Catch: Throwable -> L16
    }

    public void a(String r16, String r17, int r18, int r19, int r20, List<String> r21, String r22) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onTTDnsResolveResult info uuid = " + r16 + " host: " + r17);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r0 = this.f40528c;     // Catch: Throwable -> L16
        if (r0 != null) goto L10;
        return;
    L10:
        r0.onTTDnsResolveResult(r16, r17, r18, r19, r20, r6, r22);     // Catch: Throwable -> L16
        return;
    L11:
        Object r1 = this.f40527b;     // Catch: Throwable -> L16
        if (r1 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r1).call("onTTDnsResolveResult", new Class[]{String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, List.class, String.class}, new Object[]{r16, r17, Integer.valueOf(r18), Integer.valueOf(r19), Integer.valueOf(r20), r6, r22});     // Catch: Throwable -> L16
    }

    public void a(String r7, int r8) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onMappingRequestStatus key = " + r7 + " status = " + r8);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r6 = this.f40528c;     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        return;
    L10:
        r6.onMappingRequestStatus(r7, r8);     // Catch: Throwable -> L16
        return;
    L11:
        Object r9 = this.f40527b;     // Catch: Throwable -> L16
        if (r9 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r9).call("onMappingRequestStatus", new Class[]{String.class, Integer.TYPE}, new Object[]{r7, Integer.valueOf(r8)});     // Catch: Throwable -> L16
    }

    public void a(int r6) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onEffectiveConnectionTypeChanged type = " + r6);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r5 = this.f40528c;     // Catch: Throwable -> L16
        if (r5 != null) goto L10;
        return;
    L10:
        r5.onEffectiveConnectionTypeChangedOnIOThread(r6);     // Catch: Throwable -> L16
        return;
    L11:
        Object r7 = this.f40527b;     // Catch: Throwable -> L16
        if (r7 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r7).call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r6)});     // Catch: Throwable -> L16
    }

    public void a(int r8, int r9, int r10) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onRTTOrThroughputEstimatesComputed httpRtt = " + r8 + ", transportRttMs = " + r9 + ",downstreamThroughputKbps = " + r10);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r7 = this.f40528c;     // Catch: Throwable -> L16
        if (r7 != null) goto L10;
        return;
    L10:
        r7.onRTTOrThroughputEstimatesComputedOnIOThread(r8, r9, r10);     // Catch: Throwable -> L16
        return;
    L11:
        Object r11 = this.f40527b;     // Catch: Throwable -> L16
        if (r11 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r11).call("onRTTOrThroughputEstimatesComputedOnIOThread", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10)});     // Catch: Throwable -> L16
    }

    public void a(int r20, double r21, double r23, double r25, double r27) {
        if (d.a().loggerDebug() == false) goto L20;
        d.a().loggerD("CronetAppProviderManager", "onPacketLossComputed protocol = " + r20 + ", upstreamLossRate = " + r21 + ", upstreamLossRateVariance = " + r23 + ", downstreamLossRate = " + r25 + ", downstreamLossRateVariance = " + r27);
    L20:
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L12;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L17
        if (r3 != null) goto L11;
        return;
    L11:
        r3.onPacketLossComputedOnIOThread(r20, r21, r23, r25, r27);     // Catch: Throwable -> L17
        return;
    L12:
        Object r0 = this.f40527b;     // Catch: Throwable -> L17
        if (r0 != null) goto L15;
        return;
    L15:
        com.bytedance.frameworks.baselib.network.h.a.a(r0).call("onPacketLossComputedOnIOThread", new Class[]{Integer.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE}, new Object[]{Integer.valueOf(r20), Double.valueOf(r21), Double.valueOf(r23), Double.valueOf(r25), Double.valueOf(r27)});     // Catch: Throwable -> L17
    }

    public void b(int r9) {
        if (d.a().loggerDebug() == false) goto L20;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityTypeChangedV3, network_quality_type = " + r9);
    L20:
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L12;
        ICronetAppProvider r8 = this.f40528c;     // Catch: Throwable -> L17
        if (r8 != null) goto L11;
        return;
    L11:
        r8.onEffectiveConnectionTypeChangedOnIOThread(r9);     // Catch: Throwable -> L17
        com.bytedance.frameworks.baselib.network.h.a.a("com.bytedance.ttnet.NQEManager", null).call("notifyNQTChanged", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r9)});     // Catch: Throwable -> L17
        return;
    L12:
        Object r10 = this.f40527b;     // Catch: Throwable -> L17
        if (r10 != null) goto L15;
        return;
    L15:
        com.bytedance.frameworks.baselib.network.h.a.a(r10).call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r9)});     // Catch: Throwable -> L17
        com.bytedance.frameworks.baselib.network.h.a.a("com.bytedance.ttnet.NQEManager").call("notifyNQTChanged", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r9)});     // Catch: Throwable -> L17
    }

    public void b() {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onColdStartFinish ");
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L16
        if (r3 != null) goto L10;
        return;
    L10:
        r3.onColdStartFinish();     // Catch: Throwable -> L16
        return;
    L11:
        Object r4 = this.f40527b;     // Catch: Throwable -> L16
        if (r4 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r4).call("onColdStartFinish");     // Catch: Throwable -> L16
    }

    public void b(String r6) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onClientIPChanged ");
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r5 = this.f40528c;     // Catch: Throwable -> L16
        if (r5 != null) goto L10;
        return;
    L10:
        r5.onClientIPChanged(r6);     // Catch: Throwable -> L16
        return;
    L11:
        Object r7 = this.f40527b;     // Catch: Throwable -> L16
        if (r7 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r7).call("onClientIPChanged", new Class[]{String.class}, new Object[]{r6});     // Catch: Throwable -> L16
    }

    public void a(List<String> r7, List<String> r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onPublicIPsChanged ");
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r6 = this.f40528c;     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        return;
    L10:
        r6.onPublicIPsChanged(r9, r10);     // Catch: Throwable -> L16
        return;
    L11:
        Object r11 = this.f40527b;     // Catch: Throwable -> L16
        if (r11 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r11).call("onPublicIPsChanged", new Class[]{List.class, List.class}, new Object[]{r9, r10});     // Catch: Throwable -> L16
    }

    public void a(String r12, String r13, String r14, String r15, String r16, String r17) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onStoreIdcChanged ");
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r2 = this.f40528c;     // Catch: Throwable -> L16
        if (r2 != null) goto L10;
        return;
    L10:
        r2.onStoreIdcChanged(r12, r13, r14, r15, r16, r17);     // Catch: Throwable -> L16
        return;
    L11:
        Object r0 = this.f40527b;     // Catch: Throwable -> L16
        if (r0 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r0).call("onStoreIdcChanged", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r12, r13, r14, r15, r16, r17});     // Catch: Throwable -> L16
    }

    public void a(boolean r7, List<Integer> r8) {
        List<Integer> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onDropReasonChanged " + r7 + ", Drop Reason List " + r9);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r6 = this.f40528c;     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        return;
    L10:
        r6.onDropReasonChanged(r7, r9);     // Catch: Throwable -> L16
        return;
    L11:
        Object r10 = this.f40527b;     // Catch: Throwable -> L16
        if (r10 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r10).call("onDropReasonChanged", new Class[]{Boolean.TYPE, List.class}, new Object[]{Boolean.valueOf(r7), r9});     // Catch: Throwable -> L16
    }

    public void c() {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onCronetBootSucceed ");
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L16
        if (r3 != null) goto L10;
        return;
    L10:
        r3.onCronetBootSucceed();     // Catch: Throwable -> L16
        return;
    L11:
        Object r4 = this.f40527b;     // Catch: Throwable -> L16
        if (r4 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r4).call("onCronetBootSucceed");     // Catch: Throwable -> L16
    }

    public void a(String[] r7, String r8) {
        if (d.a().loggerDebug() == false) goto L5;
        d.a().loggerD("CronetAppProviderManager", "onTNCUpdateFailed ");
    L5:
        if (r7 == null) goto L27;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (r7.length <= 0) goto L23;
        ArrayList<String> r0 = new ArrayList();     // Catch: Throwable -> L20
        Collections.addAll(r0, r7);     // Catch: Throwable -> L20
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L15;
        ICronetAppProvider r6 = this.f40528c;     // Catch: Throwable -> L20
        if (r6 != null) goto L14;
        return;
    L14:
        r6.onTNCUpdateFailed(r0, r8);     // Catch: Throwable -> L20
        goto L23
    L15:
        Object r9 = this.f40527b;     // Catch: Throwable -> L20
        if (r9 != null) goto L18;
        return;
    L18:
        com.bytedance.frameworks.baselib.network.h.a.a(r9).call("onTNCUpdateFailed", new Class[]{ArrayList.class, String.class}, new Object[]{r0, r8});     // Catch: Throwable -> L20
    L23:
        return;
    }

    public Map<String, String> a(String r9, Map<String, String> r10) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        if (d.a().loggerDebug() == false) goto L21;
        d.a().loggerD("CronetAppProviderManager", "onCallToAddSecurityFactor info url = " + r9);
    L21:
    L18:
        th = move-exception;
        th.printStackTrace();
        return null;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L13;
        ICronetAppProvider r8 = this.f40528c;     // Catch: Throwable -> L18
        if (r8 != null) goto L12;
        return null;
    L12:
        return r8.onCallToAddSecurityFactor(r9, r11);
    L13:
        Object r12 = this.f40527b;     // Catch: Throwable -> L18
        if (r12 != null) goto L17;
        return null;
    L17:
        return (Map) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r12).call("onCallToAddSecurityFactor", new Class[]{String.class, Map.class}, new Object[]{r9, r11}).a(), Map.class, "com.obric.aiagent.plugin");
    }

    public void a(int r7, int r8) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onWiFiToCellStateChanged, prev state = " + r7 + ", curr state = " + r8);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r6 = this.f40528c;     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        return;
    L10:
        r6.onWiFiToCellStateChanged(r7, r8);     // Catch: Throwable -> L16
        return;
    L11:
        Object r9 = this.f40527b;     // Catch: Throwable -> L16
        if (r9 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r9).call("onWiFiToCellStateChanged", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)}).a();     // Catch: Throwable -> L16
    }

    public void b(int r7, int r8) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onMultiNetworkStateChanged, prev state = " + r7 + ", curr state = " + r8);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r6 = this.f40528c;     // Catch: Throwable -> L16
        if (r6 != null) goto L10;
        return;
    L10:
        r6.onMultiNetworkStateChanged(r7, r8);     // Catch: Throwable -> L16
        return;
    L11:
        Object r9 = this.f40527b;     // Catch: Throwable -> L16
        if (r9 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r9).call("onMultiNetworkStateChanged", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)}).a();     // Catch: Throwable -> L16
    }

    public void a(boolean r6) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onUserSpecifiedNetworkEnabled, enable = " + r6);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r5 = this.f40528c;     // Catch: Throwable -> L16
        if (r5 != null) goto L10;
        return;
    L10:
        r5.onUserSpecifiedNetworkEnabled(r6);     // Catch: Throwable -> L16
        return;
    L11:
        Object r7 = this.f40527b;     // Catch: Throwable -> L16
        if (r7 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r7).call("onUserSpecifiedNetworkEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(r6)});     // Catch: Throwable -> L16
    }

    public void c(int r6) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityLevelChanged, nql: " + r6);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r5 = this.f40528c;     // Catch: Throwable -> L16
        if (r5 != null) goto L10;
        return;
    L10:
        r5.onNetworkQualityLevelChangedOnIOThread(r6);     // Catch: Throwable -> L16
        return;
    L11:
        Object r7 = this.f40527b;     // Catch: Throwable -> L16
        if (r7 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r7).call("onNetworkQualityLevelChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r6)}).a();     // Catch: Throwable -> L16
    }

    public void b(int r8, int r9, int r10) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityRttAndThroughputNotified, effectiveHrttMs: " + r8 + ", effectiveTrttMs: " + r9 + ", effectiveRxThroughputKbps: " + r10);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r7 = this.f40528c;     // Catch: Throwable -> L16
        if (r7 != null) goto L10;
        return;
    L10:
        r7.onNetworkQualityRttAndThroughputNotifiedOnIOThread(r8, r9, r10);     // Catch: Throwable -> L16
        return;
    L11:
        Object r11 = this.f40527b;     // Catch: Throwable -> L16
        if (r11 != null) goto L14;
        return;
    L14:
        com.bytedance.frameworks.baselib.network.h.a.a(r11).call("onNetworkQualityRttAndThroughputNotifiedOnIOThread", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9), Integer.valueOf(r10)}).a();     // Catch: Throwable -> L16
    }

    public String d() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getUserId();
    L11:
        return d("getUserId");
    }

    public String e() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getAppId();
    L11:
        return d("getAppId");
    }

    public String f() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getOSApi();
    L11:
        return d("getOSApi");
    }

    public String g() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getDeviceId();
    L11:
        return d("getDeviceId");
    }

    public String h() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getNetAccessType();
    L11:
        return d("getNetAccessType");
    }

    public String i() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getVersionCode();
    L11:
        return d("getVersionCode");
    }

    public String j() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getDeviceType();
    L11:
        return d("getDeviceType");
    }

    public String k() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getAppName();
    L11:
        return d("getAppName");
    }

    public String l() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getSdkAppId();
    L11:
        return d("getSdkAppId");
    }

    public String m() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getSdkVersion();
    L11:
        return d("getSdkVersion");
    }

    public String n() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getChannel();
    L11:
        return d("getChannel");
    }

    public String o() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getOSVersion();
    L11:
        return d("getOSVersion");
    }

    public String p() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getAbi();
    L11:
        return d("getAbi");
    }

    public String q() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getDevicePlatform();
    L11:
        return d("getDevicePlatform");
    }

    public String r() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getDeviceBrand();
    L11:
        return d("getDeviceBrand");
    }

    public String s() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getDeviceModel();
    L11:
        return d("getDeviceModel");
    }

    public String t() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getVersionName();
    L11:
        return d("getVersionName");
    }

    public String u() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getUpdateVersionCode();
    L11:
        return d("getUpdateVersionCode");
    }

    public String v() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getManifestVersionCode();
    L11:
        return d("getManifestVersionCode");
    }

    public String w() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getStoreIdc();
    L11:
        return d("getStoreIdc");
    }

    public String x() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getRegion();
    L11:
        return d("getRegion");
    }

    public String y() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getSysRegion();
    L11:
        return d("getSysRegion");
    }

    public String z() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getCarrierRegion();
    L11:
        return d("getCarrierRegion");
    }

    public String A() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getAppInitialRegionInfo();
    L11:
        return d("getAppInitialRegionInfo");
    }

    public String B() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getTNCRequestFlags();
    L11:
        return d("getTNCRequestFlags");
    }

    public String C() {
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L11;
        ICronetAppProvider r1 = this.f40528c;
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getHttpDnsRequestFlags();
    L11:
        return d("getHttpDnsRequestFlags");
    }

    private String d(String r3) {
        Object r2 = this.f40527b;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        return "";
    L6:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r2).call(r3).a(), String.class, "com.obric.aiagent.plugin");
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public Map<String, String> D() {
    L16:
        th = move-exception;
        th.printStackTrace();
        return Collections.emptyMap();
    L3:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r2 = this.f40528c;     // Catch: Throwable -> L16
        if (r2 != null) goto L9;
        return Collections.emptyMap();
    L9:
        return r2.getGetDomainDependHostMap();
    L10:
        Object r3 = this.f40527b;     // Catch: Throwable -> L16
        if (r3 != null) goto L15;
        return Collections.emptyMap();
    L15:
        return (Map) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r3).call("getGetDomainDependHostMap").a(), Map.class, "com.obric.aiagent.plugin");
    }

    public boolean E() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.getOptInit();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getOptInit").a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public long F() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return -1;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r4 = this.f40528c;     // Catch: Throwable -> L15
        if (r4 != null) goto L9;
        return -1;
    L9:
        return r4.getAppStartTime();
    L10:
        Object r5 = this.f40527b;     // Catch: Throwable -> L15
        if (r5 != null) goto L14;
        return -1;
    L14:
        return ((Long) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r5).call("getAppStartTime").a(), Long.class, "com.obric.aiagent.plugin")).longValue();
    }

    public String G() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getGetDomainDefaultJSON();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getGetDomainDefaultJSON").a(), String.class, "com.obric.aiagent.plugin");
    }

    public ArrayList<byte[]> H() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getOpaqueData();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (ArrayList) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getOpaqueData").a(), ArrayList.class, "com.obric.aiagent.plugin");
    }

    public Map<String[], Pair<byte[], byte[]>> I() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getClientOpaqueData();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (Map) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getClientOpaqueData").a(), Map.class, "com.obric.aiagent.plugin");
    }

    public Map<String, String> J() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getTNCRequestHeader();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (Map) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getTNCRequestHeader").a(), Map.class, "com.obric.aiagent.plugin");
    }

    public Map<String, String> K() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getTNCRequestQuery();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (Map) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getTNCRequestQuery").a(), Map.class, "com.obric.aiagent.plugin");
    }

    public boolean L() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.isEnableQuic();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("isEnableQuic").a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public boolean M() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.isEnableHttp2();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("isEnableHttp2").a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public boolean N() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.isEnableBrotli();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("isEnableBrotli").a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public Map<String, Pair<Integer, Integer>> O() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getQuicHint();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (Map) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getQuicHint").a(), Map.class, "com.obric.aiagent.plugin");
    }

    public boolean P() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.isBOEProxyEnabled();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("isBOEProxyEnabled").a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public String Q() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getBypassBOEJSON();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getBypassBOEJSON").a(), String.class, "com.obric.aiagent.plugin");
    }

    public String R() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getStoreIdcRuleJSON();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getStoreIdcRuleJSON").a(), String.class, "com.obric.aiagent.plugin");
    }

    public String S() {
    L14:
        th = move-exception;
        th.printStackTrace();
        return "";
    L3:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L9;
        ICronetAppProvider r2 = this.f40528c;     // Catch: Throwable -> L14
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.getIsDropFirstTnc();
    L9:
        Object r3 = this.f40527b;     // Catch: Throwable -> L14
        if (r3 != null) goto L13;
        return null;
    L13:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r3).call("getIsDropFirstTnc").a(), String.class, "com.obric.aiagent.plugin");
    }

    public void c(String r6) {
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L8;
        ICronetAppProvider r5 = this.f40528c;     // Catch: Throwable -> L13
        if (r5 != null) goto L7;
        return;
    L7:
        r5.doLoadLibrary(r6);     // Catch: Throwable -> L13
    L16:
        return;
    L8:
        Object r7 = this.f40527b;     // Catch: Throwable -> L13
        if (r7 != null) goto L11;
        return;
    L11:
        com.bytedance.frameworks.baselib.network.h.a.a(r7).call("doLoadLibrary", new Class[]{String.class}, new Object[]{r6});     // Catch: Throwable -> L13
        goto L16
    }

    public boolean T() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.needCustomLoadLibrary();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("needCustomLoadLibrary").a(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    public String U() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getCronetSoPath();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getCronetSoPath").a(), String.class, "com.obric.aiagent.plugin");
    }

    public int V() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return 0;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.getWifiFrequency();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return 0;
    L14:
        return ((Integer) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getWifiFrequency").a(), Integer.class, "com.obric.aiagent.plugin")).intValue();
    }

    public int W() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return 0;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.getWifiRssi();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return 0;
    L14:
        return ((Integer) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getWifiRssi").a(), Integer.class, "com.obric.aiagent.plugin")).intValue();
    }

    public String X() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return "";
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3.getNetworkOperator();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return "";
    L14:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getNetworkOperator").a(), String.class, "com.obric.aiagent.plugin");
    }

    public String Y() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return "";
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3.getSimOperator();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return "";
    L14:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getSimOperator").a(), String.class, "com.obric.aiagent.plugin");
    }

    public List<String> Z() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L10;
        ICronetAppProvider r3 = this.f40528c;     // Catch: Throwable -> L15
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getAbSdkVersion();
    L10:
        Object r4 = this.f40527b;     // Catch: Throwable -> L15
        if (r4 != null) goto L14;
        return null;
    L14:
        return (List) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.h.a.a(r4).call("getAbSdkVersion").a(), List.class, "com.obric.aiagent.plugin");
    }

    public void a(boolean r8, boolean r9, int r10) {
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (com.bytedance.frameworks.baselib.network.http.g.d() == false) goto L8;
        ICronetAppProvider r7 = this.f40528c;     // Catch: Throwable -> L13
        if (r7 != null) goto L7;
        return;
    L7:
        r7.onTncRequestSucceeded(r8, r9, r10);     // Catch: Throwable -> L13
    L16:
        return;
    L8:
        Object r11 = this.f40527b;     // Catch: Throwable -> L13
        if (r11 != null) goto L11;
        return;
    L11:
        com.bytedance.frameworks.baselib.network.h.a.a(r11).call("onTncRequestSucceeded", new Class[]{Boolean.TYPE, Boolean.TYPE, Integer.TYPE}, new Object[]{Boolean.valueOf(r8), Boolean.valueOf(r9), Integer.valueOf(r10)}).a();     // Catch: Throwable -> L13
        goto L16
    }
}
