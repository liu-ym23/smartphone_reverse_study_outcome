package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$BackdropScaffoldKt {
    public static final ComposableSingletons$BackdropScaffoldKt INSTANCE = null;
    private static Function3<SnackbarHostState, Composer, Integer, Unit> lambda$2057676608;

    public ComposableSingletons$BackdropScaffoldKt() {
    }

    public final Function3<SnackbarHostState, Composer, Integer, Unit> getLambda$2057676608$material() {
        return lambda$2057676608;
    }

    static {
        INSTANCE = new ComposableSingletons$BackdropScaffoldKt();
        lambda$2057676608 = ComposableLambdaKt.composableLambdaInstance(2057676608, false, ComposableSingletons$BackdropScaffoldKt$lambda$2057676608$1.INSTANCE);
    }
}
