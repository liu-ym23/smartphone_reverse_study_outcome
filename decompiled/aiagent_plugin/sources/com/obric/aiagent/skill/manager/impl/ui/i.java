package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: InstalledSkillListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
final class i extends com.obric.oui.orecyclerview.widget.j.e<m> {
    public i() {
    }

    @Override // com.obric.oui.orecyclerview.widget.j.e
    public /* synthetic */ boolean a(m r3, m r4) {
        return a2((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.j.e
    public /* synthetic */ boolean b(m r3, m r4) {
        return b2((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.j.e
    public /* synthetic */ Object c(m r3, m r4) {
        return c2((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(m r1, m r2) {
        d.h.b.o.e(r1, "oldItem");
        d.h.b.o.e(r2, "newItem");
        return d.h.b.o.a(r1.a().a(), r2.a().a());
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public boolean b2(m r1, m r2) {
        d.h.b.o.e(r1, "oldItem");
        d.h.b.o.e(r2, "newItem");
        return r1.a(r2);
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    public Object c2(m r4, m r5) {
        d.h.b.o.e(r4, "oldItem");
        d.h.b.o.e(r5, "newItem");
        Set r3 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        if (r4.b() == r5.b()) goto L5;
    L6:
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).add(j.f20789a);
    L8:
        if (d.h.b.o.a(r4.d(), r5.d()) == true) goto L11;
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).add(j.f20790b);
    L11:
        if (d.h.b.o.a(r4.e(), r5.e()) == true) goto L13;
    L14:
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).add(j.f20791c);
    L16:
        if (d.h.b.o.a(r4.g(), r5.g()) == true) goto L18;
    L19:
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).add(j.f20792d);
    L21:
        if (r4.i() == r5.i()) goto L23;
    L24:
        ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).add(j.f20793e);
    L26:
        return new l(r3);
    L23:
        if (r4.j() == r5.j()) goto L26;
    L18:
        if (d.h.b.o.a(r4.h(), r5.h()) == true) goto L21;
    L13:
        if (d.h.b.o.a(r4.f(), r5.f()) == true) goto L16;
    L5:
        if (r4.c() == r5.c()) goto L8;
        goto L6
    }
}
