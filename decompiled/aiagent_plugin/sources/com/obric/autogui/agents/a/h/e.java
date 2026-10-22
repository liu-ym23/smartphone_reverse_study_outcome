package com.obric.autogui.agents.a.h;

import com.obric.autogui.agents.a.f.j;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.l.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: SettingsActionEffectPolicyProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "ActionEffectPolicy";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26507a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.common.a.a.a f26508b;

    /* JADX INFO: compiled from: SettingsActionEffectPolicyProvider.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f26507a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CharSequence lambda$K234i2bDXZFLRDw4aqYPL7SByq0(com.obric.autogui.agents.a.f.c r0) {
        return a(r0);
    }

    public e(com.obric.autogui.common.a.a.a r3) {
        com.obric.autogui.common.a.a.a r4 = (com.obric.autogui.common.a.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.common.a.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "settings");
        this.f26508b = r4;
    }

    public /* synthetic */ e(com.obric.autogui.common.a.a.a r2, int r3, h r4) {
        com.obric.autogui.common.a.a.a r5 = (com.obric.autogui.common.a.a.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.common.a.a.a.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = (com.obric.autogui.common.a.a.a) ZeusTransformUtils.preCheckCast(AutoActionConfigs.INSTANCE, com.obric.autogui.common.a.a.a.class, "com.obric.aiagent.plugin");
    L5:
        this(r5);
    }

    public final d a(com.obric.autogui.agents.a.f.a r6) {
        o.e(r6, "action");
        boolean r2 = true;
        if (this.f26508b.getBooleanCfg("operator.action_effect.observe_enabled", true) == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == true) goto L12;
    L16:
        r2 = false;
    L18:
        return new d(r6, r0, r2);
    L12:
        if (this.f26508b.getBooleanCfg("operator.action_effect.retry_wait_enabled", false) == false) goto L16;
        if (a(r6, "retry_wait_enabled", true) == false) goto L16;
    L5:
        if (a().contains(r6) == false) goto L9;
        if (a(r6, "observe_enabled", true) == false) goto L9;
        r0 = true;
        goto L10
    }

    private final Set<com.obric.autogui.agents.a.f.a> a() {
        List<?> r0 = this.f26508b.getListCfg("operator.action_effect.supported_actions");
        if (r0 == null) goto L5;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L15;
        Object r4 = r3.next();
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L12;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
    L13:
        if (r5 == null) goto L8;
        r2.add(r5);
        goto L8
    L12:
        r5 = null;
        goto L13
    L15:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r6, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r6.iterator();
    L17:
        if (r8.hasNext() == false) goto L19;
        String r9 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString().toLowerCase(Locale.ROOT);
        o.c(r9, "toLowerCase(...)");
        r7.add(r9);
        goto L17
    L19:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r10.iterator();
    L20:
        boolean r13 = true;
        if (r12.hasNext() == false) goto L28;
        Object r14 = r12.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L26;
        r13 = false;
    L26:
        if (r13 == false) goto L20;
        r11.add(r14);
        goto L20
    L28:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L31;
    L33:
        Iterator r17 = r16.iterator();
    L35:
        if (r17.hasNext() == false) goto L32;
        if (o.a((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin"), "all") == false) goto L35;
    L38:
        if (r13 == true) goto L40;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r20 = r18.iterator();
    L43:
        if (r20.hasNext() == false) goto L49;
        String r21 = (String) ZeusTransformUtils.preCheckCast(r20.next(), String.class, "com.obric.aiagent.plugin");
        Set<com.obric.autogui.agents.a.f.a> r22 = a(r21);
        if (r22.isEmpty() == false) goto L47;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] ignore unknown supported action=" + com.obric.autogui.agents.a.b.a(r21, 80));
    L47:
        p.a(r19, (Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.aiagent.plugin"));
        goto L43
    L49:
        return (Set) ZeusTransformUtils.preCheckCast(r19, Set.class, "com.obric.aiagent.plugin");
    L40:
        return p.q((Iterable) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.a.f.a.c(), Iterable.class, "com.obric.aiagent.plugin"));
    L32:
        r13 = false;
        goto L38
    L31:
        if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L33;
    L5:
        return p.q((Iterable) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.a.f.a.c(), Iterable.class, "com.obric.aiagent.plugin"));
    }

    public final j a(d r33) {
        o.e(r33, "rollout");
        com.obric.autogui.agents.a.f.a r1 = r33.a();
        j r4 = c.f26502a.a(r1);
        long r6 = a("operator.action_effect.detect_interval_ms", r4.c());
        int r3 = a("operator.action_effect.max_detect_count", r4.d());
        long r10 = a("operator.action_effect.timeout_ms", r4.e());
        int r12 = a("operator.action_effect.tolerance_permille", r4.f());
        boolean r13 = this.f26508b.getBooleanCfg("operator.action_effect.image_pixel_compare_enabled", r4.g());
        int r14 = a("operator.action_effect.image_pixel_delta_threshold", r4.h());
        int r15 = a("operator.action_effect.image_global_changed_permille", r4.i());
        int r9 = a("operator.action_effect.image_block_changed_permille", r4.j());
        int r8 = a("operator.action_effect.image_click_region_radius_permille", r4.k());
        int r2 = a("operator.action_effect.image_click_region_changed_permille", r4.l());
        List<String> r5 = a(r1, "detectors");
        List<com.obric.autogui.agents.a.f.c> r16 = null;
        if (r5 == null) goto L21;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r7.iterator();
    L6:
        if (r17.hasNext() == false) goto L20;
        Iterator r22 = r17;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.f.c[] r19 = com.obric.autogui.agents.a.f.c.values();
        int r23 = r14;
        int r110 = r19.length;
        boolean r24 = r13;
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L13;
        com.obric.autogui.agents.a.f.c r25 = r19[r111];
        int r26 = r110;
        com.obric.autogui.agents.a.f.c[] r27 = r19;
        if (d.o.o.a(r25.a(), r18, true) == true) goto L11;
        r111 = r111 + 1;
        r110 = r26;
        r19 = r27;
        goto L8
    L11:
        com.obric.autogui.agents.a.f.c r112 = r25;
    L14:
        if (r112 != null) goto L17;
        Loog.INSTANCE.w(TAG, "[OAutoActionEffect] ignore unknown detector=" + com.obric.autogui.agents.a.b.a(r18, 80) + ", action=" + r1.a());
    L17:
        if (r112 == null) goto L19;
        r11.add(r112);
    L19:
        r17 = r22;
        r14 = r23;
        r13 = r24;
        r12 = r12;
        goto L6
    L13:
        r112 = null;
        goto L14
    L20:
        int r28 = r12;
        boolean r29 = r13;
        int r210 = r14;
        r16 = p.s((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    L22:
        if (r16 != null) goto L24;
        List<com.obric.autogui.agents.a.f.c> r211 = r4.b();
    L25:
        j r20 = j.a(r4, null, r211, n.a(a(r1, "detect_interval_ms", r6), 0, 5000), n.a(a(r1, "max_detect_count", r3), 1, 100), n.a(a(r1, "timeout_ms", r10), 0, 60000), n.a(a(r1, "tolerance_permille", r28), 0, 1000), a(r1, "image_pixel_compare_enabled", r29), n.a(a(r1, "image_pixel_delta_threshold", r210), 0, 255), n.a(a(r1, "image_global_changed_permille", r15), 0, 1000), n.a(a(r1, "image_block_changed_permille", r9), 0, 1000), n.a(a(r1, "image_click_region_radius_permille", r8), 0, 500), n.a(a(r1, "image_click_region_changed_permille", r2), 0, 1000), 1, null);
        Loog r21 = Loog.INSTANCE;
        StringBuilder r30 = new StringBuilder();
        r30.append("[OAutoActionEffect] policy action=").append(r1.a()).append(", settings_action=").append(r1.b()).append(", settings_version=").append(this.f26508b.getVersion()).append(", observe_enabled=").append(r33.b()).append(", retry_wait_enabled=").append(r33.c()).append(", detect_interval_ms=").append(r20.c()).append(", max_detect_count=").append(r20.d()).append(", timeout_ms=").append(r20.e()).append(", tolerance_permille=").append(r20.f()).append(", image_pixel_compare_enabled=").append(r20.g()).append(", image_pixel_delta_threshold=").append(r20.h()).append(", image_global_changed_permille=");
        r30.append(r20.i()).append(", image_block_changed_permille=").append(r20.j()).append(", image_click_region_radius_permille=").append(r20.k()).append(", image_click_region_changed_permille=").append(r20.l()).append(", detectors=").append(p.a((Iterable) ZeusTransformUtils.preCheckCast(r20.b(), Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, $$Lambda$e$K234i2bDXZFLRDw4aqYPL7SByq0.INSTANCE, 31, null));
        r21.i(TAG, r30.toString());
        return r20;
    L24:
        r211 = r16;
        goto L25
    L21:
        r28 = r12;
        r29 = r13;
        r210 = r14;
        goto L22
    }

    private static final CharSequence a(com.obric.autogui.agents.a.f.c r2) {
        o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final Set<com.obric.autogui.agents.a.f.a> a(String r7) {
        if (o.a(r7, "press") == true) goto L16;
        com.obric.autogui.agents.a.f.a[] r6 = com.obric.autogui.agents.a.f.a.values();
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        int r3 = r6.length;
    L6:
        if (r1 >= r3) goto L12;
        com.obric.autogui.agents.a.f.a r4 = r6[r1];
        if (o.a(r4.a(), r7) == false) goto L10;
        r0.add(r4);
    L10:
        r1 = r1 + 1;
        goto L6
    L12:
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.aiagent.plugin");
    L16:
        return ax.a(com.obric.autogui.agents.a.f.a.h);
    }

    /* JADX WARN: Type inference failed for: r7v12, types: [T, java.util.List] */
    private final List<String> a(com.obric.autogui.agents.a.f.a r6, String r7) {
        z.f r0 = new z.f();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(b(r6, r7), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L18;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        List<?> r10 = this.f26508b.getListCfg(r9);
        if (r10 == null) goto L4;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L16;
        Object r3 = r12.next();
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L14:
        if (r4 == null) goto L9;
        r2.add(r4);
        goto L9
    L13:
        r4 = null;
        goto L14
    L16:
        r0.f38504a = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        goto L4
    L18:
        return (List) ZeusTransformUtils.preCheckCast(r0.f38504a, List.class, "com.obric.aiagent.plugin");
    }

    private final boolean a(com.obric.autogui.agents.a.f.a r3, String r4, boolean r5) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(b(r3, r4), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        r5 = this.f26508b.getBooleanCfg(r7, r5);
        goto L4
    L6:
        return r5;
    }

    private final int a(com.obric.autogui.agents.a.f.a r3, String r4, int r5) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(b(r3, r4), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        r5 = this.f26508b.getIntCfg(r7, r5);
        goto L4
    L6:
        return r5;
    }

    private final int a(String r1, int r2) {
        return this.f26508b.getIntCfg(r1, r2);
    }

    private final long a(String r1, long r2) {
        return this.f26508b.getLongCfg(r1, r2);
    }

    private final long a(com.obric.autogui.agents.a.f.a r3, String r4, long r5) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(b(r3, r4), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        r5 = this.f26508b.getLongCfg(r7, r5);
        goto L4
    L6:
        return r5;
    }

    private final List<String> b(com.obric.autogui.agents.a.f.a r7, String r8) {
        String r6 = "operator.action_effect.actions." + r7.b() + '.' + r8;
        if (r7 != com.obric.autogui.agents.a.f.a.h) goto L6;
        return p.b(new String[]{"operator.action_effect.actions.press." + r8, r6});
    L6:
        if (r7 != com.obric.autogui.agents.a.f.a.f26396e) goto L11;
        if (o.a(r8, "detectors") == true) goto L11;
        return p.b(new String[]{"operator.action_effect.actions." + com.obric.autogui.agents.a.f.a.f26395d.a() + '.' + r8, r6});
    L11:
        return p.a(r6);
    }
}
