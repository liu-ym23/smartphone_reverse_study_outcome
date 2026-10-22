package com.obric.agent.entity;

import com.google.android.material.timepicker.TimeModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.l.n;
import d.n.m;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: EntityManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14464a = null;

    static {
        f14464a = new c();
    }

    public static /* synthetic */ String lambda$5lYQEVDHESelWWHtIl2CkdXEsKA(int r0) {
        return a(r0);
    }

    private c() {
    }

    public final String a(Collection<String> r7, String r8, int r9) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.aiagent.plugin");
        o.e(r6, "existingEcaIds");
        o.e(r8, "previousEcaId");
        if (r9 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L31;
        Set r3 = p.q((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin"));
        Object r4 = null;
        if (r3.size() >= r9) goto L22;
        Iterator r10 = m.d(p.y((Iterable) ZeusTransformUtils.preCheckCast(n.b(0, r9), Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$c$5lYQEVDHESelWWHtIl2CkdXEsKA.INSTANCE).a();
    L11:
        if (r10.hasNext() == false) goto L21;
        Object r11 = r10.next();
        String r5 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");
        if (o.a(r5, r8) == false) goto L15;
    L17:
        boolean r12 = false;
    L18:
        if (r12 == false) goto L11;
        r4 = r11;
        goto L21
    L15:
        if (r3.contains(r5) == true) goto L17;
        r12 = true;
    L21:
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
    L22:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L24:
        if (r13.hasNext() == false) goto L29;
        Object r14 = r13.next();
        if ((!o.a((String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.aiagent.plugin"), r8)) == false) goto L24;
        r4 = r14;
    L29:
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
    L31:
        throw new IllegalArgumentException("capacity must be positive".toString());
    L5:
        r2 = false;
        goto L6
    }

    private static final String a(int r4) {
        StringBuilder r0 = new StringBuilder().append("$E_");
        String r5 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(r4)}, 1));
        o.c(r5, "format(...)");
        return r0.append(r5).toString();
    }
}
