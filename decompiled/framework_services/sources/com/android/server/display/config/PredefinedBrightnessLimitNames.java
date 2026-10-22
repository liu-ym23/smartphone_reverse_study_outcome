package com.android.server.display.config;

/* JADX INFO: loaded from: classes2.dex */
public final enum PredefinedBrightnessLimitNames extends Enum<PredefinedBrightnessLimitNames> {
    private static final /* synthetic */ PredefinedBrightnessLimitNames[] $VALUES = null;
    public static final PredefinedBrightnessLimitNames _default = null;
    public static final PredefinedBrightnessLimitNames adaptive = null;
    private final String rawName;

    private static /* synthetic */ PredefinedBrightnessLimitNames[] $values() {
        return new PredefinedBrightnessLimitNames[]{_default, adaptive};
    }

    public static PredefinedBrightnessLimitNames valueOf(String name) {
        return (PredefinedBrightnessLimitNames) Enum.valueOf(PredefinedBrightnessLimitNames.class, name);
    }

    public static PredefinedBrightnessLimitNames[] values() {
        return (PredefinedBrightnessLimitNames[]) $VALUES.clone();
    }

    static {
        _default = new PredefinedBrightnessLimitNames("_default", 0, "default");
        adaptive = new PredefinedBrightnessLimitNames("adaptive", 1, "adaptive");
        $VALUES = $values();
    }

    private PredefinedBrightnessLimitNames(String r1, int r2, String rawName) {
        super(r1, r2);
        this.rawName = rawName;
    }

    public String getRawName() {
        return this.rawName;
    }

    static PredefinedBrightnessLimitNames fromString(String rawString) {
        PredefinedBrightnessLimitNames[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        PredefinedBrightnessLimitNames _f = r0[r2];
        if (_f.getRawName().equals(rawString) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return _f;
    L9:
        throw new IllegalArgumentException(rawString);
    }
}
