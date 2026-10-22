package com.obric.autogui.common.api.presentation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IAutoActionGlobalUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GlobalUIContext {
    private final AssistInputState assistState;
    private final IslandState island;
    private final PlayerState player;
    private final WidgetState widgetState;

    public GlobalUIContext() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ GlobalUIContext copy$default(GlobalUIContext r0, PlayerState r1, IslandState r2, AssistInputState r3, WidgetState r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.player;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.island;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.assistState;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.widgetState;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final PlayerState component1() {
        return this.player;
    }

    public final IslandState component2() {
        return this.island;
    }

    public final AssistInputState component3() {
        return this.assistState;
    }

    public final WidgetState component4() {
        return this.widgetState;
    }

    public final GlobalUIContext copy(PlayerState r1, IslandState r2, AssistInputState r3, WidgetState r4) {
        o.e(r1, "player");
        o.e(r2, "island");
        o.e(r3, "assistState");
        return new GlobalUIContext(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalUIContext.class) == true) goto L8;
        return false;
    L8:
        GlobalUIContext r6 = (GlobalUIContext) ZeusTransformUtils.preCheckCast(r5, GlobalUIContext.class, "com.obric.aiagent.plugin");
        if (o.a(this.player, r6.player) == true) goto L12;
        return false;
    L12:
        if (o.a(this.island, r6.island) == true) goto L15;
        return false;
    L15:
        if (o.a(this.assistState, r6.assistState) == true) goto L18;
        return false;
    L18:
        if (o.a(this.widgetState, r6.widgetState) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.player.hashCode() * 31) + this.island.hashCode()) * 31) + this.assistState.hashCode()) * 31;
        WidgetState r2 = this.widgetState;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "GlobalUIContext(player=" + this.player + ", island=" + this.island + ", assistState=" + this.assistState + ", widgetState=" + this.widgetState + ')';
    }

    public GlobalUIContext(PlayerState r2, IslandState r3, AssistInputState r4, WidgetState r5) {
        o.e(r2, "player");
        o.e(r3, "island");
        o.e(r4, "assistState");
        this.player = r2;
        this.island = r3;
        this.assistState = r4;
        this.widgetState = r5;
    }

    public /* synthetic */ GlobalUIContext(PlayerState r8, IslandState r9, AssistInputState r10, WidgetState r11, int r12, h r13) {
        if ((r12 & 1) == 0) goto L6;
        r8 = new PlayerState(null, 1, null);
    L6:
        if ((r12 & 2) == 0) goto L9;
        r9 = new IslandState(false, false, false, 7, null);
    L9:
        if ((r12 & 4) == 0) goto L12;
        r10 = new AssistInputState(false, null, 3, null);
    L12:
        if ((r12 & 8) == 0) goto L14;
        r11 = null;
    L14:
        this(r8, r9, r10, r11);
    }

    public final PlayerState getPlayer() {
        return this.player;
    }

    public final IslandState getIsland() {
        return this.island;
    }

    public final AssistInputState getAssistState() {
        return this.assistState;
    }

    public final WidgetState getWidgetState() {
        return this.widgetState;
    }
}
