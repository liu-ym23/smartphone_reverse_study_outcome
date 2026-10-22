package com.bytedance.frameworks.baselib.network.http.cronet;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.cronet.b.g;
import com.bytedance.frameworks.baselib.network.http.cronet.b.h;
import com.bytedance.frameworks.baselib.network.http.cronet.b.k;
import java.net.HttpURLConnection;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface ICronetClient {

    public interface ICronetBootFailureCheckerProvider {
        boolean isCronetBootFailureExpected();
    }

    public interface ICronetThreadStackOptFailureCheckerProvider {
        String getThreadStackInitReason();

        boolean isCronetThreadStackOptFailureExpected();
    }

    void addClientOpaqueData(String[] r1, byte[] r2, byte[] r3, long r4, long r6);

    void bindBigCore(d.c r1);

    void bindLittleCore(d.c r1);

    void clearClientOpaqueData();

    void enableTTBizHttpDns(boolean r1, String r2, String r3, String r4, boolean r5, String r6);

    int getCronetInternalErrorCode(HttpURLConnection r1);

    String getCronetVersion();

    int getEffectiveConnectionType();

    int getEffectiveHttpRttMs();

    int getEffectiveRxThroughputKbps();

    int getEffectiveTransportRttMs();

    Map<String, g> getGroupRttEstimates();

    void getMappingRequestState(String r1);

    g getNetworkQuality();

    int getNetworkQualityLevel();

    h getPacketLossRateMetrics(int r1);

    boolean isCronetHttpURLConnection(HttpURLConnection r1);

    void notifyStoreRegionUpdated(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11);

    void notifyTNCConfigUpdated(String r1, String r2, String r3, String r4, String r5, String r6);

    HttpURLConnection openConnection(Context r1, String r2, boolean r3, String r4, com.bytedance.frameworks.baselib.network.http.b r5, ICronetAppProvider r6);

    void preconnectUrl(String r1, Map<String, String> r2);

    void removeClientOpaqueData(String r1);

    void reportNetDiagnosisUserLog(String r1);

    void resetCoreBind(d.c r1);

    void runInBackGround(boolean r1);

    void setAlogFuncAddr(long r1);

    void setAppStartUpState(int r1);

    void setBestHostWithRouteSelectionName(String r1, String r2);

    void setCookieInitCompleted();

    void setCronetBootFailureCheckerProvider(ICronetBootFailureCheckerProvider r1);

    void setCronetThreadStackOptFailureCheckerProvider(ICronetThreadStackOptFailureCheckerProvider r1);

    void setHostResolverRules(String r1);

    void setHttpDnsForTesting(boolean r1, boolean r2, boolean r3);

    void setProxy(String r1);

    void setSlaSamplingSetting(JSONObject r1);

    void setZstdFuncAddr(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15);

    void startThrottle(String[] r1, int r2, long r3);

    void stopThrottle(String[] r1, int r2);

    void triggerGetDomain(boolean r1);

    void tryCreateCronetEngine(Context r1, boolean r2, boolean r3, boolean r4, boolean r5, String r6, boolean r7, ICronetAppProvider r8);

    void tryStartNetDetect(String[] r1, int r2, int r3);

    void ttDnsResolve(String r1, int r2, String r3, Map<String, String> r4);

    k ttUrlDispatch(String r1, int r2, boolean r3);
}
