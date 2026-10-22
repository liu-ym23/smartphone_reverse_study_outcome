package com.obric.aiagent.skill.manager.impl.ui;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.skill.manager.impl.dh;
import com.obric.aiagent.skill.manager.impl.di;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashSet;
import java.util.Set;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SkillStoreUiErrors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cl {

    /* JADX INFO: compiled from: SkillStoreUiErrors.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20757a = null;

        static {
            int[] r0 = new int[com.obric.aiagent.skill.manager.api.r.values().length];
            r0[com.obric.aiagent.skill.manager.api.r.f19302c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[com.obric.aiagent.skill.manager.api.r.f19304e.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[com.obric.aiagent.skill.manager.api.r.f.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[com.obric.aiagent.skill.manager.api.r.g.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[com.obric.aiagent.skill.manager.api.r.h.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[com.obric.aiagent.skill.manager.api.r.i.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[com.obric.aiagent.skill.manager.api.r.j.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[com.obric.aiagent.skill.manager.api.r.k.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[com.obric.aiagent.skill.manager.api.r.n.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[com.obric.aiagent.skill.manager.api.r.m.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f20757a = r0;
        }
    }

    public static final cm.a a(Throwable r4) {
        d.h.b.o.e(r4, "throwable");
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
    L3:
        if (r4 == null) goto L24;
        if (r0.add(r4) == false) goto L32;
        if (ZeusTransformUtils.instanceOf(r4, com.obric.aiagent.skill.manager.impl.cd.class) == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r4, com.obric.aiagent.skill.manager.impl.bu.class) == false) goto L17;
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.impl.bu) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.manager.impl.bu.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.impl.bt.p.f19608a) == false) goto L17;
        return cm.a.f;
    L17:
        if (ZeusTransformUtils.instanceOf(r4, dh.class) == true) goto L19;
        r4 = r4.getCause();
        goto L3
    L19:
        if (((dh) ZeusTransformUtils.preCheckCast(r4, dh.class, "com.obric.aiagent.plugin")).a() != di.f19744b) goto L22;
        return cm.a.l;
    L22:
        return cm.a.m;
    L9:
        return cm.a.f20764e;
    L32:
        return null;
    L24:
        return null;
    }

    public static final cm.a a(com.obric.aiagent.skill.manager.api.u.a r3) {
        d.h.b.o.e(r3, "failure");
        com.obric.aiagent.skill.manager.api.s r0 = r3.d();
        if (r0 == null) goto L5;
        com.obric.aiagent.skill.manager.api.t r1 = r0.a();
    L7:
        if (r1 != com.obric.aiagent.skill.manager.api.t.R) goto L11;
        return cm.a.f;
    L11:
        switch(a.f20757a[r3.a().ordinal()]) {
            case 1: goto L18;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L21;
            case 5: goto L21;
            case 6: goto L21;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L19;
            default: goto L23;
        };
    L23:
        return null;
    L19:
        return cm.a.f20762c;
    L20:
        return cm.a.j;
    L21:
        return cm.a.m;
    L22:
        return cm.a.l;
    L18:
        return cm.a.f20764e;
    L5:
        r1 = null;
        goto L7
    }

    public static final void a(String r1, String r2, Throwable r3) {
        d.h.b.o.e(r1, "tag");
        d.h.b.o.e(r2, "action");
        d.h.b.o.e(r3, "throwable");
        if (IAppContext.Companion.isDebug() == false) goto L5;
        b("SkillManager", r2 + " failed", r3);
        return;
    L5:
        a("SkillManager", "skill store operation failed");
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
