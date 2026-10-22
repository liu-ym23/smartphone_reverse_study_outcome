package com.fasterxml.jackson.a.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: JsonParserSequence.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.a.k[] f12111e;
    protected final boolean f;
    protected int g;
    protected boolean h;

    public k(boolean r3, com.fasterxml.jackson.a.k[] r4) {
        boolean r0 = false;
        super(r4[0]);
        this.f = r3;
        if (r3 == true) goto L5;
    L7:
        this.h = r0;
        this.f12111e = r4;
        this.g = 1;
        return;
    L5:
        if (this.f12110d.p() == false) goto L7;
        r0 = true;
        goto L7
    }

    public static k a(boolean r4, com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.a.k r6) {
        if (ZeusTransformUtils.instanceOf(r5, k.class) == false) goto L5;
    L8:
        ArrayList r1 = new ArrayList();
        if (ZeusTransformUtils.instanceOf(r5, k.class) == false) goto L11;
        ((k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin")).a(r1);
    L13:
        if (ZeusTransformUtils.instanceOf(r6, k.class) == false) goto L15;
        ((k) ZeusTransformUtils.preCheckCast(r6, k.class, "com.obric.aiagent.plugin")).a(r1);
    L17:
        return new k(r4, (com.fasterxml.jackson.a.k[]) ZeusTransformUtils.preCheckCast(r1.toArray(new com.fasterxml.jackson.a.k[r1.size()]), com.fasterxml.jackson.a.k[].class, "com.obric.aiagent.plugin"));
    L15:
        r1.add(r6);
        goto L17
    L11:
        r1.add(r5);
        goto L13
    L5:
        if (ZeusTransformUtils.instanceOf(r6, k.class) == true) goto L8;
        return new k(r4, new com.fasterxml.jackson.a.k[]{r5, r6});
    }

    public void a(List<com.fasterxml.jackson.a.k> r7) {
        List<com.fasterxml.jackson.a.k> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        int r1 = this.g - 1;
        int r3 = this.f12111e.length;
    L3:
        if (r1 >= r3) goto L9;
        com.fasterxml.jackson.a.k r4 = this.f12111e[r1];
        if (ZeusTransformUtils.instanceOf(r4, k.class) == false) goto L7;
        ((k) ZeusTransformUtils.preCheckCast(r4, k.class, "com.obric.aiagent.plugin")).a(r8);
    L8:
        r1 = r1 + 1;
        goto L3
    L7:
        r8.add(r4);
        goto L8
    }

    @Override // com.fasterxml.jackson.a.h.j, com.fasterxml.jackson.a.k, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    L2:
        this.f12110d.close();
        if (X() == true) goto L2;
    }

    @Override // com.fasterxml.jackson.a.h.j, com.fasterxml.jackson.a.k
    public com.fasterxml.jackson.a.n g() {
        if (this.f12110d != null) goto L7;
        return null;
    L7:
        if (this.h == false) goto L10;
        this.h = false;
        return this.f12110d.l();
    L10:
        com.fasterxml.jackson.a.n r0 = this.f12110d.g();
        if (r0 == null) goto L13;
        return r0;
    L13:
        return Y();
    }

    @Override // com.fasterxml.jackson.a.h.j, com.fasterxml.jackson.a.k
    public com.fasterxml.jackson.a.k k() {
        if (this.f12110d.l() != com.fasterxml.jackson.a.n.f12152b) goto L5;
    L7:
        int r0 = 1;
    L8:
        com.fasterxml.jackson.a.n r1 = g();
        if (r1 == null) goto L10;
        if (r1.e() == true) goto L13;
        if (r1.f() == false) goto L8;
        r0 = r0 - 1;
        if (r0 != 0) goto L8;
        return this;
    L13:
        r0 = r0 + 1;
        goto L8
    L10:
        return this;
    L5:
        if (this.f12110d.l() == com.fasterxml.jackson.a.n.f12154d) goto L7;
        return this;
    }

    public boolean X() {
        int r0 = this.g;
        com.fasterxml.jackson.a.k[] r1 = this.f12111e;
        if (r0 >= r1.length) goto L6;
        this.g = r0 + 1;
        this.f12110d = r1[r0];
        return true;
    L6:
        return false;
    }

    public com.fasterxml.jackson.a.n Y() {
    L2:
        int r0 = this.g;
        com.fasterxml.jackson.a.k[] r1 = this.f12111e;
        if (r0 >= r1.length) goto L13;
        this.g = r0 + 1;
        this.f12110d = r1[r0];
        if (this.f == true) goto L7;
    L10:
        com.fasterxml.jackson.a.n r2 = this.f12110d.g();
        if (r2 == null) goto L2;
        return r2;
    L7:
        if (this.f12110d.p() == false) goto L10;
        return this.f12110d.n();
    L13:
        return null;
    }
}
