package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$BasicTextFieldKt {
    public static final ComposableSingletons$BasicTextFieldKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-665310900, reason: not valid java name */
    private static Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> f1lambda$665310900;
    private static Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> lambda$444370233;
    private static Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> lambda$486633673;
    private static Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> lambda$759698998;

    public ComposableSingletons$BasicTextFieldKt() {
    }

    /* JADX INFO: renamed from: getLambda$-665310900$foundation_release, reason: not valid java name */
    public final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> m1048getLambda$665310900$foundation_release() {
        return f1lambda$665310900;
    }

    public final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> getLambda$444370233$foundation_release() {
        return lambda$444370233;
    }

    public final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> getLambda$486633673$foundation_release() {
        return lambda$486633673;
    }

    public final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> getLambda$759698998$foundation_release() {
        return lambda$759698998;
    }

    static {
        INSTANCE = new ComposableSingletons$BasicTextFieldKt();
        lambda$759698998 = ComposableLambdaKt.composableLambdaInstance(759698998, false, ComposableSingletons$BasicTextFieldKt$lambda$759698998$1.INSTANCE);
        lambda$486633673 = ComposableLambdaKt.composableLambdaInstance(486633673, false, ComposableSingletons$BasicTextFieldKt$lambda$486633673$1.INSTANCE);
        lambda$444370233 = ComposableLambdaKt.composableLambdaInstance(444370233, false, ComposableSingletons$BasicTextFieldKt$lambda$444370233$1.INSTANCE);
        f1lambda$665310900 = ComposableLambdaKt.composableLambdaInstance(-665310900, false, ComposableSingletons$BasicTextFieldKt$lambda$665310900$1.INSTANCE);
    }
}
