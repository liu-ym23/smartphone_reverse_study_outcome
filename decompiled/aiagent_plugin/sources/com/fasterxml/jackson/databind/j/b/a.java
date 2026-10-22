package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: ArraySerializerBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> extends com.fasterxml.jackson.databind.j.i<T> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.d f12859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Boolean f12860d;

    public abstract com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.d r1, Boolean r2);

    public abstract void b(T r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3);

    public a(Class<T> r1) {
        super(r1);
        this.f12859c = null;
        this.f12860d = null;
    }

    public a(a<?> r3, com.fasterxml.jackson.databind.d r4, Boolean r5) {
        com.fasterxml.jackson.databind.d r6 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        super(r3.r, false);
        this.f12859c = r6;
        this.f12860d = r5;
    }

    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.d r4) {
        com.fasterxml.jackson.databind.d r5 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L10;
        JsonFormat.Value r6 = a(r3, r5, a());
        if (r6 == null) goto L11;
        Boolean r7 = r6.getFeature(JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
        if (Objects.equals(r7, this.f12860d) == false) goto L9;
        return this;
    L9:
        return a(r5, r7);
    L11:
        return this;
    L10:
        return this;
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public void a(T r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
        if (a(r4) == true) goto L5;
    L8:
        r3.b(r2);
        b(r2, r3, r4);
        r3.i();
        return;
    L5:
        if (a(r2) == false) goto L8;
        b(r2, r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.p
    public final void a(T r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4, com.fasterxml.jackson.databind.h.h r5) {
        com.fasterxml.jackson.a.g.b r0 = r5.a(r3, r5.a(r2, com.fasterxml.jackson.a.n.f12154d));
        r3.a(r2);
        b(r2, r3, r4);
        r5.b(r3, r0);
    }

    public final boolean a(com.fasterxml.jackson.databind.ac r1) {
        Boolean r0 = this.f12860d;
        if (r0 != null) goto L7;
        return r1.a(com.fasterxml.jackson.databind.ab.u);
    L7:
        return r0.booleanValue();
    }
}
