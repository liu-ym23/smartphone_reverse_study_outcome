package com.byted.cast.common.bean;

/* JADX INFO: loaded from: classes39.dex */
public class DlnaUpnpErrorRepushSetting {
    private String mFriendlyNameList;
    private String mManufactureList;
    private int mRepushMode;

    public DlnaUpnpErrorRepushSetting() {
        this.mRepushMode = 0;
        this.mManufactureList = "";
        this.mFriendlyNameList = "";
    }

    public String getFriendlyNameList() {
        return this.mFriendlyNameList;
    }

    public String getManufactureList() {
        return this.mManufactureList;
    }

    public int getRepushMode() {
        return this.mRepushMode;
    }

    public void setFriendlyNameList(String r100) {
        this.mFriendlyNameList = r100;
    }

    public void setManufactureList(String r100) {
        this.mManufactureList = r100;
    }

    public void setRepushMode(int r100) {
        this.mRepushMode = r100;
    }
}
