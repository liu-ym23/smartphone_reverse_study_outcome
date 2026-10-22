package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnchorInfoApi34Helper;", "", "<init>", "()V", "addVisibleLineBounds", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "builder", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CursorAnchorInfoApi34Helper {
    public static final int $stable = 0;
    public static final CursorAnchorInfoApi34Helper INSTANCE = null;

    static {
        INSTANCE = new CursorAnchorInfoApi34Helper();
    }

    private CursorAnchorInfoApi34Helper() {
    }

    @JvmStatic
    public static final CursorAnchorInfo.Builder addVisibleLineBounds(CursorAnchorInfo.Builder r100, TextLayoutResult r101, Rect r102) {
        if (r102.isEmpty() == true) goto L9;
        int r103 = r101.getLineForVerticalPosition(r102.getTop());
        int r104 = r101.getLineForVerticalPosition(r102.getBottom());
        if (r103 > r104) goto L9;
    L6:
        r100.addVisibleLineBounds(r101.getLineLeft(r103), r101.getLineTop(r103), r101.getLineRight(r103), r101.getLineBottom(r103));
        if (r103 == r104) goto L9;
        r103 = r103 + 1;
    L9:
        return r100;
    }
}
