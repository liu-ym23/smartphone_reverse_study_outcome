package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerHistoryClickType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "WATCHLIVE", "PERSONALDETAIL", "FOLLOW", "UNFOLLOW", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerHistoryClickType extends Enum<LiveDrawerHistoryClickType> {
    public static final LiveDrawerHistoryClickType FOLLOW = null;
    public static final LiveDrawerHistoryClickType PERSONALDETAIL = null;
    public static final LiveDrawerHistoryClickType UNFOLLOW = null;
    public static final LiveDrawerHistoryClickType WATCHLIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveDrawerHistoryClickType[] f122495a = null;
    private final String value;

    static {
        LiveDrawerHistoryClickType r100 = new LiveDrawerHistoryClickType("WATCHLIVE", 0, "watch_live");
        WATCHLIVE = r100;
        LiveDrawerHistoryClickType r101 = new LiveDrawerHistoryClickType("PERSONALDETAIL", 1, "personal_detail");
        PERSONALDETAIL = r101;
        LiveDrawerHistoryClickType r102 = new LiveDrawerHistoryClickType("FOLLOW", 2, "follow");
        FOLLOW = r102;
        LiveDrawerHistoryClickType r103 = new LiveDrawerHistoryClickType("UNFOLLOW", 3, "unfollow");
        UNFOLLOW = r103;
        f122495a = new LiveDrawerHistoryClickType[]{r100, r101, r102, r103};
    }

    public static LiveDrawerHistoryClickType valueOf(String r100) {
        return (LiveDrawerHistoryClickType) r27.a.a(LiveDrawerHistoryClickType.class, r100);
    }

    public static LiveDrawerHistoryClickType[] values() {
        return (LiveDrawerHistoryClickType[]) f122495a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public LiveDrawerHistoryClickType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
