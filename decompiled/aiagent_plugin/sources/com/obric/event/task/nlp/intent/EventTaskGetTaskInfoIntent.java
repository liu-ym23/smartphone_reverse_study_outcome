package com.obric.event.task.nlp.intent;

import android.os.Parcelable;
import com.google.gson.Gson;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.BaseEventTaskGetTaskInfoIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.EventTaskGetTaskInfoParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.EventTask;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.o.o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: EventTaskGetTaskInfoIntent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EventTaskGetTaskInfoIntent extends BaseEventTaskGetTaskInfoIntent {
    private final Gson gson;
    private final String tag;

    /* JADX INFO: compiled from: EventTaskGetTaskInfoIntent.kt */
    @f(b = "EventTaskGetTaskInfoIntent.kt", c = {52}, d = "buildShortcutTaskResult", e = "com.obric.event.task.nlp.intent.EventTaskGetTaskInfoIntent")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f33025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f33026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ EventTaskGetTaskInfoIntent f33027c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f33028d;

        a(EventTaskGetTaskInfoIntent r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f33027c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f33026b = r3;
            this.f33028d |= Integer.MIN_VALUE;
            return EventTaskGetTaskInfoIntent.access$buildShortcutTaskResult(this.f33027c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.capabilitykit.common.intent.BaseEventTaskGetTaskInfoIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public EventTaskGetTaskInfoIntent() {
        this.tag = "EventTaskGetTaskInfoIntent";
        this.gson = new Gson();
    }

    public static final /* synthetic */ Object access$buildShortcutTaskResult(EventTaskGetTaskInfoIntent r2, String r3, d.c.d r4) {
        return r2.buildShortcutTaskResult(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.capabilitykit.common.intent.BaseEventTaskGetTaskInfoIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((EventTaskGetTaskInfoParams) ZeusTransformUtils.preCheckCast(r6, EventTaskGetTaskInfoParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseEventTaskGetTaskInfoIntent
    public Object doAction(EventTaskGetTaskInfoParams r5, DispatchContext r6, d.c.d<? super IntentResult<Empty>> r7) {
        d.c.d<? super IntentResult<Empty>> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        String r9 = r5.getTaskId();
        if (r9 != null) goto L5;
    L7:
        r9 = null;
    L9:
        if (r9 == null) goto L11;
        Integer r10 = r5.getTaskType();
        if (r10 == null) goto L15;
        com.obric.event.task.nlp.a.a.f32889a.b(this.tag, "doAction task_id = " + r9 + ", task_type = " + r10);
        if (r10.intValue() != 3) goto L21;
        return buildShortcutTaskResult(r9, r8);
    L21:
        if (r10.intValue() != 2) goto L24;
        return buildGetInfoErrorResult(999, "condition task not implemented");
    L24:
        return buildGetInfoErrorResult(103, "unsupported task_type=" + r10);
    L15:
        return buildGetInfoErrorResult(ErrorCode.EventTask.PARAMS_EMPTY, "task_type is empty");
    L11:
        return buildGetInfoErrorResult(ErrorCode.EventTask.PARAMS_EMPTY, "task_id is empty");
    L5:
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L7;
        goto L7
    }

    private final Object buildShortcutTaskResult(String r6, d.c.d<? super IntentResult<Empty>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
        if ((r0.f33028d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f33028d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f33026b;
        Object r2 = b.a();
        int r3 = r0.f33028d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        EventTaskGetTaskInfoIntent this = (EventTaskGetTaskInfoIntent) ZeusTransformUtils.preCheckCast(r0.f33025a, EventTaskGetTaskInfoIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L19:
        EventTask r10 = (EventTask) ZeusTransformUtils.preCheckCast(r9, EventTask.class, "com.obric.aiagent.plugin");
    L22:
        if (r10 != null) goto L26;
        return this.buildGetInfoErrorResult(ErrorCode.EventTask.TARGET_DATA_NOT_FOUND, "task not found");
    L26:
        if (r10.getType() != 3) goto L28;
        Integer r1 = r10.getEnableStatus();
        if (r1 == null) goto L35;
        if (r1.intValue() != 0) goto L35;
        com.obric.eventkit.task.model.a r11 = com.obric.event.task.nlp.intent.a.f33039a.a(r10);
        r11.a(d.c.b.a.b.a(0));
        ConcurrentHashMap<String, String> r4 = new ConcurrentHashMap();
        ((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin")).put(com.obric.event.task.nlp.intent.a.f33039a.c(), this.gson.toJson(r11));
        com.obric.event.task.nlp.intent.a.f33039a.a("get_info", 0, "", "obric_get_task_info_from_query");
        IntentResult<Empty> r5 = com.obric.event.task.nlp.intent.a.f33039a.a("success");
        r5.setExt(r4);
        return r5;
    L35:
        return this.buildGetInfoErrorResult(ErrorCode.EventTask.TARGET_DATA_NOT_FOUND, "task disabled");
    L28:
        return this.buildGetInfoErrorResult(103, "task type mismatch");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        IEventTaskApi r12 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L20;
        r0.f33025a = this;
        r0.f33028d = 1;
        r9 = r12.getEventTask(r6, r0);
        if (r9 != r2) goto L19;
        return r2;
    L20:
        r10 = null;
    L7:
        r0 = new a(this, r8);
        goto L8
    }

    private final IntentResult<Empty> buildGetInfoErrorResult(int r3, String r4) {
        com.obric.event.task.nlp.a.a.f32889a.d(this.tag, r4);
        com.obric.event.task.nlp.intent.a.f33039a.a("get_info", r3, r4, "obric_get_task_info_from_query");
        return com.obric.event.task.nlp.intent.a.f33039a.a(r3, r4);
    }
}
