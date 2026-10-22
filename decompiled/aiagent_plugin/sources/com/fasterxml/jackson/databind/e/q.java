package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: AnnotationMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements com.fasterxml.jackson.databind.l.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected HashMap<Class<?>, Annotation> f12658a;

    public q() {
    }

    public static q a(Class<?> r2, Annotation r3) {
        Annotation r4 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r3, Annotation.class, "com.obric.aiagent.plugin");
        HashMap r0 = new HashMap(4);
        r0.put(r2, r4);
        return new q(r0);
    }

    q(HashMap<Class<?>, Annotation> r1) {
        this.f12658a = r1;
    }

    @Override // com.fasterxml.jackson.databind.l.b
    public <A extends Annotation> A a(Class<A> r2) {
        HashMap<Class<?>, Annotation> r1 = this.f12658a;
        if (r1 != null) goto L7;
        return null;
    L7:
        return (A) ZeusTransformUtils.preCheckCast(r1.get(r2), Annotation.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.l.b
    public boolean b(Class<?> r1) {
        HashMap<Class<?>, Annotation> r0 = this.f12658a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.containsKey(r1);
    }

    @Override // com.fasterxml.jackson.databind.l.b
    public boolean a(Class<? extends Annotation>[] r6) {
        if (this.f12658a == null) goto L11;
        int r0 = r6.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L11;
        if (this.f12658a.containsKey(r6[r2]) == true) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public static q a(q r4, q r5) {
        if (r4 == null) goto L24;
        HashMap<Class<?>, Annotation> r0 = r4.f12658a;
        if (r0 == null) goto L24;
        if (r0.isEmpty() == true) goto L24;
        if (r5 == null) goto L27;
        HashMap<Class<?>, Annotation> r1 = r5.f12658a;
        if (r1 != null) goto L12;
        return r4;
    L12:
        if (r1.isEmpty() == true) goto L29;
        HashMap r2 = new HashMap();
        Iterator<Annotation> r6 = r5.f12658a.values().iterator();
    L16:
        if (r6.hasNext() == false) goto L18;
        Annotation r3 = (Annotation) ZeusTransformUtils.preCheckCast(r6.next(), Annotation.class, "com.obric.aiagent.plugin");
        r2.put(r3.annotationType(), r3);
        goto L16
    L18:
        Iterator<Annotation> r7 = r4.f12658a.values().iterator();
    L20:
        if (r7.hasNext() == false) goto L23;
        Annotation r8 = (Annotation) ZeusTransformUtils.preCheckCast(r7.next(), Annotation.class, "com.obric.aiagent.plugin");
        r2.put(r8.annotationType(), r8);
        goto L20
    L23:
        return new q(r2);
    L29:
        return r4;
    L27:
        return r4;
    L24:
        return r5;
    }

    @Override // com.fasterxml.jackson.databind.l.b
    public int a() {
        HashMap<Class<?>, Annotation> r0 = this.f12658a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    public boolean a(Annotation r3) {
        return b((Annotation) ZeusTransformUtils.wrapperContextForParams(r3, Annotation.class, "com.obric.aiagent.plugin"));
    }

    public String toString() {
        HashMap<Class<?>, Annotation> r0 = this.f12658a;
        if (r0 != null) goto L7;
        return "[null]";
    L7:
        return r0.toString();
    }

    public final boolean b(Annotation r3) {
        Annotation r4 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r3, Annotation.class, "com.obric.aiagent.plugin");
        if (this.f12658a != null) goto L5;
        this.f12658a = new HashMap();
    L5:
        Annotation r2 = (Annotation) ZeusTransformUtils.preCheckCast(this.f12658a.put(r4.annotationType(), r4), Annotation.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L8;
    L11:
        return true;
    L8:
        if (r2.equals(r4) == false) goto L11;
        return false;
    }
}
