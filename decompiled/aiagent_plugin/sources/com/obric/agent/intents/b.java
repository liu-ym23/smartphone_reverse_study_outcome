package com.obric.agent.intents;

import android.content.Context;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.IOpenRealTimeCallCallbackIDL;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.h;
import d.h.b.aa;
import d.m;
import d.o;
import d.x;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: SystemIntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: compiled from: SystemIntentUtils.kt */
    @f(b = "SystemIntentUtils.kt", c = {53}, d = "openRealTimeCall", e = "com.obric.agent.intents.SystemIntentUtilsKt")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f14680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14681c;

        a(d.c.d<? super a> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f14680b = r2;
            this.f14681c |= Integer.MIN_VALUE;
            return b.a(0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final Object a(d.c.d<? super x> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        ObricProductSdk.INSTANCE.platformService().windowManager().showGlobalActions((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    public static final Object a(int r30, d.c.d<? super IntentResult<Empty>> r31) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
        if ((r3.f14681c & Integer.MIN_VALUE) == 0) goto L7;
        r3.f14681c -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f14680b;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f14681c;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r0 = r3.f14679a;
        o.a(r2);
    L22:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.aiagent.plugin");
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r6.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r7 == 0) goto L31;
        if (r7 == 1) goto L34;
        if (r7 == 5) goto L33;
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_IO, null);
    L33:
        return new IntentResult(1, null, null, (String) ZeusTransformUtils.preCheckCast(r6.b(), String.class, "com.obric.aiagent.plugin"), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L34:
        return new IntentResult(999, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L31:
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        r3.f14679a = r30;
        r3.f14681c = 1;
        kotlinx.coroutines.o r8 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r8.e();
        final n r9 = (n) ZeusTransformUtils.preCheckCast(r8, n.class, "com.obric.aiagent.plugin");
        IFlowUiIDL r10 = aw.a(aa.b(IFlowUiIDL.class));
        if (r10 == null) goto L17;
        r10.openRealtimeCall(r30, (IOpenRealTimeCallCallbackIDL) ZeusTransformUtils.preCheckCast(new SystemIntentUtilsKt$openRealTimeCall$result$1$1(r9), IOpenRealTimeCallCallbackIDL.class, "com.obric.aiagent.plugin"));
    L17:
        r2 = r8.h();
        if (r2 != d.c.a.b.a()) goto L20;
        h.c((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    L20:
        if (r2 != r4) goto L22;
        return r4;
    L7:
        r3 = new a(r1);
        goto L8
    }
}
