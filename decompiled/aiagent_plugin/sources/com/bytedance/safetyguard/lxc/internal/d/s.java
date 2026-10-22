package com.bytedance.safetyguard.lxc.internal.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxySessionLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public interface s {

    /* JADX INFO: compiled from: ProxySessionLogger.kt */
    public static final class a {
        public static /* synthetic */ void a(s r2, String r3, String r4, Throwable r5, int r6, Object r7) {
            s r8 = (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L7;
            r5 = null;
        L7:
            r8.b(r3, r4, r5);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
        }
    }

    String a(String r1);

    void a(String r1, String r2);

    void a(String r1, String r2, Throwable r3);

    void b(String r1, String r2);

    void b(String r1, String r2, Throwable r3);
}
