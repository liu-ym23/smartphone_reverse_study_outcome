package sa;

import ya.S;

/* loaded from: classes5.dex */
public class j extends AbstractC5454a {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(S s10) {
        this(s10, null);
        if (s10 == null) {
            c(0);
        }
    }

    private static /* synthetic */ void c(int i10) {
        Object[] objArr = new Object[3];
        if (i10 != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i10 != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        return "{Transient} : " + getType();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(S s10, InterfaceC5460g interfaceC5460g) {
        super(s10, interfaceC5460g);
        if (s10 == null) {
            c(1);
        }
    }
}
