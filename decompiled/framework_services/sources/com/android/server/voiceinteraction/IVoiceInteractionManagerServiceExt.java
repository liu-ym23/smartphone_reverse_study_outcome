package com.android.server.voiceinteraction;

import android.prometheus.ext.core.ExtLoader;

/* JADX INFO: loaded from: classes3.dex */
public class IVoiceInteractionManagerServiceExt {
    public IVoiceInteractionManagerServiceExt() {
    }

    public static IVoiceInteractionManagerServiceExt get(VoiceInteractionManagerService base) {
        return (IVoiceInteractionManagerServiceExt) ExtLoader.get(IVoiceInteractionManagerServiceExt.class, base);
    }

    protected boolean showSession_skipPermissionCheck() {
        return false;
    }
}
