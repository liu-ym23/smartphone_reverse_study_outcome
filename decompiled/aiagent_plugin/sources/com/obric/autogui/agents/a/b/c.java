package com.obric.autogui.agents.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectDetectorFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f26276a = null;

    /* JADX INFO: compiled from: ActionEffectDetectorFactory.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26277a = null;

        static {
            int[] r0 = new int[com.obric.autogui.agents.a.f.c.values().length];
            r0[com.obric.autogui.agents.a.f.c.f26402a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[com.obric.autogui.agents.a.f.c.f26403b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[com.obric.autogui.agents.a.f.c.f26404c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[com.obric.autogui.agents.a.f.c.f26405d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[com.obric.autogui.agents.a.f.c.f26406e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[com.obric.autogui.agents.a.f.c.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[com.obric.autogui.agents.a.f.c.g.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f26277a = r0;
        }
    }

    static {
        f26276a = new c();
    }

    private c() {
    }

    public final com.obric.autogui.agents.a.b.a a(com.obric.autogui.agents.a.f.c r2) {
        o.e(r2, "type");
        switch(a.f26277a[r2.ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L5;
        };
    L5:
        throw new d.k();
    L14:
        return (com.obric.autogui.agents.a.b.a) ZeusTransformUtils.preCheckCast(g.f26280a, com.obric.autogui.agents.a.b.a.class, "com.obric.aiagent.plugin");
    L15:
        return (com.obric.autogui.agents.a.b.a) ZeusTransformUtils.preCheckCast(i.f26282a, com.obric.autogui.agents.a.b.a.class, "com.obric.aiagent.plugin");
    L16:
        return (com.obric.autogui.agents.a.b.a) ZeusTransformUtils.preCheckCast(f.f26279a, com.obric.autogui.agents.a.b.a.class, "com.obric.aiagent.plugin");
    L17:
        return (com.obric.autogui.agents.a.b.a) ZeusTransformUtils.preCheckCast(e.f26278a, com.obric.autogui.agents.a.b.a.class, "com.obric.aiagent.plugin");
    L18:
        return (com.obric.autogui.agents.a.b.a) ZeusTransformUtils.preCheckCast(j.f26284a, com.obric.autogui.agents.a.b.a.class, "com.obric.aiagent.plugin");
    L19:
        return (com.obric.autogui.agents.a.b.a) ZeusTransformUtils.preCheckCast(k.f26285a, com.obric.autogui.agents.a.b.a.class, "com.obric.aiagent.plugin");
    L13:
        return (com.obric.autogui.agents.a.b.a) ZeusTransformUtils.preCheckCast(h.f26281a, com.obric.autogui.agents.a.b.a.class, "com.obric.aiagent.plugin");
    }
}
