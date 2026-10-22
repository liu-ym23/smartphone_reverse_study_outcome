package com.obric.event.task.nlp.intent;

import android.content.Context;
import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.BaseEventTaskUpdateTaskIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.EventTaskUpdateTaskParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventTaskUpdateTaskIntent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EventTaskUpdateTaskIntent extends BaseEventTaskUpdateTaskIntent {
    private final String TAG;

    /* JADX INFO: compiled from: EventTaskUpdateTaskIntent.kt */
    @f(b = "EventTaskUpdateTaskIntent.kt", c = {56}, d = "doAction", e = "com.obric.event.task.nlp.intent.EventTaskUpdateTaskIntent")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f33034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f33035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f33036c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ EventTaskUpdateTaskIntent f33037d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f33038e;

        a(EventTaskUpdateTaskIntent r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33037d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f33036c = r3;
            this.f33038e |= Integer.MIN_VALUE;
            return this.f33037d.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.capabilitykit.common.intent.BaseEventTaskUpdateTaskIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public EventTaskUpdateTaskIntent() {
        this.TAG = "EventTaskUpdateTaskIntent";
    }

    @Override // com.obric.capabilitykit.common.intent.BaseEventTaskUpdateTaskIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((EventTaskUpdateTaskParams) ZeusTransformUtils.preCheckCast(r6, EventTaskUpdateTaskParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseEventTaskUpdateTaskIntent
    public Object doAction(EventTaskUpdateTaskParams r12, DispatchContext r13, d.c.d<? super IntentResult<Empty>> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r15, a.class, "com.obric.aiagent.plugin");
        if ((r0.f33038e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f33038e -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f33036c;
        Object r2 = b.a();
        int r3 = r0.f33038e;
        boolean r6 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r0.f33035b, String.class, "com.obric.aiagent.plugin");
        EventTaskUpdateTaskIntent r17 = (EventTaskUpdateTaskIntent) ZeusTransformUtils.preCheckCast(r0.f33034a, EventTaskUpdateTaskIntent.class, "com.obric.aiagent.plugin");
        o.a(r16);
        String r18 = r11;
        EventTaskUpdateTaskIntent this = r17;
        Object r19 = r16;
    L36:
        com.obric.event.task.nlp.api.d r110 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r19, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        String r111 = (String) ZeusTransformUtils.preCheckCast(r110.a(), String.class, "com.obric.aiagent.plugin");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L39;
    L42:
        if (r6 == true) goto L45;
        com.obric.event.task.nlp.a.a.f32889a.b(this.TAG, "doAction response success");
        com.obric.event.task.nlp.intent.a.f33039a.a(r18, "update", 0, "");
        ConcurrentHashMap<String, String> r112 = new ConcurrentHashMap();
        ((Map) ZeusTransformUtils.preCheckCast(r112, Map.class, "com.obric.aiagent.plugin")).put(com.obric.event.task.nlp.intent.a.f33039a.b(), r111);
        IntentResult<Empty> r113 = com.obric.event.task.nlp.intent.a.f33039a.a("success");
        r113.setExt(r112);
        return r113;
    L45:
        com.obric.event.task.nlp.a.a.f32889a.d(this.TAG, "doAction error, msg = " + r110.b());
        String r114 = r110.b();
        if (r114 != null) goto L48;
        r114 = "doAction error";
    L48:
        com.obric.event.task.nlp.intent.a.f33039a.a(r18, "update", r110.c(), r114);
        return com.obric.event.task.nlp.intent.a.f33039a.a(r110.c(), r114);
    L39:
        if (r1.length() == 0) goto L42;
        r6 = false;
        goto L42
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r16);
        String r115 = r12.getTaskParams();
        r18 = String.valueOf(r13.getQuestionId());
        com.obric.event.task.nlp.a.a.f32889a.b(this.TAG, "doAction paramsStr = " + r115);
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L17;
    L20:
        boolean r5 = true;
    L22:
        if (r5 == false) goto L53;
        com.obric.event.task.nlp.a.a.f32889a.d(this.TAG, "doAction params empty");
        com.obric.event.task.nlp.intent.a.f33039a.a(r18, "update", ErrorCode.EventTask.PARAMS_EMPTY, "params is empty");
        return com.obric.event.task.nlp.intent.a.f33039a.a(ErrorCode.EventTask.PARAMS_EMPTY, "params is empty");
    L53:
        String r7 = new JSONObject(r115).optString("target");     // Catch: Exception -> L50
        d.h.b.o.c(r7, "optString(...)");     // Catch: Exception -> L50
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L29;
        boolean r8 = true;
    L30:
        if (r8 == false) goto L33;
        com.obric.event.task.nlp.a.a.f32889a.d(this.TAG, "doAction target is empty");
        com.obric.event.task.nlp.intent.a.f33039a.a(r18, "update", ErrorCode.EventTask.TARGET_EMPTY, "target is empty");
        return com.obric.event.task.nlp.intent.a.f33039a.a(ErrorCode.EventTask.TARGET_EMPTY, "target is empty");
    L33:
        com.obric.event.task.nlp.b.f r9 = com.obric.event.task.nlp.b.f.f32960a;
        Context r116 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r0.f33034a = this;
        r0.f33035b = r18;
        r0.f33038e = 1;
        r19 = r9.b(r7, r115, r116, r0);
        if (r19 != r2) goto L36;
        return r2;
    L29:
        r8 = false;
    L50:
        e = move-exception;
        String r117 = "params parse error,  e = " + e.getMessage();
        com.obric.event.task.nlp.a.a.f32889a.b(this.TAG, "doAction exception, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        com.obric.event.task.nlp.intent.a.f33039a.a(r18, "update", ErrorCode.EventTask.PARAMS_EMPTY, r117);
        return com.obric.event.task.nlp.intent.a.f33039a.a(ErrorCode.EventTask.PARAMS_EMPTY, r117);
    L17:
        if (r4.length() == 0) goto L20;
        r5 = false;
    L7:
        r0 = new a(this, r15);
        goto L8
    }
}
