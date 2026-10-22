package com.bytedance.android.livesdk.preinflate;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import zo2.a;
import zo2.b;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/preinflate/LiveNitaViewInfo;", "", "Lzo2/a;", "", "getResId", "()I", "resId", "", "getTag", "()Ljava/lang/String;", "tag", "getCount", "count", "getType", "type", "TTLIVE_FRAGMENT_LIVE_ROOM", "TTLIVE_FRAGMENT_LIVE_PLAY", "TTLIVE_FRAGMENT_PORTRAIT_INTERACTION", "TTLIVE_FRAGMENT_LANDSCAPE_INTERACTION", "TTLIVE_TOOLBARBUTTON_MORE", "TTLIVE_TOOLBARBUTTON_GAME_GUESS", "TTLIVE_TOOLBARBUTTON_GAME_PROMOTE_AUDIENCE", "TTLIVE_TOOLBARBUTTON_WELFARE", "TTLIVE_TOOLBARBUTTON_INTERACTION_AUDIENCE", "TTLIVE_TOOLBARBUTTON_INTERACTION", "TTLIVE_TOOLBARBUTTON_AUDIO_TOGGLE", "TTLIVE_TOOLBARBUTTON_TICKET_SALE", "TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_LYNX_GAME", "TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_GAME", "TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_MINI_APP", "TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_MINI_GAME", "TTLIVE_TOOLBARBUTTON_COMMERCE", "TTLIVE_TOOLBARBUTTON_COMMERCE_LIVE_AD", "TTLIVE_TOOLBARBUTTON_EASTER_EGG", "TTLIVE_TOOLBARBUTTON_GIFT", "TTLIVE_TOOLBARBUTTON_SWITCH_SCREEN_ORIENTATION", "TTLIVE_TOOLBARBUTTON_AIRDROP_GIFT", "TTLIVE_TOOLBARBUTTON_CASH_EXCHANGE", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveNitaViewInfo extends Enum<LiveNitaViewInfo> implements a {
    public static final LiveNitaViewInfo TTLIVE_FRAGMENT_LANDSCAPE_INTERACTION = null;
    public static final LiveNitaViewInfo TTLIVE_FRAGMENT_LIVE_PLAY = null;
    public static final LiveNitaViewInfo TTLIVE_FRAGMENT_LIVE_ROOM = null;
    public static final LiveNitaViewInfo TTLIVE_FRAGMENT_PORTRAIT_INTERACTION = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_AIRDROP_GIFT = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_AUDIO_TOGGLE = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_CASH_EXCHANGE = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_COMMERCE = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_COMMERCE_LIVE_AD = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_EASTER_EGG = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_GAME_GUESS = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_GAME_PROMOTE_AUDIENCE = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_GIFT = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_INTERACTION = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_INTERACTION_AUDIENCE = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_MORE = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_GAME = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_LYNX_GAME = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_MINI_APP = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_MINI_GAME = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_SWITCH_SCREEN_ORIENTATION = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_TICKET_SALE = null;
    public static final LiveNitaViewInfo TTLIVE_TOOLBARBUTTON_WELFARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveNitaViewInfo[] f156315a = null;

    static {
        LiveNitaViewInfo r100 = new LiveNitaViewInfo("TTLIVE_FRAGMENT_LIVE_ROOM", 0);
        TTLIVE_FRAGMENT_LIVE_ROOM = r100;
        LiveNitaViewInfo r101 = new LiveNitaViewInfo("TTLIVE_FRAGMENT_LIVE_PLAY", 1);
        TTLIVE_FRAGMENT_LIVE_PLAY = r101;
        LiveNitaViewInfo r102 = new LiveNitaViewInfo("TTLIVE_FRAGMENT_PORTRAIT_INTERACTION", 2);
        TTLIVE_FRAGMENT_PORTRAIT_INTERACTION = r102;
        LiveNitaViewInfo r103 = new LiveNitaViewInfo("TTLIVE_FRAGMENT_LANDSCAPE_INTERACTION", 3);
        TTLIVE_FRAGMENT_LANDSCAPE_INTERACTION = r103;
        LiveNitaViewInfo r104 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_MORE", 4);
        TTLIVE_TOOLBARBUTTON_MORE = r104;
        LiveNitaViewInfo r105 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_GAME_GUESS", 5);
        TTLIVE_TOOLBARBUTTON_GAME_GUESS = r105;
        LiveNitaViewInfo r106 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_GAME_PROMOTE_AUDIENCE", 6);
        TTLIVE_TOOLBARBUTTON_GAME_PROMOTE_AUDIENCE = r106;
        LiveNitaViewInfo r107 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_WELFARE", 7);
        TTLIVE_TOOLBARBUTTON_WELFARE = r107;
        LiveNitaViewInfo r108 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_INTERACTION_AUDIENCE", 8);
        TTLIVE_TOOLBARBUTTON_INTERACTION_AUDIENCE = r108;
        LiveNitaViewInfo r109 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_INTERACTION", 9);
        TTLIVE_TOOLBARBUTTON_INTERACTION = r109;
        LiveNitaViewInfo r110 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_AUDIO_TOGGLE", 10);
        TTLIVE_TOOLBARBUTTON_AUDIO_TOGGLE = r110;
        LiveNitaViewInfo r111 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_TICKET_SALE", 11);
        TTLIVE_TOOLBARBUTTON_TICKET_SALE = r111;
        LiveNitaViewInfo r112 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_LYNX_GAME", 12);
        TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_LYNX_GAME = r112;
        LiveNitaViewInfo r113 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_GAME", 13);
        TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_GAME = r113;
        LiveNitaViewInfo r114 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_MINI_APP", 14);
        TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_MINI_APP = r114;
        LiveNitaViewInfo r115 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_MINI_GAME", 15);
        TTLIVE_TOOLBARBUTTON_OPEN_PLATFORM_MINI_GAME = r115;
        LiveNitaViewInfo r116 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_COMMERCE", 16);
        TTLIVE_TOOLBARBUTTON_COMMERCE = r116;
        LiveNitaViewInfo r117 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_COMMERCE_LIVE_AD", 17);
        TTLIVE_TOOLBARBUTTON_COMMERCE_LIVE_AD = r117;
        LiveNitaViewInfo r118 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_EASTER_EGG", 18);
        TTLIVE_TOOLBARBUTTON_EASTER_EGG = r118;
        LiveNitaViewInfo r119 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_GIFT", 19);
        TTLIVE_TOOLBARBUTTON_GIFT = r119;
        LiveNitaViewInfo r120 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_SWITCH_SCREEN_ORIENTATION", 20);
        TTLIVE_TOOLBARBUTTON_SWITCH_SCREEN_ORIENTATION = r120;
        LiveNitaViewInfo r121 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_AIRDROP_GIFT", 21);
        TTLIVE_TOOLBARBUTTON_AIRDROP_GIFT = r121;
        LiveNitaViewInfo r122 = new LiveNitaViewInfo("TTLIVE_TOOLBARBUTTON_CASH_EXCHANGE", 22);
        TTLIVE_TOOLBARBUTTON_CASH_EXCHANGE = r122;
        f156315a = new LiveNitaViewInfo[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122};
    }

    public static LiveNitaViewInfo valueOf(String r100) {
        return (LiveNitaViewInfo) r27.a.a(LiveNitaViewInfo.class, r100);
    }

    public static LiveNitaViewInfo[] values() {
        return (LiveNitaViewInfo[]) f156315a.clone();
    }

    @Override // zo2.a
    public int getCount() {
        if (b.f573104c[ordinal()] != 1) goto L7;
        return 2;
    L7:
        return 1;
    }

    @Override // zo2.a
    public int getResId() {
        switch(b.f573102a[ordinal()]) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L48;
            case 6: goto L47;
            case 7: goto L46;
            case 8: goto L45;
            case 9: goto L44;
            case 10: goto L43;
            case 11: goto L42;
            case 12: goto L41;
            case 13: goto L40;
            case 14: goto L39;
            case 15: goto L38;
            case 16: goto L37;
            case 17: goto L36;
            case 18: goto L35;
            case 19: goto L34;
            case 20: goto L33;
            case 21: goto L32;
            case 22: goto L31;
            case 23: goto L30;
            default: goto L5;
        };
    L25:
        return R.layout.ttlive_fragment_landscape_interaction;
    L26:
        return R.layout.ttlive_fragment_portrait_interaction;
    L27:
        return R.layout.ttlive_fragment_live_play;
    L28:
        return R.layout.ttlive_fragment_live_room;
    L5:
        throw new NoWhenBranchMatchedException();
    L30:
        return ToolbarButton.CASH_EXCHANGE.getLayoutId();
    L31:
        return ToolbarButton.AIRDROP_GIFT.getLayoutId();
    L32:
        return ToolbarButton.SWITCH_SCREEN_ORIENTATION.getLayoutId();
    L33:
        return ToolbarButton.GIFT.getLayoutId();
    L34:
        return ToolbarButton.EASTER_EGG.getLayoutId();
    L35:
        return ToolbarButton.COMMERCE_LIVE_AD.getLayoutId();
    L36:
        return ToolbarButton.COMMERCE.getLayoutId();
    L37:
        return ToolbarButton.OPEN_PLATFORM_MINI_GAME.getLayoutId();
    L38:
        return ToolbarButton.OPEN_PLATFORM_MINI_APP.getLayoutId();
    L39:
        return ToolbarButton.OPEN_PLATFORM_GAME.getLayoutId();
    L40:
        return ToolbarButton.OPEN_PLATFORM_LYNX_GAME.getLayoutId();
    L41:
        return ToolbarButton.TICKET_SALE.getLayoutId();
    L42:
        return ToolbarButton.AUDIO_TOGGLE.getLayoutId();
    L43:
        return ToolbarButton.INTERACTION.getLayoutId();
    L44:
        return ToolbarButton.INTERACTION_AUDIENCE.getLayoutId();
    L45:
        return ToolbarButton.WELFARE.getLayoutId();
    L46:
        return ToolbarButton.GAME_PROMOTE_AUDIENCE.getLayoutId();
    L47:
        return ToolbarButton.GAME_GUESS.getLayoutId();
    L48:
        return ToolbarButton.MORE.getLayoutId();
    }

    @Override // zo2.a
    public String getTag() {
        switch(b.f573103b[ordinal()]) {
            case 1: goto L24;
            case 2: goto L43;
            case 3: goto L42;
            case 4: goto L41;
            case 5: goto L40;
            case 6: goto L39;
            case 7: goto L38;
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L35;
            case 11: goto L34;
            case 12: goto L33;
            case 13: goto L32;
            case 14: goto L31;
            case 15: goto L30;
            case 16: goto L29;
            case 17: goto L28;
            case 18: goto L27;
            case 19: goto L26;
            default: goto L25;
        };
    L25:
        return name();
    L26:
        return ToolbarButton.CASH_EXCHANGE.name();
    L27:
        return ToolbarButton.AIRDROP_GIFT.name();
    L28:
        return ToolbarButton.SWITCH_SCREEN_ORIENTATION.name();
    L29:
        return ToolbarButton.GIFT.name();
    L30:
        return ToolbarButton.EASTER_EGG.name();
    L31:
        return ToolbarButton.COMMERCE_LIVE_AD.name();
    L32:
        return ToolbarButton.COMMERCE.name();
    L33:
        return ToolbarButton.OPEN_PLATFORM_MINI_GAME.name();
    L34:
        return ToolbarButton.OPEN_PLATFORM_MINI_APP.name();
    L35:
        return ToolbarButton.OPEN_PLATFORM_GAME.name();
    L36:
        return ToolbarButton.OPEN_PLATFORM_LYNX_GAME.name();
    L37:
        return ToolbarButton.TICKET_SALE.name();
    L38:
        return ToolbarButton.AUDIO_TOGGLE.name();
    L39:
        return ToolbarButton.INTERACTION.name();
    L40:
        return ToolbarButton.INTERACTION_AUDIENCE.name();
    L41:
        return ToolbarButton.WELFARE.name();
    L42:
        return ToolbarButton.GAME_PROMOTE_AUDIENCE.name();
    L43:
        return ToolbarButton.GAME_GUESS.name();
    L24:
        return ToolbarButton.MORE.name();
    }

    @Override // zo2.a
    public int getType() {
        switch(b.f573105d[ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L6;
            case 14: goto L6;
            case 15: goto L6;
            case 16: goto L6;
            case 17: goto L6;
            case 18: goto L6;
            case 19: goto L6;
            case 20: goto L6;
            case 21: goto L6;
            case 22: goto L6;
            case 23: goto L6;
            default: goto L5;
        };
    L6:
        return 1;
    L8:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public LiveNitaViewInfo(String r100, int r101) {
        super(r100, r101);
    }
}
