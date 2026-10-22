package com.bytedanceos.common.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AppRecommend {
    private int mCheckedNum;
    private ArrayList<AppInfo> mDataList;

    public AppRecommend() {
    }

    public int getCheckedNum() {
        return this.mCheckedNum;
    }

    public ArrayList<AppInfo> getDataList() {
        return this.mDataList;
    }

    public boolean isEmpty() {
        ArrayList<AppInfo> r10 = this.mDataList;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.isEmpty() == true) goto L8;
        return false;
    }

    public void setCheckedNum(int r10) {
        this.mCheckedNum = r10;
    }

    public void setDataList(ArrayList<AppInfo> r10) {
        this.mDataList = r10;
    }
}
