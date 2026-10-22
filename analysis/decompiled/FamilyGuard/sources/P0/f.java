package P0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final List<a<?, ?>> f4539a = new ArrayList();

    private static final class a<Z, R> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<Z> f4540a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<R> f4541b;

        /* renamed from: c, reason: collision with root package name */
        final e<Z, R> f4542c;

        a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.f4540a = cls;
            this.f4541b = cls2;
            this.f4542c = eVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f4540a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f4541b);
        }
    }

    public synchronized <Z, R> e<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.b();
        }
        for (a<?, ?> aVar : this.f4539a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f4542c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator<a<?, ?>> it = this.f4539a.iterator();
        while (it.hasNext()) {
            if (it.next().a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.f4539a.add(new a<>(cls, cls2, eVar));
    }
}
