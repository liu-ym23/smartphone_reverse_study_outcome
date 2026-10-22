package com.obric.livecard.api.impl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: ClientCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
@Target({ElementType.TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
public @interface ClientEvent {
    public static final String CUSTOM_EVENT = "customEvent";
    public static final Companion Companion = null;
    public static final String HAS_CARD_CLICK = "hasCardClick";
    public static final String ON_CARD_CLICK = "onCardClick";
    public static final String ON_FLAGS_CHANGE = "onFlagsChange";
    public static final String ON_SESSION_ACTIVE = "onSessionActive";
    public static final String ON_SESSION_CREATE = "onSessionCreate";
    public static final String ON_SESSION_DESTROY = "onSessionDestroy";
    public static final String ON_SESSION_INACTIVE = "onSessionInactive";
    public static final String ON_SESSION_STATUS_CHANGED = "onSessionStatusChanged";
    public static final String ON_VIEW_CLICK = "onViewClick";
    public static final String ON_WIDGET_SHOW = "onWidgetShow";
    public static final String UPDATE_SESSION_CONFIG = "updateSessionConfig";

    /* JADX INFO: compiled from: ClientCallback.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String CUSTOM_EVENT = "customEvent";
        public static final String HAS_CARD_CLICK = "hasCardClick";
        public static final String ON_CARD_CLICK = "onCardClick";
        public static final String ON_FLAGS_CHANGE = "onFlagsChange";
        public static final String ON_SESSION_ACTIVE = "onSessionActive";
        public static final String ON_SESSION_CREATE = "onSessionCreate";
        public static final String ON_SESSION_DESTROY = "onSessionDestroy";
        public static final String ON_SESSION_INACTIVE = "onSessionInactive";
        public static final String ON_SESSION_STATUS_CHANGED = "onSessionStatusChanged";
        public static final String ON_VIEW_CLICK = "onViewClick";
        public static final String ON_WIDGET_SHOW = "onWidgetShow";
        public static final String UPDATE_SESSION_CONFIG = "updateSessionConfig";

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
