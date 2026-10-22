package com.bytedance.safetyguard.lxc.internal.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SafetyGuardLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public interface e {

    /* JADX INFO: compiled from: SafetyGuardLogger.kt */
    public static final class a {
        public static /* synthetic */ void a(e r2, String r3, Throwable r4, d.h.a.a r5, int r6, Object r7) {
            e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
            d.h.a.a<String> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L7;
            r4 = null;
        L7:
            r8.a(r3, r4, r9);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
        }

        public static /* synthetic */ void b(e r2, String r3, Throwable r4, d.h.a.a r5, int r6, Object r7) {
            e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
            d.h.a.a<String> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L7;
            r4 = null;
        L7:
            r8.b(r3, r4, r9);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
        }
    }

    String a(String r1);

    void a(String r1, d.h.a.a<String> r2);

    void a(String r1, Throwable r2, d.h.a.a<String> r3);

    void b(String r1, d.h.a.a<String> r2);

    void b(String r1, Throwable r2, d.h.a.a<String> r3);
}
