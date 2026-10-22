package com.stepos.agentcache.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/agentcache/core/ServiceContract;", "", "<init>", "()V", "SERVICE_PACKAGE", "", "SERVICE_ACTION", "SERVICE_PERMISSION", "RequiredKeys", "WorkNames", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ServiceContract {
    public static final ServiceContract INSTANCE = new ServiceContract();
    public static final String SERVICE_ACTION = "com.stepos.agentcache.action.BIND_AGENT_CACHE_SERVICE";
    public static final String SERVICE_PACKAGE = "com.stepos.agentcache";
    public static final String SERVICE_PERMISSION = "com.stepos.agentcache.permission.WRITE_AGENT_CACHE";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/agentcache/core/ServiceContract$RequiredKeys;", "", "<init>", "()V", "TRACE_ID", "", "NODE_NAME", "EVENT_TIME", "APP_NAME", "APP_VERSION", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RequiredKeys {
        public static final String APP_NAME = "appName";
        public static final String APP_VERSION = "appVersion";
        public static final String EVENT_TIME = "eventTime";
        public static final RequiredKeys INSTANCE = new RequiredKeys();
        public static final String NODE_NAME = "nodeName";
        public static final String TRACE_ID = "traceId";

        private RequiredKeys() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentcache/core/ServiceContract$WorkNames;", "", "<init>", "()V", "UPLOAD_PERIODIC", "", "UPLOAD_ON_DEMAND", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WorkNames {
        public static final WorkNames INSTANCE = new WorkNames();
        public static final String UPLOAD_ON_DEMAND = "agent_cache_on_demand_upload";
        public static final String UPLOAD_PERIODIC = "agent_cache_periodic_upload";

        private WorkNames() {
        }
    }

    private ServiceContract() {
    }
}
