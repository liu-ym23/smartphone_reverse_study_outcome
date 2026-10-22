package com.bytedance.android.live.livepkaudience.seat;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/seat/SeatAnimTaskState;", "", "IDLE", "LINK_SUC_ANIM", "DYNAMIC_EMOJI", "KTV_SINGER_ANIMA", "GUEST_BATTLE_ANIM", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SeatAnimTaskState extends Enum<SeatAnimTaskState> {
    public static final SeatAnimTaskState DYNAMIC_EMOJI = null;
    public static final SeatAnimTaskState GUEST_BATTLE_ANIM = null;
    public static final SeatAnimTaskState IDLE = null;
    public static final SeatAnimTaskState KTV_SINGER_ANIMA = null;
    public static final SeatAnimTaskState LINK_SUC_ANIM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SeatAnimTaskState[] f82234a = null;

    static {
        SeatAnimTaskState r100 = new SeatAnimTaskState("IDLE", 0);
        IDLE = r100;
        SeatAnimTaskState r101 = new SeatAnimTaskState("LINK_SUC_ANIM", 1);
        LINK_SUC_ANIM = r101;
        SeatAnimTaskState r102 = new SeatAnimTaskState("DYNAMIC_EMOJI", 2);
        DYNAMIC_EMOJI = r102;
        SeatAnimTaskState r103 = new SeatAnimTaskState("KTV_SINGER_ANIMA", 3);
        KTV_SINGER_ANIMA = r103;
        SeatAnimTaskState r104 = new SeatAnimTaskState("GUEST_BATTLE_ANIM", 4);
        GUEST_BATTLE_ANIM = r104;
        f82234a = new SeatAnimTaskState[]{r100, r101, r102, r103, r104};
    }

    public static SeatAnimTaskState valueOf(String r100) {
        return (SeatAnimTaskState) r27.a.a(SeatAnimTaskState.class, r100);
    }

    public static SeatAnimTaskState[] values() {
        return (SeatAnimTaskState[]) f82234a.clone();
    }

    public SeatAnimTaskState(String r100, int r101) {
        super(r100, r101);
    }
}
