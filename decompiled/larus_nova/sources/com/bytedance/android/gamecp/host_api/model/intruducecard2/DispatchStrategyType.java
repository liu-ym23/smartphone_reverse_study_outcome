package com.bytedance.android.gamecp.host_api.model.intruducecard2;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/intruducecard2/DispatchStrategyType;", "", "", "type", "I", "getType", "()I", EffectConstants.NORMAL, "RANDOM", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DispatchStrategyType extends Enum<DispatchStrategyType> {
    public static final DispatchStrategyType NORMAL = null;
    public static final DispatchStrategyType RANDOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DispatchStrategyType[] f57394a = null;
    private final int type;

    static {
        DispatchStrategyType r100 = new DispatchStrategyType(EffectConstants.NORMAL, 0, 1);
        NORMAL = r100;
        DispatchStrategyType r101 = new DispatchStrategyType("RANDOM", 1, 2);
        RANDOM = r101;
        f57394a = new DispatchStrategyType[]{r100, r101};
    }

    public static DispatchStrategyType valueOf(String r100) {
        return (DispatchStrategyType) r27.a.a(DispatchStrategyType.class, r100);
    }

    public static DispatchStrategyType[] values() {
        return (DispatchStrategyType[]) f57394a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public DispatchStrategyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
