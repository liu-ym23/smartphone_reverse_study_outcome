package com.android.server.soundtrigger_middleware;

/* JADX INFO: loaded from: classes3.dex */
interface ICaptureStateNotifier {

    public interface Listener {
        void onCaptureStateChange(boolean r1);
    }

    boolean registerListener(Listener r1);

    void unregisterListener(Listener r1);
}
