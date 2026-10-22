package com.obric.agent.intents.skill.c;

import android.os.SystemClock;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.l.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ShellInspectActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.c.a, a> {
    private static final String TAG = "ShellInspectActionExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f15034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15035b = null;

    /* JADX INFO: compiled from: ShellInspectActionExecutor.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("executions")
        private final List<d> f15036a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15036a, r6.f15036a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            List<d> r0 = this.f15036a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "InspectActionRequest(executions=" + this.f15036a + ')';
        }

        public final List<d> a() {
            return this.f15036a;
        }
    }

    private h() {
    }

    @Override // com.obric.agent.intents.skill.a.c
    public /* synthetic */ Object a(com.obric.agent.intents.skill.c.a r3, a r4, DispatchContext r5, d.c.d r6) {
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a2((com.obric.agent.intents.skill.c.a) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.intents.skill.c.a.class, "com.obric.aiagent.plugin"), (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"), r5, r7);
    }

    static {
        f15034a = new h();
        f15035b = "inspect";
    }

    @Override // com.obric.agent.intents.skill.a.c
    public String a() {
        return f15035b;
    }

    @Override // com.obric.agent.intents.skill.a.c
    public com.obric.agent.intents.skill.a.g<a> a(com.obric.agent.intents.skill.a.f r15) {
        o.e(r15, Ext.KEY_REQUEST);
        a r14 = (a) ZeusTransformUtils.preCheckCast(com.obric.agent.intents.skill.a.e.f14888a.a(r15.c(), a.class, TAG), a.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L5;
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(r14.a(), Collection.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L9;
    L12:
        boolean r17 = true;
    L13:
        if (r17 == false) goto L17;
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.a(new IntentResult(-2004, null, null, "executions is missing", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L17:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.b(r14), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L9:
        if (r16.isEmpty() == true) goto L12;
        r17 = false;
        goto L13
    L5:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.a(new IntentResult(103, null, null, "invalid inspect actionArgs", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public Object a2(com.obric.agent.intents.skill.c.a r9, a r10, DispatchContext r11, d.c.d<? super IntentResult<Empty>> r12) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        long r0 = SystemClock.elapsedRealtime();
        List<d> r13 = r10.a();
        if (r13 != null) goto L5;
        r13 = p.b();
    L5:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r14, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r14.iterator();
    L7:
        if (r16.hasNext() == false) goto L9;
        d r17 = (d) ZeusTransformUtils.preCheckCast(r16.next(), d.class, "com.obric.aiagent.plugin");
        r15.add(f15034a.a(r9, r17));
        goto L7
    L9:
        List<j.e> r18 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.e.a.f15181a.a(r9.b(), SystemClock.elapsedRealtime() - r0, 0, r18);
        return j.a(j.f15039a, new j.c(r18), 0, 2, null);
    }

    private final j.e a(com.obric.agent.intents.skill.c.a r9, d r10) {
        String r0 = r10.a();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L8;
        Long r1 = r10.b();
        if (r1 == null) goto L12;
        long r4 = r1.longValue();
    L14:
        if (r4 < 0) goto L29;
        Long r2 = r10.c();
        if (r2 == null) goto L18;
        long r5 = r2.longValue();
    L20:
        if (r5 < 0) goto L29;
        com.obric.aiagent.skill.ovirt.api.b.b.c r11 = r9.a().getShell().a(r9.b(), r0);
        if (r11 != null) goto L27;
        return j.f15039a.a(r0);
    L27:
        return a(r11, r10);
    L18:
        r5 = 0;
    L29:
        return j.f15039a.a("NORMAL", "char offset must not be negative", r0);
    L12:
        r4 = 0;
        goto L14
    L8:
        return j.a(j.f15039a, "NORMAL", "execution_id is missing", null, 4, null);
    }

    private final j.e a(com.obric.aiagent.skill.ovirt.api.b.b.c r10, d r11) {
        return j.a(j.f15039a, r10, null, null, null, a(r11.b()), a(r11.c()), 14, null);
    }

    private final int a(Long r3) {
        if (r3 != null) goto L6;
        return 0;
    L6:
        return (int) n.b(r3.longValue(), 2147483647L);
    }
}
