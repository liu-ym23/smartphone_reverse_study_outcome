package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/text/input/internal/Api34PerformHandwritingGestureImpl;", "", "<init>", "()V", "performHandwritingGesture", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "intConsumer", "Ljava/util/function/IntConsumer;", "previewHandwritingGesture", "", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class Api34PerformHandwritingGestureImpl {
    public static final Api34PerformHandwritingGestureImpl INSTANCE = null;

    static {
        INSTANCE = new Api34PerformHandwritingGestureImpl();
    }

    private Api34PerformHandwritingGestureImpl() {
    }

    public static /* synthetic */ void a(IntConsumer r100, int r101) {
        performHandwritingGesture$lambda$0(r100, r101);
    }

    private static final void performHandwritingGesture$lambda$0(IntConsumer r100, int r101) {
        r100.accept(r101);
    }

    public final boolean previewHandwritingGesture(TextInputSession r100, PreviewableHandwritingGesture r101, CancellationSignal r102) {
        return r100.previewHandwritingGesture(r101, r102);
    }

    public final void performHandwritingGesture(TextInputSession r100, HandwritingGesture r101, Executor r102, final IntConsumer r103) {
        final int r104 = r100.performHandwritingGesture(r101);
        if (r103 != null) goto L5;
        return;
    L5:
        if (r102 == null) goto L7;
        r102.execute(new h(r103, r104));
        return;
    L7:
        r103.accept(r104);
    }
}
