package com.android.ttcjpaysdk.kmp.common.ui;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class CJComposeDialogContentKt$textButtonList$1$2$1$1$1 implements PointerInputEventHandler {
    final /* synthetic */ CJDialogButtonOptions $buttonInfo;

    public CJComposeDialogContentKt$textButtonList$1$2$1$1$1(CJDialogButtonOptions r100) {
        this.$buttonInfo = r100;
    }

    public static /* synthetic */ Unit a(CJDialogButtonOptions r100, Offset r101) {
        return invoke$lambda$0(r100, r101);
    }

    private static final Unit invoke$lambda$0(CJDialogButtonOptions r100, Offset r101) {
        CJDialogButtonEventListener r102 = r100.getEventListener();
        if (r102 == null) goto L6;
        r102.onClick();
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope r100, Continuation<? super Unit> r110) {
        final CJDialogButtonOptions r101 = this.$buttonInfo;
        Object r102 = TapGestureDetectorKt.detectTapGestures$default(r100, null, null, null, new j(r101), r110, 7, null);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }
}
