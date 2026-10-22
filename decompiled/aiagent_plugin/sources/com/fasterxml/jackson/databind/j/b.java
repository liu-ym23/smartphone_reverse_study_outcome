package com.fasterxml.jackson.databind.j;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.databind.aa;
import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.j.b.ab;
import com.fasterxml.jackson.databind.j.b.ad;
import com.fasterxml.jackson.databind.j.b.ae;
import com.fasterxml.jackson.databind.j.b.af;
import com.fasterxml.jackson.databind.j.b.ah;
import com.fasterxml.jackson.databind.j.b.ak;
import com.fasterxml.jackson.databind.j.b.al;
import com.fasterxml.jackson.databind.j.b.am;
import com.fasterxml.jackson.databind.j.b.an;
import com.fasterxml.jackson.databind.j.b.ap;
import com.fasterxml.jackson.databind.j.b.u;
import com.fasterxml.jackson.databind.j.b.w;
import com.fasterxml.jackson.databind.j.b.x;
import com.fasterxml.jackson.databind.l.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: BasicSerializerFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends r implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final HashMap<String, com.fasterxml.jackson.databind.p<?>> f12854a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final HashMap<String, Class<? extends com.fasterxml.jackson.databind.p<?>>> f12855b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.a.p f12856c;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.j.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: BasicSerializerFactory.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12857a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f12858b = null;

        static {
            int[] r0 = new int[JsonInclude.Include.values().length];
            f12858b = r0;
            r0[JsonInclude.Include.NON_DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L25:
            f12858b[JsonInclude.Include.NON_ABSENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L31:
            f12858b[JsonInclude.Include.NON_EMPTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L41:
            f12858b[JsonInclude.Include.CUSTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L29:
            f12858b[JsonInclude.Include.NON_NULL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L33:
            f12858b[JsonInclude.Include.USE_DEFAULTS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L11:
            int[] r3 = new int[JsonFormat.Shape.values().length];
            f12857a = r3;
            r3[JsonFormat.Shape.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L37:
            f12857a[JsonFormat.Shape.OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L27:
            f12857a[JsonFormat.Shape.ARRAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
            return;
        }
    }

    public abstract Iterable<s> a();

    static {
        HashMap<String, Class<? extends com.fasterxml.jackson.databind.p<?>>> r0 = new HashMap();
        HashMap<String, com.fasterxml.jackson.databind.p<?>> r1 = new HashMap();
        r1.put(String.class.getName(), new ak());
        an r2 = an.f12885a;
        r1.put(StringBuffer.class.getName(), r2);
        r1.put(StringBuilder.class.getName(), r2);
        r1.put(Character.class.getName(), r2);
        r1.put(Character.TYPE.getName(), r2);
        x.a(r1);
        r1.put(Boolean.TYPE.getName(), new com.fasterxml.jackson.databind.j.b.e(true));
        r1.put(Boolean.class.getName(), new com.fasterxml.jackson.databind.j.b.e(false));
        r1.put(BigInteger.class.getName(), new w(BigInteger.class));
        r1.put(BigDecimal.class.getName(), new w(BigDecimal.class));
        r1.put(Calendar.class.getName(), com.fasterxml.jackson.databind.j.b.h.f12900a);
        r1.put(Date.class.getName(), com.fasterxml.jackson.databind.j.b.k.f12901a);
        Iterator<Map.Entry<Class<?>, Object>> r3 = af.a().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Object r5 = r4.getValue();
        if (ZeusTransformUtils.instanceOf(r5, com.fasterxml.jackson.databind.p.class) == true) goto L7;
        Class<? extends com.fasterxml.jackson.databind.p<?>> r6 = (Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.aiagent.plugin");
        r0.put(((Class) ZeusTransformUtils.preCheckCast(r4.getKey(), Class.class, "com.obric.aiagent.plugin")).getName(), r6);
        goto L4
    L7:
        r1.put(((Class) ZeusTransformUtils.preCheckCast(r4.getKey(), Class.class, "com.obric.aiagent.plugin")).getName(), (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(r5, com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin"));
        goto L4
    L9:
        r0.put(y.class.getName(), ap.class);
        f12854a = r1;
        f12855b = r0;
    }

    public b(com.fasterxml.jackson.databind.a.p r1) {
        if (r1 != null) goto L5;
        r1 = new com.fasterxml.jackson.databind.a.p();
    L5:
        this.f12856c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.j.r
    public com.fasterxml.jackson.databind.p<Object> a(ac r8, com.fasterxml.jackson.databind.k r9, com.fasterxml.jackson.databind.p<Object> r10) {
        aa r0 = r8.c();
        com.fasterxml.jackson.databind.c r1 = r0.a(r9);
        if (this.f12856c.a() == false) goto L10;
        Iterator<s> r2 = this.f12856c.d().iterator();
        com.fasterxml.jackson.databind.p<?> r5 = null;
    L6:
        if (r2.hasNext() == false) goto L11;
        r5 = ((s) ZeusTransformUtils.preCheckCast(r2.next(), s.class, "com.obric.aiagent.plugin")).a(r0, r9, r1);
        if (r5 == null) goto L6;
    L11:
        if (r5 != null) goto L27;
        com.fasterxml.jackson.databind.p<Object> r3 = c(r8, r1.c());
        if (r3 != null) goto L26;
        if (r10 != null) goto L29;
        r3 = ah.a(r0, r9.e(), false);
        if (r3 != null) goto L26;
        com.fasterxml.jackson.databind.e.j r4 = r1.o();
        if (r4 != null) goto L20;
        r4 = r1.p();
    L20:
        if (r4 == null) goto L25;
        com.fasterxml.jackson.databind.p<Object> r11 = a(r8, r4.getType(), r10);
        if (r0.g() == false) goto L24;
        com.fasterxml.jackson.databind.l.h.a(r4.g(), r0.a(com.fasterxml.jackson.databind.r.o));
    L24:
        r10 = new com.fasterxml.jackson.databind.j.b.s(r4, null, r11);
        goto L29
    L25:
        r10 = ah.a(r0, r9.e());
    L29:
        if (this.f12856c.b() == false) goto L34;
        Iterator<h> r7 = this.f12856c.e().iterator();
    L32:
        if (r7.hasNext() == false) goto L34;
        r10 = ((h) ZeusTransformUtils.preCheckCast(r7.next(), h.class, "com.obric.aiagent.plugin")).b(r0, r9, r1, r10);
    L34:
        return r10;
    L26:
        r10 = r3;
        goto L29
    L27:
        r10 = r5;
        goto L29
    L10:
        r5 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.j.r
    @Deprecated
    public com.fasterxml.jackson.databind.p<Object> a(aa r6, com.fasterxml.jackson.databind.k r7, com.fasterxml.jackson.databind.p<Object> r8) {
        com.fasterxml.jackson.databind.c r0 = r6.a(r7);
        com.fasterxml.jackson.databind.p<?> r3 = null;
        if (this.f12856c.a() == false) goto L9;
        Iterator<s> r1 = this.f12856c.d().iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r3 = ((s) ZeusTransformUtils.preCheckCast(r1.next(), s.class, "com.obric.aiagent.plugin")).a(r6, r7, r0);
        if (r3 == null) goto L6;
    L9:
        if (r3 != null) goto L14;
        if (r8 != null) goto L16;
        r8 = ah.a(r6, r7.e(), false);
        if (r8 != null) goto L16;
        r8 = ah.a(r6, r7.e());
    L16:
        if (this.f12856c.b() == false) goto L21;
        Iterator<h> r5 = this.f12856c.e().iterator();
    L19:
        if (r5.hasNext() == false) goto L21;
        r8 = ((h) ZeusTransformUtils.preCheckCast(r5.next(), h.class, "com.obric.aiagent.plugin")).b(r6, r7, r0, r8);
    L21:
        return r8;
    L14:
        r8 = r3;
        goto L16
    }

    @Override // com.fasterxml.jackson.databind.j.r
    public com.fasterxml.jackson.databind.h.h a(aa r4, com.fasterxml.jackson.databind.k r5) {
        com.fasterxml.jackson.databind.e.d r3 = r4.c(r5.e()).c();
        com.fasterxml.jackson.databind.h.g<?> r0 = r4.j().a(r4, r3, r5);
        if (r0 != null) goto L5;
        r0 = r4.d(r5);
        Collection<com.fasterxml.jackson.databind.h.b> r6 = null;
    L6:
        if (r0 != null) goto L9;
        return null;
    L9:
        return r0.a(r4, r5, r6);
    L5:
        r6 = r4.v().a(r4, r3);
        goto L6
    }

    public final com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.k r1, aa r2, com.fasterxml.jackson.databind.c r3, boolean r4) {
        String r0 = r1.e().getName();
        com.fasterxml.jackson.databind.p<?> r5 = (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(f12854a.get(r0), com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L8;
        Class r6 = (Class) ZeusTransformUtils.preCheckCast(f12855b.get(r0), Class.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L8;
        return (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.b(r6, false), com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin");
    L8:
        return r5;
    }

    public final com.fasterxml.jackson.databind.p<?> a(ac r5, com.fasterxml.jackson.databind.k r6, com.fasterxml.jackson.databind.c r7) {
        if (com.fasterxml.jackson.databind.o.class.isAssignableFrom(r6.e()) == true) goto L5;
        com.fasterxml.jackson.databind.e.j r8 = r7.p();
        if (r8 != null) goto L9;
        return null;
    L9:
        if (r5.f() == false) goto L11;
        com.fasterxml.jackson.databind.l.h.a(r8.g(), r5.a(com.fasterxml.jackson.databind.r.o));
    L11:
        com.fasterxml.jackson.databind.k r9 = r8.getType();
        com.fasterxml.jackson.databind.p<Object> r0 = a(r5, r8);
        if (r0 != null) goto L14;
        r0 = (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(r9.D(), com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin");
    L14:
        com.fasterxml.jackson.databind.h.h r1 = (com.fasterxml.jackson.databind.h.h) ZeusTransformUtils.preCheckCast(r9.E(), com.fasterxml.jackson.databind.h.h.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L18;
        r1 = a(r5.c(), r9);
    L18:
        return new com.fasterxml.jackson.databind.j.b.s(r8, r1, r0);
    L5:
        return ab.f12867a;
    }

    public final com.fasterxml.jackson.databind.p<?> a(ac r11, com.fasterxml.jackson.databind.k r12, com.fasterxml.jackson.databind.c r13, boolean r14) {
        if (r12.k() == true) goto L5;
        Class<?> r0 = r12.e();
        com.fasterxml.jackson.databind.p<?> r1 = b(r11, r12, r13, r14);
        if (r1 == null) goto L10;
        return r1;
    L10:
        if (Calendar.class.isAssignableFrom(r0) == false) goto L14;
        return com.fasterxml.jackson.databind.j.b.h.f12900a;
    L14:
        if (Date.class.isAssignableFrom(r0) == false) goto L18;
        return com.fasterxml.jackson.databind.j.b.k.f12901a;
    L18:
        if (Map.Entry.class.isAssignableFrom(r0) == false) goto L22;
        com.fasterxml.jackson.databind.k r2 = r12.d(Map.Entry.class);
        return a(r11, r12, r13, r14, r2.b(0), r2.b(1));
    L22:
        if (ByteBuffer.class.isAssignableFrom(r0) == false) goto L26;
        return new com.fasterxml.jackson.databind.j.b.g();
    L26:
        if (InetAddress.class.isAssignableFrom(r0) == false) goto L30;
        return new com.fasterxml.jackson.databind.j.b.p();
    L30:
        if (InetSocketAddress.class.isAssignableFrom(r0) == false) goto L34;
        return new com.fasterxml.jackson.databind.j.b.q();
    L34:
        if (TimeZone.class.isAssignableFrom(r0) == false) goto L38;
        return new al();
    L38:
        if (Charset.class.isAssignableFrom(r0) == false) goto L42;
        return an.f12885a;
    L42:
        if (Number.class.isAssignableFrom(r0) == false) goto L55;
        JsonFormat.Value r10 = r13.a(null);
        int r15 = AnonymousClass1.f12857a[r10.getShape().ordinal()];
        if (r15 == 1) goto L53;
        if (r15 != 2) goto L48;
    L51:
        return null;
    L48:
        if (r15 == 3) goto L51;
        return w.f12925a;
    L53:
        return an.f12885a;
    L55:
        if (ClassLoader.class.isAssignableFrom(r0) == true) goto L57;
        return null;
    L57:
        return new am(r12);
    L5:
        return a(r11.c(), r12, r13);
    }

    public com.fasterxml.jackson.databind.p<?> b(ac r1, com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.c r3, boolean r4) {
        return com.fasterxml.jackson.databind.d.c.f12564a.a(r1.c(), r2, r3);
    }

    public final com.fasterxml.jackson.databind.p<?> a(aa r8, com.fasterxml.jackson.databind.k r9, com.fasterxml.jackson.databind.c r10, boolean r11) {
        Class<?> r0 = r9.e();
        if (Iterator.class.isAssignableFrom(r0) == false) goto L14;
        com.fasterxml.jackson.databind.k[] r1 = r8.o().c(r9, Iterator.class);
        if (r1 != null) goto L7;
    L10:
        com.fasterxml.jackson.databind.k r2 = com.fasterxml.jackson.databind.k.o.c();
    L12:
        return a(r8, r9, r10, r11, r2);
    L7:
        if (r1.length != 1) goto L10;
        r2 = r1[0];
        goto L12
    L14:
        if (Iterable.class.isAssignableFrom(r0) == false) goto L25;
        com.fasterxml.jackson.databind.k[] r3 = r8.o().c(r9, Iterable.class);
        if (r3 != null) goto L18;
    L21:
        com.fasterxml.jackson.databind.k r4 = com.fasterxml.jackson.databind.k.o.c();
    L23:
        return b(r8, r9, r10, r11, r4);
    L18:
        if (r3.length != 1) goto L21;
        r4 = r3[0];
        goto L23
    L25:
        if (CharSequence.class.isAssignableFrom(r0) == true) goto L27;
        return null;
    L27:
        return an.f12885a;
    }

    public com.fasterxml.jackson.databind.p<Object> a(ac r2, com.fasterxml.jackson.databind.e.b r3) {
        Object r0 = r2.d().m(r3);
        if (r0 != null) goto L7;
        return null;
    L7:
        return a(r2, r3, r2.b(r3, r0));
    }

    public com.fasterxml.jackson.databind.p<?> a(ac r1, com.fasterxml.jackson.databind.e.b r2, com.fasterxml.jackson.databind.p<?> r3) {
        com.fasterxml.jackson.databind.l.j<Object, Object> r0 = b(r1, r2);
        if (r0 != null) goto L6;
        return r3;
    L6:
        return new ae(r0, r0.b(r1.b()), r3);
    }

    public com.fasterxml.jackson.databind.l.j<Object, Object> b(ac r1, com.fasterxml.jackson.databind.e.b r2) {
        Object r0 = r1.d().r(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r1.a(r2, r0);
    }

    public com.fasterxml.jackson.databind.p<?> c(ac r18, com.fasterxml.jackson.databind.k r19, com.fasterxml.jackson.databind.c r20, boolean r21) {
        aa r11 = r18.c();
        if (r21 == false) goto L5;
    L11:
        boolean r3 = r21;
    L12:
        com.fasterxml.jackson.databind.h.h r12 = a(r11, r19.x());
        if (r12 == null) goto L15;
        r3 = false;
    L15:
        boolean r4 = r3;
        com.fasterxml.jackson.databind.p<Object> r13 = d(r18, r20.c());
        com.fasterxml.jackson.databind.p<?> r5 = null;
        if (r19.s() == false) goto L40;
        com.fasterxml.jackson.databind.k.g r6 = (com.fasterxml.jackson.databind.k.g) ZeusTransformUtils.preCheckCast(r19, com.fasterxml.jackson.databind.k.g.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.p<Object> r15 = c(r18, r20.c());
        if (ZeusTransformUtils.instanceOf(r6, com.fasterxml.jackson.databind.k.h.class) == true) goto L20;
        com.fasterxml.jackson.databind.k.g r9 = (com.fasterxml.jackson.databind.k.g) ZeusTransformUtils.preCheckCast(r19, com.fasterxml.jackson.databind.k.g.class, "com.obric.aiagent.plugin");
        Iterator<s> r16 = a().iterator();
    L23:
        if (r16.hasNext() == false) goto L28;
        com.fasterxml.jackson.databind.k.g r1 = r9;
        r5 = ((s) ZeusTransformUtils.preCheckCast(r16.next(), s.class, "com.obric.aiagent.plugin")).a(r11, r9, r20, r15, r12, r13);
        if (r5 != null) goto L29;
        r9 = r1;
    L29:
        if (r5 != null) goto L31;
        r5 = a(r18, r19, r20);
    L31:
        if (r5 != null) goto L33;
    L38:
        return r5;
    L33:
        if (this.f12856c.b() == false) goto L38;
        Iterator<h> r0 = this.f12856c.e().iterator();
    L36:
        if (r0.hasNext() == false) goto L38;
        r5 = ((h) ZeusTransformUtils.preCheckCast(r0.next(), h.class, "com.obric.aiagent.plugin")).a(r11, r1, r20, r5);
        goto L36
    L28:
        r1 = r9;
        goto L29
    L20:
        return a(r18, (com.fasterxml.jackson.databind.k.h) ZeusTransformUtils.preCheckCast(r6, com.fasterxml.jackson.databind.k.h.class, "com.obric.aiagent.plugin"), r20, r4, r15, r12, r13);
    L40:
        if (r19.r() == false) goto L61;
        com.fasterxml.jackson.databind.k.d r2 = (com.fasterxml.jackson.databind.k.d) ZeusTransformUtils.preCheckCast(r19, com.fasterxml.jackson.databind.k.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.fasterxml.jackson.databind.k.e.class) == true) goto L44;
        com.fasterxml.jackson.databind.k.d r7 = (com.fasterxml.jackson.databind.k.d) ZeusTransformUtils.preCheckCast(r19, com.fasterxml.jackson.databind.k.d.class, "com.obric.aiagent.plugin");
        Iterator<s> r10 = a().iterator();
    L47:
        if (r10.hasNext() == false) goto L50;
        r5 = ((s) ZeusTransformUtils.preCheckCast(r10.next(), s.class, "com.obric.aiagent.plugin")).a(r11, r7, r20, r12, r13);
        if (r5 == null) goto L47;
    L50:
        if (r5 != null) goto L52;
        r5 = a(r18, r19, r20);
    L52:
        if (r5 != null) goto L54;
    L59:
        return r5;
    L54:
        if (this.f12856c.b() == false) goto L59;
        Iterator<h> r8 = this.f12856c.e().iterator();
    L57:
        if (r8.hasNext() == false) goto L59;
        r5 = ((h) ZeusTransformUtils.preCheckCast(r8.next(), h.class, "com.obric.aiagent.plugin")).a(r11, r7, r20, r5);
        goto L57
    L44:
        return a(r18, (com.fasterxml.jackson.databind.k.e) ZeusTransformUtils.preCheckCast(r2, com.fasterxml.jackson.databind.k.e.class, "com.obric.aiagent.plugin"), r20, r4, r12, r13);
    L61:
        if (r19.j() == true) goto L63;
        return null;
    L63:
        return a(r18, (com.fasterxml.jackson.databind.k.a) ZeusTransformUtils.preCheckCast(r19, com.fasterxml.jackson.databind.k.a.class, "com.obric.aiagent.plugin"), r20, r4, r12, r13);
    L5:
        if (r19.u() == false) goto L11;
        if (r19.q() == true) goto L9;
    L10:
        r3 = true;
        goto L12
    L9:
        if (r19.x().t() == true) goto L11;
        goto L10
    }

    public com.fasterxml.jackson.databind.p<?> a(ac r16, com.fasterxml.jackson.databind.k.e r17, com.fasterxml.jackson.databind.c r18, boolean r19, com.fasterxml.jackson.databind.h.h r20, com.fasterxml.jackson.databind.p<Object> r21) {
        aa r11 = r16.c();
        Iterator<s> r12 = a().iterator();
        com.fasterxml.jackson.databind.k r13 = null;
        com.fasterxml.jackson.databind.p<?> r1 = null;
    L4:
        if (r12.hasNext() == false) goto L7;
        r1 = ((s) ZeusTransformUtils.preCheckCast(r12.next(), s.class, "com.obric.aiagent.plugin")).a(r11, r17, r18, r20, r21);
        if (r1 == null) goto L4;
    L7:
        if (r1 != null) goto L36;
        r1 = a(r16, r17, r18);
        if (r1 != null) goto L36;
        if (r18.a(null).getShape() != JsonFormat.Shape.OBJECT) goto L13;
        return null;
    L13:
        Class<?> r2 = r17.e();
        if (EnumSet.class.isAssignableFrom(r2) == false) goto L20;
        com.fasterxml.jackson.databind.k r3 = r17.x();
        if (r3.l() == false) goto L19;
        r13 = r3;
    L19:
        r1 = a(r13);
        goto L36
    L20:
        Class<?> r4 = r17.x().e();
        if (a(r2) == false) goto L29;
        if (r4 == String.class) goto L25;
        r1 = a(r17.x(), r19, r20, r21);
    L33:
        if (r1 != null) goto L36;
        r1 = b(r17.x(), r19, r20, r21);
        goto L36
    L25:
        if (com.fasterxml.jackson.databind.l.h.e(r21) == false) goto L33;
        r1 = com.fasterxml.jackson.databind.j.a.f.f12806a;
        goto L33
    L29:
        if (r4 != String.class) goto L33;
        if (com.fasterxml.jackson.databind.l.h.e(r21) == false) goto L33;
        r1 = com.fasterxml.jackson.databind.j.a.o.f12845a;
    L36:
        if (this.f12856c.b() == false) goto L41;
        Iterator<h> r0 = this.f12856c.e().iterator();
    L39:
        if (r0.hasNext() == false) goto L41;
        r1 = ((h) ZeusTransformUtils.preCheckCast(r0.next(), h.class, "com.obric.aiagent.plugin")).a(r11, r17, r18, r1);
    L41:
        return r1;
    }

    public boolean a(Class<?> r1) {
        return RandomAccess.class.isAssignableFrom(r1);
    }

    public i<?> a(com.fasterxml.jackson.databind.k r1, boolean r2, com.fasterxml.jackson.databind.h.h r3, com.fasterxml.jackson.databind.p<Object> r4) {
        return new com.fasterxml.jackson.databind.j.a.e(r1, r2, r3, r4);
    }

    public i<?> b(com.fasterxml.jackson.databind.k r1, boolean r2, com.fasterxml.jackson.databind.h.h r3, com.fasterxml.jackson.databind.p<Object> r4) {
        return new com.fasterxml.jackson.databind.j.b.j(r1, r2, r3, r4);
    }

    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.k r1) {
        return new com.fasterxml.jackson.databind.j.b.n(r1);
    }

    public com.fasterxml.jackson.databind.p<?> a(ac r22, com.fasterxml.jackson.databind.k.h r23, com.fasterxml.jackson.databind.c r24, boolean r25, com.fasterxml.jackson.databind.p<Object> r26, com.fasterxml.jackson.databind.h.h r27, com.fasterxml.jackson.databind.p<Object> r28) {
        Set<String> r9 = null;
        if (r24.a(null).getShape() != JsonFormat.Shape.OBJECT) goto L5;
        return null;
    L5:
        aa r10 = r22.c();
        Iterator<s> r11 = a().iterator();
        com.fasterxml.jackson.databind.p<?> r1 = null;
    L7:
        if (r11.hasNext() == false) goto L10;
        r1 = ((s) ZeusTransformUtils.preCheckCast(r11.next(), s.class, "com.obric.aiagent.plugin")).a(r10, r23, r24, r26, r27, r28);
        if (r1 == null) goto L7;
    L10:
        if (r1 != null) goto L23;
        r1 = a(r22, r23, r24);
        if (r1 != null) goto L23;
        Object r20 = a(r10, r24);
        JsonIgnoreProperties.Value r2 = r10.b(Map.class, r24.c());
        if (r2 != null) goto L16;
        Set<String> r13 = null;
    L17:
        JsonIncludeProperties.Value r3 = r10.c(Map.class, r24.c());
        if (r3 == null) goto L21;
        r9 = r3.getIncluded();
    L21:
        r1 = a(r22, r24, u.a(r13, r9, r23, r25, r27, r26, r28, r20));
        goto L23
    L16:
        r13 = r2.findIgnoredForSerialization();
    L23:
        if (this.f12856c.b() == false) goto L28;
        Iterator<h> r0 = this.f12856c.e().iterator();
    L26:
        if (r0.hasNext() == false) goto L28;
        r1 = ((h) ZeusTransformUtils.preCheckCast(r0.next(), h.class, "com.obric.aiagent.plugin")).a(r10, r23, r24, r1);
    L28:
        return r1;
    }

    public u a(ac r5, com.fasterxml.jackson.databind.c r6, u r7) {
        com.fasterxml.jackson.databind.k r0 = r7.d();
        JsonInclude.Value r4 = a(r5, r6, r0, Map.class);
        if (r4 != null) goto L5;
        JsonInclude.Include r8 = JsonInclude.Include.USE_DEFAULTS;
    L6:
        boolean r2 = true;
        Object r3 = null;
        if (r8 == JsonInclude.Include.USE_DEFAULTS) goto L36;
        if (r8 == JsonInclude.Include.ALWAYS) goto L36;
        int r9 = AnonymousClass1.f12858b[r8.ordinal()];
        if (r9 != 1) goto L14;
        r3 = com.fasterxml.jackson.databind.l.e.a(r0);
        if (r3 != null) goto L31;
    L34:
        return r7.a(r3, r2);
    L31:
        if (r3.getClass().isArray() == false) goto L34;
        r3 = com.fasterxml.jackson.databind.l.c.a(r3);
        goto L34
    L14:
        if (r9 == 2) goto L26;
        if (r9 != 3) goto L18;
        r3 = u.f12919b;
        goto L34
    L18:
        if (r9 != 4) goto L34;
        r3 = r5.a(null, r4.getContentFilter());
        if (r3 == null) goto L34;
        r2 = r5.b(r3);
        goto L34
    L26:
        if (r0.a() == false) goto L34;
        r3 = u.f12919b;
    L36:
        if (r5.a(com.fasterxml.jackson.databind.ab.s) == false) goto L38;
        return r7;
    L38:
        return r7.a(null, true);
    L5:
        r8 = r4.getContentInclusion();
        goto L6
    }

    public com.fasterxml.jackson.databind.p<?> a(ac r10, com.fasterxml.jackson.databind.k r11, com.fasterxml.jackson.databind.c r12, boolean r13, com.fasterxml.jackson.databind.k r14, com.fasterxml.jackson.databind.k r15) {
        JsonFormat.Value r16 = r10.a(Map.Entry.class);
        Object r0 = null;
        if (JsonFormat.Value.merge(r12.a(null), r16).getShape() != JsonFormat.Shape.OBJECT) goto L5;
        return null;
    L5:
        com.fasterxml.jackson.databind.j.a.h r17 = new com.fasterxml.jackson.databind.j.a.h(r15, r14, r15, r13, a(r10.c(), r15), null);
        com.fasterxml.jackson.databind.k r18 = r17.d();
        JsonInclude.Value r9 = a(r10, r12, r18, Map.Entry.class);
        if (r9 != null) goto L8;
        JsonInclude.Include r19 = JsonInclude.Include.USE_DEFAULTS;
    L10:
        if (r19 != JsonInclude.Include.USE_DEFAULTS) goto L12;
    L38:
        return r17;
    L12:
        if (r19 == JsonInclude.Include.ALWAYS) goto L38;
        int r110 = AnonymousClass1.f12858b[r19.ordinal()];
        boolean r111 = true;
        if (r110 != 1) goto L17;
        r0 = com.fasterxml.jackson.databind.l.e.a(r18);
        if (r0 != null) goto L34;
    L37:
        return r17.a(r0, r111);
    L34:
        if (r0.getClass().isArray() == false) goto L37;
        r0 = com.fasterxml.jackson.databind.l.c.a(r0);
        goto L37
    L17:
        if (r110 == 2) goto L29;
        if (r110 != 3) goto L21;
        r0 = u.f12919b;
        goto L37
    L21:
        if (r110 != 4) goto L37;
        r0 = r10.a(null, r9.getContentFilter());
        if (r0 == null) goto L37;
        r111 = r10.b(r0);
        goto L37
    L29:
        if (r18.a() == false) goto L37;
        r0 = u.f12919b;
        goto L37
    L8:
        r19 = r9.getContentInclusion();
        goto L10
    }

    public JsonInclude.Value a(ac r1, com.fasterxml.jackson.databind.c r2, com.fasterxml.jackson.databind.k r3, Class<?> r4) {
        aa r0 = r1.c();
        JsonInclude.Value r5 = r0.a(r4, r2.a(r0.z()));
        JsonInclude.Value r6 = r0.a(r3.e(), null);
        if (r6 == null) goto L11;
        int r7 = AnonymousClass1.f12858b[r6.getValueInclusion().ordinal()];
        if (r7 == 4) goto L10;
        if (r7 != 6) goto L13;
        return r5;
    L13:
        return r5.withContentInclusion(r6.getValueInclusion());
    L10:
        return r5.withContentFilter(r6.getContentFilter());
    L11:
        return r5;
    }

    public com.fasterxml.jackson.databind.p<?> a(ac r9, com.fasterxml.jackson.databind.k.a r10, com.fasterxml.jackson.databind.c r11, boolean r12, com.fasterxml.jackson.databind.h.h r13, com.fasterxml.jackson.databind.p<Object> r14) {
        aa r15 = r9.c();
        Iterator<s> r6 = a().iterator();
        com.fasterxml.jackson.databind.p<?> r0 = null;
    L4:
        if (r6.hasNext() == false) goto L7;
        r0 = ((s) ZeusTransformUtils.preCheckCast(r6.next(), s.class, "com.obric.aiagent.plugin")).a(r15, r10, r11, r13, r14);
        if (r0 == null) goto L4;
    L7:
        if (r0 != null) goto L19;
        Class<?> r1 = r10.e();
        if (r14 == null) goto L13;
        if (com.fasterxml.jackson.databind.l.h.e(r14) == true) goto L13;
    L16:
        if (r0 != null) goto L19;
        r0 = new com.fasterxml.jackson.databind.j.b.y(r10.x(), r12, r13, r14);
    L13:
        if (String[].class != r1) goto L15;
        r0 = com.fasterxml.jackson.databind.j.a.n.f12842a;
        goto L16
    L15:
        r0 = ad.a(r1);
    L19:
        if (this.f12856c.b() == false) goto L24;
        Iterator<h> r8 = this.f12856c.e().iterator();
    L22:
        if (r8.hasNext() == false) goto L24;
        r0 = ((h) ZeusTransformUtils.preCheckCast(r8.next(), h.class, "com.obric.aiagent.plugin")).a(r15, r10, r11, r0);
    L24:
        return r0;
    }

    public com.fasterxml.jackson.databind.p<?> a(ac r12, com.fasterxml.jackson.databind.k.j r13, com.fasterxml.jackson.databind.c r14, boolean r15) {
        com.fasterxml.jackson.databind.k r0 = r13.x();
        com.fasterxml.jackson.databind.h.h r1 = (com.fasterxml.jackson.databind.h.h) ZeusTransformUtils.preCheckCast(r0.E(), com.fasterxml.jackson.databind.h.h.class, "com.obric.aiagent.plugin");
        aa r2 = r12.c();
        if (r1 != null) goto L5;
        r1 = a(r2, r0);
    L5:
        com.fasterxml.jackson.databind.p<Object> r10 = (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(r0.D(), com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin");
        Iterator<s> r3 = a().iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        com.fasterxml.jackson.databind.p<?> r4 = ((s) ZeusTransformUtils.preCheckCast(r3.next(), s.class, "com.obric.aiagent.plugin")).a(r2, r13, r14, r1, r10);
        if (r4 == null) goto L7;
        return r4;
    L12:
        if (r13.b(AtomicReference.class) == true) goto L14;
        return null;
    L14:
        return a(r12, r13, r14, r15, r1, r10);
    }

    public com.fasterxml.jackson.databind.p<?> a(ac r5, com.fasterxml.jackson.databind.k.j r6, com.fasterxml.jackson.databind.c r7, boolean r8, com.fasterxml.jackson.databind.h.h r9, com.fasterxml.jackson.databind.p<Object> r10) {
        com.fasterxml.jackson.databind.k r0 = r6.y();
        JsonInclude.Value r4 = a(r5, r7, r0, AtomicReference.class);
        if (r4 != null) goto L5;
        JsonInclude.Include r11 = JsonInclude.Include.USE_DEFAULTS;
    L6:
        boolean r2 = true;
        Object r3 = null;
        if (r11 != JsonInclude.Include.USE_DEFAULTS) goto L9;
    L33:
        r2 = false;
    L35:
        return new com.fasterxml.jackson.databind.j.b.c(r6, r8, r9, r10).a(r3, r2);
    L9:
        if (r11 == JsonInclude.Include.ALWAYS) goto L33;
        int r12 = AnonymousClass1.f12858b[r11.ordinal()];
        if (r12 != 1) goto L14;
        r3 = com.fasterxml.jackson.databind.l.e.a(r0);
        if (r3 == null) goto L35;
        if (r3.getClass().isArray() == false) goto L35;
        r3 = com.fasterxml.jackson.databind.l.c.a(r3);
        goto L35
    L14:
        if (r12 == 2) goto L26;
        if (r12 != 3) goto L18;
        r3 = u.f12919b;
        goto L35
    L18:
        if (r12 != 4) goto L35;
        r3 = r5.a(null, r4.getContentFilter());
        if (r3 == null) goto L35;
        r2 = r5.b(r3);
        goto L35
    L26:
        if (r0.a() == false) goto L35;
        r3 = u.f12919b;
        goto L35
    L5:
        r11 = r4.getContentInclusion();
        goto L6
    }

    public com.fasterxml.jackson.databind.p<?> a(aa r1, com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.c r3, boolean r4, com.fasterxml.jackson.databind.k r5) {
        return new com.fasterxml.jackson.databind.j.a.g(r5, r4, a(r1, r5));
    }

    public com.fasterxml.jackson.databind.p<?> b(aa r1, com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.c r3, boolean r4, com.fasterxml.jackson.databind.k r5) {
        return new com.fasterxml.jackson.databind.j.b.r(r5, r4, a(r1, r5));
    }

    public com.fasterxml.jackson.databind.p<?> a(aa r6, com.fasterxml.jackson.databind.k r7, com.fasterxml.jackson.databind.c r8) {
        JsonFormat.Value r1 = r8.a(null);
        if (r1.getShape() != JsonFormat.Shape.OBJECT) goto L6;
        ((com.fasterxml.jackson.databind.e.r) ZeusTransformUtils.preCheckCast(r8, com.fasterxml.jackson.databind.e.r.class, "com.obric.aiagent.plugin")).a("declaringClass");
        return null;
    L6:
        com.fasterxml.jackson.databind.p<?> r0 = com.fasterxml.jackson.databind.j.b.m.a(r7.e(), r6, r8, r1);
        if (this.f12856c.b() == false) goto L12;
        Iterator<h> r5 = this.f12856c.e().iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r0 = ((h) ZeusTransformUtils.preCheckCast(r5.next(), h.class, "com.obric.aiagent.plugin")).a(r6, r7, r8, r0);
    L12:
        return r0;
    }

    public com.fasterxml.jackson.databind.p<Object> c(ac r1, com.fasterxml.jackson.databind.e.b r2) {
        Object r0 = r1.d().n(r2);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r1.b(r2, r0);
    }

    public com.fasterxml.jackson.databind.p<Object> d(ac r1, com.fasterxml.jackson.databind.e.b r2) {
        Object r0 = r1.d().o(r2);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r1.b(r2, r0);
    }

    public Object a(aa r1, com.fasterxml.jackson.databind.c r2) {
        return r1.j().b(r2.c());
    }

    public boolean a(aa r1, com.fasterxml.jackson.databind.c r2, com.fasterxml.jackson.databind.h.h r3) {
        if (r3 == null) goto L5;
        return false;
    L5:
        JsonSerialize.Typing r4 = r1.j().q(r2.c());
        if (r4 == null) goto L14;
        if (r4 == JsonSerialize.Typing.DEFAULT_TYPING) goto L14;
        if (r4 != JsonSerialize.Typing.STATIC) goto L15;
        return true;
    L15:
        return false;
    L14:
        return r1.a(com.fasterxml.jackson.databind.r.p);
    }
}
