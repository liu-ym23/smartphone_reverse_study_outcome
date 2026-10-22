package com.bytedance.android.livesdk.revenue.service.livecore;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/ICharacterEnumParam;", "", FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, "GUEST", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ICharacterEnumParam extends Enum<ICharacterEnumParam> {
    public static final ICharacterEnumParam ANCHOR = null;
    public static final ICharacterEnumParam GUEST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ICharacterEnumParam[] f157367a = null;

    static {
        ICharacterEnumParam r100 = new ICharacterEnumParam(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, 0);
        ANCHOR = r100;
        ICharacterEnumParam r101 = new ICharacterEnumParam("GUEST", 1);
        GUEST = r101;
        f157367a = new ICharacterEnumParam[]{r100, r101};
    }

    public static ICharacterEnumParam valueOf(String r100) {
        return (ICharacterEnumParam) a.a(ICharacterEnumParam.class, r100);
    }

    public static ICharacterEnumParam[] values() {
        return (ICharacterEnumParam[]) f157367a.clone();
    }

    public ICharacterEnumParam(String r100, int r101) {
        super(r100, r101);
    }
}
