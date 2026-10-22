package com.obric.aiagent.skill.credentials.impl.c;

import com.bytedance.safetyguard.lxc.api.SafetyGuardLogLevel;
import com.bytedance.safetyguard.lxc.api.SafetyGuardLogger;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: SafetyGuardSidecarProvider.kt */
/* JADX INFO: loaded from: classes.dex */
final class a implements SafetyGuardLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19021a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.credentials.impl.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SafetyGuardSidecarProvider.kt */
    public /* synthetic */ class C0417a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19022a = null;

        static {
            int[] r0 = new int[SafetyGuardLogLevel.values().length];
            r0[SafetyGuardLogLevel.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[SafetyGuardLogLevel.INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[SafetyGuardLogLevel.WARN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[SafetyGuardLogLevel.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f19022a = r0;
        }
    }

    static {
        f19021a = new a();
    }

    private a() {
    }

    @Override // com.bytedance.safetyguard.lxc.api.SafetyGuardLogger
    public boolean isEnabled(SafetyGuardLogLevel r1, String r2) {
        o.e(r1, "level");
        o.e(r2, "tag");
        if (IAppContext.Companion.isDebug() == false) goto L5;
    L8:
        return true;
    L5:
        if (r1 != SafetyGuardLogLevel.DEBUG) goto L8;
        return false;
    }

    @Override // com.bytedance.safetyguard.lxc.api.SafetyGuardLogger
    public void log(SafetyGuardLogLevel r2, String r3, String r4) {
        o.e(r2, "level");
        o.e(r3, "tag");
        o.e(r4, "message");
        if (isEnabled(r2, r3) == true) goto L5;
        return;
    L5:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r1) == false) goto L8;
        r1 = "SkillCred/SafetyGuard";
    L8:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
        int r6 = C0417a.f19022a[r2.ordinal()];
        if (r6 != 1) goto L11;
        ILogDepend.Companion.d(r5, r4);
        return;
    L11:
        if (r6 != 2) goto L13;
        ILogDepend.Companion.i(r5, r4);
        return;
    L13:
        if (r6 != 3) goto L15;
        ILogDepend.Companion.w(r5, r4);
        return;
    L15:
        if (r6 != 4) goto L18;
        ILogDepend.Companion.e(r5, r4);
        return;
    L18:
        throw new k();
    }
}
