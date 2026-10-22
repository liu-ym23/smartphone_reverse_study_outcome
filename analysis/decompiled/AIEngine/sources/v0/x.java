package v0;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class x<T> implements Iterator<T>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13339a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public Iterator<? extends T> f13340b;

    public x(kotlin.jvm.internal.a aVar) {
        this.f13340b = aVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13340b.hasNext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    public final T next() {
        T next = this.f13340b.next();
        View view = (View) next;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        kotlin.jvm.internal.a aVar = viewGroup != null ? new kotlin.jvm.internal.a(viewGroup) : null;
        ArrayList arrayList = this.f13339a;
        if (aVar != null && aVar.hasNext()) {
            arrayList.add(this.f13340b);
            this.f13340b = aVar;
            return next;
        }
        while (!this.f13340b.hasNext() && !arrayList.isEmpty()) {
            this.f13340b = (Iterator) kotlin.collections.a.A0(arrayList);
            mb.q.j0(arrayList);
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
