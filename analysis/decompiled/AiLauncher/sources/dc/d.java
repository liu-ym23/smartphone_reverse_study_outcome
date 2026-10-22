package dc;

import Yb.u;
import cc.InterfaceC1510a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f32166a;

    /* renamed from: b, reason: collision with root package name */
    public final List<dc.c> f32167b;

    public class a implements dc.c {
        public a() {
        }

        @Override // dc.c
        public InterfaceC1510a a(InterfaceC3968b interfaceC3968b) {
            return new C3967a(interfaceC3968b);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f32169a = false;

        /* renamed from: b, reason: collision with root package name */
        public List<dc.c> f32170b = new ArrayList();

        public d c() {
            return new d(this, null);
        }

        public b d(Iterable<? extends Ob.a> iterable) {
            for (Ob.a aVar : iterable) {
                if (aVar instanceof InterfaceC0390d) {
                    ((InterfaceC0390d) aVar).a(this);
                }
            }
            return this;
        }

        public b e(dc.c cVar) {
            this.f32170b.add(cVar);
            return this;
        }

        public b f(boolean z10) {
            this.f32169a = z10;
            return this;
        }
    }

    public class c implements InterfaceC3968b {

        /* renamed from: a, reason: collision with root package name */
        public final e f32171a;

        /* renamed from: b, reason: collision with root package name */
        public final Vb.a f32172b;

        public /* synthetic */ c(d dVar, e eVar, a aVar) {
            this(eVar);
        }

        @Override // dc.InterfaceC3968b
        public void a(u uVar) {
            this.f32172b.b(uVar);
        }

        @Override // dc.InterfaceC3968b
        public boolean b() {
            return d.this.f32166a;
        }

        @Override // dc.InterfaceC3968b
        public e c() {
            return this.f32171a;
        }

        public c(e eVar) {
            this.f32172b = new Vb.a();
            this.f32171a = eVar;
            for (int size = d.this.f32167b.size() - 1; size >= 0; size--) {
                this.f32172b.a(((dc.c) d.this.f32167b.get(size)).a(this));
            }
        }
    }

    /* renamed from: dc.d$d, reason: collision with other inner class name */
    public interface InterfaceC0390d extends Ob.a {
        void a(b bVar);
    }

    public /* synthetic */ d(b bVar, a aVar) {
        this(bVar);
    }

    public static b c() {
        return new b();
    }

    public String d(u uVar) {
        StringBuilder sb2 = new StringBuilder();
        e(uVar, sb2);
        return sb2.toString();
    }

    public void e(u uVar, Appendable appendable) {
        new c(this, new e(appendable), null).a(uVar);
    }

    public d(b bVar) {
        this.f32166a = bVar.f32169a;
        ArrayList arrayList = new ArrayList(bVar.f32170b.size() + 1);
        this.f32167b = arrayList;
        arrayList.addAll(bVar.f32170b);
        arrayList.add(new a());
    }
}
