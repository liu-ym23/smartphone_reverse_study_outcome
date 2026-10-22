package com.stepos.alphame.utils;

import android.os.Looper;
import android.os.NetworkOnMainThreadException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Waiter {
    public static final int TIMEOUT = -1;
    public int mErrorCode;
    public Object mExtra;
    private CountDownLatch mWaiter = new CountDownLatch(1);

    public boolean isFinished() {
        return this.mWaiter.getCount() < 1;
    }

    public void lock(long j4) throws InterruptedException {
        if (this.mWaiter.getCount() < 1) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new NetworkOnMainThreadException();
        }
        try {
            if (j4 <= 0) {
                this.mWaiter.await();
            } else if (!this.mWaiter.await(j4, TimeUnit.MILLISECONDS)) {
                this.mErrorCode = -1;
            }
        } catch (InterruptedException e4) {
            e4.printStackTrace();
            this.mErrorCode = -1;
        }
    }

    public void unlock() {
        this.mWaiter.countDown();
    }
}
