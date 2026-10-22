package androidx.compose.ui.focus;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u00002\u00020\u0001J#\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/focus/PlatformFocusOwner;", "", "Landroidx/compose/ui/focus/FocusDirection;", "focusDirection", "Landroidx/compose/ui/geometry/Rect;", "previouslyFocusedRect", "", "requestOwnerFocus-7o62pno", "(Landroidx/compose/ui/focus/FocusDirection;Landroidx/compose/ui/geometry/Rect;)Z", "requestOwnerFocus", "LC7/r;", "clearOwnerFocus", "()V", "moveFocusInChildren-3ESFkO8", "(I)Z", "moveFocusInChildren", "getEmbeddedViewFocusRect", "()Landroidx/compose/ui/geometry/Rect;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PlatformFocusOwner {
    void clearOwnerFocus();

    Rect getEmbeddedViewFocusRect();

    /* renamed from: moveFocusInChildren-3ESFkO8, reason: not valid java name */
    boolean mo3836moveFocusInChildren3ESFkO8(int focusDirection);

    /* renamed from: requestOwnerFocus-7o62pno, reason: not valid java name */
    boolean mo3837requestOwnerFocus7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect);
}
