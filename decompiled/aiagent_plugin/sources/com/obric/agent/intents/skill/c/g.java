package com.obric.agent.intents.skill.c;

import android.app.Application;
import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.keva.KevaImpl;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.al;
import com.obric.aiagent.skill.ovirt.api.IOVirtService;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.ResultCode;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.m;
import d.h.b.o;
import d.h.b.z;
import d.n;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: ShellImportFilesActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.c.a, c> {
    private static final String TAG = "ShellImportFilesActionExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f14982a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14983b = null;

    /* JADX INFO: compiled from: ShellImportFilesActionExecutor.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("type")
        private final String f14984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("entity")
        private final JsonObject f14985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName(DownloadConstants.PATH_KEY)
        private final String f14986c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14984a, r6.f14984a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14985b, r6.f14985b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14986c, r6.f14986c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.f14984a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            JsonObject r4 = this.f14985b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.f14986c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ImportFileRef(type=" + this.f14984a + ", entity=" + this.f14985b + ", path=" + this.f14986c + ')';
        }

        public final String getType() {
            return this.f14984a;
        }

        public final JsonObject a() {
            return this.f14985b;
        }

        public final String b() {
            return this.f14986c;
        }
    }

    /* JADX INFO: compiled from: ShellImportFilesActionExecutor.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("is_success")
        private final boolean f14987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("name")
        private final String f14988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName(MonitorConstants.SIZE)
        private final Long f14989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("mime_type")
        private final String f14990d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("vm_path")
        private final String f14991e;

        @SerializedName("error_code")
        private final Integer f;

        @SerializedName("error_msg")
        private final String g;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f14987a == r6.f14987a) goto L12;
            return false;
        L12:
            if (o.a(this.f14988b, r6.f14988b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14989c, r6.f14989c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f14990d, r6.f14990d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f14991e, r6.f14991e) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (o.a(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f14987a) * 31;
            String r1 = this.f14988b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Long r5 = this.f14989c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f14990d;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.f14991e;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Integer r14 = this.f;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.g;
            if (r17 == null) goto L27;
            r2 = r17.hashCode();
        L27:
            return r16 + r2;
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
            return "ImportFileResult(isSuccess=" + this.f14987a + ", name=" + this.f14988b + ", size=" + this.f14989c + ", mimeType=" + this.f14990d + ", vmPath=" + this.f14991e + ", errorCode=" + this.f + ", errorMsg=" + this.g + ')';
        }

        public b(boolean r1, String r2, Long r3, String r4, String r5, Integer r6, String r7) {
            this.f14987a = r1;
            this.f14988b = r2;
            this.f14989c = r3;
            this.f14990d = r4;
            this.f14991e = r5;
            this.f = r6;
            this.g = r7;
        }

        public /* synthetic */ b(boolean r8, String r9, Long r10, String r11, String r12, Integer r13, String r14, int r15, d.h.b.h r16) {
            String r1 = null;
            if ((r15 & 2) == 0) goto L5;
            String r0 = null;
        L7:
            if ((r15 & 4) == 0) goto L9;
            Long r2 = null;
        L11:
            if ((r15 & 8) == 0) goto L13;
            String r3 = null;
        L15:
            if ((r15 & 16) == 0) goto L17;
            String r4 = null;
        L19:
            if ((r15 & 32) == 0) goto L21;
            Integer r5 = null;
        L23:
            if ((r15 & 64) != 0) goto L26;
            r1 = r14;
        L26:
            this(r8, r0, r2, r3, r4, r5, r1);
            return;
        L21:
            r5 = r13;
            goto L23
        L17:
            r4 = r12;
            goto L19
        L13:
            r3 = r11;
            goto L15
        L9:
            r2 = r10;
            goto L11
        L5:
            r0 = r9;
            goto L7
        }

        public final boolean a() {
            return this.f14987a;
        }

        public final String b() {
            return this.f14988b;
        }

        public final String c() {
            return this.f14991e;
        }

        public final Integer d() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: ShellImportFilesActionExecutor.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(KevaImpl.PrivateConstants.FILES_DIR_NAME)
        private final List<a> f14992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14993b;

        public static /* synthetic */ c a(c r1, List r2, String r3, int r4, Object r5) {
            List<a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r6 = r1.f14992a;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = r1.f14993b;
        L9:
            return r1.a(r6, r3);
        }

        public final c a(List<a> r2, String r3) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            o.e(r3, "uniqueId");
            return new c(r1, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14992a, r6.f14992a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14993b, r6.f14993b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            List<a> r0 = this.f14992a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f14993b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "ImportFilesActionRequest(files=" + this.f14992a + ", uniqueId=" + this.f14993b + ')';
        }

        public c(List<a> r3, String r4) {
            List<a> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "uniqueId");
            this.f14992a = r5;
            this.f14993b = r4;
        }

        public final List<a> a() {
            return this.f14992a;
        }

        public final String b() {
            return this.f14993b;
        }
    }

    /* JADX INFO: compiled from: ShellImportFilesActionExecutor.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(KevaImpl.PrivateConstants.FILES_DIR_NAME)
        private final List<b> f14994a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14994a, r6.f14994a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f14994a.hashCode();
        }

        public String toString() {
            return "ImportFilesResult(files=" + this.f14994a + ')';
        }

        public d(List<b> r3) {
            List<b> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r4, KevaImpl.PrivateConstants.FILES_DIR_NAME);
            this.f14994a = r4;
        }
    }

    /* JADX INFO: compiled from: ShellImportFilesActionExecutor.kt */
    @d.c.b.a.f(b = "ShellImportFilesActionExecutor.kt", c = {93}, d = "invokeSuspend", e = "com.obric.agent.intents.skill.systemshell.ShellImportFilesActionExecutor$execute$2")
    static final class e extends d.c.b.a.l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f14995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.intents.skill.c.a f14997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f14998d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ DispatchContext f14999e;

        e(com.obric.agent.intents.skill.c.a r3, c r4, DispatchContext r5, d.c.d<? super e> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14997c = r3;
            this.f14998d = r4;
            this.f14999e = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f14997c, this.f14998d, this.f14999e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r25) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f14996b;
            if (r2 == 0) goto L12;
            if (r2 != 1) goto L11;
            long r5 = this.f14995a;
            d.o.a(r25);     // Catch: Exception -> L8
            Object r3 = r25;
        L17:
            IntentResult<?> r1 = (IntentResult) ZeusTransformUtils.preCheckCast(r3, IntentResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
        L22:
            AtomicCapabilitySdk.INSTANCE.updateIntentResult(r1, this.f14999e, true);
            return x.f38692a;
        L8:
            e = e;
            long r9 = r5;
        L21:
            g.a(g.f14982a, "import_files async final failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            r1 = new IntentResult(-2002, null, null, "import failed", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
            g.a(g.f14982a, this.f14998d, r9, r1, null, 8, null);
            goto L22
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            d.o.a(r25);
            long r11 = SystemClock.elapsedRealtime();
            g r6 = g.f14982a;     // Catch: Exception -> L19
            com.obric.agent.intents.skill.c.a r7 = this.f14997c;     // Catch: Exception -> L19
            c r8 = this.f14998d;     // Catch: Exception -> L19
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
            this.f14995a = r11;     // Catch: Exception -> L19
            this.f14996b = 1;     // Catch: Exception -> L19
            r3 = g.a(r6, r7, r8, r11, r10);     // Catch: Exception -> L19
            if (r3 != r0) goto L16;
            return r0;
        L16:
            r5 = r11;
        L19:
            e = e;
            r9 = r11;
            goto L21
        }
    }

    /* JADX INFO: compiled from: ShellImportFilesActionExecutor.kt */
    @d.c.b.a.f(b = "ShellImportFilesActionExecutor.kt", c = {125}, d = "executeImportFiles", e = "com.obric.agent.intents.skill.systemshell.ShellImportFilesActionExecutor")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15001b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15002c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f15003d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f15004e;
        Object f;
        long g;
        int h;
        /* synthetic */ Object i;
        final /* synthetic */ g j;
        int k;

        f(g r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.i = r7;
            this.k |= Integer.MIN_VALUE;
            return g.a(this.j, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.intents.skill.c.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShellImportFilesActionExecutor.kt */
    @d.c.b.a.f(b = "ShellImportFilesActionExecutor.kt", c = {264, 265}, d = "importEntity", e = "com.obric.agent.intents.skill.systemshell.ShellImportFilesActionExecutor")
    static final class C0302g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15007c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f15008d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f15009e;
        /* synthetic */ Object f;
        final /* synthetic */ g g;
        int h;

        C0302g(g r3, d.c.d<? super C0302g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return g.b(this.g, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellImportFilesActionExecutor.kt */
    @d.c.b.a.f(b = "ShellImportFilesActionExecutor.kt", c = {353}, d = "importFile", e = "com.obric.agent.intents.skill.systemshell.ShellImportFilesActionExecutor")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f15011b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f15012c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f15013d;

        h(g r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15012c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15011b = r3;
            this.f15013d |= Integer.MIN_VALUE;
            return g.a(this.f15012c, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellImportFilesActionExecutor.kt */
    @d.c.b.a.f(b = "ShellImportFilesActionExecutor.kt", c = {199}, d = "importHostFile", e = "com.obric.agent.intents.skill.systemshell.ShellImportFilesActionExecutor")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15015b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f15016c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f15017d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f15018e;

        i(g r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15017d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15016c = r3;
            this.f15018e |= Integer.MIN_VALUE;
            return g.a(this.f15017d, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellImportFilesActionExecutor.kt */
    @d.c.b.a.f(b = "ShellImportFilesActionExecutor.kt", c = {319}, d = "importWithAtomicCapabilitySdk", e = "com.obric.agent.intents.skill.systemshell.ShellImportFilesActionExecutor")
    static final class j extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f15021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f15022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f15023e;

        j(g r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15022d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15021c = r3;
            this.f15023e |= Integer.MIN_VALUE;
            return g.a(this.f15022d, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellImportFilesActionExecutor.kt */
    @d.c.b.a.f(b = "ShellImportFilesActionExecutor.kt", c = {320}, d = "invokeSuspend", e = "com.obric.agent.intents.skill.systemshell.ShellImportFilesActionExecutor$importWithAtomicCapabilitySdk$status$1")
    static final class k extends d.c.b.a.l implements m<InputStream, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f15025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.f<com.obric.aiagent.skill.ovirt.api.a.f> f15026c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.intents.skill.c.a f15027d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ FileEntity f15028e;

        k(z.f<com.obric.aiagent.skill.ovirt.api.a.f> r3, com.obric.agent.intents.skill.c.a r4, FileEntity r5, d.c.d<? super k> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15026c = r3;
            this.f15027d = r4;
            this.f15028e = r5;
            super(2, r7);
        }

        public final Object a(InputStream r3, d.c.d<? super x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            k r0 = new k(this.f15026c, this.f15027d, this.f15028e, r7);
            r0.f15025b = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(InputStream r3, d.c.d<? super x> r4) {
            return a((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15024a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            z.f<com.obric.aiagent.skill.ovirt.api.a.f> r8 = (z.f) ZeusTransformUtils.preCheckCast(this.f15025b, z.f.class, "com.obric.aiagent.plugin");
            d.o.a(r9);
            T r10 = r9;
        L12:
            r8.f38504a = r10;
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r9);
            InputStream r11 = (InputStream) ZeusTransformUtils.preCheckCast(this.f15025b, InputStream.class, "com.obric.aiagent.plugin");
            z.f<com.obric.aiagent.skill.ovirt.api.a.f> r2 = this.f15026c;
            g r4 = g.f14982a;
            com.obric.agent.intents.skill.c.a r5 = this.f15027d;
            FileEntity r6 = this.f15028e;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15025b = r2;
            this.f15024a = 1;
            Object r12 = g.a(r4, r5, r6, r11, r3);
            if (r12 != r0) goto L11;
            return r0;
        L11:
            r8 = r2;
            r10 = r12;
            goto L12
        }
    }

    /* JADX INFO: compiled from: ShellImportFilesActionExecutor.kt */
    @d.c.b.a.f(b = "ShellImportFilesActionExecutor.kt", c = {ResultCode.ERROR_MULTI_DETAIL}, d = "importWithContentResolver", e = "com.obric.agent.intents.skill.systemshell.ShellImportFilesActionExecutor")
    static final class l extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f15031c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f15032d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f15033e;

        l(g r3, d.c.d<? super l> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15032d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15031c = r3;
            this.f15033e |= Integer.MIN_VALUE;
            return g.a(this.f15032d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private g() {
    }

    public static final /* synthetic */ Object a(g r2, com.obric.agent.intents.skill.c.a r3, a r4, int r5, d.c.d r6) {
        return r2.b(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(g r6, com.obric.agent.intents.skill.c.a r7, c r8, long r9, d.c.d r11) {
        return r6.a(r7, r8, r9, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(g r2, com.obric.agent.intents.skill.c.a r3, com.obric.aiagent.skill.ovirt.api.a.g r4, String r5, d.c.d r6) {
        return r2.a(r3, (com.obric.aiagent.skill.ovirt.api.a.g) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiagent.skill.ovirt.api.a.g.class, "com.obric.aiagent.plugin"), r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(g r2, com.obric.agent.intents.skill.c.a r3, AppEntity r4, FileEntity r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(g r2, com.obric.agent.intents.skill.c.a r3, FileEntity r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(g r2, com.obric.agent.intents.skill.c.a r3, FileEntity r4, InputStream r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(g r0, String r1, Throwable r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ Object b(g r2, com.obric.agent.intents.skill.c.a r3, a r4, int r5, d.c.d r6) {
        return r2.c(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.agent.intents.skill.a.c
    public /* synthetic */ Object a(com.obric.agent.intents.skill.c.a r3, c r4, DispatchContext r5, d.c.d r6) {
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a2((com.obric.agent.intents.skill.c.a) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.intents.skill.c.a.class, "com.obric.aiagent.plugin"), (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin"), r5, r7);
    }

    static {
        f14982a = new g();
        f14983b = "import_files";
    }

    @Override // com.obric.agent.intents.skill.a.c
    public String a() {
        return f14983b;
    }

    @Override // com.obric.agent.intents.skill.a.c
    public com.obric.agent.intents.skill.a.g<c> a(com.obric.agent.intents.skill.a.f r15) {
        o.e(r15, Ext.KEY_REQUEST);
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        g r14 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r16 = n.f((c) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r15.c(), c.class), c.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = n.c(r16);
        if (r2 == null) goto L11;
        f14982a.a("parse import_files actionArgs failed", r2);
    L11:
        if (n.b(r16) == false) goto L13;
        r16 = null;
    L13:
        c r17 = (c) ZeusTransformUtils.preCheckCast(r16, c.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L16;
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r17.a(), Collection.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L20;
    L23:
        boolean r4 = true;
    L24:
        if (r4 == false) goto L28;
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.a(new IntentResult(-2004, null, null, "files is missing", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L28:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.b(c.a(r17, null, r15.a(), 1, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L20:
        if (r3.isEmpty() == true) goto L23;
        r4 = false;
        goto L24
    L16:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.a(new IntentResult(103, null, null, "invalid import_files actionArgs", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r5 = n.f38560a;
        r16 = n.f(d.o.a(th));
        goto L7
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public Object a2(com.obric.agent.intents.skill.c.a r8, c r9, DispatchContext r10, d.c.d<? super IntentResult<Empty>> r11) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(com.obric.agent.intents.skill.a.h.f14894a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new e(r8, r9, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return com.obric.agent.intents.skill.a.d.a("System_Shell action accepted");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00fb -> B:32:0x0109). Please report as a decompilation issue!!! */
    private final Object a(com.obric.agent.intents.skill.c.a r26, c r27, long r28, d.c.d<? super IntentResult<Empty>> r30) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r30, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L7;
        f r2 = (f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.aiagent.plugin");
        if ((r2.k & Integer.MIN_VALUE) == 0) goto L7;
        r2.k -= Integer.MIN_VALUE;
        g r3 = this;
    L8:
        Object r1 = r2.i;
        Object r4 = d.c.a.b.a();
        int r5 = r2.k;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        int r6 = r2.h;
        long r7 = r2.g;
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(r2.f, Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = (Iterator) ZeusTransformUtils.preCheckCast(r2.f15004e, Iterator.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(r2.f15003d, Collection.class, "com.obric.aiagent.plugin");
        c r11 = (c) ZeusTransformUtils.preCheckCast(r2.f15002c, c.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.c.a r12 = (com.obric.agent.intents.skill.c.a) ZeusTransformUtils.preCheckCast(r2.f15001b, com.obric.agent.intents.skill.c.a.class, "com.obric.aiagent.plugin");
        g r13 = (g) ZeusTransformUtils.preCheckCast(r2.f15000a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r1);     // Catch: Exception -> L14
    L32:
        b r14 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
    L37:
        long r22 = r7;
        f r15 = r2;
        com.obric.agent.intents.skill.c.a r16 = r12;
        Iterator r17 = r9;
        Collection r24 = r10;
        Object r18 = r4;
        c r19 = r11;
        r8.add(r14);
        int r20 = r6;
        f r21 = r15;
        r7 = r22;
        Object r23 = r18;
        r10 = r24;
        Iterator r110 = r17;
        r3 = r13;
    L23:
        if (r110.hasNext() == false) goto L38;
        Object r111 = r110.next();
        int r112 = r20 + 1;
        if (r20 >= 0) goto L27;
        p.c();
    L27:
        a r113 = (a) ZeusTransformUtils.preCheckCast(r111, a.class, "com.obric.aiagent.plugin");
        g r114 = f14982a;     // Catch: Exception -> L34
        r21.f15000a = r3;     // Catch: Exception -> L34
        r21.f15001b = r16;     // Catch: Exception -> L34
        r21.f15002c = r19;     // Catch: Exception -> L34
        r21.f15003d = r10;     // Catch: Exception -> L34
        r21.f15004e = r110;     // Catch: Exception -> L34
        r21.f = r10;     // Catch: Exception -> L34
        r21.g = r7;     // Catch: Exception -> L34
        r21.h = r112;     // Catch: Exception -> L34
        r21.k = 1;     // Catch: Exception -> L34
        r1 = r114.a(r16, r113, r20, r21);     // Catch: Exception -> L34
        if (r1 != r23) goto L31;
        return r23;
    L31:
        r12 = r16;
        r2 = r21;
        r8 = r10;
        r13 = r3;
        r6 = r112;
        Iterator r25 = r110;
        r11 = r19;
        r4 = r23;
        r9 = r25;
    L34:
        e = move-exception;
        r12 = r16;
        r2 = r21;
        r8 = r10;
        r13 = r3;
        r6 = r112;
        Iterator r29 = r110;
        r11 = r19;
        r4 = r23;
        r9 = r29;
        g r115 = f14982a;
        r115.a("import file failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r14 = r115.a(1001, "import failed");
        goto L37
    L38:
        List<b> r31 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
        String r116 = com.obric.capabilitykit.common.a.a().toJson(new d(r31));     // Catch: Exception -> L42
        ILogDepend.Companion.i(TAG, "import_files done count=" + r31.size());
        IntentResult<Empty> r32 = new IntentResult(0, null, null, r116, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        r3.a(r19, r7, r32, r31);
        return r32;
    L42:
        e = move-exception;
        r3.a("serialize import_files result failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        IntentResult<Empty> r33 = new IntentResult(-2002, null, null, "serialize import_files result failed", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        r3.a(r19, r7, r33, r31);
        return r33;
    L14:
        e = move-exception;
        g r117 = f14982a;
        r117.a("import file failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r14 = r117.a(1001, "import failed");
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r1);
        List<a> r34 = r27.a();
        if (r34 != null) goto L21;
        r34 = p.b();
    L21:
        Iterable r35 = (Iterable) ZeusTransformUtils.preCheckCast(r34, Iterable.class, "com.obric.aiagent.plugin");
        Collection r36 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r35, 10)), Collection.class, "com.obric.aiagent.plugin");
        r110 = r35.iterator();
        r23 = r4;
        r10 = r36;
        r20 = 0;
        r19 = r27;
        r7 = r28;
        r21 = r2;
        r16 = r26;
    L7:
        r3 = this;
        r2 = new f(r3, r0);
        goto L8
    }

    static /* synthetic */ void a(g r6, c r7, long r8, IntentResult r10, List r11, int r12, Object r13) {
        List<b> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 8) == 0) goto L5;
        r14 = p.b();
    L5:
        r6.a(r7, r8, r10, r14);
    }

    private final void a(c r8, long r9, IntentResult<Empty> r11, List<b> r12) {
        List<b> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.e.a r0 = com.obric.agent.intents.skill.e.a.f15181a;
        String r1 = r8.b();
        long r2 = SystemClock.elapsedRealtime() - r9;
        int r4 = r11.getRet();
        List<a> r7 = r8.a();
        if (r7 != null) goto L5;
        r7 = p.b();
    L5:
        r0.c(r1, r2, r4, r7, r6);
    }

    private final Object a(com.obric.agent.intents.skill.c.a r3, a r4, int r5, d.c.d<? super b> r6) {
        d.c.d<? super b> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        String r0 = r4.getType();
        if (o.a(r0, DownloadConstants.PATH_KEY) == false) goto L7;
        return b(r3, r4, r5, r7);
    L7:
        if (o.a(r0, "entity") == false) goto L11;
        return c(r3, r4, r5, r7);
    L11:
        return a(1000, "invalid type at index=" + r5);
    }

    private final Object b(com.obric.agent.intents.skill.c.a r8, a r9, int r10, d.c.d<? super b> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, i.class) == false) goto L7;
        i r0 = (i) ZeusTransformUtils.preCheckCast(r12, i.class, "com.obric.aiagent.plugin");
        if ((r0.f15018e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f15018e -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f15016c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f15018e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r0.f15015b, String.class, "com.obric.aiagent.plugin");
        g r14 = (g) ZeusTransformUtils.preCheckCast(r0.f15014a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
        String r4 = r7;
        g this = r14;
    L36:
        com.obric.aiagent.skill.ovirt.api.a.f r15 = (com.obric.aiagent.skill.ovirt.api.a.f) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.ovirt.api.a.f.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L41;
        return this.a(1001, "import failed");
    L41:
        return this.a(r15, com.obric.aiagent.utils.b.f.f22331a.b(r4));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        String r16 = r9.b();
        if (r16 == null) goto L43;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L20;
        r16 = null;
    L20:
        if (r16 == null) goto L43;
        File r17 = a(r16);
        if (r17 == null) goto L25;
        r4 = r17.getName();
        o.a(r4);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L30;
        r4 = null;
    L30:
        if (r4 == null) goto L32;
        com.obric.aiagent.skill.ovirt.api.a.g r18 = (com.obric.aiagent.skill.ovirt.api.a.g) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.a.g.a(r17), com.obric.aiagent.skill.ovirt.api.a.g.class, "com.obric.aiagent.plugin");
        r0.f15014a = this;
        r0.f15015b = r4;
        r0.f15018e = 1;
        r13 = a(r8, r18, r4, r0);
        if (r13 != r2) goto L36;
        return r2;
    L32:
        return a(1000, "invalid path at index=" + r10);
    L25:
        return a(1000, "host path is not allowed at index=" + r10);
    L43:
        return a(1000, "path is missing at index=" + r10);
    L7:
        r0 = new i(this, r12);
        goto L8
    }

    private final File a(String r4) {
        File r0 = new File(r4);
        if (al.f19195a.a().v() == true) goto L15;
        return r0;
    L15:
        File r1 = b();     // Catch: Exception -> L12
        if (r1 != null) goto L9;
        return null;
    L9:
        File r2 = r1.getCanonicalFile();     // Catch: Exception -> L12
        File r3 = r0.getCanonicalFile();     // Catch: Exception -> L12
        g r5 = f14982a;     // Catch: Exception -> L12
        o.a(r3);     // Catch: Exception -> L12
        o.a(r2);     // Catch: Exception -> L12
        if (r5.a(r3, r2) == true) goto L18;
        return null;
    L18:
        return r3;
    L12:
        e = move-exception;
        a("resolve import host path failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    private final File b() {
        File r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getExternalFilesDir(null);
        if (r2 != null) goto L6;
        return null;
    L6:
        if (o.a(r2.getName(), "zeus_" + IAppContext.Companion.getAppName()) == true) goto L8;
        return r2;
    L8:
        return r2.getParentFile();
    }

    private final boolean a(File r5, File r6) {
        StringBuilder r4 = new StringBuilder();
        String r7 = r6.getPath();
        o.c(r7, "getPath(...)");
        String r8 = r4.append(d.o.o.c(r7, new char[]{File.separatorChar})).append(File.separator).toString();
        String r9 = r5.getPath();
        o.c(r9, "getPath(...)");
        return d.o.o.b(r9, r8, false, 2, null);
    }

    private final Object c(com.obric.agent.intents.skill.c.a r11, a r12, int r13, d.c.d<? super b> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, C0302g.class) == false) goto L7;
        C0302g r1 = (C0302g) ZeusTransformUtils.preCheckCast(r15, C0302g.class, "com.obric.aiagent.plugin");
        if ((r1.h & Integer.MIN_VALUE) == 0) goto L7;
        r1.h -= Integer.MIN_VALUE;
    L8:
        Object r16 = r1.f;
        Object r3 = d.c.a.b.a();
        int r4 = r1.h;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        int r10 = r1.f15009e;
        FileEntity r17 = (FileEntity) ZeusTransformUtils.preCheckCast(r1.f15006b, FileEntity.class, "com.obric.aiagent.plugin");
        g r18 = (g) ZeusTransformUtils.preCheckCast(r1.f15005a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L39:
        com.obric.aiagent.skill.ovirt.api.a.f r0 = (com.obric.aiagent.skill.ovirt.api.a.f) ZeusTransformUtils.preCheckCast(r16, com.obric.aiagent.skill.ovirt.api.a.f.class, "com.obric.aiagent.plugin");
        r13 = r10;
        FileEntity r19 = r17;
        g this = r18;
    L40:
        if (r0 != null) goto L44;
        return this.a(1001, "entity import failed at index=" + r13);
    L44:
        return this.a(r0, r19.getMimeType());
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = r1.f15009e;
        FileEntity r110 = (FileEntity) ZeusTransformUtils.preCheckCast(r1.f15008d, FileEntity.class, "com.obric.aiagent.plugin");
        AppEntity r111 = (AppEntity) ZeusTransformUtils.preCheckCast(r1.f15007c, AppEntity.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.c.a r112 = (com.obric.agent.intents.skill.c.a) ZeusTransformUtils.preCheckCast(r1.f15006b, com.obric.agent.intents.skill.c.a.class, "com.obric.aiagent.plugin");
        g r2 = (g) ZeusTransformUtils.preCheckCast(r1.f15005a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
        r19 = r110;
        this = r2;
        Object r5 = r16;
        AppEntity r113 = r111;
        r11 = r112;
    L33:
        r0 = (com.obric.aiagent.skill.ovirt.api.a.f) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.ovirt.api.a.f.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L40;
        r1.f15005a = this;
        r1.f15006b = r19;
        r1.f15007c = null;
        r1.f15008d = null;
        r1.f15009e = r13;
        r1.h = 2;
        Object r114 = this.a(r11, r113, r19, r1);
        if (r114 != r3) goto L38;
        return r3;
    L38:
        r18 = this;
        r10 = r13;
        FileEntity r8 = r19;
        r16 = r114;
        r17 = r8;
        goto L39
    L16:
        d.o.a(r16);
        JsonObject r115 = r12.a();
        if (r115 == null) goto L19;
        r113 = a(r115);
        if (r113 != null) goto L25;
        return a(1001, "unsupported entity at index=" + r13);
    L25:
        if (ZeusTransformUtils.instanceOf(r113, FileEntity.class) == false) goto L28;
        r19 = (FileEntity) ZeusTransformUtils.preCheckCast(r113, FileEntity.class, "com.obric.aiagent.plugin");
    L30:
        r1.f15005a = this;
        r1.f15006b = r11;
        r1.f15007c = r113;
        r1.f15008d = r19;
        r1.f15009e = r13;
        r1.h = 1;
        r5 = a(r11, r19, r1);
        if (r5 != r3) goto L33;
        return r3;
    L28:
        if (ZeusTransformUtils.instanceOf(r113, PhotoEntity.class) == false) goto L46;
        r19 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r113, PhotoEntity.class, "com.obric.aiagent.plugin")).getFile();
        goto L30
    L46:
        return a(1001, "unsupported entity at index=" + r13);
    L19:
        return a(1000, "entity is missing at index=" + r13);
    L7:
        r1 = new C0302g(this, r15);
        goto L8
    }

    private final AppEntity a(JsonObject r5) {
        JsonElement r1 = r5.get("type");     // Catch: Exception -> L21
        if (r1 == null) goto L6;
        Integer r2 = Integer.valueOf(r1.getAsInt());     // Catch: Exception -> L21
    L8:
        if (r2 != null) goto L11;
    L15:
        if (r2 != null) goto L18;
        return null;
    L18:
        if (r2.intValue() != 301) goto L27;
        AppEntity r4 = a(r5, PhotoEntity.class);     // Catch: Exception -> L21
    L25:
        return r4;
    L27:
        return null;
    L11:
        if (r2.intValue() != 801) goto L15;
        r4 = a(r5, FileEntity.class);     // Catch: Exception -> L21
        goto L25
    L6:
        r2 = null;
    L21:
        e = move-exception;
        a("parse expanded entity failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    private final <T extends AppEntity> T a(JsonObject r3, Class<T> r4) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        g r2 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r5 = n.f((AppEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r3, JsonElement.class, "com.obric.aiagent.plugin"), r4), AppEntity.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
    L8:
        if (n.c(r5) == null) goto L15;
        n.a r6 = n.f38560a;     // Catch: Throwable -> L12
        r5 = n.f((AppEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.c().fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r3, JsonElement.class, "com.obric.aiagent.plugin"), r4), AppEntity.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        n.a r7 = n.f38560a;
        r5 = n.f(d.o.a(th));
    L15:
        if (n.c(r5) == null) goto L18;
        r5 = (AppEntity) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r3, JsonElement.class, "com.obric.aiagent.plugin"), r4), AppEntity.class, "com.obric.aiagent.plugin");
    L18:
        o.c(r5, "getOrElse(...)");
        return (T) ZeusTransformUtils.preCheckCast(r5, AppEntity.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r8 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.obric.agent.intents.skill.c.a] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v15, types: [com.obric.agent.intents.skill.c.g] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.obric.agent.intents.skill.c.g] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    private final Object a(com.obric.agent.intents.skill.c.a r9, FileEntity r10, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.f> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, l.class) == false) goto L7;
        l r0 = (l) ZeusTransformUtils.preCheckCast(r12, l.class, "com.obric.aiagent.plugin");
        if ((r0.f15033e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f15033e -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f15031c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f15033e;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r0.f15030b, Closeable.class, "com.obric.aiagent.plugin");
        r9 = (g) ZeusTransformUtils.preCheckCast(r0.f15029a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r13);     // Catch: Throwable -> L14
        r9 = r9;
    L26:
        com.obric.aiagent.skill.ovirt.api.a.f r14 = (com.obric.aiagent.skill.ovirt.api.a.f) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.ovirt.api.a.f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        d.f.c.a(r8, null);     // Catch: Exception -> L35
        return r14;
    L14:
        th = th;
    L43:
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        d.f.c.a(r8, th);     // Catch: Exception -> L35
        throw th;     // Catch: Exception -> L35
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r13);
        InputStream r15 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getContentResolver().openInputStream(r10.getContentUrl());     // Catch: Exception -> L37
        if (r15 == null) goto L50;
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L37
        InputStream r4 = (InputStream) ZeusTransformUtils.preCheckCast(r16, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        g r6 = f14982a;     // Catch: Throwable -> L29
        r0.f15029a = this;     // Catch: Throwable -> L29
        r0.f15030b = r16;     // Catch: Throwable -> L29
        r0.f15033e = 1;     // Catch: Throwable -> L29
        Object r17 = r6.a(r9, r10, r4, r0);     // Catch: Throwable -> L29
        if (r17 != r2) goto L25;
        return r2;
    L25:
        r9 = this;
        r8 = r16;
        r13 = r17;
    L29:
        th = th;
        r9 = this;
        r8 = r16;
        goto L43
    L50:
        return null;
    L37:
        e = move-exception;
        r9 = this;
        e = e;
    L39:
        r9.a("content resolver import failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L35:
        e = e;
    L7:
        r0 = new l(this, r12);
        goto L8
    }

    private final Object a(com.obric.agent.intents.skill.c.a r10, AppEntity r11, FileEntity r12, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.f> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, j.class) == false) goto L7;
        j r0 = (j) ZeusTransformUtils.preCheckCast(r14, j.class, "com.obric.aiagent.plugin");
        if ((r0.f15023e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f15023e -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f15021c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f15023e;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        z.f r9 = (z.f) ZeusTransformUtils.preCheckCast(r0.f15020b, z.f.class, "com.obric.aiagent.plugin");
        g r16 = (g) ZeusTransformUtils.preCheckCast(r0.f15019a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r15);     // Catch: Exception -> L14
    L23:
        int r17 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Exception -> L14
        if (r17 == 0) goto L35;
        ILogDepend.Companion.w(TAG, "atomic capability import failed status=" + r17);     // Catch: Exception -> L14
        return null;
    L35:
        return (com.obric.aiagent.skill.ovirt.api.a.f) ZeusTransformUtils.preCheckCast(r9.f38504a, com.obric.aiagent.skill.ovirt.api.a.f.class, "com.obric.aiagent.plugin");
    L14:
        Exception e2 = e;
    L30:
        r16.a("atomic capability import failed", (Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r15);
        z.f r18 = new z.f();
        AtomicCapabilitySdk r4 = AtomicCapabilitySdk.INSTANCE;     // Catch: Exception -> L28
        Uri r6 = r12.getContentUrl();     // Catch: Exception -> L28
        m<? super InputStream, ? super d.c.d<? super x>, ? extends Object> r19 = (m) ZeusTransformUtils.preCheckCast(new k(r18, r10, r12, null), m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        r0.f15019a = this;     // Catch: Exception -> L28
        r0.f15020b = r18;     // Catch: Exception -> L28
        r0.f15023e = 1;     // Catch: Exception -> L28
        Object r110 = r4.openInputStream(r11, r6, r19, r0);     // Catch: Exception -> L28
        if (r110 != r2) goto L22;
        return r2;
    L22:
        r9 = r18;
        r15 = r110;
    L28:
        e = move-exception;
        r16 = this;
        e2 = e;
    L7:
        r0 = new j(this, r14);
        goto L8
    }

    private final Object a(com.obric.agent.intents.skill.c.a r3, FileEntity r4, InputStream r5, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.f> r6) {
        d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.f> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a(r3, (com.obric.aiagent.skill.ovirt.api.a.g) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.a.g.b(r5), com.obric.aiagent.skill.ovirt.api.a.g.class, "com.obric.aiagent.plugin"), r4.getFileName(), r7);
    }

    private final Object a(com.obric.agent.intents.skill.c.a r6, com.obric.aiagent.skill.ovirt.api.a.g r7, String r8, d.c.d<? super com.obric.aiagent.skill.ovirt.api.a.f> r9) {
        com.obric.aiagent.skill.ovirt.api.a.g r10 = (com.obric.aiagent.skill.ovirt.api.a.g) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.aiagent.skill.ovirt.api.a.g.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r11, h.class, "com.obric.aiagent.plugin");
        if ((r0.f15013d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f15013d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f15011b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f15013d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        g this = (g) ZeusTransformUtils.preCheckCast(r0.f15010a, g.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
    L17:
        com.obric.aiagent.skill.ovirt.api.b r13 = (com.obric.aiagent.skill.ovirt.api.b) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.ovirt.api.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, com.obric.aiagent.skill.ovirt.api.b.a.class) == false) goto L21;
        return (com.obric.aiagent.skill.ovirt.api.a.f) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.ovirt.api.b.a) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.ovirt.api.b.a.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.ovirt.api.a.f.class, "com.obric.aiagent.plugin");
    L21:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.aiagent.skill.ovirt.api.b.c.class) == false) goto L24;
        this.a("import file failed", ((com.obric.aiagent.skill.ovirt.api.b.c) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.ovirt.api.b.c.class, "com.obric.aiagent.plugin")).a());
        return null;
    L24:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.aiagent.skill.ovirt.api.b.C0439b.class) == false) goto L26;
        return null;
    L26:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.aiagent.skill.ovirt.api.b.d.class) == false) goto L29;
        return null;
    L29:
        throw new d.k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r12);
        IOVirtService.b r14 = r6.a().getFiles();
        String r15 = r6.b();
        r0.f15010a = this;
        r0.f15013d = 1;
        r12 = r14.a(r15, r10, r8, r0);
        if (r12 != r2) goto L17;
        return r2;
    L7:
        r0 = new h(this, r11);
        goto L8
    }

    private final b a(com.obric.aiagent.skill.ovirt.api.a.f r11, String r12) {
        String r2 = r11.b();
        Long r3 = Long.valueOf(r11.c());
        if (r12 != null) goto L5;
    L11:
        String r4 = com.obric.aiagent.utils.b.f.f22331a.b(r11.b());
    L13:
        return new b(true, r2, r3, r4, r11.a().a(), null, null, 96, null);
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r12 = null;
    L8:
        if (r12 == null) goto L11;
        r4 = r12;
        goto L13
    }

    private final b a(int r11, String r12) {
        boolean r1 = false;
        String r2 = null;
        Long r3 = null;
        String r4 = null;
        String r5 = null;
        return new b(r1, r2, r3, r4, r5, Integer.valueOf(r11), r12, 30, null);
    }

    private final void a(String r2, Throwable r3) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e(TAG, r2, r3);
        return;
    L5:
        ILogDepend.Companion.e(TAG, r2);
    }
}
