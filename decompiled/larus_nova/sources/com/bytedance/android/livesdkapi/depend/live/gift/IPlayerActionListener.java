package com.bytedance.android.livesdkapi.depend.live.gift;

import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface IPlayerActionListener {

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFirstFrame(IPlayerActionListener r100) {
        }

        public static void $default$onReportPlayMetrics(IPlayerActionListener r100, Map r101) {
        }
    }

    void onEnd();

    void onFileLoaded(int r100, int r101);

    void onFirstFrame();

    void onReportPlayMetrics(Map<String, String> r100);

    void onStart();

    void onStop();

    void updateTextEffectPosition(float r100, float r101, float r102, float r103);
}
