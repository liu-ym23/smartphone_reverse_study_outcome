package com.obric.agent.office;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseOfficeLarkCLIEnsureAuthIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.OfficeLarkCLIEnsureAuthParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OfficeLarkCLIEnsureAuthIntent extends BaseOfficeLarkCLIEnsureAuthIntent {
    @Override // com.obric.capabilitykit.common.intent.BaseOfficeLarkCLIEnsureAuthIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public OfficeLarkCLIEnsureAuthIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseOfficeLarkCLIEnsureAuthIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((OfficeLarkCLIEnsureAuthParams) ZeusTransformUtils.preCheckCast(r6, OfficeLarkCLIEnsureAuthParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseOfficeLarkCLIEnsureAuthIntent
    public Object doAction(OfficeLarkCLIEnsureAuthParams r2, DispatchContext r3, d.c.d<? super IntentResult<Empty>> r4) {
        d.c.d<? super IntentResult<Empty>> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return c.f15302a.a(r2, r3, r1);
    }
}
