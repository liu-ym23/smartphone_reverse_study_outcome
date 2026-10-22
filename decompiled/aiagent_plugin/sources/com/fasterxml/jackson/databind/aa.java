package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.e.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: SerializationConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public final class aa extends com.fasterxml.jackson.databind.a.n<ab, aa> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final com.fasterxml.jackson.a.p f12240a = null;
    private static final int i = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.j.l f12241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.a.p f12242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f12243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final int f12244e;
    protected final int f;
    protected final int g;
    protected final int h;

    @Override // com.fasterxml.jackson.databind.a.n
    public /* synthetic */ com.fasterxml.jackson.databind.a.n b(long r1) {
        return a(r1);
    }

    static {
        f12240a = new com.fasterxml.jackson.a.h.e();
        i = a(ab.class);
    }

    public aa(com.fasterxml.jackson.databind.a.a r1, com.fasterxml.jackson.databind.h.d r2, af r3, com.fasterxml.jackson.databind.l.v r4, com.fasterxml.jackson.databind.a.h r5) {
        super(r1, r2, r3, r4, r5);
        this.f12243d = i;
        this.f12241b = null;
        this.f12242c = f12240a;
        this.f12244e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }

    private aa(aa r1, long r2, int r4, int r5, int r6, int r7, int r8) {
        super(r1, r2);
        this.f12243d = r4;
        this.f12241b = r1.f12241b;
        this.f12242c = r1.f12242c;
        this.f12244e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public final aa a(long r11) {
        return new aa(this, r11, this.f12243d, this.f12244e, this.f, this.g, this.h);
    }

    public com.fasterxml.jackson.a.p a() {
        com.fasterxml.jackson.a.p r2 = this.f12242c;
        if (ZeusTransformUtils.instanceOf(r2, com.fasterxml.jackson.a.h.f.class) == true) goto L5;
        return r2;
    L5:
        return (com.fasterxml.jackson.a.p) ZeusTransformUtils.preCheckCast(((com.fasterxml.jackson.a.h.f) ZeusTransformUtils.preCheckCast(r2, com.fasterxml.jackson.a.h.f.class, "com.obric.aiagent.plugin")).b(), com.fasterxml.jackson.a.p.class, "com.obric.aiagent.plugin");
    }

    public void a(com.fasterxml.jackson.a.h r4) {
        if (ab.f12246b.a(this.f12243d) == true) goto L5;
    L9:
        boolean r0 = ab.v.a(this.f12243d);
        int r1 = this.f;
        if (r1 != 0) goto L12;
        if (r0 == true) goto L12;
    L16:
        int r2 = this.h;
        if (r2 == 0) goto L20;
        r4.b(this.g, r2);
        return;
    L20:
        return;
    L12:
        int r3 = this.f12244e;
        if (r0 == false) goto L15;
        int r5 = com.fasterxml.jackson.a.h.a.h.c();
        r3 = r3 | r5;
        r1 = r1 | r5;
    L15:
        r4.a(r3, r1);
        goto L16
    L5:
        if (r4.c() != null) goto L9;
        com.fasterxml.jackson.a.p r6 = a();
        if (r6 == null) goto L9;
        r4.a(r6);
        goto L9
    }

    public final boolean a(ab r1) {
        if ((this.f12243d & r1.b()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public com.fasterxml.jackson.databind.j.l b() {
        return this.f12241b;
    }

    public com.fasterxml.jackson.a.p c() {
        return this.f12242c;
    }

    public c a(k r2) {
        return i().b(this, r2, this);
    }
}
