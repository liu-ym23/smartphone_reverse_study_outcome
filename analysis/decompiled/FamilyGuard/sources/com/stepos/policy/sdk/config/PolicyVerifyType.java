package com.stepos.policy.sdk.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface PolicyVerifyType {
    public static final String CHECK_ACCOUNT = "2";
    public static final String CHECK_DEVICE = "1";
    public static final String CHECK_DEVICE_ACCOUNT = "3";
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String NO_CHECK = "0";

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CHECK_ACCOUNT = "2";
        public static final String CHECK_DEVICE = "1";
        public static final String CHECK_DEVICE_ACCOUNT = "3";
        public static final String NO_CHECK = "0";

        private Companion() {
        }
    }
}
