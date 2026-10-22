package com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/widget/entrance/mvistate/EntranceAnimState;", "", UserProfileEvent.POSITION_NONE, "FOLLOWED_TICKING", "FOLLOWED_HIDING", "FOLLOWED_SHOWING", "ACTIVATED_HIDING", "ACTIVATED_SHOWING", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EntranceAnimState extends Enum<EntranceAnimState> {
    public static final EntranceAnimState ACTIVATED_HIDING = null;
    public static final EntranceAnimState ACTIVATED_SHOWING = null;
    public static final EntranceAnimState FOLLOWED_HIDING = null;
    public static final EntranceAnimState FOLLOWED_SHOWING = null;
    public static final EntranceAnimState FOLLOWED_TICKING = null;
    public static final EntranceAnimState NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntranceAnimState[] f87418a = null;

    static {
        EntranceAnimState r100 = new EntranceAnimState(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        EntranceAnimState r101 = new EntranceAnimState("FOLLOWED_TICKING", 1);
        FOLLOWED_TICKING = r101;
        EntranceAnimState r102 = new EntranceAnimState("FOLLOWED_HIDING", 2);
        FOLLOWED_HIDING = r102;
        EntranceAnimState r103 = new EntranceAnimState("FOLLOWED_SHOWING", 3);
        FOLLOWED_SHOWING = r103;
        EntranceAnimState r104 = new EntranceAnimState("ACTIVATED_HIDING", 4);
        ACTIVATED_HIDING = r104;
        EntranceAnimState r105 = new EntranceAnimState("ACTIVATED_SHOWING", 5);
        ACTIVATED_SHOWING = r105;
        f87418a = new EntranceAnimState[]{r100, r101, r102, r103, r104, r105};
    }

    public static EntranceAnimState valueOf(String r100) {
        return (EntranceAnimState) a.a(EntranceAnimState.class, r100);
    }

    public static EntranceAnimState[] values() {
        return (EntranceAnimState[]) f87418a.clone();
    }

    public EntranceAnimState(String r100, int r101) {
        super(r100, r101);
    }
}
