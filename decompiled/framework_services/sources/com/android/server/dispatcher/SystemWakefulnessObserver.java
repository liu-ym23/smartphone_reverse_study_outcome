package com.android.server.dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public interface SystemWakefulnessObserver extends AbsDispatcher.IObserver {
    void onUpdateGlobalWakefulness(SystemWakefulnessEventDispatcher.GlobalWakefulness r1);

    void onWakefulnessChanged(SystemWakefulnessEventDispatcher.Wakefulness r1);
}
