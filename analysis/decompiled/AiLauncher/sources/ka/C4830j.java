package ka;

import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.O;
import E9.a0;
import java.util.Comparator;

/* renamed from: ka.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4830j implements Comparator<InterfaceC0803h> {

    /* renamed from: a, reason: collision with root package name */
    public static final C4830j f34656a = new C4830j();

    public static Integer b(InterfaceC0803h interfaceC0803h, InterfaceC0803h interfaceC0803h2) {
        int iC = c(interfaceC0803h2) - c(interfaceC0803h);
        if (iC != 0) {
            return Integer.valueOf(iC);
        }
        if (C4828h.B(interfaceC0803h) && C4828h.B(interfaceC0803h2)) {
            return 0;
        }
        int iCompareTo = interfaceC0803h.getName().compareTo(interfaceC0803h2.getName());
        if (iCompareTo != 0) {
            return Integer.valueOf(iCompareTo);
        }
        return null;
    }

    public static int c(InterfaceC0803h interfaceC0803h) {
        if (C4828h.B(interfaceC0803h)) {
            return 8;
        }
        if (interfaceC0803h instanceof kotlin.reflect.jvm.internal.impl.descriptors.c) {
            return 7;
        }
        if (interfaceC0803h instanceof O) {
            return ((O) interfaceC0803h).K() == null ? 6 : 5;
        }
        if (interfaceC0803h instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.e) interfaceC0803h).K() == null ? 4 : 3;
        }
        if (interfaceC0803h instanceof InterfaceC0797b) {
            return 2;
        }
        return interfaceC0803h instanceof a0 ? 1 : 0;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(InterfaceC0803h interfaceC0803h, InterfaceC0803h interfaceC0803h2) {
        Integer numB = b(interfaceC0803h, interfaceC0803h2);
        if (numB != null) {
            return numB.intValue();
        }
        return 0;
    }
}
