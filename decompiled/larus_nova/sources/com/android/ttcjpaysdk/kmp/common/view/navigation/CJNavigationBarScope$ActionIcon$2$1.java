package com.android.ttcjpaysdk.kmp.common.view.navigation;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class CJNavigationBarScope$ActionIcon$2$1 implements PointerInputEventHandler {
    final /* synthetic */ Function0<Unit> $onClick;

    public CJNavigationBarScope$ActionIcon$2$1(Function0<Unit> r100) {
        this.$onClick = r100;
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
        final Function0<Unit> r101 = this.$onClick;
        Object r102 = TapGestureDetectorKt.detectTapGestures$default(r100, null, null, null, new l(r101), r110, 7, null);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }
}
