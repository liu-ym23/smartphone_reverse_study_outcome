package com.bytedance.android.livesdk.revenue.toolbar;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/toolbar/RevRedDot;", "", "AudienceRoomMoreVote", "AnchorMoreGift", "AudienceRoomGiftEffect", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevRedDot extends Enum<RevRedDot> {
    public static final RevRedDot AnchorMoreGift = null;
    public static final RevRedDot AudienceRoomGiftEffect = null;
    public static final RevRedDot AudienceRoomMoreVote = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevRedDot[] f157519a = null;

    static {
        RevRedDot r100 = new RevRedDot("AudienceRoomMoreVote", 0);
        AudienceRoomMoreVote = r100;
        RevRedDot r101 = new RevRedDot("AnchorMoreGift", 1);
        AnchorMoreGift = r101;
        RevRedDot r102 = new RevRedDot("AudienceRoomGiftEffect", 2);
        AudienceRoomGiftEffect = r102;
        f157519a = new RevRedDot[]{r100, r101, r102};
    }

    public static RevRedDot valueOf(String r100) {
        return (RevRedDot) a.a(RevRedDot.class, r100);
    }

    public static RevRedDot[] values() {
        return (RevRedDot[]) f157519a.clone();
    }

    public RevRedDot(String r100, int r101) {
        super(r100, r101);
    }
}
