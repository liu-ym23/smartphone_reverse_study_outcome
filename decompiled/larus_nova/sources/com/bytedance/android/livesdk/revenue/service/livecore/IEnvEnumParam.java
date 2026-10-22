package com.bytedance.android.livesdk.revenue.service.livecore;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/IEnvEnumParam;", "", "ENV_BOE", "ENV_PRODUCT", "ENV_TEST", "live-kmp-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IEnvEnumParam extends Enum<IEnvEnumParam> {
    public static final IEnvEnumParam ENV_BOE = null;
    public static final IEnvEnumParam ENV_PRODUCT = null;
    public static final IEnvEnumParam ENV_TEST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IEnvEnumParam[] f157397a = null;

    static {
        IEnvEnumParam r100 = new IEnvEnumParam("ENV_BOE", 0);
        ENV_BOE = r100;
        IEnvEnumParam r101 = new IEnvEnumParam("ENV_PRODUCT", 1);
        ENV_PRODUCT = r101;
        IEnvEnumParam r102 = new IEnvEnumParam("ENV_TEST", 2);
        ENV_TEST = r102;
        f157397a = new IEnvEnumParam[]{r100, r101, r102};
    }

    public static IEnvEnumParam valueOf(String r100) {
        return (IEnvEnumParam) a.a(IEnvEnumParam.class, r100);
    }

    public static IEnvEnumParam[] values() {
        return (IEnvEnumParam[]) f157397a.clone();
    }

    public IEnvEnumParam(String r100, int r101) {
        super(r100, r101);
    }
}
