package com.bytedance.android.live.effect.beauty.presets;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/ApplyStatus;", "", "SUCCESS", "MODIFIED", "PANEL_LOAD_FAILED", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ApplyStatus extends Enum<ApplyStatus> {
    public static final ApplyStatus MODIFIED = null;
    public static final ApplyStatus PANEL_LOAD_FAILED = null;
    public static final ApplyStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ApplyStatus[] f67408a = null;

    static {
        ApplyStatus r100 = new ApplyStatus("SUCCESS", 0);
        SUCCESS = r100;
        ApplyStatus r101 = new ApplyStatus("MODIFIED", 1);
        MODIFIED = r101;
        ApplyStatus r102 = new ApplyStatus("PANEL_LOAD_FAILED", 2);
        PANEL_LOAD_FAILED = r102;
        f67408a = new ApplyStatus[]{r100, r101, r102};
    }

    public static ApplyStatus valueOf(String r100) {
        return (ApplyStatus) r27.a.a(ApplyStatus.class, r100);
    }

    public static ApplyStatus[] values() {
        return (ApplyStatus[]) f67408a.clone();
    }

    public ApplyStatus(String r100, int r101) {
        super(r100, r101);
    }
}
