package com.bytedance.android.livesdk.interactivity.api.entity;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/entity/PSMessageHeatState;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "HOT", EffectConstants.NORMAL, "COLD", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSMessageHeatState extends Enum<PSMessageHeatState> {
    public static final PSMessageHeatState COLD = null;
    public static final a Companion = null;
    public static final PSMessageHeatState HOT = null;
    public static final PSMessageHeatState NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PSMessageHeatState[] f133130a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        PSMessageHeatState r100 = new PSMessageHeatState("HOT", 0, 3);
        HOT = r100;
        PSMessageHeatState r101 = new PSMessageHeatState(EffectConstants.NORMAL, 1, 2);
        NORMAL = r101;
        PSMessageHeatState r102 = new PSMessageHeatState("COLD", 2, 1);
        COLD = r102;
        f133130a = new PSMessageHeatState[]{r100, r101, r102};
        Companion = new a();
    }

    public static PSMessageHeatState valueOf(String r100) {
        return (PSMessageHeatState) r27.a.a(PSMessageHeatState.class, r100);
    }

    public static PSMessageHeatState[] values() {
        return (PSMessageHeatState[]) f133130a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PSMessageHeatState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
