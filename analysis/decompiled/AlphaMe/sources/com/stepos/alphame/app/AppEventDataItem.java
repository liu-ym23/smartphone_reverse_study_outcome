package com.stepos.alphame.app;

import B0.g;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.data.DataItem;

/* loaded from: classes.dex */
public class AppEventDataItem extends DataItem {
    public static final String APP_CREATE = "create";
    public static final String APP_HOME = "home";
    public static final String APP_PAUSE = "pause";
    public static final String APP_RESUME = "resume";
    public static final String APP_RESUME_MULTI = "resumeMulti";
    public boolean isSpecActivity;
    private String mEvent;
    public String mPid;
    private String mPkgName;
    private String mActivityName = "";
    private String mUserId = "0";
    public boolean mIsMultiWindowMode = false;

    @NotProguard
    public void fill(String str, String str2) {
        this.mPkgName = str;
        this.mEvent = str2;
        this.isSpecActivity = false;
    }

    public String getActivityName() {
        return this.mActivityName;
    }

    public String getEvent() {
        return this.mEvent;
    }

    public String getPkgName() {
        return this.mPkgName;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String toString() {
        String str = this.mPkgName;
        String str2 = this.mEvent;
        String str3 = this.mActivityName;
        String str4 = this.mUserId;
        StringBuilder sbX = g.x("[pkgName=", str, " event=", str2, " activityName=");
        sbX.append(str3);
        sbX.append(" userId=");
        sbX.append(str4);
        sbX.append("]");
        return sbX.toString();
    }

    @NotProguard
    public void fill(String str, String str2, String str3, String str4) {
        this.mPkgName = str;
        this.mEvent = APP_RESUME_MULTI.equals(str2) ? "resume" : str2;
        this.mActivityName = str3;
        this.mUserId = str4;
        this.mIsMultiWindowMode = APP_RESUME_MULTI.equals(str2);
        this.mPid = null;
        this.isSpecActivity = true;
    }

    @NotProguard
    public void fill(String str, String str2, String str3, String str4, String str5) {
        this.mPkgName = str;
        this.mEvent = APP_RESUME_MULTI.equals(str2) ? "resume" : str2;
        this.mActivityName = str3;
        this.mUserId = str4;
        this.mPid = str5;
        this.mIsMultiWindowMode = APP_RESUME_MULTI.equals(str2);
        this.isSpecActivity = true;
    }
}
