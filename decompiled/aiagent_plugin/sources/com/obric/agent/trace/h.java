package com.obric.agent.trace;

import android.os.SystemClock;
import androidx.core.provider.FontsContractCompat;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskId;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.coroutines.am;
import org.json.JSONObject;

/* JADX INFO: compiled from: IntentExecuteData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList<t> f15491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<v> f15492e;
    private TaskInfo f;
    private long g;
    private f h;
    private String i;
    private String j;
    private String k;
    private String l;
    private boolean m;
    private boolean n;
    private long o;
    private long p;
    private com.obric.agent.trace.omni.a q;
    private Map<String, String> r;

    /* JADX INFO: compiled from: IntentExecuteData.kt */
    @d.c.b.a.f(b = "IntentExecuteData.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentExecuteData$setState$3")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f15494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f15495c;

        a(h r3, long r4, d.c.d<? super a> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15494b = r3;
            this.f15495c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f15494b, this.f15495c, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f15493a != 0) goto L7;
            d.o.a(r8);
            h.a(this.f15494b, this.f15495c, false, 2, null);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: lambda$-Vi325wzew-ZaXgcptmWRtP3Pr4, reason: not valid java name */
    public static /* synthetic */ CharSequence m104lambda$Vi325wzewZaXgcptmWRtP3Pr4(Map r0, Map r1, String r2) {
        return a(r0, r1, r2);
    }

    public h() {
        this.f15488a = "";
        this.f15491d = new CopyOnWriteArrayList();
        this.f15492e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.g = SystemClock.elapsedRealtime();
    }

    public final String a() {
        return this.f15488a;
    }

    public final void a(String r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.f15488a = r2;
    }

    public final String b() {
        return this.f15489b;
    }

    public final void b(String r1) {
        this.f15490c = r1;
    }

    public final String c() {
        return this.f15490c;
    }

    public final o d() {
        t r2 = (t) ZeusTransformUtils.preCheckCast(d.a.p.n((List) ZeusTransformUtils.preCheckCast(this.f15491d, List.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        o r3 = r2.a();
        if (r3 == null) goto L7;
        return r3;
    L7:
        return o.f15587a;
    }

    public final void a(f r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        f r0 = this.h;
        if (r0 != null) goto L8;
        this.h = r5;
        return;
    L8:
        d.h.b.o.a(r0);
        if (r0.a().compareTo((Enum) ZeusTransformUtils.preCheckCast(r5.a(), Enum.class, "com.obric.aiagent.plugin")) <= 0) goto L12;
        ILogDepend.Companion r1 = ILogDepend.Companion;
        StringBuilder r6 = new StringBuilder().append(r5.a()).append(" is low than ");
        f r4 = this.h;
        d.h.b.o.a(r4);
        r1.i("IntentTracer", r6.append(r4.a()).append('.').toString());
        return;
    L12:
        this.h = r5;
    }

    public final void c(String r1) {
        this.i = r1;
    }

    public final String e() {
        return this.i;
    }

    public final void d(String r1) {
        this.j = r1;
    }

    public final String f() {
        return this.j;
    }

    public final void e(String r1) {
        this.k = r1;
    }

    public final void f(String r1) {
        this.l = r1;
    }

    public final String g() {
        return this.l;
    }

    public final void a(boolean r1) {
        this.m = r1;
    }

    public final void b(boolean r1) {
        this.n = r1;
    }

    public final void a(long r1) {
        this.o = r1;
    }

    public final void a(com.obric.agent.trace.omni.a r1) {
        this.q = r1;
    }

    public final void a(Map<String, String> r3) {
        this.r = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ Object a(h r1, o r2, boolean r3, d.c.d r4, int r5, Object r6) {
        d.c.d<? super d.x> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        return r1.a(r2, r3, r7);
    }

    public final Object a(o r11, boolean r12, d.c.d<? super d.x> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtime();
        ISecureLogDepend.Companion.i("IntentTracer", "Intent:" + this.f15488a);
        ILogDepend.Companion.i("IntentTracer", "state:" + d() + "->" + r11);
        t r15 = (t) ZeusTransformUtils.preCheckCast(d.a.p.n((List) ZeusTransformUtils.preCheckCast(this.f15491d, List.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L5;
    L7:
        this.f15491d.add(new t(r11, (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin"), r8, r12));
        if (r11 != o.A) goto L19;
        t r16 = (t) ZeusTransformUtils.preCheckCast(d.a.p.n((List) ZeusTransformUtils.preCheckCast(this.f15491d, List.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L15;
        Map<String, Object> r17 = r16.b();
        if (r17 == null) goto L15;
        r17.put("endTime", d.c.b.a.b.a(r8));
    L15:
        if (this.o != 0) goto L17;
        this.o = r8;
    L17:
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this, (this.o - this.g) + this.p, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    L19:
        return d.x.f38692a;
    L5:
        if (r15.d() == true) goto L7;
        a(r15);
        goto L7
    }

    public final void b(long r3) {
        this.p = r3;
        ILogDepend.Companion.i("IntentTracer", "state:" + o.f15588b + ", cost:" + r3 + ", data:null");
    }

    public final void a(o r11, long r12, boolean r14) {
        d.h.b.o.e(r11, "state");
        long r0 = 0;
        if (r12 <= 0) goto L50;
        Long r5 = null;
        if (r14 == false) goto L20;
        List r15 = (List) ZeusTransformUtils.preCheckCast(this.f15491d, List.class, "com.obric.aiagent.plugin");
        ListIterator r16 = r15.listIterator(r15.size());
    L8:
        if (r16.hasPrevious() == false) goto L15;
        Object r7 = r16.previous();
        if (((t) ZeusTransformUtils.preCheckCast(r7, t.class, "com.obric.aiagent.plugin")).a() != r11) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L8;
    L16:
        t r17 = (t) ZeusTransformUtils.preCheckCast(r7, t.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L20;
        r17.b().put("endTime", Long.valueOf(r17.c() + r12));
        goto L20
    L12:
        r8 = false;
        goto L13
    L15:
        r7 = null;
    L20:
        if (r11 != o.t) goto L51;
        List r10 = (List) ZeusTransformUtils.preCheckCast(this.f15491d, List.class, "com.obric.aiagent.plugin");
        ListIterator r13 = r10.listIterator(r10.size());
    L23:
        if (r13.hasPrevious() == false) goto L30;
        Object r18 = r13.previous();
        if (((t) ZeusTransformUtils.preCheckCast(r18, t.class, "com.obric.aiagent.plugin")).a() != o.r) goto L27;
        boolean r19 = true;
    L28:
        if (r19 == false) goto L23;
    L31:
        t r110 = (t) ZeusTransformUtils.preCheckCast(r18, t.class, "com.obric.aiagent.plugin");
        if (r110 == null) goto L52;
        Object r111 = r110.b().get("endTime");
        if (ZeusTransformUtils.instanceOf(r111, Long.class) == false) goto L36;
        r5 = (Long) ZeusTransformUtils.preCheckCast(r111, Long.class, "com.obric.aiagent.plugin");
    L36:
        if (r5 == null) goto L38;
        r0 = r5.longValue();
    L38:
        r110.b().put("endTime", Long.valueOf(r0 - r12));
        return;
    L52:
        return;
    L27:
        r19 = false;
        goto L28
    L30:
        r18 = null;
        goto L31
    L51:
        return;
    }

    public final Long a(o r5) {
        d.h.b.o.e(r5, "state");
        List r4 = (List) ZeusTransformUtils.preCheckCast(this.f15491d, List.class, "com.obric.aiagent.plugin");
        ListIterator r6 = r4.listIterator(r4.size());
    L4:
        if (r6.hasPrevious() == false) goto L11;
        Object r0 = r6.previous();
        if (((t) ZeusTransformUtils.preCheckCast(r0, t.class, "com.obric.aiagent.plugin")).a() != r5) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        t r7 = (t) ZeusTransformUtils.preCheckCast(r0, t.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L26;
        Object r8 = r7.b().get("endTime");
        if (ZeusTransformUtils.instanceOf(r8, Long.class) == false) goto L17;
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(r8, Long.class, "com.obric.aiagent.plugin");
    L18:
        if (r9 != null) goto L20;
        return null;
    L20:
        return Long.valueOf(r9.longValue() - r7.c());
    L17:
        r9 = null;
        goto L18
    L26:
        return null;
    L8:
        r3 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    public final void b(o r4) {
        d.h.b.o.e(r4, "state");
        List r3 = (List) ZeusTransformUtils.preCheckCast(this.f15491d, List.class, "com.obric.aiagent.plugin");
        ListIterator r5 = r3.listIterator(r3.size());
    L4:
        if (r5.hasPrevious() == false) goto L11;
        Object r0 = r5.previous();
        if (((t) ZeusTransformUtils.preCheckCast(r0, t.class, "com.obric.aiagent.plugin")).a() != r4) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        t r6 = (t) ZeusTransformUtils.preCheckCast(r0, t.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L21;
        r6.b().put("endTime", Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L21:
        return;
    L8:
        r2 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    private final void a(t r7) {
        long r0 = SystemClock.elapsedRealtime();
        if (r7.b().get("endTime") != null) goto L5;
        Long r1 = Long.valueOf(r0);
        r7.b().put("endTime", r1);
    L5:
        ISecureLogDepend.Companion r2 = ISecureLogDepend.Companion;
        StringBuilder r3 = new StringBuilder().append("state:").append(r7).append(", cost:");
        Object r4 = r7.b().get("endTime");
        d.h.b.o.a(r4, "null cannot be cast to non-null type kotlin.Long");
        r2.i("IntentTracer", r3.append(((Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.aiagent.plugin")).longValue() - r7.c()).append(", ").toString());
        b(r7);
    }

    public static /* synthetic */ void a(h r0, String r1, Object r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        r0.a(r1, r2, r3);
    }

    public final void a(String r7, Object r8, int r9) {
        d.h.b.o.e(r7, "key");
        t r0 = (t) ZeusTransformUtils.preCheckCast(d.a.p.n((List) ZeusTransformUtils.preCheckCast(this.f15491d, List.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L32;
        Map<String, Object> r1 = r0.b();
        if (r1 != null) goto L8;
        return;
    L8:
        if (d.h.b.o.a(r7, "error_msg") == true) goto L10;
        r1.put(r7, r8);
    L10:
        Object r4 = r1.get(FontsContractCompat.Columns.RESULT_CODE);
        if (r4 != null) goto L13;
    L14:
        r1.put(FontsContractCompat.Columns.RESULT_CODE, Integer.valueOf(r9));
        if (d.h.b.o.a(r7, "error_msg") == false) goto L18;
        r1.put(r7, r8);
    L18:
        if (d.h.b.o.a(r7, "summarize_result") == false) goto L33;
        f r2 = null;
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L22;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
    L23:
        if (r10 == null) goto L34;
        if (r9 != 0) goto L26;
        n r11 = n.f15582a;
    L27:
        f r3 = this.h;
        if (r3 == null) goto L30;
        r2 = r3.a(r11, r10, r9);
    L30:
        a(r2);
        return;
    L26:
        r11 = n.f15585d;
        goto L27
    L34:
        return;
    L22:
        r10 = null;
        goto L23
    L33:
        return;
    L13:
        if (d.h.b.o.a(r4, 0) == false) goto L18;
    }

    public final String h() {
        List r5 = (List) ZeusTransformUtils.preCheckCast(this.f15491d, List.class, "com.obric.aiagent.plugin");
        ListIterator r6 = r5.listIterator(r5.size());
    L4:
        if (r6.hasPrevious() == false) goto L11;
        Object r0 = r6.previous();
        if (((t) ZeusTransformUtils.preCheckCast(r0, t.class, "com.obric.aiagent.plugin")).a() != o.t) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        t r7 = (t) ZeusTransformUtils.preCheckCast(r0, t.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L27;
        Map<String, Object> r8 = r7.b();
        if (r8 != null) goto L17;
        return null;
    L17:
        if (r8.get("endTime") != null) goto L29;
        Object r9 = r8.get(Ext.KEY_INTENT_NAME);
        if (ZeusTransformUtils.instanceOf(r9, String.class) == true) goto L21;
        return null;
    L21:
        return (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
    L29:
        return null;
    L27:
        return null;
    L8:
        r3 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    public final boolean c(o r6) {
        d.h.b.o.e(r6, "state");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f15491d, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r5.iterator();
    L9:
        if (r7.hasNext() == false) goto L15;
        if (((t) ZeusTransformUtils.preCheckCast(r7.next(), t.class, "com.obric.aiagent.plugin")).a() != r6) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L9;
        return true;
    L13:
        r0 = false;
    L15:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public final boolean a(o r7, String r8) {
        d.h.b.o.e(r7, "state");
        d.h.b.o.e(r8, "key");
        List r6 = (List) ZeusTransformUtils.preCheckCast(this.f15491d, List.class, "com.obric.aiagent.plugin");
        ListIterator r9 = r6.listIterator(r6.size());
    L3:
        Object r4 = null;
        if (r9.hasPrevious() == false) goto L11;
        Object r0 = r9.previous();
        if (((t) ZeusTransformUtils.preCheckCast(r0, t.class, "com.obric.aiagent.plugin")).a() != r7) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L3;
    L12:
        t r10 = (t) ZeusTransformUtils.preCheckCast(r0, t.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L17;
        Map<String, Object> r11 = r10.b();
        if (r11 == null) goto L17;
        r4 = r11.get(r8);
    L17:
        if (r4 == null) goto L20;
        return true;
    L20:
        return false;
    L8:
        r5 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    public final void a(TaskInfo r17, State r18, DMEvent r19, Exception r20) {
        d.h.b.o.e(r17, "taskInfo");
        d.h.b.o.e(r18, "currentState");
        d.h.b.o.e(r20, "exception");
        long r11 = SystemClock.elapsedRealtime();
        String r4 = null;
        if (r19 == null) goto L11;
        long r5 = r19.getTimestamp();
        String r7 = r19.getEventName();
        Map<String, String> r8 = r19.getExtra();
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r10 = r8.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if ((!d.h.b.o.a((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.aiagent.plugin"), "message_reply")) == false) goto L6;
        r9.put(r12.getKey(), r12.getValue());
        goto L6
    L10:
        e r13 = new e(r5, r7, (Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.aiagent.plugin"));
    L12:
        StringBuilder r2 = new StringBuilder().append("currentState=").append(r18.getStateName()).append(" eventName=");
        if (r19 == null) goto L15;
        r4 = r19.getEventName();
    L15:
        this.f15492e.add(new v("Interrupted:TransitionFailed", r11, null, r13, ao.a(d.s.a("error_msg", r2.append(r4).append(" failed: ").append(r20.getMessage()).toString())), 4, null));
        if (this.f15492e.size() <= 1) goto L24;
        List<v> r0 = this.f15492e;
        ((v) ZeusTransformUtils.preCheckCast(r0.get(r0.size() - 2), v.class, "com.obric.aiagent.plugin")).a(Long.valueOf(r11));
        return;
    L24:
        return;
    L11:
        r13 = null;
        goto L12
    }

    public final void a(State r13, TaskInfo r14, DMEvent r15) {
        d.h.b.o.e(r13, "newState");
        if (r14 == null) goto L5;
        a(this.f, r14);
        this.f = r14;
    L5:
        long r10 = SystemClock.elapsedRealtime();
        if (r15 == null) goto L14;
        long r1 = r15.getTimestamp();
        String r3 = r15.getEventName();
        Map<String, String> r16 = r15.getExtra();
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r17 = r16.entrySet().iterator();
    L9:
        if (r17.hasNext() == false) goto L13;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if ((!d.h.b.o.a((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin"), "message_reply")) == false) goto L9;
        r4.put(r5.getKey(), r5.getValue());
        goto L9
    L13:
        e r6 = new e(r1, r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
    L15:
        this.f15492e.add(new v(r13.getStateName(), r10, null, r6, null, 20, null));
        if (this.f15492e.size() <= 1) goto L24;
        List<v> r12 = this.f15492e;
        ((v) ZeusTransformUtils.preCheckCast(r12.get(r12.size() - 2), v.class, "com.obric.aiagent.plugin")).a(Long.valueOf(r10));
        return;
    L24:
        return;
    L14:
        r6 = null;
        goto L15
    }

    private final void a(TaskInfo r25, TaskInfo r26) {
        long r10 = SystemClock.elapsedRealtime();
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        if (r25 != null) goto L5;
    L7:
        if (r25 == null) goto L12;
        if (r25.getIndex() == r26.getIndex()) goto L12;
        r1.add("index=" + r25.getIndex() + "->" + r26.getIndex());
    L12:
        if (r25 == null) goto L29;
        final Map<String, String> r2 = r25.getExt();
        if (r2 != null) goto L16;
        r2 = ao.b();
    L16:
        final Map<String, String> r3 = r26.getExt();
        if (r3 != null) goto L19;
        r3 = ao.b();
    L19:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(ax.b(r3.keySet(), (Iterable) ZeusTransformUtils.preCheckCast(r2.keySet(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r4.iterator();
    L21:
        if (r6.hasNext() == false) goto L25;
        Object r7 = r6.next();
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
        if ((!d.h.b.o.a(r3.get(r8), r2.get(r8))) == false) goto L21;
        r5.add(r7);
        goto L21
    L25:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L29;
        r1.add("ext={" + d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, new $$Lambda$h$Vi325wzewZaXgcptmWRtP3Pr4(r2, r3), 30, null) + '}');
    L29:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L39;
        this.f15492e.add(new v("TaskInfoChanges", r10, null, null, ao.a(d.s.a("change_info", d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("+", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null))), 4, null));
        if (this.f15492e.size() <= 1) goto L40;
        List<v> r0 = this.f15492e;
        ((v) ZeusTransformUtils.preCheckCast(r0.get(r0.size() - 2), v.class, "com.obric.aiagent.plugin")).a(Long.valueOf(r10));
        return;
    L40:
        return;
    L39:
        return;
    L5:
        if (d.h.b.o.a(r25.getProgress(), r26.getProgress()) == true) goto L7;
        r1.add("progress=" + r25.getProgress() + "->" + r26.getProgress());
        goto L7
    }

    private static final CharSequence a(Map r3, Map r4, String r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "key");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r5 + '=' + ((String) ZeusTransformUtils.preCheckCast(r6.get(r5), String.class, "com.obric.aiagent.plugin")) + "->" + ((String) ZeusTransformUtils.preCheckCast(r7.get(r5), String.class, "com.obric.aiagent.plugin")), CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final void a(String r10, Map<String, ? extends Object> r11) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "interruptReason");
        this.f15492e.add(new v("Interrupted: " + r10, SystemClock.elapsedRealtime(), null, null, r6, 4, null));
    }

    static /* synthetic */ void a(h r0, long r1, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        r0.a(r1, r3);
    }

    private final void a(long r39, boolean r41) {
        List r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        if (this.p <= 0) goto L5;
        r12.add(new u(o.f15588b, this.p, null, 4, null));
    L5:
        Iterator<t> r1 = this.f15491d.iterator();
        d.h.b.o.c(r1, "iterator(...)");
    L6:
        String r6 = null;
        Long r7 = null;
        r6 = null;
        if (r1.hasNext() == false) goto L15;
        t r2 = (t) ZeusTransformUtils.preCheckCast(r1.next(), t.class, "com.obric.aiagent.plugin");
        Object r8 = r2.b().get("endTime");
        if (ZeusTransformUtils.instanceOf(r8, Long.class) == false) goto L11;
        r7 = (Long) ZeusTransformUtils.preCheckCast(r8, Long.class, "com.obric.aiagent.plugin");
    L11:
        if (r7 == null) goto L13;
        long r9 = r7.longValue();
    L14:
        r12.add(new u(r2.a(), r9 - r2.c(), r2.b()));
        goto L6
    L13:
        r9 = 0;
        goto L14
    L15:
        Date r3 = new Date();
        SimpleDateFormat r4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f15492e, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L47;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f15492e, Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r5.iterator();
    L19:
        if (r11.hasNext() == false) goto L21;
        v r13 = (v) ZeusTransformUtils.preCheckCast(r11.next(), v.class, "com.obric.aiagent.plugin");
        r10.add(new v(r13.a(), r13.b(), r13.c(), r13.d(), null, 16, null));
        goto L19
    L21:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
        Map<String, String> r14 = this.r;
        if (r14 == null) goto L26;
        com.obric.agent.trace.omni.a r15 = this.q;
        if (r15 == null) goto L30;
        r r16 = a(r15, r14);
    L29:
        r r18 = r16;
    L31:
        TaskInfo r19 = this.f;
        if (r19 == null) goto L34;
        TaskId r110 = r19.getTaskId();
    L35:
        TaskInfo r20 = this.f;
        if (r20 == null) goto L40;
        IMMessage r21 = r20.getMessage();
        if (r21 == null) goto L40;
        String r111 = r21.getMessageId();
    L41:
        TaskInfo r22 = this.f;
        if (r22 == null) goto L46;
        IMMessage r23 = r22.getMessage();
        if (r23 == null) goto L46;
        r6 = com.obric.agent.im.b.a(r23);
    L46:
        w r112 = new w(r110, r111, r6, r17, r18);
    L48:
        String r24 = this.f15488a;
        String r25 = this.f15489b;
        String r26 = r4.format(r3);
        f r27 = this.h;
        Iterable r28 = (Iterable) ZeusTransformUtils.preCheckCast(this.f15491d, Iterable.class, "com.obric.aiagent.plugin");
        Collection r29 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r28, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r30 = r28.iterator();
    L50:
        if (r30.hasNext() == false) goto L52;
        r29.add(((t) ZeusTransformUtils.preCheckCast(r30.next(), t.class, "com.obric.aiagent.plugin")).a());
        goto L50
    L52:
        i r210 = new i(r24, r25, r26, r27, r39, (List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.aiagent.plugin"), r12, r112, null, null, null, null, null, 7936, null);
        if (this.m == false) goto L55;
        String r31 = "VOICE";
    L56:
        i r32 = i.a(i.a(i.a(r210, null, null, null, null, 0, null, null, null, r31, null, null, null, null, 7935, null), null, null, null, null, 0, null, null, null, null, this.k, this.i, this.j, null, 4607, null), null, null, null, null, 0, null, null, null, null, null, null, null, this.l, 4095, null);
        String r0 = this.j;
        if (r0 == null) goto L67;
        if (r41 == false) goto L60;
        q.f15713a.b(r0, r32);
        return;
    L60:
        q.f15713a.a(r0, r32);
        return;
    L67:
        return;
    L55:
        r31 = "TEXT";
    L40:
        r111 = null;
        goto L41
    L34:
        r110 = null;
    L30:
        r18 = null;
        goto L31
    L26:
        com.obric.agent.trace.omni.a r33 = this.q;
        if (r33 == null) goto L30;
        r16 = b(r33);
        goto L29
    L47:
        r112 = null;
        goto L48
    }

    private final void b(t r22) {
        if (r22.a() != o.r) goto L5;
    L9:
        List r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator<t> r1 = this.f15491d.iterator();
        d.h.b.o.c(r1, "iterator(...)");
    L11:
        if (r1.hasNext() == false) goto L20;
        t r2 = (t) ZeusTransformUtils.preCheckCast(r1.next(), t.class, "com.obric.aiagent.plugin");
        Object r4 = r2.b().get("endTime");
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == false) goto L15;
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.aiagent.plugin");
    L16:
        if (r5 == null) goto L18;
        long r6 = r5.longValue();
    L19:
        long r7 = r6 - r2.c();
        r12.add(new u(r2.a(), r7, r2.b()));
        goto L11
    L18:
        r6 = 0;
        goto L19
    L15:
        r5 = null;
        goto L16
    L20:
        String r8 = this.f15488a;
        String r9 = this.f15489b;
        f r10 = this.h;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(this.f15491d, Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r3.iterator();
    L22:
        if (r13.hasNext() == false) goto L24;
        r11.add(((t) ZeusTransformUtils.preCheckCast(r13.next(), t.class, "com.obric.aiagent.plugin")).a());
        goto L22
    L24:
        new i(r8, r9, null, r10, 0, (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"), r12, null, null, null, this.i, null, null, 7040, null);
        return;
    L5:
        if (r22.a() == o.t) goto L9;
        if (r22.a() == o.j) goto L9;
    }

    private final r b(com.obric.agent.trace.omni.a r53) {
        List r0 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("dispatch_intent_end"), List.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L18;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        Object r5 = r2.next();
        if (ZeusTransformUtils.instanceOf(r5, com.obric.agent.trace.omni.t.class) == false) goto L10;
        com.obric.agent.trace.omni.t r6 = (com.obric.agent.trace.omni.t) ZeusTransformUtils.preCheckCast(r5, com.obric.agent.trace.omni.t.class, "com.obric.aiagent.plugin");
    L11:
        if (r6 == null) goto L6;
        r4.add(r6);
        goto L6
    L10:
        r6 = null;
        goto L11
    L13:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r3.iterator();
    L15:
        if (r8.hasNext() == false) goto L17;
        com.obric.agent.trace.omni.t r9 = (com.obric.agent.trace.omni.t) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.agent.trace.omni.t.class, "com.obric.aiagent.plugin");
        r7.add(new x(r9.a(), r9.b(), r9.c(), r9.e(), r9.h(), r9.f(), r9.g(), r9.d(), r9.i()));
        goto L15
    L17:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
    L19:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("clarify_start"), List.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L27;
        Object r12 = d.a.p.n(r11);
        if (r12 == null) goto L27;
        if (ZeusTransformUtils.instanceOf(r12, com.obric.agent.trace.omni.s.class) == false) goto L27;
    L28:
        com.obric.agent.trace.omni.s r13 = (com.obric.agent.trace.omni.s) ZeusTransformUtils.preCheckCast(r12, com.obric.agent.trace.omni.s.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L47;
        List r14 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("clarify_end"), List.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L38;
        Object r15 = d.a.p.n(r14);
        if (r15 == null) goto L38;
        if (ZeusTransformUtils.instanceOf(r15, com.obric.agent.trace.omni.s.class) == false) goto L38;
    L39:
        com.obric.agent.trace.omni.s r16 = (com.obric.agent.trace.omni.s) ZeusTransformUtils.preCheckCast(r15, com.obric.agent.trace.omni.s.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L42;
    L44:
        List r17 = null;
    L45:
        if (r17 == null) goto L47;
    L48:
        List r42 = r17;
        List r18 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List r19 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("call_user_start"), List.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L78;
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L52:
        if (r20.hasNext() == false) goto L77;
        Object r21 = r20.next();
        if (ZeusTransformUtils.instanceOf(r21, com.obric.agent.trace.omni.r.class) == false) goto L56;
        com.obric.agent.trace.omni.r r22 = (com.obric.agent.trace.omni.r) ZeusTransformUtils.preCheckCast(r21, com.obric.agent.trace.omni.r.class, "com.obric.aiagent.plugin");
    L57:
        if (r22 == null) goto L52;
        List r23 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("call_user_end"), List.class, "com.obric.aiagent.plugin");
        if (r23 == null) goto L61;
        Object r24 = d.a.p.l(r23);
    L63:
        if (ZeusTransformUtils.instanceOf(r24, com.obric.agent.trace.omni.r.class) == false) goto L65;
        com.obric.agent.trace.omni.r r25 = (com.obric.agent.trace.omni.r) ZeusTransformUtils.preCheckCast(r24, com.obric.agent.trace.omni.r.class, "com.obric.aiagent.plugin");
    L66:
        if (r25 != null) goto L68;
    L76:
        d.x r26 = d.x.f38692a;
        d.x r27 = d.x.f38692a;
        goto L52
    L68:
        if (r25.c() <= 0) goto L76;
        if (r25.a() != r22.a()) goto L76;
        if (r22.b() <= 0) goto L74;
        String r110 = "user";
    L75:
        r18.add(new com.obric.agent.trace.a(r110, r22.a(), r22.b(), r25.c(), r25.c() - r22.a()));
        goto L76
    L74:
        r110 = "model";
        goto L75
    L65:
        r25 = null;
        goto L66
    L61:
        r24 = null;
        goto L63
    L56:
        r22 = null;
        goto L57
    L77:
        d.x r28 = d.x.f38692a;
    L78:
        List r29 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("message_send_success"), List.class, "com.obric.aiagent.plugin");
        if (r29 == null) goto L86;
        Object r30 = d.a.p.n(r29);
        if (r30 == null) goto L86;
        if (ZeusTransformUtils.instanceOf(r30, Long.class) == false) goto L86;
    L87:
        Long r31 = (Long) ZeusTransformUtils.preCheckCast(r30, Long.class, "com.obric.aiagent.plugin");
        if (r31 == null) goto L90;
        long r32 = r31.longValue();
    L91:
        List r33 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("task_end"), List.class, "com.obric.aiagent.plugin");
        if (r33 == null) goto L99;
        Object r34 = d.a.p.n(r33);
        if (r34 == null) goto L99;
        if (ZeusTransformUtils.instanceOf(r34, Long.class) == false) goto L99;
    L100:
        Long r35 = (Long) ZeusTransformUtils.preCheckCast(r34, Long.class, "com.obric.aiagent.plugin");
        if (r35 == null) goto L103;
        long r36 = r35.longValue();
    L104:
        long r37 = r36 - r32;
        List r111 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("queueing_start"), List.class, "com.obric.aiagent.plugin");
        if (r111 == null) goto L112;
        Object r112 = d.a.p.n(r111);
        if (r112 == null) goto L112;
        if (ZeusTransformUtils.instanceOf(r112, Long.class) == false) goto L112;
    L113:
        Long r113 = (Long) ZeusTransformUtils.preCheckCast(r112, Long.class, "com.obric.aiagent.plugin");
        if (r113 == null) goto L116;
        long r114 = r113.longValue();
    L117:
        List r115 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("queueing_end"), List.class, "com.obric.aiagent.plugin");
        if (r115 == null) goto L125;
        Object r116 = d.a.p.n(r115);
        if (r116 == null) goto L125;
        if (ZeusTransformUtils.instanceOf(r116, Long.class) == false) goto L125;
    L126:
        Long r117 = (Long) ZeusTransformUtils.preCheckCast(r116, Long.class, "com.obric.aiagent.plugin");
        if (r117 == null) goto L129;
        long r118 = r117.longValue();
    L130:
        long r119 = r118 - r114;
        List r120 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("prepare_end"), List.class, "com.obric.aiagent.plugin");
        if (r120 == null) goto L138;
        Object r121 = d.a.p.n(r120);
        if (r121 == null) goto L138;
        if (ZeusTransformUtils.instanceOf(r121, Long.class) == false) goto L138;
    L139:
        Long r122 = (Long) ZeusTransformUtils.preCheckCast(r121, Long.class, "com.obric.aiagent.plugin");
        if (r122 == null) goto L142;
        long r123 = r122.longValue();
    L143:
        long r124 = r123 - r32;
        List r125 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("prepare_request_server_end"), List.class, "com.obric.aiagent.plugin");
        if (r125 == null) goto L151;
        Object r126 = d.a.p.n(r125);
        if (r126 == null) goto L151;
        if (ZeusTransformUtils.instanceOf(r126, Long.class) == false) goto L151;
    L152:
        Long r127 = (Long) ZeusTransformUtils.preCheckCast(r126, Long.class, "com.obric.aiagent.plugin");
        if (r127 == null) goto L155;
        long r128 = r127.longValue();
    L156:
        long r129 = r128 - r32;
        long r130 = r124 - r129;
        Iterable r38 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r39 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r40 = r38.iterator();
    L158:
        if (r40.hasNext() == false) goto L163;
        Object r131 = r40.next();
        String r41 = ((x) ZeusTransformUtils.preCheckCast(r131, x.class, "com.obric.aiagent.plugin")).b().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r41, "toLowerCase(...)");
        List r43 = r18;
        Iterator r210 = r40;
        if (d.o.o.b(r41, "gui_", false, 2, null) == false) goto L162;
        r39.add(r131);
    L162:
        r40 = r210;
        r18 = r43;
        goto L158
    L163:
        List r44 = r18;
        Iterator r45 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r39, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r211 = 0;
    L165:
        if (r45.hasNext() == false) goto L167;
        r211 = r211 + ((x) ZeusTransformUtils.preCheckCast(r45.next(), x.class, "com.obric.aiagent.plugin")).e();
        goto L165
    L167:
        Iterable r46 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r47 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r48 = r46.iterator();
    L169:
        if (r48.hasNext() == false) goto L180;
        Object r49 = r48.next();
        x r132 = (x) ZeusTransformUtils.preCheckCast(r49, x.class, "com.obric.aiagent.plugin");
        String r50 = r132.b().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r50, "toLowerCase(...)");
        Iterator r212 = r48;
        long r213 = r124;
        if (d.o.o.b(r50, "pc_", false, 2, null) == true) goto L176;
        String r51 = r132.b().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r51, "toLowerCase(...)");
        if (d.o.o.b(r51, "personalcontext_", false, 2, null) == true) goto L176;
        boolean r214 = false;
    L177:
        if (r214 == false) goto L179;
        r47.add(r49);
    L179:
        r48 = r212;
        r124 = r213;
    L176:
        r214 = true;
        goto L177
    L180:
        long r215 = r124;
        String r52 = null;
        Iterator r54 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r47, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r310 = 0;
    L182:
        if (r54.hasNext() == false) goto L184;
        r310 = r310 + ((x) ZeusTransformUtils.preCheckCast(r54.next(), x.class, "com.obric.aiagent.plugin")).e();
        goto L182
    L184:
        Iterator r55 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r311 = 0;
    L186:
        if (r55.hasNext() == false) goto L189;
        r311 = r311 + ((x) ZeusTransformUtils.preCheckCast(r55.next(), x.class, "com.obric.aiagent.plugin")).e();
        goto L186
    L189:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L191;
        long r312 = ((x) ZeusTransformUtils.preCheckCast(d.a.p.m(r10), x.class, "com.obric.aiagent.plugin")).d() - ((x) ZeusTransformUtils.preCheckCast(d.a.p.k(r10), x.class, "com.obric.aiagent.plugin")).c();
    L192:
        x r56 = (x) ZeusTransformUtils.preCheckCast(d.a.p.n(r10), x.class, "com.obric.aiagent.plugin");
        List r57 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("is_interrupted"), List.class, "com.obric.aiagent.plugin");
        if (r57 == null) goto L200;
        Object r58 = d.a.p.n(r57);
        if (r58 == null) goto L200;
        if (ZeusTransformUtils.instanceOf(r58, Boolean.class) == false) goto L200;
    L201:
        boolean r59 = true;
        if (d.h.b.o.a(r58, true) == false) goto L228;
        List r60 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("error_code"), List.class, "com.obric.aiagent.plugin");
        if (r60 == null) goto L211;
        Object r61 = d.a.p.n(r60);
        if (r61 == null) goto L211;
        if (ZeusTransformUtils.instanceOf(r61, String.class) == false) goto L211;
    L212:
        String r62 = (String) ZeusTransformUtils.preCheckCast(r61, String.class, "com.obric.aiagent.plugin");
        if (r62 != null) goto L215;
        r62 = "-1";
    L215:
        List r133 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("finish_reason"), List.class, "com.obric.aiagent.plugin");
        if (r133 == null) goto L223;
        Object r134 = d.a.p.n(r133);
        if (r134 == null) goto L223;
        if (ZeusTransformUtils.instanceOf(r134, String.class) == false) goto L223;
    L224:
        String r135 = (String) ZeusTransformUtils.preCheckCast(r134, String.class, "com.obric.aiagent.plugin");
        if (r135 != null) goto L227;
        r135 = "interrupted";
    L227:
        d.m r63 = new d.m(r62, r135);
    L229:
        String r313 = (String) ZeusTransformUtils.preCheckCast(r63.c(), String.class, "com.obric.aiagent.plugin");
        String r410 = (String) ZeusTransformUtils.preCheckCast(r63.d(), String.class, "com.obric.aiagent.plugin");
        List r64 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("o_omni_track"), List.class, "com.obric.aiagent.plugin");
        if (r64 == null) goto L237;
        Object r65 = d.a.p.n(r64);
        if (r65 == null) goto L237;
        if (ZeusTransformUtils.instanceOf(r65, String.class) == false) goto L237;
    L238:
        String r66 = (String) ZeusTransformUtils.preCheckCast(r65, String.class, "com.obric.aiagent.plugin");
        if (r66 == null) goto L241;
        int r314 = new JSONObject(r66).optInt("server_tool_count", 0);
    L242:
        List r67 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("o_omni_track"), List.class, "com.obric.aiagent.plugin");
        if (r67 == null) goto L250;
        Object r68 = d.a.p.n(r67);
        if (r68 == null) goto L250;
        if (ZeusTransformUtils.instanceOf(r68, String.class) == false) goto L250;
    L251:
        String r69 = (String) ZeusTransformUtils.preCheckCast(r68, String.class, "com.obric.aiagent.plugin");
        if (r69 == null) goto L254;
        long r136 = 0;
        long r315 = new JSONObject(r69).optLong("server_tool_duration", 0);
    L255:
        List r70 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("instruction_id"), List.class, "com.obric.aiagent.plugin");
        if (r70 == null) goto L265;
        Object r71 = d.a.p.n(r70);
        if (r71 == null) goto L265;
        if (r71 == null) goto L262;
        boolean r72 = ZeusTransformUtils.instanceOf(r71, String.class);
    L263:
        if (r72 == false) goto L265;
    L266:
        String r73 = (String) ZeusTransformUtils.preCheckCast(r71, String.class, "com.obric.aiagent.plugin");
        List r74 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("instruction_type"), List.class, "com.obric.aiagent.plugin");
        if (r74 == null) goto L276;
        Object r75 = d.a.p.n(r74);
        if (r75 == null) goto L276;
        if (r75 == null) goto L273;
        boolean r137 = ZeusTransformUtils.instanceOf(r75, String.class);
    L274:
        if (r137 == false) goto L276;
    L277:
        String r76 = (String) ZeusTransformUtils.preCheckCast(r75, String.class, "com.obric.aiagent.plugin");
        List r138 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("instruction_entry"), List.class, "com.obric.aiagent.plugin");
        if (r138 == null) goto L286;
        Object r139 = d.a.p.n(r138);
        if (r139 == null) goto L286;
        if (r139 == null) goto L284;
        r59 = ZeusTransformUtils.instanceOf(r139, String.class);
    L284:
        if (r59 == false) goto L286;
    L287:
        String r140 = (String) ZeusTransformUtils.preCheckCast(r139, String.class, "com.obric.aiagent.plugin");
        long r216 = r37 - r119;
        long r411 = r311 + r315;
        int r412 = r10.size() + r314;
        if (r56 == null) goto L293;
        String r141 = r56.b();
        if (r141 == null) goto L293;
        String r413 = r141;
    L294:
        if (r56 == null) goto L299;
        String r142 = r56.f();
        if (r142 == null) goto L299;
        String r414 = r142;
    L300:
        if (r56 == null) goto L302;
        r136 = r56.e();
    L302:
        long r415 = r136;
        if (r56 == null) goto L308;
        String r77 = r56.a();
        if (r77 == null) goto L308;
        String r510 = r77;
    L309:
        List r78 = (List) ZeusTransformUtils.preCheckCast(r53.b().get("dispatch_intent_end"), List.class, "com.obric.aiagent.plugin");
        if (r78 == null) goto L317;
        Object r79 = d.a.p.n(r78);
        if (r79 == null) goto L317;
        if (ZeusTransformUtils.instanceOf(r79, com.obric.agent.trace.omni.t.class) == false) goto L317;
    L318:
        com.obric.agent.trace.omni.t r80 = (com.obric.agent.trace.omni.t) ZeusTransformUtils.preCheckCast(r79, com.obric.agent.trace.omni.t.class, "com.obric.aiagent.plugin");
        if (r80 == null) goto L322;
        r52 = r80.i();
    L322:
        return new r(r73, r76, r140, r37, r216, r119, r215, r129, r130, r211, r310, r312, r311, r411, r412, r314, r315, r413, r414, r415, r510, r313, r410, r10, r42, r44, r52);
    L317:
        r79 = null;
    L308:
        r510 = "";
    L299:
        r414 = "";
    L293:
        r413 = "";
    L286:
        r139 = null;
        goto L287
    L273:
        r137 = true;
    L276:
        r75 = null;
        goto L277
    L262:
        r72 = true;
    L265:
        r71 = null;
        goto L266
    L254:
        r136 = 0;
        r315 = 0;
    L250:
        r68 = null;
        goto L251
    L241:
        r314 = 0;
    L237:
        r65 = null;
    L223:
        r134 = null;
    L211:
        r61 = null;
        goto L212
    L228:
        r63 = new d.m("0", "success");
    L200:
        r58 = null;
        goto L201
    L191:
        r312 = 0;
        goto L192
    L155:
        r128 = 0;
    L151:
        r126 = null;
        goto L152
    L142:
        r123 = 0;
    L138:
        r121 = null;
        goto L139
    L129:
        r118 = 0;
    L125:
        r116 = null;
        goto L126
    L116:
        r114 = 0;
    L112:
        r112 = null;
        goto L113
    L103:
        r36 = 0;
    L99:
        r34 = null;
        goto L100
    L90:
        r32 = 0;
    L86:
        r30 = null;
        goto L87
    L42:
        if (r16.b() <= 0) goto L44;
        r17 = d.a.p.a(new b(r13.a(), r16.b(), r16.b() - r13.a()));
    L38:
        r15 = null;
    L47:
        r17 = d.a.p.b();
    L27:
        r12 = null;
        goto L28
    L18:
        r10 = d.a.p.b();
        goto L19
    }

    private final r a(com.obric.agent.trace.omni.a r46, Map<String, String> r47) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r47, Map.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.preCheckCast(r46.b().get("dispatch_intent_end"), List.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L18;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L13;
        Object r6 = r4.next();
        if (ZeusTransformUtils.instanceOf(r6, com.obric.agent.trace.omni.t.class) == false) goto L10;
        com.obric.agent.trace.omni.t r7 = (com.obric.agent.trace.omni.t) ZeusTransformUtils.preCheckCast(r6, com.obric.agent.trace.omni.t.class, "com.obric.aiagent.plugin");
    L11:
        if (r7 == null) goto L6;
        r5.add(r7);
        goto L6
    L10:
        r7 = null;
        goto L11
    L13:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r8.iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        com.obric.agent.trace.omni.t r11 = (com.obric.agent.trace.omni.t) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.agent.trace.omni.t.class, "com.obric.aiagent.plugin");
        r9.add(new x(r11.a(), r11.b(), r11.c(), r11.e(), r11.h(), r11.f(), r11.g(), r11.d(), r11.i()));
        goto L15
    L17:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
    L19:
        List r41 = r12;
        List r13 = (List) ZeusTransformUtils.preCheckCast(r46.b().get("clarify_start"), List.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L27;
        Object r14 = d.a.p.n(r13);
        if (r14 == null) goto L27;
        if (ZeusTransformUtils.instanceOf(r14, com.obric.agent.trace.omni.s.class) == false) goto L27;
    L28:
        com.obric.agent.trace.omni.s r15 = (com.obric.agent.trace.omni.s) ZeusTransformUtils.preCheckCast(r14, com.obric.agent.trace.omni.s.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L47;
        List r16 = (List) ZeusTransformUtils.preCheckCast(r46.b().get("clarify_end"), List.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L38;
        Object r17 = d.a.p.n(r16);
        if (r17 == null) goto L38;
        if (ZeusTransformUtils.instanceOf(r17, com.obric.agent.trace.omni.s.class) == false) goto L38;
    L39:
        com.obric.agent.trace.omni.s r18 = (com.obric.agent.trace.omni.s) ZeusTransformUtils.preCheckCast(r17, com.obric.agent.trace.omni.s.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L42;
    L44:
        List r19 = null;
    L45:
        if (r19 == null) goto L47;
    L48:
        List r42 = r19;
        List r20 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List r21 = (List) ZeusTransformUtils.preCheckCast(r46.b().get("call_user_start"), List.class, "com.obric.aiagent.plugin");
        if (r21 == null) goto L78;
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L52:
        if (r22.hasNext() == false) goto L77;
        Object r23 = r22.next();
        if (ZeusTransformUtils.instanceOf(r23, com.obric.agent.trace.omni.r.class) == false) goto L56;
        com.obric.agent.trace.omni.r r24 = (com.obric.agent.trace.omni.r) ZeusTransformUtils.preCheckCast(r23, com.obric.agent.trace.omni.r.class, "com.obric.aiagent.plugin");
    L57:
        if (r24 == null) goto L52;
        List r25 = (List) ZeusTransformUtils.preCheckCast(r46.b().get("call_user_end"), List.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L61;
        Object r26 = d.a.p.l(r25);
    L63:
        if (ZeusTransformUtils.instanceOf(r26, com.obric.agent.trace.omni.r.class) == false) goto L65;
        com.obric.agent.trace.omni.r r27 = (com.obric.agent.trace.omni.r) ZeusTransformUtils.preCheckCast(r26, com.obric.agent.trace.omni.r.class, "com.obric.aiagent.plugin");
    L66:
        if (r27 != null) goto L68;
    L76:
        d.x r28 = d.x.f38692a;
        d.x r29 = d.x.f38692a;
        goto L52
    L68:
        if (r27.c() <= 0) goto L76;
        if (r27.a() != r24.a()) goto L76;
        if (r24.b() <= 0) goto L74;
        String r110 = "user";
    L75:
        r20.add(new com.obric.agent.trace.a(r110, r24.a(), r24.b(), r27.c(), r27.c() - r24.a()));
        goto L76
    L74:
        r110 = "model";
        goto L75
    L65:
        r27 = null;
        goto L66
    L61:
        r26 = null;
        goto L63
    L56:
        r24 = null;
        goto L57
    L77:
        d.x r30 = d.x.f38692a;
    L78:
        x r31 = (x) ZeusTransformUtils.preCheckCast(d.a.p.n(r41), x.class, "com.obric.aiagent.plugin");
        List r32 = (List) ZeusTransformUtils.preCheckCast(r46.b().get("instruction_id"), List.class, "com.obric.aiagent.plugin");
        boolean r33 = true;
        if (r32 == null) goto L88;
        Object r34 = d.a.p.n(r32);
        if (r34 == null) goto L88;
        if (r34 == null) goto L85;
        boolean r35 = ZeusTransformUtils.instanceOf(r34, String.class);
    L86:
        if (r35 == false) goto L88;
    L89:
        String r36 = (String) ZeusTransformUtils.preCheckCast(r34, String.class, "com.obric.aiagent.plugin");
        List r37 = (List) ZeusTransformUtils.preCheckCast(r46.b().get("instruction_type"), List.class, "com.obric.aiagent.plugin");
        if (r37 == null) goto L99;
        Object r38 = d.a.p.n(r37);
        if (r38 == null) goto L99;
        if (r38 == null) goto L96;
        boolean r39 = ZeusTransformUtils.instanceOf(r38, String.class);
    L97:
        if (r39 == false) goto L99;
    L100:
        String r40 = (String) ZeusTransformUtils.preCheckCast(r38, String.class, "com.obric.aiagent.plugin");
        List r43 = (List) ZeusTransformUtils.preCheckCast(r46.b().get("instruction_entry"), List.class, "com.obric.aiagent.plugin");
        if (r43 == null) goto L109;
        Object r44 = d.a.p.n(r43);
        if (r44 == null) goto L109;
        if (r44 == null) goto L107;
        r33 = ZeusTransformUtils.instanceOf(r44, String.class);
    L107:
        if (r33 == false) goto L109;
    L110:
        String r45 = (String) ZeusTransformUtils.preCheckCast(r44, String.class, "com.obric.aiagent.plugin");
        String r48 = (String) ZeusTransformUtils.preCheckCast(r0.get("all_duration"), String.class, "com.obric.aiagent.plugin");
        if (r48 == null) goto L115;
        Long r49 = d.o.o.e(r48);
        if (r49 == null) goto L115;
        long r50 = r49.longValue();
    L116:
        String r111 = (String) ZeusTransformUtils.preCheckCast(r0.get("all_duration_exclude_wait_queue"), String.class, "com.obric.aiagent.plugin");
        if (r111 == null) goto L121;
        Long r112 = d.o.o.e(r111);
        if (r112 == null) goto L121;
        long r113 = r112.longValue();
    L122:
        String r114 = (String) ZeusTransformUtils.preCheckCast(r0.get("wait_queue_duration"), String.class, "com.obric.aiagent.plugin");
        if (r114 == null) goto L127;
        Long r115 = d.o.o.e(r114);
        if (r115 == null) goto L127;
        long r116 = r115.longValue();
    L128:
        String r51 = (String) ZeusTransformUtils.preCheckCast(r0.get("prepare_duration"), String.class, "com.obric.aiagent.plugin");
        if (r51 == null) goto L133;
        Long r52 = d.o.o.e(r51);
        if (r52 == null) goto L133;
        long r117 = r52.longValue();
    L134:
        String r53 = (String) ZeusTransformUtils.preCheckCast(r0.get("prepare_server_duration"), String.class, "com.obric.aiagent.plugin");
        if (r53 == null) goto L139;
        Long r54 = d.o.o.e(r53);
        if (r54 == null) goto L139;
        long r210 = r54.longValue();
    L140:
        String r55 = (String) ZeusTransformUtils.preCheckCast(r0.get("prepare_client_duration"), String.class, "com.obric.aiagent.plugin");
        if (r55 == null) goto L145;
        Long r56 = d.o.o.e(r55);
        if (r56 == null) goto L145;
        long r211 = r56.longValue();
    L146:
        String r57 = (String) ZeusTransformUtils.preCheckCast(r0.get("gui_exec_all_duration"), String.class, "com.obric.aiagent.plugin");
        if (r57 == null) goto L151;
        Long r58 = d.o.o.e(r57);
        if (r58 == null) goto L151;
        long r212 = r58.longValue();
    L152:
        String r59 = (String) ZeusTransformUtils.preCheckCast(r0.get("memory_exec_all_duration"), String.class, "com.obric.aiagent.plugin");
        if (r59 == null) goto L157;
        Long r60 = d.o.o.e(r59);
        if (r60 == null) goto L157;
        long r213 = r60.longValue();
    L158:
        String r61 = (String) ZeusTransformUtils.preCheckCast(r0.get("tool_exec_stage_duration"), String.class, "com.obric.aiagent.plugin");
        if (r61 == null) goto L163;
        Long r62 = d.o.o.e(r61);
        if (r62 == null) goto L163;
        long r214 = r62.longValue();
    L164:
        String r63 = (String) ZeusTransformUtils.preCheckCast(r0.get("client_tool_duration"), String.class, "com.obric.aiagent.plugin");
        if (r63 == null) goto L169;
        Long r64 = d.o.o.e(r63);
        if (r64 == null) goto L169;
        long r310 = r64.longValue();
    L170:
        String r65 = (String) ZeusTransformUtils.preCheckCast(r0.get("tool_all_exec_duration"), String.class, "com.obric.aiagent.plugin");
        if (r65 == null) goto L175;
        Long r66 = d.o.o.e(r65);
        if (r66 == null) goto L175;
        long r311 = r66.longValue();
    L176:
        int r67 = r41.size();
        String r68 = (String) ZeusTransformUtils.preCheckCast(r0.get("server_tool_count"), String.class, "com.obric.aiagent.plugin");
        if (r68 == null) goto L181;
        Integer r69 = d.o.o.d(r68);
        if (r69 == null) goto L181;
        int r70 = r69.intValue();
    L182:
        int r71 = r70 + r67;
        String r72 = (String) ZeusTransformUtils.preCheckCast(r0.get("server_tool_count"), String.class, "com.obric.aiagent.plugin");
        if (r72 == null) goto L187;
        Integer r73 = d.o.o.d(r72);
        if (r73 == null) goto L187;
        int r312 = r73.intValue();
    L188:
        String r74 = (String) ZeusTransformUtils.preCheckCast(r0.get("server_tool_duration"), String.class, "com.obric.aiagent.plugin");
        if (r74 == null) goto L193;
        Long r75 = d.o.o.e(r74);
        if (r75 == null) goto L193;
        long r313 = r75.longValue();
    L194:
        String r76 = (String) ZeusTransformUtils.preCheckCast(r0.get("last_tool_name"), String.class, "com.obric.aiagent.plugin");
        if (r76 != null) goto L197;
        String r314 = "";
    L198:
        String r77 = (String) ZeusTransformUtils.preCheckCast(r0.get("last_tool_args"), String.class, "com.obric.aiagent.plugin");
        if (r77 != null) goto L201;
        String r315 = "";
    L202:
        String r78 = (String) ZeusTransformUtils.preCheckCast(r0.get("last_tool_duration"), String.class, "com.obric.aiagent.plugin");
        if (r78 == null) goto L207;
        Long r79 = d.o.o.e(r78);
        if (r79 == null) goto L207;
        long r316 = r79.longValue();
    L208:
        String r80 = (String) ZeusTransformUtils.preCheckCast(r0.get("last_tool_id"), String.class, "com.obric.aiagent.plugin");
        if (r80 != null) goto L211;
        String r410 = "";
    L212:
        List r81 = (List) ZeusTransformUtils.preCheckCast(r46.b().get("dispatch_intent_end"), List.class, "com.obric.aiagent.plugin");
        if (r81 == null) goto L220;
        Object r82 = d.a.p.n(r81);
        if (r82 == null) goto L220;
        if (ZeusTransformUtils.instanceOf(r82, com.obric.agent.trace.omni.t.class) == false) goto L220;
    L221:
        com.obric.agent.trace.omni.t r83 = (com.obric.agent.trace.omni.t) ZeusTransformUtils.preCheckCast(r82, com.obric.agent.trace.omni.t.class, "com.obric.aiagent.plugin");
        if (r83 == null) goto L224;
        String r411 = r83.i();
    L225:
        String r84 = (String) ZeusTransformUtils.preCheckCast(r0.get("error_code"), String.class, "com.obric.aiagent.plugin");
        if (r84 != null) goto L228;
        r84 = "";
    L228:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("finish_reason"), String.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L232;
        r1 = "";
    L232:
        return new r(r36, r40, r45, r50, r113, r116, r117, r210, r211, r212, r213, r214, r310, r311, r71, r312, r313, r314, r315, r316, r410, r84, r1, r41, r42, r20, r411);
    L224:
        r411 = null;
    L220:
        r82 = null;
        goto L221
    L211:
        r410 = r80;
    L207:
        r316 = 0;
        goto L208
    L201:
        r315 = r77;
        goto L202
    L197:
        r314 = r76;
    L193:
        r313 = 0;
    L187:
        r312 = 0;
    L181:
        r70 = 0;
    L175:
        r311 = 0;
    L169:
        r310 = 0;
    L163:
        r214 = 0;
    L157:
        r213 = 0;
    L151:
        r212 = 0;
    L145:
        r211 = 0;
    L139:
        r210 = 0;
    L133:
        r117 = 0;
    L127:
        r116 = 0;
    L121:
        r113 = 0;
    L115:
        r50 = 0;
    L109:
        r44 = null;
        goto L110
    L96:
        r39 = true;
    L99:
        r38 = null;
        goto L100
    L85:
        r35 = true;
    L88:
        r34 = null;
        goto L89
    L42:
        if (r18.b() <= 0) goto L44;
        r19 = d.a.p.a(new b(r15.a(), r18.b(), r18.b() - r15.a()));
    L38:
        r17 = null;
    L47:
        r19 = d.a.p.b();
    L27:
        r14 = null;
        goto L28
    L18:
        r12 = d.a.p.b();
        goto L19
    }

    public final void g(String r11) {
        d.h.b.o.e(r11, "reason");
        long r7 = SystemClock.elapsedRealtime();
        t r12 = (t) ZeusTransformUtils.preCheckCast(d.a.p.n((List) ZeusTransformUtils.preCheckCast(this.f15491d, List.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L5;
    L7:
        this.f15491d.add(new t(o.z, (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin"), r7, true));
        t r13 = (t) ZeusTransformUtils.preCheckCast(d.a.p.n((List) ZeusTransformUtils.preCheckCast(this.f15491d, List.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L13;
        Map<String, Object> r14 = r13.b();
        if (r14 == null) goto L13;
        r14.put("endTime", Long.valueOf(r7));
    L13:
        if (this.o != 0) goto L15;
        this.o = r7;
    L15:
        a((this.o - this.g) + this.p, true);
        return;
    L5:
        if (r12.d() == true) goto L7;
        a(r12);
        goto L7
    }
}
