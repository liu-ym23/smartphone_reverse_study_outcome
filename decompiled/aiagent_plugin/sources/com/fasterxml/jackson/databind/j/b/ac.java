package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: compiled from: StaticListSerializerBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ac<T extends Collection<?>> extends aj<T> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Boolean f12868b;

    public abstract com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.d r1, Boolean r2);

    public abstract void a(T r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.h.h r4);

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        a((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
        return a(r3, (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin"));
    }

    public ac(Class<?> r2) {
        super(r2, false);
        this.f12868b = null;
    }

    public ac(ac<?> r1, Boolean r2) {
        super(r1);
        this.f12868b = r2;
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.d r6) {
        com.fasterxml.jackson.databind.d r7 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r6, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L9;
        com.fasterxml.jackson.databind.b r1 = r5.d();
        com.fasterxml.jackson.databind.e.j r2 = r7.d();
        if (r2 == null) goto L9;
        Object r3 = r1.o(r2);
        if (r3 == null) goto L9;
        com.fasterxml.jackson.databind.p<Object> r4 = r5.b(r2, r3);
    L10:
        JsonFormat.Value r8 = a(r5, r7, a());
        if (r8 == null) goto L13;
        Boolean r9 = r8.getFeature(JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
    L14:
        com.fasterxml.jackson.databind.p<?> r10 = a(r5, r7, r4);
        if (r10 != null) goto L18;
        r10 = r5.c(String.class, r7);
    L18:
        if (a(r10) == false) goto L25;
        if (Objects.equals(r9, this.f12868b) == false) goto L23;
        return this;
    L23:
        return a(r7, r9);
    L25:
        return new j(r5.a(String.class), true, null, r10);
    L13:
        r9 = null;
    L9:
        r4 = null;
        goto L10
    }

    public boolean a(com.fasterxml.jackson.databind.ac r1, T r2) {
        Collection r0 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.size() == 0) goto L8;
        return false;
    }
}
