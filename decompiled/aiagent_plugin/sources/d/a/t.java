package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: compiled from: IteratorsJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
class t extends s {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: IteratorsJVM.kt */
    public static final class a<T> implements d.h.b.a.a, Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Enumeration<T> f38389a;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(Enumeration<T> r3) {
            this.f38389a = (Enumeration) ZeusTransformUtils.wrapperContextForParams(r3, Enumeration.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38389a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f38389a.nextElement();
        }
    }

    public static final <T> Iterator<T> a(Enumeration<T> r2) {
        Enumeration r3 = (Enumeration) ZeusTransformUtils.wrapperContextForParams(r2, Enumeration.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return (Iterator) ZeusTransformUtils.preCheckCast(new a(r3), Iterator.class, "com.obric.aiagent.plugin");
    }
}
