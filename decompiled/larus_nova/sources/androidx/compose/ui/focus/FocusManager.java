package androidx.compose.ui.focus;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/focus/FocusManager;", "", "clearFocus", "", "force", "", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface FocusManager {

    /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusManager$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void clearFocus$default(FocusManager r100, boolean r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            r100.clearFocus(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearFocus");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void clearFocus$default(FocusManager r100, boolean r101, int r102, Object r103) {
            CC.clearFocus$default(r100, r101, r102, r103);
        }
    }

    void clearFocus(boolean r100);

    /* JADX INFO: renamed from: moveFocus-3ESFkO8, reason: not valid java name */
    boolean mo4475moveFocus3ESFkO8(int r100);
}
