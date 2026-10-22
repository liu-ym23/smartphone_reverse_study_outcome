package com.fasterxml.jackson.a.e;

import com.fasterxml.jackson.a.i;
import com.fasterxml.jackson.a.j;
import com.fasterxml.jackson.a.k;
import com.fasterxml.jackson.a.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JsonReadContext.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final c f12024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected a f12025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected c f12026e;
    protected String f;
    protected Object g;
    protected int h;
    protected int i;

    @Override // com.fasterxml.jackson.a.m
    public /* synthetic */ m a() {
        return j();
    }

    public c(c r1, a r2, int r3, int r4, int r5) {
        this.f12024c = r1;
        this.f12025d = r2;
        this.f12149a = r3;
        this.h = r4;
        this.i = r5;
        this.f12150b = -1;
    }

    public void a(int r1, int r2, int r3) {
        this.f12149a = r1;
        this.f12150b = -1;
        this.h = r2;
        this.i = r3;
        this.f = null;
        this.g = null;
        a r0 = this.f12025d;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public c a(a r1) {
        this.f12025d = r1;
        return this;
    }

    @Override // com.fasterxml.jackson.a.m
    public Object i() {
        return this.g;
    }

    @Override // com.fasterxml.jackson.a.m
    public void a(Object r1) {
        this.g = r1;
    }

    public static c b(a r7) {
        return new c(null, r7, 0, 1, 0);
    }

    public c a(int r8, int r9) {
        c r0 = this.f12026e;
        if (r0 != null) goto L9;
        a r1 = this.f12025d;
        if (r1 != null) goto L7;
        a r2 = null;
    L8:
        r0 = new c(this, r2, 1, r8, r9);
        this.f12026e = r0;
    L10:
        return r0;
    L7:
        r2 = r1.a();
        goto L8
    L9:
        r0.a(1, r8, r9);
        goto L10
    }

    public c b(int r8, int r9) {
        c r0 = this.f12026e;
        if (r0 != null) goto L10;
        a r1 = this.f12025d;
        if (r1 != null) goto L7;
        a r2 = null;
    L8:
        c r3 = new c(this, r2, 2, r8, r9);
        this.f12026e = r3;
        return r3;
    L7:
        r2 = r1.a();
        goto L8
    L10:
        r0.a(2, r8, r9);
        return r0;
    }

    @Override // com.fasterxml.jackson.a.m
    public String h() {
        return this.f;
    }

    public c j() {
        return this.f12024c;
    }

    @Override // com.fasterxml.jackson.a.m
    public i a(com.fasterxml.jackson.a.d.d r8) {
        return new i(r8, -1, this.h, this.i);
    }

    public c k() {
        this.g = null;
        return this.f12024c;
    }

    public a l() {
        return this.f12025d;
    }

    public boolean m() {
        int r0 = this.f12150b + 1;
        this.f12150b = r0;
        if (this.f12149a == 0) goto L6;
        if (r0 <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public void a(String r2) {
        this.f = r2;
        a r0 = this.f12025d;
        if (r0 == null) goto L6;
        a(r0, r2);
        return;
    }

    private void a(a r3, String r4) {
        if (r3.a(r4) == false) goto L10;
        Object r2 = r3.c();
        if (ZeusTransformUtils.instanceOf(r2, k.class) == false) goto L7;
        k r5 = (k) ZeusTransformUtils.preCheckCast(r2, k.class, "com.obric.aiagent.plugin");
    L9:
        throw new j(r5, "Duplicate field '" + r4 + "'");
    L7:
        r5 = null;
        goto L9
    }
}
