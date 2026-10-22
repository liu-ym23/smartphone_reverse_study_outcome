package com.stepos.policy.sdk.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface PolicyRequestErrorCode {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int SERVICE_ERROR = 500;
    public static final int SERVICE_PARAMETER_ERROR = 100001;
    public static final int SERVICE_POLICY_NON_EXIST = 210001;
    public static final int SERVICE_POLICY_VERSION_NON_EXIST = 210002;
    public static final int SERVICE_RECORD_APP_ID_ERROR = 110003;
    public static final int SERVICE_SUCCESS = 200;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int SERVICE_ERROR = 500;
        public static final int SERVICE_PARAMETER_ERROR = 100001;
        public static final int SERVICE_POLICY_NON_EXIST = 210001;
        public static final int SERVICE_POLICY_VERSION_NON_EXIST = 210002;
        public static final int SERVICE_RECORD_APP_ID_ERROR = 110003;
        public static final int SERVICE_SUCCESS = 200;

        private Companion() {
        }
    }
}
