package com.android.server.permission.access;

import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.access.immutable.MutableReference;

/* JADX INFO: compiled from: AccessState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MutableAccessState extends AccessState {
    private MutableAccessState(MutableReference<ExternalState, MutableExternalState> r2, MutableReference<SystemState, MutableSystemState> r3, MutableReference<IntReferenceMap<UserState, MutableUserState>, MutableIntReferenceMap<UserState, MutableUserState>> r4) {
        super(r2, r3, r4, null);
    }

    public MutableAccessState() {
        this(new MutableReference(new MutableExternalState()), new MutableReference(new MutableSystemState()), new MutableReference(new MutableIntReferenceMap(null, 1, null)));
    }

    public MutableAccessState(AccessState accessState) {
        this(accessState.getExternalStateReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().toImmutable(), accessState.getSystemStateReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().toImmutable(), accessState.getUserStatesReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().toImmutable());
    }

    public final MutableExternalState mutateExternalState() {
        return (MutableExternalState) getExternalStateReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().mutate();
    }

    public static /* synthetic */ MutableSystemState mutateSystemState$default(MutableAccessState r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 1;
    L6:
        return r0.mutateSystemState(r1);
    }

    public final MutableSystemState mutateSystemState(int writeMode) {
        Immutable r0 = getSystemStateReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().mutate();
        MutableSystemState $this$mutateSystemState_u24lambda_u240 = (MutableSystemState) r0;
        $this$mutateSystemState_u24lambda_u240.requestWriteMode(writeMode);
        return (MutableSystemState) r0;
    }

    public final MutableIntReferenceMap<UserState, MutableUserState> mutateUserStatesNoWrite() {
        return (MutableIntReferenceMap) getUserStatesReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar().mutate();
    }

    public static /* synthetic */ MutableUserState mutateUserState$default(MutableAccessState r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 1;
    L6:
        return r0.mutateUserState(r1, r2);
    }

    public final MutableUserState mutateUserState(int userId, int writeMode) {
        MutableUserState $this$mutateUserState_u24lambda_u241 = (MutableUserState) mutateUserStatesNoWrite().mutate(userId);
        if ($this$mutateUserState_u24lambda_u241 == null) goto L5;
        $this$mutateUserState_u24lambda_u241.requestWriteMode(writeMode);
        return $this$mutateUserState_u24lambda_u241;
    L5:
        return null;
    }

    public static /* synthetic */ MutableUserState mutateUserStateAt$default(MutableAccessState r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 1;
    L6:
        return r0.mutateUserStateAt(r1, r2);
    }

    public final MutableUserState mutateUserStateAt(int index, int writeMode) {
        Immutable r0 = mutateUserStatesNoWrite().mutateAt(index);
        MutableUserState $this$mutateUserStateAt_u24lambda_u242 = (MutableUserState) r0;
        $this$mutateUserStateAt_u24lambda_u242.requestWriteMode(writeMode);
        return (MutableUserState) r0;
    }
}
