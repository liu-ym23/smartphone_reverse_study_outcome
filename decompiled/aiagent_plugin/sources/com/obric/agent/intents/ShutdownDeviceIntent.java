package com.obric.agent.intents;

import android.content.Context;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemShutdownIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.o;

/* JADX INFO: compiled from: ShutdownDeviceIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShutdownDeviceIntent extends BaseSystemShutdownIntent {

    /* JADX INFO: compiled from: ShutdownDeviceIntent.kt */
    @f(b = "ShutdownDeviceIntent.kt", c = {16}, d = "doAction", e = "com.obric.agent.intents.ShutdownDeviceIntent")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f14659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ShutdownDeviceIntent f14660c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f14661d;

        a(ShutdownDeviceIntent r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14660c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14659b = r3;
            this.f14661d |= Integer.MIN_VALUE;
            return this.f14660c.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public ShutdownDeviceIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemShutdownIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((Empty) ZeusTransformUtils.preCheckCast(r6, Empty.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemShutdownIntent
    public Object doAction(Empty r16, DispatchContext r17, d.c.d<? super IntentResult<Empty>> r18) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L7;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
        if ((r2.f14661d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f14661d -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f14659b;
        Object r4 = d.c.a.b.a();
        int r5 = r2.f14661d;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(r2.f14658a, Context.class, "com.obric.aiagent.plugin");
        o.a(r1);
    L18:
        return new IntentResult(0, null, null, r3.getString(ZeusTransformUtils.mapRes(R.string.obric_shutdown_doing_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_shutdown_doing_action")), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r1);
        ILogDepend.Companion.i(getName(), "doAction - shutting down");
        r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r2.f14658a = r3;
        r2.f14661d = 1;
        if (b.a(r2) != r4) goto L18;
        return r4;
    L7:
        r2 = new a(this, r0);
        goto L8
    }
}
