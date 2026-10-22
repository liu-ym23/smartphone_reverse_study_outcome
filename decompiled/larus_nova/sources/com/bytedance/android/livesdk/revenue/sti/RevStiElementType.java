package com.bytedance.android.livesdk.revenue.sti;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/sti/RevStiElementType;", "", "", "typeId", "I", "getTypeId", "()I", "Unknown", "CNYALuckyBox", "DTaskLuckyBox", "OfficialInteractiveLuckyBox", "RegularLuckyBox", "GiftVote", "Lottery", "CommerceRaffleTicket", "PopularCard", "LiveTC", "CommerceLottery", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevStiElementType extends Enum<RevStiElementType> {
    public static final RevStiElementType CNYALuckyBox = null;
    public static final RevStiElementType CommerceLottery = null;
    public static final RevStiElementType CommerceRaffleTicket = null;
    public static final RevStiElementType DTaskLuckyBox = null;
    public static final RevStiElementType GiftVote = null;
    public static final RevStiElementType LiveTC = null;
    public static final RevStiElementType Lottery = null;
    public static final RevStiElementType OfficialInteractiveLuckyBox = null;
    public static final RevStiElementType PopularCard = null;
    public static final RevStiElementType RegularLuckyBox = null;
    public static final RevStiElementType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevStiElementType[] f157516a = null;
    private final int typeId;

    public static RevStiElementType valueOf(String r100) {
        return (RevStiElementType) a.a(RevStiElementType.class, r100);
    }

    public static RevStiElementType[] values() {
        return (RevStiElementType[]) f157516a.clone();
    }

    static {
        RevStiElementType r100 = new RevStiElementType("Unknown", 0, 0);
        Unknown = r100;
        RevStiElementType r101 = new RevStiElementType("CNYALuckyBox", 1, 1);
        CNYALuckyBox = r101;
        RevStiElementType r102 = new RevStiElementType("DTaskLuckyBox", 2, 2);
        DTaskLuckyBox = r102;
        RevStiElementType r103 = new RevStiElementType("OfficialInteractiveLuckyBox", 3, 3);
        OfficialInteractiveLuckyBox = r103;
        RevStiElementType r104 = new RevStiElementType("RegularLuckyBox", 4, 4);
        RegularLuckyBox = r104;
        RevStiElementType r105 = new RevStiElementType("GiftVote", 5, 6);
        GiftVote = r105;
        RevStiElementType r106 = new RevStiElementType("Lottery", 6, 7);
        Lottery = r106;
        RevStiElementType r107 = new RevStiElementType("CommerceRaffleTicket", 7, 8);
        CommerceRaffleTicket = r107;
        RevStiElementType r108 = new RevStiElementType("PopularCard", 8, 10);
        PopularCard = r108;
        RevStiElementType r109 = new RevStiElementType("LiveTC", 9, 22);
        LiveTC = r109;
        RevStiElementType r110 = new RevStiElementType("CommerceLottery", 10, 27);
        CommerceLottery = r110;
        f157516a = new RevStiElementType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final int getTypeId() {
        return this.typeId;
    }

    public RevStiElementType(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeId = r102;
    }
}
