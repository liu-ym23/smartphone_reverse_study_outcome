package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.CallingMethod;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentbus/generated/InstallSource;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "BUNDLED", CallingMethod.LOCAL, "REMOTE", "UNKNOWN", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InstallSource {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ InstallSource[] $VALUES;
    public static final InstallSource BUNDLED = new InstallSource("BUNDLED", 0);
    public static final InstallSource LOCAL = new InstallSource(CallingMethod.LOCAL, 1);
    public static final InstallSource REMOTE = new InstallSource("REMOTE", 2);
    public static final InstallSource UNKNOWN = new InstallSource("UNKNOWN", 3);

    private static final /* synthetic */ InstallSource[] $values() {
        return new InstallSource[]{BUNDLED, LOCAL, REMOTE, UNKNOWN};
    }

    static {
        InstallSource[] installSourceArr$values = $values();
        $VALUES = installSourceArr$values;
        $ENTRIES = kotlin.enums.a.a(installSourceArr$values);
    }

    private InstallSource(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static InstallSource valueOf(String str) {
        return (InstallSource) Enum.valueOf(InstallSource.class, str);
    }

    public static InstallSource[] values() {
        return (InstallSource[]) $VALUES.clone();
    }
}
