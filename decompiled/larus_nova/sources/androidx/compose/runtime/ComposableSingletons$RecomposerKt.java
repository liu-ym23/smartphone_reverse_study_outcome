package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$RecomposerKt {
    public static final ComposableSingletons$RecomposerKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-1091980426, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f48lambda$1091980426;

    public ComposableSingletons$RecomposerKt() {
    }

    /* JADX INFO: renamed from: getLambda$-1091980426$runtime, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4096getLambda$1091980426$runtime() {
        return f48lambda$1091980426;
    }

    static {
        INSTANCE = new ComposableSingletons$RecomposerKt();
        f48lambda$1091980426 = ComposableLambdaKt.composableLambdaInstance(-1091980426, false, ComposableSingletons$RecomposerKt$lambda$1091980426$1.INSTANCE);
    }
}
