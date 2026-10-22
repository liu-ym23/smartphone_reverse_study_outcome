package com.bytedance.android.livesdk.revenue.service.livecore.main;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/main/IRTCStreamIndexEnumParam;", "", "STREAM_INDEX_MAIN", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IRTCStreamIndexEnumParam extends Enum<IRTCStreamIndexEnumParam> {
    public static final IRTCStreamIndexEnumParam STREAM_INDEX_MAIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IRTCStreamIndexEnumParam[] f157406a = null;

    static {
        IRTCStreamIndexEnumParam r100 = new IRTCStreamIndexEnumParam();
        STREAM_INDEX_MAIN = r100;
        f157406a = new IRTCStreamIndexEnumParam[]{r100};
    }

    public static IRTCStreamIndexEnumParam valueOf(String r100) {
        return (IRTCStreamIndexEnumParam) a.a(IRTCStreamIndexEnumParam.class, r100);
    }

    public static IRTCStreamIndexEnumParam[] values() {
        return (IRTCStreamIndexEnumParam[]) f157406a.clone();
    }

    public IRTCStreamIndexEnumParam() {
        super("STREAM_INDEX_MAIN", 0);
    }
}
