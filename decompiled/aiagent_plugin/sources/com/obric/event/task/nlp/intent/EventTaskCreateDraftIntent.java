package com.obric.event.task.nlp.intent;

import android.content.Context;
import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.BaseEventTaskCreateDraftIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.EventTaskCreateDraftParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: EventTaskCreateDraftIntent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EventTaskCreateDraftIntent extends BaseEventTaskCreateDraftIntent {
    private final String ID_PREFIX;
    private final String TAG;

    /* JADX INFO: compiled from: EventTaskCreateDraftIntent.kt */
    @f(b = "EventTaskCreateDraftIntent.kt", c = {40}, d = "doAction", e = "com.obric.event.task.nlp.intent.EventTaskCreateDraftIntent")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f33020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f33021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f33022c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ EventTaskCreateDraftIntent f33023d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f33024e;

        a(EventTaskCreateDraftIntent r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33023d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f33022c = r3;
            this.f33024e |= Integer.MIN_VALUE;
            return this.f33023d.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.capabilitykit.common.intent.BaseEventTaskCreateDraftIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public EventTaskCreateDraftIntent() {
        this.TAG = "ConditionalTaskCreateIntent";
        this.ID_PREFIX = "$CT_TEMP_";
    }

    @Override // com.obric.capabilitykit.common.intent.BaseEventTaskCreateDraftIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((EventTaskCreateDraftParams) ZeusTransformUtils.preCheckCast(r6, EventTaskCreateDraftParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseEventTaskCreateDraftIntent
    public Object doAction(EventTaskCreateDraftParams r12, DispatchContext r13, d.c.d<? super IntentResult<Empty>> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r15, a.class, "com.obric.aiagent.plugin");
        if ((r0.f33024e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f33024e -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f33022c;
        Object r2 = b.a();
        int r3 = r0.f33024e;
        boolean r6 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r0.f33021b, String.class, "com.obric.aiagent.plugin");
        EventTaskCreateDraftIntent r17 = (EventTaskCreateDraftIntent) ZeusTransformUtils.preCheckCast(r0.f33020a, EventTaskCreateDraftIntent.class, "com.obric.aiagent.plugin");
        o.a(r16);
        String r18 = r11;
        EventTaskCreateDraftIntent this = r17;
        Object r19 = r16;
    L27:
        com.obric.event.task.nlp.api.d r110 = (com.obric.event.task.nlp.api.d) ZeusTransformUtils.preCheckCast(r19, com.obric.event.task.nlp.api.d.class, "com.obric.aiagent.plugin");
        String r111 = (String) ZeusTransformUtils.preCheckCast(r110.a(), String.class, "com.obric.aiagent.plugin");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L30;
    L33:
        if (r6 == true) goto L36;
        com.obric.event.task.nlp.a.a.f32889a.b(this.TAG, "doAction response success");
        com.obric.event.task.nlp.intent.a.f33039a.a(r18, "draft", 0, "");
        ConcurrentHashMap<String, String> r112 = new ConcurrentHashMap();
        ((Map) ZeusTransformUtils.preCheckCast(r112, Map.class, "com.obric.aiagent.plugin")).put(com.obric.event.task.nlp.intent.a.f33039a.b(), r111);
        IntentResult<Empty> r113 = com.obric.event.task.nlp.intent.a.f33039a.a("success");
        r113.setExt(r112);
        return r113;
    L36:
        com.obric.event.task.nlp.a.a.f32889a.d(this.TAG, "doAction error, msg = " + r110.b());
        int r114 = r110.c();
        String r115 = r110.b();
        if (r115 != null) goto L39;
        r115 = "doAction error";
    L39:
        com.obric.event.task.nlp.intent.a.f33039a.a(r18, "draft", r114, r115);
        return com.obric.event.task.nlp.intent.a.f33039a.a(r114, r115);
    L30:
        if (r1.length() == 0) goto L33;
        r6 = false;
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r16);
        String r116 = r12.getTaskParams();
        r18 = String.valueOf(r13.getQuestionId());
        com.obric.event.task.nlp.a.a.f32889a.b(this.TAG, "doAction paramsStr = " + r116);
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r116, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == false) goto L24;
        com.obric.event.task.nlp.a.a.f32889a.d(this.TAG, "doAction params empty");
        com.obric.event.task.nlp.intent.a.f33039a.a(r18, "draft", ErrorCode.EventTask.PARAMS_EMPTY, "params is empty");
        return com.obric.event.task.nlp.intent.a.f33039a.a(ErrorCode.EventTask.PARAMS_EMPTY, "params is empty");
    L24:
        String r7 = this.ID_PREFIX + System.currentTimeMillis();
        com.obric.event.task.nlp.b.f r8 = com.obric.event.task.nlp.b.f.f32960a;
        Context r117 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        r0.f33020a = this;
        r0.f33021b = r18;
        r0.f33024e = 1;
        r19 = r8.a(r7, r116, r117, r0);
        if (r19 != r2) goto L27;
        return r2;
    L17:
        if (r4.length() == 0) goto L20;
        r5 = false;
    L7:
        r0 = new a(this, r15);
        goto L8
    }

    @Override // com.obric.capabilitykit.common.intent.BaseEventTaskCreateDraftIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean cancelTask(String r5) {
        d.h.b.o.e(r5, "reason");
        com.obric.event.task.nlp.a.a.f32889a.b(this.TAG, "cancelTask reason = " + r5);
        return super.cancelTask(r5);
    }
}
