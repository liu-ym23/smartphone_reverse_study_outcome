package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"isSystemInDarkTheme", "", "(Landroidx/compose/runtime/Composer;I)Z", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DarkThemeKt {
    public static final boolean isSystemInDarkTheme(Composer r100, int r101) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1100791446, r101, -1, "androidx.compose.foundation.isSystemInDarkTheme (DarkTheme.kt:36)");
    L5:
        boolean r102 = DarkTheme_androidKt._isSystemInDarkTheme(r100, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r102;
    }
}
