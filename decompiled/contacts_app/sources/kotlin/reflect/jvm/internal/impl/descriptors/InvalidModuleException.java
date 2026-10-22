package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InvalidModuleException.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InvalidModuleException extends IllegalStateException {
    public InvalidModuleException(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super(r2);
    }
}
