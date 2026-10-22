package androidx.compose.material3;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetKt$Scrim$dismissSheet$1$1 implements PointerInputEventHandler {
    final /* synthetic */ Function0<Unit> $onDismissRequest;

    public ModalBottomSheetKt$Scrim$dismissSheet$1$1(Function0<Unit> r100) {
        this.$onDismissRequest = r100;
    }

    public static /* synthetic */ Unit a(Function0 r100, Offset r101) {
        return invoke$lambda$0(r100, r101);
    }

    private static final Unit invoke$lambda$0(Function0 r100, Offset r101) {
        r100.invoke();
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope r100, Continuation<? super Unit> r110) {
        final Function0<Unit> r101 = this.$onDismissRequest;
        Object r102 = TapGestureDetectorKt.detectTapGestures$default(r100, null, null, null, new ze(r101), r110, 7, null);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }
}
