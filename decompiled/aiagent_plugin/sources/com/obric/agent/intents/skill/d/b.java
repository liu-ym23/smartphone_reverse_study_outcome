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
import com.obric.aiagent.skill.manager.api.r;
import com.obric.aiagent.skill.manager.api.u;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.obric.aiagent.skill.virt.api.y;
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
import java.io.File;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.w;

/* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.a.b, c> {
    private static final String TAG = "SkillApplyChangeActionExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f15059a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15060b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SecureRandom f15061c = null;

    /* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
    private interface a {

        /* JADX INFO: renamed from: com.obric.agent.intents.skill.d.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
        public static final class C0303a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0303a f15062a = null;

            static {
                f15062a = new C0303a();
            }

            private C0303a() {
            }
        }

        /* JADX INFO: renamed from: com.obric.agent.intents.skill.d.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
        public static final class C0304b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final IntentResult<Empty> f15063a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0304b.class) == true) goto L8;
                return false;
            L8:
                C0304b r6 = (C0304b) ZeusTransformUtils.preCheckCast(r5, C0304b.class, "com.obric.aiagent.plugin");
                if (o.a(this.f15063a, r6.f15063a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f15063a.hashCode();
            }

            public String toString() {
                return "Immediate(result=" + this.f15063a + ')';
            }

            public C0304b(IntentResult<Empty> r2) {
                o.e(r2, "result");
                this.f15063a = r2;
            }

            public final IntentResult<Empty> a() {
                return this.f15063a;
            }
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.intents.skill.d.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
    public static final class C0305b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("status")
        private final j f15064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("is_success")
        private final boolean f15065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("applied")
        private final boolean f15066c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("change_type")
        private final String f15067d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("skill_slug")
        private final String f15068e;

        @SerializedName("display_name")
        private final String f;

        @SerializedName("version")
        private final Integer g;

        @SerializedName("security_status")
        private final String h;

        @SerializedName("error_code")
        private final String i;

        @SerializedName("error_msg")
        private final String j;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0305b.class) == true) goto L8;
            return false;
        L8:
            C0305b r6 = (C0305b) ZeusTransformUtils.preCheckCast(r5, C0305b.class, "com.obric.aiagent.plugin");
            if (this.f15064a == r6.f15064a) goto L12;
            return false;
        L12:
            if (this.f15065b == r6.f15065b) goto L15;
            return false;
        L15:
            if (this.f15066c == r6.f15066c) goto L18;
            return false;
        L18:
            if (o.a(this.f15067d, r6.f15067d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f15068e, r6.f15068e) == true) goto L24;
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
            if (o.a(this.j, r6.j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f15064a.hashCode() * 31) + Boolean.hashCode(this.f15065b)) * 31) + Boolean.hashCode(this.f15066c)) * 31;
            String r1 = this.f15067d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f15068e;
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
            String r17 = this.i;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.j;
            if (r20 == null) goto L31;
            r2 = r20.hashCode();
        L31:
            return r19 + r2;
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
            return "ApplyResultBody(status=" + this.f15064a + ", isSuccess=" + this.f15065b + ", applied=" + this.f15066c + ", changeType=" + this.f15067d + ", skillSlug=" + this.f15068e + ", displayName=" + this.f + ", version=" + this.g + ", securityStatus=" + this.h + ", errorCode=" + this.i + ", errorMsg=" + this.j + ')';
        }

        public C0305b(j r2, boolean r3, boolean r4, String r5, String r6, String r7, Integer r8, String r9, String r10, String r11) {
            o.e(r2, "status");
            this.f15064a = r2;
            this.f15065b = r3;
            this.f15066c = r4;
            this.f15067d = r5;
            this.f15068e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
        }

        public /* synthetic */ C0305b(j r15, boolean r16, boolean r17, String r18, String r19, String r20, Integer r21, String r22, String r23, String r24, int r25, d.h.b.h r26) {
            if ((r25 & 8) == 0) goto L5;
            String r7 = null;
        L7:
            if ((r25 & 16) == 0) goto L9;
            String r8 = null;
        L11:
            if ((r25 & 32) == 0) goto L13;
            String r9 = null;
        L15:
            if ((r25 & 64) == 0) goto L17;
            Integer r10 = null;
        L19:
            if ((r25 & 128) == 0) goto L21;
            String r11 = null;
        L23:
            if ((r25 & 256) == 0) goto L25;
            String r12 = null;
        L27:
            if ((r25 & 512) == 0) goto L29;
            String r13 = null;
        L30:
            this(r15, r16, r17, r7, r8, r9, r10, r11, r12, r13);
            return;
        L29:
            r13 = r24;
            goto L30
        L25:
            r12 = r23;
            goto L27
        L21:
            r11 = r22;
            goto L23
        L17:
            r10 = r21;
            goto L19
        L13:
            r9 = r20;
            goto L15
        L9:
            r8 = r19;
            goto L11
        L5:
            r7 = r18;
            goto L7
        }

        public final boolean a() {
            return this.f15065b;
        }

        public final boolean b() {
            return this.f15066c;
        }

        public final String c() {
            return this.f15067d;
        }

        public final Integer d() {
            return this.g;
        }

        public final String e() {
            return this.h;
        }

        public final String f() {
            return this.i;
        }
    }

    /* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("mode")
        private final String f15069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("skill_path")
        private final String f15070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("skill_slug")
        private final String f15071c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f15072d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.api.j f15073e;

        public static /* synthetic */ c a(c r3, String r4, String r5, String r6, String r7, com.obric.aiagent.skill.manager.api.j r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.f15069a;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.f15070b;
        L8:
            String r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.f15071c;
        L11:
            String r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.f15072d;
        L14:
            String r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.f15073e;
        L17:
            String r12 = r4;
            return r3.a(r12, r11, r0, r1, r8);
        }

        public final c a(String r7, String r8, String r9, String r10, com.obric.aiagent.skill.manager.api.j r11) {
            o.e(r10, "uniqueId");
            return new c(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15069a, r6.f15069a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f15070b, r6.f15070b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f15071c, r6.f15071c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f15072d, r6.f15072d) == true) goto L21;
            return false;
        L21:
            if (this.f15073e == r6.f15073e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            String r0 = this.f15069a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f15070b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.f15071c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (((r6 + r8) * 31) + this.f15072d.hashCode()) * 31;
            com.obric.aiagent.skill.manager.api.j r10 = this.f15073e;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return r9 + r1;
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
            return "ApplySkillChangeRequest(mode=" + this.f15069a + ", skillPath=" + this.f15070b + ", skillSlug=" + this.f15071c + ", uniqueId=" + this.f15072d + ", normalizedMode=" + this.f15073e + ')';
        }

        public c(String r2, String r3, String r4, String r5, com.obric.aiagent.skill.manager.api.j r6) {
            o.e(r5, "uniqueId");
            this.f15069a = r2;
            this.f15070b = r3;
            this.f15071c = r4;
            this.f15072d = r5;
            this.f15073e = r6;
        }

        public final String a() {
            return this.f15069a;
        }

        public final String b() {
            return this.f15070b;
        }

        public final String c() {
            return this.f15071c;
        }

        public final String d() {
            return this.f15072d;
        }

        public final com.obric.aiagent.skill.manager.api.j e() {
            return this.f15073e;
        }
    }

    /* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15075b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15074a, r6.f15074a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f15075b, r6.f15075b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f15074a.hashCode() * 31;
            String r1 = this.f15075b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ResolvedSkillPath(absolutePath=" + this.f15074a + ", authoritativeSlug=" + this.f15075b + ')';
        }

        public d(String r2, String r3) {
            o.e(r2, "absolutePath");
            this.f15074a = r2;
            this.f15075b = r3;
        }

        public final String a() {
            return this.f15074a;
        }

        public final String b() {
            return this.f15075b;
        }
    }

    /* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
    private interface e {

        /* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
        public static final class a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.obric.agent.intents.skill.d.g f15076a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
                if (o.a(this.f15076a, r6.f15076a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f15076a.hashCode();
            }

            public String toString() {
                return "Failure(failure=" + this.f15076a + ')';
            }

            public a(com.obric.agent.intents.skill.d.g r2) {
                o.e(r2, "failure");
                this.f15076a = r2;
            }

            public final com.obric.agent.intents.skill.d.g a() {
                return this.f15076a;
            }
        }

        /* JADX INFO: renamed from: com.obric.agent.intents.skill.d.b$e$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
        public static final class C0306b implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final d f15077a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0306b.class) == true) goto L8;
                return false;
            L8:
                C0306b r6 = (C0306b) ZeusTransformUtils.preCheckCast(r5, C0306b.class, "com.obric.aiagent.plugin");
                if (o.a(this.f15077a, r6.f15077a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f15077a.hashCode();
            }

            public String toString() {
                return "Resolved(value=" + this.f15077a + ')';
            }

            public C0306b(d r2) {
                o.e(r2, "value");
                this.f15077a = r2;
            }

            public final d a() {
                return this.f15077a;
            }
        }
    }

    /* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
    public /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15078a = null;

        static {
            int[] r0 = new int[com.obric.aiagent.skill.manager.api.j.values().length];
            r0[com.obric.aiagent.skill.manager.api.j.f19267a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[com.obric.aiagent.skill.manager.api.j.f19268b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f15078a = r0;
        }
    }

    /* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
    @d.c.b.a.f(b = "SkillApplyChangeActionExecutor.kt", c = {245}, d = "execute", e = "com.obric.agent.intents.skill.systemskill.SkillApplyChangeActionExecutor")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f15079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f15080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f15081c;

        g(b r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15080b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15079a = r3;
            this.f15081c |= Integer.MIN_VALUE;
            return this.f15080b.a2(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
    @d.c.b.a.f(b = "SkillApplyChangeActionExecutor.kt", c = {149, 189}, d = "invokeSuspend", e = "com.obric.agent.intents.skill.systemskill.SkillApplyChangeActionExecutor$execute$2")
    static final class h extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f15083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f15084c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ w<a> f15085d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f15086e;
        final /* synthetic */ File f;
        final /* synthetic */ DispatchContext g;

        h(c r3, w<a> r4, long r5, File r7, DispatchContext r8, d.c.d<? super h> r9) {
            w<a> r6 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15084c = r3;
            this.f15085d = r6;
            this.f15086e = r5;
            this.f = r7;
            this.g = r8;
            super(2, r10);
        }

        public static /* synthetic */ x lambda$WFpFyKeowEaSFcQhjpY28FgxfP4(w r0) {
            return a(r0);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f15084c, this.f15085d, this.f15086e, this.f, this.g, r8), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r38) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f15083b;
            IntentResult<?> r7 = null;
            if (r2 == 0) goto L17;
            if (r2 == 1) goto L14;
            if (r2 != 2) goto L13;
            d.o.a(r38);     // Catch: Exception -> L8 CancellationException -> L10
            Object r3 = r38;
        L51:
            r7 = (IntentResult) ZeusTransformUtils.preCheckCast(r3, IntentResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8 CancellationException -> L10
        L98:
            if (r7 == null) goto L88;
            AtomicCapabilitySdk.INSTANCE.updateIntentResult(r7, this.g, true);     // Catch: Throwable -> L64 Exception -> L66 CancellationException -> L76
        L76:
            e = move-exception;
            throw e;     // Catch: Throwable -> L64
        L66:
            e = move-exception;
            b.a(b.f15059a, "apply_skill_change final delivery failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L64
            if (this.f15085d.i() == true) goto L72;
            b.a(b.f15059a, this.f15085d, this.f15084c, this.f15086e, com.obric.agent.intents.skill.d.h.a(r.q), "ovirt_export");
        L72:
            if (this.f.exists() == true) goto L74;
        L96:
            return x.f38692a;
        L74:
            if (this.f.delete() == true) goto L96;
        L75:
            ILogDepend.Companion.w(b.TAG, "apply_skill_change host archive cleanup failed");
        L88:
            if (this.f15085d.i() == true) goto L91;
            b.a(b.f15059a, this.f15085d, this.f15084c, this.f15086e, com.obric.agent.intents.skill.d.h.a(r.q), "ovirt_export");
        L91:
            if (this.f.exists() == false) goto L96;
            if (this.f.delete() == true) goto L96;
        L64:
            th = move-exception;
            if (this.f15085d.i() == true) goto L82;
            b.a(b.f15059a, this.f15085d, this.f15084c, this.f15086e, com.obric.agent.intents.skill.d.h.a(r.q), "ovirt_export");
        L82:
            if (this.f.exists() == true) goto L84;
        L86:
            throw th;
        L84:
            if (this.f.delete() == true) goto L86;
            ILogDepend.Companion.w(b.TAG, "apply_skill_change host archive cleanup failed");
            goto L86
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d r4 = (d) ZeusTransformUtils.preCheckCast(this.f15082a, d.class, "com.obric.aiagent.plugin");
            d.o.a(r38);     // Catch: Exception -> L8 CancellationException -> L10
            d r14 = r4;
            Object r5 = r38;
        L37:
            com.obric.aiagent.skill.ovirt.api.b r6 = (com.obric.aiagent.skill.ovirt.api.b) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.ovirt.api.b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8 CancellationException -> L10
            if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.skill.ovirt.api.b.C0439b.class) == false) goto L41;
            b.a(b.f15059a, this.f15085d, this.f15084c, this.f15086e, com.obric.agent.intents.skill.d.h.a("BLOCKED", ((com.obric.aiagent.skill.ovirt.api.b.C0439b) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.ovirt.api.b.C0439b.class, "com.obric.aiagent.plugin")).a()), "blocked");     // Catch: Exception -> L8 CancellationException -> L10
            goto L98
        L41:
            if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.skill.ovirt.api.b.d.class) == false) goto L44;
            b.a(b.f15059a, this.f15085d, this.f15084c, this.f15086e, com.obric.agent.intents.skill.d.h.a("SKILL_OVIRT_UNAVAILABLE", "A matching OVirt is unavailable for this phone-operation task"), "ovirt_export");     // Catch: Exception -> L8 CancellationException -> L10
            goto L98
        L44:
            if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.skill.ovirt.api.b.c.class) == false) goto L47;
            com.obric.agent.intents.skill.d.g r1 = com.obric.agent.intents.skill.d.h.a(((com.obric.aiagent.skill.ovirt.api.b.c) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.ovirt.api.b.c.class, "com.obric.aiagent.plugin")).a());     // Catch: Exception -> L8 CancellationException -> L10
            C0305b r8 = b.a(b.f15059a, r1.a(), r1.b());     // Catch: Exception -> L8 CancellationException -> L10
            b.a(b.f15059a, this.f15084c, this.f15086e, r8, "ovirt_export", null, 16, null);     // Catch: Exception -> L8 CancellationException -> L10
            r7 = new IntentResult(0, null, null, ObricService.INSTANCE.getGson().toJson(r8), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);     // Catch: Exception -> L8 CancellationException -> L10
            goto L98
        L47:
            if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.skill.ovirt.api.b.a.class) == false) goto L53;
            b r9 = b.f15059a;     // Catch: Exception -> L8 CancellationException -> L10
            c r10 = this.f15084c;     // Catch: Exception -> L8 CancellationException -> L10
            DispatchContext r11 = this.g;     // Catch: Exception -> L8 CancellationException -> L10
            long r12 = this.f15086e;     // Catch: Exception -> L8 CancellationException -> L10
            File r15 = this.f;     // Catch: Exception -> L8 CancellationException -> L10
            d.c.d r16 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8 CancellationException -> L10
            this.f15082a = null;     // Catch: Exception -> L8 CancellationException -> L10
            this.f15083b = 2;     // Catch: Exception -> L8 CancellationException -> L10
            r3 = b.a(r9, r10, r11, r12, r14, r15, r16);     // Catch: Exception -> L8 CancellationException -> L10
            if (r3 != r0) goto L51;
            return r0;
        L53:
            throw new d.k();     // Catch: Exception -> L8 CancellationException -> L10
        L17:
            d.o.a(r38);
            IOVirtService r13 = IOVirtService.Companion.a();     // Catch: Exception -> L8 CancellationException -> L10
            if (r13 == null) goto L23;
            IOVirtService.e r17 = r13.getTask();     // Catch: Exception -> L8 CancellationException -> L10
            if (r17 == null) goto L23;
            y r18 = r17.paths(this.f15084c.d());     // Catch: Exception -> L8 CancellationException -> L10
        L24:
            if (r18 == null) goto L26;
            e r19 = b.a(b.f15059a, r18, this.f15084c);     // Catch: Exception -> L8 CancellationException -> L10
        L27:
            if (r13 == null) goto L54;
            if (r18 == null) goto L54;
            if (ZeusTransformUtils.instanceOf(r19, e.a.class) == false) goto L33;
            b.a(b.f15059a, this.f15085d, this.f15084c, this.f15086e, ((e.a) ZeusTransformUtils.preCheckCast(r19, e.a.class, "com.obric.aiagent.plugin")).a(), "ovirt_export");     // Catch: Exception -> L8 CancellationException -> L10
            goto L98
        L33:
            o.a(r19, "null cannot be cast to non-null type com.obric.agent.intents.skill.systemskill.SkillApplyChangeActionExecutor.SkillPathResolution.Resolved");     // Catch: Exception -> L8 CancellationException -> L10
            d r20 = ((e.C0306b) ZeusTransformUtils.preCheckCast(r19, e.C0306b.class, "com.obric.aiagent.plugin")).a();     // Catch: Exception -> L8 CancellationException -> L10
            IOVirtService.b r110 = r13.getFiles();     // Catch: Exception -> L8 CancellationException -> L10
            String r111 = this.f15084c.d();     // Catch: Exception -> L8 CancellationException -> L10
            String r112 = r20.a();     // Catch: Exception -> L8 CancellationException -> L10
            com.obric.aiagent.skill.ovirt.api.a.d r113 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.a.d.b(this.f), com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8 CancellationException -> L10
            final w<a> r21 = this.f15085d;     // Catch: Exception -> L8 CancellationException -> L10
            d.h.a.a<x> r114 = new $$Lambda$b$h$WFpFyKeowEaSFcQhjpY28FgxfP4(r21);     // Catch: Exception -> L8 CancellationException -> L10
            d.c.d<? super com.obric.aiagent.skill.ovirt.api.b<com.obric.aiagent.skill.ovirt.api.a.e>> r115 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8 CancellationException -> L10
            this.f15082a = r20;     // Catch: Exception -> L8 CancellationException -> L10
            this.f15083b = 1;     // Catch: Exception -> L8 CancellationException -> L10
            r5 = r110.a(r111, r112, r113, true, r114, r115);     // Catch: Exception -> L8 CancellationException -> L10
            if (r5 != r0) goto L36;
            return r0;
        L36:
            r14 = r20;
        L54:
            b.a(b.f15059a, this.f15085d, this.f15084c, this.f15086e, com.obric.agent.intents.skill.d.h.a("SKILL_OVIRT_UNAVAILABLE", "A matching OVirt is unavailable for this phone-operation task"), "ovirt_export");     // Catch: Exception -> L8 CancellationException -> L10
            goto L98
        L26:
            r19 = null;
        L23:
            r18 = null;
        L10:
            e = move-exception;
            throw e;
        L8:
            e = move-exception;
            b.a(b.f15059a, "apply_skill_change async final failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            com.obric.agent.intents.skill.d.g r116 = com.obric.agent.intents.skill.d.h.a(r.q);
            C0305b r22 = b.a(b.f15059a, r116.a(), r116.b());
            if (b.a(b.f15059a, this.f15085d, this.f15084c, this.f15086e, r116, "ovirt_export") == true) goto L98;
            b.a(b.f15059a, this.f15084c, this.f15086e, r22, "ovirt_export", null, 16, null);
            r7 = new IntentResult(0, null, null, ObricService.INSTANCE.getGson().toJson(r22), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
            goto L98
        }

        private static final x a(w r2) {
            ((w) ZeusTransformUtils.wrapperContextForParams(r2, w.class, "com.obric.aiagent.plugin")).a(a.C0303a.f15062a);
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillApplyChangeActionExecutor.kt */
    @d.c.b.a.f(b = "SkillApplyChangeActionExecutor.kt", c = {266}, d = "executeApply", e = "com.obric.agent.intents.skill.systemskill.SkillApplyChangeActionExecutor")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f15089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f15090d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f15091e;
        int f;

        i(b r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15091e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            this.f15090d = r9;
            this.f |= Integer.MIN_VALUE;
            return b.a(this.f15091e, null, null, 0, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ CharSequence lambda$kWKOrMstSbw25HECyRTR1GTpGdM(byte r0) {
        return a(r0);
    }

    private b() {
    }

    public static final /* synthetic */ C0305b a(b r0, String r1, String r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ e a(b r0, y r1, c r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ Object a(b r8, c r9, DispatchContext r10, long r11, d r13, File r14, d.c.d r15) {
        return r8.a(r9, r10, r11, r13, r14, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(b r0, String r1, Throwable r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ boolean a(b r7, w r8, c r9, long r10, com.obric.agent.intents.skill.d.g r12, String r13) {
        return r7.a((w) ZeusTransformUtils.wrapperContextForParams(r8, w.class, "com.obric.aiagent.plugin"), r9, r10, r12, r13);
    }

    @Override // com.obric.agent.intents.skill.a.c
    public /* synthetic */ Object a(com.obric.agent.intents.skill.a.b r3, c r4, DispatchContext r5, d.c.d r6) {
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a2((com.obric.agent.intents.skill.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.intents.skill.a.b.class, "com.obric.aiagent.plugin"), (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin"), r5, r7);
    }

    static {
        f15059a = new b();
        f15060b = "apply_skill_change";
        f15061c = new SecureRandom();
    }

    @Override // com.obric.agent.intents.skill.a.c
    public String a() {
        return f15060b;
    }

    @Override // com.obric.agent.intents.skill.a.c
    public com.obric.agent.intents.skill.a.g<c> a(com.obric.agent.intents.skill.a.f r12) {
        o.e(r12, Ext.KEY_REQUEST);
        c r3 = (c) ZeusTransformUtils.preCheckCast(com.obric.agent.intents.skill.a.e.f14888a.a(r12.c(), c.class, TAG), c.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        String r1 = r3.a();
        if (r1 == null) goto L11;
        String r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r2 == null) goto L11;
        String r4 = r2.toLowerCase(Locale.ROOT);
        o.c(r4, "toLowerCase(...)");
    L13:
        if (o.a(r4, "create") == false) goto L17;
        com.obric.aiagent.skill.manager.api.j r5 = com.obric.aiagent.skill.manager.api.j.f19267a;
    L15:
        com.obric.aiagent.skill.manager.api.j r8 = r5;
        String r6 = r3.b();
        if (r6 == null) goto L22;
        String r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L23:
        String r9 = "";
        if (r7 != null) goto L27;
        r7 = "";
    L27:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L31;
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(-2004, "skill_path is missing"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L31:
        if (a(r7) == false) goto L33;
        int r10 = f.f15078a[r8.ordinal()];
        if (r10 == 1) goto L52;
        if (r10 != 2) goto L50;
        String r0 = r3.c();
        if (r0 == null) goto L41;
        String r11 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L42:
        if (r11 == null) goto L46;
        r9 = r11;
    L46:
        if (b(r9) == false) goto L48;
    L55:
        String r13 = r12.a();
        String r14 = r3.c();
        if (r14 == null) goto L58;
        String r15 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L60:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.b(c.a(r3, null, r7, r15, r13, r8, 1, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L58:
        r15 = null;
        goto L60
    L48:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(-2004, "update requires skill_slug"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L41:
        r11 = null;
        goto L42
    L50:
        throw new d.k();
    L52:
        if (r3.c() == null) goto L55;
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(103, "create forbids skill_slug"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L33:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(103, "skill_path must be ~/... or absolute"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L22:
        r7 = null;
        goto L23
    L17:
        if (o.a(r4, "update") == false) goto L62;
        r5 = com.obric.aiagent.skill.manager.api.j.f19268b;
        goto L15
    L62:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(103, "mode must be create or update"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L11:
        r4 = null;
        goto L13
    L5:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(a(103, "invalid apply_skill_change actionArgs"), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public Object a2(com.obric.agent.intents.skill.a.b r20, c r21, DispatchContext r22, d.c.d<? super IntentResult<Empty>> r23) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L7;
        g r2 = (g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.aiagent.plugin");
        if ((r2.f15081c & Integer.MIN_VALUE) == 0) goto L7;
        r2.f15081c -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f15079a;
        Object r4 = d.c.a.b.a();
        int r5 = r2.f15081c;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        d.o.a(r1);
    L21:
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
        if (o.a(r3, a.C0303a.f15062a) == false) goto L25;
        return k.a();
    L25:
        if (ZeusTransformUtils.instanceOf(r3, a.C0304b.class) == false) goto L29;
        return ((a.C0304b) ZeusTransformUtils.preCheckCast(r3, a.C0304b.class, "com.obric.aiagent.plugin")).a();
    L29:
        throw new d.k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r1);
        long r10 = SystemClock.elapsedRealtime();
        if (al.f19195a.a().x() == true) goto L18;
        ILogDepend.Companion.w(TAG, "apply_skill_change blocked by create Skill cloud setting, mode=" + r21.e());
        return a(r21, r10, com.obric.agent.intents.skill.d.h.b(), "blocked");
    L18:
        w r6 = kotlinx.coroutines.y.a(null, 1, null);
        kotlinx.coroutines.i.a(com.obric.agent.intents.skill.a.h.f14894a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new h(r21, r6, r10, new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r22.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getCacheDir(), "skill_apply_intent_" + c() + ".zip"), r22, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        r2.f15081c = 1;
        r1 = r6.a(r2);
        if (r1 != r4) goto L21;
        return r4;
    L7:
        r2 = new g(this, r0);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r27v1, types: [com.obric.agent.intents.skill.d.b] */
    /* JADX WARN: Type inference failed for: r28v1, types: [com.obric.agent.intents.skill.d.b$c] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.obric.agent.intents.skill.d.b$c] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.obric.aiagent.skill.manager.api.j] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object] */
    private final Object a(c r28, DispatchContext r29, long r30, d r32, File r33, d.c.d<? super IntentResult<Empty>> r34) {
        b r10 = this;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r34, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, i.class) == false) goto L7;
        i r1 = (i) ZeusTransformUtils.preCheckCast(r0, i.class, "com.obric.aiagent.plugin");
        if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
        r1.f -= Integer.MIN_VALUE;
    L8:
        Object r2 = r1.f15090d;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        long r5 = r1.f15089c;
        c r6 = (c) ZeusTransformUtils.preCheckCast(r1.f15088b, c.class, "com.obric.aiagent.plugin");
        b r7 = (b) ZeusTransformUtils.preCheckCast(r1.f15087a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Exception -> L14 CancellationException -> L83
        r10 = r7;
        ?? r8 = r6;
    L86:
        u r9 = (u) ZeusTransformUtils.preCheckCast(r2, u.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L67 CancellationException -> L83
        if (ZeusTransformUtils.instanceOf(r9, u.a.class) == false) goto L43;
        com.obric.agent.intents.skill.d.g r11 = com.obric.agent.intents.skill.d.h.a((u.a) ZeusTransformUtils.preCheckCast(r9, u.a.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L67 CancellationException -> L83
        C0305b r12 = f15059a.a(r11.a(), r11.b());     // Catch: Exception -> L67 CancellationException -> L83
    L46:
        if (ZeusTransformUtils.instanceOf(r9, u.a.class) == false) goto L49;
        Integer r13 = null;
    L53:
        if (ZeusTransformUtils.instanceOf(r9, u.a.class) == false) goto L56;
    L54:
        String r14 = "commit";
    L61:
        r10.a(r8, r5, r12, r14, r13);     // Catch: Exception -> L67 CancellationException -> L83
        return new IntentResult(0, null, null, ObricService.INSTANCE.getGson().toJson(r12), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L56:
        if (r12.a() == false) goto L59;
        r14 = "complete";
        goto L61
    L59:
        if (r12.b() == false) goto L54;
        r14 = "scan_submit";
        goto L61
    L49:
        if (ZeusTransformUtils.instanceOf(r9, u.b.class) == false) goto L64;
        r13 = ((com.obric.aiagent.skill.manager.api.l) ZeusTransformUtils.preCheckCast(((u.b) ZeusTransformUtils.preCheckCast(r9, u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.l.class, "com.obric.aiagent.plugin")).d();     // Catch: Exception -> L67 CancellationException -> L83
        goto L53
    L64:
        throw new d.k();     // Catch: Exception -> L67 CancellationException -> L83
    L43:
        if (ZeusTransformUtils.instanceOf(r9, u.b.class) == false) goto L66;
        r12 = r10.a((com.obric.aiagent.skill.manager.api.l) ZeusTransformUtils.preCheckCast(((u.b) ZeusTransformUtils.preCheckCast(r9, u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.l.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L67 CancellationException -> L83
        goto L46
    L66:
        throw new d.k();     // Catch: Exception -> L67 CancellationException -> L83
    L67:
        e = e;
        ?? r15 = r8;
        long r16 = r5;
    L80:
        b r17 = r10;
        ?? r18 = r15;
    L81:
        r17.a("apply_skill_change operation failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        com.obric.agent.intents.skill.d.g r19 = com.obric.agent.intents.skill.d.h.a(r.q);
        C0305b r20 = r17.a(r19.a(), r19.b());
        a(r17, r18, r16, r20, "ovirt_export", null, 16, null);
        return new IntentResult(0, null, null, ObricService.INSTANCE.getGson().toJson(r20), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L14:
        e = e;
        r17 = r7;
        r18 = r6;
        r16 = r5;
        goto L81
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r2);
        ISkillManagerService r21 = ISkillManagerService.Companion.a();     // Catch: Exception -> L76 CancellationException -> L83
        if (r21 != null) goto L25;
        com.obric.agent.intents.skill.d.g r22 = com.obric.agent.intents.skill.d.h.a(r.m);     // Catch: Exception -> L23 CancellationException -> L83
        C0305b r23 = r10.a(r22.a(), r22.b());     // Catch: Exception -> L23 CancellationException -> L83
        a(this, r28, r30, r23, "commit", null, 16, null);     // Catch: Exception -> L23 CancellationException -> L83
        return new IntentResult(0, null, null, ObricService.INSTANCE.getGson().toJson(r23), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L25:
        ?? r24 = r28.e();     // Catch: Exception -> L76 CancellationException -> L83
        if (r24 == 0) goto L73;
        String r25 = r32.b();     // Catch: Exception -> L76 CancellationException -> L83
        if (r25 != null) goto L31;
        r25 = r28.c();     // Catch: Exception -> L23 CancellationException -> L83
    L31:
        com.obric.aiagent.skill.manager.api.k r26 = new com.obric.aiagent.skill.manager.api.k(r24, r33, r25);     // Catch: Exception -> L76 CancellationException -> L83
        r1.f15087a = r10;     // Catch: Exception -> L76 CancellationException -> L83
        r24 = r28;
        r1.f15088b = r24;     // Catch: Exception -> L69 CancellationException -> L83
        r1.f15089c = r30;     // Catch: Exception -> L74 CancellationException -> L83
        r1.f = 1;     // Catch: Exception -> L74 CancellationException -> L83
        r2 = r21.applySkillChange(r26, r1);     // Catch: Exception -> L74 CancellationException -> L83
        if (r2 != r3) goto L38;
        return r3;
    L38:
        r8 = r24;
        r5 = r30;
    L69:
        e = e;
    L79:
        r15 = r24;
        r16 = r30;
        goto L80
    L73:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Exception -> L74 CancellationException -> L83
    L74:
        e = e;
    L23:
        e = e;
        r15 = r28;
        r16 = r30;
    L76:
        e = e;
        r24 = r28;
    L83:
        e = move-exception;
        throw e;
    L7:
        r1 = new i(r10, r0);
        goto L8
    }

    private final boolean a(w<a> r8, c r9, long r10, com.obric.agent.intents.skill.d.g r12, String r13) {
        w r11 = (w) ZeusTransformUtils.wrapperContextForParams(r8, w.class, "com.obric.aiagent.plugin");
        if (r11.i() == false) goto L7;
        return false;
    L7:
        return r11.a(new a.C0304b(a(r9, r10, r12, r13)));
    }

    private final e a(y r10, c r11) {
        String r2 = r11.b();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r4 = null;
        boolean r5 = false;
        if (d.o.o.b(r2, "~/", false, 2, null) == false) goto L10;
        String r0 = r10.a(d.o.o.a(r2, (CharSequence) ZeusTransformUtils.preCheckCast("~/", CharSequence.class, "com.obric.aiagent.plugin"))).a();     // Catch: Exception -> L39
    L13:
        if (r11.e() != com.obric.aiagent.skill.manager.api.j.f19268b) goto L15;
        String r12 = d.o.o.c(r10.a(".agents/skills").a(), new char[]{'/'});     // Catch: Exception -> L35
        String r6 = d.o.o.a(r0, (CharSequence) ZeusTransformUtils.preCheckCast(r12 + '/', CharSequence.class, "com.obric.aiagent.plugin"));
        if (d.o.o.b(r0, r12 + '/', false, 2, null) == true) goto L20;
    L24:
        if (r5 == false) goto L26;
        r4 = r6;
    L26:
        if (r4 != null) goto L30;
        return (e) ZeusTransformUtils.preCheckCast(b(), e.class, "com.obric.aiagent.plugin");
    L30:
        if (o.a(r4, r11.c()) == true) goto L34;
        return (e) ZeusTransformUtils.preCheckCast(new e.a(com.obric.agent.intents.skill.d.h.a("SKILL_PATH_SLUG_MISMATCH", "skill_slug does not match the final skill_path directory segment")), e.class, "com.obric.aiagent.plugin");
    L34:
        return (e) ZeusTransformUtils.preCheckCast(new e.C0306b(new d(r0, r4)), e.class, "com.obric.aiagent.plugin");
    L20:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L24;
        if (f15059a.b(r6) == false) goto L24;
        r5 = true;
    L36:
        return (e) ZeusTransformUtils.preCheckCast(b(), e.class, "com.obric.aiagent.plugin");
    L15:
        return (e) ZeusTransformUtils.preCheckCast(new e.C0306b(new d(r0, null)), e.class, "com.obric.aiagent.plugin");
    L10:
        if (d.o.o.b(r2, "/", false, 2, null) == false) goto L38;
        r0 = r10.c(r2).a();     // Catch: Exception -> L39
        goto L13
    L38:
        return (e) ZeusTransformUtils.preCheckCast(b(), e.class, "com.obric.aiagent.plugin");
    L40:
        return (e) ZeusTransformUtils.preCheckCast(b(), e.class, "com.obric.aiagent.plugin");
    }

    private final e.a b() {
        return new e.a(com.obric.agent.intents.skill.d.h.a("SKILL_PATH_INVALID", "skill_path is not a valid projected Skill root"));
    }

    private final C0305b a(com.obric.aiagent.skill.manager.api.l r16) {
        r r0 = r16.e();
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
        boolean r6 = r5;
        boolean r7 = r16.a();
        String r8 = r16.b().name().toLowerCase(Locale.ROOT);
        o.c(r8, "toLowerCase(...)");
        String r9 = r16.c().a();
        String r10 = r16.c().b();
        Integer r11 = Integer.valueOf(r16.c().j());
        String r12 = a(r16.c().i());
        if (r2 == null) goto L17;
        String r13 = r2.a();
    L18:
        if (r2 == null) goto L21;
        r1 = r2.b();
    L21:
        return new C0305b(r4, r6, r7, r8, r9, r10, r11, r12, r13, r1);
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

    private final C0305b a(String r14, String r15) {
        return new C0305b(j.f15178c, false, false, null, null, null, null, null, r14, r15, 248, null);
    }

    static /* synthetic */ void a(b r7, c r8, long r9, C0305b r11, String r12, Integer r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        r13 = null;
    L5:
        r7.a(r8, r9, r11, r12, r13);
    }

    private final void a(c r14, long r15, C0305b r17, String r18, Integer r19) {
        com.obric.agent.intents.skill.e.a r0 = com.obric.agent.intents.skill.e.a.f15181a;
        String r1 = r14.d();
        long r2 = SystemClock.elapsedRealtime() - r15;
        com.obric.aiagent.skill.manager.api.j r4 = r14.e();
        if (r4 == null) goto L7;
        String r5 = r4.name();
        if (r5 == null) goto L7;
        String r6 = r5.toLowerCase(Locale.ROOT);
        o.c(r6, "toLowerCase(...)");
    L8:
        if (r6 != null) goto L10;
        r6 = "";
    L10:
        r0.a(r1, r2, r6, r17.c(), r19, r17.d(), r17.a(), r17.b(), r18, r17.e(), r17.f());
        return;
    L7:
        r6 = null;
        goto L8
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
        String r8 = d.o.o.a(r9, (CharSequence) ZeusTransformUtils.preCheckCast("~/", CharSequence.class, "com.obric.aiagent.plugin"));
    L14:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'/'}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
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
        r8 = d.o.o.a(r9, (CharSequence) ZeusTransformUtils.preCheckCast("/", CharSequence.class, "com.obric.aiagent.plugin"));
        goto L14
    }

    private final boolean b(String r7) {
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L23;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), '/', false, 2, null) == true) goto L23;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), 0, false, 2, null) == true) goto L23;
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
        if (r8 == false) goto L23;
        if (o.a(r7, ".") == true) goto L23;
        if (o.a(r7, DownloadConstants.VULNERABILITY_PATH) == true) goto L23;
        return true;
    L15:
        r8 = true;
    L23:
        return false;
    }

    private final com.obric.agent.intents.skill.a.g.a a(int r16, String r17) {
        return new com.obric.agent.intents.skill.a.g.a(new IntentResult(r16, null, null, r17, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null));
    }

    private final IntentResult<Empty> a(c r25, long r26, com.obric.agent.intents.skill.d.g r28, String r29) {
        C0305b r0 = a(r28.a(), r28.b());
        a(this, r25, r26, r0, r29, null, 16, null);
        return new IntentResult(0, null, null, ObricService.INSTANCE.getGson().toJson(r0), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    }

    private final String c() {
        byte[] r0 = new byte[12];
        f15061c.nextBytes(r0);
        return d.a.i.a(r0, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$b$kWKOrMstSbw25HECyRTR1GTpGdM.INSTANCE, 30, null);
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
