package com.stepos.policy.sdk.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface PolicyOperationType {
    public static final String AGREE = "2";
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String DISAGREE = "0";
    public static final String REJECT_AGREE_BASIC = "1";
    public static final String WITHDRAWAL = "3";

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
