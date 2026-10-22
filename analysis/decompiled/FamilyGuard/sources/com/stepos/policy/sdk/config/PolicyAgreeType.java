package com.stepos.policy.sdk.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface PolicyAgreeType {
    public static final int AGREE = 1;
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DENY = 0;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int AGREE = 1;
        public static final int DENY = 0;

        private Companion() {
        }
    }
}
