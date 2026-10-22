package ka;

import E9.E;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.a0;
import Z8.C1173v;
import Z8.F;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ra.C5231d;
import ra.InterfaceC5238k;
import ra.InterfaceC5241n;

/* renamed from: ka.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4821a extends AbstractC4838r {

    /* renamed from: a, reason: collision with root package name */
    public static final C4821a f34643a = new C4821a();

    /* renamed from: ka.a$a, reason: collision with other inner class name */
    public static final class C0429a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(DescriptorUtilsKt.o((InterfaceC0797b) t10).a(), DescriptorUtilsKt.o((InterfaceC0797b) t11).a());
        }
    }

    public static final void b(InterfaceC0797b interfaceC0797b, LinkedHashSet<InterfaceC0797b> linkedHashSet, InterfaceC5238k interfaceC5238k, boolean z10) {
        for (InterfaceC0803h interfaceC0803h : InterfaceC5241n.a.a(interfaceC5238k, C5231d.f38874t, null, 2, null)) {
            if (interfaceC0803h instanceof InterfaceC0797b) {
                InterfaceC0797b interfaceC0797bR = (InterfaceC0797b) interfaceC0803h;
                if (interfaceC0797bR.e0()) {
                    ga.e name = interfaceC0797bR.getName();
                    kotlin.jvm.internal.p.h(name, "getName(...)");
                    InterfaceC0799d interfaceC0799dD = interfaceC5238k.d(name, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
                    interfaceC0797bR = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : interfaceC0799dD instanceof a0 ? ((a0) interfaceC0799dD).r() : null;
                }
                if (interfaceC0797bR != null) {
                    if (C4828h.z(interfaceC0797bR, interfaceC0797b)) {
                        linkedHashSet.add(interfaceC0797bR);
                    }
                    if (z10) {
                        InterfaceC5238k interfaceC5238kO = interfaceC0797bR.O();
                        kotlin.jvm.internal.p.h(interfaceC5238kO, "getUnsubstitutedInnerClassesScope(...)");
                        b(interfaceC0797b, linkedHashSet, interfaceC5238kO, z10);
                    }
                }
            }
        }
    }

    public Collection<InterfaceC0797b> a(InterfaceC0797b sealedClass, boolean z10) {
        InterfaceC0803h next;
        InterfaceC0803h interfaceC0803hB;
        kotlin.jvm.internal.p.i(sealedClass, "sealedClass");
        if (sealedClass.p() != Modality.SEALED) {
            return C1173v.m();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z10) {
            Iterator<InterfaceC0803h> it = DescriptorUtilsKt.u(sealedClass).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next instanceof E) {
                    break;
                }
            }
            interfaceC0803hB = next;
        } else {
            interfaceC0803hB = sealedClass.b();
        }
        if (interfaceC0803hB instanceof E) {
            b(sealedClass, linkedHashSet, ((E) interfaceC0803hB).m(), z10);
        }
        InterfaceC5238k interfaceC5238kO = sealedClass.O();
        kotlin.jvm.internal.p.h(interfaceC5238kO, "getUnsubstitutedInnerClassesScope(...)");
        b(sealedClass, linkedHashSet, interfaceC5238kO, true);
        return F.c1(linkedHashSet, new C0429a());
    }
}
