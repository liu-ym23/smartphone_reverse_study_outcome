package androidx.compose.material3.carousel;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aD\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0000\u001a(\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000\u001aU\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010\u0012\u001a0\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a0\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u001a \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002¨\u0006\u001d"}, d2 = {"multiBrowseKeylineList", "Landroidx/compose/material3/carousel/KeylineList;", "density", "Landroidx/compose/ui/unit/Density;", "carouselMainAxisSize", "", "preferredItemSize", "itemSpacing", "itemCount", "", "minSmallItemSize", "maxSmallItemSize", "uncontainedKeylineList", "itemSize", "heroKeylineList", "maxItemSize", "isCentered", "", "(Landroidx/compose/ui/unit/Density;FLjava/lang/Float;FIZFF)Landroidx/compose/material3/carousel/KeylineList;", "createLeftAlignedKeylineList", "leftAnchorSize", "rightAnchorSize", "arrangement", "Landroidx/compose/material3/carousel/Arrangement;", "createCenterAlignedKeylineList", "calculateMediumChildSize", "minimumMediumSize", "largeItemSize", "remainingSpace", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KeylinesKt {
    public static /* synthetic */ Unit a(float r100, Arrangement r101, float r102, KeylineListScope r103) {
        return createLeftAlignedKeylineList$lambda$10(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit b(float r100, Arrangement r101, float r102, KeylineListScope r103) {
        return createCenterAlignedKeylineList$lambda$16(r100, r101, r102, r103);
    }

    private static final float calculateMediumChildSize(float r100, float r101, float r102) {
        float r103 = Math.max(1.5f * r102, r100);
        float r104 = 0.85f * r101;
        if (r103 > r104) goto L5;
        return r103;
    L5:
        return Math.min(Math.max(r104, r102 * 1.2f), r101);
    }

    private static final Unit createCenterAlignedKeylineList$lambda$16(float r100, Arrangement r101, float r102, KeylineListScope r103) {
        r103.add(r100, true);
        int r104 = r101.getSmallCount() / 2;
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L6;
        KeylineListScope.CC.add$default(r103, r101.getSmallSize(), false, 2, null);
        r105 = r105 + 1;
        goto L4
    L6:
        int r106 = r101.getMediumCount() / 2;
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L9;
        KeylineListScope.CC.add$default(r103, r101.getMediumSize(), false, 2, null);
        r107 = r107 + 1;
        goto L7
    L9:
        int r108 = r101.getLargeCount();
        int r109 = 0;
    L10:
        if (r109 >= r108) goto L12;
        KeylineListScope.CC.add$default(r103, r101.getLargeSize(), false, 2, null);
        r109 = r109 + 1;
        goto L10
    L12:
        int r110 = r101.getMediumCount() / 2;
        int r111 = 0;
    L13:
        if (r111 >= r110) goto L15;
        KeylineListScope.CC.add$default(r103, r101.getMediumSize(), false, 2, null);
        r111 = r111 + 1;
        goto L13
    L15:
        int r112 = r101.getSmallCount() / 2;
        int r113 = 0;
    L16:
        if (r113 >= r112) goto L18;
        KeylineListScope.CC.add$default(r103, r101.getSmallSize(), false, 2, null);
        r113 = r113 + 1;
        goto L16
    L18:
        r103.add(r102, true);
        return Unit.INSTANCE;
    }

    private static final Unit createLeftAlignedKeylineList$lambda$10(float r100, Arrangement r101, float r102, KeylineListScope r103) {
        r103.add(r100, true);
        int r104 = r101.getLargeCount();
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L6;
        KeylineListScope.CC.add$default(r103, r101.getLargeSize(), false, 2, null);
        r105 = r105 + 1;
        goto L4
    L6:
        int r106 = r101.getMediumCount();
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L9;
        KeylineListScope.CC.add$default(r103, r101.getMediumSize(), false, 2, null);
        r107 = r107 + 1;
        goto L7
    L9:
        int r108 = r101.getSmallCount();
        int r109 = 0;
    L10:
        if (r109 >= r108) goto L12;
        KeylineListScope.CC.add$default(r103, r101.getSmallSize(), false, 2, null);
        r109 = r109 + 1;
        goto L10
    L12:
        r103.add(r102, true);
        return Unit.INSTANCE;
    }

    public static final KeylineList uncontainedKeylineList(Density r110, float r111, float r112, float r113) {
        if (r111 != 0.0f) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L20;
        if (r112 != 0.0f) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == true) goto L20;
        float r114 = Math.min(r112 + r113, r111);
        int r115 = Math.max(1, (int) Math.floor(r111 / r114));
        float r102 = r111 - (r115 * r114);
        if (r102 <= 0.0f) goto L16;
        int r103 = 1;
    L17:
        float r116 = r110.mo371toPx0680j_4(CarouselDefaults.INSTANCE.m3106getAnchorSizeD9Ej5fM$material3());
        float r104 = calculateMediumChildSize(r116, r114, r102);
        return createLeftAlignedKeylineList(r111, r113, Math.max(Math.min(r116, r112), r104 * 0.5f), r116, new Arrangement(0, 0.0f, 0, r104, r103, r114, r115));
    L16:
        r103 = 0;
        goto L17
    L10:
        r101 = false;
    L20:
        return KeylineListKt.emptyKeylineList();
    L5:
        r100 = false;
        goto L6
    }

    public static final KeylineList createCenterAlignedKeylineList(float r100, float r101, final float r102, final float r103, final Arrangement r104) {
        return KeylineListKt.m3119keylineListOfWNYm7Xg(r100, r101, CarouselAlignment.Companion.m3103getCenterNUL3oTo(), new c0(r102, r104, r103));
    }

    public static final KeylineList createLeftAlignedKeylineList(float r100, float r101, final float r102, final float r103, final Arrangement r104) {
        return KeylineListKt.m3119keylineListOfWNYm7Xg(r100, r101, CarouselAlignment.Companion.m3105getStartNUL3oTo(), new d0(r102, r104, r103));
    }

    public static final KeylineList multiBrowseKeylineList(Density r210, float r211, float r212, float r213, int r214, float r215, float r216) {
        if (r211 != 0.0f) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L38;
        if (r212 != 0.0f) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == true) goto L38;
        int[] r102 = {1};
        int[] r103 = {1, 0};
        float r110 = Math.min(r212, r211);
        float r111 = RangesKt.coerceIn(r110 / 3.0f, r215, r216);
        float r112 = (r110 + r111) / 2.0f;
        if (r211 >= (2 * r215)) goto L16;
        int[] r104 = {0};
    L17:
        int r105 = Math.max(1, (int) Math.floor(((r211 - (ArraysKt.maxOrThrow(r103) * r112)) - (ArraysKt.maxOrThrow(r104) * r216)) / r110));
        int r106 = (int) Math.ceil(r211 / r110);
        int r107 = (r106 - r105) + 1;
        int[] r108 = new int[r107];
        int r109 = 0;
    L18:
        if (r109 >= r107) goto L20;
        r108[r109] = r106 - r109;
        r109 = r109 + 1;
        goto L18
    L20:
        float r113 = r210.mo371toPx0680j_4(CarouselDefaults.INSTANCE.m3106getAnchorSizeD9Ej5fM$material3());
        Arrangement r114 = Arrangement.Companion.findLowestCostArrangement(r211, r213, r111, r215, r216, r104, r112, r103, r110, r108);
        if (r114 != null) goto L23;
    L32:
        if (r114 != null) goto L36;
        return KeylineListKt.emptyKeylineList();
    L36:
        return createLeftAlignedKeylineList(r211, r213, r113, r113, r114);
    L23:
        if (r114.itemCount() <= r214) goto L32;
        int r115 = r114.itemCount() - r214;
        int r116 = r114.getSmallCount();
        int r117 = r114.getMediumCount();
    L25:
        if (r115 <= 0) goto L31;
        if (r116 <= 0) goto L28;
        r116 = r116 - 1;
    L30:
        r115 = r115 - 1;
        goto L25
    L28:
        if (r117 <= 1) goto L30;
        r117 = r117 - 1;
        goto L30
    L31:
        r114 = Arrangement.Companion.findLowestCostArrangement(r211, r213, r111, r215, r216, new int[]{r116}, r112, new int[]{r117}, r110, r108);
        goto L32
    L16:
        r104 = r102;
        goto L17
    L10:
        r101 = false;
    L38:
        return KeylineListKt.emptyKeylineList();
    L5:
        r100 = false;
        goto L6
    }

    public static final KeylineList heroKeylineList(Density r110, float r111, Float r112, float r113, int r210, boolean r211, float r212, float r213) {
        if (r111 != 0.0f) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        if (r211 == true) goto L11;
    L13:
        boolean r114 = false;
    L14:
        int[] r101 = new int[1];
        if (r114 == false) goto L17;
        r101[0] = 2;
    L18:
        if (r112 == null) goto L20;
        float r102 = r112.floatValue();
    L21:
        float r103 = Math.min(r102, r111);
        float r104 = RangesKt.coerceIn(r103 / 3.0f, r212, r213);
        if (r111 >= ((ArraysKt.maxOrThrow(r101) * r212) + (1.25f * r212))) goto L24;
        r101 = new int[]{0};
    L24:
        int[] r105 = r101;
        int r106 = Math.max(1, (int) Math.floor((r111 - (ArraysKt.maxOrThrow(r105) * r212)) / r103));
        int r107 = (int) Math.ceil(r111 / r103);
        int r108 = (r107 - r106) + 1;
        int[] r115 = new int[r108];
        int r109 = 0;
    L25:
        if (r109 >= r108) goto L27;
        r115[r109] = r107 - r109;
        r109 = r109 + 1;
        goto L25
    L27:
        float r116 = r110.mo371toPx0680j_4(CarouselDefaults.INSTANCE.m3106getAnchorSizeD9Ej5fM$material3());
        Arrangement r117 = Arrangement.Companion.findLowestCostArrangement(r111, r113, r104, r212, r213, r105, 0.0f, new int[]{0}, r103, r115);
        if (r117 == null) goto L30;
        if (r114 == false) goto L37;
        if (r210 < r117.itemCount()) goto L37;
        return createCenterAlignedKeylineList(r111, r113, r116, r116, r117);
    L37:
        return createLeftAlignedKeylineList(r111, r113, r116, r116, r117);
    L30:
        return KeylineListKt.emptyKeylineList();
    L20:
        r102 = r111;
        goto L21
    L17:
        r101[0] = 1;
        goto L18
    L11:
        if (r210 < 3) goto L13;
        r114 = true;
        goto L14
    L8:
        return KeylineListKt.emptyKeylineList();
    L5:
        r100 = false;
        goto L6
    }

    public static /* synthetic */ KeylineList multiBrowseKeylineList$default(Density r100, float r101, float r102, float r110, int r111, float r112, float r113, int r114, Object r115) {
        if ((r114 & 32) == 0) goto L5;
        r112 = r100.mo371toPx0680j_4(CarouselDefaults.INSTANCE.m3108getMinSmallItemSizeD9Ej5fM());
    L5:
        float r103 = r112;
        if ((r114 & 64) == 0) goto L9;
        r113 = r100.mo371toPx0680j_4(CarouselDefaults.INSTANCE.m3107getMaxSmallItemSizeD9Ej5fM());
    L9:
        return multiBrowseKeylineList(r100, r101, r102, r110, r111, r103, r113);
    }

    public static /* synthetic */ KeylineList heroKeylineList$default(Density r100, float r101, Float r110, float r111, int r112, boolean r113, float r114, float r115, int r116, Object r117) {
        if ((r116 & 32) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r116 & 64) == 0) goto L9;
        float r103 = r100.mo371toPx0680j_4(CarouselDefaults.INSTANCE.m3108getMinSmallItemSizeD9Ej5fM());
    L11:
        if ((r116 & 128) == 0) goto L13;
        float r104 = r100.mo371toPx0680j_4(CarouselDefaults.INSTANCE.m3107getMaxSmallItemSizeD9Ej5fM());
    L15:
        return heroKeylineList(r100, r101, r110, r111, r112, r102, r103, r104);
    L13:
        r104 = r115;
        goto L15
    L9:
        r103 = r114;
        goto L11
    L5:
        r102 = r113;
        goto L7
    }
}
