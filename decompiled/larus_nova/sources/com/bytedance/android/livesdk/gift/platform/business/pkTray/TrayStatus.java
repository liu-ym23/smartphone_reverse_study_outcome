package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/pkTray/TrayStatus;", "", "Idle", "Busy", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TrayStatus extends Enum<TrayStatus> {
    public static final TrayStatus Busy = null;
    public static final TrayStatus Idle = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TrayStatus[] f130033a = null;

    static {
        TrayStatus r100 = new TrayStatus("Idle", 0);
        Idle = r100;
        TrayStatus r101 = new TrayStatus("Busy", 1);
        Busy = r101;
        f130033a = new TrayStatus[]{r100, r101};
    }

    public static TrayStatus valueOf(String r100) {
        return (TrayStatus) r27.a.a(TrayStatus.class, r100);
    }

    public static TrayStatus[] values() {
        return (TrayStatus[]) f130033a.clone();
    }

    public TrayStatus(String r100, int r101) {
        super(r100, r101);
    }
}
