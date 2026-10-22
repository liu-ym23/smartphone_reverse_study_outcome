package com.obric.aiagent.platform.depend;

import android.os.Bundle;
import com.obric.aiagent.platform.AIAgentPlatform;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.a.q;
import d.h.b.o;
import d.x;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ITraceDepend.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ITraceDepend {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: ITraceDepend.kt */
    public static final class Companion implements ITraceDepend {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final f<ITraceDepend> impl$delegate = null;

        public static /* synthetic */ ITraceDepend lambda$XnwBlVAv3xG3C0N9HLnVbVtoCCs() {
            return impl_delegate$lambda$0();
        }

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            impl$delegate = g.a($$Lambda$ITraceDepend$Companion$XnwBlVAv3xG3C0N9HLnVbVtoCCs.INSTANCE);
        }

        private final ITraceDepend getImpl() {
            return (ITraceDepend) ZeusTransformUtils.preCheckCast(impl$delegate.b(), ITraceDepend.class, "com.obric.aiagent.plugin");
        }

        private static final ITraceDepend impl_delegate$lambda$0() {
            IAIAgentPlatform r0 = AIAgentPlatform.INSTANCE.get$platform_release();
            if (r0 == null) goto L7;
            ITraceDepend r1 = r0.getTracer();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return (ITraceDepend) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITraceDepend.class), ITraceDepend.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.platform.depend.ITraceDepend
        public void report(String r2, JSONObject r3) {
            o.e(r2, "event");
            o.e(r3, "params");
            ITraceDepend r1 = getImpl();
            if (r1 == null) goto L6;
            r1.report(r2, r3);
            return;
        }

        @Override // com.obric.aiagent.platform.depend.ITraceDepend
        public void report(String r2, Bundle r3) {
            o.e(r2, "event");
            o.e(r3, "bundleParams");
            ITraceDepend r1 = getImpl();
            if (r1 == null) goto L6;
            r1.report(r2, r3);
            return;
        }

        @Override // com.obric.aiagent.platform.depend.ITraceDepend
        public void enableETVerify() {
            ITraceDepend r0 = getImpl();
            if (r0 == null) goto L6;
            r0.enableETVerify();
            return;
        }

        @Override // com.obric.aiagent.platform.depend.ITraceDepend
        public String getSessionId() {
            ITraceDepend r0 = getImpl();
            if (r0 == null) goto L5;
            String r1 = r0.getSessionId();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.aiagent.platform.depend.ITraceDepend
        public String getDeviceId() {
            ITraceDepend r0 = getImpl();
            if (r0 == null) goto L5;
            String r1 = r0.getDeviceId();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.aiagent.platform.depend.ITraceDepend
        public String getInstallId() {
            ITraceDepend r0 = getImpl();
            if (r0 == null) goto L5;
            String r1 = r0.getInstallId();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.aiagent.platform.depend.ITraceDepend
        public String getSsid() {
            ITraceDepend r0 = getImpl();
            if (r0 == null) goto L5;
            String r1 = r0.getSsid();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.aiagent.platform.depend.ITraceDepend
        public void awaitTraceId(q<? super String, ? super String, ? super String, x> r3) {
            q<? super String, ? super String, ? super String, x> r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
            o.e(r4, "callback");
            ITraceDepend r2 = getImpl();
            if (r2 == null) goto L6;
            r2.awaitTraceId(r4);
            return;
        }

        @Override // com.obric.aiagent.platform.depend.ITraceDepend
        public String getUserID() {
            ITraceDepend r0 = getImpl();
            if (r0 == null) goto L5;
            String r1 = r0.getUserID();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.aiagent.platform.depend.ITraceDepend
        public String getUUID() {
            ITraceDepend r0 = getImpl();
            if (r0 == null) goto L5;
            String r1 = r0.getUUID();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.aiagent.platform.depend.ITraceDepend
        public void addCommonParams(Map<String, String> r3) {
            Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r4, "params");
            ITraceDepend r2 = getImpl();
            if (r2 == null) goto L6;
            r2.addCommonParams(r4);
            return;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void addCommonParams(Map<String, String> r1);

    void awaitTraceId(q<? super String, ? super String, ? super String, x> r1);

    void enableETVerify();

    String getDeviceId();

    String getInstallId();

    String getSessionId();

    String getSsid();

    String getUUID();

    String getUserID();

    void report(String r1, Bundle r2);

    void report(String r1, JSONObject r2);
}
