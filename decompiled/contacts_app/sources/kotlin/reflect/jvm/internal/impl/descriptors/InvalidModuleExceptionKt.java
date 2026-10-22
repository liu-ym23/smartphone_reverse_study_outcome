package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InvalidModuleException.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InvalidModuleExceptionKt {
    private static final ModuleCapability<InvalidModuleNotifier> INVALID_MODULE_NOTIFIER_CAPABILITY = null;

    public static final void moduleInvalidated(ModuleDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        InvalidModuleNotifier r0 = (InvalidModuleNotifier) r3.getCapability(INVALID_MODULE_NOTIFIER_CAPABILITY);
        if (r0 == null) goto L5;
        r0.notifyModuleInvalidated(r3);
        Unit r1 = Unit.INSTANCE;
    L6:
        if (r1 == null) goto L9;
        return;
    L9:
        throw new InvalidModuleException("Accessing invalid module descriptor " + r3);
    L5:
        r1 = null;
        goto L6
    }

    static {
        INVALID_MODULE_NOTIFIER_CAPABILITY = new ModuleCapability("InvalidModuleNotifier");
    }
}
