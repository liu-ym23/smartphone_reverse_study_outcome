package com.obric.agent.intents.findphone;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemFindPhoneIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;

/* JADX INFO: compiled from: FindPhoneIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FindPhoneIntent extends BaseSystemFindPhoneIntent {
    public FindPhoneIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemFindPhoneIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((Empty) ZeusTransformUtils.preCheckCast(r6, Empty.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemFindPhoneIntent
    public Object doAction(Empty r17, DispatchContext r18, d<? super IntentResult<Empty>> r19) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r19, d.class, "com.obric.aiagent.plugin");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Intent r2 = new Intent(r1, FindPhoneActivity.class).addFlags(268435456);     // Catch: Exception -> L10
        o.c(r2, "addFlags(...)");     // Catch: Exception -> L10
        ZeusTransformUtils.startActivity(r1, r2, "com.obric.aiagent.plugin");     // Catch: Exception -> L10
        if (FindPhoneActivity.Companion.a(r1) == false) goto L7;
        String r3 = r1.getString(ZeusTransformUtils.mapRes(R.string.find_phone_result_with_all, WsChannelMultiProcessSharedProvider.STRING_TYPE, "find_phone_result_with_all"));     // Catch: Exception -> L10
    L8:
        String r5 = r3;
        o.a(r5);     // Catch: Exception -> L10
        return new IntentResult(0, null, null, r5, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L7:
        r3 = r1.getString(ZeusTransformUtils.mapRes(R.string.find_phone_result_ring_only, WsChannelMultiProcessSharedProvider.STRING_TYPE, "find_phone_result_ring_only"));     // Catch: Exception -> L10
    L10:
        e = move-exception;
        ILogDepend.Companion.e(getName(), "doAction e=" + e);
        return new IntentResult(1, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    }
}
