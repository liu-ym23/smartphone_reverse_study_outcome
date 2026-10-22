package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModuleCapability.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ModuleCapability<T> {
    private final String name;

    public ModuleCapability(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.name = r2;
    }

    public String toString() {
        return this.name;
    }
}
