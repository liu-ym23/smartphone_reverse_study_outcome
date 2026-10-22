package com.obric.agent.auth;

import android.os.Bundle;
import com.obric.aiagent.assistant.idl.bean.Authentication;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: IAgentAuthService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAgentAuthService {
    public static final a Companion = null;
    public static final int RESULT_CANCELLED = 4;
    public static final int RESULT_FAILED = 1;
    public static final int RESULT_NOT_AVAILABLE = 3;
    public static final int RESULT_PASS = 0;
    public static final int RESULT_TIMEOUT = 2;

    /* JADX INFO: compiled from: IAgentAuthService.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f14239a = null;

        static {
            f14239a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: IAgentAuthService.kt */
    public static final class b {
        public static /* synthetic */ Object a(IAgentAuthService r2, String r3, String r4, boolean r5, Bundle r6, d r7, int r8, Object r9) {
            IAgentAuthService r10 = (IAgentAuthService) ZeusTransformUtils.wrapperContextForParams(r2, IAgentAuthService.class, "com.obric.aiagent.plugin");
            d<? super Boolean> r0 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            if (r9 != null) goto L18;
            if ((r8 & 2) == 0) goto L7;
            String r11 = null;
        L9:
            if ((r8 & 4) == 0) goto L11;
            r5 = true;
        L11:
            boolean r1 = r5;
            if ((r8 & 8) == 0) goto L14;
            Bundle r12 = null;
        L16:
            return r10.requestDismissKeyguard(r3, r11, r1, r12, r0);
        L14:
            r12 = r6;
            goto L16
        L7:
            r11 = r4;
            goto L9
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestDismissKeyguard");
        }
    }

    static {
        Companion = a.f14239a;
    }

    void dismissKeyguard();

    Authentication isAuthPass(String r1, String r2);

    boolean isKeyguardReallyLocked();

    void popWindowIfNeed(String r1, String r2, int r3);

    Object requestBiometricAuth(String r1, String r2, Bundle r3, d<? super Integer> r4);

    Object requestDeviceCredentialAuth(String r1, String r2, Bundle r3, d<? super Integer> r4);

    Object requestDismissKeyguard(String r1, String r2, boolean r3, Bundle r4, d<? super Boolean> r5);

    Object requestVoiceprintAuth(String r1, String r2, Bundle r3, d<? super Integer> r4);
}
