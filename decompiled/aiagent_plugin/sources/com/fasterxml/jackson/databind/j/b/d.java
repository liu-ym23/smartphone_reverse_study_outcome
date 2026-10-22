package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: BeanSerializerBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends aj<Object> implements com.fasterxml.jackson.databind.j.j, com.fasterxml.jackson.databind.j.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final com.fasterxml.jackson.databind.x f12893b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final com.fasterxml.jackson.databind.j.d[] f12894c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.j.d[] f12896e;
    protected final com.fasterxml.jackson.databind.j.d[] f;
    protected final com.fasterxml.jackson.databind.j.a g;
    protected final Object h;
    protected final com.fasterxml.jackson.databind.e.j i;
    protected final com.fasterxml.jackson.databind.j.a.i j;
    protected final JsonFormat.Shape k;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.j.b.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: BeanSerializerBase.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12897a = null;

        static {
            int[] r0 = new int[JsonFormat.Shape.values().length];
            f12897a = r0;
            r0[JsonFormat.Shape.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f12897a[JsonFormat.Shape.NUMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f12897a[JsonFormat.Shape.NUMBER_INT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public abstract d a(com.fasterxml.jackson.databind.j.a.i r1);

    public abstract d a(Object r1);

    public abstract d a(Set<String> r1, Set<String> r2);

    public abstract d a(com.fasterxml.jackson.databind.j.d[] r1, com.fasterxml.jackson.databind.j.d[] r2);

    public abstract d d();

    static {
        f12893b = new com.fasterxml.jackson.databind.x("#object-ref");
        f12894c = new com.fasterxml.jackson.databind.j.d[0];
    }

    public d(com.fasterxml.jackson.databind.k r1, com.fasterxml.jackson.databind.j.f r2, com.fasterxml.jackson.databind.j.d[] r3, com.fasterxml.jackson.databind.j.d[] r4) {
        super(r1);
        this.f12895d = r1;
        this.f12896e = r3;
        this.f = r4;
        if (r2 != null) goto L5;
        this.i = null;
        this.g = null;
        this.h = null;
        this.j = null;
        this.k = null;
        return;
    L5:
        this.i = r2.e();
        this.g = r2.c();
        this.h = r2.d();
        this.j = r2.f();
        this.k = r2.a().a(null).getShape();
    }

    public d(d r2, com.fasterxml.jackson.databind.j.d[] r3, com.fasterxml.jackson.databind.j.d[] r4) {
        super(r2.r);
        this.f12895d = r2.f12895d;
        this.f12896e = r3;
        this.f = r4;
        this.i = r2.i;
        this.g = r2.g;
        this.j = r2.j;
        this.h = r2.h;
        this.k = r2.k;
    }

    public d(d r2, com.fasterxml.jackson.databind.j.a.i r3) {
        this(r2, r3, r2.h);
    }

    public d(d r2, com.fasterxml.jackson.databind.j.a.i r3, Object r4) {
        super(r2.r);
        this.f12895d = r2.f12895d;
        this.f12896e = r2.f12896e;
        this.f = r2.f;
        this.i = r2.i;
        this.g = r2.g;
        this.j = r3;
        this.h = r4;
        this.k = r2.k;
    }

    public d(d r11, Set<String> r12, Set<String> r13) {
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.aiagent.plugin");
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin");
        super(r11.r);
        this.f12895d = r11.f12895d;
        com.fasterxml.jackson.databind.j.d[] r0 = r11.f12896e;
        com.fasterxml.jackson.databind.j.d[] r2 = r11.f;
        int r3 = r0.length;
        ArrayList r4 = new ArrayList(r3);
        com.fasterxml.jackson.databind.j.d[] r5 = null;
        if (r2 != null) goto L5;
        ArrayList r6 = null;
    L6:
        int r7 = 0;
    L7:
        if (r7 >= r3) goto L15;
        com.fasterxml.jackson.databind.j.d r8 = r0[r7];
        if (com.fasterxml.jackson.databind.l.m.a(r8.a(), r14, r15) == true) goto L14;
        r4.add(r8);
        if (r2 == null) goto L14;
        r6.add(r2[r7]);
    L14:
        r7 = r7 + 1;
        goto L7
    L15:
        this.f12896e = (com.fasterxml.jackson.databind.j.d[]) ZeusTransformUtils.preCheckCast(r4.toArray(new com.fasterxml.jackson.databind.j.d[r4.size()]), com.fasterxml.jackson.databind.j.d[].class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L19;
        r5 = (com.fasterxml.jackson.databind.j.d[]) ZeusTransformUtils.preCheckCast(r6.toArray(new com.fasterxml.jackson.databind.j.d[r6.size()]), com.fasterxml.jackson.databind.j.d[].class, "com.obric.aiagent.plugin");
    L19:
        this.f = r5;
        this.i = r11.i;
        this.g = r11.g;
        this.j = r11.j;
        this.h = r11.h;
        this.k = r11.k;
        return;
    L5:
        r6 = new ArrayList(r3);
        goto L6
    }

    public d(d r3, com.fasterxml.jackson.databind.l.q r4) {
        this(r3, a(r3.f12896e, r4), a(r3.f, r4));
    }

    private static final com.fasterxml.jackson.databind.j.d[] a(com.fasterxml.jackson.databind.j.d[] r4, com.fasterxml.jackson.databind.l.q r5) {
        if (r4 != null) goto L4;
    L16:
        return r4;
    L4:
        if (r4.length == 0) goto L16;
        if (r5 == null) goto L16;
        if (r5 == com.fasterxml.jackson.databind.l.q.f13048a) goto L16;
        int r0 = r4.length;
        com.fasterxml.jackson.databind.j.d[] r1 = new com.fasterxml.jackson.databind.j.d[r0];
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L15;
        com.fasterxml.jackson.databind.j.d r3 = r4[r2];
        if (r3 == null) goto L14;
        r1[r2] = r3.a(r5);
    L14:
        r2 = r2 + 1;
        goto L10
    L15:
        return r1;
    }

    @Override // com.fasterxml.jackson.databind.j.p
    public void a(com.fasterxml.jackson.databind.ac r9) {
        com.fasterxml.jackson.databind.j.d[] r0 = this.f;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = this.f12896e.length;
    L7:
        if (r1 >= r3) goto L47;
        com.fasterxml.jackson.databind.j.d r4 = this.f12896e[r1];
        if (r4.h() == true) goto L20;
        if (r4.f() == true) goto L20;
        com.fasterxml.jackson.databind.p<Object> r5 = r9.a(r4);
        if (r5 == null) goto L20;
        r4.b(r5);
        if (r1 >= r2) goto L20;
        com.fasterxml.jackson.databind.j.d r6 = this.f[r1];
        if (r6 == null) goto L20;
        r6.b(r5);
    L20:
        if (r4.e() == true) goto L46;
        com.fasterxml.jackson.databind.p<Object> r7 = a(r9, r4);
        if (r7 != null) goto L41;
        com.fasterxml.jackson.databind.k r8 = r4.i();
        if (r8 != null) goto L33;
        r8 = r4.getType();
        if (r8.p() == true) goto L33;
        if (r8.q() == false) goto L31;
    L32:
        r4.a(r8);
        goto L46
    L31:
        if (r8.z() <= 0) goto L46;
    L33:
        com.fasterxml.jackson.databind.p<Object> r10 = r9.a(r8, r4);
        if (r8.q() == false) goto L40;
        com.fasterxml.jackson.databind.h.h r11 = (com.fasterxml.jackson.databind.h.h) ZeusTransformUtils.preCheckCast(r8.x().E(), com.fasterxml.jackson.databind.h.h.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L40;
        if (ZeusTransformUtils.instanceOf(r10, com.fasterxml.jackson.databind.j.i.class) == false) goto L40;
        r7 = ((com.fasterxml.jackson.databind.j.i) ZeusTransformUtils.preCheckCast(r10, com.fasterxml.jackson.databind.j.i.class, "com.obric.aiagent.plugin")).a(r11);
    L40:
        r7 = r10;
    L41:
        if (r1 >= r2) goto L45;
        com.fasterxml.jackson.databind.j.d r12 = this.f[r1];
        if (r12 == null) goto L45;
        r12.a(r7);
    L45:
        r4.a(r7);
    L46:
        r1 = r1 + 1;
        goto L7
    L47:
        com.fasterxml.jackson.databind.j.a r13 = this.g;
        if (r13 == null) goto L57;
        r13.a(r9);
        return;
    L57:
        return;
    L5:
        r2 = r0.length;
        goto L6
    }

    public com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.ac r4, com.fasterxml.jackson.databind.j.d r5) {
        com.fasterxml.jackson.databind.b r3 = r4.d();
        com.fasterxml.jackson.databind.p<Object> r0 = null;
        if (r3 == null) goto L14;
        com.fasterxml.jackson.databind.e.j r1 = r5.d();
        if (r1 == null) goto L14;
        Object r6 = r3.r(r1);
        if (r6 == null) goto L14;
        com.fasterxml.jackson.databind.l.j<Object, Object> r7 = r4.a(r5.d(), r6);
        com.fasterxml.jackson.databind.k r2 = r7.b(r4.b());
        if (r2.t() == true) goto L13;
        r0 = r4.a(r2, r5);
    L13:
        return new ae(r7, r2, r0);
    L14:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r20, com.fasterxml.jackson.databind.d r21) {
        com.fasterxml.jackson.databind.d r2 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r21, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b r4 = r20.d();
        if (r2 == null) goto L7;
        if (r4 == null) goto L7;
        com.fasterxml.jackson.databind.e.j r6 = r2.d();
    L8:
        com.fasterxml.jackson.databind.aa r7 = r20.c();
        JsonFormat.Value r8 = a(r20, r2, this.r);
        int r9 = 2;
        if (r8 != null) goto L11;
    L37:
        JsonFormat.Shape r12 = null;
    L38:
        com.fasterxml.jackson.databind.j.a.i r10 = this.j;
        if (r6 == null) goto L65;
        Set<String> r13 = r4.a(r7, r6).findIgnoredForSerialization();
        Set<String> r11 = r4.b(r7, r6).getIncluded();
        com.fasterxml.jackson.databind.e.ac r14 = r4.a(r6);
        if (r14 != null) goto L47;
        if (r10 == null) goto L46;
        com.fasterxml.jackson.databind.e.ac r15 = r4.a(r6, null);
        if (r15 == null) goto L46;
        r10 = this.j.a(r15.f());
    L46:
        com.fasterxml.jackson.databind.j.d[] r16 = null;
        int r5 = 0;
    L57:
        Object r17 = r4.b(r6);
        if (r17 == null) goto L64;
        Object r18 = this.h;
        if (r18 != null) goto L62;
    L66:
        if (r5 <= 0) goto L72;
        com.fasterxml.jackson.databind.j.d[] r19 = this.f12896e;
        com.fasterxml.jackson.databind.j.d[] r22 = (com.fasterxml.jackson.databind.j.d[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r19, r19.length), com.fasterxml.jackson.databind.j.d[].class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.j.d r23 = r22[r5];
        System.arraycopy(r22, 0, r22, 1, r5);
        r22[0] = r23;
        com.fasterxml.jackson.databind.j.d[] r24 = this.f;
        if (r24 != null) goto L70;
        com.fasterxml.jackson.databind.j.d[] r25 = r16;
    L71:
        d r3 = a(r22, r25);
    L73:
        if (r10 == null) goto L77;
        com.fasterxml.jackson.databind.j.a.i r1 = r10.a(r20.a(r10.f12813a, r2));
        if (r1 == this.j) goto L77;
        r3 = r3.a(r1);
    L77:
        if (r13 != null) goto L79;
    L80:
        if (r11 == null) goto L82;
    L81:
        r3 = r3.a(r13, r11);
    L82:
        if (r17 == null) goto L84;
        r3 = r3.a(r17);
    L84:
        if (r12 != null) goto L87;
        r12 = this.k;
    L87:
        if (r12 == JsonFormat.Shape.ARRAY) goto L89;
        return r3;
    L89:
        return r3.d();
    L79:
        if (r13.isEmpty() == false) goto L81;
    L70:
        com.fasterxml.jackson.databind.j.d[] r26 = (com.fasterxml.jackson.databind.j.d[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r24, r24.length), com.fasterxml.jackson.databind.j.d[].class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.j.d r27 = r26[r5];
        System.arraycopy(r26, 0, r26, 1, r5);
        r26[0] = r27;
        r25 = r26;
        goto L71
    L72:
        r3 = this;
        goto L73
    L62:
        if (r17.equals(r18) == false) goto L66;
    L64:
        r17 = r16;
        goto L66
    L47:
        com.fasterxml.jackson.databind.e.ac r28 = r4.a(r6, r14);
        Class<? extends ObjectIdGenerator<?>> r110 = r28.d();
        com.fasterxml.jackson.databind.k r29 = r20.b().c(r20.a(r110), ObjectIdGenerator.class)[0];
        if (r110 != ObjectIdGenerators.PropertyGenerator.class) goto L56;
        String r111 = r28.b().b();
        int r112 = this.f12896e.length;
        r5 = 0;
    L50:
        if (r5 != r112) goto L52;
        com.fasterxml.jackson.databind.k r113 = this.f12895d;
        Object[] r114 = new Object[r9];
        r114[0] = com.fasterxml.jackson.databind.l.h.h(a());
        r114[1] = com.fasterxml.jackson.databind.l.h.b(r111);
        r20.b(r113, String.format("Invalid Object Id definition for %s: cannot find property with name %s", r114));
    L52:
        com.fasterxml.jackson.databind.j.d r30 = this.f12896e[r5];
        if (r111.equals(r30.a()) == true) goto L54;
        r5 = r5 + 1;
        r9 = 2;
        goto L50
    L54:
        r16 = null;
        r10 = com.fasterxml.jackson.databind.j.a.i.a(r30.getType(), (com.fasterxml.jackson.databind.x) ZeusTransformUtils.preCheckCast(null, com.fasterxml.jackson.databind.x.class, "com.obric.aiagent.plugin"), new com.fasterxml.jackson.databind.j.a.j(r28, r30), r28.f());
        goto L57
    L56:
        r16 = null;
        r10 = com.fasterxml.jackson.databind.j.a.i.a(r29, r28.b(), r20.a(r6, r28), r28.f());
        r5 = 0;
        goto L57
    L65:
        r16 = null;
        r17 = null;
        r11 = null;
        r13 = null;
        r5 = 0;
        goto L66
    L11:
        if (r8.hasShape() == false) goto L37;
        r12 = r8.getShape();
        if (r12 == JsonFormat.Shape.ANY) goto L38;
        if (r12 == this.k) goto L38;
        if (this.f12895d.k() == false) goto L27;
        int r115 = AnonymousClass1.f12897a[r12.ordinal()];
        if (r115 == 1) goto L25;
        if (r115 == 2) goto L25;
        if (r115 != 3) goto L38;
    L25:
        return r20.a(m.a(this.f12895d.e(), r20.c(), r7.e(this.f12895d), r8), r2);
    L27:
        if (r12 != JsonFormat.Shape.NATURAL) goto L38;
        if (this.f12895d.s() == false) goto L34;
        if (Map.class.isAssignableFrom(this.r) == true) goto L38;
    L34:
        if (Map.Entry.class.isAssignableFrom(this.r) == false) goto L38;
        com.fasterxml.jackson.databind.k r31 = this.f12895d.d(Map.Entry.class);
        return r20.a(new com.fasterxml.jackson.databind.j.a.h(this.f12895d, r31.b(0), r31.b(1), false, null, r2), r2);
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.fasterxml.jackson.databind.p
    public boolean b() {
        if (this.j == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.p
    public void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        if (this.j == null) goto L6;
        b(r3, r4, r5, r6);
        return;
    L6:
        com.fasterxml.jackson.a.g.b r0 = a(r6, r3, com.fasterxml.jackson.a.n.f12152b);
        r6.a(r4, r0);
        r4.a(r3);
        if (this.h == null) goto L9;
        d(r3, r4, r5);
    L10:
        r6.b(r4, r0);
        return;
    L9:
        c(r3, r4, r5);
        goto L10
    }

    public final void a(Object r5, com.fasterxml.jackson.a.h r6, com.fasterxml.jackson.databind.ac r7, boolean r8) {
        com.fasterxml.jackson.databind.j.a.i r0 = this.j;
        com.fasterxml.jackson.databind.j.a.u r1 = r7.a(r5, r0.f12815c);
        if (r1.a(r6, r7, r0) == false) goto L5;
        return;
    L5:
        Object r2 = r1.a(r5);
        if (r0.f12817e == false) goto L9;
        r0.f12816d.a(r2, r6, r7);
        return;
    L9:
        if (r8 == false) goto L11;
        r6.c(r5);
    L11:
        r1.b(r6, r7, r0);
        if (this.h == null) goto L14;
        d(r5, r6, r7);
    L15:
        if (r8 == false) goto L18;
        r6.k();
        return;
    L18:
        return;
    L14:
        c(r5, r6, r7);
        goto L15
    }

    public final void b(Object r9, com.fasterxml.jackson.a.h r10, com.fasterxml.jackson.databind.ac r11, com.fasterxml.jackson.databind.h.h r12) {
        com.fasterxml.jackson.databind.j.a.i r0 = this.j;
        com.fasterxml.jackson.databind.j.a.u r7 = r11.a(r9, r0.f12815c);
        if (r7.a(r10, r11, r0) == false) goto L5;
        return;
    L5:
        Object r1 = r7.a(r9);
        if (r0.f12817e == false) goto L9;
        r0.f12816d.a(r1, r10, r11);
        return;
    L9:
        a(r9, r10, r11, r12, r7);
    }

    public void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6, com.fasterxml.jackson.databind.j.a.u r7) {
        com.fasterxml.jackson.databind.j.a.i r0 = this.j;
        com.fasterxml.jackson.a.g.b r1 = a(r6, r3, com.fasterxml.jackson.a.n.f12152b);
        r6.a(r4, r1);
        r4.a(r3);
        r7.b(r4, r5, r0);
        if (this.h == null) goto L5;
        d(r3, r4, r5);
    L6:
        r6.b(r4, r1);
        return;
    L5:
        c(r3, r4, r5);
        goto L6
    }

    public final com.fasterxml.jackson.a.g.b a(com.fasterxml.jackson.databind.h.h r1, Object r2, com.fasterxml.jackson.a.n r3) {
        com.fasterxml.jackson.databind.e.j r0 = this.i;
        if (r0 == null) goto L5;
        Object r4 = r0.b(r2);
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        return r1.a(r2, r3, r4);
    L5:
        return r1.a(r2, r3);
    }

    public void c(Object r6, com.fasterxml.jackson.a.h r7, com.fasterxml.jackson.databind.ac r8) {
        String r0 = "[anySetter]";
        if (this.f != null) goto L5;
    L7:
        com.fasterxml.jackson.databind.j.d[] r1 = this.f12896e;
    L8:
        int r2 = 0;
        int r3 = r1.length;     // Catch: StackOverflowError -> L19 Exception -> L26
    L10:
        if (r2 >= r3) goto L15;
        com.fasterxml.jackson.databind.j.d r4 = r1[r2];     // Catch: StackOverflowError -> L19 Exception -> L26
        if (r4 == null) goto L14;
        r4.a(r6, r7, r8);     // Catch: StackOverflowError -> L19 Exception -> L26
    L14:
        r2 = r2 + 1;     // Catch: StackOverflowError -> L19 Exception -> L26
        goto L10
    L15:
        com.fasterxml.jackson.databind.j.a r5 = this.g;     // Catch: StackOverflowError -> L19 Exception -> L26
        if (r5 == null) goto L38;
        r5.a(r6, r7, r8);     // Catch: StackOverflowError -> L19 Exception -> L26
    L39:
        return;
    L38:
        return;
    L26:
        e = move-exception;
        if (r2 == r1.length) goto L31;
        r0 = r1[r2].a();
    L31:
        a(r8, e, r6, r0);
        return;
    L19:
        e = move-exception;
        com.fasterxml.jackson.databind.m r9 = new com.fasterxml.jackson.databind.m(r7, "Infinite recursion (StackOverflowError)", e);
        if (r2 == r1.length) goto L24;
        r0 = r1[r2].a();
    L24:
        r9.a(r6, r0);
        throw r9;
    L5:
        if (r8.e() == null) goto L7;
        r1 = this.f;
        goto L8
    }

    public void d(Object r7, com.fasterxml.jackson.a.h r8, com.fasterxml.jackson.databind.ac r9) {
        String r0 = "[anySetter]";
        if (this.f != null) goto L5;
    L7:
        com.fasterxml.jackson.databind.j.d[] r1 = this.f12896e;
    L8:
        com.fasterxml.jackson.databind.j.n r2 = a(r9, this.h, r7);
        if (r2 != null) goto L12;
        c(r7, r8, r9);
        return;
    L12:
        int r3 = 0;
        int r4 = r1.length;     // Catch: StackOverflowError -> L23 Exception -> L30
    L14:
        if (r3 >= r4) goto L19;
        com.fasterxml.jackson.databind.j.d r5 = r1[r3];     // Catch: StackOverflowError -> L23 Exception -> L30
        if (r5 == null) goto L18;
        r2.a(r7, r8, r9, r5);     // Catch: StackOverflowError -> L23 Exception -> L30
    L18:
        r3 = r3 + 1;     // Catch: StackOverflowError -> L23 Exception -> L30
        goto L14
    L19:
        com.fasterxml.jackson.databind.j.a r6 = this.g;     // Catch: StackOverflowError -> L23 Exception -> L30
        if (r6 == null) goto L42;
        r6.a(r7, r8, r9, r2);     // Catch: StackOverflowError -> L23 Exception -> L30
    L43:
        return;
    L42:
        return;
    L30:
        e = move-exception;
        if (r3 == r1.length) goto L35;
        r0 = r1[r3].a();
    L35:
        a(r9, e, r7, r0);
        return;
    L23:
        e = move-exception;
        com.fasterxml.jackson.databind.m r10 = new com.fasterxml.jackson.databind.m(r8, "Infinite recursion (StackOverflowError)", e);
        if (r3 == r1.length) goto L28;
        r0 = r1[r3].a();
    L28:
        r10.a(r7, r0);
        throw r10;
    L5:
        if (r9.e() == null) goto L7;
        r1 = this.f;
        goto L8
    }
}
