package org.chromium;

import android.os.Process;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.impl.TTCronetInitTimingInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class CronetEventListener extends TTEventListener {
    private static volatile CronetEventListener sInstance;
    private boolean enableOptInit;
    private boolean isMainProcess;

    public static CronetEventListener inst() {
        if (sInstance != null) goto L15;
        monitor-enter(CronetEventListener.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CronetEventListener();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetEventListener.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private CronetEventListener() {
        this.isMainProcess = false;
        this.enableOptInit = false;
    }

    public void setIsMainProcess(boolean r1) {
        this.isMainProcess = r1;
    }

    public void enableOptInit(boolean r1) {
        this.enableOptInit = r1;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onServerConfigUpdated(String r1, String r2, String r3) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onServerConfigUpdated(r1, r2, r3);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTTNetDetectInfoChanged(String r1) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onTTNetDetectInfoChanged(r1);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTTDnsResolveResult(String r9, String r10, int r11, int r12, int r13, List<String> r14, String r15) {
        CronetAppProviderManager.inst().onTTDnsResolveResult(r9, r10, r11, r12, r13, r14, r15);
    }

    public void onMappingRequestStatus(String r1, int r2) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onMappingRequestStatus(r1, r2);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onColdStartFinish() {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onColdStartFinish();
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onEffectiveConnectionTypeChanged(int r1) {
        CronetAppProviderManager.inst().onEffectiveConnectionTypeChanged(r1);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onRTTOrThroughputEstimatesComputed(int r1, int r2, int r3) {
        CronetAppProviderManager.inst().onRTTOrThroughputEstimatesComputed(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onPacketLossComputed(int r11, double r12, double r14, double r16, double r18) {
        CronetAppProviderManager.inst().onPacketLossComputed(r11, r12, r14, r16, r18);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onNetworkQualityTypeChangedV3(int r1) {
        CronetAppProviderManager.inst().onNetworkQualityTypeChangedV3(r1);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onClientIPChanged(String r1) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onClientIPChanged(r1);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTLBDecompressFail() {
        TTRequestCompressManager.setGlobalForbidenCompress();
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onPublicIPsChanged(List<String> r1, List<String> r2) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onPublicIPsChanged(r1, r2);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onStoreIdcChanged(String r8, String r9, String r10, String r11, String r12, String r13) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onStoreIdcChanged(r8, r9, r10, r11, r12, r13);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onDropReasonChanged(boolean r1, List<Integer> r2) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onDropReasonChanged(r1, r2);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTNCUpdateFailed(String[] r1, String r2) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onTNCUpdateFailed(r1, r2);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void handleApiResult(boolean r38, String r39, String r40, String r41, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, boolean r62, long r63, long r65, String r67, String r68, String r69, int r70, int r71, String r72) {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().handleApiResult(r38, r39, r40, r41, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r63, r65, r67, r68, r69, r70, r71, r72);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public boolean handleApiSample(String r1, String r2) {
        return CronetAppProviderManager.inst().handleApiSample(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public Map<String, String> onCallToAddSecurityFactor(String r1, Map<String, String> r2) {
        return CronetAppProviderManager.inst().onCallToAddSecurityFactor(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public String onRequestInterceptorToStart(String r1, Map<String, String> r2, List<String> r3) {
        return NativeRequestInterceptor.onCallRequestInterceptorToStart(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public String onResponseInterceptorToStart(String r1, Map<String, List<String>> r2, int r3) {
        return NativeRequestInterceptor.onCallResponseInterceptorToStart(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onContextInitCompleted(long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38) {
        if (this.enableOptInit == false) goto L5;
        TTNetInitMetrics.setCronetInitSuccess(true);
    L5:
        TTNetInitMetrics r1 = TTNetInitMetrics.inst();
        r1.netThreadPriority = Process.getThreadPriority(0);
        r1.initThreadStart = TTCronetInitTimingInfo.sInitThreadStart;
        r1.initThreadEnd = TTCronetInitTimingInfo.sInitThreadEnd;
        r1.loadCronetSoStart = TTCronetInitTimingInfo.sLoadCronetSoStart;
        r1.loadCronetSoEnd = TTCronetInitTimingInfo.sLoadCronetSoEnd;
        r1.cronetInitTimingInfoJsonStr = TTCronetInitTimingInfo.sNativeInitTimingJson;
        r1.abTestStr = TTCronetInitTimingInfo.sABTest;
        r1.cronetInitEnd = System.nanoTime();
        r1.networkThreadStartTime = r8;
        r1.networkThreadEndTime = r10;
        r1.executeWaitingTaskEndTime = r12;
        r1.preconnectStartTime = r14;
        r1.nqeInitDuration = r16;
        r1.prefsInitDuration = r18;
        r1.channelInitDuration = r20;
        r1.contextBuilderDuration = r22;
        r1.tncConfigDuration = r24;
        r1.updateAppinfoDuration = r26;
        r1.netlogInitDuration = r28;
        r1.nqeDetectDuration = r30;
        r1.preconnectDuration = r32;
        r1.sslSessionDuration = r34;
        r1.ttnetConfigDuration = r36;
        r1.installCertDuration = r38;
        final long r3 = CronetAppProviderManager.inst().getAppStartTime();
        if (TTNetInitMetrics.inst().checkTTNetLayerInitComplete() == true) goto L11;
        TTExecutors.getScheduledThreadPool().schedule(new AnonymousClass1(this, r3), 5, TimeUnit.SECONDS);
        if (this.enableOptInit == true) goto L16;
        TTNetInitMetrics.setCronetInitSuccess(true);
        return;
    L16:
        return;
    L11:
        JSONObject r2 = TTNetInitMetrics.inst().constructTTNetInitTimingInfo();
        JSONObject r4 = TTNetInitMetrics.inst().constructTTNetInitTimingInfoV2(r3);
        if (this.enableOptInit == true) goto L14;
        TTNetInitMetrics.setCronetInitSuccess(true);
    L14:
        CronetAppProviderManager.inst().sendAppMonitorEvent(r2.toString(), TTNetInitMetrics.LOG_TYPE);
        CronetAppProviderManager.inst().sendAppMonitorEvent(r4.toString(), TTNetInitMetrics.LOG_TYPE_V2);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onCronetBootSucceed() {
        if (this.isMainProcess == false) goto L6;
        CronetAppProviderManager.inst().onCronetBootSucceed();
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onMultiNetworkStateChanged(int r1, int r2) {
        CronetAppProviderManager.inst().onMultiNetworkStateChanged(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onMultiNetStateChanged(int r1, int r2) {
        CronetAppProviderManager.inst().onMultiNetStateChanged(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onUserSpecifiedNetworkEnabled(boolean r1) {
        CronetAppProviderManager.inst().onUserSpecifiedNetworkEnabled(r1);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onNetworkQualityLevelChanged(int r1) {
        CronetAppProviderManager.inst().onNetworkQualityLevelChanged(r1);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onNetworkQualityRttAndThroughputNotified(int r1, int r2, int r3) {
        CronetAppProviderManager.inst().onNetworkQualityRttAndThroughputNotified(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public void onTncRequestSucceeded(boolean r1, boolean r2, int r3) {
        CronetAppProviderManager.inst().onTncRequestSucceeded(r1, r2, r3);
    }
}
