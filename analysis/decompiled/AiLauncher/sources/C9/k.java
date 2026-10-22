package C9;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import p9.InterfaceC5063a;

/* loaded from: classes5.dex */
public class k implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final PrimitiveType f1793a;

    public k(PrimitiveType primitiveType) {
        this.f1793a = primitiveType;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return PrimitiveType.typeFqName_delegate$lambda$0(this.f1793a);
    }
}
