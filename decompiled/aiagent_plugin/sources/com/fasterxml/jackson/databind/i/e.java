package com.fasterxml.jackson.databind.i;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BooleanNode.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12767a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f12768b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f12769c;

    static {
        f12767a = new e(true);
        f12768b = new e(false);
    }

    public e(boolean r1) {
        this.f12769c = r1;
    }

    public static e e() {
        return f12767a;
    }

    public static e f() {
        return f12768b;
    }

    @Override // com.fasterxml.jackson.databind.i.u
    public com.fasterxml.jackson.a.n d() {
        if (this.f12769c == false) goto L6;
        return com.fasterxml.jackson.a.n.k;
    L6:
        return com.fasterxml.jackson.a.n.l;
    }

    @Override // com.fasterxml.jackson.databind.i.b, com.fasterxml.jackson.databind.o
    public final void a(com.fasterxml.jackson.a.h r1, ac r2) {
        r1.a(this.f12769c);
    }

    public int hashCode() {
        if (this.f12769c == false) goto L5;
        return 3;
    L5:
        return 1;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L12;
        return false;
    L12:
        if (this.f12769c != ((e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin")).f12769c) goto L15;
        return true;
    L15:
        return false;
    }
}
