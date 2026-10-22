package com.obric.livecard.api.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: IslandVersionCode.kt */
/* JADX INFO: loaded from: classes4.dex */
@Target({ElementType.TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
public @interface IslandVersionCode {
    public static final Companion Companion = null;
    public static final int DIALOGUE_FEATURE = 3;

    /* JADX INFO: compiled from: IslandVersionCode.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int DIALOGUE_FEATURE = 3;

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
