package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;

/* JADX INFO: loaded from: classes3.dex */
public class PhoneTeardownResult extends ComponentResult {
    public long mPhoneActiveTime;

    public PhoneTeardownResult(int phoneCurrent, long phoneActiveTime) {
        this.mCurrent = phoneCurrent;
        this.mPhoneActiveTime = phoneActiveTime;
    }

    public String toString() {
        long activeTimeToSecond = this.mPhoneActiveTime / 1000;
        return "[Phone] Phone current=" + this.mCurrent + "mA, phoneActiveTime=" + activeTimeToSecond + "s\n";
    }
}
