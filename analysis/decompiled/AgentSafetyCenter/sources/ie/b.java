package ie;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class b extends k {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5977a;

    @Override // ie.k
    public final l a(Type type) {
        if (ad.c0.class.isAssignableFrom(w0.h(type))) {
            return a.f5969h;
        }
        return null;
    }

    @Override // ie.k
    public final l b(Type type, Annotation[] annotationArr, q0 q0Var) {
        if (type == ad.h0.class) {
            return w0.k(annotationArr, ke.w.class) ? a.i : a.f5968g;
        }
        if (type == Void.class) {
            return a.f5971k;
        }
        if (!this.f5977a || type != jb.v.class) {
            return null;
        }
        try {
            return a.f5970j;
        } catch (NoClassDefFoundError unused) {
            this.f5977a = false;
            return null;
        }
    }
}
