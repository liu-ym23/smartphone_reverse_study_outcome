package androidx.compose.ui.focus;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"is1dFocusSearch", "", "Landroidx/compose/ui/focus/FocusDirection;", "is1dFocusSearch-3ESFkO8", "(I)Z", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FocusOwnerImplKt {
    /* JADX INFO: renamed from: is1dFocusSearch-3ESFkO8, reason: not valid java name */
    public static final boolean m4486is1dFocusSearch3ESFkO8(int r100) {
        FocusDirection.Companion r101 = FocusDirection.Companion;
        if (FocusDirection.m4461equalsimpl0(r100, r101.m4469getNextdhqQ8s()) == false) goto L5;
    L8:
        return true;
    L5:
        if (FocusDirection.m4461equalsimpl0(r100, r101.m4470getPreviousdhqQ8s()) == true) goto L8;
        return false;
    }
}
