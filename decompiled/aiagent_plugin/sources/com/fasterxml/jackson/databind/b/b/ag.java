package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: StringArrayDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public final class ag extends ab<String[]> implements com.fasterxml.jackson.databind.b.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ag f12392a = null;
    private static final String[] f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.fasterxml.jackson.databind.l<String> f12393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.s f12394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Boolean f12395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final boolean f12396e;

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        return b(r3, r4, (String[]) ZeusTransformUtils.preCheckCast(r5, String[].class, "com.obric.aiagent.plugin"));
    }

    static {
        f = new String[0];
        f12392a = new ag();
    }

    public ag() {
        this(null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ag(com.fasterxml.jackson.databind.l<?> r3, com.fasterxml.jackson.databind.b.s r4, Boolean r5) {
        com.fasterxml.jackson.databind.b.s r6 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        super(String[].class);
        this.f12393b = r3;
        this.f12394c = r6;
        this.f12395d = r5;
        this.f12396e = com.fasterxml.jackson.databind.b.a.q.a(r6);
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f12967a;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return Boolean.TRUE;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.l.a e() {
        return com.fasterxml.jackson.databind.l.a.f12995b;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        return f;
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.d r5) {
        com.fasterxml.jackson.databind.d r6 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r5, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.l<?> r0 = a(r4, r6, this.f12393b);
        com.fasterxml.jackson.databind.k r1 = r4.b(String.class);
        if (r0 != null) goto L5;
        com.fasterxml.jackson.databind.l<?> r2 = r4.a(r1, r6);
    L6:
        Boolean r3 = a(r4, r6, String[].class, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        com.fasterxml.jackson.databind.b.s r7 = b(r4, r6, r2);
        if (r2 == null) goto L12;
        if (a(r2) == false) goto L12;
        r2 = null;
    L12:
        if (this.f12393b != r2) goto L19;
        if (Objects.equals(this.f12395d, r3) == false) goto L19;
        if (this.f12394c != r7) goto L19;
        return this;
    L19:
        return new ag(r2, r7, r3);
    L5:
        r2 = r4.b(r0, r6, r1);
        goto L6
    }

    public String[] b(com.fasterxml.jackson.a.k r8, com.fasterxml.jackson.databind.h r9) {
        if (r8.q() == true) goto L7;
        return d(r8, r9);
    L7:
        if (this.f12393b != null) goto L9;
        com.fasterxml.jackson.databind.l.s r0 = r9.n();
        Object[] r1 = r0.a();
        int r3 = 0;
    L37:
        String r4 = r8.j();     // Catch: Exception -> L34
        if (r4 != null) goto L26;
        com.fasterxml.jackson.a.n r5 = r8.l();     // Catch: Exception -> L34
        if (r5 == com.fasterxml.jackson.a.n.f12155e) goto L16;
        if (r5 != com.fasterxml.jackson.a.n.m) goto L24;
        if (this.f12396e == true) goto L37;
        r4 = (String) ZeusTransformUtils.preCheckCast(this.f12394c.a(r9), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L34
        goto L26
    L24:
        r4 = B(r8, r9);     // Catch: Exception -> L34
        goto L26
    L16:
        String[] r7 = (String[]) ZeusTransformUtils.preCheckCast(r0.a(r1, r3, String.class), String[].class, "com.obric.aiagent.plugin");
        r9.a(r0);
        return r7;
    L26:
        if (r3 < r1.length) goto L29;
        r1 = r0.a(r1);     // Catch: Exception -> L34
        r3 = 0;
    L29:
        int r6 = r3 + 1;
        r1[r3] = r4;     // Catch: Exception -> L32
        r3 = r6;
    L32:
        e = e;
        r3 = r6;
    L36:
        throw com.fasterxml.jackson.databind.m.a(e, r1, r0.c() + r3);
    L34:
        e = e;
        goto L36
    L9:
        return a(r8, r9, null);
    }

    public final String[] a(com.fasterxml.jackson.a.k r8, com.fasterxml.jackson.databind.h r9, String[] r10) {
        com.fasterxml.jackson.databind.l.s r0 = r9.n();
        if (r10 != null) goto L5;
        Object[] r11 = r0.a();
        int r2 = 0;
    L6:
        com.fasterxml.jackson.databind.l<String> r3 = this.f12393b;
    L34:
        if (r8.j() != null) goto L21;
        com.fasterxml.jackson.a.n r4 = r8.l();     // Catch: Exception -> L31
        if (r4 == com.fasterxml.jackson.a.n.f12155e) goto L12;
        if (r4 != com.fasterxml.jackson.a.n.m) goto L20;
        if (this.f12396e == true) goto L34;
        String r5 = (String) ZeusTransformUtils.preCheckCast(this.f12394c.a(r9), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L31
    L23:
        if (r2 < r11.length) goto L26;
        r11 = r0.a(r11);     // Catch: Exception -> L31
        r2 = 0;
    L26:
        int r6 = r2 + 1;
        r11[r2] = r5;     // Catch: Exception -> L29
        r2 = r6;
    L29:
        e = e;
        r2 = r6;
    L33:
        throw com.fasterxml.jackson.databind.m.a(e, String.class, r2);
    L20:
        r5 = (String) ZeusTransformUtils.preCheckCast(r3.a(r8, r9), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L31
        goto L23
    L12:
        String[] r7 = (String[]) ZeusTransformUtils.preCheckCast(r0.a(r11, r2, String.class), String[].class, "com.obric.aiagent.plugin");
        r9.a(r0);
        return r7;
    L21:
        r5 = (String) ZeusTransformUtils.preCheckCast(r3.a(r8, r9), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L31
    L31:
        e = e;
        goto L33
    L5:
        r2 = r10.length;
        r11 = r0.a(r10, r2);
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return r3.b(r1, r2);
    }

    public String[] b(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8, String[] r9) {
        if (r7.q() == true) goto L10;
        String[] r6 = d(r7, r8);
        if (r6 != null) goto L7;
        return r9;
    L7:
        int r10 = r9.length;
        String[] r11 = new String[r6.length + r10];
        System.arraycopy(r9, 0, r11, 0, r10);
        System.arraycopy(r6, 0, r11, r10, r6.length);
        return r11;
    L10:
        if (this.f12393b != null) goto L12;
        com.fasterxml.jackson.databind.l.s r0 = r8.n();
        int r2 = r9.length;
        Object[] r12 = r0.a(r9, r2);
    L41:
        String r3 = r7.j();     // Catch: Exception -> L38
        if (r3 != null) goto L30;
        com.fasterxml.jackson.a.n r4 = r7.l();     // Catch: Exception -> L38
        if (r4 == com.fasterxml.jackson.a.n.f12155e) goto L19;
        if (r4 == com.fasterxml.jackson.a.n.m) goto L24;
        r3 = B(r7, r8);     // Catch: Exception -> L38
        goto L30
    L24:
        if (this.f12396e == true) goto L25;
        r3 = (String) ZeusTransformUtils.preCheckCast(this.f12394c.a(r8), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        goto L30
    L25:
        return f;
    L19:
        String[] r13 = (String[]) ZeusTransformUtils.preCheckCast(r0.a(r12, r2, String.class), String[].class, "com.obric.aiagent.plugin");
        r8.a(r0);
        return r13;
    L30:
        if (r2 < r12.length) goto L33;
        r12 = r0.a(r12);     // Catch: Exception -> L38
        r2 = 0;
    L33:
        int r5 = r2 + 1;
        r12[r2] = r3;     // Catch: Exception -> L36
        r2 = r5;
    L36:
        e = e;
        r2 = r5;
    L40:
        throw com.fasterxml.jackson.databind.m.a(e, r12, r0.c() + r2);
    L38:
        e = e;
        goto L40
    L12:
        return a(r7, r8, r9);
    }

    private final String[] d(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
        if (this.f12395d != Boolean.TRUE) goto L5;
    L10:
        boolean r0 = true;
    L12:
        if (r0 == false) goto L20;
        if (r5.a(com.fasterxml.jackson.a.n.m) == false) goto L16;
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.f12394c.a(r6), String.class, "com.obric.aiagent.plugin");
    L18:
        return new String[]{r4};
    L16:
        r4 = B(r5, r6);
        goto L18
    L20:
        if (r5.a(com.fasterxml.jackson.a.n.h) == false) goto L24;
        return (String[]) ZeusTransformUtils.preCheckCast(r(r5, r6), String[].class, "com.obric.aiagent.plugin");
    L24:
        return (String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r6.a(this.B, r5), String[].class, "com.obric.aiagent.plugin"), String[].class, "com.obric.aiagent.plugin");
    L5:
        if (this.f12395d == null) goto L7;
    L9:
        r0 = false;
        goto L12
    L7:
        if (r6.a(com.fasterxml.jackson.databind.i.q) == false) goto L9;
        goto L9
    }
}
