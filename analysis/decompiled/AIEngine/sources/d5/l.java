package d5;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l extends o implements Iterable<o> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<o> f8381a = new ArrayList<>();

    @Override // d5.o
    public final boolean a() {
        return g().a();
    }

    @Override // d5.o
    public final int b() {
        return g().b();
    }

    @Override // d5.o
    public final long e() {
        return g().e();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof l) && ((l) obj).f8381a.equals(this.f8381a);
        }
        return true;
    }

    @Override // d5.o
    public final String f() {
        return g().f();
    }

    public final o g() {
        ArrayList<o> arrayList = this.f8381a;
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        throw new IllegalStateException(ai.onnxruntime.providers.a.a(size, "Array must have size 1, but has size "));
    }

    public final int hashCode() {
        return this.f8381a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator<o> iterator() {
        return this.f8381a.iterator();
    }
}
