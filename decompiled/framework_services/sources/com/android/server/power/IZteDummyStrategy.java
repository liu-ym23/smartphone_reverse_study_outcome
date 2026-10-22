package com.android.server.power;

/* JADX INFO: loaded from: classes3.dex */
public interface IZteDummyStrategy {
    int getAllowSetStateOffTimeout();

    int getDummySleepAfterAnimTime();

    int getDummySleepDelayTime();

    boolean isStrategyOpened();

    void onBootCompletedPhase();

    void onSystemReady();
}
