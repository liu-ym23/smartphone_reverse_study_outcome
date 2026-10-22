package com.obric.cloudsdk.kv.syncstate;

import kotlin.Metadata;

/* JADX INFO: compiled from: SyncState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/cloudsdk/kv/syncstate/SyncState;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NOT_STARTED", "SYNCING", "FINISHED", "ERROR", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum SyncState extends Enum<SyncState> {
    private static final /* synthetic */ SyncState[] $VALUES = null;
    public static final SyncState ERROR = null;
    public static final SyncState FINISHED = null;
    public static final SyncState NOT_STARTED = null;
    public static final SyncState SYNCING = null;
    private final int value;

    private static final /* synthetic */ SyncState[] $values() {
        return new SyncState[]{NOT_STARTED, SYNCING, FINISHED, ERROR};
    }

    public static SyncState valueOf(String r1) {
        return (SyncState) Enum.valueOf(SyncState.class, r1);
    }

    public static SyncState[] values() {
        return (SyncState[]) $VALUES.clone();
    }

    private SyncState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        NOT_STARTED = new SyncState("NOT_STARTED", 0, 0);
        SYNCING = new SyncState("SYNCING", 1, 1);
        FINISHED = new SyncState("FINISHED", 2, 2);
        ERROR = new SyncState("ERROR", 3, 3);
        $VALUES = $values();
    }
}
