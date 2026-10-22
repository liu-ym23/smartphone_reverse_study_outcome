package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopPageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
final class bz extends com.obric.oui.orecyclerview.widget.j.e<by> {
    @Override // com.obric.oui.orecyclerview.widget.j.e
    public /* synthetic */ boolean a(by r3, by r4) {
        return a2((by) ZeusTransformUtils.preCheckCast(r3, by.class, "com.obric.aiagent.plugin"), (by) ZeusTransformUtils.preCheckCast(r4, by.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.j.e
    public /* synthetic */ boolean b(by r3, by r4) {
        return b2((by) ZeusTransformUtils.preCheckCast(r3, by.class, "com.obric.aiagent.plugin"), (by) ZeusTransformUtils.preCheckCast(r4, by.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.orecyclerview.widget.j.e
    public /* synthetic */ Object c(by r3, by r4) {
        return c2((by) ZeusTransformUtils.preCheckCast(r3, by.class, "com.obric.aiagent.plugin"), (by) ZeusTransformUtils.preCheckCast(r4, by.class, "com.obric.aiagent.plugin"));
    }

    public bz() {
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(by r2, by r3) {
        d.h.b.o.e(r2, "oldItem");
        d.h.b.o.e(r3, "newItem");
        if (ZeusTransformUtils.instanceOf(r2, by.a.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r3, by.a.class) == false) goto L8;
        return true;
    L8:
        if (ZeusTransformUtils.instanceOf(r2, by.b.class) == true) goto L10;
    L12:
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r3, by.b.class) == false) goto L12;
        return d.h.b.o.a(((by.b) ZeusTransformUtils.preCheckCast(r2, by.b.class, "com.obric.aiagent.plugin")).a().a(), ((by.b) ZeusTransformUtils.preCheckCast(r3, by.b.class, "com.obric.aiagent.plugin")).a().a());
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public boolean b2(by r1, by r2) {
        d.h.b.o.e(r1, "oldItem");
        d.h.b.o.e(r2, "newItem");
        return d.h.b.o.a(r1, r2);
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    public Object c2(by r4, by r5) {
        d.h.b.o.e(r4, "oldItem");
        d.h.b.o.e(r5, "newItem");
        if (ZeusTransformUtils.instanceOf(r4, by.b.class) == true) goto L5;
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, by.b.class) == true) goto L8;
        return null;
    L8:
        if (d.h.b.o.a(((by.b) ZeusTransformUtils.preCheckCast(r4, by.b.class, "com.obric.aiagent.plugin")).a(), ((by.b) ZeusTransformUtils.preCheckCast(r5, by.b.class, "com.obric.aiagent.plugin")).a()) == true) goto L10;
        return null;
    L10:
        if (d.h.b.o.a(((by.b) ZeusTransformUtils.preCheckCast(r4, by.b.class, "com.obric.aiagent.plugin")).b(), ((by.b) ZeusTransformUtils.preCheckCast(r5, by.b.class, "com.obric.aiagent.plugin")).b()) == true) goto L12;
        return null;
    L12:
        if (((by.b) ZeusTransformUtils.preCheckCast(r4, by.b.class, "com.obric.aiagent.plugin")).c() == ((by.b) ZeusTransformUtils.preCheckCast(r5, by.b.class, "com.obric.aiagent.plugin")).c()) goto L14;
        return null;
    L14:
        if (((by.b) ZeusTransformUtils.preCheckCast(r4, by.b.class, "com.obric.aiagent.plugin")).d() != ((by.b) ZeusTransformUtils.preCheckCast(r5, by.b.class, "com.obric.aiagent.plugin")).d()) goto L16;
        return null;
    L16:
        return bx.f20694a;
    }
}
