package com.tencent.mmkv;

/* JADX INFO: loaded from: classes4.dex */
public final enum MMKVRecoverStrategic extends Enum<MMKVRecoverStrategic> {
    private static final /* synthetic */ MMKVRecoverStrategic[] $VALUES = null;
    public static final MMKVRecoverStrategic OnErrorDiscard = null;
    public static final MMKVRecoverStrategic OnErrorRecover = null;

    static {
        MMKVRecoverStrategic r10 = new MMKVRecoverStrategic("OnErrorDiscard", 0);
        OnErrorDiscard = r10;
        MMKVRecoverStrategic r11 = new MMKVRecoverStrategic("OnErrorRecover", 1);
        OnErrorRecover = r11;
        $VALUES = new MMKVRecoverStrategic[]{r10, r11};
    }

    private MMKVRecoverStrategic(String r10, int r11) {
        super(r10, r11);
    }

    public static MMKVRecoverStrategic valueOf(String r10) {
        return (MMKVRecoverStrategic) Enum.valueOf(MMKVRecoverStrategic.class, r10);
    }

    public static MMKVRecoverStrategic[] values() {
        return (MMKVRecoverStrategic[]) $VALUES.clone();
    }
}
