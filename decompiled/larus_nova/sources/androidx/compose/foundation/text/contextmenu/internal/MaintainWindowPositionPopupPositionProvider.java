package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/MaintainWindowPositionPopupPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "popupPositionProvider", "<init>", "(Landroidx/compose/ui/window/PopupPositionProvider;)V", "getPopupPositionProvider", "()Landroidx/compose/ui/window/PopupPositionProvider;", "previousWindowSize", "Landroidx/compose/ui/unit/IntSize;", "getPreviousWindowSize-bOM6tXw", "()Landroidx/compose/ui/unit/IntSize;", "setPreviousWindowSize-fhxjrPA", "(Landroidx/compose/ui/unit/IntSize;)V", "previousLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getPreviousLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setPreviousLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "previousPopupContentSize", "getPreviousPopupContentSize-bOM6tXw", "setPreviousPopupContentSize-fhxjrPA", "previousPosition", "Landroidx/compose/ui/unit/IntOffset;", "getPreviousPosition-JyOPPKE", "()Landroidx/compose/ui/unit/IntOffset;", "setPreviousPosition-fg0MpWk", "(Landroidx/compose/ui/unit/IntOffset;)V", "calculatePosition", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "layoutDirection", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MaintainWindowPositionPopupPositionProvider implements PopupPositionProvider {
    private final PopupPositionProvider popupPositionProvider;
    private LayoutDirection previousLayoutDirection;
    private IntSize previousPopupContentSize;
    private IntOffset previousPosition;
    private IntSize previousWindowSize;

    public final PopupPositionProvider getPopupPositionProvider() {
        return this.popupPositionProvider;
    }

    public final LayoutDirection getPreviousLayoutDirection() {
        return this.previousLayoutDirection;
    }

    /* JADX INFO: renamed from: getPreviousPopupContentSize-bOM6tXw, reason: not valid java name */
    public final IntSize m1172getPreviousPopupContentSizebOM6tXw() {
        return this.previousPopupContentSize;
    }

    /* JADX INFO: renamed from: getPreviousPosition-JyOPPKE, reason: not valid java name */
    public final IntOffset m1173getPreviousPositionJyOPPKE() {
        return this.previousPosition;
    }

    /* JADX INFO: renamed from: getPreviousWindowSize-bOM6tXw, reason: not valid java name */
    public final IntSize m1174getPreviousWindowSizebOM6tXw() {
        return this.previousWindowSize;
    }

    public MaintainWindowPositionPopupPositionProvider(PopupPositionProvider r100) {
        this.popupPositionProvider = r100;
    }

    public final void setPreviousLayoutDirection(LayoutDirection r100) {
        this.previousLayoutDirection = r100;
    }

    /* JADX INFO: renamed from: setPreviousPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m1175setPreviousPopupContentSizefhxjrPA(IntSize r100) {
        this.previousPopupContentSize = r100;
    }

    /* JADX INFO: renamed from: setPreviousPosition-fg0MpWk, reason: not valid java name */
    public final void m1176setPreviousPositionfg0MpWk(IntOffset r100) {
        this.previousPosition = r100;
    }

    /* JADX INFO: renamed from: setPreviousWindowSize-fhxjrPA, reason: not valid java name */
    public final void m1177setPreviousWindowSizefhxjrPA(IntSize r100) {
        this.previousWindowSize = r100;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo340calculatePositionllwVHH4(IntRect r100, long r101, LayoutDirection r110, long r111) {
        IntOffset r102 = this.previousPosition;
        if (r102 == null) goto L18;
        IntSize r103 = this.previousWindowSize;
        boolean r104 = false;
        if (r103 != null) goto L7;
        boolean r105 = false;
    L8:
        if (r105 == false) goto L18;
        if (this.previousLayoutDirection != r110) goto L18;
        IntSize r106 = this.previousPopupContentSize;
        if (r106 == null) goto L15;
        r104 = IntSize.m7717equalsimpl0(r106.m7723unboximpl(), r111);
    L15:
        if (r104 == false) goto L18;
        return r102.m7685unboximpl();
    L7:
        r105 = IntSize.m7717equalsimpl0(r103.m7723unboximpl(), r101);
    L18:
        long r107 = this.popupPositionProvider.mo340calculatePositionllwVHH4(r100, r101, r110, r111);
        this.previousWindowSize = IntSize.m7711boximpl(r101);
        this.previousLayoutDirection = r110;
        this.previousPopupContentSize = IntSize.m7711boximpl(r111);
        this.previousPosition = IntOffset.m7667boximpl(r107);
        return r107;
    }
}
