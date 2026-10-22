package com.obric.agent.intents.skill.d;

import android.os.SystemClock;
import com.google.gson.annotations.SerializedName;
import com.obric.agent.ObricService;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.skill.manager.api.al;
import com.obric.aiagent.skill.manager.api.aq;
import com.obric.aiagent.skill.manager.api.as;
import com.obric.aiagent.skill.manager.api.q;
import com.obric.aiagent.skill.manager.api.u;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: SkillLoadActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.a.b, b> {
    private static final String TAG = "SkillLoadActionExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f15146a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15147b = null;

    /* JADX INFO: compiled from: SkillLoadActionExecutor.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("skill_id")
        private final String f15148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("is_success")
        private final boolean f15149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("skill_name")
        private final String f15150c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("work_dir")
        private final String f15151d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("content")
        private final String f15152e;

        @SerializedName("tool_schema")
        private final String f;

        @SerializedName("truncated")
        private final Boolean g;

        @SerializedName("error_code")
        private final Integer h;

        @SerializedName("error_msg")
        private final String i;

        @SerializedName("install_type")
        private final String j;

        @SerializedName("version")
        private final Integer k;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15148a, r6.f15148a) == true) goto L12;
            return false;
        L12:
            if (this.f15149b == r6.f15149b) goto L15;
            return false;
        L15:
            if (o.a(this.f15150c, r6.f15150c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f15151d, r6.f15151d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f15152e, r6.f15152e) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (o.a(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (o.a(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (o.a(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (o.a(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (o.a(this.k, r6.k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f15148a.hashCode() * 31) + Boolean.hashCode(this.f15149b)) * 31;
            String r1 = this.f15150c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f15151d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f15152e;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.f;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Boolean r14 = this.g;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            Integer r17 = this.h;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.i;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            String r23 = this.j;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            Integer r26 = this.k;
            if (r26 == null) goto L39;
            r2 = r26.hashCode();
        L39:
            return r25 + r2;
        L33:
            r24 = r23.hashCode();
            goto L34
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("LoadSkillResult(skillId=").append(this.f15148a).append(", isSuccess=").append(this.f15149b).append(", skillName=").append(this.f15150c).append(", workDir=").append(this.f15151d).append(", skillContent=").append(this.f15152e).append(", toolSchema=").append(this.f).append(", truncated=").append(this.g).append(", errorCode=").append(this.h).append(", errorMsg=").append(this.i).append(", installType=").append(this.j).append(", version=").append(this.k).append(')');
            return r0.toString();
        }

        public a(String r2, boolean r3, String r4, String r5, String r6, String r7, Boolean r8, Integer r9, String r10, String r11, Integer r12) {
            o.e(r2, "skillId");
            this.f15148a = r2;
            this.f15149b = r3;
            this.f15150c = r4;
            this.f15151d = r5;
            this.f15152e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
        }

        public /* synthetic */ a(String r16, boolean r17, String r18, String r19, String r20, String r21, Boolean r22, Integer r23, String r24, String r25, Integer r26, int r27, d.h.b.h r28) {
            if ((r27 & 4) == 0) goto L5;
            String r6 = null;
        L7:
            if ((r27 & 8) == 0) goto L9;
            String r7 = null;
        L11:
            if ((r27 & 16) == 0) goto L13;
            String r8 = null;
        L15:
            if ((r27 & 32) == 0) goto L17;
            String r9 = null;
        L19:
            if ((r27 & 64) == 0) goto L21;
            Boolean r10 = null;
        L23:
            if ((r27 & 128) == 0) goto L25;
            Integer r11 = null;
        L27:
            if ((r27 & 256) == 0) goto L29;
            String r12 = null;
        L31:
            if ((r27 & 512) == 0) goto L33;
            String r13 = null;
        L35:
            if ((r27 & 1024) == 0) goto L37;
            Integer r14 = null;
        L38:
            this(r16, r17, r6, r7, r8, r9, r10, r11, r12, r13, r14);
            return;
        L37:
            r14 = r26;
            goto L38
        L33:
            r13 = r25;
            goto L35
        L29:
            r12 = r24;
            goto L31
        L25:
            r11 = r23;
            goto L27
        L21:
            r10 = r22;
            goto L23
        L17:
            r9 = r21;
            goto L19
        L13:
            r8 = r20;
            goto L15
        L9:
            r7 = r19;
            goto L11
        L5:
            r6 = r18;
            goto L7
        }

        public final String a() {
            return this.f15148a;
        }

        public final boolean b() {
            return this.f15149b;
        }

        public final String c() {
            return this.f15150c;
        }

        public final String d() {
            return this.f15151d;
        }

        public final String e() {
            return this.f15152e;
        }

        public final String f() {
            return this.f;
        }

        public final Boolean g() {
            return this.g;
        }

        public final Integer h() {
            return this.h;
        }

        public final String i() {
            return this.i;
        }

        public final String j() {
            return this.j;
        }

        public final Integer k() {
            return this.k;
        }
    }

    /* JADX INFO: compiled from: SkillLoadActionExecutor.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("skills")
        private final List<d> f15153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15154b;

        public static /* synthetic */ b a(b r1, List r2, String r3, int r4, Object r5) {
            List<d> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r6 = r1.f15153a;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = r1.f15154b;
        L9:
            return r1.a(r6, r3);
        }

        public final b a(List<d> r2, String r3) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            o.e(r3, "uniqueId");
            return new b(r1, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15153a, r6.f15153a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f15154b, r6.f15154b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            List<d> r0 = this.f15153a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f15154b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "LoadSkillsActionRequest(skills=" + this.f15153a + ", uniqueId=" + this.f15154b + ')';
        }

        public b(List<d> r3, String r4) {
            List<d> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "uniqueId");
            this.f15153a = r5;
            this.f15154b = r4;
        }

        public final List<d> a() {
            return this.f15153a;
        }

        public final String b() {
            return this.f15154b;
        }
    }

    /* JADX INFO: compiled from: SkillLoadActionExecutor.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("results")
        private final List<a> f15155a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15155a, r6.f15155a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f15155a.hashCode();
        }

        public String toString() {
            return "LoadSkillsResult(results=" + this.f15155a + ')';
        }

        public c(List<a> r3) {
            List<a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "results");
            this.f15155a = r4;
        }

        public final List<a> a() {
            return this.f15155a;
        }
    }

    /* JADX INFO: compiled from: SkillLoadActionExecutor.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("skill_id")
        private final String f15156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("version")
        private final Integer f15157b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15156a, r6.f15156a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f15157b, r6.f15157b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f15156a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.f15157b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "SkillRef(skillId=" + this.f15156a + ", version=" + this.f15157b + ')';
        }

        public final String a() {
            return this.f15156a;
        }

        public final Integer b() {
            return this.f15157b;
        }
    }

    /* JADX INFO: compiled from: SkillLoadActionExecutor.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f15159b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15158a, r6.f15158a) == true) goto L12;
            return false;
        L12:
            if (this.f15159b == r6.f15159b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f15158a.hashCode() * 31) + Boolean.hashCode(this.f15159b);
        }

        public String toString() {
            return "TrimmedText(content=" + this.f15158a + ", truncated=" + this.f15159b + ')';
        }

        public e(String r2, boolean r3) {
            o.e(r2, "content");
            this.f15158a = r2;
            this.f15159b = r3;
        }

        public final String a() {
            return this.f15158a;
        }

        public final boolean b() {
            return this.f15159b;
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.intents.skill.d.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SkillLoadActionExecutor.kt */
    @d.c.b.a.f(b = "SkillLoadActionExecutor.kt", c = {84}, d = "invokeSuspend", e = "com.obric.agent.intents.skill.systemskill.SkillLoadActionExecutor$execute$2")
    static final class C0308f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f15160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f15161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f15162c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ DispatchContext f15163d;

        C0308f(b r3, DispatchContext r4, d.c.d<? super C0308f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15162c = r3;
            this.f15163d = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0308f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0308f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0308f(this.f15162c, this.f15163d, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r31) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f15161b;
            if (r2 == 0) goto L12;
            if (r2 != 1) goto L11;
            long r5 = this.f15160a;
            d.o.a(r31);     // Catch: Exception -> L8 CancellationException -> L30
            Object r3 = r31;
        L17:
            IntentResult<?> r1 = (IntentResult) ZeusTransformUtils.preCheckCast(r3, IntentResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8 CancellationException -> L30
        L37:
            AtomicCapabilitySdk.INSTANCE.updateIntentResult(r1, this.f15163d, true);     // Catch: Exception -> L24 CancellationException -> L28
        L27:
            return x.f38692a;
        L28:
            e = move-exception;
            throw e;
        L24:
            e = move-exception;
            f.a(f.f15146a, "load_skill final delivery failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), null, 4, null);
        L8:
            e = e;
            long r9 = r5;
        L21:
            f.a(f.f15146a, "load_skill async final failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), null, 4, null);
            r1 = new IntentResult(-2002, null, null, "operation failed", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
            f.a(f.f15146a, this.f15162c, r9, r1, null, 8, null);
            goto L37
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            d.o.a(r31);
            long r11 = SystemClock.elapsedRealtime();
            f r6 = f.f15146a;     // Catch: Exception -> L19 CancellationException -> L30
            b r7 = this.f15162c;     // Catch: Exception -> L19 CancellationException -> L30
            DispatchContext r8 = this.f15163d;     // Catch: Exception -> L19 CancellationException -> L30
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19 CancellationException -> L30
            this.f15160a = r11;     // Catch: Exception -> L19 CancellationException -> L30
            this.f15161b = 1;     // Catch: Exception -> L19 CancellationException -> L30
            r3 = f.a(r6, r7, r8, r11, r10);     // Catch: Exception -> L19 CancellationException -> L30
            if (r3 != r0) goto L16;
            return r0;
        L16:
            r5 = r11;
        L19:
            e = e;
            r9 = r11;
        L30:
            e = move-exception;
            throw e;
        }
    }

    /* JADX INFO: compiled from: SkillLoadActionExecutor.kt */
    @d.c.b.a.f(b = "SkillLoadActionExecutor.kt", c = {171, 197}, d = "executeLoadSkills", e = "com.obric.agent.intents.skill.systemskill.SkillLoadActionExecutor")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15166c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f15167d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f15168e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        long k;
        int l;
        /* synthetic */ Object m;
        final /* synthetic */ f n;
        int o;

        g(f r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.n = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.m = r7;
            this.o |= Integer.MIN_VALUE;
            return f.a(this.n, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private f() {
    }

    public static final /* synthetic */ Object a(f r6, b r7, DispatchContext r8, long r9, d.c.d r11) {
        return r6.a(r7, r8, r9, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.agent.intents.skill.a.c
    public /* synthetic */ Object a(com.obric.agent.intents.skill.a.b r3, b r4, DispatchContext r5, d.c.d r6) {
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a2((com.obric.agent.intents.skill.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.intents.skill.a.b.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin"), r5, r7);
    }

    static {
        f15146a = new f();
        f15147b = "load_skill";
    }

    @Override // com.obric.agent.intents.skill.a.c
    public String a() {
        return f15147b;
    }

    @Override // com.obric.agent.intents.skill.a.c
    public com.obric.agent.intents.skill.a.g<b> a(com.obric.agent.intents.skill.a.f r18) {
        o.e(r18, Ext.KEY_REQUEST);
        b r0 = (b) ZeusTransformUtils.preCheckCast(com.obric.agent.intents.skill.a.e.f14888a.a(r18.c(), b.class, TAG), b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r0.a(), Collection.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L17;
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.a(new IntentResult(-2004, null, null, "skills is missing", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L17:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.b(b.a(r0, null, r18.a(), 1, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.a(new IntentResult(103, null, null, "invalid load_skill actionArgs", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public Object a2(com.obric.agent.intents.skill.a.b r7, b r8, DispatchContext r9, d.c.d<? super IntentResult<Empty>> r10) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(com.obric.agent.intents.skill.a.h.f14894a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new C0308f(r8, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return com.obric.agent.intents.skill.a.d.a("System_Skill action accepted");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x03dd -> B:110:0x03e7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:123:0x0479 -> B:134:0x0574). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:133:0x0546 -> B:134:0x0574). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x0390 -> B:161:0x039b). Please report as a decompilation issue!!! */
    private final Object a(b r38, DispatchContext r39, long r40, d.c.d<? super IntentResult<Empty>> r42) {
        String r2 = "com.obric.aiagent.plugin";
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r42, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, g.class) == false) goto L7;
        g r3 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.aiagent.plugin");
        if ((r3.o & Integer.MIN_VALUE) == 0) goto L7;
        r3.o -= Integer.MIN_VALUE;
        f r4 = this;
    L8:
        Object r5 = r3.m;
        Object r6 = d.c.a.b.a();
        int r7 = r3.o;
        String r10 = TAG;
        if (r7 == 0) goto L26;
        if (r7 == 1) goto L19;
        if (r7 != 2) goto L18;
        int r8 = r3.l;
        long r13 = r3.k;
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r3.j, Collection.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.manager.api.c r11 = (com.obric.aiagent.skill.manager.api.c) ZeusTransformUtils.preCheckCast(r3.i, com.obric.aiagent.skill.manager.api.c.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r3.h, String.class, "com.obric.aiagent.plugin");
        Iterator r14 = (Iterator) ZeusTransformUtils.preCheckCast(r3.g, Iterator.class, "com.obric.aiagent.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(r3.f, Collection.class, "com.obric.aiagent.plugin");
        al r16 = (al) ZeusTransformUtils.preCheckCast(r3.f15168e, al.class, "com.obric.aiagent.plugin");
        List r17 = (List) ZeusTransformUtils.preCheckCast(r3.f15167d, List.class, "com.obric.aiagent.plugin");
        ISkillManagerService r18 = (ISkillManagerService) ZeusTransformUtils.preCheckCast(r3.f15166c, ISkillManagerService.class, "com.obric.aiagent.plugin");
        b r19 = (b) ZeusTransformUtils.preCheckCast(r3.f15165b, b.class, "com.obric.aiagent.plugin");
        f r110 = (f) ZeusTransformUtils.preCheckCast(r3.f15164a, f.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Throwable -> L15
        String r20 = "com.obric.aiagent.plugin";
        b r21 = r19;
        Object r22 = r6;
        String r111 = TAG;
        int r112 = r8;
        al r23 = r16;
        List r24 = r17;
        String r37 = "load skill failed";
        f r25 = r110;
        long r113 = r13;
        Collection r114 = r15;
        Iterator r115 = r14;
        Collection r116 = r9;
        ISkillManagerService r26 = r18;
    L161:
        x r0 = x.f38692a;     // Catch: Throwable -> L92
        long r117 = r113;
        al r118 = r23;
        int r27 = r112;
    L168:
        Object r28 = n.f(r0);     // Catch: Throwable -> L103
    L110:
        Iterator r29 = r115;
        Collection r210 = r114;
        al r211 = r118;
        long r212 = r117;
        String r119 = r12;
        Collection r120 = r116;
        Throwable r121 = n.c(r28);
        if (r121 != null) goto L113;
    L181:
        a r30 = f15146a.a(r119, r11.a(), r11.b(), r27, r211.y());     // Catch: Exception -> L118
        String r31 = r37;
        String r122 = r20;
    L120:
        int r32 = r27;
        r111 = r111;
        r114 = r210;
        r118 = r211;
        long r123 = r212;
        String r34 = r31;
        b r33 = r21;
        List r35 = r24;
        ISkillManagerService r36 = r26;
        Collection r41 = r120;
        r3 = r3;
        String r43 = r122;
        Object r124 = r22;
        String r44 = r34;
    L134:
        r41.add(r30);
        r4 = r25;
        long r45 = r123;
        r116 = r114;
        r115 = r29;
        String r125 = r44;
        r2 = r43;
        r3 = r3;
        String r310 = r111;
        Object r126 = r124;
        r10 = r310;
    L37:
        if (r115.hasNext() == false) goto L136;
        r37 = r125;
        d r46 = (d) ZeusTransformUtils.preCheckCast(r115.next(), d.class, r2);
        String r127 = r46.a();
        if (r127 != null) goto L41;
        r127 = "";
    L41:
        Object r47 = r126;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r127, CharSequence.class, r2)) == false) goto L45;
        String r128 = r10;
        r30 = f15146a.a(r127, 1001, "skill_id is missing");
        r124 = r47;
        r3 = r3;
        r114 = r116;
        r29 = r115;
        r111 = r128;
        r43 = r2;
        r44 = r37;
        r123 = r45;
        r41 = r114;
        r25 = r4;
        goto L134
    L45:
        r111 = r10;
        Integer r48 = r46.b();
        String r129 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r127, CharSequence.class, r2)).toString();
        Iterator r130 = ((Iterable) ZeusTransformUtils.preCheckCast(r35, Iterable.class, r2)).iterator();
    L47:
        if (r130.hasNext() == false) goto L52;
        int r131 = r32;
        Object r49 = r130.next();
        Iterator r410 = r130;
        if (o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r49, com.obric.aiagent.skill.manager.api.e.class, r2)).a(), r129) == true) goto L53;
        r130 = r410;
        r32 = r131;
    L53:
        com.obric.aiagent.skill.manager.api.e r50 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r49, com.obric.aiagent.skill.manager.api.e.class, r2);
        if (r50 == null) goto L56;
        aq r132 = r50.g();
    L58:
        if (ZeusTransformUtils.instanceOf(r132, aq.b.class) == false) goto L163;
        int r51 = r50.j();
        if (r48 != null) goto L63;
    L64:
        r30 = f15146a.a(r127);
        r124 = r47;
        r3 = r3;
        r114 = r116;
        r29 = r115;
        r111 = r111;
        r32 = r131;
        r43 = r2;
        r44 = r37;
        r123 = r45;
        r41 = r114;
        r25 = r4;
        goto L134
    L63:
        if (r51 != r48.intValue()) goto L64;
    L163:
        String r52 = r33.b();     // Catch: CancellationException -> L24 Exception -> L130
        r3.f15164a = r4;     // Catch: CancellationException -> L24 Exception -> L130
        r3.f15165b = r33;     // Catch: CancellationException -> L24 Exception -> L130
        r3.f15166c = r36;     // Catch: CancellationException -> L24 Exception -> L130
        r3.f15167d = r35;     // Catch: CancellationException -> L24 Exception -> L130
        r3.f15168e = r118;     // Catch: CancellationException -> L24 Exception -> L130
        r3.f = r116;     // Catch: CancellationException -> L24 Exception -> L130
        r3.g = r115;     // Catch: CancellationException -> L24 Exception -> L130
        r3.h = r127;     // Catch: CancellationException -> L24 Exception -> L130
        r3.i = r116;     // Catch: CancellationException -> L24 Exception -> L130
        r3.j = null;     // Catch: CancellationException -> L24 Exception -> L130
        r3.k = r45;     // Catch: CancellationException -> L24 Exception -> L130
        r112 = r131;
        r3.l = r112;     // Catch: CancellationException -> L24 Exception -> L128
        r3.o = 1;     // Catch: CancellationException -> L24 Exception -> L128
        Object r53 = r36.loadSkill(r127, r52, r3);     // Catch: CancellationException -> L24 Exception -> L128
        if (r53 != r47) goto L71;
        return r47;
    L71:
        f r133 = r4;
        Object r134 = r47;
        b r54 = r33;
        r12 = r127;
        long r55 = r45;
        r114 = r116;
        r26 = r36;
        r24 = r35;
        r5 = r53;
    L179:
        u r56 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, r2);     // Catch: CancellationException -> L24 Exception -> L126
        if (ZeusTransformUtils.instanceOf(r56, u.b.class) == false) goto L121;
        com.obric.aiagent.skill.manager.api.c r57 = (com.obric.aiagent.skill.manager.api.c) ZeusTransformUtils.preCheckCast(((u.b) ZeusTransformUtils.preCheckCast(r56, u.b.class, r2)).a(), com.obric.aiagent.skill.manager.api.c.class, r2);
        n.a r58 = n.f38560a;     // Catch: Throwable -> L105
        IOVirtService r59 = IOVirtService.Companion.a();     // Catch: Throwable -> L105
        if (r59 == null) goto L100;
        IOVirtService.e r60 = r59.getTask();     // Catch: Throwable -> L105
        if (r60 == null) goto L100;
        r20 = r2;
        String r61 = r54.b();     // Catch: Throwable -> L98
        String r62 = r57.a().a();     // Catch: Throwable -> L98
        List<String> r63 = r57.c();     // Catch: Throwable -> L98
        r3.f15164a = r133;     // Catch: Throwable -> L98
        r3.f15165b = r54;     // Catch: Throwable -> L98
        r3.f15166c = r26;     // Catch: Throwable -> L98
        r3.f15167d = r24;     // Catch: Throwable -> L98
        r3.f15168e = r118;     // Catch: Throwable -> L98
        r3.f = r114;     // Catch: Throwable -> L98
        r3.g = r115;     // Catch: Throwable -> L98
        r3.h = r12;     // Catch: Throwable -> L98
        r3.i = r57;     // Catch: Throwable -> L98
        r3.j = r116;     // Catch: Throwable -> L98
        r3.k = r55;     // Catch: Throwable -> L98
        r3.l = r112;     // Catch: Throwable -> L98
        com.obric.aiagent.skill.manager.api.c r411 = r57;
        r3.o = 2;     // Catch: Throwable -> L96
        b r311 = r54;
        Object r64 = r134;
        if (r60.skillLoaded(r61, r62, r63, r3) != r64) goto L89;
        return r64;
    L89:
        r22 = r64;
        r23 = r118;
        r21 = r311;
        long r312 = r55;
        r11 = r411;
        r25 = r133;
        r113 = r312;
    L94:
        Throwable th = th;
    L108:
        r22 = r134;
        r27 = r112;
        r21 = r311;
        long r313 = r55;
        r11 = r411;
        r25 = r133;
        r117 = r313;
    L109:
        n.a r135 = n.f38560a;
        r28 = n.f(d.o.a(th));
    L96:
        th = th;
    L107:
        r311 = r54;
    L98:
        th = th;
        r411 = r57;
        goto L107
    L100:
        r20 = r2;
        b r314 = r54;
        r22 = r134;
        r27 = r112;
        r0 = null;
        r21 = r314;
        long r315 = r55;
        r11 = r57;
        r25 = r133;
        r117 = r315;
        goto L168
    L186:
        r20 = r2;
        b r316 = r54;
        r22 = r134;
        r27 = r112;
        r0 = null;
        r21 = r316;
        long r317 = r55;
        r11 = r57;
        r25 = r133;
        r117 = r317;
    L105:
        th = th;
        r411 = r57;
        r20 = r2;
        goto L107
    L121:
        b r318 = r54;
        String r65 = r2;
        r44 = r37;
        if (ZeusTransformUtils.instanceOf(r56, u.a.class) == false) goto L125;
        g r213 = r3;
        List r214 = r24;
        String r66 = r111;
        ILogDepend.Companion.e(r66, "load_skill failed skillId=" + r12 + ", code=" + ((u.a) ZeusTransformUtils.preCheckCast(r56, u.a.class, r65)).a() + ", diagnostic=" + ((u.a) ZeusTransformUtils.preCheckCast(r56, u.a.class, r65)).c() + ", retryable=" + ((u.a) ZeusTransformUtils.preCheckCast(r56, u.a.class, r65)).b());
        r30 = f15146a.a(r12, (u.a) ZeusTransformUtils.preCheckCast(r56, u.a.class, r65));
        r33 = r318;
        r43 = r65;
        r29 = r115;
        r35 = r214;
        f r319 = r133;
        r111 = r66;
        r36 = r26;
        r41 = r116;
        r123 = r55;
        r32 = r112;
        r25 = r319;
        r124 = r134;
        r3 = r213;
        goto L134
    L125:
        throw new d.k();
    L126:
        Exception e2 = e;
        g r215 = r3;
        b r320 = r54;
        List r216 = r24;
        String r67 = r2;
        r44 = r37;
        r43 = r67;
        r36 = r26;
        r41 = r116;
        Iterator r321 = r115;
        r54 = r320;
        r123 = r55;
        Collection r68 = r114;
        r47 = r134;
        r3 = r215;
        List r322 = r216;
        r127 = r12;
        f r69 = r133;
        r111 = r111;
    L133:
        f r70 = f15146a;
        a(r70, "load_skill manager boundary failed", (Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, r43), null, 4, null);
        r30 = r70.a(r127, 1002, r44);
        r29 = r321;
        r35 = r322;
        r114 = r68;
        r25 = r69;
        r33 = r54;
        int r323 = r112;
        r124 = r47;
        r32 = r323;
    L128:
        e2 = e;
    L132:
        r43 = r2;
        r44 = r37;
        r322 = r35;
        r321 = r115;
        b r324 = r33;
        r69 = r4;
        r54 = r324;
        long r325 = r45;
        r41 = r116;
        r123 = r325;
        r68 = r41;
        goto L133
    L24:
        e = move-exception;
        throw e;
    L130:
        e2 = e;
        r112 = r131;
        goto L132
    L56:
        r132 = null;
        goto L58
    L52:
        r131 = r32;
        r49 = null;
        goto L53
    L136:
        String r71 = r2;
        String r136 = r10;
        int r137 = r32;
        List<a> r72 = (List) ZeusTransformUtils.preCheckCast(r116, List.class, r71);
        String r217 = r4.a(new c(r72));
        if (r217 != null) goto L140;
        IntentResult<Empty> r73 = new IntentResult(-2002, null, null, "result serialization failed", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        r4.a(r33, r45, r73, r72);
        return r73;
    L140:
        long r74 = SystemClock.elapsedRealtime() - r45;
        ILogDepend.Companion r75 = ILogDepend.Companion;
        StringBuilder r76 = new StringBuilder().append("load_skill done count=").append(r72.size()).append(" success=");
        Iterable r138 = (Iterable) ZeusTransformUtils.preCheckCast(r72, Iterable.class, r71);
        int r139 = 0;
        if (ZeusTransformUtils.instanceOf(r138, Collection.class) == true) goto L143;
    L145:
        Iterator r140 = r138.iterator();
    L147:
        if (r140.hasNext() == false) goto L153;
        if (((a) ZeusTransformUtils.preCheckCast(r140.next(), a.class, r71)).b() == false) goto L147;
        r139 = r139 + 1;
        if (r139 >= 0) goto L147;
        p.d();
    L153:
        r75.i(r136, r76.append(r139).append(" limitChars=").append(r137).append(" costMs=").append(r74).toString());
        IntentResult<Empty> r77 = new IntentResult(0, null, null, r217, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        r4.a(r33, r45, r77, r72);
        return r77;
    L143:
        if (((Collection) ZeusTransformUtils.preCheckCast(r138, Collection.class, r71)).isEmpty() == false) goto L145;
    L118:
        e = move-exception;
        f r78 = f15146a;
        r122 = r20;
        r78.a("build load_skill result failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, r122), "build load_skill result failed skillId=" + r119);
        r31 = r37;
        r30 = r78.a(r119, 1002, r31);
        goto L120
    L113:
        if (ZeusTransformUtils.instanceOf(r121, CancellationException.class) == true) goto L115;
        a(f15146a, "load_skill OVirt hook failed", r121, null, 4, null);
        goto L181
    L115:
        throw r121;
    L103:
        th = th;
    L92:
        th = th;
        r117 = r113;
        r118 = r23;
        r27 = r112;
    L15:
        th = th;
        r20 = "com.obric.aiagent.plugin";
        r21 = r19;
        r22 = r6;
        r111 = TAG;
        r27 = r8;
        r24 = r17;
        r37 = "load skill failed";
        r25 = r110;
        r117 = r13;
        r118 = r16;
        r114 = r15;
        r115 = r14;
        r116 = r9;
        r26 = r18;
        goto L109
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        int r79 = r3.l;
        long r80 = r3.k;
        r41 = (Collection) ZeusTransformUtils.preCheckCast(r3.i, Collection.class, "com.obric.aiagent.plugin");
        String r141 = (String) ZeusTransformUtils.preCheckCast(r3.h, String.class, "com.obric.aiagent.plugin");
        r115 = (Iterator) ZeusTransformUtils.preCheckCast(r3.g, Iterator.class, "com.obric.aiagent.plugin");
        r114 = (Collection) ZeusTransformUtils.preCheckCast(r3.f, Collection.class, "com.obric.aiagent.plugin");
        r118 = (al) ZeusTransformUtils.preCheckCast(r3.f15168e, al.class, "com.obric.aiagent.plugin");
        r322 = (List) ZeusTransformUtils.preCheckCast(r3.f15167d, List.class, "com.obric.aiagent.plugin");
        ISkillManagerService r81 = (ISkillManagerService) ZeusTransformUtils.preCheckCast(r3.f15166c, ISkillManagerService.class, "com.obric.aiagent.plugin");
        r54 = (b) ZeusTransformUtils.preCheckCast(r3.f15165b, b.class, "com.obric.aiagent.plugin");
        r133 = (f) ZeusTransformUtils.preCheckCast(r3.f15164a, f.class, "com.obric.aiagent.plugin");
        d.o.a(r5);     // Catch: Exception -> L22 CancellationException -> L24
        r134 = r6;
        r111 = TAG;
        r112 = r79;
        r24 = r322;
        r37 = "load skill failed";
        r55 = r80;
        r12 = r141;
        r116 = r41;
        r26 = r81;
    L22:
        e2 = e;
        r3 = r3;
        r43 = "com.obric.aiagent.plugin";
        r44 = "load skill failed";
        r68 = r114;
        r127 = r141;
        r112 = r79;
        r321 = r115;
        r123 = r80;
        r69 = r133;
        r47 = r6;
        r111 = TAG;
        r36 = r81;
        goto L133
    L26:
        d.o.a(r5);
        ISkillManagerService r82 = ISkillManagerService.Companion.a();
        if (r82 != null) goto L30;
        IntentResult r83 = new IntentResult(-2002, null, null, "service unavailable", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        a(this, r38, r40, r83, null, 8, null);
        return r83;
    L30:
        u<List<com.obric.aiagent.skill.manager.api.e>> r84 = r82.getInstalledSkills();
        if (ZeusTransformUtils.instanceOf(r84, u.b.class) == false) goto L156;
        r35 = (List) ZeusTransformUtils.preCheckCast(((u.b) ZeusTransformUtils.preCheckCast(r84, u.b.class, "com.obric.aiagent.plugin")).a(), List.class, "com.obric.aiagent.plugin");
        al r85 = al.f19195a.a();
        r32 = r85.a();
        List<d> r86 = r38.a();
        if (r86 != null) goto L35;
        r86 = p.b();
    L35:
        Iterable r87 = (Iterable) ZeusTransformUtils.preCheckCast(r86, Iterable.class, "com.obric.aiagent.plugin");
        r116 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r87, 10)), Collection.class, "com.obric.aiagent.plugin");
        r126 = r6;
        r118 = r85;
        r125 = "load skill failed";
        r115 = r87.iterator();
        r33 = r38;
        r45 = r40;
        r36 = r82;
        goto L37
    L156:
        if (ZeusTransformUtils.instanceOf(r84, u.a.class) == false) goto L160;
        ILogDepend.Companion.e(TAG, "load_skill manager unavailable, code=" + ((u.a) ZeusTransformUtils.preCheckCast(r84, u.a.class, "com.obric.aiagent.plugin")).a());
        IntentResult r88 = new IntentResult(-2002, null, null, "service unavailable", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        a(this, r38, r40, r88, null, 8, null);
        return r88;
    L160:
        throw new d.k();
    L7:
        r4 = this;
        r3 = new g(r4, r1);
        goto L8
    }

    static /* synthetic */ void a(f r6, b r7, long r8, IntentResult r10, List r11, int r12, Object r13) {
        List<a> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 8) == 0) goto L5;
        r14 = p.b();
    L5:
        r6.a(r7, r8, r10, r14);
    }

    private final void a(b r8, long r9, IntentResult<Empty> r11, List<a> r12) {
        List<a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.e.a r0 = com.obric.agent.intents.skill.e.a.f15181a;
        String r1 = r8.b();
        long r2 = SystemClock.elapsedRealtime() - r9;
        int r4 = r11.getRet();
        List<d> r7 = r8.a();
        if (r7 != null) goto L5;
        r7 = p.b();
    L5:
        r0.a(r1, r2, r4, r7, r6);
    }

    private final a a(String r18, com.obric.aiagent.skill.manager.api.e r19, String r20, int r21, boolean r22) {
        e r0 = a(a(r19.k(), r19.a(), r22), r21);
        aq r1 = r19.g();
        CharSequence r2 = null;
        if (r1 == null) goto L7;
        q r3 = as.a(r1);
        if (r3 == null) goto L7;
        String r13 = r3.a();
    L8:
        String r6 = r19.b();
        String r8 = r0.a();
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r19.q(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r4) == true) goto L13;
        r2 = r4;
    L13:
        return new a(r18, true, r6, r20, r8, (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), Boolean.valueOf(r0.b()), null, null, r13, Integer.valueOf(r19.j()), 384, null);
    L7:
        r13 = null;
        goto L8
    }

    private final String a(String r1, String r2, boolean r3) {
        if (o.a(r2, "skill-installer") == false) goto L8;
        if (r3 == true) goto L8;
        return h.a().b() + "\n\n" + r1;
    L8:
        return r1;
    }

    private final a a(String r3) {
        return a(r3, 1003, "skill version has changed");
    }

    private final a a(String r16, int r17, String r18) {
        boolean r2 = false;
        String r3 = null;
        String r4 = null;
        String r5 = null;
        String r6 = null;
        Boolean r7 = null;
        return new a(r16, r2, r3, r4, r5, r6, r7, Integer.valueOf(r17), r18, null, null, 1660, null);
    }

    private final a a(String r3, u.a r4) {
        return a(r3, 1002, "load skill failed: code=" + r4.a() + ", diagnostic=" + r4.c() + ", retryable=" + r4.b());
    }

    private final String a(c r7) {
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L15
        r1.append("{\"results\":[");     // Catch: Exception -> L15
        int r2 = 0;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L15
    L5:
        if (r8.hasNext() == false) goto L13;
        Object r3 = r8.next();     // Catch: Exception -> L15
        int r4 = r2 + 1;     // Catch: Exception -> L15
        if (r2 >= 0) goto L9;
        p.c();     // Catch: Exception -> L15
    L9:
        a r5 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L15
        if (r2 <= 0) goto L12;
        r1.append(',');     // Catch: Exception -> L15
    L12:
        f15146a.a(r1, r5);     // Catch: Exception -> L15
        r2 = r4;
        goto L5
    L13:
        r1.append("]}");     // Catch: Exception -> L15
        String r9 = r1.toString();     // Catch: Exception -> L15
        o.c(r9, "toString(...)");     // Catch: Exception -> L15
        return r9;
    L15:
        e = move-exception;
        a(this, "serialize load_skill result failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), null, 4, null);
        return null;
    }

    private final void a(StringBuilder r4, a r5) {
        r4.append('{');
        r4.append("\"skill_id\":").append(ObricService.INSTANCE.getGson().toJson(r5.a()));
        String r3 = r5.c();
        if (r3 == null) goto L5;
        f15146a.a(r4, "skill_name", r3);
    L5:
        r4.append(",\"is_success\":").append(r5.b());
        String r6 = r5.d();
        if (r6 == null) goto L8;
        f15146a.a(r4, "work_dir", r6);
    L8:
        String r7 = r5.e();
        if (r7 == null) goto L11;
        f15146a.a(r4, "content", r7);
    L11:
        String r8 = r5.f();
        if (r8 != null) goto L14;
    L19:
        Boolean r9 = r5.g();
        if (r9 == null) goto L22;
        r4.append(",\"truncated\":").append(r9.booleanValue());
    L22:
        String r10 = r5.j();
        if (r10 == null) goto L25;
        f15146a.a(r4, "install_type", r10);
    L25:
        Integer r11 = r5.k();
        if (r11 == null) goto L28;
        r4.append(",\"version\":").append(((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue());
    L28:
        Integer r12 = r5.h();
        if (r12 == null) goto L31;
        r4.append(",\"error_code\":").append(((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue());
    L31:
        String r13 = r5.i();
        if (r13 == null) goto L34;
        f15146a.a(r4, "error_msg", r13);
    L34:
        r4.append('}');
        return;
    L14:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L17;
        r8 = null;
    L17:
        if (r8 == null) goto L19;
        r4.append(",\"tool_schema\":").append(r8);
        goto L19
    }

    private final void a(StringBuilder r1, String r2, String r3) {
        r1.append(",\"").append(r2).append("\":").append(ObricService.INSTANCE.getGson().toJson(r3));
    }

    static /* synthetic */ void a(f r0, String r1, Throwable r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = r1;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(String r2, Throwable r3, String r4) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e(TAG, r4, r3);
        return;
    L5:
        ILogDepend.Companion.e(TAG, r2);
    }

    private final e a(String r2, int r3) {
        if (r3 > 0) goto L7;
        return new e(r2, false);
    L7:
        if (r2.length() <= r3) goto L10;
        String r1 = r2.substring(0, r3);
        o.c(r1, "substring(...)");
        return new e(r1, true);
    L10:
        return new e(r2, false);
    }
}
