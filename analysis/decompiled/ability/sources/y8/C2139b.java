package y8;

import X8.w;
import h8.InterfaceC1503K;
import h8.InterfaceC1522e;
import i8.InterfaceC1556b;
import java.util.Map;

/* renamed from: y8.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2139b implements InterfaceC1556b {

    /* renamed from: a, reason: collision with root package name */
    public static final C2139b f6911a = new C2139b();

    @Override // i8.InterfaceC1556b
    public final Map a() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters");
    }

    @Override // i8.InterfaceC1556b
    public final G8.c b() {
        InterfaceC1522e interfaceC1522eD = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d(this);
        if (interfaceC1522eD != null) {
            if (Z8.i.f(interfaceC1522eD)) {
                interfaceC1522eD = null;
            }
            if (interfaceC1522eD != null) {
                return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.c(interfaceC1522eD);
            }
        }
        return null;
    }

    @Override // i8.InterfaceC1556b
    public final InterfaceC1503K getSource() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters");
    }

    @Override // i8.InterfaceC1556b
    public final w getType() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters");
    }

    public final String toString() {
        return "[EnhancedType]";
    }
}
