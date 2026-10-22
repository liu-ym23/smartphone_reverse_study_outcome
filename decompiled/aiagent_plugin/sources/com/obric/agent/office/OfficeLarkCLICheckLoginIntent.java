package com.obric.agent.office;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseOfficeLarkCLICheckLoginIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OfficeLarkCLICheckLoginIntent extends BaseOfficeLarkCLICheckLoginIntent {
    @Override // com.obric.capabilitykit.common.intent.BaseOfficeLarkCLICheckLoginIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public OfficeLarkCLICheckLoginIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseOfficeLarkCLICheckLoginIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((Empty) ZeusTransformUtils.preCheckCast(r6, Empty.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseOfficeLarkCLICheckLoginIntent
    public Object doAction(Empty r1, DispatchContext r2, d.c.d<? super IntentResult<Empty>> r3) {
        d.c.d<? super IntentResult<Empty>> r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return c.f15302a.a(d.a(r2.getExt()), r0);
    }
}
