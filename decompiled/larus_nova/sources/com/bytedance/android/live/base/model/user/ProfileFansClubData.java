package com.bytedance.android.live.base.model.user;

import android.text.TextUtils;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class ProfileFansClubData {

    @SerializedName("anchor_id")
    public long anchorId;

    @SerializedName("available_gift_ids")
    public List<Long> availableGiftIds;

    @SerializedName(IAllianceService.CONTENT_TYPE_BADGE)
    public ProfileUserBadge badge;

    @SerializedName("club_name")
    public String clubName;

    @SerializedName("level")
    public int level;

    @SerializedName("user_fans_club_status")
    public int userFansClubStatus;

    public static class ProfileUserBadge {

        @SerializedName("icons")
        public Map<Integer, py.k> icons;

        @SerializedName("title")
        public String title;

        public ProfileUserBadge() {
        }

        public py.k getToShowIcon() {
            Map<Integer, py.k> r100 = this.icons;
            if (r100 != null) goto L6;
            return null;
        L6:
            if (r100.get(6) == null) goto L9;
            return this.icons.get(6);
        L9:
            if (this.icons.get(5) == null) goto L12;
            return this.icons.get(5);
        L12:
            if (this.icons.get(4) != null) goto L14;
            return null;
        L14:
            return this.icons.get(4);
        }

        public py.k getToShowShopFansClubIcon() {
            Map<Integer, py.k> r100 = this.icons;
            if (r100 != null) goto L6;
            return null;
        L6:
            if (r100.get(2) == null) goto L11;
            py.k r101 = this.icons.get(2);
            if (r101 == null) goto L14;
            r101.setImageType(57);
            return r101;
        L14:
            return r101;
        L11:
            if (this.icons.get(1) != null) goto L13;
            return null;
        L13:
            return this.icons.get(1);
        }
    }

    public ProfileFansClubData() {
    }

    public static boolean isValid(ProfileFansClubData r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty(r100.clubName) == true) goto L6;
        return true;
    }
}
