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
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u0007J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/capabilitykit/ActionManager;", "", "()V", "ACTION_TOAST_DURATION", "", "REGISTERED_ACTIONS", "", "", "Lcom/obric/capabilitykit/common/BaseFunction;", "TAG", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "keyguardManager$delegate", "Lkotlin/Lazy;", "addTool", "", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "getTool", "name", "handleAction", "Lcom/obric/capabilitykit/common/BaseResult;", "Lcom/obric/capabilitykit/common/IMAppAction;", "(Lcom/obric/capabilitykit/common/IMAppAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTool", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {
    public static final b a = null;
    private static final String b = "ActionManager";
    private static final long c = 2000;
    private static final Map<String, BaseFunction> d = null;
    private static final Lazy e = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionManager", f = "ActionManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {74, 79, 93}, m = "handleAction", n = {CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "dispatchContext", "targetAction", "result", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "dispatchContext", "targetAction", "result", "result"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
    public static final class a extends ContinuationImpl {
        public Object a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public /* synthetic */ Object f;
        public final /* synthetic */ b g;
        public int h;

        public a(b r1, Continuation<? super a> r2) {
            this.g = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.f = r2;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.capabilitykit.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionManager$handleAction$2", f = "ActionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0078b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ Ref.ObjectRef<BaseResult> b;
        public final /* synthetic */ DispatchContext c;

        public C0078b(Ref.ObjectRef<BaseResult> r1, DispatchContext r2, Continuation<? super C0078b> r3) {
            this.b = r1;
            this.c = r2;
            super(2, r3);
        }

        public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C0078b) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C0078b(this.b, this.c, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return a(r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) goto L21;
            ResultKt.throwOnFailure(r8);
            this.b.element.getUiType();
            if ((this.b.element.getUiType() & 8) == 0) goto L19;
            b r9 = b.a;
            if (b.a(r9).isKeyguardLocked() == false) goto L19;
            boolean r1 = false;
            Method r2 = KeyguardManager.class.getMethod("dismissKeyguardToLaunch", new Class[]{Intent.class});     // Catch: Exception -> L13
            r2.setAccessible(true);     // Catch: Exception -> L13
            Object r10 = r2.invoke(b.a(r9), new Object[]{null});     // Catch: Exception -> L13
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L13
            r1 = ((Boolean) r10).booleanValue();     // Catch: Exception -> L13
        L15:
            Logger.INSTANCE.d(b.b, "handleAction,dismissKeyguardToLaunch: " + r1);
            if (r1 == true) goto L19;
            this.b.element.setDetails(this.c.getContext().getString(R.string.obric_dismiss_keyguard_failed));
        L13:
            e = move-exception;
            Logger.INSTANCE.e(b.b, "handleAction,dismissKeyguardToLaunch failed", e);
        L19:
            return Unit.INSTANCE;
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/BaseResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionManager$handleAction$result$1", f = "ActionManager.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BaseResult>, Object> {
        public int a;
        public final /* synthetic */ BaseFunction b;
        public final /* synthetic */ Ref.ObjectRef<JsonObject> c;
        public final /* synthetic */ DispatchContext d;

        public c(BaseFunction r1, Ref.ObjectRef<JsonObject> r2, DispatchContext r3, Continuation<? super c> r4) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            super(2, r4);
        }

        public final Object a(CoroutineScope r1, Continuation<? super BaseResult> r2) {
            return ((c) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new c(this.b, this.c, this.d, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super BaseResult> r2) {
            return a(r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            BaseFunction r6 = this.b;
            JsonObject r2 = this.c.element.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(r2, "params.asJsonObject");
            DispatchContext r3 = this.d;
            this.a = 1;
            r5 = r6.doAction(r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/KeyguardManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<KeyguardManager> {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
            super(0);
        }

        public final KeyguardManager a() {
            Object r1 = AppHost.Companion.getApplication().getSystemService("keyguard");
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.KeyguardManager");
            return (KeyguardManager) r1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KeyguardManager invoke() {
            return a();
        }
    }

    static {
        a = new b();
        d = new LinkedHashMap();
        e = LazyKt.lazy(d.a);
    }

    private b() {
    }

    private final KeyguardManager a() {
        return (KeyguardManager) e.getValue();
    }

    public static final /* synthetic */ KeyguardManager a(b r0) {
        return r0.a();
    }

    public final BaseFunction a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Map<String, BaseFunction> r1 = d;
        if (r1.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return r1.get(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v20, types: [T, com.obric.capabilitykit.common.BaseResult] */
    /* JADX WARN: Type inference failed for: r1v31, types: [T, com.obric.capabilitykit.common.BaseResult] */
    /* JADX WARN: Type inference failed for: r9v18, types: [T, com.google.gson.JsonObject, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3, types: [T, com.google.gson.JsonObject] */
    /* JADX WARN: Type inference failed for: r9v6, types: [T, com.google.gson.JsonObject, java.lang.Object] */
    public final Object a(IMAppAction r29, Continuation<? super BaseResult> r30) {
        IMAppAction r0 = r29;
        if ((r30 instanceof a) == false) goto L7;
        a r2 = (a) r30;
        int r3 = r2.h;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.h = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.h;
        if (r5 == 0) goto L17;
        if (r5 == 1) goto L16;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        Ref.ObjectRef r6 = (Ref.ObjectRef) r2.a;
        ResultKt.throwOnFailure(r1);
    L54:
        return r6.element;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Ref.ObjectRef r7 = (Ref.ObjectRef) r2.e;
        Ref.ObjectRef r8 = (Ref.ObjectRef) r2.d;
        BaseFunction r9 = (BaseFunction) r2.c;
        DispatchContext r10 = (DispatchContext) r2.b;
        IMAppAction r11 = (IMAppAction) r2.a;
        ResultKt.throwOnFailure(r1);
        Ref.ObjectRef r12 = r7;
        r0 = r11;
    L46:
        r12.element = (BaseResult) r1;
        if (r8.element != 0) goto L49;
        String r14 = AppHost.Companion.getApplication().getString(R.string.obric_action_exe_success);
        Intrinsics.checkNotNullExpressionValue(r14, "AppHost.application.getS…obric_action_exe_success)");
        r8.element = new BaseResult(null, null, 0, r14, null, 0, null, null, 243, null);
    L49:
        ((BaseResult) r8.element).setQuestionId(r0.getQuestionId());
        ((BaseResult) r8.element).setReplyId(r0.getMessageId());
        ((BaseResult) r8.element).setReplyFor(r9.getName());
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        C0078b r15 = new C0078b(r8, r10, null);
        r2.a = r8;
        r2.b = null;
        r2.c = null;
        r2.d = null;
        r2.e = null;
        r2.h = 3;
        if (BuildersKt.withContext(r13, r15, r2) != r4) goto L52;
        return r4;
    L52:
        r6 = r8;
        goto L54
    L17:
        ResultKt.throwOnFailure(r1);
        Logger.INSTANCE.d(b, "handleAction questionId:" + r29.getQuestionId());
        String r16 = r29.getContent();
        if (r16 != null) goto L20;
    L23:
        boolean r17 = true;
    L24:
        if (r17 == false) goto L26;
        JsonObject r18 = new JsonObject();
    L27:
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        r19.element = new JsonObject();
        JsonElement r20 = r18.get("Params");     // Catch: Exception -> L32
        if (r20.isJsonNull() == true) goto L33;
        ?? r21 = JsonParserExt.INSTANCE.parseString(r20.getAsString()).getAsJsonObject();     // Catch: Exception -> L32
        Intrinsics.checkNotNullExpressionValue(r21, "JsonParserExt.parseStrin…tr.asString).asJsonObject");     // Catch: Exception -> L32
        r19.element = r21;     // Catch: Exception -> L32
    L33:
        String r22 = r18.get("OperationId").getAsString();
        DispatchContext r110 = new DispatchContext(AppHost.Companion.getApplication(), r29.getQuestionId(), null, 4, null);
        BaseFunction r23 = d.get(r22);
        String r24 = r110.getContext().getString(R.string.obric_action_not_support);
        Intrinsics.checkNotNullExpressionValue(r24, "dispatchContext.context.…obric_action_not_support)");
        if (r23 == null) goto L36;
        r12 = new Ref.ObjectRef();
        if (r23.isBlock() == false) goto L42;
        JsonObject r25 = ((JsonObject) r19.element).getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(r25, "params.asJsonObject");
        r2.a = r0;
        r2.b = r110;
        r2.c = r23;
        r2.d = r12;
        r2.e = r12;
        r2.h = 1;
        Object r26 = r23.doAction(r25, r110, r2);
        if (r26 != r4) goto L45;
        return r4;
    L45:
        r9 = r23;
        r1 = r26;
        r8 = r12;
        r10 = r110;
        goto L46
    L42:
        c r27 = new c(r23, r19, r110, null);
        r2.a = r0;
        r2.b = r110;
        r2.c = r23;
        r2.d = r12;
        r2.e = r12;
        r2.h = 2;
        r26 = TimeoutKt.withTimeoutOrNull(WsConstants.EXIT_DELAY_TIME, r27, r2);
        if (r26 != r4) goto L45;
        return r4;
    L36:
        return new BaseResult(r29.getQuestionId(), r29.getMessageId(), 1, r24, null, 0, null, null, 224, null);
    L32:
        ?? r28 = JsonParserExt.INSTANCE.parseString("{}").getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(r28, "JsonParserExt.parseString(\"{}\").asJsonObject");
        r19.element = r28;
        goto L33
    L26:
        r18 = JsonParserExt.INSTANCE.parseString(r29.getContent()).getAsJsonObject();
        goto L27
    L20:
        if (r16.length() == 0) goto L23;
        r17 = false;
    L7:
        r2 = new a(this, r30);
        goto L8
    }

    public final void a(BaseFunction r2) {
        Intrinsics.checkNotNullParameter(r2, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        d.put(r2.getName(), r2);
    }

    public final void b(BaseFunction r1) {
        Intrinsics.checkNotNullParameter(r1, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        d.remove(r1.getName());
    }
}
