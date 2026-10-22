package com.obric.agent.intents.skill.d;

import android.content.Context;
import android.os.SystemClock;
import com.google.gson.annotations.SerializedName;
import com.obric.agent.ObricService;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.skill.manager.api.aj;
import com.obric.aiagent.skill.manager.api.al;
import com.obric.aiagent.skill.manager.api.q;
import com.obric.aiagent.skill.manager.api.r;
import com.obric.aiagent.skill.manager.api.u;
import com.obric.aiagent.skill.manager.api.z;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.obric.aiagent.skill.virt.api.y;
import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.oui.orecyclerview.widget.ItemTouchHelper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.n;
import d.x;
import java.io.File;
import java.net.URI;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.w;

/* JADX INFO: compiled from: SkillInstallPackageActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.a.b, b> {
    private static final String TAG = "SkillInstallPackageExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f15095a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15096b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.o.k f15097c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SecureRandom f15098d = null;

    /* JADX INFO: compiled from: SkillInstallPackageActionExecutor.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("status")
        private final j f15099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("is_success")
        private final boolean f15100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("installed")
        private final boolean f15101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("change_type")
        private final String f15102d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("skill_slug")
        private final String f15103e;

        @SerializedName("display_name")
        private final String f;

        @SerializedName("version")
        private final Integer g;

        @SerializedName("security_status")
        private final String h;

        @SerializedName("runtime_synced")
        private final Boolean i;

        @SerializedName("error_code")
        private final String j;

        @SerializedName("error_msg")
        private final String k;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f15099a == r6.f15099a) goto L12;
            return false;
        L12:
            if (this.f15100b == r6.f15100b) goto L15;
            return false;
        L15:
            if (this.f15101c == r6.f15101c) goto L18;
            return false;
        L18:
            if (o.a(this.f15102d, r6.f15102d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f15103e, r6.f15103e) == true) goto L24;
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
            int r0 = ((((this.f15099a.hashCode() * 31) + Boolean.hashCode(this.f15100b)) * 31) + Boolean.hashCode(this.f15101c)) * 31;
            String r1 = this.f15102d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f15103e;
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
            String r20 = this.j;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            String r23 = this.k;
            if (r23 == null) goto L35;
            r2 = r23.hashCode();
        L35:
            return r22 + r2;
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
            r0.append("InstallResultBody(status=").append(this.f15099a).append(", isSuccess=").append(this.f15100b).append(", installed=").append(this.f15101c).append(", changeType=").append(this.f15102d).append(", skillSlug=").append(this.f15103e).append(", displayName=").append(this.f).append(", version=").append(this.g).append(", securityStatus=").append(this.h).append(", ovirtSynced=").append(this.i).append(", errorCode=").append(this.j).append(", errorMsg=").append(this.k).append(')');
            return r0.toString();
        }

        public a(j r2, boolean r3, boolean r4, String r5, String r6, String r7, Integer r8, String r9, Boolean r10, String r11, String r12) {
            o.e(r2, "status");
            this.f15099a = r2;
            this.f15100b = r3;
            this.f15101c = r4;
            this.f15102d = r5;
            this.f15103e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
        }

        public /* synthetic */ a(j r16, boolean r17, boolean r18, String r19, String r20, String r21, Integer r22, String r23, Boolean r24, String r25, String r26, int r27, d.h.b.h r28) {
            if ((r27 & 8) == 0) goto L5;
            String r7 = null;
        L7:
            if ((r27 & 16) == 0) goto L9;
            String r8 = null;
        L11:
            if ((r27 & 32) == 0) goto L13;
            String r9 = null;
        L15:
            if ((r27 & 64) == 0) goto L17;
            Integer r10 = null;
        L19:
            if ((r27 & 128) == 0) goto L21;
            String r11 = null;
        L23:
            if ((r27 & 256) == 0) goto L25;
            Boolean r12 = null;
        L27:
            if ((r27 & 512) == 0) goto L29;
            String r13 = null;
        L31:
            if ((r27 & 1024) == 0) goto L33;
            String r14 = null;
        L34:
            this(r16, r17, r18, r7, r8, r9, r10, r11, r12, r13, r14);
            return;
        L33:
            r14 = r26;
            goto L34
        L29:
            r13 = r25;
            goto L31
        L25:
            r12 = r24;
            goto L27
        L21:
            r11 = r23;
            goto L23
        L17:
            r10 = r22;
            goto L19
        L13:
            r9 = r21;
            goto L15
        L9:
            r8 = r20;
            goto L11
        L5:
            r7 = r19;
            goto L7
        }

        public final boolean a() {
            return this.f15100b;
        }

        public final boolean b() {
            return this.f15101c;
        }

        public final String c() {
            return this.f15102d;
        }

        public final Integer d() {
            return this.g;
        }

        public final String e() {
            return this.h;
        }

        public final String f() {
            return this.j;
        }
    }

    /* JADX INFO: compiled from: SkillInstallPackageActionExecutor.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("package_url")
        private final String f15104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("package_path")
        private final String f15105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("source_url")
        private final String f15106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("expected_sha256")
        private final String f15107d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f15108e;

        public final b a(String r7, String r8, String r9, String r10, String r11) {
            o.e(r11, "uniqueId");
            return new b(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15104a, r6.f15104a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f15105b, r6.f15105b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f15106c, r6.f15106c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f15107d, r6.f15107d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f15108e, r6.f15108e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            String r0 = this.f15104a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f15105b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.f15106c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.f15107d;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return ((r9 + r1) * 31) + this.f15108e.hashCode();
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "InstallSkillPackageRequest(packageUrl=" + this.f15104a + ", packagePath=" + this.f15105b + ", sourceUrl=" + this.f15106c + ", expectedSha256=" + this.f15107d + ", uniqueId=" + this.f15108e + ')';
        }

        public b(String r2, String r3, String r4, String r5, String r6) {
            o.e(r6, "uniqueId");
            this.f15104a = r2;
            this.f15105b = r3;
            this.f15106c = r4;
            this.f15107d = r5;
            this.f15108e = r6;
        }

        public final String a() {
            return this.f15104a;
        }

        public final String b() {
            return this.f15105b;
        }

        public final String c() {
            return this.f15106c;
        }

        public final String d() {
            return this.f15107d;
        }

        public final String e() {
            return this.f15108e;
        }
    }

    /* JADX INFO: compiled from: SkillInstallPackageActionExecutor.kt */
    private interface c {

        /* JADX INFO: compiled from: SkillInstallPackageActionExecutor.kt */
        public static final class a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f15109a = null;

            static {
                f15109a = new a();
            }

            private a() {
            }
        }

        /* JADX INFO: compiled from: SkillInstallPackageActionExecutor.kt */
        public static final class b implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final IntentResult<Empty> f15110a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
                if (o.a(this.f15110a, r6.f15110a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f15110a.hashCode();
            }

            public String toString() {
                return "Immediate(result=" + this.f15110a + ')';
            }

            public b(IntentResult<Empty> r2) {
                o.e(r2, "result");
                this.f15110a = r2;
            }

            public final IntentResult<Empty> a() {
                return this.f15110a;
            }
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.intents.skill.d.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SkillInstallPackageActionExecutor.kt */
    @d.c.b.a.f(b = "SkillInstallPackageActionExecutor.kt", c = {ItemTouchHelper.a.DEFAULT_SWIPE_ANIMATION_DURATION}, d = "execute", e = "com.obric.agent.intents.skill.systemskill.SkillInstallPackageActionExecutor")
    static final class C0307d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f15111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f15112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f15113c;

        C0307d(d r3, d.c.d<? super C0307d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15112b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15111a = r3;
            this.f15113c |= Integer.MIN_VALUE;
            return this.f15112b.a2(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillInstallPackageActionExecutor.kt */
    @d.c.b.a.f(b = "SkillInstallPackageActionExecutor.kt", c = {114, 120}, d = "invokeSuspend", e = "com.obric.agent.intents.skill.systemskill.SkillInstallPackageActionExecutor$execute$2")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f15115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DispatchContext f15116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f15117d;

        e(b r3, DispatchContext r4, long r5, d.c.d<? super e> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15115b = r3;
            this.f15116c = r4;
            this.f15117d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f15115b, this.f15116c, this.f15117d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15114a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r13);
        L20:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r13);
        L16:
            IntentResult r14 = (IntentResult) ZeusTransformUtils.preCheckCast(r13, IntentResult.class, "com.obric.aiagent.plugin");
            d r2 = d.f15095a;
            DispatchContext r3 = this.f15116c;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15114a = 2;
            if (d.a(r2, r14, r3, r4) != r0) goto L20;
            return r0;
        L10:
            d.o.a(r13);
            d r5 = d.f15095a;
            b r6 = this.f15115b;
            DispatchContext r7 = this.f15116c;
            long r8 = this.f15117d;
            String r9 = this.f15115b.a();
            if (r9 != null) goto L13;
            r9 = "";
        L13:
            z r10 = (z) ZeusTransformUtils.preCheckCast(new z.b(r9), z.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15114a = 1;
            r13 = d.a(r5, r6, r7, r8, r10, r11);
            if (r13 != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillInstallPackageActionExecutor.kt */
    @d.c.b.a.f(b = "SkillInstallPackageActionExecutor.kt", c = {164, 201, ChannelsEnvironment.BAND_6_GHZ_LAST_CH_NUM}, d = "invokeSuspend", e = "com.obric.agent.intents.skill.systemskill.SkillInstallPackageActionExecutor$execute$3")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f15119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ w<c> f15120c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f15121d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f15122e;
        final /* synthetic */ DispatchContext f;

        f(b r3, w<c> r4, long r5, File r7, DispatchContext r8, d.c.d<? super f> r9) {
            w<c> r6 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15119b = r3;
            this.f15120c = r6;
            this.f15121d = r5;
            this.f15122e = r7;
            this.f = r8;
            super(2, r10);
        }

        public static /* synthetic */ x lambda$KQgSIRybWeKS9JQSOsHKZWd110s(w r0) {
            return a(r0);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f15119b, this.f15120c, this.f15121d, this.f15122e, this.f, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r25) {
            Object r2 = d.c.a.b.a();
            int r0 = this.f15118a;
            IntentResult r10 = null;
            if (r0 == 0) goto L20;
            if (r0 == 1) goto L14;
            if (r0 == 2) goto L13;
            if (r0 != 3) goto L12;
            d.o.a(r25);     // Catch: Throwable -> L9
        L93:
        L82:
            if (this.f15120c.i() == true) goto L85;
            d.a(d.f15095a, this.f15120c, this.f15119b, this.f15121d, com.obric.agent.intents.skill.d.h.a(r.q), "ovirt_export");
        L85:
            if (this.f15122e.exists() == false) goto L90;
            if (this.f15122e.delete() == true) goto L90;
            ILogDepend.Companion.w(d.TAG, "install_skill_package host ZIP cleanup failed");
        L90:
            return x.f38692a;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.o.a(r25);     // Catch: Exception -> L16 CancellationException -> L18
            Object r1 = r25;
        L59:
            r10 = (IntentResult) ZeusTransformUtils.preCheckCast(r1, IntentResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16 CancellationException -> L18
        L68:
            if (r10 == null) goto L82;
            d r3 = d.f15095a;     // Catch: Throwable -> L9
            DispatchContext r4 = this.f;     // Catch: Throwable -> L9
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            this.f15118a = 3;     // Catch: Throwable -> L9
            if (d.a(r3, r10, r4, r5) != r2) goto L93;
            return r2;
        L14:
            d.o.a(r25);     // Catch: Exception -> L16 CancellationException -> L18
            Object r6 = r25;
        L45:
            com.obric.aiagent.skill.ovirt.api.b r7 = (com.obric.aiagent.skill.ovirt.api.b) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.ovirt.api.b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16 CancellationException -> L18
            if (ZeusTransformUtils.instanceOf(r7, com.obric.aiagent.skill.ovirt.api.b.C0439b.class) == false) goto L49;
            d.a(d.f15095a, this.f15120c, this.f15119b, this.f15121d, com.obric.agent.intents.skill.d.h.a("BLOCKED", ((com.obric.aiagent.skill.ovirt.api.b.C0439b) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.ovirt.api.b.C0439b.class, "com.obric.aiagent.plugin")).a()), "blocked");     // Catch: Exception -> L16 CancellationException -> L18
            goto L68
        L49:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.aiagent.skill.ovirt.api.b.d.class) == false) goto L52;
            d.a(d.f15095a, this.f15120c, this.f15119b, this.f15121d, com.obric.agent.intents.skill.d.h.a("SKILL_OVIRT_UNAVAILABLE", "A matching OVirt is unavailable for this phone-operation task"), "ovirt_export");     // Catch: Exception -> L16 CancellationException -> L18
            goto L68
        L52:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.aiagent.skill.ovirt.api.b.c.class) == false) goto L55;
            com.obric.agent.intents.skill.d.g r8 = com.obric.agent.intents.skill.d.h.b(((com.obric.aiagent.skill.ovirt.api.b.c) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.ovirt.api.b.c.class, "com.obric.aiagent.plugin")).a());     // Catch: Exception -> L16 CancellationException -> L18
            r10 = d.a(d.f15095a, this.f15119b, this.f15121d, r8.a(), r8.b(), "ovirt_export");     // Catch: Exception -> L16 CancellationException -> L18
            goto L68
        L55:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.aiagent.skill.ovirt.api.b.a.class) == false) goto L61;
            d r12 = d.f15095a;     // Catch: Exception -> L16 CancellationException -> L18
            b r13 = this.f15119b;     // Catch: Exception -> L16 CancellationException -> L18
            DispatchContext r14 = this.f;     // Catch: Exception -> L16 CancellationException -> L18
            long r9 = this.f15121d;     // Catch: Exception -> L16 CancellationException -> L18
            z r17 = (z) ZeusTransformUtils.preCheckCast(new z.a(this.f15122e), z.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16 CancellationException -> L18
            d.c.d r18 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16 CancellationException -> L18
            this.f15118a = 2;     // Catch: Exception -> L16 CancellationException -> L18
            r1 = d.a(r12, r13, r14, r9, r17, r18);     // Catch: Exception -> L16 CancellationException -> L18
            if (r1 != r2) goto L59;
            return r2;
        L61:
            throw new d.k();     // Catch: Exception -> L16 CancellationException -> L18
        L20:
            d.o.a(r25);
            IOVirtService r11 = IOVirtService.Companion.a();     // Catch: Exception -> L16 CancellationException -> L18
            if (r11 == null) goto L27;
            IOVirtService.e r15 = r11.getTask();     // Catch: Exception -> L16 CancellationException -> L18
            if (r15 == null) goto L27;
            y r16 = r15.paths(this.f15119b.e());     // Catch: Exception -> L16 CancellationException -> L18
        L28:
            if (r16 != null) goto L95;
            String r19 = null;
        L36:
            String r110 = r19;
        L37:
            if (r11 == null) goto L62;
            if (r16 == null) goto L62;
            if (r110 != null) goto L42;
            d.a(d.f15095a, this.f15120c, this.f15119b, this.f15121d, com.obric.agent.intents.skill.d.h.a("PACKAGE_PATH_INVALID", "package_path is not a valid OVirt ZIP path"), "ovirt_export");     // Catch: Exception -> L16 CancellationException -> L18
            goto L68
        L42:
            IOVirtService.b r111 = r11.getFiles();     // Catch: Exception -> L16 CancellationException -> L18
            String r112 = this.f15119b.e();     // Catch: Exception -> L16 CancellationException -> L18
            com.obric.aiagent.skill.ovirt.api.a.d r113 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.a.d.b(this.f15122e), com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16 CancellationException -> L18
            final w<c> r20 = this.f15120c;     // Catch: Exception -> L16 CancellationException -> L18
            d.h.a.a r114 = new $$Lambda$d$f$KQgSIRybWeKS9JQSOsHKZWd110s(r20);     // Catch: Exception -> L16 CancellationException -> L18
            d.c.d r21 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L16 CancellationException -> L18
            this.f15118a = 1;     // Catch: Exception -> L16 CancellationException -> L18
            r6 = IOVirtService.b.a.a(r111, r112, r110, r113, null, true, r114, r21, 8, null);     // Catch: Exception -> L16 CancellationException -> L18
            if (r6 != r2) goto L45;
            return r2;
        L62:
            d.a(d.f15095a, this.f15120c, this.f15119b, this.f15121d, com.obric.agent.intents.skill.d.h.a("SKILL_OVIRT_UNAVAILABLE", "A matching OVirt is unavailable for this phone-operation task"), "ovirt_export");     // Catch: Exception -> L16 CancellationException -> L18
            goto L68
        L95:
            b r115 = this.f15119b;     // Catch: CancellationException -> L18 Exception -> L34
            d r116 = d.f15095a;     // Catch: CancellationException -> L18 Exception -> L34
            String r117 = r115.b();     // Catch: CancellationException -> L18 Exception -> L34
            if (r117 != null) goto L32;
            r117 = "";
        L32:
            r19 = d.a(r116, r16, r117);     // Catch: CancellationException -> L18 Exception -> L34
        L34:
            r110 = null;
        L27:
            r16 = null;
        L18:
            e = move-exception;
            throw e;
        L9:
            th = move-exception;
            if (this.f15120c.i() == true) goto L76;
            d.a(d.f15095a, this.f15120c, this.f15119b, this.f15121d, com.obric.agent.intents.skill.d.h.a(r.q), "ovirt_export");
        L76:
            if (this.f15122e.exists() == true) goto L78;
        L80:
            throw th;
        L78:
            if (this.f15122e.delete() == true) goto L80;
            ILogDepend.Companion.w(d.TAG, "install_skill_package host ZIP cleanup failed");
        L16:
            e = move-exception;
            d.a(d.f15095a, "install_skill_package async final failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            com.obric.agent.intents.skill.d.g r22 = com.obric.agent.intents.skill.d.h.a(r.q);
            if (d.a(d.f15095a, this.f15120c, this.f15119b, this.f15121d, r22, "ovirt_export") == true) goto L68;
            r10 = d.a(d.f15095a, this.f15119b, this.f15121d, r22.a(), r22.b(), "commit");
            goto L68
        }

        private static final x a(w r2) {
            ((w) ZeusTransformUtils.wrapperContextForParams(r2, w.class, "com.obric.aiagent.plugin")).a(c.a.f15109a);
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillInstallPackageActionExecutor.kt */
    @d.c.b.a.f(b = "SkillInstallPackageActionExecutor.kt", c = {295, 291}, d = "executeInstall", e = "com.obric.agent.intents.skill.systemskill.SkillInstallPackageActionExecutor")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15125c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f15126d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f15127e;
        long f;
        /* synthetic */ Object g;
        final /* synthetic */ d h;
        int i;

        g(d r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.g = r8;
            this.i |= Integer.MIN_VALUE;
            return d.b(this.h, null, null, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillInstallPackageActionExecutor.kt */
    @d.c.b.a.f(b = "SkillInstallPackageActionExecutor.kt", c = {263}, d = "executeInstallSafely", e = "com.obric.agent.intents.skill.systemskill.SkillInstallPackageActionExecutor")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f15130c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f15131d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f15132e;
        int f;

        h(d r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15132e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.f15131d = r8;
            this.f |= Integer.MIN_VALUE;
            return d.a(this.f15132e, null, null, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ CharSequence lambda$SJoTVwBNrJCFLAq0zdKZVew3aYI(byte r0) {
        return a(r0);
    }

    private d() {
    }

    public static final /* synthetic */ IntentResult a(d r0, b r1, long r2, String r4, String r5, String r6) {
        return r0.a(r1, r2, r4, r5, r6);
    }

    public static final /* synthetic */ Object a(d r9, b r10, DispatchContext r11, long r12, z r14, d.c.d r15) {
        return r9.a(r10, r11, r12, (z) ZeusTransformUtils.wrapperContextForParams(r14, z.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(d r2, IntentResult r3, DispatchContext r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(d r0, y r1, String r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(d r0, String r1, Throwable r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ boolean a(d r7, w r8, b r9, long r10, com.obric.agent.intents.skill.d.g r12, String r13) {
        return r7.a((w) ZeusTransformUtils.wrapperContextForParams(r8, w.class, "com.obric.aiagent.plugin"), r9, r10, r12, r13);
    }

    public static final /* synthetic */ Object b(d r9, b r10, DispatchContext r11, long r12, z r14, d.c.d r15) {
        return r9.b(r10, r11, r12, (z) ZeusTransformUtils.wrapperContextForParams(r14, z.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.agent.intents.skill.a.c
    public /* synthetic */ Object a(com.obric.agent.intents.skill.a.b r3, b r4, DispatchContext r5, d.c.d r6) {
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a2((com.obric.agent.intents.skill.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.intents.skill.a.b.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin"), r5, r7);
    }

    static {
        f15095a = new d();
        f15096b = "install_skill_package";
        f15097c = new d.o.k("^[0-9a-f]{64}$");
        f15098d = new SecureRandom();
    }

    @Override // com.obric.agent.intents.skill.a.c
    public String a() {
        return f15096b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.agent.intents.skill.a.c
    public com.obric.agent.intents.skill.a.g<b> a(com.obric.agent.intents.skill.a.f r10) {
        o.e(r10, Ext.KEY_REQUEST);
        b r3 = (b) ZeusTransformUtils.preCheckCast(com.obric.agent.intents.skill.a.e.f14888a.a(r10.c(), b.class, TAG), b.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        String r1 = r3.a();
        CharSequence r4 = null;
        if (r1 == null) goto L14;
        String r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r2 == null) goto L14;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r5) == false) goto L13;
        r5 = null;
    L13:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
    L15:
        String r7 = r3.b();
        if (r7 == null) goto L23;
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r8 == null) goto L23;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r9) == false) goto L22;
        r9 = null;
    L22:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
    L24:
        boolean r12 = false;
        if (r6 != null) goto L27;
        boolean r13 = true;
    L28:
        if (r11 != null) goto L30;
        r12 = true;
    L30:
        if (r13 == r12) goto L32;
        if (r6 != null) goto L35;
    L38:
        if (r11 != null) goto L40;
    L45:
        String r14 = r3.c();
        if (r14 != null) goto L48;
        r14 = "";
    L48:
        String r15 = c(r14);
        if (r15 == null) goto L51;
        String r16 = r3.d();
        if (r16 == null) goto L61;
        String r17 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r17 == null) goto L61;
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r18) == true) goto L60;
        r4 = r18;
    L60:
        r4 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
    L61:
        String r19 = r4;
        if (r19 == 0) goto L68;
        if (f15097c.a((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L68;
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(103, "expected_sha256 must be lowercase hex"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L68:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.b(r3.a(r6, r11, r15, r19, r10.a())), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L51:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(-2004, "source_url is missing or invalid"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L40:
        if (a(r11) == false) goto L44;
        if (d.o.o.c(r11, ".zip", true) == true) goto L45;
    L44:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(103, "package_path must be an absolute ZIP path"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L35:
        if (b(r6) == true) goto L38;
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(103, "package_url must be a public HTTPS URL"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L32:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(103, "exactly one of package_url and package_path is required"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L27:
        r13 = false;
    L23:
        r11 = null;
    L14:
        r6 = null;
        goto L15
    L5:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(103, "invalid install_skill_package actionArgs"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public Object a2(com.obric.agent.intents.skill.a.b r20, b r21, DispatchContext r22, d.c.d<? super IntentResult<Empty>> r23) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, C0307d.class) == false) goto L7;
        C0307d r2 = (C0307d) ZeusTransformUtils.preCheckCast(r0, C0307d.class, "com.obric.aiagent.plugin");
        if ((r2.f15113c & Integer.MIN_VALUE) == 0) goto L7;
        r2.f15113c -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f15111a;
        Object r4 = d.c.a.b.a();
        int r5 = r2.f15113c;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        d.o.a(r1);
    L25:
        c r3 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
        if (o.a(r3, c.a.f15109a) == false) goto L29;
        return k.a();
    L29:
        if (ZeusTransformUtils.instanceOf(r3, c.b.class) == false) goto L33;
        return ((c.b) ZeusTransformUtils.preCheckCast(r3, c.b.class, "com.obric.aiagent.plugin")).a();
    L33:
        throw new d.k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r1);
        long r10 = SystemClock.elapsedRealtime();
        if (al.f19195a.a().y() == true) goto L19;
        ILogDepend.Companion.w(TAG, "install_skill_package blocked by import Skill cloud setting");
        return a(r21, r10, com.obric.agent.intents.skill.d.h.a().a(), com.obric.agent.intents.skill.d.h.a().b(), "blocked");
    L19:
        if (r21.b() != null) goto L22;
        kotlinx.coroutines.i.a(com.obric.agent.intents.skill.a.h.f14894a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new e(r21, r22, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return k.a();
    L22:
        w r6 = kotlinx.coroutines.y.a(null, 1, null);
        kotlinx.coroutines.i.a(com.obric.agent.intents.skill.a.h.f14894a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new f(r21, r6, r10, new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r22.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getCacheDir(), "skill_install_intent_" + b() + ".zip"), r22, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        r2.f15113c = 1;
        r1 = r6.a(r2);
        if (r1 != r4) goto L25;
        return r4;
    L7:
        r2 = new C0307d(this, r0);
        goto L8
    }

    private final Object a(b r10, DispatchContext r11, long r12, z r14, d.c.d<? super IntentResult<Empty>> r15) {
        z r7 = (z) ZeusTransformUtils.wrapperContextForParams(r14, z.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, h.class) == false) goto L7;
        h r17 = (h) ZeusTransformUtils.preCheckCast(r16, h.class, "com.obric.aiagent.plugin");
        if ((r17.f & Integer.MIN_VALUE) == 0) goto L7;
        r17.f -= Integer.MIN_VALUE;
    L8:
        h r8 = r17;
        Object r18 = r8.f15131d;
        Object r19 = d.c.a.b.a();
        int r0 = r8.f;
        if (r0 == 0) goto L16;
        if (r0 != 1) goto L15;
        r12 = r8.f15130c;
        r10 = (b) ZeusTransformUtils.preCheckCast(r8.f15129b, b.class, "com.obric.aiagent.plugin");
        d this = (d) ZeusTransformUtils.preCheckCast(r8.f15128a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r18);     // Catch: Exception -> L22 CancellationException -> L25
    L20:
    L29:
        return (IntentResult) ZeusTransformUtils.preCheckCast(r18, IntentResult.class, "com.obric.aiagent.plugin");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r18);
        r8.f15128a = this;     // Catch: Exception -> L22 CancellationException -> L25
        r8.f15129b = r10;     // Catch: Exception -> L22 CancellationException -> L25
        r8.f15130c = r12;     // Catch: Exception -> L22 CancellationException -> L25
        r8.f = 1;     // Catch: Exception -> L22 CancellationException -> L25
        r18 = b(r10, r11, r12, r7, r8);     // Catch: Exception -> L22 CancellationException -> L25
        if (r18 != r19) goto L20;
        return r19;
    L25:
        e = move-exception;
        throw e;
    L22:
        e = move-exception;
        d r2 = this;
        r2.a("install_skill_package async final failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        com.obric.agent.intents.skill.d.g r9 = com.obric.agent.intents.skill.d.h.a(r.q);
        return r2.a(r10, r12, r9.a(), r9.b(), "commit");
    L7:
        r17 = new h(this, r16);
        goto L8
    }

    private final Object b(b r28, DispatchContext r29, long r30, z r32, d.c.d<? super IntentResult<Empty>> r33) {
        z r1 = (z) ZeusTransformUtils.wrapperContextForParams(r32, z.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r33, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, g.class) == false) goto L7;
        g r3 = (g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin");
        if ((r3.i & Integer.MIN_VALUE) == 0) goto L7;
        r3.i -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.g;
        Object r5 = d.c.a.b.a();
        int r6 = r3.i;
        if (r6 == 0) goto L24;
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L18;
        long r7 = r3.f;
        b r8 = (b) ZeusTransformUtils.preCheckCast(r3.f15124b, b.class, "com.obric.aiagent.plugin");
        d r9 = (d) ZeusTransformUtils.preCheckCast(r3.f15123a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Exception -> L15 CancellationException -> L87
        b r12 = r8;
        d r13 = r9;
        long r10 = r7;
    L55:
        u r0 = (u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L75 CancellationException -> L87
        if (ZeusTransformUtils.instanceOf(r0, u.a.class) == false) goto L59;
        com.obric.agent.intents.skill.d.g r11 = com.obric.agent.intents.skill.d.h.a((u.a) ZeusTransformUtils.preCheckCast(r0, u.a.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L75 CancellationException -> L87
        a r14 = f15095a.a(r11.a(), r11.b());     // Catch: Exception -> L75 CancellationException -> L87
    L63:
        if (ZeusTransformUtils.instanceOf(r0, u.a.class) == false) goto L66;
    L64:
        String r15 = "commit";
    L71:
        r13.a(r12, r10, r14, r15);     // Catch: Exception -> L75 CancellationException -> L87
        return new IntentResult(0, null, null, ObricService.INSTANCE.getGson().toJson(r14), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L66:
        if (r14.a() == false) goto L69;
        r15 = "complete";
        goto L71
    L69:
        if (r14.b() == false) goto L64;
        r15 = "scan_submit";
        goto L71
    L59:
        if (ZeusTransformUtils.instanceOf(r0, u.b.class) == false) goto L74;
        r14 = r13.a((com.obric.aiagent.skill.manager.api.y) ZeusTransformUtils.preCheckCast(((u.b) ZeusTransformUtils.preCheckCast(r0, u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.y.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L75 CancellationException -> L87
        goto L63
    L74:
        throw new d.k();     // Catch: Exception -> L75 CancellationException -> L87
    L15:
        e = e;
        r12 = r8;
        r13 = r9;
        r10 = r7;
    L85:
        r13.a("install_skill_package operation failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        com.obric.agent.intents.skill.d.g r16 = com.obric.agent.intents.skill.d.h.a(r.q);
        return r13.a(r12, r10, r16.a(), r16.b(), "commit");
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        long r17 = r3.f;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r3.f15127e, String.class, "com.obric.aiagent.plugin");
        z r19 = (z) ZeusTransformUtils.preCheckCast(r3.f15126d, z.class, "com.obric.aiagent.plugin");
        ISkillManagerService r110 = (ISkillManagerService) ZeusTransformUtils.preCheckCast(r3.f15125c, ISkillManagerService.class, "com.obric.aiagent.plugin");
        r12 = (b) ZeusTransformUtils.preCheckCast(r3.f15124b, b.class, "com.obric.aiagent.plugin");
        r13 = (d) ZeusTransformUtils.preCheckCast(r3.f15123a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Exception -> L22 CancellationException -> L87
        String r20 = r18;
        r1 = r19;
        ISkillManagerService r21 = r110;
        r10 = r17;
    L101:
        com.obric.aiagent.skill.manager.api.x r22 = new com.obric.aiagent.skill.manager.api.x(r1, r20, (q) ZeusTransformUtils.preCheckCast(r4, q.class, "com.obric.aiagent.plugin"), r12.d());     // Catch: Exception -> L75 CancellationException -> L87
        r3.f15123a = r13;     // Catch: Exception -> L75 CancellationException -> L87
        r3.f15124b = r12;     // Catch: Exception -> L75 CancellationException -> L87
        r3.f15125c = null;     // Catch: Exception -> L75 CancellationException -> L87
        r3.f15126d = null;     // Catch: Exception -> L75 CancellationException -> L87
        r3.f15127e = null;     // Catch: Exception -> L75 CancellationException -> L87
        r3.f = r10;     // Catch: Exception -> L75 CancellationException -> L87
        r3.i = 2;     // Catch: Exception -> L75 CancellationException -> L87
        r4 = r21.installSkillPackage(r22, r3);     // Catch: Exception -> L75 CancellationException -> L87
        if (r4 != r5) goto L55;
        return r5;
    L75:
        e = e;
    L22:
        e = e;
        r10 = r17;
        goto L85
    L24:
        d.o.a(r4);
        ISkillManagerService r111 = ISkillManagerService.Companion.a();     // Catch: Exception -> L81 CancellationException -> L87
        if (r111 != null) goto L31;
        com.obric.agent.intents.skill.d.g r23 = com.obric.agent.intents.skill.d.h.a(r.m);     // Catch: Exception -> L29 CancellationException -> L87
        return a(r28, r30, r23.a(), r23.b(), "commit");
    L31:
        r20 = r28.c();     // Catch: Exception -> L81 CancellationException -> L87
        if (r20 != null) goto L34;
        r20 = "";
    L34:
        com.obric.agent.intents.skill.d.c r24 = com.obric.agent.intents.skill.d.c.f15092a;     // Catch: Exception -> L81 CancellationException -> L87
        if (r28.b() != null) goto L38;
        q r25 = q.f19298d;     // Catch: Exception -> L29 CancellationException -> L87
    L39:
        String r112 = r28.e();     // Catch: Exception -> L81 CancellationException -> L87
        Long r113 = r29.getQuestionId();     // Catch: Exception -> L81 CancellationException -> L87
        if (r113 == null) goto L43;
        String r114 = r113.toString();     // Catch: Exception -> L29 CancellationException -> L87
    L44:
        r3.f15123a = this;     // Catch: Exception -> L81 CancellationException -> L87
        b r115 = r28;
        r3.f15124b = r115;     // Catch: Exception -> L79 CancellationException -> L87
        r3.f15125c = r111;     // Catch: Exception -> L79 CancellationException -> L87
        r3.f15126d = r1;     // Catch: Exception -> L79 CancellationException -> L87
        r3.f15127e = r20;     // Catch: Exception -> L79 CancellationException -> L87
        r10 = r30;
        r3.f = r10;     // Catch: Exception -> L77 CancellationException -> L87
        r3.i = 1;     // Catch: Exception -> L77 CancellationException -> L87
        r4 = r24.a(r25, r112, r114, r3);     // Catch: Exception -> L77 CancellationException -> L87
        if (r4 != r5) goto L51;
        return r5;
    L51:
        r21 = r111;
        r13 = this;
        r12 = r115;
    L77:
        e = e;
    L84:
        r13 = this;
        r12 = r115;
    L79:
        e = e;
    L83:
        r10 = r30;
        goto L84
    L43:
        r114 = null;
        goto L44
    L38:
        r25 = q.f19299e;     // Catch: Exception -> L81 CancellationException -> L87
    L29:
        e = e;
        r12 = r28;
        r10 = r30;
        r13 = this;
    L81:
        e = e;
        r115 = r28;
    L87:
        e = move-exception;
        throw e;
    L7:
        r3 = new g(this, r2);
        goto L8
    }

    private final Object a(IntentResult<Empty> r3, DispatchContext r4, d.c.d<? super x> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        AtomicCapabilitySdk.INSTANCE.updateIntentResult(r3, r4, true);     // Catch: Exception -> L5 CancellationException -> L9
    L8:
        return x.f38692a;
    L9:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        a("install_skill_package final delivery failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L8
    }

    private final boolean a(w<c> r8, b r9, long r10, com.obric.agent.intents.skill.d.g r12, String r13) {
        w r11 = (w) ZeusTransformUtils.wrapperContextForParams(r8, w.class, "com.obric.aiagent.plugin");
        if (r11.i() == false) goto L7;
        return false;
    L7:
        return r11.a(new c.b(a(r9, r10, r12, r13)));
    }

    private final String a(y r5, String r6) {
        if (d.o.o.b(r6, "~/", false, 2, null) == false) goto L6;
        return r5.a(d.o.o.a(r6, (CharSequence) ZeusTransformUtils.preCheckCast("~/", CharSequence.class, "com.obric.aiagent.plugin"))).a();
    L6:
        if (d.o.o.b(r6, "/", false, 2, null) == false) goto L10;
        return r5.c(r6).a();
    L10:
        throw new IllegalArgumentException("Unsupported package path");
    }

    private final a a(com.obric.aiagent.skill.manager.api.y r17) {
        r r0 = r17.d();
        String r1 = null;
        if (r0 == null) goto L5;
        com.obric.agent.intents.skill.d.g r2 = com.obric.agent.intents.skill.d.h.c();
    L7:
        if (r0 != null) goto L9;
        j r3 = j.f15177b;
    L10:
        j r4 = r3;
        if (r0 != null) goto L13;
        boolean r5 = true;
    L14:
        boolean r6 = r17.a();
        String r7 = r17.b().name().toLowerCase(Locale.ROOT);
        o.c(r7, "toLowerCase(...)");
        String r8 = r17.c().a();
        String r9 = r17.c().b();
        Integer r10 = Integer.valueOf(r17.c().j());
        String r11 = a(r17.c().i());
        if (r2 == null) goto L17;
        String r13 = r2.a();
    L18:
        if (r2 == null) goto L21;
        r1 = r2.b();
    L21:
        return new a(r4, r5, r6, r7, r8, r9, r10, r11, false, r13, r1);
    L17:
        r13 = null;
        goto L18
    L13:
        r5 = false;
        goto L14
    L9:
        r3 = j.f15178c;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    private final a a(String r16, String r17) {
        return new a(j.f15178c, false, false, null, null, null, null, null, null, r16, r17, 504, null);
    }

    private final IntentResult<Empty> a(b r21, long r22, String r24, String r25, String r26) {
        a r6 = a(r24, r25);
        a(r21, r22, r6, r26);
        return new IntentResult(0, null, null, ObricService.INSTANCE.getGson().toJson(r6), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    }

    private final IntentResult<Empty> a(b r8, long r9, com.obric.agent.intents.skill.d.g r11, String r12) {
        return a(r8, r9, r11.a(), r11.b(), r12);
    }

    private final void a(b r13, long r14, a r16, String r17) {
        com.obric.agent.intents.skill.e.a r0 = com.obric.agent.intents.skill.e.a.f15181a;
        String r1 = r13.e();
        long r2 = SystemClock.elapsedRealtime() - r14;
        if (r13.b() != null) goto L5;
        String r4 = "url";
    L6:
        r0.a(r1, r2, r4, r16.c(), r16.d(), r16.a(), r16.b(), r17, r16.e(), r16.f());
        return;
    L5:
        r4 = DownloadConstants.PATH_KEY;
        goto L6
    }

    private final String a(aj r2) {
        aj r1 = (aj) ZeusTransformUtils.wrapperContextForParams(r2, aj.class, "com.obric.aiagent.plugin");
        if (o.a(r1, aj.c.f19187a) == false) goto L6;
        return "NOT_REQUIRED";
    L6:
        if (o.a(r1, aj.d.f19189a) == false) goto L9;
        return "NOT_STARTED";
    L9:
        if (ZeusTransformUtils.instanceOf(r1, aj.e.class) == false) goto L12;
        return "SCANNING";
    L12:
        if (ZeusTransformUtils.instanceOf(r1, aj.a.class) == false) goto L15;
        return "COMPLETED";
    L15:
        if (ZeusTransformUtils.instanceOf(r1, aj.b.class) == false) goto L19;
        return "ERROR";
    L19:
        throw new d.k();
    }

    private final boolean a(String r9) {
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null) == false) goto L6;
        return false;
    L6:
        if (d.o.o.b(r9, "~/", false, 2, null) == true) goto L11;
        if (d.o.o.b(r9, "/", false, 2, null) == true) goto L11;
        return false;
    L11:
        if (d.o.o.b(r9, "~/", false, 2, null) == false) goto L13;
        Object r8 = ZeusTransformUtils.preCheckCast("~/", CharSequence.class, "com.obric.aiagent.plugin");
    L14:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(r9, (CharSequence) r8), CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'/'}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L17;
    L19:
        Iterator r11 = r10.iterator();
    L21:
        if (r11.hasNext() == false) goto L32;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");
        if (o.a(r2, ".") == false) goto L25;
    L30:
        boolean r3 = true;
    L31:
        if (r3 == false) goto L21;
        return false;
    L25:
        if (o.a(r2, DownloadConstants.VULNERABILITY_PATH) == true) goto L30;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L30;
        r3 = false;
    L32:
        return true;
    L17:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L19;
    L13:
        r8 = ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.aiagent.plugin");
        goto L14
    }

    private final boolean b(String r5) {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L23
        d r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        URI r6 = new URI(r5);     // Catch: Throwable -> L23
        boolean r3 = true;
        if (r6.isAbsolute() == true) goto L6;
    L20:
        r3 = false;
    L21:
        Object r7 = n.f(Boolean.valueOf(r3));     // Catch: Throwable -> L23
    L26:
        if (n.b(r7) == false) goto L29;
        r7 = false;
    L29:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L6:
        if (d.o.o.a(r6.getScheme(), "https", true) == false) goto L20;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.getHost(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r8 != null) goto L10;
    L13:
        boolean r9 = true;
    L14:
        if (r9 == true) goto L20;
        if (r6.getUserInfo() != null) goto L20;
        if (r6.getFragment() != null) goto L20;
    L10:
        if (d.o.o.d(r8) == true) goto L13;
        r9 = false;
    L23:
        th = move-exception;
        n.a r10 = n.f38560a;
        r7 = n.f(d.o.a(th));
        goto L26
    }

    private final String c(String r13) {
        String r14 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        Object r2 = null;
        if (r0 == false) goto L9;
    L59:
        return null;
    L9:
        if (r14.length() > 8192) goto L59;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L51
        d r12 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        URI r15 = new URI(r14);     // Catch: Throwable -> L51
        String r16 = r15.getScheme();     // Catch: Throwable -> L51
        if (r16 == null) goto L16;
        String r17 = r16.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L51
        o.c(r17, "toLowerCase(...)");     // Catch: Throwable -> L51
    L18:
        if (r17 != null) goto L20;
        String r5 = "";
    L21:
        String r18 = r15.getHost();     // Catch: Throwable -> L51
        if (r18 == null) goto L24;
        String r19 = r18.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L51
        o.c(r19, "toLowerCase(...)");     // Catch: Throwable -> L51
    L25:
        if (r19 != null) goto L27;
        String r7 = "";
    L29:
        if (o.a(r5, "https") == true) goto L33;
        if (o.a(r5, "http") == true) goto L33;
    L50:
        return null;
    L33:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L50;
        if (r15.getUserInfo() != null) goto L50;
        int r8 = r15.getPort();     // Catch: Throwable -> L51
        String r110 = r15.getPath();     // Catch: Throwable -> L51
        if (r110 == null) goto L47;
        CharSequence r111 = (CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        if (d.o.o.d(r111) == false) goto L43;
        r111 = "/";
    L43:
        String r112 = (String) ZeusTransformUtils.preCheckCast(r111, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        if (r112 == null) goto L47;
        String r9 = r112;
    L48:
        Object r113 = n.f(new URI(r5, null, r7, r8, r9, null, null).toASCIIString());     // Catch: Throwable -> L51
    L54:
        if (n.b(r113) == true) goto L58;
        r2 = r113;
    L58:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L47:
        r9 = "/";
        goto L48
    L27:
        r7 = r19;
        goto L29
    L24:
        r19 = null;
        goto L25
    L20:
        r5 = r17;
        goto L21
    L16:
        r17 = null;
    L51:
        th = move-exception;
        n.a r114 = n.f38560a;
        r113 = n.f(d.o.a(th));
        goto L54
    L5:
        r0 = false;
        goto L6
    }

    private final com.obric.agent.intents.skill.a.g.a a(int r16, String r17) {
        return new com.obric.agent.intents.skill.a.g.a(new IntentResult(r16, null, null, r17, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null));
    }

    private final String b() {
        byte[] r0 = new byte[12];
        f15098d.nextBytes(r0);
        return d.a.i.a(r0, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$d$SJoTVwBNrJCFLAq0zdKZVew3aYI.INSTANCE, 30, null);
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final void a(String r2, Throwable r3) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e(TAG, r2, r3);
        return;
    L5:
        ILogDepend.Companion.e(TAG, r2);
    }
}
