package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ModalBottomSheet_androidKt {
    public static final ComposableSingletons$ModalBottomSheet_androidKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-1294623166, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f35lambda$1294623166;

    /* JADX INFO: renamed from: lambda$-91331245, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f36lambda$91331245;

    public ComposableSingletons$ModalBottomSheet_androidKt() {
    }

    /* JADX INFO: renamed from: getLambda$-1294623166$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2080getLambda$1294623166$material3() {
        return f35lambda$1294623166;
    }

    /* JADX INFO: renamed from: getLambda$-91331245$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2081getLambda$91331245$material3() {
        return f36lambda$91331245;
    }

    static {
        INSTANCE = new ComposableSingletons$ModalBottomSheet_androidKt();
        f35lambda$1294623166 = ComposableLambdaKt.composableLambdaInstance(-1294623166, false, ComposableSingletons$ModalBottomSheet_androidKt$lambda$1294623166$1.INSTANCE);
        f36lambda$91331245 = ComposableLambdaKt.composableLambdaInstance(-91331245, false, ComposableSingletons$ModalBottomSheet_androidKt$lambda$91331245$1.INSTANCE);
    }
}
