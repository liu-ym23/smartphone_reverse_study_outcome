package com.obric.autoaction.inittasks.refactor;

import android.content.Context;
import com.obric.aiagent.assistant_card.provider_core.a;
import com.obric.aiagent.assistant_card.provider_core.a.f;
import com.obric.aiagent.assistant_card.provider_core.b;
import com.obric.autoaction.presentation.doubao.c;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: InitCardProviderTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitCardProviderTask implements IAutoActionFoundationReadyTask {

    /* JADX INFO: renamed from: com.obric.autoaction.inittasks.refactor.InitCardProviderTask$run$2, reason: invalid class name */
    /* JADX INFO: compiled from: InitCardProviderTask.kt */
    public static final class AnonymousClass2 implements f {
        private static final String d$lambda$0(String r0) {
            return r0;
        }

        private static final String d$lambda$1() {
            return "[value-omitted-production-build]";
        }

        public static /* synthetic */ String lambda$b0qsrsk8iLzrSEFaz3LPx9clUf4(String r0) {
            return d$lambda$0(r0);
        }

        public static /* synthetic */ String lambda$sKhkqUNFE6g0inIlnpqGbm874sU() {
            return d$lambda$1();
        }

        AnonymousClass2() {
        }

        public void d(String r2, final String r3) {
            o.e(r2, "tag");
            o.e(r3, "msg");
            Loog.INSTANCE.dp(r2, new $$Lambda$InitCardProviderTask$run$2$b0qsrsk8iLzrSEFaz3LPx9clUf4(r3), $$Lambda$InitCardProviderTask$run$2$sKhkqUNFE6g0inIlnpqGbm874sU.INSTANCE);
        }

        @Override // com.obric.aiagent.assistant_card.provider_core.a.f
        public void i(String r1, String r2) {
            o.e(r1, "tag");
            o.e(r2, "msg");
            Loog.INSTANCE.i(r1, r2);
        }

        @Override // com.obric.aiagent.assistant_card.provider_core.a.f
        public void w(String r1, String r2) {
            o.e(r1, "tag");
            o.e(r2, "msg");
            Loog.INSTANCE.w(r1, r2);
        }

        @Override // com.obric.aiagent.assistant_card.provider_core.a.f
        public void w(String r1, String r2, Throwable r3) {
            o.e(r1, "tag");
            o.e(r2, "msg");
            o.e(r3, "throwable");
            Loog.INSTANCE.w(r1, r2, r3);
        }
    }

    public InitCardProviderTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - initialising card provider...");
        b.f16338a.a((a) ZeusTransformUtils.preCheckCast(new c(), a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        b.f16338a.a(r7, (f) ZeusTransformUtils.preCheckCast(new AnonymousClass2(), f.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
    L8:
        return x.f38692a;
    L5:
        th = move-exception;
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - initialising card provider errored: " + th.getMessage(), th);
        goto L8
    }
}
