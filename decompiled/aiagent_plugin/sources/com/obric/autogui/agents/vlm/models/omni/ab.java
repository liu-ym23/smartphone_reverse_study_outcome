package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PreActionPageChangeBatch.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, aa> f28201b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ab.class) == true) goto L8;
        return false;
    L8:
        ab r6 = (ab) ZeusTransformUtils.preCheckCast(r5, ab.class, "com.obric.aiagent.plugin");
        if (this.f28200a == r6.f28200a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28201b, r6.f28201b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f28200a) * 31) + this.f28201b.hashCode();
    }

    public String toString() {
        return "PreActionPageChangeSnapshot(expectedActionCount=" + this.f28200a + ", entries=" + this.f28201b + ')';
    }

    public ab(int r3, Map<Integer, aa> r4) {
        Map<Integer, aa> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "entries");
        this.f28200a = r3;
        this.f28201b = r5;
    }

    public final Boolean a() {
        return a((d.h.a.b) ZeusTransformUtils.preCheckCast(a.f28202a, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final Boolean b() {
        return a((d.h.a.b) ZeusTransformUtils.preCheckCast(c.f28204a, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public final Boolean c() {
        return a((d.h.a.b) ZeusTransformUtils.preCheckCast(b.f28203a, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final Boolean a(d.h.a.b<? super aa, Boolean> r8) {
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        int r0 = this.f28200a;
        if (r0 > 0) goto L5;
        return null;
    L5:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(d.l.n.b(0, r0), Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        aa r5 = (aa) ZeusTransformUtils.preCheckCast(this.f28201b.get(Integer.valueOf(((al) ZeusTransformUtils.preCheckCast(r2, al.class, "com.obric.aiagent.plugin")).a())), aa.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L11;
        Boolean r6 = (Boolean) ZeusTransformUtils.preCheckCast(r9.invoke(r5), Boolean.class, "com.obric.aiagent.plugin");
    L12:
        r4.add(r6);
        goto L7
    L11:
        r6 = null;
        goto L12
    L13:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        boolean r11 = true;
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L16;
    L18:
        Iterator r12 = r10.iterator();
    L20:
        if (r12.hasNext() == false) goto L17;
        if (d.h.b.o.a((Boolean) ZeusTransformUtils.preCheckCast(r12.next(), Boolean.class, "com.obric.aiagent.plugin"), true) == false) goto L20;
        boolean r13 = true;
    L24:
        if (r13 == true) goto L49;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L29;
    L31:
        Iterator r15 = r14.iterator();
    L33:
        if (r15.hasNext() == false) goto L37;
        if (d.h.b.o.a((Boolean) ZeusTransformUtils.preCheckCast(r15.next(), Boolean.class, "com.obric.aiagent.plugin"), false) == true) goto L33;
        r11 = false;
    L37:
        if (r11 == true) goto L39;
        return null;
    L39:
        return false;
    L29:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L31;
    L49:
        return true;
    L17:
        r13 = false;
        goto L24
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L18;
        goto L17
    }
}
