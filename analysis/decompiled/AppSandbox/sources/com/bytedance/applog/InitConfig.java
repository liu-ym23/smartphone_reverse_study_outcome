package com.bytedance.applog;

import android.accounts.Account;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.applog.encryptor.IEncryptorType;
import com.bytedance.applog.network.INetworkClient;
import com.bytedance.applog.store.kv.KVStoreConfig;
import com.bytedance.bdtracker.d6;
import com.bytedance.bdtracker.f5;
import com.bytedance.bdtracker.n2;
import com.bytedance.bdtracker.r;
import com.bytedance.bdtracker.z;
import com.bytedance.mpaas.IEncryptor;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class InitConfig {
    public String A;

    @Deprecated
    public String B;
    public SSLSocketFactory B0;
    public Map<String, Object> C;

    @Deprecated
    public Account D;
    public boolean E;
    public INetworkClient F;
    public boolean H;
    public String M;
    public String N;
    public ISensitiveInfoProvider O;
    public List<String> U;
    public String Y;
    public boolean Z;
    public final String a;
    public String b;
    public String d;
    public String e;
    public z f;
    public String g;
    public String h;
    public ILogger i;
    public String j;

    @Deprecated
    public String k;
    public IPicker l;

    @Deprecated
    public boolean m;
    public boolean o;
    public String q;

    @Deprecated
    public boolean r;
    public String s;
    public UriConfig t;
    public String u;

    @Deprecated
    public String v;
    public int w;
    public int x;
    public int y;

    @Deprecated
    public String z;
    public boolean c = true;

    @Deprecated
    public boolean n = false;
    public int p = 0;
    public boolean G = true;
    public boolean I = false;
    public boolean J = true;
    public boolean K = true;
    public boolean L = true;
    public boolean P = true;
    public boolean Q = true;
    public boolean R = false;
    public boolean S = false;
    public boolean T = false;
    public boolean V = false;
    public boolean W = false;
    public boolean X = true;
    public IpcDataChecker a0 = null;

    @Deprecated
    public String b0 = null;

    @Deprecated
    public String c0 = null;
    public boolean d0 = true;
    public boolean e0 = false;
    public boolean f0 = false;
    public boolean g0 = true;
    public boolean h0 = true;
    public boolean i0 = true;
    public boolean j0 = false;
    public boolean k0 = false;
    public boolean l0 = false;
    public boolean m0 = false;
    public boolean n0 = false;
    public boolean o0 = true;
    public int p0 = 6;
    public boolean q0 = true;
    public boolean r0 = false;
    public int s0 = 2000;
    public int t0 = 0;
    public Map<String, String> u0 = null;
    public DynamicValueCallback<Map<String, String>> v0 = null;
    public boolean w0 = true;
    public boolean x0 = true;

    @Deprecated
    public boolean y0 = true;
    public boolean z0 = true;
    public final Set<String> A0 = new HashSet(4);
    public KVStoreConfig C0 = KVStoreConfig.DEFAULT_CONFIG;
    public DynamicValueCallback<String> D0 = null;
    public boolean E0 = true;
    public boolean F0 = true;
    public boolean G0 = true;
    public boolean H0 = true;
    public boolean I0 = true;

    public interface IpcDataChecker {
        boolean checkIpcData(String[] strArr);
    }

    public InitConfig(String str, String str2) {
        this.a = str;
        this.d = str2;
    }

    public void addLoaderFilter(String str) {
        this.A0.add(str);
    }

    public boolean autoStart() {
        return this.c;
    }

    public InitConfig clearABCacheOnUserChange(boolean z) {
        this.X = z;
        return this;
    }

    public void clearDidAndIid(String str) {
        this.E = true;
        this.e = str;
    }

    public InitConfig disableDeferredALink() {
        this.W = false;
        return this;
    }

    public InitConfig enableDeferredALink() {
        this.W = true;
        return this;
    }

    public Account getAccount() {
        return this.D;
    }

    public String getAid() {
        String str;
        String strTrim = this.a.trim();
        if (!strTrim.startsWith("rangers://")) {
            return strTrim;
        }
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        try {
            URI uri = new URI(strTrim);
            String strReplace = uri.getPath().replace("/", "");
            String host = uri.getHost();
            if (!TextUtils.isEmpty(strReplace) && !TextUtils.isEmpty(host)) {
                try {
                    str = new String(Base64.decode(strReplace.getBytes("UTF-8"), 2));
                } catch (Throwable unused) {
                    str = "";
                }
                if (host.equalsIgnoreCase(f5.a(str))) {
                    this.b = str;
                    return str;
                }
                Log.w("AppLog", "Init failed. App id can't parse! AppId: " + strTrim + ", parserAid: " + str + ", aidMd5: " + host);
            }
            Log.w("AppLog", "Init failed. App id can't parse! RawAppId: " + strTrim);
            return "";
        } catch (Throwable unused2) {
            Log.e("AppLog", "Init failed. App id parse error! AppId: " + strTrim);
            return "";
        }
    }

    @Deprecated
    public String getAliyunUdid() {
        return this.k;
    }

    @Deprecated
    public boolean getAnonymous() {
        return this.m;
    }

    public String getAppImei() {
        return this.Y;
    }

    public String getAppName() {
        return this.s;
    }

    public int getAutoTrackEventType() {
        return this.p0;
    }

    public String getChannel() {
        return this.d;
    }

    public String getClearKey() {
        return this.e;
    }

    public Map<String, Object> getCommonHeader() {
        return this.C;
    }

    public DynamicValueCallback<String> getCustomOaidCallback() {
        return this.D0;
    }

    public String getDbName() {
        if (!TextUtils.isEmpty(this.M)) {
            return this.M;
        }
        return r.a((Object) getAid()) + "@bd_tea_agent.db";
    }

    public IEncryptor getEncryptor() {
        return this.f;
    }

    public int getGaidTimeOutMilliSeconds() {
        return this.s0;
    }

    public String getGoogleAid() {
        return this.g;
    }

    public List<String> getH5BridgeAllowlist() {
        return this.U;
    }

    public DynamicValueCallback<Map<String, String>> getHttpHeaderCallback() {
        return this.v0;
    }

    @Deprecated
    public Map<String, String> getHttpHeaders() {
        return this.u0;
    }

    public IpcDataChecker getIpcDataChecker() {
        return this.a0;
    }

    public KVStoreConfig getKvStoreConfig() {
        return this.C0;
    }

    public String getLanguage() {
        return this.h;
    }

    public Set<String> getLoaderFilters() {
        return this.A0;
    }

    @Deprecated
    public boolean getLocalTest() {
        return this.n;
    }

    public ILogger getLogger() {
        return this.i;
    }

    @Deprecated
    public String getManifestVersion() {
        return this.z;
    }

    public int getManifestVersionCode() {
        return this.y;
    }

    public INetworkClient getNetworkClient() {
        return this.F;
    }

    @Deprecated
    public boolean getNotReuqestSender() {
        return this.r;
    }

    public IPicker getPicker() {
        return this.l;
    }

    @Deprecated
    public d6 getPreInstallCallback() {
        return null;
    }

    public int getProcess() {
        return this.p;
    }

    public String getRegion() {
        return this.j;
    }

    public String getReleaseBuild() {
        return this.q;
    }

    public ISensitiveInfoProvider getSensitiveInfoProvider() {
        return this.O;
    }

    public String getSpName() {
        return this.N;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.B0;
    }

    public int getTrackCrashType() {
        return this.t0;
    }

    @Deprecated
    public String getTweakedChannel() {
        return this.v;
    }

    public int getUpdateVersionCode() {
        return this.x;
    }

    public UriConfig getUriConfig() {
        return this.t;
    }

    @Deprecated
    public String getUserUniqueId() {
        return this.b0;
    }

    @Deprecated
    public String getUserUniqueIdType() {
        return this.c0;
    }

    public String getVersion() {
        return this.u;
    }

    public int getVersionCode() {
        return this.w;
    }

    public String getVersionMinor() {
        return this.A;
    }

    @Deprecated
    public String getZiJieCloudPkg() {
        return this.B;
    }

    public boolean isAbEnable() {
        return this.I;
    }

    public boolean isAbTestExposureEventRepeatEnabled() {
        return this.G0;
    }

    public boolean isAndroidIdEnabled() {
        return this.i0;
    }

    public boolean isAutoActive() {
        return this.G;
    }

    public boolean isAutoTrackEnabled() {
        return this.J;
    }

    public boolean isAutoTrackFragmentEnabled() {
        return this.f0;
    }

    public boolean isCPUAbiEnabled() {
        return this.H0;
    }

    public boolean isClearABCacheOnUserChange() {
        return this.X;
    }

    public boolean isClearDidAndIid() {
        return this.E;
    }

    public boolean isCongestionControlEnable() {
        return this.L;
    }

    public boolean isDeferredALinkEnabled() {
        return this.W;
    }

    public boolean isDisplayDensityAndDpiEnabled() {
        return this.I0;
    }

    public boolean isEventFilterEnable() {
        return this.Z;
    }

    public boolean isExposureEnabled() {
        return this.j0;
    }

    public boolean isGaidEnabled() {
        return this.r0;
    }

    public boolean isH5BridgeAllowAll() {
        return this.V;
    }

    public boolean isH5BridgeEnable() {
        return this.R;
    }

    public boolean isH5CollectEnable() {
        return this.S;
    }

    public boolean isHandleLifeCycle() {
        return this.K;
    }

    public boolean isHarmonyEnabled() {
        return this.e0;
    }

    public boolean isIccIdEnabled() {
        return this.w0;
    }

    public boolean isImeiEnable() {
        return this.Q;
    }

    public boolean isLaunchTerminateEnabled() {
        return this.z0;
    }

    public boolean isLogEnable() {
        return this.T;
    }

    public boolean isMacEnable() {
        return this.P;
    }

    public boolean isMetaSecEnabled() {
        return this.g0;
    }

    public boolean isMigrateEnabled() {
        return this.q0;
    }

    public boolean isMonitorEnabled() {
        return this.l0;
    }

    public boolean isOaidEnabled() {
        return this.h0;
    }

    public boolean isOperatorInfoEnabled() {
        return this.o0;
    }

    @Deprecated
    public boolean isPageMetaAnnotationEnable() {
        return this.y0;
    }

    public boolean isPlayEnable() {
        return this.o;
    }

    public boolean isReportOaidEnable() {
        return this.n0;
    }

    public boolean isResponseEncryptEnabled() {
        return this.F0;
    }

    public boolean isScreenOrientationEnabled() {
        return this.m0;
    }

    public boolean isScrollObserveEnabled() {
        return this.k0;
    }

    public boolean isSerialNumberEnable() {
        return this.x0;
    }

    public boolean isSilenceInBackground() {
        return this.H;
    }

    public boolean isTrackEventEnabled() {
        return this.d0;
    }

    public boolean isUseBridgeUpdateUUIDEnabled() {
        return this.E0;
    }

    @Deprecated
    public InitConfig putCommonHeader(Map<String, Object> map) {
        this.C = map;
        return this;
    }

    public void setAbEnable(boolean z) {
        this.I = z;
    }

    public void setAbTestExposureEventRepeatEnabled(boolean z) {
        this.G0 = z;
    }

    @Deprecated
    public InitConfig setAccount(Account account) {
        this.D = account;
        return this;
    }

    @Deprecated
    public InitConfig setAliyunUdid(String str) {
        this.k = str;
        return this;
    }

    public void setAndroidIdEnabled(boolean z) {
        this.i0 = z;
    }

    @Deprecated
    public InitConfig setAnonymous(boolean z) {
        this.m = z;
        return this;
    }

    public void setAppImei(String str) {
        this.Y = str;
    }

    public InitConfig setAppName(String str) {
        this.s = str;
        return this;
    }

    public void setAutoActive(boolean z) {
        this.G = z;
    }

    public InitConfig setAutoStart(boolean z) {
        this.c = z;
        return this;
    }

    public void setAutoTrackEnabled(boolean z) {
        this.J = z;
    }

    public void setAutoTrackEventType(int i) {
        this.p0 = i;
    }

    public void setAutoTrackFragmentEnabled(boolean z) {
        this.f0 = z;
    }

    public void setCPUAbiEnabled(boolean z) {
        this.H0 = z;
    }

    public void setChannel(String str) {
        this.d = str;
    }

    public void setCongestionControlEnable(boolean z) {
        this.L = z;
    }

    public void setCustomOaidCallback(DynamicValueCallback<String> dynamicValueCallback) {
        this.D0 = dynamicValueCallback;
    }

    public InitConfig setDbName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.M = str;
        }
        return this;
    }

    public void setDisplayDensityAndDpiEnabled(boolean z) {
        this.I0 = z;
    }

    public InitConfig setEnablePlay(boolean z) {
        this.o = z;
        return this;
    }

    public InitConfig setEncryptor(IEncryptor iEncryptor) {
        this.f = new z(iEncryptor, IEncryptorType.DEFAULT_ENCRYPTOR);
        return this;
    }

    public InitConfig setEncryptor(IEncryptor iEncryptor, String str) {
        this.f = new z(iEncryptor, str);
        return this;
    }

    public void setEventFilterEnable(boolean z) {
        this.Z = z;
    }

    public void setExposureEnabled(boolean z) {
        this.j0 = z;
    }

    public void setGaidEnabled(boolean z) {
        this.r0 = z;
    }

    public void setGaidTimeOutMilliSeconds(int i) {
        this.s0 = i;
    }

    public InitConfig setGoogleAid(String str) {
        this.g = str;
        return this;
    }

    public InitConfig setH5BridgeAllowAll(boolean z) {
        this.V = z;
        return this;
    }

    public InitConfig setH5BridgeAllowlist(List<String> list) {
        this.U = list;
        return this;
    }

    public InitConfig setH5BridgeEnable(boolean z) {
        this.R = z;
        return this;
    }

    public InitConfig setH5CollectEnable(boolean z) {
        this.S = z;
        return this;
    }

    public void setHandleLifeCycle(boolean z) {
        this.K = z;
    }

    public void setHarmonyEnable(boolean z) {
        this.e0 = z;
    }

    @Deprecated
    public void setHttpHeaders(Map<String, String> map) {
        this.u0 = map;
    }

    public void setHttpHeadersCallback(DynamicValueCallback<Map<String, String>> dynamicValueCallback) {
        this.v0 = dynamicValueCallback;
    }

    public void setIccIdEnabled(boolean z) {
        this.w0 = z;
    }

    public InitConfig setImeiEnable(boolean z) {
        this.Q = z;
        return this;
    }

    public InitConfig setIpcDataChecker(IpcDataChecker ipcDataChecker) {
        this.a0 = ipcDataChecker;
        return this;
    }

    public void setKvStoreConfig(KVStoreConfig kVStoreConfig) {
        this.C0 = kVStoreConfig;
    }

    public InitConfig setLanguage(String str) {
        this.h = str;
        return this;
    }

    public void setLaunchTerminateEnabled(boolean z) {
        this.z0 = z;
    }

    @Deprecated
    public InitConfig setLocalTest(boolean z) {
        this.n = z;
        return this;
    }

    public InitConfig setLogEnable(boolean z) {
        this.T = z;
        return this;
    }

    public InitConfig setLogger(ILogger iLogger) {
        this.i = iLogger;
        return this;
    }

    public void setMacEnable(boolean z) {
        this.P = z;
    }

    public InitConfig setMainProcess() {
        this.p = 1;
        return this;
    }

    @Deprecated
    public InitConfig setManifestVersion(String str) {
        this.z = str;
        return this;
    }

    public InitConfig setManifestVersionCode(int i) {
        this.y = i;
        return this;
    }

    public void setMetaSecEnabled(boolean z) {
        this.g0 = z;
    }

    public void setMigrateEnabled(boolean z) {
        this.q0 = z;
    }

    public void setMonitorEnabled(boolean z) {
        n2.b(this);
        this.l0 = z;
    }

    public InitConfig setNetworkClient(INetworkClient iNetworkClient) {
        this.F = iNetworkClient;
        return this;
    }

    @Deprecated
    public InitConfig setNotRequestSender(boolean z) {
        this.r = z;
        return this;
    }

    public void setOaidEnabled(boolean z) {
        this.h0 = z;
    }

    public void setOperatorInfoEnabled(boolean z) {
        this.o0 = z;
    }

    @Deprecated
    public void setPageMetaAnnotationEnable(boolean z) {
        this.y0 = z;
    }

    public InitConfig setPicker(IPicker iPicker) {
        this.l = iPicker;
        return this;
    }

    @Deprecated
    public InitConfig setPreInstallChannelCallback(d6 d6Var) {
        return this;
    }

    public InitConfig setProcess(int i) {
        this.p = i;
        return this;
    }

    public InitConfig setRegion(String str) {
        this.j = str;
        return this;
    }

    public InitConfig setReleaseBuild(String str) {
        this.q = str;
        return this;
    }

    public void setReportOaidEnable(boolean z) {
        this.n0 = z;
    }

    public void setResponseEncryptEnabled(boolean z) {
        this.F0 = z;
    }

    public void setScreenOrientationEnabled(boolean z) {
        this.m0 = z;
    }

    public void setScrollObserveEnabled(boolean z) {
        this.k0 = z;
    }

    public void setSensitiveInfoProvider(ISensitiveInfoProvider iSensitiveInfoProvider) {
        this.O = iSensitiveInfoProvider;
    }

    public void setSerialNumberEnable(boolean z) {
        this.x0 = z;
    }

    public void setSilenceInBackground(boolean z) {
        this.H = z;
    }

    public InitConfig setSpName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.N = str;
        }
        return this;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.B0 = sSLSocketFactory;
    }

    public void setTrackCrashType(int i) {
        this.t0 = i;
    }

    public void setTrackEventEnabled(boolean z) {
        this.d0 = z;
    }

    @Deprecated
    public InitConfig setTweakedChannel(String str) {
        this.v = str;
        return this;
    }

    public InitConfig setUpdateVersionCode(int i) {
        this.x = i;
        return this;
    }

    public InitConfig setUriConfig(int i) {
        this.t = UriConfig.createUriConfig(i);
        return this;
    }

    public InitConfig setUriConfig(UriConfig uriConfig) {
        this.t = uriConfig;
        return this;
    }

    public void setUseBridgeUpdateUUIDEnabled(boolean z) {
        this.E0 = z;
    }

    @Deprecated
    public InitConfig setUserUniqueId(String str) {
        this.b0 = str;
        return this;
    }

    @Deprecated
    public InitConfig setUserUniqueIdType(String str) {
        this.c0 = str;
        return this;
    }

    public InitConfig setVersion(String str) {
        this.u = str;
        return this;
    }

    public InitConfig setVersionCode(int i) {
        this.w = i;
        return this;
    }

    public InitConfig setVersionMinor(String str) {
        this.A = str;
        return this;
    }

    @Deprecated
    public InitConfig setZiJieCloudPkg(String str) {
        this.B = str;
        return this;
    }
}
