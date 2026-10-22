package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0010\u001a\u00020\f*\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u001c\u0010\u0012\u001a\u00020\f*\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u00020\f*\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/Modifier$Element;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LayoutModifier extends Modifier.Element {

    /* JADX INFO: renamed from: androidx.compose.ui.layout.LayoutModifier$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ boolean access$all$jd(LayoutModifier r100, Function1 r101) {
            return Modifier.Element.CC.$default$all(r100, r101);
        }

        public static /* synthetic */ boolean access$any$jd(LayoutModifier r100, Function1 r101) {
            return Modifier.Element.CC.$default$any(r100, r101);
        }

        public static /* synthetic */ Modifier access$then$jd(LayoutModifier r100, Modifier r101) {
            return Modifier.CC.$default$then(r100, r101);
        }

        public static /* synthetic */ Object access$foldIn$jd(LayoutModifier r100, Object r101, Function2 r102) {
            return Modifier.Element.CC.$default$foldIn(r100, r101, r102);
        }

        public static /* synthetic */ Object access$foldOut$jd(LayoutModifier r100, Object r101, Function2 r102) {
            return Modifier.Element.CC.$default$foldOut(r100, r101, r102);
        }

        public static int $default$maxIntrinsicHeight(LayoutModifier r100, IntrinsicMeasureScope r101, IntrinsicMeasurable r102, int r103) {
            return MeasuringIntrinsics.INSTANCE.maxHeight(r100, r101, r102, r103);
        }

        public static int $default$maxIntrinsicWidth(LayoutModifier r100, IntrinsicMeasureScope r101, IntrinsicMeasurable r102, int r103) {
            return MeasuringIntrinsics.INSTANCE.maxWidth(r100, r101, r102, r103);
        }

        public static int $default$minIntrinsicHeight(LayoutModifier r100, IntrinsicMeasureScope r101, IntrinsicMeasurable r102, int r103) {
            return MeasuringIntrinsics.INSTANCE.minHeight(r100, r101, r102, r103);
        }

        public static int $default$minIntrinsicWidth(LayoutModifier r100, IntrinsicMeasureScope r101, IntrinsicMeasurable r102, int r103) {
            return MeasuringIntrinsics.INSTANCE.minWidth(r100, r101, r102, r103);
        }

        public static /* synthetic */ int access$maxIntrinsicHeight$jd(LayoutModifier r100, IntrinsicMeasureScope r101, IntrinsicMeasurable r102, int r103) {
            return $default$maxIntrinsicHeight(r100, r101, r102, r103);
        }

        public static /* synthetic */ int access$maxIntrinsicWidth$jd(LayoutModifier r100, IntrinsicMeasureScope r101, IntrinsicMeasurable r102, int r103) {
            return $default$maxIntrinsicWidth(r100, r101, r102, r103);
        }

        public static /* synthetic */ int access$minIntrinsicHeight$jd(LayoutModifier r100, IntrinsicMeasureScope r101, IntrinsicMeasurable r102, int r103) {
            return $default$minIntrinsicHeight(r100, r101, r102, r103);
        }

        public static /* synthetic */ int access$minIntrinsicWidth$jd(LayoutModifier r100, IntrinsicMeasureScope r101, IntrinsicMeasurable r102, int r103) {
            return $default$minIntrinsicWidth(r100, r101, r102, r103);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean all(LayoutModifier r100, Function1<? super Modifier.Element, Boolean> r101) {
            return CC.access$all$jd(r100, r101);
        }

        public static boolean any(LayoutModifier r100, Function1<? super Modifier.Element, Boolean> r101) {
            return CC.access$any$jd(r100, r101);
        }

        public static Modifier then(LayoutModifier r100, Modifier r101) {
            return CC.access$then$jd(r100, r101);
        }

        public static <R> R foldIn(LayoutModifier r100, R r101, Function2<? super R, ? super Modifier.Element, ? extends R> r102) {
            return (R) CC.access$foldIn$jd(r100, r101, r102);
        }

        public static <R> R foldOut(LayoutModifier r100, R r101, Function2<? super Modifier.Element, ? super R, ? extends R> r102) {
            return (R) CC.access$foldOut$jd(r100, r101, r102);
        }

        public static int maxIntrinsicHeight(LayoutModifier r100, IntrinsicMeasureScope r101, IntrinsicMeasurable r102, int r103) {
            return CC.access$maxIntrinsicHeight$jd(r100, r101, r102, r103);
        }

        public static int maxIntrinsicWidth(LayoutModifier r100, IntrinsicMeasureScope r101, IntrinsicMeasurable r102, int r103) {
            return CC.access$maxIntrinsicWidth$jd(r100, r101, r102, r103);
        }

        public static int minIntrinsicHeight(LayoutModifier r100, IntrinsicMeasureScope r101, IntrinsicMeasurable r102, int r103) {
            return CC.access$minIntrinsicHeight$jd(r100, r101, r102, r103);
        }

        public static int minIntrinsicWidth(LayoutModifier r100, IntrinsicMeasureScope r101, IntrinsicMeasurable r102, int r103) {
            return CC.access$minIntrinsicWidth$jd(r100, r101, r102, r103);
        }
    }

    int maxIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102);

    int maxIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102);

    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo652measure3p2s80s(MeasureScope r100, Measurable r101, long r102);

    int minIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102);

    int minIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102);
}
