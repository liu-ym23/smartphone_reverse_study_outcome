package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentbus/generated/Role;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "USER", "ASSISTANT", "SYSTEM", "TOOL", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Role {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ Role[] $VALUES;
    public static final Role USER = new Role("USER", 0);
    public static final Role ASSISTANT = new Role("ASSISTANT", 1);
    public static final Role SYSTEM = new Role("SYSTEM", 2);
    public static final Role TOOL = new Role("TOOL", 3);

    private static final /* synthetic */ Role[] $values() {
        return new Role[]{USER, ASSISTANT, SYSTEM, TOOL};
    }

    static {
        Role[] roleArr$values = $values();
        $VALUES = roleArr$values;
        $ENTRIES = kotlin.enums.a.a(roleArr$values);
    }

    private Role(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static Role valueOf(String str) {
        return (Role) Enum.valueOf(Role.class, str);
    }

    public static Role[] values() {
        return (Role[]) $VALUES.clone();
    }
}
