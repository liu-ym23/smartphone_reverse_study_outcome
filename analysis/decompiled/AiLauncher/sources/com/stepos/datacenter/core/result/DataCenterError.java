package com.stepos.datacenter.core.result;

import Y8.h;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.aiengine.flow.ModelFlowError;
import com.stepos.datacenter.core.result.DataCenterError;
import h9.InterfaceC4149a;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;
import kotlinx.serialization.KSerializer;
import lb.l;
import p9.InterfaceC5063a;
import pb.I;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b0\b\u0087\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3¨\u00064"}, d2 = {"Lcom/stepos/datacenter/core/result/DataCenterError;", "", "", "code", "", Const.JSON_KEY_DESC, "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "I", "getCode", "()I", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "getCategory", QueryAlgorithmBundle.KEY_CATEGORY, "Companion", Const.INTENT_KEY_APIKEY, "INVALID_ARGS", "DIMENSION_MISMATCH", "SIZE_MISMATCH", "EMPTY_INPUT", "INVALID_TOPK", "NOT_CONNECTED", "UNSUPPORTED_OPERATION", "NOT_INITIALIZED", "STORAGE_FULL", "NOT_FOUND", "ALREADY_EXISTS", "INTERNAL_ERROR", "VERSION_MISMATCH", "FORMAT_UNSUPPORTED", "IPC_REMOTE_EXCEPTION", "IPC_TRANSACTION_TOO_LARGE", "IPC_SERVICE_DIED", "IPC_BIND_FAILED", "IPC_TIMEOUT", "CORRUPT_DATA", "CHECKSUM_MISMATCH", "MIGRATION_FAILED", "CLOUD_AUTH_FAILED", "CLOUD_NETWORK", "CLOUD_SERVER_ERROR", "CLOUD_RATE_LIMITED", "CLOUD_SERIALIZATION", "VECTOR_COLLECTION_NOT_FOUND", "VECTOR_INDEX_NOT_FOUND", "VECTOR_INDEX_NOT_READY", "VECTOR_EMBED_PROVIDER_MISSING", "VECTOR_EMBED_FAILED", "VECTOR_MODEL_MISMATCH", "UNKNOWN", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@l
/* loaded from: classes3.dex */
public final class DataCenterError {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ DataCenterError[] $VALUES;
    private static final h<KSerializer<Object>> $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int code;
    private final String desc;
    public static final DataCenterError INVALID_ARGS = new DataCenterError("INVALID_ARGS", 0, 1000, "参数非法");
    public static final DataCenterError DIMENSION_MISMATCH = new DataCenterError("DIMENSION_MISMATCH", 1, 1001, "向量维度与 collection 不匹配");
    public static final DataCenterError SIZE_MISMATCH = new DataCenterError("SIZE_MISMATCH", 2, 1002, "批量参数列表长度不一致");
    public static final DataCenterError EMPTY_INPUT = new DataCenterError("EMPTY_INPUT", 3, 1003, "输入为空");
    public static final DataCenterError INVALID_TOPK = new DataCenterError("INVALID_TOPK", 4, 1004, "topK 必须大于 0");
    public static final DataCenterError NOT_CONNECTED = new DataCenterError("NOT_CONNECTED", 5, 1006, "未连接到引擎或会话已失效");
    public static final DataCenterError UNSUPPORTED_OPERATION = new DataCenterError("UNSUPPORTED_OPERATION", 6, AMapException.CODE_AMAP_INVALID_USER_DOMAIN, "provider 不支持此操作");
    public static final DataCenterError NOT_INITIALIZED = new DataCenterError("NOT_INITIALIZED", 7, AMapException.CODE_AMAP_ID_NOT_EXIST, "未初始化");
    public static final DataCenterError STORAGE_FULL = new DataCenterError("STORAGE_FULL", 8, AMapException.CODE_AMAP_SERVICE_MAINTENANCE, "存储空间不足");
    public static final DataCenterError NOT_FOUND = new DataCenterError("NOT_FOUND", 9, AMapException.CODE_AMAP_ENGINE_TABLEID_NOT_EXIST, "未找到指定 id / 记录");
    public static final DataCenterError ALREADY_EXISTS = new DataCenterError("ALREADY_EXISTS", 10, 2004, "已存在同名条目");
    public static final DataCenterError INTERNAL_ERROR = new DataCenterError("INTERNAL_ERROR", 11, O6.l.MAX_YEAR, "内部错误");
    public static final DataCenterError VERSION_MISMATCH = new DataCenterError("VERSION_MISMATCH", 12, AMapException.CODE_AMAP_ROUTE_NO_ROADS_NEARBY, "SDK 与引擎协议版本不兼容");
    public static final DataCenterError FORMAT_UNSUPPORTED = new DataCenterError("FORMAT_UNSUPPORTED", 13, AMapException.CODE_AMAP_ROUTE_FAIL, "文件格式版本不支持");
    public static final DataCenterError IPC_REMOTE_EXCEPTION = new DataCenterError("IPC_REMOTE_EXCEPTION", 14, 4001, "跨进程调用异常");
    public static final DataCenterError IPC_TRANSACTION_TOO_LARGE = new DataCenterError("IPC_TRANSACTION_TOO_LARGE", 15, 4002, "单次事务数据过大");
    public static final DataCenterError IPC_SERVICE_DIED = new DataCenterError("IPC_SERVICE_DIED", 16, ModelFlowError.USER_CANCELED_CELLULAR, "DataCenter 服务已终止");
    public static final DataCenterError IPC_BIND_FAILED = new DataCenterError("IPC_BIND_FAILED", 17, ModelFlowError.USER_CANCELED_UPDATE, "无法绑定 DataCenter 服务");
    public static final DataCenterError IPC_TIMEOUT = new DataCenterError("IPC_TIMEOUT", 18, ModelFlowError.USER_CANCELED_WIFI_GUIDE, "跨进程调用超时");
    public static final DataCenterError CORRUPT_DATA = new DataCenterError("CORRUPT_DATA", 19, 5001, "数据损坏");
    public static final DataCenterError CHECKSUM_MISMATCH = new DataCenterError("CHECKSUM_MISMATCH", 20, 5002, "校验和不匹配");
    public static final DataCenterError MIGRATION_FAILED = new DataCenterError("MIGRATION_FAILED", 21, ModelFlowError.ALREADY_UP_TO_DATE, "schema 迁移失败");
    public static final DataCenterError CLOUD_AUTH_FAILED = new DataCenterError("CLOUD_AUTH_FAILED", 22, ModelFlowError.DOWNLOAD_SCHEDULED, "云端鉴权失败");
    public static final DataCenterError CLOUD_NETWORK = new DataCenterError("CLOUD_NETWORK", 23, ModelFlowError.NEED_DOWNLOAD_SUPPRESSED, "云端网络错误");
    public static final DataCenterError CLOUD_SERVER_ERROR = new DataCenterError("CLOUD_SERVER_ERROR", 24, ModelFlowError.SERVICE_ENABLE_GUIDED, "云端服务异常");
    public static final DataCenterError CLOUD_RATE_LIMITED = new DataCenterError("CLOUD_RATE_LIMITED", 25, 6004, "云端限流");
    public static final DataCenterError CLOUD_SERIALIZATION = new DataCenterError("CLOUD_SERIALIZATION", 26, 6005, "云同步序列化失败");
    public static final DataCenterError VECTOR_COLLECTION_NOT_FOUND = new DataCenterError("VECTOR_COLLECTION_NOT_FOUND", 27, 7001, "collection 不存在");
    public static final DataCenterError VECTOR_INDEX_NOT_FOUND = new DataCenterError("VECTOR_INDEX_NOT_FOUND", 28, 7002, "index 不存在");
    public static final DataCenterError VECTOR_INDEX_NOT_READY = new DataCenterError("VECTOR_INDEX_NOT_READY", 29, 7003, "index 未就绪");
    public static final DataCenterError VECTOR_EMBED_PROVIDER_MISSING = new DataCenterError("VECTOR_EMBED_PROVIDER_MISSING", 30, 7004, "EmbedProvider 未注入");
    public static final DataCenterError VECTOR_EMBED_FAILED = new DataCenterError("VECTOR_EMBED_FAILED", 31, 7005, "embedding 生成失败");
    public static final DataCenterError VECTOR_MODEL_MISMATCH = new DataCenterError("VECTOR_MODEL_MISMATCH", 32, 7006, "embedding 模型与 collection 不匹配");
    public static final DataCenterError UNKNOWN = new DataCenterError("UNKNOWN", 33, 9999, AMapException.AMAP_CLIENT_UNKNOWN_ERROR);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/datacenter/core/result/DataCenterError$a;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/datacenter/core/result/DataCenterError;", "serializer", "()Lkotlinx/serialization/KSerializer;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.core.result.DataCenterError$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final /* synthetic */ KSerializer a() {
            return (KSerializer) DataCenterError.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<DataCenterError> serializer() {
            return a();
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ DataCenterError[] $values() {
        return new DataCenterError[]{INVALID_ARGS, DIMENSION_MISMATCH, SIZE_MISMATCH, EMPTY_INPUT, INVALID_TOPK, NOT_CONNECTED, UNSUPPORTED_OPERATION, NOT_INITIALIZED, STORAGE_FULL, NOT_FOUND, ALREADY_EXISTS, INTERNAL_ERROR, VERSION_MISMATCH, FORMAT_UNSUPPORTED, IPC_REMOTE_EXCEPTION, IPC_TRANSACTION_TOO_LARGE, IPC_SERVICE_DIED, IPC_BIND_FAILED, IPC_TIMEOUT, CORRUPT_DATA, CHECKSUM_MISMATCH, MIGRATION_FAILED, CLOUD_AUTH_FAILED, CLOUD_NETWORK, CLOUD_SERVER_ERROR, CLOUD_RATE_LIMITED, CLOUD_SERIALIZATION, VECTOR_COLLECTION_NOT_FOUND, VECTOR_INDEX_NOT_FOUND, VECTOR_INDEX_NOT_READY, VECTOR_EMBED_PROVIDER_MISSING, VECTOR_EMBED_FAILED, VECTOR_MODEL_MISMATCH, UNKNOWN};
    }

    static {
        DataCenterError[] dataCenterErrorArr$values = $values();
        $VALUES = dataCenterErrorArr$values;
        $ENTRIES = a.a(dataCenterErrorArr$values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: X6.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DataCenterError._init_$_anonymous_();
            }
        });
    }

    private DataCenterError(String str, int i10, int i11, String str2) {
        this.code = i11;
        this.desc = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return I.a("com.stepos.datacenter.core.result.DataCenterError", values());
    }

    public static InterfaceC4149a<DataCenterError> getEntries() {
        return $ENTRIES;
    }

    public static DataCenterError valueOf(String str) {
        return (DataCenterError) Enum.valueOf(DataCenterError.class, str);
    }

    public static DataCenterError[] values() {
        return (DataCenterError[]) $VALUES.clone();
    }

    public final int getCategory() {
        return this.code / 1000;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDesc() {
        return this.desc;
    }
}
