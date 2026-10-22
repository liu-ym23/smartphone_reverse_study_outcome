package androidx.compose.ui.window;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$AndroidPopup_androidKt {
    public static final ComposableSingletons$AndroidPopup_androidKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-1131826196, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f50lambda$1131826196;

    public ComposableSingletons$AndroidPopup_androidKt() {
    }

    /* JADX INFO: renamed from: getLambda$-1131826196$ui_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7802getLambda$1131826196$ui_release() {
        return f50lambda$1131826196;
    }

    static {
        INSTANCE = new ComposableSingletons$AndroidPopup_androidKt();
        f50lambda$1131826196 = ComposableLambdaKt.composableLambdaInstance(-1131826196, false, ComposableSingletons$AndroidPopup_androidKt$lambda$1131826196$1.INSTANCE);
    }
}
