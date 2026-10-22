package com.obric.livecard.api;

import android.app.Application;
import android.content.Context;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.island.IslandHideApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ILiveCard.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ILiveCard {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: ILiveCard.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static volatile ILiveCard instance;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final ILiveCard getInst() {
            ILiveCard r0 = instance;
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = instance;     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            LiveCard r1 = LiveCard.INSTANCE;     // Catch: Throwable -> L10
            instance = (ILiveCard) ZeusTransformUtils.preCheckCast(r1, ILiveCard.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            r0 = (ILiveCard) ZeusTransformUtils.preCheckCast(r1, ILiveCard.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    /* JADX INFO: compiled from: ILiveCard.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ IslandHideApi getIslandHideApi$default(ILiveCard r2, Application r3, int r4, Object r5) {
            ILiveCard r6 = (ILiveCard) ZeusTransformUtils.wrapperContextForParams(r2, ILiveCard.class, "com.obric.aiagent.plugin");
            Application r7 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L10;
            if ((r4 & 1) == 0) goto L8;
            r7 = null;
        L8:
            return r6.getIslandHideApi(r7);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getIslandHideApi");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Application getContext();

    IslandHideApi getIslandHideApi(Application r1);

    IslandApi getIslandService();

    String getPackageName();

    int getVersion(Context r1);

    void init(Application r1);
}
