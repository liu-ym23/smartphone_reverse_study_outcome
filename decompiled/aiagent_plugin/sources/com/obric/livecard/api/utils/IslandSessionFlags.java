package com.obric.livecard.api.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: IslandSessionFlags.kt */
/* JADX INFO: loaded from: classes4.dex */
@Target({ElementType.TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
public @interface IslandSessionFlags {
    public static final Companion Companion = null;
    public static final long FLAG_DIALOGUE_MODE = 8;
    public static final long FLAG_DIALOGUE_MODE_TIME_LIMIT = 512;
    public static final long FLAG_FULL_SCREEN_SHOW = 1024;
    public static final long FLAG_KEYGUARD_ABOVE_ONCLICK = 256;
    public static final long FLAG_KEYGUARD_DISMISS_ONCLICK = 2;
    public static final long FLAG_KEYGUARD_SHOW = 1;
    public static final long FLAG_PENDING_AUTO_DISMISS = 128;
    public static final long FLAG_QUIT_DIALOGUE_MODE_AND_COLLAPSE = 16;
    public static final long FLAG_SLIDE_UP_DESTROY = 4;
    public static final long FLAG_TEMP_REFRESH_FRONT_SHOW = 64;

    /* JADX INFO: compiled from: IslandSessionFlags.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final long FLAG_DIALOGUE_MODE = 8;
        public static final long FLAG_DIALOGUE_MODE_TIME_LIMIT = 512;
        public static final long FLAG_FULL_SCREEN_SHOW = 1024;
        public static final long FLAG_KEYGUARD_ABOVE_ONCLICK = 256;
        public static final long FLAG_KEYGUARD_DISMISS_ONCLICK = 2;
        public static final long FLAG_KEYGUARD_SHOW = 1;
        public static final long FLAG_PENDING_AUTO_DISMISS = 128;
        public static final long FLAG_QUIT_DIALOGUE_MODE_AND_COLLAPSE = 16;
        public static final long FLAG_SLIDE_UP_DESTROY = 4;
        public static final long FLAG_TEMP_REFRESH_FRONT_SHOW = 64;

        static {
            $$INSTANCE = new Companion();
        }

        public static /* synthetic */ void getFLAG_KEYGUARD_DISMISS_ONCLICK$annotations() {
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
