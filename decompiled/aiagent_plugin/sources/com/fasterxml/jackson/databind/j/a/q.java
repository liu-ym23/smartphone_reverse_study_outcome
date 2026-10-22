package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ab;
import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.j.b.am;

/* JADX INFO: compiled from: UnknownSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class q extends am {
    public q() {
        super(Object.class);
    }

    public q(Class<?> r1) {
        super(r1);
    }

    @Override // com.fasterxml.jackson.databind.j.b.am, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public void a(Object r2, com.fasterxml.jackson.a.h r3, ac r4) {
        if (r4.a(ab.f12247c) == false) goto L5;
        b(r4, r2);
    L5:
        super.a(r2, r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.j.b.am, com.fasterxml.jackson.databind.p
    public void a(Object r2, com.fasterxml.jackson.a.h r3, ac r4, com.fasterxml.jackson.databind.h.h r5) {
        if (r4.a(ab.f12247c) == false) goto L5;
        b(r4, r2);
    L5:
        super.a(r2, r3, r4, r5);
    }

    public void b(ac r3, Object r4) {
        r3.a(a(), String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)", new Object[]{r4.getClass().getName()}));
    }
}
