package com.android.server.backup.restore;

/* JADX INFO: loaded from: classes.dex */
public final enum UnifiedRestoreState extends Enum<UnifiedRestoreState> {
    private static final /* synthetic */ UnifiedRestoreState[] $VALUES = null;
    public static final UnifiedRestoreState FINAL = null;
    public static final UnifiedRestoreState INITIAL = null;
    public static final UnifiedRestoreState RESTORE_FINISHED = null;
    public static final UnifiedRestoreState RESTORE_FULL = null;
    public static final UnifiedRestoreState RESTORE_KEYVALUE = null;
    public static final UnifiedRestoreState RUNNING_QUEUE = null;

    private static /* synthetic */ UnifiedRestoreState[] $values() {
        return new UnifiedRestoreState[]{INITIAL, RUNNING_QUEUE, RESTORE_KEYVALUE, RESTORE_FULL, RESTORE_FINISHED, FINAL};
    }

    private UnifiedRestoreState(String r1, int r2) {
        super(r1, r2);
    }

    public static UnifiedRestoreState valueOf(String name) {
        return (UnifiedRestoreState) Enum.valueOf(UnifiedRestoreState.class, name);
    }

    public static UnifiedRestoreState[] values() {
        return (UnifiedRestoreState[]) $VALUES.clone();
    }

    static {
        INITIAL = new UnifiedRestoreState("INITIAL", 0);
        RUNNING_QUEUE = new UnifiedRestoreState("RUNNING_QUEUE", 1);
        RESTORE_KEYVALUE = new UnifiedRestoreState("RESTORE_KEYVALUE", 2);
        RESTORE_FULL = new UnifiedRestoreState("RESTORE_FULL", 3);
        RESTORE_FINISHED = new UnifiedRestoreState("RESTORE_FINISHED", 4);
        FINAL = new UnifiedRestoreState("FINAL", 5);
        $VALUES = $values();
    }
}
