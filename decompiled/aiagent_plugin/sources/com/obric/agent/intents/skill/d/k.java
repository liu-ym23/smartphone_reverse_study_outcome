package com.obric.agent.intents.skill.d;

import com.obric.agent.ObricService;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;

/* JADX INFO: compiled from: SystemSkillResultStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static final IntentResult<Empty> a() {
        i r0 = new i(j.f15176a);
        IntentResult<Empty> r1 = new IntentResult(0, null, null, ObricService.INSTANCE.getGson().toJson(r0), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        r1.setFinal(false);
        return r1;
    }
}
