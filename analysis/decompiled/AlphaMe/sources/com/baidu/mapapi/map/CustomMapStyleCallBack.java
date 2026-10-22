package com.baidu.mapapi.map;

/* loaded from: classes.dex */
public interface CustomMapStyleCallBack {
    boolean onCustomMapStyleLoadFailed(int i4, String str, String str2);

    boolean onCustomMapStyleLoadSuccess(boolean z4, String str);

    boolean onPreLoadLastCustomMapStyle(String str);
}
