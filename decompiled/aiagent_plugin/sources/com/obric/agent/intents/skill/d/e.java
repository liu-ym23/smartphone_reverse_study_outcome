package com.obric.agent.intents.skill.d;

import android.os.SystemClock;
import com.google.gson.annotations.SerializedName;
import com.obric.agent.ObricService;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.skill.manager.api.au;
import com.obric.aiagent.skill.manager.api.av;
import com.obric.aiagent.skill.manager.api.r;
import com.obric.aiagent.skill.manager.api.u;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.x;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: SkillInstallStoreActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.a.b, b> {
    private static final String TAG = "SkillInstallStoreExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f15133a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15134b = null;

    /* JADX INFO: compiled from: SkillInstallStoreActionExecutor.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("status")
        private final j f15135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("is_success")
        private final boolean f15136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("installed")
        private final boolean f15137c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("change_type")
        private final String f15138d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("skill_slug")
        private final String f15139e;

        @SerializedName("display_name")
        private final String f;

        @SerializedName("version")
        private final Integer g;

        @SerializedName("security_status")
        private final String h;

        @SerializedName("enabled")
        private final Boolean i;

        @SerializedName("runtime_synced")
        private final Boolean j;

        @SerializedName("error_code")
        private final String k;

        @SerializedName("error_msg")
        private final String l;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f15135a == r6.f15135a) goto L12;
            return false;
        L12:
            if (this.f15136b == r6.f15136b) goto L15;
            return false;
        L15:
            if (this.f15137c == r6.f15137c) goto L18;
            return false;
        L18:
            if (o.a(this.f15138d, r6.f15138d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f15139e, r6.f15139e) == true) goto L24;
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
            if (o.a(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (o.a(this.l, r6.l) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f15135a.hashCode() * 31) + Boolean.hashCode(this.f15136b)) * 31) + Boolean.hashCode(this.f15137c)) * 31;
            String r1 = this.f15138d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f15139e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Integer r11 = this.g;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.h;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            Boolean r17 = this.i;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            Boolean r20 = this.j;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            String r23 = this.k;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            String r26 = this.l;
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
            r0.append("InstallStoreResultBody(status=").append(this.f15135a).append(", isSuccess=").append(this.f15136b).append(", installed=").append(this.f15137c).append(", changeType=").append(this.f15138d).append(", skillSlug=").append(this.f15139e).append(", displayName=").append(this.f).append(", version=").append(this.g).append(", securityStatus=").append(this.h).append(", enabled=").append(this.i).append(", ovirtSynced=").append(this.j).append(", errorCode=").append(this.k).append(", errorMsg=");
            r0.append(this.l).append(')');
            return r0.toString();
        }

        public a(j r2, boolean r3, boolean r4, String r5, String r6, String r7, Integer r8, String r9, Boolean r10, Boolean r11, String r12, String r13) {
            o.e(r2, "status");
            this.f15135a = r2;
            this.f15136b = r3;
            this.f15137c = r4;
            this.f15138d = r5;
            this.f15139e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
        }

        public /* synthetic */ a(j r17, boolean r18, boolean r19, String r20, String r21, String r22, Integer r23, String r24, Boolean r25, Boolean r26, String r27, String r28, int r29, d.h.b.h r30) {
            if ((r29 & 8) == 0) goto L5;
            String r7 = null;
        L7:
            if ((r29 & 16) == 0) goto L9;
            String r8 = null;
        L11:
            if ((r29 & 32) == 0) goto L13;
            String r9 = null;
        L15:
            if ((r29 & 64) == 0) goto L17;
            Integer r10 = null;
        L19:
            if ((r29 & 128) == 0) goto L21;
            String r11 = null;
        L23:
            if ((r29 & 256) == 0) goto L25;
            Boolean r12 = null;
        L27:
            if ((r29 & 512) == 0) goto L29;
            Boolean r13 = null;
        L31:
            if ((r29 & 1024) == 0) goto L33;
            String r14 = null;
        L35:
            if ((r29 & 2048) == 0) goto L37;
            String r15 = null;
        L38:
            this(r17, r18, r19, r7, r8, r9, r10, r11, r12, r13, r14, r15);
            return;
        L37:
            r15 = r28;
            goto L38
        L33:
            r14 = r27;
            goto L35
        L29:
            r13 = r26;
            goto L31
        L25:
            r12 = r25;
            goto L27
        L21:
            r11 = r24;
            goto L23
        L17:
            r10 = r23;
            goto L19
        L13:
            r9 = r22;
            goto L15
        L9:
            r8 = r21;
            goto L11
        L5:
            r7 = r20;
            goto L7
        }

        public final boolean a() {
            return this.f15136b;
        }

        public final boolean b() {
            return this.f15137c;
        }

        public final String c() {
            return this.f15138d;
        }

        public final Integer d() {
            return this.g;
        }

        public final Boolean e() {
            return this.i;
        }

        public final String f() {
            return this.k;
        }
    }

    /* JADX INFO: compiled from: SkillInstallStoreActionExecutor.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("skill_slug")
        private final String f15140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15141b;

        public final b a(String r1, String r2) {
            o.e(r2, "uniqueId");
            return new b(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15140a, r6.f15140a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f15141b, r6.f15141b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f15140a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f15141b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "InstallStoreSkillRequest(skillSlug=" + this.f15140a + ", uniqueId=" + this.f15141b + ')';
        }

        public b(String r2, String r3) {
            o.e(r3, "uniqueId");
            this.f15140a = r2;
            this.f15141b = r3;
        }

        public final String a() {
            return this.f15140a;
        }

        public final String b() {
            return this.f15141b;
        }
    }

    /* JADX INFO: compiled from: SkillInstallStoreActionExecutor.kt */
    @d.c.b.a.f(b = "SkillInstallStoreActionExecutor.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.intents.skill.systemskill.SkillInstallStoreActionExecutor$execute$2")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f15143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DispatchContext f15144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f15145d;

        c(b r3, DispatchContext r4, long r5, d.c.d<? super c> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15143b = r3;
            this.f15144c = r4;
            this.f15145d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f15143b, this.f15144c, this.f15145d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f15142a != 0) goto L20;
            d.o.a(r10);
            IntentResult<?> r11 = e.a(e.f15133a, this.f15143b, this.f15144c, this.f15145d);     // Catch: Exception -> L7 CancellationException -> L17
        L23:
            AtomicCapabilitySdk.INSTANCE.updateIntentResult(r11, this.f15144c, true);     // Catch: Exception -> L11 CancellationException -> L15
        L14:
            return x.f38692a;
        L15:
            e = move-exception;
            throw e;
        L11:
            e = move-exception;
            e.a(e.f15133a, "install_store_skill final delivery failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        L17:
            e = move-exception;
            throw e;
        L7:
            e = move-exception;
            e.a(e.f15133a, "install_store_skill async final failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            r11 = e.a(e.f15133a, this.f15143b, this.f15145d, h.a(r.q), "install");
            goto L23
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private e() {
    }

    public static final /* synthetic */ IntentResult a(e r0, b r1, long r2, g r4, String r5) {
        return r0.a(r1, r2, r4, r5);
    }

    public static final /* synthetic */ IntentResult a(e r0, b r1, DispatchContext r2, long r3) {
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ void a(e r0, String r1, Throwable r2) {
        r0.a(r1, r2);
    }

    @Override // com.obric.agent.intents.skill.a.c
    public /* synthetic */ Object a(com.obric.agent.intents.skill.a.b r3, b r4, DispatchContext r5, d.c.d r6) {
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a2((com.obric.agent.intents.skill.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.intents.skill.a.b.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin"), r5, r7);
    }

    static {
        f15133a = new e();
        f15134b = "install_store_skill";
    }

    @Override // com.obric.agent.intents.skill.a.c
    public String a() {
        return f15134b;
    }

    @Override // com.obric.agent.intents.skill.a.c
    public com.obric.agent.intents.skill.a.g<b> a(com.obric.agent.intents.skill.a.f r6) {
        o.e(r6, Ext.KEY_REQUEST);
        b r0 = (b) ZeusTransformUtils.preCheckCast(com.obric.agent.intents.skill.a.e.f14888a.a(r6.c(), b.class, TAG), b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        String r3 = r0.a();
        if (r3 == null) goto L9;
        String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L10:
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L20;
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(-2004, "skill_slug is missing"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L20:
        if (a(r4) == true) goto L24;
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(103, "skill_slug is invalid"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L24:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.b(r0.a(r4, r6.a())), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L15:
        r5 = false;
        goto L16
    L9:
        r4 = null;
        goto L10
    L5:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(103, "invalid install_store_skill actionArgs"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public Object a2(com.obric.agent.intents.skill.a.b r12, b r13, DispatchContext r14, d.c.d<? super IntentResult<Empty>> r15) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        long r3 = SystemClock.elapsedRealtime();
        kotlinx.coroutines.i.a(com.obric.agent.intents.skill.a.h.f14894a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new c(r13, r14, r3, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return k.a();
    }

    private final IntentResult<Empty> a(b r21, DispatchContext r22, long r23) {
        ISkillManagerService r1 = ISkillManagerService.Companion.a();
        if (r1 == null) goto L5;
        String r2 = r21.a();
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        u<av> r3 = r1.installStoreSkill(r2, au.i);
        if (ZeusTransformUtils.instanceOf(r3, u.b.class) == false) goto L14;
        a r4 = a((av) ZeusTransformUtils.preCheckCast(((u.b) ZeusTransformUtils.preCheckCast(r3, u.b.class, "com.obric.aiagent.plugin")).a(), av.class, "com.obric.aiagent.plugin"));
    L12:
        a r6 = r4;
        if (r6.a() == false) goto L19;
        String r5 = "complete";
    L20:
        a(r21, r23, r6, r5);
        return new IntentResult(0, null, null, ObricService.INSTANCE.getGson().toJson(r6), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L19:
        r5 = "install";
        goto L20
    L14:
        if (ZeusTransformUtils.instanceOf(r3, u.a.class) == false) goto L23;
        r4 = a(h.a((u.a) ZeusTransformUtils.preCheckCast(r3, u.a.class, "com.obric.aiagent.plugin")));
        goto L12
    L23:
        throw new d.k();
    L5:
        return a(r21, r23, h.a(r.m), "manager");
    }

    private final a a(av r17) {
        j r1 = j.f15177b;
        String r4 = r17.a().name().toLowerCase(Locale.ROOT);
        o.c(r4, "toLowerCase(...)");
        boolean r2 = true;
        boolean r3 = true;
        String r8 = "NOT_REQUIRED";
        return new a(r1, r2, r3, r4, r17.b().a(), r17.b().b(), Integer.valueOf(r17.b().j()), r8, Boolean.valueOf(r17.b().l()), false, null, null, 3072, null);
    }

    private final a a(g r17) {
        boolean r2 = false;
        boolean r3 = false;
        String r4 = null;
        String r5 = null;
        String r6 = null;
        Integer r7 = null;
        String r8 = null;
        Boolean r9 = null;
        Boolean r10 = null;
        return new a(j.f15178c, r2, r3, r4, r5, r6, r7, r8, r9, r10, r17.a(), r17.b(), DownloadErrorCode.ERROR_DB_READONLY, null);
    }

    private final IntentResult<Empty> a(b r21, long r22, g r24, String r25) {
        a r6 = a(r24);
        a(r21, r22, r6, r25);
        return new IntentResult(0, null, null, ObricService.INSTANCE.getGson().toJson(r6), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    }

    private final void a(b r12, long r13, a r15, String r16) {
        com.obric.agent.intents.skill.e.a.f15181a.a(r12.b(), SystemClock.elapsedRealtime() - r13, r15.c(), r15.d(), r15.e(), r15.a(), r15.b(), r16, r15.f());
    }

    private final boolean a(String r7) {
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == false) goto L5;
        return false;
    L5:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), '\\', false, 2, null) == false) goto L7;
        return false;
    L7:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null) == true) goto L27;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        int r0 = 0;
    L10:
        if (r0 >= r6.length()) goto L15;
        if (d.o.a.a(r6.charAt(r0)) == true) goto L13;
        r0 = r0 + 1;
        goto L10
    L13:
        boolean r8 = false;
    L16:
        if (r8 == true) goto L18;
        return false;
    L18:
        if (o.a(r7, ".") == false) goto L20;
        return false;
    L20:
        if (o.a(r7, DownloadConstants.VULNERABILITY_PATH) == false) goto L22;
        return false;
    L22:
        return true;
    L15:
        r8 = true;
        goto L16
    L27:
        return false;
    }

    private final com.obric.agent.intents.skill.a.g.a a(int r16, String r17) {
        return new com.obric.agent.intents.skill.a.g.a(new IntentResult(r16, null, null, r17, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null));
    }

    private final void a(String r2, Throwable r3) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e(TAG, r2, r3);
        return;
    L5:
        ILogDepend.Companion.e(TAG, r2);
    }
}
