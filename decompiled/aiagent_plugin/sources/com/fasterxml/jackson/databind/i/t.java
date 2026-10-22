package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TextNode.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final t f12798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f12799b;

    static {
        f12798a = new t("");
    }

    public t(String r1) {
        this.f12799b = r1;
    }

    public static t b(String r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.isEmpty() == false) goto L10;
        return f12798a;
    L10:
        return new t(r1);
    }

    @Override // com.fasterxml.jackson.databind.i.u
    public com.fasterxml.jackson.a.n d() {
        return com.fasterxml.jackson.a.n.h;
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public final void a(com.fasterxml.jackson.a.h r1, ac r2) {
        String r0 = this.f12799b;
        if (r0 != null) goto L5;
        r1.l();
        return;
    L5:
        r1.b(r0);
    }

    public boolean equals(Object r4) {
        if (r4 != this) goto L7;
        return true;
    L7:
        if (r4 != null) goto L10;
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, t.class) == true) goto L12;
        return false;
    L12:
        return ((t) ZeusTransformUtils.preCheckCast(r4, t.class, "com.obric.aiagent.plugin")).f12799b.equals(this.f12799b);
    }

    public int hashCode() {
        return this.f12799b.hashCode();
    }
}
