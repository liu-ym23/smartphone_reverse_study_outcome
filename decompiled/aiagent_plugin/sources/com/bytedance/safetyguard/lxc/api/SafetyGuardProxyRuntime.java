package com.bytedance.safetyguard.lxc.api;

import android.os.ParcelFileDescriptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: SafetyGuardProxyRuntime.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SafetyGuardProxyRuntime {

    /* JADX INFO: compiled from: SafetyGuardProxyRuntime.kt */
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: startSession-gIAlu-s$default, reason: not valid java name */
        public static /* synthetic */ Object m38startSessiongIAlus$default(SafetyGuardProxyRuntime r2, ParcelFileDescriptor r3, ProxySessionOptions r4, int r5, Object r6) {
            SafetyGuardProxyRuntime r7 = (SafetyGuardProxyRuntime) ZeusTransformUtils.wrapperContextForParams(r2, SafetyGuardProxyRuntime.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L8;
            r4 = new ProxySessionOptions(null, 1, null);
        L8:
            return r7.mo37startSessiongIAlus(r3, r4);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startSession-gIAlu-s");
        }
    }

    Object awaitClosed(d<? super x> r1);

    /* JADX INFO: renamed from: close-d1pmJ48, reason: not valid java name */
    Object mo36closed1pmJ48();

    boolean isAvailable();

    /* JADX INFO: renamed from: startSession-gIAlu-s, reason: not valid java name */
    Object mo37startSessiongIAlus(ParcelFileDescriptor r1, ProxySessionOptions r2);
}
