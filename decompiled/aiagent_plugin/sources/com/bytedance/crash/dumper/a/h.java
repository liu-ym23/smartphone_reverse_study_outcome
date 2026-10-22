package com.bytedance.crash.dumper.a;

/* JADX INFO: compiled from: StackBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f7393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f7394b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f7395c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f7396d;

    static {
        f7393a = new char[]{'(', 'N', 'a', 't', 'i', 'v', 'e', ' ', 'M', 'e', 't', 'h', 'o', 'd', ')'};
        f7394b = new char[]{'(', 'U', 'n', 'k', 'n', 'o', 'w', 'n', ' ', 'S', 'o', 'u', 'r', 'c', 'e', ')'};
        f7395c = new char[]{'(', 'U', 'n', 'k', 'n', 'o', 'w', 'n', ' ', 'S', 'o', 'u', 'r', 'c', 'e', ':'};
    }

    h(i r1) {
        this.f7396d = r1;
    }

    h a(int r2) {
        this.f7396d.b(r2);
        return this;
    }

    h a(String r2) {
        if (r2.length() == 0) goto L5;
        this.f7396d.c(r2);
    L5:
        return this;
    }

    h a(char r2) {
        this.f7396d.a(r2);
        return this;
    }

    h a(char[] r2) {
        if (r2.length == 0) goto L5;
        this.f7396d.a(r2);
    L5:
        return this;
    }

    h a(Throwable r2) {
        this.f7396d.a(r2);
        return this;
    }

    h a(StackTraceElement r7) {
        String r0 = r7.getClassName();
        String r1 = r7.getMethodName();
        String r2 = r7.getFileName();
        int r3 = r7.getLineNumber();
        boolean r4 = r7.isNativeMethod();
        a(r0).a('.').a(r1);
        if (r4 == false) goto L6;
        a(f7393a);
    L14:
        return this;
    L6:
        if (r2 != null) goto L8;
        if (r3 < 0) goto L13;
        a(f7395c).a(r3).a(')');
        goto L14
    L13:
        a(f7394b);
        goto L14
    L8:
        if (r7.getLineNumber() < 0) goto L10;
        a('(').a(r2).a(':').a(r3).a(')');
        goto L14
    L10:
        a('(').a(r2).a(')');
        goto L14
    }

    h b(int r4) {
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L5;
        this.f7396d.a('\t');
        r0 = r0 + 1;
        goto L3
    L5:
        return this;
    }
}
