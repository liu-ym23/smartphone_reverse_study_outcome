package com.stepos.ailauncher.contract.model;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", "", "<init>", "(Ljava/lang/String;I)V", "AVAILABLE", ModelFlowMeta.PLAN_UNAVAILABLE, "BLOCKED", "UNKNOWN", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtifactAvailability {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ArtifactAvailability[] $VALUES;
    public static final ArtifactAvailability AVAILABLE = new ArtifactAvailability("AVAILABLE", 0);
    public static final ArtifactAvailability UNAVAILABLE = new ArtifactAvailability(ModelFlowMeta.PLAN_UNAVAILABLE, 1);
    public static final ArtifactAvailability BLOCKED = new ArtifactAvailability("BLOCKED", 2);
    public static final ArtifactAvailability UNKNOWN = new ArtifactAvailability("UNKNOWN", 3);

    private static final /* synthetic */ ArtifactAvailability[] $values() {
        return new ArtifactAvailability[]{AVAILABLE, UNAVAILABLE, BLOCKED, UNKNOWN};
    }

    static {
        ArtifactAvailability[] artifactAvailabilityArr$values = $values();
        $VALUES = artifactAvailabilityArr$values;
        $ENTRIES = a.a(artifactAvailabilityArr$values);
    }

    private ArtifactAvailability(String str, int i10) {
    }

    public static InterfaceC4149a<ArtifactAvailability> getEntries() {
        return $ENTRIES;
    }

    public static ArtifactAvailability valueOf(String str) {
        return (ArtifactAvailability) Enum.valueOf(ArtifactAvailability.class, str);
    }

    public static ArtifactAvailability[] values() {
        return (ArtifactAvailability[]) $VALUES.clone();
    }
}
