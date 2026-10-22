package H9;

import E9.InterfaceC0803h;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import sa.InterfaceC5460g;

/* loaded from: classes5.dex */
public class N extends AbstractC0824c {

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0803h f3069c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC5460g f3070d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public N(InterfaceC0803h interfaceC0803h, InterfaceC5460g interfaceC5460g, F9.g gVar) {
        this(interfaceC0803h, interfaceC5460g, gVar, ga.g.f32749i);
        if (interfaceC0803h == null) {
            T(0);
        }
        if (interfaceC5460g == null) {
            T(1);
        }
        if (gVar == null) {
            T(2);
        }
    }

    private static /* synthetic */ void T(int i10) {
        String str = (i10 == 7 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 7 || i10 == 8) ? 2 : 3];
        switch (i10) {
            case 1:
            case 4:
                objArr[0] = UxipConstants.f30680s;
                break;
            case 2:
            case 5:
                objArr[0] = "annotations";
                break;
            case 3:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 6:
                objArr[0] = "name";
                break;
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 9:
                objArr[0] = "newOwner";
                break;
            case 10:
                objArr[0] = "outType";
                break;
        }
        if (i10 == 7) {
            objArr[1] = "getValue";
        } else if (i10 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        switch (i10) {
            case 7:
            case 8:
                break;
            case 9:
                objArr[2] = ChatTracker.CLICK_COPY;
                break;
            case 10:
                objArr[2] = "setOutType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 7 && i10 != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // E9.InterfaceC0803h
    public InterfaceC0803h b() {
        InterfaceC0803h interfaceC0803h = this.f3069c;
        if (interfaceC0803h == null) {
            T(8);
        }
        return interfaceC0803h;
    }

    @Override // E9.S
    public InterfaceC5460g getValue() {
        InterfaceC5460g interfaceC5460g = this.f3070d;
        if (interfaceC5460g == null) {
            T(7);
        }
        return interfaceC5460g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(InterfaceC0803h interfaceC0803h, InterfaceC5460g interfaceC5460g, F9.g gVar, ga.e eVar) {
        super(gVar, eVar);
        if (interfaceC0803h == null) {
            T(3);
        }
        if (interfaceC5460g == null) {
            T(4);
        }
        if (gVar == null) {
            T(5);
        }
        if (eVar == null) {
            T(6);
        }
        this.f3069c = interfaceC0803h;
        this.f3070d = interfaceC5460g;
    }
}
