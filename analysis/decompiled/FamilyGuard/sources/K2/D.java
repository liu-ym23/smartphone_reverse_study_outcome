package K2;

import V3.n;
import W3.C0403n;
import android.view.View;
import i4.InterfaceC0761a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3596a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<View> f3597b;

    /* renamed from: c, reason: collision with root package name */
    private List<a> f3598c;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f3599a;

        /* renamed from: b, reason: collision with root package name */
        private final s f3600b;

        public a(String str, s sVar) {
            j4.k.g(str, "capabilityId");
            j4.k.g(sVar, "binding");
            this.f3599a = str;
            this.f3600b = sVar;
        }

        public final s a() {
            return this.f3600b;
        }

        public final String b() {
            return this.f3599a;
        }
    }

    public D(View view, boolean z5, List<a> list) {
        j4.k.g(view, "view");
        j4.k.g(list, "entries");
        this.f3596a = z5;
        this.f3597b = new WeakReference<>(view);
        this.f3598c = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v e(D d6) {
        d6.f();
        return V3.v.f5542a;
    }

    private final void f() {
        for (a aVar : this.f3598c) {
            try {
                n.a aVar2 = V3.n.f5531a;
                aVar.a().a();
                V3.n.a(V3.v.f5542a);
            } catch (Throwable th) {
                n.a aVar3 = V3.n.f5531a;
                V3.n.a(V3.o.a(th));
            }
        }
    }

    public final int b() {
        return this.f3598c.size();
    }

    public final List<String> c() {
        List<a> list = this.f3598c;
        ArrayList arrayList = new ArrayList(C0403n.r(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((a) it.next()).b());
        }
        return arrayList;
    }

    public final void d() {
        if (this.f3598c.isEmpty()) {
            return;
        }
        if (this.f3596a) {
            f();
        } else {
            L2.j.f3840a.o(new InterfaceC0761a() { // from class: K2.C
                @Override // i4.InterfaceC0761a
                public final Object invoke() {
                    return D.e(this.f3595a);
                }
            });
        }
        this.f3598c = C0403n.h();
    }
}
