package androidx.compose.ui.platform;

import android.view.View;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/ViewLayerVerificationHelper28;", "", "<init>", "()V", "setOutlineAmbientShadowColor", "", "view", "Landroid/view/View;", PickerReporterConstants.KEY.TARGET, "", "setOutlineSpotShadowColor", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ViewLayerVerificationHelper28 {
    public static final ViewLayerVerificationHelper28 INSTANCE = null;

    static {
        INSTANCE = new ViewLayerVerificationHelper28();
    }

    private ViewLayerVerificationHelper28() {
    }

    public final void setOutlineAmbientShadowColor(View r100, int r101) {
        r100.setOutlineAmbientShadowColor(r101);
    }

    public final void setOutlineSpotShadowColor(View r100, int r101) {
        r100.setOutlineSpotShadowColor(r101);
    }
}
