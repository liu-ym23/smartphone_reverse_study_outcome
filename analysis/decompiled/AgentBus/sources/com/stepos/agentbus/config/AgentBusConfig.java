package com.stepos.agentbus.config;

import fi.iki.elonen.NanoHTTPD;
import kotlin.Metadata;
import q7.k;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020#\u0012\b\b\u0002\u0010$\u001a\u00020%\u0012\b\b\u0002\u0010&\u001a\u00020'\u0012\b\b\u0002\u0010(\u001a\u00020)¢\u0006\u0004\b*\u0010+J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0007HÆ\u0003J\t\u0010W\u001a\u00020\tHÆ\u0003J\t\u0010X\u001a\u00020\u000bHÆ\u0003J\t\u0010Y\u001a\u00020\rHÆ\u0003J\t\u0010Z\u001a\u00020\u000fHÆ\u0003J\t\u0010[\u001a\u00020\u0011HÆ\u0003J\t\u0010\\\u001a\u00020\u0013HÆ\u0003J\t\u0010]\u001a\u00020\u0015HÆ\u0003J\t\u0010^\u001a\u00020\u0017HÆ\u0003J\t\u0010_\u001a\u00020\u0019HÆ\u0003J\t\u0010`\u001a\u00020\u001bHÆ\u0003J\t\u0010a\u001a\u00020\u001dHÆ\u0003J\t\u0010b\u001a\u00020\u001fHÆ\u0003J\t\u0010c\u001a\u00020!HÆ\u0003J\t\u0010d\u001a\u00020#HÆ\u0003J\t\u0010e\u001a\u00020%HÆ\u0003J\t\u0010f\u001a\u00020'HÆ\u0003J\t\u0010g\u001a\u00020)HÆ\u0003JÑ\u0001\u0010h\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)HÆ\u0001J\u0013\u0010i\u001a\u00020j2\b\u0010k\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010l\u001a\u00020\u0003HÖ\u0001J\t\u0010m\u001a\u00020nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bR\u0010S¨\u0006o"}, d2 = {"Lcom/stepos/agentbus/config/AgentBusConfig;", "", "version", "", "cloud", "Lcom/stepos/agentbus/config/CloudConfig;", "edge", "Lcom/stepos/agentbus/config/EdgeConfig;", "localSocket", "Lcom/stepos/agentbus/config/LocalSocketConfig;", "restApi", "Lcom/stepos/agentbus/config/RestApiConfig;", "timeouts", "Lcom/stepos/agentbus/config/TimeoutsConfig;", "router", "Lcom/stepos/agentbus/config/RouterConfig;", "rateLimit", "Lcom/stepos/agentbus/config/RateLimitConfig;", "dedup", "Lcom/stepos/agentbus/config/DedupConfig;", "invocationMapper", "Lcom/stepos/agentbus/config/InvocationMapperConfig;", "blobServer", "Lcom/stepos/agentbus/config/BlobServerConfig;", "offlineQueue", "Lcom/stepos/agentbus/config/OfflineQueueConfig;", "metrics", "Lcom/stepos/agentbus/config/MetricsConfig;", "logging", "Lcom/stepos/agentbus/config/LoggingConfig;", "memory", "Lcom/stepos/agentbus/config/MemoryConfig;", "resource", "Lcom/stepos/agentbus/config/ResourceConfig;", "gateway", "Lcom/stepos/agentbus/config/GatewayConfig;", "push", "Lcom/stepos/agentbus/config/PushConfig;", "privacy", "Lcom/stepos/agentbus/config/PrivacyConfig;", "dataReport", "Lcom/stepos/agentbus/config/DataReportConfig;", "<init>", "(ILcom/stepos/agentbus/config/CloudConfig;Lcom/stepos/agentbus/config/EdgeConfig;Lcom/stepos/agentbus/config/LocalSocketConfig;Lcom/stepos/agentbus/config/RestApiConfig;Lcom/stepos/agentbus/config/TimeoutsConfig;Lcom/stepos/agentbus/config/RouterConfig;Lcom/stepos/agentbus/config/RateLimitConfig;Lcom/stepos/agentbus/config/DedupConfig;Lcom/stepos/agentbus/config/InvocationMapperConfig;Lcom/stepos/agentbus/config/BlobServerConfig;Lcom/stepos/agentbus/config/OfflineQueueConfig;Lcom/stepos/agentbus/config/MetricsConfig;Lcom/stepos/agentbus/config/LoggingConfig;Lcom/stepos/agentbus/config/MemoryConfig;Lcom/stepos/agentbus/config/ResourceConfig;Lcom/stepos/agentbus/config/GatewayConfig;Lcom/stepos/agentbus/config/PushConfig;Lcom/stepos/agentbus/config/PrivacyConfig;Lcom/stepos/agentbus/config/DataReportConfig;)V", "getVersion", "()I", "getCloud", "()Lcom/stepos/agentbus/config/CloudConfig;", "getEdge", "()Lcom/stepos/agentbus/config/EdgeConfig;", "getLocalSocket", "()Lcom/stepos/agentbus/config/LocalSocketConfig;", "getRestApi", "()Lcom/stepos/agentbus/config/RestApiConfig;", "getTimeouts", "()Lcom/stepos/agentbus/config/TimeoutsConfig;", "getRouter", "()Lcom/stepos/agentbus/config/RouterConfig;", "getRateLimit", "()Lcom/stepos/agentbus/config/RateLimitConfig;", "getDedup", "()Lcom/stepos/agentbus/config/DedupConfig;", "getInvocationMapper", "()Lcom/stepos/agentbus/config/InvocationMapperConfig;", "getBlobServer", "()Lcom/stepos/agentbus/config/BlobServerConfig;", "getOfflineQueue", "()Lcom/stepos/agentbus/config/OfflineQueueConfig;", "getMetrics", "()Lcom/stepos/agentbus/config/MetricsConfig;", "getLogging", "()Lcom/stepos/agentbus/config/LoggingConfig;", "getMemory", "()Lcom/stepos/agentbus/config/MemoryConfig;", "getResource", "()Lcom/stepos/agentbus/config/ResourceConfig;", "getGateway", "()Lcom/stepos/agentbus/config/GatewayConfig;", "getPush", "()Lcom/stepos/agentbus/config/PushConfig;", "getPrivacy", "()Lcom/stepos/agentbus/config/PrivacyConfig;", "getDataReport", "()Lcom/stepos/agentbus/config/DataReportConfig;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "equals", "", "other", "hashCode", "toString", "", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AgentBusConfig {
    private final BlobServerConfig blobServer;
    private final CloudConfig cloud;
    private final DataReportConfig dataReport;
    private final DedupConfig dedup;
    private final EdgeConfig edge;
    private final GatewayConfig gateway;
    private final InvocationMapperConfig invocationMapper;
    private final LocalSocketConfig localSocket;
    private final LoggingConfig logging;
    private final MemoryConfig memory;
    private final MetricsConfig metrics;
    private final OfflineQueueConfig offlineQueue;
    private final PrivacyConfig privacy;
    private final PushConfig push;
    private final RateLimitConfig rateLimit;
    private final ResourceConfig resource;
    private final RestApiConfig restApi;
    private final RouterConfig router;
    private final TimeoutsConfig timeouts;
    private final int version;

    public AgentBusConfig() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    public static /* synthetic */ AgentBusConfig copy$default(AgentBusConfig agentBusConfig, int i2, CloudConfig cloudConfig, EdgeConfig edgeConfig, LocalSocketConfig localSocketConfig, RestApiConfig restApiConfig, TimeoutsConfig timeoutsConfig, RouterConfig routerConfig, RateLimitConfig rateLimitConfig, DedupConfig dedupConfig, InvocationMapperConfig invocationMapperConfig, BlobServerConfig blobServerConfig, OfflineQueueConfig offlineQueueConfig, MetricsConfig metricsConfig, LoggingConfig loggingConfig, MemoryConfig memoryConfig, ResourceConfig resourceConfig, GatewayConfig gatewayConfig, PushConfig pushConfig, PrivacyConfig privacyConfig, DataReportConfig dataReportConfig, int i10, Object obj) {
        DataReportConfig dataReportConfig2;
        PrivacyConfig privacyConfig2;
        int i11 = (i10 & 1) != 0 ? agentBusConfig.version : i2;
        CloudConfig cloudConfig2 = (i10 & 2) != 0 ? agentBusConfig.cloud : cloudConfig;
        EdgeConfig edgeConfig2 = (i10 & 4) != 0 ? agentBusConfig.edge : edgeConfig;
        LocalSocketConfig localSocketConfig2 = (i10 & 8) != 0 ? agentBusConfig.localSocket : localSocketConfig;
        RestApiConfig restApiConfig2 = (i10 & 16) != 0 ? agentBusConfig.restApi : restApiConfig;
        TimeoutsConfig timeoutsConfig2 = (i10 & 32) != 0 ? agentBusConfig.timeouts : timeoutsConfig;
        RouterConfig routerConfig2 = (i10 & 64) != 0 ? agentBusConfig.router : routerConfig;
        RateLimitConfig rateLimitConfig2 = (i10 & 128) != 0 ? agentBusConfig.rateLimit : rateLimitConfig;
        DedupConfig dedupConfig2 = (i10 & 256) != 0 ? agentBusConfig.dedup : dedupConfig;
        InvocationMapperConfig invocationMapperConfig2 = (i10 & 512) != 0 ? agentBusConfig.invocationMapper : invocationMapperConfig;
        BlobServerConfig blobServerConfig2 = (i10 & NanoHTTPD.HTTPSession.MAX_HEADER_SIZE) != 0 ? agentBusConfig.blobServer : blobServerConfig;
        OfflineQueueConfig offlineQueueConfig2 = (i10 & 2048) != 0 ? agentBusConfig.offlineQueue : offlineQueueConfig;
        MetricsConfig metricsConfig2 = (i10 & 4096) != 0 ? agentBusConfig.metrics : metricsConfig;
        LoggingConfig loggingConfig2 = (i10 & NanoHTTPD.HTTPSession.BUFSIZE) != 0 ? agentBusConfig.logging : loggingConfig;
        int i12 = i11;
        MemoryConfig memoryConfig2 = (i10 & 16384) != 0 ? agentBusConfig.memory : memoryConfig;
        ResourceConfig resourceConfig2 = (i10 & 32768) != 0 ? agentBusConfig.resource : resourceConfig;
        GatewayConfig gatewayConfig2 = (i10 & 65536) != 0 ? agentBusConfig.gateway : gatewayConfig;
        PushConfig pushConfig2 = (i10 & 131072) != 0 ? agentBusConfig.push : pushConfig;
        PrivacyConfig privacyConfig3 = (i10 & 262144) != 0 ? agentBusConfig.privacy : privacyConfig;
        if ((i10 & 524288) != 0) {
            privacyConfig2 = privacyConfig3;
            dataReportConfig2 = agentBusConfig.dataReport;
        } else {
            dataReportConfig2 = dataReportConfig;
            privacyConfig2 = privacyConfig3;
        }
        return agentBusConfig.copy(i12, cloudConfig2, edgeConfig2, localSocketConfig2, restApiConfig2, timeoutsConfig2, routerConfig2, rateLimitConfig2, dedupConfig2, invocationMapperConfig2, blobServerConfig2, offlineQueueConfig2, metricsConfig2, loggingConfig2, memoryConfig2, resourceConfig2, gatewayConfig2, pushConfig2, privacyConfig2, dataReportConfig2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component10, reason: from getter */
    public final InvocationMapperConfig getInvocationMapper() {
        return this.invocationMapper;
    }

    /* renamed from: component11, reason: from getter */
    public final BlobServerConfig getBlobServer() {
        return this.blobServer;
    }

    /* renamed from: component12, reason: from getter */
    public final OfflineQueueConfig getOfflineQueue() {
        return this.offlineQueue;
    }

    /* renamed from: component13, reason: from getter */
    public final MetricsConfig getMetrics() {
        return this.metrics;
    }

    /* renamed from: component14, reason: from getter */
    public final LoggingConfig getLogging() {
        return this.logging;
    }

    /* renamed from: component15, reason: from getter */
    public final MemoryConfig getMemory() {
        return this.memory;
    }

    /* renamed from: component16, reason: from getter */
    public final ResourceConfig getResource() {
        return this.resource;
    }

    /* renamed from: component17, reason: from getter */
    public final GatewayConfig getGateway() {
        return this.gateway;
    }

    /* renamed from: component18, reason: from getter */
    public final PushConfig getPush() {
        return this.push;
    }

    /* renamed from: component19, reason: from getter */
    public final PrivacyConfig getPrivacy() {
        return this.privacy;
    }

    /* renamed from: component2, reason: from getter */
    public final CloudConfig getCloud() {
        return this.cloud;
    }

    /* renamed from: component20, reason: from getter */
    public final DataReportConfig getDataReport() {
        return this.dataReport;
    }

    /* renamed from: component3, reason: from getter */
    public final EdgeConfig getEdge() {
        return this.edge;
    }

    /* renamed from: component4, reason: from getter */
    public final LocalSocketConfig getLocalSocket() {
        return this.localSocket;
    }

    /* renamed from: component5, reason: from getter */
    public final RestApiConfig getRestApi() {
        return this.restApi;
    }

    /* renamed from: component6, reason: from getter */
    public final TimeoutsConfig getTimeouts() {
        return this.timeouts;
    }

    /* renamed from: component7, reason: from getter */
    public final RouterConfig getRouter() {
        return this.router;
    }

    /* renamed from: component8, reason: from getter */
    public final RateLimitConfig getRateLimit() {
        return this.rateLimit;
    }

    /* renamed from: component9, reason: from getter */
    public final DedupConfig getDedup() {
        return this.dedup;
    }

    public final AgentBusConfig copy(int version, CloudConfig cloud, EdgeConfig edge, LocalSocketConfig localSocket, RestApiConfig restApi, TimeoutsConfig timeouts, RouterConfig router, RateLimitConfig rateLimit, DedupConfig dedup, InvocationMapperConfig invocationMapper, BlobServerConfig blobServer, OfflineQueueConfig offlineQueue, MetricsConfig metrics, LoggingConfig logging, MemoryConfig memory, ResourceConfig resource, GatewayConfig gateway, PushConfig push, PrivacyConfig privacy, DataReportConfig dataReport) {
        k.e(cloud, "cloud");
        k.e(edge, "edge");
        k.e(localSocket, "localSocket");
        k.e(restApi, "restApi");
        k.e(timeouts, "timeouts");
        k.e(router, "router");
        k.e(rateLimit, "rateLimit");
        k.e(dedup, "dedup");
        k.e(invocationMapper, "invocationMapper");
        k.e(blobServer, "blobServer");
        k.e(offlineQueue, "offlineQueue");
        k.e(metrics, "metrics");
        k.e(logging, "logging");
        k.e(memory, "memory");
        k.e(resource, "resource");
        k.e(gateway, "gateway");
        k.e(push, "push");
        k.e(privacy, "privacy");
        k.e(dataReport, "dataReport");
        return new AgentBusConfig(version, cloud, edge, localSocket, restApi, timeouts, router, rateLimit, dedup, invocationMapper, blobServer, offlineQueue, metrics, logging, memory, resource, gateway, push, privacy, dataReport);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentBusConfig)) {
            return false;
        }
        AgentBusConfig agentBusConfig = (AgentBusConfig) other;
        return this.version == agentBusConfig.version && k.a(this.cloud, agentBusConfig.cloud) && k.a(this.edge, agentBusConfig.edge) && k.a(this.localSocket, agentBusConfig.localSocket) && k.a(this.restApi, agentBusConfig.restApi) && k.a(this.timeouts, agentBusConfig.timeouts) && k.a(this.router, agentBusConfig.router) && k.a(this.rateLimit, agentBusConfig.rateLimit) && k.a(this.dedup, agentBusConfig.dedup) && k.a(this.invocationMapper, agentBusConfig.invocationMapper) && k.a(this.blobServer, agentBusConfig.blobServer) && k.a(this.offlineQueue, agentBusConfig.offlineQueue) && k.a(this.metrics, agentBusConfig.metrics) && k.a(this.logging, agentBusConfig.logging) && k.a(this.memory, agentBusConfig.memory) && k.a(this.resource, agentBusConfig.resource) && k.a(this.gateway, agentBusConfig.gateway) && k.a(this.push, agentBusConfig.push) && k.a(this.privacy, agentBusConfig.privacy) && k.a(this.dataReport, agentBusConfig.dataReport);
    }

    public final BlobServerConfig getBlobServer() {
        return this.blobServer;
    }

    public final CloudConfig getCloud() {
        return this.cloud;
    }

    public final DataReportConfig getDataReport() {
        return this.dataReport;
    }

    public final DedupConfig getDedup() {
        return this.dedup;
    }

    public final EdgeConfig getEdge() {
        return this.edge;
    }

    public final GatewayConfig getGateway() {
        return this.gateway;
    }

    public final InvocationMapperConfig getInvocationMapper() {
        return this.invocationMapper;
    }

    public final LocalSocketConfig getLocalSocket() {
        return this.localSocket;
    }

    public final LoggingConfig getLogging() {
        return this.logging;
    }

    public final MemoryConfig getMemory() {
        return this.memory;
    }

    public final MetricsConfig getMetrics() {
        return this.metrics;
    }

    public final OfflineQueueConfig getOfflineQueue() {
        return this.offlineQueue;
    }

    public final PrivacyConfig getPrivacy() {
        return this.privacy;
    }

    public final PushConfig getPush() {
        return this.push;
    }

    public final RateLimitConfig getRateLimit() {
        return this.rateLimit;
    }

    public final ResourceConfig getResource() {
        return this.resource;
    }

    public final RestApiConfig getRestApi() {
        return this.restApi;
    }

    public final RouterConfig getRouter() {
        return this.router;
    }

    public final TimeoutsConfig getTimeouts() {
        return this.timeouts;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.dataReport.hashCode() + ((this.privacy.hashCode() + ((this.push.hashCode() + ((this.gateway.hashCode() + ((this.resource.hashCode() + ((this.memory.hashCode() + ((this.logging.hashCode() + ((this.metrics.hashCode() + ((this.offlineQueue.hashCode() + ((this.blobServer.hashCode() + ((this.invocationMapper.hashCode() + ((this.dedup.hashCode() + ((this.rateLimit.hashCode() + ((this.router.hashCode() + ((this.timeouts.hashCode() + ((this.restApi.hashCode() + ((this.localSocket.hashCode() + ((this.edge.hashCode() + ((this.cloud.hashCode() + (Integer.hashCode(this.version) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "AgentBusConfig(version=" + this.version + ", cloud=" + this.cloud + ", edge=" + this.edge + ", localSocket=" + this.localSocket + ", restApi=" + this.restApi + ", timeouts=" + this.timeouts + ", router=" + this.router + ", rateLimit=" + this.rateLimit + ", dedup=" + this.dedup + ", invocationMapper=" + this.invocationMapper + ", blobServer=" + this.blobServer + ", offlineQueue=" + this.offlineQueue + ", metrics=" + this.metrics + ", logging=" + this.logging + ", memory=" + this.memory + ", resource=" + this.resource + ", gateway=" + this.gateway + ", push=" + this.push + ", privacy=" + this.privacy + ", dataReport=" + this.dataReport + ")";
    }

    public AgentBusConfig(int i2, CloudConfig cloudConfig, EdgeConfig edgeConfig, LocalSocketConfig localSocketConfig, RestApiConfig restApiConfig, TimeoutsConfig timeoutsConfig, RouterConfig routerConfig, RateLimitConfig rateLimitConfig, DedupConfig dedupConfig, InvocationMapperConfig invocationMapperConfig, BlobServerConfig blobServerConfig, OfflineQueueConfig offlineQueueConfig, MetricsConfig metricsConfig, LoggingConfig loggingConfig, MemoryConfig memoryConfig, ResourceConfig resourceConfig, GatewayConfig gatewayConfig, PushConfig pushConfig, PrivacyConfig privacyConfig, DataReportConfig dataReportConfig) {
        k.e(cloudConfig, "cloud");
        k.e(edgeConfig, "edge");
        k.e(localSocketConfig, "localSocket");
        k.e(restApiConfig, "restApi");
        k.e(timeoutsConfig, "timeouts");
        k.e(routerConfig, "router");
        k.e(rateLimitConfig, "rateLimit");
        k.e(dedupConfig, "dedup");
        k.e(invocationMapperConfig, "invocationMapper");
        k.e(blobServerConfig, "blobServer");
        k.e(offlineQueueConfig, "offlineQueue");
        k.e(metricsConfig, "metrics");
        k.e(loggingConfig, "logging");
        k.e(memoryConfig, "memory");
        k.e(resourceConfig, "resource");
        k.e(gatewayConfig, "gateway");
        k.e(pushConfig, "push");
        k.e(privacyConfig, "privacy");
        k.e(dataReportConfig, "dataReport");
        this.version = i2;
        this.cloud = cloudConfig;
        this.edge = edgeConfig;
        this.localSocket = localSocketConfig;
        this.restApi = restApiConfig;
        this.timeouts = timeoutsConfig;
        this.router = routerConfig;
        this.rateLimit = rateLimitConfig;
        this.dedup = dedupConfig;
        this.invocationMapper = invocationMapperConfig;
        this.blobServer = blobServerConfig;
        this.offlineQueue = offlineQueueConfig;
        this.metrics = metricsConfig;
        this.logging = loggingConfig;
        this.memory = memoryConfig;
        this.resource = resourceConfig;
        this.gateway = gatewayConfig;
        this.push = pushConfig;
        this.privacy = privacyConfig;
        this.dataReport = dataReportConfig;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ AgentBusConfig(int r41, com.stepos.agentbus.config.CloudConfig r42, com.stepos.agentbus.config.EdgeConfig r43, com.stepos.agentbus.config.LocalSocketConfig r44, com.stepos.agentbus.config.RestApiConfig r45, com.stepos.agentbus.config.TimeoutsConfig r46, com.stepos.agentbus.config.RouterConfig r47, com.stepos.agentbus.config.RateLimitConfig r48, com.stepos.agentbus.config.DedupConfig r49, com.stepos.agentbus.config.InvocationMapperConfig r50, com.stepos.agentbus.config.BlobServerConfig r51, com.stepos.agentbus.config.OfflineQueueConfig r52, com.stepos.agentbus.config.MetricsConfig r53, com.stepos.agentbus.config.LoggingConfig r54, com.stepos.agentbus.config.MemoryConfig r55, com.stepos.agentbus.config.ResourceConfig r56, com.stepos.agentbus.config.GatewayConfig r57, com.stepos.agentbus.config.PushConfig r58, com.stepos.agentbus.config.PrivacyConfig r59, com.stepos.agentbus.config.DataReportConfig r60, int r61, q7.f r62) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.config.AgentBusConfig.<init>(int, com.stepos.agentbus.config.CloudConfig, com.stepos.agentbus.config.EdgeConfig, com.stepos.agentbus.config.LocalSocketConfig, com.stepos.agentbus.config.RestApiConfig, com.stepos.agentbus.config.TimeoutsConfig, com.stepos.agentbus.config.RouterConfig, com.stepos.agentbus.config.RateLimitConfig, com.stepos.agentbus.config.DedupConfig, com.stepos.agentbus.config.InvocationMapperConfig, com.stepos.agentbus.config.BlobServerConfig, com.stepos.agentbus.config.OfflineQueueConfig, com.stepos.agentbus.config.MetricsConfig, com.stepos.agentbus.config.LoggingConfig, com.stepos.agentbus.config.MemoryConfig, com.stepos.agentbus.config.ResourceConfig, com.stepos.agentbus.config.GatewayConfig, com.stepos.agentbus.config.PushConfig, com.stepos.agentbus.config.PrivacyConfig, com.stepos.agentbus.config.DataReportConfig, int, q7.f):void");
    }
}
