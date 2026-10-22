package androidx.compose.ui.layout;

import androidx.compose.ui.unit.ConstraintsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bç\u0080\u0001\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\f\u001a\u00020\r*\u00020\u000e2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00060\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0016J(\u0010\u0011\u001a\u00020\r*\u00020\u000e2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00060\u00062\u0006\u0010\u0012\u001a\u00020\rH\u0016J(\u0010\u0013\u001a\u00020\r*\u00020\u000e2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00060\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0016J(\u0010\u0014\u001a\u00020\r*\u00020\u000e2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00060\u00062\u0006\u0010\u0012\u001a\u00020\rH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MultiContentMeasurePolicy {

    /* JADX INFO: renamed from: androidx.compose.ui.layout.MultiContentMeasurePolicy$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$maxIntrinsicHeight(MultiContentMeasurePolicy r110, IntrinsicMeasureScope r111, List r112, int r113) {
            ArrayList r100 = new ArrayList(r112.size());
            int r101 = r112.size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L8;
            List r103 = (List) ListProtector.get(r112, r102);
            ArrayList r104 = new ArrayList(r103.size());
            int r105 = r103.size();
            int r106 = 0;
        L5:
            if (r106 >= r105) goto L7;
            r104.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) ListProtector.get(r103, r106), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
            r106 = r106 + 1;
            goto L5
        L7:
            r100.add(r104);
            r102 = r102 + 1;
            goto L3
        L8:
            long r114 = ConstraintsKt.Constraints$default(0, r113, 0, 0, 13, null);
            return r110.mo678measure3p2s80s(new IntrinsicsMeasureScope(r111, r111.getLayoutDirection()), r100, r114).getHeight();
        }

        public static int $default$maxIntrinsicWidth(MultiContentMeasurePolicy r110, IntrinsicMeasureScope r111, List r112, int r113) {
            ArrayList r100 = new ArrayList(r112.size());
            int r101 = r112.size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L8;
            List r103 = (List) ListProtector.get(r112, r102);
            ArrayList r104 = new ArrayList(r103.size());
            int r105 = r103.size();
            int r106 = 0;
        L5:
            if (r106 >= r105) goto L7;
            r104.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) ListProtector.get(r103, r106), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
            r106 = r106 + 1;
            goto L5
        L7:
            r100.add(r104);
            r102 = r102 + 1;
            goto L3
        L8:
            long r114 = ConstraintsKt.Constraints$default(0, 0, 0, r113, 7, null);
            return r110.mo678measure3p2s80s(new IntrinsicsMeasureScope(r111, r111.getLayoutDirection()), r100, r114).getWidth();
        }

        public static int $default$minIntrinsicHeight(MultiContentMeasurePolicy r110, IntrinsicMeasureScope r111, List r112, int r113) {
            ArrayList r100 = new ArrayList(r112.size());
            int r101 = r112.size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L8;
            List r103 = (List) ListProtector.get(r112, r102);
            ArrayList r104 = new ArrayList(r103.size());
            int r105 = r103.size();
            int r106 = 0;
        L5:
            if (r106 >= r105) goto L7;
            r104.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) ListProtector.get(r103, r106), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
            r106 = r106 + 1;
            goto L5
        L7:
            r100.add(r104);
            r102 = r102 + 1;
            goto L3
        L8:
            long r114 = ConstraintsKt.Constraints$default(0, r113, 0, 0, 13, null);
            return r110.mo678measure3p2s80s(new IntrinsicsMeasureScope(r111, r111.getLayoutDirection()), r100, r114).getHeight();
        }

        public static int $default$minIntrinsicWidth(MultiContentMeasurePolicy r110, IntrinsicMeasureScope r111, List r112, int r113) {
            ArrayList r100 = new ArrayList(r112.size());
            int r101 = r112.size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L8;
            List r103 = (List) ListProtector.get(r112, r102);
            ArrayList r104 = new ArrayList(r103.size());
            int r105 = r103.size();
            int r106 = 0;
        L5:
            if (r106 >= r105) goto L7;
            r104.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) ListProtector.get(r103, r106), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
            r106 = r106 + 1;
            goto L5
        L7:
            r100.add(r104);
            r102 = r102 + 1;
            goto L3
        L8:
            long r114 = ConstraintsKt.Constraints$default(0, 0, 0, r113, 7, null);
            return r110.mo678measure3p2s80s(new IntrinsicsMeasureScope(r111, r111.getLayoutDirection()), r100, r114).getWidth();
        }
    }

    int maxIntrinsicHeight(IntrinsicMeasureScope r100, List<? extends List<? extends IntrinsicMeasurable>> r101, int r102);

    int maxIntrinsicWidth(IntrinsicMeasureScope r100, List<? extends List<? extends IntrinsicMeasurable>> r101, int r102);

    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo678measure3p2s80s(MeasureScope r100, List<? extends List<? extends Measurable>> r101, long r102);

    int minIntrinsicHeight(IntrinsicMeasureScope r100, List<? extends List<? extends IntrinsicMeasurable>> r101, int r102);

    int minIntrinsicWidth(IntrinsicMeasureScope r100, List<? extends List<? extends IntrinsicMeasurable>> r101, int r102);
}
