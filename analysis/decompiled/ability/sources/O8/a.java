package O8;

import D7.A;
import G8.f;
import h8.InterfaceC1522e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k8.H;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class a implements d {
    public final List b;

    public a(List inner) {
        k.f(inner, "inner");
        this.b = inner;
    }

    public final void a(InterfaceC1522e thisDescriptor, ArrayList arrayList, K1.a c) {
        k.f(thisDescriptor, "thisDescriptor");
        k.f(c, "c");
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((a) ((d) it.next())).a(thisDescriptor, arrayList, c);
        }
    }

    public final void b(InterfaceC1522e thisDescriptor, f name, ArrayList arrayList, K1.a c) {
        k.f(thisDescriptor, "thisDescriptor");
        k.f(name, "name");
        k.f(c, "c");
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((a) ((d) it.next())).b(thisDescriptor, name, arrayList, c);
        }
    }

    public final void c(InterfaceC1522e thisDescriptor, f name, ListBuilder listBuilder, K1.a c) {
        k.f(thisDescriptor, "thisDescriptor");
        k.f(name, "name");
        k.f(c, "c");
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((a) ((d) it.next())).c(thisDescriptor, name, listBuilder, c);
        }
    }

    public final void d(InterfaceC1522e thisDescriptor, f name, ArrayList arrayList, K1.a c) {
        k.f(thisDescriptor, "thisDescriptor");
        k.f(name, "name");
        k.f(c, "c");
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((a) ((d) it.next())).d(thisDescriptor, name, arrayList, c);
        }
    }

    public final ArrayList e(InterfaceC1522e thisDescriptor, K1.a c) {
        k.f(thisDescriptor, "thisDescriptor");
        k.f(c, "c");
        List list = this.b;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            A.e0(((a) ((d) it.next())).e(thisDescriptor, c), arrayList);
        }
        return arrayList;
    }

    public final ArrayList f(InterfaceC1522e thisDescriptor, K1.a c) {
        k.f(thisDescriptor, "thisDescriptor");
        k.f(c, "c");
        List list = this.b;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            A.e0(((a) ((d) it.next())).f(thisDescriptor, c), arrayList);
        }
        return arrayList;
    }

    public final ArrayList g(InterfaceC1522e thisDescriptor, K1.a c) {
        k.f(thisDescriptor, "thisDescriptor");
        k.f(c, "c");
        List list = this.b;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            A.e0(((a) ((d) it.next())).g(thisDescriptor, c), arrayList);
        }
        return arrayList;
    }

    public final H h(InterfaceC1522e interfaceC1522e, H propertyDescriptor, K1.a c) {
        k.f(propertyDescriptor, "propertyDescriptor");
        k.f(c, "c");
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            propertyDescriptor = ((a) ((d) it.next())).h(interfaceC1522e, propertyDescriptor, c);
        }
        return propertyDescriptor;
    }
}
