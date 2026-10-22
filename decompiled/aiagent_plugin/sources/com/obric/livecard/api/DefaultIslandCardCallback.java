package com.obric.livecard.api;

import android.os.Bundle;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IslandCardCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface DefaultIslandCardCallback extends IslandCardCallback {

    /* JADX INFO: compiled from: IslandCardCallback.kt */
    public static final class DefaultImpls {
        public static void onSessionActive(DefaultIslandCardCallback r2, IslandSession r3) {
            DefaultIslandCardCallback r4 = (DefaultIslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r2, DefaultIslandCardCallback.class, "com.obric.aiagent.plugin");
            o.e(r3, SensitiveType.SESSION);
        }

        public static void onSessionCreate(DefaultIslandCardCallback r2, IslandSession r3) {
            DefaultIslandCardCallback r4 = (DefaultIslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r2, DefaultIslandCardCallback.class, "com.obric.aiagent.plugin");
            o.e(r3, SensitiveType.SESSION);
        }

        public static void onSessionDestroy(DefaultIslandCardCallback r1, IslandSession r2, Integer r3) {
            DefaultIslandCardCallback r4 = (DefaultIslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r1, DefaultIslandCardCallback.class, "com.obric.aiagent.plugin");
            o.e(r2, SensitiveType.SESSION);
        }

        public static void onSessionInactive(DefaultIslandCardCallback r2, IslandSession r3) {
            DefaultIslandCardCallback r4 = (DefaultIslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r2, DefaultIslandCardCallback.class, "com.obric.aiagent.plugin");
            o.e(r3, SensitiveType.SESSION);
        }

        public static void onSessionStatusChanged(DefaultIslandCardCallback r1, IslandSession r2, int r3) {
            DefaultIslandCardCallback r4 = (DefaultIslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r1, DefaultIslandCardCallback.class, "com.obric.aiagent.plugin");
            o.e(r2, SensitiveType.SESSION);
        }

        public static Bundle onWidgetShow(DefaultIslandCardCallback r2, IslandWidget r3) {
            DefaultIslandCardCallback r4 = (DefaultIslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r2, DefaultIslandCardCallback.class, "com.obric.aiagent.plugin");
            o.e(r3, "widget");
            return null;
        }
    }

    @Override // com.obric.livecard.api.IslandCardCallback
    void onSessionActive(IslandSession r1);

    @Override // com.obric.livecard.api.IslandCardCallback
    void onSessionCreate(IslandSession r1);

    @Override // com.obric.livecard.api.IslandCardCallback
    void onSessionDestroy(IslandSession r1, Integer r2);

    @Override // com.obric.livecard.api.IslandCardCallback
    void onSessionInactive(IslandSession r1);

    @Override // com.obric.livecard.api.IslandCardCallback
    void onSessionStatusChanged(IslandSession r1, int r2);

    @Override // com.obric.livecard.api.IslandCardCallback
    Bundle onWidgetShow(IslandWidget r1);
}
