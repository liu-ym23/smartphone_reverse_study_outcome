package com.obric.aiagent.executionengine.capabilitymanager.matcher;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.executionengine.capabilitymanager.api.matcher.IActionMatcherApi;
import com.obric.aiagent.executionengine.capabilitymanager.matcher.bean.ActionData;
import com.obric.capabilitykit.common.AppAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ActionMatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ActionMatcherService implements IActionMatcherApi {

    /* JADX INFO: compiled from: ActionMatcher.kt */
    @f(b = "ActionMatcher.kt", c = {23}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.capabilitymanager.matcher.ActionMatcherService$getAppFunctionSkills$2")
    static final class a extends l implements m<am, d<? super List<? extends com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16452a;

        a(d<? super a> r3) {
            super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d<? super List<com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c>> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r1, d<?> r2) {
            return (d) ZeusTransformUtils.preCheckCast(new a((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super List<? extends com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16452a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            com.obric.aiagent.executionengine.capabilitymanager.matcher.a.d r6 = com.obric.aiagent.executionengine.capabilitymanager.matcher.a.d.f16488a;
            d<? super List<com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c>> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f16452a = 1;
            r5 = r6.b(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.api.matcher.IActionMatcherApi
    public Object queryExecutableAppAction(JsonObject r1, d<? super AppAction> r2) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        return null;
    }

    public ActionMatcherService() {
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.api.matcher.IActionMatcherApi
    public Object getAppFunctionSkills(d<? super List<com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.c>> r4) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new a(null), m.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.api.matcher.IActionMatcherApi
    public Object queryExecutableIntent(JsonObject r3, d<? super com.obric.aiagent.executionengine.capabilitymanager.api.matcher.a> r4) {
        d<? super com.obric.aiagent.executionengine.capabilitymanager.api.matcher.a> r2 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        ActionData r5 = (ActionData) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r3, JsonElement.class, "com.obric.aiagent.plugin"), ActionData.class), ActionData.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.capabilitymanager.matcher.a.f16453a.a(r5, r2);
    }
}
