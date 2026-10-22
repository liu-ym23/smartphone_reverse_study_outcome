package kotlin.reflect.jvm.internal.impl.km;

import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class InconsistentKotlinMetadataException extends IllegalArgumentException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InconsistentKotlinMetadataException(String message, Throwable th) {
        super(message, th);
        p.i(message, "message");
    }

    public /* synthetic */ InconsistentKotlinMetadataException(String str, Throwable th, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? null : th);
    }
}
