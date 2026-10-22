package com.obric.autogui.agents.vlm.models.omni.intent;

import android.graphics.Bitmap;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: OmniPausedActionDispatchResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static /* synthetic */ IntentResult a(c r1, Map r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = ao.b();
    L6:
        return a(r1, r5);
    }

    public static final IntentResult<Bitmap> a(c r14, Map<String, String> r15) {
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        o.e(r14, "<this>");
        o.e(r16, "ext");
        IntentResult<Bitmap> r0 = new IntentResult(r14.a(), null, null, r14.b(), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        if ((!r16.isEmpty()) == false) goto L5;
        r0.setExt(new ConcurrentHashMap(r16));
    L5:
        return r0;
    }
}
