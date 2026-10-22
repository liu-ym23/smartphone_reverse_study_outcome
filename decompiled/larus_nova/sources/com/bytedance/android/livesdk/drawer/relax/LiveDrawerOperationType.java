package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerOperationType;", "", "", "value", "I", "getValue", "()I", "BANNER", "SINGLE_LIVE", "POLY_LIVE", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerOperationType extends Enum<LiveDrawerOperationType> {
    public static final LiveDrawerOperationType BANNER = null;
    public static final LiveDrawerOperationType POLY_LIVE = null;
    public static final LiveDrawerOperationType SINGLE_LIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveDrawerOperationType[] f122504a = null;
    private final int value;

    static {
        LiveDrawerOperationType r100 = new LiveDrawerOperationType("BANNER", 0, 1);
        BANNER = r100;
        LiveDrawerOperationType r101 = new LiveDrawerOperationType("SINGLE_LIVE", 1, 2);
        SINGLE_LIVE = r101;
        LiveDrawerOperationType r102 = new LiveDrawerOperationType("POLY_LIVE", 2, 3);
        POLY_LIVE = r102;
        f122504a = new LiveDrawerOperationType[]{r100, r101, r102};
    }

    public static LiveDrawerOperationType valueOf(String r100) {
        return (LiveDrawerOperationType) r27.a.a(LiveDrawerOperationType.class, r100);
    }

    public static LiveDrawerOperationType[] values() {
        return (LiveDrawerOperationType[]) f122504a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveDrawerOperationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
