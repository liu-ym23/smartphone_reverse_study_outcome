package q4;

import W3.C0403n;
import i4.InterfaceC0772l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k4.InterfaceC0814a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends i {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterable<T>, InterfaceC0814a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0988b f19946a;

        public a(InterfaceC0988b interfaceC0988b) {
            this.f19946a = interfaceC0988b;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f19946a.iterator();
        }
    }

    public static <T> Iterable<T> e(InterfaceC0988b<? extends T> interfaceC0988b) {
        j4.k.g(interfaceC0988b, "<this>");
        return new a(interfaceC0988b);
    }

    public static <T, R> InterfaceC0988b<R> f(InterfaceC0988b<? extends T> interfaceC0988b, InterfaceC0772l<? super T, ? extends R> interfaceC0772l) {
        j4.k.g(interfaceC0988b, "<this>");
        j4.k.g(interfaceC0772l, "transform");
        return new k(interfaceC0988b, interfaceC0772l);
    }

    public static <T> List<T> g(InterfaceC0988b<? extends T> interfaceC0988b) {
        j4.k.g(interfaceC0988b, "<this>");
        Iterator<? extends T> it = interfaceC0988b.iterator();
        if (!it.hasNext()) {
            return C0403n.h();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return C0403n.b(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
