package ua;

import E9.InterfaceC0819y;
import ra.InterfaceC5238k;
import xa.InterfaceC5869l;

/* renamed from: ua.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5631q extends H9.H {

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC5869l f42643g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC5631q(ga.c fqName, InterfaceC5869l storageManager, InterfaceC0819y module) {
        super(module, fqName);
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(module, "module");
        this.f42643g = storageManager;
    }

    public abstract InterfaceC5623i A0();

    public boolean E0(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        InterfaceC5238k interfaceC5238kM = m();
        return (interfaceC5238kM instanceof wa.u) && ((wa.u) interfaceC5238kM).s().contains(name);
    }

    public abstract void F0(C5627m c5627m);
}
