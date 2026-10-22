package com.android.server.companion.devicepresence;

import android.os.ParcelUuid;

/* JADX INFO: loaded from: classes.dex */
public class ObservableUuid {
    private final String mPackageName;
    private final long mTimeApprovedMs;
    private final int mUserId;
    private final ParcelUuid mUuid;

    public ObservableUuid(int userId, ParcelUuid uuid, String packageName, Long timeApprovedMs) {
        this.mUserId = userId;
        this.mUuid = uuid;
        this.mPackageName = packageName;
        this.mTimeApprovedMs = timeApprovedMs.longValue();
    }

    public int getUserId() {
        return this.mUserId;
    }

    public ParcelUuid getUuid() {
        return this.mUuid;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public long getTimeApprovedMs() {
        return this.mTimeApprovedMs;
    }
}
