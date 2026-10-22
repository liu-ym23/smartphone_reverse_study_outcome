package i0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import com.stepos.core.common.telemetry.FailStage;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"LogConditional"})
/* loaded from: classes.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    public static String a(int i10, Context context) throws Resources.NotFoundException {
        if (i10 == -1) {
            return FailStage.UNKNOWN;
        }
        try {
            i10 = context.getResources().getResourceEntryName(i10);
            return i10;
        } catch (Exception unused) {
            return ai.onnxruntime.providers.a.a(i10, "?");
        }
    }
}
