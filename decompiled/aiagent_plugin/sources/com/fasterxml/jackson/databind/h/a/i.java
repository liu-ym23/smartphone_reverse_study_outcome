package com.fasterxml.jackson.databind.h.a;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.l.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: AsWrapperTypeDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends q implements Serializable {
    public i(com.fasterxml.jackson.databind.k r7, com.fasterxml.jackson.databind.h.f r8, String r9, boolean r10, com.fasterxml.jackson.databind.k r11) {
        super(r7, (com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.wrapperContextForParams(r8, com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin"), r9, r10, r11);
    }

    public i(i r3, com.fasterxml.jackson.databind.d r4) {
        super(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public com.fasterxml.jackson.databind.h.e a(com.fasterxml.jackson.databind.d r3) {
        com.fasterxml.jackson.databind.d r4 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r4 != this.f12737e) goto L6;
        return this;
    L6:
        return new i(this, r4);
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public JsonTypeInfo.As a() {
        return JsonTypeInfo.As.WRAPPER_OBJECT;
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return e(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public Object b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return e(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public Object c(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return e(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public Object d(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return e(r1, r2);
    }

    public Object e(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7) {
        if (r6.T() == false) goto L8;
        Object r0 = r6.V();
        if (r0 == null) goto L8;
        return a(r6, r7, r0);
    L8:
        com.fasterxml.jackson.a.n r1 = r6.l();
        if (r1 != com.fasterxml.jackson.a.n.f12152b) goto L14;
        if (r6.g() == com.fasterxml.jackson.a.n.f) goto L16;
        r7.a(h(), com.fasterxml.jackson.a.n.f, "need JSON String that contains type id (for subtype of " + g() + ")", new Object[0]);
    L16:
        String r2 = r6.x();
        com.fasterxml.jackson.databind.l<Object> r3 = a(r7, r2);
        r6.g();
        if (this.h == true) goto L19;
    L21:
        Object r4 = r3.a(r6, r7);
        if (r6.g() == com.fasterxml.jackson.a.n.f12153c) goto L24;
        r7.a(h(), com.fasterxml.jackson.a.n.f12153c, "expected closing END_OBJECT after type information and deserialized value", new Object[0]);
    L24:
        return r4;
    L19:
        if (r6.a(com.fasterxml.jackson.a.n.f12152b) == false) goto L21;
        y r5 = r7.a(r6);
        r5.j();
        r5.a(this.g);
        r5.b(r2);
        r6.u();
        r6 = com.fasterxml.jackson.a.h.k.a(false, r5.d(r6), r6);
        r6.g();
        goto L21
    L14:
        if (r1 == com.fasterxml.jackson.a.n.f) goto L16;
        r7.a(h(), com.fasterxml.jackson.a.n.f12152b, "need JSON Object to contain As.WRAPPER_OBJECT type information for class " + g(), new Object[0]);
        goto L16
    }
}
