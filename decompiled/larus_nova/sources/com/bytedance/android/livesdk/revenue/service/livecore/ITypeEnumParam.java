package com.bytedance.android.livesdk.revenue.service.livecore;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/ITypeEnumParam;", "", "AUDIO", "VIDEO", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ITypeEnumParam extends Enum<ITypeEnumParam> {
    public static final ITypeEnumParam AUDIO = null;
    public static final ITypeEnumParam VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ITypeEnumParam[] f157403a = null;

    static {
        ITypeEnumParam r100 = new ITypeEnumParam("AUDIO", 0);
        AUDIO = r100;
        ITypeEnumParam r101 = new ITypeEnumParam("VIDEO", 1);
        VIDEO = r101;
        f157403a = new ITypeEnumParam[]{r100, r101};
    }

    public static ITypeEnumParam valueOf(String r100) {
        return (ITypeEnumParam) a.a(ITypeEnumParam.class, r100);
    }

    public static ITypeEnumParam[] values() {
        return (ITypeEnumParam[]) f157403a.clone();
    }

    public ITypeEnumParam(String r100, int r101) {
        super(r100, r101);
    }
}
