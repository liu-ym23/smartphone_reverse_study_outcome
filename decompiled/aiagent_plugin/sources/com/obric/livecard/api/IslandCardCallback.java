package com.obric.livecard.api;

import android.os.Bundle;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IslandCardCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IslandCardCallback {
    public static final Companion Companion = null;
    public static final int LIVE_CARD_DISABLE = 4;
    public static final int NO_PERMISSION = 3;
    public static final int ON_LIVE_CARD_DIED = 1;
    public static final int ON_LIVE_CARD_SLIDE_UP_CANCEL = 2;

    /* JADX INFO: compiled from: IslandCardCallback.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int LIVE_CARD_DISABLE = 4;
        public static final int NO_PERMISSION = 3;
        public static final int ON_LIVE_CARD_DIED = 1;
        public static final int ON_LIVE_CARD_SLIDE_UP_CANCEL = 2;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: IslandCardCallback.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onSessionDestroy$default(IslandCardCallback r2, IslandSession r3, Integer r4, int r5, Object r6) {
            IslandCardCallback r7 = (IslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r2, IslandCardCallback.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L7;
            r4 = null;
        L7:
            r7.onSessionDestroy(r3, r4);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSessionDestroy");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void onSessionActive(IslandSession r1);

    void onSessionCreate(IslandSession r1);

    void onSessionDestroy(IslandSession r1, Integer r2);

    void onSessionInactive(IslandSession r1);

    void onSessionStatusChanged(IslandSession r1, int r2);

    Bundle onWidgetShow(IslandWidget r1);
}
