package com.obric.aiagent.executionengine.scheduler.impl.d;

import android.app.Application;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: CapabilityActionDispatcherExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final IntentResult<?> a() {
        IntentResult<?> r13 = new IntentResult(1, null, null, ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_failed")), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        ConcurrentHashMap<String, String> r0 = new ConcurrentHashMap();
        r0.put("binder_died_fail_tag", "1");
        r13.setExt(r0);
        return r13;
    }

    public static final boolean a(IntentResult<?> r3) {
        o.e(r3, "<this>");
        ConcurrentHashMap<String, String> r4 = r3.getExt();
        String r0 = null;
        if (r4 == null) goto L6;
        r0 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin")).getOrDefault("binder_died_fail_tag", null), String.class, "com.obric.aiagent.plugin");
    L6:
        return o.a(r0, "1");
    }
}
