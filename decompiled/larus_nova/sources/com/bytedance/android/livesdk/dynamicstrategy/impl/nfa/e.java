package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import com.bytedance.android.livesdk.dynamicstrategy.api.entity.s;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.t;
import com.bytedance.android.livesdk.dynamicstrategy.impl.AbsDynamicStrategyContext;
import com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner;
import com.bytedance.android.livesdk.log.k0;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements g, j, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<a> f123224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f123225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f123226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f123227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f123228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f123229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<g.a> f123230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f123231h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final s f123232i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f123233j;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g
    public final List<String> g() {
        if (this.f123227d == true) goto L5;
        LinkedHashSet r100 = new LinkedHashSet();
        Iterator<T> r101 = this.f123224a.iterator();
    L8:
        if (r101.hasNext() == false) goto L27;
        a r102 = (a) r101.next();
        d r103 = r102.f123211e;
        if (r103 == null) goto L8;
        t r104 = r103.f123219f;
        if (r104 == null) goto L8;
        List<String> r105 = r104.b();
        if (r105 == null) goto L8;
        if (r102.f123212f <= (-1)) goto L20;
        boolean r106 = true;
        if ((!r105.isEmpty()) == false) goto L20;
    L21:
        if (r106 == true) goto L24;
        r105 = null;
    L24:
        if (r105 == null) goto L8;
        r100.addAll(r105);
    L20:
        r106 = false;
        goto L21
    L27:
        return CollectionsKt.toList(r100);
    L5:
        return new ArrayList();
    }

    public final List<String> h() {
        if (this.f123227d == true) goto L5;
        List<t> r100 = this.f123232i.b();
        if (r100 == null) goto L13;
        t r101 = (t) CollectionsKt.getOrNull(r100, 0);
        if (r101 == null) goto L13;
        List<String> r102 = r101.b();
        if (r102 == null) goto L13;
        return r102;
    L13:
        return new ArrayList();
    L5:
        return new ArrayList();
    }

    public final List<String> i() {
        if (this.f123227d == true) goto L9;
        List<String> r100 = this.f123232i.a();
        if (r100 == null) goto L8;
        return r100;
    L8:
        return new ArrayList();
    L9:
        return new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g
    public final boolean b() {
        return this.f123229f;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g
    public final String e() {
        return this.f123231h;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.j
    public final void a(final long r110) {
        final String r100 = "Nfa Time Out";
        final long r101 = 0;
        if (r110 <= 0) goto L5;
        CollectionsKt.removeAll(this.f123224a, new EventCepNfa$finishFollow$2(this, r110, r101, r100));
    L5:
        h r111 = this.f123226c;
        if (r111 == null) goto L9;
        r111.b(this.f123231h);
        r111.d(this.f123231h);
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g
    public final void c(g.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f123230g.remove(r100);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g
    public final void f(AbsDynamicStrategyContext.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f123230g.add(r100);
    }

    public final void l(com.bytedance.android.livesdk.dynamicstrategy.api.entity.a r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        int r101 = b.f123213a;
        String r102 = this.f123233j;
        String r103 = this.f123231h;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.f r104 = r100.boolNode;
        boolean r105 = false;
        if (r104 == null) goto L7;
        Boolean r106 = r104.value;
        if (r106 == null) goto L7;
        boolean r107 = r106.booleanValue();
    L8:
        Intrinsics.checkNotNullParameter(r102, "roomId");
        Intrinsics.checkNotNullParameter(r103, "name");
        b.b("StrategyCepNfa_result", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("room_id", r102), TuplesKt.to("nfa_name", r103), TuplesKt.to("nfa_result", Boolean.valueOf(r107))}));
        if (r100.nodeType != 1) goto L15;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.f r108 = r100.boolNode;
        if (r108 == null) goto L15;
        Boolean r109 = r108.value;
        if (r109 == null) goto L15;
        r105 = r109.booleanValue();
    L15:
        this.f123229f = r105;
        Iterator<T> r110 = this.f123230g.iterator();
    L17:
        if (r110.hasNext() == false) goto L19;
        ((g.a) r110.next()).a(this.f123231h, this.f123229f);
        goto L17
    L19:
        return;
    L7:
        r107 = false;
        goto L8
    }

    public final void j(String r310, Map r311) {
        String r110 = "eventKey";
        Intrinsics.checkNotNullParameter(r310, "eventKey");
        String r111 = "eventParams";
        Intrinsics.checkNotNullParameter(r311, "eventParams");
        if (this.f123227d == false) goto L5;
        return;
    L5:
        LinkedHashSet r112 = new LinkedHashSet();
        int r100 = this.f123224a.size();
        ku1.g r101 = ku1.g.f506185a;
        if (r100 >= r101.getValue().c()) goto L45;
        List<t> r102 = this.f123232i.b();
        if (r102 == null) goto L37;
        t r103 = (t) CollectionsKt.getOrNull(r102, 0);
        if (r103 == null) goto L37;
        if (r103.d() != 1) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        t r105 = r103;
    L18:
        if (r105 == null) goto L37;
        if (this.f123228e >= r101.getValue().b()) goto L45;
        long r210 = System.nanoTime();
        String r106 = this.f123231h + "_#Flow" + this.f123228e;
        if (this.f123232i.d() <= 0) goto L28;
        long r107 = (((long) (this.f123232i.d() * 1000)) * 1000000) + r210;
        Long r108 = Long.valueOf(r107);
        m r109 = new m(r106, r107, this);
        l r113 = this.f123225b;
        if (r113 == null) goto L27;
        r113.b(r109);
    L27:
        Unit r114 = Unit.INSTANCE;
        Pair r115 = new Pair(r108, r109);
    L29:
        a r116 = new a(r106, r210, ((Number) r115.component1()).longValue(), (m) r115.component2());
        Object r117 = "room_id";
        r116.f123211e = new d(this.f123233j, this.f123231h, r105, System.nanoTime(), this.f123225b, r116, this);
        this.f123224a.add(r116);
        this.f123228e++;
        int r118 = b.f123213a;
        String r119 = this.f123233j;
        String r120 = "roomId";
        Intrinsics.checkNotNullParameter(r119, r120);
        Intrinsics.checkNotNullParameter(r106, "name");
        Intrinsics.checkNotNullParameter(r116, "wrapper");
        Pair[] r121 = new Pair[3];
        r121[0] = TuplesKt.to(r117, r119);
        r121[1] = TuplesKt.to("nfa_name", r106);
        d r122 = r116.f123211e;
        if (r122 == null) goto L35;
        t r123 = r122.f123219f;
        if (r123 == null) goto L35;
        String r124 = r123.e();
        if (r124 == null) goto L35;
    L36:
        Object r125 = "pattern_name";
        r121[2] = TuplesKt.to(r125, r124);
        b.b("StrategyCepNfa_flow_start", MapsKt.mutableMapOf(r121));
        String r126 = "StrategyCepNfa_error";
    L46:
        Iterator r127 = this.f123224a.iterator();
    L48:
        if (r127.hasNext() == false) goto L169;
        a r128 = (a) r127.next();
        if (this.f123232i.d() > 0) goto L52;
    L55:
        LinkedHashSet r129 = r112;
        d r130 = r128.f123211e;
        if (r130 == null) goto L148;
        String r131 = r310;
        String r132 = r110;
        Intrinsics.checkNotNullParameter(r131, r132);
        String r133 = r111;
        Intrinsics.checkNotNullParameter(r311, r133);
        if (r130.f123216c == false) goto L60;
        r111 = r133;
        LinkedHashSet r211 = r129;
        a r212 = r128;
        Iterator r312 = r127;
    L146:
        int r134 = 4;
    L147:
        int r135 = r134;
    L149:
        int r136 = b.f123213a;
        String r137 = this.f123233j;
        a r138 = r212;
        String r139 = r138.f123207a;
        Intrinsics.checkNotNullParameter(r137, r120);
        Intrinsics.checkNotNullParameter(r131, "eventName");
        Intrinsics.checkNotNullParameter(r139, "flowName");
        b.b("StrategyCepNfa_flow_move", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r117, r137), TuplesKt.to(ReportCardMonitorPlugin.EVENT_NAME, r131), TuplesKt.to("flow_name", r139), TuplesKt.to("flow_pattern_result", Integer.valueOf(r135))}));
        if (r135 != 2) goto L152;
        LinkedHashSet r140 = r211;
        r138.f123212f++;
        List<t> r141 = this.f123232i.b();
        if (r141 == null) goto L167;
        t r142 = (t) CollectionsKt.getOrNull(r141, r138.f123212f);
        if (r142 == null) goto L167;
        r120 = r120;
        String r213 = r111;
        String r214 = r132;
        d r143 = new d(this.f123233j, this.f123231h, r142, System.nanoTime(), this.f123225b, r138, this);
        r138.f123211e = r143;
        t r144 = r143.f123219f;
        if (r144 != null) goto L163;
    L166:
        LinkedHashSet r145 = r140;
    L168:
        r112 = r145;
        r111 = r213;
        r110 = r214;
        r127 = r312;
        r120 = r120;
        goto L48
    L163:
        if (r144.d() != 6) goto L166;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.a r146 = new com.bytedance.android.livesdk.dynamicstrategy.api.entity.a();
        r146.nodeType = 1;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.f r147 = new com.bytedance.android.livesdk.dynamicstrategy.api.entity.f();
        r147.value = Boolean.TRUE;
        Unit r148 = Unit.INSTANCE;
        r146.boolNode = r147;
        l(r146);
        r138.f123211e = null;
        k(r138.f123208b, "Nfa Move To End");
        return;
    L167:
        r214 = r132;
        r120 = r120;
        r213 = r111;
        r145 = r140;
        r145.add(Long.valueOf(r138.f123208b));
        goto L168
    L152:
        if (r135 == 4) goto L154;
        LinkedHashSet r149 = r211;
    L155:
        r214 = r132;
        r145 = r149;
        r213 = r111;
        goto L168
    L154:
        r149 = r211;
        r149.add(Long.valueOf(r138.f123208b));
        goto L155
    L60:
        r111 = r133;
        if (r130.f123219f.g() <= 0) goto L66;
        r211 = r129;
        r212 = r128;
        r312 = r127;
        Object r313 = r125;
        if ((System.nanoTime() - r130.f123220g) <= ((((long) r130.f123219f.g()) * 1000000) * ((long) 1000))) goto L67;
        int r150 = b.f123213a;
        b.c(r130.f123217d, r131, r130.f123222i.f123207a + '_' + r130.f123219f.e(), "Pattern Time Out");
    L65:
        r125 = r313;
    L67:
        Map<String, com.bytedance.android.livesdk.dynamicstrategy.api.entity.k> r151 = r130.f123219f.c();
        if (r151 == null) goto L173;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.k r152 = r151.get(r131);
        if (r152 == null) goto L173;
        List<com.bytedance.android.livesdk.dynamicstrategy.api.entity.l> r153 = r152.a();
        if (r153 == null) goto L173;
        Iterator<T> r154 = r153.iterator();
    L75:
        if (r154.hasNext() == false) goto L173;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.l r155 = (com.bytedance.android.livesdk.dynamicstrategy.api.entity.l) r154.next();
        String r156 = r155.a();
        if (r156 == null) goto L75;
        if (r156.length() <= 0) goto L81;
        boolean r157 = true;
    L82:
        if (r157 == true) goto L85;
        r156 = null;
    L85:
        if (r156 == null) goto L75;
        Object r158 = r311.get(r156);
        if (r158 == null) goto L75;
        if ((r158 instanceof String) == false) goto L75;
        if (r155.b() != 1) goto L98;
        long r159 = CastLongProtector.parseLong((String) r158);     // Catch: NumberFormatException -> L95
    L96:
        r311.put(r156, Long.valueOf(r159));
    L95:
        r159 = 0;
        goto L96
    L98:
        if (r155.b() != 2) goto L75;
        Object r160 = Double.valueOf(CastDoubleProtector.parseDouble((String) r158));     // Catch: NumberFormatException -> L101
    L102:
        r311.put(r156, r160);
    L101:
        r160 = 0;
        goto L102
    L81:
        r157 = false;
    L173:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.a r161 = r130.f123219f.a();     // Catch: Exception -> L141
        if (r161 == null) goto L108;
        Map<String, ASTRunner.b0> r162 = ASTRunner.f123060a;     // Catch: Exception -> L141
        Object r163 = ASTRunner.b(r161, new ASTRunner.a(r311));     // Catch: Exception -> L141
    L110:
        if ((r163 instanceof Boolean) == true) goto L112;
        r163 = null;
    L112:
        Boolean r164 = (Boolean) r163;     // Catch: Exception -> L141
        if (r164 == null) goto L65;
        boolean r165 = r164.booleanValue();     // Catch: Exception -> L141
        int r166 = b.f123213a;
        String r167 = r130.f123217d;
        String r168 = r130.f123222i.f123207a + '_' + r130.f123219f.e();
        Intrinsics.checkNotNullParameter(r167, r120);
        Intrinsics.checkNotNullParameter(r131, "eventName");
        Intrinsics.checkNotNullParameter(r168, "patternName");
        r125 = r313;
        b.b("StrategyCepNfa_pattern", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r117, r167), TuplesKt.to(ReportCardMonitorPlugin.EVENT_NAME, r131), TuplesKt.to(r125, r168), TuplesKt.to("condition_result", Boolean.valueOf(r165))}));
        int r169 = r130.f123219f.d();
        if (r169 == 1) goto L123;
        if (r169 == 2) goto L123;
        if (r169 != 4) goto L146;
        if (r165 == true) goto L146;
    L138:
        r134 = 2;
    L123:
        if (r165 == true) goto L125;
        r134 = 3;
        goto L147
    L125:
        if (r130.f123219f.f() <= 0) goto L130;
        int r170 = r130.f123214a + 1;
        r130.f123214a = r170;
        if (r170 >= r130.f123219f.f()) goto L130;
        boolean r171 = false;
    L131:
        if (r171 == false) goto L139;
        m r172 = r130.f123215b;
        if (r172 == null) goto L137;
        l r173 = r130.f123221h;
        if (r173 == null) goto L137;
        r173.c(r172);
    L137:
        r130.f123215b = null;
        goto L138
    L139:
        r134 = 1;
    L130:
        r171 = true;
        goto L131
    L108:
        r163 = null;
    L141:
        e = move-exception;
        r125 = r313;
        int r174 = b.f123213a;
        String r175 = r130.f123217d;
        String r176 = r130.f123222i.f123207a + '_' + r130.f123219f.e();
        String r177 = e.getMessage();
        if (r177 != null) goto L145;
        r177 = "ASTRunner Execute Error";
    L145:
        Intrinsics.checkNotNullParameter(r175, r120);
        Intrinsics.checkNotNullParameter(r131, "eventName");
        Intrinsics.checkNotNullParameter(r176, "patternName");
        Intrinsics.checkNotNullParameter(r177, "reason");
        k0.o().f(r126, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r117, r175), TuplesKt.to(ReportCardMonitorPlugin.EVENT_NAME, r131), TuplesKt.to(r125, r176), TuplesKt.to("reason", r177)}));
        goto L146
    L66:
        r211 = r129;
        r212 = r128;
        r312 = r127;
        r313 = r125;
        goto L67
    L148:
        r131 = r310;
        r211 = r129;
        r212 = r128;
        r312 = r127;
        r132 = r110;
        r135 = 4;
        goto L149
    L52:
        if (System.nanoTime() <= r128.f123209c) goto L55;
        LinkedHashSet r178 = r112;
        r178.add(Long.valueOf(r128.f123208b));
        r145 = r178;
        r312 = r127;
        r214 = r110;
        r213 = r111;
        goto L168
    L169:
        final LinkedHashSet r179 = r112;
        CollectionsKt.removeAll(this.f123224a, new EventCepNfa$onNewEvent$5(this, r179));
        return;
    L35:
        r124 = "null";
        goto L36
    L28:
        r115 = new Pair(0L, null);
        goto L29
    L17:
        r105 = null;
        goto L18
    L14:
        r104 = false;
    L37:
        this.f123227d = true;
        int r180 = b.f123213a;
        String r181 = this.f123233j;
        String r182 = this.f123231h;
        s r183 = this.f123232i;
        Intrinsics.checkNotNullParameter(r181, "roomId");
        Intrinsics.checkNotNullParameter(r182, "name");
        Intrinsics.checkNotNullParameter(r183, "nfa");
        Pair[] r184 = new Pair[3];
        r184[0] = TuplesKt.to("room_id", r181);
        r184[1] = TuplesKt.to("nfa_name", r182);
        List<t> r185 = r183.b();
        if (r185 == null) goto L42;
        t r186 = (t) CollectionsKt.getOrNull(r185, 0);
        if (r186 == null) goto L42;
        int r187 = r186.d();
    L43:
        r184[2] = TuplesKt.to("first_pattern", Integer.valueOf(r187));
        k0.o().f("StrategyCepNfa_error", MapsKt.mutableMapOf(r184));
        return;
    L42:
        r187 = -1;
    L45:
        r120 = "roomId";
        r126 = "StrategyCepNfa_error";
        r125 = "pattern_name";
        r117 = "room_id";
        goto L46
    }

    public final void k(long r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "stopReason");
        int r101 = b.f123213a;
        String r102 = this.f123233j;
        String r103 = this.f123231h;
        Intrinsics.checkNotNullParameter(r102, "roomId");
        Intrinsics.checkNotNullParameter(r103, "name");
        Intrinsics.checkNotNullParameter(r110, "reason");
        b.b("StrategyCepNfa_nfa_stop", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("room_id", r102), TuplesKt.to("nfa_name", r103), TuplesKt.to("reason", r110)}));
        Iterator<T> r104 = this.f123224a.iterator();
    L4:
        if (r104.hasNext() == false) goto L18;
        a r105 = (a) r104.next();
        m r106 = r105.f123210d;
        if (r106 == null) goto L11;
        l r107 = this.f123225b;
        if (r107 == null) goto L11;
        r107.c(r106);
    L11:
        if (r100 != 0) goto L13;
    L14:
        d r108 = r105.f123211e;
        if (r108 == null) goto L17;
        r108.b(false, r110);
    L17:
        r105.f123211e = null;
        r105.f123210d = null;
        r105.f123212f = -1;
        goto L4
    L13:
        if (r100 == r105.f123208b) goto L17;
    L18:
        this.f123224a.clear();
        this.f123225b = null;
        this.f123227d = true;
    }

    public e(String r100, s r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "nfa");
        Intrinsics.checkNotNullParameter(r102, "roomId");
        this.f123231h = r100;
        this.f123232i = r101;
        this.f123233j = r102;
        this.f123224a = new LinkedList();
        this.f123230g = new LinkedHashSet();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.c
    public final void d(String r110, long r111, long r112) {
        Intrinsics.checkNotNullParameter(r110, "nfaName");
        if (this.f123227d == false) goto L5;
        return;
    L5:
        Iterator<T> r100 = this.f123224a.iterator();
    L7:
        if (r100.hasNext() == false) goto L20;
        Object r101 = r100.next();
        a r102 = (a) r101;
        if (r111 <= 0) goto L13;
        if (r102.f123208b != r111) goto L13;
    L16:
        boolean r103 = true;
    L18:
        if (r103 == false) goto L7;
    L21:
        a r113 = (a) r101;
        if (r113 == null) goto L41;
        r113.f123212f++;
        List<t> r104 = this.f123232i.b();
        if (r104 == null) goto L32;
        t r105 = (t) CollectionsKt.getOrNull(r104, r113.f123212f);
        if (r105 == null) goto L32;
        d r114 = new d(this.f123233j, this.f123231h, r105, System.nanoTime(), this.f123225b, r113, this);
        r113.f123211e = r114;
        t r106 = r114.f123219f;
        if (r106 == null) goto L32;
        if (r106.d() != 6) goto L32;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.a r107 = new com.bytedance.android.livesdk.dynamicstrategy.api.entity.a();
        r107.nodeType = 1;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.f r108 = new com.bytedance.android.livesdk.dynamicstrategy.api.entity.f();
        r108.value = Boolean.TRUE;
        Unit r109 = Unit.INSTANCE;
        r107.boolNode = r108;
        l(r107);
        r113.f123211e = null;
        k(r113.f123208b, "Nfa Pattern TimeOut Move To End");
    L32:
        h r115 = this.f123226c;
        if (r115 == null) goto L42;
        r115.b(r110);
        r115.d(r110);
        return;
    L42:
        return;
    L41:
        return;
    L13:
        if (r112 > 0) goto L15;
    L17:
        r103 = false;
        goto L18
    L15:
        if (r102.f123209c != r112) goto L17;
    L20:
        r101 = null;
        goto L21
    }
}
