package com.obric.event.task.nlp.intent;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.BaseEventTaskSubmitTaskIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.EventTaskSubmitTaskParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventTaskSubmitTaskIntent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EventTaskSubmitTaskIntent extends BaseEventTaskSubmitTaskIntent {
    private final String TAG;

    /* JADX INFO: compiled from: EventTaskSubmitTaskIntent.kt */
    @f(b = "EventTaskSubmitTaskIntent.kt", c = {56}, d = "doAction", e = "com.obric.event.task.nlp.intent.EventTaskSubmitTaskIntent")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f33029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f33030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f33031c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f33032d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ EventTaskSubmitTaskIntent f33033e;
        int f;

        a(EventTaskSubmitTaskIntent r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33033e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f33032d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f33033e.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.capabilitykit.common.intent.BaseEventTaskSubmitTaskIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public EventTaskSubmitTaskIntent() {
        this.TAG = "EventTaskSubmitTaskIntent";
    }

    @Override // com.obric.capabilitykit.common.intent.BaseEventTaskSubmitTaskIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((EventTaskSubmitTaskParams) ZeusTransformUtils.preCheckCast(r6, EventTaskSubmitTaskParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseEventTaskSubmitTaskIntent
    public Object doAction(EventTaskSubmitTaskParams r12, DispatchContext r13, d.c.d<? super IntentResult<Empty>> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r15, a.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f33032d;
        Object r2 = b.a();
        int r3 = r0.f;
        boolean r6 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r0.f33031c, String.class, "com.obric.aiagent.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r0.f33030b, String.class, "com.obric.aiagent.plugin");
        EventTaskSubmitTaskIntent r18 = (EventTaskSubmitTaskIntent) ZeusTransformUtils.preCheckCast(r0.f33029a, EventTaskSubmitTaskIntent.class, "com.obric.aiagent.plugin");
        o.a(r16);
        String r19 = r11;
        EventTaskSubmitTaskIntent this = r18;
        Object r110 = r16;
        String r111 = r17;
    L36:
        com.obric.event.task.nlp.api.d r112 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r110, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r112.a(), String.class, "com.obric.aiagent.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L39;
    L42:
        if (r6 == true) goto L45;
        com.obric.event.task.nlp.a.a.f32889a.b(this.TAG, "doAction response success");
        ConcurrentHashMap<String, String> r113 = new ConcurrentHashMap();
        ((Map) ZeusTransformUtils.preCheckCast(r113, Map.class, "com.obric.aiagent.plugin")).put(com.obric.event.task.nlp.intent.a.f33039a.a(), r19);
        ((Map) ZeusTransformUtils.preCheckCast(r113, Map.class, "com.obric.aiagent.plugin")).put(com.obric.event.task.nlp.intent.a.f33039a.b(), r1);
        IntentResult<Empty> r114 = com.obric.event.task.nlp.intent.a.f33039a.a("success: " + r112.d());
        r114.setExt(r113);
        com.obric.event.task.nlp.intent.a.f33039a.a(r111, "submit", 0, "");
        return r114;
    L45:
        com.obric.event.task.nlp.a.a.f32889a.d(this.TAG, "doAction error, msg = " + r112.b());
        String r115 = r112.b();
        if (r115 != null) goto L48;
        r115 = "doAction error";
    L48:
        com.obric.event.task.nlp.intent.a.f33039a.a(r111, "submit", r112.c(), r115);
        return com.obric.event.task.nlp.intent.a.f33039a.a(r112.c(), r115);
    L39:
        if (r4.length() == 0) goto L42;
        r6 = false;
        goto L42
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r16);
        String r116 = r12.getTaskParams();
        r111 = String.valueOf(r13.getQuestionId());
        com.obric.event.task.nlp.a.a.f32889a.b(this.TAG, "doAction paramsStr = " + r116);
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r116, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L17;
    L20:
        boolean r7 = true;
    L22:
        if (r7 == false) goto L53;
        com.obric.event.task.nlp.a.a.f32889a.d(this.TAG, "doAction params empty");
        com.obric.event.task.nlp.intent.a.f33039a.a(r111, "submit", ErrorCode.EventTask.PARAMS_EMPTY, "params is empty");
        return com.obric.event.task.nlp.intent.a.f33039a.a(ErrorCode.EventTask.PARAMS_EMPTY, "params is empty");
    L53:
        r19 = new JSONObject(r116).optString("target");     // Catch: Exception -> L50
        d.h.b.o.c(r19, "optString(...)");     // Catch: Exception -> L50
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L29;
        boolean r8 = true;
    L30:
        if (r8 == false) goto L33;
        com.obric.event.task.nlp.a.a.f32889a.d(this.TAG, "doAction target is empty");
        com.obric.event.task.nlp.intent.a.f33039a.a(r111, "submit", ErrorCode.EventTask.TARGET_EMPTY, "target params is empty");
        return com.obric.event.task.nlp.intent.a.f33039a.a(ErrorCode.EventTask.TARGET_EMPTY, "target params is empty");
    L33:
        com.obric.event.task.nlp.b.f r9 = com.obric.event.task.nlp.b.f.f32960a;
        String r117 = String.valueOf(r13.getQuestionId());
        r0.f33029a = this;
        r0.f33030b = r111;
        r0.f33031c = r19;
        r0.f = 1;
        r110 = r9.a(r19, r117, r0);
        if (r110 != r2) goto L36;
        return r2;
    L29:
        r8 = false;
    L50:
        e = move-exception;
        String r118 = "params parse error,  e = " + e.getMessage();
        com.obric.event.task.nlp.a.a.f32889a.b(this.TAG, "doAction exception, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        com.obric.event.task.nlp.intent.a.f33039a.a(r111, "submit", ErrorCode.EventTask.PARAMS_EMPTY, r118);
        return com.obric.event.task.nlp.intent.a.f33039a.a(ErrorCode.EventTask.PARAMS_EMPTY, r118);
    L17:
        if (r5.length() == 0) goto L20;
        r7 = false;
    L7:
        r0 = new a(this, r15);
        goto L8
    }
}
