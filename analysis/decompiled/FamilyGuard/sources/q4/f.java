package q4;

import V3.v;
import a4.C0428b;
import i4.p;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements InterfaceC0988b<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f19944a;

        public a(p pVar) {
            this.f19944a = pVar;
        }

        @Override // q4.InterfaceC0988b
        public Iterator<T> iterator() {
            return f.a(this.f19944a);
        }
    }

    public static final <T> Iterator<T> a(p<? super d<? super T>, ? super Z3.e<? super v>, ? extends Object> pVar) {
        j4.k.g(pVar, "block");
        C0989c c0989c = new C0989c();
        c0989c.l(C0428b.a(pVar, c0989c, c0989c));
        return c0989c;
    }

    public static <T> InterfaceC0988b<T> b(p<? super d<? super T>, ? super Z3.e<? super v>, ? extends Object> pVar) {
        j4.k.g(pVar, "block");
        return new a(pVar);
    }
}
