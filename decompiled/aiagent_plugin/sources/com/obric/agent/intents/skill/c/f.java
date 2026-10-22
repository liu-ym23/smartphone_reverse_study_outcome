package com.obric.agent.intents.skill.c;

import com.bytedance.keva.KevaImpl;
import com.google.gson.annotations.SerializedName;
import com.obric.agent.ObricService;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import java.util.List;

/* JADX INFO: compiled from: ShellFileTransferResultMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private static final String TAG = "ShellFileTransferResultMapper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f14965a = null;

    /* JADX INFO: compiled from: ShellFileTransferResultMapper.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("media")
        private final b f14966a;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14966a, r6.f14966a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            b r0 = this.f14966a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "FileTransferExt(media=" + this.f14966a + ')';
        }

        public a(b r1) {
            this.f14966a = r1;
        }

        public /* synthetic */ a(b r1, int r2, d.h.b.h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    /* JADX INFO: compiled from: ShellFileTransferResultMapper.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("type")
        private final String f14967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("width")
        private final Integer f14968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("height")
        private final Integer f14969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("duration_ms")
        private final Long f14970d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("cover")
        private final c f14971e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14967a, r6.f14967a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14968b, r6.f14968b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14969c, r6.f14969c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f14970d, r6.f14970d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f14971e, r6.f14971e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = this.f14967a.hashCode() * 31;
            Integer r1 = this.f14968b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.f14969c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Long r8 = this.f14970d;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            c r11 = this.f14971e;
            if (r11 == null) goto L19;
            r2 = r11.hashCode();
        L19:
            return r10 + r2;
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
            return "FileTransferMedia(type=" + this.f14967a + ", width=" + this.f14968b + ", height=" + this.f14969c + ", durationMs=" + this.f14970d + ", cover=" + this.f14971e + ')';
        }

        public b(String r2, Integer r3, Integer r4, Long r5, c r6) {
            o.e(r2, "type");
            this.f14967a = r2;
            this.f14968b = r3;
            this.f14969c = r4;
            this.f14970d = r5;
            this.f14971e = r6;
        }

        public /* synthetic */ b(String r8, Integer r9, Integer r10, Long r11, c r12, int r13, d.h.b.h r14) {
            if ((r13 & 2) == 0) goto L5;
            Integer r3 = null;
        L7:
            if ((r13 & 4) == 0) goto L9;
            Integer r4 = null;
        L11:
            if ((r13 & 8) == 0) goto L13;
            Long r5 = null;
        L15:
            if ((r13 & 16) == 0) goto L17;
            c r6 = null;
        L18:
            this(r8, r3, r4, r5, r6);
            return;
        L17:
            r6 = r12;
            goto L18
        L13:
            r5 = r11;
            goto L15
        L9:
            r4 = r10;
            goto L11
        L5:
            r3 = r9;
            goto L7
        }

        public final String getType() {
            return this.f14967a;
        }
    }

    /* JADX INFO: compiled from: ShellFileTransferResultMapper.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("extension_name")
        private final String f14972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName(DownloadConstants.PATH_KEY)
        private final String f14973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("width")
        private final int f14974c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("height")
        private final int f14975d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14972a, r6.f14972a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14973b, r6.f14973b) == true) goto L15;
            return false;
        L15:
            if (this.f14974c == r6.f14974c) goto L18;
            return false;
        L18:
            if (this.f14975d == r6.f14975d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f14972a.hashCode() * 31) + this.f14973b.hashCode()) * 31) + Integer.hashCode(this.f14974c)) * 31) + Integer.hashCode(this.f14975d);
        }

        public String toString() {
            return "FileTransferMediaCover(extensionName=" + this.f14972a + ", path=" + this.f14973b + ", width=" + this.f14974c + ", height=" + this.f14975d + ')';
        }

        public c(String r2, String r3, int r4, int r5) {
            o.e(r2, "extensionName");
            o.e(r3, DownloadConstants.PATH_KEY);
            this.f14972a = r2;
            this.f14973b = r3;
            this.f14974c = r4;
            this.f14975d = r5;
        }
    }

    /* JADX INFO: compiled from: ShellFileTransferResultMapper.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("is_success")
        private final boolean f14976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("name")
        private final String f14977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("extension_name")
        private final String f14978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName(MonitorConstants.SIZE)
        private final Long f14979d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("mime_type")
        private final String f14980e;

        @SerializedName("source_path")
        private final String f;

        @SerializedName("exported_path")
        private final String g;

        @SerializedName("ext")
        private final a h;

        @SerializedName("error_code")
        private final Integer i;

        @SerializedName("error_msg")
        private final String j;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (this.f14976a == r6.f14976a) goto L12;
            return false;
        L12:
            if (o.a(this.f14977b, r6.f14977b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14978c, r6.f14978c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f14979d, r6.f14979d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f14980e, r6.f14980e) == true) goto L24;
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
            int r0 = Boolean.hashCode(this.f14976a) * 31;
            String r1 = this.f14977b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f14978c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Long r8 = this.f14979d;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.f14980e;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.f;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.g;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            a r20 = this.h;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            Integer r23 = this.i;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            String r26 = this.j;
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
            return "FileTransferResultFile(isSuccess=" + this.f14976a + ", name=" + this.f14977b + ", extensionName=" + this.f14978c + ", size=" + this.f14979d + ", mimeType=" + this.f14980e + ", sourcePath=" + this.f + ", exportedPath=" + this.g + ", ext=" + this.h + ", errorCode=" + this.i + ", errorMsg=" + this.j + ')';
        }

        public d(boolean r1, String r2, String r3, Long r4, String r5, String r6, String r7, a r8, Integer r9, String r10) {
            this.f14976a = r1;
            this.f14977b = r2;
            this.f14978c = r3;
            this.f14979d = r4;
            this.f14980e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
        }

        public /* synthetic */ d(boolean r11, String r12, String r13, Long r14, String r15, String r16, String r17, a r18, Integer r19, String r20, int r21, d.h.b.h r22) {
            String r2 = null;
            if ((r21 & 2) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r21 & 4) == 0) goto L9;
            String r3 = null;
        L11:
            if ((r21 & 8) == 0) goto L13;
            Long r4 = null;
        L15:
            if ((r21 & 16) == 0) goto L17;
            String r5 = null;
        L19:
            if ((r21 & 32) == 0) goto L21;
            String r6 = null;
        L23:
            if ((r21 & 64) == 0) goto L25;
            String r7 = null;
        L27:
            if ((r21 & 128) == 0) goto L29;
            a r8 = null;
        L31:
            if ((r21 & 256) == 0) goto L33;
            Integer r9 = null;
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

        public final boolean a() {
            return this.f14976a;
        }

        public final String b() {
            return this.f14977b;
        }

        public final String c() {
            return this.f;
        }

        public final String d() {
            return this.g;
        }

        public final Integer e() {
            return this.i;
        }
    }

    /* JADX INFO: compiled from: ShellFileTransferResultMapper.kt */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(KevaImpl.PrivateConstants.FILES_DIR_NAME)
        private final List<d> f14981a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14981a, r6.f14981a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f14981a.hashCode();
        }

        public String toString() {
            return "FileTransferResultMsg(files=" + this.f14981a + ')';
        }

        public e(List<d> r3) {
            List<d> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r4, KevaImpl.PrivateConstants.FILES_DIR_NAME);
            this.f14981a = r4;
        }
    }

    static {
        f14965a = new f();
    }

    private f() {
    }

    public final IntentResult<Empty> a(List<d> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        return a(0, new e(r4));
    }

    public final d a(String r15, String r16, long r17, String r19, String r20, String r21, a r22) {
        o.e(r15, "name");
        o.e(r16, "extensionName");
        o.e(r19, DBDefinition.MIME_TYPE);
        o.e(r20, "sourcePath");
        o.e(r21, "exportedPath");
        boolean r2 = true;
        return new d(r2, r15, r16, Long.valueOf(r17), r19, r20, r21, r22, null, null, 768, null);
    }

    public final d a(int r14, String r15) {
        o.e(r15, "message");
        boolean r1 = false;
        String r2 = null;
        String r3 = null;
        Long r4 = null;
        String r5 = null;
        String r6 = null;
        String r7 = null;
        a r8 = null;
        return new d(r1, r2, r3, r4, r5, r6, r7, r8, Integer.valueOf(r14), r15, 254, null);
    }

    public final IntentResult<Empty> b(int r14, String r15) {
        o.e(r15, "message");
        return new IntentResult(r14, null, null, r15, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    }

    private final IntentResult<Empty> a(int r14, e r15) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        f r13 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r16 = n.f(ObricService.INSTANCE.getGson().toJson(r15));     // Catch: Throwable -> L5
    L7:
        Throwable r17 = n.c(r16);
        if (r17 == null) goto L14;
        if (IAppContext.Companion.isDebug() == false) goto L12;
        ILogDepend.Companion.e(TAG, "serialize file transfer result failed", r17);
        goto L14
    L12:
        ILogDepend.Companion.e(TAG, "serialize file transfer result failed");
    L14:
        if (n.c(r16) == null) goto L18;
        r16 = "{\"error_msg\":\"serialize file transfer result failed\"}";
    L18:
        return new IntentResult(r14, null, null, (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin"), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L5:
        th = move-exception;
        n.a r18 = n.f38560a;
        r16 = n.f(d.o.a(th));
        goto L7
    }
}
