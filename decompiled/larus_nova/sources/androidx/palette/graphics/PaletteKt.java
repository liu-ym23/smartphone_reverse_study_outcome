package androidx.palette.graphics;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\n¨\u0006\u0005"}, d2 = {MonitorConstants.CONNECT_TYPE_GET, "Landroidx/palette/graphics/Palette$Swatch;", "Landroidx/palette/graphics/Palette;", PickerReporterConstants.KEY.TARGET, "Landroidx/palette/graphics/Target;", "palette-ktx_release"}, k = 2, mv = {1, 1, 10})
public final class PaletteKt {
    public static final Palette.Swatch get(Palette r100, Target r101) {
        return r100.getSwatchForTarget(r101);
    }
}
