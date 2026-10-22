package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

/* JADX INFO: compiled from: RuntimeErrorReporter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RuntimeErrorReporter implements ErrorReporter {
    public static final RuntimeErrorReporter INSTANCE = null;

    static {
        INSTANCE = new RuntimeErrorReporter();
    }

    private RuntimeErrorReporter() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportIncompleteHierarchy(ClassDescriptor r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        Intrinsics.checkNotNullParameter(r4, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + r3.getName() + ", unresolved classes " + r4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportCannotInferVisibility(CallableMemberDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + r3);
    }
}
