package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$SegmentedButtonKt {
    public static final ComposableSingletons$SegmentedButtonKt INSTANCE = null;
    private static Function2<Composer, Integer, Unit> lambda$1863131183;

    public ComposableSingletons$SegmentedButtonKt() {
    }

    public final Function2<Composer, Integer, Unit> getLambda$1863131183$material3() {
        return lambda$1863131183;
    }

    static {
        INSTANCE = new ComposableSingletons$SegmentedButtonKt();
        lambda$1863131183 = ComposableLambdaKt.composableLambdaInstance(1863131183, false, ComposableSingletons$SegmentedButtonKt$lambda$1863131183$1.INSTANCE);
    }
}
