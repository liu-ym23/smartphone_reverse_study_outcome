package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public final enum AsyncUpdates extends Enum<AsyncUpdates> {
    private static final /* synthetic */ AsyncUpdates[] $VALUES = null;
    public static final AsyncUpdates AUTOMATIC = null;
    public static final AsyncUpdates DISABLED = null;
    public static final AsyncUpdates ENABLED = null;

    private static /* synthetic */ AsyncUpdates[] $values() {
        return new AsyncUpdates[]{AUTOMATIC, ENABLED, DISABLED};
    }

    private AsyncUpdates(String r1, int r2) {
        super(r1, r2);
    }

    public static AsyncUpdates valueOf(String r1) {
        return (AsyncUpdates) Enum.valueOf(AsyncUpdates.class, r1);
    }

    public static AsyncUpdates[] values() {
        return (AsyncUpdates[]) $VALUES.clone();
    }

    static {
        AUTOMATIC = new AsyncUpdates("AUTOMATIC", 0);
        ENABLED = new AsyncUpdates("ENABLED", 1);
        DISABLED = new AsyncUpdates("DISABLED", 2);
        $VALUES = $values();
    }
}
