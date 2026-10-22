package com.obric.livecard.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: IslandCardCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
@Target({ElementType.TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
public @interface IslandSessionStatus {
    public static final Companion Companion = null;
    public static final int SESSION_STATUS_ON_DIALOGUE_MODE = -1;
    public static final int SESSION_STATUS_ON_NORMAL_MODE = -2;

    /* JADX INFO: compiled from: IslandCardCallback.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int SESSION_STATUS_ON_DIALOGUE_MODE = -1;
        public static final int SESSION_STATUS_ON_NORMAL_MODE = -2;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
