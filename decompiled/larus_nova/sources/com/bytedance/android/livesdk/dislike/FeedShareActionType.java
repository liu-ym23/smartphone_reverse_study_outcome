package com.bytedance.android.livesdk.dislike;

/* JADX INFO: loaded from: classes8.dex */
final enum FeedShareActionType extends Enum<FeedShareActionType> {
    public static final FeedShareActionType AFTER_DISLIKE = null;
    public static final FeedShareActionType AFTER_FOLLOW = null;
    public static final FeedShareActionType AFTER_REPORT = null;
    public static final FeedShareActionType UNSUPPORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedShareActionType[] f122003a = null;
    public int value;

    static {
        FeedShareActionType r100 = new FeedShareActionType("UNSUPPORT", 0, 0);
        UNSUPPORT = r100;
        FeedShareActionType r101 = new FeedShareActionType("AFTER_DISLIKE", 1, 1);
        AFTER_DISLIKE = r101;
        FeedShareActionType r102 = new FeedShareActionType("AFTER_FOLLOW", 2, 2);
        AFTER_FOLLOW = r102;
        FeedShareActionType r103 = new FeedShareActionType("AFTER_REPORT", 3, 3);
        AFTER_REPORT = r103;
        f122003a = new FeedShareActionType[]{r100, r101, r102, r103};
    }

    public static FeedShareActionType[] values() {
        return (FeedShareActionType[]) f122003a.clone();
    }

    public static FeedShareActionType valueOf(String r100) {
        return (FeedShareActionType) r27.a.a(FeedShareActionType.class, r100);
    }

    public FeedShareActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
