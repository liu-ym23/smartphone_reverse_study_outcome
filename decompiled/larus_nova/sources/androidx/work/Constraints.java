package androidx.work;

import android.net.Uri;
import android.os.Build;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes17.dex */
public final class Constraints {
    public static final Constraints NONE = null;
    private ContentUriTriggers mContentUriTriggers;
    private NetworkType mRequiredNetworkType;
    private boolean mRequiresBatteryNotLow;
    private boolean mRequiresCharging;
    private boolean mRequiresDeviceIdle;
    private boolean mRequiresStorageNotLow;
    private long mTriggerContentUpdateDelay;
    private long mTriggerMaxContentDelay;

    public static final class Builder {
        ContentUriTriggers mContentUriTriggers;
        NetworkType mRequiredNetworkType;
        boolean mRequiresBatteryNotLow;
        boolean mRequiresCharging;
        boolean mRequiresDeviceIdle;
        boolean mRequiresStorageNotLow;
        long mTriggerContentMaxDelay;
        long mTriggerContentUpdateDelay;

        public Constraints build() {
            return new Constraints(this);
        }

        public Builder() {
            this.mRequiresCharging = false;
            this.mRequiresDeviceIdle = false;
            this.mRequiredNetworkType = NetworkType.NOT_REQUIRED;
            this.mRequiresBatteryNotLow = false;
            this.mRequiresStorageNotLow = false;
            this.mTriggerContentUpdateDelay = -1;
            this.mTriggerContentMaxDelay = -1;
            this.mContentUriTriggers = new ContentUriTriggers();
        }

        public Builder(Constraints r100) {
            boolean r101 = false;
            this.mRequiresCharging = false;
            this.mRequiresDeviceIdle = false;
            this.mRequiredNetworkType = NetworkType.NOT_REQUIRED;
            this.mRequiresBatteryNotLow = false;
            this.mRequiresStorageNotLow = false;
            this.mTriggerContentUpdateDelay = -1;
            this.mTriggerContentMaxDelay = -1;
            this.mContentUriTriggers = new ContentUriTriggers();
            this.mRequiresCharging = r100.requiresCharging();
            int r102 = Build.VERSION.SDK_INT;
            if (r102 >= 23) goto L5;
        L7:
            this.mRequiresDeviceIdle = r101;
            this.mRequiredNetworkType = r100.getRequiredNetworkType();
            this.mRequiresBatteryNotLow = r100.requiresBatteryNotLow();
            this.mRequiresStorageNotLow = r100.requiresStorageNotLow();
            if (r102 < 24) goto L11;
            this.mTriggerContentUpdateDelay = r100.getTriggerContentUpdateDelay();
            this.mTriggerContentMaxDelay = r100.getTriggerMaxContentDelay();
            this.mContentUriTriggers = r100.getContentUriTriggers();
            return;
        L11:
            return;
        L5:
            if (r100.requiresDeviceIdle() == false) goto L7;
            r101 = true;
            goto L7
        }

        public Builder setRequiredNetworkType(NetworkType r100) {
            this.mRequiredNetworkType = r100;
            return this;
        }

        public Builder setRequiresBatteryNotLow(boolean r100) {
            this.mRequiresBatteryNotLow = r100;
            return this;
        }

        public Builder setRequiresCharging(boolean r100) {
            this.mRequiresCharging = r100;
            return this;
        }

        public Builder setRequiresDeviceIdle(boolean r100) {
            this.mRequiresDeviceIdle = r100;
            return this;
        }

        public Builder setRequiresStorageNotLow(boolean r100) {
            this.mRequiresStorageNotLow = r100;
            return this;
        }

        public Builder setTriggerContentMaxDelay(Duration r100) {
            this.mTriggerContentMaxDelay = r100.toMillis();
            return this;
        }

        public Builder setTriggerContentUpdateDelay(Duration r100) {
            this.mTriggerContentUpdateDelay = r100.toMillis();
            return this;
        }

        public Builder addContentUriTrigger(Uri r100, boolean r101) {
            this.mContentUriTriggers.add(r100, r101);
            return this;
        }

        public Builder setTriggerContentMaxDelay(long r100, TimeUnit r101) {
            this.mTriggerContentMaxDelay = r101.toMillis(r100);
            return this;
        }

        public Builder setTriggerContentUpdateDelay(long r100, TimeUnit r101) {
            this.mTriggerContentUpdateDelay = r101.toMillis(r100);
            return this;
        }
    }

    static {
        NONE = new Builder().build();
    }

