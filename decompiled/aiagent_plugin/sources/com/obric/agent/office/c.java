package com.obric.agent.office;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.obric.agent.complextask.IComplexTaskService;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.credentials.api.ISkillCredentialService;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.ITaskStateChangeCallback;
import com.obric.capabilitykit.common.TaskState;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.OfficeLarkCLIEnsureAuthParams;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDNetworkSpeedTest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.w;
import org.json.JSONObject;

/* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final String TAG = "OfficeLarkCLIIntent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f15302a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f15303b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.o.k f15304c = null;

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IntentResult<Empty> f15305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15307c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f15308d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f15309e;
        private final String f;
        private final int g;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15305a, r6.f15305a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15306b, r6.f15306b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15307c, r6.f15307c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f15308d, r6.f15308d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f15309e, r6.f15309e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f15305a.hashCode() * 31) + this.f15306b.hashCode()) * 31;
            String r1 = this.f15307c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f15308d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f15309e;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.f;
            if (r11 == null) goto L19;
            r2 = r11.hashCode();
        L19:
            return ((r10 + r2) * 31) + Integer.hashCode(this.g);
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
            return "EnsureAuthFinalResult(intentResult=" + this.f15305a + ", outcome=" + this.f15306b + ", failureStage=" + this.f15307c + ", errorType=" + this.f15308d + ", errorSubtype=" + this.f15309e + ", tokenStatus=" + this.f + ", missingScopeCount=" + this.g + ')';
        }

        public a(IntentResult<Empty> r2, String r3, String r4, String r5, String r6, String r7, int r8) {
            d.h.b.o.e(r2, "intentResult");
            d.h.b.o.e(r3, "outcome");
            this.f15305a = r2;
            this.f15306b = r3;
            this.f15307c = r4;
            this.f15308d = r5;
            this.f15309e = r6;
            this.f = r7;
            this.g = r8;
        }

        public final IntentResult<Empty> a() {
            return this.f15305a;
        }

        public final String b() {
            return this.f15306b;
        }

        public final String c() {
            return this.f15307c;
        }

        public final String d() {
            return this.f15308d;
        }

        public final String e() {
            return this.f15309e;
        }

        public final String f() {
            return this.f;
        }

        public final int g() {
            return this.g;
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15310a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("status")
        private final String f15311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("auth_type")
        private final String f15312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("auth_session_id")
        private final String f15313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("logged_in")
        private final Boolean f15314e;

        @SerializedName("verified")
        private final Boolean f;

        @SerializedName(DownloadHelper.IDENTITY)
        private final String g;

        @SerializedName("user")
        private final e.a h;

        @SerializedName("token_status")
        private final String i;

        @SerializedName("granted_scopes")
        private final List<String> j;

        @SerializedName("missing_scopes")
        private final List<String> k;

        @SerializedName("takeover_reason")
        private final String l;

        @SerializedName("message")
        private final String m;

        @SerializedName("hint")
        private final String n;

        @SerializedName("error_type")
        private final String o;

        @SerializedName("error_subtype")
        private final String p;

        /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }

            public static /* synthetic */ b a(a r1, String r2, e r3, List r4, String r5, int r6, Object r7) {
                List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
                if ((r6 & 8) == 0) goto L6;
                r5 = null;
            L6:
                return r1.a(r2, r3, r8, r5);
            }

            public final b a(String r20, e r21, List<String> r22, String r23) {
                List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r20, "authType");
                d.h.b.o.e(r21, "login");
                d.h.b.o.e(r0, "missingScopes");
                String r1 = "authorized";
                String r3 = null;
                return new b(r1, r20, r3, Boolean.valueOf(r21.a()), Boolean.valueOf(r21.b()), r21.c(), r21.d(), r21.e(), r21.f(), r0, null, null, r23, null, null, 27652, null);
            }

            public final b a(com.obric.aiagent.skill.credentials.api.l.b r21) {
                d.h.b.o.e(r21, Ext.KEY_REQUEST);
                String r3 = "pending";
                Boolean r6 = null;
                Boolean r7 = null;
                String r8 = null;
                e.a r9 = null;
                String r10 = null;
                List r11 = null;
                return new b(r3, r21.e().a(), r21.a(), r6, r7, r8, r9, r10, r11, r21.d(), "lark_authorize", null, null, null, null, 31224, null);
            }

            public static /* synthetic */ b a(a r9, String r10, String r11, String r12, String r13, List r14, String r15, String r16, int r17, Object r18) {
                List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
                if ((r17 & 32) == 0) goto L5;
                String r7 = null;
            L7:
                if ((r17 & 64) == 0) goto L9;
                String r8 = null;
            L11:
                return r9.a(r10, r11, r12, r13, r6, r7, r8);
            L9:
                r8 = r16;
                goto L11
            L5:
                r7 = r15;
                goto L7
            }

            public final b a(String r20, String r21, String r22, String r23, List<String> r24, String r25, String r26) {
                List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r20, "status");
                d.h.b.o.e(r21, "message");
                d.h.b.o.e(r22, "authType");
                d.h.b.o.e(r23, "authSessionId");
                d.h.b.o.e(r0, "missingScopes");
                return new b(r20, r22, r23, null, null, null, null, null, null, r0, null, r21, null, r25, r26, 5624, null);
            }
        }

        static {
            f15310a = new a(null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15311b, r6.f15311b) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15312c, r6.f15312c) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15313d, r6.f15313d) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f15314e, r6.f15314e) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.g, r6.g) == true) goto L27;
            return false;
        L27:
            if (d.h.b.o.a(this.h, r6.h) == true) goto L30;
            return false;
        L30:
            if (d.h.b.o.a(this.i, r6.i) == true) goto L33;
            return false;
        L33:
            if (d.h.b.o.a(this.j, r6.j) == true) goto L36;
            return false;
        L36:
            if (d.h.b.o.a(this.k, r6.k) == true) goto L39;
            return false;
        L39:
            if (d.h.b.o.a(this.l, r6.l) == true) goto L42;
            return false;
        L42:
            if (d.h.b.o.a(this.m, r6.m) == true) goto L45;
            return false;
        L45:
            if (d.h.b.o.a(this.n, r6.n) == true) goto L48;
            return false;
        L48:
            if (d.h.b.o.a(this.o, r6.o) == true) goto L51;
            return false;
        L51:
            if (d.h.b.o.a(this.p, r6.p) == true) goto L53;
            return false;
        L53:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f15311b.hashCode() * 31) + this.f15312c.hashCode()) * 31;
            String r1 = this.f15313d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Boolean r5 = this.f15314e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Boolean r8 = this.f;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.g;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            e.a r14 = this.h;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.i;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            List<String> r20 = this.j;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (((r19 + r21) * 31) + this.k.hashCode()) * 31;
            String r23 = this.l;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            String r26 = this.m;
            if (r26 != null) goto L37;
            int r27 = 0;
        L38:
            int r28 = (r25 + r27) * 31;
            String r29 = this.n;
            if (r29 != null) goto L41;
            int r30 = 0;
        L42:
            int r31 = (r28 + r30) * 31;
            String r32 = this.o;
            if (r32 != null) goto L45;
            int r33 = 0;
        L46:
            int r34 = (r31 + r33) * 31;
            String r35 = this.p;
            if (r35 == null) goto L51;
            r2 = r35.hashCode();
        L51:
            return r34 + r2;
        L45:
            r33 = r32.hashCode();
            goto L46
        L41:
            r30 = r29.hashCode();
            goto L42
        L37:
            r27 = r26.hashCode();
            goto L38
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
            r0.append("EnsureAuthPayload(status=").append(this.f15311b).append(", authType=").append(this.f15312c).append(", authSessionId=").append(this.f15313d).append(", loggedIn=").append(this.f15314e).append(", verified=").append(this.f).append(", identity=").append(this.g).append(", user=").append(this.h).append(", tokenStatus=").append(this.i).append(", grantedScopes=").append(this.j).append(", missingScopes=").append(this.k).append(", takeoverReason=").append(this.l).append(", message=");
            r0.append(this.m).append(", hint=").append(this.n).append(", errorType=").append(this.o).append(", errorSubtype=").append(this.p).append(')');
            return r0.toString();
        }

        public b(String r8, String r9, String r10, Boolean r11, Boolean r12, String r13, e.a r14, String r15, List<String> r16, List<String> r17, String r18, String r19, String r20, String r21, String r22) {
            List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r8, "status");
            d.h.b.o.e(r9, "authType");
            d.h.b.o.e(r4, "missingScopes");
            this.f15311b = r8;
            this.f15312c = r9;
            this.f15313d = r10;
            this.f15314e = r11;
            this.f = r12;
            this.g = r13;
            this.h = r14;
            this.i = r15;
            this.j = r3;
            this.k = r4;
            this.l = r18;
            this.m = r19;
            this.n = r20;
            this.o = r21;
            this.p = r22;
        }

        public /* synthetic */ b(String r20, String r21, String r22, Boolean r23, Boolean r24, String r25, e.a r26, String r27, List r28, List r29, String r30, String r31, String r32, String r33, String r34, int r35, d.h.b.h r36) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.aiagent.plugin");
            List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.aiagent.plugin");
            if ((r35 & 4) == 0) goto L5;
            String r6 = null;
        L7:
            if ((r35 & 8) == 0) goto L9;
            Boolean r7 = null;
        L11:
            if ((r35 & 16) == 0) goto L13;
            Boolean r8 = null;
        L15:
            if ((r35 & 32) == 0) goto L17;
            String r9 = null;
        L19:
            if ((r35 & 64) == 0) goto L21;
            e.a r10 = null;
        L23:
            if ((r35 & 128) == 0) goto L25;
            String r11 = null;
        L27:
            if ((r35 & 256) == 0) goto L29;
            List r12 = null;
        L31:
            if ((r35 & 1024) == 0) goto L33;
            String r14 = null;
        L35:
            if ((r35 & 2048) == 0) goto L37;
            String r15 = null;
        L39:
            if ((r35 & 4096) == 0) goto L41;
            String r16 = null;
        L43:
            if ((r35 & 8192) == 0) goto L45;
            String r17 = null;
        L47:
            if ((r35 & 16384) == 0) goto L49;
            String r18 = null;
        L50:
            this(r20, r21, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
            return;
        L49:
            r18 = r34;
            goto L50
        L45:
            r17 = r33;
            goto L47
        L41:
            r16 = r32;
            goto L43
        L37:
            r15 = r31;
            goto L39
        L33:
            r14 = r30;
            goto L35
        L29:
            r12 = r1;
            goto L31
        L25:
            r11 = r27;
            goto L27
        L21:
            r10 = r26;
            goto L23
        L17:
            r9 = r25;
            goto L19
        L13:
            r8 = r24;
            goto L15
        L9:
            r7 = r23;
            goto L11
        L5:
            r6 = r22;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.office.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    private static final class C0314c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f15316b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0314c.class) == true) goto L8;
            return false;
        L8:
            C0314c r6 = (C0314c) ZeusTransformUtils.preCheckCast(r5, C0314c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15315a, r6.f15315a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15316b, r6.f15316b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f15315a.hashCode() * 31) + this.f15316b.hashCode();
        }

        public String toString() {
            return "EnsureAuthRequest(reason=" + this.f15315a + ", scopes=" + this.f15316b + ')';
        }

        public C0314c(String r3, List<String> r4) {
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "reason");
            d.h.b.o.e(r5, "scopes");
            this.f15315a = r3;
            this.f15316b = r5;
        }

        public final String a() {
            return this.f15315a;
        }

        public final List<String> b() {
            return this.f15316b;
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15317a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("status")
        private final String f15318b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("error_type")
        private final String f15319c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("message")
        private final String f15320d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("hint")
        private final String f15321e;

        /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }

            public static /* synthetic */ d a(a r0, String r1, String r2, String r3, int r4, Object r5) {
                if ((r4 & 4) == 0) goto L6;
                r3 = null;
            L6:
                return r0.a(r1, r2, r3);
            }

            public final d a(String r2, String r3, String r4) {
                d.h.b.o.e(r2, "errorType");
                d.h.b.o.e(r3, "message");
                return new d("failed", r2, r3, r4);
            }

            public final d a(Throwable r5) {
                d.h.b.o.e(r5, WsConstants.KEY_CONNECTION_ERROR);
                String r1 = null;
                if (ZeusTransformUtils.instanceOf(r5, com.obric.aiagent.skill.credentials.api.e.class) == false) goto L5;
                com.obric.aiagent.skill.credentials.api.e r0 = (com.obric.aiagent.skill.credentials.api.e) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.credentials.api.e.class, "com.obric.aiagent.plugin");
            L6:
                if (r0 == null) goto L8;
                com.obric.aiagent.skill.credentials.api.h r2 = r0.a();
            L9:
                if (r2 == null) goto L12;
                String r3 = r2.getType();
                if (r3 == null) goto L12;
            L13:
                d.h.b.o.a(r3);
                if (r2 == null) goto L17;
                String r4 = r2.d();
                if (r4 == null) goto L17;
            L20:
                if (r2 == null) goto L23;
                r1 = r2.e();
            L23:
                return a(r3, r4, r1);
            L17:
                r4 = r5.getMessage();
                if (r4 != null) goto L20;
                r4 = "";
            L12:
                r3 = r5.getClass().getSimpleName();
                goto L13
            L8:
                r2 = null;
                goto L9
            L5:
                r0 = null;
                goto L6
            }
        }

        static {
            f15317a = new a(null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15318b, r6.f15318b) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15319c, r6.f15319c) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15320d, r6.f15320d) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f15321e, r6.f15321e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f15318b.hashCode() * 31) + this.f15319c.hashCode()) * 31) + this.f15320d.hashCode()) * 31;
            String r2 = this.f15321e;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "ErrorPayload(status=" + this.f15318b + ", errorType=" + this.f15319c + ", message=" + this.f15320d + ", hint=" + this.f15321e + ')';
        }

        public d(String r2, String r3, String r4, String r5) {
            d.h.b.o.e(r2, "status");
            d.h.b.o.e(r3, "errorType");
            d.h.b.o.e(r4, "message");
            this.f15318b = r2;
            this.f15319c = r3;
            this.f15320d = r4;
            this.f15321e = r5;
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("logged_in")
        private final boolean f15322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("verified")
        private final boolean f15323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName(DownloadHelper.IDENTITY)
        private final String f15324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("user")
        private final a f15325d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("token_status")
        private final String f15326e;

        @SerializedName("granted_scopes")
        private final List<String> f;

        /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @SerializedName("name")
            private final String f15327a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @SerializedName("open_id")
            private final String f15328b;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f15327a, r6.f15327a) == true) goto L12;
                return false;
            L12:
                if (d.h.b.o.a(this.f15328b, r6.f15328b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f15327a.hashCode() * 31) + this.f15328b.hashCode();
            }

            public String toString() {
                return "User(name=" + this.f15327a + ", openId=" + this.f15328b + ')';
            }

            public a(String r2, String r3) {
                d.h.b.o.e(r2, "name");
                d.h.b.o.e(r3, "openId");
                this.f15327a = r2;
                this.f15328b = r3;
            }
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (this.f15322a == r6.f15322a) goto L12;
            return false;
        L12:
            if (this.f15323b == r6.f15323b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15324c, r6.f15324c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f15325d, r6.f15325d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f15326e, r6.f15326e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((((Boolean.hashCode(this.f15322a) * 31) + Boolean.hashCode(this.f15323b)) * 31) + this.f15324c.hashCode()) * 31;
            a r1 = this.f15325d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((r0 + r2) * 31) + this.f15326e.hashCode()) * 31) + this.f.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "LoginStatusPayload(loggedIn=" + this.f15322a + ", verified=" + this.f15323b + ", identity=" + this.f15324c + ", user=" + this.f15325d + ", tokenStatus=" + this.f15326e + ", grantedScopes=" + this.f + ')';
        }

        public e(boolean r3, boolean r4, String r5, a r6, String r7, List<String> r8) {
            List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, DownloadHelper.IDENTITY);
            d.h.b.o.e(r7, "tokenStatus");
            d.h.b.o.e(r9, "grantedScopes");
            this.f15322a = r3;
            this.f15323b = r4;
            this.f15324c = r5;
            this.f15325d = r6;
            this.f15326e = r7;
            this.f = r9;
        }

        public final boolean a() {
            return this.f15322a;
        }

        public final boolean b() {
            return this.f15323b;
        }

        public final String c() {
            return this.f15324c;
        }

        public final a d() {
            return this.f15325d;
        }

        public final String e() {
            return this.f15326e;
        }

        public final List<String> f() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    public /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15329a = null;

        static {
            int[] r0 = new int[com.obric.aiagent.skill.credentials.api.l.d.values().length];
            r0[com.obric.aiagent.skill.credentials.api.l.d.f18986a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[com.obric.aiagent.skill.credentials.api.l.d.f18987b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[com.obric.aiagent.skill.credentials.api.l.d.f18988c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[com.obric.aiagent.skill.credentials.api.l.d.f18989d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f15329a = r0;
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {475, 495, 527, 564, 586, 617}, d = "awaitAuthAndBuildFinalResult", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15332c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f15333d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f15334e;
        /* synthetic */ Object f;
        final /* synthetic */ c g;
        int h;

        g(c r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return c.a(this.g, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {476}, d = "invokeSuspend", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler$awaitAuthAndBuildFinalResult$authResult$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.aiagent.skill.credentials.api.l.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.credentials.api.l.a f15336b;

        h(com.obric.aiagent.skill.credentials.api.l.a r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15336b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super com.obric.aiagent.skill.credentials.api.l.c> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f15336b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.aiagent.skill.credentials.api.l.c> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15335a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            w<com.obric.aiagent.skill.credentials.api.l.c> r6 = this.f15336b.b();
            d.c.d<? super com.obric.aiagent.skill.credentials.api.l.c> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15335a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {BDNetworkSpeedTest.KeyIsEnableIntelligentSpeedTest}, d = "awaitAuthFlowEntryOrFail", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f15338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f15339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f15340d;

        i(c r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15339c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15338b = r3;
            this.f15340d |= Integer.MIN_VALUE;
            return c.a(this.f15339c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {1309}, d = "invokeSuspend", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler$awaitAuthFlowEntryOrFail$entered$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.credentials.api.l.a f15342b;

        /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
        @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler$awaitAuthFlowEntryOrFail$entered$1$1$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<x, d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f15343a;

            a(d.c.d<? super a> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(x r3, d.c.d<? super Boolean> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(x r3, d.c.d<? super Boolean> r4) {
                return a((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r1) {
                d.c.a.b.a();
                if (this.f15343a != 0) goto L7;
                d.o.a(r1);
                return d.c.b.a.b.a(true);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
        @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler$awaitAuthFlowEntryOrFail$entered$1$1$2")
        static final class b extends d.c.b.a.l implements d.h.a.m<com.obric.aiagent.skill.credentials.api.l.c, d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f15344a;

            b(d.c.d<? super b> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(com.obric.aiagent.skill.credentials.api.l.c r3, d.c.d<? super Boolean> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(com.obric.aiagent.skill.credentials.api.l.c r3, d.c.d<? super Boolean> r4) {
                return a((com.obric.aiagent.skill.credentials.api.l.c) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.credentials.api.l.c.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r1) {
                d.c.a.b.a();
                if (this.f15344a != 0) goto L7;
                d.o.a(r1);
                return d.c.b.a.b.a(false);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        j(com.obric.aiagent.skill.credentials.api.l.a r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15342b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f15342b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15341a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            com.obric.aiagent.skill.credentials.api.l.a r11 = this.f15342b;
            kotlinx.coroutines.e.i r2 = new kotlinx.coroutines.e.i(getContext());
            kotlinx.coroutines.e.c r3 = (kotlinx.coroutines.e.c) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.e.c.class, "com.obric.aiagent.plugin");
            r3.a(r11.c().g(), (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(null), d.h.a.m.class, "com.obric.aiagent.plugin"));
            r3.a(r11.b().g(), (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(null), d.h.a.m.class, "com.obric.aiagent.plugin"));
            this.f15341a = 1;
            r10 = r2.a(this);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {ApWakeEvent.ACCELERATING_END}, d = "checkLoginDetails", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f15345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f15346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f15347c;

        k(c r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15346b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15345a = r3;
            this.f15347c |= Integer.MIN_VALUE;
            return this.f15346b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {158, 176}, d = "checkLoginInternal", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler")
    static final class l extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f15351d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f15352e;
        long f;
        /* synthetic */ Object g;
        final /* synthetic */ c h;
        int i;

        l(c r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return c.a(this.h, false, false, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {989}, d = "cleanupConfiguredApp", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler")
    static final class m extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f15354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f15355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f15356d;

        m(c r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15355c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15354b = r3;
            this.f15356d |= Integer.MIN_VALUE;
            return c.a(this.f15355c, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {799, 817}, d = "cleanupCreatedAppIfNeeded", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler")
    static final class n extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f15360d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f15361e;
        int f;

        n(c r3, d.c.d<? super n> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15361e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15360d = r3;
            this.f |= Integer.MIN_VALUE;
            return c.b(this.f15361e, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {270, 295}, d = "ensureAuth", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler")
    static final class o extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f15365d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f15366e;
        long f;
        long g;
        /* synthetic */ Object h;
        final /* synthetic */ c i;
        int j;

        o(c r3, d.c.d<? super o> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return this.i.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {368}, d = "invokeSuspend", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler$ensureAuth$4")
    static final class p extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.credentials.api.l.a f15368b;

        p(com.obric.aiagent.skill.credentials.api.l.a r3, d.c.d<? super p> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15368b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((p) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new p(this.f15368b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15367a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            c r7 = c.f15302a;
            com.obric.aiagent.skill.credentials.api.l.a r2 = this.f15368b;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15367a = 1;
            if (c.a(r7, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {371}, d = "invokeSuspend", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler$ensureAuth$5")
    static final class q extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISkillCredentialService f15370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.credentials.api.l.a f15371c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15372d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ DispatchContext f15373e;
        final /* synthetic */ long f;
        final /* synthetic */ String g;

        q(ISkillCredentialService r3, com.obric.aiagent.skill.credentials.api.l.a r4, String r5, DispatchContext r6, long r7, String r9, d.c.d<? super q> r10) {
            ISkillCredentialService r8 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15370b = r8;
            this.f15371c = r4;
            this.f15372d = r5;
            this.f15373e = r6;
            this.f = r7;
            this.g = r9;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((q) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new q(this.f15370b, this.f15371c, this.f15372d, this.f15373e, this.f, this.g, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r22) {
            Object r0 = d.c.a.b.a();
            int r3 = this.f15369a;
            if (r3 == 0) goto L8;
            if (r3 != 1) goto L7;
            d.o.a(r22);
            Object r4 = r22;
        L11:
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
            AtomicCapabilitySdk.INSTANCE.updateIntentResult(r5.a(), this.f15373e, true);     // Catch: Throwable -> L15
            ILogDepend.Companion.i(c.TAG, "ensureAuth final result updated session=" + this.f15371c.a().a() + " ret=" + r5.a().getRet());     // Catch: Throwable -> L15
            c.a(c.f15302a, this.f, r5, this.f15371c, this.g);     // Catch: Throwable -> L15
            return x.f38692a;
        L15:
            th = move-exception;
            ILogDepend.Companion.e(c.TAG, "ensureAuth final result update failed session=" + this.f15371c.a().a(), th);
            c.a(c.f15302a, this.f, r5.a().getRet(), "failure", this.g, this.f15371c.a().c().size(), r5.g(), r5.f(), this.f15371c.a().e().a(), this.f15371c.a().f(), "final_update", "final_update_failed", c.a(c.f15302a, th), true);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r22);
            c r6 = c.f15302a;
            ISkillCredentialService r7 = this.f15370b;
            com.obric.aiagent.skill.credentials.api.l.a r8 = this.f15371c;
            String r9 = this.f15372d;
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15369a = 1;
            r4 = c.a(r6, r7, r8, r9, r10);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {934, 936, 945, 952, 963}, d = "loadStatus-gIAlu-s", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler")
    static final class r extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f15376c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f15377d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f15378e;

        r(c r3, d.c.d<? super r> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15377d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15376c = r3;
            this.f15378e |= Integer.MIN_VALUE;
            Object r2 = c.a(this.f15377d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return d.n.g(r2);
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {DownloadErrorCode.ERROR_SAVE_PATH_CREATE_FAILED}, d = "prepareRuntimeEnvIfAuthorized-gIAlu-s", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler")
    static final class s extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f15379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f15380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f15381c;

        s(c r3, d.c.d<? super s> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15380b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15379a = r3;
            this.f15381c |= Integer.MIN_VALUE;
            Object r2 = c.a(this.f15380b, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            if (r2 != d.c.a.b.a()) goto L6;
            return r2;
        L6:
            return d.n.g(r2);
        }
    }

    /* JADX INFO: compiled from: OfficeLarkCLIIntents.kt */
    @d.c.b.a.f(b = "OfficeLarkCLIIntents.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.office.OfficeLarkCLIIntentHandler$reportLarkCliAuthResult$1$1")
    static final class t extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f15383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f15384c;

        t(JSONObject r3, d.c.d<? super t> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15383b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((t) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            t r0 = new t(this.f15383b, r5);
            r0.f15384c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f15382a != 0) goto L19;
            d.o.a(r3);
            am r4 = (am) ZeusTransformUtils.preCheckCast(this.f15384c, am.class, "com.obric.aiagent.plugin");
            JSONObject r2 = this.f15383b;
            d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L11
            IAppLog r6 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            if (r6 == null) goto L8;
            r6.reportToFlow("obric_omni_lark_cli_auth_result", r2);     // Catch: Throwable -> L11
            x r7 = x.f38692a;     // Catch: Throwable -> L11
        L9:
            Object r8 = d.n.f(r7);     // Catch: Throwable -> L11
        L13:
            Throwable r9 = d.n.c(r8);
            if (r9 == null) goto L17;
            ILogDepend.Companion.w(c.TAG, "report lark cli auth result failed", r9);
        L17:
            return x.f38692a;
        L8:
            r7 = null;
        L11:
            th = move-exception;
            d.n.a r10 = d.n.f38560a;
            r8 = d.n.f(d.o.a(th));
            goto L13
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private c() {
    }

    public static final /* synthetic */ Object a(c r2, ISkillCredentialService r3, com.obric.aiagent.skill.credentials.api.l.a r4, String r5, d.c.d r6) {
        return r2.a((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, ISkillCredentialService r3, d.c.d r4) {
        return r2.a((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, ISkillCredentialService r3, String r4, d.c.d r5) {
        return r2.a((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, com.obric.aiagent.skill.credentials.api.a r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, com.obric.aiagent.skill.credentials.api.l.a r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(c r2, boolean r3, boolean r4, String r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(c r0, Throwable r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ void a(c r0, long r1, int r3, String r4, String r5, int r6, int r7, String r8, String r9, String r10, String r11, String r12, String r13, boolean r14) {
        r0.a(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ void a(c r0, long r1, a r3, com.obric.aiagent.skill.credentials.api.l.a r4, String r5) {
        r0.a(r1, r3, r4, r5);
    }

    public static final /* synthetic */ Object b(c r2, ISkillCredentialService r3, com.obric.aiagent.skill.credentials.api.l.a r4, String r5, d.c.d r6) {
        return r2.b((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f15302a = new c();
        f15303b = new Gson();
        f15304c = new d.o.k("^[A-Za-z0-9:._-]+$");
    }

    public final Object a(String r8, d.c.d<? super IntentResult<Empty>> r9) {
        return a(this, true, false, r8, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final Object a(d.c.d<? super String> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, k.class) == false) goto L7;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r11, k.class, "com.obric.aiagent.plugin");
        if ((r0.f15347c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f15347c -= Integer.MIN_VALUE;
    L8:
        k r6 = r0;
        Object r12 = r6.f15345a;
        Object r1 = d.c.a.b.a();
        int r2 = r6.f15347c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r12);
    L17:
        String r9 = ((IntentResult) ZeusTransformUtils.preCheckCast(r12, IntentResult.class, "com.obric.aiagent.plugin")).getDetails();
        if (r9 != null) goto L21;
        return "";
    L21:
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r12);
        r6.f15347c = 1;
        r12 = a(this, false, false, null, r6, 4, null);
        if (r12 != r1) goto L17;
        return r1;
    L7:
        r0 = new k(this, r11);
        goto L8
    }

    static /* synthetic */ Object a(c r1, boolean r2, boolean r3, String r4, d.c.d r5, int r6, Object r7) {
        d.c.d<? super IntentResult<Empty>> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = true;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        return r1.a(r2, r3, r4, r8);
    }

    private final Object a(boolean r27, boolean r28, String r29, d.c.d<? super IntentResult<Empty>> r30) {
        c r0 = this;
        boolean r1 = r27;
        boolean r2 = r28;
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r30, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, l.class) == false) goto L7;
        l r6 = (l) ZeusTransformUtils.preCheckCast(r4, l.class, "com.obric.aiagent.plugin");
        if ((r6.i & Integer.MIN_VALUE) == 0) goto L7;
        r6.i -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.g;
        Object r7 = d.c.a.b.a();
        int r8 = r6.i;
        if (r8 == 0) goto L16;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L14;
        long r3 = r6.f;
        r2 = r6.f15351d;
        com.obric.aiagent.skill.credentials.api.a r9 = (com.obric.aiagent.skill.credentials.api.a) ZeusTransformUtils.preCheckCast(r6.f15350c, com.obric.aiagent.skill.credentials.api.a.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r6.f15349b, String.class, "com.obric.aiagent.plugin");
        c r11 = (c) ZeusTransformUtils.preCheckCast(r6.f15348a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        Object r12 = ((d.n) ZeusTransformUtils.preCheckCast(r5, d.n.class, "com.obric.aiagent.plugin")).a();
        long r17 = r3;
        String r21 = r10;
    L33:
        Throwable r13 = d.n.c(r12);
        if (r13 != null) goto L36;
        r0 = r11;
        com.obric.aiagent.skill.credentials.api.a r14 = r9;
        long r15 = r17;
        String r16 = r21;
    L41:
        IntentResult<Empty> r18 = r0.a(0, r0.a(r14));
        if (r2 == false) goto L44;
        c r19 = f15302a;
        a(r19, r15, r18.getRet(), "success", r16, r19.a(r14).e(), null, null, null, 224, null);
    L44:
        return r18;
    L36:
        ILogDepend.Companion.e(TAG, "checkLogin prepare runtime env failed", r13);
        c r20 = f15302a;
        IntentResult<Empty> r22 = r20.a(-2002, d.f15317a.a(r13));
        if (r2 == false) goto L39;
        r20.a(r17, r22.getRet(), "failure", r21, r20.a(r9).e(), "prepare_runtime_env", r20.a(r13), r20.b(r13));
    L39:
        return r22;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r23 = r6.f;
        r2 = r6.f15352e;
        boolean r24 = r6.f15351d;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r6.f15349b, String.class, "com.obric.aiagent.plugin");
        c r25 = (c) ZeusTransformUtils.preCheckCast(r6.f15348a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        long r111 = r23;
        r0 = r25;
        Object r26 = ((d.n) ZeusTransformUtils.preCheckCast(r5, d.n.class, "com.obric.aiagent.plugin")).a();
        r1 = r24;
        String r31 = r110;
    L25:
        Throwable r32 = d.n.c(r26);
        if (r32 != null) goto L45;
        r14 = (com.obric.aiagent.skill.credentials.api.a) ZeusTransformUtils.preCheckCast(r26, com.obric.aiagent.skill.credentials.api.a.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "checkLogin complete " + a(r0, r14, null, null, 3, null));
        if (r1 == false) goto L40;
        r6.f15348a = r0;
        r6.f15349b = r31;
        r6.f15350c = r14;
        r6.f15351d = r2;
        r6.f = r111;
        r6.i = 2;
        Object r33 = r0.a(r14, r6);
        if (r33 != r7) goto L32;
        return r7;
    L32:
        r9 = r14;
        r21 = r31;
        r17 = r111;
        r11 = r0;
        r12 = r33;
        goto L33
    L40:
        r16 = r31;
        r15 = r111;
        goto L41
    L45:
        ILogDepend.Companion.e(TAG, "checkLogin load status failed", r32);
        c r112 = f15302a;
        IntentResult<Empty> r34 = r112.a(-2002, d.f15317a.a(r32));
        if (r2 == false) goto L48;
        a(r112, r111, r34.getRet(), "failure", r31, null, "check_status", r112.a(r32), r112.b(r32), 16, null);
    L48:
        return r34;
    L16:
        d.o.a(r5);
        r111 = SystemClock.elapsedRealtime();
        ILogDepend.Companion.i(TAG, "checkLogin start prepareRuntimeEnv=" + r1);
        ISkillCredentialService r35 = ISkillCredentialService.Companion.a();
        if (r35 != null) goto L22;
        IntentResult<Empty> r36 = r0.a(-2002, d.a.a(d.f15317a, "credential_service_unavailable", "ISkillCredentialService is unavailable.", null, 4, null));
        ILogDepend.Companion.e(TAG, "checkLogin failed: credential service unavailable");
        if (r2 == false) goto L21;
        a(f15302a, r111, r36.getRet(), "failure", r29, null, "get_service", "credential_service_unavailable", null, 144, null);
    L21:
        return r36;
    L22:
        r6.f15348a = r0;
        r31 = r29;
        r6.f15349b = r31;
        r6.f15351d = r1;
        r6.f15352e = r2;
        r6.f = r111;
        r6.i = 1;
        r26 = r0.a(r35, r6);
        if (r26 != r7) goto L25;
        return r7;
    L7:
        r6 = new l(r0, r4);
        goto L8
    }

    public final Object a(OfficeLarkCLIEnsureAuthParams r42, DispatchContext r43, d.c.d<? super IntentResult<Empty>> r44) {
        c r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r44, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, o.class) == false) goto L7;
        o r4 = (o) ZeusTransformUtils.preCheckCast(r2, o.class, "com.obric.aiagent.plugin");
        if ((r4.j & Integer.MIN_VALUE) == 0) goto L7;
        r4.j -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.h;
        Object r5 = d.c.a.b.a();
        int r6 = r4.j;
        if (r6 == 0) goto L17;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        long r7 = r4.f;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.f15366e, String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.credentials.api.a r8 = (com.obric.aiagent.skill.credentials.api.a) ZeusTransformUtils.preCheckCast(r4.f15365d, com.obric.aiagent.skill.credentials.api.a.class, "com.obric.aiagent.plugin");
        C0314c r9 = (C0314c) ZeusTransformUtils.preCheckCast(r4.f15364c, C0314c.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4.f15363b, String.class, "com.obric.aiagent.plugin");
        c r11 = (c) ZeusTransformUtils.preCheckCast(r4.f15362a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        Object r12 = ((d.n) ZeusTransformUtils.preCheckCast(r3, d.n.class, "com.obric.aiagent.plugin")).a();
        String r27 = r1;
        long r20 = r7;
        String r24 = r10;
    L47:
        Throwable r13 = d.n.c(r12);
        if (r13 != null) goto L51;
        IntentResult<Empty> r14 = r11.a(0, b.a.a(b.f15310a, com.obric.aiagent.skill.credentials.api.l.e.f18991a.a(), r11.a(r8), d.a.p.b(), null, 8, null));
        a(f15302a, r20, r14.getRet(), "success", r24, r9.b().size(), 0, r27, com.obric.aiagent.skill.credentials.api.l.e.f18991a.a(), null, null, null, null, false, 3872, null);
        return r14;
    L51:
        ILogDepend.Companion.e(TAG, "ensureAuth prepare runtime env failed", r13);
        c r15 = f15302a;
        IntentResult<Empty> r16 = r15.a(-2002, d.f15317a.a(r13));
        a(r15, r20, r16.getRet(), "failure", r24, r9.b().size(), 0, r27, com.obric.aiagent.skill.credentials.api.l.e.f18991a.a(), null, "prepare_runtime_env", r15.a(r13), r15.b(r13), false, 288, null);
        return r16;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r17 = r4.g;
        long r18 = r4.f;
        ISkillCredentialService r19 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r4.f15366e, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        C0314c r21 = (C0314c) ZeusTransformUtils.preCheckCast(r4.f15365d, C0314c.class, "com.obric.aiagent.plugin");
        String r22 = (String) ZeusTransformUtils.preCheckCast(r4.f15364c, String.class, "com.obric.aiagent.plugin");
        DispatchContext r23 = (DispatchContext) ZeusTransformUtils.preCheckCast(r4.f15363b, DispatchContext.class, "com.obric.aiagent.plugin");
        c r25 = (c) ZeusTransformUtils.preCheckCast(r4.f15362a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        Object r26 = ((d.n) ZeusTransformUtils.preCheckCast(r3, d.n.class, "com.obric.aiagent.plugin")).a();
        ISkillCredentialService r28 = r19;
        r0 = r25;
        String r29 = r22;
        DispatchContext r210 = r23;
        long r30 = r18;
    L16:
        r9 = r21;
        Throwable r31 = d.n.c(r26);
        if (r31 != null) goto L67;
        com.obric.aiagent.skill.credentials.api.a r32 = (com.obric.aiagent.skill.credentials.api.a) ZeusTransformUtils.preCheckCast(r26, com.obric.aiagent.skill.credentials.api.a.class, "com.obric.aiagent.plugin");
        List<String> r110 = r0.a(r32, r9.b());
        String r33 = r0.a(r32).e();
        ILogDepend.Companion.i(TAG, "ensureAuth status " + r0.a(r32, d.c.b.a.b.a(r9.b().size()), r110));
        if (r32.a() != null) goto L38;
        boolean r34 = true;
    L40:
        if (r32.b() == false) goto L54;
        if (r110.isEmpty() == false) goto L54;
        ILogDepend.Companion.i(TAG, "ensureAuth sync authorized scopeCount=" + r9.b().size());
        r4.f15362a = r0;
        r4.f15363b = r29;
        r4.f15364c = r9;
        r4.f15365d = r32;
        r4.f15366e = r33;
        r4.f = r30;
        r4.j = 2;
        Object r35 = r0.a(r32, r4);
        if (r35 != r5) goto L46;
        return r5;
    L46:
        r24 = r29;
        r8 = r32;
        r12 = r35;
        r27 = r33;
        r20 = r30;
        r11 = r0;
    L54:
        if (r32.b() == false) goto L56;
        com.obric.aiagent.skill.credentials.api.l.e r36 = com.obric.aiagent.skill.credentials.api.l.e.f18993c;
    L57:
        com.obric.aiagent.skill.credentials.api.l.e r37 = r36;
        if (r32.b() == false) goto L60;
        String r38 = "insufficient_permission";
    L61:
        long r211 = r17;
        com.obric.aiagent.skill.credentials.api.l.a r39 = com.obric.aiagent.skill.credentials.api.l.f18971a.a(new com.obric.aiagent.skill.credentials.api.l.b(null, r211, r9.a(), r9.b(), r110, r37, r38, r34, 1, null));
        ILogDepend.Companion.i(TAG, "ensureAuth register flow session=" + r39.a().a() + " authType=" + r39.a().e().a() + " authorizeReason=" + r39.a().f() + " requiresAppSetup=" + r39.a().g() + " scopeCount=" + r39.a().c().size() + " missingScopes=" + r39.a().d());
        if (com.obric.aiagent.skill.credentials.api.l.f18971a.a(r39.a().a()) == false) goto L64;
        r0.a(r17, r39.a(), r210.getExt());
    L65:
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new p(r39, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new q(r28, r39, r33, r210, r30, r29, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        IntentResult<Empty> r40 = r0.a(0, b.f15310a.a(r39.a()));
        r40.setFinal(false);
        return r40;
    L64:
        ILogDepend.Companion.i(TAG, "reuse active lark authorize flow session=" + r39.a().a());
        goto L65
    L60:
        r38 = "not_login";
        goto L61
    L56:
        r36 = com.obric.aiagent.skill.credentials.api.l.e.f18992b;
        goto L57
    L38:
        r34 = false;
        goto L40
    L67:
        ILogDepend.Companion.e(TAG, "ensureAuth load status failed", r31);
        c r41 = f15302a;
        IntentResult<Empty> r45 = r41.a(-2002, d.f15317a.a(r31));
        a(r41, r30, r45.getRet(), "failure", r29, r9.b().size(), 0, null, null, null, "check_status", r41.a(r31), r41.b(r31), false, 480, null);
        return r45;
    L17:
        d.o.a(r3);
        long r46 = SystemClock.elapsedRealtime();
        String[] r47 = r42.getScopes();
        if (r47 == null) goto L20;
        int r48 = r47.length;
    L21:
        String r49 = com.obric.agent.office.d.a(r43.getExt());
        ILogDepend.Companion.i(TAG, "ensureAuth start questionId=" + r43.getQuestionId() + " scopeCount=" + r48);
        Long r50 = r43.getQuestionId();
        if (r50 == null) goto L74;
        r17 = r50.longValue();
        Object r51 = a(r42);
        Throwable r111 = d.n.c(r51);
        if (r111 != null) goto L69;
        r21 = (C0314c) ZeusTransformUtils.preCheckCast(r51, C0314c.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r52 = ISkillCredentialService.Companion.a();
        if (r52 != null) goto L29;
        IntentResult<Empty> r53 = r0.a(-2002, d.a.a(d.f15317a, "credential_service_unavailable", "ISkillCredentialService is unavailable.", null, 4, null));
        ILogDepend.Companion.e(TAG, "ensureAuth failed: credential service unavailable");
        a(f15302a, r46, r53.getRet(), "failure", r49, r21.b().size(), 0, null, null, null, "get_service", "credential_service_unavailable", null, false, 2528, null);
        return r53;
    L29:
        r4.f15362a = r0;
        r4.f15363b = r43;
        r4.f15364c = r49;
        r4.f15365d = r21;
        r4.f15366e = r52;
        r4.f = r46;
        r4.g = r17;
        r4.j = 1;
        Object r112 = r0.a(r52, r4);
        if (r112 != r5) goto L32;
        return r5;
    L32:
        r28 = r52;
        r210 = r43;
        r30 = r46;
        r29 = r49;
        r26 = r112;
        goto L16
    L69:
        ILogDepend.Companion.e(TAG, "ensureAuth invalid scopes: " + r111.getMessage());
        c r54 = f15302a;
        d.a r113 = d.f15317a;
        String r55 = r111.getMessage();
        if (r55 != null) goto L72;
        r55 = "";
    L72:
        IntentResult<Empty> r56 = r54.a(103, d.a.a(r113, "invalid_scopes", r55, null, 4, null));
        a(r54, r46, r56.getRet(), "failure", r49, r48, 0, null, null, null, "params", "invalid_scopes", null, false, 2528, null);
        return r56;
    L74:
        IntentResult<Empty> r57 = r0.a(-2004, d.a.a(d.f15317a, "missing_question_id", "questionId is missing.", null, 4, null));
        ILogDepend.Companion.e(TAG, "ensureAuth failed: questionId is missing");
        a(f15302a, r46, r57.getRet(), "failure", r49, r48, 0, null, null, null, "params", "missing_question_id", null, false, 2528, null);
        return r57;
    L20:
        r48 = 0;
    L7:
        r4 = new o(r0, r2);
        goto L8
    }

    private final Object a(com.obric.aiagent.skill.credentials.api.l.a r13, d.c.d<? super x> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, i.class) == false) goto L7;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r15, i.class, "com.obric.aiagent.plugin");
        if ((r0.f15340d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f15340d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f15338b;
        Object r16 = d.c.a.b.a();
        int r2 = r0.f15340d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r13 = (com.obric.aiagent.skill.credentials.api.l.a) ZeusTransformUtils.preCheckCast(r0.f15337a, com.obric.aiagent.skill.credentials.api.l.a.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
    L17:
        Boolean r17 = (Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r17, d.c.b.a.b.a(true)) == false) goto L21;
        ILogDepend.Companion.i(TAG, "ensureAuth auth flow entered session=" + r13.a().a());
    L26:
        return x.f38692a;
    L21:
        if (d.h.b.o.a(r17, d.c.b.a.b.a(false)) == false) goto L23;
        ILogDepend.Companion.i(TAG, "ensureAuth auth flow entry wait skipped because flow already completed session=" + r13.a().a());
        goto L26
    L23:
        if (r17 != null) goto L28;
        ILogDepend.Companion.w(TAG, "ensureAuth auth flow enter timeout session=" + r13.a().a() + " completed=" + com.obric.aiagent.skill.credentials.api.l.f18971a.a(r13.a().a(), new com.obric.aiagent.skill.credentials.api.l.c(com.obric.aiagent.skill.credentials.api.l.d.f18988c, "Authorization was not opened in time.", "auth_flow_enter_timeout", null, 8, null)));
        goto L26
    L28:
        throw new d.k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r12);
        ILogDepend.Companion.i(TAG, "ensureAuth await auth flow entry session=" + r13.a().a() + " timeoutMs=300000");
        d.h.a.m r18 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r13, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.f15337a = r13;
        r0.f15340d = 1;
        r12 = dg.b(300000, r18, r0);
        if (r12 != r16) goto L17;
        return r16;
    L7:
        r0 = new i(this, r15);
        goto L8
    }

    private final Object a(ISkillCredentialService r26, com.obric.aiagent.skill.credentials.api.l.a r27, String r28, d.c.d<? super a> r29) {
        c r0 = this;
        com.obric.aiagent.skill.credentials.api.l.a r1 = r27;
        ISkillCredentialService r3 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r26, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r29, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, g.class) == false) goto L7;
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if ((r6.h & Integer.MIN_VALUE) == 0) goto L7;
        r6.h -= Integer.MIN_VALUE;
    L8:
        Object r7 = r6.f;
        Object r8 = d.c.a.b.a();
        String r10 = " errorSubtype=";
        switch(r6.h) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        com.obric.aiagent.skill.credentials.api.l.c r2 = (com.obric.aiagent.skill.credentials.api.l.c) ZeusTransformUtils.preCheckCast(r6.f15333d, com.obric.aiagent.skill.credentials.api.l.c.class, "com.obric.aiagent.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r6.f15332c, String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.credentials.api.l.a r9 = (com.obric.aiagent.skill.credentials.api.l.a) ZeusTransformUtils.preCheckCast(r6.f15331b, com.obric.aiagent.skill.credentials.api.l.a.class, "com.obric.aiagent.plugin");
        c r11 = (c) ZeusTransformUtils.preCheckCast(r6.f15330a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        String r12 = r4;
    L70:
        return new a(r11.a(4, b.a.a(b.f15310a, "expired", r2.b(), r9.a().e().a(), r9.a().a(), r9.a().d(), null, null, 96, null)), "timeout", "auth_wait", null, null, r12, r9.a().d().size());
    L13:
        com.obric.aiagent.skill.credentials.api.l.c r13 = (com.obric.aiagent.skill.credentials.api.l.c) ZeusTransformUtils.preCheckCast(r6.f15333d, com.obric.aiagent.skill.credentials.api.l.c.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r6.f15332c, String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.credentials.api.l.a r15 = (com.obric.aiagent.skill.credentials.api.l.a) ZeusTransformUtils.preCheckCast(r6.f15331b, com.obric.aiagent.skill.credentials.api.l.a.class, "com.obric.aiagent.plugin");
        c r16 = (c) ZeusTransformUtils.preCheckCast(r6.f15330a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        String r22 = r14;
        r10 = " errorSubtype=";
    L43:
        ILogDepend.Companion.e(TAG, "ensureAuth failed session=" + r15.a().a() + " errorType=" + r13.c() + r10 + r13.d() + " message=" + r13.b());
        return new a(r16.a(-2002, b.f15310a.a("failed", r13.b(), r15.a().e().a(), r15.a().a(), r15.a().d(), r13.c(), r13.d())), r16.a(r13), r16.a(r13.c()), r13.c(), r13.d(), r22, r15.a().d().size());
    L14:
        com.obric.aiagent.skill.credentials.api.l.c r17 = (com.obric.aiagent.skill.credentials.api.l.c) ZeusTransformUtils.preCheckCast(r6.f15333d, com.obric.aiagent.skill.credentials.api.l.c.class, "com.obric.aiagent.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r6.f15332c, String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.credentials.api.l.a r19 = (com.obric.aiagent.skill.credentials.api.l.a) ZeusTransformUtils.preCheckCast(r6.f15331b, com.obric.aiagent.skill.credentials.api.l.a.class, "com.obric.aiagent.plugin");
        c r20 = (c) ZeusTransformUtils.preCheckCast(r6.f15330a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        String r21 = r18;
    L72:
        return new a(r20.a(-2002, b.a.a(b.f15310a, "canceled", r17.b(), r19.a().e().a(), r19.a().a(), r19.a().d(), null, null, 96, null)), "canceled", "user_cancel", null, null, r21, r19.a().d().size());
    L15:
        String r23 = (String) ZeusTransformUtils.preCheckCast(r6.f15334e, String.class, "com.obric.aiagent.plugin");
        List<String> r24 = (List) ZeusTransformUtils.preCheckCast(r6.f15333d, List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.credentials.api.a r25 = (com.obric.aiagent.skill.credentials.api.a) ZeusTransformUtils.preCheckCast(r6.f15332c, com.obric.aiagent.skill.credentials.api.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.credentials.api.l.a r30 = (com.obric.aiagent.skill.credentials.api.l.a) ZeusTransformUtils.preCheckCast(r6.f15331b, com.obric.aiagent.skill.credentials.api.l.a.class, "com.obric.aiagent.plugin");
        c r31 = (c) ZeusTransformUtils.preCheckCast(r6.f15330a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        Object r32 = ((d.n) ZeusTransformUtils.preCheckCast(r7, d.n.class, "com.obric.aiagent.plugin")).a();
    L62:
        Throwable r33 = d.n.c(r32);
        if (r33 == null) goto L65;
        ILogDepend.Companion.e(TAG, "ensureAuth prepare runtime env after auth failed session=" + r30.a().a(), r33);
        c r34 = f15302a;
        return new a(r34.a(-2002, d.f15317a.a(r33)), "failure", "prepare_runtime_env", r34.a(r33), r34.b(r33), r34.a(r25).e(), r24.size());
    L65:
        return new a(r31.a(0, b.f15310a.a(r30.a().e().a(), r31.a(r25), r24, r23)), "success", null, null, null, r31.a(r25).e(), r24.size());
    L16:
        String r35 = (String) ZeusTransformUtils.preCheckCast(r6.f15332c, String.class, "com.obric.aiagent.plugin");
        r1 = (com.obric.aiagent.skill.credentials.api.l.a) ZeusTransformUtils.preCheckCast(r6.f15331b, com.obric.aiagent.skill.credentials.api.l.a.class, "com.obric.aiagent.plugin");
        r31 = (c) ZeusTransformUtils.preCheckCast(r6.f15330a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        Object r36 = ((d.n) ZeusTransformUtils.preCheckCast(r7, d.n.class, "com.obric.aiagent.plugin")).a();
        String r210 = r35;
    L53:
        Throwable r37 = d.n.c(r36);
        if (r37 != null) goto L68;
        r25 = (com.obric.aiagent.skill.credentials.api.a) ZeusTransformUtils.preCheckCast(r36, com.obric.aiagent.skill.credentials.api.a.class, "com.obric.aiagent.plugin");
        List<String> r38 = r31.a(r25, r1.a().c());
        ILogDepend.Companion.i(TAG, "ensureAuth reload status after auth session=" + r1.a().a() + ' ' + r31.a(r25, d.c.b.a.b.a(r1.a().c().size()), r38));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r38, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L58;
        ILogDepend.Companion.w(TAG, "ensureAuth completed but status still reports missing scopes session=" + r1.a().a() + " missingScopes=" + r38 + " loggedIn=" + r25.b());
    L58:
        String r39 = r31.a(r1.a().e(), r38);
        ILogDepend.Companion.i(TAG, "ensureAuth completed authorized session=" + r1.a().a());
        r6.f15330a = r31;
        r6.f15331b = r1;
        r6.f15332c = r25;
        r6.f15333d = r38;
        r6.f15334e = r39;
        r6.h = 3;
        Object r40 = r31.a(r25, r6);
        if (r40 != r8) goto L61;
        return r8;
    L61:
        r30 = r1;
        r24 = r38;
        r23 = r39;
        r32 = r40;
        goto L62
    L68:
        ILogDepend.Companion.e(TAG, "ensureAuth reload status after auth failed session=" + r1.a().a(), r37);
        c r41 = f15302a;
        return new a(r41.a(-2002, d.f15317a.a(r37)), "failure", "check_status", r41.a(r37), r41.b(r37), r210, r1.a().d().size());
    L17:
        String r42 = (String) ZeusTransformUtils.preCheckCast(r6.f15333d, String.class, "com.obric.aiagent.plugin");
        r1 = (com.obric.aiagent.skill.credentials.api.l.a) ZeusTransformUtils.preCheckCast(r6.f15332c, com.obric.aiagent.skill.credentials.api.l.a.class, "com.obric.aiagent.plugin");
        r3 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r6.f15331b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        c r43 = (c) ZeusTransformUtils.preCheckCast(r6.f15330a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        String r110 = r42;
        r0 = r43;
    L21:
        com.obric.aiagent.skill.credentials.api.l.c r44 = (com.obric.aiagent.skill.credentials.api.l.c) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.credentials.api.l.c.class, "com.obric.aiagent.plugin");
        if (r44 != null) goto L24;
        c r45 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "ensureAuth flow timeout session=" + r1.a().a() + " expired=" + com.obric.aiagent.skill.credentials.api.l.f18971a.c(r1.a().a()));
        com.obric.aiagent.skill.credentials.api.l.c r46 = new com.obric.aiagent.skill.credentials.api.l.c(com.obric.aiagent.skill.credentials.api.l.d.f18989d, "Authorization expired.", null, null, 12, null);
    L25:
        ILogDepend.Companion.i(TAG, "ensureAuth flow result session=" + r1.a().a() + " status=" + r46.a().a() + " errorType=" + r46.c() + r10 + r46.d());
        int r47 = f.f15329a[r46.a().ordinal()];
        if (r47 == 1) goto L49;
        if (r47 != 2) goto L29;
        ILogDepend.Companion.i(TAG, "ensureAuth canceled session=" + r1.a().a());
        r6.f15330a = r0;
        r6.f15331b = r1;
        r6.f15332c = r110;
        r6.f15333d = r46;
        r6.h = 4;
        if (r0.b(r3, r1, "canceled", r6) != r8) goto L47;
        return r8;
    L47:
        r19 = r1;
        r21 = r110;
        com.obric.aiagent.skill.credentials.api.l.c r211 = r46;
        r20 = r0;
        r17 = r211;
        goto L72
    L29:
        if (r47 != 3) goto L31;
        r6.f15330a = r0;
        r6.f15331b = r1;
        r6.f15332c = r110;
        r6.f15333d = r46;
        r6.h = 5;
        if (r0.b(r3, r1, "failed", r6) != r8) goto L42;
        return r8;
    L42:
        r15 = r1;
        r22 = r110;
        com.obric.aiagent.skill.credentials.api.l.c r212 = r46;
        r16 = r0;
        r13 = r212;
        goto L43
    L31:
        if (r47 != 4) goto L38;
        ILogDepend.Companion.w(TAG, "ensureAuth expired session=" + r1.a().a());
        r6.f15330a = r0;
        r6.f15331b = r1;
        r6.f15332c = r110;
        r6.f15333d = r46;
        r6.h = 6;
        if (r0.b(r3, r1, "expired", r6) != r8) goto L35;
        return r8;
    L35:
        r9 = r1;
        r12 = r110;
        com.obric.aiagent.skill.credentials.api.l.c r213 = r46;
        r11 = r0;
        r2 = r213;
        goto L70
    L38:
        throw new d.k();
    L49:
        r6.f15330a = r0;
        r6.f15331b = r1;
        r6.f15332c = r110;
        r6.f15333d = null;
        r6.h = 2;
        r36 = r0.a(r3, r6);
        if (r36 != r8) goto L52;
        return r8;
    L52:
        r31 = r0;
        r210 = r110;
        goto L53
    L24:
        r46 = r44;
        goto L25
    L18:
        d.o.a(r7);
        ILogDepend.Companion.i(TAG, "ensureAuth await flow session=" + r27.a().a() + " timeoutMs=300000");
        d.h.a.m r48 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r1, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r6.f15330a = r0;
        r6.f15331b = r3;
        r6.f15332c = r1;
        r110 = r28;
        r6.f15333d = r110;
        r6.h = 1;
        r7 = dg.b(300000, r48, r6);
        if (r7 != r8) goto L21;
        return r8;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r6 = new g(r0, r5);
        goto L8
    }

    static /* synthetic */ void a(c r13, long r14, int r16, String r17, String r18, String r19, String r20, String r21, String r22, int r23, Object r24) {
        if ((r23 & 8) == 0) goto L5;
        String r8 = null;
    L7:
        if ((r23 & 16) == 0) goto L9;
        String r9 = null;
    L11:
        if ((r23 & 32) == 0) goto L13;
        String r10 = null;
    L15:
        if ((r23 & 64) == 0) goto L17;
        String r11 = null;
    L19:
        if ((r23 & 128) == 0) goto L21;
        String r12 = null;
    L22:
        r13.a(r14, r16, r17, r8, r9, r10, r11, r12);
        return;
    L21:
        r12 = r22;
        goto L22
    L17:
        r11 = r21;
        goto L19
    L13:
        r10 = r20;
        goto L15
    L9:
        r9 = r19;
        goto L11
    L5:
        r8 = r18;
        goto L7
    }

    private final void a(long r4, int r6, String r7, String r8, String r9, String r10, String r11, String r12) {
        JSONObject r0 = new JSONObject();
        r0.put("tool_name", "Office_LarkCLICheckLogin");
        r0.put("result", r7);
        r0.put("duration_ms", SystemClock.elapsedRealtime() - r4);
        r0.put("error_code", r6);
        r0.put("requested_scope_count", 0);
        r0.put("missing_scope_count", 0);
        r0.put("is_async", false);
        c r5 = f15302a;
        r5.a(r0, "omni_task_id", r8);
        r5.a(r0, "token_status", r9);
        r5.a(r0, "failure_stage", r10);
        r5.a(r0, "error_type", r11);
        r5.a(r0, "error_subtype", r12);
        a(r0);
    }

    private final void a(long r17, a r19, com.obric.aiagent.skill.credentials.api.l.a r20, String r21) {
        a(r17, r19.a().getRet(), r19.b(), r21, r20.a().c().size(), r19.g(), r19.f(), r20.a().e().a(), r20.a().f(), r19.c(), r19.d(), r19.e(), true);
    }

    static /* synthetic */ void a(c r18, long r19, int r21, String r22, String r23, int r24, int r25, String r26, String r27, String r28, String r29, String r30, String r31, boolean r32, int r33, Object r34) {
        if ((r33 & 8) == 0) goto L5;
        String r8 = null;
    L7:
        if ((r33 & 32) == 0) goto L9;
        int r10 = 0;
    L11:
        if ((r33 & 64) == 0) goto L13;
        String r11 = null;
    L15:
        if ((r33 & 128) == 0) goto L17;
        String r12 = null;
    L19:
        if ((r33 & 256) == 0) goto L21;
        String r13 = null;
    L23:
        if ((r33 & 512) == 0) goto L25;
        String r14 = null;
    L27:
        if ((r33 & 1024) == 0) goto L29;
        String r15 = null;
    L31:
        if ((r33 & 2048) == 0) goto L33;
        String r16 = null;
    L34:
        r18.a(r19, r21, r22, r8, r24, r10, r11, r12, r13, r14, r15, r16, r32);
        return;
    L33:
        r16 = r31;
        goto L34
    L29:
        r15 = r30;
        goto L31
    L25:
        r14 = r29;
        goto L27
    L21:
        r13 = r28;
        goto L23
    L17:
        r12 = r27;
        goto L19
    L13:
        r11 = r26;
        goto L15
    L9:
        r10 = r25;
        goto L11
    L5:
        r8 = r23;
        goto L7
    }

    private final void a(long r5, int r7, String r8, String r9, int r10, int r11, String r12, String r13, String r14, String r15, String r16, String r17, boolean r18) {
        JSONObject r0 = new JSONObject();
        r0.put("tool_name", "Office_LarkCLIEnsureAuth");
        r0.put("result", r8);
        r0.put("duration_ms", SystemClock.elapsedRealtime() - r5);
        r0.put("error_code", r7);
        r0.put("requested_scope_count", r10);
        r0.put("missing_scope_count", r11);
        r0.put("is_async", r18);
        c r1 = f15302a;
        r1.a(r0, "omni_task_id", r9);
        r1.a(r0, "token_status", r12);
        r1.a(r0, "auth_type", r13);
        r1.a(r0, "authorize_reason", r14);
        r1.a(r0, "failure_stage", r15);
        r1.a(r0, "error_type", r16);
        r1.a(r0, "error_subtype", r17);
        a(r0);
    }

    private final void a(JSONObject r8) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        c r7 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r9 = d.n.f(kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new t(r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null));     // Catch: Throwable -> L5
    L7:
        Throwable r10 = d.n.c(r9);
        if (r10 == null) goto L13;
        ILogDepend.Companion.w(TAG, "schedule lark cli auth result report failed", r10);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L7
    }

    private final String a(Throwable r2) {
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.credentials.api.e.class) == false) goto L5;
        com.obric.aiagent.skill.credentials.api.e r1 = (com.obric.aiagent.skill.credentials.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.credentials.api.e.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L11;
        com.obric.aiagent.skill.credentials.api.h r3 = r1.a();
        if (r3 == null) goto L11;
        String r4 = r3.getType();
        if (r4 == null) goto L11;
        return r4;
    L11:
        String r5 = r2.getClass().getSimpleName();
        d.h.b.o.c(r5, "getSimpleName(...)");
        return r5;
    L5:
        r1 = null;
        goto L6
    }

    private final String b(Throwable r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.credentials.api.e.class) == false) goto L5;
        com.obric.aiagent.skill.credentials.api.e r2 = (com.obric.aiagent.skill.credentials.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.credentials.api.e.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 == null) goto L11;
        com.obric.aiagent.skill.credentials.api.h r4 = r2.a();
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4.c();
    L11:
        return null;
    L5:
        r2 = null;
        goto L6
    }

    private final String a(String r1) {
        if (r1 != null) goto L4;
        return SensitiveType.UNKNOWN;
    L4:
        switch(r1.hashCode()) {
            case -1599178805: goto L28;
            case -1250198174: goto L24;
            case -52378208: goto L20;
            case 832893386: goto L16;
            case 1168080673: goto L13;
            case 1623441149: goto L10;
            case 1635595488: goto L7;
            default: goto L31;
        };
    L31:
        return "credential_flow";
    L7:
        if (r1.equals("auth_activity_destroyed") == false) goto L31;
    L30:
        return "auth_activity";
    L10:
        if (r1.equals("takeover_timeout") == false) goto L31;
    L26:
        return "takeover_notify";
    L13:
        if (r1.equals("takeover_failed") == true) goto L26;
    L16:
        if (r1.equals("auth_flow_replaced") == false) goto L31;
        return "auth_wait";
    L20:
        if (r1.equals("auth_flow_enter_timeout") == false) goto L31;
        return "auth_activity_enter";
    L24:
        if (r1.equals("takeover_service_unavailable") == true) goto L26;
    L28:
        if (r1.equals("auth_activity_detached") == true) goto L30;
        goto L30
    }

    private final String a(com.obric.aiagent.skill.credentials.api.l.c r5) {
        String r4 = r5.c();
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == true) goto L11;
        return "failure";
    L11:
        return "timeout";
    L5:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("timeout", CharSequence.class, "com.obric.aiagent.plugin"), true) != true) goto L7;
        r0 = true;
        goto L7
    }

    private final void a(JSONObject r2, String r3, String r4) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L12;
        r2.put(r3, r4);
        return;
    L12:
        return;
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r5 = false;
        goto L9
    }

    private final Object b(ISkillCredentialService r8, com.obric.aiagent.skill.credentials.api.l.a r9, String r10, d.c.d<? super x> r11) {
        ISkillCredentialService r12 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r8, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, n.class) == false) goto L7;
        n r0 = (n) ZeusTransformUtils.preCheckCast(r13, n.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f15360d;
        Object r14 = d.c.a.b.a();
        int r2 = r0.f;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r0.f15358b, String.class, "com.obric.aiagent.plugin");
        r9 = (com.obric.aiagent.skill.credentials.api.l.a) ZeusTransformUtils.preCheckCast(r0.f15357a, com.obric.aiagent.skill.credentials.api.l.a.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        Object r16 = ((d.n) ZeusTransformUtils.preCheckCast(r7, d.n.class, "com.obric.aiagent.plugin")).a();
    L33:
        Throwable r17 = d.n.c(r16);
        if (r17 != null) goto L41;
        com.obric.aiagent.skill.credentials.api.h r18 = (com.obric.aiagent.skill.credentials.api.h) ZeusTransformUtils.preCheckCast(r16, com.obric.aiagent.skill.credentials.api.h.class, "com.obric.aiagent.plugin");
        if (r18.a() == false) goto L38;
        ILogDepend.Companion.i(TAG, "ensureAuth cleanup deleted configured app session=" + r9.a().a() + " terminalStatus=" + r15);
    L40:
        return x.f38692a;
    L38:
        ILogDepend.Companion.w(TAG, "ensureAuth cleanup delete configured app rejected session=" + r9.a().a() + " terminalStatus=" + r15 + " code=" + r18.b() + " subtype=" + r18.c());
        goto L40
    L41:
        ILogDepend.Companion.e(TAG, "ensureAuth cleanup delete configured app failed session=" + r9.a().a() + " terminalStatus=" + r15, r17);
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (String) ZeusTransformUtils.preCheckCast(r0.f15359c, String.class, "com.obric.aiagent.plugin");
        r9 = (com.obric.aiagent.skill.credentials.api.l.a) ZeusTransformUtils.preCheckCast(r0.f15358b, com.obric.aiagent.skill.credentials.api.l.a.class, "com.obric.aiagent.plugin");
        r12 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r0.f15357a, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        Object r19 = ((d.n) ZeusTransformUtils.preCheckCast(r7, d.n.class, "com.obric.aiagent.plugin")).a();
    L23:
        Throwable r3 = d.n.c(r19);
        if (r3 == null) goto L26;
        ILogDepend.Companion.e(TAG, "ensureAuth cleanup app check failed session=" + r9.a().a() + " terminalStatus=" + r10, r3);
        return x.f38692a;
    L26:
        if (((com.obric.aiagent.skill.credentials.api.b) ZeusTransformUtils.preCheckCast(r19, com.obric.aiagent.skill.credentials.api.b.class, "com.obric.aiagent.plugin")) != null) goto L29;
        ILogDepend.Companion.i(TAG, "ensureAuth cleanup skipped no configured app session=" + r9.a().a() + " terminalStatus=" + r10);
        return x.f38692a;
    L29:
        ISkillCredentialService.b r20 = r12.getApps();
        com.obric.aiagent.skill.credentials.api.f r21 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        r0.f15357a = r9;
        r0.f15358b = r10;
        r0.f15359c = null;
        r0.f = 2;
        r16 = r20.c(r21, r0);
        if (r16 != r14) goto L32;
        return r14;
    L32:
        r15 = r10;
        goto L33
    L16:
        d.o.a(r7);
        if (r9.a().g() == false) goto L19;
        ISkillCredentialService.b r22 = r12.getApps();
        com.obric.aiagent.skill.credentials.api.f r4 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        r0.f15357a = r12;
        r0.f15358b = r9;
        r0.f15359c = r10;
        r0.f = 1;
        r19 = r22.a(r4, r0);
        if (r19 != r14) goto L23;
        return r14;
    L19:
        return x.f38692a;
    L7:
        r0 = new n(this, r13);
        goto L8
    }

    private final void a(long r12, final com.obric.aiagent.skill.credentials.api.l.b r14, Map<String, String> r15) {
        String r3 = a(r12, (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin"));
        Gson r16 = f15303b;
        Map r8 = ao.a(new d.m[]{d.s.a("take_over_scene", "lark_authorize"), d.s.a("authorize_reason", r14.f()), d.s.a("auth_session_id", r14.a()), d.s.a("reason", r14.b()), d.s.a("scopes", r16.toJson(r14.c())), d.s.a("missing_scopes", r16.toJson(r14.d())), d.s.a("auth_type", r14.e().a())});
        IComplexTaskService r2 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L6;
        ILogDepend.Companion.e(TAG, "notifyTakeover failed: complex task service unavailable session=" + r14.a());
        com.obric.aiagent.skill.credentials.api.l.f18971a.a(r14.a(), new com.obric.aiagent.skill.credentials.api.l.c(com.obric.aiagent.skill.credentials.api.l.d.f18988c, "IComplexTaskService is unavailable.", "takeover_service_unavailable", null, 8, null));
        return;
    L6:
        ILogDepend.Companion.i(TAG, "notifyTakeover request questionId=" + r12 + " taskId=" + r3 + " session=" + r14.a() + " scene=lark_authorize authorizeReason=" + r14.f() + " authType=" + r14.e().a() + " requiresAppSetup=" + r14.g() + " missingScopes=" + r14.d());
        r2.requestStateChanged(r3, new TaskStateInfo(TaskState.UserOperationBegin, r14.b(), null, r8, 4, null), (ITaskStateChangeCallback) ZeusTransformUtils.preCheckCast(new OfficeLarkCLIIntentHandler$notifyTakeover$1(r14), ITaskStateChangeCallback.class, "com.obric.aiagent.plugin"), 300000);
    }

    private final String a(long r2, Map<String, String> r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L6:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
        return r3;
    L15:
        ILogDepend.Companion.w(TAG, "resolveTakeoverTaskId fallback to questionId=" + r2 + " because o_omni_task_id is missing");
        return String.valueOf(r2);
    L9:
        if (d.o.o.d(r5) == true) goto L12;
        r6 = false;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    private final Object a(ISkillCredentialService r23, d.c.d<? super d.n<com.obric.aiagent.skill.credentials.api.a>> r24) {
        c r0 = this;
        ISkillCredentialService r1 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r23, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, r.class) == false) goto L7;
        r r4 = (r) ZeusTransformUtils.preCheckCast(r3, r.class, "com.obric.aiagent.plugin");
        if ((r4.f15378e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f15378e -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f15376c;
        Object r6 = d.c.a.b.a();
        int r7 = r4.f15378e;
        if (r7 == 0) goto L22;
        if (r7 == 1) goto L21;
        if (r7 == 2) goto L20;
        if (r7 == 3) goto L19;
        if (r7 == 4) goto L18;
        if (r7 != 5) goto L17;
        d.o.a(r5);
    L52:
        d.n.a r2 = d.n.f38560a;
        return d.n.f(f15302a.a());
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r5);
    L42:
        d.n.a r8 = d.n.f38560a;
        return d.n.f(f15302a.a());
    L19:
        com.obric.aiagent.skill.credentials.api.b r9 = (com.obric.aiagent.skill.credentials.api.b) ZeusTransformUtils.preCheckCast(r4.f15375b, com.obric.aiagent.skill.credentials.api.b.class, "com.obric.aiagent.plugin");
        r1 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r4.f15374a, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        Object r10 = ((d.n) ZeusTransformUtils.preCheckCast(r5, d.n.class, "com.obric.aiagent.plugin")).a();
        com.obric.aiagent.skill.credentials.api.b r15 = r9;
    L35:
        Throwable r11 = d.n.c(r10);
        if (r11 != null) goto L47;
        com.obric.aiagent.skill.credentials.api.a r14 = (com.obric.aiagent.skill.credentials.api.a) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.credentials.api.a.class, "com.obric.aiagent.plugin");
        if (r14.b() == true) goto L44;
        ILogDepend.Companion.w(TAG, "loadStatus resets configured app without login");
        c r12 = f15302a;
        r4.f15374a = null;
        r4.f15375b = null;
        r4.f15378e = 4;
        if (r12.a(r1, "app_without_login", r4) != r6) goto L42;
        return r6;
    L44:
        if (r14.a() != null) goto L46;
        ILogDepend.Companion.w(TAG, "loadStatus preserves configured app missing from status");
        d.n.a r13 = d.n.f38560a;
        return d.n.f(com.obric.aiagent.skill.credentials.api.a.a(r14, r15, false, null, null, null, 30, null));
    L46:
        d.n.a r16 = d.n.f38560a;
        return d.n.f(r14);
    L47:
        c r17 = f15302a;
        if (r17.c(r11) == false) goto L53;
        r4.f15374a = null;
        r4.f15375b = null;
        r4.f15378e = 5;
        if (r17.a(r1, "status", r11, r4) != r6) goto L52;
        return r6;
    L53:
        d.n.a r18 = d.n.f38560a;
        return d.n.f(d.o.a(r11));
    L20:
        d.o.a(r5);
    L60:
        d.n.a r19 = d.n.f38560a;
        return d.n.f(f15302a.a());
    L21:
        r1 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r4.f15375b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        r0 = (c) ZeusTransformUtils.preCheckCast(r4.f15374a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        Object r20 = ((d.n) ZeusTransformUtils.preCheckCast(r5, d.n.class, "com.obric.aiagent.plugin")).a();
    L25:
        Throwable r21 = d.n.c(r20);
        if (r21 != null) goto L55;
        com.obric.aiagent.skill.credentials.api.b r22 = (com.obric.aiagent.skill.credentials.api.b) ZeusTransformUtils.preCheckCast(r20, com.obric.aiagent.skill.credentials.api.b.class, "com.obric.aiagent.plugin");
        if (r22 != null) goto L31;
        ILogDepend.Companion.i(TAG, "loadStatus no configured lark app");
        d.n.a r25 = d.n.f38560a;
        return d.n.f(r0.a());
    L31:
        ISkillCredentialService.a r26 = r1.getAccount();
        com.obric.aiagent.skill.credentials.api.f r27 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        r4.f15374a = r1;
        r4.f15375b = r22;
        r4.f15378e = 3;
        Object r28 = r26.b(r27, r4);
        if (r28 != r6) goto L34;
        return r6;
    L34:
        r15 = r22;
        r10 = r28;
        goto L35
    L55:
        c r29 = f15302a;
        if (r29.c(r21) == false) goto L62;
        r4.f15374a = null;
        r4.f15375b = null;
        r4.f15378e = 2;
        if (r29.a(r1, "getConfiguredApp", r21, r4) != r6) goto L60;
        return r6;
    L62:
        d.n.a r30 = d.n.f38560a;
        return d.n.f(d.o.a(r21));
    L22:
        d.o.a(r5);
        ISkillCredentialService.b r31 = r1.getApps();
        com.obric.aiagent.skill.credentials.api.f r32 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        r4.f15374a = r0;
        r4.f15375b = r1;
        r4.f15378e = 1;
        r20 = r31.a(r32, r4);
        if (r20 != r6) goto L25;
        return r6;
    L7:
        r4 = new r(r0, r3);
        goto L8
    }

    private final Object a(ISkillCredentialService r5, String r6, Throwable r7, d.c.d<? super x> r8) {
        ISkillCredentialService r9 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r5, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r7, com.obric.aiagent.skill.credentials.api.e.class) == false) goto L5;
        com.obric.aiagent.skill.credentials.api.e r11 = (com.obric.aiagent.skill.credentials.api.e) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.credentials.api.e.class, "com.obric.aiagent.plugin");
    L6:
        if (r11 == null) goto L8;
        com.obric.aiagent.skill.credentials.api.h r12 = r11.a();
    L9:
        ILogDepend.Companion r0 = ILogDepend.Companion;
        StringBuilder r1 = new StringBuilder().append("loadStatus recover app conflict method=").append(r6).append(" code=");
        if (r12 == null) goto L12;
        Integer r3 = r12.b();
    L13:
        StringBuilder r4 = r1.append(r3).append(" subtype=");
        if (r12 == null) goto L16;
        r2 = r12.c();
    L16:
        r0.w(TAG, r4.append(r2).toString());
        Object r13 = a(r9, "preflight_" + r6, r10);
        if (r13 != d.c.a.b.a()) goto L20;
        return r13;
    L20:
        return x.f38692a;
    L12:
        r3 = null;
        goto L13
    L8:
        r12 = null;
        goto L9
    L5:
        r11 = null;
        goto L6
    }

    private final Object a(ISkillCredentialService r5, String r6, d.c.d<? super x> r7) {
        ISkillCredentialService r8 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r5, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, m.class) == false) goto L7;
        m r0 = (m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.aiagent.plugin");
        if ((r0.f15356d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f15356d -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f15354b;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f15356d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r6 = (String) ZeusTransformUtils.preCheckCast(r0.f15353a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        Object r11 = ((d.n) ZeusTransformUtils.preCheckCast(r4, d.n.class, "com.obric.aiagent.plugin")).a();
    L17:
        Throwable r12 = d.n.c(r11);
        if (r12 != null) goto L25;
        com.obric.aiagent.skill.credentials.api.h r13 = (com.obric.aiagent.skill.credentials.api.h) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.skill.credentials.api.h.class, "com.obric.aiagent.plugin");
        if (r13.a() == false) goto L22;
        ILogDepend.Companion.i(TAG, "cleanup configured app completed reason=" + r6);
    L24:
        return x.f38692a;
    L22:
        ILogDepend.Companion.w(TAG, "cleanup configured app rejected reason=" + r6 + " code=" + r13.b() + " subtype=" + r13.c());
        goto L24
    L25:
        ILogDepend.Companion.e(TAG, "cleanup configured app failed reason=" + r6, r12);
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r4);
        ISkillCredentialService.b r14 = r8.getApps();
        com.obric.aiagent.skill.credentials.api.f r15 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        r0.f15353a = r6;
        r0.f15356d = 1;
        r11 = r14.c(r15, r0);
        if (r11 != r10) goto L17;
        return r10;
    L7:
        r0 = new m(this, r9);
        goto L8
    }

    private final boolean c(Throwable r2) {
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aiagent.skill.credentials.api.e.class) == false) goto L5;
        com.obric.aiagent.skill.credentials.api.e r1 = (com.obric.aiagent.skill.credentials.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.credentials.api.e.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L12;
        com.obric.aiagent.skill.credentials.api.h r3 = r1.a();
        if (r3 != null) goto L11;
        return false;
    L11:
        return com.obric.aiagent.skill.credentials.api.d.a(r3);
    L12:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    private final com.obric.aiagent.skill.credentials.api.a a() {
        return new com.obric.aiagent.skill.credentials.api.a(null, false, d.a.p.b(), null, null);
    }

    private final Object a(com.obric.aiagent.skill.credentials.api.a r7, d.c.d<? super d.n<x>> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, s.class) == false) goto L7;
        s r0 = (s) ZeusTransformUtils.preCheckCast(r9, s.class, "com.obric.aiagent.plugin");
        if ((r0.f15381c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f15381c -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f15379a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f15381c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r10);
        Object r6 = ((d.n) ZeusTransformUtils.preCheckCast(r10, d.n.class, "com.obric.aiagent.plugin")).a();
    L26:
        Throwable r11 = d.n.c(r6);
        if (r11 != null) goto L29;
    L32:
        return r6;
    L29:
        if (IAppContext.Companion.isDebug() == false) goto L31;
        ILogDepend.Companion.e(TAG, "prepare runtime env provider failed provider=" + com.obric.aiagent.skill.credentials.api.f.f18949a.a(), r11);
        goto L32
    L31:
        ILogDepend.Companion.e(TAG, "prepare runtime env provider failed");
        goto L32
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        if (r7.b() == true) goto L17;
    L33:
        d.n.a r12 = d.n.f38560a;
        return d.n.f(x.f38692a);
    L17:
        if (d.h.b.o.a(a(r7).e(), "valid") == false) goto L33;
        ISkillCredentialService r13 = ISkillCredentialService.Companion.a();
        if (r13 != null) goto L23;
        c r14 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "prepare runtime env provider skipped: credential service unavailable");
        d.n.a r15 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("ISkillCredentialService is unavailable."), Throwable.class, "com.obric.aiagent.plugin")));
    L23:
        ISkillCredentialService.e r16 = r13.getTaskSessions();
        com.obric.aiagent.skill.credentials.api.f r17 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        r0.f15381c = 1;
        r6 = r16.a(r17, "lark-cli", r0);
        if (r6 != r2) goto L26;
        return r2;
    L7:
        r0 = new s(this, r9);
        goto L8
    }

    private final e a(com.obric.aiagent.skill.credentials.api.a r13) {
        Long r12 = r13.d();
        Long r0 = r13.e();
        long r1 = System.currentTimeMillis();
        if (r12 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        if (r0 != null) goto L10;
    L12:
        boolean r2 = false;
    L14:
        if (r13.b() == false) goto L22;
        if (r14 == false) goto L22;
        if (r2 == true) goto L22;
        if (r0 != null) goto L20;
        ILogDepend.Companion.i(TAG, "access token expired but refresh token expiry is unavailable; token status remains valid");
        goto L22
    L20:
        ILogDepend.Companion.i(TAG, "access token expired but refresh token is still usable; token status remains valid");
    L22:
        if (r13.a() != null) goto L26;
        String r15 = "no_app";
    L24:
        String r10 = r15;
    L31:
        boolean r6 = r13.b();
        if (r13.b() == true) goto L34;
    L36:
        boolean r7 = false;
    L37:
        com.obric.aiagent.skill.credentials.api.b r16 = r13.a();
        if (r16 == null) goto L42;
        com.obric.aiagent.skill.credentials.api.i r17 = r16.b();
        if (r17 == null) goto L42;
        e.a r9 = new e.a(r17.b(), r17.a());
    L44:
        return new e(r6, r7, "user", r9, r10, r13.c());
    L42:
        r9 = null;
        goto L44
    L34:
        if (d.h.b.o.a(r10, "valid") == false) goto L36;
        r7 = true;
        goto L37
    L26:
        if (r13.b() == true) goto L28;
        r15 = "no_token";
        goto L24
    L28:
        if (r2 == false) goto L30;
        r15 = "expired";
        goto L24
    L30:
        r10 = "valid";
        goto L31
    L10:
        if (r0.longValue() >= r1) goto L12;
        r2 = true;
        goto L14
    L5:
        if (r12.longValue() >= r1) goto L7;
        r14 = true;
        goto L8
    }

    private final List<String> a(com.obric.aiagent.skill.credentials.api.a r4, List<String> r5) {
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (r4.b() == true) goto L5;
        return r3;
    L5:
        Set r6 = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast(r4.c(), Iterable.class, "com.obric.aiagent.plugin"));
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r7.iterator();
    L7:
        if (r9.hasNext() == false) goto L12;
        Object r1 = r9.next();
        if (r6.contains((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin")) == true) goto L7;
        r8.add(r1);
        goto L7
    L12:
        return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
    }

    private final String a(com.obric.aiagent.skill.credentials.api.l.e r14, List<String> r15) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        if (r14 == com.obric.aiagent.skill.credentials.api.l.e.f18993c) goto L5;
        return null;
    L5:
        if (r13.isEmpty() == true) goto L28;
        List r16 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r17.iterator();
    L9:
        if (r18.hasNext() == false) goto L13;
        Object r2 = r18.next();
        if (d.h.b.o.a((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), "docx:document") == true) goto L9;
        r1.add(r2);
        goto L9
    L13:
        List r19 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L17;
        ((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).add(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null) + " 可能被企业管理员限制授予，若功能受限，可尝试申请其他权限，不用切换为GUI操作。");
    L17:
        if (r13.contains("docx:document") == false) goto L20;
        ((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).add("提示：docx:document权限缺失不会影响文档创建和修改操作，确保按需申请了docx:document:create、docx:document:readonly或者docx:document:write_only即可。对于文档相关权限问题你不需要切换为GUI操作。");
    L20:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L28:
        return null;
    }

    private final Object a(OfficeLarkCLIEnsureAuthParams r6) {
        CharSequence r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_skill_lark_cli_default_reason, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_lark_cli_default_reason"));
        d.h.b.o.c(r0, "getString(...)");
        CharSequence r2 = r6.getReason();
        if (r2 != null) goto L5;
        r2 = r0;
    L5:
        String[] r7 = r6.getScopes();
        if (r7 == null) goto L8;
        List<String> r8 = d.a.i.g(r7);
    L9:
        if (r8 != null) goto L11;
        r8 = d.a.p.b();
    L11:
        Object r5 = a(r8);
        Throwable r9 = d.n.c(r5);
        if (r9 != null) goto L19;
        List r10 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
        d.n.a r11 = d.n.f38560a;
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r12) == true) goto L18;
        r0 = r12;
    L18:
        return d.n.f(new C0314c((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"), r10));
    L19:
        d.n.a r13 = d.n.f38560a;
        return d.n.f(d.o.a(r9));
    L8:
        r8 = null;
        goto L9
    }

    private final Object a(List<String> r7) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r6, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r6.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r8.add(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString());
        goto L4
    L6:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r10.iterator();
    L7:
        boolean r2 = true;
        if (r12.hasNext() == false) goto L15;
        Object r1 = r12.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L13;
        r2 = false;
    L13:
        if (r2 == false) goto L7;
        r11.add(r1);
        goto L7
    L15:
        List r13 = d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L17:
        if (r14.hasNext() == false) goto L21;
        Object r3 = r14.next();
        if ((!f15304c.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L17;
    L22:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L25;
        d.n.a r16 = d.n.f38560a;
        return d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Invalid Lark scope: " + r15 + '.'), Throwable.class, "com.obric.aiagent.plugin")));
    L25:
        d.n.a r17 = d.n.f38560a;
        return d.n.f(r13);
    L21:
        r3 = null;
        goto L22
    }

    static /* synthetic */ String a(c r1, com.obric.aiagent.skill.credentials.api.a r2, Integer r3, List r4, int r5, Object r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = null;
    L9:
        return r1.a(r2, r3, r7);
    }

    private final String a(com.obric.aiagent.skill.credentials.api.a r3, Integer r4, List<String> r5) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        StringBuilder r6 = new StringBuilder();
        StringBuilder r0 = new StringBuilder().append("configuredApp=");
        if (r3.a() == null) goto L5;
        boolean r1 = true;
    L6:
        r6.append(r0.append(r1).append(" loggedIn=").append(r3.b()).append(" tokenStatus=").append(f15302a.a(r3).e()).append(' ').toString());
        r6.append("grantedScopeCount=" + r3.c().size());
        if (r4 == null) goto L9;
        r6.append(" requestedScopeCount=" + r4);
    L9:
        if (r2 == null) goto L11;
        r6.append(" missingScopes=" + r2);
    L11:
        String r7 = r6.toString();
        d.h.b.o.c(r7, "toString(...)");
        return r7;
    L5:
        r1 = false;
        goto L6
    }

    private final IntentResult<Empty> a(int r14, Object r15) {
        return new IntentResult(r14, null, null, f15303b.toJson(r15), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    }
}
