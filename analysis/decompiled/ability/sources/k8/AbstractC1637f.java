package k8;

import h8.C1531n;
import h8.InterfaceC1503K;
import h8.InterfaceC1506N;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import h8.InterfaceC1528k;
import h8.InterfaceC1529l;
import i8.InterfaceC1561g;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;

/* renamed from: k8.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1637f extends AbstractC1645n implements InterfaceC1506N {
    public final W8.l e;
    public final C1531n f;
    public List g;
    public final C1636e h;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        nVar.g(new PropertyReference1Impl(nVar.b(AbstractC1637f.class), "constructors", "getConstructors()Ljava/util/Collection;"));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1637f(W8.l storageManager, InterfaceC1527j containingDeclaration, InterfaceC1561g interfaceC1561g, G8.f fVar, C1531n visibilityImpl) {
        super(containingDeclaration, interfaceC1561g, fVar, InterfaceC1503K.f4577I);
        kotlin.jvm.internal.k.f(storageManager, "storageManager");
        kotlin.jvm.internal.k.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.k.f(visibilityImpl, "visibilityImpl");
        this.e = storageManager;
        this.f = visibilityImpl;
        ((W8.i) storageManager).b(new I8.e(this, 22));
        this.h = new C1636e(this);
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return interfaceC1529l.x(this, obj);
    }

    @Override // k8.AbstractC1645n
    /* renamed from: Q0 */
    public final InterfaceC1528k a() {
        return this;
    }

    @Override // h8.InterfaceC1539v
    public final boolean S() {
        return false;
    }

    @Override // k8.AbstractC1645n, k8.AbstractC1644m, h8.InterfaceC1527j
    public final InterfaceC1524g a() {
        return this;
    }

    @Override // h8.InterfaceC1539v
    public final boolean g0() {
        return false;
    }

    @Override // h8.InterfaceC1539v
    public final C1531n getVisibility() {
        return this.f;
    }

    @Override // h8.InterfaceC1525h
    public final List h() {
        List list = this.g;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.k.n("declaredTypeParametersImpl");
        throw null;
    }

    @Override // h8.InterfaceC1539v
    public final boolean isExternal() {
        return false;
    }

    @Override // h8.InterfaceC1524g
    public final X8.K m() {
        return this.h;
    }

    @Override // h8.InterfaceC1525h
    public final boolean q() {
        return X8.S.c(((V8.t) this).T0(), new J4.b(this, 13), null);
    }

    @Override // k8.AbstractC1644m
    public final String toString() {
        return "typealias " + getName().b();
    }

    @Override // k8.AbstractC1645n, k8.AbstractC1644m, h8.InterfaceC1527j
    public final InterfaceC1527j a() {
        return this;
    }
}
