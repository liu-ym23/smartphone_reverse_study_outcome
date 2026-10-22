package com.zyql.protobuf.agent;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.C1771g;
import o7.r;
import o7.x;

/* loaded from: classes2.dex */
public final class Skill$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Skill$Builder(int i) {
        this();
    }

    public Skill$Builder clearDirSkillLoader() {
        copyOnWrite();
        x.D((x) this.instance);
        return this;
    }

    public Skill$Builder clearInlineSkill() {
        copyOnWrite();
        x.E((x) this.instance);
        return this;
    }

    public Skill$Builder clearSkill() {
        copyOnWrite();
        x.F((x) this.instance);
        return this;
    }

    public C1771g getDirSkillLoader() {
        return ((x) this.instance).L();
    }

    public r getInlineSkill() {
        return ((x) this.instance).M();
    }

    public Skill$SkillCase getSkillCase() {
        return ((x) this.instance).N();
    }

    public boolean hasDirSkillLoader() {
        return ((x) this.instance).O();
    }

    public boolean hasInlineSkill() {
        return ((x) this.instance).P();
    }

    public Skill$Builder mergeDirSkillLoader(C1771g c1771g) {
        copyOnWrite();
        x.G((x) this.instance, c1771g);
        return this;
    }

    public Skill$Builder mergeInlineSkill(r rVar) {
        copyOnWrite();
        x.H((x) this.instance, rVar);
        return this;
    }

    public Skill$Builder setDirSkillLoader(C1771g c1771g) {
        copyOnWrite();
        x.I((x) this.instance, c1771g);
        return this;
    }

    public Skill$Builder setInlineSkill(r rVar) {
        copyOnWrite();
        x.J((x) this.instance, rVar);
        return this;
    }

    private Skill$Builder() {
        super(x.DEFAULT_INSTANCE);
    }

    public Skill$Builder setDirSkillLoader(DirSkillLoader$Builder dirSkillLoader$Builder) {
        copyOnWrite();
        x.I((x) this.instance, (C1771g) dirSkillLoader$Builder.k());
        return this;
    }

    public Skill$Builder setInlineSkill(InlineSkill$Builder inlineSkill$Builder) {
        copyOnWrite();
        x.J((x) this.instance, (r) inlineSkill$Builder.k());
        return this;
    }
}
