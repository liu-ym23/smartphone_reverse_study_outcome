package com.stepos.digitalwellbeing.server.net.category;

/* loaded from: classes.dex */
public class CategoryEntity {
    public static final int FINANCING = 105;
    public static final int GAME_VIDEO = 204;
    public static final int LIFE = 104;
    public static final int NEWS = 103;
    public static final int OFFICE = 339;
    public static final int OTHER = 9023;
    public static final int SHOPPING = 9014;
    public static final int SOCIAL = 106;
    public static final int SPORT = 344;
    public static final int STUDY = 338;
    public static final int SYSTEM_APP = 9999;
    public static final int UTILS = 100;
    public int cateId;
    public String pkg;
    public int sys;

    public String toString() {
        return "CategoryEntity{pkg='" + this.pkg + "', cateId=" + this.cateId + ", sys=" + this.sys + '}';
    }
}
