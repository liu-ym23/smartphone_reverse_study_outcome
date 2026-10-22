package E9;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.v0;

/* renamed from: E9.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0796a implements b0 {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f2447a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0803h f2448b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2449c;

    public C0796a(b0 originalDescriptor, InterfaceC0803h declarationDescriptor, int i10) {
        kotlin.jvm.internal.p.i(originalDescriptor, "originalDescriptor");
        kotlin.jvm.internal.p.i(declarationDescriptor, "declarationDescriptor");
        this.f2447a = originalDescriptor;
        this.f2448b = declarationDescriptor;
        this.f2449c = i10;
    }

    @Override // E9.b0
    public InterfaceC5869l I() {
        InterfaceC5869l interfaceC5869lI = this.f2447a.I();
        kotlin.jvm.internal.p.h(interfaceC5869lI, "getStorageManager(...)");
        return interfaceC5869lI;
    }

    @Override // E9.b0
    public boolean M() {
        return true;
    }

    @Override // E9.InterfaceC0804i, E9.InterfaceC0803h
    public InterfaceC0803h b() {
        return this.f2448b;
    }

    @Override // E9.InterfaceC0806k
    public W e() {
        W wE = this.f2447a.e();
        kotlin.jvm.internal.p.h(wE, "getSource(...)");
        return wE;
    }

    @Override // F9.a
    public F9.g getAnnotations() {
        return this.f2447a.getAnnotations();
    }

    @Override // E9.b0
    public int getIndex() {
        return this.f2449c + this.f2447a.getIndex();
    }

    @Override // E9.A
    public ga.e getName() {
        ga.e name = this.f2447a.getName();
        kotlin.jvm.internal.p.h(name, "getName(...)");
        return name;
    }

    @Override // E9.b0
    public List<ya.S> getUpperBounds() {
        List<ya.S> upperBounds = this.f2447a.getUpperBounds();
        kotlin.jvm.internal.p.h(upperBounds, "getUpperBounds(...)");
        return upperBounds;
    }

    @Override // E9.b0, E9.InterfaceC0799d
    public v0 j() {
        v0 v0VarJ = this.f2447a.j();
        kotlin.jvm.internal.p.h(v0VarJ, "getTypeConstructor(...)");
        return v0VarJ;
    }

    @Override // E9.b0
    public Variance l() {
        Variance varianceL = this.f2447a.l();
        kotlin.jvm.internal.p.h(varianceL, "getVariance(...)");
        return varianceL;
    }

    @Override // E9.InterfaceC0799d
    public AbstractC5990d0 n() {
        AbstractC5990d0 abstractC5990d0N = this.f2447a.n();
        kotlin.jvm.internal.p.h(abstractC5990d0N, "getDefaultType(...)");
        return abstractC5990d0N;
    }

    public String toString() {
        return this.f2447a + "[inner-copy]";
    }

    @Override // E9.InterfaceC0803h
    public <R, D> R v(InterfaceC0805j<R, D> interfaceC0805j, D d10) {
        return (R) this.f2447a.v(interfaceC0805j, d10);
    }

    @Override // E9.b0
    public boolean w() {
        return this.f2447a.w();
    }

    @Override // E9.InterfaceC0803h
    public b0 a() {
        b0 b0VarA = this.f2447a.a();
        kotlin.jvm.internal.p.h(b0VarA, "getOriginal(...)");
        return b0VarA;
    }
}
