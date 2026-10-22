package com.android.server.policy;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.pico.utils.IExtBase;
import android.view.KeyEvent;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtPhoneWindowManager extends IExtBase {
    void dismissPreventTouchIfNeed(boolean r1, KeyEvent r2);

    void handleMemoryAction();

    void init(Context r1, Handler r2);

    boolean interceptKeyBeforeQueueing(KeyEvent r1, int r2);

    boolean interceptVolumeKeyWhenIsDreaming(AtomicInteger r1, KeyEvent r2);

    boolean interceptVolumeKeyWhenNotPassToUser(int r1, KeyEvent r2);

    boolean isTogglePowerAndAiKey();

    void onHandleKeycodeClick(KeyEvent r1);

    void onHandleKeycodeDoubleClick(boolean r1, long r2);

    void onHandleKeycodeReport(int r1, boolean r2);

    void onObserveSettings(ContentObserver r1);

    void onStartedGoingToSleep();

    void onStartedWakingUp();

    void onSystemReady();

    void onUpdateSettings();

    boolean performHapticFeedback(int r1, String r2, int r3, boolean r4, String r5, boolean r6);

    void setForceHideKeyguard(boolean r1);

    void togglePowerAndAiKey(boolean r1);

    void updatePocketMode(boolean r1);

    default boolean checkTopActivityForPowerKey(int keyCode, Context context) {
        return false;
    }
}
