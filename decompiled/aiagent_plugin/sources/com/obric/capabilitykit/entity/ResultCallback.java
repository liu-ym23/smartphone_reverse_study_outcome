package com.obric.capabilitykit.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public interface ResultCallback<T> {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(ResultCallback r2, int r3, String r4, Object r5, int r6, Object r7) {
            ResultCallback r8 = (ResultCallback) ZeusTransformUtils.wrapperContextForParams(r2, ResultCallback.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L7;
            r5 = null;
        L7:
            r8.onResult(r3, r4, r5);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResult");
        }
    }

    void onResult(int r1, String r2, T r3);
}
