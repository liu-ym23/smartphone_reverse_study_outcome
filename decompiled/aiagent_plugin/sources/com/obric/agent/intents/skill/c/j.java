package com.obric.agent.intents.skill.c;

import com.google.gson.annotations.SerializedName;
import com.obric.agent.ObricService;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.al;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import java.util.List;

/* JADX INFO: compiled from: ShellResultMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    private static final String TAG = "ShellResultMapper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f15039a = null;

    /* JADX INFO: compiled from: ShellResultMapper.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("client_egress_result")
        private final String f15040a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15040a, r6.f15040a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f15040a.hashCode();
        }

        public String toString() {
            return "ClientInfoMsg(clientEgressResult=" + this.f15040a + ')';
        }

        public a(String r2) {
            o.e(r2, "clientEgressResult");
            this.f15040a = r2;
        }
    }

    /* JADX INFO: compiled from: ShellResultMapper.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("result")
        private final String f15041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("message")
        private final String f15042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("execution_id")
        private final String f15043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("client_info")
        private final a f15044d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15041a, r6.f15041a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f15042b, r6.f15042b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f15043c, r6.f15043c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f15044d, r6.f15044d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f15041a.hashCode() * 31) + this.f15042b.hashCode()) * 31) + this.f15043c.hashCode()) * 31;
            a r2 = this.f15044d;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "KillResultMsg(result=" + this.f15041a + ", message=" + this.f15042b + ", executionId=" + this.f15043c + ", clientInfo=" + this.f15044d + ')';
        }

        public b(String r2, String r3, String r4, a r5) {
            o.e(r2, "result");
            o.e(r3, "message");
            o.e(r4, "executionId");
            this.f15041a = r2;
            this.f15042b = r3;
            this.f15043c = r4;
            this.f15044d = r5;
        }

        public final String a() {
            return this.f15041a;
        }

        public final String b() {
            return this.f15043c;
        }
    }

    /* JADX INFO: compiled from: ShellResultMapper.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("results")
        private final List<e> f15045a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15045a, r6.f15045a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f15045a.hashCode();
        }

        public String toString() {
            return "ShellInspectBatchResultMsg(results=" + this.f15045a + ')';
        }

        public c(List<e> r3) {
            List<e> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "results");
            this.f15045a = r4;
        }
    }

    /* JADX INFO: compiled from: ShellResultMapper.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(DownloadConstants.PATH_KEY)
        private final String f15046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("content")
        private final String f15047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("char_start")
        private final int f15048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("char_end")
        private final int f15049d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("total_chars")
        private final int f15050e;

        @SerializedName("truncated")
        private final boolean f;

        @SerializedName("truncated_lines")
        private final Integer g;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15046a, r6.f15046a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f15047b, r6.f15047b) == true) goto L15;
            return false;
        L15:
            if (this.f15048c == r6.f15048c) goto L18;
            return false;
        L18:
            if (this.f15049d == r6.f15049d) goto L21;
            return false;
        L21:
            if (this.f15050e == r6.f15050e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (o.a(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            String r0 = this.f15046a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((((((((((r2 * 31) + this.f15047b.hashCode()) * 31) + Integer.hashCode(this.f15048c)) * 31) + Integer.hashCode(this.f15049d)) * 31) + Integer.hashCode(this.f15050e)) * 31) + Boolean.hashCode(this.f)) * 31;
            Integer r4 = this.g;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ShellOutputMsg(path=" + this.f15046a + ", content=" + this.f15047b + ", charStart=" + this.f15048c + ", charEnd=" + this.f15049d + ", totalChars=" + this.f15050e + ", truncated=" + this.f + ", truncatedLines=" + this.g + ')';
        }

        public d(String r2, String r3, int r4, int r5, int r6, boolean r7, Integer r8) {
            o.e(r3, "content");
            this.f15046a = r2;
            this.f15047b = r3;
            this.f15048c = r4;
            this.f15049d = r5;
            this.f15050e = r6;
            this.f = r7;
            this.g = r8;
        }

        public final boolean a() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: ShellResultMapper.kt */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("result")
        private final String f15051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("execution_id")
        private final String f15052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("cwd")
        private final String f15053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("exit_code")
        private final Integer f15054d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("duration_ms")
        private final Long f15055e;

        @SerializedName("stdout")
        private final d f;

        @SerializedName("stderr")
        private final d g;

        @SerializedName("error_type")
        private final String h;

        @SerializedName("error_msg")
        private final String i;

        @SerializedName("client_info")
        private final a j;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15051a, r6.f15051a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f15052b, r6.f15052b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f15053c, r6.f15053c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f15054d, r6.f15054d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f15055e, r6.f15055e) == true) goto L24;
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
            int r0 = this.f15051a.hashCode() * 31;
            String r1 = this.f15052b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f15053c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Integer r8 = this.f15054d;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Long r11 = this.f15055e;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            d r14 = this.f;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            d r17 = this.g;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.h;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            String r23 = this.i;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            a r26 = this.j;
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
            return "ShellResultMsg(result=" + this.f15051a + ", executionId=" + this.f15052b + ", cwd=" + this.f15053c + ", exitCode=" + this.f15054d + ", durationMs=" + this.f15055e + ", stdout=" + this.f + ", stderr=" + this.g + ", errorType=" + this.h + ", errorMsg=" + this.i + ", clientInfo=" + this.j + ')';
        }

        public e(String r2, String r3, String r4, Integer r5, Long r6, d r7, d r8, String r9, String r10, a r11) {
            o.e(r2, "result");
            this.f15051a = r2;
            this.f15052b = r3;
            this.f15053c = r4;
            this.f15054d = r5;
            this.f15055e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
        }

        public /* synthetic */ e(String r11, String r12, String r13, Integer r14, Long r15, d r16, d r17, String r18, String r19, a r20, int r21, d.h.b.h r22) {
            a r2 = null;
            if ((r21 & 2) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r21 & 4) == 0) goto L9;
            String r3 = null;
        L11:
            if ((r21 & 8) == 0) goto L13;
            Integer r4 = null;
        L15:
            if ((r21 & 16) == 0) goto L17;
            Long r5 = null;
        L19:
            if ((r21 & 32) == 0) goto L21;
            d r6 = null;
        L23:
            if ((r21 & 64) == 0) goto L25;
            d r7 = null;
        L27:
            if ((r21 & 128) == 0) goto L29;
            String r8 = null;
        L31:
            if ((r21 & 256) == 0) goto L33;
            String r9 = null;
        L35:
            if ((r21 & 512) != 0) goto L38;
            r2 = r20;
        L38:
            this(r11, r1, r3, r4, r5, r6, r7, r8, r9, r2);
            return;
        L33:
            r9 = r19;
            goto L35
        L29:
            r8 = r18;
            goto L31
        L25:
            r7 = r17;
            goto L27
        L21:
            r6 = r16;
            goto L23
        L17:
            r5 = r15;
            goto L19
        L13:
            r4 = r14;
            goto L15
        L9:
            r3 = r13;
            goto L11
        L5:
            r1 = r12;
            goto L7
        }

        public final String a() {
            return this.f15051a;
        }

        public final String b() {
            return this.f15052b;
        }

        public final Integer c() {
            return this.f15054d;
        }

        public final d d() {
            return this.f;
        }

        public final d e() {
            return this.g;
        }

        public final String f() {
            return this.h;
        }
    }

    static {
        f15039a = new j();
    }

    private j() {
    }

    public final e a(com.obric.aiagent.skill.ovirt.api.b.b.a r11) {
        o.e(r11, "result");
        return a(this, r11.a(), null, null, r11.b(), 0, 0, 54, null);
    }

    public static /* synthetic */ e a(j r6, com.obric.aiagent.skill.ovirt.api.b.b.c r7, String r8, String r9, String r10, int r11, int r12, int r13, Object r14) {
        String r1 = null;
        if ((r13 & 2) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r13 & 8) != 0) goto L14;
        r1 = r10;
    L14:
        int r4 = 0;
        if ((r13 & 16) == 0) goto L17;
        int r3 = 0;
    L19:
        if ((r13 & 32) != 0) goto L23;
        r4 = r12;
    L23:
        return r6.a(r7, r0, r2, r1, r3, r4);
    L17:
        r3 = r11;
        goto L19
    L9:
        r2 = r9;
        goto L11
    L5:
        r0 = r8;
        goto L7
    }

    public final e a(com.obric.aiagent.skill.ovirt.api.b.b.c r17, String r18, String r19, String r20, int r21, int r22) {
        o.e(r17, "snapshot");
        int r1 = al.f19195a.a().q();
        d r11 = a(r17.d(), r17.j(), r21, r1);
        d r12 = a(r17.e(), r17.k(), r22, r1);
        if (r18 == null) goto L5;
        String r6 = r18;
    L17:
        String r7 = r17.a();
        String r8 = r17.b();
        long r3 = r17.i();
        Integer r5 = r17.g();
        if ((!o.a(r6, "PENDING")) == false) goto L20;
        Integer r0 = r5;
    L21:
        if (r19 == null) goto L23;
        String r13 = r19;
    L32:
        if (o.a(r6, "FAILURE") == false) goto L34;
        String r14 = r20;
    L35:
        String r2 = r17.l();
        if (r2 == null) goto L38;
        a r15 = new a(r2);
    L40:
        return new e(r6, r7, r8, r0, Long.valueOf(r3), r11, r12, r13, r14, r15);
    L38:
        r15 = null;
        goto L40
    L34:
        r14 = null;
        goto L35
    L23:
        if (o.a(r6, "FAILURE") == true) goto L26;
        r13 = null;
        goto L32
    L26:
        if (r17.h() == false) goto L28;
        String r9 = "KILL";
    L29:
        r13 = r9;
        goto L32
    L28:
        r9 = "NORMAL";
        goto L29
    L20:
        r0 = null;
        goto L21
    L5:
        if (r17.f() == true) goto L7;
        r6 = "PENDING";
        goto L17
    L7:
        Integer r4 = r17.g();
        if (r4 != null) goto L11;
    L15:
        r6 = "FAILURE";
        goto L17
    L11:
        if (r4.intValue() != 0) goto L15;
        if (r17.h() == true) goto L15;
        r6 = "SUCCESS";
        goto L17
    }

    public final e a(com.obric.aiagent.skill.ovirt.api.b.b.c r15, String r16) {
        o.e(r16, "reason");
        if (r15 != null) goto L7;
        String r2 = "FAILURE";
        String r9 = "BLOCKED";
        return new e(r2, null, null, null, null, null, null, r9, r16, null, 638, null);
    L7:
        return a(this, r15, "FAILURE", "BLOCKED", r16, 0, 0, 48, null);
    }

    public final e a(String r14) {
        o.e(r14, "executionId");
        return new e("FAILURE", r14, null, null, null, null, null, "NORMAL", "execution not found", null, 636, null);
    }

    public static /* synthetic */ e a(j r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.a(r1, r2, r3);
    }

    public final e a(String r15, String r16, String r17) {
        o.e(r15, "errorType");
        o.e(r16, "errorMsg");
        return new e("FAILURE", r17, null, null, null, null, null, r15, r16, null, 636, null);
    }

    public static /* synthetic */ b a(j r0, String r1, boolean r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = null;
    L9:
        return r0.a(r1, r2, r3, r4);
    }

    public final b a(String r1, boolean r2, String r3, String r4) {
        o.e(r1, "executionId");
        o.e(r3, "message");
        if (r2 == false) goto L5;
        String r0 = "SUCCESS";
    L6:
        if (r4 == null) goto L8;
        a r5 = new a(r4);
    L10:
        return new b(r0, r3, r1, r5);
    L8:
        r5 = null;
        goto L10
    L5:
        r0 = "FAILURE";
        goto L6
    }

    public static /* synthetic */ IntentResult a(j r0, e r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = true;
    L9:
        return r0.a(r1, r2, r3);
    }

    public final IntentResult<Empty> a(e r15, int r16, boolean r17) {
        o.e(r15, "result");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        j r3 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r0 = n.f(ObricService.INSTANCE.getGson().toJson(r15));     // Catch: Throwable -> L5
    L7:
        Throwable r4 = n.c(r0);
        if (r4 == null) goto L11;
        f15039a.a("serialize shell result failed", r4);
    L11:
        if (n.c(r0) != null) goto L15;
        IntentResult<Empty> r1 = new IntentResult(r16, null, null, (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        r1.setFinal(r17);
        return r1;
    L15:
        return new IntentResult(-2002, null, null, "result serialization failed", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L5:
        th = move-exception;
        n.a r5 = n.f38560a;
        r0 = n.f(d.o.a(th));
        goto L7
    }

    public static /* synthetic */ IntentResult a(j r0, c r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.a(r1, r2);
    }

    public final IntentResult<Empty> a(c r28, int r29) {
        o.e(r28, "result");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        j r3 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r0 = n.f(ObricService.INSTANCE.getGson().toJson(r28));     // Catch: Throwable -> L5
    L7:
        Throwable r4 = n.c(r0);
        if (r4 == null) goto L11;
        f15039a.a("serialize inspect result failed", r4);
    L11:
        if (n.c(r0) != null) goto L15;
        return new IntentResult(r29, null, null, (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L15:
        return new IntentResult(-2002, null, null, "result serialization failed", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L5:
        th = move-exception;
        n.a r5 = n.f38560a;
        r0 = n.f(d.o.a(th));
        goto L7
    }

    public static /* synthetic */ IntentResult a(j r0, b r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.a(r1, r2);
    }

    public final IntentResult<Empty> a(b r28, int r29) {
        o.e(r28, "result");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        j r3 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r0 = n.f(ObricService.INSTANCE.getGson().toJson(r28));     // Catch: Throwable -> L5
    L7:
        Throwable r4 = n.c(r0);
        if (r4 == null) goto L11;
        f15039a.a("serialize kill result failed", r4);
    L11:
        if (n.c(r0) != null) goto L15;
        return new IntentResult(r29, null, null, (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L15:
        return new IntentResult(-2002, null, null, "result serialization failed", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L5:
        th = move-exception;
        n.a r5 = n.f38560a;
        r0 = n.f(d.o.a(th));
        goto L7
    }

    private final void a(String r2, Throwable r3) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e(TAG, r2, r3);
        return;
    L5:
        ILogDepend.Companion.e(TAG, r2);
    }

    private final d a(String r9, String r10, int r11, int r12) {
        int r5 = r9.length();
        int r3 = d.l.n.a(r11, 0, r5);
        if (r12 > 0) goto L5;
        int r4 = r5;
    L6:
        if (r4 >= r5) goto L8;
        boolean r6 = true;
    L9:
        String r2 = r9.substring(r3, r4);
        o.c(r2, "substring(...)");
        Integer r8 = Integer.valueOf(a(r9, r4));
        ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r6 == true) goto L14;
        r8 = null;
    L14:
        return new d(r10, r2, r3, r4, r5, r6, r8);
    L8:
        r6 = false;
        goto L9
    L5:
        r4 = d.l.n.d(r12 + r3, r5);
        goto L6
    }

    private final int a(String r7, int r8) {
        if (r8 < r7.length()) goto L5;
        return 0;
    L5:
        String r6 = r7.substring(r8);
        o.c(r6, "substring(...)");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        int r2 = 0;
    L6:
        boolean r5 = true;
        if (r1 >= r9.length()) goto L16;
        if (r9.charAt(r1) == '\n') goto L12;
        r5 = false;
    L12:
        if (r5 == false) goto L14;
        r2 = r2 + 1;
    L14:
        r1 = r1 + 1;
        goto L6
    L16:
        return r2 + (!d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), '\n', false, 2, null) ? 1 : 0);
    }
}
