package com.obric.agent.intents;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseGUIReplyIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.GUIReplyParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: GUIReplyIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GUIReplyIntent extends BaseGUIReplyIntent {
    public GUIReplyIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseGUIReplyIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((GUIReplyParams) ZeusTransformUtils.preCheckCast(r6, GUIReplyParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseGUIReplyIntent
    public Object doAction(GUIReplyParams r15, DispatchContext r16, d<? super IntentResult<Empty>> r17) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r17, d.class, "com.obric.aiagent.plugin");
        r15.getContent();
        IntentResult r1 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        r1.setFinal(false);
        return r1;
    }
}
