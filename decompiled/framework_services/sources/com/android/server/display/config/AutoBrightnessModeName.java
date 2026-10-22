package com.android.server.display.config;

/* JADX INFO: loaded from: classes2.dex */
public final enum AutoBrightnessModeName extends Enum<AutoBrightnessModeName> {
    private static final /* synthetic */ AutoBrightnessModeName[] $VALUES = null;
    public static final AutoBrightnessModeName _default = null;
    public static final AutoBrightnessModeName bedtime_wear = null;
    public static final AutoBrightnessModeName doze = null;
    public static final AutoBrightnessModeName idle = null;
    private final String rawName;

    private static /* synthetic */ AutoBrightnessModeName[] $values() {
        return new AutoBrightnessModeName[]{_default, idle, doze, bedtime_wear};
    }

    public static AutoBrightnessModeName valueOf(String name) {
        return (AutoBrightnessModeName) Enum.valueOf(AutoBrightnessModeName.class, name);
    }

    public static AutoBrightnessModeName[] values() {
        return (AutoBrightnessModeName[]) $VALUES.clone();
    }

    static {
        _default = new AutoBrightnessModeName("_default", 0, "default");
        idle = new AutoBrightnessModeName("idle", 1, "idle");
        doze = new AutoBrightnessModeName("doze", 2, "doze");
        bedtime_wear = new AutoBrightnessModeName("bedtime_wear", 3, "bedtime_wear");
        $VALUES = $values();
    }

    private AutoBrightnessModeName(String r1, int r2, String rawName) {
        super(r1, r2);
        this.rawName = rawName;
    }

    public String getRawName() {
        return this.rawName;
    }

    static AutoBrightnessModeName fromString(String rawString) {
        AutoBrightnessModeName[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        AutoBrightnessModeName _f = r0[r2];
        if (_f.getRawName().equals(rawString) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return _f;
    L9:
        throw new IllegalArgumentException(rawString);
    }
}
