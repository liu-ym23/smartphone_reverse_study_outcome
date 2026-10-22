package sa;

import ya.S;

/* renamed from: sa.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5454a implements InterfaceC5460g {

    /* renamed from: a, reason: collision with root package name */
    public final S f40171a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5460g f40172b;

    public AbstractC5454a(S s10, InterfaceC5460g interfaceC5460g) {
        if (s10 == null) {
            c(0);
        }
        this.f40171a = s10;
        this.f40172b = interfaceC5460g == null ? this : interfaceC5460g;
    }

    private static /* synthetic */ void c(int i10) {
        String str = (i10 == 1 || i10 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 1 || i10 == 2) ? 2 : 3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i10 == 1) {
            objArr[1] = "getType";
        } else if (i10 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i10 != 1 && i10 != 2) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // sa.InterfaceC5460g
    public S getType() {
        S s10 = this.f40171a;
        if (s10 == null) {
            c(1);
        }
        return s10;
    }
}
