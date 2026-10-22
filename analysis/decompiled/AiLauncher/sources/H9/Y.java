package H9;

import E9.InterfaceC0803h;
import ma.AbstractC4927g;
import p9.InterfaceC5063a;
import xa.InterfaceC5866i;

/* loaded from: classes5.dex */
public abstract class Y extends X {

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3094f;

    /* renamed from: g, reason: collision with root package name */
    public InterfaceC5866i<AbstractC4927g<?>> f3095g;

    /* renamed from: h, reason: collision with root package name */
    public InterfaceC5063a<InterfaceC5866i<AbstractC4927g<?>>> f3096h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y(InterfaceC0803h interfaceC0803h, F9.g gVar, ga.e eVar, ya.S s10, boolean z10, E9.W w10) {
        super(interfaceC0803h, gVar, eVar, s10, w10);
        if (interfaceC0803h == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (eVar == null) {
            T(2);
        }
        if (w10 == null) {
            T(3);
        }
        this.f3094f = z10;
    }

    private static /* synthetic */ void T(int i10) {
        Object[] objArr = new Object[3];
        if (i10 == 1) {
            objArr[0] = "annotations";
        } else if (i10 == 2) {
            objArr[0] = "name";
        } else if (i10 == 3) {
            objArr[0] = "source";
        } else if (i10 == 4 || i10 == 5) {
            objArr[0] = "compileTimeInitializerFactory";
        } else {
            objArr[0] = "containingDeclaration";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i10 == 4) {
            objArr[2] = "setCompileTimeInitializerFactory";
        } else if (i10 != 5) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public void E0(InterfaceC5866i<AbstractC4927g<?>> interfaceC5866i, InterfaceC5063a<InterfaceC5866i<AbstractC4927g<?>>> interfaceC5063a) {
        if (interfaceC5063a == null) {
            T(5);
        }
        this.f3096h = interfaceC5063a;
        if (interfaceC5866i == null) {
            interfaceC5866i = interfaceC5063a.invoke();
        }
        this.f3095g = interfaceC5866i;
    }

    public void F0(InterfaceC5063a<InterfaceC5866i<AbstractC4927g<?>>> interfaceC5063a) {
        if (interfaceC5063a == null) {
            T(4);
        }
        E0(null, interfaceC5063a);
    }

    @Override // E9.j0
    public boolean J() {
        return this.f3094f;
    }

    @Override // E9.j0
    public AbstractC4927g<?> i0() {
        InterfaceC5866i<AbstractC4927g<?>> interfaceC5866i = this.f3095g;
        if (interfaceC5866i != null) {
            return interfaceC5866i.invoke();
        }
        return null;
    }
}
