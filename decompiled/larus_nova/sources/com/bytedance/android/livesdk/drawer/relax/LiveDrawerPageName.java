package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerPageName;", "", "", "value", "I", "getValue", "()I", "NoLogin", "NoData", "NoAccess", "HaveData", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerPageName extends Enum<LiveDrawerPageName> {
    public static final LiveDrawerPageName HaveData = null;
    public static final LiveDrawerPageName NoAccess = null;
    public static final LiveDrawerPageName NoData = null;
    public static final LiveDrawerPageName NoLogin = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveDrawerPageName[] f122505a = null;
    private final int value;

    static {
        LiveDrawerPageName r100 = new LiveDrawerPageName("NoLogin", 0, 0);
        NoLogin = r100;
        LiveDrawerPageName r101 = new LiveDrawerPageName("NoData", 1, 1);
        NoData = r101;
        LiveDrawerPageName r102 = new LiveDrawerPageName("NoAccess", 2, 2);
        NoAccess = r102;
        LiveDrawerPageName r103 = new LiveDrawerPageName("HaveData", 3, 3);
        HaveData = r103;
        f122505a = new LiveDrawerPageName[]{r100, r101, r102, r103};
    }

    public static LiveDrawerPageName valueOf(String r100) {
        return (LiveDrawerPageName) r27.a.a(LiveDrawerPageName.class, r100);
    }

    public static LiveDrawerPageName[] values() {
        return (LiveDrawerPageName[]) f122505a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveDrawerPageName(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
