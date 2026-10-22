package fc;

import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b<T, K> extends mb.b<T> {

    /* renamed from: c, reason: collision with root package name */
    public final Iterator<T> f8792c;

    /* renamed from: d, reason: collision with root package name */
    public final zb.l<T, K> f8793d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet<K> f8794e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Iterator<? extends T> source, zb.l<? super T, ? extends K> lVar) {
        kotlin.jvm.internal.g.f(source, "source");
        this.f8792c = source;
        this.f8793d = lVar;
        this.f8794e = new HashSet<>();
    }

    @Override // mb.b
    public final void a() {
        T next;
        do {
            Iterator<T> it = this.f8792c;
            if (!it.hasNext()) {
                this.f10545a = 2;
                return;
            } else {
                next = it.next();
            }
        } while (!this.f8794e.add(this.f8793d.invoke(next)));
        this.f10546b = next;
        this.f10545a = 1;
    }
}
