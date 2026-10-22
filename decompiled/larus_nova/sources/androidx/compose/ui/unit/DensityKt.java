package androidx.compose.ui.unit;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0005"}, d2 = {"Density", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DensityKt {
    public static final Density Density(float r100, float r101) {
        return new DensityImpl(r100, r101);
    }

    public static /* synthetic */ Density Density$default(float r100, float r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = 1.0f;
    L6:
        return Density(r100, r101);
    }
}
