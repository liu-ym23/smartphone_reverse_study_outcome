package com.obric.agent.intents.skill.a;

import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import d.h.b.o;

/* JADX INFO: compiled from: IntentActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final IntentResult<Empty> a(String r14) {
        o.e(r14, "details");
        IntentResult<Empty> r0 = new IntentResult(0, null, null, r14, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        r0.setFinal(false);
        return r0;
    }
}
