package com.bytedance.android.livesdk.bottomguide;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/bottomguide/g;", "", "", "dailyShowLimit", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "minShowInterval", "J", "c", "()J", "totalShowLimit", "e", "newUserProtectionSecond", "d", "enterRoomWaitSecond", "b", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("daily_show_limit")
    private final int dailyShowLimit;

    @SerializedName("enter_room_wait_second")
    private final long enterRoomWaitSecond;

    @SerializedName("min_show_interval")
    private final long minShowInterval;

    @SerializedName("new_user_protection_second")
    private final long newUserProtectionSecond;

    @SerializedName("total_show_limit")
    private final int totalShowLimit;

    public g() {
        this(0, 0, 0, 0, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L16;
        g r101 = (g) r100;
        if (this.dailyShowLimit == r101.dailyShowLimit) goto L8;
        return false;
    L8:
        if (this.minShowInterval == r101.minShowInterval) goto L10;
        return false;
    L10:
        if (this.totalShowLimit == r101.totalShowLimit) goto L12;
        return false;
    L12:
        if (this.newUserProtectionSecond == r101.newUserProtectionSecond) goto L14;
        return false;
    L14:
        if (this.enterRoomWaitSecond == r101.enterRoomWaitSecond) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.dailyShowLimit * 31;
        long r101 = this.minShowInterval;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.totalShowLimit) * 31;
        long r103 = this.newUserProtectionSecond;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.enterRoomWaitSecond;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    }

    public final String toString() {
        return "GuideBarThresholdConfig(dailyShowLimit=" + this.dailyShowLimit + ", minShowInterval=" + this.minShowInterval + ", totalShowLimit=" + this.totalShowLimit + ", newUserProtectionSecond=" + this.newUserProtectionSecond + ", enterRoomWaitSecond=" + this.enterRoomWaitSecond + ")";
    }

    public final int a() {
        return this.dailyShowLimit;
    }

    public final long b() {
        return this.enterRoomWaitSecond;
    }

    public final long c() {
        return this.minShowInterval;
    }

    public final long d() {
        return this.newUserProtectionSecond;
    }

    public final int e() {
        return this.totalShowLimit;
    }

    public g(int r100, long r101, int r102, long r103, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r110 & 16) == 0) goto L14;
        r103 = 0;
    L14:
        this.dailyShowLimit = r100;
        this.minShowInterval = r101;
        this.totalShowLimit = r102;
        this.newUserProtectionSecond = 0;
        this.enterRoomWaitSecond = r103;
    }
}
