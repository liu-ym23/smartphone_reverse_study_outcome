package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes2.dex */
public final enum Timebase extends Enum<Timebase> {
    private static final /* synthetic */ Timebase[] $VALUES = null;
    public static final Timebase REALTIME = null;
    public static final Timebase UPTIME = null;

    private static /* synthetic */ Timebase[] $values() {
        return new Timebase[]{UPTIME, REALTIME};
    }

    static {
        UPTIME = new Timebase("UPTIME", 0);
        REALTIME = new Timebase("REALTIME", 1);
        $VALUES = $values();
    }

    public static Timebase[] values() {
        return (Timebase[]) $VALUES.clone();
    }

    public static Timebase valueOf(String r100) {
        return (Timebase) r27.a.a(Timebase.class, r100);
    }

    private Timebase(String r100, int r101) {
        super(r100, r101);
    }
}
