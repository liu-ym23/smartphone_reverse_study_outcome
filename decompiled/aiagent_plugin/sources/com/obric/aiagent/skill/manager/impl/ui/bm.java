package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.skill.manager.impl.cw;
import com.obric.aiagent.skill.manager.impl.ee;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillPageAvailabilityChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bm f20656a = null;

    static {
        f20656a = new bm();
    }

    private bm() {
    }

    public final bn a(Context r11) {
        d.h.b.o.e((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin"), "context");
        com.obric.aiagent.skill.manager.impl.bq r12 = com.obric.aiagent.skill.manager.impl.br.f19586a.a();     // Catch: Exception -> L24
        if (r12 == com.obric.aiagent.skill.manager.impl.bq.f19581a) goto L8;
        ee.f19808a.b("SkillManager", "Skill page availability denied by feature capability", "Skill page availability denied by feature capability: state=" + r12);     // Catch: Exception -> L24
        return a();
    L8:
        if (((Boolean) ZeusTransformUtils.preCheckCast(cw.f19708a.a().getValue(OSkillManagerConfig.KEY_SKILL_EXTENSION_ENABLED, true), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L11;
        ee.a(ee.f19808a, "SkillManager", "Skill page availability denied by extension switch", null, 4, null);     // Catch: Exception -> L24
        return a();
    L11:
        ISkillManagerService r13 = ISkillManagerService.Companion.a();     // Catch: Exception -> L24
        if (r13 != null) goto L15;
        ee.b(ee.f19808a, "SkillManager", "Skill page availability denied because manager service is unavailable", null, 4, null);     // Catch: Exception -> L24
        return a();
    L15:
        com.obric.aiagent.skill.manager.api.u<List<com.obric.aiagent.skill.manager.api.e>> r1 = r13.getInstalledSkills();     // Catch: Exception -> L24
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L19;
        ee.f19808a.b("SkillManager", "Skill page availability resolved", "Skill page availability resolved: available=true");     // Catch: Exception -> L24
        return new bn(true, r13);
    L19:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L23;
        ee.f19808a.c("SkillManager", "Skill page availability denied because manager initialization failed", "Skill page availability denied because manager initialization failed: code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());     // Catch: Exception -> L24
        return a();
    L23:
        throw new d.k();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ee.f19808a.a("SkillManager", "Skill page availability check failed", "Skill page availability check failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return a();
    }

    private final bn a() {
        return new bn(false, null);
    }
}