    public boolean hasContentUriTriggers() {
        if (this.mContentUriTriggers.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        int r100 = ((((((((this.mRequiredNetworkType.hashCode() * 31) + (this.mRequiresCharging ? 1 : 0)) * 31) + (this.mRequiresDeviceIdle ? 1 : 0)) * 31) + (this.mRequiresBatteryNotLow ? 1 : 0)) * 31) + (this.mRequiresStorageNotLow ? 1 : 0)) * 31;
        long r101 = this.mTriggerContentUpdateDelay;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.mTriggerMaxContentDelay;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.mContentUriTriggers.hashCode();
    }

    public Constraints() {
        this.mRequiredNetworkType = NetworkType.NOT_REQUIRED;
        this.mTriggerContentUpdateDelay = -1;
        this.mTriggerMaxContentDelay = -1;
        this.mContentUriTriggers = new ContentUriTriggers();
    }

    public ContentUriTriggers getContentUriTriggers() {
        return this.mContentUriTriggers;
    }

    public NetworkType getRequiredNetworkType() {
        return this.mRequiredNetworkType;
    }

    public long getTriggerContentUpdateDelay() {
        return this.mTriggerContentUpdateDelay;
    }

    public long getTriggerMaxContentDelay() {
        return this.mTriggerMaxContentDelay;
    }

    public boolean requiresBatteryNotLow() {
        return this.mRequiresBatteryNotLow;
    }

    public boolean requiresCharging() {
        return this.mRequiresCharging;
    }

    public boolean requiresDeviceIdle() {
        return this.mRequiresDeviceIdle;
    }

    public boolean requiresStorageNotLow() {
        return this.mRequiresStorageNotLow;
    }

    public Constraints(Builder r100) {
        this.mRequiredNetworkType = NetworkType.NOT_REQUIRED;
        this.mTriggerContentUpdateDelay = -1;
        this.mTriggerMaxContentDelay = -1;
        this.mContentUriTriggers = new ContentUriTriggers();
        this.mRequiresCharging = r100.mRequiresCharging;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 23) goto L5;
    L7:
        boolean r102 = false;
    L8:
        this.mRequiresDeviceIdle = r102;
        this.mRequiredNetworkType = r100.mRequiredNetworkType;
        this.mRequiresBatteryNotLow = r100.mRequiresBatteryNotLow;
        this.mRequiresStorageNotLow = r100.mRequiresStorageNotLow;
        if (r101 < 24) goto L12;
        this.mContentUriTriggers = r100.mContentUriTriggers;
        this.mTriggerContentUpdateDelay = r100.mTriggerContentUpdateDelay;
        this.mTriggerMaxContentDelay = r100.mTriggerContentMaxDelay;
        return;
    L12:
        return;
    L5:
        if (r100.mRequiresDeviceIdle == false) goto L7;
        r102 = true;
        goto L8
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L33:
        return false;
    L8:
        if (Constraints.class != r100.getClass()) goto L33;
        Constraints r101 = (Constraints) r100;
        if (this.mRequiresCharging == r101.mRequiresCharging) goto L14;
        return false;
    L14:
        if (this.mRequiresDeviceIdle == r101.mRequiresDeviceIdle) goto L17;
        return false;
    L17:
        if (this.mRequiresBatteryNotLow == r101.mRequiresBatteryNotLow) goto L20;
        return false;
    L20:
        if (this.mRequiresStorageNotLow == r101.mRequiresStorageNotLow) goto L23;
        return false;
    L23:
        if (this.mTriggerContentUpdateDelay == r101.mTriggerContentUpdateDelay) goto L26;
        return false;
    L26:
        if (this.mTriggerMaxContentDelay == r101.mTriggerMaxContentDelay) goto L29;
        return false;
    L29:
        if (this.mRequiredNetworkType == r101.mRequiredNetworkType) goto L32;
        return false;
    L32:
        return this.mContentUriTriggers.equals(r101.mContentUriTriggers);
    }

    public void setContentUriTriggers(ContentUriTriggers r100) {
        this.mContentUriTriggers = r100;
    }

    public void setRequiredNetworkType(NetworkType r100) {
        this.mRequiredNetworkType = r100;
    }

    public void setRequiresBatteryNotLow(boolean r100) {
        this.mRequiresBatteryNotLow = r100;
    }

    public void setRequiresCharging(boolean r100) {
        this.mRequiresCharging = r100;
    }

    public void setRequiresDeviceIdle(boolean r100) {
        this.mRequiresDeviceIdle = r100;
    }

    public void setRequiresStorageNotLow(boolean r100) {
        this.mRequiresStorageNotLow = r100;
    }

    public void setTriggerContentUpdateDelay(long r100) {
        this.mTriggerContentUpdateDelay = r100;
    }

    public void setTriggerMaxContentDelay(long r100) {
        this.mTriggerMaxContentDelay = r100;
    }

    public Constraints(Constraints r100) {
        this.mRequiredNetworkType = NetworkType.NOT_REQUIRED;
        this.mTriggerContentUpdateDelay = -1;
        this.mTriggerMaxContentDelay = -1;
        this.mContentUriTriggers = new ContentUriTriggers();
        this.mRequiresCharging = r100.mRequiresCharging;
        this.mRequiresDeviceIdle = r100.mRequiresDeviceIdle;
        this.mRequiredNetworkType = r100.mRequiredNetworkType;
        this.mRequiresBatteryNotLow = r100.mRequiresBatteryNotLow;
        this.mRequiresStorageNotLow = r100.mRequiresStorageNotLow;
        this.mContentUriTriggers = r100.mContentUriTriggers;
    }
}
