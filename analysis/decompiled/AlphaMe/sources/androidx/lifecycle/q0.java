package androidx.lifecycle;

import d0.C0534d;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public interface q0 {
    default n0 a(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    default n0 c(Class modelClass, C0534d extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return a(modelClass);
    }
}
