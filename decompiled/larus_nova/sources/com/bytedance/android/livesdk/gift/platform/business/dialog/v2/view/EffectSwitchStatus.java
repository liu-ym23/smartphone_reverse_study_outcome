package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/EffectSwitchStatus;", "", "OPEN", "CLOSE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EffectSwitchStatus extends Enum<EffectSwitchStatus> {
    public static final EffectSwitchStatus CLOSE = null;
    public static final EffectSwitchStatus OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EffectSwitchStatus[] f126641a = null;

    static {
        EffectSwitchStatus r100 = new EffectSwitchStatus("OPEN", 0);
        OPEN = r100;
        EffectSwitchStatus r101 = new EffectSwitchStatus("CLOSE", 1);
        CLOSE = r101;
        f126641a = new EffectSwitchStatus[]{r100, r101};
    }

    public static EffectSwitchStatus valueOf(String r100) {
        return (EffectSwitchStatus) r27.a.a(EffectSwitchStatus.class, r100);
    }

    public static EffectSwitchStatus[] values() {
        return (EffectSwitchStatus[]) f126641a.clone();
    }

    public EffectSwitchStatus(String r100, int r101) {
        super(r100, r101);
    }
}
