package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/BasicTooltipStrings;", "", "<init>", "()V", "label", "", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "description", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BasicTooltipStrings {
    public static final int $stable = 0;
    public static final BasicTooltipStrings INSTANCE = null;

    static {
        INSTANCE = new BasicTooltipStrings();
    }

    private BasicTooltipStrings() {
    }

    public final String description(Composer r100, int r101) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1416633714, r101, -1, "androidx.compose.foundation.BasicTooltipStrings.description (BasicTooltip.android.kt:26)");
    L5:
        String r102 = StringResources_androidKt.stringResource(R.string.tooltip_description, r100, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r102;
    }

    public final String label(Composer r100, int r101) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(187295226, r101, -1, "androidx.compose.foundation.BasicTooltipStrings.label (BasicTooltip.android.kt:24)");
    L5:
        String r102 = StringResources_androidKt.stringResource(R.string.tooltip_label, r100, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r102;
    }
}
