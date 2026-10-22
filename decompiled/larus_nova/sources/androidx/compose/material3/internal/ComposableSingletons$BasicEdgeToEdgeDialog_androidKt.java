package androidx.compose.material3.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$BasicEdgeToEdgeDialog_androidKt {
    public static final ComposableSingletons$BasicEdgeToEdgeDialog_androidKt INSTANCE = null;
    private static Function2<Composer, Integer, Unit> lambda$453789431;

    public ComposableSingletons$BasicEdgeToEdgeDialog_androidKt() {
    }

    public final Function2<Composer, Integer, Unit> getLambda$453789431$material3() {
        return lambda$453789431;
    }

    static {
        INSTANCE = new ComposableSingletons$BasicEdgeToEdgeDialog_androidKt();
        lambda$453789431 = ComposableLambdaKt.composableLambdaInstance(453789431, false, ComposableSingletons$BasicEdgeToEdgeDialog_androidKt$lambda$453789431$1.INSTANCE);
    }
}
