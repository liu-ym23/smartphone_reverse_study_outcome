package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ContextMenuUi_androidKt {
    public static final ComposableSingletons$ContextMenuUi_androidKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-355168742, reason: not valid java name */
    private static Function3<ContextMenuColors, Composer, Integer, Unit> f0lambda$355168742;

    public ComposableSingletons$ContextMenuUi_androidKt() {
    }

    /* JADX INFO: renamed from: getLambda$-355168742$foundation_release, reason: not valid java name */
    public final Function3<ContextMenuColors, Composer, Integer, Unit> m334getLambda$355168742$foundation_release() {
        return f0lambda$355168742;
    }

    static {
        INSTANCE = new ComposableSingletons$ContextMenuUi_androidKt();
        f0lambda$355168742 = ComposableLambdaKt.composableLambdaInstance(-355168742, false, ComposableSingletons$ContextMenuUi_androidKt$lambda$355168742$1.INSTANCE);
    }
}
