package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001BQ\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012:\b\u0002\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eBM\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012:\b\u0002\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u0010J/\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuPopupPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "anchorPositionBlock", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "onPositionCalculated", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "anchorPosition", "(JLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "calculatePosition", "anchorBounds", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextMenuPopupPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final Function0<IntOffset> anchorPositionBlock;
    private final Function2<IntOffset, IntRect, Unit> onPositionCalculated;

    public /* synthetic */ ContextMenuPopupPositionProvider(long r100, Function2 r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public static /* synthetic */ IntOffset a(long r100) {
        return _init_$lambda$0(r100);
    }

    private static final IntOffset _init_$lambda$0(long r100) {
        return IntOffset.m7667boximpl(r100);
    }

    private ContextMenuPopupPositionProvider(final long r100, Function2<? super IntOffset, ? super IntRect, Unit> r101) {
        this(new g(r100), r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContextMenuPopupPositionProvider(Function0<IntOffset> r100, Function2<? super IntOffset, ? super IntRect, Unit> r101) {
        this.anchorPositionBlock = r100;
        this.onPositionCalculated = r101;
    }

    public /* synthetic */ ContextMenuPopupPositionProvider(long r100, Function2 r101, int r102, DefaultConstructorMarker r103) {
        DefaultConstructorMarker r104 = null;
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, r104);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long mo340calculatePositionllwVHH4(IntRect r110, long r111, LayoutDirection r112, long r210) {
        long r100 = this.anchorPositionBlock.invoke().m7685unboximpl();
        int r101 = r110.getLeft() + IntOffset.m7676getXimpl(r100);
        int r102 = (int) (r210 >> 32);
        int r103 = (int) (r111 >> 32);
        if (r112 != LayoutDirection.Ltr) goto L5;
        boolean r104 = true;
    L6:
        int r105 = ContextMenuPopupPositionProviderKt.alignPopupAxis(r101, r102, r103, r104);
        int r106 = ContextMenuPopupPositionProviderKt.alignPopupAxis$default(r110.getTop() + IntOffset.m7677getYimpl(r100), (int) (r210 & BodyPartID.bodyIdMax), (int) (r111 & BodyPartID.bodyIdMax), false, 8, null);
        long r107 = IntOffset.m7670constructorimpl((((long) r105) << 32) | (BodyPartID.bodyIdMax & ((long) r106)));
        Function2<IntOffset, IntRect, Unit> r108 = this.onPositionCalculated;
        if (r108 == null) goto L9;
        r108.invoke(IntOffset.m7667boximpl(r100), IntRectKt.m7709IntRectVbeCjmY(r107, r210));
    L9:
        return r107;
    L5:
        r104 = false;
        goto L6
    }

    public /* synthetic */ ContextMenuPopupPositionProvider(Function0 r100, Function2 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
