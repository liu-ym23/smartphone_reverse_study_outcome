package com.obric.aiagent.skill.manager.impl;

import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SkillTrackingReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class hd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final he f20073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final hc f20074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final fb f20075c;

    /* JADX INFO: compiled from: SkillTrackingReporter.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20076a = null;

        static {
            int[] r0 = new int[ck.values().length];
            r0[ck.f19670a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ck.f19671b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f20076a = r0;
        }
    }

    public hd() {
        this(null, null, null, 7, null);
    }

    public hd(he r3, hc r4, fb r5) {
        he r6 = (he) ZeusTransformUtils.wrapperContextForParams(r3, he.class, "com.obric.aiagent.plugin");
        hc r7 = (hc) ZeusTransformUtils.wrapperContextForParams(r4, hc.class, "com.obric.aiagent.plugin");
        fb r8 = (fb) ZeusTransformUtils.wrapperContextForParams(r5, fb.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "sink");
        d.h.b.o.e(r7, "logger");
        d.h.b.o.e(r8, "serverSink");
        this.f20073a = r6;
        this.f20074b = r7;
        this.f20075c = r8;
    }

    public /* synthetic */ hd(he r2, hc r3, fb r4, int r5, d.h.b.h r6) {
        he r7 = (he) ZeusTransformUtils.wrapperContextForParams(r2, he.class, "com.obric.aiagent.plugin");
        hc r8 = (hc) ZeusTransformUtils.wrapperContextForParams(r3, hc.class, "com.obric.aiagent.plugin");
        fb r9 = (fb) ZeusTransformUtils.wrapperContextForParams(r4, fb.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = (he) ZeusTransformUtils.preCheckCast(t.f20166a, he.class, "com.obric.aiagent.plugin");
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = (hc) ZeusTransformUtils.preCheckCast(e.f19796a, hc.class, "com.obric.aiagent.plugin");
    L9:
        if ((r5 & 4) == 0) goto L11;
        r9 = (fb) ZeusTransformUtils.preCheckCast(af.f19444a, fb.class, "com.obric.aiagent.plugin");
    L11:
        this(r7, r8, r9);
    }

    public final void a(dt r4) {
        d.h.b.o.e(r4, "context");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r5 = d.n.f(((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).b(r4));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = d.n.c(r5);
        if (r2 != null) goto L11;
        a("enter_page", (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        a("enter_page", r2);
        return;
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L7
    }

    public final void a(as r3) {
        d.h.b.o.e(r3, "cardType");
        JSONObject r0 = new JSONObject();
        r0.put("card_type_level1", r3.a());
        d.x r4 = d.x.f38692a;
        a("obric_omni_card_show", r0);
    }

    public final void a(cl r4) {
        d.h.b.o.e(r4, "context");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r5 = d.n.f(((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).b(r4));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = d.n.c(r5);
        if (r2 != null) goto L11;
        a("obric_omni_skill_install_start", (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        a("obric_omni_skill_install_start", r2);
        return;
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L7
    }

    public static /* synthetic */ void a(hd r0, cl r1, ck r2, ci r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    public final void a(cl r3, ck r4, ci r5) {
        d.h.b.o.e(r3, "context");
        d.h.b.o.e(r4, "status");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r6 = d.n.f(((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).b(r3, r4, r5));     // Catch: Throwable -> L5
    L7:
        Throwable r7 = d.n.c(r6);
        if (r7 != null) goto L11;
        a("obric_omni_skill_install_file_result", (JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        a("obric_omni_skill_install_file_result", r7);
        return;
    L5:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L7
    }

    public final void a(com.obric.aiagent.skill.manager.api.e r3, boolean r4) {
        d.h.b.o.e(r3, "skill");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r5 = d.n.f(((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).b(r3, r4));     // Catch: Throwable -> L5
    L7:
        Throwable r6 = d.n.c(r5);
        if (r6 != null) goto L11;
        a("obric_omni_skill_item_switch", (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        a("obric_omni_skill_item_switch", r6);
        return;
    L5:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L7
    }

    public final void a(com.obric.aiagent.skill.manager.api.e r3, Collection<? extends bf> r4) {
        Collection<? extends bf> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "skill");
        d.h.b.o.e(r5, "fields");
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r6 = d.n.f(((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).b(r3, r5));     // Catch: Throwable -> L5
    L7:
        Throwable r7 = d.n.c(r6);
        if (r7 != null) goto L11;
        a("obric_omni_skill_edit", (JSONObject) ZeusTransformUtils.preCheckCast(r6, JSONObject.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        a("obric_omni_skill_edit", r7);
        return;
    L5:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L7
    }

    public final void a(com.obric.aiagent.skill.manager.api.e r4) {
        d.h.b.o.e(r4, "skill");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r5 = d.n.f(((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).b(r4));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = d.n.c(r5);
        if (r2 != null) goto L11;
        a("obric_omni_skill_delete", (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        a("obric_omni_skill_delete", r2);
        return;
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L7
    }

    public final void a(eo r4) {
        d.h.b.o.e(r4, "context");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r5 = d.n.f(((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).b(r4));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = d.n.c(r5);
        if (r2 != null) goto L11;
        a("obric_omni_security_scan_start", (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        a("obric_omni_security_scan_start", r2);
        return;
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L7
    }

    public final void a(dx r4) {
        d.h.b.o.e(r4, "event");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r5 = d.n.f(((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).b(r4));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = d.n.c(r5);
        if (r2 != null) goto L11;
        a("obric_omni_skill_performance", (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        a("obric_omni_skill_performance", r2);
        return;
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L7
    }

    public final void a(cs r4) {
        d.h.b.o.e(r4, "event");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r5 = d.n.f(((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).b(r4));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = d.n.c(r5);
        if (r2 != null) goto L11;
        a("obric_omni_skill_load_performance", (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        a("obric_omni_skill_load_performance", r2);
        return;
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L7
    }

    public final void a(com.obric.aiagent.skill.manager.api.e r2, Boolean r3) {
        d.h.b.o.e(r2, "skill");
        a(r2, ew.f19847a, r3);
    }

    public final void b(com.obric.aiagent.skill.manager.api.e r2, Boolean r3) {
        d.h.b.o.e(r2, "skill");
        a(r2, ew.f19848b, r3);
    }

    public final void c(com.obric.aiagent.skill.manager.api.e r2, Boolean r3) {
        d.h.b.o.e(r2, "skill");
        a(r2, ew.f19849c, r3);
    }

    public final void a(cl r3, ci r4, Boolean r5) {
        d.h.b.o.e(r3, "context");
        d.h.b.o.e(r4, "failureReason");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        hd r2 = (hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r6 = d.n.f(fc.f19862a.a(r3, r4, r5));     // Catch: Throwable -> L5
    L7:
        Throwable r7 = d.n.c(r6);
        if (r7 != null) goto L11;
        a("server_install_fail", (fc) ZeusTransformUtils.preCheckCast(r6, fc.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        a("server_install_fail", r7);
        return;
    L5:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L7
    }

    private final JSONObject b(cl r6) {
        String r0 = r6.b();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L22;
        JSONObject r1 = new JSONObject();
        r1.put("install_method", r6.a().a());
        r1.put("skill_name", r0);
        String r2 = r6.c();
        String r3 = null;
        if (r2 != null) goto L7;
    L12:
        String r4 = r6.d();
        if (r4 != null) goto L15;
    L19:
        a(r1, r6);
        return r1;
    L15:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L17;
        r3 = r4;
    L17:
        if (r3 == null) goto L19;
        r1.put("skill_source_url", r3);
        goto L19
    L7:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        r1.put("skill_id", r2);
        goto L12
    L22:
        throw new IllegalArgumentException("skill_name must not be blank".toString());
    }

    private final JSONObject b(cl r7, ck r8, ci r9) {
        String r0 = r7.b();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L34;
        int r1 = a.f20076a[r8.ordinal()];
        if (r1 != 1) goto L7;
        if (r9 != null) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L32;
        d.x r3 = d.x.f38692a;
    L19:
        JSONObject r4 = new JSONObject();
        r4.put("install_method", r7.a().a());
        r4.put("local_status", r8.a());
        r4.put("skill_name", r0);
        String r10 = r7.c();
        if (r10 != null) goto L22;
    L27:
        if (r9 == null) goto L29;
        r4.put("fail_reason", r9.a());
    L29:
        a(r4, r7);
        return r4;
    L22:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L25;
        r10 = null;
    L25:
        if (r10 == null) goto L27;
        r4.put("skill_id", r10);
        goto L27
    L32:
        throw new IllegalArgumentException("fail_reason must be absent when local_status=success".toString());
    L16:
        r2 = false;
        goto L17
    L7:
        if (r1 != 2) goto L13;
        if (r9 != null) goto L19;
        throw new IllegalArgumentException("fail_reason must be present when local_status=fail".toString());
    L13:
        throw new d.k();
    L34:
        throw new IllegalArgumentException("skill_name must not be blank".toString());
    }

    private final void a(JSONObject r2, cl r3) {
        if (r3.a() == com.obric.aiagent.skill.manager.api.q.f) goto L5;
        return;
    L5:
        gs r1 = r3.e();
        if (r1 != null) goto L8;
        return;
    L8:
        if (hj.f20114a.a(r1.b()) == false) goto L11;
        r2.put("install_type", r1.a().a());
        r2.put("skill_version", String.valueOf(r1.b()));
        return;
    L11:
        throw new IllegalArgumentException("skill_version must be positive".toString());
    }

    private final JSONObject b(dt r4) {
        String r3 = r4.b();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L7;
        JSONObject r0 = new JSONObject();
        r0.put("current_page", r4.a().a());
        r0.put("previous_page", r3);
        r0.put("enter_method", r4.c().a());
        return r0;
    L7:
        throw new IllegalArgumentException("previous_page must not be blank".toString());
    }

    private final JSONObject b(com.obric.aiagent.skill.manager.api.e r3, boolean r4) {
        String r2 = r3.a();
        String r5 = r3.b();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L11;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L9;
        JSONObject r0 = new JSONObject();
        r0.put("switch_status", hb.f20068a.a(r4).a());
        r0.put("skill_id", r2);
        r0.put("skill_name", r5);
        return r0;
    L9:
        throw new IllegalArgumentException("skill_name must not be blank".toString());
    L11:
        throw new IllegalArgumentException("skill_id must not be blank".toString());
    }

    private final JSONObject b(com.obric.aiagent.skill.manager.api.e r6, Collection<? extends bf> r7) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.aiagent.plugin");
        String r8 = r6.a();
        String r9 = r6.b();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(bf.b(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if (r5.contains((bf) ZeusTransformUtils.preCheckCast(r4, bf.class, "com.obric.aiagent.plugin")) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L25;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L23;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L21;
        JSONObject r11 = new JSONObject();
        JSONArray r12 = new JSONArray();
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        r12.put(((bf) ZeusTransformUtils.preCheckCast(r13.next(), bf.class, "com.obric.aiagent.plugin")).a());
        goto L16
    L18:
        d.x r14 = d.x.f38692a;
        r11.put("edit_field", r12);
        r11.put("skill_id", r8);
        r11.put("skill_name", r9);
        return r11;
    L21:
        throw new IllegalArgumentException("skill_name must not be blank".toString());
    L23:
        throw new IllegalArgumentException("skill_id must not be blank".toString());
    L25:
        throw new IllegalArgumentException("edit_field must not be empty".toString());
    }

    private final JSONObject b(com.obric.aiagent.skill.manager.api.e r3) {
        String r2 = r3.a();
        String r4 = r3.b();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L11;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L9;
        JSONObject r0 = new JSONObject();
        r0.put("skill_id", r2);
        r0.put("skill_name", r4);
        return r0;
    L9:
        throw new IllegalArgumentException("skill_name must not be blank".toString());
    L11:
        throw new IllegalArgumentException("skill_id must not be blank".toString());
    }

    private final JSONObject b(eo r5) {
        String r4 = r5.a();
        String r0 = r5.c();
        String r1 = r5.d();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L15;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L13;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L11;
        JSONObject r2 = new JSONObject();
        r2.put(KnowledgeActivity.KEY_TASK_ID, r4);
        r2.put("trigger_type", r5.b().a());
        r2.put("skill_id", r0);
        r2.put("skill_name", r1);
        return r2;
    L11:
        throw new IllegalArgumentException("skill_name must not be blank".toString());
    L13:
        throw new IllegalArgumentException("skill_id must not be blank".toString());
    L15:
        throw new IllegalArgumentException("task_id must not be blank".toString());
    }

    private final JSONObject b(dx r12) {
        boolean r1 = false;
        if (r12.c() < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L48;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12.d(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L46;
        if (r12.e() <= 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L44;
        JSONObject r2 = new JSONObject();
        r2.put("schema_version", 2);
        r2.put("operation", r12.a().a());
        r2.put("result", r12.b().a());
        r2.put("duration_ms", r12.c());
        r2.put("trace_id", d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r12.d(), CharSequence.class, "com.obric.aiagent.plugin")).toString());
        r2.put("attempt_index", r12.e());
        a(r2, r12.f(), r12.g(), r12.h(), r12.i());
        String r3 = r12.j();
        String r4 = null;
        if (r3 == null) goto L23;
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r5 == null) goto L23;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L23;
        r2.put("parent_trace_id", r5);
    L23:
        dw r6 = r12.k();
        if (r6 == null) goto L26;
        r2.put("error_code", r6.a());
    L26:
        String r7 = r12.l();
        if (r7 == null) goto L35;
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r8 == null) goto L35;
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L33;
        r4 = r8;
    L33:
        if (r4 == null) goto L35;
        r2.put("failure_stage", r4);
    L35:
        Boolean r9 = r12.m();
        if (r9 == null) goto L38;
        r2.put("retryable", r9.booleanValue());
    L38:
        Boolean r10 = r12.n();
        if (r10 == null) goto L41;
        r2.put("will_retry", r10.booleanValue());
    L41:
        a(r2, r12.o());
        return r2;
    L44:
        throw new IllegalArgumentException("attempt_index must be positive".toString());
    L46:
        throw new IllegalArgumentException("trace_id must not be blank".toString());
    L48:
        throw new IllegalArgumentException("duration_ms must not be negative".toString());
    L5:
        r0 = false;
        goto L6
    }

    private final JSONObject b(cs r11) {
        if (r11.b() < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L30;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11.c(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L28;
        JSONObject r1 = new JSONObject();
        r1.put("schema_version", 2);
        r1.put("result", r11.a().a());
        r1.put("duration_ms", r11.b());
        r1.put("trace_id", d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11.c(), CharSequence.class, "com.obric.aiagent.plugin")).toString());
        a(r1, r11.e(), r11.f(), r11.g(), r11.d());
        dw r2 = r11.h();
        if (r2 == null) goto L12;
        r1.put("error_code", r2.a());
    L12:
        String r3 = r11.i();
        if (r3 == null) goto L22;
        String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r4 == null) goto L22;
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L20;
        r4 = null;
    L20:
        if (r4 == null) goto L22;
        r1.put("failure_stage", r4);
    L22:
        Boolean r5 = r11.j();
        if (r5 == null) goto L25;
        r1.put("retryable", r5.booleanValue());
    L25:
        a(r1, r11.k());
        return r1;
    L28:
        throw new IllegalArgumentException("trace_id must not be blank".toString());
    L30:
        throw new IllegalArgumentException("duration_ms must not be negative".toString());
    L5:
        r0 = false;
        goto L6
    }

    private final void a(JSONObject r3, String r4, Integer r5, String r6, String r7) {
        String r2 = null;
        if (r4 == null) goto L12;
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r8 == null) goto L12;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r8 = null;
    L10:
        if (r8 == null) goto L12;
        r3.put("skill_id", r8);
    L12:
        if (r5 != null) goto L14;
    L19:
        if (r6 == null) goto L28;
        String r9 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r9 == null) goto L28;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L26;
        r9 = null;
    L26:
        if (r9 == null) goto L28;
        r3.put("skill_source", r9);
    L28:
        if (r7 == null) goto L37;
        String r10 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r10 != null) goto L32;
        return;
    L32:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L34;
        r2 = r10;
    L34:
        if (r2 == null) goto L39;
        r3.put(KnowledgeActivity.KEY_TASK_ID, r2);
        return;
    L39:
        return;
    L37:
        return;
    L14:
        if (hj.f20114a.a(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue()) == true) goto L17;
        r5 = null;
    L17:
        if (r5 == null) goto L19;
        r3.put("skill_version", String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue()));
        goto L19
    }

    private final void a(String r5, JSONObject r6) {
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L5
        ((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).f20074b.a(r5, r6);     // Catch: Throwable -> L5
        Object r3 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = d.n.c(r3);
        if (r4 == null) goto L18;
        a(r5, r4);
    L18:
        d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L12
        ((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).f20073a.a(r5, r6);     // Catch: Throwable -> L12
        Object r8 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L12
    L14:
        Throwable r9 = d.n.c(r8);
        if (r9 == null) goto L22;
        a(r5, r9);
        return;
    L22:
        return;
    L12:
        th = move-exception;
        d.n.a r0 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
    L5:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r3 = d.n.f(d.o.a(th));
        goto L7
    }

    private final void a(com.obric.aiagent.skill.manager.api.e r4, ew r5, Boolean r6) {
        String r1 = "server_" + r5.a();
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L5
        hd r3 = (hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r7 = d.n.f(fc.f19862a.a(r4, r5, r6));     // Catch: Throwable -> L5
    L7:
        Throwable r8 = d.n.c(r7);
        if (r8 != null) goto L11;
        a(r1, (fc) ZeusTransformUtils.preCheckCast(r7, fc.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        a(r1, r8);
        return;
    L5:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L7
    }

    private final void a(String r5, fc r6) {
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r3 = d.n.f(Boolean.valueOf(((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).f20075c.a(r6)));     // Catch: Throwable -> L5
    L8:
        if (d.n.a(r3) == true) goto L10;
    L25:
        Throwable r7 = d.n.c(r3);
        if (r7 == null) goto L35;
        a(r5, r7);
        return;
    L35:
        return;
    L10:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L33;
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L20
        ((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).f20074b.c(r5, "server_queue_full");     // Catch: Throwable -> L20
        Object r9 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L20
    L22:
        Throwable r10 = d.n.c(r9);
        if (r10 == null) goto L25;
        a(r5, r10);
    L20:
        th = move-exception;
        d.n.a r0 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L22
    L33:
        d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L13
        ((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).f20074b.a(r6);     // Catch: Throwable -> L13
        Object r11 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L13
    L15:
        Throwable r12 = d.n.c(r11);
        if (r12 == null) goto L25;
        a(r5, r12);
    L13:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
    L5:
        th = move-exception;
        d.n.a r13 = d.n.f38560a;
        r3 = d.n.f(d.o.a(th));
        goto L8
    }

    private final void a(String r3, Throwable r4) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        ((hd) ZeusTransformUtils.preCheckCast(this, hd.class, "com.obric.aiagent.plugin")).f20074b.a(r3, r4);     // Catch: Throwable -> L4
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }

    private final void a(JSONObject r4, Map<String, ? extends Object> r5) {
        Iterator r3 = ((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L14;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.aiagent.plugin");
        Object r7 = r6.getValue();
        String r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
        if (d.h.b.o.a(r2, "skill_name") == true) goto L4;
        if (r4.has(r2) == true) goto L4;
        if (d.h.b.o.a(r7, JSONObject.NULL) == true) goto L4;
        r4.put(r2, r7);
        goto L4
    }
}
