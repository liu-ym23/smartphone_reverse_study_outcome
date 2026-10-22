package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ActionEffectEvaluationBatch.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin")).a()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.b a(Set r2, List r3) {
        return b((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ boolean lambda$3ILUl7_7zSRzLHA4akeh0tnKeMs(Set r0, int r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ com.obric.autogui.agents.a.f.k lambda$IXpR7x3tcP9YuqqmLJGYDbC2vPs(e r0) {
        return b(r0);
    }

    public static /* synthetic */ boolean lambda$Mlsw7uz4KsWuxwm6oonqfoNq4Qs(Set r0, int r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ com.obric.autogui.agents.a.f.k lambda$X0Xn7VcsrA4S3tuQhcdCzQoPVgg(e r0) {
        return a(r0);
    }

    private static final com.obric.autogui.agents.vlm.models.omni.b b(Set<Integer> r7, List<e> r8) {
        final Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r2 = r11.next();
        if (r9.contains(Integer.valueOf(((e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin")).a())) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List r12 = d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.aiagent.plugin"));
        i r1 = a(r9, r12, $$Lambda$d$X0Xn7VcsrA4S3tuQhcdCzQoPVgg.INSTANCE);
        i r3 = a(r9, r12, $$Lambda$d$IXpR7x3tcP9YuqqmLJGYDbC2vPs.INSTANCE);
        int r4 = d.n.m.k(d.n.m.j(d.n.m.a(d.n.m.d(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f28328a, d.h.a.b.class, "com.obric.aiagent.plugin")), new $$Lambda$d$Mlsw7uz4KsWuxwm6oonqfoNq4Qs(r9))));
        boolean r5 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L11;
    L25:
        boolean r13 = false;
    L27:
        if (r3.a() != com.obric.autogui.agents.a.f.k.f26443b) goto L29;
    L34:
        boolean r14 = true;
    L35:
        com.obric.autogui.agents.a.f.k r6 = r1.a();
        com.obric.autogui.agents.a.f.k r15 = r3.a();
        if (r14 == true) goto L41;
        if (r13 == true) goto L41;
        r5 = false;
    L41:
        return new com.obric.autogui.agents.vlm.models.omni.b(r6, r15, r5, r3.b());
    L29:
        if (r3.a() == com.obric.autogui.agents.a.f.k.f26445d) goto L34;
        if (r3.a() == com.obric.autogui.agents.a.f.k.f26446e) goto L34;
        r14 = false;
        goto L35
    L11:
        if (r4 != r9.size()) goto L25;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L15;
    L17:
        Iterator r17 = r16.iterator();
    L19:
        if (r17.hasNext() == false) goto L16;
        if (((e) ZeusTransformUtils.preCheckCast(r17.next(), e.class, "com.obric.aiagent.plugin")).d() == true) goto L19;
        boolean r18 = false;
    L23:
        if (r18 == false) goto L25;
        r13 = true;
    L16:
        r18 = true;
        goto L23
    L15:
        if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L17;
        goto L16
    }

    private static final com.obric.autogui.agents.a.f.k a(e r1) {
        d.h.b.o.e(r1, "it");
        return r1.e().c();
    }

    private static final com.obric.autogui.agents.a.f.k b(e r1) {
        d.h.b.o.e(r1, "it");
        return r1.e().d();
    }

    private static final boolean a(Set r2, int r3) {
        return ((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin")).contains(Integer.valueOf(r3));
    }

    private static final i a(Set<Integer> r10, List<e> r11, d.h.a.b<? super e, ? extends com.obric.autogui.agents.a.f.k> r12) {
        final Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.aiagent.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        d.h.a.b r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(new com.obric.autogui.agents.a.f.k[]{com.obric.autogui.agents.a.f.k.f26443b, com.obric.autogui.agents.a.f.k.f26445d, com.obric.autogui.agents.a.f.k.f26446e}), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L3:
        Object r5 = null;
        if (r0.hasNext() == false) goto L20;
        com.obric.autogui.agents.a.f.k r2 = (com.obric.autogui.agents.a.f.k) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.autogui.agents.a.f.k.class, "com.obric.aiagent.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r6.hasNext() == false) goto L16;
        Object r7 = r6.next();
        e r8 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.aiagent.plugin");
        if (r8.d() == true) goto L11;
    L13:
        boolean r9 = false;
    L14:
        if (r9 == false) goto L7;
        r5 = r7;
        goto L16
    L11:
        if (r15.invoke(r8) != r2) goto L13;
        r9 = true;
    L16:
        e r16 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L3;
        return new i(r2, r16);
    L20:
        int r1 = d.n.m.k(d.n.m.j(d.n.m.a(d.n.m.d(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(c.f28329a, d.h.a.b.class, "com.obric.aiagent.plugin")), new $$Lambda$d$3ILUl7_7zSRzLHA4akeh0tnKeMs(r13))));
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r3.hasNext() == false) goto L34;
        Object r17 = r3.next();
        e r18 = (e) ZeusTransformUtils.preCheckCast(r17, e.class, "com.obric.aiagent.plugin");
        if (r18.d() == true) goto L26;
    L31:
        boolean r19 = true;
    L32:
        if (r19 == false) goto L22;
    L35:
        e r4 = (e) ZeusTransformUtils.preCheckCast(r17, e.class, "com.obric.aiagent.plugin");
        if (r1 != r13.size()) goto L74;
        if (r4 != null) goto L74;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L59;
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r110, Collection.class) == true) goto L44;
    L46:
        Iterator r111 = r110.iterator();
    L48:
        if (r111.hasNext() == false) goto L45;
        e r20 = (e) ZeusTransformUtils.preCheckCast(r111.next(), e.class, "com.obric.aiagent.plugin");
        if (r20.d() == true) goto L52;
    L54:
        boolean r21 = false;
    L55:
        if (r21 == true) goto L48;
        boolean r112 = false;
    L57:
        if (r112 == false) goto L59;
        boolean r113 = true;
    L60:
        if (r113 == true) goto L98;
        com.obric.autogui.agents.a.f.k r114 = com.obric.autogui.agents.a.f.k.f;
        Iterator r115 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L64:
        if (r115.hasNext() == false) goto L72;
        Object r22 = r115.next();
        if (r15.invoke((e) ZeusTransformUtils.preCheckCast(r22, e.class, "com.obric.aiagent.plugin")) == com.obric.autogui.agents.a.f.k.f26442a) goto L68;
        boolean r23 = true;
    L69:
        if (r23 == false) goto L64;
        r5 = r22;
        goto L72
    L68:
        r23 = false;
    L72:
        return new i(r114, (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin"));
    L98:
        return new i(com.obric.autogui.agents.a.f.k.f26442a, null);
    L52:
        if (r15.invoke(r20) != com.obric.autogui.agents.a.f.k.f26442a) goto L54;
        r21 = true;
    L45:
        r112 = true;
        goto L57
    L44:
        if (((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L46;
    L59:
        r113 = false;
    L74:
        return new i(com.obric.autogui.agents.a.f.k.f, r4);
    L26:
        if (r15.invoke(r18) == com.obric.autogui.agents.a.f.k.f) goto L31;
        if (r15.invoke(r18) == com.obric.autogui.agents.a.f.k.f26444c) goto L31;
        r19 = false;
        goto L32
    L34:
        r17 = null;
        goto L35
    }

    private static final boolean b(Set r2, int r3) {
        return ((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin")).contains(Integer.valueOf(r3));
    }
}
