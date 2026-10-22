package com.obric.agent.intents;

import android.os.Parcelable;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent;
import com.obric.capabilitykit.common.intent.CommonViewEntitiesParams;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: TestViewEntities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TestViewEntities extends BaseCommonViewEntitiesIntent {
    @Override // com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public TestViewEntities() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((CommonViewEntitiesParams) ZeusTransformUtils.preCheckCast(r6, CommonViewEntitiesParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent
    public Object doAction(CommonViewEntitiesParams r17, DispatchContext r18, d<? super IntentResult<Empty>> r19) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r19, d.class, "com.obric.aiagent.plugin");
        AppEntity[] r1 = r17.getEntities();
        if (r1 == null) goto L7;
        int r2 = 0;
        int r3 = r1.length;
    L5:
        if (r2 >= r3) goto L7;
        ILogDepend.Companion.d("yuwei", "BaseCommonViewEntitiesIntent doAction " + r1[r2]);
        r2 = r2 + 1;
    L7:
        IntentResult r4 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        r4.setUiType(r4.getUiType() | UiType.FLAG_NO_FEEDBACK);
        return r4;
    }
}
