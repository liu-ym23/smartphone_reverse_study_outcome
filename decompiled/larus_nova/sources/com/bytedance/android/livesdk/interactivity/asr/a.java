package com.bytedance.android.livesdk.interactivity.asr;

import com.bytedance.speech.speechengine.SpeechEngineLoader;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f133828a = null;

    static {
        int[] r100 = new int[SpeechEngineLoader.State.values().length];
        f133828a = r100;
        r100[SpeechEngineLoader.State.UNKNOWN.ordinal()] = 1;
        r100[SpeechEngineLoader.State.PLUGIN_NOT_EXIST.ordinal()] = 2;
        r100[SpeechEngineLoader.State.PLUGIN_LOADED.ordinal()] = 3;
    }
}
