package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$TimePickerKt {
    public static final ComposableSingletons$TimePickerKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-1179219109, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f47lambda$1179219109;
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1425358052;

    public ComposableSingletons$TimePickerKt() {
    }

    /* JADX INFO: renamed from: getLambda$-1179219109$material3, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m2092getLambda$1179219109$material3() {
        return f47lambda$1179219109;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1425358052$material3() {
        return lambda$1425358052;
    }

    static {
        INSTANCE = new ComposableSingletons$TimePickerKt();
        lambda$1425358052 = ComposableLambdaKt.composableLambdaInstance(1425358052, false, ComposableSingletons$TimePickerKt$lambda$1425358052$1.INSTANCE);
        f47lambda$1179219109 = ComposableLambdaKt.composableLambdaInstance(-1179219109, false, ComposableSingletons$TimePickerKt$lambda$1179219109$1.INSTANCE);
    }
}
