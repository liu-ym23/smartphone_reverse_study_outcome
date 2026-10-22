package com.stepos.policy.sdk.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface PolicyOperationType {
    public static final String AGREE = "2";
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String DISAGREE = "0";
    public static final String REJECT_AGREE_BASIC = "1";
    public static final String WITHDRAWAL = "3";

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String AGREE = "2";
        public static final String DISAGREE = "0";
        public static final String REJECT_AGREE_BASIC = "1";
        public static final String WITHDRAWAL = "3";

        private Companion() {
        }
    }
}
