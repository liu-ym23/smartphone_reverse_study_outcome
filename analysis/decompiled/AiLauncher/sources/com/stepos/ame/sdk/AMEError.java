package com.stepos.ame.sdk;

import O6.l;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ame/sdk/AMEError;", "", "code", "", Const.JSON_KEY_DESC, "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getDesc", "()Ljava/lang/String;", "ARGS_DIMENSION_MISMATCH", "ARGS_SIZE_MISMATCH", "ARGS_EMPTY_INPUT", "ARGS_INVALID_TOPK", "ARGS_INVALID_PARAM", "ARGS_NOT_CONNECTED", "SERVICE_NOT_INITIALIZED", "SERVICE_STORAGE_FULL", "SERVICE_ID_NOT_FOUND", "SERVICE_DIMENSION_MISMATCH", "SERVICE_INTERNAL_ERROR", "VERSION_MISMATCH", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AMEError {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ AMEError[] $VALUES;
    private final int code;
    private final String desc;
    public static final AMEError ARGS_DIMENSION_MISMATCH = new AMEError("ARGS_DIMENSION_MISMATCH", 0, 1001, "向量维度与引擎配置不匹配");
    public static final AMEError ARGS_SIZE_MISMATCH = new AMEError("ARGS_SIZE_MISMATCH", 1, 1002, "批量参数列表长度不一致");
    public static final AMEError ARGS_EMPTY_INPUT = new AMEError("ARGS_EMPTY_INPUT", 2, 1003, "输入向量或 ID 列表为空");
    public static final AMEError ARGS_INVALID_TOPK = new AMEError("ARGS_INVALID_TOPK", 3, 1004, "topK 必须大于 0");
    public static final AMEError ARGS_INVALID_PARAM = new AMEError("ARGS_INVALID_PARAM", 4, 1005, "参数非法");
    public static final AMEError ARGS_NOT_CONNECTED = new AMEError("ARGS_NOT_CONNECTED", 5, 1006, "未连接到 AME 引擎");
    public static final AMEError SERVICE_NOT_INITIALIZED = new AMEError("SERVICE_NOT_INITIALIZED", 6, AMapException.CODE_AMAP_ID_NOT_EXIST, "引擎尚未初始化");
    public static final AMEError SERVICE_STORAGE_FULL = new AMEError("SERVICE_STORAGE_FULL", 7, AMapException.CODE_AMAP_SERVICE_MAINTENANCE, "存储空间不足");
    public static final AMEError SERVICE_ID_NOT_FOUND = new AMEError("SERVICE_ID_NOT_FOUND", 8, AMapException.CODE_AMAP_ENGINE_TABLEID_NOT_EXIST, "向量 ID 不存在");
    public static final AMEError SERVICE_DIMENSION_MISMATCH = new AMEError("SERVICE_DIMENSION_MISMATCH", 9, 2004, "向量维度与引擎配置不一致");
    public static final AMEError SERVICE_INTERNAL_ERROR = new AMEError("SERVICE_INTERNAL_ERROR", 10, l.MAX_YEAR, "引擎内部错误");
    public static final AMEError VERSION_MISMATCH = new AMEError("VERSION_MISMATCH", 11, AMapException.CODE_AMAP_ROUTE_NO_ROADS_NEARBY, "SDK 与引擎协议版本不兼容");

    private static final /* synthetic */ AMEError[] $values() {
        return new AMEError[]{ARGS_DIMENSION_MISMATCH, ARGS_SIZE_MISMATCH, ARGS_EMPTY_INPUT, ARGS_INVALID_TOPK, ARGS_INVALID_PARAM, ARGS_NOT_CONNECTED, SERVICE_NOT_INITIALIZED, SERVICE_STORAGE_FULL, SERVICE_ID_NOT_FOUND, SERVICE_DIMENSION_MISMATCH, SERVICE_INTERNAL_ERROR, VERSION_MISMATCH};
    }

    static {
        AMEError[] aMEErrorArr$values = $values();
        $VALUES = aMEErrorArr$values;
        $ENTRIES = a.a(aMEErrorArr$values);
    }

    private AMEError(String str, int i10, int i11, String str2) {
        this.code = i11;
        this.desc = str2;
    }

    public static InterfaceC4149a<AMEError> getEntries() {
        return $ENTRIES;
    }

    public static AMEError valueOf(String str) {
        return (AMEError) Enum.valueOf(AMEError.class, str);
    }

    public static AMEError[] values() {
        return (AMEError[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDesc() {
        return this.desc;
    }
}
