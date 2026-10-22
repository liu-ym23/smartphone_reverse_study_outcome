package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$Wrapper_androidKt {
    public static final ComposableSingletons$Wrapper_androidKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-1759434350, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f49lambda$1759434350;

    public ComposableSingletons$Wrapper_androidKt() {
    }

    /* JADX INFO: renamed from: getLambda$-1759434350$ui_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6681getLambda$1759434350$ui_release() {
        return f49lambda$1759434350;
    }

    static {
        INSTANCE = new ComposableSingletons$Wrapper_androidKt();
        f49lambda$1759434350 = ComposableLambdaKt.composableLambdaInstance(-1759434350, false, ComposableSingletons$Wrapper_androidKt$lambda$1759434350$1.INSTANCE);
    }
}
