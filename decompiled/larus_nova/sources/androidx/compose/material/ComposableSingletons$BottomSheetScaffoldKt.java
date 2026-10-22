package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$BottomSheetScaffoldKt {
    public static final ComposableSingletons$BottomSheetScaffoldKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-505419337, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f3lambda$505419337;
    private static Function2<Composer, Integer, Unit> lambda$687232378;
    private static Function3<SnackbarHostState, Composer, Integer, Unit> lambda$937349512;

    public ComposableSingletons$BottomSheetScaffoldKt() {
    }

    /* JADX INFO: renamed from: getLambda$-505419337$material, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1615getLambda$505419337$material() {
        return f3lambda$505419337;
    }

    public final Function2<Composer, Integer, Unit> getLambda$687232378$material() {
        return lambda$687232378;
    }

    public final Function3<SnackbarHostState, Composer, Integer, Unit> getLambda$937349512$material() {
        return lambda$937349512;
    }

    static {
        INSTANCE = new ComposableSingletons$BottomSheetScaffoldKt();
        lambda$937349512 = ComposableLambdaKt.composableLambdaInstance(937349512, false, ComposableSingletons$BottomSheetScaffoldKt$lambda$937349512$1.INSTANCE);
        f3lambda$505419337 = ComposableLambdaKt.composableLambdaInstance(-505419337, false, ComposableSingletons$BottomSheetScaffoldKt$lambda$505419337$1.INSTANCE);
        lambda$687232378 = ComposableLambdaKt.composableLambdaInstance(687232378, false, ComposableSingletons$BottomSheetScaffoldKt$lambda$687232378$1.INSTANCE);
    }
}
