package com.obric.aiagent.skill.manager.impl.ui;

import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormSheetController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ba {

    /* JADX INFO: compiled from: SkillFormSheetController.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20624a = null;

        static {
            int[] r0 = new int[ax.values().length];
            r0[ax.f20582a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ax.f20583b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ax.f20584c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f20624a = r0;
        }
    }

    public static final com.obric.aiagent.skill.manager.impl.as a(ax r1) {
        d.h.b.o.e(r1, "<this>");
        int r2 = a.f20624a[r1.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L10;
        return com.obric.aiagent.skill.manager.impl.as.f19517c;
    L10:
        throw new d.k();
    L15:
        return com.obric.aiagent.skill.manager.impl.as.f19516b;
    L13:
        return com.obric.aiagent.skill.manager.impl.as.f19515a;
    }

    public static final void a(ax r2, d.h.a.a<d.x> r3, d.h.a.b<? super com.obric.aiagent.skill.manager.impl.as, d.x> r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "mode");
        d.h.b.o.e(r5, VDPlayerEffectProviderImpl.METHOD_SHOW);
        d.h.b.o.e(r6, "report");
        r5.invoke();
        r6.invoke(a(r2));
    }
}
