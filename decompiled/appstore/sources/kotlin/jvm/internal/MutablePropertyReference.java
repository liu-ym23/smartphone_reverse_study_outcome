package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KMutableProperty;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MutablePropertyReference extends PropertyReference implements KMutableProperty {
    public MutablePropertyReference() {
    }

    @SinceKotlin(version = "1.1")
    public MutablePropertyReference(Object r10) {
        super(r10);
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference(Object r10, Class r11, String r12, String r13, int r14) {
        super(r10, r11, r12, r13, r14);
    }
}
