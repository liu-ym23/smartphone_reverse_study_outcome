package com.bytedance.android.live.revlink.link.domain.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/link/domain/service/MicStage;", "", "Idle", "Reuse", "NewCreated", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MicStage extends Enum<MicStage> {
    public static final MicStage Idle = null;
    public static final MicStage NewCreated = null;
    public static final MicStage Reuse = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MicStage[] f98484a = null;

    static {
        MicStage r100 = new MicStage("Idle", 0);
        Idle = r100;
        MicStage r101 = new MicStage("Reuse", 1);
        Reuse = r101;
        MicStage r102 = new MicStage("NewCreated", 2);
        NewCreated = r102;
        f98484a = new MicStage[]{r100, r101, r102};
    }

    public static MicStage valueOf(String r100) {
        return (MicStage) r27.a.a(MicStage.class, r100);
    }

    public static MicStage[] values() {
        return (MicStage[]) f98484a.clone();
    }

    public MicStage(String r100, int r101) {
        super(r100, r101);
    }
}
