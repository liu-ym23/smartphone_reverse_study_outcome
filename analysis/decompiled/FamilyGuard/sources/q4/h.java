package q4;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends g {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements InterfaceC0988b<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f19945a;

        public a(Iterator it) {
            this.f19945a = it;
        }

        @Override // q4.InterfaceC0988b
        public Iterator<T> iterator() {
            return this.f19945a;
        }
    }

    public static <T> InterfaceC0988b<T> c(Iterator<? extends T> it) {
        j4.k.g(it, "<this>");
        return d(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> InterfaceC0988b<T> d(InterfaceC0988b<? extends T> interfaceC0988b) {
        j4.k.g(interfaceC0988b, "<this>");
        return interfaceC0988b instanceof C0987a ? interfaceC0988b : new C0987a(interfaceC0988b);
    }
}
