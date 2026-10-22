package com.bytedance.android.livesdk.revenue.toolbar;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/toolbar/RevToolbarButton;", "", "PK", "Vote", "InteractGame", "Lottery", "Gift", "BroadCastGift", "GiftAnimation", "FastGift", "More", "GiftEffect", "INTERACTION", "CashExchange", "InteractGift", "TreasureBox", "AttackAndDefense", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevToolbarButton extends Enum<RevToolbarButton> {
    public static final RevToolbarButton AttackAndDefense = null;
    public static final RevToolbarButton BroadCastGift = null;
    public static final RevToolbarButton CashExchange = null;
    public static final RevToolbarButton FastGift = null;
    public static final RevToolbarButton Gift = null;
    public static final RevToolbarButton GiftAnimation = null;
    public static final RevToolbarButton GiftEffect = null;
    public static final RevToolbarButton INTERACTION = null;
    public static final RevToolbarButton InteractGame = null;
    public static final RevToolbarButton InteractGift = null;
    public static final RevToolbarButton Lottery = null;
    public static final RevToolbarButton More = null;
    public static final RevToolbarButton PK = null;
    public static final RevToolbarButton TreasureBox = null;
    public static final RevToolbarButton Vote = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevToolbarButton[] f157522a = null;

    static {
        RevToolbarButton r100 = new RevToolbarButton("PK", 0);
        PK = r100;
        RevToolbarButton r101 = new RevToolbarButton("Vote", 1);
        Vote = r101;
        RevToolbarButton r102 = new RevToolbarButton("InteractGame", 2);
        InteractGame = r102;
        RevToolbarButton r103 = new RevToolbarButton("Lottery", 3);
        Lottery = r103;
        RevToolbarButton r104 = new RevToolbarButton("Gift", 4);
        Gift = r104;
        RevToolbarButton r105 = new RevToolbarButton("BroadCastGift", 5);
        BroadCastGift = r105;
        RevToolbarButton r106 = new RevToolbarButton("GiftAnimation", 6);
        GiftAnimation = r106;
        RevToolbarButton r107 = new RevToolbarButton("FastGift", 7);
        FastGift = r107;
        RevToolbarButton r108 = new RevToolbarButton("More", 8);
        More = r108;
        RevToolbarButton r109 = new RevToolbarButton("GiftEffect", 9);
        GiftEffect = r109;
        RevToolbarButton r110 = new RevToolbarButton("INTERACTION", 10);
        INTERACTION = r110;
        RevToolbarButton r111 = new RevToolbarButton("CashExchange", 11);
        CashExchange = r111;
        RevToolbarButton r112 = new RevToolbarButton("InteractGift", 12);
        InteractGift = r112;
        RevToolbarButton r113 = new RevToolbarButton("TreasureBox", 13);
        TreasureBox = r113;
        RevToolbarButton r114 = new RevToolbarButton("AttackAndDefense", 14);
        AttackAndDefense = r114;
        f157522a = new RevToolbarButton[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
    }

    public static RevToolbarButton valueOf(String r100) {
        return (RevToolbarButton) a.a(RevToolbarButton.class, r100);
    }

    public static RevToolbarButton[] values() {
        return (RevToolbarButton[]) f157522a.clone();
    }

    public RevToolbarButton(String r100, int r101) {
        super(r100, r101);
    }
}
