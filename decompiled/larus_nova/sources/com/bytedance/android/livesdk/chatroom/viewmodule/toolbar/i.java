package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.config.we;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class i extends ToolbarConstraints {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<ToolbarSlot> f116326g;

    public static final class a {
    }

    static {
    }

    public i() {
        ToolbarSlot[] r100 = new ToolbarSlot[27];
        ToolbarSlot r101 = new ToolbarSlot();
        r101.setPriority(1000);
        r101.d().add(CollectionsKt.listOf(ToolbarButton.CHAT_CHANNEL_LANDSCAPE.name()));
        Unit r102 = Unit.INSTANCE;
        r100[0] = r101;
        ToolbarSlot r103 = new ToolbarSlot();
        r103.setPriority(1000);
        r103.d().add(CollectionsKt.listOf(ToolbarButton.ROOM_CHANNEL_LANDSCAPE.name()));
        r100[1] = r103;
        ToolbarSlot r104 = new ToolbarSlot();
        r104.setPriority(1000);
        r104.d().add(CollectionsKt.listOf(ToolbarButton.VS_FAST_PLAY.name()));
        r100[2] = r104;
        ToolbarSlot r105 = new ToolbarSlot();
        r105.setPriority(1000);
        r105.d().add(CollectionsKt.listOf(ToolbarButton.CAST_FEED_BACK.name()));
        r100[3] = r105;
        ToolbarSlot r106 = new ToolbarSlot();
        r106.setPriority(1000);
        r106.d().add(CollectionsKt.listOf(ToolbarButton.CAST_REFRESH.name()));
        r100[4] = r106;
        ToolbarSlot r107 = new ToolbarSlot();
        r107.setPriority(1000);
        r107.d().add(CollectionsKt.listOf(ToolbarButton.VS_VIDEO_QUALITY.name()));
        r100[5] = r107;
        ToolbarSlot r108 = new ToolbarSlot();
        r108.setPriority(500);
        r108.d().add(CollectionsKt.listOf(ToolbarButton.GAME_GUESS.name()));
        r100[6] = r108;
        ToolbarSlot r109 = new ToolbarSlot();
        r109.setPriority(TTVideoEngineInterface.PLAYER_OPTION_FRC_LEVEL);
        r109.d().add(CollectionsKt.listOf(ToolbarButton.OPEN_PLATFORM_LYNX_GAME.name()));
        r100[7] = r109;
        ToolbarSlot r110 = new ToolbarSlot();
        r110.setPriority(TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_BARRAGE_MASK);
        r110.d().add(CollectionsKt.listOf(new String[]{ToolbarButton.INTERACTION_AUDIENCE.name(), ToolbarButton.INTERACTION.name()}));
        r100[8] = r110;
        ToolbarSlot r111 = new ToolbarSlot();
        r111.setPriority(501);
        we r112 = we.f121517a;
        if (r112.getValue().booleanValue() == false) goto L5;
        r111.d().add(CollectionsKt.listOf(ToolbarButton.OPEN_PLATFORM_MINI_APP.name()));
    L5:
        r100[9] = r111;
        ToolbarSlot r113 = new ToolbarSlot();
        r113.setPriority(502);
        if (r112.getValue().booleanValue() == false) goto L8;
        List<String> r114 = CollectionsKt.listOf(new String[]{ToolbarButton.REPLAY_TICKET_SALE.name(), ToolbarButton.TICKET_SALE.name(), ToolbarButton.COMMERCE.name(), ToolbarButton.LITTLE_GAME.name(), ToolbarButton.OPEN_PLATFORM_GAME.name(), ToolbarButton.COMMERCE_LIVE_AD.name(), ToolbarButton.GROUP_PURCHASE_AUDIENCE.name(), ToolbarButton.EASTER_EGG.name(), ToolbarButton.WELFARE.name(), ToolbarButton.OPEN_PLATFORM_MINI_GAME.name(), ToolbarButton.GAME_PROMOTE_AUDIENCE.name()});
    L9:
        r113.d().add(r114);
        r100[10] = r113;
        ToolbarSlot r115 = new ToolbarSlot();
        r115.setPriority(400);
        r115.d().add(CollectionsKt.listOf(ToolbarButton.COUPON_EXCHANGE.name()));
        r115.d().add(CollectionsKt.listOf(ToolbarButton.CASH_EXCHANGE.name()));
        r115.d().add(CollectionsKt.listOf(ToolbarButton.AUTO_CAR.name()));
        r115.d().add(CollectionsKt.listOf(ToolbarButton.AIRDROP_GIFT.name()));
        r115.d().add(CollectionsKt.listOf(ToolbarButton.FAST_GIFT.name()));
        r100[11] = r115;
        ToolbarSlot r116 = new ToolbarSlot();
        r116.setPriority(999);
        r116.d().add(CollectionsKt.listOf(ToolbarButton.GIFT.name()));
        r100[12] = r116;
        ToolbarSlot r117 = new ToolbarSlot();
        r117.setPriority(996);
        r117.d().add(CollectionsKt.listOf(ToolbarButton.VR_MODE.name()));
        r100[13] = r117;
        ToolbarSlot r118 = new ToolbarSlot();
        r118.setPriority(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_UPGRADE_TIME_THRESHOLD);
        r118.d().add(CollectionsKt.listOf(ToolbarButton.MULTI_CAMERA_LINKED_ROOM.name()));
        r100[14] = r118;
        ToolbarSlot r119 = new ToolbarSlot();
        r119.setPriority(990);
        r119.d().add(CollectionsKt.listOf(ToolbarButton.QUICK_SCREEN_SHOT.name()));
        r100[15] = r119;
        ToolbarSlot r120 = new ToolbarSlot();
        r120.setPriority(985);
        r120.d().add(CollectionsKt.listOf(ToolbarButton.ROOM_CHANNEL.name()));
        r100[16] = r120;
        ToolbarSlot r121 = new ToolbarSlot();
        r121.setPriority(501);
        r121.d().add(CollectionsKt.listOf(ToolbarButton.VS_MESSAGE_BOARD.name()));
        r100[17] = r121;
        ToolbarSlot r122 = new ToolbarSlot();
        r122.setPriority(980);
        r122.d().add(CollectionsKt.listOf(ToolbarButton.VS_ACTIVITY_ONE.name()));
        r100[18] = r122;
        ToolbarSlot r123 = new ToolbarSlot();
        r123.setPriority(1000);
        r123.d().add(CollectionsKt.listOf(ToolbarButton.VS_CAST_SCREEN.name()));
        r100[19] = r123;
        ToolbarSlot r124 = new ToolbarSlot();
        r124.setPriority(1000);
        r124.d().add(CollectionsKt.listOf(ToolbarButton.SHARE.name()));
        r100[20] = r124;
        ToolbarSlot r125 = new ToolbarSlot();
        r125.setPriority(1000);
        r125.d().add(CollectionsKt.listOf(ToolbarButton.MORE.name()));
        r100[21] = r125;
        ToolbarSlot r126 = new ToolbarSlot();
        r126.setPriority(501);
        r126.d().add(CollectionsKt.listOf(ToolbarButton.LIVE_IM_ENTRANCE.name()));
        r100[22] = r126;
        ToolbarSlot r127 = new ToolbarSlot();
        r127.setPriority(1000);
        r127.d().add(CollectionsKt.listOf(new String[]{ToolbarButton.DOUYIN_CLOSE.name(), ToolbarButton.CLOSE_ROOM.name()}));
        r100[23] = r127;
        ToolbarSlot r128 = new ToolbarSlot();
        r128.setPriority(2000);
        r128.d().add(CollectionsKt.listOf(ToolbarButton.SWITCH_VIDEO_QUALITY.name()));
        r100[24] = r128;
        ToolbarSlot r129 = new ToolbarSlot();
        r129.setPriority(2000);
        r129.d().add(CollectionsKt.listOf(ToolbarButton.LANDSCAPE_MULTI_TAB.name()));
        r100[25] = r129;
        ToolbarSlot r130 = new ToolbarSlot();
        r130.setPriority(1999);
        r130.d().add(CollectionsKt.listOf(ToolbarButton.VS_SELECT_EPISODE.name()));
        r100[26] = r130;
        this.f116326g = CollectionsKt.listOf(r100);
        return;
    L8:
        r114 = CollectionsKt.listOf(new String[]{ToolbarButton.REPLAY_TICKET_SALE.name(), ToolbarButton.TICKET_SALE.name(), ToolbarButton.COMMERCE.name(), ToolbarButton.LITTLE_GAME.name(), ToolbarButton.OPEN_PLATFORM_MINI_APP.name(), ToolbarButton.OPEN_PLATFORM_GAME.name(), ToolbarButton.COMMERCE_LIVE_AD.name(), ToolbarButton.GROUP_PURCHASE_AUDIENCE.name(), ToolbarButton.EASTER_EGG.name(), ToolbarButton.WELFARE.name(), ToolbarButton.OPEN_PLATFORM_MINI_GAME.name(), ToolbarButton.GAME_PROMOTE_AUDIENCE.name()});
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarConstraints
    public final List<ToolbarSlot> a() {
        return this.f116326g;
    }
}
