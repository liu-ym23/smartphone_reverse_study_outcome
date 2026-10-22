package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt {
    public static final ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt INSTANCE = null;

    /* JADX INFO: renamed from: lambda$-1357803046, reason: not valid java name */
    private static Function5<TextContextMenuSession, TextContextMenuDataProvider, Function0<? extends LayoutCoordinates>, Composer, Integer, Unit> f2lambda$1357803046;
    private static Function5<TextContextMenuSession, TextContextMenuDataProvider, Function0<? extends LayoutCoordinates>, Composer, Integer, Unit> lambda$129995601;
    private static Function5<TextContextMenuSession, TextContextMenuDataProvider, Function0<? extends LayoutCoordinates>, Composer, Integer, Unit> lambda$636288403;

    public ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt() {
    }

    /* JADX INFO: renamed from: getLambda$-1357803046$foundation_release, reason: not valid java name */
    public final Function5<TextContextMenuSession, TextContextMenuDataProvider, Function0<? extends LayoutCoordinates>, Composer, Integer, Unit> m1168getLambda$1357803046$foundation_release() {
        return f2lambda$1357803046;
    }

    public final Function5<TextContextMenuSession, TextContextMenuDataProvider, Function0<? extends LayoutCoordinates>, Composer, Integer, Unit> getLambda$129995601$foundation_release() {
        return lambda$129995601;
    }

    public final Function5<TextContextMenuSession, TextContextMenuDataProvider, Function0<? extends LayoutCoordinates>, Composer, Integer, Unit> getLambda$636288403$foundation_release() {
        return lambda$636288403;
    }

    static {
        INSTANCE = new ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt();
        lambda$129995601 = ComposableLambdaKt.composableLambdaInstance(129995601, false, ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt$lambda$129995601$1.INSTANCE);
        lambda$636288403 = ComposableLambdaKt.composableLambdaInstance(636288403, false, ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt$lambda$636288403$1.INSTANCE);
        f2lambda$1357803046 = ComposableLambdaKt.composableLambdaInstance(-1357803046, false, ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt$lambda$1357803046$1.INSTANCE);
    }
}
