package com.bytedance.android.livesdk.gift.platform.business.effect.service;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/EffectGameStatus;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "IDLE", "RUNNING", "SETTING", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EffectGameStatus extends Enum<EffectGameStatus> {
    public static final a Companion = null;
    public static final EffectGameStatus IDLE = null;
    public static final EffectGameStatus RUNNING = null;
    public static final EffectGameStatus SETTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EffectGameStatus[] f129516a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        EffectGameStatus r100 = new EffectGameStatus("IDLE", 0, 0);
        IDLE = r100;
        EffectGameStatus r101 = new EffectGameStatus("RUNNING", 1, 1);
        RUNNING = r101;
        EffectGameStatus r102 = new EffectGameStatus("SETTING", 2, 2);
        SETTING = r102;
        f129516a = new EffectGameStatus[]{r100, r101, r102};
        Companion = new a();
    }

    public static EffectGameStatus valueOf(String r100) {
        return (EffectGameStatus) r27.a.a(EffectGameStatus.class, r100);
    }

    public static EffectGameStatus[] values() {
        return (EffectGameStatus[]) f129516a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public EffectGameStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
