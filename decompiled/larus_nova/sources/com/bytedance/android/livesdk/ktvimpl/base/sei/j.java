package com.bytedance.android.livesdk.ktvimpl.base.sei;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class j implements md0.a.c {
    public j() {
    }

    @Override // md0.a.InterfaceC6802a
    public final boolean isVersionSupported(int r100, int r101) {
        return true;
    }

    @Override // md0.a.c
    public final void onAudioMvControllerUpdate(String r100) {
    }

    @Override // md0.a.c
    public final void onAudioSubtitleUpdate(String r100) {
    }

    @Override // md0.a.InterfaceC6802a
    public final /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r100) {
    }

    @Override // md0.a.c
    public final void onRadioSeiUpdate(JSONObject r100) {
    }

    @Override // md0.a.c
    public final void onRadioTextSeiUpdate(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "seiObj");
    }

    @Override // md0.a.c
    public final void onSpeechRecognitionSeiUpdate(String r100) {
    }

    @Override // md0.a.c
    public final /* synthetic */ void onSpeechRhythm(String r100) {
    }

    @Override // md0.a.c
    public final void onVideoStateSeiUpdate(ld0.a r100) {
    }
}
