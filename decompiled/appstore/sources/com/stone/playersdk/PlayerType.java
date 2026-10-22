package com.stone.playersdk;

/* JADX INFO: loaded from: classes4.dex */
public final enum PlayerType extends Enum<PlayerType> {
    private static final /* synthetic */ PlayerType[] $VALUES = null;
    public static final PlayerType EXO_PLAYER = null;
    public static final PlayerType IJK_PLAYER = null;
    public static final PlayerType MEDIA_PLAYER = null;

    static {
        PlayerType r10 = new PlayerType("MEDIA_PLAYER", 0);
        MEDIA_PLAYER = r10;
        PlayerType r11 = new PlayerType("EXO_PLAYER", 1);
        EXO_PLAYER = r11;
        PlayerType r12 = new PlayerType("IJK_PLAYER", 2);
        IJK_PLAYER = r12;
        $VALUES = new PlayerType[]{r10, r11, r12};
    }

    private PlayerType(String r10, int r11) {
        super(r10, r11);
    }

    public static PlayerType valueOf(String r10) {
        return (PlayerType) Enum.valueOf(PlayerType.class, r10);
    }

    public static PlayerType[] values() {
        return (PlayerType[]) $VALUES.clone();
    }
}
