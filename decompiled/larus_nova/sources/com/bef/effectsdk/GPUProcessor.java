package com.bef.effectsdk;

import com.bef.effectsdk.message.MessageCenter;

/* JADX INFO: loaded from: classes39.dex */
public class GPUProcessor {
    private static Listener sListener;

    public interface Listener {
        void onMessageReceived(int r100, int r101, int r102, String r103);
    }

    public GPUProcessor() {
    }

    public static void destroy() {
        MessageCenter.destroy();
        sListener = null;
    }

    public static void init() {
        MessageCenter.init();
        MessageCenter.setListener(new AnonymousClass1());
    }

    public static /* synthetic */ Listener access$000() {
        return sListener;
    }

    public static void setListener(Listener r100) {
        sListener = r100;
    }
}
