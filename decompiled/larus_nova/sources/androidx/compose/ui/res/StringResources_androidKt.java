package androidx.compose.ui.res;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a+\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\n\u001a\u001f\u0010\u000b\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\r\u001a3\u0010\u000b\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"stringResource", "", "id", "", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "formatArgs", "", "", "(I[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "stringArrayResource", "(ILandroidx/compose/runtime/Composer;I)[Ljava/lang/String;", "pluralStringResource", "count", "(IILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "(II[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StringResources_androidKt {
    public static final String[] stringArrayResource(int r100, Composer r101, int r102) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1562162650, r102, -1, "androidx.compose.ui.res.stringArrayResource (StringResources.android.kt:58)");
    L5:
        String[] r103 = ((Resources) r101.consume(AndroidCompositionLocals_androidKt.getLocalResources())).getStringArray(r100);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r103;
    }

    public static final String stringResource(int r100, Composer r101, int r102) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1223887937, r102, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:33)");
    L5:
        String r103 = ((Resources) r101.consume(AndroidCompositionLocals_androidKt.getLocalResources())).getString(r100);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r103;
    }

    public static final String pluralStringResource(int r100, int r101, Composer r102, int r103) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1784741530, r103, -1, "androidx.compose.ui.res.pluralStringResource (StringResources.android.kt:71)");
    L5:
        String r104 = ((Resources) r102.consume(AndroidCompositionLocals_androidKt.getLocalResources())).getQuantityString(r100, r101);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r104;
    }

    public static final String stringResource(int r100, Object[] r101, Composer r102, int r103) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(2071230100, r103, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:46)");
    L5:
        String r104 = ((Resources) r102.consume(AndroidCompositionLocals_androidKt.getLocalResources())).getString(r100, Arrays.copyOf(r101, r101.length));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r104;
    }

    public static final String pluralStringResource(int r100, int r101, Object[] r102, Composer r103, int r104) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(523207213, r104, -1, "androidx.compose.ui.res.pluralStringResource (StringResources.android.kt:85)");
    L5:
        String r105 = ((Resources) r103.consume(AndroidCompositionLocals_androidKt.getLocalResources())).getQuantityString(r100, r101, Arrays.copyOf(r102, r102.length));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r105;
    }
}
