package androidx.compose.material3.internal;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.ConfigurationCompat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0001¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"getString", "", "string", "Landroidx/compose/material3/internal/Strings;", "getString-2EP1pXo", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "formatArgs", "", "", "getString-qBjtwXw", "(I[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "formatString", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Strings_androidKt {
    public static final String formatString(String r100, Object... r101) {
        Object[] r102 = Arrays.copyOf(r101, r101.length);
        return String.format(r100, Arrays.copyOf(r102, r102.length));
    }

    /* JADX INFO: renamed from: getString-2EP1pXo, reason: not valid java name */
    public static final String m3227getString2EP1pXo(int r100, Composer r101, int r102) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-907677715, r102, -1, "androidx.compose.material3.internal.getString (Strings.android.kt:30)");
    L5:
        r101.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        String r103 = ((Context) r101.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getString(r100);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r103;
    }

    /* JADX INFO: renamed from: getString-qBjtwXw, reason: not valid java name */
    public static final String m3228getStringqBjtwXw(int r100, Object[] r101, Composer r102, int r103) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1427268608, r103, -1, "androidx.compose.material3.internal.getString (Strings.android.kt:38)");
    L5:
        String r104 = m3227getString2EP1pXo(r100, r102, r103 & 14);
        Locale r105 = ConfigurationCompat.getLocales((Configuration) r102.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).get(0);
        if (r105 != null) goto L8;
        r105 = Locale.getDefault();
    L8:
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        Object[] r107 = Arrays.copyOf(r101, r101.length);
        String r108 = String.format(r105, r104, Arrays.copyOf(r107, r107.length));
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r108;
    }
}
