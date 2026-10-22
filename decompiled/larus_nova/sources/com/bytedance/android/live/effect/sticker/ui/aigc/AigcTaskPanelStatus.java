package com.bytedance.android.live.effect.sticker.ui.aigc;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/aigc/AigcTaskPanelStatus;", "", "Default", "Ready", "Running", "Done", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AigcTaskPanelStatus extends Enum<AigcTaskPanelStatus> {
    public static final AigcTaskPanelStatus Default = null;
    public static final AigcTaskPanelStatus Done = null;
    public static final AigcTaskPanelStatus Ready = null;
    public static final AigcTaskPanelStatus Running = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AigcTaskPanelStatus[] f68526a = null;

    static {
        AigcTaskPanelStatus r100 = new AigcTaskPanelStatus("Default", 0);
        Default = r100;
        AigcTaskPanelStatus r101 = new AigcTaskPanelStatus("Ready", 1);
        Ready = r101;
        AigcTaskPanelStatus r102 = new AigcTaskPanelStatus("Running", 2);
        Running = r102;
        AigcTaskPanelStatus r103 = new AigcTaskPanelStatus("Done", 3);
        Done = r103;
        f68526a = new AigcTaskPanelStatus[]{r100, r101, r102, r103};
    }

    public static AigcTaskPanelStatus valueOf(String r100) {
        return (AigcTaskPanelStatus) r27.a.a(AigcTaskPanelStatus.class, r100);
    }

    public static AigcTaskPanelStatus[] values() {
        return (AigcTaskPanelStatus[]) f68526a.clone();
    }

    public AigcTaskPanelStatus(String r100, int r101) {
        super(r100, r101);
    }
}
