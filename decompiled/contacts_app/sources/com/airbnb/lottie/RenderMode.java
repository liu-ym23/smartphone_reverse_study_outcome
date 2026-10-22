package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public final enum RenderMode extends Enum<RenderMode> {
    private static final /* synthetic */ RenderMode[] $VALUES = null;
    public static final RenderMode AUTOMATIC = null;
    public static final RenderMode HARDWARE = null;
    public static final RenderMode SOFTWARE = null;

    /* JADX INFO: renamed from: com.airbnb.lottie.RenderMode$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$RenderMode = null;

        static {
            int[] r0 = new int[RenderMode.values().length];
            $SwitchMap$com$airbnb$lottie$RenderMode = r0;
            r0[RenderMode.HARDWARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$airbnb$lottie$RenderMode[RenderMode.SOFTWARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$airbnb$lottie$RenderMode[RenderMode.AUTOMATIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static /* synthetic */ RenderMode[] $values() {
        return new RenderMode[]{AUTOMATIC, HARDWARE, SOFTWARE};
    }

    private RenderMode(String r1, int r2) {
        super(r1, r2);
    }

    public static RenderMode valueOf(String r1) {
        return (RenderMode) Enum.valueOf(RenderMode.class, r1);
    }

    public static RenderMode[] values() {
        return (RenderMode[]) $VALUES.clone();
    }

    static {
        AUTOMATIC = new RenderMode("AUTOMATIC", 0);
        HARDWARE = new RenderMode("HARDWARE", 1);
        SOFTWARE = new RenderMode("SOFTWARE", 2);
        $VALUES = $values();
    }

    public boolean useSoftwareRendering(int r4, boolean r5, int r6) {
        int r3 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$RenderMode[ordinal()];
        if (r3 != 1) goto L5;
        return false;
    L5:
        if (r3 == 2) goto L17;
        if (r5 == false) goto L11;
        if (r4 >= 28) goto L11;
        return true;
    L11:
        if (r6 <= 4) goto L14;
        return true;
    L14:
        if (r4 <= 25) goto L16;
        return false;
    L16:
        return true;
    L17:
        return true;
    }
}
