package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H&J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H&J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH&Jg\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u0018J9\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006#À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "", "mainAxisSize", "", "Landroidx/compose/ui/layout/Placeable;", "crossAxisSize", "populateMainAxisPositions", "", "mainAxisLayoutSize", "childrenMainAxisSize", "", "mainAxisPositions", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "placeHelper", "Landroidx/compose/ui/layout/MeasureResult;", "placeables", "", "beforeCrossAxisAlignmentLine", "crossAxisLayoutSize", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "mainAxisMin", "crossAxisMin", "mainAxisMax", "crossAxisMax", "isPrioritizing", "", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface RowColumnMeasurePolicy {

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.RowColumnMeasurePolicy$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: createConstraints-xF2OJ5Q$default, reason: not valid java name */
        public static /* synthetic */ long m758createConstraintsxF2OJ5Q$default(RowColumnMeasurePolicy r100, int r101, int r102, int r103, int r110, boolean r111, int r112, Object r113) {
            if (r113 != null) goto L10;
            if ((r112 & 16) == 0) goto L6;
            boolean r104 = false;
        L8:
            return r100.mo645createConstraintsxF2OJ5Q(r101, r102, r103, r110, r104);
        L6:
            r104 = r111;
            goto L8
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createConstraints-xF2OJ5Q");
        }
    }

    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q */
    long mo645createConstraintsxF2OJ5Q(int r100, int r101, int r102, int r103, boolean r104);

    int crossAxisSize(Placeable r100);

    int mainAxisSize(Placeable r100);

    MeasureResult placeHelper(Placeable[] r100, MeasureScope r101, int r102, int[] r103, int r104, int r105, int[] r106, int r107, int r108, int r110);

    void populateMainAxisPositions(int r100, int[] r101, int[] r102, MeasureScope r103);
}
