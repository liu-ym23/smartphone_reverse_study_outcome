package androidx.compose.ui.platform;

import android.content.Context;
import android.view.View;
import androidx.compose.ui.input.pointer.AndroidPointerIcon;
import androidx.compose.ui.input.pointer.AndroidPointerIconType;
import androidx.compose.ui.input.pointer.PointerIcon;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewVerificationHelperMethodsN;", "", "<init>", "()V", "toAndroidPointerIcon", "Landroid/view/PointerIcon;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "setPointerIcon", "", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidComposeViewVerificationHelperMethodsN {
    public static final AndroidComposeViewVerificationHelperMethodsN INSTANCE = null;

    static {
        INSTANCE = new AndroidComposeViewVerificationHelperMethodsN();
    }

    private AndroidComposeViewVerificationHelperMethodsN() {
    }

    public final void setPointerIcon(View r100, PointerIcon r101) {
        android.view.PointerIcon r102 = toAndroidPointerIcon(r100.getContext(), r101);
        if (Intrinsics.areEqual(r100.getPointerIcon(), r102) == true) goto L6;
        r100.setPointerIcon(r102);
        return;
    }

    public final android.view.PointerIcon toAndroidPointerIcon(Context r100, PointerIcon r101) {
        if ((r101 instanceof AndroidPointerIcon) == false) goto L6;
        return ((AndroidPointerIcon) r101).getPointerIcon();
    L6:
        if ((r101 instanceof AndroidPointerIconType) == false) goto L9;
        return android.view.PointerIcon.getSystemIcon(r100, ((AndroidPointerIconType) r101).getType());
    L9:
        return android.view.PointerIcon.getSystemIcon(r100, 1000);
    }
}
