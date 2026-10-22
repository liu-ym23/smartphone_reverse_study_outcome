package com.fasterxml.jackson.a.d;

import com.fasterxml.jackson.a.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: SerializedString.java */
/* JADX INFO: loaded from: classes2.dex */
public class m implements q, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final h f12017c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f12018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected char[] f12019b;

    static {
        f12017c = h.a();
    }

    public m(String r1) {
        if (r1 == null) goto L7;
        this.f12018a = r1;
        return;
    L7:
        throw new IllegalStateException("Null String illegal for SerializedString");
    }

    @Override // com.fasterxml.jackson.a.q
    public final String a() {
        return this.f12018a;
    }

    @Override // com.fasterxml.jackson.a.q
    public final char[] b() {
        char[] r0 = this.f12019b;
        if (r0 != null) goto L6;
        char[] r1 = f12017c.a(this.f12018a);
        this.f12019b = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.fasterxml.jackson.a.q
    public int a(char[] r4, int r5) {
        char[] r0 = this.f12019b;
        if (r0 != null) goto L5;
        r0 = f12017c.a(this.f12018a);
        this.f12019b = r0;
    L5:
        int r3 = r0.length;
        if ((r5 + r3) <= r4.length) goto L9;
        return -1;
    L9:
        System.arraycopy(r0, 0, r4, r5, r3);
        return r3;
    }

    @Override // com.fasterxml.jackson.a.q
    public int b(char[] r4, int r5) {
        String r3 = this.f12018a;
        int r0 = r3.length();
        if ((r5 + r0) <= r4.length) goto L6;
        return -1;
    L6:
        r3.getChars(0, r0, r4, r5);
        return r0;
    }

    public final String toString() {
        return this.f12018a;
    }

    public final int hashCode() {
        return this.f12018a.hashCode();
    }

    public final boolean equals(Object r3) {
        if (r3 != this) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (r3.getClass() != getClass()) goto L13;
        m r4 = (m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin");
        return this.f12018a.equals(r4.f12018a);
    L13:
        return false;
    }
}
