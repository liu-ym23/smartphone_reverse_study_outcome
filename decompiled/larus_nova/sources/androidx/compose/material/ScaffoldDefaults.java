package androidx.compose.material;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/material/ScaffoldDefaults;", "", "<init>", "()V", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getContentWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScaffoldDefaults {
    public static final int $stable = 0;
    public static final ScaffoldDefaults INSTANCE = null;

    static {
        INSTANCE = new ScaffoldDefaults();
    }

    private ScaffoldDefaults() {
    }

    public final WindowInsets getContentWindowInsets(Composer r100, int r101) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(423092031, r101, -1, "androidx.compose.material.ScaffoldDefaults.<get-contentWindowInsets> (Scaffold.kt:349)");
    L5:
        WindowInsets r102 = SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, r100, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r102;
    }
}
