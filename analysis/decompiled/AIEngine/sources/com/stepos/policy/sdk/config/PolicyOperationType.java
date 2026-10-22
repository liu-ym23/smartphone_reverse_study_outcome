package com.stepos.policy.sdk.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface PolicyOperationType {
    public static final String AGREE = "2";
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String DISAGREE = "0";
    public static final String REJECT_AGREE_BASIC = "1";
    public static final String WITHDRAWAL = "3";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
