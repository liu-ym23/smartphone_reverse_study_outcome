package com.stepos.aiengine.api.trace;

import La.K;
import android.os.Bundle;
import android.util.Log;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"withTraceId", "Landroid/os/Bundle;", DidiCardProvider.KEY_TRACE_ID, "", "aiengine-api_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AiTraceExtKt {
    public static final Bundle withTraceId(Bundle bundle, String traceId) {
        p.i(bundle, "<this>");
        p.i(traceId, "traceId");
        String strR1 = K.R1(traceId, 128);
        bundle.putString("trace_id", strR1);
        Log.i("AiTrace", "[TRACE] withTraceId set: len=" + strR1.length() + ", val=" + K.R1(strR1, 16) + (strR1.length() > 16 ? "..." : ""));
        return bundle;
    }
}
