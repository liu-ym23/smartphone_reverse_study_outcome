package com.android.ttcjpaysdk.fastpay.data.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/fastpay/data/bean/FastPayConstant;", "", "()V", "CJPayBaseResponseCode", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FastPayConstant {
    public static final FastPayConstant INSTANCE = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/fastpay/data/bean/FastPayConstant$CJPayBaseResponseCode;", "", "()V", "CHECK_TYPE_FAST_PAY", "", "FAILURE_SOURCE_FAILED", "", "FAILURE_SOURCE_UNAVAILABLE", "RESPONSE_FAILED", "RESPONSE_NEED_VERIFY", "RESPONSE_NOT_SUPPORT", "RESPONSE_SUCCEED", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayBaseResponseCode {
        public static final String CHECK_TYPE_FAST_PAY = "极速";
        public static final int FAILURE_SOURCE_FAILED = 1;
        public static final int FAILURE_SOURCE_UNAVAILABLE = 2;
        public static final CJPayBaseResponseCode INSTANCE = null;
        public static final String RESPONSE_FAILED = "CA3008";
        public static final String RESPONSE_NEED_VERIFY = "CA3009";
        public static final String RESPONSE_NOT_SUPPORT = "CA3007";
        public static final String RESPONSE_SUCCEED = "CA0000";

        static {
            INSTANCE = new CJPayBaseResponseCode();
        }

        private CJPayBaseResponseCode() {
        }
    }

    static {
        INSTANCE = new FastPayConstant();
    }

    private FastPayConstant() {
    }
}
