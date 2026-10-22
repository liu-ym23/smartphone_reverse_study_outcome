package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: SkipCallbackExecutorImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class ai implements ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ah f9452a = null;

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    ai() {
    }

    static {
        f9452a = new ai();
    }

    static Annotation[] a(Annotation[] r4) {
        if (an.a(r4, ah.class) == false) goto L5;
        return r4;
    L5:
        Annotation[] r0 = new Annotation[r4.length + 1];
        r0[0] = f9452a;
        System.arraycopy(r4, 0, r0, 1, r4.length);
        return r0;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return ah.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, ah.class);
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + ah.class.getName() + "()";
    }
}
