package com.obric.autogui.common.api.platform.tasks;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IAutoActionTasksApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionTasksApi {

    /* JADX INFO: compiled from: IAutoActionTasksApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onReceiveKnowledge$default(IAutoActionTasksApi r2, String r3, int r4, String r5, String r6, int r7, Object r8) {
            IAutoActionTasksApi r9 = (IAutoActionTasksApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionTasksApi.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 8) == 0) goto L7;
            r6 = null;
        L7:
            r9.onReceiveKnowledge(r3, r4, r5, r6);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onReceiveKnowledge");
        }
    }

    void onReceiveKnowledge(String r1, int r2, String r3, String r4);
}
