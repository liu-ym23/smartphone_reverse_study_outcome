package com.obric.common.oea.style.scene.alpha.alphaplayer.player;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "", "(Ljava/lang/String;I)V", "NOT_PREPARED", "PREPARED", "STARTED", "PAUSED", "STOPPED", "RELEASE", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayerState extends Enum<PlayerState> {
    private static final /* synthetic */ PlayerState[] $VALUES = null;
    public static final PlayerState NOT_PREPARED = null;
    public static final PlayerState PAUSED = null;
    public static final PlayerState PREPARED = null;
    public static final PlayerState RELEASE = null;
    public static final PlayerState STARTED = null;
    public static final PlayerState STOPPED = null;

    static {
        PlayerState r10 = new PlayerState("NOT_PREPARED", 0);
        NOT_PREPARED = r10;
        PlayerState r11 = new PlayerState("PREPARED", 1);
        PREPARED = r11;
        PlayerState r12 = new PlayerState("STARTED", 2);
        STARTED = r12;
        PlayerState r13 = new PlayerState("PAUSED", 3);
        PAUSED = r13;
        PlayerState r14 = new PlayerState("STOPPED", 4);
        STOPPED = r14;
        PlayerState r15 = new PlayerState("RELEASE", 5);
        RELEASE = r15;
        $VALUES = new PlayerState[]{r10, r11, r12, r13, r14, r15};
    }

    private PlayerState(String r10, int r11) {
        super(r10, r11);
    }

    public static PlayerState valueOf(String r10) {
        return (PlayerState) Enum.valueOf(PlayerState.class, r10);
    }

    public static PlayerState[] values() {
        return (PlayerState[]) $VALUES.clone();
    }
}
