package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m {
    public static final void a(ih0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        InteractiveSongContext r101 = InteractiveSongContext.Companion.getContext();
        if (r101 == null) goto L8;
        JsonObject r102 = r101.getRecordeLastSpeechRhythmBeats();
        if (r102 == null) goto L9;
        r100.Dk("audiochat_stage", "speech_effect", r102, false);
        return;
    L9:
        return;
    }
}
