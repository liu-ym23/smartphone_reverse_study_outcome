package com.bytedance.android.livesdk.revenue.service.livecore;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/IInteractModeEnumParam;", "", "MULTI_ANCHOR", "PK", "GAME_AUDIO", EffectConstants.NORMAL, "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IInteractModeEnumParam extends Enum<IInteractModeEnumParam> {
    public static final IInteractModeEnumParam GAME_AUDIO = null;
    public static final IInteractModeEnumParam MULTI_ANCHOR = null;
    public static final IInteractModeEnumParam NORMAL = null;
    public static final IInteractModeEnumParam PK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IInteractModeEnumParam[] f157398a = null;

    static {
        IInteractModeEnumParam r100 = new IInteractModeEnumParam("MULTI_ANCHOR", 0);
        MULTI_ANCHOR = r100;
        IInteractModeEnumParam r101 = new IInteractModeEnumParam("PK", 1);
        PK = r101;
        IInteractModeEnumParam r102 = new IInteractModeEnumParam("GAME_AUDIO", 2);
        GAME_AUDIO = r102;
        IInteractModeEnumParam r103 = new IInteractModeEnumParam(EffectConstants.NORMAL, 3);
        NORMAL = r103;
        f157398a = new IInteractModeEnumParam[]{r100, r101, r102, r103};
    }

    public static IInteractModeEnumParam valueOf(String r100) {
        return (IInteractModeEnumParam) a.a(IInteractModeEnumParam.class, r100);
    }

    public static IInteractModeEnumParam[] values() {
        return (IInteractModeEnumParam[]) f157398a.clone();
    }

    public IInteractModeEnumParam(String r100, int r101) {
        super(r100, r101);
    }
}
