package com.android.ttcjpaysdk.base.paymentbasis;

import com.android.ttcjpaysdk.base.paymentbasis.common.CJPayException;

/* JADX INFO: loaded from: classes28.dex */
public interface CJPaySession {
    public static final int RESULT_CANCELED = 2;
    public static final int RESULT_FAILED = 1;
    public static final int RESULT_PROCESSING = 5;
    public static final int RESULT_SUCCEED = 0;
    public static final int RESULT_UN_INSTALLED = 3;
    public static final int RESULT_UN_SUPPORTED = 4;
    public static final int TYPE_ALIPAY = 2;
    public static final int TYPE_CLOUD_UNION_PAY = 4;
    public static final int TYPE_CMB = 3;
    public static final int TYPE_WEIXIN = 1;

    void notifyResult(String r100);

    void release();

    void reportEvent(String r100, String r101);

    void start() throws CJPayException;
}
