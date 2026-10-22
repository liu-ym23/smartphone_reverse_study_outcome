package com.obric.aiagent.platform.depend;

import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.apm.impl.a;
import com.obric.aiagent.platform.AIAgentPlatform;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.o;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ILogDepend.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ILogDepend {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: ILogDepend.kt */
    private static final class AndroidLogcat implements ILogDepend {
        public static final AndroidLogcat INSTANCE = null;

        static {
            INSTANCE = new AndroidLogcat();
        }

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.v(r0, r1);
        }

        public static /* synthetic */ int access$001(String r0, String r1) {
            return Log.d(r0, r1);
        }

        public static /* synthetic */ int access$002(String r0, String r1) {
            return Log.i(r0, r1);
        }

        public static /* synthetic */ int access$003(String r0, String r1) {
            return Log.w(r0, r1);
        }

        public static /* synthetic */ int access$004(String r0, String r1, Throwable r2) {
            return Log.w(r0, r1, r2);
        }

        public static /* synthetic */ int access$005(String r0, Throwable r1) {
            return Log.w(r0, r1);
        }

        public static /* synthetic */ int access$006(String r0, String r1) {
            return Log.e(r0, r1);
        }

        public static /* synthetic */ int access$007(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }

        private AndroidLogcat() {
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public String getDirPath() {
            return DefaultImpls.getDirPath(this);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public boolean isDebug() {
            return DefaultImpls.isDebug(this);
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void uploadAllLog(String r3, q<? super Boolean, ? super Integer, ? super String, x> r4) {
            DefaultImpls.uploadAllLog(this, r3, (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void v(String r1, String r2) {
            o.e(r1, "tag");
            if (IAppContext.Companion.isDebugChannel() == false) goto L5;
        L6:
            if (r2 != null) goto L8;
            r2 = "null";
        L8:
            INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(r1, r2);
            return;
        L5:
            if (IAppContext.Companion.isTestChannel() == true) goto L6;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void d(String r1, String r2) {
            o.e(r1, "tag");
            if (IAppContext.Companion.isDebugChannel() == false) goto L5;
        L6:
            if (r2 != null) goto L8;
            r2 = "null";
        L8:
            INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(r1, r2);
            return;
        L5:
            if (IAppContext.Companion.isTestChannel() == true) goto L6;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void i(String r1, String r2) {
            o.e(r1, "tag");
            if (IAppContext.Companion.isDebugChannel() == false) goto L5;
        L6:
            if (r2 != null) goto L8;
            r2 = "null";
        L8:
            INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(r1, r2);
            return;
        L5:
            if (IAppContext.Companion.isTestChannel() == true) goto L6;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void w(String r1, String r2) {
            o.e(r1, "tag");
            if (IAppContext.Companion.isDebugChannel() == false) goto L5;
        L6:
            if (r2 != null) goto L8;
            r2 = "null";
        L8:
            INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r1, r2);
            return;
        L5:
            if (IAppContext.Companion.isTestChannel() == true) goto L6;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void w(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
            if (IAppContext.Companion.isDebugChannel() == false) goto L5;
        L6:
            if (r2 != null) goto L8;
            r2 = "null";
        L8:
            INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r1, r2, r3);
            return;
        L5:
            if (IAppContext.Companion.isTestChannel() == true) goto L6;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void w(String r1, Throwable r2) {
            o.e(r1, "tag");
            if (IAppContext.Companion.isDebugChannel() == false) goto L5;
        L6:
            INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(r1, r2);
            return;
        L5:
            if (IAppContext.Companion.isTestChannel() == true) goto L6;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void e(String r1, String r2) {
            o.e(r1, "tag");
            if (IAppContext.Companion.isDebugChannel() == false) goto L5;
        L6:
            if (r2 != null) goto L8;
            r2 = "null";
        L8:
            INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r1, r2);
            return;
        L5:
            if (IAppContext.Companion.isTestChannel() == true) goto L6;
        }

        @Override // com.obric.aiagent.platform.depend.ILogDepend
        public void e(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
            if (IAppContext.Companion.isDebugChannel() == false) goto L5;
        L6:
            if (r2 != null) goto L8;
            r2 = "null";
        L8:
            INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(r1, r2, r3);
            return;
        L5:
            if (IAppContext.Companion.isTestChannel() == true) goto L6;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
            if (a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
            if (a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
            if (a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
            if (a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, Throwable r2) {
            if (a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
            if (a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2, r3);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
            return Log.e(r0, r1);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_aiagent_platform_depend_ILogDepend$AndroidLogcat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: ILogDepend.kt */
    public static final class Companion implements ILogDepend {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private final /* synthetic */ ILogDepend $$delegate_0;

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
            ILogDepend r1 = r0.getLogger();
            if (r1 == null) goto L6;
        L9:
            this.$$delegate_0 = r1;
            return;
        L6:
            r1 = (ILogDepend) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ILogDepend.class, false, false), ILogDepend.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L9;
            r1 = (ILogDepend) ZeusTransformUtils.preCheckCast(AndroidLogcat.INSTANCE, ILogDepend.class, "com.obric.aiagent.plugin");
            goto L9
        }
    }

    /* JADX INFO: compiled from: ILogDepend.kt */
    public static final class DefaultImpls {
        public static String getDirPath(ILogDepend r2) {
            ILogDepend r3 = (ILogDepend) ZeusTransformUtils.wrapperContextForParams(r2, ILogDepend.class, "com.obric.aiagent.plugin");
            return "";
        }

        public static boolean isDebug(ILogDepend r2) {
            ILogDepend r3 = (ILogDepend) ZeusTransformUtils.wrapperContextForParams(r2, ILogDepend.class, "com.obric.aiagent.plugin");
            return false;
        }

        public static void uploadAllLog(ILogDepend r2, String r3, q<? super Boolean, ? super Integer, ? super String, x> r4) {
            ILogDepend r5 = (ILogDepend) ZeusTransformUtils.wrapperContextForParams(r2, ILogDepend.class, "com.obric.aiagent.plugin");
            q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
            o.e(r3, DBHelper.BATTERY_COL_SCENE);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void d(String r1, String r2);

    void e(String r1, String r2);

    void e(String r1, String r2, Throwable r3);

    String getDirPath();

    void i(String r1, String r2);

    boolean isDebug();

    void uploadAllLog(String r1, q<? super Boolean, ? super Integer, ? super String, x> r2);

    void v(String r1, String r2);

    void w(String r1, String r2);

    void w(String r1, String r2, Throwable r3);

    void w(String r1, Throwable r2);
}
