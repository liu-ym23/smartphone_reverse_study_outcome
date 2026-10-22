package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SimpleBeanPropertyFilter.java */
/* JADX INFO: loaded from: classes2.dex */
public class m implements com.fasterxml.jackson.databind.j.c, com.fasterxml.jackson.databind.j.n {
    public boolean a(com.fasterxml.jackson.databind.j.d r1) {
        return true;
    }

    public boolean a(com.fasterxml.jackson.databind.j.o r1) {
        return true;
    }

    public static com.fasterxml.jackson.databind.j.n a(com.fasterxml.jackson.databind.j.c r2) {
        final com.fasterxml.jackson.databind.j.c r3 = (com.fasterxml.jackson.databind.j.c) ZeusTransformUtils.wrapperContextForParams(r2, com.fasterxml.jackson.databind.j.c.class, "com.obric.aiagent.plugin");
        return new AnonymousClass1(r3);
    }

    @Override // com.fasterxml.jackson.databind.j.c
    @Deprecated
    public void a(Object r1, com.fasterxml.jackson.a.h r2, ac r3, com.fasterxml.jackson.databind.j.d r4) {
        if (a(r4) == false) goto L6;
        r4.a(r1, r2, r3);
        return;
    L6:
        if (r2.g() == true) goto L10;
        r4.b(r1, r2, r3);
        return;
    }

    @Override // com.fasterxml.jackson.databind.j.n
    public void a(Object r1, com.fasterxml.jackson.a.h r2, ac r3, com.fasterxml.jackson.databind.j.o r4) {
        if (a(r4) == false) goto L6;
        r4.a(r1, r2, r3);
        return;
    L6:
        if (r2.g() == true) goto L10;
        r4.b(r1, r2, r3);
        return;
    }
}
