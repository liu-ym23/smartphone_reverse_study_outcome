package androidx.compose.ui.input.pointer;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0 implements PointerInputEventHandler, FunctionAdapter {
    private final /* synthetic */ Function2 function;

    public SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(Function2 r100) {
        this.function = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof PointerInputEventHandler) == true) goto L5;
        return false;
    L5:
        if ((r100 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final /* synthetic */ Object invoke(PointerInputScope r100, Continuation r101) {
        return this.function.invoke(r100, r101);
    }
}
