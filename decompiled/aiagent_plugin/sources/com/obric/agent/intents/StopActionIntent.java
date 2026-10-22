package com.obric.agent.intents;

import android.os.Parcelable;
import com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemStopActionIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemStopActionParams;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: StopActionIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StopActionIntent extends BaseSystemStopActionIntent {
    public StopActionIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemStopActionIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((SystemStopActionParams) ZeusTransformUtils.preCheckCast(r6, SystemStopActionParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemStopActionIntent
    public Object doAction(SystemStopActionParams r19, DispatchContext r20, d<? super IntentResult<Empty>> r21) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r21, d.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(getName(), "stopAction questionId:" + r19.getQuestionId() + " actionId:" + r19.getActionId() + " intentName:" + r19.getIntentName() + ", " + r19.getReason());
        IJobManagerApi r1 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        String r2 = r19.getQuestionId();
        String r3 = r19.getActionId();
        String r4 = r19.getIntentName();
        String r5 = r19.getReason();
        if (r5 != null) goto L7;
        r5 = "server_require";
    L7:
        r1.stopRunningAction(r2, r3, r4, r5);
    L9:
        return new IntentResult(0, null, null, "success!", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    }
}
