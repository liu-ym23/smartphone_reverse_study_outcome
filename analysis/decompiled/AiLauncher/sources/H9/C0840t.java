package H9;

import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import sa.C5458e;
import sa.InterfaceC5460g;

/* renamed from: H9.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0840t extends AbstractC0824c {

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0797b f3214c;

    /* renamed from: d, reason: collision with root package name */
    public final C5458e f3215d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0840t(InterfaceC0797b interfaceC0797b) {
        super(F9.g.f2609m0.b());
        if (interfaceC0797b == null) {
            T(0);
        }
        this.f3214c = interfaceC0797b;
        this.f3215d = new C5458e(interfaceC0797b, null);
    }

    private static /* synthetic */ void T(int i10) {
        String str = (i10 == 1 || i10 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 1 || i10 == 2) ? 2 : 3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i10 != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i10 == 1) {
            objArr[1] = "getValue";
        } else if (i10 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = ChatTracker.CLICK_COPY;
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // E9.InterfaceC0803h
    public InterfaceC0803h b() {
        InterfaceC0797b interfaceC0797b = this.f3214c;
        if (interfaceC0797b == null) {
            T(2);
        }
        return interfaceC0797b;
    }

    @Override // E9.S
    public InterfaceC5460g getValue() {
        C5458e c5458e = this.f3215d;
        if (c5458e == null) {
            T(1);
        }
        return c5458e;
    }

    @Override // H9.AbstractC0834m
    public String toString() {
        return "class " + this.f3214c.getName() + "::this";
    }
}
