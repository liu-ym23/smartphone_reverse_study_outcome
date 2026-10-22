package androidx.compose.runtime.tooling;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalCompositionErrorContext", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/tooling/CompositionErrorContext;", "getLocalCompositionErrorContext", "()Landroidx/compose/runtime/CompositionLocal;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CompositionErrorContextKt {
    private static final CompositionLocal<CompositionErrorContext> LocalCompositionErrorContext = null;

    private static final CompositionErrorContext LocalCompositionErrorContext$lambda$0() {
        return null;
    }

    public static /* synthetic */ CompositionErrorContext a() {
        return LocalCompositionErrorContext$lambda$0();
    }

    static {
        LocalCompositionErrorContext = CompositionLocalKt.staticCompositionLocalOf(new b());
    }

    public static final CompositionLocal<CompositionErrorContext> getLocalCompositionErrorContext() {
        return LocalCompositionErrorContext;
    }
}
