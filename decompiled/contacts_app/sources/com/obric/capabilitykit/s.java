package com.obric.capabilitykit;

import android.app.Application;
import com.google.gson.Gson;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseResultExt;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u0012*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/obric/capabilitykit/execution/IntentDispatcherClient;", "", "()V", "TAG", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "onIntentReceived", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/IMAppAction;", "intentCalling", "Lcom/obric/capabilitykit/common/execution/IntentCalling;", "jobId", "(Lcom/obric/capabilitykit/common/execution/IntentCalling;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toBaseResultExt", "Lcom/obric/capabilitykit/common/BaseResultExt;", "Ljava/util/concurrent/ConcurrentHashMap;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class s {
    public static final s a = null;
    private static final String b = "IntentDispatcher";
    private static final CoroutineScope c = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.IntentDispatcherClient", f = "IntentDispatcherClient.kt", i = {0, 0, 0}, l = {36}, m = "onIntentReceived", n = {"intentCalling", "context", "start"}, s = {"L$0", "L$1", "J$0"})
    public static final class a extends ContinuationImpl {
        public Object a;
        public Object b;
        public long c;
        public /* synthetic */ Object d;
        public final /* synthetic */ s e;
        public int f;

        public a(s r1, Continuation<? super a> r2) {
            this.e = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.d = r2;
            this.f |= Integer.MIN_VALUE;
            return this.e.a(null, null, this);
        }
    }

    public static /* synthetic */ Thread $r8$lambda$jFgaDheJ95aBB_Zbd0wlHZGU9Jw(Runnable r0) {
        return a(r0);
    }

    static {
        a = new s();
        ExecutorService r0 = Executors.newSingleThreadExecutor(new s$$ExternalSyntheticLambda0());
        Intrinsics.checkNotNullExpressionValue(r0, "newSingleThreadExecutor …intent-dispatcher\")\n    }");
        c = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(r0));
    }

    private s() {
    }

    private final BaseResultExt a(ConcurrentHashMap<String, String> r1) {
        BaseResultExt r0 = new BaseResultExt();
        r0.putAll(r1);
        return r0;
    }

    private static final Thread a(Runnable r2) {
        return new Thread(r2, "intent-dispatcher");
    }

    public final Object a(IntentCalling r37, String r38, Continuation<? super Pair<? extends IntentResult<?>, IMAppAction>> r39) {
        IntentCalling r0 = r37;
        if ((r39 instanceof a) == false) goto L7;
        a r2 = (a) r39;
        int r3 = r2.f;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.f = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.d;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.f;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r6 = r2.c;
        Application r7 = (Application) r2.b;
        IntentCalling r8 = (IntentCalling) r2.a;
        ResultKt.throwOnFailure(r1);
        Application r9 = r7;
        r0 = r8;
        Object r10 = r1;
    L18:
        IntentResult r11 = (IntentResult) r10;
        long r12 = System.currentTimeMillis() - r6;
        String r13 = r9.getString(R.string.obric_action_success);
        Intrinsics.checkNotNullExpressionValue(r13, "context.getString(R.string.obric_action_success)");
        String r14 = r9.getString(R.string.obric_action_failed);
        Intrinsics.checkNotNullExpressionValue(r14, "context.getString(R.string.obric_action_failed)");
        if (r11.getRet() != 0) goto L25;
        String r15 = r11.getDetails();
        if (r15 == null) goto L24;
        r13 = r15;
    L24:
        r11.setDetails(r13);
    L25:
        Gson r16 = UtilsKt.getGson();
        int r17 = r11.getRet();
        String r18 = r11.getDetails();
        if (r18 != null) goto L28;
        String r19 = r14;
    L29:
        String r25 = r16.toJson(new FeedbackResult(r17, r19, null, r11.getUiType(), String.valueOf(r0.getReplyFor()), false, 36, null));
        if ((r11.getUiType() & 32) == 0) goto L32;
    L69:
        String r20 = UUID.randomUUID().toString();
        long r21 = r0.getMessageId();
        long r22 = r0.getQuestionId();
        long r23 = r0.getMessageId();
        long r27 = r0.getActionId();
        long r29 = r0.getJobId();
        IMAppActionExt r24 = new IMAppActionExt();
        ConcurrentHashMap<String, String> r26 = r11.getExt();
        if (r26 == null) goto L74;
        BaseResultExt r28 = a.a(r26);
        if (r28 == null) goto L74;
        String r30 = r28.getResultDetailExtras();
    L75:
        r24.setActionDetailExtras(r30);
        r24.put("app_cost", String.valueOf(r12));
        ConcurrentHashMap<String, String> r31 = r11.getExt();
        if (r31 == null) goto L79;
        r24.putAll(r31);
    L79:
        return new Pair(r11, new IMAppAction(0, Boxing.boxLong(r23), r20, r21, Boxing.boxLong(r22), null, r25, null, r27, r29, 0, r24, 1185, null));
    L74:
        r30 = null;
        goto L75
    L32:
        if ((r11.getUiType() & 64) != 0) goto L69;
        if ((r11.getUiType() & 128) != 0) goto L69;
        if ((r11.getUiType() & 512) != 0) goto L69;
        if ((r11.getUiType() & 1024) != 0) goto L69;
        if ((r11.getUiType() & 2048) != 0) goto L69;
        if ((r11.getUiType() & 4096) != 0) goto L69;
        if ((r11.getUiType() & 8192) != 0) goto L69;
        if ((r11.getUiType() & 16384) != 0) goto L69;
        if ((r11.getUiType() & 32768) != 0) goto L69;
        if ((r11.getUiType() & 524288) != 0) goto L69;
        if ((r11.getUiType() & 65536) != 0) goto L69;
        if ((r11.getUiType() & 131072) != 0) goto L69;
        if ((r11.getUiType() & 1048576) != 0) goto L69;
        if ((r11.getUiType() & 262144) != 0) goto L69;
        if ((r11.getUiType() & 2097152) != 0) goto L69;
        if ((r11.getUiType() & 8388608) != 0) goto L69;
        String r210 = UUID.randomUUID().toString();
        long r211 = r0.getMessageId();
        long r32 = r0.getQuestionId();
        long r33 = r0.getMessageId();
        long r212 = r0.getActionId();
        long r213 = r0.getJobId();
        IMAppActionExt r34 = new IMAppActionExt();
        r34.put("app_cost", String.valueOf(r12));
        ConcurrentHashMap<String, String> r35 = r11.getExt();
        if (r35 == null) goto L68;
        r34.putAll(r35);
    L68:
        return new Pair(r11, new IMAppAction(0, Boxing.boxLong(r33), r210, r211, Boxing.boxLong(r32), null, r25, null, r212, r213, 0, r34, 1185, null));
    L28:
        r19 = r18;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r9 = AppHost.Companion.getApplication();
        long r36 = System.currentTimeMillis();
        t r40 = t.a;
        r2.a = r0;
        r2.b = r9;
        r2.c = r36;
        r2.f = 1;
        r10 = r40.a(r9, r0, r38, r2);
        if (r10 != r4) goto L17;
        return r4;
    L17:
        r6 = r36;
    L7:
        r2 = new a(this, r39);
        goto L8
    }

    public final CoroutineScope a() {
        return c;
    }
}
