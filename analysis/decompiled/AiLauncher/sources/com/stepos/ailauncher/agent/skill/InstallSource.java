package com.stepos.ailauncher.agent.skill;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/InstallSource;", "", "<init>", "(Ljava/lang/String;I)V", "CLOUD", "LOCAL", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstallSource {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ InstallSource[] $VALUES;
    public static final InstallSource CLOUD = new InstallSource("CLOUD", 0);
    public static final InstallSource LOCAL = new InstallSource("LOCAL", 1);

    private static final /* synthetic */ InstallSource[] $values() {
        return new InstallSource[]{CLOUD, LOCAL};
    }

    static {
        InstallSource[] installSourceArr$values = $values();
        $VALUES = installSourceArr$values;
        $ENTRIES = a.a(installSourceArr$values);
    }

    private InstallSource(String str, int i10) {
    }

    public static InterfaceC4149a<InstallSource> getEntries() {
        return $ENTRIES;
    }

    public static InstallSource valueOf(String str) {
        return (InstallSource) Enum.valueOf(InstallSource.class, str);
    }

    public static InstallSource[] values() {
        return (InstallSource[]) $VALUES.clone();
    }
}
