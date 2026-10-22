package com.jeffmony.async.util;

/* JADX INFO: loaded from: classes3.dex */
public final enum ThrottleTimeout$ThrottleMode extends Enum<ThrottleTimeout$ThrottleMode> {
    private static final /* synthetic */ ThrottleTimeout$ThrottleMode[] $VALUES = null;
    public static final ThrottleTimeout$ThrottleMode Collect = null;
    public static final ThrottleTimeout$ThrottleMode Meter = null;

    static {
        ThrottleTimeout$ThrottleMode r10 = new ThrottleTimeout$ThrottleMode("Collect", 0);
        Collect = r10;
        ThrottleTimeout$ThrottleMode r11 = new ThrottleTimeout$ThrottleMode("Meter", 1);
        Meter = r11;
        $VALUES = new ThrottleTimeout$ThrottleMode[]{r10, r11};
    }

    private ThrottleTimeout$ThrottleMode(String r10, int r11) {
        super(r10, r11);
    }

    public static ThrottleTimeout$ThrottleMode valueOf(String r10) {
        return (ThrottleTimeout$ThrottleMode) Enum.valueOf(ThrottleTimeout$ThrottleMode.class, r10);
    }

    public static ThrottleTimeout$ThrottleMode[] values() {
        return (ThrottleTimeout$ThrottleMode[]) $VALUES.clone();
    }
}
