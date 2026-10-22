package H0;

import java.util.Collections;
import java.util.List;
import z0.C1342h;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
public interface n<Model, Data> {

    public static class a<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1340f f2003a;

        /* renamed from: b, reason: collision with root package name */
        public final List<InterfaceC1340f> f2004b;

        /* renamed from: c, reason: collision with root package name */
        public final A0.d<Data> f2005c;

        public a(InterfaceC1340f interfaceC1340f, A0.d<Data> dVar) {
            this(interfaceC1340f, Collections.EMPTY_LIST, dVar);
        }

        public a(InterfaceC1340f interfaceC1340f, List<InterfaceC1340f> list, A0.d<Data> dVar) {
            this.f2003a = (InterfaceC1340f) X0.j.d(interfaceC1340f);
            this.f2004b = (List) X0.j.d(list);
            this.f2005c = (A0.d) X0.j.d(dVar);
        }
    }

    boolean a(Model model);

    a<Data> b(Model model, int i5, int i6, C1342h c1342h);
}
