package com.android.ttcjpaysdk.thirdparty.counter.activity;

import com.android.ttcjpaysdk.thirdparty.data.CJPayPaymentMethodInfo;

/* JADX INFO: loaded from: classes39.dex */
public interface ICJPayCheckoutCounter {
    void backToConfirmFragment(int r100);

    void closeAll();

    int getFragmentType();

    String getIdentityToken();

    CJPayPaymentMethodInfo getSelectedPaymentMethodInfo();

    void gotoBindCard(boolean r100);

    void gotoMethodFragment();

    int isInsufficientCard(String r100);

    void showFragment(int r100, int r101, boolean r102);

    void updateIdentityToken(String r100);

    void updatePaymentMethodFragmentType(String r100);
}
