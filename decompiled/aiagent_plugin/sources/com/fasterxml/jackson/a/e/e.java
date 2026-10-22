package com.fasterxml.jackson.a.e;

import com.fasterxml.jackson.a.h;
import com.fasterxml.jackson.a.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JsonWriteContext.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final e f12032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected a f12033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected e f12034e;
    protected String f;
    protected Object g;
    protected boolean h;

    @Override // com.fasterxml.jackson.a.m
    public /* synthetic */ m a() {
        return l();
    }

    public e(int r1, e r2, a r3) {
        this.f12149a = r1;
        this.f12032c = r2;
        this.f12033d = r3;
        this.f12150b = -1;
    }

    public e(int r1, e r2, a r3, Object r4) {
        this.f12149a = r1;
        this.f12032c = r2;
        this.f12033d = r3;
        this.f12150b = -1;
        this.g = r4;
    }

    public e a(int r2) {
        this.f12149a = r2;
        this.f12150b = -1;
        this.f = null;
        this.h = false;
        this.g = null;
        a r3 = this.f12033d;
        if (r3 == null) goto L5;
        r3.b();
    L5:
        return this;
    }

    public e a(int r1, Object r2) {
        this.f12149a = r1;
        this.f12150b = -1;
        this.f = null;
        this.h = false;
        this.g = r2;
        a r3 = this.f12033d;
        if (r3 == null) goto L5;
        r3.b();
    L5:
        return this;
    }

    public e a(a r1) {
        this.f12033d = r1;
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

    public static e b(a r3) {
        return new e(0, null, r3);
    }

    public e j() {
        e r0 = this.f12034e;
        if (r0 != null) goto L11;
        a r2 = this.f12033d;
        if (r2 != null) goto L7;
        a r3 = null;
    L8:
        e r1 = new e(1, this, r3);
        this.f12034e = r1;
        return r1;
    L7:
        r3 = r2.a();
        goto L8
    L11:
        return r0.a(1);
    }

    public e b(Object r4) {
        e r0 = this.f12034e;
        if (r0 != null) goto L11;
        a r2 = this.f12033d;
        if (r2 != null) goto L7;
        a r3 = null;
    L8:
        e r1 = new e(1, this, r3, r4);
        this.f12034e = r1;
        return r1;
    L7:
        r3 = r2.a();
        goto L8
    L11:
        return r0.a(1, r4);
    }

    public e k() {
        e r0 = this.f12034e;
        if (r0 != null) goto L11;
        a r2 = this.f12033d;
        if (r2 != null) goto L7;
        a r3 = null;
    L8:
        e r1 = new e(2, this, r3);
        this.f12034e = r1;
        return r1;
    L7:
        r3 = r2.a();
        goto L8
    L11:
        return r0.a(2);
    }

    public e c(Object r4) {
        e r0 = this.f12034e;
        if (r0 != null) goto L11;
        a r2 = this.f12033d;
        if (r2 != null) goto L7;
        a r3 = null;
    L8:
        e r1 = new e(2, this, r3, r4);
        this.f12034e = r1;
        return r1;
    L7:
        r3 = r2.a();
        goto L8
    L11:
        return r0.a(2, r4);
    }

    public final e l() {
        return this.f12032c;
    }

    @Override // com.fasterxml.jackson.a.m
    public final String h() {
        return this.f;
    }

    public e m() {
        this.g = null;
        return this.f12032c;
    }

    public a n() {
        return this.f12033d;
    }

    public int a(String r3) {
        if (this.f12149a == 2) goto L5;
        return 4;
    L5:
        if (this.h == true) goto L17;
        this.h = true;
        this.f = r3;
        a r1 = this.f12033d;
        if (r1 == null) goto L11;
        a(r1, r3);
    L11:
        if (this.f12150b >= 0) goto L16;
        return 0;
    L16:
        return 1;
    L17:
        return 4;
    }

    private final void a(a r3, String r4) {
        if (r3.a(r4) == false) goto L10;
        Object r2 = r3.c();
        String r5 = "Duplicate field '" + r4 + "'";
        if (ZeusTransformUtils.instanceOf(r2, h.class) == false) goto L7;
        h r6 = (h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin");
    L9:
        throw new com.fasterxml.jackson.a.g(r5, r6);
    L7:
        r6 = null;
        goto L9
    }

    public int o() {
        if (this.f12149a != 2) goto L11;
        if (this.h == true) goto L8;
        return 5;
    L8:
        this.h = false;
        this.f12150b++;
        return 2;
    L11:
        if (this.f12149a != 1) goto L17;
        int r0 = this.f12150b;
        this.f12150b++;
        if (r0 >= 0) goto L16;
        return 0;
    L16:
        return 1;
    L17:
        this.f12150b++;
        if (this.f12150b == 0) goto L23;
        return 3;
    L23:
        return 0;
    }
}
