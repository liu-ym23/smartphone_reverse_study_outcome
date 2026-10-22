package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class ProfileBasicArea {

    @SerializedName("badge_list")
    public List<py.k> badgeList;

    @SerializedName("badge_suffix_map")
    public Map<Integer, ProfileBadgeSuffix> badgeSuffixMap;

    @SerializedName("grade_icon")
    public py.k gradeIcon;

    @SerializedName("has_owned_public_groups")
    int hasOwnedPublicGroups;

    public ProfileBasicArea() {
    }

    public boolean hasOwnedPublicGroups() {
        if (this.hasOwnedPublicGroups == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean notHasOwnedPublicGroups() {
        if (this.hasOwnedPublicGroups != 2) goto L5;
        return true;
    L5:
        return false;
    }
}
