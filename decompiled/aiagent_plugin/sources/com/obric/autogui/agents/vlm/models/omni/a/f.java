package com.obric.autogui.agents.vlm.models.omni.a;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.keva.Keva;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.a.p;
import d.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DataFeedbackUploadFeedbackTaskStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<String, String> f28161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Keva f28162e;
    private final Object f;

    /* JADX INFO: compiled from: DataFeedbackUploadFeedbackTaskStore.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: DataFeedbackUploadFeedbackTaskStore.kt */
    @d.c.b.a.f(b = "DataFeedbackUploadFeedbackTaskStore.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.feedback.DataFeedbackUploadFeedbackTaskStore$getFeedbackInfo$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super e>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f28164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f28165c;

        b(f r3, String r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28164b = r3;
            this.f28165c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super e> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f28164b, this.f28165c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super e> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f28163a != 0) goto L7;
            o.a(r2);
            return this.f28164b.a(this.f28165c);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: DataFeedbackUploadFeedbackTaskStore.kt */
    @d.c.b.a.f(b = "DataFeedbackUploadFeedbackTaskStore.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.feedback.DataFeedbackUploadFeedbackTaskStore$snapshotTasks$2")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super m>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f28167b;

        c(f r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28167b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super m> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f28167b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super m> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f28166a != 0) goto L13;
            o.a(r2);
            Object r3 = f.a(this.f28167b);
            f r1 = this.f28167b;
            monitor-enter(r3);
            m r4 = f.b(r1);     // Catch: Throwable -> L9
            monitor-exit(r3);
            return r4;
        L9:
            th = move-exception;
            throw th;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f28158a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$j-rtg3JvtjgoiR2oaATw2ChAOmM, reason: not valid java name */
    public static /* synthetic */ boolean m771lambda$jrtg3JvtjgoiR2oaATw2ChAOmM(String r0) {
        return h(r0);
    }

    public static /* synthetic */ String lambda$os6XzaGRSTI24rpZ8HQFqxWgvhM(String r0) {
        return g(r0);
    }

    public f(String r3, String r4, d.h.a.b<? super String, String> r5, Keva r6) {
        d.h.a.b<String, String> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "repoName");
        d.h.b.o.e(r4, "tag");
        d.h.b.o.e(r7, "taskIdNormalizer");
        d.h.b.o.e(r6, "keva");
        this.f28159b = r3;
        this.f28160c = r4;
        this.f28161d = r7;
        this.f28162e = r6;
        this.f = new Object();
    }

    public static final /* synthetic */ Object a(f r0) {
        return r0.f;
    }

    public static final /* synthetic */ m b(f r0) {
        return r0.b();
    }

    public /* synthetic */ f(String r2, String r3, d.h.a.b r4, Keva r5, int r6, d.h.b.h r7) {
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r5 = Keva.getRepo(r2, 0);
    L5:
        this(r2, r3, r8, r5);
    }

    public final Object a(d.c.d<? super m> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    public final void a(String r5, e r6) {
        d.h.b.o.e(r5, DBDefinition.TASK_ID);
        String r7 = c(r5);
        if (r7 != null) goto L5;
        return;
    L5:
        Object r0 = this.f;
        monitor-enter(r0);
        Set r1 = p.t((Iterable) ZeusTransformUtils.preCheckCast(a(), Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        String r2 = UUID.randomUUID().toString();     // Catch: Throwable -> L15
        d.h.b.o.c(r2, "toString(...)");     // Catch: Throwable -> L15
        a(r7, r6, r2);     // Catch: Throwable -> L15
        if (r1.add(r7) == false) goto L12;
        a((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        OmniDataFeedbackLog r8 = OmniDataFeedbackLog.INSTANCE;     // Catch: Throwable -> L15
        String r4 = this.f28160c;     // Catch: Throwable -> L15
        if (r8.isVerboseLogEnabled() == false) goto L12;
        Loog.INSTANCE.i(r4, "feedback task added, taskId=" + r7);     // Catch: Throwable -> L15
    L12:
        x r9 = x.f38692a;     // Catch: Throwable -> L15
        monitor-exit(r0);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r5, String r6) {
        d.h.b.o.e(r5, DBDefinition.TASK_ID);
        d.h.b.o.e(r6, "expectedVersion");
        String r7 = c(r5);
        boolean r0 = false;
        if (r7 != null) goto L5;
        return false;
    L5:
        Object r1 = this.f;
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (d.h.b.o.a(d(r7), r6) == true) goto L12;
        OmniDataFeedbackLog r8 = OmniDataFeedbackLog.INSTANCE;     // Catch: Throwable -> L15
        String r4 = this.f28160c;     // Catch: Throwable -> L15
        if (r8.isVerboseLogEnabled() == false) goto L13;
        Loog.INSTANCE.i(r4, "retain feedback task because version changed, taskId=" + r7);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r1);
        return r0;
    L12:
        r0 = e(r7);     // Catch: Throwable -> L15
        goto L13
    }

    public final Object a(String r5, d.c.d<? super e> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    public final e a(String r4) {
        d.h.b.o.e(r4, DBDefinition.TASK_ID);
        String r5 = c(r4);
        e r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        Object r1 = this.f;
        monitor-enter(r1);
        e r3 = (e) ZeusTransformUtils.preCheckCast(c().get(r5), e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r3 == null) goto L12;
        if (r3.g() == true) goto L12;
        r0 = r3;
    L12:
        monitor-exit(r1);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean b(String r2) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        String r3 = c(r2);
        if (r3 != null) goto L6;
        return false;
    L6:
        Object r0 = this.f;
        monitor-enter(r0);
        boolean r1 = a().contains(r3);     // Catch: Throwable -> L11
        monitor-exit(r0);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    private final String c(String r3) {
        String r2 = this.f28161d.invoke(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString());
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
        r2 = null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    }

    private final List<String> a() {
        String r0 = "";
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L9
        String r3 = ((f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin")).f28162e.getString("pending_feedback_task_ids", "");     // Catch: Throwable -> L9
        if (r3 == null) goto L7;
        r0 = r3;
    L7:
        Object r1 = d.n.f(d.n.m.g(d.n.m.j(d.n.m.a(d.n.m.d(d.o.o.f((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")), $$Lambda$f$os6XzaGRSTI24rpZ8HQFqxWgvhM.INSTANCE), $$Lambda$f$jrtg3JvtjgoiR2oaATw2ChAOmM.INSTANCE))));     // Catch: Throwable -> L9
    L11:
        Throwable r4 = d.n.c(r1);
        if (r4 == null) goto L16;
        OmniDataFeedbackLog.INSTANCE.e(this.f28160c, "read feedback task ids failed", r4);
        r1 = p.b();
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L9:
        th = move-exception;
        d.n.a r5 = d.n.f38560a;
        r1 = d.n.f(o.a(th));
        goto L11
    }

    private static final String g(String r2) {
        d.h.b.o.e(r2, "it");
        return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    }

    private static final boolean h(String r2) {
        d.h.b.o.e(r2, "it");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final m b() {
        CharSequence r2 = "{}";
        List<String> r5 = a();
        if (r5.isEmpty() == true) goto L5;
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L40
        f r7 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        String r8 = r7.f28162e.getString("pending_feedback_task_info", "{}");     // Catch: Throwable -> L40
        if (r8 != null) goto L10;
        r8 = "";
    L10:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (d.o.o.d(r9) == true) goto L14;
        r2 = r9;
    L14:
        JSONObject r10 = new JSONObject((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L40
        Map<String, e> r3 = r7.c();     // Catch: Throwable -> L40
        boolean r11 = false;
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L40
        Iterator<String> r13 = r5.iterator();     // Catch: Throwable -> L40
    L16:
        if (r13.hasNext() == false) goto L36;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (r10.has(r14) == true) goto L20;
    L23:
        JSONObject r15 = r10.optJSONObject(r14);     // Catch: Throwable -> L40
        if (r15 != null) goto L26;
        r15 = new JSONObject();     // Catch: Throwable -> L40
        r10.put(r14, r15);     // Catch: Throwable -> L40
        r11 = true;
    L26:
        String r16 = r15.optString("__version", "");     // Catch: Throwable -> L40
        d.h.b.o.c(r16, "optString(...)");     // Catch: Throwable -> L40
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (d.o.o.d(r17) == false) goto L29;
        r17 = UUID.randomUUID().toString();     // Catch: Throwable -> L40
        r15.put("__version", r17);     // Catch: Throwable -> L40
        d.h.b.o.c(r17, "also(...)");     // Catch: Throwable -> L40
        r11 = true;
    L29:
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        Map r19 = (Map) ZeusTransformUtils.preCheckCast(r12, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        e r110 = (e) ZeusTransformUtils.preCheckCast(r3.get(r14), e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (r110 != null) goto L32;
    L34:
        r110 = null;
    L35:
        r19.put(r14, new n(r18, r110));     // Catch: Throwable -> L40
    L22:
        r13 = r13;
        goto L16
    L32:
        if (r110.g() == true) goto L34;
    L20:
        if (r10.optJSONObject(r14) != null) goto L23;
        OmniDataFeedbackLog.INSTANCE.e(r7.f28160c, "snapshot feedback task version failed, malformed taskId=" + r14);     // Catch: Throwable -> L40
        goto L22
    L36:
        if (r11 == false) goto L38;
        r7.f28162e.storeString("pending_feedback_task_info", r10.toString());     // Catch: Throwable -> L40
    L38:
        Object r0 = d.n.f(r12);     // Catch: Throwable -> L40
    L42:
        Throwable r4 = d.n.c(r0);
        if (r4 == null) goto L47;
        OmniDataFeedbackLog.INSTANCE.e(this.f28160c, "snapshot feedback tasks failed", r4);
        r0 = ao.b();
    L47:
        return new m(p.q((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")), (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"));
    L40:
        th = move-exception;
        d.n.a r20 = d.n.f38560a;
        r0 = d.n.f(o.a(th));
        goto L42
    L5:
        return new m(ax.b(), ao.b());
    }

    private final String d(String r7) {
        CharSequence r0 = "{}";
        Object r2 = null;
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L26
        String r4 = ((f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin")).f28162e.getString("pending_feedback_task_info", "{}");     // Catch: Throwable -> L26
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (d.o.o.d(r5) == true) goto L11;
        r0 = r5;
    L11:
        JSONObject r1 = new JSONObject((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin")).optJSONObject(r7);     // Catch: Throwable -> L26
        if (r1 == null) goto L23;
        String r6 = r1.optString("__version", "");     // Catch: Throwable -> L26
        if (r6 == null) goto L23;
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L26
        if (r8 == null) goto L23;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L23;
    L24:
        Object r10 = d.n.f(r8);     // Catch: Throwable -> L26
    L28:
        Throwable r11 = d.n.c(r10);
        if (r11 != null) goto L31;
        r2 = r10;
    L33:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L31:
        OmniDataFeedbackLog.INSTANCE.e(this.f28160c, "read feedback task version failed, taskId=" + r7, r11);
        goto L33
    L20:
        r9 = false;
    L23:
        r8 = null;
    L26:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r10 = d.n.f(o.a(th));
        goto L28
    }

    private final boolean e(String r4) {
        Set r0 = p.t((Iterable) ZeusTransformUtils.preCheckCast(a(), Iterable.class, "com.obric.aiagent.plugin"));
        if (r0.remove(r4) == true) goto L6;
        return false;
    L6:
        a((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin"));
        f(r4);
        OmniDataFeedbackLog r1 = OmniDataFeedbackLog.INSTANCE;
        String r3 = this.f28160c;
        if (r1.isVerboseLogEnabled() == false) goto L11;
        Loog.INSTANCE.i(r3, "feedback task removed, taskId=" + r4);
        return true;
    L11:
        return true;
    }

    private final void a(Collection<String> r15) {
        Collection r16 = (Collection) ZeusTransformUtils.wrapperContextForParams(r15, Collection.class, "com.obric.aiagent.plugin");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L10
        f r2 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r16.isEmpty() == false) goto L7;
        r2.f28162e.erase("pending_feedback_task_ids");     // Catch: Throwable -> L10
        r2.f28162e.erase("pending_feedback_task_info");     // Catch: Throwable -> L10
    L8:
        Object r17 = d.n.f(x.f38692a);     // Catch: Throwable -> L10
    L12:
        Throwable r18 = d.n.c(r17);
        if (r18 == null) goto L18;
        OmniDataFeedbackLog.INSTANCE.e(this.f28160c, "write feedback task ids failed", r18);
        return;
    L18:
        return;
    L7:
        r2.f28162e.storeString("pending_feedback_task_ids", p.a((Iterable) ZeusTransformUtils.preCheckCast(p.m((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), 0, null, null, 58, null));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        d.n.a r0 = d.n.f38560a;
        r17 = d.n.f(o.a(th));
        goto L12
    }

    private final Map<String, e> c() {
        CharSequence r0 = "{}";
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L58
        String r4 = ((f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin")).f28162e.getString("pending_feedback_task_info", "{}");     // Catch: Throwable -> L58
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
        if (d.o.o.d(r5) == true) goto L11;
        r0 = r5;
    L11:
        JSONObject r6 = new JSONObject((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L58
        Iterator<String> r1 = r6.keys();     // Catch: Throwable -> L58
        d.h.b.o.c(r1, "keys(...)");     // Catch: Throwable -> L58
        d.n.j r2 = d.n.m.a(r1);     // Catch: Throwable -> L58
        LinkedHashMap r7 = new LinkedHashMap();     // Catch: Throwable -> L58
        Iterator r8 = r2.a();     // Catch: Throwable -> L58
    L13:
        if (r8.hasNext() == false) goto L56;
        Object r9 = r8.next();     // Catch: Throwable -> L58
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
        JSONObject r11 = r6.optJSONObject((String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L58
        if (r11 != null) goto L17;
        r11 = new JSONObject();     // Catch: Throwable -> L58
    L17:
        JSONArray r12 = r11.optJSONArray("tags");     // Catch: Throwable -> L58
        if (r12 == null) goto L29;
        List r13 = p.a();     // Catch: Throwable -> L58
        int r14 = r12.length();     // Catch: Throwable -> L58
        int r15 = 0;
    L20:
        if (r15 >= r14) goto L28;
        String r16 = r12.optString(r15, "");     // Catch: Throwable -> L58
        d.h.b.o.c(r16, "optString(...)");     // Catch: Throwable -> L58
        String r17 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L58
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L25;
        r17 = null;
    L25:
        if (r17 == null) goto L27;
        r13.add(r17);     // Catch: Throwable -> L58
    L27:
        r15 = r15 + 1;     // Catch: Throwable -> L58
        goto L20
    L28:
        List r18 = p.a(r13);     // Catch: Throwable -> L58
    L30:
        if (r18 != null) goto L32;
        r18 = p.b();     // Catch: Throwable -> L58
    L32:
        List r19 = r18;
        String r20 = r11.optString("content", "");     // Catch: Throwable -> L58
        d.h.b.o.a(r20);     // Catch: Throwable -> L58
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L35;
        String r110 = r20;
    L36:
        j[] r21 = j.values();     // Catch: Throwable -> L58
        int r111 = r21.length;     // Catch: Throwable -> L58
        int r112 = 0;
    L37:
        if (r112 >= r111) goto L42;
        j r113 = r21[r112];     // Catch: Throwable -> L58
        if (d.h.b.o.a(r113.a(), r11.optString(DBHelper.BATTERY_COL_SOURCE, "")) == true) goto L40;
        r112 = r112 + 1;     // Catch: Throwable -> L58
        goto L37
    L40:
        j r114 = r113;
    L43:
        String r22 = r11.optString("type", "");     // Catch: Throwable -> L58
        d.h.b.o.a(r22);     // Catch: Throwable -> L58
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L46;
        String r23 = r22;
    L47:
        String r24 = r11.optString("score", "");     // Catch: Throwable -> L58
        d.h.b.o.a(r24);     // Catch: Throwable -> L58
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L50;
        String r25 = r24;
    L51:
        boolean r26 = r11.optBoolean("need_upload_image", true);     // Catch: Throwable -> L58
        com.obric.aiagent.assistant.idl.bean.c r27 = com.obric.aiagent.assistant.idl.bean.c.f16269a;     // Catch: Throwable -> L58
        Object r28 = r11.opt("amount");     // Catch: Throwable -> L58
        if (ZeusTransformUtils.instanceOf(r28, Integer.class) == false) goto L54;
        Integer r115 = (Integer) ZeusTransformUtils.preCheckCast(r28, Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
    L55:
        r10.put(r9, new e(r110, r19, r114, r23, r25, r26, r27.a(r115)));     // Catch: Throwable -> L58
        goto L13
    L54:
        r115 = null;
        goto L55
    L50:
        r25 = null;
        goto L51
    L46:
        r23 = null;
        goto L47
    L42:
        r114 = null;
        goto L43
    L35:
        r110 = null;
        goto L36
    L29:
        r18 = null;
        goto L30
    L56:
        Object r29 = d.n.f((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L58
    L60:
        Throwable r30 = d.n.c(r29);
        if (r30 == null) goto L65;
        OmniDataFeedbackLog.INSTANCE.e(this.f28160c, "read feedback info failed", r30);
        r29 = ao.b();
    L65:
        return (Map) ZeusTransformUtils.preCheckCast(r29, Map.class, "com.obric.aiagent.plugin");
    L58:
        th = move-exception;
        d.n.a r31 = d.n.f38560a;
        r29 = d.n.f(o.a(th));
        goto L60
    }

    private final void a(String r16, e r17, String r18) {
        CharSequence r0 = "{}";
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L61
        f r6 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
        String r7 = r6.f28162e.getString("pending_feedback_task_info", "{}");     // Catch: Throwable -> L61
        if (r7 != null) goto L6;
        r7 = "";
    L6:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
        if (d.o.o.d(r8) == true) goto L10;
        r0 = r8;
    L10:
        JSONObject r9 = new JSONObject((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L61
        if (r17 != null) goto L13;
    L15:
        boolean r10 = false;
    L16:
        if (r10 == false) goto L56;
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L61
        String r12 = r17.a();     // Catch: Throwable -> L61
        String r13 = null;
        if (r12 == null) goto L26;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L23;
        r12 = null;
    L23:
        if (r12 == null) goto L26;
        r11.put("content", r12);     // Catch: Throwable -> L61
    L26:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r17.b(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L32;
        JSONArray r14 = new JSONArray();     // Catch: Throwable -> L61
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r17.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L61
    L29:
        if (r15.hasNext() == false) goto L31;
        r14.put((String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L61
        goto L29
    L31:
        x r19 = x.f38692a;     // Catch: Throwable -> L61
        r11.put("tags", r14);     // Catch: Throwable -> L61
    L32:
        j r20 = r17.c();     // Catch: Throwable -> L61
        if (r20 == null) goto L35;
        r11.put(DBHelper.BATTERY_COL_SOURCE, r20.a());     // Catch: Throwable -> L61
    L35:
        String r21 = r17.getType();     // Catch: Throwable -> L61
        if (r21 != null) goto L38;
    L43:
        String r22 = r17.d();     // Catch: Throwable -> L61
        if (r22 != null) goto L46;
    L50:
        Integer r23 = com.obric.aiagent.assistant.idl.bean.c.f16269a.a(r17.f());     // Catch: Throwable -> L61
        if (r23 == null) goto L54;
        r11.put("amount", ((Number) ZeusTransformUtils.preCheckCast(r23, Number.class, "com.obric.aiagent.plugin")).intValue());     // Catch: Throwable -> L61
    L54:
        if (r17.e() == true) goto L59;
        r11.put("need_upload_image", false);     // Catch: Throwable -> L61
    L59:
        r11.put("__version", r18);     // Catch: Throwable -> L61
        r9.put(r16, r11);     // Catch: Throwable -> L61
        r6.f28162e.storeString("pending_feedback_task_info", r9.toString());     // Catch: Throwable -> L61
        Object r1 = d.n.f(x.f38692a);     // Catch: Throwable -> L61
    L63:
        Throwable r2 = d.n.c(r1);
        if (r2 == null) goto L70;
        OmniDataFeedbackLog.INSTANCE.e(this.f28160c, "write feedback task failed, taskId=" + r16, r2);
        return;
    L70:
        return;
    L46:
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L48;
        r13 = r22;
    L48:
        if (r13 == null) goto L50;
        r11.put("score", r13);     // Catch: Throwable -> L61
        goto L50
    L38:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L41;
        r21 = null;
    L41:
        if (r21 == null) goto L43;
        r11.put("type", r21);     // Catch: Throwable -> L61
        goto L43
    L56:
        r11 = r9.optJSONObject(r16);     // Catch: Throwable -> L61
        if (r11 != null) goto L59;
        r11 = new JSONObject();     // Catch: Throwable -> L61
        goto L59
    L13:
        if (r17.g() == true) goto L15;
        r10 = true;
    L61:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r1 = d.n.f(o.a(th));
        goto L63
    }

    private final void f(String r7) {
        CharSequence r0 = "{}";
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L16
        f r4 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        String r5 = r4.f28162e.getString("pending_feedback_task_info", "{}");     // Catch: Throwable -> L16
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (d.o.o.d(r6) == true) goto L10;
        r0 = r6;
    L10:
        JSONObject r2 = new JSONObject((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        r2.remove(r7);     // Catch: Throwable -> L16
        if (r2.length() != 0) goto L13;
        r4.f28162e.erase("pending_feedback_task_info");     // Catch: Throwable -> L16
    L14:
        Object r1 = d.n.f(x.f38692a);     // Catch: Throwable -> L16
    L18:
        Throwable r8 = d.n.c(r1);
        if (r8 == null) goto L24;
        OmniDataFeedbackLog.INSTANCE.e(this.f28160c, "remove feedback info failed, taskId=" + r7, r8);
        return;
    L24:
        return;
    L13:
        r4.f28162e.storeString("pending_feedback_task_info", r2.toString());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r1 = d.n.f(o.a(th));
        goto L18
    }
}
