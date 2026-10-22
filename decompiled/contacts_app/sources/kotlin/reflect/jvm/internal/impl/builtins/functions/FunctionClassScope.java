package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: compiled from: FunctionClassScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FunctionClassScope extends GivenFunctionsMemberScope {

    /* JADX INFO: compiled from: FunctionClassScope.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[FunctionClassKind.values().length];
            r0[FunctionClassKind.Function.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FunctionClassKind.SuspendFunction.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public FunctionClassScope(StorageManager r2, FunctionClassDescriptor r3) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "containingClass");
        super(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
    protected List<FunctionDescriptor> computeDeclaredFunctions() {
        ClassDescriptor r0 = getContainingClass();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        FunctionClassKind r1 = ((FunctionClassDescriptor) r0).getFunctionKind();
        int r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r2 == 1) goto L9;
        if (r2 == 2) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor) getContainingClass(), true));
    L9:
        return CollectionsKt.listOf(FunctionInvokeDescriptor.Factory.create((FunctionClassDescriptor) getContainingClass(), false));
    }
}
