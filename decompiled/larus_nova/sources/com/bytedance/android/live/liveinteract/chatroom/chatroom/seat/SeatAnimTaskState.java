package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/SeatAnimTaskState;", "", "IDLE", "LINK_SUC_ANIM", "DYNAMIC_EMOJI", "KTV_SINGER_ANIMA", "REVENUE_DRESS_ANIM", "THEMED_COMPETITION_ANIM", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SeatAnimTaskState extends Enum<SeatAnimTaskState> {
    public static final SeatAnimTaskState DYNAMIC_EMOJI = null;
    public static final SeatAnimTaskState IDLE = null;
    public static final SeatAnimTaskState KTV_SINGER_ANIMA = null;
    public static final SeatAnimTaskState LINK_SUC_ANIM = null;
    public static final SeatAnimTaskState REVENUE_DRESS_ANIM = null;
    public static final SeatAnimTaskState THEMED_COMPETITION_ANIM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SeatAnimTaskState[] f72209a = null;

    static {
        SeatAnimTaskState r100 = new SeatAnimTaskState("IDLE", 0);
        IDLE = r100;
        SeatAnimTaskState r101 = new SeatAnimTaskState("LINK_SUC_ANIM", 1);
        LINK_SUC_ANIM = r101;
        SeatAnimTaskState r102 = new SeatAnimTaskState("DYNAMIC_EMOJI", 2);
        DYNAMIC_EMOJI = r102;
        SeatAnimTaskState r103 = new SeatAnimTaskState("KTV_SINGER_ANIMA", 3);
        KTV_SINGER_ANIMA = r103;
        SeatAnimTaskState r104 = new SeatAnimTaskState("REVENUE_DRESS_ANIM", 4);
        REVENUE_DRESS_ANIM = r104;
        SeatAnimTaskState r105 = new SeatAnimTaskState("THEMED_COMPETITION_ANIM", 5);
        THEMED_COMPETITION_ANIM = r105;
        f72209a = new SeatAnimTaskState[]{r100, r101, r102, r103, r104, r105};
    }

    public static SeatAnimTaskState valueOf(String r100) {
        return (SeatAnimTaskState) r27.a.a(SeatAnimTaskState.class, r100);
    }

    public static SeatAnimTaskState[] values() {
        return (SeatAnimTaskState[]) f72209a.clone();
    }

    public SeatAnimTaskState(String r100, int r101) {
        super(r100, r101);
    }
}
