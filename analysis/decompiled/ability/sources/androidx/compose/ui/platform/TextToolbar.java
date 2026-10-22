package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001Jq\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ_\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&¢\u0006\u0004\b\u000b\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/TextToolbar;", "", "Landroidx/compose/ui/geometry/Rect;", "rect", "Lkotlin/Function0;", "LC7/r;", "onCopyRequested", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "onAutofillRequested", "showMenu", "(Landroidx/compose/ui/geometry/Rect;LS7/a;LS7/a;LS7/a;LS7/a;LS7/a;)V", "(Landroidx/compose/ui/geometry/Rect;LS7/a;LS7/a;LS7/a;LS7/a;)V", "hide", "()V", "Landroidx/compose/ui/platform/TextToolbarStatus;", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "status", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface TextToolbar {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void showMenu(TextToolbar textToolbar, Rect rect, S7.a aVar, S7.a aVar2, S7.a aVar3, S7.a aVar4, S7.a aVar5) {
            TextToolbar.super.showMenu(rect, aVar, aVar2, aVar3, aVar4, aVar5);
        }
    }

    static /* synthetic */ void showMenu$default(TextToolbar textToolbar, Rect rect, S7.a aVar, S7.a aVar2, S7.a aVar3, S7.a aVar4, S7.a aVar5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMenu");
        }
        if ((i & 2) != 0) {
            aVar = null;
        }
        if ((i & 4) != 0) {
            aVar2 = null;
        }
        if ((i & 8) != 0) {
            aVar3 = null;
        }
        if ((i & 16) != 0) {
            aVar4 = null;
        }
        if ((i & 32) != 0) {
            aVar5 = null;
        }
        textToolbar.showMenu(rect, aVar, aVar2, aVar3, aVar4, aVar5);
    }

    TextToolbarStatus getStatus();

    void hide();

    void showMenu(Rect rect, S7.a onCopyRequested, S7.a onPasteRequested, S7.a onCutRequested, S7.a onSelectAllRequested);

    default void showMenu(Rect rect, S7.a onCopyRequested, S7.a onPasteRequested, S7.a onCutRequested, S7.a onSelectAllRequested, S7.a onAutofillRequested) {
        showMenu(rect, onCopyRequested, onPasteRequested, onCutRequested, onSelectAllRequested);
    }

    static /* synthetic */ void showMenu$default(TextToolbar textToolbar, Rect rect, S7.a aVar, S7.a aVar2, S7.a aVar3, S7.a aVar4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMenu");
        }
        if ((i & 2) != 0) {
            aVar = null;
        }
        if ((i & 4) != 0) {
            aVar2 = null;
        }
        if ((i & 8) != 0) {
            aVar3 = null;
        }
        if ((i & 16) != 0) {
            aVar4 = null;
        }
        textToolbar.showMenu(rect, aVar, aVar2, aVar3, aVar4);
    }
}
