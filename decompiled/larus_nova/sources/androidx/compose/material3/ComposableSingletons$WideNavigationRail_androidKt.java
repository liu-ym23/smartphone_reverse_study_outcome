package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$WideNavigationRail_androidKt {
    public static final ComposableSingletons$WideNavigationRail_androidKt INSTANCE = null;
    private static Function2<Composer, Integer, Unit> lambda$2011757776;

    public ComposableSingletons$WideNavigationRail_androidKt() {
    }

    public final Function2<Composer, Integer, Unit> getLambda$2011757776$material3() {
        return lambda$2011757776;
    }

    static {
        INSTANCE = new ComposableSingletons$WideNavigationRail_androidKt();
        lambda$2011757776 = ComposableLambdaKt.composableLambdaInstance(2011757776, false, ComposableSingletons$WideNavigationRail_androidKt$lambda$2011757776$1.INSTANCE);
    }
}
