package K;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;

/* renamed from: K.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0093z implements Iterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final Function1 f1019a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1020b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public Iterator f1021c;

    public C0093z(Iterator it, Y y4) {
        this.f1019a = y4;
        this.f1021c = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1021c.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object next = this.f1021c.next();
        Iterator it = (Iterator) this.f1019a.invoke(next);
        ArrayList arrayList = this.f1020b;
        if (it == null || !it.hasNext()) {
            while (!this.f1021c.hasNext() && (!arrayList.isEmpty())) {
                this.f1021c = (Iterator) CollectionsKt.last((List) arrayList);
                CollectionsKt.removeLast(arrayList);
            }
        } else {
            arrayList.add(this.f1021c);
            this.f1021c = it;
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
