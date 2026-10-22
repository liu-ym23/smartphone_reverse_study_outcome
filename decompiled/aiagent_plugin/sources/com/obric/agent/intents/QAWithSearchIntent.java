package com.obric.agent.intents;

import android.os.Parcelable;
import com.obric.agent.IAgentService;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemQAWithSearchIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemQAWithSearchParams;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: QAWithSearchIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class QAWithSearchIntent extends BaseSystemQAWithSearchIntent {
    @Override // com.obric.capabilitykit.common.intent.BaseSystemQAWithSearchIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public QAWithSearchIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemQAWithSearchIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((SystemQAWithSearchParams) ZeusTransformUtils.preCheckCast(r6, SystemQAWithSearchParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemQAWithSearchIntent
    public Object doAction(SystemQAWithSearchParams r17, DispatchContext r18, d<? super IntentResult<Empty>> r19) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r19, d.class, "com.obric.aiagent.plugin");
        IAgentService r1 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        r1.handleQAWithSearchIntent(r17.getEntities(), r17.getMessage(), r18);
    L5:
        IntentResult r2 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        r2.setDetails(r17.getMessage());
        return r2;
    }
}
