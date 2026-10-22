package com.obric.agent.intents.skill.e;

import com.bytedance.keva.KevaImpl;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.agent.intents.skill.c.j;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.e;
import com.obric.aiagent.skill.ovirt.api.g;
import com.obric.aiagent.skill.ovirt.api.h;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.k;
import d.n;
import d.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SkillIntentEventReporter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "SkillIntentEventReporter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15181a = null;

    /* JADX INFO: renamed from: com.obric.agent.intents.skill.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SkillIntentEventReporter.kt */
    @f(b = "SkillIntentEventReporter.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.intents.skill.tracking.SkillIntentEventReporter$report$1$1")
    static final class C0309a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<JSONObject> f15184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f15185d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f15186e;

        C0309a(String r3, d.h.a.a<? extends JSONObject> r4, a r5, d<? super C0309a> r6) {
            d.h.a.a<JSONObject> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.f15183b = r3;
            this.f15184c = r7;
            this.f15185d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((C0309a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0309a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r5, d<?> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            C0309a r0 = new C0309a(this.f15183b, this.f15184c, this.f15185d, r7);
            r0.f15186e = r5;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            b.a();
            if (this.f15182a != 0) goto L19;
            o.a(r5);
            am r6 = (am) ZeusTransformUtils.preCheckCast(this.f15186e, am.class, "com.obric.aiagent.plugin");
            String r7 = this.f15183b;
            d.h.a.a<JSONObject> r0 = this.f15184c;
            n.a r2 = n.f38560a;     // Catch: Throwable -> L11
            IAppLog r3 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            if (r3 == null) goto L8;
            r3.reportToFlow(r7, (JSONObject) ZeusTransformUtils.preCheckCast(r0.invoke(), JSONObject.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
            x r8 = x.f38692a;     // Catch: Throwable -> L11
        L9:
            Object r9 = n.f(r8);     // Catch: Throwable -> L11
        L13:
            a r1 = this.f15185d;
            String r4 = this.f15183b;
            Throwable r10 = n.c(r9);
            if (r10 == null) goto L17;
            a.a(r1, "report failed event=" + r4, r10);
        L17:
            return x.f38692a;
        L8:
            r8 = null;
        L11:
            th = move-exception;
            n.a r11 = n.f38560a;
            r9 = n.f(o.a(th));
            goto L13
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f15181a = new a();
    }

    public static /* synthetic */ JSONObject lambda$2zJVqzyQv_C3eTdeRum8pxrBP60(String r0, String r1, long r2, int r4, List r5, int r6, int r7, List r8) {
        return a(r0, r1, r2, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: lambda$6IKkriJXPCgmFS-vQo8KntniUzQ, reason: not valid java name */
    public static /* synthetic */ JSONObject m87lambda$6IKkriJXPCgmFSvQo8KntniUzQ(String r0, j.e r1, long r2, int r4) {
        return a(r0, r1, r2, r4);
    }

    public static /* synthetic */ JSONObject lambda$861BlHpp19NIO0finerdiwag0wA(String r0, String r1, long r2, int r4, List r5, int r6, int r7, List r8) {
        return b(r0, r1, r2, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: lambda$J0QBxIW9yS_Bvj7YgLm-ug2bbEY, reason: not valid java name */
    public static /* synthetic */ JSONObject m88lambda$J0QBxIW9yS_Bvj7YgLmug2bbEY(String r0, boolean r1, long r2, boolean r4, String r5, String r6, Integer r7, Boolean r8, String r9) {
        return a(r0, r1, r2, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ JSONObject lambda$MCUkLkX1FVjWtnLyI9nM9hsHqq0(h r0, String r1, String r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$Vri-cRMv-lAyBlZN-dN8TMVYfi0, reason: not valid java name */
    public static /* synthetic */ JSONObject m89lambda$VricRMvlAyBlZNdN8TMVYfi0(String r0, String r1, Integer r2, String r3, String r4, com.obric.aiagent.skill.virt.api.m r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ JSONObject lambda$aDwe9WfGwcF9md4rWu_tBUWjOBQ(String r0, boolean r1, long r2, String r4, boolean r5, String r6, String r7, Integer r8, Integer r9, String r10, String r11) {
        return a(r0, r1, r2, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ JSONObject lambda$jX307NLRijP0YvP84sIurRep7uw(String r0, long r1, int r3) {
        return a(r0, r1, r3);
    }

    public static /* synthetic */ JSONObject lambda$jzBAHP5W8J7EU31KPZ8J17pl2zg(List r0, int r1, List r2, String r3, long r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ JSONObject lambda$nmKNgMCgVWT2SIozF3JojlrDngI(String r0, boolean r1, long r2, String r4, boolean r5, String r6, String r7, Integer r8, String r9, String r10) {
        return a(r0, r1, r2, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ JSONObject lambda$pcglqDnnVwxbS_YOGgyfPmsZYfc(String r0, boolean r1, long r2, List r4) {
        return a(r0, r1, r2, r4);
    }

    public static /* synthetic */ JSONObject lambda$puZ7CkiOVJ69JQmJNRVB6XjQtDI(String r0, String r1, long r2, int r4, j.b r5) {
        return a(r0, r1, r2, r4, r5);
    }

    public static /* synthetic */ JSONObject lambda$wGPWHiHIlafSUDhNv6KKCri2nyc(String r0, String r1, long r2, int r4, List r5, int r6, int r7, int r8) {
        return a(r0, r1, r2, r4, r5, r6, r7, r8);
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0, String r1, Throwable r2) {
        r0.a(r1, r2);
    }

    public final void a(final String r2, final String r3, final h r4) {
        d.h.b.o.e(r3, "actionType");
        d.h.b.o.e(r4, "result");
        a("obric_omni_skill_performance", new $$Lambda$a$MCUkLkX1FVjWtnLyI9nM9hsHqq0(r4, r2, r3));
    }

    private static final JSONObject a(h r8, String r9, String r10) {
        if (ZeusTransformUtils.instanceOf(r8, h.a.class) == false) goto L5;
        h.a r0 = (h.a) ZeusTransformUtils.preCheckCast(r8, h.a.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r8, h.b.class) == false) goto L10;
        g r3 = ((h.b) ZeusTransformUtils.preCheckCast(r8, h.b.class, "com.obric.aiagent.plugin")).b();
    L12:
        JSONObject r4 = new JSONObject();
        r4.put("schema_version", 2);
        r4.put("operation", "ovirt_activation");
        if (r0 != null) goto L15;
        String r5 = "success";
    L16:
        r4.put("result", r5);
        r4.put("duration_ms", r3.a());
        r4.put("trace_id", UUID.randomUUID().toString());
        boolean r6 = true;
        r4.put("attempt_index", 1);
        if (r9 != null) goto L19;
    L24:
        r4.put("action_type", r10);
        r4.put("stale_ovirt_cleanup_duration_ms", r3.b());
        r4.put("ovirt_open_duration_ms", r3.c());
        r4.put("skill_projection_duration_ms", r3.d());
        if (ZeusTransformUtils.instanceOf(r8, h.b.class) == true) goto L27;
    L29:
        r6 = false;
    L30:
        r4.put("ovirt_reused", r6);
        if (r0 == null) goto L33;
        r4.put("error_code", "ovirt_failed");
        r4.put("failure_stage", "ovirt_open");
        r4.put("failure_reason", r0.a().a());
    L33:
        return r4;
    L27:
        if (((h.b) ZeusTransformUtils.preCheckCast(r8, h.b.class, "com.obric.aiagent.plugin")).a() == false) goto L29;
    L19:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L22;
        r9 = null;
    L22:
        if (r9 == null) goto L24;
        r4.put(KnowledgeActivity.KEY_TASK_ID, r9);
        goto L24
    L15:
        r5 = "fail";
        goto L16
    L10:
        if (ZeusTransformUtils.instanceOf(r8, h.a.class) == false) goto L35;
        r3 = ((h.a) ZeusTransformUtils.preCheckCast(r8, h.a.class, "com.obric.aiagent.plugin")).c();
        goto L12
    L35:
        throw new k();
    L5:
        r0 = null;
        goto L7
    }

    public final void a(final String r7, final long r8, final boolean r10, List<e> r11) {
        final List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "skills");
        a("obric_omni_skill_list_result", new $$Lambda$a$pcglqDnnVwxbS_YOGgyfPmsZYfc(r7, r10, r8, r5));
    }

    private static final JSONObject a(String r8, boolean r9, long r10, List r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        a r2 = f15181a;
        if (r9 == false) goto L5;
        String r0 = "success";
    L6:
        String r4 = r0;
        if (r9 == false) goto L9;
        Integer r11 = null;
    L10:
        JSONObject r14 = r2.a(r8, r4, r10, r11);
        r14.put("skill_count", r13.size());
        JSONArray r15 = new JSONArray();
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r16.hasNext() == false) goto L17;
        e r17 = (e) ZeusTransformUtils.preCheckCast(r16.next(), e.class, "com.obric.aiagent.plugin");
        JSONObject r18 = new JSONObject();
        r18.put("skill_id", r17.a());
        r18.put("skill_name", r17.b());
        String r1 = r17.i().a();
        if (r1 != null) goto L16;
        r1 = "";
    L16:
        r18.put(KnowledgeActivity.KEY_TASK_ID, r1);
        r18.put("version", r17.j());
        r15.put(r18);
        goto L12
    L17:
        x r19 = x.f38692a;
        r14.put("skill_infos", r15.toString());
        return r14;
    L9:
        r11 = -2002;
        goto L10
    L5:
        r0 = "failure";
        goto L6
    }

    public final void a(final String r10, final long r11, final int r13, List<com.obric.agent.intents.skill.d.f.d> r14, List<com.obric.agent.intents.skill.d.f.a> r15) {
        final List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        final List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "requestedSkills");
        d.h.b.o.e(r3, "results");
        a("obric_omni_skill_load_result", new $$Lambda$a$jzBAHP5W8J7EU31KPZ8J17pl2zg(r3, r13, r5, r10, r11));
    }

    private static final JSONObject a(List r10, int r11, List r12, String r13, long r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
        int r2 = 0;
    L9:
        if (r1.hasNext() == false) goto L15;
        if (((com.obric.agent.intents.skill.d.f.a) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.agent.intents.skill.d.f.a.class, "com.obric.aiagent.plugin")).b() == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        p.d();
    L15:
        if (r11 != 0) goto L17;
        int r3 = r15.size();
    L18:
        int r4 = r3 - r2;
        a r5 = f15181a;
        String r6 = r5.a(r2, 0, r4, r11);
        Integer r7 = Integer.valueOf(r11);
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L25;
        r7 = null;
    L25:
        JSONObject r17 = r5.a(r13, r6, r14, r7);
        r17.put("skill_count", r16.size());
        r17.put("success_count", r2);
        r17.put("failure_count", r4);
        JSONArray r18 = new JSONArray();
        if (r15.isEmpty() == false) goto L35;
        if (r11 == 0) goto L35;
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L30:
        if (r19.hasNext() == false) goto L54;
        com.obric.agent.intents.skill.d.f.d r110 = (com.obric.agent.intents.skill.d.f.d) ZeusTransformUtils.preCheckCast(r19.next(), com.obric.agent.intents.skill.d.f.d.class, "com.obric.aiagent.plugin");
        JSONObject r111 = new JSONObject();
        String r112 = r110.a();
        if (r112 != null) goto L34;
        r112 = "";
    L34:
        r111.put("skill_id", r112);
        r111.put("is_success", false);
        r111.put("error_code", r11);
        r18.put(r111);
    L54:
        x r113 = x.f38692a;
        r17.put("skill_results", r18.toString());
        return r17;
    L35:
        Iterator r114 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L37:
        if (r114.hasNext() == false) goto L54;
        com.obric.agent.intents.skill.d.f.a r115 = (com.obric.agent.intents.skill.d.f.a) ZeusTransformUtils.preCheckCast(r114.next(), com.obric.agent.intents.skill.d.f.a.class, "com.obric.aiagent.plugin");
        JSONObject r116 = new JSONObject();
        r116.put("skill_id", r115.a());
        String r117 = r115.c();
        if (r117 == null) goto L41;
        r116.put("skill_name", r117);
    L41:
        r116.put("is_success", r115.b());
        Integer r118 = r115.h();
        if (r118 == null) goto L44;
        r116.put("error_code", ((Number) ZeusTransformUtils.preCheckCast(r118, Number.class, "com.obric.aiagent.plugin")).intValue());
    L44:
        Boolean r119 = r115.g();
        if (r119 == null) goto L47;
        r116.put("truncated", r119.booleanValue());
    L47:
        String r120 = r115.j();
        if (r120 == null) goto L50;
        r116.put("install_type", r120);
    L50:
        Integer r121 = r115.k();
        if (r121 == null) goto L53;
        r116.put("version", ((Number) ZeusTransformUtils.preCheckCast(r121, Number.class, "com.obric.aiagent.plugin")).intValue());
    L53:
        r18.put(r116);
        goto L37
    L21:
        r8 = false;
        goto L22
    L17:
        r3 = r16.size();
        goto L18
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        r2 = 0;
        goto L15
    }

    public final void a(final String r15, final long r16, final String r18, final String r19, final Integer r20, final Integer r21, final boolean r22, final boolean r23, final String r24, final String r25, final String r26) {
        d.h.b.o.e(r18, "mode");
        d.h.b.o.e(r24, "resultStage");
        a("obric_omni_skill_apply_change_result", new $$Lambda$a$aDwe9WfGwcF9md4rWu_tBUWjOBQ(r15, r22, r16, r18, r23, r24, r19, r20, r21, r25, r26));
    }

    private static final JSONObject a(String r11, boolean r12, long r13, String r15, boolean r16, String r17, String r18, Integer r19, Integer r20, String r21, String r22) {
        a r5 = f15181a;
        if (r12 == false) goto L5;
        String r6 = "success";
    L6:
        JSONObject r7 = r5.a(r11, r6, r13, null);
        r7.put("mode", r15);
        r7.put("applied", r16);
        r7.put("result_stage", r17);
        if (r18 == null) goto L10;
        r7.put("change_type", r18);
    L10:
        if (r19 == null) goto L12;
        r7.put("previous_version", ((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.aiagent.plugin")).intValue());
    L12:
        if (r20 == null) goto L14;
        r7.put("version", ((Number) ZeusTransformUtils.preCheckCast(r20, Number.class, "com.obric.aiagent.plugin")).intValue());
    L14:
        if (r21 == null) goto L16;
        r7.put("security_status", r21);
    L16:
        if (r22 == null) goto L18;
        r7.put("business_error_code", r22);
    L18:
        return r7;
    L5:
        r6 = "failure";
        goto L6
    }

    public final void a(final String r14, final long r15, final String r17, final String r18, final Integer r19, final boolean r20, final boolean r21, final String r22, final String r23, final String r24) {
        d.h.b.o.e(r17, "inputType");
        d.h.b.o.e(r22, "resultStage");
        a("obric_omni_skill_install_package_result", new $$Lambda$a$nmKNgMCgVWT2SIozF3JojlrDngI(r14, r20, r15, r17, r21, r22, r18, r19, r23, r24));
    }

    private static final JSONObject a(String r10, boolean r11, long r12, String r14, boolean r15, String r16, String r17, Integer r18, String r19, String r20) {
        a r4 = f15181a;
        if (r11 == false) goto L5;
        String r5 = "success";
    L6:
        JSONObject r6 = r4.a(r10, r5, r12, null);
        r6.put("input_type", r14);
        r6.put("installed", r15);
        r6.put("result_stage", r16);
        if (r17 == null) goto L9;
        r6.put("change_type", r17);
    L9:
        if (r18 == null) goto L11;
        r6.put("version", ((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.aiagent.plugin")).intValue());
    L11:
        if (r19 == null) goto L13;
        r6.put("security_status", r19);
    L13:
        if (r20 == null) goto L15;
        r6.put("business_error_code", r20);
    L15:
        return r6;
    L5:
        r5 = "failure";
        goto L6
    }

    public final void a(final String r13, final long r14, final String r16, final Integer r17, final Boolean r18, final boolean r19, final boolean r20, final String r21, final String r22) {
        d.h.b.o.e(r21, "resultStage");
        a("obric_omni_skill_install_store_result", new $$Lambda$a$J0QBxIW9yS_Bvj7YgLmug2bbEY(r13, r19, r14, r20, r21, r16, r17, r18, r22));
    }

    private static final JSONObject a(String r6, boolean r7, long r8, boolean r10, String r11, String r12, Integer r13, Boolean r14, String r15) {
        a r0 = f15181a;
        if (r7 == false) goto L5;
        String r9 = "success";
    L6:
        JSONObject r16 = r0.a(r6, r9, r8, null);
        r16.put("installed", r10);
        r16.put("result_stage", r11);
        if (r12 == null) goto L9;
        r16.put("change_type", r12);
    L9:
        if (r13 == null) goto L11;
        r16.put("version", ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).intValue());
    L11:
        if (r14 == null) goto L13;
        r16.put("enabled", r14.booleanValue());
    L13:
        if (r15 == null) goto L15;
        r16.put("business_error_code", r15);
    L15:
        return r16;
    L5:
        r9 = "failure";
        goto L6
    }

    public final void a(final String r8, final long r9, final int r11, final j.e r12) {
        d.h.b.o.e(r12, "execution");
        a("obric_omni_shell_bash_result", new $$Lambda$a$6IKkriJXPCgmFSvQo8KntniUzQ(r8, r12, r9, r11));
    }

    private static final JSONObject a(String r7, j.e r8, long r9, int r11) {
        a r6 = f15181a;
        String r2 = r6.a(r8);
        Integer r12 = Integer.valueOf(r11);
        if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r12 = null;
    L9:
        JSONObject r10 = r6.a(r7, r2, r9, r12);
        r6.a(r10, r8);
        return r10;
    L5:
        r0 = false;
        goto L6
    }

    public final void a(final String r21, final long r22, final int r24, List<j.e> r25) {
        final List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r15, "executions");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
        int r2 = 0;
    L9:
        if (r1.hasNext() == false) goto L15;
        if (d.h.b.o.a(((j.e) ZeusTransformUtils.preCheckCast(r1.next(), j.e.class, "com.obric.aiagent.plugin")).a(), "SUCCESS") == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        p.d();
        goto L9
    L15:
        int r13 = r2;
    L16:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L19;
    L21:
        Iterator r5 = r4.iterator();
        int r6 = 0;
    L23:
        if (r5.hasNext() == false) goto L29;
        if (d.h.b.o.a(((j.e) ZeusTransformUtils.preCheckCast(r5.next(), j.e.class, "com.obric.aiagent.plugin")).a(), "PENDING") == false) goto L23;
        r6 = r6 + 1;
        if (r6 >= 0) goto L23;
        p.d();
        goto L23
    L29:
        int r14 = r6;
    L30:
        final int r12 = (r15.size() - r13) - r14;
        final String r16 = a(r13, r14, r12, r24);
        Integer r7 = Integer.valueOf(r24);
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L33;
        r3 = true;
    L33:
        if (r3 == false) goto L36;
        r7 = null;
    L36:
        a(this, r21, "inspect", r16, r7, null, null, 48, null);
        final int r8 = r13;
        final int r9 = r14;
        a("obric_omni_shell_inspect_result", new $$Lambda$a$wGPWHiHIlafSUDhNv6KKCri2nyc(r21, r16, r22, r24, r15, r8, r9, r12));
        return;
    L19:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L21;
        r14 = 0;
        goto L30
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        r13 = 0;
        goto L16
    }

    private static final JSONObject a(String r8, String r9, long r10, int r12, List r13, int r14, int r15, int r16) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        a r2 = f15181a;
        Integer r3 = Integer.valueOf(r12);
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        r3 = null;
    L9:
        JSONObject r5 = r2.a(r8, r9, r10, r3);
        r5.put("execution_count", r0.size());
        r5.put("success_count", r14);
        r5.put("pending_count", r15);
        r5.put("failure_count", r16);
        JSONArray r6 = new JSONArray();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r1.hasNext() == false) goto L13;
        j.e r7 = (j.e) ZeusTransformUtils.preCheckCast(r1.next(), j.e.class, "com.obric.aiagent.plugin");
        JSONObject r11 = new JSONObject();
        a r17 = f15181a;
        r17.a(r11, r7);
        r11.put("result", r17.a(r7));
        r6.put(r11);
        goto L11
    L13:
        x r18 = x.f38692a;
        r5.put("execution_results", r6.toString());
        return r5;
    L5:
        r4 = false;
        goto L6
    }

    public final void a(final String r11, final long r12, final int r14, final j.b r15) {
        d.h.b.o.e(r15, "result");
        if (d.h.b.o.a(r15.a(), "SUCCESS") == false) goto L6;
        if (r14 != 0) goto L6;
        String r0 = "success";
    L7:
        Integer r1 = Integer.valueOf(r14);
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        r1 = null;
    L14:
        String r4 = r0;
        a(this, r11, "kill", r4, r1, null, null, 48, null);
        final String r3 = r0;
        a("obric_omni_shell_kill_result", new $$Lambda$a$puZ7CkiOVJ69JQmJNRVB6XjQtDI(r11, r3, r12, r14, r15));
        return;
    L10:
        r2 = false;
    L6:
        r0 = "failure";
        goto L7
    }

    private static final JSONObject a(String r6, String r7, long r8, int r10, j.b r11) {
        a r0 = f15181a;
        Integer r12 = Integer.valueOf(r10);
        if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        r12 = null;
    L9:
        JSONObject r9 = r0.a(r6, r7, r8, r12);
        r9.put("execution_id", r11.b());
        return r9;
    L5:
        r1 = false;
        goto L6
    }

    public final void a(final String r12, String r13, final long r14, final int r16, com.obric.aiagent.skill.virt.api.m r17) {
        d.h.b.o.e(r13, "actionType");
        d.h.b.o.e(r17, "commandSummary");
        String r10 = a(r13);
        if (r10 != null) goto L5;
        return;
    L5:
        a(this, r12, r13, "failure", Integer.valueOf(r16), null, r17, 16, null);
        a(r10, new $$Lambda$a$jX307NLRijP0YvP84sIurRep7uw(r12, r14, r16));
    }

    private static final JSONObject a(String r6, long r7, int r9) {
        return f15181a.a(r6, "failure", r7, Integer.valueOf(r9));
    }

    public final void b(final String r21, final long r22, final int r24, List<com.obric.agent.intents.skill.c.e.a> r25, List<com.obric.agent.intents.skill.c.f.d> r26) {
        final List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        final List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "requests");
        d.h.b.o.e(r14, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
        int r2 = 0;
    L9:
        if (r1.hasNext() == false) goto L15;
        if (((com.obric.agent.intents.skill.c.f.d) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.agent.intents.skill.c.f.d.class, "com.obric.aiagent.plugin")).a() == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        p.d();
        goto L9
    L15:
        int r12 = r2;
    L16:
        if (r24 != 0) goto L18;
        int r4 = r14.size();
    L19:
        final int r5 = r4 - r12;
        final String r16 = a(r12, 0, r5, r24);
        Integer r6 = Integer.valueOf(r24);
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L22;
        r3 = true;
    L22:
        if (r3 == false) goto L25;
        r6 = null;
    L25:
        a(this, r21, "export_files", r16, r6, null, null, 48, null);
        final int r7 = r12;
        a("obric_omni_shell_export_files_result", new $$Lambda$a$2zJVqzyQv_C3eTdeRum8pxrBP60(r21, r16, r22, r24, r13, r7, r5, r14));
        return;
    L18:
        r4 = r13.size();
        goto L19
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        r12 = 0;
        goto L16
    }

    private static final JSONObject a(String r15, String r16, long r17, int r19, List r20, int r21, int r22, List r23) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        a r3 = f15181a;
        Integer r4 = Integer.valueOf(r19);
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L5;
        boolean r5 = true;
    L7:
        if (r5 == true) goto L9;
        Integer r8 = r4;
    L10:
        JSONObject r6 = r3.a(r15, r16, r17, r8);
        r6.put("file_count", r0.size());
        r6.put("success_count", r21);
        r6.put("failure_count", r22);
        JSONArray r7 = new JSONArray();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r9 = 0;
    L12:
        if (r1.hasNext() == false) goto L62;
        Object r10 = r1.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L16;
        p.c();
    L16:
        com.obric.agent.intents.skill.c.e.a r12 = (com.obric.agent.intents.skill.c.e.a) ZeusTransformUtils.preCheckCast(r10, com.obric.agent.intents.skill.c.e.a.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.c.f.d r13 = (com.obric.agent.intents.skill.c.f.d) ZeusTransformUtils.preCheckCast(p.d(r2, r9), com.obric.agent.intents.skill.c.f.d.class, "com.obric.aiagent.plugin");
        JSONObject r14 = new JSONObject();
        if (r13 == null) goto L20;
        String r18 = r13.b();
        if (r18 == null) goto L20;
    L31:
        if (r18 == null) goto L33;
        r14.put("file_name", r18);
    L33:
        if (r13 == null) goto L36;
        String r110 = r13.c();
        if (r110 == null) goto L36;
    L37:
        if (r110 == null) goto L39;
        r14.put("source_path", r110);
    L39:
        if (r13 == null) goto L43;
        String r24 = r13.d();
        if (r24 == null) goto L43;
        r14.put("exported_path", r24);
    L43:
        if (r13 != null) goto L45;
    L47:
        boolean r25 = false;
    L48:
        r14.put("is_success", r25);
        if (r13 == null) goto L52;
        Integer r26 = r13.e();
        if (r26 == null) goto L52;
    L59:
        if (r26 == null) goto L61;
        r14.put("error_code", ((Number) ZeusTransformUtils.preCheckCast(r26, Number.class, "com.obric.aiagent.plugin")).intValue());
    L61:
        r7.put(r14);
        r9 = r11;
    L52:
        r26 = Integer.valueOf(r19);
        if (((Number) ZeusTransformUtils.preCheckCast(r26, Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L55;
        boolean r27 = true;
    L56:
        if (r27 == false) goto L59;
        r26 = null;
        goto L59
    L55:
        r27 = false;
        goto L56
    L45:
        if (r13.a() != true) goto L47;
        r25 = true;
    L36:
        r110 = r12.a();
    L20:
        r18 = r12.b();
        if (r18 != null) goto L23;
    L25:
        r18 = null;
    L26:
        if (r18 != null) goto L31;
        String r111 = r12.a();
        if (r111 == null) goto L30;
        r18 = d.o.o.c(r111, '/', null, 2, null);
        goto L31
    L30:
        r18 = null;
        goto L31
    L23:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L25;
    L62:
        x r28 = x.f38692a;
        r6.put("file_results", r7.toString());
        return r6;
    L9:
        r8 = null;
        goto L10
    L5:
        r5 = false;
        goto L7
    }

    public final void c(final String r21, final long r22, final int r24, List<com.obric.agent.intents.skill.c.g.a> r25, List<com.obric.agent.intents.skill.c.g.b> r26) {
        final List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        final List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "requests");
        d.h.b.o.e(r14, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
        int r2 = 0;
    L9:
        if (r1.hasNext() == false) goto L15;
        if (((com.obric.agent.intents.skill.c.g.b) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.agent.intents.skill.c.g.b.class, "com.obric.aiagent.plugin")).a() == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        p.d();
        goto L9
    L15:
        int r12 = r2;
    L16:
        if (r24 != 0) goto L18;
        int r4 = r14.size();
    L19:
        final int r5 = r4 - r12;
        final String r16 = a(r12, 0, r5, r24);
        Integer r6 = Integer.valueOf(r24);
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L22;
        r3 = true;
    L22:
        if (r3 == false) goto L25;
        r6 = null;
    L25:
        a(this, r21, "import_files", r16, r6, null, null, 48, null);
        final int r7 = r12;
        a("obric_omni_shell_import_files_result", new $$Lambda$a$861BlHpp19NIO0finerdiwag0wA(r21, r16, r22, r24, r13, r7, r5, r14));
        return;
    L18:
        r4 = r13.size();
        goto L19
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        r12 = 0;
        goto L16
    }

    private static final JSONObject b(String r15, String r16, long r17, int r19, List r20, int r21, int r22, List r23) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        a r3 = f15181a;
        Integer r4 = Integer.valueOf(r19);
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L5;
        boolean r5 = true;
    L7:
        if (r5 == true) goto L9;
        Integer r8 = r4;
    L10:
        JSONObject r6 = r3.a(r15, r16, r17, r8);
        r6.put("file_count", r0.size());
        r6.put("success_count", r21);
        r6.put("failure_count", r22);
        JSONArray r7 = new JSONArray();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r9 = 0;
    L12:
        if (r1.hasNext() == false) goto L74;
        Object r10 = r1.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L16;
        p.c();
    L16:
        com.obric.agent.intents.skill.c.g.a r12 = (com.obric.agent.intents.skill.c.g.a) ZeusTransformUtils.preCheckCast(r10, com.obric.agent.intents.skill.c.g.a.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.c.g.b r13 = (com.obric.agent.intents.skill.c.g.b) ZeusTransformUtils.preCheckCast(p.d(r2, r9), com.obric.agent.intents.skill.c.g.b.class, "com.obric.aiagent.plugin");
        JSONObject r14 = new JSONObject();
        String r18 = r12.getType();
        if (r18 != null) goto L19;
    L24:
        if (r13 == null) goto L27;
        String r110 = r13.b();
        if (r110 == null) goto L27;
    L31:
        if (r110 != null) goto L33;
    L38:
        String r24 = r12.b();
        if (r24 != null) goto L41;
    L46:
        if (r13 == null) goto L55;
        String r25 = r13.c();
        if (r25 == null) goto L55;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L53;
        r25 = null;
    L53:
        if (r25 == null) goto L55;
        r14.put("vm_path", r25);
    L55:
        if (r13 != null) goto L57;
    L59:
        boolean r26 = false;
    L60:
        r14.put("is_success", r26);
        if (r13 == null) goto L64;
        Integer r27 = r13.d();
        if (r27 == null) goto L64;
    L71:
        if (r27 == null) goto L73;
        r14.put("error_code", ((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.aiagent.plugin")).intValue());
    L73:
        r7.put(r14);
        r9 = r11;
    L64:
        r27 = Integer.valueOf(r19);
        if (((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.aiagent.plugin")).intValue() != 0) goto L67;
        boolean r28 = true;
    L68:
        if (r28 == false) goto L71;
        r27 = null;
        goto L71
    L67:
        r28 = false;
        goto L68
    L57:
        if (r13.a() != true) goto L59;
        r26 = true;
        goto L60
    L41:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L44;
        r24 = null;
    L44:
        if (r24 == null) goto L46;
        r14.put("source_path", r24);
        goto L46
    L33:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L36;
        r110 = null;
    L36:
        if (r110 == null) goto L38;
        r14.put("file_name", r110);
    L27:
        String r111 = r12.b();
        if (r111 == null) goto L30;
        r110 = d.o.o.c(r111, '/', null, 2, null);
        goto L31
    L30:
        r110 = null;
        goto L31
    L19:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L22;
        r18 = null;
    L22:
        if (r18 == null) goto L24;
        r14.put("source_type", r18);
        goto L24
    L74:
        x r29 = x.f38692a;
        r6.put("file_results", r7.toString());
        return r6;
    L9:
        r8 = null;
        goto L10
    L5:
        r5 = false;
        goto L7
    }

    public static /* synthetic */ void a(a r9, String r10, String r11, String r12, Integer r13, String r14, com.obric.aiagent.skill.virt.api.m r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        String r4 = "failure";
    L7:
        if ((r16 & 8) == 0) goto L9;
        Integer r5 = null;
    L11:
        if ((r16 & 16) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r16 & 32) == 0) goto L17;
        com.obric.aiagent.skill.virt.api.m r7 = new com.obric.aiagent.skill.virt.api.m(null, null, 0, 7, null);
    L18:
        r9.a(r10, r11, r4, r5, r6, r7);
        return;
    L17:
        r7 = r15;
        goto L18
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }

    public final void a(final String r9, final String r10, final String r11, final Integer r12, final String r13, final com.obric.aiagent.skill.virt.api.m r14) {
        d.h.b.o.e(r10, "actionType");
        d.h.b.o.e(r11, "result");
        d.h.b.o.e(r14, "commandSummary");
        a("obric_omni_skill_shell_execution_perf", new $$Lambda$a$VricRMvlAyBlZNdN8TMVYfi0(r9, r10, r12, r13, r11, r14));
    }

    private static final JSONObject a(String r4, String r5, Integer r6, String r7, String r8, com.obric.aiagent.skill.virt.api.m r9) {
        JSONObject r0 = new JSONObject();
        r0.put("schema_version", 2);
        if (r4 == null) goto L11;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L11;
        r0.put("omni_task_id", r4);
    L11:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L16;
        r0.put("action_type", r5);
    L16:
        if (r6 == null) goto L18;
        r0.put("error_code", ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue());
    L18:
        if (r7 != null) goto L20;
    L25:
        r0.put("shell_type", MemorySourceLinkType.INTENT);
        r0.put("backend_type", SensitiveType.UNKNOWN);
        r0.put("result", r8);
        r0.put("entered_shell", false);
        r0.put("primary_command", r9.a());
        r0.put("command_family", r9.b());
        r0.put("command_count", r9.c());
        r0.put("completed", false);
        r0.put("killed", false);
        r0.put("duration_ms", 0);
        r0.put("preprocess_duration_ms", 0);
        r0.put("backend_duration_ms", 0);
        r0.put("output_duration_ms", 0);
        r0.put("stdout_chars", 0);
        r0.put("stderr_chars", 0);
        return r0;
    L20:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L23;
        r7 = null;
    L23:
        if (r7 == null) goto L25;
        r0.put("error_type", r7);
        goto L25
    }

    private final void a(String r9, d.h.a.a<? extends JSONObject> r10) {
        d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        Object r8 = n.f(i.a(com.obric.agent.e.f14435a.b(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new C0309a(r9, r11, (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin"), null), m.class, "com.obric.aiagent.plugin"), 2, null));     // Catch: Throwable -> L5
    L7:
        Throwable r12 = n.c(r8);
        if (r12 == null) goto L13;
        f15181a.a("schedule report failed event=" + r9, r12);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r13 = n.f38560a;
        r8 = n.f(o.a(th));
        goto L7
    }

    private final void a(String r3, Throwable r4) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L4
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        ILogDepend.Companion.w(TAG, r3, r4);     // Catch: Throwable -> L4
        n.f(x.f38692a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        n.a r5 = n.f38560a;
        n.f(o.a(th));
    }

    private final JSONObject a(String r3, String r4, long r5, Integer r7) {
        JSONObject r2 = new JSONObject();
        if (r3 != null) goto L5;
    L10:
        r2.put("result", r4);
        r2.put("duration_ms", r5);
        if (r7 == null) goto L13;
        r2.put("error_code", ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue());
    L13:
        return r2;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L10;
        r2.put("omni_task_id", r3);
        goto L10
    }

    private final void a(JSONObject r4, j.e r5) {
        String r3 = r5.b();
        String r0 = null;
        if (r3 != null) goto L5;
    L10:
        Integer r6 = r5.c();
        if (r6 == null) goto L13;
        r4.put("exit_code", ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue());
    L13:
        String r7 = r5.f();
        if (r7 != null) goto L16;
    L20:
        j.d r8 = r5.d();
        if (r8 == null) goto L23;
        r4.put("stdout_truncated", r8.a());
    L23:
        j.d r9 = r5.e();
        if (r9 == null) goto L27;
        r4.put("stderr_truncated", r9.a());
        return;
    L27:
        return;
    L16:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L18;
        r0 = r7;
    L18:
        if (r0 == null) goto L20;
        r4.put("error_type", r0);
        goto L20
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L10;
        r4.put("execution_id", r3);
        goto L10
    }

    private final String a(j.e r2) {
        if (d.h.b.o.a(r2.f(), "BLOCKED") == false) goto L6;
        return "blocked";
    L6:
        if (d.h.b.o.a(r2.a(), "SUCCESS") == false) goto L9;
        return "success";
    L9:
        if (d.h.b.o.a(r2.a(), "PENDING") == false) goto L11;
        return "pending";
    L11:
        return "failure";
    }

    private final String a(String r1) {
        switch(r1.hashCode()) {
            case -1718714019: goto L22;
            case -526673364: goto L18;
            case 3016404: goto L14;
            case 3291998: goto L10;
            case 1957454356: goto L6;
            default: goto L25;
        };
    L25:
        return null;
    L6:
        if (r1.equals("inspect") == false) goto L25;
        return "obric_omni_shell_inspect_result";
    L10:
        if (r1.equals("kill") == false) goto L25;
        return "obric_omni_shell_kill_result";
    L14:
        if (r1.equals("bash") == false) goto L25;
        return "obric_omni_shell_bash_result";
    L18:
        if (r1.equals("export_files") == false) goto L25;
        return "obric_omni_shell_export_files_result";
    L22:
        if (r1.equals("import_files") == false) goto L25;
        return "obric_omni_shell_import_files_result";
    }

    private final String a(int r6, int r7, int r8, int r9) {
        if (r9 == 0) goto L5;
        return "failure";
    L5:
        int r1 = 0;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(p.b(new Integer[]{Integer.valueOf(r6), Integer.valueOf(r7), Integer.valueOf(r8)}), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L8;
    L10:
        Iterator r11 = r10.iterator();
        int r12 = 0;
    L12:
        if (r11.hasNext() == false) goto L21;
        if (((Number) ZeusTransformUtils.preCheckCast(r11.next(), Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L12;
        r12 = r12 + 1;
        if (r12 >= 0) goto L12;
        p.d();
        goto L12
    L16:
        r3 = false;
        goto L17
    L21:
        r1 = r12;
    L22:
        if (r1 <= 1) goto L25;
        return "partial";
    L25:
        if (r6 <= 0) goto L27;
        return "success";
    L27:
        if (r7 <= 0) goto L38;
        return "pending";
    L38:
        return "failure";
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L10;
        goto L10
    }
}
