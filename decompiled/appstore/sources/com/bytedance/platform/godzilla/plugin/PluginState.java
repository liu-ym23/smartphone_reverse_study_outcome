package com.bytedance.platform.godzilla.plugin;

/* JADX INFO: loaded from: classes.dex */
public final enum PluginState extends Enum<PluginState> {
    private static final /* synthetic */ PluginState[] $VALUES = null;
    public static final PluginState DESTROYED = null;
    public static final PluginState INITIALIZED = null;
    public static final PluginState STARTED = null;
    public static final PluginState STOPPED = null;

    static {
        PluginState r10 = new PluginState("INITIALIZED", 0);
        INITIALIZED = r10;
        PluginState r11 = new PluginState("STARTED", 1);
        STARTED = r11;
        PluginState r12 = new PluginState("STOPPED", 2);
        STOPPED = r12;
        PluginState r13 = new PluginState("DESTROYED", 3);
        DESTROYED = r13;
        $VALUES = new PluginState[]{r10, r11, r12, r13};
    }

    private PluginState(String r10, int r11) {
        super(r10, r11);
    }

    public static PluginState valueOf(String r10) {
        return (PluginState) Enum.valueOf(PluginState.class, r10);
    }

    public static PluginState[] values() {
        return (PluginState[]) $VALUES.clone();
    }
}
