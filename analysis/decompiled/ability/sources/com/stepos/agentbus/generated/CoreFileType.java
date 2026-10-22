package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/agentbus/generated/CoreFileType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "SOUL", "AGENTS", "USER", "MEMORY", "TOOLS", "IDENTITY", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CoreFileType {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ CoreFileType[] $VALUES;
    public static final CoreFileType SOUL = new CoreFileType("SOUL", 0);
    public static final CoreFileType AGENTS = new CoreFileType("AGENTS", 1);
    public static final CoreFileType USER = new CoreFileType("USER", 2);
    public static final CoreFileType MEMORY = new CoreFileType("MEMORY", 3);
    public static final CoreFileType TOOLS = new CoreFileType("TOOLS", 4);
    public static final CoreFileType IDENTITY = new CoreFileType("IDENTITY", 5);

    private static final /* synthetic */ CoreFileType[] $values() {
        return new CoreFileType[]{SOUL, AGENTS, USER, MEMORY, TOOLS, IDENTITY};
    }

    static {
        CoreFileType[] coreFileTypeArr$values = $values();
        $VALUES = coreFileTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(coreFileTypeArr$values);
    }

    private CoreFileType(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static CoreFileType valueOf(String str) {
        return (CoreFileType) Enum.valueOf(CoreFileType.class, str);
    }

    public static CoreFileType[] values() {
        return (CoreFileType[]) $VALUES.clone();
    }
}
