package com.android.ttcjpaysdk.base.service;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayVerifyFastPayService extends ICJPayService {
    String getCheckList();

    boolean hasShownKeepDialog();

    void initVerifyComponents(Context r100, int r101, ICJPayVerifyFastPayParamsCallBack r102, ICJPayVerifyFastPayResultCallBack r103);

    boolean isEmpty();

    boolean onBackPressed();

    void release();

    void setHashShownKeepDialog();

    void setPayMethod(String r100);

    void start(String r100, int r101, int r102, boolean r103);

    boolean whenBackPressedExit();
}
