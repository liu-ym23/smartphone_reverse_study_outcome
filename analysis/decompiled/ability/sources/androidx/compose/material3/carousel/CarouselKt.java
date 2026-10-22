package androidx.compose.material3.carousel;

import B7.a;
import C7.r;
import S7.k;
import S7.o;
import androidx.annotation.VisibleForTesting;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a}\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000b2\u001d\u0010\u0012\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001ai\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000b2\u001d\u0010\u0012\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0089\u0001\u0010\"\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\u001d\u0010\u0012\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001b\u0010#\u001a\u00020\u001c*\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0003¢\u0006\u0004\b#\u0010$\u001a\u001b\u0010%\u001a\u00020\u001c*\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0003¢\u0006\u0004\b%\u0010$\u001aA\u0010.\u001a\u00020\u0004*\u00020\u00042\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0000¢\u0006\u0004\b.\u0010/\u001a\u001f\u00100\u001a\u00020\u001c2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(H\u0000¢\u0006\u0004\b0\u00101\u001a\u001f\u00102\u001a\u00020\u001c2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(H\u0001¢\u0006\u0004\b2\u00101\u001a'\u00107\u001a\u00020\u001c2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u0002032\u0006\u00106\u001a\u00020\u001cH\u0002¢\u0006\u0004\b7\u00108\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"Landroidx/compose/material3/carousel/CarouselState;", "state", "Landroidx/compose/ui/unit/Dp;", "preferredItemWidth", "Landroidx/compose/ui/Modifier;", "modifier", "itemSpacing", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "flingBehavior", "minSmallItemWidth", "maxSmallItemWidth", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "Lkotlin/Function2;", "Landroidx/compose/material3/carousel/CarouselItemScope;", "", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "HorizontalMultiBrowseCarousel-zCIJ0Nk", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;FFLandroidx/compose/foundation/layout/PaddingValues;LS7/p;Landroidx/compose/runtime/Composer;II)V", "HorizontalMultiBrowseCarousel", "itemWidth", "HorizontalUncontainedCarousel-9QcgTRs", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/layout/PaddingValues;LS7/p;Landroidx/compose/runtime/Composer;II)V", "HorizontalUncontainedCarousel", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "", "Landroidx/compose/material3/carousel/KeylineList;", "keylineList", "maxNonFocalVisibleItemCount", "Carousel-V-95POc", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/foundation/gestures/Orientation;LS7/n;Landroidx/compose/foundation/layout/PaddingValues;ILandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;LS7/p;Landroidx/compose/runtime/Composer;II)V", "Carousel", "calculateBeforeContentPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)F", "calculateAfterContentPadding", "index", "Lkotlin/Function0;", "Landroidx/compose/material3/carousel/Strategy;", "strategy", "Landroidx/compose/material3/carousel/CarouselItemInfoImpl;", "carouselItemInfo", "Landroidx/compose/ui/graphics/Shape;", "clipShape", "carouselItem", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/carousel/CarouselState;LS7/a;Landroidx/compose/material3/carousel/CarouselItemInfoImpl;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "calculateCurrentScrollOffset", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/material3/carousel/Strategy;)F", "calculateMaxScrollOffset", "Landroidx/compose/material3/carousel/Keyline;", "before", "after", "unadjustedOffset", "getProgress", "(Landroidx/compose/material3/carousel/Keyline;Landroidx/compose/material3/carousel/Keyline;F)F", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CarouselKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0107  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: Carousel-V-95POc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2657CarouselV95POc(androidx.compose.material3.carousel.CarouselState r32, final androidx.compose.foundation.gestures.Orientation r33, final S7.n r34, final androidx.compose.foundation.layout.PaddingValues r35, final int r36, androidx.compose.ui.Modifier r37, float r38, androidx.compose.foundation.gestures.TargetedFlingBehavior r39, final S7.p r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m2657CarouselV95POc(androidx.compose.material3.carousel.CarouselState, androidx.compose.foundation.gestures.Orientation, S7.n, androidx.compose.foundation.layout.PaddingValues, int, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, S7.p, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: HorizontalMultiBrowseCarousel-zCIJ0Nk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2658HorizontalMultiBrowseCarouselzCIJ0Nk(final androidx.compose.material3.carousel.CarouselState r24, final float r25, androidx.compose.ui.Modifier r26, float r27, androidx.compose.foundation.gestures.TargetedFlingBehavior r28, float r29, float r30, androidx.compose.foundation.layout.PaddingValues r31, final S7.p r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m2658HorizontalMultiBrowseCarouselzCIJ0Nk(androidx.compose.material3.carousel.CarouselState, float, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, float, float, androidx.compose.foundation.layout.PaddingValues, S7.p, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010b  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: HorizontalUncontainedCarousel-9QcgTRs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2659HorizontalUncontainedCarousel9QcgTRs(final androidx.compose.material3.carousel.CarouselState r21, final float r22, androidx.compose.ui.Modifier r23, float r24, androidx.compose.foundation.gestures.TargetedFlingBehavior r25, androidx.compose.foundation.layout.PaddingValues r26, final S7.p r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m2659HorizontalUncontainedCarousel9QcgTRs(androidx.compose.material3.carousel.CarouselState, float, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, androidx.compose.foundation.layout.PaddingValues, S7.p, androidx.compose.runtime.Composer, int, int):void");
    }

    @Composable
    private static final float calculateAfterContentPadding(PaddingValues paddingValues, Orientation orientation, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1018496720, i, -1, "androidx.compose.material3.carousel.calculateAfterContentPadding (Carousel.kt:353)");
        }
        composer.startReplaceGroup(-587616383);
        float bottom = orientation == Orientation.Vertical ? paddingValues.getBottom() : PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection()));
        composer.endReplaceGroup();
        float fMo381toPx0680j_4 = ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).mo381toPx0680j_4(bottom);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return fMo381toPx0680j_4;
    }

    @Composable
    private static final float calculateBeforeContentPadding(PaddingValues paddingValues, Orientation orientation, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896839347, i, -1, "androidx.compose.material3.carousel.calculateBeforeContentPadding (Carousel.kt:341)");
        }
        composer.startReplaceGroup(295830617);
        float top = orientation == Orientation.Vertical ? paddingValues.getTop() : PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection()));
        composer.endReplaceGroup();
        float fMo381toPx0680j_4 = ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).mo381toPx0680j_4(top);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return fMo381toPx0680j_4;
    }

    public static final float calculateCurrentScrollOffset(CarouselState carouselState, Strategy strategy) {
        float itemSpacing = strategy.getItemSpacing() + strategy.getItemMainAxisSize();
        return ((carouselState.getPagerState().getCurrentPageOffsetFraction() * itemSpacing) + (carouselState.getPagerState().getCurrentPage() * itemSpacing)) - KeylineSnapPositionKt.getSnapPositionOffset(strategy, carouselState.getPagerState().getCurrentPage(), carouselState.getPagerState().getPageCount());
    }

    @VisibleForTesting
    public static final float calculateMaxScrollOffset(CarouselState carouselState, Strategy strategy) {
        float pageCount = carouselState.getPagerState().getPageCount();
        float fB = a.b(pageCount, 1, strategy.getItemSpacing(), strategy.getItemMainAxisSize() * pageCount) - strategy.getAvailableSpace();
        if (fB < 0.0f) {
            return 0.0f;
        }
        return fB;
    }

    public static final Modifier carouselItem(Modifier modifier, final int i, final CarouselState carouselState, final S7.a aVar, final CarouselItemInfoImpl carouselItemInfoImpl, final Shape shape) {
        return LayoutModifierKt.layout(modifier, new o() { // from class: androidx.compose.material3.carousel.CarouselKt.carouselItem.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m2660invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).getValue());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m2660invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
                final Strategy strategy = (Strategy) aVar.invoke();
                if (!strategy.getIsValid()) {
                    return MeasureScope.layout$default(measureScope, 0, 0, null, new k() { // from class: androidx.compose.material3.carousel.CarouselKt.carouselItem.1.1
                        public final void invoke(Placeable.PlacementScope placementScope) {
                        }

                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return r.f317a;
                        }
                    }, 4, null);
                }
                final boolean z10 = carouselState.getPagerState().getLayoutInfo().getOrientation() == Orientation.Vertical;
                final boolean z11 = measureScope.getLayoutDirection() == LayoutDirection.Rtl;
                float itemMainAxisSize = strategy.getItemMainAxisSize();
                final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(z10 ? Constraints.m6786copyZbe2FdA(j5, Constraints.m6799getMinWidthimpl(j5), Constraints.m6797getMaxWidthimpl(j5), U7.a.U(itemMainAxisSize), U7.a.U(itemMainAxisSize)) : Constraints.m6786copyZbe2FdA(j5, U7.a.U(itemMainAxisSize), U7.a.U(itemMainAxisSize), Constraints.m6798getMinHeightimpl(j5), Constraints.m6796getMaxHeightimpl(j5)));
                int width = placeableMo5549measureBRTryo0.getWidth();
                int height = placeableMo5549measureBRTryo0.getHeight();
                final CarouselState carouselState2 = carouselState;
                final int i6 = i;
                final CarouselItemInfoImpl carouselItemInfoImpl2 = carouselItemInfoImpl;
                final Shape shape2 = shape;
                return MeasureScope.layout$default(measureScope, width, height, null, new k() { // from class: androidx.compose.material3.carousel.CarouselKt.carouselItem.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return r.f317a;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope) {
                        Placeable placeable = placeableMo5549measureBRTryo0;
                        final CarouselState carouselState3 = carouselState2;
                        final Strategy strategy2 = strategy;
                        final int i10 = i6;
                        final boolean z12 = z10;
                        final CarouselItemInfoImpl carouselItemInfoImpl3 = carouselItemInfoImpl2;
                        final Shape shape3 = shape2;
                        final boolean z13 = z11;
                        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, 0, 0.0f, new k() { // from class: androidx.compose.material3.carousel.CarouselKt.carouselItem.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((GraphicsLayerScope) obj);
                                return r.f317a;
                            }

                            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                float fCalculateCurrentScrollOffset = CarouselKt.calculateCurrentScrollOffset(carouselState3, strategy2);
                                float fCalculateMaxScrollOffset = CarouselKt.calculateMaxScrollOffset(carouselState3, strategy2);
                                KeylineList keylineListForScrollOffset$material3_release$default = Strategy.getKeylineListForScrollOffset$material3_release$default(strategy2, fCalculateCurrentScrollOffset, fCalculateMaxScrollOffset, false, 4, null);
                                KeylineList keylineListForScrollOffset$material3_release = strategy2.getKeylineListForScrollOffset$material3_release(fCalculateCurrentScrollOffset, fCalculateMaxScrollOffset, true);
                                float itemMainAxisSize2 = ((strategy2.getItemMainAxisSize() / 2.0f) + (i10 * (strategy2.getItemSpacing() + strategy2.getItemMainAxisSize()))) - fCalculateCurrentScrollOffset;
                                Keyline keylineBefore = keylineListForScrollOffset$material3_release$default.getKeylineBefore(itemMainAxisSize2);
                                Keyline keylineAfter = keylineListForScrollOffset$material3_release$default.getKeylineAfter(itemMainAxisSize2);
                                Keyline keylineLerp = KeylineListKt.lerp(keylineBefore, keylineAfter, CarouselKt.getProgress(keylineBefore, keylineAfter, itemMainAxisSize2));
                                boolean zB = kotlin.jvm.internal.k.b(keylineBefore, keylineAfter);
                                float fM3961getHeightimpl = (z12 ? Size.m3961getHeightimpl(graphicsLayerScope.getSize()) : strategy2.getItemMainAxisSize()) / 2.0f;
                                float itemMainAxisSize3 = (z12 ? strategy2.getItemMainAxisSize() : Size.m3961getHeightimpl(graphicsLayerScope.getSize())) / 2.0f;
                                float fM3964getWidthimpl = (z12 ? Size.m3964getWidthimpl(graphicsLayerScope.getSize()) : keylineLerp.getSize()) / 2.0f;
                                float size = (z12 ? keylineLerp.getSize() : Size.m3961getHeightimpl(graphicsLayerScope.getSize())) / 2.0f;
                                Rect rect = new Rect(fM3961getHeightimpl - fM3964getWidthimpl, itemMainAxisSize3 - size, fM3961getHeightimpl + fM3964getWidthimpl, itemMainAxisSize3 + size);
                                carouselItemInfoImpl3.setSizeState(keylineLerp.getSize());
                                CarouselItemInfoImpl carouselItemInfoImpl4 = carouselItemInfoImpl3;
                                Iterator<Keyline> it = keylineListForScrollOffset$material3_release.iterator();
                                if (!it.hasNext()) {
                                    throw new NoSuchElementException();
                                }
                                Keyline next = it.next();
                                if (it.hasNext()) {
                                    float size2 = next.getSize();
                                    do {
                                        Keyline next2 = it.next();
                                        float size3 = next2.getSize();
                                        if (Float.compare(size2, size3) > 0) {
                                            next = next2;
                                            size2 = size3;
                                        }
                                    } while (it.hasNext());
                                }
                                carouselItemInfoImpl4.setMinSizeState(next.getSize());
                                carouselItemInfoImpl3.setMaxSizeState(keylineListForScrollOffset$material3_release.getFirstFocal().getSize());
                                carouselItemInfoImpl3.setMaskRectState(rect);
                                graphicsLayerScope.setClip(!rect.equals(new Rect(0.0f, 0.0f, Size.m3964getWidthimpl(graphicsLayerScope.getSize()), Size.m3961getHeightimpl(graphicsLayerScope.getSize()))));
                                graphicsLayerScope.setShape(shape3);
                                float offset = keylineLerp.getOffset() - itemMainAxisSize2;
                                if (zB) {
                                    offset += (itemMainAxisSize2 - keylineLerp.getUnadjustedOffset()) / keylineLerp.getSize();
                                }
                                if (z12) {
                                    graphicsLayerScope.setTranslationY(offset);
                                    return;
                                }
                                if (z13) {
                                    offset = -offset;
                                }
                                graphicsLayerScope.setTranslationX(offset);
                            }
                        }, 4, (Object) null);
                    }
                }, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getProgress(Keyline keyline, Keyline keyline2, float f) {
        if (kotlin.jvm.internal.k.b(keyline, keyline2)) {
            return 1.0f;
        }
        return (f - keyline.getUnadjustedOffset()) / (keyline2.getUnadjustedOffset() - keyline.getUnadjustedOffset());
    }
}
