package com.android.server.permission.access;

import com.android.server.permission.access.immutable.Immutable;
import com.android.server.permission.access.immutable.IntReferenceMap;
import com.android.server.permission.access.immutable.MutableIntReferenceMap;
import com.android.server.permission.access.immutable.MutableReference;
import com.android.server.permission.jarjar.kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AccessState.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AccessState implements Immutable<MutableAccessState> {
    private final MutableReference<ExternalState, MutableExternalState> externalStateReference;
    private final MutableReference<SystemState, MutableSystemState> systemStateReference;
    private final MutableReference<IntReferenceMap<UserState, MutableUserState>, MutableIntReferenceMap<UserState, MutableUserState>> userStatesReference;

    public /* synthetic */ AccessState(MutableReference r1, MutableReference r2, MutableReference r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    private AccessState(MutableReference<ExternalState, MutableExternalState> r1, MutableReference<SystemState, MutableSystemState> r2, MutableReference<IntReferenceMap<UserState, MutableUserState>, MutableIntReferenceMap<UserState, MutableUserState>> r3) {
        this.externalStateReference = r1;
        this.systemStateReference = r2;
        this.userStatesReference = r3;
    }

    @Override // com.android.server.permission.access.immutable.Immutable
    public /* bridge */ /* synthetic */ MutableAccessState toMutable() {
        return toMutable();
    }

    public final MutableReference<ExternalState, MutableExternalState> getExternalStateReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.externalStateReference;
    }

    public final MutableReference<SystemState, MutableSystemState> getSystemStateReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.systemStateReference;
    }

    public final MutableReference<IntReferenceMap<UserState, MutableUserState>, MutableIntReferenceMap<UserState, MutableUserState>> getUserStatesReference$frameworks__base__services__permission__android_common__services_permission_pre_jarjar() {
        return this.userStatesReference;
    }

    public final ExternalState getExternalState() {
        return (ExternalState) this.externalStateReference.get();
    }

    public final SystemState getSystemState() {
        return (SystemState) this.systemStateReference.get();
    }

    public final IntReferenceMap<UserState, MutableUserState> getUserStates() {
        return (IntReferenceMap) this.userStatesReference.get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.server.permission.access.immutable.Immutable
    public MutableAccessState toMutable() {
        return new MutableAccessState(this);
    }
}
