package androidx.compose.ui.platform;

import android.view.RenderNode;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005¨\u0006\r"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeVerificationHelper28;", "", "<init>", "()V", "getAmbientShadowColor", "", "renderNode", "Landroid/view/RenderNode;", "setAmbientShadowColor", "", PickerReporterConstants.KEY.TARGET, "getSpotShadowColor", "setSpotShadowColor", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RenderNodeVerificationHelper28 {
    public static final RenderNodeVerificationHelper28 INSTANCE = null;

    static {
        INSTANCE = new RenderNodeVerificationHelper28();
    }

    private RenderNodeVerificationHelper28() {
    }

    public final int getAmbientShadowColor(RenderNode r100) {
        return r100.getAmbientShadowColor();
    }

    public final int getSpotShadowColor(RenderNode r100) {
        return r100.getSpotShadowColor();
    }

    public final void setAmbientShadowColor(RenderNode r100, int r101) {
        r100.setAmbientShadowColor(r101);
    }

    public final void setSpotShadowColor(RenderNode r100, int r101) {
        r100.setSpotShadowColor(r101);
    }
}
