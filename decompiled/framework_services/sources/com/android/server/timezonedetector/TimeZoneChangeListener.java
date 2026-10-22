package com.android.server.timezonedetector;

import android.util.IndentingPrintWriter;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public interface TimeZoneChangeListener {

    public static class TimeZoneChangeEvent {
        private final String mCause;
        private final long mElapsedRealtimeMillis;
        private final int mNewConfidence;
        private final String mNewZoneId;
        private final String mOldZoneId;
        private final int mOrigin;
        private final long mUnixEpochTimeMillis;
        private final int mUserId;

        public TimeZoneChangeEvent(long elapsedRealtimeMillis, long unixEpochTimeMillis, int origin, int userId, String oldZoneId, String newZoneId, int newConfidence, String cause) {
            this.mElapsedRealtimeMillis = elapsedRealtimeMillis;
            this.mUnixEpochTimeMillis = unixEpochTimeMillis;
            this.mOrigin = origin;
            this.mUserId = userId;
            oldZoneId.getClass();
            this.mOldZoneId = oldZoneId;
            newZoneId.getClass();
            this.mNewZoneId = newZoneId;
            this.mNewConfidence = newConfidence;
            cause.getClass();
            this.mCause = cause;
        }

        public long getElapsedRealtimeMillis() {
            return this.mElapsedRealtimeMillis;
        }

        public long getUnixEpochTimeMillis() {
            return this.mUnixEpochTimeMillis;
        }

        public int getOrigin() {
            return this.mOrigin;
        }

        public int getUserId() {
            return this.mUserId;
        }

        public String getOldZoneId() {
            return this.mOldZoneId;
        }

        public String getNewZoneId() {
            return this.mNewZoneId;
        }

        public String toString() {
            return "TimeZoneChangeEvent{mElapsedRealtimeMillis=" + this.mElapsedRealtimeMillis + ", mUnixEpochTimeMillis=" + this.mUnixEpochTimeMillis + ", mOrigin=" + this.mOrigin + ", mUserId=" + this.mUserId + ", mOldZoneId='" + this.mOldZoneId + "', mNewZoneId='" + this.mNewZoneId + "', mNewConfidence=" + this.mNewConfidence + ", mCause='" + this.mCause + "'}";
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof TimeZoneChangeEvent) == false) goto L26;
            TimeZoneChangeEvent that = (TimeZoneChangeEvent) o;
            if (this.mElapsedRealtimeMillis != that.mElapsedRealtimeMillis) goto L25;
            if (this.mUnixEpochTimeMillis != that.mUnixEpochTimeMillis) goto L25;
            if (this.mOrigin != that.mOrigin) goto L25;
            if (this.mUserId != that.mUserId) goto L25;
            if (Objects.equals(this.mOldZoneId, that.mOldZoneId) == false) goto L25;
            if (Objects.equals(this.mNewZoneId, that.mNewZoneId) == false) goto L25;
            if (this.mNewConfidence != that.mNewConfidence) goto L25;
            if (Objects.equals(this.mCause, that.mCause) == false) goto L25;
            return true;
        L25:
            return false;
        L26:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Long.valueOf(this.mElapsedRealtimeMillis), Long.valueOf(this.mUnixEpochTimeMillis), Integer.valueOf(this.mOrigin), Integer.valueOf(this.mUserId), this.mOldZoneId, this.mNewZoneId, Integer.valueOf(this.mNewConfidence), this.mCause});
        }
    }

    void dump(IndentingPrintWriter r1);

    void process(TimeZoneChangeEvent r1);
}
