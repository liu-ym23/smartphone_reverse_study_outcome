package androidx.compose.ui.window;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/window/Api33Impl;", "", "<init>", "()V", "createBackCallback", "Landroid/window/OnBackInvokedCallback;", "onDismissRequest", "Lkotlin/Function0;", "", "maybeRegisterBackCallback", "view", "Landroid/view/View;", "backCallback", "maybeUnregisterBackCallback", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class Api33Impl {
    public static final Api33Impl INSTANCE = null;

    static {
        INSTANCE = new Api33Impl();
    }

    private Api33Impl() {
    }

    public static /* synthetic */ void a(Function0 r100) {
        createBackCallback$lambda$0(r100);
    }

    @JvmStatic
    public static final OnBackInvokedCallback createBackCallback(final Function0<Unit> r100) {
        return new a(r100);
    }

    private static final void createBackCallback$lambda$0(Function0 r100) {
        if (r100 == null) goto L5;
        r100.invoke();
        return;
    }

    @JvmStatic
    public static final void maybeRegisterBackCallback(View r100, Object r101) {
        if ((r101 instanceof OnBackInvokedCallback) == false) goto L8;
        OnBackInvokedDispatcher r102 = r100.findOnBackInvokedDispatcher();
        if (r102 == null) goto L9;
        r102.registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) r101);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void maybeUnregisterBackCallback(View r100, Object r101) {
        if ((r101 instanceof OnBackInvokedCallback) == false) goto L8;
        OnBackInvokedDispatcher r102 = r100.findOnBackInvokedDispatcher();
        if (r102 == null) goto L9;
        r102.unregisterOnBackInvokedCallback((OnBackInvokedCallback) r101);
        return;
    L9:
        return;
    }
}
