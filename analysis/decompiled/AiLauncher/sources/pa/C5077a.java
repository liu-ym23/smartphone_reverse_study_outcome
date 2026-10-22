package pa;

import E9.InterfaceC0797b;
import H9.K;
import V9.k;
import Z8.A;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.g;

/* renamed from: pa.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5077a implements InterfaceC5081e {

    /* renamed from: b, reason: collision with root package name */
    public final List<InterfaceC5081e> f38250b;

    /* JADX WARN: Multi-variable type inference failed */
    public C5077a(List<? extends InterfaceC5081e> inner) {
        p.i(inner, "inner");
        this.f38250b = inner;
    }

    @Override // pa.InterfaceC5081e
    public void a(InterfaceC0797b thisDescriptor, ga.e name, Collection<g> result, k c10) {
        p.i(thisDescriptor, "thisDescriptor");
        p.i(name, "name");
        p.i(result, "result");
        p.i(c10, "c");
        Iterator<T> it = this.f38250b.iterator();
        while (it.hasNext()) {
            ((InterfaceC5081e) it.next()).a(thisDescriptor, name, result, c10);
        }
    }

    @Override // pa.InterfaceC5081e
    public K b(InterfaceC0797b thisDescriptor, K propertyDescriptor, k c10) {
        p.i(thisDescriptor, "thisDescriptor");
        p.i(propertyDescriptor, "propertyDescriptor");
        p.i(c10, "c");
        Iterator<T> it = this.f38250b.iterator();
        while (it.hasNext()) {
            propertyDescriptor = ((InterfaceC5081e) it.next()).b(thisDescriptor, propertyDescriptor, c10);
        }
        return propertyDescriptor;
    }

    @Override // pa.InterfaceC5081e
    public List<ga.e> c(InterfaceC0797b thisDescriptor, k c10) {
        p.i(thisDescriptor, "thisDescriptor");
        p.i(c10, "c");
        List<InterfaceC5081e> list = this.f38250b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            A.E(arrayList, ((InterfaceC5081e) it.next()).c(thisDescriptor, c10));
        }
        return arrayList;
    }

    @Override // pa.InterfaceC5081e
    public void d(InterfaceC0797b thisDescriptor, ga.e name, Collection<g> result, k c10) {
        p.i(thisDescriptor, "thisDescriptor");
        p.i(name, "name");
        p.i(result, "result");
        p.i(c10, "c");
        Iterator<T> it = this.f38250b.iterator();
        while (it.hasNext()) {
            ((InterfaceC5081e) it.next()).d(thisDescriptor, name, result, c10);
        }
    }

    @Override // pa.InterfaceC5081e
    public List<ga.e> e(InterfaceC0797b thisDescriptor, k c10) {
        p.i(thisDescriptor, "thisDescriptor");
        p.i(c10, "c");
        List<InterfaceC5081e> list = this.f38250b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            A.E(arrayList, ((InterfaceC5081e) it.next()).e(thisDescriptor, c10));
        }
        return arrayList;
    }

    @Override // pa.InterfaceC5081e
    public void f(InterfaceC0797b thisDescriptor, List<kotlin.reflect.jvm.internal.impl.descriptors.b> result, k c10) {
        p.i(thisDescriptor, "thisDescriptor");
        p.i(result, "result");
        p.i(c10, "c");
        Iterator<T> it = this.f38250b.iterator();
        while (it.hasNext()) {
            ((InterfaceC5081e) it.next()).f(thisDescriptor, result, c10);
        }
    }

    @Override // pa.InterfaceC5081e
    public List<ga.e> g(InterfaceC0797b thisDescriptor, k c10) {
        p.i(thisDescriptor, "thisDescriptor");
        p.i(c10, "c");
        List<InterfaceC5081e> list = this.f38250b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            A.E(arrayList, ((InterfaceC5081e) it.next()).g(thisDescriptor, c10));
        }
        return arrayList;
    }

    @Override // pa.InterfaceC5081e
    public void h(InterfaceC0797b thisDescriptor, ga.e name, List<InterfaceC0797b> result, k c10) {
        p.i(thisDescriptor, "thisDescriptor");
        p.i(name, "name");
        p.i(result, "result");
        p.i(c10, "c");
        Iterator<T> it = this.f38250b.iterator();
        while (it.hasNext()) {
            ((InterfaceC5081e) it.next()).h(thisDescriptor, name, result, c10);
        }
    }
}
