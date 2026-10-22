package com.obric.aiagent.platform.depend;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.platform.AIAgentPlatform;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: ISysLogDepend.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ISysLogDepend extends ILogDepend {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: ISysLogDepend.kt */
    public static final class Companion implements ISysLogDepend {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private final /* synthetic */ ISysLogDepend $$delegate_0;

        static {
            $$INSTANCE = new Companion();
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void d(String r2, String r3) {
            o.e(r2, "tag");
            this.$$delegate_0.d(r2, r3);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void e(String r2, String r3) {
            o.e(r2, "tag");
            this.$$delegate_0.e(r2, r3);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void e(String r2, String r3, Throwable r4) {
            o.e(r2, "tag");
            this.$$delegate_0.e(r2, r3, r4);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public String getDirPath() {
            return this.$$delegate_0.getDirPath();
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void i(String r2, String r3) {
            o.e(r2, "tag");
            this.$$delegate_0.i(r2, r3);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public boolean isDebug() {
            return this.$$delegate_0.isDebug();
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void uploadAllLog(String r3, q<? super Boolean, ? super Integer, ? super String, x> r4) {
            q<? super Boolean, ? super Integer, ? super String, x> r5 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
            o.e(r3, DBHelper.BATTERY_COL_SCENE);
            this.$$delegate_0.uploadAllLog(r3, r5);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void v(String r2, String r3) {
            o.e(r2, "tag");
            this.$$delegate_0.v(r2, r3);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void w(String r2, String r3) {
            o.e(r2, "tag");
            this.$$delegate_0.w(r2, r3);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void w(String r2, String r3, Throwable r4) {
            o.e(r2, "tag");
            this.$$delegate_0.w(r2, r3, r4);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void w(String r2, Throwable r3) {
            o.e(r2, "tag");
            this.$$delegate_0.w(r2, r3);
        }

        private Companion() {
            IAIAgentPlatform r0 = AIAgentPlatform.INSTANCE.get$platform_release();
            if (r0 == null) goto L6;
            ISysLogDepend r1 = r0.getSysLogger();
            if (r1 == null) goto L6;
        L9:
            this.$$delegate_0 = r1;
            return;
        L6:
            r1 = (ISysLogDepend) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ISysLogDepend.class, false, false), ISysLogDepend.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L9;
            r1 = (ISysLogDepend) ZeusTransformUtils.preCheckCast(Empty.INSTANCE, ISysLogDepend.class, "com.obric.aiagent.plugin");
            goto L9
        }
    }

    /* JADX INFO: compiled from: ISysLogDepend.kt */
    public static final class DefaultImpls {
        public static String getDirPath(ISysLogDepend r2) {
            return ILogDepend.DefaultImpls.getDirPath((ILogDepend) ZeusTransformUtils.preCheckCast((ISysLogDepend) ZeusTransformUtils.wrapperContextForParams(r2, ISysLogDepend.class, "com.obric.aiagent.plugin"), ILogDepend.class, "com.obric.aiagent.plugin"));
        }

        public static boolean isDebug(ISysLogDepend r2) {
            return ILogDepend.DefaultImpls.isDebug((ILogDepend) ZeusTransformUtils.preCheckCast((ISysLogDepend) ZeusTransformUtils.wrapperContextForParams(r2, ISysLogDepend.class, "com.obric.aiagent.plugin"), ILogDepend.class, "com.obric.aiagent.plugin"));
        }

        public static void uploadAllLog(ISysLogDepend r2, String r3, q<? super Boolean, ? super Integer, ? super String, x> r4) {
            ISysLogDepend r5 = (ISysLogDepend) ZeusTransformUtils.wrapperContextForParams(r2, ISysLogDepend.class, "com.obric.aiagent.plugin");
            q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
            o.e(r3, DBHelper.BATTERY_COL_SCENE);
            ILogDepend.DefaultImpls.uploadAllLog((ILogDepend) ZeusTransformUtils.preCheckCast(r5, ILogDepend.class, "com.obric.aiagent.plugin"), r3, r6);
        }
    }

    /* JADX INFO: compiled from: ISysLogDepend.kt */
    private static final class Empty implements ILogDepend, ISysLogDepend {
        public static final Empty INSTANCE = null;

        static {
            INSTANCE = new Empty();
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void d(String r1, String r2) {
            o.e(r1, "tag");
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void e(String r1, String r2) {
            o.e(r1, "tag");
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void e(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void i(String r1, String r2) {
            o.e(r1, "tag");
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void v(String r1, String r2) {
            o.e(r1, "tag");
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void w(String r1, String r2) {
            o.e(r1, "tag");
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void w(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void w(String r1, Throwable r2) {
            o.e(r1, "tag");
        }

        private Empty() {
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public String getDirPath() {
            return ILogDepend.DefaultImpls.getDirPath(this);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public boolean isDebug() {
            return ILogDepend.DefaultImpls.isDebug(this);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void uploadAllLog(String r3, q<? super Boolean, ? super Integer, ? super String, x> r4) {
            ILogDepend.DefaultImpls.uploadAllLog(this, r3, (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
