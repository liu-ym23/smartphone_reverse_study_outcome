package com.bytedance.android.livesdk.chatroom;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/f;", "", "", "cityCode", "Ljava/lang/Long;", "getCityCode", "()Ljava/lang/Long;", "", "cityName", "Ljava/lang/String;", "getCityName", "()Ljava/lang/String;", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("city_code")
    private final Long cityCode;

    @SerializedName("city_name")
    private final String cityName;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.cityCode, r101.cityCode) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cityName, r101.cityName) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.cityCode;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.cityName;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CityInfo(cityCode=" + this.cityCode + ", cityName=" + this.cityName + ")";
    }

    public f() {
        this.cityCode = 0L;
        this.cityName = null;
    }
}
