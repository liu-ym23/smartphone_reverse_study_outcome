package androidx.compose.ui.graphics.layer;

import android.view.View;
import androidx.compose.ui.graphics.RenderEffect;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/graphics/layer/ViewLayerVerificationHelper31;", "", "<init>", "()V", "setRenderEffect", "", "view", "Landroid/view/View;", PickerReporterConstants.KEY.TARGET, "Landroidx/compose/ui/graphics/RenderEffect;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ViewLayerVerificationHelper31 {
    public static final ViewLayerVerificationHelper31 INSTANCE = null;

    static {
        INSTANCE = new ViewLayerVerificationHelper31();
    }

    private ViewLayerVerificationHelper31() {
    }

    public final void setRenderEffect(View r100, RenderEffect r101) {
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
