package com.stepos.ailauncher.agent.skill;

import androidx.annotation.Keep;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/SkillSource;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "TESTING", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillSource {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SkillSource[] $VALUES;
    public static final SkillSource NORMAL = new SkillSource("NORMAL", 0);
    public static final SkillSource TESTING = new SkillSource("TESTING", 1);

    private static final /* synthetic */ SkillSource[] $values() {
        return new SkillSource[]{NORMAL, TESTING};
    }

    static {
        SkillSource[] skillSourceArr$values = $values();
        $VALUES = skillSourceArr$values;
        $ENTRIES = a.a(skillSourceArr$values);
    }

    private SkillSource(String str, int i10) {
    }

    public static InterfaceC4149a<SkillSource> getEntries() {
        return $ENTRIES;
    }

    public static SkillSource valueOf(String str) {
        return (SkillSource) Enum.valueOf(SkillSource.class, str);
    }

    public static SkillSource[] values() {
        return (SkillSource[]) $VALUES.clone();
    }
}
