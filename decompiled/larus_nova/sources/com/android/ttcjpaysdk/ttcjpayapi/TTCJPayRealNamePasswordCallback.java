package com.android.ttcjpaysdk.ttcjpayapi;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public interface TTCJPayRealNamePasswordCallback {

    /* JADX INFO: loaded from: classes39.dex */
    public static final enum PasswordResult extends Enum<PasswordResult> {
        private static final /* synthetic */ PasswordResult[] $VALUES = null;
        public static final PasswordResult SET_PASSWORD_CANCEL = null;
        public static final PasswordResult SET_PASSWORD_SUCCESS = null;

        private static /* synthetic */ PasswordResult[] $values() {
            return new PasswordResult[]{SET_PASSWORD_SUCCESS, SET_PASSWORD_CANCEL};
        }

        static {
            SET_PASSWORD_SUCCESS = new PasswordResult("SET_PASSWORD_SUCCESS", 0);
            SET_PASSWORD_CANCEL = new PasswordResult("SET_PASSWORD_CANCEL", 1);
            $VALUES = $values();
        }

        public static PasswordResult[] values() {
            return (PasswordResult[]) $VALUES.clone();
        }

        public static PasswordResult valueOf(String r100) {
            return (PasswordResult) a.a(PasswordResult.class, r100);
        }

        private PasswordResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    void onSetPasswordResult(PasswordResult r100);
}
