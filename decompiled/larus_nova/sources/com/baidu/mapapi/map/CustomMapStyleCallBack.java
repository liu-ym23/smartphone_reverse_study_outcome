package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public interface CustomMapStyleCallBack {
    boolean onCustomMapStyleLoadFailed(int r100, String r101, String r102);

    boolean onCustomMapStyleLoadSuccess(boolean r100, String r101);

    boolean onPreLoadLastCustomMapStyle(String r100);
}
