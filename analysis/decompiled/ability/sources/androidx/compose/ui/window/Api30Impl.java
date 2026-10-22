package androidx.compose.ui.window;

import android.view.WindowManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@RequiresApi(30)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Landroidx/compose/ui/window/Api30Impl;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/WindowManager$LayoutParams;", "attrs", "", "sides", "LC7/r;", "setFitInsetsSides", "(Landroid/view/WindowManager$LayoutParams;I)V", "types", "setFitInsetsTypes", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
final class Api30Impl {
    public static final Api30Impl INSTANCE = new Api30Impl();

    private Api30Impl() {
    }

    @DoNotInline
    public final void setFitInsetsSides(WindowManager.LayoutParams attrs, int sides) {
        attrs.setFitInsetsSides(sides);
    }

    @DoNotInline
    public final void setFitInsetsTypes(WindowManager.LayoutParams attrs, int types) {
        attrs.setFitInsetsTypes(types);
    }
}
