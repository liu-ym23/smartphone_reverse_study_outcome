package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\b\u001a\u0019\u0010\u0016\u001a\u00020\u0003*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0003*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0017\u0010\u001b\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a#\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a7\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {GXTemplateKey.FLEXBOX_PADDING, "Landroidx/compose/ui/Modifier;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "padding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "horizontal", "vertical", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "all", "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", "left", "right", "absolutePadding-qDBjuR0", "calculateStartPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateEndPadding", "PaddingValues", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PaddingKt {
    public static /* synthetic */ Unit a(float r100, float r101, float r102, float r103, InspectorInfo r104) {
        return absolutePadding_qDBjuR0$lambda$4(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit b(float r100, InspectorInfo r101) {
        return padding_3ABfNKs$lambda$2(r100, r101);
    }

    public static /* synthetic */ Unit c(float r100, float r101, InspectorInfo r102) {
        return padding_VpY3zN4$lambda$1(r100, r101, r102);
    }

    public static /* synthetic */ Unit d(float r100, float r101, float r102, float r103, InspectorInfo r104) {
        return padding_qDBjuR0$lambda$0(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit e(PaddingValues r100, InspectorInfo r101) {
        return padding$lambda$3(r100, r101);
    }

    /* JADX INFO: renamed from: PaddingValues-0680j_4, reason: not valid java name */
    public static final PaddingValues m724PaddingValues0680j_4(float r100) {
        return new PaddingValuesImpl(r100, r100, r100, r100, null);
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA, reason: not valid java name */
    public static final PaddingValues m725PaddingValuesYgX7TsA(float r100, float r101) {
        return new PaddingValuesImpl(r100, r101, r100, r101, null);
    }

    public static final float calculateEndPadding(PaddingValues r100, LayoutDirection r101) {
        if (r101 != LayoutDirection.Ltr) goto L6;
        return r100.mo682calculateRightPaddingu2uoSUM(r101);
    L6:
        return r100.mo681calculateLeftPaddingu2uoSUM(r101);
    }

    public static final float calculateStartPadding(PaddingValues r100, LayoutDirection r101) {
        if (r101 != LayoutDirection.Ltr) goto L6;
        return r100.mo681calculateLeftPaddingu2uoSUM(r101);
    L6:
        return r100.mo682calculateRightPaddingu2uoSUM(r101);
    }

    public static final Modifier padding(Modifier r100, final PaddingValues r101) {
        return r100.then(new PaddingValuesElement(r101, new q1(r101)));
    }

    private static final Unit padding$lambda$3(PaddingValues r100, InspectorInfo r101) {
        r101.setName(GXTemplateKey.FLEXBOX_PADDING);
        r101.getProperties().set("paddingValues", r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m731padding3ABfNKs(Modifier r100, final float r110) {
        return r100.then(new PaddingElement(r110, r110, r110, r110, true, new o1(r110), null));
    }

    private static final Unit padding_3ABfNKs$lambda$2(float r100, InspectorInfo r101) {
        r101.setName(GXTemplateKey.FLEXBOX_PADDING);
        r101.setValue(Dp.m7542boximpl(r100));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m732paddingVpY3zN4(Modifier r100, final float r110, final float r111) {
        return r100.then(new PaddingElement(r110, r111, r110, r111, true, new p1(r110, r111), null));
    }

    private static final Unit padding_VpY3zN4$lambda$1(float r100, float r101, InspectorInfo r102) {
        r102.setName(GXTemplateKey.FLEXBOX_PADDING);
        r102.getProperties().set("horizontal", Dp.m7542boximpl(r100));
        r102.getProperties().set("vertical", Dp.m7542boximpl(r101));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m726PaddingValuesYgX7TsA$default(float r100, float r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = Dp.m7544constructorimpl(0);
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = Dp.m7544constructorimpl(0);
    L9:
        return m725PaddingValuesYgX7TsA(r100, r101);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4, reason: not valid java name */
    public static final PaddingValues m727PaddingValuesa9UjIt4(float r100, float r101, float r102, float r110) {
        return new PaddingValuesImpl(r100, r101, r102, r110, null);
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0, reason: not valid java name */
    public static final Modifier m729absolutePaddingqDBjuR0(Modifier r100, final float r110, final float r111, final float r112, final float r113) {
        return r100.then(new PaddingElement(r110, r111, r112, r113, false, new r1(r110, r111, r112, r113), null));
    }

    private static final Unit absolutePadding_qDBjuR0$lambda$4(float r100, float r101, float r102, float r103, InspectorInfo r104) {
        r104.setName("absolutePadding");
        r104.getProperties().set("left", Dp.m7542boximpl(r100));
        r104.getProperties().set("top", Dp.m7542boximpl(r101));
        r104.getProperties().set("right", Dp.m7542boximpl(r102));
        r104.getProperties().set("bottom", Dp.m7542boximpl(r103));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m733paddingVpY3zN4$default(Modifier r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = Dp.m7544constructorimpl(0);
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = Dp.m7544constructorimpl(0);
    L9:
        return m732paddingVpY3zN4(r100, r101, r102);
    }

    /* JADX INFO: renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m734paddingqDBjuR0(Modifier r100, final float r110, final float r111, final float r112, final float r113) {
        return r100.then(new PaddingElement(r110, r111, r112, r113, true, new n1(r110, r111, r112, r113), null));
    }

    private static final Unit padding_qDBjuR0$lambda$0(float r100, float r101, float r102, float r103, InspectorInfo r104) {
        r104.setName(GXTemplateKey.FLEXBOX_PADDING);
        r104.getProperties().set("start", Dp.m7542boximpl(r100));
        r104.getProperties().set("top", Dp.m7542boximpl(r101));
        r104.getProperties().set("end", Dp.m7542boximpl(r102));
        r104.getProperties().set("bottom", Dp.m7542boximpl(r103));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m728PaddingValuesa9UjIt4$default(float r100, float r101, float r102, float r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = Dp.m7544constructorimpl(0);
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = Dp.m7544constructorimpl(0);
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = Dp.m7544constructorimpl(0);
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = Dp.m7544constructorimpl(0);
    L15:
        return m727PaddingValuesa9UjIt4(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m730absolutePaddingqDBjuR0$default(Modifier r100, float r101, float r102, float r103, float r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = Dp.m7544constructorimpl(0);
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = Dp.m7544constructorimpl(0);
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = Dp.m7544constructorimpl(0);
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = Dp.m7544constructorimpl(0);
    L15:
        return m729absolutePaddingqDBjuR0(r100, r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m735paddingqDBjuR0$default(Modifier r100, float r101, float r102, float r103, float r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = Dp.m7544constructorimpl(0);
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = Dp.m7544constructorimpl(0);
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = Dp.m7544constructorimpl(0);
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = Dp.m7544constructorimpl(0);
    L15:
        return m734paddingqDBjuR0(r100, r101, r102, r103, r104);
    }
}
