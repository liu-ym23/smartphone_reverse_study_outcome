package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentbus/generated/ActorSource;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "USER", "MODEL", "SYSTEM", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ActorSource {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ ActorSource[] $VALUES;
    public static final ActorSource USER = new ActorSource("USER", 0);
    public static final ActorSource MODEL = new ActorSource("MODEL", 1);
    public static final ActorSource SYSTEM = new ActorSource("SYSTEM", 2);

    private static final /* synthetic */ ActorSource[] $values() {
        return new ActorSource[]{USER, MODEL, SYSTEM};
    }

    static {
        ActorSource[] actorSourceArr$values = $values();
        $VALUES = actorSourceArr$values;
        $ENTRIES = kotlin.enums.a.a(actorSourceArr$values);
    }

    private ActorSource(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static ActorSource valueOf(String str) {
        return (ActorSource) Enum.valueOf(ActorSource.class, str);
    }

    public static ActorSource[] values() {
        return (ActorSource[]) $VALUES.clone();
    }
}
