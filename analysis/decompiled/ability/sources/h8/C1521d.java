package h8;

import i8.InterfaceC1561g;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: h8.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1521d implements InterfaceC1507O {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1507O f4580a;
    public final InterfaceC1525h b;
    public final int c;

    public C1521d(InterfaceC1507O interfaceC1507O, InterfaceC1525h interfaceC1525h, int i) {
        this.f4580a = interfaceC1507O;
        this.b = interfaceC1525h;
        this.c = i;
    }

    @Override // h8.InterfaceC1507O
    public final W8.l F() {
        W8.l lVarF = this.f4580a.F();
        kotlin.jvm.internal.k.e(lVarF, "getStorageManager(...)");
        return lVarF;
    }

    @Override // h8.InterfaceC1507O
    public final boolean K() {
        return true;
    }

    @Override // h8.InterfaceC1527j
    public final Object N(InterfaceC1529l interfaceC1529l, Object obj) {
        return this.f4580a.N(interfaceC1529l, obj);
    }

    @Override // h8.InterfaceC1524g, h8.InterfaceC1527j
    public final InterfaceC1524g a() {
        return this.f4580a.a();
    }

    @Override // h8.InterfaceC1527j
    public final InterfaceC1527j d() {
        return this.b;
    }

    @Override // h8.InterfaceC1524g
    public final X8.A g() {
        X8.A aG = this.f4580a.g();
        kotlin.jvm.internal.k.e(aG, "getDefaultType(...)");
        return aG;
    }

    @Override // i8.InterfaceC1555a
    public final InterfaceC1561g getAnnotations() {
        return this.f4580a.getAnnotations();
    }

    @Override // h8.InterfaceC1507O
    public final int getIndex() {
        return this.f4580a.getIndex() + this.c;
    }

    @Override // h8.InterfaceC1527j
    public final G8.f getName() {
        G8.f name = this.f4580a.getName();
        kotlin.jvm.internal.k.e(name, "getName(...)");
        return name;
    }

    @Override // h8.InterfaceC1528k
    public final InterfaceC1503K getSource() {
        InterfaceC1503K source = this.f4580a.getSource();
        kotlin.jvm.internal.k.e(source, "getSource(...)");
        return source;
    }

    @Override // h8.InterfaceC1507O
    public final List getUpperBounds() {
        List upperBounds = this.f4580a.getUpperBounds();
        kotlin.jvm.internal.k.e(upperBounds, "getUpperBounds(...)");
        return upperBounds;
    }

    @Override // h8.InterfaceC1524g
    public final X8.K m() {
        X8.K kM = this.f4580a.m();
        kotlin.jvm.internal.k.e(kM, "getTypeConstructor(...)");
        return kM;
    }

    @Override // h8.InterfaceC1507O
    public final boolean o() {
        return this.f4580a.o();
    }

    @Override // h8.InterfaceC1507O
    public final Variance r() {
        Variance varianceR = this.f4580a.r();
        kotlin.jvm.internal.k.e(varianceR, "getVariance(...)");
        return varianceR;
    }

    public final String toString() {
        return this.f4580a + "[inner-copy]";
    }

    @Override // h8.InterfaceC1527j
    public final InterfaceC1527j a() {
        return this.f4580a.a();
    }

    @Override // h8.InterfaceC1507O, h8.InterfaceC1524g, h8.InterfaceC1527j
    public final InterfaceC1507O a() {
        return this.f4580a.a();
    }
}
