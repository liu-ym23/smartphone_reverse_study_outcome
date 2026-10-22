package J9;

import E9.W;
import E9.X;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class b implements W {

    /* renamed from: b, reason: collision with root package name */
    public final Annotation f3790b;

    public b(Annotation annotation) {
        p.i(annotation, "annotation");
        this.f3790b = annotation;
    }

    @Override // E9.W
    public X b() {
        X NO_SOURCE_FILE = X.f2445a;
        p.h(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    public final Annotation d() {
        return this.f3790b;
    }
}
