package com.bytedance.ttnet.cronet;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetAppInfoSubset;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.ttnet.AbsOptionalTTNetDepend;
import com.bytedance.ttnet.TTMultiNetwork;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.AppConfig;
import com.obric.contactsdk.loader.ContractKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsCronetDependAdapter implements ICronetDepend, ICronetAppProvider {
    private static final int MAX_ABSDK_VERSION_LENGTH = 5;

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
        return ContractKt.IM_CUSTOM;
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
        return ContractKt.IM_CUSTOM;
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
        return ContractKt.IM_CUSTOM;
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
        return ContractKt.IM_CUSTOM;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUserId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionCode() {
        return ContractKt.IM_CUSTOM;
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

    public void onCronetMappingRequestStatus(String r1, int r2) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onEffectiveConnectionTypeChanged(int r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onMultiNetworkStateChanged(int r1, int r2) {
    }

    public void onNQEEffectiveConnectionTypeChanged(int r1) {
    }

    public void onNQEPacketLossComputed(int r1, double r2, double r4, double r6, double r8) {
    }

    public void onNQERTTOrThroughputComputed(int r1, int r2, int r3) {
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

    public void onTTNetDetectResult(String r1) {
    }

    public void onTTNetworkStateChanged(int r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void sendAppMonitorEvent(String r1, String r2) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void setAdapter(ICronetDepend r1) {
    }

    public final void tryStartTTNetDetect(List<String> r1, int r2, int r3) {
    }

    protected AbsCronetDependAdapter() {
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
    public void onServerConfigEtagChanged(final String r3) {
        final String r1 = "NetWork-Event";
        new AnonymousClass1(this, r1, r3).start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigABTestChanged(final String r3) {
        final String r1 = "NetWork-Event";
        new AnonymousClass2(this, r1, r3).start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigUpdated(final String r4) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "config = " + r4);     // Catch: Throwable -> L8
    L6:
        final String r1 = "NetWork-Event";
        new AnonymousClass3(this, r1, r4).start();     // Catch: Throwable -> L8
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTDnsResolveResult(final String r13, final String r14, final int r15, final int r16, final int r17, final List<String> r18, final String r19) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "onTTDnsResolveResult uuid = " + r13 + " host = " + r14);
    L6:
        final String r4 = "NetWork-Event";
        new AnonymousClass4(this, r4, r13, r14, r15, r16, r17, r18, r19).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTNetDetectInfoChanged(final String r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onTTNetDetectInfoChanged result = " + r3);
    L5:
        final String r1 = "NetWork-Event";
        new AnonymousClass5(this, r1, r3).start();
    }

    public final void onMappingRequestStatus(final String r3, final int r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onMappingRequestStatus key = " + r3 + " status: " + r4);
    L5:
        final String r1 = "NetWork-Event";
        new AnonymousClass6(this, r1, r3, r4).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onEffectiveConnectionTypeChangedOnIOThread(final int r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onEffectiveConnectionTypeChangedOnIOThread type = " + r3);
    L5:
        final String r1 = "NetWork-Event";
        new AnonymousClass7(this, r1, r3).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onRTTOrThroughputEstimatesComputedOnIOThread(final int r9, final int r10, final int r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onRTTOrThroughputEstimatesComputedOnIOThread httpRtt = " + r9 + ", transportRttMs = " + r10 + ",downstreamThroughputKbps = " + r11);
    L5:
        final String r4 = "NetWork-Event";
        new AnonymousClass8(this, r4, r9, r10, r11).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onPacketLossComputedOnIOThread(final int r15, final double r16, final double r18, final double r20, final double r22) {
        if (Logger.debug() == false) goto L6;
        Logger.d("onPacketLossComputedOnIOThread", "onPacketLossComputed protocol = " + r15 + ", upstreamLossRate = " + r16 + ", upstreamLossRateVariance = " + r18 + ", downstreamLossRate = " + r20 + ", downstreamLossRateVariance = " + r22);
    L6:
        final String r4 = "NetWork-Event";
        new AnonymousClass9(this, r4, r15, r16, r18, r20, r22).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onWiFiToCellStateChangedOnIOThread(final int r3, final int r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onWiFiToCellStateChangedOnIOThread prev state = " + r3 + ", curr state = " + r4);
    L5:
        final String r1 = "NetWork-Event";
        new AnonymousClass10(this, r1, r3, r4).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onMultiNetStateChanged(int r7, int r8) {
        if (Logger.debug() == false) goto L10;
        Logger.d("CronetDependAdapter", "onMultiNetStateChanged prev state = " + r7 + ", curr state = " + r8);
    L10:
        Reflect.on(TTMultiNetwork.class).call("notifyMultiNetState", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onUserSpecifiedNetworkEnabled(boolean r6) {
        if (Logger.debug() == false) goto L10;
        Logger.d("CronetDependAdapter", "onUserSpecifiedNetworkEnabled enable = " + r6);
    L10:
        Reflect.on(TTMultiNetwork.class).call("notifyUserSpecifiedNetworkEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(r6)});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onNetworkQualityLevelChangedOnIOThread(final int r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onNetworkQualityLevelChangedOnIOThread nql: " + r3);
    L5:
        final String r1 = "NetWork-Event";
        new AnonymousClass11(this, r1, r3).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityRttAndThroughputNotifiedOnIOThread(final int r9, final int r10, final int r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onNetworkQualityRttAndThroughputNotifiedOnIOThread, effectiveHrttMs: " + r9 + ", effectiveTrttMs: " + r10 + ", effectiveRxThroughputKbps: " + r11);
    L5:
        final String r4 = "NetWork-Event";
        new AnonymousClass12(this, r4, r9, r10, r11).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onColdStartFinish() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onColdStartFinish");
    L5:
        final String r1 = "NetWork-Event";
        new AnonymousClass13(this, r1).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onClientIPChanged(final String r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onClientIPChanged");
    L5:
        final String r1 = "NetWork-Event";
        new AnonymousClass14(this, r1, r3).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onPublicIPsChanged(final List<String> r3, final List<String> r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onPublicIPsChanged");
    L5:
        final String r1 = "NetWork-Event";
        new AnonymousClass15(this, r1, r3, r4).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onStoreIdcChanged(final String r12, final String r13, final String r14, final String r15, final String r16, final String r17) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onStoreIdcChanged");
    L5:
        final String r4 = "NetWork-Event";
        new AnonymousClass16(this, r4, r12, r13, r14, r15, r16, r17).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onDropReasonChanged(final boolean r3, final List<Integer> r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onDropReasonChanged");
    L5:
        final String r1 = "NetWork-Event";
        new AnonymousClass17(this, r1, r3, r4).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTNCUpdateFailed(final ArrayList<String> r3, final String r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onTNCUpdateFailed");
    L5:
        final String r1 = "NetWork-Event";
        new AnonymousClass18(this, r1, r3, r4).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void handleApiResult(boolean r14, String r15, String r16, String r17, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, boolean r38, long r39, long r41, String r43, String r44, String r45, Exception r46) {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "handleApiResult, succ: " + r14 + " url: " + r15 + "tracecode: " + r16 + " remoteIp: " + r17 + " appStart: " + r18);
    L5:
        BaseHttpRequestInfo r11 = BaseHttpRequestInfo.createHttpRequestInfo();
        r11.traceCode = r16;
        r11.remoteIp = r17;
        r11.appLevelRequestStart = r18;
        r11.beforeAllInterceptors = r18;
        r11.requestStart = r20;
        r11.responseBack = r22;
        r11.completeReadResponse = r24;
        r11.requestEnd = r26;
        r11.dnsTime = r28;
        r11.connectTime = r30;
        r11.sslTime = r32;
        r11.sendTime = r34;
        r11.receiveTime = r36;
        r11.isSocketReused = r38;
        r11.ttfbMs = r39;
        r11.totalTime = r26 - r20;
        r11.receivedByteCount = r41;
        r11.requestLog = r43;
        r11.requestHeaders = r44;
        r11.responseHeaders = r45;
        r11.httpClientType = 0;
        if (r14 == false) goto L8;
        NetworkParams.handleApiOk(r15, r11);
        NetworkParams.monitorApiOk(r15, r11);
        return;
    L8:
        NetworkParams.handleApiError(r15, r46, r11);
        NetworkParams.monitorApiError(r15, r11, r46);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean handleApiSample(String r2, String r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "handleApiSample, url: " + r2 + "method: " + r3);
    L6:
        return NetworkParams.handleApiSample(r2, r3);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onCronetBootSucceed() {
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetDependAdapter", "onCronetBootSucceed... ");
    L5:
        final String r1 = "NetWork-Event";
        new AnonymousClass19(this, r1).start();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRticket() {
        return String.valueOf(System.currentTimeMillis());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getNetAccessType() {
        return NetworkUtils.getNetworkAccessType(TTNetInit.getTTNetDepend().getContext());
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
        int r0 = UIUtils.getDpi(TTNetInit.getTTNetDepend().getContext());
        if (r0 > 0) goto L5;
        return "";
    L5:
        return String.valueOf(r0);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getResolution() {
        String r1 = UIUtils.getScreenResolution(TTNetInit.getTTNetDepend().getContext());
        if (StringUtils.isEmpty(r1) == true) goto L5;
        return r1;
    L5:
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getGetDomainDependHostMap() {
        LinkedHashMap r5 = new LinkedHashMap();
        String[] r0 = TTNetInit.getTTNetDepend().getConfigServers();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L13:
        Map<String, String> r2 = TTNetInit.getTTNetDepend().getTTNetServiceDomainMap();
        if (TextUtils.isEmpty(r2.get(TTNetInit.DOMAIN_HTTPDNS_KEY)) == false) goto L16;
    L19:
        r1 = true;
    L20:
        if (r1 == true) goto L24;
        r5.putAll(r2);
        return r5;
    L24:
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L16:
        if (TextUtils.isEmpty(r2.get(TTNetInit.DOMAIN_BOE_KEY)) == false) goto L20;
        if (TextUtils.isEmpty(r2.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY)) == false) goto L20;
    L5:
        if (r0.length <= 0) goto L8;
        r5.put("first", r0[0]);
    L8:
        if (r0.length <= 1) goto L11;
        r5.put("second", r0[1]);
    L11:
        if (r0.length <= 2) goto L13;
        r5.put("third", r0[2]);
        goto L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getTNCRequestQuery() {
        Object r1 = TTNetInit.getTTNetDepend();
        if (r1 != null) goto L5;
        return null;
    L5:
        if ((r1 instanceof AbsOptionalTTNetDepend) == true) goto L7;
        return null;
    L7:
        return ((AbsOptionalTTNetDepend) r1).getTNCExtraParam();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> onCallToAddSecurityFactor(String r4, Map<String, String> r5) {
        HashMap r3 = new HashMap();
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        Map.Entry<String, String> r0 = r6.next();
        ArrayList r1 = new ArrayList();
        r1.add(r0.getValue());
        r3.put(r0.getKey(), r1);
        goto L4
    L7:
        return NetworkParams.tryAddSecurityFactor(r4, r3);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCronetSoPath() {
        return AppConfig.getInstance(TTNetInit.getTTNetDepend().getContext()).getCronetSoPath();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final int getProcessFlag() {
        return ProcessUtils.getProcessFlag();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public int getWifiFrequency() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return 0;
    L7:
        return TTNetInit.getSystemApiSandbox().getWifiFrequency();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public int getWifiRssi() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return 0;
    L7:
        return TTNetInit.getSystemApiSandbox().getWifiRssi();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getNetworkOperator() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return "";
    L7:
        return TTNetInit.getSystemApiSandbox().getNetworkOperator();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSimOperator() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return "";
    L7:
        return TTNetInit.getSystemApiSandbox().getSimOperator();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public TTNetAppInfoSubset getAppInfoSubset() {
        TTNetAppInfoSubset r0 = new TTNetAppInfoSubset();
        List<String> r1 = getAbSdkVersion();
        String r4 = "";
        if (r1 == null) goto L13;
        Iterator<String> r2 = r1.iterator();
        int r5 = 0;
    L6:
        if (r2.hasNext() == false) goto L13;
        String r6 = r2.next();
        r5 = r5 + 1;
        if (r5 > 5) goto L13;
        if (TextUtils.isEmpty(r6) == true) goto L6;
        r4 = r4 + r6 + SimContactsConstants.EMAIL_SEP;
    L13:
        r0.mAbSdkVersion = r4;
        String[] r3 = TTNetInit.getTTNetDepend().getConfigServers();
        if (r3 != null) goto L16;
    L24:
        Map<String, String> r7 = TTNetInit.getTTNetDepend().getTTNetServiceDomainMap();
        String r8 = r7.get(TTNetInit.DOMAIN_HTTPDNS_KEY);
        if (r8 != null) goto L27;
    L29:
        String r9 = r7.get(TTNetInit.DOMAIN_BOE_KEY);
        if (r9 != null) goto L32;
    L34:
        String r10 = r7.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY);
        if (r10 != null) goto L37;
    L39:
        r0.mInitRegion = getAppInitialRegionInfo();
        return r0;
    L37:
        if (TextUtils.isEmpty(r10) == true) goto L39;
        r0.mDomainBoeHttps = r10;
        goto L39
    L32:
        if (TextUtils.isEmpty(r9) == true) goto L34;
        r0.mDomainBoe = r9;
        goto L34
    L27:
        if (TextUtils.isEmpty(r8) == true) goto L29;
        r0.mDomainHttpDns = r8;
        goto L29
    L16:
        if (r3.length <= 0) goto L19;
        r0.mHostFirst = r3[0];
    L19:
        if (r3.length <= 1) goto L22;
        r0.mHostSecond = r3[1];
    L22:
        if (r3.length <= 2) goto L24;
        r0.mHostThird = r3[2];
        goto L24
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onTncRequestSucceeded(final boolean r4, final boolean r5, final int r6) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (Logger.debug() == false) goto L6;
        Logger.d("CronetDependAdapter", "stackOptEnabled = " + r4);     // Catch: Throwable -> L8
    L6:
        new AnonymousClass20(this, r4, r5, r6).start();     // Catch: Throwable -> L8
    }
}
