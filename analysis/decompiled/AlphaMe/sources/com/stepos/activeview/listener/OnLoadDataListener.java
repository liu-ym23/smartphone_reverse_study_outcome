package com.stepos.activeview.listener;

/* loaded from: classes.dex */
public interface OnLoadDataListener {
    public static final int LOAD_FAIL = 0;
    public static final int LOAD_SUCESS = 1;

    <T> void onLoadDataResult(int i4, T t4);
}
