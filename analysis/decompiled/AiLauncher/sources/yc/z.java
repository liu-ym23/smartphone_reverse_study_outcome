package yc;

import java.lang.annotation.Annotation;

/* loaded from: classes5.dex */
public final class z implements y {

    /* renamed from: a, reason: collision with root package name */
    public static final y f44491a = new z();

    public static Annotation[] a(Annotation[] annotationArr) {
        if (A.l(annotationArr, y.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[annotationArr.length + 1];
        annotationArr2[0] = f44491a;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return y.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof y;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + y.class.getName() + "()";
    }
}
