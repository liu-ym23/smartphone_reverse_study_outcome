package com.obric.capabilitykit;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseFunction;
import com.obric.capabilitykit.common.BaseResult;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.corecommon.JsonParserExt;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import d.x;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cm;
import kotlinx.coroutines.dg;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f32001a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, BaseFunction> f32002b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.f f32003c = null;

    @d.c.b.a.f(b = "ActionManager.kt", c = {74, 79, 93}, d = "handleAction", e = "com.obric.capabilitykit.ActionManager")
    public static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f32004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f32005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f32006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f32007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f32008e;
        public /* synthetic */ Object f;
        public final /* synthetic */ b g;
        public int h;

        public a(b r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f = r2;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.capabilitykit.b$b, reason: collision with other inner class name */
    @d.c.b.a.f(b = "ActionManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.capabilitykit.ActionManager$handleAction$2")
    public static final class C0874b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ z.f<BaseResult> f32010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DispatchContext f32011c;

        public C0874b(z.f<BaseResult> r3, DispatchContext r4, d.c.d<? super C0874b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32010b = r3;
            this.f32011c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0874b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0874b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return new C0874b(this.f32010b, this.f32011c, r4);
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f32009a != 0) goto L21;
            d.o.a(r9);
            ((BaseResult) ZeusTransformUtils.preCheckCast(this.f32010b.f38504a, BaseResult.class, "com.obric.aiagent.plugin")).getUiType();
            if ((((BaseResult) ZeusTransformUtils.preCheckCast(this.f32010b.f38504a, BaseResult.class, "com.obric.aiagent.plugin")).getUiType() & 8) == 0) goto L19;
            b r10 = b.f32001a;
            if (b.a(r10).isKeyguardLocked() == false) goto L19;
            boolean r1 = false;
            Method r3 = KeyguardManager.class.getMethod("dismissKeyguardToLaunch", new Class[]{Intent.class});     // Catch: Exception -> L13
            r3.setAccessible(true);     // Catch: Exception -> L13
            Object r11 = r3.invoke(b.a(r10), new Object[]{null});     // Catch: Exception -> L13
            d.h.b.o.a(r11, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L13
            r1 = ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Exception -> L13
        L15:
            Logger.INSTANCE.d("ActionManager", "handleAction,dismissKeyguardToLaunch: " + r1);
            if (r1 == true) goto L19;
            ((BaseResult) ZeusTransformUtils.preCheckCast(this.f32010b.f38504a, BaseResult.class, "com.obric.aiagent.plugin")).setDetails(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f32011c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_dismiss_keyguard_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_dismiss_keyguard_failed")));
        L13:
            e = move-exception;
            Logger.INSTANCE.e("ActionManager", "handleAction,dismissKeyguardToLaunch failed", e);
        L19:
            return x.f38692a;
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @d.c.b.a.f(b = "ActionManager.kt", c = {80}, d = "invokeSuspend", e = "com.obric.capabilitykit.ActionManager$handleAction$result$1")
    public static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super BaseResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseFunction f32013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ z.f<JsonObject> f32014c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DispatchContext f32015d;

        public c(BaseFunction r3, z.f<JsonObject> r4, DispatchContext r5, d.c.d<? super c> r6) {
            BaseFunction r7 = (BaseFunction) ZeusTransformUtils.wrapperContextForParams(r3, BaseFunction.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32013b = r7;
            this.f32014c = r4;
            this.f32015d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super BaseResult> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return new c(this.f32013b, this.f32014c, this.f32015d, r5);
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super BaseResult> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f32012a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            BaseFunction r7 = this.f32013b;
            JsonObject r2 = ((JsonObject) ZeusTransformUtils.preCheckCast(this.f32014c.f38504a, JsonObject.class, "com.obric.aiagent.plugin")).getAsJsonObject();
            d.h.b.o.c(r2, "params.asJsonObject");
            DispatchContext r3 = this.f32015d;
            this.f32012a = 1;
            r6 = r7.doAction(r2, r3, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    public static final class d extends d.h.b.p implements d.h.a.a<KeyguardManager> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f32016a = null;

        static {
            f32016a = new d();
        }

        public d() {
            super(0);
        }

        public final KeyguardManager a() {
            Object r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("keyguard");
            d.h.b.o.a(r2, "null cannot be cast to non-null type android.app.KeyguardManager");
            return (KeyguardManager) ZeusTransformUtils.preCheckCast(r2, KeyguardManager.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.a
        public /* synthetic */ KeyguardManager invoke() {
            return a();
        }
    }

    static {
        f32001a = new b();
        f32002b = new LinkedHashMap();
        f32003c = d.g.a(d.f32016a);
    }

    private b() {
    }

    private final KeyguardManager a() {
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(f32003c.b(), KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ KeyguardManager a(b r0) {
        return r0.a();
    }

    /* JADX WARN: Type inference failed for: r11v25, types: [T, com.google.gson.JsonObject, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v3, types: [T, com.google.gson.JsonObject] */
    /* JADX WARN: Type inference failed for: r11v6, types: [T, com.google.gson.JsonObject, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v24, types: [T, com.obric.capabilitykit.common.BaseResult] */
    /* JADX WARN: Type inference failed for: r1v41, types: [T, com.obric.capabilitykit.common.BaseResult] */
    public final Object a(IMAppAction r26, d.c.d<? super BaseResult> r27) {
        IMAppAction r0 = r26;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
        int r4 = r3.h;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.h = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f;
        Object r5 = d.c.a.b.a();
        int r6 = r3.h;
        if (r6 == 0) goto L17;
        if (r6 == 1) goto L16;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        z.f r7 = (z.f) ZeusTransformUtils.preCheckCast(r3.f32004a, z.f.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L54:
        return r7.f38504a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        z.f r8 = (z.f) ZeusTransformUtils.preCheckCast(r3.f32008e, z.f.class, "com.obric.aiagent.plugin");
        z.f r9 = (z.f) ZeusTransformUtils.preCheckCast(r3.f32007d, z.f.class, "com.obric.aiagent.plugin");
        BaseFunction r10 = (BaseFunction) ZeusTransformUtils.preCheckCast(r3.f32006c, BaseFunction.class, "com.obric.aiagent.plugin");
        DispatchContext r11 = (DispatchContext) ZeusTransformUtils.preCheckCast(r3.f32005b, DispatchContext.class, "com.obric.aiagent.plugin");
        IMAppAction r12 = (IMAppAction) ZeusTransformUtils.preCheckCast(r3.f32004a, IMAppAction.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        z.f r13 = r8;
        r0 = r12;
    L46:
        r13.f38504a = (BaseResult) ZeusTransformUtils.preCheckCast(r2, BaseResult.class, "com.obric.aiagent.plugin");
        if (r9.f38504a != 0) goto L49;
        String r15 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_exe_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_exe_success"));
        d.h.b.o.c(r15, "AppHost.application.getS…obric_action_exe_success)");
        r9.f38504a = new BaseResult(null, null, 0, r15, null, 0, null, null, 243, null);
    L49:
        ((BaseResult) ZeusTransformUtils.preCheckCast(r9.f38504a, BaseResult.class, "com.obric.aiagent.plugin")).setQuestionId(r0.getQuestionId());
        ((BaseResult) ZeusTransformUtils.preCheckCast(r9.f38504a, BaseResult.class, "com.obric.aiagent.plugin")).setReplyId(r0.getMessageId());
        ((BaseResult) ZeusTransformUtils.preCheckCast(r9.f38504a, BaseResult.class, "com.obric.aiagent.plugin")).setReplyFor(r10.getName());
        cm r14 = bd.b();
        C0874b r16 = new C0874b(r9, r11, null);
        r3.f32004a = r9;
        r3.f32005b = null;
        r3.f32006c = null;
        r3.f32007d = null;
        r3.f32008e = null;
        r3.h = 3;
        if (kotlinx.coroutines.i.a(r14, r16, r3) != r5) goto L52;
        return r5;
    L52:
        r7 = r9;
        goto L54
    L17:
        d.o.a(r2);
        Logger.INSTANCE.d("ActionManager", "handleAction questionId:" + r26.getQuestionId());
        String r17 = r26.getContent();
        if (r17 != null) goto L20;
    L23:
        boolean r18 = true;
    L24:
        if (r18 == false) goto L26;
        JsonObject r19 = new JsonObject();
    L27:
        z.f r20 = new z.f();
        r20.f38504a = new JsonObject();
        JsonElement r110 = r19.get("Params");     // Catch: Exception -> L32
        if (r110.isJsonNull() == true) goto L33;
        ?? r111 = JsonParserExt.INSTANCE.parseString(r110.getAsString()).getAsJsonObject();     // Catch: Exception -> L32
        d.h.b.o.c(r111, "JsonParserExt.parseStrin…tr.asString).asJsonObject");     // Catch: Exception -> L32
        r20.f38504a = r111;     // Catch: Exception -> L32
    L33:
        String r21 = r19.get("OperationId").getAsString();
        DispatchContext r112 = new DispatchContext((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), r26.getQuestionId(), null, 4, null);
        BaseFunction r22 = (BaseFunction) ZeusTransformUtils.preCheckCast(f32002b.get(r21), BaseFunction.class, "com.obric.aiagent.plugin");
        String r113 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r112.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_not_support, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_not_support"));
        d.h.b.o.c(r113, "dispatchContext.context.…obric_action_not_support)");
        if (r22 == null) goto L36;
        r13 = new z.f();
        if (r22.isBlock() == false) goto L42;
        JsonObject r23 = ((JsonObject) ZeusTransformUtils.preCheckCast(r20.f38504a, JsonObject.class, "com.obric.aiagent.plugin")).getAsJsonObject();
        d.h.b.o.c(r23, "params.asJsonObject");
        r3.f32004a = r0;
        DispatchContext r114 = r112;
        r3.f32005b = r114;
        r3.f32006c = r22;
        r3.f32007d = r13;
        r3.f32008e = r13;
        r3.h = 1;
        Object r24 = r22.doAction(r23, r114, r3);
        if (r24 != r5) goto L45;
        return r5;
    L45:
        r10 = r22;
        r2 = r24;
        r9 = r13;
        r11 = r114;
        goto L46
    L42:
        r114 = r112;
        c r25 = new c(r22, r20, r114, null);
        r3.f32004a = r0;
        r3.f32005b = r114;
        r3.f32006c = r22;
        r3.f32007d = r13;
        r3.f32008e = r13;
        r3.h = 2;
        r24 = dg.b(WsConstants.EXIT_DELAY_TIME, r25, r3);
        if (r24 != r5) goto L45;
        return r5;
    L36:
        return new BaseResult(r26.getQuestionId(), r26.getMessageId(), 1, r113, null, 0, null, null, 224, null);
    L32:
        ?? r115 = JsonParserExt.INSTANCE.parseString("{}").getAsJsonObject();
        d.h.b.o.c(r115, "JsonParserExt.parseString(\"{}\").asJsonObject");
        r20.f38504a = r115;
        goto L33
    L26:
        r19 = JsonParserExt.INSTANCE.parseString(r26.getContent()).getAsJsonObject();
        goto L27
    L20:
        if (r17.length() == 0) goto L23;
        r18 = false;
    L7:
        r3 = new a(this, r1);
        goto L8
    }
}
