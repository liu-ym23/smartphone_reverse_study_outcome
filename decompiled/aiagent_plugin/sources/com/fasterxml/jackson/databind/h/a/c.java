package com.fasterxml.jackson.databind.h.a;

import com.fasterxml.jackson.databind.l.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AsDeductionTypeDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends g {
    private static final BitSet k = null;
    private final Map<String, Integer> l;
    private final Map<BitSet, String> m;

    static {
        k = new BitSet(0);
    }

    public c(com.fasterxml.jackson.databind.k r10, com.fasterxml.jackson.databind.h.f r11, com.fasterxml.jackson.databind.k r12, com.fasterxml.jackson.databind.g r13, Collection<com.fasterxml.jackson.databind.h.b> r14) {
        com.fasterxml.jackson.databind.h.f r4 = (com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.wrapperContextForParams(r11, com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin");
        Collection<com.fasterxml.jackson.databind.h.b> r15 = (Collection) ZeusTransformUtils.wrapperContextForParams(r14, Collection.class, "com.obric.aiagent.plugin");
        super(r10, r4, null, false, r12, null);
        this.l = new HashMap();
        this.m = a(r13, r15);
    }

    public c(c r3, com.fasterxml.jackson.databind.d r4) {
        super(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
        this.l = r3.l;
        this.m = r3.m;
    }

    @Override // com.fasterxml.jackson.databind.h.a.g, com.fasterxml.jackson.databind.h.a.a, com.fasterxml.jackson.databind.h.e
    public com.fasterxml.jackson.databind.h.e a(com.fasterxml.jackson.databind.d r3) {
        com.fasterxml.jackson.databind.d r4 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r4 != this.f12737e) goto L6;
        return this;
    L6:
        return new c(this, r4);
    }

    public Map<BitSet, String> a(com.fasterxml.jackson.databind.g r13, Collection<com.fasterxml.jackson.databind.h.b> r14) {
        Collection r15 = (Collection) ZeusTransformUtils.wrapperContextForParams(r14, Collection.class, "com.obric.aiagent.plugin");
        boolean r0 = r13.a(com.fasterxml.jackson.databind.r.v);
        HashMap r2 = new HashMap();
        Iterator r16 = r15.iterator();
        int r4 = 0;
    L4:
        if (r16.hasNext() == false) goto L20;
        com.fasterxml.jackson.databind.h.b r5 = (com.fasterxml.jackson.databind.h.b) ZeusTransformUtils.preCheckCast(r16.next(), com.fasterxml.jackson.databind.h.b.class, "com.obric.aiagent.plugin");
        List<com.fasterxml.jackson.databind.e.t> r6 = r13.a(r13.o().a(r5.getType())).g();
        BitSet r7 = new BitSet(r6.size() + r4);
        Iterator<com.fasterxml.jackson.databind.e.t> r8 = r6.iterator();
    L7:
        if (r8.hasNext() == false) goto L15;
        String r9 = ((com.fasterxml.jackson.databind.e.t) ZeusTransformUtils.preCheckCast(r8.next(), com.fasterxml.jackson.databind.e.t.class, "com.obric.aiagent.plugin")).a();
        if (r0 == false) goto L11;
        r9 = r9.toLowerCase();
    L11:
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(this.l.get(r9), Integer.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L14;
        r10 = Integer.valueOf(r4);
        this.l.put(r9, Integer.valueOf(r4));
        r4 = r4 + 1;
    L14:
        r7.set(r10.intValue());
        goto L7
    L15:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r2.put(r7, r5.getType().getName()), String.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L4;
        throw new IllegalStateException(String.format("Subtypes %s and %s have the same signature and cannot be uniquely deduced.", new Object[]{r11, r5.getType().getName()}));
    L20:
        return r2;
    }

    @Override // com.fasterxml.jackson.databind.h.a.g, com.fasterxml.jackson.databind.h.a.a, com.fasterxml.jackson.databind.h.e
    public Object a(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
        com.fasterxml.jackson.a.n r0 = r9.l();
        if (r0 != com.fasterxml.jackson.a.n.f12152b) goto L6;
        r0 = r9.g();
    L10:
        if (r0 != com.fasterxml.jackson.a.n.f12153c) goto L15;
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.m.get(k), String.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L15;
        return a(r9, r10, null, r1);
    L15:
        LinkedList r2 = new LinkedList(this.m.keySet());
        y r3 = r10.a(r9);
        boolean r4 = r10.a(com.fasterxml.jackson.databind.r.v);
    L17:
        if (r0 != com.fasterxml.jackson.a.n.f) goto L29;
        String r5 = r9.w();
        if (r4 == false) goto L21;
        r5 = r5.toLowerCase();
    L21:
        r3.b(r9);
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(this.l.get(r5), Integer.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L27;
        a(r2, r6.intValue());
        if (r2.size() != 1) goto L27;
        return a(r9, r10, r3, (String) ZeusTransformUtils.preCheckCast(this.m.get(r2.get(0)), String.class, "com.obric.aiagent.plugin"));
    L27:
        r0 = r9.g();
        goto L17
    L29:
        return b(r9, r10, r3, String.format("Cannot deduce unique subtype of %s (%d candidates match)", new Object[]{com.fasterxml.jackson.databind.l.h.b(this.f12736d), Integer.valueOf(r2.size())}));
    L6:
        if (r0 == com.fasterxml.jackson.a.n.f) goto L10;
        return b(r9, r10, null, "Unexpected input");
    }

    private static void a(List<BitSet> r3, int r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (((BitSet) ZeusTransformUtils.preCheckCast(r5.next(), BitSet.class, "com.obric.aiagent.plugin")).get(r4) == true) goto L4;
        r5.remove();
        goto L4
    }
}
