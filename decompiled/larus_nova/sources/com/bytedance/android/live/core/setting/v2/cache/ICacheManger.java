package com.bytedance.android.live.core.setting.v2.cache;

import java.util.Map;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public interface ICacheManger {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$CacheType;", "", "LOCAL_CACHE", "STICKY", "PRELOAD_CACHE", "TRANSIENT", "OBJECT", "live-setting_release"}, k = 1, mv = {1, 4, 3})
    public static final enum CacheType extends Enum<CacheType> {
        public static final CacheType LOCAL_CACHE = null;
        public static final CacheType OBJECT = null;
        public static final CacheType PRELOAD_CACHE = null;
        public static final CacheType STICKY = null;
        public static final CacheType TRANSIENT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CacheType[] f65431a = null;

        static {
            CacheType r100 = new CacheType("LOCAL_CACHE", 0);
            LOCAL_CACHE = r100;
            CacheType r101 = new CacheType("STICKY", 1);
            STICKY = r101;
            CacheType r102 = new CacheType("PRELOAD_CACHE", 2);
            PRELOAD_CACHE = r102;
            CacheType r103 = new CacheType("TRANSIENT", 3);
            TRANSIENT = r103;
            CacheType r104 = new CacheType("OBJECT", 4);
            OBJECT = r104;
            f65431a = new CacheType[]{r100, r101, r102, r103, r104};
        }

        public static CacheType valueOf(String r100) {
            return (CacheType) a.a(CacheType.class, r100);
        }

        public static CacheType[] values() {
            return (CacheType[]) f65431a.clone();
        }

        public CacheType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$Operation;", "", "PLUS", "MINUS", "live-setting_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Operation extends Enum<Operation> {
        public static final Operation MINUS = null;
        public static final Operation PLUS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Operation[] f65432a = null;

        static {
            Operation r100 = new Operation("PLUS", 0);
            PLUS = r100;
            Operation r101 = new Operation("MINUS", 1);
            MINUS = r101;
            f65432a = new Operation[]{r100, r101};
        }

        public static Operation valueOf(String r100) {
            return (Operation) a.a(Operation.class, r100);
        }

        public static Operation[] values() {
            return (Operation[]) f65432a.clone();
        }

        public Operation(String r100, int r101) {
            super(r100, r101);
        }
    }

    boolean update(CacheType r100, Operation r101, Map<String, ? extends Object> r102);
}
