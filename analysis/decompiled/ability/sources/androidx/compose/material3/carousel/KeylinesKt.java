package androidx.compose.material3.carousel;

import C7.r;
import D7.q;
import S7.k;
import androidx.compose.ui.unit.Density;
import g1.AbstractC1451a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001aD\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u0001H\u0000\u001a(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000¨\u0006\u0017"}, d2 = {"calculateMediumChildSize", "", "minimumMediumSize", "largeItemSize", "remainingSpace", "createLeftAlignedKeylineList", "Landroidx/compose/material3/carousel/KeylineList;", "carouselMainAxisSize", "itemSpacing", "leftAnchorSize", "rightAnchorSize", "arrangement", "Landroidx/compose/material3/carousel/Arrangement;", "multiBrowseKeylineList", "density", "Landroidx/compose/ui/unit/Density;", "preferredItemSize", "itemCount", "", "minSmallItemSize", "maxSmallItemSize", "uncontainedKeylineList", "itemSize", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeylinesKt {
    private static final float calculateMediumChildSize(float f, float f7, float f9) {
        float fMax = Math.max(1.5f * f9, f);
        float f10 = f7 * 0.85f;
        return fMax > f10 ? Math.max(f10, f9 * 1.2f) : fMax;
    }

    public static final KeylineList createLeftAlignedKeylineList(float f, float f7, final float f9, final float f10, final Arrangement arrangement) {
        return KeylineListKt.m2661keylineListOfWNYm7Xg(f, f7, CarouselAlignment.INSTANCE.m2652getStartNUL3oTo(), new k() { // from class: androidx.compose.material3.carousel.KeylinesKt.createLeftAlignedKeylineList.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((KeylineListScope) obj);
                return r.f317a;
            }

            public final void invoke(KeylineListScope keylineListScope) {
                keylineListScope.add(f9, true);
                int largeCount = arrangement.getLargeCount();
                Arrangement arrangement2 = arrangement;
                for (int i = 0; i < largeCount; i++) {
                    KeylineListScope.add$default(keylineListScope, arrangement2.getLargeSize(), false, 2, null);
                }
                int mediumCount = arrangement.getMediumCount();
                Arrangement arrangement3 = arrangement;
                for (int i6 = 0; i6 < mediumCount; i6++) {
                    KeylineListScope.add$default(keylineListScope, arrangement3.getMediumSize(), false, 2, null);
                }
                int smallCount = arrangement.getSmallCount();
                Arrangement arrangement4 = arrangement;
                for (int i10 = 0; i10 < smallCount; i10++) {
                    KeylineListScope.add$default(keylineListScope, arrangement4.getSmallSize(), false, 2, null);
                }
                keylineListScope.add(f10, true);
            }
        });
    }

    public static final KeylineList multiBrowseKeylineList(Density density, float f, float f7, float f9, int i, float f10, float f11) {
        float f12;
        if (f == 0.0f || f7 == 0.0f) {
            return KeylineListKt.emptyKeylineList();
        }
        int[] iArr = {1};
        int[] iArr2 = {1, 0};
        float fMin = Math.min(f7, f);
        float fT = AbstractC1451a.t(fMin / 3.0f, f10, f11);
        float f13 = (fMin + fT) / 2.0f;
        if (f < 2 * f10) {
            iArr = new int[]{0};
        }
        int[] iArr3 = iArr;
        int iCeil = (int) Math.ceil(f / fMin);
        int iMax = (iCeil - Math.max(1, (int) Math.floor(((f - (q.z0(iArr2) * f13)) - (q.z0(iArr3) * f11)) / fMin))) + 1;
        int[] iArr4 = new int[iMax];
        for (int i6 = 0; i6 < iMax; i6++) {
            iArr4[i6] = iCeil - i6;
        }
        float fMo381toPx0680j_4 = density.mo381toPx0680j_4(CarouselDefaults.INSTANCE.m2653getAnchorSizeD9Ej5fM$material3_release());
        Arrangement arrangementFindLowestCostArrangement = Arrangement.INSTANCE.findLowestCostArrangement(f, f9, fT, f10, f11, iArr3, f13, iArr2, fMin, iArr4);
        if (arrangementFindLowestCostArrangement == null || arrangementFindLowestCostArrangement.itemCount() <= i) {
            f12 = f;
        } else {
            int smallCount = arrangementFindLowestCostArrangement.getSmallCount();
            int mediumCount = arrangementFindLowestCostArrangement.getMediumCount();
            for (int iItemCount = arrangementFindLowestCostArrangement.itemCount() - i; iItemCount > 0; iItemCount--) {
                if (smallCount > 0) {
                    smallCount--;
                } else if (mediumCount > 1) {
                    mediumCount--;
                }
            }
            f12 = f;
            arrangementFindLowestCostArrangement = Arrangement.INSTANCE.findLowestCostArrangement(f12, f9, fT, f10, f11, new int[]{smallCount}, f13, new int[]{mediumCount}, fMin, iArr4);
        }
        return arrangementFindLowestCostArrangement == null ? KeylineListKt.emptyKeylineList() : createLeftAlignedKeylineList(f12, f9, fMo381toPx0680j_4, fMo381toPx0680j_4, arrangementFindLowestCostArrangement);
    }

    public static /* synthetic */ KeylineList multiBrowseKeylineList$default(Density density, float f, float f7, float f9, int i, float f10, float f11, int i6, Object obj) {
        if ((i6 & 32) != 0) {
            f10 = density.mo381toPx0680j_4(CarouselDefaults.INSTANCE.m2655getMinSmallItemSizeD9Ej5fM$material3_release());
        }
        float f12 = f10;
        if ((i6 & 64) != 0) {
            f11 = density.mo381toPx0680j_4(CarouselDefaults.INSTANCE.m2654getMaxSmallItemSizeD9Ej5fM$material3_release());
        }
        return multiBrowseKeylineList(density, f, f7, f9, i, f12, f11);
    }

    public static final KeylineList uncontainedKeylineList(Density density, float f, float f7, float f9) {
        if (f == 0.0f || f7 == 0.0f) {
            return KeylineListKt.emptyKeylineList();
        }
        float fMin = Math.min(f7 + f9, f);
        int iMax = Math.max(1, (int) Math.floor(f / fMin));
        float f10 = f - (iMax * fMin);
        int i = f10 <= 0.0f ? 0 : 1;
        float fMo381toPx0680j_4 = density.mo381toPx0680j_4(CarouselDefaults.INSTANCE.m2653getAnchorSizeD9Ej5fM$material3_release());
        float fCalculateMediumChildSize = calculateMediumChildSize(fMo381toPx0680j_4, fMin, f10);
        return createLeftAlignedKeylineList(f, f9, Math.max(Math.min(fMo381toPx0680j_4, f7), fCalculateMediumChildSize * 0.5f), fMo381toPx0680j_4, new Arrangement(0, 0.0f, 0, fCalculateMediumChildSize, i, fMin, iMax));
    }
}
