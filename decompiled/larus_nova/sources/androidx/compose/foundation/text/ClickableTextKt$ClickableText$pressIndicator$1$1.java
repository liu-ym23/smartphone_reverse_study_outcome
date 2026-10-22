package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ClickableTextKt$ClickableText$pressIndicator$1$1 implements PointerInputEventHandler {
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ Function1<Integer, Unit> $onClick;

    /* JADX WARN: Multi-variable type inference failed */
    public ClickableTextKt$ClickableText$pressIndicator$1$1(MutableState<TextLayoutResult> r100, Function1<? super Integer, Unit> r101) {
        this.$layoutResult = r100;
        this.$onClick = r101;
    }

    public static /* synthetic */ Unit a(MutableState r100, Function1 r101, Offset r102) {
        return invoke$lambda$1(r100, r101, r102);
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope r100, Continuation<? super Unit> r110) {
        final MutableState<TextLayoutResult> r101 = this.$layoutResult;
        final Function1<Integer, Unit> r102 = this.$onClick;
        Object r103 = TapGestureDetectorKt.detectTapGestures$default(r100, null, null, null, new m1(r101, r102), r110, 7, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$1(MutableState r100, Function1 r101, Offset r102) {
        TextLayoutResult r103 = (TextLayoutResult) r100.getValue();
        if (r103 == null) goto L6;
        r101.invoke(Integer.valueOf(r103.m6968getOffsetForPositionk4lQ0M(r102.m4592unboximpl())));
    L6:
        return Unit.INSTANCE;
    }
}
