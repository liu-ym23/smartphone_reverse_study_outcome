package com.android.server.policy;

import android.content.Context;
import android.view.KeyEvent;
import com.android.server.policy.keyguard.KeyguardServiceDelegate;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswPhoneWindowManager {
    void broadcastScreenOff(Context r1);

    void finishedWakingUp(int r1);

    void handleFreezer();

    void handleKeyGesture(KeyEvent r1);

    boolean handleScreenShot(Context r1);

    void init(Context r1);

    void interceptKeyBeforeDispatching(KeyEvent r1);

    boolean interceptKeyBeforeQueueing(Context r1, int r2, KeyEvent r3, KeyguardServiceDelegate r4);

    boolean interceptPowerKeyDown(KeyEvent r1);

    boolean interceptPowerKeyUp();

    boolean interceptPowerPress();

    boolean isInEmode(Context r1);

    boolean isMusicAppRunning(Context r1);

    void launchMusicPlayWhenhandsetInsert(Context r1);

    void shutdownWhenWizardFirst30Min(Context r1);
}
