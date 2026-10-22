package androidx.compose.material3;

import C7.r;
import H4.o;
import S7.n;
import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Stable
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0004\b\r\u0010\u000eJ2\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\"\u0010\u001eR)\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n8\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010.R\u0014\u00100\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010.R\u0014\u00101\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010.\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "Landroidx/compose/ui/unit/Density;", "density", "", "topWindowInsets", "Landroidx/compose/runtime/State;", "LC7/r;", "keyboardSignalState", "verticalMargin", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "onPositionCalculated", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/unit/Density;ILandroidx/compose/runtime/State;ILS7/n;)V", "anchorBounds", "Landroidx/compose/ui/unit/IntSize;", "windowSize", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "popupContentSize", "Landroidx/compose/ui/unit/IntOffset;", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "calculatePosition", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "I", "getTopWindowInsets", "()I", "Landroidx/compose/runtime/State;", "getKeyboardSignalState", "()Landroidx/compose/runtime/State;", "getVerticalMargin", "LS7/n;", "getOnPositionCalculated", "()LS7/n;", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "startToAnchorStart", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "endToAnchorEnd", "leftToWindowLeft", "rightToWindowRight", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "topToAnchorBottom", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToAnchorTop", "topToWindowTop", "bottomToWindowBottom", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExposedDropdownMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final MenuPosition.Vertical bottomToAnchorTop;
    private final MenuPosition.Vertical bottomToWindowBottom;
    private final Density density;
    private final MenuPosition.Horizontal endToAnchorEnd;
    private final State<r> keyboardSignalState;
    private final MenuPosition.Horizontal leftToWindowLeft;
    private final n onPositionCalculated;
    private final MenuPosition.Horizontal rightToWindowRight;
    private final MenuPosition.Horizontal startToAnchorStart;
    private final MenuPosition.Vertical topToAnchorBottom;
    private final MenuPosition.Vertical topToWindowTop;
    private final int topWindowInsets;
    private final int verticalMargin;

    public ExposedDropdownMenuPositionProvider(Density density, int i, State<r> state, int i6, n nVar) {
        this.density = density;
        this.topWindowInsets = i;
        this.keyboardSignalState = state;
        this.verticalMargin = i6;
        this.onPositionCalculated = nVar;
        MenuPosition menuPosition = MenuPosition.INSTANCE;
        this.startToAnchorStart = MenuPosition.startToAnchorStart$default(menuPosition, 0, 1, null);
        this.endToAnchorEnd = MenuPosition.endToAnchorEnd$default(menuPosition, 0, 1, null);
        this.leftToWindowLeft = MenuPosition.leftToWindowLeft$default(menuPosition, 0, 1, null);
        this.rightToWindowRight = MenuPosition.rightToWindowRight$default(menuPosition, 0, 1, null);
        this.topToAnchorBottom = MenuPosition.topToAnchorBottom$default(menuPosition, 0, 1, null);
        this.bottomToAnchorTop = MenuPosition.bottomToAnchorTop$default(menuPosition, 0, 1, null);
        this.topToWindowTop = menuPosition.topToWindowTop(i6);
        this.bottomToWindowBottom = menuPosition.bottomToWindowBottom(i6);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4 */
    public long mo352calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        int iMo2666position95KtPRI;
        State<r> state = this.keyboardSignalState;
        if (state != null) {
            state.getValue();
        }
        long jIntSize = IntSizeKt.IntSize(IntSize.m7015getWidthimpl(windowSize), IntSize.m7014getHeightimpl(windowSize) + this.topWindowInsets);
        int i = 0;
        List listN = o.N(this.startToAnchorStart, this.endToAnchorEnd, IntOffset.m6972getXimpl(anchorBounds.m6996getCenternOccac()) < IntSize.m7015getWidthimpl(jIntSize) / 2 ? this.leftToWindowLeft : this.rightToWindowRight);
        int size = listN.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                iMo2666position95KtPRI = 0;
                break;
            }
            iMo2666position95KtPRI = ((MenuPosition.Horizontal) listN.get(i6)).mo2666position95KtPRI(anchorBounds, jIntSize, IntSize.m7015getWidthimpl(popupContentSize), layoutDirection);
            if (i6 == o.H(listN) || (iMo2666position95KtPRI >= 0 && IntSize.m7015getWidthimpl(popupContentSize) + iMo2666position95KtPRI <= IntSize.m7015getWidthimpl(jIntSize))) {
                break;
            }
            i6++;
        }
        List listN2 = o.N(this.topToAnchorBottom, this.bottomToAnchorTop, IntOffset.m6973getYimpl(anchorBounds.m6996getCenternOccac()) < IntSize.m7014getHeightimpl(jIntSize) / 2 ? this.topToWindowTop : this.bottomToWindowBottom);
        int size2 = listN2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            int iMo2667positionJVtK1S4 = ((MenuPosition.Vertical) listN2.get(i10)).mo2667positionJVtK1S4(anchorBounds, jIntSize, IntSize.m7014getHeightimpl(popupContentSize));
            if (i10 == o.H(listN2) || (iMo2667positionJVtK1S4 >= 0 && IntSize.m7014getHeightimpl(popupContentSize) + iMo2667positionJVtK1S4 <= IntSize.m7014getHeightimpl(jIntSize))) {
                i = iMo2667positionJVtK1S4;
                break;
            }
        }
        long jIntOffset = IntOffsetKt.IntOffset(iMo2666position95KtPRI, i);
        this.onPositionCalculated.invoke(anchorBounds, IntRectKt.m7005IntRectVbeCjmY(jIntOffset, popupContentSize));
        return jIntOffset;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final State<r> getKeyboardSignalState() {
        return this.keyboardSignalState;
    }

    public final n getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    public final int getTopWindowInsets() {
        return this.topWindowInsets;
    }

    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    public /* synthetic */ ExposedDropdownMenuPositionProvider(Density density, int i, State state, int i6, n nVar, int i10, e eVar) {
        this(density, i, (i10 & 4) != 0 ? null : state, (i10 & 8) != 0 ? density.mo375roundToPx0680j_4(MenuKt.getMenuVerticalMargin()) : i6, (i10 & 16) != 0 ? new n() { // from class: androidx.compose.material3.ExposedDropdownMenuPositionProvider.2
            public final void invoke(IntRect intRect, IntRect intRect2) {
            }

            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((IntRect) obj, (IntRect) obj2);
                return r.f317a;
            }
        } : nVar);
    }
}
