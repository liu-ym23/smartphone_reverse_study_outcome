package com.bytedanceos.common.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class GroupInfo {
    ArrayList<AppInfo> contents;
    private int location;
    private String name;
    private int type;

    private GroupInfo(int r10, AppInfo r11) {
        this.contents = null;
        this.location = r10;
        ArrayList<AppInfo> r12 = new ArrayList();
        this.contents = r12;
        r12.add(r11);
    }

    public static GroupInfo createBanner(int r10, AppInfo r11) {
        return new GroupInfo(r10, r11).setType(2);
    }

    public static GroupInfo createGroup(String r10, int r11, ArrayList<AppInfo> r12) {
        return new GroupInfo(r10, r11, r12).setType(1);
    }

    public static GroupInfo createList(int r10, AppInfo r11) {
        return new GroupInfo(r10, r11).setType(3);
    }

    public static GroupInfo createNormal(int r10, AppInfo r11) {
        return new GroupInfo(r10, r11).setType(0);
    }

    public ArrayList<AppInfo> convert2List() {
        ArrayList<AppInfo> r10 = new ArrayList();
        ArrayList<AppInfo> r11 = this.contents;
        if (r11 != null) goto L5;
        return r10;
    L5:
        int r12 = this.type;
        if (r12 != 0) goto L8;
    L15:
        r10.addAll(r11);
    L16:
        return r10;
    L8:
        if (r12 != 1) goto L10;
        AppInfo r13 = new AppInfo();
        r13.appName = this.name;
        r13.mItemShowType = 4;
        r10.add(r13);
        r10.addAll(this.contents);
        goto L16
    L10:
        if (r12 == 2) goto L15;
        if (r12 == 3) goto L15;
        goto L15
    }

    public ArrayList<AppInfo> getContents() {
        return this.contents;
    }

    public int getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public void setLocation(int r10) {
        this.location = r10;
    }

    public void setName(String r10) {
        this.name = r10;
    }

    public GroupInfo setType(int r10) {
        this.type = r10;
        return this;
    }

    private GroupInfo(int r10, ArrayList<AppInfo> r11) {
        this.location = r10;
        this.contents = r11;
    }

    private GroupInfo(String r10, int r11, ArrayList<AppInfo> r12) {
        this.name = r10;
        this.location = r11;
        this.contents = r12;
    }
}
