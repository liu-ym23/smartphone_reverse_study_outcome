package com.obric.aiagent.executionengine.capabilitymanager.api.intention;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IIntentionDataManagerApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IIntentionDataManagerApi {

    /* JADX INFO: compiled from: IIntentionDataManagerApi.kt */
    public static final class a {
        public static /* synthetic */ void a(IIntentionDataManagerApi r2, String r3, String r4, String r5, String r6, int r7, Object r8) {
            IIntentionDataManagerApi r9 = (IIntentionDataManagerApi) ZeusTransformUtils.wrapperContextForParams(r2, IIntentionDataManagerApi.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L13;
            if ((r7 & 4) == 0) goto L8;
            r5 = "";
        L8:
            if ((r7 & 8) == 0) goto L10;
            r6 = "";
        L10:
            r9.recordAppActionExecution(r3, r4, r5, r6);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordAppActionExecution");
        }
    }

    void init();

    void recordAppActionExecution(String r1, String r2, String r3, String r4);
}
