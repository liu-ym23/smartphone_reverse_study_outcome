package com.bytedance.common.wschannel.event;

/* JADX INFO: loaded from: classes.dex */
public final enum ChannelType extends Enum<ChannelType> {
    private static final /* synthetic */ ChannelType[] $VALUES = null;
    public static final ChannelType CHANNEL_OK = null;
    public static final ChannelType CHANNEL_SELF = null;
    int mTypeValue;

    static {
        ChannelType r10 = new ChannelType("CHANNEL_SELF", 0, 1);
        CHANNEL_SELF = r10;
        ChannelType r11 = new ChannelType("CHANNEL_OK", 1, 2);
        CHANNEL_OK = r11;
        $VALUES = new ChannelType[]{r10, r11};
    }

    private ChannelType(String r10, int r11, int r12) {
        super(r10, r11);
        this.mTypeValue = r12;
    }

    public static ChannelType of(int r10) {
        if (r10 != 1) goto L7;
        return CHANNEL_SELF;
    L7:
        return CHANNEL_OK;
    }

    public static ChannelType valueOf(String r10) {
        return (ChannelType) Enum.valueOf(ChannelType.class, r10);
    }

    public static ChannelType[] values() {
        return (ChannelType[]) $VALUES.clone();
    }

    public int getVal() {
        return this.mTypeValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ChannelType{Type=" + this.mTypeValue + '}';
    }
}
