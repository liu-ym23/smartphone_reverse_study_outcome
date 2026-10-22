package com.stepos.policy.sdk.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface PolicySecureServiceVersionCode {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int SUPPORT_RSA_SIGN = 12000011;
    public static final int SUPPORT_WITHDRAWAL = 11000031;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int SUPPORT_RSA_SIGN = 12000011;
        public static final int SUPPORT_WITHDRAWAL = 11000031;

        private Companion() {
        }
    }
}
