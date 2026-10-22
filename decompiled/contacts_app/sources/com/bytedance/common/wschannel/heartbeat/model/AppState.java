package com.bytedance.common.wschannel.heartbeat.model;

/* JADX INFO: loaded from: classes2.dex */
public final enum AppState extends Enum<AppState> {
    private static final /* synthetic */ AppState[] $VALUES = null;
    public static final AppState STATE_BACKGROUND = null;
    public static final AppState STATE_DOZE = null;
    public static final AppState STATE_FOREGROUND = null;
    public static final AppState STATE_LIGHT_DOZE = null;

    private AppState(String r1, int r2) {
        super(r1, r2);
    }

    public static AppState valueOf(String r1) {
        return (AppState) Enum.valueOf(AppState.class, r1);
    }

    public static AppState[] values() {
        return (AppState[]) $VALUES.clone();
    }

    static {
        AppState r0 = new AppState("STATE_FOREGROUND", 0);
        STATE_FOREGROUND = r0;
        AppState r1 = new AppState("STATE_BACKGROUND", 1);
        STATE_BACKGROUND = r1;
        AppState r3 = new AppState("STATE_LIGHT_DOZE", 2);
        STATE_LIGHT_DOZE = r3;
        AppState r5 = new AppState("STATE_DOZE", 3);
        STATE_DOZE = r5;
        $VALUES = new AppState[]{r0, r1, r3, r5};
    }
}
