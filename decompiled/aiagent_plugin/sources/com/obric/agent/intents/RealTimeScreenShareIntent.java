package com.obric.agent.intents;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseDoubaoRealTimeScreenShareIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: RealTimeScreenShareIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RealTimeScreenShareIntent extends BaseDoubaoRealTimeScreenShareIntent {
    public RealTimeScreenShareIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseDoubaoRealTimeScreenShareIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((Empty) ZeusTransformUtils.preCheckCast(r6, Empty.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseDoubaoRealTimeScreenShareIntent
    public Object doAction(Empty r1, DispatchContext r2, d<? super IntentResult<Empty>> r3) {
        return b.a(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
    }
}
