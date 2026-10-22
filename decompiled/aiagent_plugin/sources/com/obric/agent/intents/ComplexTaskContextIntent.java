package com.obric.agent.intents;

import android.os.Parcelable;
import com.obric.agent.ObricService;
import com.obric.agent.complextask.IComplexTaskService;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseRCComplexTaskContextIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ComplexTaskContextIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComplexTaskContextIntent extends BaseRCComplexTaskContextIntent {

    /* JADX INFO: compiled from: ComplexTaskContextIntent.kt */
    @f(b = "ComplexTaskContextIntent.kt", c = {19}, d = "doAction", e = "com.obric.agent.intents.ComplexTaskContextIntent")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f14611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ComplexTaskContextIntent f14612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14613c;

        a(ComplexTaskContextIntent r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14612b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14611a = r3;
            this.f14613c |= Integer.MIN_VALUE;
            return this.f14612b.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ComplexTaskContextIntent.kt */
    @f(b = "ComplexTaskContextIntent.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.intents.ComplexTaskContextIntent$doAction$map$1")
    static final class b extends l implements m<am, d.c.d<? super Map<String, String>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DispatchContext f14615b;

        b(DispatchContext r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14615b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Map<String, String>> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f14615b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Map<String, String>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f14614a != 0) goto L10;
            o.a(r3);
            IComplexTaskService r4 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L11;
            return null;
        L11:
            return r4.getContext(this.f14615b);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ComplexTaskContextIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseRCComplexTaskContextIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((Empty) ZeusTransformUtils.preCheckCast(r6, Empty.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseRCComplexTaskContextIntent
    public Object doAction(Empty r16, DispatchContext r17, d.c.d<? super IntentResult<Empty>> r18) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r18, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L7;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
        if ((r2.f14613c & Integer.MIN_VALUE) == 0) goto L7;
        r2.f14613c -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f14611a;
        Object r4 = d.c.a.b.a();
        int r5 = r2.f14613c;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        o.a(r1);
    L18:
        return new IntentResult(0, null, null, ObricService.INSTANCE.getGson().toJson((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.aiagent.plugin")), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r1);
        ILogDepend.Companion.d(getName(), "doAction");
        g r3 = (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin");
        m r6 = (m) ZeusTransformUtils.preCheckCast(new b(r17, null), m.class, "com.obric.aiagent.plugin");
        r2.f14613c = 1;
        r1 = i.a(r3, r6, r2);
        if (r1 != r4) goto L18;
        return r4;
    L7:
        r2 = new a(this, r0);
        goto L8
    }
}
