package com.fasterxml.jackson.databind.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/* JADX INFO: compiled from: StdKeySerializers.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final com.fasterxml.jackson.databind.p<Object> f12879a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final com.fasterxml.jackson.databind.p<Object> f12880b = null;

    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class a extends aj<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final int f12881a;

        public a(int r2, Class<?> r3) {
            super(r3, false);
            this.f12881a = r2;
        }

        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            switch(this.f12881a) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L8;
                case 5: goto L6;
                case 6: goto L6;
                case 7: goto L5;
                default: goto L4;
            };
        L4:
            r4.a(r3.toString());
            return;
        L5:
            r4.a(r5.c().u().a((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin")));
            return;
        L6:
            r4.a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue());
            return;
        L15:
            r4.a(((Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.aiagent.plugin")).getName());
            return;
        L16:
            r5.a(((Calendar) ZeusTransformUtils.preCheckCast(r3, Calendar.class, "com.obric.aiagent.plugin")).getTimeInMillis(), r4);
            return;
        L17:
            r5.b((Date) ZeusTransformUtils.preCheckCast(r3, Date.class, "com.obric.aiagent.plugin"), r4);
            return;
        L8:
            if (r5.a(com.fasterxml.jackson.databind.ab.p) == false) goto L10;
            String r2 = r3.toString();
        L14:
            r4.a(r2);
            return;
        L10:
            Enum r6 = (Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.aiagent.plugin");
            if (r5.a(com.fasterxml.jackson.databind.ab.r) == false) goto L13;
            r2 = String.valueOf(r6.ordinal());
            goto L14
        L13:
            r2 = r6.name();
            goto L14
        }
    }

    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class b extends aj<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected transient com.fasterxml.jackson.databind.j.a.k f12882a;

        public b() {
            super(String.class, false);
            this.f12882a = com.fasterxml.jackson.databind.j.a.k.a();
        }

        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public void a(Object r4, com.fasterxml.jackson.a.h r5, com.fasterxml.jackson.databind.ac r6) {
            Class<?> r0 = r4.getClass();
            com.fasterxml.jackson.databind.j.a.k r1 = this.f12882a;
            com.fasterxml.jackson.databind.p<Object> r2 = r1.a(r0);
            if (r2 != null) goto L5;
            r2 = a(r1, r0, r6);
        L5:
            r2.a(r4, r5, r6);
        }

        public com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.j.a.k r2, Class<?> r3, com.fasterxml.jackson.databind.ac r4) {
            if (r3 != Object.class) goto L6;
            a r5 = new a(8, r3);
            this.f12882a = r2.b(r3, r5);
            return r5;
        L6:
            com.fasterxml.jackson.databind.j.a.k.d r6 = r2.c(r3, r4, null);
            if (r2 == r6.f12828b) goto L10;
            this.f12882a = r6.f12828b;
        L10:
            return r6.f12827a;
        }
    }

    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class c extends aj<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final com.fasterxml.jackson.databind.l.l f12883a;

        public c(Class<?> r2, com.fasterxml.jackson.databind.l.l r3) {
            super(r2, false);
            this.f12883a = r3;
        }

        public static c a(Class<?> r1, com.fasterxml.jackson.databind.l.l r2) {
            return new c(r1, r2);
        }

        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
            if (r5.a(com.fasterxml.jackson.databind.ab.p) == false) goto L6;
            r4.a(r3.toString());
            return;
        L6:
            Enum<?> r6 = (Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.aiagent.plugin");
            if (r5.a(com.fasterxml.jackson.databind.ab.r) == false) goto L10;
            r4.a(String.valueOf(r6.ordinal()));
            return;
        L10:
            r4.b(this.f12883a.a(r6));
        }
    }

    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class d extends aj<Object> {
        public d() {
            super(String.class, false);
        }

        @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
        public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
            r2.a((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f12879a = new ag();
        f12880b = new d();
    }

    public static com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.aa r1, Class<?> r2, boolean r3) {
        if (r2 == null) goto L54;
        if (r2 == Object.class) goto L54;
        if (r2 != String.class) goto L11;
        return f12880b;
    L11:
        if (r2.isPrimitive() == false) goto L14;
        r2 = com.fasterxml.jackson.databind.l.h.j(r2);
    L14:
        if (r2 != Integer.class) goto L18;
        return new a(5, r2);
    L18:
        if (r2 != Long.class) goto L22;
        return new a(6, r2);
    L22:
        if (r2.isPrimitive() == true) goto L52;
        if (Number.class.isAssignableFrom(r2) == true) goto L52;
        if (r2 != Class.class) goto L31;
        return new a(3, r2);
    L31:
        if (Date.class.isAssignableFrom(r2) == false) goto L35;
        return new a(1, r2);
    L35:
        if (Calendar.class.isAssignableFrom(r2) == false) goto L39;
        return new a(2, r2);
    L39:
        if (r2 != UUID.class) goto L43;
        return new a(8, r2);
    L43:
        if (r2 == byte[].class) goto L45;
        if (r3 == true) goto L48;
        return null;
    L48:
        return new a(8, r2);
    L45:
        return new a(7, r2);
    L52:
        return new a(8, r2);
    L54:
        return new b();
    }

    public static com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.aa r1, Class<?> r2) {
        if (r2 == null) goto L12;
        if (r2 != Enum.class) goto L8;
        return new b();
    L8:
        if (com.fasterxml.jackson.databind.l.h.l(r2) == false) goto L12;
        return c.a(r2, com.fasterxml.jackson.databind.l.l.a(r1, r2));
    L12:
        return new a(8, r2);
    }
}
