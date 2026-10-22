package com.fasterxml.jackson.databind.h.a;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.l.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: AsArrayTypeDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends q implements Serializable {
    public boolean f() {
        return false;
    }

    public a(com.fasterxml.jackson.databind.k r7, com.fasterxml.jackson.databind.h.f r8, String r9, boolean r10, com.fasterxml.jackson.databind.k r11) {
        super(r7, (com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.wrapperContextForParams(r8, com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin"), r9, r10, r11);
    }

    public a(a r3, com.fasterxml.jackson.databind.d r4) {
        super(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public com.fasterxml.jackson.databind.h.e a(com.fasterxml.jackson.databind.d r3) {
        com.fasterxml.jackson.databind.d r4 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r4 != this.f12737e) goto L6;
        return this;
    L6:
        return new a(this, r4);
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public JsonTypeInfo.As a() {
        return JsonTypeInfo.As.WRAPPER_ARRAY;
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public Object b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return e(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.h.e
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
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

    public Object e(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8) {
        if (r7.T() == false) goto L8;
        Object r0 = r7.V();
        if (r0 == null) goto L8;
        return a(r7, r8, r0);
    L8:
        boolean r1 = r7.q();
        String r2 = f(r7, r8);
        com.fasterxml.jackson.databind.l<Object> r3 = a(r8, r2);
        if (this.h == true) goto L11;
    L15:
        if (r1 == true) goto L17;
    L20:
        Object r4 = r3.a(r7, r8);
        if (r1 == true) goto L23;
    L25:
        return r4;
    L23:
        if (r7.g() == com.fasterxml.jackson.a.n.f12155e) goto L25;
        r8.a(h(), com.fasterxml.jackson.a.n.f12155e, "expected closing END_ARRAY after type information and deserialized value", new Object[0]);
        goto L25
    L17:
        if (r7.l() != com.fasterxml.jackson.a.n.f12155e) goto L20;
        return r3.a(r8);
    L11:
        if (f() == true) goto L15;
        if (r7.a(com.fasterxml.jackson.a.n.f12152b) == false) goto L15;
        y r5 = r8.a(r7);
        r5.j();
        r5.a(this.g);
        r5.b(r2);
        r7.u();
        r7 = com.fasterxml.jackson.a.h.k.a(false, r5.d(r7), r7);
        r7.g();
        goto L15
    }

    public String f(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7) {
        if (r6.q() == true) goto L11;
        if (this.f != null) goto L7;
        r7.a(h(), com.fasterxml.jackson.a.n.f12154d, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + g(), new Object[0]);
        return null;
    L7:
        return this.f12735c.a();
    L11:
        if (r6.g() != com.fasterxml.jackson.a.n.h) goto L14;
        String r5 = r6.x();
        r6.g();
        return r5;
    L14:
        r7.a(h(), com.fasterxml.jackson.a.n.h, "need JSON String that contains type id (for subtype of %s)", new Object[]{g()});
        return null;
    }
}
