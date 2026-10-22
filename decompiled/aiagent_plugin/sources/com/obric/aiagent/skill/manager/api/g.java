package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillAdmissionPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f19256a = null;

    static {
        f19256a = new g();
    }

    private g() {
    }

    public final f a(e r3, boolean r4) {
        d.h.b.o.e(r3, "skill");
        if (r4 == true) goto L7;
        return (f) ZeusTransformUtils.preCheckCast(new f.b(h.f19257a), f.class, "com.obric.aiagent.plugin");
    L7:
        if (r3.l() == false) goto L9;
        aj r5 = r3.i();
        h r1 = null;
        if (d.h.b.o.a(r5, aj.c.f19187a) == false) goto L17;
        if (ZeusTransformUtils.instanceOf(r3.g(), aq.e.class) == true) goto L42;
        r1 = h.f19259c;
    L42:
        if (r1 != null) goto L45;
        return (f) ZeusTransformUtils.preCheckCast(f.a.f19254a, f.class, "com.obric.aiagent.plugin");
    L45:
        return (f) ZeusTransformUtils.preCheckCast(new f.b(r1), f.class, "com.obric.aiagent.plugin");
    L17:
        if (d.h.b.o.a(r5, aj.d.f19189a) == false) goto L20;
        r1 = h.f19260d;
        goto L42
    L20:
        if (ZeusTransformUtils.instanceOf(r5, aj.e.class) == false) goto L31;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(((aj.e) ZeusTransformUtils.preCheckCast(r5, aj.e.class, "com.obric.aiagent.plugin")).a(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L24;
    L27:
        boolean r7 = true;
    L28:
        if (r7 == false) goto L42;
        r1 = h.f19261e;
        goto L42
    L24:
        if (d.o.o.d(r6) == true) goto L27;
        r7 = false;
        goto L28
    L31:
        if (ZeusTransformUtils.instanceOf(r5, aj.b.class) == false) goto L34;
        r1 = h.f;
        goto L42
    L34:
        if (ZeusTransformUtils.instanceOf(r5, aj.a.class) == false) goto L47;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(((aj.a) ZeusTransformUtils.preCheckCast(r5, aj.a.class, "com.obric.aiagent.plugin")).a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L39;
        r1 = h.f19261e;
        goto L42
    L39:
        if (((aj.a) ZeusTransformUtils.preCheckCast(r5, aj.a.class, "com.obric.aiagent.plugin")).b().a().getAllowsSkillUse() == true) goto L42;
        r1 = h.g;
        goto L42
    L47:
        throw new d.k();
    L9:
        return (f) ZeusTransformUtils.preCheckCast(new f.b(h.f19258b), f.class, "com.obric.aiagent.plugin");
    }
}
