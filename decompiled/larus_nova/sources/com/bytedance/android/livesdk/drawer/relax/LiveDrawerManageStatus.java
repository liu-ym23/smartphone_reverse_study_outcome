package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerManageStatus;", "", "", "value", "I", "getValue", "()I", "ManageNotStart", "ManageReady", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerManageStatus extends Enum<LiveDrawerManageStatus> {
    public static final LiveDrawerManageStatus ManageNotStart = null;
    public static final LiveDrawerManageStatus ManageReady = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveDrawerManageStatus[] f122503a = null;
    private final int value;

    static {
        LiveDrawerManageStatus r100 = new LiveDrawerManageStatus("ManageNotStart", 0, 0);
        ManageNotStart = r100;
        LiveDrawerManageStatus r101 = new LiveDrawerManageStatus("ManageReady", 1, 1);
        ManageReady = r101;
        f122503a = new LiveDrawerManageStatus[]{r100, r101};
    }

    public static LiveDrawerManageStatus valueOf(String r100) {
        return (LiveDrawerManageStatus) r27.a.a(LiveDrawerManageStatus.class, r100);
    }

    public static LiveDrawerManageStatus[] values() {
        return (LiveDrawerManageStatus[]) f122503a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveDrawerManageStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
