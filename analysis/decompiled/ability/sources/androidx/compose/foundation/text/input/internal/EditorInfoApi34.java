package androidx.compose.foundation.text.input.internal;

import D7.q;
import H4.o;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@RequiresApi(34)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/input/internal/EditorInfoApi34;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/inputmethod/EditorInfo;", "editorInfo", "LC7/r;", "setHandwritingGestures", "(Landroid/view/inputmethod/EditorInfo;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class EditorInfoApi34 {
    public static final EditorInfoApi34 INSTANCE = new EditorInfoApi34();

    private EditorInfoApi34() {
    }

    @DoNotInline
    public final void setHandwritingGestures(EditorInfo editorInfo) {
        editorInfo.setSupportedHandwritingGestures(o.N(d.n(), d.x(), d.t(), d.v(), d.z(), d.B(), d.D()));
        editorInfo.setSupportedHandwritingGesturePreviews(q.K0(new Class[]{d.n(), d.x(), d.t(), d.v()}));
    }
}
