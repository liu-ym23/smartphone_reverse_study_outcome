package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayAlipayAuthCallback;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayAlipayAuthService extends ICJPayService {
    void authAlipay(Activity r100, String r101, boolean r102, TTCJPayAlipayAuthCallback r103);
}
