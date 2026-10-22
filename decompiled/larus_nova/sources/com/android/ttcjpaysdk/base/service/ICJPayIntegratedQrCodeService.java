package com.android.ttcjpaysdk.base.service;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayIntegratedQrCodeService extends ICJPayService {
    Fragment getFragment();

    boolean isQrCodeFragment(Fragment r100);

    void release();

    void setCallBack(ICJPayIntegratedQrCodeServiceCallback r100);

    void setOutAnim(int r100);
}
