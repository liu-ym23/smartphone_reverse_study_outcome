package E9;

import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;

/* renamed from: E9.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0814t {

    /* renamed from: a, reason: collision with root package name */
    public static final C0818x<InterfaceC0815u> f2489a = new C0818x<>("InvalidModuleNotifier");

    public static final void a(InterfaceC0819y interfaceC0819y) {
        kotlin.jvm.internal.p.i(interfaceC0819y, "<this>");
        InterfaceC0815u interfaceC0815u = (InterfaceC0815u) interfaceC0819y.q0(f2489a);
        if (interfaceC0815u != null) {
            interfaceC0815u.a(interfaceC0819y);
            return;
        }
        throw new InvalidModuleException("Accessing invalid module descriptor " + interfaceC0819y);
    }
}
