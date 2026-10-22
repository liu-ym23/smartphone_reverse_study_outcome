package androidx.compose.material3.internal;

import C7.r;
import H4.o;
import S7.n;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Immutable
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ2\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u001a\u001a\u00020\u0002HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0003¢\u0006\u0004\b\u001f\u0010 JM\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b'\u0010\u001eJ\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b+\u0010,R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010/\u001a\u0004\b0\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00101\u001a\u0004\b2\u0010\u001eR)\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006¢\u0006\f\n\u0004\b\u000b\u00103\u001a\u0004\b4\u0010 R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00107R\u0014\u00109\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010:\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00107R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010=R\u0014\u0010?\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010=R\u0014\u0010@\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010=R\u0014\u0010A\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010=\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/material3/internal/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "Landroidx/compose/ui/unit/DpOffset;", "contentOffset", "Landroidx/compose/ui/unit/Density;", "density", "", "verticalMargin", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "LC7/r;", "onPositionCalculated", AppAgent.CONSTRUCT, "(JLandroidx/compose/ui/unit/Density;ILS7/n;Lkotlin/jvm/internal/e;)V", "anchorBounds", "Landroidx/compose/ui/unit/IntSize;", "windowSize", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "popupContentSize", "Landroidx/compose/ui/unit/IntOffset;", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "calculatePosition", "component1-RKDOV3M", "()J", "component1", "component2", "()Landroidx/compose/ui/unit/Density;", "component3", "()I", "component4", "()LS7/n;", "copy-uVxBXkw", "(JLandroidx/compose/ui/unit/Density;ILS7/n;)Landroidx/compose/material3/internal/DropdownMenuPositionProvider;", "copy", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getContentOffset-RKDOV3M", "Landroidx/compose/ui/unit/Density;", "getDensity", "I", "getVerticalMargin", "LS7/n;", "getOnPositionCalculated", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "startToAnchorStart", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "endToAnchorEnd", "leftToWindowLeft", "rightToWindowRight", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "topToAnchorBottom", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToAnchorTop", "centerToAnchorTop", "topToWindowTop", "bottomToWindowBottom", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DropdownMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final MenuPosition.Vertical bottomToAnchorTop;
    private final MenuPosition.Vertical bottomToWindowBottom;
    private final MenuPosition.Vertical centerToAnchorTop;
    private final long contentOffset;
    private final Density density;
    private final MenuPosition.Horizontal endToAnchorEnd;
    private final MenuPosition.Horizontal leftToWindowLeft;
    private final n onPositionCalculated;
    private final MenuPosition.Horizontal rightToWindowRight;
    private final MenuPosition.Horizontal startToAnchorStart;
    private final MenuPosition.Vertical topToAnchorBottom;
    private final MenuPosition.Vertical topToWindowTop;
    private final int verticalMargin;

    public /* synthetic */ DropdownMenuPositionProvider(long j5, Density density, int i, n nVar, e eVar) {
        this(j5, density, i, nVar);
    }

    /* renamed from: copy-uVxBXkw$default, reason: not valid java name */
    public static /* synthetic */ DropdownMenuPositionProvider m2674copyuVxBXkw$default(DropdownMenuPositionProvider dropdownMenuPositionProvider, long j5, Density density, int i, n nVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            j5 = dropdownMenuPositionProvider.contentOffset;
        }
        long j6 = j5;
        if ((i6 & 2) != 0) {
            density = dropdownMenuPositionProvider.density;
        }
        Density density2 = density;
        if ((i6 & 4) != 0) {
            i = dropdownMenuPositionProvider.verticalMargin;
        }
        int i10 = i;
        if ((i6 & 8) != 0) {
            nVar = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.m2676copyuVxBXkw(j6, density2, i10, nVar);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4 */
    public long mo352calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        int iMo2666position95KtPRI;
        int i = 0;
        List listN = o.N(this.startToAnchorStart, this.endToAnchorEnd, IntOffset.m6972getXimpl(anchorBounds.m6996getCenternOccac()) < IntSize.m7015getWidthimpl(windowSize) / 2 ? this.leftToWindowLeft : this.rightToWindowRight);
        int size = listN.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                iMo2666position95KtPRI = 0;
                break;
            }
            iMo2666position95KtPRI = ((MenuPosition.Horizontal) listN.get(i6)).mo2666position95KtPRI(anchorBounds, windowSize, IntSize.m7015getWidthimpl(popupContentSize), layoutDirection);
            if (i6 == o.H(listN) || (iMo2666position95KtPRI >= 0 && IntSize.m7015getWidthimpl(popupContentSize) + iMo2666position95KtPRI <= IntSize.m7015getWidthimpl(windowSize))) {
                break;
            }
            i6++;
        }
        List listN2 = o.N(this.topToAnchorBottom, this.bottomToAnchorTop, this.centerToAnchorTop, IntOffset.m6973getYimpl(anchorBounds.m6996getCenternOccac()) < IntSize.m7014getHeightimpl(windowSize) / 2 ? this.topToWindowTop : this.bottomToWindowBottom);
        int size2 = listN2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            int iMo2667positionJVtK1S4 = ((MenuPosition.Vertical) listN2.get(i10)).mo2667positionJVtK1S4(anchorBounds, windowSize, IntSize.m7014getHeightimpl(popupContentSize));
            if (i10 == o.H(listN2) || (iMo2667positionJVtK1S4 >= this.verticalMargin && IntSize.m7014getHeightimpl(popupContentSize) + iMo2667positionJVtK1S4 <= IntSize.m7014getHeightimpl(windowSize) - this.verticalMargin)) {
                i = iMo2667positionJVtK1S4;
                break;
            }
        }
        long jIntOffset = IntOffsetKt.IntOffset(iMo2666position95KtPRI, i);
        this.onPositionCalculated.invoke(anchorBounds, IntRectKt.m7005IntRectVbeCjmY(jIntOffset, popupContentSize));
        return jIntOffset;
    }

    /* renamed from: component1-RKDOV3M, reason: not valid java name and from getter */
    public final long getContentOffset() {
        return this.contentOffset;
    }

    /* renamed from: component2, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    /* renamed from: component3, reason: from getter */
    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    /* renamed from: component4, reason: from getter */
    public final n getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    /* renamed from: copy-uVxBXkw, reason: not valid java name */
    public final DropdownMenuPositionProvider m2676copyuVxBXkw(long contentOffset, Density density, int verticalMargin, n onPositionCalculated) {
        return new DropdownMenuPositionProvider(contentOffset, density, verticalMargin, onPositionCalculated, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) other;
        return DpOffset.m6904equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && k.b(this.density, dropdownMenuPositionProvider.density) && this.verticalMargin == dropdownMenuPositionProvider.verticalMargin && k.b(this.onPositionCalculated, dropdownMenuPositionProvider.onPositionCalculated);
    }

    /* renamed from: getContentOffset-RKDOV3M, reason: not valid java name */
    public final long m2677getContentOffsetRKDOV3M() {
        return this.contentOffset;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final n getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    public int hashCode() {
        return this.onPositionCalculated.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.verticalMargin, (this.density.hashCode() + (DpOffset.m6909hashCodeimpl(this.contentOffset) * 31)) * 31, 31);
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.m6912toStringimpl(this.contentOffset)) + ", density=" + this.density + ", verticalMargin=" + this.verticalMargin + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }

    private DropdownMenuPositionProvider(long j5, Density density, int i, n nVar) {
        this.contentOffset = j5;
        this.density = density;
        this.verticalMargin = i;
        this.onPositionCalculated = nVar;
        int iMo375roundToPx0680j_4 = density.mo375roundToPx0680j_4(DpOffset.m6905getXD9Ej5fM(j5));
        MenuPosition menuPosition = MenuPosition.INSTANCE;
        this.startToAnchorStart = menuPosition.startToAnchorStart(iMo375roundToPx0680j_4);
        this.endToAnchorEnd = menuPosition.endToAnchorEnd(iMo375roundToPx0680j_4);
        this.leftToWindowLeft = menuPosition.leftToWindowLeft(0);
        this.rightToWindowRight = menuPosition.rightToWindowRight(0);
        int iMo375roundToPx0680j_42 = density.mo375roundToPx0680j_4(DpOffset.m6907getYD9Ej5fM(j5));
        this.topToAnchorBottom = menuPosition.topToAnchorBottom(iMo375roundToPx0680j_42);
        this.bottomToAnchorTop = menuPosition.bottomToAnchorTop(iMo375roundToPx0680j_42);
        this.centerToAnchorTop = menuPosition.centerToAnchorTop(iMo375roundToPx0680j_42);
        this.topToWindowTop = menuPosition.topToWindowTop(i);
        this.bottomToWindowBottom = menuPosition.bottomToWindowBottom(i);
    }

    public /* synthetic */ DropdownMenuPositionProvider(long j5, Density density, int i, n nVar, int i6, e eVar) {
        this(j5, density, (i6 & 4) != 0 ? density.mo375roundToPx0680j_4(MenuKt.getMenuVerticalMargin()) : i, (i6 & 8) != 0 ? new n() { // from class: androidx.compose.material3.internal.DropdownMenuPositionProvider.2
            public final void invoke(IntRect intRect, IntRect intRect2) {
            }

            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((IntRect) obj, (IntRect) obj2);
                return r.f317a;
            }
        } : nVar, null);
    }
}
