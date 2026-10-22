package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: compiled from: ClassicTypeSystemContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ClassicTypeSystemContextKt {
    public static final /* synthetic */ UnwrappedType access$makeDefinitelyNotNullOrNotNullInternal(UnwrappedType r0) {
        return makeDefinitelyNotNullOrNotNullInternal(r0);
    }

    private static final UnwrappedType makeDefinitelyNotNullOrNotNullInternal(UnwrappedType r3) {
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull$default(r3, false, 1, null);
    }
}
