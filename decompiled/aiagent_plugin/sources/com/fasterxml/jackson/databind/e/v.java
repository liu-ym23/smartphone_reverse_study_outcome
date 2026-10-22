package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: CollectorBase.java */
/* JADX INFO: loaded from: classes2.dex */
class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final q[] f12669a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Annotation[] f12670b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b f12671c;

    static {
        f12669a = new q[0];
        f12670b = new Annotation[0];
    }

    public v(com.fasterxml.jackson.databind.b r1) {
        this.f12671c = r1;
    }

    public final p a(Annotation[] r6) {
        p r0 = p.b();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        Annotation r3 = r6[r2];
        r0 = r0.b(r3);
        if (this.f12671c.a(r3) == false) goto L7;
        r0 = a(r0, r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    public final p a(p r5, Annotation[] r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Annotation r2 = r6[r1];
        r5 = r5.b(r2);
        if (this.f12671c.a(r2) == false) goto L7;
        r5 = a(r5, r2);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r5;
    }

    public final p a(p r5, Annotation r6) {
        Annotation[] r7 = com.fasterxml.jackson.databind.l.h.r(((Annotation) ZeusTransformUtils.wrapperContextForParams(r6, Annotation.class, "com.obric.aiagent.plugin")).annotationType());
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        Annotation r2 = r7[r1];
        if (a(r2) == true) goto L13;
        if (this.f12671c.a(r2) == true) goto L10;
        r5 = r5.b(r2);
        goto L13
    L10:
        if (r5.a(r2) == true) goto L13;
        r5 = a(r5.b(r2), r2);
    L13:
        r1 = r1 + 1;
        goto L3
    L14:
        return r5;
    }

    public final p b(p r5, Annotation[] r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        Annotation r2 = r6[r1];
        if (r5.a(r2) == true) goto L9;
        r5 = r5.b(r2);
        if (this.f12671c.a(r2) == false) goto L9;
        r5 = b(r5, r2);
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return r5;
    }

    public final p b(p r5, Annotation r6) {
        Annotation[] r7 = com.fasterxml.jackson.databind.l.h.r(((Annotation) ZeusTransformUtils.wrapperContextForParams(r6, Annotation.class, "com.obric.aiagent.plugin")).annotationType());
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        Annotation r2 = r7[r1];
        if (a(r2) == true) goto L12;
        if (r5.a(r2) == true) goto L12;
        r5 = r5.b(r2);
        if (this.f12671c.a(r2) == false) goto L12;
        r5 = a(r5, r2);
    L12:
        r1 = r1 + 1;
        goto L3
    L13:
        return r5;
    }

    public static final boolean a(Annotation r2) {
        Annotation r3 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r2, Annotation.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Target.class) == false) goto L5;
    L8:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, Retention.class) == true) goto L8;
        return false;
    }

    static q a() {
        return new q();
    }

    static q[] a(int r3) {
        if (r3 == 0) goto L4;
        q[] r0 = new q[r3];
        int r1 = 0;
    L6:
        if (r1 >= r3) goto L8;
        r0[r1] = a();
        r1 = r1 + 1;
        goto L6
    L8:
        return r0;
    L4:
        return f12669a;
    }
}
