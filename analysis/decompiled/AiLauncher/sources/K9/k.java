package K9;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import o9.C5013a;

/* loaded from: classes5.dex */
public final class k {
    public static final C0926g a(Annotation[] annotationArr, ga.c fqName) {
        Annotation annotation;
        kotlin.jvm.internal.p.i(annotationArr, "<this>");
        kotlin.jvm.internal.p.i(fqName, "fqName");
        int length = annotationArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i10];
            if (kotlin.jvm.internal.p.d(C0925f.e(C5013a.b(C5013a.a(annotation))).a(), fqName)) {
                break;
            }
            i10++;
        }
        if (annotation != null) {
            return new C0926g(annotation);
        }
        return null;
    }

    public static final List<C0926g> b(Annotation[] annotationArr) {
        kotlin.jvm.internal.p.i(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new C0926g(annotation));
        }
        return arrayList;
    }
}
