package com.obric.autogui.common.api.logging;

import com.obric.autogui.common.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: ILogger.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ILogger {

    /* JADX INFO: compiled from: ILogger.kt */
    public static final class DefaultImpls {
        public static void ip(ILogger r2, String r3, a<String> r4, a<String> r5) {
            ILogger r6 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.aiagent.plugin");
            a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
            a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "tag");
            o.e(r7, "privateMsg");
            o.e(r8, "publicMsg");
            if (b.f29001a.a() == false) goto L5;
            r6.i(r3, (String) ZeusTransformUtils.preCheckCast(r7.invoke(), String.class, "com.obric.aiagent.plugin"));
            return;
        L5:
            r6.i(r3, (String) ZeusTransformUtils.preCheckCast(r8.invoke(), String.class, "com.obric.aiagent.plugin"));
        }

        public static void dp(ILogger r2, String r3, a<String> r4, a<String> r5) {
            ILogger r6 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.aiagent.plugin");
            a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
            a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "tag");
            o.e(r7, "privateMsg");
            o.e(r8, "publicMsg");
            if (b.f29001a.a() == false) goto L5;
            r6.d(r3, (String) ZeusTransformUtils.preCheckCast(r7.invoke(), String.class, "com.obric.aiagent.plugin"));
            return;
        L5:
            r6.d(r3, (String) ZeusTransformUtils.preCheckCast(r8.invoke(), String.class, "com.obric.aiagent.plugin"));
        }

        public static void dp(ILogger r2, String r3, a<String> r4) {
            ILogger r5 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.aiagent.plugin");
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "tag");
            o.e(r6, "privateMsg");
            if (b.f29001a.a() == false) goto L6;
            r5.d(r3, (String) ZeusTransformUtils.preCheckCast(r6.invoke(), String.class, "com.obric.aiagent.plugin"));
            return;
        }

        public static void wp(ILogger r2, String r3, a<String> r4, a<String> r5) {
            ILogger r6 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.aiagent.plugin");
            a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
            a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "tag");
            o.e(r7, "privateMsg");
            o.e(r8, "publicMsg");
            if (b.f29001a.a() == false) goto L5;
            r6.w(r3, (String) ZeusTransformUtils.preCheckCast(r7.invoke(), String.class, "com.obric.aiagent.plugin"));
            return;
        L5:
            r6.w(r3, (String) ZeusTransformUtils.preCheckCast(r8.invoke(), String.class, "com.obric.aiagent.plugin"));
        }

        public static void ep(ILogger r2, String r3, a<String> r4, a<String> r5, Throwable r6) {
            ILogger r7 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.aiagent.plugin");
            a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
            a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "tag");
            o.e(r8, "privateMsg");
            o.e(r9, "publicMsg");
            if (b.f29001a.a() == false) goto L5;
            r7.e(r3, (String) ZeusTransformUtils.preCheckCast(r8.invoke(), String.class, "com.obric.aiagent.plugin"), r6);
            return;
        L5:
            r7.e(r3, (String) ZeusTransformUtils.preCheckCast(r9.invoke(), String.class, "com.obric.aiagent.plugin"), r6);
        }

        public static void ep(ILogger r2, String r3, a<String> r4, a<String> r5) {
            ILogger r6 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.aiagent.plugin");
            a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
            a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
            o.e(r3, "tag");
            o.e(r7, "privateMsg");
            o.e(r8, "publicMsg");
            if (b.f29001a.a() == false) goto L5;
            r6.e(r3, (String) ZeusTransformUtils.preCheckCast(r7.invoke(), String.class, "com.obric.aiagent.plugin"));
            return;
        L5:
            r6.e(r3, (String) ZeusTransformUtils.preCheckCast(r8.invoke(), String.class, "com.obric.aiagent.plugin"));
        }

        public static /* synthetic */ void uploadAllLog$default(ILogger r2, String r3, d.h.a.b r4, int r5, Object r6) {
            ILogger r7 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.aiagent.plugin");
            d.h.a.b<? super Boolean, x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L7;
            r8 = null;
        L7:
            r7.uploadAllLog(r3, r8);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadAllLog");
        }
    }

    void d(String r1, String r2);

    void dp(String r1, a<String> r2);

    void dp(String r1, a<String> r2, a<String> r3);

    void e(String r1, String r2);

    void e(String r1, String r2, Throwable r3);

    void ep(String r1, a<String> r2, a<String> r3);

    void ep(String r1, a<String> r2, a<String> r3, Throwable r4);

    String getDirPath();

    void i(String r1, String r2);

    void ip(String r1, a<String> r2, a<String> r3);

    boolean isDebug();

    void uploadAllLog(String r1, d.h.a.b<? super Boolean, x> r2);

    void v(String r1, String r2);

    void w(String r1, String r2);

    void w(String r1, String r2, Throwable r3);

    void w(String r1, Throwable r2);

    void wp(String r1, a<String> r2, a<String> r3);
}
