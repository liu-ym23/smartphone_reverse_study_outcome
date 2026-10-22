package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CliUpdateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface m {

    /* JADX INFO: compiled from: CliUpdateRepository.kt */
    public static final class a {
        public static /* synthetic */ void a(m r2, String r3, Throwable r4, int r5, Object r6) {
            m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L7;
            r4 = null;
        L7:
            r7.a(r3, r4);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warning");
        }
    }

    void a(String r1);

    void a(String r1, Throwable r2);
}
