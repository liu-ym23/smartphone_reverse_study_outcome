package com.stepos.ailauncher.common.utils;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/common/utils/NetworkPhase;", "", "<init>", "(Ljava/lang/String;I)V", "AVAILABLE", "CONNECTING", "LOST", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkPhase {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ NetworkPhase[] $VALUES;
    public static final NetworkPhase AVAILABLE = new NetworkPhase("AVAILABLE", 0);
    public static final NetworkPhase CONNECTING = new NetworkPhase("CONNECTING", 1);
    public static final NetworkPhase LOST = new NetworkPhase("LOST", 2);

    private static final /* synthetic */ NetworkPhase[] $values() {
        return new NetworkPhase[]{AVAILABLE, CONNECTING, LOST};
    }

    static {
        NetworkPhase[] networkPhaseArr$values = $values();
        $VALUES = networkPhaseArr$values;
        $ENTRIES = kotlin.enums.a.a(networkPhaseArr$values);
    }

    private NetworkPhase(String str, int i10) {
    }

    public static InterfaceC4149a<NetworkPhase> getEntries() {
        return $ENTRIES;
    }

    public static NetworkPhase valueOf(String str) {
        return (NetworkPhase) Enum.valueOf(NetworkPhase.class, str);
    }

    public static NetworkPhase[] values() {
        return (NetworkPhase[]) $VALUES.clone();
    }
}
