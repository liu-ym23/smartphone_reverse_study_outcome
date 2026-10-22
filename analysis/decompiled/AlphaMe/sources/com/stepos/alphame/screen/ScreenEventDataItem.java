package com.stepos.alphame.screen;

import android.os.SystemClock;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.data.DataItem;
import java.util.Calendar;

/* loaded from: classes.dex */
public class ScreenEventDataItem extends DataItem {
    public static final int EVENT_OFF = 0;
    public static final int EVENT_ON = 1;
    private long mElapsedTime;
    private int mEvent;
    private long mRtcTime;

    @NotProguard
    public void fill(int i4) {
        Calendar.getInstance();
        fill(i4, System.currentTimeMillis(), SystemClock.elapsedRealtime());
    }

    public long getElapsedTime() {
        return this.mElapsedTime;
    }

    public int getEvent() {
        return this.mEvent;
    }

    public long getRtcTime() {
        return this.mRtcTime;
    }

    public String toString() {
        return String.format("[event=%d rtc=%d elapsed=%d]", Integer.valueOf(this.mEvent), Long.valueOf(this.mRtcTime), Long.valueOf(this.mElapsedTime));
    }

    @NotProguard
    public void fill(int i4, long j4, long j5) {
        this.mEvent = i4;
        this.mRtcTime = j4;
        this.mElapsedTime = j5;
    }
}
