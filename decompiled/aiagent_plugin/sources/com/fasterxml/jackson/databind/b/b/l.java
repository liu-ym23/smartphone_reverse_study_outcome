package com.fasterxml.jackson.databind.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.EnumMap;

/* JADX INFO: compiled from: EnumMapDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends i<EnumMap<?, ?>> implements com.fasterxml.jackson.databind.b.i, com.fasterxml.jackson.databind.b.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Class<?> f12435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.q f12436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.l<Object> f12437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.e f12438d;
    protected final com.fasterxml.jackson.databind.b.y i;
    protected com.fasterxml.jackson.databind.l<Object> j;
    protected com.fasterxml.jackson.databind.b.a.v k;

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        return a(r3, r4, (EnumMap) ZeusTransformUtils.preCheckCast(r5, EnumMap.class, "com.obric.aiagent.plugin"));
    }

    public l(com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.b.y r4, com.fasterxml.jackson.databind.q r5, com.fasterxml.jackson.databind.l<?> r6, com.fasterxml.jackson.databind.h.e r7, com.fasterxml.jackson.databind.b.s r8) {
        super(r3, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r8, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), null);
        this.f12435a = r3.w().e();
        this.f12436b = r5;
        this.f12437c = r6;
        this.f12438d = r7;
        this.i = r4;
    }

    public l(l r3, com.fasterxml.jackson.databind.q r4, com.fasterxml.jackson.databind.l<?> r5, com.fasterxml.jackson.databind.h.e r6, com.fasterxml.jackson.databind.b.s r7) {
        super(r3, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r3.h);
        this.f12435a = r3.f12435a;
        this.f12436b = r4;
        this.f12437c = r5;
        this.f12438d = r6;
        this.i = r3.i;
        this.j = r3.j;
        this.k = r3.k;
    }

    public l a(com.fasterxml.jackson.databind.q r7, com.fasterxml.jackson.databind.l<?> r8, com.fasterxml.jackson.databind.h.e r9, com.fasterxml.jackson.databind.b.s r10) {
        com.fasterxml.jackson.databind.b.s r5 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r10, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        if (r7 != this.f12436b) goto L12;
        if (r5 != this.f) goto L12;
        if (r8 != this.f12437c) goto L12;
        if (r9 != this.f12438d) goto L12;
        return this;
    L12:
        return new l(this, r7, r8, r9, r5);
    }

    @Override // com.fasterxml.jackson.databind.b.t
    public void d(com.fasterxml.jackson.databind.h r8) {
        com.fasterxml.jackson.databind.b.y r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.l() == false) goto L11;
        com.fasterxml.jackson.databind.k r1 = this.i.b(r8.c());
        if (r1 != null) goto L9;
        r8.b(this.f12422e, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[]{this.f12422e, this.i.getClass().getName()}));
    L9:
        this.j = a(r8, r1, null);
        return;
    L11:
        if (this.i.m() == false) goto L17;
        com.fasterxml.jackson.databind.k r2 = this.i.c(r8.c());
        if (r2 != null) goto L15;
        r8.b(this.f12422e, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[]{this.f12422e, this.i.getClass().getName()}));
    L15:
        this.j = a(r8, r2, null);
        return;
    L17:
        if (this.i.n() == false) goto L23;
        this.k = com.fasterxml.jackson.databind.b.a.v.a(r8, this.i, this.i.a(r8.c()), r8.a(com.fasterxml.jackson.databind.r.v));
        return;
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.d r5) {
        com.fasterxml.jackson.databind.d r6 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.q r0 = this.f12436b;
        if (r0 != null) goto L5;
        r0 = r4.b(this.f12422e.w(), r6);
    L5:
        com.fasterxml.jackson.databind.l<?> r1 = this.f12437c;
        com.fasterxml.jackson.databind.k r2 = this.f12422e.x();
        if (r1 != null) goto L8;
        com.fasterxml.jackson.databind.l<?> r3 = r4.a(r2, r6);
    L9:
        com.fasterxml.jackson.databind.h.e r7 = this.f12438d;
        if (r7 == null) goto L13;
        r7 = r7.a(r6);
    L13:
        return a(r0, r3, r7, b(r4, r6, r3));
    L8:
        r3 = r4.b(r1, r6, r2);
        goto L9
    }

    @Override // com.fasterxml.jackson.databind.l
    public boolean c() {
        if (this.f12437c == null) goto L5;
    L9:
        return false;
    L5:
        if (this.f12436b != null) goto L9;
        if (this.f12438d != null) goto L9;
        return true;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f12969c;
    }

    @Override // com.fasterxml.jackson.databind.b.b.i
    public com.fasterxml.jackson.databind.l<Object> h() {
        return this.f12437c;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab
    public com.fasterxml.jackson.databind.b.y k() {
        return this.i;
    }

    @Override // com.fasterxml.jackson.databind.b.b.i, com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        return e(r1);
    }

    public EnumMap<?, ?> b(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
        if (this.k != null) goto L5;
        com.fasterxml.jackson.databind.l<Object> r0 = this.j;
        if (r0 != null) goto L9;
        int r1 = r4.m();
        if (r1 == 1) goto L27;
        if (r1 == 2) goto L27;
        if (r1 == 3) goto L25;
        if (r1 == 5) goto L27;
        if (r1 == 6) goto L23;
        return (EnumMap) ZeusTransformUtils.preCheckCast(r5.a(f(r5), r4), EnumMap.class, "com.obric.aiagent.plugin");
    L23:
        return (EnumMap) ZeusTransformUtils.preCheckCast(r(r4, r5), EnumMap.class, "com.obric.aiagent.plugin");
    L25:
        return (EnumMap) ZeusTransformUtils.preCheckCast(e(r4, r5), EnumMap.class, "com.obric.aiagent.plugin");
    L27:
        return a(r4, r5, e(r5));
    L9:
        return (EnumMap) ZeusTransformUtils.preCheckCast(this.i.a(r5, r0.a(r4, r5)), EnumMap.class, "com.obric.aiagent.plugin");
    L5:
        return d(r4, r5);
    }

    public EnumMap<?, ?> a(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10, EnumMap r11) {
        r9.a(r11);
        com.fasterxml.jackson.databind.l<Object> r0 = this.f12437c;
        com.fasterxml.jackson.databind.h.e r1 = this.f12438d;
        if (r9.r() == false) goto L5;
        String r2 = r9.i();
    L12:
        if (r2 == null) goto L34;
        Enum r4 = (Enum) ZeusTransformUtils.preCheckCast(this.f12436b.a(r2, r10), Enum.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.a.n r5 = r9.g();
        if (r4 == null) goto L16;
        if (r5 == com.fasterxml.jackson.a.n.m) goto L23;
        if (r1 != null) goto L28;
        Object r3 = r0.a(r9, r10);     // Catch: Exception -> L31
    L29:
        r11.put(r4, r3);
    L30:
        r2 = r9.i();
        goto L12
    L28:
        r3 = r0.a(r9, r10, r1);     // Catch: Exception -> L31
        goto L29
    L23:
        if (this.g == true) goto L30;
        r3 = this.f.a(r10);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        return (EnumMap) ZeusTransformUtils.preCheckCast(a(r10, e, r11, r2), EnumMap.class, "com.obric.aiagent.plugin");
    L16:
        if (r10.a(com.fasterxml.jackson.databind.i.x) == false) goto L18;
        r9.k();
        goto L30
    L18:
        return (EnumMap) ZeusTransformUtils.preCheckCast(r10.b(this.f12435a, r2, "value not one of declared Enum instance names for %s", new Object[]{this.f12422e.w()}), EnumMap.class, "com.obric.aiagent.plugin");
    L34:
        return r11;
    L5:
        com.fasterxml.jackson.a.n r6 = r9.l();
        if (r6 != com.fasterxml.jackson.a.n.f) goto L8;
    L11:
        r2 = r9.w();
        goto L12
    L8:
        if (r6 != com.fasterxml.jackson.a.n.f12153c) goto L10;
        return r11;
    L10:
        r10.a(this, com.fasterxml.jackson.a.n.f, null, new Object[0]);
        goto L11
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return r3.a(r1, r2);
    }

    public EnumMap<?, ?> e(com.fasterxml.jackson.databind.h r9) {
        com.fasterxml.jackson.databind.b.y r1 = this.i;
        if (r1 == null) goto L5;
    L12:
        e = move-exception;
        return (EnumMap) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.a(r9, e), EnumMap.class, "com.obric.aiagent.plugin");
    L7:
        if (r1.k() == true) goto L11;
        return (EnumMap) ZeusTransformUtils.preCheckCast(r9.a(a(), k(), null, "no default constructor found", new Object[0]), EnumMap.class, "com.obric.aiagent.plugin");
    L11:
        return (EnumMap) ZeusTransformUtils.preCheckCast(this.i.a(r9), EnumMap.class, "com.obric.aiagent.plugin");
    L5:
        return new EnumMap(this.f12435a);
    }

    public EnumMap<?, ?> d(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
        com.fasterxml.jackson.databind.b.a.v r0 = this.k;
        com.fasterxml.jackson.databind.b.a.y r2 = r0.a(r9, r10, null);
        if (r9.r() == false) goto L6;
        String r3 = r9.i();
    L10:
        if (r3 == null) goto L49;
        com.fasterxml.jackson.a.n r5 = r9.g();
        com.fasterxml.jackson.databind.b.v r6 = r0.a(r3);
        if (r6 != null) goto L14;
        Enum r7 = (Enum) ZeusTransformUtils.preCheckCast(this.f12436b.a(r3, r10), Enum.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L25;
        if (r5 == com.fasterxml.jackson.a.n.m) goto L32;
        com.fasterxml.jackson.databind.h.e r4 = this.f12438d;     // Catch: Exception -> L41
        if (r4 != null) goto L38;
        Object r8 = this.f12437c.a(r9, r10);     // Catch: Exception -> L41
    L39:
        r2.a(r7, r8);
    L40:
        r3 = r9.i();
        goto L10
    L38:
        r8 = this.f12437c.a(r9, r10, r4);     // Catch: Exception -> L41
        goto L39
    L32:
        if (this.g == true) goto L40;
        r8 = this.f.a(r10);     // Catch: Exception -> L41
    L41:
        e = move-exception;
        a(r10, e, this.f12422e.e(), r3);
        return null;
    L25:
        if (r10.a(com.fasterxml.jackson.databind.i.x) == false) goto L27;
        r9.g();
        r9.k();
        goto L40
    L27:
        return (EnumMap) ZeusTransformUtils.preCheckCast(r10.b(this.f12435a, r3, "value not one of declared Enum instance names for %s", new Object[]{this.f12422e.w()}), EnumMap.class, "com.obric.aiagent.plugin");
    L14:
        if (r2.a(r6, r6.a(r9, r10)) == false) goto L40;
        r9.g();
        return a(r9, r10, (EnumMap) ZeusTransformUtils.preCheckCast(r0.a(r10, r2), EnumMap.class, "com.obric.aiagent.plugin"));
    L19:
        e = move-exception;
        return (EnumMap) ZeusTransformUtils.preCheckCast(a(r10, e, this.f12422e.e(), r3), EnumMap.class, "com.obric.aiagent.plugin");
    L49:
        return (EnumMap) ZeusTransformUtils.preCheckCast(r0.a(r10, r2), EnumMap.class, "com.obric.aiagent.plugin");
    L46:
        e = move-exception;
        a(r10, e, this.f12422e.e(), r3);
        return null;
    L6:
        if (r9.a(com.fasterxml.jackson.a.n.f) == false) goto L8;
        r3 = r9.w();
        goto L10
    L8:
        r3 = null;
        goto L10
    }
}
