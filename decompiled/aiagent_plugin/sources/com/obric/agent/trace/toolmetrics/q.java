package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniClientToolTraceState.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface q {

    /* JADX INFO: compiled from: OmniClientToolTraceState.kt */
    public static final class a {
        public static /* synthetic */ void a(q r2, String r3, String r4, int r5, Object r6) {
            q r7 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L7;
            r4 = null;
        L7:
            r7.a(r3, r4);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: record");
        }
    }

    void a(String r1, String r2);
}
