package com.obric.autogui.agents.b;

import com.obric.autogui.common.a.k;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitor;
import com.obric.autogui.common.api.platform.special.PageSwitchPhase;
import com.obric.autogui.common.api.platform.special.SystemAnimationSnapshot;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.l.n;
import d.o.o;
import d.x;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: RuleStabilityJudge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements com.obric.autogui.agents.c {
    private static final String TAG = "RuleStability";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26833a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f26834b = null;

    /* JADX INFO: compiled from: RuleStabilityJudge.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final boolean a(String r3) {
            if (r3 == null) goto L7;
            String r4 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r4 == null) goto L7;
            String r5 = r4.toLowerCase(Locale.ROOT);
            d.h.b.o.c(r5, "toLowerCase(...)");
        L8:
            if (r5 != null) goto L11;
            r5 = "";
        L11:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L13;
            boolean r2 = true;
        L14:
            if (r2 == false) goto L16;
            return true;
        L16:
            if (g.a().contains(r5) == true) goto L19;
            return true;
        L19:
            return false;
        L13:
            r2 = false;
        L7:
            r5 = null;
            goto L8
        }

        public final long a(String r3, com.obric.autogui.agents.vlm.models.impl.g r4) {
            if (e.a(r4) == false) goto L6;
            return 0;
        L6:
            if (r3 == null) goto L10;
            String r5 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r5 == null) goto L10;
            String r6 = r5.toLowerCase(Locale.ROOT);
            d.h.b.o.c(r6, "toLowerCase(...)");
        L11:
            if (r6 != null) goto L14;
            r6 = "";
        L14:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L16;
            boolean r2 = true;
        L17:
            if (r2 == false) goto L22;
            if (com.obric.autogui.common.a.d.f28974a.T().contains(r6) == false) goto L22;
            return 0;
        L22:
            return com.obric.autogui.common.a.d.f28974a.p();
        L16:
            r2 = false;
        L10:
            r6 = null;
            goto L11
        }
    }

    /* JADX INFO: compiled from: RuleStabilityJudge.kt */
    @d.c.b.a.f(b = "RuleStabilityJudge.kt", c = {95, 128}, d = "judgePredCondition", e = "com.obric.autogui.agents.predjudge.RuleStabilityJudge")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f26837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f26838d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f26839e;
        Object f;
        long g;
        long h;
        long i;
        long j;
        long k;
        long l;
        int m;
        /* synthetic */ Object n;
        final /* synthetic */ g o;
        int p;

        b(g r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.o = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.n = r3;
            this.p |= Integer.MIN_VALUE;
            return this.o.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public g() {
    }

    public static final /* synthetic */ Set a() {
        return f26834b;
    }

    @Override // com.obric.autogui.agents.c
    public void a(com.obric.autogui.session.a r1) {
        com.obric.autogui.agents.c.a.a(this, r1);
    }

    static {
        f26833a = new a(null);
        f26834b = ax.a(new String[]{"type", "clarify", "call_user", "take_notes", "set_time_task", "set_scroll_value"});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x041d: MOVE (r8 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:151:0x041a */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x041e: MOVE (r9 I:??[long, double]) = (r11 I:??[long, double]), block:B:151:0x041a */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.autogui.agents.vlm.models.impl.g] */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [long] */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r9v4, types: [long] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.autogui.agents.c
    public Object a(com.obric.autogui.session.a r51, k r52, com.obric.autogui.agents.a.d r53, d.c.d<? super com.obric.autogui.agents.a.b> r54) {
        g r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r54, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L7;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
        if ((r4.p & Integer.MIN_VALUE) == 0) goto L7;
        r4.p -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.n;
        Object r5 = d.c.a.b.a();
        int r6 = r4.p;
        if (r6 == 0) goto L24;
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L18;
        long r7 = r4.l;
        int r8 = r4.m;
        long r13 = r4.k;
        long r11 = r4.j;
        long r9 = r4.i;
        long r10 = r4.h;
        long r12 = r4.g;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.f, String.class, "com.obric.aiagent.plugin");
        ActionSystemAnimationMonitor r14 = (ActionSystemAnimationMonitor) ZeusTransformUtils.preCheckCast(r4.f26839e, ActionSystemAnimationMonitor.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.g r15 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r4.f26838d, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d r16 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r4.f26837c, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r17 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r4.f26836b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        g r18 = (g) ZeusTransformUtils.preCheckCast(r4.f26835a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L15
        String r43 = r1;
        com.obric.autogui.agents.a.d r27 = r16;
        g r25 = r18;
        com.obric.autogui.session.a r26 = r17;
        long r34 = r9;
        long r32 = r10;
        long r30 = r12;
        long r19 = r7;
        String r110 = "com.obric.aiagent.plugin";
        Object r20 = r3;
        boolean r21 = true;
        com.obric.autogui.agents.vlm.models.impl.g r111 = r15;
    L192:
        SystemAnimationSnapshot r22 = (SystemAnimationSnapshot) ZeusTransformUtils.preCheckCast(r20, SystemAnimationSnapshot.class, r110);     // Catch: Throwable -> L139
        long r23 = n.a(AOSystemTools.INSTANCE.nowTimeMillis() - r19, 0);     // Catch: Throwable -> L152
        if (r22 == null) goto L121;
        String r24 = "callback_ready";
    L122:
        String r29 = r24;
        PageSwitchPhase r41 = r14.pageSwitchPhase();     // Catch: Throwable -> L150
        if (r22 == null) goto L128;
        SystemAnimationSnapshot.Event r28 = r22.getEvent();     // Catch: Throwable -> L150
        if (r28 == null) goto L128;
    L127:
        SystemAnimationSnapshot.Event r42 = r28;
    L132:
        com.obric.autogui.agents.a.b r31 = r25.a(r26, r27, r14, r29, r30, r32, r34, r11, r23, true, r41, r42, r43);     // Catch: Throwable -> L150
        boolean r33 = r14.hasPageSwitchStarted();
        long r112 = r11 + r23;
        if (r8 == 0) goto L136;
        boolean r35 = r21;
    L137:
        r111.a(r33, r112, r35);
        return r31;
    L136:
        r35 = false;
    L128:
        SystemAnimationSnapshot r36 = r14.latestPageSwitchSnapshot();     // Catch: Throwable -> L150
        if (r36 == null) goto L131;
        r28 = r36.getEvent();     // Catch: Throwable -> L150
        goto L127
    L131:
        r42 = null;
        goto L132
    L121:
        r24 = "callback_timeout";
    L139:
        th = th;
    L148:
        n.a(AOSystemTools.INSTANCE.nowTimeMillis() - r19, 0);     // Catch: Throwable -> L152
        throw th;     // Catch: Throwable -> L150
    L15:
        th = th;
        r19 = r7;
        goto L148
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        long r37 = r4.l;
        int r38 = r4.m;
        long r113 = r4.k;
        long r114 = r4.j;
        long r115 = r4.i;
        long r39 = r4.h;
        long r40 = r4.g;
        String r44 = (String) ZeusTransformUtils.preCheckCast(r4.f, String.class, "com.obric.aiagent.plugin");
        ActionSystemAnimationMonitor r45 = (ActionSystemAnimationMonitor) ZeusTransformUtils.preCheckCast(r4.f26839e, ActionSystemAnimationMonitor.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.g r46 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r4.f26838d, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.d r47 = (com.obric.autogui.agents.a.d) ZeusTransformUtils.preCheckCast(r4.f26837c, com.obric.autogui.agents.a.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r48 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r4.f26836b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        g r49 = (g) ZeusTransformUtils.preCheckCast(r4.f26835a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L22
        Object r50 = r5;
        int r55 = r38;
        String r56 = r44;
        com.obric.autogui.session.a r116 = r48;
        r0 = r49;
        com.obric.autogui.agents.vlm.models.impl.g r57 = r46;
        com.obric.autogui.agents.a.d r117 = r47;
        r110 = "com.obric.aiagent.plugin";
        long r58 = r37;
        long r210 = r40;
        long r118 = r113;
        long r211 = r114;
        long r119 = r39;
    L178:
        Object r212 = r50;
        long r59 = r115;
        com.obric.autogui.agents.vlm.models.impl.g r120 = r57;
        com.obric.autogui.session.a r60 = r116;
        long r410 = r118;
        int r121 = r55;
        long r61 = r210;
        long r411 = r119;
        r14 = r45;
        r11 = n.a(AOSystemTools.INSTANCE.nowTimeMillis() - r58, 0);     // Catch: Throwable -> L73
        long r62 = r411;
        com.obric.autogui.agents.a.d r63 = r117;
        long r122 = r410;
    L174:
        PageSwitchPhase r64 = r14.pageSwitchPhase();     // Catch: Throwable -> L156
        SystemAnimationSnapshot r123 = r14.latestPageSwitchSnapshot();     // Catch: Throwable -> L156
        b r213 = r4;
        if (r64 != PageSwitchPhase.InProgress) goto L186;
        long r65 = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L156
        r213.f26835a = r0;     // Catch: Throwable -> L145
        r213.f26836b = r60;     // Catch: Throwable -> L145
        r213.f26837c = r63;     // Catch: Throwable -> L145
        r213.f26838d = r120;     // Catch: Throwable -> L145
        r213.f26839e = r14;     // Catch: Throwable -> L145
        r213.f = r56;     // Catch: Throwable -> L145
        r213.g = r61;     // Catch: Throwable -> L145
        r213.h = r62;     // Catch: Throwable -> L145
        g r510 = r0;
        com.obric.autogui.session.a r66 = r60;
        long r67 = r59;
        r213.i = r67;     // Catch: Throwable -> L145
        r213.j = r11;     // Catch: Throwable -> L145
        r213.k = r122;     // Catch: Throwable -> L145
        com.obric.autogui.agents.a.d r511 = r63;
        r21 = true;
        r213.m = 1;     // Catch: Throwable -> L143
        long r214 = r61;
        long r68 = r65;
        r213.l = r68;     // Catch: Throwable -> L141
        r213.p = 2;     // Catch: Throwable -> L141
        Object r69 = r14.awaitReady(r67, r213);     // Catch: Throwable -> L141
        Object r70 = r212;
        if (r69 != r70) goto L116;
        return r70;
    L116:
        r27 = r511;
        r26 = r66;
        r25 = r510;
        r34 = r67;
        r19 = r68;
        r32 = r62;
        r43 = r56;
        r30 = r214;
        r8 = 1;
        r20 = r69;
        r111 = r120;
    L141:
        th = th;
    L147:
        r19 = r68;
    L143:
        th = th;
        r68 = r65;
    L145:
        th = th;
        r68 = r65;
        r21 = true;
        goto L147
    L186:
    L104:
        th = th;
        r45 = r14;
        long r71 = r11;
        long r72 = r122;
        com.obric.autogui.agents.vlm.models.impl.g r73 = r120;
    L83:
        ?? r74 = 1;
        ?? r75 = r73;
        ?? r76 = r72;
    L161:
        boolean r77 = r45.hasPageSwitchStarted();
        ?? r78 = r71 + r76;
        if (r121 == 0) goto L164;
        ?? r79 = r74;
    L165:
        r75.a(r77, r78, r79);
        throw th;
    L164:
        r79 = 0;
        goto L165
    L90:
        if (r64 != PageSwitchPhase.Ended) goto L92;
        String r80 = "page_switch_finished_during_initial_wait";
    L93:
        String r215 = r80;
        if (r123 == null) goto L96;
        SystemAnimationSnapshot.Event r412 = r123.getEvent();     // Catch: Throwable -> L104
    L97:
        com.obric.autogui.agents.a.b r81 = a(r0, r60, r63, r14, r215, r61, r62, r59, r11, 0, false, r64, r412, r56, 768, null);     // Catch: Throwable -> L104
        boolean r82 = r14.hasPageSwitchStarted();
        long r124 = r11 + r122;
        if (r121 == 0) goto L101;
        boolean r83 = true;
    L102:
        r120.a(r82, r124, r83);
        return r81;
    L101:
        r83 = false;
        goto L102
    L96:
        r412 = null;
        goto L97
    L92:
        r80 = "page_switch_not_started";
    L156:
        th = th;
        ?? r84 = 1;
    L154:
        r45 = r14;
        r71 = r11;
        ?? r85 = r122;
        ?? r86 = r84;
    L155:
        r75 = r120;
        r74 = r86;
        r76 = r85;
    L73:
        th = th;
        r71 = r211;
        r74 = 1;
        long r413 = r118;
        r121 = r55;
        r76 = r413;
        r75 = r57;
    L22:
        th = th;
        ActionSystemAnimationMonitor r87 = r45;
        r121 = r38;
        long r88 = r37;
        com.obric.autogui.agents.vlm.models.impl.g r89 = r46;
    L188:
        long r90 = n.a(AOSystemTools.INSTANCE.nowTimeMillis() - r88, 0);     // Catch: Throwable -> L81
        throw th;     // Catch: Throwable -> L79
    L79:
        th = th;
        r45 = r87;
        r73 = r89;
        r72 = r113;
        r71 = r90;
    L81:
        th = th;
        r45 = r87;
        r73 = r89;
        r72 = r113;
        r71 = r114;
        goto L83
    L24:
        d.o.a(r3);
        if (com.obric.autogui.common.a.d.f28974a.o() == false) goto L27;
        long r91 = AOSystemTools.INSTANCE.nowTimeMillis();
        Object r92 = p.n(r51.p());
        if (ZeusTransformUtils.instanceOf(r92, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L31;
        com.obric.autogui.agents.vlm.models.impl.g r93 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r92, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L32:
        if (r93 == null) goto L168;
        r45 = r93.q();
        if (r45 == null) goto L168;
        String r94 = r51.C();
        Iterator r95 = ((Iterable) ZeusTransformUtils.preCheckCast(r93.Q(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L38:
        if (r95.hasNext() == false) goto L45;
        Object r125 = r95.next();
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r125, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.f29869a) goto L42;
        boolean r126 = true;
    L43:
        if (r126 == false) goto L38;
    L46:
        com.obric.autogui.operator.e.C0780e r96 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r125, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (r96 == null) goto L49;
        com.obric.autogui.operator.b.a r97 = r96.b();
    L51:
        if (ZeusTransformUtils.instanceOf(r97, com.obric.autogui.operator.a.b.a.a.b.class) == false) goto L53;
        com.obric.autogui.operator.a.b.a.a.b r98 = (com.obric.autogui.operator.a.b.a.a.b) ZeusTransformUtils.preCheckCast(r97, com.obric.autogui.operator.a.b.a.a.b.class, "com.obric.aiagent.plugin");
    L54:
        if (r98 == null) goto L58;
        String r99 = r98.c();
        if (r99 == null) goto L58;
        r56 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r99, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L59:
        if (r56 != null) goto L61;
        r56 = "";
    L61:
        r119 = f26833a.a(r94, r93);
        r115 = com.obric.autogui.common.a.d.f28974a.c(r94);
        r110 = "com.obric.aiagent.plugin";
        Loog.INSTANCE.i("RuleStability", "[RuleStability] begin, sessionId=" + r51.b() + ", stepId=" + r93.W() + ", actionType=" + r94 + ", initialWait=" + r119 + "ms, callbackTimeout=" + r115 + "ms");     // Catch: Throwable -> L158
        if (r119 > 0) goto L194;
        r212 = r5;
        r63 = r53;
        r59 = r115;
        r61 = r91;
        r122 = 0;
        r121 = 0;
        r120 = r93;
        r60 = r51;
        r14 = r45;
        r62 = r119;
        r11 = 0;
        goto L174
    L194:
        r58 = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L84
        AOThreadingTools r100 = AOThreadingTools.INSTANCE;     // Catch: Throwable -> L75
        r4.f26835a = r0;     // Catch: Throwable -> L75
        r116 = r51;
        r4.f26836b = r116;     // Catch: Throwable -> L75
        r117 = r53;
        r4.f26837c = r117;     // Catch: Throwable -> L75
        r4.f26838d = r93;     // Catch: Throwable -> L75
        r4.f26839e = r45;     // Catch: Throwable -> L75
        r4.f = r56;     // Catch: Throwable -> L75
        r4.g = r91;     // Catch: Throwable -> L75
        r4.h = r119;     // Catch: Throwable -> L75
        r4.i = r115;     // Catch: Throwable -> L75
        r210 = r91;
        r4.j = 0;     // Catch: Throwable -> L75
        r4.k = 0;     // Catch: Throwable -> L75
        r4.m = 0;     // Catch: Throwable -> L75
        r4.l = r58;     // Catch: Throwable -> L75
        r4.p = 1;     // Catch: Throwable -> L75
        r50 = r5;
        if (r100.delayForMillis(r119, r4) != r50) goto L70;
        return r50;
    L70:
        r55 = 0;
        r118 = 0;
        r211 = 0;
        r57 = r93;
    L75:
        th = th;
        r89 = r93;
        r87 = r45;
        r113 = 0;
        r114 = 0;
        r121 = 0;
        r88 = r58;
    L84:
        th = th;
        boolean r101 = true;
        long r102 = 0;
        r71 = 0;
    L160:
        r121 = 0;
        r75 = r93;
        r74 = r101;
        r76 = r102;
    L158:
        th = th;
        r101 = true;
        r102 = 0;
        r71 = 0;
    L58:
        r56 = null;
        goto L59
    L53:
        r98 = null;
        goto L54
    L49:
        r97 = null;
        goto L51
    L42:
        r126 = false;
        goto L43
    L45:
        r125 = null;
    L168:
        return com.obric.autogui.agents.a.b.f26124a.a();
    L31:
        r93 = null;
        goto L32
    L27:
        return com.obric.autogui.agents.a.b.f26124a.a();
    L152:
        th = th;
        r121 = 2;
        r84 = r3;
    L150:
        th = th;
        r85 = "com.obric.aiagent.plugin";
        r121 = 2;
        r45 = r10;
        r71 = r11;
        r86 = r3;
    L7:
        r4 = new b(r0, r2);
        goto L8
    }

    static /* synthetic */ com.obric.autogui.agents.a.b a(g r21, com.obric.autogui.session.a r22, com.obric.autogui.agents.a.d r23, ActionSystemAnimationMonitor r24, String r25, long r26, long r28, long r30, long r32, long r34, boolean r36, PageSwitchPhase r37, SystemAnimationSnapshot.Event r38, String r39, int r40, Object r41) {
        ActionSystemAnimationMonitor r5 = (ActionSystemAnimationMonitor) ZeusTransformUtils.wrapperContextForParams(r24, ActionSystemAnimationMonitor.class, "com.obric.aiagent.plugin");
        if ((r40 & 256) == 0) goto L5;
        long r15 = 0;
    L7:
        if ((r40 & 512) == 0) goto L9;
        boolean r17 = false;
    L11:
        if ((r40 & 2048) == 0) goto L13;
        SystemAnimationSnapshot.Event r19 = null;
    L15:
        return r21.a(r22, r23, r5, r25, r26, r28, r30, r32, r15, r17, r37, r19, r39);
    L13:
        r19 = r38;
        goto L15
    L9:
        r17 = r36;
        goto L11
    L5:
        r15 = r34;
        goto L7
    }

    private final com.obric.autogui.agents.a.b a(com.obric.autogui.session.a r20, com.obric.autogui.agents.a.d r21, ActionSystemAnimationMonitor r22, String r23, long r24, long r26, long r28, long r30, long r32, boolean r34, PageSwitchPhase r35, SystemAnimationSnapshot.Event r36, String r37) {
        ActionSystemAnimationMonitor r12 = (ActionSystemAnimationMonitor) ZeusTransformUtils.wrapperContextForParams(r22, ActionSystemAnimationMonitor.class, "com.obric.aiagent.plugin");
        long r14 = AOSystemTools.INSTANCE.nowTimeMillis() - r24;
        boolean r11 = r12.hasPageSwitchStarted();
        long r13 = r30 + r32;
        Loog r15 = Loog.INSTANCE;
        StringBuilder r16 = new StringBuilder();
        r16.append("[RuleStability] end, sessionId=").append(r20.b()).append(", stepId=").append(r12.getStepId()).append(", predictionStepId=").append(r21.b()).append(", branch=").append(r23).append(", observedPhase=").append(r35).append(", observedEvent=").append(r36).append(", initialWait=").append(r26).append("ms, callbackTimeout=").append(r28).append("ms, initialWaitCost=").append(r30).append("ms, callbackWait=").append(r32).append("ms, waitDuration=").append(r13).append("ms, pageSwitchCallbackReceived=");
        r16.append(r11).append(", waitedForPageSwitch=").append(r34).append(", totalCost=").append(r14).append("ms, callbackCount=").append(r12.snapshots().size());
        r15.i("RuleStability", r16.toString());
        IAutoActionTrackingApi r9 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r17 = new JSONObject();
        com.obric.autogui.session.c.b.a(r17, r20);
        r17.put("step_id", r12.getStepId());
        r17.put("prediction_step_id", r21.b());
        r17.put("action_type", r20.C());
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r37, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        r17.put("target_app_name", r37);
    L8:
        r17.put("branch", r23);
        r17.put("observed_phase", r35.name());
        if (r36 == null) goto L11;
        String r0 = r36.name();
    L12:
        r17.put("observed_event", r0);
        r17.put("initial_wait", r26);
        r17.put("callback_timeout", r28);
        r17.put("initial_wait_cost", r30);
        r17.put("callback_wait", r32);
        r17.put("wait_duration", r13);
        r17.put("page_switch_callback_received", r11);
        r17.put("waited_for_page_switch", r34);
        r17.put("total_cost", r14);
        r17.put("callback_count", r12.snapshots().size());
        x r1 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r9, "oauto_rule_stability", r17, false, false, null, 28, null);
        return com.obric.autogui.agents.a.b.f26124a.a();
    L11:
        r0 = null;
        goto L12
    L5:
        r10 = false;
        goto L6
    }
}
