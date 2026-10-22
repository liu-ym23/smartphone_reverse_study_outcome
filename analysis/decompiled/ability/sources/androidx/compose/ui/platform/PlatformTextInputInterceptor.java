package androidx.compose.ui.platform;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Metadata;

@ExperimentalComposeUiApi
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\bç\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/PlatformTextInputInterceptor;", "", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "request", "Landroidx/compose/ui/platform/PlatformTextInputSession;", "nextHandler", "", "interceptStartInputMethod", "(Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;Landroidx/compose/ui/platform/PlatformTextInputSession;LH7/c;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PlatformTextInputInterceptor {
    Object interceptStartInputMethod(PlatformTextInputMethodRequest platformTextInputMethodRequest, PlatformTextInputSession platformTextInputSession, H7.c<?> cVar);
}
