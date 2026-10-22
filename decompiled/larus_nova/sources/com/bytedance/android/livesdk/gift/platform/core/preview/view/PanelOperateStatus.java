package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/PanelOperateStatus;", "", "Idle", "Operate", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelOperateStatus extends Enum<PanelOperateStatus> {
    public static final PanelOperateStatus Idle = null;
    public static final PanelOperateStatus Operate = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelOperateStatus[] f131016a = null;

    static {
        PanelOperateStatus r100 = new PanelOperateStatus("Idle", 0);
        Idle = r100;
        PanelOperateStatus r101 = new PanelOperateStatus("Operate", 1);
        Operate = r101;
        f131016a = new PanelOperateStatus[]{r100, r101};
    }

    public static PanelOperateStatus valueOf(String r100) {
        return (PanelOperateStatus) r27.a.a(PanelOperateStatus.class, r100);
    }

    public static PanelOperateStatus[] values() {
        return (PanelOperateStatus[]) f131016a.clone();
    }

    public PanelOperateStatus(String r100, int r101) {
        super(r100, r101);
    }
}
