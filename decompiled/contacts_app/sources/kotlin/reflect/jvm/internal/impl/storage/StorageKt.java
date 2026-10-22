package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: storage.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StorageKt {
    public static final <T> T getValue(NotNullLazyValue<? extends T> r0, Object r1, KProperty<?> r2) {
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r2, "p");
        return r0.invoke();
    }

    public static final <T> T getValue(NullableLazyValue<? extends T> r0, Object r1, KProperty<?> r2) {
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r2, "p");
        return r0.invoke();
    }
}
