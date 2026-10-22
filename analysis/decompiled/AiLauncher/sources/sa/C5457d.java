package sa;

import ya.S;

/* renamed from: sa.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5457d extends AbstractC5454a implements InterfaceC5460g {

    /* renamed from: c, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.descriptors.a f40177c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5457d(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, S s10, InterfaceC5460g interfaceC5460g) {
        super(s10, interfaceC5460g);
        if (aVar == null) {
            c(0);
        }
        if (s10 == null) {
            c(1);
        }
        this.f40177c = aVar;
    }

    public static /* synthetic */ void c(int i10) {
        String str = i10 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 2 ? 3 : 2];
        if (i10 == 1) {
            objArr[0] = "receiverType";
        } else if (i10 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else if (i10 != 3) {
            objArr[0] = "callableDescriptor";
        } else {
            objArr[0] = "newType";
        }
        if (i10 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else {
            objArr[1] = "getDeclarationDescriptor";
        }
        if (i10 != 2) {
            if (i10 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "replaceType";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 == 2) {
            throw new IllegalStateException(str2);
        }
    }

    public String toString() {
        return getType() + ": Ext {" + this.f40177c + "}";
    }
}
