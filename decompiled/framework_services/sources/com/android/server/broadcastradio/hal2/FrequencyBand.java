package com.android.server.broadcastradio.hal2;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes.dex */
final enum FrequencyBand extends Enum<FrequencyBand> {
    private static final /* synthetic */ FrequencyBand[] $VALUES = null;
    public static final FrequencyBand AM_LW = null;
    public static final FrequencyBand AM_MW = null;
    public static final FrequencyBand AM_SW = null;
    public static final FrequencyBand FM = null;
    public static final FrequencyBand UNKNOWN = null;

    private static /* synthetic */ FrequencyBand[] $values() {
        return new FrequencyBand[]{UNKNOWN, FM, AM_LW, AM_MW, AM_SW};
    }

    private FrequencyBand(String r1, int r2) {
        super(r1, r2);
    }

    public static FrequencyBand valueOf(String name) {
        return (FrequencyBand) Enum.valueOf(FrequencyBand.class, name);
    }

    public static FrequencyBand[] values() {
        return (FrequencyBand[]) $VALUES.clone();
    }

    static {
        UNKNOWN = new FrequencyBand("UNKNOWN", 0);
        FM = new FrequencyBand("FM", 1);
        AM_LW = new FrequencyBand("AM_LW", 2);
        AM_MW = new FrequencyBand("AM_MW", 3);
        AM_SW = new FrequencyBand("AM_SW", 4);
        $VALUES = $values();
    }
}
