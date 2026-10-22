package com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/viewmodel/PanelOperationState;", "", "UNKNOWN", "Add", "Remove", "Top", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelOperationState extends Enum<PanelOperationState> {
    public static final PanelOperationState Add = null;
    public static final PanelOperationState Remove = null;
    public static final PanelOperationState Top = null;
    public static final PanelOperationState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelOperationState[] f131116a = null;

    static {
        PanelOperationState r100 = new PanelOperationState("UNKNOWN", 0);
        UNKNOWN = r100;
        PanelOperationState r101 = new PanelOperationState("Add", 1);
        Add = r101;
        PanelOperationState r102 = new PanelOperationState("Remove", 2);
        Remove = r102;
        PanelOperationState r103 = new PanelOperationState("Top", 3);
        Top = r103;
        f131116a = new PanelOperationState[]{r100, r101, r102, r103};
    }

    public static PanelOperationState valueOf(String r100) {
        return (PanelOperationState) r27.a.a(PanelOperationState.class, r100);
    }

    public static PanelOperationState[] values() {
        return (PanelOperationState[]) f131116a.clone();
    }

    public PanelOperationState(String r100, int r101) {
        super(r100, r101);
    }
}
