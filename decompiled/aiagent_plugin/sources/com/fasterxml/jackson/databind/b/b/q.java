package com.fasterxml.jackson.databind.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JsonLocationInstantiator.java */
/* JADX INFO: loaded from: classes2.dex */
public class q extends com.fasterxml.jackson.databind.b.y.a {
    @Override // com.fasterxml.jackson.databind.b.y
    public boolean n() {
        return true;
    }

    public q() {
        super(com.fasterxml.jackson.a.i.class);
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public com.fasterxml.jackson.databind.b.v[] a(com.fasterxml.jackson.databind.g r5) {
        com.fasterxml.jackson.databind.k r4 = r5.b(Integer.TYPE);
        com.fasterxml.jackson.databind.k r0 = r5.b(Long.TYPE);
        return new com.fasterxml.jackson.databind.b.v[]{a("sourceRef", r5.b(Object.class), 0), a("byteOffset", r0, 1), a("charOffset", r0, 2), a("lineNr", r4, 3), a("columnNr", r4, 4)};
    }

    private static com.fasterxml.jackson.databind.b.k a(String r9, com.fasterxml.jackson.databind.k r10, int r11) {
        return com.fasterxml.jackson.databind.b.k.a(com.fasterxml.jackson.databind.x.a(r9), r10, null, null, null, null, r11, null, com.fasterxml.jackson.databind.w.f13125a);
    }

    @Override // com.fasterxml.jackson.databind.b.y
    public Object a(com.fasterxml.jackson.databind.h r9, Object[] r10) {
        return new com.fasterxml.jackson.a.i(com.fasterxml.jackson.a.d.d.a(r10[0]), a(r10[1]), a(r10[2]), b(r10[3]), b(r10[4]));
    }

    private static final long a(Object r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        return ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue();
    }

    private static final int b(Object r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        return ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue();
    }
}
