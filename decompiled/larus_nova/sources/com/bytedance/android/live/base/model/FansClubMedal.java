package com.bytedance.android.live.base.model;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class FansClubMedal {

    @SerializedName("anchor")
    private User anchor;

    @SerializedName(IAllianceService.CONTENT_TYPE_BADGE)
    private Badge badge;

    @SerializedName("intimacy")
    private int intimacy;
    private boolean isSelected;

    @SerializedName("level")
    private int level;

    @SerializedName("status")
    private int status;

    public FansClubMedal() {
        this.isSelected = false;
    }

    public User getAnchor() {
        return this.anchor;
    }

    public Badge getBadge() {
        return this.badge;
    }

    public int getIntimacy() {
        return this.intimacy;
    }

    public int getLevel() {
        return this.level;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setAnchor(User r100) {
        this.anchor = r100;
    }

    public void setBadge(Badge r100) {
        this.badge = r100;
    }

    public void setIntimacy(int r100) {
        this.intimacy = r100;
    }

    public void setLevel(int r100) {
        this.level = r100;
    }

    public void setSelected(boolean r100) {
        this.isSelected = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }
}
