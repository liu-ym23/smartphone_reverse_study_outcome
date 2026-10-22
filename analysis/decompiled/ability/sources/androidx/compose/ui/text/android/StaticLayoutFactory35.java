package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@RequiresApi(35)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory35;", "", AppAgent.CONSTRUCT, "()V", "Landroid/text/StaticLayout$Builder;", "builder", "LC7/r;", "disableUseBoundsForWidth", "(Landroid/text/StaticLayout$Builder;)V", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
final class StaticLayoutFactory35 {
    public static final StaticLayoutFactory35 INSTANCE = new StaticLayoutFactory35();

    private StaticLayoutFactory35() {
    }

    public static final void disableUseBoundsForWidth(StaticLayout.Builder builder) {
        builder.setUseBoundsForWidth(false);
    }
}
