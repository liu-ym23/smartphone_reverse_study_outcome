package com.obric.capabilitykit;

import androidx.annotation.Keep;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.Gson;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseResult;
import com.obric.capabilitykit.common.BaseResultExt;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.logger.Logger;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004J3\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001bJ?\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00062'\u0010\u001f\u001a#\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!\u0012\u0006\u0012\u0004\u0018\u00010\u00010 ¢\u0006\u0002\b\"ø\u0001\u0000¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0019\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/ActionDispatcher;", "", "()V", "TAG", "", "<set-?>", "", "dispatchStartedQuestion", "getDispatchStartedQuestion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "parallelScope", "Lkotlinx/coroutines/CoroutineScope;", "getParallelScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "getScope", "getAppActionFailResult", "Lcom/obric/capabilitykit/common/IMAppAction;", Ext.KEY_REQUEST, ServerElements.CODE, "", "msg", "getIntentFailResult", "intentCalling", "Lcom/obric/capabilitykit/common/execution/IntentCalling;", "duration", "(Lcom/obric/capabilitykit/common/execution/IntentCalling;ILjava/lang/String;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/IMAppAction;", "launchWithTrace", "", "questionId", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;)V", "markDispatchEnded", "markDispatchStarted", "onActionReceived", "action", "(Lcom/obric/capabilitykit/common/IMAppAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ActionDispatcher {

    @NotNull
    public static final ActionDispatcher INSTANCE = null;

    @NotNull
    private static final String TAG = "ActionDispatcher";

    @Nullable
    private static Long dispatchStartedQuestion;

    @NotNull
    private static final CoroutineScope parallelScope = null;

    @NotNull
    private static final CoroutineScope scope = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionDispatcher$launchWithTrace$1", f = "ActionDispatcher.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f11140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f11141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> f11142d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long r10, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super a> r12) {
            this.f11141c = r10;
            this.f11142d = r11;
            super(2, r12);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((a) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            a r12 = new a(this.f11141c, this.f11142d, r11);
            r12.f11140b = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return a(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.f11139a;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            kotlin.c.b(r10);
        L11:
            ActionDispatcher.access$markDispatchEnded(ActionDispatcher.INSTANCE, this.f11141c);
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            CoroutineScope r13 = (CoroutineScope) this.f11140b;
            ActionDispatcher.access$markDispatchStarted(ActionDispatcher.INSTANCE, this.f11141c);
            Function2<CoroutineScope, Continuation<? super Unit>, Object> r14 = this.f11142d;
            this.f11139a = 1;
            if (r14.mo0invoke(r13, this) != r11) goto L11;
            return r11;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionDispatcher", f = "ActionDispatcher.kt", i = {0, 0}, l = {58}, m = "onActionReceived", n = {"action", "start"}, s = {"L$0", "J$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f11144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f11145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ActionDispatcher f11146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11147e;

        public b(ActionDispatcher r10, Continuation<? super b> r11) {
            this.f11146d = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            this.f11145c = r10;
            this.f11147e |= Integer.MIN_VALUE;
            return this.f11146d.onActionReceived(null, this);
        }
    }

    static {
        INSTANCE = new ActionDispatcher();
        ExecutorService r10 = Executors.newSingleThreadExecutor(new cb.a());
        kotlin.jvm.internal.q.f(r10, "newSingleThreadExecutor …action-dispatcher\")\n    }");
        scope = d0.a(x0.b(r10));
        ExecutorService r11 = Executors.newCachedThreadPool(new cb.b());
        kotlin.jvm.internal.q.f(r11, "newCachedThreadPool {\n  …spatcher-parallel\")\n    }");
        parallelScope = d0.a(x0.b(r11));
    }

    private ActionDispatcher() {
    }

    public static /* synthetic */ Thread a(Runnable r10) {
        return scope$lambda$0(r10);
    }

    public static final /* synthetic */ void access$markDispatchEnded(ActionDispatcher r10, long r11) {
        r10.markDispatchEnded(r11);
    }

    public static final /* synthetic */ void access$markDispatchStarted(ActionDispatcher r10, long r11) {
        r10.markDispatchStarted(r11);
    }

    public static /* synthetic */ Thread b(Runnable r10) {
        return parallelScope$lambda$1(r10);
    }

    public static /* synthetic */ IMAppAction getAppActionFailResult$default(ActionDispatcher r10, IMAppAction r11, int r12, String r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = null;
    L6:
        return r10.getAppActionFailResult(r11, r12, r13);
    }

    public static /* synthetic */ IMAppAction getIntentFailResult$default(ActionDispatcher r10, IntentCalling r11, int r12, String r13, Long r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L6;
        r13 = null;
    L6:
        if ((r15 & 8) == 0) goto L9;
        r14 = null;
    L9:
        return r10.getIntentFailResult(r11, r12, r13, r14);
    }

    private final void markDispatchEnded(long r10) {
        Logger.INSTANCE.d(TAG, "** ActionDispatcher [ended qId=" + r10 + ']');
        dispatchStartedQuestion = null;
    }

    private final void markDispatchStarted(long r10) {
        Logger.INSTANCE.d(TAG, "** ActionDispatcher [started qId=" + r10 + ']');
        dispatchStartedQuestion = Long.valueOf(r10);
    }

    private static final Thread parallelScope$lambda$1(Runnable r10) {
        return new Thread(r10, "action-dispatcher-parallel");
    }

    private static final Thread scope$lambda$0(Runnable r10) {
        return new Thread(r10, "action-dispatcher");
    }

    @NotNull
    public final IMAppAction getAppActionFailResult(@NotNull IMAppAction r32, int r33, @Nullable String r34) {
        kotlin.jvm.internal.q.g(r32, Ext.KEY_REQUEST);
        Gson r10 = UtilsKt.getGson();
        if (r34 != null) goto L5;
        String r11 = "failed";
    L6:
        String r21 = r10.toJson(new FeedbackResult(r33, r11, null, 1, String.valueOf(r32.getReplyId()), false, 36, null));
        String r16 = UUID.randomUUID().toString();
        long r17 = r32.getReplyId();
        Long r19 = r32.getQuestionId();
        return new IMAppAction(0, r32.getMessageId(), r16, r17, r19, null, r21, null, r32.getActionId(), r32.getJobId(), 0, null, 3233, null);
    L5:
        r11 = r34;
        goto L6
    }

    @Nullable
    public final Long getDispatchStartedQuestion() {
        return dispatchStartedQuestion;
    }

    @NotNull
    public final IMAppAction getIntentFailResult(@NotNull IntentCalling r32, int r33, @Nullable String r34, @Nullable Long r35) {
        kotlin.jvm.internal.q.g(r32, "intentCalling");
        Gson r10 = UtilsKt.getGson();
        if (r34 != null) goto L5;
        String r11 = "failed";
    L6:
        String r21 = r10.toJson(new FeedbackResult(r33, r11, null, 1, String.valueOf(r32.getReplyFor()), false, 36, null));
        String r16 = UUID.randomUUID().toString();
        long r17 = r32.getReplyFor();
        long r12 = r32.getQuestionId();
        long r13 = r32.getMessageId();
        long r23 = r32.getActionId();
        long r25 = r32.getJobId();
        if (r35 == null) goto L9;
        long r14 = r35.longValue();
        IMAppActionExt r15 = new IMAppActionExt();
        r15.put("app_cost", String.valueOf(r14));
        IMAppActionExt r28 = r15;
    L11:
        return new IMAppAction(0, Long.valueOf(r13), r16, r17, Long.valueOf(r12), null, r21, null, r23, r25, 0, r28, 1185, null);
    L9:
        r28 = null;
        goto L11
    L5:
        r11 = r34;
        goto L6
    }

    @NotNull
    public final CoroutineScope getParallelScope() {
        return parallelScope;
    }

    @NotNull
    public final CoroutineScope getScope() {
        return scope;
    }

    public final void launchWithTrace(long r10, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r11) {
        kotlin.jvm.internal.q.g(r11, "block");
        h.d(scope, null, null, new a(r10, r11, null), 3, null);
    }

    @Nullable
    public final Object onActionReceived(@NotNull IMAppAction r36, @NotNull Continuation<? super IMAppAction> r37) {
        IMAppAction r10 = r36;
        if ((r37 instanceof b) == false) goto L7;
        b r11 = (b) r37;
        int r12 = r11.f11147e;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f11147e = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f11145c;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.f11147e;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        long r16 = r11.f11144b;
        r10 = (IMAppAction) r11.f11143a;
        kotlin.c.b(r13);
    L18:
        BaseResult r17 = (BaseResult) r13;
        long r18 = System.currentTimeMillis() - r16;
        Gson r19 = new Gson();
        AppHost.Companion r20 = AppHost.Companion;
        String r21 = r20.getApplication().getString(R$string.obric_action_success);
        kotlin.jvm.internal.q.f(r21, "AppHost.application.getS…ing.obric_action_success)");
        String r22 = r20.getApplication().getString(R$string.obric_action_failed);
        kotlin.jvm.internal.q.f(r22, "AppHost.application.getS…ring.obric_action_failed)");
        if (r17.getRet() != 0) goto L25;
        String r23 = r17.getDetails();
        if (r23 == null) goto L24;
        r21 = r23;
    L24:
        r17.setDetails(r21);
    L25:
        int r24 = r17.getRet();
        String r25 = r17.getDetails();
        if (r25 != null) goto L28;
        String r26 = r22;
    L29:
        String r27 = r19.toJson(new FeedbackResult(r24, r26, null, r17.getUiType(), r17.getReplyFor(), false, 36, null));
        long r28 = 0;
        if ((r17.getUiType() & 32) == 0) goto L32;
    L75:
        String r29 = UUID.randomUUID().toString();
        Long r30 = r17.getReplyId();
        if (r30 == null) goto L78;
        r28 = r30.longValue();
    L78:
        long r210 = r28;
        Long r211 = r17.getQuestionId();
        Long r110 = r10.getMessageId();
        long r212 = r10.getActionId();
        long r213 = r10.getJobId();
        IMAppActionExt r31 = new IMAppActionExt();
        ConcurrentHashMap<String, String> r32 = r17.getExt();
        String r33 = null;
        if ((r32 instanceof BaseResultExt) == false) goto L81;
        BaseResultExt r34 = (BaseResultExt) r32;
    L82:
        if (r34 == null) goto L84;
        r33 = r34.getResultDetailExtras();
    L84:
        r31.setActionDetailExtras(r33);
        r31.put("app_cost", String.valueOf(r18));
        ConcurrentHashMap<String, String> r35 = r17.getExt();
        if (r35 == null) goto L88;
        r31.putAll(r35);
    L88:
        return new IMAppAction(0, r110, r29, r210, r211, null, r27, null, r212, r213, 0, r31, 1185, null);
    L81:
        r34 = null;
        goto L82
    L32:
        if ((r17.getUiType() & 64) != 0) goto L75;
        if ((r17.getUiType() & 128) != 0) goto L75;
        if ((r17.getUiType() & 512) != 0) goto L75;
        if ((r17.getUiType() & 1024) != 0) goto L75;
        if ((r17.getUiType() & 2048) != 0) goto L75;
        if ((r17.getUiType() & 4096) != 0) goto L75;
        if ((r17.getUiType() & 8192) != 0) goto L75;
        if ((r17.getUiType() & 16384) != 0) goto L75;
        if ((r17.getUiType() & UiType.FLAG_SETTINGS_CARD) != 0) goto L75;
        if ((r17.getUiType() & UiType.FLAG_WIFI_QRCODE_CARD) != 0) goto L75;
        if ((r17.getUiType() & 65536) != 0) goto L75;
        if ((r17.getUiType() & UiType.FLAG_PHONE_CARD) != 0) goto L75;
        if ((r17.getUiType() & UiType.FLAG_APP_CHOOSER_CARD) != 0) goto L75;
        if ((r17.getUiType() & UiType.FLAG_TIMER_CARD) != 0) goto L75;
        if ((r17.getUiType() & UiType.FLAG_REMOTE_CARD) != 0) goto L75;
        if ((r17.getUiType() & UiType.FLAG_APPLET_CARD) != 0) goto L75;
        String r214 = UUID.randomUUID().toString();
        Long r38 = r17.getReplyId();
        if (r38 == null) goto L67;
        r28 = r38.longValue();
    L67:
        long r215 = r28;
        Long r216 = r17.getQuestionId();
        Long r111 = r10.getMessageId();
        long r217 = r10.getActionId();
        long r218 = r10.getJobId();
        IMAppActionExt r39 = r10.getExt();
        if (r39 != null) goto L70;
        r39 = new IMAppActionExt();
    L70:
        r39.put("app_cost", String.valueOf(r18));
        ConcurrentHashMap<String, String> r40 = r17.getExt();
        if (r40 == null) goto L74;
        r39.putAll(r40);
    L74:
        return new IMAppAction(0, r111, r214, r215, r216, null, r27, null, r217, r218, 0, r39, 1185, null);
    L28:
        r26 = r25;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r13);
        long r41 = System.currentTimeMillis();
        com.obric.capabilitykit.b r42 = com.obric.capabilitykit.b.f11220a;
        r11.f11143a = r10;
        r11.f11144b = r41;
        r11.f11147e = 1;
        r13 = r42.c(r10, r11);
        if (r13 != r14) goto L17;
        return r14;
    L17:
        r16 = r41;
    L7:
        r11 = new b(this, r37);
        goto L8
    }
}
