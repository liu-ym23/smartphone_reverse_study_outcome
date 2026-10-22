package com.obric.autogui.agents.a.h;

import com.obric.autogui.agents.a.f.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: ActionEffectActionResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f26500a = null;

    /* JADX INFO: compiled from: ActionEffectActionResolver.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26501a = null;

        static {
            int[] r0 = new int[com.obric.autogui.operator.a.b.c.b.values().length];
            r0[com.obric.autogui.operator.a.b.c.b.f29637a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[com.obric.autogui.operator.a.b.c.b.f29638b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[com.obric.autogui.operator.a.b.c.b.f29641e.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f26501a = r0;
        }
    }

    static {
        f26500a = new b();
    }

    private b() {
    }

    public final com.obric.autogui.agents.a.h.a a(com.obric.autogui.operator.e r8) {
        o.e(r8, "step");
        if (ZeusTransformUtils.instanceOf(r8, com.obric.autogui.agents.vlm.models.a.e.class) == true) goto L5;
        String r0 = c(r8);
        switch(r0.hashCode()) {
            case -1950471620: goto L100;
            case -1046022900: goto L96;
            case -779672311: goto L92;
            case -570883966: goto L88;
            case -504325460: goto L84;
            case -326696768: goto L80;
            case -171636951: goto L77;
            case 3540994: goto L73;
            case 3575610: goto L34;
            case 3641717: goto L30;
            case 94750088: goto L26;
            case 106931267: goto L22;
            case 109854522: goto L18;
            case 853581410: goto L14;
            case 1374143386: goto L10;
            default: goto L104;
        };
    L10:
        if (r0.equals("double_click") == false) goto L104;
        return a(com.obric.autogui.agents.a.f.a.f26393b);
    L14:
        if (r0.equals("clarify") == false) goto L104;
        return a(h.f26427a);
    L18:
        if (r0.equals("swipe") == false) goto L104;
        return a(com.obric.autogui.agents.a.f.a.f);
    L22:
        if (r0.equals("press") == false) goto L104;
        return b(r8);
    L26:
        if (r0.equals("click") == false) goto L104;
        return a(com.obric.autogui.agents.a.f.a.f26392a);
    L30:
        if (r0.equals("wait") == false) goto L104;
        return a(h.f26430d);
    L34:
        if (r0.equals("type") == false) goto L104;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r8.Q(), Iterable.class, "com.obric.aiagent.plugin");
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L39;
    L41:
        Iterator r2 = r1.iterator();
    L43:
        if (r2.hasNext() == false) goto L40;
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.f) goto L47;
        boolean r4 = true;
    L48:
        if (r4 == false) goto L43;
        boolean r5 = true;
    L50:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8.Q(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L53;
    L55:
        Iterator r10 = r9.iterator();
    L57:
        if (r10.hasNext() == false) goto L54;
        com.obric.autogui.operator.e.C0780e r6 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (r6.a() != com.obric.autogui.operator.b.EnumC0777b.g) goto L69;
        com.obric.autogui.operator.b.a r7 = r6.b();
        com.obric.autogui.operator.a.b.c.b r11 = null;
        if (ZeusTransformUtils.instanceOf(r7, com.obric.autogui.operator.a.b.c.C0765c.class) == false) goto L63;
        com.obric.autogui.operator.a.b.c.C0765c r12 = (com.obric.autogui.operator.a.b.c.C0765c) ZeusTransformUtils.preCheckCast(r7, com.obric.autogui.operator.a.b.c.C0765c.class, "com.obric.aiagent.plugin");
    L64:
        if (r12 == null) goto L67;
        r11 = r12.getType();
    L67:
        if (r11 != com.obric.autogui.operator.a.b.c.b.f29640d) goto L69;
        boolean r13 = true;
    L70:
        if (r13 == false) goto L57;
    L121:
        return a(r5, r3);
    L63:
        r12 = null;
    L69:
        r13 = false;
    L54:
        r3 = false;
        goto L121
    L53:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L55;
    L47:
        r4 = false;
    L40:
        r5 = false;
        goto L50
    L39:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L41;
    L73:
        if (r0.equals("stop") == false) goto L104;
        return a(h.i);
    L77:
        if (r0.equals("calluser") == false) goto L104;
    L127:
        return a(h.f26429c);
    L80:
        if (r0.equals("long_press") == false) goto L104;
        return a(com.obric.autogui.agents.a.f.a.f26394c);
    L84:
        if (r0.equals("open_app") == false) goto L104;
        return a(com.obric.autogui.agents.a.f.a.g);
    L88:
        if (r0.equals("run_script_by_ability") == false) goto L104;
        return a(h.f26431e);
    L92:
        if (r0.equals("take_notes") == false) goto L104;
        return a(h.f26428b);
    L96:
        if (r0.equals("call_user") == true) goto L127;
    L100:
        if (r0.equals("set_scroll_value") == false) goto L104;
        return a(h.f);
    L104:
        return (com.obric.autogui.agents.a.h.a) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.a.h.a.c.f26499a, com.obric.autogui.agents.a.h.a.class, "com.obric.aiagent.plugin");
    L5:
        return (com.obric.autogui.agents.a.h.a) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.a.h.a.c.f26499a, com.obric.autogui.agents.a.h.a.class, "com.obric.aiagent.plugin");
    }

    public final com.obric.autogui.agents.a.h.a a(boolean r1, boolean r2) {
        if (r1 == true) goto L8;
        if (r2 == false) goto L7;
        return a(com.obric.autogui.agents.a.f.a.f26396e);
    L7:
        return (com.obric.autogui.agents.a.h.a) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.a.h.a.c.f26499a, com.obric.autogui.agents.a.h.a.class, "com.obric.aiagent.plugin");
    L8:
        return a(com.obric.autogui.agents.a.f.a.f26395d);
    }

    private final com.obric.autogui.agents.a.h.a b(com.obric.autogui.operator.e r6) {
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.Q(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L3:
        com.obric.autogui.operator.a.b.c.b r2 = null;
        if (r7.hasNext() == false) goto L11;
        Object r0 = r7.next();
        if (((com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin")).a() != com.obric.autogui.operator.b.EnumC0777b.g) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L3;
    L12:
        com.obric.autogui.operator.e.C0780e r8 = (com.obric.autogui.operator.e.C0780e) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.operator.e.C0780e.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L15;
        com.obric.autogui.operator.b.a r9 = r8.b();
    L17:
        if (ZeusTransformUtils.instanceOf(r9, com.obric.autogui.operator.a.b.c.C0765c.class) == false) goto L19;
        com.obric.autogui.operator.a.b.c.C0765c r10 = (com.obric.autogui.operator.a.b.c.C0765c) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.operator.a.b.c.C0765c.class, "com.obric.aiagent.plugin");
    L20:
        if (r10 == null) goto L23;
        r2 = r10.getType();
    L23:
        return a(r2);
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

    public final com.obric.autogui.agents.a.h.a a(com.obric.autogui.operator.a.b.c.b r2) {
        if (r2 != null) goto L4;
        int r3 = -1;
    L6:
        if (r3 == 1) goto L15;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        return (com.obric.autogui.agents.a.h.a) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.a.h.a.c.f26499a, com.obric.autogui.agents.a.h.a.class, "com.obric.aiagent.plugin");
    L17:
        return a(h.h);
    L18:
        return a(h.g);
    L15:
        return a(com.obric.autogui.agents.a.f.a.h);
    L4:
        r3 = a.f26501a[r2.ordinal()];
        goto L6
    }

    private final String c(com.obric.autogui.operator.e r3) {
        String r1 = null;
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.agents.vlm.models.a.b.class) == false) goto L5;
        com.obric.autogui.agents.vlm.models.a.b r2 = (com.obric.autogui.agents.vlm.models.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.vlm.models.a.b.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 == null) goto L12;
        String r4 = r2.f();
        if (r4 == null) goto L12;
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r5 == null) goto L12;
        r1 = r5.toLowerCase(Locale.ROOT);
        o.c(r1, "toLowerCase(...)");
    L12:
        if (r1 != null) goto L15;
        return "";
    L15:
        return r1;
    L5:
        r2 = null;
        goto L6
    }

    private final com.obric.autogui.agents.a.h.a a(com.obric.autogui.agents.a.f.a r2) {
        return (com.obric.autogui.agents.a.h.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.a.h.a.b(r2), com.obric.autogui.agents.a.h.a.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.autogui.agents.a.h.a a(h r2) {
        return (com.obric.autogui.agents.a.h.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.a.h.a.C0666a(r2), com.obric.autogui.agents.a.h.a.class, "com.obric.aiagent.plugin");
    }
}
