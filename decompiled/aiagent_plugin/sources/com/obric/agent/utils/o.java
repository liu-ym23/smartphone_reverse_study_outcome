package com.obric.agent.utils;

import com.obric.agent.omnimodel.IOmniModelService;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autoaction.app.launcherpage.api.ITaskDataApi;
import com.obric.eventkit.ITaskManagerApi;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.LocationCondition;
import com.obric.eventkit.task.model.TimeCondition;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.Iterator;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventTaskUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o {
    private static final String TAG = "EventTaskUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f16054a = null;

    /* JADX INFO: compiled from: EventTaskUtil.kt */
    @d.c.b.a.f(b = "EventTaskUtil.kt", c = {215}, d = "invokeSuspend", e = "com.obric.agent.utils.EventTaskUtil$getConditionTaskInner$2")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ConditionTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16056b;

        a(String r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16056b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super ConditionTask> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f16056b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ConditionTask> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16055a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L16:
            return (ConditionTask) ZeusTransformUtils.preCheckCast(r6, ConditionTask.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            IEventTaskApi r7 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L14;
            String r2 = this.f16056b;
            d.c.d<? super ConditionTask> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16055a = 1;
            r6 = r7.getConditionTask(r2, r4);
            if (r6 != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    /* JADX INFO: compiled from: EventTaskUtil.kt */
    @d.c.b.a.f(b = "EventTaskUtil.kt", c = {185}, d = "invokeSuspend", e = "com.obric.agent.utils.EventTaskUtil$getTaskConditionType$1$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super ConditionTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16058b;

        b(String r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16058b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super ConditionTask> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f16058b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ConditionTask> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16057a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            o r7 = o.f16054a;
            String r2 = this.f16058b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16057a = 1;
            r6 = o.a(r7, r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    static {
        f16054a = new o();
    }

    private o() {
    }

    public static final /* synthetic */ Object a(o r2, String r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ Map a(o r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.a(r1, r2);
    }

    public final Map<String, String> a(String r2, String r3) {
        d.h.b.o.e(r2, "eventTaskJson");
        Map<String, String> r1 = ao.b(new d.m[]{d.s.a(com.obric.agent.intents.a.f14662a.a(), r2)});
        if (r3 == null) goto L5;
        r1.put("o_instruction_entry", r3);
    L5:
        f16054a.a(r1, r1);
        return r1;
    }

    public final void a(Map<String, String> r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "map");
        d.h.b.o.e(r7, "extras");
        JSONObject r0 = c(r6);
        Integer r1 = a(r0);
        if (r1 == null) goto L9;
        int r2 = r1.intValue();
        String r3 = b(r0);
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        b(r6, r7);
        a(r0, r7);
        a(r2, r3, r7);
        a(r2, r6, r7);
        b(r7);
        return;
    }

    private final void b(Map<String, String> r2, Map<String, String> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r1.get(com.obric.agent.intents.a.f14662a.a()), String.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L6;
        r4.put(com.obric.agent.intents.a.f14662a.a(), r5);
        return;
    }

    private final void a(JSONObject r2, Map<String, String> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        String r4 = r2.optString("omniModel");
        d.h.b.o.a(r4);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r4 = null;
    L6:
        IOmniModelService r5 = IOmniModelService.Companion.a();
        r1.put(IOmniModelService.MESSAGE_EXT_KEY, r5.toExtValue(r5.getEntryByDisplayModel(r4)));
    }

    private final void a(int r5, Map<String, String> r6, Map<String, String> r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r9.get("o_instruction_entry"), String.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        r2 = (String) ZeusTransformUtils.preCheckCast(r8.get("o_instruction_entry"), String.class, "com.obric.aiagent.plugin");
    L5:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L15;
        r9.put("o_instruction_entry", r2);
        return;
    L15:
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L23;
        if (r5 != 3) goto L29;
        r9.put("o_instruction_entry", "shortcut_click_trigger");
        return;
    L29:
        return;
    L23:
        if (d(r8) == false) goto L25;
        String r4 = "auto_test_run";
    L26:
        r9.put("o_instruction_entry", r4);
        return;
    L25:
        r4 = "auto_trigger";
        goto L26
    L8:
        if (r1.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    private final void b(Map<String, String> r2) {
        ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin")).put("o_is_omni_agent", "1");
    }

    public final void a(Map<String, String> r3) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "extras");
        ITaskManagerApi r4 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        String r5 = r4.getConditionTaskV2();
        if (r5 != null) goto L7;
        return;
    L7:
        if (d.h.b.o.a(r5, "true") == false) goto L12;
        r2.put("o_condition_task_v2", "1");
        return;
    L12:
        return;
    }

    private final Integer a(JSONObject r2) {
        int r1 = r2.optInt("taskType", -1);
        if (r1 != (-1)) goto L6;
        return null;
    L6:
        return Integer.valueOf(r1);
    }

    private final JSONObject c(Map<String, String> r3) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L8
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2.get("o_event_task"), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        if (r5 != null) goto L6;
        r5 = "{}";
    L6:
        Object r6 = d.n.f(new JSONObject(r5));     // Catch: Throwable -> L8
    L11:
        if (d.n.c(r6) == null) goto L15;
        r6 = new JSONObject();
    L15:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.aiagent.plugin");
    L8:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L11
    }

    private final boolean d(Map<String, String> r3) {
        return c((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin")).optBoolean("isTryRun");
    }

    private final String b(JSONObject r2) {
        return r2.optString(DBDefinition.TASK_ID, "");
    }

    private final String a(String r7) {
        boolean r1 = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r6 = true;
    L7:
        if (r6 == false) goto L36;
        return null;
    L36:
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L31
        ConditionTask r9 = (ConditionTask) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), ConditionTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (r9 == null) goto L30;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.getConditions().getConditions(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L31
        boolean r11 = false;
    L13:
        if (r10.hasNext() == false) goto L20;
        Condition r4 = (Condition) ZeusTransformUtils.preCheckCast(r10.next(), Condition.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (ZeusTransformUtils.instanceOf(r4, TimeCondition.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r4, LocationCondition.class) == false) goto L13;
        r11 = true;
        goto L13
    L16:
        r1 = true;
        goto L13
    L20:
        if (r1 == false) goto L24;
        if (r11 == false) goto L24;
        return "auto_position_time";
    L24:
        if (r1 == false) goto L27;
        return "auto_time";
    L27:
        if (r11 == false) goto L30;
        return "auto_position";
    L30:
        return null;
    L31:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        Throwable r13 = d.n.c(d.n.f(d.o.a(th)));
        if (r13 == null) goto L35;
        ILogDepend.Companion.e(TAG, "getTaskConditionType", r13);
    L35:
        return null;
    L5:
        r6 = false;
        goto L7
    }

    private final Object a(String r3, d.c.d<? super ConditionTask> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return dg.b(100, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r2);
    }

    private final void a(int r9, String r10, Map<String, String> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        ITaskDataApi r0 = (ITaskDataApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskDataApi.class), ITaskDataApi.class, "com.obric.aiagent.plugin");
        String r3 = null;
        boolean r4 = true;
        String r6 = "";
        if (r9 != 2) goto L5;
        if (r0 == null) goto L30;
        String r13 = r0.getInstructionType(r10);
        if (r13 == null) goto L30;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).length() == 0) goto L26;
        r4 = false;
    L26:
        if (r4 == true) goto L28;
        r3 = r13;
    L28:
        if (r3 == null) goto L30;
        r6 = r3;
    L34:
        r12.put("o_omni_instruction_type", r6);
        return;
    L30:
        String r8 = a(r10);
        if (r8 == null) goto L34;
        r6 = r8;
        goto L34
    L5:
        if (r9 != 3) goto L37;
        if (r0 == null) goto L18;
        String r14 = r0.getShortcutInstructionType(r10);
        if (r14 == null) goto L18;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() == 0) goto L14;
        r4 = false;
    L14:
        if (r4 == true) goto L16;
        r3 = r14;
    L16:
        if (r3 == null) goto L18;
        r6 = r3;
    L18:
        r12.put("o_omni_instruction_type", r6);
        return;
    }
}
