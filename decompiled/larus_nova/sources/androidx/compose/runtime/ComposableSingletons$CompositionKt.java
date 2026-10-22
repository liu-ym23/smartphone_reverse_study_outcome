package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$CompositionKt {
    public static final ComposableSingletons$CompositionKt INSTANCE = null;
    private static Function2<Composer, Integer, Unit> lambda$1918065384;
    private static Function2<Composer, Integer, Unit> lambda$954879418;

    public ComposableSingletons$CompositionKt() {
    }

    public final Function2<Composer, Integer, Unit> getLambda$1918065384$runtime() {
        return lambda$1918065384;
    }

    public final Function2<Composer, Integer, Unit> getLambda$954879418$runtime() {
        return lambda$954879418;
    }

    static {
        INSTANCE = new ComposableSingletons$CompositionKt();
        lambda$954879418 = ComposableLambdaKt.composableLambdaInstance(954879418, false, ComposableSingletons$CompositionKt$lambda$954879418$1.INSTANCE);
        lambda$1918065384 = ComposableLambdaKt.composableLambdaInstance(1918065384, false, ComposableSingletons$CompositionKt$lambda$1918065384$1.INSTANCE);
    }
}
