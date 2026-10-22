package androidx.compose.foundation.text.input.internal;

import S7.k;
import android.os.Build;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a/\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\b\"\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/view/View;", "view", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "ComposeInputMethodManager", "(Landroid/view/View;)Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "Lkotlin/Function1;", "factory", "overrideComposeInputMethodManagerFactoryForTests", "(LS7/k;)LS7/k;", "ComposeInputMethodManagerFactory", "LS7/k;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposeInputMethodManager_androidKt {
    private static k ComposeInputMethodManagerFactory = new k() { // from class: androidx.compose.foundation.text.input.internal.ComposeInputMethodManager_androidKt$ComposeInputMethodManagerFactory$1
        @Override // S7.k
        public final ComposeInputMethodManager invoke(View view) {
            return Build.VERSION.SDK_INT >= 34 ? new ComposeInputMethodManagerImplApi34(view) : new ComposeInputMethodManagerImplApi24(view);
        }
    };

    public static final ComposeInputMethodManager ComposeInputMethodManager(View view) {
        return (ComposeInputMethodManager) ComposeInputMethodManagerFactory.invoke(view);
    }

    @VisibleForTesting
    public static final k overrideComposeInputMethodManagerFactoryForTests(k kVar) {
        k kVar2 = ComposeInputMethodManagerFactory;
        ComposeInputMethodManagerFactory = kVar;
        return kVar2;
    }
}
