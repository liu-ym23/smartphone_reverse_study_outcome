package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public class PreStartProcInfo {
    private String mIdentity;
    private String mPkgName;
    private int mUid;

    public PreStartProcInfo(String pkgName, int uid, String identity) {
        this.mPkgName = pkgName;
        this.mIdentity = identity;
        this.mUid = uid;
    }

    public String getPkgName() {
        return this.mPkgName;
    }

    public int getUid() {
        return this.mUid;
    }

    public String getIdentity() {
        return this.mIdentity;
    }

    public String toString() {
        String info = "PreStartProcInfo{" + this.mPkgName + "," + this.mUid + "," + this.mIdentity + "}";
        return info;
    }
}
