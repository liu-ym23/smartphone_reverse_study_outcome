package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: NumberSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class w extends ai<Number> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f12925a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final boolean f12926b;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.j.b.w$1, reason: invalid class name */
    /* JADX INFO: compiled from: NumberSerializer.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12927a = null;

        static {
            int[] r0 = new int[JsonFormat.Shape.values().length];
            f12927a = r0;
            r0[JsonFormat.Shape.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    /* JADX INFO: compiled from: NumberSerializer.java */
    static final class a extends ao {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f12928a = null;

        @Override // com.fasterxml.jackson.databind.j.b.ao, com.fasterxml.jackson.databind.p
        public boolean a(com.fasterxml.jackson.databind.ac r1, Object r2) {
            return false;
        }

        static {
            f12928a = new a();
        }

        public a() {
            super(BigDecimal.class);
        }

        @Override // com.fasterxml.jackson.databind.j.b.ao, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public void a(Object r5, com.fasterxml.jackson.a.h r6, com.fasterxml.jackson.databind.ac r7) {
            if (r6.b(com.fasterxml.jackson.a.h.a.h) == false) goto L8;
            BigDecimal r8 = (BigDecimal) ZeusTransformUtils.preCheckCast(r5, BigDecimal.class, "com.obric.aiagent.plugin");
            if (a(r6, r8) == true) goto L7;
            r7.b(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", new Object[]{Integer.valueOf(r8.scale()), 9999, 9999}), new Object[0]);
        L7:
            String r4 = r8.toPlainString();
        L9:
            r6.b(r4);
            return;
        L8:
            r4 = r5.toString();
            goto L9
        }

        @Override // com.fasterxml.jackson.databind.j.b.ao
        public String a(Object r1) {
            throw new IllegalStateException();
        }

        public boolean a(com.fasterxml.jackson.a.h r1, BigDecimal r2) {
            int r0 = r2.scale();
            if (r0 >= (-9999)) goto L5;
        L7:
            return false;
        L5:
            if (r0 > 9999) goto L7;
            return true;
        }
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    static {
        f12925a = new w(Number.class);
    }

    public w(Class<? extends Number> r3) {
        boolean r0 = false;
        super(r3, false);
        if (r3 != BigInteger.class) goto L5;
        r0 = true;
    L5:
        this.f12926b = r0;
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.d r4) {
        JsonFormat.Value r5 = a(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), a());
        if (r5 != null) goto L5;
        return this;
    L5:
        if (AnonymousClass1.f12927a[r5.getShape().ordinal()] == 1) goto L8;
        return this;
    L8:
        if (a() != BigDecimal.class) goto L12;
        return d();
    L12:
        return an.f12885a;
    }

    public void a(Number r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
        if (ZeusTransformUtils.instanceOf(r1, BigDecimal.class) == false) goto L6;
        r2.a((BigDecimal) ZeusTransformUtils.preCheckCast(r1, BigDecimal.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, BigInteger.class) == false) goto L9;
        r2.a((BigInteger) ZeusTransformUtils.preCheckCast(r1, BigInteger.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r1, Long.class) == false) goto L12;
        r2.b(r1.longValue());
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r1, Double.class) == false) goto L15;
        r2.a(r1.doubleValue());
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r1, Float.class) == false) goto L18;
        r2.a(r1.floatValue());
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L20;
    L25:
        r2.d(r1.intValue());
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r1, Byte.class) == true) goto L25;
        if (ZeusTransformUtils.instanceOf(r1, Short.class) == true) goto L25;
        r2.e(r1.toString());
    }

    public static com.fasterxml.jackson.databind.p<?> d() {
        return a.f12928a;
    }
}
