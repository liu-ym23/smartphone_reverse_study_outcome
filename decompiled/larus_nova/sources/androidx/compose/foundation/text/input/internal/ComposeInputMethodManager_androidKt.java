package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a(\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H\u0001\"\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"ComposeInputMethodManager", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "view", "Landroid/view/View;", "ComposeInputMethodManagerFactory", "Lkotlin/Function1;", "overrideComposeInputMethodManagerFactoryForTests", "factory", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ComposeInputMethodManager_androidKt {
    private static Function1<? super View, ? extends ComposeInputMethodManager> ComposeInputMethodManagerFactory;

    public static /* synthetic */ ComposeInputMethodManager a(View r100) {
        return ComposeInputMethodManagerFactory$lambda$0(r100);
    }

    static {
        ComposeInputMethodManagerFactory = new i();
    }

    public static final ComposeInputMethodManager ComposeInputMethodManager(View r100) {
        return ComposeInputMethodManagerFactory.invoke(r100);
    }

    private static final ComposeInputMethodManager ComposeInputMethodManagerFactory$lambda$0(View r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 34) goto L6;
        return new ComposeInputMethodManagerImplApi34(r100);
    L6:
        if (r101 < 24) goto L9;
        return new ComposeInputMethodManagerImplApi24(r100);
    L9:
        return new ComposeInputMethodManagerImplApi21(r100);
    }

    public static final Function1<View, ComposeInputMethodManager> overrideComposeInputMethodManagerFactoryForTests(Function1<? super View, ? extends ComposeInputMethodManager> r100) {
        Function1 r101 = ComposeInputMethodManagerFactory;
        ComposeInputMethodManagerFactory = r100;
        return r101;
    }
}
