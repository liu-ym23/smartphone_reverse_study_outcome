package com.ttnet.org.chromium.base.task;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: TaskTraits.java */
/* JADX INFO: loaded from: classes4.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f37770a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f37771b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f37772c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f37773d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n f37774e = null;
    public static final n f = null;
    public static final n g = null;
    public static final n h = null;
    public static final n i = null;
    public static final n j = null;
    public static final n k = null;
    static final /* synthetic */ boolean r = true;
    int l;
    boolean m;
    boolean n;
    byte o;
    byte[] p;
    boolean q;

    static {
        n r0 = new n().a(0);
        f37770a = r0;
        f37771b = r0.a();
        n r1 = new n().a(1);
        f37772c = r1;
        f37773d = r1.a();
        n r2 = new n().a(2);
        f37774e = r2;
        f = r2.a();
        n r3 = new n();
        g = r3;
        r3.q = true;
        n r4 = new n().b().a(2);
        h = r4;
        i = r4.a(2);
        j = r4.a(1);
        k = r4.a(0);
    }

    private n() {
        this.l = 2;
    }

    private n(n r2) {
        this.l = r2.l;
        this.m = r2.m;
        this.n = r2.n;
        this.o = r2.o;
        this.p = r2.p;
    }

    public n a(int r2) {
        n r0 = new n(this);
        r0.l = r2;
        return r0;
    }

    public n a() {
        n r0 = new n(this);
        r0.m = true;
        return r0;
    }

    public n b() {
        n r0 = new n(this);
        r0.n = true;
        return r0;
    }

    public boolean c() {
        if (this.o == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public n d() {
        if (this.n == false) goto L5;
        return this;
    L5:
        if (c() == false) goto L7;
        return this;
    L7:
        return b();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == false) goto L22;
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        if (this.l != r6.l) goto L21;
        if (this.m != r6.m) goto L21;
        if (this.n != r6.n) goto L21;
        if (this.o != r6.o) goto L21;
        if (Arrays.equals(this.p, r6.p) == false) goto L21;
        if (this.q != r6.q) goto L21;
        return true;
    L21:
        return false;
    L22:
        return false;
    }

    public int hashCode() {
        return ((((((((((1147 + this.l) * 37) + (!this.m ? 1 : 0)) * 37) + (!this.n ? 1 : 0)) * 37) + this.o) * 37) + Arrays.hashCode(this.p)) * 37) + (!this.q ? 1 : 0);
    }
}
