package com.obric.aiagent.skill.manager.impl;

import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerStatusKeys;
import com.obric.aiagent.skill.manager.api.ISkillSettingsService;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFeatureAvailabilityResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final br f19586a = null;

    /* JADX INFO: compiled from: SkillFeatureAvailabilityResolver.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19587a = null;

        static {
            int[] r0 = new int[bq.values().length];
            r0[bq.f19581a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[bq.f19582b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[bq.f19583c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[bq.f19584d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f19587a = r0;
        }
    }

    static {
        f19586a = new br();
    }

    private br() {
    }

    public final bq a() {
        ISkillSettingsService r6 = ISkillSettingsService.Companion.a();
        if (r6 != null) goto L26;
        ee.b(ee.f19808a, "SkillManager", "Skill feature availability unknown because settings service is unavailable", null, 4, null);
        return bq.f19584d;
    L26:
        com.obric.aiagent.skill.manager.api.al r7 = r6.getSettings();     // Catch: Exception -> L23
        if (r7.w() == true) goto L11;
        return bq.f19582b;
    L11:
        if (r7.F() == false) goto L13;
        IOVirtService r8 = IOVirtService.Companion.a();     // Catch: Exception -> L23
        if (r8 != null) goto L19;
        ee.b(ee.f19808a, "SkillManager", "Skill feature unavailable because OVirt service is unavailable", null, 4, null);     // Catch: Exception -> L23
        return bq.f19583c;
    L19:
        if (r8.getTask().isAvailable() == false) goto L28;
        return bq.f19581a;
    L28:
        return bq.f19583c;
    L13:
        return bq.f19583c;
    L23:
        e = move-exception;
        ee.f19808a.a("SkillManager", "Skill feature availability probe failed", "Skill feature availability probe failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return bq.f19584d;
    }

    public final String a(String r2) {
        d.h.b.o.e(r2, "key");
        if (d.h.b.o.a(r2, OSkillManagerStatusKeys.KEY_OMNI_SKILL_AVAILABLE) == true) goto L5;
        return "";
    L5:
        bq r1 = a();
        int r3 = a.f19587a[r1.ordinal()];
        if (r3 != 1) goto L8;
        return "true";
    L8:
        if (r3 != 2) goto L10;
    L16:
        return "false";
    L10:
        if (r3 == 3) goto L16;
        if (r3 != 4) goto L15;
        return "";
    L15:
        throw new d.k();
    }

    public final aq b() {
        bq r3 = a();
        int r4 = a.f19587a[r3.ordinal()];
        if (r4 != 1) goto L5;
    L23:
        e = move-exception;
        ee.f19808a.a("SkillManager", "Skill feature activation config read failed", "Skill feature activation config read failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return aq.f19509e;
    L19:
        if (((Boolean) ZeusTransformUtils.preCheckCast(cw.f19708a.a().getValue(OSkillManagerConfig.KEY_SKILL_EXTENSION_ENABLED, true), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L21;
        aq r5 = aq.f19505a;     // Catch: Exception -> L23
    L26:
        return r5;
    L21:
        r5 = aq.f19507c;     // Catch: Exception -> L23
        goto L26
    L5:
        if (r4 == 2) goto L17;
        if (r4 == 3) goto L15;
        if (r4 != 4) goto L13;
        return aq.f19509e;
    L13:
        throw new d.k();
    L15:
        return aq.f19508d;
    L17:
        return aq.f19506b;
    }

    public final boolean c() {
        if (b() != aq.f19505a) goto L5;
        return true;
    L5:
        return false;
    }
}
