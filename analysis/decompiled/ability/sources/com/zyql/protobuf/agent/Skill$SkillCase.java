package com.zyql.protobuf.agent;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class Skill$SkillCase {

    /* renamed from: a, reason: collision with root package name */
    public static final Skill$SkillCase f4255a;
    public static final Skill$SkillCase b;
    public static final Skill$SkillCase c;
    public static final /* synthetic */ Skill$SkillCase[] d;

    static {
        Skill$SkillCase skill$SkillCase = new Skill$SkillCase("INLINE_SKILL", 0);
        f4255a = skill$SkillCase;
        Skill$SkillCase skill$SkillCase2 = new Skill$SkillCase("DIR_SKILL_LOADER", 1);
        b = skill$SkillCase2;
        Skill$SkillCase skill$SkillCase3 = new Skill$SkillCase("SKILL_NOT_SET", 2);
        c = skill$SkillCase3;
        d = new Skill$SkillCase[]{skill$SkillCase, skill$SkillCase2, skill$SkillCase3};
    }

    public static Skill$SkillCase valueOf(String str) {
        return (Skill$SkillCase) Enum.valueOf(Skill$SkillCase.class, str);
    }

    public static Skill$SkillCase[] values() {
        return (Skill$SkillCase[]) d.clone();
    }
}
