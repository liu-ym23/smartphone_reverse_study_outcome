package com.bef.effectsdk;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class EffectSDKBuildConfig {
    private static int ENABLE_AUDIO_EFFECT = 0;
    private static int ENABLE_BORINGSSL = 0;
    private static int ENABLE_BYTEBENCH = 0;
    private static int ENABLE_FFMPEG = 1;
    private static int ENABLE_IES_APPLOGGER = 1;
    private static int ENABLE_JAZZ = 1;
    private static int ENABLE_LENS;
    private static int ENABLE_SPEECH_ASR;
    private static int ENABLE_SPEECH_CAPT;
    private static int ENABLE_VC0;

    public EffectSDKBuildConfig() {
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static List<String> getEffectLibs() {
        ArrayList r100 = new ArrayList();
        r100.add("c++_shared");
        if (ENABLE_BYTEBENCH != 1) goto L6;
        r100.add("bytebench");
    L6:
        if (ENABLE_BORINGSSL != 1) goto L8;
    L9:
        r100.add("ttcrypto");
        r100.add("ttboringssl");
    L11:
        if (ENABLE_FFMPEG != 1) goto L14;
        r100.add("ttffmpeg");
    L14:
        if (ENABLE_IES_APPLOGGER != 1) goto L16;
        r100.add("iesapplogger");
    L16:
        r100.add("bytenn");
        if (ENABLE_AUDIO_EFFECT != 1) goto L20;
        r100.add(com.mammon.audiosdk.BuildConfig.LIBNAME);
    L20:
        if (ENABLE_SPEECH_CAPT != 1) goto L22;
    L23:
        r100.add("speechsdk");
    L24:
        r100.add("gaia_lib");
        r100.add("AGFX");
        if (ENABLE_LENS != 1) goto L28;
        r100.add("lens");
    L28:
        if (ENABLE_JAZZ != 1) goto L31;
        r100.add("napi");
        r100.add("quick");
        r100.add("jazz");
    L31:
        if (ENABLE_VC0 != 1) goto L33;
        r100.add("bytevc0");
    L33:
        r100.add("effect");
        return r100;
    L22:
        if (ENABLE_SPEECH_ASR != 1) goto L24;
    L8:
        if (ENABLE_FFMPEG != 1) goto L11;
        goto L9
    }

    public static String getAarVersion() {
        return BuildConfig.FULL_VERSION;
    }
}
