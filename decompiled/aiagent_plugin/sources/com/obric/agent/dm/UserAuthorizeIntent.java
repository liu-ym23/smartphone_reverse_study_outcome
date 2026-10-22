package com.obric.agent.dm;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemUserAuthorizeIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemUserAuthorizeParams;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: UserAuthorizeIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAuthorizeIntent extends BaseSystemUserAuthorizeIntent {
    public UserAuthorizeIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemUserAuthorizeIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((SystemUserAuthorizeParams) ZeusTransformUtils.preCheckCast(r6, SystemUserAuthorizeParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemUserAuthorizeIntent
    public Object doAction(SystemUserAuthorizeParams r15, DispatchContext r16, d.c.d<? super IntentResult<Empty>> r17) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    }
}
