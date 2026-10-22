package androidx.compose.ui.platform;

import android.graphics.RenderNode;
import androidx.compose.ui.graphics.RenderEffect;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi29VerificationHelper;", "", "<init>", "()V", "setRenderEffect", "", "renderNode", "Landroid/graphics/RenderNode;", PickerReporterConstants.KEY.TARGET, "Landroidx/compose/ui/graphics/RenderEffect;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RenderNodeApi29VerificationHelper {
    public static final RenderNodeApi29VerificationHelper INSTANCE = null;

    static {
        INSTANCE = new RenderNodeApi29VerificationHelper();
    }

    private RenderNodeApi29VerificationHelper() {
    }

    public final void setRenderEffect(RenderNode r100, RenderEffect r101) {
        if (r101 == null) goto L4;
        android.graphics.RenderEffect r102 = r101.asAndroidRenderEffect();
    L5:
        r100.setRenderEffect(r102);
        return;
    L4:
        r102 = null;
        goto L5
    }
}
