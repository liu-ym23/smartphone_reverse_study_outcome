package androidx.compose.ui.platform;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@RequiresApi(35)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewSensitiveContent35;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/View;", "view", "", "isSensitiveContent", "LC7/r;", "setContentSensitivity", "(Landroid/view/View;Z)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class AndroidComposeViewSensitiveContent35 {
    public static final AndroidComposeViewSensitiveContent35 INSTANCE = new AndroidComposeViewSensitiveContent35();

    private AndroidComposeViewSensitiveContent35() {
    }

    @DoNotInline
    @RequiresApi(35)
    public final void setContentSensitivity(View view, boolean isSensitiveContent) {
        if (isSensitiveContent) {
            view.setContentSensitivity(1);
        } else {
            view.setContentSensitivity(0);
        }
    }
}
