package com.bytedance.android.livesdk.chatroom.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/AnchorTagType;", "", "", "value", "I", "getValue", "()I", "Unknown", "RedPackage", "MutualWithAnchor", "FollowAnchor", "MutualWithGuest", "FollowGuest", "MutualIsWatching", "MutualWatched", "SameCityWithAnchor", "Last7DayLinked", "Last7DayWatched", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnchorTagType extends Enum<AnchorTagType> {
    public static final AnchorTagType FollowAnchor = null;
    public static final AnchorTagType FollowGuest = null;
    public static final AnchorTagType Last7DayLinked = null;
    public static final AnchorTagType Last7DayWatched = null;
    public static final AnchorTagType MutualIsWatching = null;
    public static final AnchorTagType MutualWatched = null;
    public static final AnchorTagType MutualWithAnchor = null;
    public static final AnchorTagType MutualWithGuest = null;
    public static final AnchorTagType RedPackage = null;
    public static final AnchorTagType SameCityWithAnchor = null;
    public static final AnchorTagType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnchorTagType[] f106887a = null;
    private final int value;

    public static AnchorTagType valueOf(String r100) {
        return (AnchorTagType) r27.a.a(AnchorTagType.class, r100);
    }

    public static AnchorTagType[] values() {
        return (AnchorTagType[]) f106887a.clone();
    }

    static {
        AnchorTagType r100 = new AnchorTagType("Unknown", 0, 0);
        Unknown = r100;
        AnchorTagType r101 = new AnchorTagType("RedPackage", 1, 1);
        RedPackage = r101;
        AnchorTagType r102 = new AnchorTagType("MutualWithAnchor", 2, 2);
        MutualWithAnchor = r102;
        AnchorTagType r103 = new AnchorTagType("FollowAnchor", 3, 3);
        FollowAnchor = r103;
        AnchorTagType r104 = new AnchorTagType("MutualWithGuest", 4, 4);
        MutualWithGuest = r104;
        AnchorTagType r105 = new AnchorTagType("FollowGuest", 5, 5);
        FollowGuest = r105;
        AnchorTagType r106 = new AnchorTagType("MutualIsWatching", 6, 6);
        MutualIsWatching = r106;
        AnchorTagType r107 = new AnchorTagType("MutualWatched", 7, 7);
        MutualWatched = r107;
        AnchorTagType r108 = new AnchorTagType("SameCityWithAnchor", 8, 8);
        SameCityWithAnchor = r108;
        AnchorTagType r109 = new AnchorTagType("Last7DayLinked", 9, 9);
        Last7DayLinked = r109;
        AnchorTagType r110 = new AnchorTagType("Last7DayWatched", 10, 10);
        Last7DayWatched = r110;
        f106887a = new AnchorTagType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final int getValue() {
        return this.value;
    }

    public AnchorTagType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
