package androidx.compose.ui.text.input;

import android.os.Build;
import android.view.inputmethod.InputConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¨\u0006\u0007"}, d2 = {"NullableInputConnectionWrapper", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "delegate", "Landroid/view/inputmethod/InputConnection;", "onConnectionClosed", "Lkotlin/Function1;", "", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NullableInputConnectionWrapper_androidKt {
    public static final NullableInputConnectionWrapper NullableInputConnectionWrapper(InputConnection r100, Function1<? super NullableInputConnectionWrapper, Unit> r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 34) goto L6;
        return new NullableInputConnectionWrapperApi34(r100, r101);
    L6:
        if (r102 < 25) goto L9;
        return new NullableInputConnectionWrapperApi25(r100, r101);
    L9:
        if (r102 < 24) goto L12;
        return new NullableInputConnectionWrapperApi24(r100, r101);
    L12:
        return new NullableInputConnectionWrapperApi21(r100, r101);
    }
}
