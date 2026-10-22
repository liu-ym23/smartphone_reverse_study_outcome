package com.zyql.protobuf.agent;

import com.google.protobuf.MessageLiteOrBuilder;
import com.zyql.protobuf.agent.Skill;

/* loaded from: classes4.dex */
public interface SkillOrBuilder extends MessageLiteOrBuilder {
    DirSkillLoader getDirSkillLoader();

    InlineSkill getInlineSkill();

    Skill.SkillCase getSkillCase();

    boolean hasDirSkillLoader();

    boolean hasInlineSkill();
}
