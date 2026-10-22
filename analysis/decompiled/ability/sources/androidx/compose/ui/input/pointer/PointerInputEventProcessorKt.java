package androidx.compose.ui.input.pointer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\b*\u00020\u0003H\u0082\b¨\u0006\t"}, d2 = {"ProcessResult", "Landroidx/compose/ui/input/pointer/ProcessResult;", "dispatchedToAPointerInputModifier", "", "anyMovementConsumed", "anyChangeConsumed", "(ZZZ)I", "toInt", "", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerInputEventProcessorKt {
    public static final int ProcessResult(boolean z10, boolean z11, boolean z12) {
        return ProcessResult.m5504constructorimpl((z10 ? 1 : 0) | ((z11 ? 1 : 0) << 1) | ((z12 ? 1 : 0) << 2));
    }

    private static final int toInt(boolean z10) {
        return z10 ? 1 : 0;
    }
}
