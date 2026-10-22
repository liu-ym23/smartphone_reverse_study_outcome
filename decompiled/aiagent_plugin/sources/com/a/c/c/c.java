package com.a.c.c;

import com.a.c.c.a.h;
import com.a.c.c.a.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ExecutionTimeBuilder.java */
/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.c.b f3164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f3165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.a.c.b.a f3166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.a.c.b.a f3167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.a.c.b.a f3168e;
    private f f;
    private f g;
    private f h;
    private f i;

    public c(com.a.c.b r3) {
        this.f3164a = (com.a.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.a.c.b.class, "com.obric.aiagent.plugin");
    }

    public c a(com.a.c.b.a r4) {
        a(com.a.c.b.b.f3104a, r4);
        this.i = new f(i.a(r4).b(0, 59));
        return this;
    }

    public c b(com.a.c.b.a r4) {
        a(com.a.c.b.b.f3105b, r4);
        this.h = new f(i.a(r4).b(0, 59));
        return this;
    }

    public c c(com.a.c.b.a r4) {
        a(com.a.c.b.b.f3106c, r4);
        this.g = new f(i.a(r4).b(0, 23));
        return this;
    }

    public c d(com.a.c.b.a r4) {
        a(com.a.c.b.b.f3108e, r4);
        this.f = new f(i.a(r4).b(1, 12));
        return this;
    }

    public c e(com.a.c.b.a r2) {
        a(com.a.c.b.b.g, r2);
        this.f3165b = i.a(r2);
        return this;
    }

    public c f(com.a.c.b.a r2) {
        a(com.a.c.b.b.f, r2);
        this.f3166c = r2;
        return this;
    }

    public c g(com.a.c.b.a r2) {
        a(com.a.c.b.b.f3107d, r2);
        this.f3167d = r2;
        return this;
    }

    public c h(com.a.c.b.a r2) {
        a(com.a.c.b.b.h, r2);
        this.f3168e = r2;
        return this;
    }

    public b a() {
        if (this.i != null) goto L5;
        this.i = a(com.a.c.b.b.f3104a, 0, 59);
        boolean r0 = false;
    L7:
        if (this.h != null) goto L13;
        com.a.c.b.b r4 = com.a.c.b.b.f3105b;
        if (r0 == false) goto L11;
        f r1 = b(r4, 0, 59);
    L12:
        this.h = r1;
    L15:
        if (this.g != null) goto L21;
        com.a.c.b.b r5 = com.a.c.b.b.f3106c;
        if (r0 == false) goto L19;
        f r2 = b(r5, 0, 23);
    L20:
        this.g = r2;
    L23:
        if (this.f3167d != null) goto L29;
        com.a.c.b.a.a r3 = a(com.a.c.b.b.f3107d);
        if (r0 == false) goto L27;
        com.a.c.b.a r6 = new com.a.c.b.a(com.a.c.b.b.f3107d, com.a.c.b.c.e.d(), r3);
    L28:
        this.f3167d = r6;
    L31:
        if (this.f3166c != null) goto L37;
        com.a.c.b.a.a r7 = a(com.a.c.b.b.f);
        if (r0 == false) goto L35;
        com.a.c.b.a r8 = new com.a.c.b.a(com.a.c.b.b.f, com.a.c.b.c.e.d(), r7);
    L36:
        this.f3166c = r8;
    L39:
        if (this.f != null) goto L46;
        com.a.c.b.b r9 = com.a.c.b.b.f3108e;
        if (r0 == false) goto L43;
        f r10 = b(r9, 1, 12);
    L44:
        this.f = r10;
        goto L46
    L43:
        r10 = a(r9, 1, 12);
    L46:
        if (this.f3165b != null) goto L49;
        this.f3165b = i.a(new com.a.c.b.a(com.a.c.b.b.g, com.a.c.b.c.e.d(), a(com.a.c.b.b.g)));
    L49:
        if (this.f3168e != null) goto L56;
        com.a.c.b.a.a r11 = a(com.a.c.b.b.h);
        com.a.c.b.b r12 = com.a.c.b.b.h;
        if (r0 == false) goto L53;
        com.a.c.b.c.e r13 = com.a.c.b.c.e.e();
    L54:
        this.f3168e = new com.a.c.b.a(r12, r13, r11);
        goto L56
    L53:
        r13 = com.a.c.b.c.e.d();
    L56:
        return new e(this.f3164a.c(), this.f3164a.a(com.a.c.b.b.g), this.f3166c, this.f3167d, this.f3168e, this.f, this.g, this.h, this.i);
    L35:
        r8 = new com.a.c.b.a(com.a.c.b.b.f, new com.a.c.b.c.f(new com.a.c.b.d.b(1)), r7);
        goto L36
    L37:
        r0 = true;
        goto L39
    L27:
        r6 = new com.a.c.b.a(com.a.c.b.b.f3107d, new com.a.c.b.c.f(new com.a.c.b.d.b(1)), r3);
        goto L28
    L29:
        r0 = true;
        goto L31
    L19:
        r2 = a(r5, 0, 23);
        goto L20
    L21:
        r0 = true;
        goto L23
    L11:
        r1 = a(r4, 0, 59);
        goto L12
    L13:
        r0 = true;
        goto L15
    L5:
        r0 = true;
        goto L7
    }

    private f a(com.a.c.b.b r5, int r6, int r7) {
        com.a.c.b.a.a r4 = a(r5);
        return new f(i.a(new com.a.c.b.a(r5, new com.a.c.b.c.f(new com.a.c.b.d.b(r6)), r4)).b(r6, r7));
    }

    private f b(com.a.c.b.b r4, int r5, int r6) {
        return new f(i.a(new com.a.c.b.a(r4, com.a.c.b.c.e.d(), a(r4))).b(r5, r6));
    }

    private void a(com.a.c.b.b r3, com.a.c.b.a r4) {
        com.a.e.a.a(r3, "Reference CronFieldName cannot be null");
        com.a.e.a.a(r4.a(), "CronField's CronFieldName cannot be null");
        if (r3.equals(r4.a()) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("Invalid argument! Expected CronField instance for field %s but found %s", new Object[]{r4.a(), r3}));
    }

    private com.a.c.b.a.a a(com.a.c.b.b r2) {
        if (this.f3164a.c().a(r2) == null) goto L6;
        return this.f3164a.c().a(r2).c();
    L6:
        return com.a.c.b.a.b.h().a(r2).g();
    }
}
