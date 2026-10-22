package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: EnumSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class m extends ai<Enum<?>> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l.l f12905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Boolean f12906b;

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public m(com.fasterxml.jackson.databind.l.l r3, Boolean r4) {
        super(r3.a(), false);
        this.f12905a = r3;
        this.f12906b = r4;
    }

    public static m a(Class<?> r1, com.fasterxml.jackson.databind.aa r2, com.fasterxml.jackson.databind.c r3, JsonFormat.Value r4) {
        return new m(com.fasterxml.jackson.databind.l.l.a(r2, r1), a(r1, r4, true, null));
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.d r4) {
        JsonFormat.Value r5 = a(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), a());
        if (r5 == null) goto L8;
        Boolean r6 = a(a(), r5, false, this.f12906b);
        if (Objects.equals(r6, this.f12906b) == true) goto L8;
        return new m(this.f12905a, r6);
    L8:
        return this;
    }

    public final void a(Enum<?> r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
        if (a(r4) == false) goto L7;
        r3.d(r2.ordinal());
        return;
    L7:
        if (r4.a(com.fasterxml.jackson.databind.ab.p) == false) goto L10;
        r3.b(r2.toString());
        return;
    L10:
        r3.c(this.f12905a.a(r2));
    }

    public final boolean a(com.fasterxml.jackson.databind.ac r1) {
        Boolean r0 = this.f12906b;
        if (r0 == null) goto L7;
        return r0.booleanValue();
    L7:
        return r1.a(com.fasterxml.jackson.databind.ab.q);
    }

    public static Boolean a(Class<?> r2, JsonFormat.Value r3, boolean r4, Boolean r5) {
        if (r3 != null) goto L4;
        JsonFormat.Shape r6 = null;
    L5:
        if (r6 != null) goto L8;
        return r5;
    L8:
        if (r6 != JsonFormat.Shape.ANY) goto L10;
    L32:
        return r5;
    L10:
        if (r6 == JsonFormat.Shape.SCALAR) goto L32;
        if (r6 == JsonFormat.Shape.STRING) goto L31;
        if (r6 == JsonFormat.Shape.NATURAL) goto L31;
        if (r6.isNumeric() == true) goto L29;
        if (r6 == JsonFormat.Shape.ARRAY) goto L29;
        Object[] r0 = new Object[3];
        r0[0] = r6;
        r0[1] = r2.getName();
        if (r4 == false) goto L25;
        String r7 = "class";
    L26:
        r0[2] = r7;
        throw new IllegalArgumentException(String.format("Unsupported serialization shape (%s) for Enum %s, not supported as %s annotation", r0));
    L25:
        r7 = "property";
    L29:
        return Boolean.TRUE;
    L31:
        return Boolean.FALSE;
    L4:
        r6 = r3.getShape();
        goto L5
    }
}
