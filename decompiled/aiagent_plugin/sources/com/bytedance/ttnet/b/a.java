package com.bytedance.ttnet.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.i;
import com.bytedance.common.utility.j;
import com.bytedance.common.utility.k;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.frameworks.baselib.network.http.g;
import com.bytedance.frameworks.baselib.network.http.i.h;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AbsCronetDependAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements ICronetAppProvider, ICronetDepend {
    private static final String TAG = "AbsCronetDependAdapter";

    public void a(int r1) {
    }

    public void a(int r1, double r2, double r4, double r6, double r8) {
    }

    public void a(int r1, int r2) {
    }

    public void a(int r1, int r2, int r3) {
    }

    public void a(String r1) {
    }

    public void a(String r1, int r2) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void doLoadLibrary(String r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbClient() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbFeature() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbFlag() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public List<String> getAbSdkVersion() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbVersion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppId() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppInitialRegionInfo() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public long getAppStartTime() {
        return -1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getBypassBOEJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCarrierRegion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getChannel() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCityName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDevicePlatform() {
        return "android";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getGetDomainDefaultJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getHttpDnsRequestFlags() {
        return "0";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getIId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getIsDropFirstTnc() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getLanguage() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getLazyInitCronetIPC() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getManifestVersionCode() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public ArrayList<byte[]> getOpaqueData() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOpenUdid() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getOptInit() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getOptNqeDefault() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getOptNqePersist() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, Pair<Integer, Integer>> getQuicHint() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRegion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSdkAppId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSdkVersion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public String getSsCookieKey() {
        return "X-SS-Cookie";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSsmix() {
        return "a";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdc() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdcRuleJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSysRegion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getTNCRequestFlags() {
        return "0";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getTNCRequestHeader() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUUID() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUpdateVersionCode() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUserId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionCode() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isBOEProxyEnabled() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableBrotli() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableHttp2() {
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableQuic() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean needCustomLoadLibrary() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onEffectiveConnectionTypeChanged(int r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityLevelChanged(int r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityRttAndThroughputNotified(int r1, int r2, int r3) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onPacketLossComputed(int r1, double r2, double r4, double r6, double r8) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onRTTOrThroughputEstimatesComputed(int r1, int r2, int r3) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void sendAppMonitorEvent(String r1, String r2) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void setAdapter(ICronetDepend r2) {
        ICronetDepend r1 = (ICronetDepend) ZeusTransformUtils.wrapperContextForParams(r2, ICronetDepend.class, "com.obric.aiagent.plugin");
    }

    public a() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        return Logger.debug();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void loggerD(String r1, String r2) {
        Logger.d(r1, r2);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigEtagChanged(final String r2) {
        new AnonymousClass1(this, r2).a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigABTestChanged(final String r2) {
        new AnonymousClass12(this, r2).a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigUpdated(final String r4) {
    L7:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "config = " + r4);     // Catch: Throwable -> L7
    L5:
        new AnonymousClass16(this, r4).a();     // Catch: Throwable -> L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTDnsResolveResult(final String r11, final String r12, final int r13, final int r14, final int r15, List<String> r16, final String r17) {
        final List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onTTDnsResolveResult uuid = " + r11 + " host = " + r12);
    L6:
        new AnonymousClass17(this, r11, r12, r13, r14, r15, r8, r17).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTNetDetectInfoChanged(final String r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onTTNetDetectInfoChanged result = " + r3);
    L5:
        new AnonymousClass18(this, r3).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onMappingRequestStatus(final String r3, final int r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onMappingRequestStatus key = " + r3 + " status: " + r4);
    L5:
        new AnonymousClass19(this, r3, r4).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onEffectiveConnectionTypeChangedOnIOThread(final int r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onEffectiveConnectionTypeChangedOnIOThread type = " + r3);
    L5:
        new AnonymousClass20(this, r3).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onRTTOrThroughputEstimatesComputedOnIOThread(final int r3, final int r4, final int r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onRTTOrThroughputEstimatesComputedOnIOThread httpRtt = " + r3 + ", transportRttMs = " + r4 + ",downstreamThroughputKbps = " + r5);
    L5:
        new AnonymousClass21(this, r3, r4, r5).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onPacketLossComputedOnIOThread(final int r13, final double r14, final double r16, final double r18, final double r20) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onPacketLossComputed protocol = " + r13 + ", upstreamLossRate = " + r14 + ", upstreamLossRateVariance = " + r16 + ", downstreamLossRate = " + r18 + ", downstreamLossRateVariance = " + r20);
    L6:
        new AnonymousClass22(this, r13, r14, r16, r18, r20).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onWiFiToCellStateChanged(final int r3, final int r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onWiFiToCellStateChanged prev state = " + r3 + ", curr state = " + r4);
    L5:
        new AnonymousClass2(this, r3, r4).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onMultiNetworkStateChanged(final int r3, final int r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onMultiNetStateChanged prev state = " + r3 + ", curr state = " + r4);
    L5:
        new AnonymousClass3(this, r3, r4).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onUserSpecifiedNetworkEnabled(final boolean r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onUserSpecifiedNetworkEnabled enable = " + r3);
    L5:
        new AnonymousClass4(this, r3).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onNetworkQualityLevelChangedOnIOThread(final int r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onNetworkQualityLevelChangedOnIOThread nql: " + r3);
    L5:
        new AnonymousClass5(this, r3).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityRttAndThroughputNotifiedOnIOThread(final int r3, final int r4, final int r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onNetworkQualityRttAndThroughputNotifiedOnIOThread, effectiveHrttMs: " + r3 + ", effectiveTrttMs: " + r4 + ", effectiveRxThroughputKbps: " + r5);
    L5:
        new AnonymousClass6(this, r3, r4, r5).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onColdStartFinish() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onColdStartFinish");
    L5:
        new AnonymousClass7(this).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onClientIPChanged(final String r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onClientIPChanged");
    L5:
        new AnonymousClass8(this, r3).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onPublicIPsChanged(List<String> r3, List<String> r4) {
        final List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onPublicIPsChanged");
    L5:
        new AnonymousClass9(this, r5, r6).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onStoreIdcChanged(final String r11, final String r12, final String r13, final String r14, final String r15, final String r16) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onStoreIdcChanged");
    L5:
        new AnonymousClass10(this, r11, r12, r13, r14, r15, r16).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onDropReasonChanged(final boolean r3, List<Integer> r4) {
        final List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onDropReasonChanged");
    L5:
        new AnonymousClass11(this, r3, r5).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTNCUpdateFailed(final ArrayList<String> r3, final String r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onTNCUpdateFailed");
    L5:
        new AnonymousClass13(this, r3, r4).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onCronetBootSucceed() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "onCronetBootSucceed... ");
    L5:
        new AnonymousClass14(this).a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRticket() {
        return String.valueOf(System.currentTimeMillis());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getNetAccessType() {
        return i.f((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceType() {
        return Build.MODEL;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceBrand() {
        return Build.BRAND;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceModel() {
        return Build.MODEL;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbi() {
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return Build.CPU_ABI;
    L6:
        return Build.SUPPORTED_ABIS[0];
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSApi() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSVersion() {
        String r2 = Build.VERSION.RELEASE;     // Catch: Exception -> L8
        if (r2 != null) goto L5;
        return r2;
    L5:
        if (r2.length() <= 10) goto L13;
        return r2.substring(0, 10);
    L13:
        return r2;
    L8:
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDPI() {
        int r2 = k.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r2 > 0) goto L5;
        return "";
    L5:
        return String.valueOf(r2);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getResolution() {
        String r2 = k.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (j.a(r2) == true) goto L5;
        return r2;
    L5:
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getGetDomainDependHostMap() {
        LinkedHashMap r6 = new LinkedHashMap();
        String[] r0 = TTNetInit.getTTNetDepend().b();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L13:
        Map<String, String> r2 = TTNetInit.getTTNetDepend().h();
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.get(TTNetInit.DOMAIN_HTTPDNS_KEY), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L16;
    L19:
        r1 = true;
    L20:
        if (r1 == true) goto L24;
        r6.putAll(r2);
        return r6;
    L24:
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L16:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.get(TTNetInit.DOMAIN_BOE_KEY), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L20;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L20;
    L5:
        if (r0.length <= 0) goto L8;
        r6.put("first", r0[0]);
    L8:
        if (r0.length <= 1) goto L11;
        r6.put("second", r0[1]);
    L11:
        if (r0.length <= 2) goto L13;
        r6.put("third", r0[2]);
        goto L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getTNCRequestQuery() {
        d r2 = TTNetInit.getTTNetDepend();
        if (r2 != null) goto L5;
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, com.bytedance.ttnet.a.class) == true) goto L7;
        return null;
    L7:
        return ((com.bytedance.ttnet.a) ZeusTransformUtils.preCheckCast(r2, com.bytedance.ttnet.a.class, "com.obric.aiagent.plugin")).c();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> onCallToAddSecurityFactor(String r6, Map<String, String> r7) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        HashMap r8 = new HashMap();
        Iterator r9 = r5.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        ArrayList r2 = new ArrayList();
        r2.add((String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.aiagent.plugin"));
        r8.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), r2);
        goto L4
    L7:
        return g.a(r6, r8);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCronetSoPath() {
        return com.bytedance.ttnet.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).n();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final int getProcessFlag() {
        return h.a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public int getWifiFrequency() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return 0;
    L7:
        return TTNetInit.getSystemApiSandbox().a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public int getWifiRssi() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return 0;
    L7:
        return TTNetInit.getSystemApiSandbox().b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getNetworkOperator() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return "";
    L7:
        return TTNetInit.getSystemApiSandbox().c();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSimOperator() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return "";
    L7:
        return TTNetInit.getSystemApiSandbox().d();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public com.bytedance.frameworks.baselib.network.http.cronet.c getAppInfoSubset() {
        com.bytedance.frameworks.baselib.network.http.cronet.c r0 = new com.bytedance.frameworks.baselib.network.http.cronet.c();
        List<String> r1 = getAbSdkVersion();
        String r5 = "";
        if (r1 == null) goto L13;
        Iterator<String> r2 = r1.iterator();
        int r6 = 0;
    L6:
        if (r2.hasNext() == false) goto L13;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        r6 = r6 + 1;
        if (r6 > 5) goto L13;
        if (TextUtils.isEmpty(r7) == true) goto L6;
        r5 = r5 + r7 + ",";
    L13:
        r0.f8250a = r5;
        String[] r3 = TTNetInit.getTTNetDepend().b();
        if (r3 != null) goto L16;
    L24:
        Map<String, String> r4 = TTNetInit.getTTNetDepend().h();
        String r8 = (String) ZeusTransformUtils.preCheckCast(r4.get(TTNetInit.DOMAIN_HTTPDNS_KEY), String.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L27;
    L29:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4.get(TTNetInit.DOMAIN_BOE_KEY), String.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L32;
    L34:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY), String.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L37;
    L39:
        r0.h = getAppInitialRegionInfo();
        return r0;
    L37:
        if (TextUtils.isEmpty(r10) == true) goto L39;
        r0.g = r10;
        goto L39
    L32:
        if (TextUtils.isEmpty(r9) == true) goto L34;
        r0.f = r9;
        goto L34
    L27:
        if (TextUtils.isEmpty(r8) == true) goto L29;
        r0.f8254e = r8;
        goto L29
    L16:
        if (r3.length <= 0) goto L19;
        r0.f8251b = r3[0];
    L19:
        if (r3.length <= 1) goto L22;
        r0.f8252c = r3[1];
    L22:
        if (r3.length <= 2) goto L24;
        r0.f8253d = r3[2];
        goto L24
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onTncRequestSucceeded(final boolean r4, final boolean r5, final int r6) {
    L7:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "stackOptEnabled = " + r4);     // Catch: Throwable -> L7
    L5:
        new AnonymousClass15(this, r4, r5, r6).a();     // Catch: Throwable -> L7
    }
}
