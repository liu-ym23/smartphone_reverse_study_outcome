package com.bytedance.android.livesdk.revenue.service.livecore;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/IMixStreamTypeEnumParam;", "", "SERVER_MIX", "CLIENT_MIX", "RTC_CLIENT_MIX", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IMixStreamTypeEnumParam extends Enum<IMixStreamTypeEnumParam> {
    public static final IMixStreamTypeEnumParam CLIENT_MIX = null;
    public static final IMixStreamTypeEnumParam RTC_CLIENT_MIX = null;
    public static final IMixStreamTypeEnumParam SERVER_MIX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IMixStreamTypeEnumParam[] f157400a = null;

    static {
        IMixStreamTypeEnumParam r100 = new IMixStreamTypeEnumParam("SERVER_MIX", 0);
        SERVER_MIX = r100;
        IMixStreamTypeEnumParam r101 = new IMixStreamTypeEnumParam("CLIENT_MIX", 1);
        CLIENT_MIX = r101;
        IMixStreamTypeEnumParam r102 = new IMixStreamTypeEnumParam("RTC_CLIENT_MIX", 2);
        RTC_CLIENT_MIX = r102;
        f157400a = new IMixStreamTypeEnumParam[]{r100, r101, r102};
    }

    public static IMixStreamTypeEnumParam valueOf(String r100) {
        return (IMixStreamTypeEnumParam) a.a(IMixStreamTypeEnumParam.class, r100);
    }

    public static IMixStreamTypeEnumParam[] values() {
        return (IMixStreamTypeEnumParam[]) f157400a.clone();
    }

    public IMixStreamTypeEnumParam(String r100, int r101) {
        super(r100, r101);
    }
}
