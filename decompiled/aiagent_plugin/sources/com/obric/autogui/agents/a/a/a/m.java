package com.obric.autogui.agents.a.a.a;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.s;
import d.x;
import java.util.Iterator;

/* JADX INFO: compiled from: SwipeActionEffectHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends com.obric.autogui.agents.a.a.a.b {
    private static final String TAG = "SwipeActionEffectHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26192a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.operator.a.b.e.b f26193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.operator.a.b.e.a f26194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile com.obric.autogui.agents.a.n.a.f f26195d;

    /* JADX INFO: compiled from: SwipeActionEffectHandler.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SwipeActionEffectHandler.kt */
    @d.c.b.a.f(b = "SwipeActionEffectHandler.kt", c = {49}, d = "onBeforeOperation", e = "com.obric.autogui.agents.actioneffect.attempt.handler.SwipeActionEffectHandler")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f26198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ m f26199d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f26200e;

        b(m r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26199d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f26198c = r3;
            this.f26200e |= Integer.MIN_VALUE;
            return this.f26199d.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f26192a = new a(null);
    }

    public m(com.obric.autogui.operator.e r6) {
        d.h.b.o.e(r6, "step");
        super(com.obric.autogui.operator.b.EnumC0777b.j);
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.Q(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L3:
        com.obric.autogui.operator.a.b.e.a r2 = null;
        if (r7.hasNext() == false) goto L11;
        Object r0 = r7.next();
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.j) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L3;
    L12:
        com.obric.autogui.operator.e.C0780e r8 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L15;
        com.obric.autogui.operator.b.a r9 = r8.b();
    L17:
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autogui.operator.a.b.e.b.class) == false) goto L19;
        com.obric.autogui.operator.a.b.e.b r10 = (com.obric.autogui.operator.a.b.e.b) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.operator.a.b.e.b.class, "com.obric.aiagent.plugin");
    L20:
        this.f26193b = r10;
        if (r10 == null) goto L23;
        r2 = a(r10);
    L23:
        this.f26194c = r2;
        return;
    L19:
        r10 = null;
        goto L20
    L15:
        r9 = null;
        goto L17
    L8:
        r3 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    @Override // com.obric.autogui.agents.a.a.a.b
    public com.obric.autogui.agents.a.a.a.a b() {
        return (com.obric.autogui.agents.a.a.a.a) ZeusTransformUtils.preCheckCast(new l(this.f26194c, this.f26195d), com.obric.autogui.agents.a.a.a.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.agents.a.a.a.b
    public Object a(d r12, com.obric.autogui.operator.e.C0780e r13, com.obric.autogui.operator.b r14, d.c.d<? super x> r15) {
        d r16 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
        d.c.d r17 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r17, b.class, "com.obric.aiagent.plugin");
        if ((r0.f26200e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f26200e -= Integer.MIN_VALUE;
    L8:
        Object r18 = r0.f26198c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f26200e;
        boolean r4 = true;
        String r5 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r16 = (d) ZeusTransformUtils.preCheckCast(r0.f26197b, d.class, "com.obric.aiagent.plugin");
        m this = (m) ZeusTransformUtils.preCheckCast(r0.f26196a, m.class, "com.obric.aiagent.plugin");
        d.o.a(r18);
    L27:
        d.m r19 = (d.m) ZeusTransformUtils.preCheckCast(r18, d.m.class, "com.obric.aiagent.plugin");
    L29:
        if (r19 == null) goto L33;
        d.m r110 = (d.m) ZeusTransformUtils.preCheckCast(r19.a(), d.m.class, "com.obric.aiagent.plugin");
        if (r110 == null) goto L33;
        d.m r111 = s.a(d.c.b.a.b.a(((Number) ZeusTransformUtils.preCheckCast(r110.a(), Number.class, "com.obric.aiagent.plugin")).intValue()), d.c.b.a.b.a(((Number) ZeusTransformUtils.preCheckCast(r110.b(), Number.class, "com.obric.aiagent.plugin")).intValue()));
    L34:
        if (r19 == null) goto L38;
        d.m r112 = (d.m) ZeusTransformUtils.preCheckCast(r19.b(), d.m.class, "com.obric.aiagent.plugin");
        if (r112 == null) goto L38;
        d.m r113 = s.a(d.c.b.a.b.a(((Number) ZeusTransformUtils.preCheckCast(r112.a(), Number.class, "com.obric.aiagent.plugin")).intValue()), d.c.b.a.b.a(((Number) ZeusTransformUtils.preCheckCast(r112.b(), Number.class, "com.obric.aiagent.plugin")).intValue()));
    L39:
        if (r111 == null) goto L41;
        com.obric.autogui.agents.a.n.a.f r114 = com.obric.autogui.agents.a.n.a.f26730a.a(r16.c().b(), this.f26194c, (Float) ZeusTransformUtils.preCheckCast(r111.a(), Float.class, "com.obric.aiagent.plugin"), (Float) ZeusTransformUtils.preCheckCast(r111.b(), Float.class, "com.obric.aiagent.plugin"));
    L42:
        this.f26195d = r114;
        com.obric.autogui.agents.a.n.a.f r115 = this.f26195d;
        if (r115 == null) goto L45;
        Boolean r1 = d.c.b.a.b.a(com.obric.autogui.agents.a.n.a.f26730a.a(r115, this.f26194c));
    L47:
        if (r115 == null) goto L49;
        String r6 = new StringBuilder().append(r115.i()).append(':').append(r115.j()).append(':').append(r115.k()).append(':').append(r115.l()).toString();
    L50:
        String r7 = "";
        if (r6 != null) goto L53;
        r6 = "";
    L53:
        StringBuilder r8 = new StringBuilder();
        StringBuilder r11 = r8.append("direction=").append(this.f26194c).append(", has_execution_start=");
        if (r111 == null) goto L56;
        boolean r9 = true;
    L57:
        StringBuilder r116 = r11.append(r9).append(", start_x=");
        if (r111 == null) goto L60;
        String r10 = d.c.b.a.b.a((int) ((Number) ZeusTransformUtils.preCheckCast(r111.a(), Number.class, "com.obric.aiagent.plugin")).floatValue()).toString();
    L61:
        if (r10 != null) goto L63;
        r10 = "";
    L63:
        StringBuilder r117 = r116.append(r10).append(", start_y=");
        if (r111 == null) goto L66;
        String r118 = d.c.b.a.b.a((int) ((Number) ZeusTransformUtils.preCheckCast(r111.b(), Number.class, "com.obric.aiagent.plugin")).floatValue()).toString();
    L67:
        if (r118 != null) goto L69;
        r118 = "";
    L69:
        StringBuilder r119 = r117.append(r118).append(", end_x=");
        if (r113 == null) goto L72;
        String r120 = d.c.b.a.b.a((int) ((Number) ZeusTransformUtils.preCheckCast(r113.a(), Number.class, "com.obric.aiagent.plugin")).floatValue()).toString();
    L73:
        if (r120 != null) goto L75;
        r120 = "";
    L75:
        StringBuilder r121 = r119.append(r120).append(", end_y=");
        if (r113 == null) goto L78;
        String r122 = d.c.b.a.b.a((int) ((Number) ZeusTransformUtils.preCheckCast(r113.b(), Number.class, "com.obric.aiagent.plugin")).floatValue()).toString();
    L79:
        if (r122 != null) goto L81;
        r122 = "";
    L81:
        StringBuilder r123 = r121.append(r122).append(", has_scroll_target=");
        if (r115 != null) goto L85;
        r4 = false;
    L85:
        StringBuilder r124 = r123.append(r4).append(", target_key_hash=");
        if (r115 == null) goto L90;
        String r125 = r115.a();
        if (r125 == null) goto L90;
        String r126 = d.c.b.a.b.a(r125.hashCode()).toString();
    L91:
        if (r126 != null) goto L93;
        r126 = "";
    L93:
        StringBuilder r127 = r124.append(r126).append(", target_bounds=").append(r6).append(", target_offset=");
        if (r115 == null) goto L96;
        String r128 = d.c.b.a.b.a(r115.b()).toString();
    L97:
        if (r128 != null) goto L99;
        r128 = "";
    L99:
        StringBuilder r129 = r127.append(r128).append(", target_range=");
        if (r115 == null) goto L102;
        String r130 = d.c.b.a.b.a(r115.c()).toString();
    L103:
        if (r130 != null) goto L105;
        r130 = "";
    L105:
        r129.append(r130).append(", target_extent=");
        if (r115 == null) goto L108;
        String r131 = d.c.b.a.b.a(r115.d()).toString();
    L109:
        if (r131 != null) goto L111;
        r131 = "";
    L111:
        StringBuilder r132 = r8.append(r131).append(", target_udlr=");
        if (r115 == null) goto L114;
        String r133 = new StringBuilder().append(r115.e()).append(':').append(r115.f()).append(':').append(r115.g()).append(':').append(r115.h()).toString();
    L115:
        if (r133 != null) goto L117;
        r133 = "";
    L117:
        StringBuilder r134 = r132.append(r133).append(", target_direction_capable=");
        if (r1 == null) goto L120;
        r5 = r1.toString();
    L120:
        if (r5 == null) goto L123;
        r7 = r5;
    L123:
        r134.append(r7).append(", selection_fallback=").append(d.h.b.o.a(r1, d.c.b.a.b.a(false)));
        Loog.INSTANCE.i(TAG, "[OAutoActionEffect] swipe target resolved " + r16.g() + ", " + r8.toString());
        return x.f38692a;
    L114:
        r133 = null;
        goto L115
    L108:
        r131 = null;
        goto L109
    L102:
        r130 = null;
        goto L103
    L96:
        r128 = null;
    L90:
        r126 = null;
        goto L91
    L78:
        r122 = null;
        goto L79
    L72:
        r120 = null;
        goto L73
    L66:
        r118 = null;
        goto L67
    L60:
        r10 = null;
        goto L61
    L56:
        r9 = false;
        goto L57
    L49:
        r6 = null;
        goto L50
    L45:
        r1 = null;
        goto L47
    L41:
        r114 = null;
    L38:
        r113 = null;
    L33:
        r111 = null;
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r18);
        if (r13.a() != com.obric.autogui.operator.b.EnumC0777b.j) goto L126;
        if (this.f26193b == null) goto L126;
        if (ZeusTransformUtils.instanceOf(r14, com.obric.autogui.operator.a.b.e.class) == false) goto L22;
        com.obric.autogui.operator.a.b.e r135 = (com.obric.autogui.operator.a.b.e) ZeusTransformUtils.preCheckCast(r14, com.obric.autogui.operator.a.b.e.class, "com.obric.aiagent.plugin");
    L23:
        if (r135 == null) goto L28;
        r0.f26196a = this;
        r0.f26197b = r16;
        r0.f26200e = 1;
        r18 = r135.a(r0);
        if (r18 != r2) goto L27;
        return r2;
    L28:
        r19 = null;
        goto L29
    L22:
        r135 = null;
    L126:
        return x.f38692a;
    L7:
        r0 = new b(this, r17);
        goto L8
    }

    private final com.obric.autogui.operator.a.b.e.a a(com.obric.autogui.operator.a.b.e.b r3) {
        if (r3.a() != com.obric.autogui.operator.a.b.e.a.f29658a) goto L5;
        float r2 = r3.c().x - r3.b().x;
        float r0 = r3.c().y - r3.b().y;
        if (Math.abs(r0) < Math.abs(r2)) goto L13;
        if (r0 >= 0.0f) goto L18;
        return com.obric.autogui.operator.a.b.e.a.f29659b;
    L18:
        return com.obric.autogui.operator.a.b.e.a.f29660c;
    L13:
        if (r2 >= 0.0f) goto L16;
        return com.obric.autogui.operator.a.b.e.a.f29661d;
    L16:
        return com.obric.autogui.operator.a.b.e.a.f29662e;
    L5:
        return r3.a();
    }
}
