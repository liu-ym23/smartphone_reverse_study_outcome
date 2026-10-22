package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SafetyGuardEvents.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SafetyGuardEventObserver {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: SafetyGuardEvents.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final SafetyGuardEventObserver NOOP = null;

        private static final void NOOP$lambda$0(SafetyGuardEvent r2) {
            o.e((SafetyGuardEvent) ZeusTransformUtils.wrapperContextForParams(r2, SafetyGuardEvent.class, "com.obric.aiagent.plugin"), "it");
        }

        public static /* synthetic */ void lambda$MoCOBixr9Nchl5LxidgomgrPc2I(SafetyGuardEvent r0) {
            NOOP$lambda$0(r0);
        }

        private Companion() {
        }

        public final SafetyGuardEventObserver noop() {
            return NOOP;
        }

        static {
            $$INSTANCE = new Companion();
            NOOP = $$Lambda$SafetyGuardEventObserver$Companion$MoCOBixr9Nchl5LxidgomgrPc2I.INSTANCE;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void emit(SafetyGuardEvent r1);
}
