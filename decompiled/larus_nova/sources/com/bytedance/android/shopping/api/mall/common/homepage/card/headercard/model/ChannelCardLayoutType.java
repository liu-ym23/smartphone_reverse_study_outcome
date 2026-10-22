package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelCardLayoutType;", "", "", "value", "I", "getValue", "()I", "BIG_CARD", "BIG_CARD_NEW_41", "THREE_PITS_CARD", "DOUBLE_PITS_CARD", "SINGLE_PIT_CARD", UserProfileEvent.POSITION_NONE, "THREE_PITS_CARD_LIVE", "DOUBLE_PITS_LIVE_CARD", "SINGLE_PIT_LIVE_CARD", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ChannelCardLayoutType extends Enum<ChannelCardLayoutType> {
    public static final ChannelCardLayoutType BIG_CARD = null;
    public static final ChannelCardLayoutType BIG_CARD_NEW_41 = null;
    public static final ChannelCardLayoutType DOUBLE_PITS_CARD = null;
    public static final ChannelCardLayoutType DOUBLE_PITS_LIVE_CARD = null;
    public static final ChannelCardLayoutType NONE = null;
    public static final ChannelCardLayoutType SINGLE_PIT_CARD = null;
    public static final ChannelCardLayoutType SINGLE_PIT_LIVE_CARD = null;
    public static final ChannelCardLayoutType THREE_PITS_CARD = null;
    public static final ChannelCardLayoutType THREE_PITS_CARD_LIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChannelCardLayoutType[] f170322a = null;
    private final int value;

    public static ChannelCardLayoutType valueOf(String r100) {
        return (ChannelCardLayoutType) a.a(ChannelCardLayoutType.class, r100);
    }

    public static ChannelCardLayoutType[] values() {
        return (ChannelCardLayoutType[]) f170322a.clone();
    }

    static {
        ChannelCardLayoutType r100 = new ChannelCardLayoutType("BIG_CARD", 0, 400);
        BIG_CARD = r100;
        ChannelCardLayoutType r101 = new ChannelCardLayoutType("BIG_CARD_NEW_41", 1, 401);
        BIG_CARD_NEW_41 = r101;
        ChannelCardLayoutType r102 = new ChannelCardLayoutType("THREE_PITS_CARD", 2, 300);
        THREE_PITS_CARD = r102;
        ChannelCardLayoutType r103 = new ChannelCardLayoutType("DOUBLE_PITS_CARD", 3, 200);
        DOUBLE_PITS_CARD = r103;
        ChannelCardLayoutType r104 = new ChannelCardLayoutType("SINGLE_PIT_CARD", 4, 100);
        SINGLE_PIT_CARD = r104;
        ChannelCardLayoutType r105 = new ChannelCardLayoutType(UserProfileEvent.POSITION_NONE, 5, 0);
        NONE = r105;
        ChannelCardLayoutType r106 = new ChannelCardLayoutType("THREE_PITS_CARD_LIVE", 6, 301);
        THREE_PITS_CARD_LIVE = r106;
        ChannelCardLayoutType r107 = new ChannelCardLayoutType("DOUBLE_PITS_LIVE_CARD", 7, 201);
        DOUBLE_PITS_LIVE_CARD = r107;
        ChannelCardLayoutType r108 = new ChannelCardLayoutType("SINGLE_PIT_LIVE_CARD", 8, 101);
        SINGLE_PIT_LIVE_CARD = r108;
        f170322a = new ChannelCardLayoutType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final int getValue() {
        return this.value;
    }

    public ChannelCardLayoutType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
