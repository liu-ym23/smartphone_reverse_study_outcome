package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes.dex */
final enum HandshakeType extends Enum<HandshakeType> {
    private static final /* synthetic */ HandshakeType[] $VALUES = null;
    public static final HandshakeType HANDSHAKE_FULL = null;
    public static final HandshakeType HANDSHAKE_RESUME = null;
    public static final HandshakeType HANDSHAKE_UNKNOWN = null;

    static {
        HandshakeType r10 = new HandshakeType("HANDSHAKE_UNKNOWN", 0);
        HANDSHAKE_UNKNOWN = r10;
        HandshakeType r11 = new HandshakeType("HANDSHAKE_RESUME", 1);
        HANDSHAKE_RESUME = r11;
        HandshakeType r12 = new HandshakeType("HANDSHAKE_FULL", 2);
        HANDSHAKE_FULL = r12;
        $VALUES = new HandshakeType[]{r10, r11, r12};
    }

    private HandshakeType(String r10, int r11) {
        super(r10, r11);
    }

    public static HandshakeType valueOf(String r10) {
        return (HandshakeType) Enum.valueOf(HandshakeType.class, r10);
    }

    public static HandshakeType[] values() {
        return (HandshakeType[]) $VALUES.clone();
    }
}
