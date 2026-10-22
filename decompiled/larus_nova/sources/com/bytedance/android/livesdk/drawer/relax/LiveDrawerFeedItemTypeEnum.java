package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b!\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerFeedItemTypeEnum;", "", "", "value", "J", "getValue", "()J", "TypeUnknown", "TypeLiveRoom", "TypeFollowRoom", "TypeAdData", "TypeSmallLive", "TypeBigLive", "TypeBanner", "TypeRankRound", "TypeCategory", "TypeScheduledLive", "TypeTab", "TypePlaceHolder", "TypeUserLiveRecord", "TypeNotice", "TypeVSLive", "TypeVSFirstLive", "TypeVSRecord", "TypeToBLive", "TypeToBFollowTop", "TypeReserveProgram", "TypeInterestExploreCard", "TypeFeedbackCard", "TypeAntiAddictionCard", "TypeOperationBanner", "TypeOperationCard", "TypeAnnouncement", "TypePaidLiveCard", "TypeMultiCamera", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerFeedItemTypeEnum extends Enum<LiveDrawerFeedItemTypeEnum> {
    public static final LiveDrawerFeedItemTypeEnum TypeAdData = null;
    public static final LiveDrawerFeedItemTypeEnum TypeAnnouncement = null;
    public static final LiveDrawerFeedItemTypeEnum TypeAntiAddictionCard = null;
    public static final LiveDrawerFeedItemTypeEnum TypeBanner = null;
    public static final LiveDrawerFeedItemTypeEnum TypeBigLive = null;
    public static final LiveDrawerFeedItemTypeEnum TypeCategory = null;
    public static final LiveDrawerFeedItemTypeEnum TypeFeedbackCard = null;
    public static final LiveDrawerFeedItemTypeEnum TypeFollowRoom = null;
    public static final LiveDrawerFeedItemTypeEnum TypeInterestExploreCard = null;
    public static final LiveDrawerFeedItemTypeEnum TypeLiveRoom = null;
    public static final LiveDrawerFeedItemTypeEnum TypeMultiCamera = null;
    public static final LiveDrawerFeedItemTypeEnum TypeNotice = null;
    public static final LiveDrawerFeedItemTypeEnum TypeOperationBanner = null;
    public static final LiveDrawerFeedItemTypeEnum TypeOperationCard = null;
    public static final LiveDrawerFeedItemTypeEnum TypePaidLiveCard = null;
    public static final LiveDrawerFeedItemTypeEnum TypePlaceHolder = null;
    public static final LiveDrawerFeedItemTypeEnum TypeRankRound = null;
    public static final LiveDrawerFeedItemTypeEnum TypeReserveProgram = null;
    public static final LiveDrawerFeedItemTypeEnum TypeScheduledLive = null;
    public static final LiveDrawerFeedItemTypeEnum TypeSmallLive = null;
    public static final LiveDrawerFeedItemTypeEnum TypeTab = null;
    public static final LiveDrawerFeedItemTypeEnum TypeToBFollowTop = null;
    public static final LiveDrawerFeedItemTypeEnum TypeToBLive = null;
    public static final LiveDrawerFeedItemTypeEnum TypeUnknown = null;
    public static final LiveDrawerFeedItemTypeEnum TypeUserLiveRecord = null;
    public static final LiveDrawerFeedItemTypeEnum TypeVSFirstLive = null;
    public static final LiveDrawerFeedItemTypeEnum TypeVSLive = null;
    public static final LiveDrawerFeedItemTypeEnum TypeVSRecord = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveDrawerFeedItemTypeEnum[] f122493a = null;
    private final long value;

    public static LiveDrawerFeedItemTypeEnum valueOf(String r100) {
        return (LiveDrawerFeedItemTypeEnum) r27.a.a(LiveDrawerFeedItemTypeEnum.class, r100);
    }

    public static LiveDrawerFeedItemTypeEnum[] values() {
        return (LiveDrawerFeedItemTypeEnum[]) f122493a.clone();
    }

    static {
        LiveDrawerFeedItemTypeEnum r100 = new LiveDrawerFeedItemTypeEnum("TypeUnknown", 0, 0);
        TypeUnknown = r100;
        LiveDrawerFeedItemTypeEnum r101 = new LiveDrawerFeedItemTypeEnum("TypeLiveRoom", 1, 1);
        TypeLiveRoom = r101;
        LiveDrawerFeedItemTypeEnum r102 = new LiveDrawerFeedItemTypeEnum("TypeFollowRoom", 2, 2);
        TypeFollowRoom = r102;
        LiveDrawerFeedItemTypeEnum r103 = new LiveDrawerFeedItemTypeEnum("TypeAdData", 3, 3);
        TypeAdData = r103;
        LiveDrawerFeedItemTypeEnum r104 = new LiveDrawerFeedItemTypeEnum("TypeSmallLive", 4, 4);
        TypeSmallLive = r104;
        LiveDrawerFeedItemTypeEnum r105 = new LiveDrawerFeedItemTypeEnum("TypeBigLive", 5, 5);
        TypeBigLive = r105;
        LiveDrawerFeedItemTypeEnum r106 = new LiveDrawerFeedItemTypeEnum("TypeBanner", 6, 6);
        TypeBanner = r106;
        LiveDrawerFeedItemTypeEnum r107 = new LiveDrawerFeedItemTypeEnum("TypeRankRound", 7, 7);
        TypeRankRound = r107;
        LiveDrawerFeedItemTypeEnum r108 = new LiveDrawerFeedItemTypeEnum("TypeCategory", 8, 8);
        TypeCategory = r108;
        LiveDrawerFeedItemTypeEnum r109 = new LiveDrawerFeedItemTypeEnum("TypeScheduledLive", 9, 9);
        TypeScheduledLive = r109;
        LiveDrawerFeedItemTypeEnum r110 = new LiveDrawerFeedItemTypeEnum("TypeTab", 10, 10);
        TypeTab = r110;
        LiveDrawerFeedItemTypeEnum r111 = new LiveDrawerFeedItemTypeEnum("TypePlaceHolder", 11, 11);
        TypePlaceHolder = r111;
        LiveDrawerFeedItemTypeEnum r112 = new LiveDrawerFeedItemTypeEnum("TypeUserLiveRecord", 12, 12);
        TypeUserLiveRecord = r112;
        LiveDrawerFeedItemTypeEnum r113 = new LiveDrawerFeedItemTypeEnum("TypeNotice", 13, 13);
        TypeNotice = r113;
        LiveDrawerFeedItemTypeEnum r114 = new LiveDrawerFeedItemTypeEnum("TypeVSLive", 14, 14);
        TypeVSLive = r114;
        LiveDrawerFeedItemTypeEnum r115 = new LiveDrawerFeedItemTypeEnum("TypeVSFirstLive", 15, 15);
        TypeVSFirstLive = r115;
        LiveDrawerFeedItemTypeEnum r116 = new LiveDrawerFeedItemTypeEnum("TypeVSRecord", 16, 16);
        TypeVSRecord = r116;
        LiveDrawerFeedItemTypeEnum r117 = new LiveDrawerFeedItemTypeEnum("TypeToBLive", 17, 17);
        TypeToBLive = r117;
        LiveDrawerFeedItemTypeEnum r118 = new LiveDrawerFeedItemTypeEnum("TypeToBFollowTop", 18, 18);
        TypeToBFollowTop = r118;
        LiveDrawerFeedItemTypeEnum r119 = new LiveDrawerFeedItemTypeEnum("TypeReserveProgram", 19, 19);
        TypeReserveProgram = r119;
        LiveDrawerFeedItemTypeEnum r120 = new LiveDrawerFeedItemTypeEnum("TypeInterestExploreCard", 20, 20);
        TypeInterestExploreCard = r120;
        LiveDrawerFeedItemTypeEnum r121 = new LiveDrawerFeedItemTypeEnum("TypeFeedbackCard", 21, 21);
        TypeFeedbackCard = r121;
        LiveDrawerFeedItemTypeEnum r122 = new LiveDrawerFeedItemTypeEnum("TypeAntiAddictionCard", 22, 22);
        TypeAntiAddictionCard = r122;
        LiveDrawerFeedItemTypeEnum r123 = new LiveDrawerFeedItemTypeEnum("TypeOperationBanner", 23, 23);
        TypeOperationBanner = r123;
        LiveDrawerFeedItemTypeEnum r124 = new LiveDrawerFeedItemTypeEnum("TypeOperationCard", 24, 24);
        TypeOperationCard = r124;
        LiveDrawerFeedItemTypeEnum r125 = new LiveDrawerFeedItemTypeEnum("TypeAnnouncement", 25, 25);
        TypeAnnouncement = r125;
        LiveDrawerFeedItemTypeEnum r126 = new LiveDrawerFeedItemTypeEnum("TypePaidLiveCard", 26, 26);
        TypePaidLiveCard = r126;
        LiveDrawerFeedItemTypeEnum r127 = new LiveDrawerFeedItemTypeEnum("TypeMultiCamera", 27, 27);
        TypeMultiCamera = r127;
        f122493a = new LiveDrawerFeedItemTypeEnum[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
    }

    public final long getValue() {
        return this.value;
    }

    public LiveDrawerFeedItemTypeEnum(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
