package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes4.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(KDeclarationContainer r10, String r11, String r12) {
        super(((ClassBasedDeclarationContainer) r10).getJClass(), r11, r12, !(r10 instanceof KClass) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty2
    public Object get(Object r10, Object r11) {
        return getGetter().call(new Object[]{r10, r11});
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference2Impl(Class r10, String r11, String r12, int r13) {
        super(r10, r11, r12, r13);
    }
}
