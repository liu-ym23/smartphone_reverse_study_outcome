package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class q extends ToolbarConstraints {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<ToolbarSlot> f116670g;

    public q() {
        ToolbarSlot[] r100 = new ToolbarSlot[14];
        ToolbarSlot r101 = new ToolbarSlot();
        r101.setPriority(1000);
        r101.d().add(CollectionsKt.listOf(ToolbarButton.CHANNEL_COMMENT.name()));
        Unit r102 = Unit.INSTANCE;
        r100[0] = r101;
        ToolbarSlot r103 = new ToolbarSlot();
        r103.setPriority(1000);
        r103.d().add(CollectionsKt.listOf(ToolbarButton.SQUARE_COMMENT.name()));
        r100[1] = r103;
        ToolbarSlot r104 = new ToolbarSlot();
        r104.setPriority(1000);
        r104.d().add(CollectionsKt.listOf(new String[]{ToolbarButton.GAME_GUESS.name(), ToolbarButton.OPEN_PLATFORM_LYNX_GAME.name()}));
        r100[2] = r104;
        ToolbarSlot r105 = new ToolbarSlot();
        r105.setPriority(602);
        r105.d().add(CollectionsKt.listOf(ToolbarButton.AUTO_CAR.name()));
        r100[3] = r105;
        ToolbarSlot r106 = new ToolbarSlot();
        r106.setPriority(1000);
        r106.d().add(CollectionsKt.listOf(ToolbarButton.INTERACT_GAME.name()));
        r100[4] = r106;
        ToolbarSlot r107 = new ToolbarSlot();
        r107.setPriority(1000);
        r107.d().add(CollectionsKt.listOf(ToolbarButton.BROADCAST_EFFECT.name()));
        r100[5] = r107;
        ToolbarSlot r108 = new ToolbarSlot();
        r108.setPriority(1000);
        r108.d().add(CollectionsKt.listOf(ToolbarButton.VIRTUAL_LIVE.name()));
        r100[6] = r108;
        ToolbarSlot r109 = new ToolbarSlot();
        r109.setPriority(601);
        ToolbarButton r110 = ToolbarButton.GAME_PROMOTE;
        List<String> r111 = CollectionsKt.listOf(new String[]{ToolbarButton.COMMERCE.name(), ToolbarButton.LITTLE_GAME.name(), ToolbarButton.TRANSFORM_WIDGET.name(), ToolbarButton.GROUP_PURCHASE.name(), ToolbarButton.WELFARE.name(), r110.name(), ToolbarButton.TICKET_SALE_ANCHOR.name()});
        com.bytedance.android.livesdk.config.c r112 = com.bytedance.android.livesdk.config.c.f119910a;
        if (r112.getValue().booleanValue() == false) goto L5;
        List r113 = CollectionsKt.toMutableList(r111);
        r113.remove(r110.name());
        r111 = CollectionsKt.toList(r113);
    L5:
        r109.d().add(r111);
        r100[7] = r109;
        ToolbarSlot r114 = new ToolbarSlot();
        r114.setPriority(602);
        r114.d().add(CollectionsKt.listOf(ToolbarButton.OPEN_PLATFORM_MINI_APP.name()));
        r100[8] = r114;
        ToolbarSlot r115 = new ToolbarSlot();
        r115.setPriority(603);
        if (r112.getValue().booleanValue() == false) goto L8;
        r115.d().add(CollectionsKt.listOf(r110.name()));
    L8:
        r100[9] = r115;
        ToolbarSlot r116 = new ToolbarSlot();
        r116.setPriority(800);
        r116.d().add(CollectionsKt.listOf(ToolbarButton.ATTACK_AND_DEFENSE.name()));
        r100[10] = r116;
        ToolbarSlot r117 = new ToolbarSlot();
        r117.setPriority(1000);
        r117.d().add(CollectionsKt.listOf(ToolbarButton.CLOSE_ROOM.name()));
        r100[11] = r117;
        ToolbarSlot r118 = new ToolbarSlot();
        r118.setPriority(1000);
        r118.d().add(CollectionsKt.listOf(ToolbarButton.MORE.name()));
        r100[12] = r118;
        ToolbarSlot r119 = new ToolbarSlot();
        r119.setPriority(600);
        r119.d().add(CollectionsKt.listOf(ToolbarButton.LIVE_IM_ENTRANCE.name()));
        r100[13] = r119;
        this.f116670g = CollectionsKt.listOf(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarConstraints
    public final List<ToolbarSlot> a() {
        return this.f116670g;
    }
}
