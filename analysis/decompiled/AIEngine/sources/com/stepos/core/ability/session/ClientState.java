package com.stepos.core.ability.session;

import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ClientState {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ClientState[] $VALUES;
    public static final ClientState ACTIVE = new ClientState("ACTIVE", 0);
    public static final ClientState IDLE = new ClientState("IDLE", 1);

    private static final /* synthetic */ ClientState[] $values() {
        return new ClientState[]{ACTIVE, IDLE};
    }

    static {
        ClientState[] clientStateArr$values = $values();
        $VALUES = clientStateArr$values;
        $ENTRIES = kotlin.enums.a.a(clientStateArr$values);
    }

    private ClientState(String str, int i10) {
    }

    public static a<ClientState> getEntries() {
        return $ENTRIES;
    }

    public static ClientState valueOf(String str) {
        return (ClientState) Enum.valueOf(ClientState.class, str);
    }

    public static ClientState[] values() {
        return (ClientState[]) $VALUES.clone();
    }
}
