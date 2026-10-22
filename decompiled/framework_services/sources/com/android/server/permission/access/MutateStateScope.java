package com.android.server.permission.access;

/* JADX INFO: compiled from: AccessState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutateStateScope extends GetStateScope {
    private final MutableAccessState newState;
    private final AccessState oldState;

    public final MutableAccessState getNewState() {
        return this.newState;
    }

    public final AccessState getOldState() {
        return this.oldState;
    }

    public MutateStateScope(AccessState oldState, MutableAccessState newState) {
        super(newState);
        this.oldState = oldState;
        this.newState = newState;
    }
}
