package com.obric.capabilitykit;

import android.app.KeyguardManager;
import android.content.Intent;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseFunction;
import com.obric.capabilitykit.common.BaseResult;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.corecommon.JsonParserExt;
import com.obric.capabilitykit.logger.Logger;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11220a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f11221b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f11222c = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionManager", f = "ActionManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {74, 79, 93}, m = "handleAction", n = {"action", "dispatchContext", "targetAction", "result", "action", "dispatchContext", "targetAction", "result", "result"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f11224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f11225c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f11226d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f11227e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public /* synthetic */ Object f11228f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ b f11229g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11230h;

        public a(b r10, Continuation<? super a> r11) {
            this.f11229g = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            this.f11228f = r10;
            this.f11230h |= Integer.MIN_VALUE;
            return this.f11229g.c(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.capabilitykit.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionManager$handleAction$2", f = "ActionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0175b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<BaseResult> f11232b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DispatchContext f11233c;

        public C0175b(Ref$ObjectRef<BaseResult> r10, DispatchContext r11, Continuation<? super C0175b> r12) {
            this.f11232b = r10;
            this.f11233c = r11;
            super(2, r12);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((C0175b) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new C0175b(this.f11232b, this.f11233c, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return a(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            kotlin.coroutines.intrinsics.a.d();
            if (this.f11231a != 0) goto L20;
            kotlin.c.b(r10);
            this.f11232b.element.getUiType();
            if ((this.f11232b.element.getUiType() & 8) == 0) goto L18;
            b r11 = b.f11220a;
            if (b.b(r11).isKeyguardLocked() == false) goto L18;
            Method r12 = KeyguardManager.class.getMethod("dismissKeyguardToLaunch", new Class[]{Intent.class});     // Catch: Exception -> L12
            r12.setAccessible(true);     // Catch: Exception -> L12
            Object r13 = r12.invoke(b.b(r11), new Object[]{null});     // Catch: Exception -> L12
            kotlin.jvm.internal.q.e(r13, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L12
            boolean r14 = ((Boolean) r13).booleanValue();     // Catch: Exception -> L12
        L14:
            Logger.INSTANCE.d("ActionManager", "handleAction,dismissKeyguardToLaunch: " + r14);
            if (r14 == true) goto L18;
            this.f11232b.element.setDetails(this.f11233c.getContext().getString(R$string.obric_dismiss_keyguard_failed));
        L12:
            e = move-exception;
            Logger.INSTANCE.e("ActionManager", "handleAction,dismissKeyguardToLaunch failed", e);
            r14 = false;
        L18:
            return Unit.f21064a;
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/BaseResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionManager$handleAction$result$1", f = "ActionManager.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BaseResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseFunction f11235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<JsonObject> f11236c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DispatchContext f11237d;

        public c(BaseFunction r10, Ref$ObjectRef<JsonObject> r11, DispatchContext r12, Continuation<? super c> r13) {
            this.f11235b = r10;
            this.f11236c = r11;
            this.f11237d = r12;
            super(2, r13);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super BaseResult> r11) {
            return ((c) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new c(this.f11235b, this.f11236c, this.f11237d, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super BaseResult> r11) {
            return a(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.f11234a;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            kotlin.c.b(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            BaseFunction r13 = this.f11235b;
            JsonObject r14 = this.f11236c.element.getAsJsonObject();
            kotlin.jvm.internal.q.f(r14, "params.asJsonObject");
            DispatchContext r15 = this.f11237d;
            this.f11234a = 1;
            r10 = r13.doAction(r14, r15, this);
            if (r10 != r11) goto L11;
            return r11;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/KeyguardManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<KeyguardManager> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f11238a = null;

        static {
            f11238a = new d();
        }

        public d() {
            super(0);
        }

        @NotNull
        public final KeyguardManager a() {
            Object r10 = AppHost.Companion.getApplication().getSystemService("keyguard");
            kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type android.app.KeyguardManager");
            return (KeyguardManager) r10;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KeyguardManager invoke() {
            return a();
        }
    }

    static {
        f11220a = new b();
        f11221b = new LinkedHashMap();
        f11222c = kotlin.b.b(d.f11238a);
    }

    public b() {
    }

    public static final /* synthetic */ KeyguardManager b(b r10) {
        return r10.a();
    }

    public final KeyguardManager a() {
        return (KeyguardManager) f11222c.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17, types: [T, com.obric.capabilitykit.common.BaseResult] */
    /* JADX WARN: Type inference failed for: r1v28, types: [T, com.obric.capabilitykit.common.BaseResult] */
    /* JADX WARN: Type inference failed for: r9v18, types: [T, com.google.gson.JsonObject, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3, types: [T, com.google.gson.JsonObject] */
    /* JADX WARN: Type inference failed for: r9v6, types: [T, com.google.gson.JsonObject, java.lang.Object] */
    public final Object c(IMAppAction r29, Continuation r30) {
        IMAppAction r10 = r29;
        if ((r30 instanceof a) == false) goto L7;
        a r11 = (a) r30;
        int r12 = r11.f11230h;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f11230h = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f11228f;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.f11230h;
        if (r15 == 0) goto L17;
        if (r15 == 1) goto L16;
        if (r15 == 2) goto L16;
        if (r15 != 3) goto L15;
        Ref$ObjectRef r16 = (Ref$ObjectRef) r11.f11223a;
        kotlin.c.b(r13);
    L51:
        return r16.element;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Ref$ObjectRef r17 = (Ref$ObjectRef) r11.f11227e;
        Ref$ObjectRef r18 = (Ref$ObjectRef) r11.f11226d;
        BaseFunction r19 = (BaseFunction) r11.f11225c;
        DispatchContext r20 = (DispatchContext) r11.f11224b;
        IMAppAction r21 = (IMAppAction) r11.f11223a;
        kotlin.c.b(r13);
        Ref$ObjectRef r22 = r17;
        r10 = r21;
    L43:
        r22.element = (BaseResult) r13;
        if (r18.element != 0) goto L46;
        String r110 = AppHost.Companion.getApplication().getString(R$string.obric_action_exe_success);
        kotlin.jvm.internal.q.f(r110, "AppHost.application.getS…obric_action_exe_success)");
        r18.element = new BaseResult(null, null, 0, r110, null, 0, null, null, 243, null);
    L46:
        ((BaseResult) r18.element).setQuestionId(r10.getQuestionId());
        ((BaseResult) r18.element).setReplyId(r10.getMessageId());
        ((BaseResult) r18.element).setReplyFor(r19.getName());
        o1 r23 = l0.c();
        C0175b r24 = new C0175b(r18, r20, null);
        r11.f11223a = r18;
        r11.f11224b = null;
        r11.f11225c = null;
        r11.f11226d = null;
        r11.f11227e = null;
        r11.f11230h = 3;
        if (h.g(r23, r24, r11) != r14) goto L49;
        return r14;
    L49:
        r16 = r18;
        goto L51
    L17:
        kotlin.c.b(r13);
        Logger.INSTANCE.d("ActionManager", "handleAction questionId:" + r29.getQuestionId());
        String r25 = r29.getContent();
        if (r25 != null) goto L20;
    L23:
        JsonObject r26 = new JsonObject();
    L24:
        Ref$ObjectRef r27 = new Ref$ObjectRef();
        r27.element = new JsonObject();
        JsonElement r28 = r26.get("Params");     // Catch: Exception -> L29
        if (r28.isJsonNull() == true) goto L30;
        ?? r31 = JsonParserExt.INSTANCE.parseString(r28.getAsString()).getAsJsonObject();     // Catch: Exception -> L29
        kotlin.jvm.internal.q.f(r31, "JsonParserExt.parseStrin…tr.asString).asJsonObject");     // Catch: Exception -> L29
        r27.element = r31;     // Catch: Exception -> L29
    L30:
        String r32 = r26.get("OperationId").getAsString();
        DispatchContext r111 = new DispatchContext(AppHost.Companion.getApplication(), r29.getQuestionId(), null, 4, null);
        BaseFunction r33 = (BaseFunction) f11221b.get(r32);
        String r34 = r111.getContext().getString(R$string.obric_action_not_support);
        kotlin.jvm.internal.q.f(r34, "dispatchContext.context.…obric_action_not_support)");
        if (r33 == null) goto L33;
        r22 = new Ref$ObjectRef();
        if (r33.isBlock() == false) goto L39;
        JsonObject r35 = ((JsonObject) r27.element).getAsJsonObject();
        kotlin.jvm.internal.q.f(r35, "params.asJsonObject");
        r11.f11223a = r10;
        r11.f11224b = r111;
        r11.f11225c = r33;
        r11.f11226d = r22;
        r11.f11227e = r22;
        r11.f11230h = 1;
        Object r36 = r33.doAction(r35, r111, r11);
        if (r36 != r14) goto L42;
        return r14;
    L42:
        r19 = r33;
        r13 = r36;
        r18 = r22;
        r20 = r111;
        goto L43
    L39:
        c r37 = new c(r33, r27, r111, null);
        r11.f11223a = r10;
        r11.f11224b = r111;
        r11.f11225c = r33;
        r11.f11226d = r22;
        r11.f11227e = r22;
        r11.f11230h = 2;
        r36 = TimeoutKt.d(WsConstants.EXIT_DELAY_TIME, r37, r11);
        if (r36 != r14) goto L42;
        return r14;
    L33:
        return new BaseResult(r29.getQuestionId(), r29.getMessageId(), 1, r34, null, 0, null, null, 224, null);
    L29:
        ?? r38 = JsonParserExt.INSTANCE.parseString("{}").getAsJsonObject();
        kotlin.jvm.internal.q.f(r38, "JsonParserExt.parseString(\"{}\").asJsonObject");
        r27.element = r38;
        goto L30
    L20:
        if (r25.length() == 0) goto L23;
        r26 = JsonParserExt.INSTANCE.parseString(r29.getContent()).getAsJsonObject();
    L7:
        r11 = new a(this, r30);
        goto L8
    }
}
