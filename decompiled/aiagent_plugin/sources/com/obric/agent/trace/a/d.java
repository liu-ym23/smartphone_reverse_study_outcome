package com.obric.agent.trace.a;

import android.content.Context;
import android.view.View;
import androidx.core.provider.FontsContractCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import com.obric.agent.trace.n;
import com.obric.agent.trace.q;
import com.obric.agent.trace.s;
import com.obric.agent.trace.u;
import com.obric.agent.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IntentDebugPanel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.agent.c.a f15424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<x> f15425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f15426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f15427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<com.obric.agent.trace.i> f15428e;
    private final a f;

    /* JADX INFO: compiled from: IntentDebugPanel.kt */
    public static final class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f15429a;

        public static /* synthetic */ void lambda$tjuwdnWQwuaqJoyvk6oLPbWnIWk(d r0) {
            a(r0);
        }

        a(d r1) {
            this.f15429a = r1;
        }

        @Override // com.obric.agent.trace.s
        public void a(List<com.obric.agent.trace.i> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            o.e(r7, "list");
            d.a(this.f15429a, r7);
            f r0 = d.a(this.f15429a);
            List r2 = d.a(this.f15429a, r7, 0);
            final d r3 = this.f15429a;
            r0.a(r2, new $$Lambda$d$a$tjuwdnWQwuaqJoyvk6oLPbWnIWk(r3));
            com.obric.agent.trace.i r8 = (com.obric.agent.trace.i) ZeusTransformUtils.preCheckCast(p.l(r7), com.obric.agent.trace.i.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L6;
            d.a(this.f15429a, r8);
            return;
        }

        private static final void a(d r1) {
            d.b(r1).f14253c.scrollToPosition(0);
        }
    }

    public static /* synthetic */ void lambda$ApNO0EXYoodOaOCH1XUkvNzb06k(d r0, List r1) {
        b(r0, r1);
    }

    public static /* synthetic */ void lambda$BLsWlDRKtpcFMY0tzphAg4opeho(d r0) {
        c(r0);
    }

    public static /* synthetic */ CharSequence lambda$HDnJK3mTEnZlu4SHozKkIlvmZoI(com.obric.agent.trace.o r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$l8_561ptzBiPLIPHtFm_c-1K4qg, reason: not valid java name */
    public static /* synthetic */ void m103lambda$l8_561ptzBiPLIPHtFm_c1K4qg(d r0, View r1) {
        a(r0, r1);
    }

    public d(com.obric.agent.c.a r3, d.h.a.a<x> r4) {
        d.h.a.a<x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "panel");
        this.f15424a = r3;
        this.f15425b = r5;
        this.f15426c = new f();
        this.f15427d = new e();
        this.f = new a(this);
    }

    public static final /* synthetic */ f a(d r0) {
        return r0.f15426c;
    }

    public static final /* synthetic */ List a(d r2, List r3, int r4) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ void a(d r0, com.obric.agent.trace.i r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void a(d r2, List r3) {
        r2.f15428e = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ com.obric.agent.c.a b(d r0) {
        return r0.f15424a;
    }

    public final void a() {
        this.f15424a.f14251a.setOnClickListener(new $$Lambda$d$l8_561ptzBiPLIPHtFm_c1K4qg(this));
        this.f15424a.f14253c.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f15424a.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        this.f15424a.f14253c.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(this.f15426c, RecyclerView.a.class, "com.obric.aiagent.plugin"));
        k r0 = new k((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f15424a.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1);
        this.f15424a.f14253c.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(r0, RecyclerView.g.class, "com.obric.aiagent.plugin"));
        q.f15713a.a((s) ZeusTransformUtils.preCheckCast(this.f, s.class, "com.obric.aiagent.plugin"));
        this.f15426c.a((i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin"));
        List<com.obric.agent.trace.i> r1 = q.f15713a.c();
        this.f15426c.a(a(r1, 0));
        this.f15428e = r1;
        if (r1 == null) goto L7;
        com.obric.agent.trace.i r2 = (com.obric.agent.trace.i) ZeusTransformUtils.preCheckCast(p.l(r1), com.obric.agent.trace.i.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        b(r2);
    L7:
        this.f15424a.f14252b.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f15424a.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        this.f15424a.f14252b.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(this.f15427d, RecyclerView.a.class, "com.obric.aiagent.plugin"));
        this.f15424a.f14252b.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(r0, RecyclerView.g.class, "com.obric.aiagent.plugin"));
    }

    private static final void a(d r2, View r3) {
        d.h.a.a<x> r4 = r2.f15425b;
        if (r4 == null) goto L5;
        r4.invoke();
    L5:
        q.f15713a.b((s) ZeusTransformUtils.preCheckCast(r2.f, s.class, "com.obric.aiagent.plugin"));
    }

    private final List<j> a(List<com.obric.agent.trace.i> r7, int r8) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r6, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r6.iterator();
        int r2 = 0;
    L4:
        if (r10.hasNext() == false) goto L14;
        Object r3 = r10.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        p.c();
    L8:
        String r5 = ((com.obric.agent.trace.i) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.trace.i.class, "com.obric.aiagent.plugin")).a();
        if (r2 != r8) goto L11;
        boolean r11 = true;
    L12:
        r9.add(new j(r5, r4, r11));
        r2 = r4;
        goto L4
    L11:
        r11 = false;
        goto L12
    L14:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
    }

    private final List<c> a(com.obric.agent.trace.i r27) {
        List<c> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        StringBuilder r3 = new StringBuilder();
        if (o.a(r27.i(), "VOICE") == false) goto L5;
        String r4 = "语音";
    L6:
        StringBuilder r5 = r3.append(r4).append("输入: ").append(r27.a());
        String r6 = "";
        if (w.a(r27.b()) == false) goto L9;
        String r7 = "\n改写后: " + r27.b();
    L10:
        String r8 = r5.append(r7).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r27.a(), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L13;
        boolean r9 = true;
    L14:
        r0.add(new c(r8, r9));
        StringBuilder r10 = new StringBuilder().append("状态: ");
        com.obric.agent.trace.f r11 = r27.d();
        if (r11 == null) goto L17;
        n r12 = r11.a();
    L18:
        StringBuilder r13 = r10.append(r12).append("\n结果反馈: ");
        com.obric.agent.trace.f r14 = r27.d();
        if (r14 == null) goto L21;
        String r15 = r14.b();
    L22:
        String r16 = r13.append(r15).append("\n执行完成时间: ").append(r27.c()).toString();
        com.obric.agent.trace.f r17 = r27.d();
        if (r17 == null) goto L25;
        n r18 = r17.a();
    L27:
        if (r18 != n.f15582a) goto L29;
        boolean r19 = true;
    L30:
        r0.add(new c(r16, r19));
        String r1 = r27.j();
        if (r1 == null) goto L33;
        r0.add(new c("logid: " + r1, false, 2, null));
    L33:
        String r2 = r27.k();
        if (r2 == null) goto L36;
        r0.add(new c("localMsgId: " + r2, false, 2, null));
    L36:
        List<u> r20 = r27.g();
        if (r20 == null) goto L56;
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.aiagent.plugin");
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r23 = r21.iterator();
    L40:
        if (r23.hasNext() == false) goto L52;
        Object r110 = r23.next();
        u r111 = (u) ZeusTransformUtils.preCheckCast(r110, u.class, "com.obric.aiagent.plugin");
        if (r111.a() != com.obric.agent.trace.o.o) goto L44;
    L49:
        boolean r112 = true;
    L50:
        if (r112 == false) goto L40;
        r22.add(r110);
        goto L40
    L44:
        if (r111.a() == com.obric.agent.trace.o.p) goto L49;
        if (r111.a() == com.obric.agent.trace.o.q) goto L49;
        r112 = false;
        goto L50
    L52:
        Iterator r24 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        long r113 = 0;
    L54:
        if (r24.hasNext() == false) goto L57;
        r113 = r113 + ((u) ZeusTransformUtils.preCheckCast(r24.next(), u.class, "com.obric.aiagent.plugin")).b();
    L57:
        String r25 = "总耗时: " + (r27.e() - r113) + "ms";
        u r114 = r27.a(com.obric.agent.trace.o.f15588b);
        String r115 = ")";
        if (r114 == null) goto L63;
        StringBuilder r26 = new StringBuilder().append(r25 + "(ASR: " + r114.b() + "ms");
        if (r113 == 0) goto L62;
        r115 = ", 未包含DM等待时间)";
    L62:
        String r28 = r26.append(r115).toString();
    L74:
        if ((r27.e() - r113) > 10000) goto L76;
        boolean r29 = true;
    L77:
        r0.add(new c(r28, r29));
        r0.add(new c("所经历阶段: \n" + p.a((Iterable) ZeusTransformUtils.preCheckCast(r27.f(), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("-->", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$d$HDnJK3mTEnZlu4SHozKkIlvmZoI.INSTANCE, 30, null), false, 2, null));
        List<u> r30 = r27.g();
        if (r30 == null) goto L124;
        Iterator r31 = ((Iterable) ZeusTransformUtils.preCheckCast(r30, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L81:
        if (r31.hasNext() == false) goto L124;
        u r32 = (u) ZeusTransformUtils.preCheckCast(r31.next(), u.class, "com.obric.aiagent.plugin");
        StringBuilder r33 = new StringBuilder().append("阶段：");
        com.obric.agent.trace.o r34 = r32.a();
        if (r34 == null) goto L85;
        String r35 = r34.a();
    L86:
        String r36 = r33.append(r35).toString();
        if (r32.b() <= 0) goto L89;
        r36 = r36 + "\n耗时：" + r32.b() + "ms";
    L89:
        Map<String, Object> r37 = r32.c();
        if (r37 != null) goto L92;
    L95:
        boolean r38 = true;
    L96:
        if (r38 == true) goto L110;
        r36 = r36 + "\n参数：";
        Map<String, Object> r39 = r32.c();
        if (r39 == null) goto L110;
        Iterator<Map.Entry<String, Object>> r40 = r39.entrySet().iterator();
    L101:
        if (r40.hasNext() == false) goto L110;
        Map.Entry r41 = (Map.Entry) ZeusTransformUtils.preCheckCast(r40.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r116 = (String) ZeusTransformUtils.preCheckCast(r41.getKey(), String.class, "com.obric.aiagent.plugin");
        Object r42 = r41.getValue();
        if (o.a(r116, FontsContractCompat.Columns.RESULT_CODE) == true) goto L105;
        r36 = r36 + '\n' + r116 + '=' + r42;
        goto L101
    L105:
        if (o.a(r42, 0) == true) goto L101;
        if (o.a(r42, Double.valueOf(0.0d)) == true) goto L101;
        r36 = r36 + '\n' + r116 + '=' + r42;
    L110:
        long r117 = r32.b();
        com.obric.agent.trace.o r43 = r32.a();
        if (r43 == null) goto L113;
        Long r44 = Long.valueOf(r43.b());
    L114:
        o.a(r44);
        if (r117 > r44.longValue()) goto L122;
        Map<String, Object> r45 = r32.c();
        if (r45 == null) goto L119;
        Object r46 = r45.get("error_msg");
    L120:
        if (r46 != null) goto L122;
        boolean r47 = true;
    L123:
        r0.add(new c(r36, r47));
        goto L81
    L119:
        r46 = null;
    L122:
        r47 = false;
        goto L123
    L113:
        r44 = null;
        goto L114
    L92:
        if (r37.isEmpty() == true) goto L95;
        r38 = false;
        goto L96
    L85:
        r35 = null;
    L124:
        return r0;
    L76:
        r29 = false;
        goto L77
    L63:
        d r48 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        if (o.a(r27.i(), "VOICE") == false) goto L69;
        StringBuilder r49 = new StringBuilder().append(r25 + "(未包含ASR耗时");
        if (r113 == 0) goto L68;
        r115 = "和DM等待时间)";
    L68:
        r28 = r49.append(r115).toString();
        goto L74
    L69:
        StringBuilder r50 = new StringBuilder().append(r25);
        if (r113 == 0) goto L72;
        r6 = "(未包含DM等待时间)";
    L72:
        r28 = r50.append(r6).toString();
        goto L74
    L56:
        r113 = 0;
        goto L57
    L29:
        r19 = false;
        goto L30
    L25:
        r18 = null;
        goto L27
    L21:
        r15 = null;
        goto L22
    L17:
        r12 = null;
        goto L18
    L13:
        r9 = false;
        goto L14
    L9:
        r7 = "";
        goto L10
    L5:
        r4 = "文本";
        goto L6
    }

    private static final CharSequence a(com.obric.agent.trace.o r2) {
        o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.agent.trace.p.a(r2), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final void b(com.obric.agent.trace.i r3) {
        final List<c> r4 = a(r3);
        com.obric.agent.utils.q.f16060a.a(new $$Lambda$d$ApNO0EXYoodOaOCH1XUkvNzb06k(this, r4));
    }

    private static final void b(final d r2, List r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        r2.f15427d.a(r4, new $$Lambda$d$BLsWlDRKtpcFMY0tzphAg4opeho(r2));
    }

    private static final void c(d r1) {
        r1.f15424a.f14252b.scrollToPosition(0);
    }
}
