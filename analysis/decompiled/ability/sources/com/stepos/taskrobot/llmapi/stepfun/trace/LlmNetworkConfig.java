package com.stepos.taskrobot.llmapi.stepfun.trace;

import D7.v;
import F9.A;
import F9.E;
import F9.F;
import F9.G;
import F9.M;
import F9.z;
import H4.o;
import H7.c;
import K9.g;
import N9.j;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import f6.AbstractC1439d;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import okhttp3.Protocol;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0013J \u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/trace/LlmNetworkConfig;", "", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/taskrobot/llmapi/stepfun/trace/LlmNetworkConfig$ClientType;", "clientType", "Lcom/stepos/taskrobot/llmapi/stepfun/trace/LlmNetworkConfig$NetworkConfig;", "getDefaultConfig", "(Lcom/stepos/taskrobot/llmapi/stepfun/trace/LlmNetworkConfig$ClientType;)Lcom/stepos/taskrobot/llmapi/stepfun/trace/LlmNetworkConfig$NetworkConfig;", "", "serviceName", "LF9/A;", "createPerformanceInterceptor", "(Ljava/lang/String;)LF9/A;", "customConfig", "LF9/F;", "createOptimizedClient", "(Ljava/lang/String;Lcom/stepos/taskrobot/llmapi/stepfun/trace/LlmNetworkConfig$ClientType;Lcom/stepos/taskrobot/llmapi/stepfun/trace/LlmNetworkConfig$NetworkConfig;)LF9/F;", "createStreamingClient", "(Ljava/lang/String;)LF9/F;", "createRegularClient", "testUrl", "diagnoseNetworkPerformance", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "ClientType", "NetworkConfig", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LlmNetworkConfig {
    public static final LlmNetworkConfig INSTANCE = new LlmNetworkConfig();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/trace/LlmNetworkConfig$ClientType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "REGULAR", "STREAMING", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ClientType {
        private static final /* synthetic */ K7.a $ENTRIES;
        private static final /* synthetic */ ClientType[] $VALUES;
        public static final ClientType REGULAR = new ClientType("REGULAR", 0);
        public static final ClientType STREAMING = new ClientType("STREAMING", 1);

        private static final /* synthetic */ ClientType[] $values() {
            return new ClientType[]{REGULAR, STREAMING};
        }

        static {
            ClientType[] clientTypeArr$values = $values();
            $VALUES = clientTypeArr$values;
            $ENTRIES = kotlin.enums.a.a(clientTypeArr$values);
        }

        private ClientType(String str, int i) {
        }

        public static K7.a getEntries() {
            return $ENTRIES;
        }

        public static ClientType valueOf(String str) {
            return (ClientType) Enum.valueOf(ClientType.class, str);
        }

        public static ClientType[] values() {
            return (ClientType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006("}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/trace/LlmNetworkConfig$NetworkConfig;", "", "connectTimeoutSeconds", "", "readTimeoutSeconds", "writeTimeoutSeconds", "callTimeoutSeconds", "maxIdleConnections", "", "keepAliveDurationMinutes", "enableLogging", "", "enableRetry", AppAgent.CONSTRUCT, "(JJJJIJZZ)V", "getConnectTimeoutSeconds", "()J", "getReadTimeoutSeconds", "getWriteTimeoutSeconds", "getCallTimeoutSeconds", "getMaxIdleConnections", "()I", "getKeepAliveDurationMinutes", "getEnableLogging", "()Z", "getEnableRetry", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NetworkConfig {
        private final long callTimeoutSeconds;
        private final long connectTimeoutSeconds;
        private final boolean enableLogging;
        private final boolean enableRetry;
        private final long keepAliveDurationMinutes;
        private final int maxIdleConnections;
        private final long readTimeoutSeconds;
        private final long writeTimeoutSeconds;

        public NetworkConfig() {
            this(0L, 0L, 0L, 0L, 0, 0L, false, false, 255, null);
        }

        /* renamed from: component1, reason: from getter */
        public final long getConnectTimeoutSeconds() {
            return this.connectTimeoutSeconds;
        }

        /* renamed from: component2, reason: from getter */
        public final long getReadTimeoutSeconds() {
            return this.readTimeoutSeconds;
        }

        /* renamed from: component3, reason: from getter */
        public final long getWriteTimeoutSeconds() {
            return this.writeTimeoutSeconds;
        }

        /* renamed from: component4, reason: from getter */
        public final long getCallTimeoutSeconds() {
            return this.callTimeoutSeconds;
        }

        /* renamed from: component5, reason: from getter */
        public final int getMaxIdleConnections() {
            return this.maxIdleConnections;
        }

        /* renamed from: component6, reason: from getter */
        public final long getKeepAliveDurationMinutes() {
            return this.keepAliveDurationMinutes;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getEnableLogging() {
            return this.enableLogging;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getEnableRetry() {
            return this.enableRetry;
        }

        public final NetworkConfig copy(long connectTimeoutSeconds, long readTimeoutSeconds, long writeTimeoutSeconds, long callTimeoutSeconds, int maxIdleConnections, long keepAliveDurationMinutes, boolean enableLogging, boolean enableRetry) {
            return new NetworkConfig(connectTimeoutSeconds, readTimeoutSeconds, writeTimeoutSeconds, callTimeoutSeconds, maxIdleConnections, keepAliveDurationMinutes, enableLogging, enableRetry);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NetworkConfig)) {
                return false;
            }
            NetworkConfig networkConfig = (NetworkConfig) other;
            return this.connectTimeoutSeconds == networkConfig.connectTimeoutSeconds && this.readTimeoutSeconds == networkConfig.readTimeoutSeconds && this.writeTimeoutSeconds == networkConfig.writeTimeoutSeconds && this.callTimeoutSeconds == networkConfig.callTimeoutSeconds && this.maxIdleConnections == networkConfig.maxIdleConnections && this.keepAliveDurationMinutes == networkConfig.keepAliveDurationMinutes && this.enableLogging == networkConfig.enableLogging && this.enableRetry == networkConfig.enableRetry;
        }

        public final long getCallTimeoutSeconds() {
            return this.callTimeoutSeconds;
        }

        public final long getConnectTimeoutSeconds() {
            return this.connectTimeoutSeconds;
        }

        public final boolean getEnableLogging() {
            return this.enableLogging;
        }

        public final boolean getEnableRetry() {
            return this.enableRetry;
        }

        public final long getKeepAliveDurationMinutes() {
            return this.keepAliveDurationMinutes;
        }

        public final int getMaxIdleConnections() {
            return this.maxIdleConnections;
        }

        public final long getReadTimeoutSeconds() {
            return this.readTimeoutSeconds;
        }

        public final long getWriteTimeoutSeconds() {
            return this.writeTimeoutSeconds;
        }

        public int hashCode() {
            return Boolean.hashCode(this.enableRetry) + androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.c(androidx.constraintlayout.core.dsl.a.a(this.maxIdleConnections, androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(Long.hashCode(this.connectTimeoutSeconds) * 31, 31, this.readTimeoutSeconds), 31, this.writeTimeoutSeconds), 31, this.callTimeoutSeconds), 31), 31, this.keepAliveDurationMinutes), 31, this.enableLogging);
        }

        public String toString() {
            long j5 = this.connectTimeoutSeconds;
            long j6 = this.readTimeoutSeconds;
            long j10 = this.writeTimeoutSeconds;
            long j11 = this.callTimeoutSeconds;
            int i = this.maxIdleConnections;
            long j12 = this.keepAliveDurationMinutes;
            boolean z10 = this.enableLogging;
            boolean z11 = this.enableRetry;
            StringBuilder sb = new StringBuilder("NetworkConfig(connectTimeoutSeconds=");
            sb.append(j5);
            sb.append(", readTimeoutSeconds=");
            sb.append(j6);
            b.y(j10, ", writeTimeoutSeconds=", ", callTimeoutSeconds=", sb);
            sb.append(j11);
            sb.append(", maxIdleConnections=");
            sb.append(i);
            b.y(j12, ", keepAliveDurationMinutes=", ", enableLogging=", sb);
            sb.append(z10);
            sb.append(", enableRetry=");
            sb.append(z11);
            sb.append(")");
            return sb.toString();
        }

        public NetworkConfig(long j5, long j6, long j10, long j11, int i, long j12, boolean z10, boolean z11) {
            this.connectTimeoutSeconds = j5;
            this.readTimeoutSeconds = j6;
            this.writeTimeoutSeconds = j10;
            this.callTimeoutSeconds = j11;
            this.maxIdleConnections = i;
            this.keepAliveDurationMinutes = j12;
            this.enableLogging = z10;
            this.enableRetry = z11;
        }

        public /* synthetic */ NetworkConfig(long j5, long j6, long j10, long j11, int i, long j12, boolean z10, boolean z11, int i6, e eVar) {
            this((i6 & 1) != 0 ? 15L : j5, (i6 & 2) != 0 ? 30L : j6, (i6 & 4) == 0 ? j10 : 15L, (i6 & 8) != 0 ? 60L : j11, (i6 & 16) != 0 ? 5 : i, (i6 & 32) != 0 ? 5L : j12, (i6 & 64) != 0 ? true : z10, (i6 & 128) != 0 ? true : z11);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClientType.values().length];
            try {
                iArr[ClientType.REGULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClientType.STREAMING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private LlmNetworkConfig() {
    }

    public static /* synthetic */ F createOptimizedClient$default(LlmNetworkConfig llmNetworkConfig, String str, ClientType clientType, NetworkConfig networkConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            clientType = ClientType.REGULAR;
        }
        if ((i & 4) != 0) {
            networkConfig = null;
        }
        return llmNetworkConfig.createOptimizedClient(str, clientType, networkConfig);
    }

    private final A createPerformanceInterceptor(final String serviceName) {
        return new A() { // from class: com.stepos.taskrobot.llmapi.stepfun.trace.a
            @Override // F9.A
            public final M intercept(z zVar) {
                return LlmNetworkConfig.createPerformanceInterceptor$lambda$0(serviceName, (g) zVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M createPerformanceInterceptor$lambda$0(String str, z chain) throws Exception {
        k.f(chain, "chain");
        G g = ((g) chain).e;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM = B7.a.m("[", str, "-Network]");
        j.H("🌐 " + strM + " Starting request to: " + g.f626a, strM);
        try {
            M mB = ((g) chain).b(g);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            j.H("⚡ " + strM + " Request completed in " + jCurrentTimeMillis2 + "ms - Status: " + mB.d, strM);
            if (jCurrentTimeMillis2 <= 10000) {
                return mB;
            }
            j.G("⚠️ " + strM + " Slow request detected: " + jCurrentTimeMillis2 + "ms for " + g.f626a, strM);
            return mB;
        } catch (Exception e) {
            j.G("💥 " + strM + " Request failed after " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms: " + e.getMessage(), strM);
            throw e;
        }
    }

    private final NetworkConfig getDefaultConfig(ClientType clientType) {
        int i = WhenMappings.$EnumSwitchMapping$0[clientType.ordinal()];
        if (i == 1) {
            return new NetworkConfig(0L, 30L, 0L, 60L, 0, 0L, false, false, 245, null);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return new NetworkConfig(0L, 90L, 0L, 120L, 0, 0L, false, false, 245, null);
    }

    public final F createOptimizedClient(String serviceName, ClientType clientType, NetworkConfig customConfig) {
        k.f(serviceName, "serviceName");
        k.f(clientType, "clientType");
        if (customConfig == null) {
            customConfig = getDefaultConfig(clientType);
        }
        E eA = ((F) AbstractC1439d.f4442a.getF4884a()).a();
        long connectTimeoutSeconds = customConfig.getConnectTimeoutSeconds();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        eA.b(connectTimeoutSeconds, timeUnit);
        eA.c(customConfig.getReadTimeoutSeconds(), timeUnit);
        eA.e(customConfig.getWriteTimeoutSeconds(), timeUnit);
        eA.f609w = G9.b.b(customConfig.getCallTimeoutSeconds(), timeUnit);
        Protocol protocol = Protocol.HTTP_2;
        Protocol protocol2 = Protocol.HTTP_1_1;
        List protocols = o.N(protocol, protocol2);
        k.f(protocols, "protocols");
        ArrayList arrayListG1 = v.g1(protocols);
        Protocol protocol3 = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!arrayListG1.contains(protocol3) && !arrayListG1.contains(protocol2)) {
            throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + arrayListG1).toString());
        }
        if (arrayListG1.contains(protocol3) && arrayListG1.size() > 1) {
            throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayListG1).toString());
        }
        if (arrayListG1.contains(Protocol.HTTP_1_0)) {
            throw new IllegalArgumentException(("protocols must not contain http/1.0: " + arrayListG1).toString());
        }
        if (arrayListG1.contains(null)) {
            throw new IllegalArgumentException("protocols must not contain null");
        }
        arrayListG1.remove(Protocol.SPDY_3);
        if (!arrayListG1.equals(eA.f606s)) {
            eA.f601B = null;
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayListG1);
        k.e(listUnmodifiableList, "unmodifiableList(protocolsCopy)");
        eA.f606s = listUnmodifiableList;
        eA.f = customConfig.getEnableRetry();
        eA.a(createPerformanceInterceptor(serviceName));
        return new F(eA);
    }

    public final F createRegularClient(String serviceName) {
        k.f(serviceName, "serviceName");
        return createOptimizedClient$default(this, serviceName, ClientType.REGULAR, null, 4, null);
    }

    public final F createStreamingClient(String serviceName) {
        k.f(serviceName, "serviceName");
        return createOptimizedClient$default(this, serviceName, ClientType.STREAMING, null, 4, null);
    }

    public final Object diagnoseNetworkPerformance(String str, String str2, c<? super String> cVar) throws UnknownHostException {
        ArrayList arrayList = new ArrayList();
        String strM = B7.a.m("[", str, "-Diagnostic]");
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                InetAddress[] allByName = InetAddress.getAllByName(new URL(str2).getHost());
                arrayList.add("✅ DNS解析: " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms (" + allByName.length + "个地址)");
                for (InetAddress inetAddress : allByName) {
                    arrayList.add("   - " + inetAddress.getHostAddress());
                }
            } catch (Exception e) {
                arrayList.add("❌ DNS解析失败: " + e.getMessage());
            }
            arrayList.add("📡 网络类型: 将在运行时检测");
        } catch (Exception e6) {
            arrayList.add("💥 诊断过程出错: " + e6.getMessage());
        }
        String strI0 = v.I0(arrayList, "\n", null, null, null, 62);
        j.H("🔍 " + strM + " 网络诊断结果:\n" + strI0, strM);
        return strI0;
    }
}
