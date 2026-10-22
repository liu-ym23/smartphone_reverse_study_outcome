package com.bytedance.safetyguard.lxc.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;
import d.n;

/* JADX INFO: compiled from: ProxySessionModels.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ProxySession {

    /* JADX INFO: compiled from: ProxySessionModels.kt */
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: activateAction-IoAF18A, reason: not valid java name */
        public static Object m34activateActionIoAF18A(ProxySession r2, String r3) {
            ProxySession r4 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r2, ProxySession.class, "com.obric.aiagent.plugin");
            o.e(r3, "outboundSensitiveDataJson");
            n.a r5 = n.f38560a;
            return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new UnsupportedOperationException("Action lifecycle is not supported"), Throwable.class, "com.obric.aiagent.plugin")));
        }

        /* JADX INFO: renamed from: finishAction-IoAF18A, reason: not valid java name */
        public static Object m35finishActionIoAF18A(ProxySession r2, ActionContextToken r3) {
            ProxySession r4 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r2, ProxySession.class, "com.obric.aiagent.plugin");
            o.e(r3, "token");
            n.a r5 = n.f38560a;
            return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new UnsupportedOperationException("Action lifecycle is not supported"), Throwable.class, "com.obric.aiagent.plugin")));
        }
    }

    /* JADX INFO: renamed from: activateAction-IoAF18A, reason: not valid java name */
    Object mo31activateActionIoAF18A(String r1);

    Object await(d<? super ProxySessionResult> r1);

    /* JADX INFO: renamed from: close-d1pmJ48, reason: not valid java name */
    Object mo32closed1pmJ48();

    /* JADX INFO: renamed from: finishAction-IoAF18A, reason: not valid java name */
    Object mo33finishActionIoAF18A(ActionContextToken r1);

    String getSessionId();
}
