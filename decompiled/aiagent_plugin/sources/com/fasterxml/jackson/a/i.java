package com.fasterxml.jackson.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: JsonLocation.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f12130a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final long f12131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final long f12132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f12133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final int f12134e;
    protected final com.fasterxml.jackson.a.d.d f;
    protected transient String g;

    static {
        f12130a = new i(com.fasterxml.jackson.a.d.d.a(), -1, -1, -1, -1);
    }

    public i(com.fasterxml.jackson.a.d.d r9, long r10, int r12, int r13) {
        this(r9, -1, r10, r12, r13);
    }

    public i(com.fasterxml.jackson.a.d.d r1, long r2, long r4, int r6, int r7) {
        if (r1 != null) goto L5;
        r1 = com.fasterxml.jackson.a.d.d.a();
    L5:
        this.f = r1;
        this.f12131b = r2;
        this.f12132c = r4;
        this.f12133d = r6;
        this.f12134e = r7;
    }

    public String a() {
        if (this.g != null) goto L6;
        this.g = this.f.g();
    L6:
        return this.g;
    }

    public StringBuilder a(StringBuilder r7) {
        if (this.f.b() == false) goto L13;
        r7.append("line: ");
        int r0 = this.f12133d;
        if (r0 < 0) goto L7;
        r7.append(r0);
    L8:
        r7.append(", column: ");
        int r6 = this.f12134e;
        if (r6 < 0) goto L11;
        r7.append(r6);
    L21:
        return r7;
    L11:
        r7.append("UNKNOWN");
        goto L21
    L7:
        r7.append("UNKNOWN");
        goto L8
    L13:
        if (this.f12133d <= 0) goto L17;
        r7.append("line: ").append(this.f12133d);
        if (this.f12134e <= 0) goto L21;
        r7.append(", column: ");
        r7.append(this.f12134e);
        goto L21
    L17:
        r7.append("byte offset: #");
        long r1 = this.f12131b;
        if (r1 < 0) goto L20;
        r7.append(r1);
        goto L21
    L20:
        r7.append("UNKNOWN");
        goto L21
    }

    public int hashCode() {
        if (this.f != null) goto L5;
        int r0 = 1;
    L7:
        return (((r0 ^ this.f12133d) + this.f12134e) ^ ((int) this.f12132c)) + ((int) this.f12131b);
    L5:
        r0 = 2;
        goto L7
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if (r8 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r8, i.class) == true) goto L11;
        return false;
    L11:
        i r9 = (i) ZeusTransformUtils.preCheckCast(r8, i.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.a.d.d r0 = this.f;
        if (r0 != null) goto L17;
        if (r9.f == null) goto L20;
        return false;
    L20:
        if (this.f12133d != r9.f12133d) goto L29;
        if (this.f12134e != r9.f12134e) goto L29;
        if (this.f12132c != r9.f12132c) goto L29;
        if (this.f12131b != r9.f12131b) goto L29;
        return true;
    L29:
        return false;
    L17:
        if (r0.equals(r9.f) == true) goto L20;
        return false;
    }

    public String toString() {
        String r0 = a();
        return a(new StringBuilder(r0.length() + 40).append("[Source: ").append(r0).append("; ")).append(']').toString();
    }
}
