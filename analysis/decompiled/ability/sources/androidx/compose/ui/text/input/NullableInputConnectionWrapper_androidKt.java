package androidx.compose.ui.text.input;

import S7.k;
import android.os.Build;
import android.view.inputmethod.InputConnection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/view/inputmethod/InputConnection;", "delegate", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "LC7/r;", "onConnectionClosed", "NullableInputConnectionWrapper", "(Landroid/view/inputmethod/InputConnection;LS7/k;)Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NullableInputConnectionWrapper_androidKt {
    public static final NullableInputConnectionWrapper NullableInputConnectionWrapper(InputConnection inputConnection, k kVar) {
        return Build.VERSION.SDK_INT >= 34 ? new NullableInputConnectionWrapperApi34(inputConnection, kVar) : new NullableInputConnectionWrapperApi25(inputConnection, kVar);
    }
}
