package com.android.server.display.config;

/* JADX INFO: loaded from: classes2.dex */
public final enum ThermalStatus extends Enum<ThermalStatus> {
    private static final /* synthetic */ ThermalStatus[] $VALUES = null;
    public static final ThermalStatus critical = null;
    public static final ThermalStatus emergency = null;
    public static final ThermalStatus light = null;
    public static final ThermalStatus moderate = null;
    public static final ThermalStatus none = null;
    public static final ThermalStatus severe = null;
    public static final ThermalStatus shutdown = null;
    private final String rawName;

    private static /* synthetic */ ThermalStatus[] $values() {
        return new ThermalStatus[]{none, light, moderate, severe, critical, emergency, shutdown};
    }

    public static ThermalStatus valueOf(String name) {
        return (ThermalStatus) Enum.valueOf(ThermalStatus.class, name);
    }

    public static ThermalStatus[] values() {
        return (ThermalStatus[]) $VALUES.clone();
    }

    static {
        none = new ThermalStatus("none", 0, "none");
        light = new ThermalStatus("light", 1, "light");
        moderate = new ThermalStatus("moderate", 2, "moderate");
        severe = new ThermalStatus("severe", 3, "severe");
        critical = new ThermalStatus("critical", 4, "critical");
        emergency = new ThermalStatus("emergency", 5, "emergency");
        shutdown = new ThermalStatus("shutdown", 6, "shutdown");
        $VALUES = $values();
    }

    private ThermalStatus(String r1, int r2, String rawName) {
        super(r1, r2);
        this.rawName = rawName;
    }

    public String getRawName() {
        return this.rawName;
    }

    static ThermalStatus fromString(String rawString) {
        ThermalStatus[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        ThermalStatus _f = r0[r2];
        if (_f.getRawName().equals(rawString) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return _f;
    L9:
        throw new IllegalArgumentException(rawString);
    }
}
