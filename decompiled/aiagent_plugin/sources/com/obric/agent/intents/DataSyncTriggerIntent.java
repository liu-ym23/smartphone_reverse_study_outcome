package com.obric.agent.intents;

import android.os.Parcelable;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemDataSyncTriggerIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemDataSyncTriggerParams;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.aa;
import d.o.o;

/* JADX INFO: compiled from: DataSyncTriggerIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DataSyncTriggerIntent extends BaseSystemDataSyncTriggerIntent {
    public DataSyncTriggerIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemDataSyncTriggerIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((SystemDataSyncTriggerParams) ZeusTransformUtils.preCheckCast(r6, SystemDataSyncTriggerParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemDataSyncTriggerIntent
    public Object doAction(SystemDataSyncTriggerParams r31, DispatchContext r32, d<? super IntentResult<Empty>> r33) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r33, d.class, "com.obric.aiagent.plugin");
        String r1 = r31.getAppletId();
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        ILogDepend.Companion.e(getName(), "appletId is null or blank");
        return new IntentResult(103, null, null, "appletId is required", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L12:
        IFlowAppIntentIDL r4 = r.a(aa.b(IFlowAppIntentIDL.class));
        if (r4 != null) goto L16;
        ILogDepend.Companion.e(getName(), "trigger data sync failed, ipc is null, appletId=" + r1);
        return new IntentResult(1, null, null, "trigger data sync failed, ipc is null", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L16:
        boolean r5 = r4.syncAppletData(r1);
        ILogDepend.Companion.i(getName(), "trigger data sync, appletId=" + r1 + ", success=" + r5);
        if (r5 == false) goto L20;
        return new IntentResult(0, null, null, "success!", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L20:
        return new IntentResult(1, null, null, "trigger data sync failed", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L5:
        if (o.d(r2) == true) goto L8;
        r3 = false;
        goto L9
    }
}
