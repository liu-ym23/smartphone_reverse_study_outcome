package com.obric.autogui.agents.vlm.models.impl.applist;

import android.content.Context;
import com.obric.autogui.api.IAutoActionAppListApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.o;
import java.util.List;

/* JADX INFO: compiled from: AutoActionAppListApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionAppListApiImpl implements IAutoActionAppListApi {

    /* JADX INFO: compiled from: AutoActionAppListApiImpl.kt */
    @f(b = "AutoActionAppListApiImpl.kt", c = {15}, d = "getAppListForModel", e = "com.obric.autogui.agents.vlm.models.impl.applist.AutoActionAppListApiImpl")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f27309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AutoActionAppListApiImpl f27310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27311c;

        a(AutoActionAppListApiImpl r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27310b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27309a = r3;
            this.f27311c |= Integer.MIN_VALUE;
            return this.f27310b.getAppListForModel(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AutoActionAppListApiImpl.kt */
    @f(b = "AutoActionAppListApiImpl.kt", c = {20}, d = "getAppListForModelV2", e = "com.obric.autogui.agents.vlm.models.impl.applist.AutoActionAppListApiImpl")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f27312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AutoActionAppListApiImpl f27313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27314c;

        b(AutoActionAppListApiImpl r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27313b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27312a = r3;
            this.f27314c |= Integer.MIN_VALUE;
            return this.f27313b.getAppListForModelV2(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public AutoActionAppListApiImpl() {
    }

    @Override // com.obric.autogui.api.IAutoActionAppListApi
    public Object getAppListForModel(Context r5, d.c.d<? super List<String>> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
        if ((r0.f27311c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27311c -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f27309a;
        Object r9 = d.c.a.b.a();
        int r2 = r0.f27311c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r4);
    L18:
        return ((com.obric.autogui.agents.vlm.models.impl.applist.b) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.vlm.models.impl.applist.b.class, "com.obric.aiagent.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r4);
        com.obric.autogui.agents.vlm.models.impl.applist.b r10 = new com.obric.autogui.agents.vlm.models.impl.applist.b(r7);
        r0.f27311c = 1;
        r4 = r10.a(r0);
        if (r4 != r9) goto L18;
        return r9;
    L7:
        r0 = new a(this, r8);
        goto L8
    }

    @Override // com.obric.autogui.api.IAutoActionAppListApi
    public Object getAppListForModelV2(Context r5, d.c.d<? super List<String[]>> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin");
        if ((r0.f27314c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27314c -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f27312a;
        Object r9 = d.c.a.b.a();
        int r2 = r0.f27314c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r4);
    L18:
        return ((com.obric.autogui.agents.vlm.models.impl.applist.b) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.vlm.models.impl.applist.b.class, "com.obric.aiagent.plugin")).b();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r4);
        com.obric.autogui.agents.vlm.models.impl.applist.b r10 = new com.obric.autogui.agents.vlm.models.impl.applist.b(r7);
        r0.f27314c = 1;
        r4 = r10.a(r0);
        if (r4 != r9) goto L18;
        return r9;
    L7:
        r0 = new b(this, r8);
        goto L8
    }
}
