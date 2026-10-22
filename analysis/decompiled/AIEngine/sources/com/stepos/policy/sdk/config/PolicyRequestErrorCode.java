package com.stepos.policy.sdk.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
