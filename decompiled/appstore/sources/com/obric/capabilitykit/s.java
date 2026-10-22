package com.obric.capabilitykit;

import android.app.Application;
import com.google.gson.Gson;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseResultExt;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f11380a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f11381b = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.IntentDispatcherClient", f = "IntentDispatcherClient.kt", i = {0, 0, 0}, l = {36}, m = "onIntentReceived", n = {"intentCalling", "context", "start"}, s = {"L$0", "L$1", "J$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f11383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f11384c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f11385d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ s f11386e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11387f;

        public a(s r10, Continuation<? super a> r11) {
            this.f11386e = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            this.f11385d = r10;
            this.f11387f |= Integer.MIN_VALUE;
            return this.f11386e.c(null, null, this);
        }
    }

    static {
        f11380a = new s();
        ExecutorService r10 = Executors.newSingleThreadExecutor(new cb.v());
        kotlin.jvm.internal.q.f(r10, "newSingleThreadExecutor …intent-dispatcher\")\n    }");
        f11381b = d0.a(x0.b(r10));
    }

    public s() {
    }

    public static /* synthetic */ Thread a(Runnable r10) {
        return d(r10);
    }

    public static final Thread d(Runnable r10) {
        return new Thread(r10, "intent-dispatcher");
    }

    public final BaseResultExt b(ConcurrentHashMap r10) {
        BaseResultExt r11 = new BaseResultExt();
        r11.putAll(r10);
        return r11;
    }

    public final Object c(IntentCalling r37, String r38, Continuation r39) {
        IntentCalling r10 = r37;
        if ((r39 instanceof a) == false) goto L7;
        a r11 = (a) r39;
        int r12 = r11.f11387f;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f11387f = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f11385d;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.f11387f;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        long r16 = r11.f11384c;
        Application r17 = (Application) r11.f11383b;
        IntentCalling r18 = (IntentCalling) r11.f11382a;
        kotlin.c.b(r13);
        Application r19 = r17;
        r10 = r18;
        Object r20 = r13;
    L18:
        IntentResult r21 = (IntentResult) r20;
        long r22 = System.currentTimeMillis() - r16;
        String r23 = r19.getString(R$string.obric_action_success);
        kotlin.jvm.internal.q.f(r23, "context.getString(R.string.obric_action_success)");
        String r24 = r19.getString(R$string.obric_action_failed);
        kotlin.jvm.internal.q.f(r24, "context.getString(R.string.obric_action_failed)");
        if (r21.getRet() != 0) goto L25;
        String r25 = r21.getDetails();
        if (r25 == null) goto L24;
        r23 = r25;
    L24:
        r21.setDetails(r23);
    L25:
        Gson r26 = UtilsKt.getGson();
        int r27 = r21.getRet();
        String r28 = r21.getDetails();
        if (r28 != null) goto L28;
        String r29 = r24;
    L29:
        String r210 = r26.toJson(new FeedbackResult(r27, r29, null, r21.getUiType(), String.valueOf(r10.getReplyFor()), false, 36, null));
        if ((r21.getUiType() & 32) == 0) goto L32;
    L69:
        String r211 = UUID.randomUUID().toString();
        long r212 = r10.getMessageId();
        long r30 = r10.getQuestionId();
        long r31 = r10.getMessageId();
        long r213 = r10.getActionId();
        long r214 = r10.getJobId();
        IMAppActionExt r32 = new IMAppActionExt();
        ConcurrentHashMap<String, String> r33 = r21.getExt();
        if (r33 == null) goto L74;
        BaseResultExt r34 = f11380a.b(r33);
        if (r34 == null) goto L74;
        String r35 = r34.getResultDetailExtras();
    L75:
        r32.setActionDetailExtras(r35);
        r32.put("app_cost", String.valueOf(r22));
        ConcurrentHashMap<String, String> r36 = r21.getExt();
        if (r36 == null) goto L79;
        r32.putAll(r36);
    L79:
        return new Pair(r21, new IMAppAction(0, tf.a.d(r31), r211, r212, tf.a.d(r30), null, r210, null, r213, r214, 0, r32, 1185, null));
    L74:
        r35 = null;
        goto L75
    L32:
        if ((r21.getUiType() & 64) != 0) goto L69;
        if ((r21.getUiType() & 128) != 0) goto L69;
        if ((r21.getUiType() & 512) != 0) goto L69;
        if ((r21.getUiType() & 1024) != 0) goto L69;
        if ((r21.getUiType() & 2048) != 0) goto L69;
        if ((r21.getUiType() & 4096) != 0) goto L69;
        if ((r21.getUiType() & 8192) != 0) goto L69;
        if ((r21.getUiType() & 16384) != 0) goto L69;
        if ((r21.getUiType() & UiType.FLAG_SETTINGS_CARD) != 0) goto L69;
        if ((r21.getUiType() & UiType.FLAG_WIFI_QRCODE_CARD) != 0) goto L69;
        if ((r21.getUiType() & 65536) != 0) goto L69;
        if ((r21.getUiType() & UiType.FLAG_PHONE_CARD) != 0) goto L69;
        if ((r21.getUiType() & UiType.FLAG_APP_CHOOSER_CARD) != 0) goto L69;
        if ((r21.getUiType() & UiType.FLAG_TIMER_CARD) != 0) goto L69;
        if ((r21.getUiType() & UiType.FLAG_REMOTE_CARD) != 0) goto L69;
        if ((r21.getUiType() & UiType.FLAG_APPLET_CARD) != 0) goto L69;
        String r215 = UUID.randomUUID().toString();
        long r216 = r10.getMessageId();
        long r40 = r10.getQuestionId();
        long r41 = r10.getMessageId();
        long r217 = r10.getActionId();
        long r218 = r10.getJobId();
        IMAppActionExt r42 = new IMAppActionExt();
        r42.put("app_cost", String.valueOf(r22));
        ConcurrentHashMap<String, String> r43 = r21.getExt();
        if (r43 == null) goto L68;
        r42.putAll(r43);
    L68:
        return new Pair(r21, new IMAppAction(0, tf.a.d(r41), r215, r216, tf.a.d(r40), null, r210, null, r217, r218, 0, r42, 1185, null));
    L28:
        r29 = r28;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r13);
        r19 = AppHost.Companion.getApplication();
        long r44 = System.currentTimeMillis();
        t r45 = t.f11407a;
        r11.f11382a = r10;
        r11.f11383b = r19;
        r11.f11384c = r44;
        r11.f11387f = 1;
        r20 = r45.c(r19, r10, r38, r11);
        if (r20 != r14) goto L17;
        return r14;
    L17:
        r16 = r44;
    L7:
        r11 = new a(this, r39);
        goto L8
    }
}
