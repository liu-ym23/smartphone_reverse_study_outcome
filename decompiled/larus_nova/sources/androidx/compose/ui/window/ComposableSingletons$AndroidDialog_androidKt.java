package androidx.compose.ui.window;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$AndroidDialog_androidKt {
    public static final ComposableSingletons$AndroidDialog_androidKt INSTANCE = null;
    private static Function2<Composer, Integer, Unit> lambda$210148896;

    public ComposableSingletons$AndroidDialog_androidKt() {
    }

    public final Function2<Composer, Integer, Unit> getLambda$210148896$ui_release() {
        return lambda$210148896;
    }

    static {
        INSTANCE = new ComposableSingletons$AndroidDialog_androidKt();
        lambda$210148896 = ComposableLambdaKt.composableLambdaInstance(210148896, false, ComposableSingletons$AndroidDialog_androidKt$lambda$210148896$1.INSTANCE);
    }
}
