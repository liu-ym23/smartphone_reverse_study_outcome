package com.obric.autogui.agents.a.a.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectActionHandlerFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f26174a = null;

    /* JADX INFO: compiled from: ActionEffectActionHandlerFactory.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26175a = null;

        static {
            int[] r0 = new int[com.obric.autogui.agents.a.f.a.values().length];
            r0[com.obric.autogui.agents.a.f.a.f26395d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[com.obric.autogui.agents.a.f.a.f26396e.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[com.obric.autogui.agents.a.f.a.f.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[com.obric.autogui.agents.a.f.a.g.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[com.obric.autogui.agents.a.f.a.f26392a.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[com.obric.autogui.agents.a.f.a.f26393b.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[com.obric.autogui.agents.a.f.a.f26394c.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[com.obric.autogui.agents.a.f.a.h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f26175a = r0;
        }
    }

    static {
        f26174a = new c();
    }

    private c() {
    }

    public final b a(com.obric.autogui.agents.a.f.a r2, Context r3, com.obric.autogui.operator.e r4, String r5, String r6) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "action");
        d.h.b.o.e(r1, "context");
        d.h.b.o.e(r4, "step");
        d.h.b.o.e(r5, "actionKey");
        d.h.b.o.e(r6, "attemptId");
        switch(a.f26175a[r2.ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            default: goto L5;
        };
    L5:
        throw new d.k();
    L14:
        return (b) ZeusTransformUtils.preCheckCast(new k(com.obric.autogui.operator.b.EnumC0777b.g), b.class, "com.obric.aiagent.plugin");
    L15:
        return (b) ZeusTransformUtils.preCheckCast(new k(com.obric.autogui.operator.b.EnumC0777b.f29870b), b.class, "com.obric.aiagent.plugin");
    L16:
        return (b) ZeusTransformUtils.preCheckCast(new g(), b.class, "com.obric.aiagent.plugin");
    L17:
        return (b) ZeusTransformUtils.preCheckCast(new i(r1, r4, r5, r6), b.class, "com.obric.aiagent.plugin");
    L18:
        return (b) ZeusTransformUtils.preCheckCast(new m(r4), b.class, "com.obric.aiagent.plugin");
    L19:
        return (b) ZeusTransformUtils.preCheckCast(new k(com.obric.autogui.operator.b.EnumC0777b.g), b.class, "com.obric.aiagent.plugin");
    L13:
        return (b) ZeusTransformUtils.preCheckCast(new o(r4), b.class, "com.obric.aiagent.plugin");
    }
}
