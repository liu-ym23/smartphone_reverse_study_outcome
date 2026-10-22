package com.stepos.core.common.util;

import com.stepos.core.data.ContentParams;
import gc.q;
import gc.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TraceIdExtractorKt {
    public static final String extractBusinessTraceId(ContentParams contentParams) {
        String strExtractTraceId = extractTraceId(contentParams);
        return strExtractTraceId == null ? "" : strExtractTraceId;
    }

    public static final String extractTraceId(ContentParams contentParams) {
        if (contentParams == null) {
            return null;
        }
        String string = contentParams.getString(TraceIdKeys.CP_TRACE_ID, "");
        if (q.t0(string)) {
            string = contentParams.getString("sla.arg.trace_id", "");
        }
        String string2 = q.L0(string).toString();
        if (q.t0(string2)) {
            string2 = null;
        }
        if (string2 != null) {
            return r.R0(TraceIdKeys.MAX_LENGTH, string2);
        }
        return null;
    }

    public static final String normalizeBusinessTraceId(String str) {
        String string;
        String strR0 = null;
        if (str != null && (string = q.L0(str).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                strR0 = r.R0(TraceIdKeys.MAX_LENGTH, string);
            }
        }
        return strR0 == null ? "" : strR0;
    }

    public static final String resolveFlywheelTraceId(String str) {
        String strNormalizeBusinessTraceId = normalizeBusinessTraceId(str);
        return !q.t0(strNormalizeBusinessTraceId) ? strNormalizeBusinessTraceId : TraceIdUtil.INSTANCE.newTraceId();
    }
}
