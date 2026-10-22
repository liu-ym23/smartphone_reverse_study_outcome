package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;

@RequiresApi(34)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/text/input/internal/Api34PerformHandwritingGestureImpl;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "session", "Landroid/view/inputmethod/HandwritingGesture;", "gesture", "Ljava/util/concurrent/Executor;", "executor", "Ljava/util/function/IntConsumer;", "intConsumer", "LC7/r;", "performHandwritingGesture", "(Landroidx/compose/foundation/text/input/internal/TextInputSession;Landroid/view/inputmethod/HandwritingGesture;Ljava/util/concurrent/Executor;Ljava/util/function/IntConsumer;)V", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "Landroid/os/CancellationSignal;", "cancellationSignal", "", "previewHandwritingGesture", "(Landroidx/compose/foundation/text/input/internal/TextInputSession;Landroid/view/inputmethod/PreviewableHandwritingGesture;Landroid/os/CancellationSignal;)Z", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class Api34PerformHandwritingGestureImpl {
    public static final Api34PerformHandwritingGestureImpl INSTANCE = new Api34PerformHandwritingGestureImpl();

    private Api34PerformHandwritingGestureImpl() {
    }

    @DoNotInline
    public final void performHandwritingGesture(TextInputSession session, HandwritingGesture gesture, Executor executor, IntConsumer intConsumer) {
        int iPerformHandwritingGesture = session.performHandwritingGesture(gesture);
        if (intConsumer == null) {
            return;
        }
        if (executor != null) {
            executor.execute(new c(intConsumer, iPerformHandwritingGesture, 1));
        } else {
            intConsumer.accept(iPerformHandwritingGesture);
        }
    }

    @DoNotInline
    public final boolean previewHandwritingGesture(TextInputSession session, PreviewableHandwritingGesture gesture, CancellationSignal cancellationSignal) {
        return session.previewHandwritingGesture(gesture, cancellationSignal);
    }
}
