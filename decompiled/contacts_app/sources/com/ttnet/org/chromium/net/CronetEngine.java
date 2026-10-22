package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CronetEngine {
    private static final String TAG = "CronetEngine";

    public static class Builder {
        public static final int HTTP_CACHE_DISABLED = 0;
        public static final int HTTP_CACHE_DISK = 3;
        public static final int HTTP_CACHE_DISK_NO_HTTP = 2;
        public static final int HTTP_CACHE_IN_MEMORY = 1;
        private static final String TAG = "CronetEngine.Builder";
        protected final ICronetEngineBuilder mBuilderDelegate;

        public static abstract class LibraryLoader {
            public abstract void loadLibrary(String r1);

            public LibraryLoader() {
            }
        }

        @Deprecated
        public Builder enableSdch(boolean r1) {
            return this;
        }

        public Builder(Context r1, boolean r2) {
            this(createBuilderDelegate(r1, r2));
        }

        public Builder(ICronetEngineBuilder r1) {
            this.mBuilderDelegate = r1;
        }

        public String getDefaultUserAgent() {
            return this.mBuilderDelegate.getDefaultUserAgent();
        }

        public Builder setUserAgent(String r2) {
            this.mBuilderDelegate.setUserAgent(r2);
            return this;
        }

        public Builder setStoragePath(String r2) {
            this.mBuilderDelegate.setStoragePath(r2);
            return this;
        }

        public Builder setLibraryLoader(LibraryLoader r2) {
            this.mBuilderDelegate.setLibraryLoader(r2);
            return this;
        }

        public Builder enableQuic(boolean r2) {
            this.mBuilderDelegate.enableQuic(r2);
            return this;
        }

        public Builder enableHttp2(boolean r2) {
            this.mBuilderDelegate.enableHttp2(r2);
            return this;
        }

        public Builder setCronetSoPath(String r2) {
            this.mBuilderDelegate.setCronetSoPath(r2);
            return this;
        }

        public Builder enableHttpDns(boolean r2) {
            this.mBuilderDelegate.enableHttpDns(r2);
            return this;
        }

        public Builder listenAppStateIndependently(boolean r2) {
            this.mBuilderDelegate.listenAppStateIndependently(r2);
            return this;
        }

        public Builder enableVerboseLog() {
            this.mBuilderDelegate.enableVerboseLog();
            return this;
        }

        public Builder setAppInfoProvider(TTAppInfoProvider r2) {
            this.mBuilderDelegate.setAppInfoProvider(r2);
            return this;
        }

        public Builder setAppMonitorProvider(TTMonitorProvider r2) {
            this.mBuilderDelegate.setAppMonitorProvider(r2);
            return this;
        }

        public Builder setEventListener(TTEventListener r2) {
            this.mBuilderDelegate.setEventListener(r2);
            return this;
        }

        public Builder setAppSecurityLevel(int r2) {
            this.mBuilderDelegate.setAppSecurityLevel(r2);
            return this;
        }

        public Builder setGetDomainDefaultJSON(String r2) {
            this.mBuilderDelegate.setGetDomainDefaultJSON(r2);
            return this;
        }

        public Builder setOpaqueData(ArrayList<byte[]> r2) {
            this.mBuilderDelegate.setOpaqueData(r2);
            return this;
        }

        public Builder setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r2) {
            this.mBuilderDelegate.setClientOpaqueData(r2);
            return this;
        }

        public Builder setBypassBOEJSON(String r2) {
            this.mBuilderDelegate.setBypassBOEJSON(r2);
            return this;
        }

        public Builder setStoreIdcRuleJSON(String r2) {
            this.mBuilderDelegate.setStoreIdcRuleJSON(r2);
            return this;
        }

        public Builder setProxyConfig(String r2) {
            this.mBuilderDelegate.setProxyConfig(r2);
            return this;
        }

        public Builder enableBoeProxy(boolean r2) {
            this.mBuilderDelegate.enableBoeProxy(r2);
            return this;
        }

        public Builder enableTncSecureMode(boolean r2) {
            this.mBuilderDelegate.enableTncSecureMode(r2);
            return this;
        }

        public Builder setALogFuncAddr(long r2) {
            this.mBuilderDelegate.setALogFuncAddr(r2);
            return this;
        }

        public Builder setIsMainProcess(boolean r2) {
            this.mBuilderDelegate.setIsMainProcess(r2);
            return this;
        }

        public Builder setLazyInitIPC(boolean r2) {
            this.mBuilderDelegate.setLazyInitIPC(r2);
            return this;
        }

        public Builder setProcessName(String r2) {
            this.mBuilderDelegate.setProcessName(r2);
            return this;
        }

        public Builder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r2) {
            this.mBuilderDelegate.setTTAppInfoColdStartSubset(r2);
            return this;
        }

        public Builder setOptInit(boolean r2) {
            this.mBuilderDelegate.setOptInit(r2);
            return this;
        }

        public Builder setOptNqeInit(boolean r2, boolean r3) {
            this.mBuilderDelegate.setOptNqeInit(r2, r3);
            return this;
        }

        public Builder setTTNetInitStart(long r2) {
            this.mBuilderDelegate.setTTNetInitStart(r2);
            return this;
        }

        public Builder setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r2) {
            this.mBuilderDelegate.setThreadConfigInfoList(r2);
            return this;
        }

        public Builder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r2) {
            this.mBuilderDelegate.setThreadConfigCallbackImpl(r2);
            return this;
        }

        public Builder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r2) {
            this.mBuilderDelegate.setSlaSamplingSetting(r2);
            return this;
        }

        public Builder setStackInfo(boolean r2, String r3) {
            this.mBuilderDelegate.setStackInfo(r2, r3);
            return this;
        }

        public Builder enableBrotli(boolean r2) {
            this.mBuilderDelegate.enableBrotli(r2);
            return this;
        }

        public Builder enableHttpCache(int r2, long r3) {
            this.mBuilderDelegate.enableHttpCache(r2, r3);
            return this;
        }

        public Builder addQuicHint(String r2, int r3, int r4) {
            this.mBuilderDelegate.addQuicHint(r2, r3, r4);
            return this;
        }

        public Builder addPublicKeyPins(String r2, Set<byte[]> r3, boolean r4, Date r5) {
            this.mBuilderDelegate.addPublicKeyPins(r2, r3, r4, r5);
            return this;
        }

        public Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r2) {
            this.mBuilderDelegate.enablePublicKeyPinningBypassForLocalTrustAnchors(r2);
            return this;
        }

        public CronetEngine build() {
            return this.mBuilderDelegate.build();
        }

        private static ICronetEngineBuilder createBuilderDelegate(Context r3, boolean r4) {
            CronetProvider r5 = getEnabledCronetProviders(r3, new ArrayList(CronetProvider.getAllProviders(r3))).get(0);
            if (Log.isLoggable(TAG, 3) == false) goto L6;
            Log.d(TAG, String.format("Using '%s' provider for creating CronetEngine.Builder.", new Object[]{r5}));
        L6:
            return r5.createBuilder(r4).mBuilderDelegate;
        }

        static List<CronetProvider> getEnabledCronetProviders(Context r1, List<CronetProvider> r2) {
            if (r2.size() == 0) goto L17;
            Iterator<CronetProvider> r3 = r2.iterator();
        L6:
            if (r3.hasNext() == false) goto L11;
            if (r3.next().isEnabled() == true) goto L6;
            r3.remove();
            goto L6
        L11:
            if (r2.size() == 0) goto L15;
            Collections.sort(r2, new AnonymousClass1());
            return r2;
        L15:
            throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
        L17:
            throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
        }

        static int compareVersions(String r5, String r6) {
            if (r5 == null) goto L20;
            if (r6 == null) goto L20;
            String[] r7 = r5.split("\\.");
            String[] r8 = r6.split("\\.");
            int r0 = 0;
        L6:
            if (r0 >= r7.length) goto L18;
            if (r0 >= r8.length) goto L18;
            int r1 = Integer.parseInt(r7[r0]);     // Catch: NumberFormatException -> L14
            int r2 = Integer.parseInt(r8[r0]);     // Catch: NumberFormatException -> L14
            if (r1 != r2) goto L11;
            r0 = r0 + 1;
            goto L6
        L11:
            return Integer.signum(r1 - r2);
        L14:
            e = move-exception;
            throw new IllegalArgumentException("Unable to convert version segments into integers: " + r7[r0] + " & " + r8[r0], e);
        L18:
            return Integer.signum(r7.length - r8.length);
        L20:
            throw new IllegalArgumentException("The input values cannot be null");
        }
    }

    static {
    }

    public abstract TTMpaService createTTMpaService();

    public abstract URLStreamHandlerFactory createURLStreamHandlerFactory();

    public abstract byte[] getGlobalMetricsDeltas();

    public abstract List<Long> getOpaqueFuncAddress();

    public abstract String getVersionString();

    public abstract TTNetDiagnosisRequest.Builder newNetDiagnosisRequestBuilder(TTNetDiagnosisRequest.Callback r1, Executor r2);

    public abstract UrlRequest.Builder newUrlRequestBuilder(String r1, UrlRequest.Callback r2, Executor r3);

    public abstract TTWebsocketConnection.Builder newWebsocketConnectionBuilder(TTWebsocketConnection.Callback r1, Executor r2);

    public abstract URLConnection openConnection(URL r1) throws IOException;

    public abstract URLConnection openConnection(URL r1, Proxy r2, boolean r3) throws IOException;

    public abstract void setAlogFuncAddr(long r1);

    public abstract void setAppStartUpState(int r1);

    public abstract void setCookieInitCompleted();

    public abstract void setHostResolverRules(String r1);

    public abstract void shutdown();

    public abstract void startNetLogToFile(String r1, boolean r2);

    public abstract void stopNetLog();

    public CronetEngine() {
    }
}
