package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class as {

    /* JADX INFO: compiled from: SkillSource.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19227a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f19228b = null;

        static {
            int[] r0 = new int[ar.values().length];
            r0[ar.f19223b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ar.f19224c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            f19227a = r0;
            int[] r1 = new int[n.values().length];
            r1[n.f19284b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r1[n.f19285c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            f19228b = r1;
        }
    }

    public static final q a(aq r5) {
        aq r6 = (aq) ZeusTransformUtils.wrapperContextForParams(r5, aq.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        if (ZeusTransformUtils.instanceOf(r6, aq.e.class) == false) goto L6;
        return q.f;
    L6:
        if (d.h.b.o.a(r6, aq.a.f19212a) == false) goto L9;
        return q.f19295a;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, aq.b.class) == false) goto L18;
        ar r7 = ((aq.b) ZeusTransformUtils.preCheckCast(r6, aq.b.class, "com.obric.aiagent.plugin")).b();
        int r8 = a.f19227a[r7.ordinal()];
        if (r8 == 1) goto L44;
        if (r8 != 2) goto L15;
        return q.f19296b;
    L15:
        throw new d.k();
    L44:
        return q.g;
    L18:
        if (ZeusTransformUtils.instanceOf(r6, aq.c.class) == false) goto L40;
        ar r0 = ((aq.c) ZeusTransformUtils.preCheckCast(r6, aq.c.class, "com.obric.aiagent.plugin")).b();
        int r1 = a.f19227a[r0.ordinal()];
        if (r1 == 1) goto L31;
        if (r1 != 2) goto L30;
        n r9 = ((aq.c) ZeusTransformUtils.preCheckCast(r6, aq.c.class, "com.obric.aiagent.plugin")).d();
        int r10 = a.f19228b[r9.ordinal()];
        if (r10 == 1) goto L46;
        if (r10 != 2) goto L27;
        return q.f19298d;
    L27:
        throw new d.k();
    L46:
        return q.f19299e;
    L30:
        throw new d.k();
    L31:
        n r11 = ((aq.c) ZeusTransformUtils.preCheckCast(r6, aq.c.class, "com.obric.aiagent.plugin")).d();
        int r12 = a.f19228b[r11.ordinal()];
        if (r12 == 1) goto L38;
        if (r12 != 2) goto L36;
        return q.i;
    L36:
        throw new d.k();
    L38:
        return q.h;
    L40:
        throw new d.k();
    }
}
