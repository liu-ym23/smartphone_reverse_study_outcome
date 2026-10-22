package com.android.ttcjpaysdk.ttcjpayapi;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public interface TTCJPayRealNameAuthCallback {

    public static final enum AuthResult extends Enum<AuthResult> {
        private static final /* synthetic */ AuthResult[] $VALUES = null;
        public static final AuthResult AUTHORIZED = null;
        public static final AuthResult AUTH_CANCEL = null;
        public static final AuthResult AUTH_ERROR = null;
        public static final AuthResult AUTH_SUCCESS = null;
        public static final AuthResult LOGOUT_ACCOUNT = null;
        public static final AuthResult QUERY_AUTH_INFO_ERROR = null;
        public static final AuthResult WITHOUT_REAL_NAME = null;

        private static /* synthetic */ AuthResult[] $values() {
            return new AuthResult[]{AUTH_SUCCESS, AUTH_ERROR, AUTH_CANCEL, LOGOUT_ACCOUNT, AUTHORIZED, WITHOUT_REAL_NAME, QUERY_AUTH_INFO_ERROR};
        }

        static {
            AUTH_SUCCESS = new AuthResult("AUTH_SUCCESS", 0);
            AUTH_ERROR = new AuthResult("AUTH_ERROR", 1);
            AUTH_CANCEL = new AuthResult("AUTH_CANCEL", 2);
            LOGOUT_ACCOUNT = new AuthResult("LOGOUT_ACCOUNT", 3);
            AUTHORIZED = new AuthResult("AUTHORIZED", 4);
            WITHOUT_REAL_NAME = new AuthResult("WITHOUT_REAL_NAME", 5);
            QUERY_AUTH_INFO_ERROR = new AuthResult("QUERY_AUTH_INFO_ERROR", 6);
            $VALUES = $values();
        }

        public static AuthResult[] values() {
            return (AuthResult[]) $VALUES.clone();
        }

        public static AuthResult valueOf(String r100) {
            return (AuthResult) a.a(AuthResult.class, r100);
        }

        private AuthResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    void onAuthResult(AuthResult r100);
}
