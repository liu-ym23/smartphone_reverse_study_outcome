package com.android.server.twilight;

import android.text.format.DateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public final class TwilightState {
    private final long mSunriseTimeMillis;
    private final long mSunsetTimeMillis;

    public TwilightState(long sunriseTimeMillis, long sunsetTimeMillis) {
        this.mSunriseTimeMillis = sunriseTimeMillis;
        this.mSunsetTimeMillis = sunsetTimeMillis;
    }

    public long sunriseTimeMillis() {
        return this.mSunriseTimeMillis;
    }

    public LocalDateTime sunrise() {
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(this.mSunriseTimeMillis), zoneId);
    }

    public long sunsetTimeMillis() {
        return this.mSunsetTimeMillis;
    }

    public LocalDateTime sunset() {
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(this.mSunsetTimeMillis), zoneId);
    }

    public boolean isNight() {
        long now = System.currentTimeMillis();
        if (now >= this.mSunsetTimeMillis) goto L5;
    L7:
        return false;
    L5:
        if (now >= this.mSunriseTimeMillis) goto L7;
        return true;
    }

    public boolean equals(Object o) {
        if ((o instanceof TwilightState) == true) goto L5;
    L7:
        return false;
    L5:
        if (equals((TwilightState) o) == false) goto L7;
        return true;
    }

    public boolean equals(TwilightState other) {
        if (other != null) goto L4;
    L8:
        return false;
    L4:
        if (this.mSunriseTimeMillis != other.mSunriseTimeMillis) goto L8;
        if (this.mSunsetTimeMillis != other.mSunsetTimeMillis) goto L8;
        return true;
    }

    public int hashCode() {
        return Long.hashCode(this.mSunriseTimeMillis) ^ Long.hashCode(this.mSunsetTimeMillis);
    }

    public String toString() {
        return "TwilightState { sunrise=" + DateFormat.format("MM-dd HH:mm", this.mSunriseTimeMillis) + " sunset=" + DateFormat.format("MM-dd HH:mm", this.mSunsetTimeMillis) + " }";
    }
}
