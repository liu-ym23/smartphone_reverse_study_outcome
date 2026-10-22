package androidx.compose.ui.layout;

import androidx.compose.ui.unit.ConstraintsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bç\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH&J\"\u0010\n\u001a\u00020\u000b*\u00020\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\"\u0010\u000f\u001a\u00020\u000b*\u00020\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\"\u0010\u0011\u001a\u00020\u000b*\u00020\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\"\u0010\u0012\u001a\u00020\u000b*\u00020\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0010\u001a\u00020\u000bH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/MeasurePolicy;", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MeasurePolicy {

    /* JADX INFO: renamed from: androidx.compose.ui.layout.MeasurePolicy$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$maxIntrinsicHeight(MeasurePolicy r100, IntrinsicMeasureScope r110, List r111, int r112) {
            ArrayList r101 = new ArrayList(r111.size());
            int r102 = r111.size();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            r101.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) ListProtector.get(r111, r103), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
            r103 = r103 + 1;
            goto L3
        L5:
            long r113 = ConstraintsKt.Constraints$default(0, r112, 0, 0, 13, null);
            return r100.mo33measure3p2s80s(new IntrinsicsMeasureScope(r110, r110.getLayoutDirection()), r101, r113).getHeight();
        }

        public static int $default$maxIntrinsicWidth(MeasurePolicy r100, IntrinsicMeasureScope r110, List r111, int r112) {
            ArrayList r101 = new ArrayList(r111.size());
            int r102 = r111.size();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            r101.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) ListProtector.get(r111, r103), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
            r103 = r103 + 1;
            goto L3
        L5:
            long r113 = ConstraintsKt.Constraints$default(0, 0, 0, r112, 7, null);
            return r100.mo33measure3p2s80s(new IntrinsicsMeasureScope(r110, r110.getLayoutDirection()), r101, r113).getWidth();
        }

        public static int $default$minIntrinsicHeight(MeasurePolicy r100, IntrinsicMeasureScope r110, List r111, int r112) {
            ArrayList r101 = new ArrayList(r111.size());
            int r102 = r111.size();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            r101.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) ListProtector.get(r111, r103), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
            r103 = r103 + 1;
            goto L3
        L5:
            long r113 = ConstraintsKt.Constraints$default(0, r112, 0, 0, 13, null);
            return r100.mo33measure3p2s80s(new IntrinsicsMeasureScope(r110, r110.getLayoutDirection()), r101, r113).getHeight();
        }

        public static int $default$minIntrinsicWidth(MeasurePolicy r100, IntrinsicMeasureScope r110, List r111, int r112) {
            ArrayList r101 = new ArrayList(r111.size());
            int r102 = r111.size();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            r101.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) ListProtector.get(r111, r103), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
            r103 = r103 + 1;
            goto L3
        L5:
            long r113 = ConstraintsKt.Constraints$default(0, 0, 0, r112, 7, null);
            return r100.mo33measure3p2s80s(new IntrinsicsMeasureScope(r110, r110.getLayoutDirection()), r101, r113).getWidth();
        }

        public static /* synthetic */ int access$maxIntrinsicHeight$jd(MeasurePolicy r100, IntrinsicMeasureScope r101, List r102, int r103) {
            return $default$maxIntrinsicHeight(r100, r101, r102, r103);
        }

        public static /* synthetic */ int access$maxIntrinsicWidth$jd(MeasurePolicy r100, IntrinsicMeasureScope r101, List r102, int r103) {
            return $default$maxIntrinsicWidth(r100, r101, r102, r103);
        }

        public static /* synthetic */ int access$minIntrinsicHeight$jd(MeasurePolicy r100, IntrinsicMeasureScope r101, List r102, int r103) {
            return $default$minIntrinsicHeight(r100, r101, r102, r103);
        }

        public static /* synthetic */ int access$minIntrinsicWidth$jd(MeasurePolicy r100, IntrinsicMeasureScope r101, List r102, int r103) {
            return $default$minIntrinsicWidth(r100, r101, r102, r103);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int maxIntrinsicHeight(MeasurePolicy r100, IntrinsicMeasureScope r101, List<? extends IntrinsicMeasurable> r102, int r103) {
            return CC.access$maxIntrinsicHeight$jd(r100, r101, r102, r103);
        }

        public static int maxIntrinsicWidth(MeasurePolicy r100, IntrinsicMeasureScope r101, List<? extends IntrinsicMeasurable> r102, int r103) {
            return CC.access$maxIntrinsicWidth$jd(r100, r101, r102, r103);
        }

        public static int minIntrinsicHeight(MeasurePolicy r100, IntrinsicMeasureScope r101, List<? extends IntrinsicMeasurable> r102, int r103) {
            return CC.access$minIntrinsicHeight$jd(r100, r101, r102, r103);
        }

        public static int minIntrinsicWidth(MeasurePolicy r100, IntrinsicMeasureScope r101, List<? extends IntrinsicMeasurable> r102, int r103) {
            return CC.access$minIntrinsicWidth$jd(r100, r101, r102, r103);
        }
    }

    int maxIntrinsicHeight(IntrinsicMeasureScope r100, List<? extends IntrinsicMeasurable> r101, int r102);

    int maxIntrinsicWidth(IntrinsicMeasureScope r100, List<? extends IntrinsicMeasurable> r101, int r102);

    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo33measure3p2s80s(MeasureScope r100, List<? extends Measurable> r101, long r102);

    int minIntrinsicHeight(IntrinsicMeasureScope r100, List<? extends IntrinsicMeasurable> r101, int r102);

    int minIntrinsicWidth(IntrinsicMeasureScope r100, List<? extends IntrinsicMeasurable> r101, int r102);
}
