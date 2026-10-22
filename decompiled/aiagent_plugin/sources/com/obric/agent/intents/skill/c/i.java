package com.obric.agent.intents.skill.c;

import android.os.SystemClock;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ShellKillActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements com.obric.agent.intents.skill.a.c<a, d> {
    private static final String TAG = "ShellKillActionExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f15037a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15038b = null;

    private i() {
    }

    @Override // com.obric.agent.intents.skill.a.c
    public /* synthetic */ Object a(a r3, d r4, DispatchContext r5, d.c.d r6) {
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"), r5, r7);
    }

    static {
        f15037a = new i();
        f15038b = "kill";
    }

    @Override // com.obric.agent.intents.skill.a.c
    public String a() {
        return f15038b;
    }

    @Override // com.obric.agent.intents.skill.a.c
    public com.obric.agent.intents.skill.a.g<d> a(com.obric.agent.intents.skill.a.f r15) {
        o.e(r15, Ext.KEY_REQUEST);
        d r14 = (d) ZeusTransformUtils.preCheckCast(com.obric.agent.intents.skill.a.e.f14888a.a(r15.c(), d.class, TAG), d.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L5;
        String r16 = r14.a();
        if (r16 != null) goto L10;
        r16 = "";
    L10:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L14;
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.a(new IntentResult(-2004, null, null, "execution_id is missing", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L14:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.b(r14), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L5:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.a(new IntentResult(103, null, null, "invalid kill actionArgs", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public Object a2(a r8, d r9, DispatchContext r10, d.c.d<? super IntentResult<Empty>> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        long r13 = SystemClock.elapsedRealtime();
        String r14 = r9.a();
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        String r1 = r14;
        com.obric.aiagent.skill.ovirt.api.b.b.c r15 = r8.a().getShell().a(r8.b(), r1);
        if (r15 != null) goto L10;
        return a(r8, r13, j.a(j.f15039a, r1, true, null, null, 12, null));
    L10:
        if (r15.f() == false) goto L14;
        return a(r8, r13, j.a(j.f15039a, r1, true, null, r15.l(), 4, null));
    L14:
        if (r8.a().getShell().a(r8.b(), r1, true) == false) goto L16;
        com.obric.aiagent.skill.ovirt.api.b.b.c r0 = r8.a().getShell().a(r8.b(), r1);
        if (r0 == null) goto L22;
        r15 = r0;
    L22:
        return a(r8, r13, j.a(j.f15039a, r1, true, null, r15.l(), 4, null));
    L16:
        return a(r8, r13, j.a(j.f15039a, r1, false, "Kill failed", null, 8, null));
    }

    private final IntentResult<Empty> a(a r7, long r8, j.b r10) {
        com.obric.agent.intents.skill.e.a.f15181a.a(r7.b(), SystemClock.elapsedRealtime() - r8, 0, r10);
        return j.a(j.f15039a, r10, 0, 2, null);
    }
}
