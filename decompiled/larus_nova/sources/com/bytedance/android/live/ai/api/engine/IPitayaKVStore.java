package com.bytedance.android.live.ai.api.engine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public interface IPitayaKVStore {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ai/api/engine/IPitayaKVStore$ServiceType;", "", "IN_MEMORY_CACHE", "KV_STORE", "liveai-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ServiceType extends Enum<ServiceType> {
        public static final ServiceType IN_MEMORY_CACHE = null;
        public static final ServiceType KV_STORE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ServiceType[] f58555a = null;

        static {
            ServiceType r100 = new ServiceType("IN_MEMORY_CACHE", 0);
            IN_MEMORY_CACHE = r100;
            ServiceType r101 = new ServiceType("KV_STORE", 1);
            KV_STORE = r101;
            f58555a = new ServiceType[]{r100, r101};
        }

        public static ServiceType valueOf(String r100) {
            return (ServiceType) a.a(ServiceType.class, r100);
        }

        public static ServiceType[] values() {
            return (ServiceType[]) f58555a.clone();
        }

        public ServiceType(String r100, int r101) {
            super(r100, r101);
        }
    }
}
