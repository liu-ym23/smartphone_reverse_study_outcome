package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: SidecarAuthApi.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SidecarAuthHandler {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: SidecarAuthApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final SidecarAuthHandler notImplemented() {
            return (SidecarAuthHandler) ZeusTransformUtils.preCheckCast(SidecarAuthHandler$Companion$notImplemented$1.INSTANCE, SidecarAuthHandler.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Object handle(SidecarAuthRequest r1, d<? super SidecarAuthResponse> r2);
}
