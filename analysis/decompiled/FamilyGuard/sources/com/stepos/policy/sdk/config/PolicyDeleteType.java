package com.stepos.policy.sdk.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface PolicyDeleteType {
    public static final int CLEAN = 1;
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int NO_CLEAN = 0;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CLEAN = 1;
        public static final int NO_CLEAN = 0;

        private Companion() {
        }
    }
}
