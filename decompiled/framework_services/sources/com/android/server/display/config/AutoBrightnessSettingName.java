package com.android.server.display.config;

/* JADX INFO: loaded from: classes2.dex */
public final enum AutoBrightnessSettingName extends Enum<AutoBrightnessSettingName> {
    private static final /* synthetic */ AutoBrightnessSettingName[] $VALUES = null;
    public static final AutoBrightnessSettingName bright = null;
    public static final AutoBrightnessSettingName dim = null;
    public static final AutoBrightnessSettingName normal = null;
    private final String rawName;

    private static /* synthetic */ AutoBrightnessSettingName[] $values() {
        return new AutoBrightnessSettingName[]{dim, normal, bright};
    }

    public static AutoBrightnessSettingName valueOf(String name) {
        return (AutoBrightnessSettingName) Enum.valueOf(AutoBrightnessSettingName.class, name);
    }

    public static AutoBrightnessSettingName[] values() {
        return (AutoBrightnessSettingName[]) $VALUES.clone();
    }

    static {
        dim = new AutoBrightnessSettingName("dim", 0, "dim");
        normal = new AutoBrightnessSettingName("normal", 1, "normal");
        bright = new AutoBrightnessSettingName("bright", 2, "bright");
        $VALUES = $values();
    }

    private AutoBrightnessSettingName(String r1, int r2, String rawName) {
        super(r1, r2);
        this.rawName = rawName;
    }

    public String getRawName() {
        return this.rawName;
    }

    static AutoBrightnessSettingName fromString(String rawString) {
        AutoBrightnessSettingName[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        AutoBrightnessSettingName _f = r0[r2];
        if (_f.getRawName().equals(rawString) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return _f;
    L9:
        throw new IllegalArgumentException(rawString);
    }
}
