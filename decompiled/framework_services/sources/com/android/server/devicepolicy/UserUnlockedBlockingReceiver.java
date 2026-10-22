package com.android.server.devicepolicy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.server.am.ProcessList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class UserUnlockedBlockingReceiver extends BroadcastReceiver {
    private static final int WAIT_FOR_USER_UNLOCKED_TIMEOUT_SECONDS = 120;
    private final Semaphore mSemaphore;
    private final int mUserId;

    UserUnlockedBlockingReceiver(int userId) {
        this.mSemaphore = new Semaphore(0);
        this.mUserId = userId;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_UNLOCKED".equals(intent.getAction()) == true) goto L6;
        return;
    L6:
        if (intent.getIntExtra("android.intent.extra.user_handle", ProcessList.INVALID_ADJ) != this.mUserId) goto L9;
        this.mSemaphore.release();
        return;
    }

    public boolean waitForUserUnlocked() {
        return this.mSemaphore.tryAcquire(120, TimeUnit.SECONDS);
    L5:
        return false;
    }
}
