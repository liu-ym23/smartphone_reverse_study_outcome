package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class ProfileFansClub {

    @SerializedName("data")
    ProfileFansClubData data;

    @SerializedName("total_fans_count_str")
    public String fansCountStr;

    @SerializedName("total_fans_count_substr")
    public String fansCountSubStr;

    @SerializedName("prefer_data")
    Map<Integer, ProfileFansClubData> preferData;

    @SerializedName("total_fans_count")
    public long totalFansCount;

    public ProfileFansClub() {
    }

    public ProfileFansClubData getData() {
        return this.data;
    }

    public Map<Integer, ProfileFansClubData> getPreferData() {
        return this.preferData;
    }

    public void setData(ProfileFansClubData r100) {
        this.data = r100;
    }

    public void setPreferData(Map<Integer, ProfileFansClubData> r100) {
        this.preferData = r100;
    }
}
