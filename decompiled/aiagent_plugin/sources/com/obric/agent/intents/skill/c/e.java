package com.obric.agent.intents.skill.c;

import android.content.Context;
import android.os.SystemClock;
import android.util.Base64;
import com.bytedance.keva.KevaImpl;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.skill.manager.api.al;
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
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.k;
import d.n;
import d.x;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: ShellExportFilesActionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.obric.agent.intents.skill.a.c<com.obric.agent.intents.skill.c.a, b> {
    private static final String TAG = "ShellExportFilesActionExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f14936a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14937b = null;

    /* JADX INFO: compiled from: ShellExportFilesActionExecutor.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(DownloadConstants.PATH_KEY)
        private final String f14938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("display_name")
        private final String f14939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("overwrite")
        private final Boolean f14940c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14938a, r6.f14938a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14939b, r6.f14939b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14940c, r6.f14940c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.f14938a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f14939b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Boolean r7 = this.f14940c;
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
            return "ExportFileRef(path=" + this.f14938a + ", displayName=" + this.f14939b + ", overwrite=" + this.f14940c + ')';
        }

        public final String a() {
            return this.f14938a;
        }

        public final String b() {
            return this.f14939b;
        }

        public final Boolean c() {
            return this.f14940c;
        }
    }

    /* JADX INFO: compiled from: ShellExportFilesActionExecutor.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(KevaImpl.PrivateConstants.FILES_DIR_NAME)
        private final List<a> f14941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14942b;

        public static /* synthetic */ b a(b r1, List r2, String r3, int r4, Object r5) {
            List<a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r6 = r1.f14941a;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = r1.f14942b;
        L9:
            return r1.a(r6, r3);
        }

        public final b a(List<a> r2, String r3) {
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
            if (o.a(this.f14941a, r6.f14941a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14942b, r6.f14942b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            List<a> r0 = this.f14941a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f14942b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "ExportFilesActionRequest(files=" + this.f14941a + ", uniqueId=" + this.f14942b + ')';
        }

        public b(List<a> r3, String r4) {
            List<a> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "uniqueId");
            this.f14941a = r5;
            this.f14942b = r4;
        }

        public final List<a> a() {
            return this.f14941a;
        }

        public final String b() {
            return this.f14942b;
        }
    }

    /* JADX INFO: compiled from: ShellExportFilesActionExecutor.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final File f14945c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f14946d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14943a, r6.f14943a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14944b, r6.f14944b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14945c, r6.f14945c) == true) goto L18;
            return false;
        L18:
            if (this.f14946d == r6.f14946d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f14943a.hashCode() * 31) + this.f14944b.hashCode()) * 31) + this.f14945c.hashCode()) * 31) + Boolean.hashCode(this.f14946d);
        }

        public String toString() {
            return "ExportPlan(sourcePath=" + this.f14943a + ", absolutePath=" + this.f14944b + ", destinationFile=" + this.f14945c + ", overwrite=" + this.f14946d + ')';
        }

        public c(String r2, String r3, File r4, boolean r5) {
            o.e(r2, "sourcePath");
            o.e(r3, "absolutePath");
            o.e(r4, "destinationFile");
            this.f14943a = r2;
            this.f14944b = r3;
            this.f14945c = r4;
            this.f14946d = r5;
        }

        public final String a() {
            return this.f14943a;
        }

        public final String b() {
            return this.f14944b;
        }

        public final File c() {
            return this.f14945c;
        }

        public final boolean d() {
            return this.f14946d;
        }
    }

    /* JADX INFO: compiled from: ShellExportFilesActionExecutor.kt */
    private static abstract class d {

        /* JADX INFO: compiled from: ShellExportFilesActionExecutor.kt */
        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f14947a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f14948b;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
                if (this.f14947a == r6.f14947a) goto L12;
                return false;
            L12:
                if (o.a(this.f14948b, r6.f14948b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (Integer.hashCode(this.f14947a) * 31) + this.f14948b.hashCode();
            }

            public String toString() {
                return "Failure(code=" + this.f14947a + ", message=" + this.f14948b + ')';
            }

            public final int a() {
                return this.f14947a;
            }

            public final String b() {
                return this.f14948b;
            }

            public a(int r2, String r3) {
                o.e(r3, "message");
                super(null);
                this.f14947a = r2;
                this.f14948b = r3;
            }
        }

        /* JADX INFO: compiled from: ShellExportFilesActionExecutor.kt */
        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final c f14949a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
                if (o.a(this.f14949a, r6.f14949a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f14949a.hashCode();
            }

            public String toString() {
                return "Success(plan=" + this.f14949a + ')';
            }

            public b(c r2) {
                o.e(r2, "plan");
                super(null);
                this.f14949a = r2;
            }

            public final c a() {
                return this.f14949a;
            }
        }

        public /* synthetic */ d(d.h.b.h r1) {
            this();
        }

        private d() {
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.intents.skill.c.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShellExportFilesActionExecutor.kt */
    @d.c.b.a.f(b = "ShellExportFilesActionExecutor.kt", c = {92}, d = "invokeSuspend", e = "com.obric.agent.intents.skill.systemshell.ShellExportFilesActionExecutor$execute$2")
    static final class C0301e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f14950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DispatchContext f14952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.intents.skill.c.a f14953d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f14954e;
        private /* synthetic */ Object f;

        C0301e(DispatchContext r3, com.obric.agent.intents.skill.c.a r4, b r5, d.c.d<? super C0301e> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14952c = r3;
            this.f14953d = r4;
            this.f14954e = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0301e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0301e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            C0301e r0 = new C0301e(this.f14952c, this.f14953d, this.f14954e, r7);
            r0.f = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14951b;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            long r2 = this.f14950a;
            d.o.a(r14);     // Catch: Throwable -> L8
        L17:
            Object r15 = n.f((IntentResult) ZeusTransformUtils.preCheckCast(r14, IntentResult.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        L22:
            long r6 = r2;
            b r5 = this.f14954e;
            Throwable r3 = n.c(r15);
            Object r16 = r15;
            if (r3 == null) goto L26;
            e.a(e.f14936a, "export_files async final failed", "export_files async final failed", r3);
            IntentResult r17 = e.a(e.f14936a, "export failed");
            e.a(e.f14936a, r5, r6, r17, null, 8, null);
            r16 = r17;
        L26:
            IntentResult<?> r18 = (IntentResult) ZeusTransformUtils.preCheckCast(r16, IntentResult.class, "com.obric.aiagent.plugin");
            AtomicCapabilitySdk.INSTANCE.updateIntentResult(r18, this.f14952c, true);
            return x.f38692a;
        L8:
            th = th;
        L21:
            n.a r4 = n.f38560a;
            r15 = n.f(d.o.a(th));
            goto L22
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            d.o.a(r14);
            am r19 = (am) ZeusTransformUtils.preCheckCast(this.f, am.class, "com.obric.aiagent.plugin");
            long r11 = SystemClock.elapsedRealtime();
            com.obric.agent.intents.skill.c.a r7 = this.f14953d;
            b r8 = this.f14954e;
            DispatchContext r9 = this.f14952c;
            n.a r110 = n.f38560a;     // Catch: Throwable -> L19
            e r10 = e.f14936a;     // Catch: Throwable -> L19
            this.f14950a = r11;     // Catch: Throwable -> L19
            this.f14951b = 1;     // Catch: Throwable -> L19
            r14 = e.a(r10, r7, r8, r9, r11, this);     // Catch: Throwable -> L19
            if (r14 != r0) goto L16;
            return r0;
        L16:
            r2 = r11;
        L19:
            th = th;
            r2 = r11;
            goto L21
        }
    }

    /* JADX INFO: compiled from: ShellExportFilesActionExecutor.kt */
    @d.c.b.a.f(b = "ShellExportFilesActionExecutor.kt", c = {160}, d = "executeExportFiles", e = "com.obric.agent.intents.skill.systemshell.ShellExportFilesActionExecutor")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14957c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f14958d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f14959e;
        Object f;
        Object g;
        long h;
        int i;
        /* synthetic */ Object j;
        final /* synthetic */ e k;
        int l;

        f(e r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.j = r8;
            this.l |= Integer.MIN_VALUE;
            return e.a(this.k, null, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShellExportFilesActionExecutor.kt */
    @d.c.b.a.f(b = "ShellExportFilesActionExecutor.kt", c = {258}, d = "exportOne", e = "com.obric.agent.intents.skill.systemshell.ShellExportFilesActionExecutor")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f14962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f14963d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14964e;

        g(e r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14963d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14962c = r3;
            this.f14964e |= Integer.MIN_VALUE;
            return e.a(this.f14963d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private e() {
    }

    public static final /* synthetic */ IntentResult a(e r0, String r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object a(e r7, com.obric.agent.intents.skill.c.a r8, b r9, DispatchContext r10, long r11, d.c.d r13) {
        return r7.a(r8, r9, r10, r11, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(e r2, com.obric.agent.intents.skill.c.a r3, c r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(e r0, String r1, String r2, Throwable r3) {
        r0.a(r1, r2, r3);
    }

    @Override // com.obric.agent.intents.skill.a.c
    public /* synthetic */ Object a(com.obric.agent.intents.skill.c.a r3, b r4, DispatchContext r5, d.c.d r6) {
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return a2((com.obric.agent.intents.skill.c.a) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.intents.skill.c.a.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin"), r5, r7);
    }

    static {
        f14936a = new e();
        f14937b = "export_files";
    }

    @Override // com.obric.agent.intents.skill.a.c
    public String a() {
        return f14937b;
    }

    @Override // com.obric.agent.intents.skill.a.c
    public com.obric.agent.intents.skill.a.g<b> a(com.obric.agent.intents.skill.a.f r5) {
        o.e(r5, Ext.KEY_REQUEST);
        b r4 = (b) ZeusTransformUtils.preCheckCast(com.obric.agent.intents.skill.a.e.f14888a.a(r5.c(), b.class, TAG), b.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r4.a(), Collection.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L17;
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.a(com.obric.agent.intents.skill.c.f.f14965a.b(-2004, "files is missing")), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L17:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.b(b.a(r4, null, r5.a(), 1, null)), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    L9:
        if (r0.isEmpty() == true) goto L12;
        r1 = false;
        goto L13
    L5:
        return (com.obric.agent.intents.skill.a.g) ZeusTransformUtils.preCheckCast(new com.obric.agent.intents.skill.a.g.a(com.obric.agent.intents.skill.c.f.f14965a.b(103, "invalid export_files actionArgs")), com.obric.agent.intents.skill.a.g.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public Object a2(com.obric.agent.intents.skill.c.a r8, b r9, DispatchContext r10, d.c.d<? super IntentResult<Empty>> r11) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(com.obric.agent.intents.skill.a.h.f14894a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new C0301e(r10, r8, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return com.obric.agent.intents.skill.a.d.a("System_Shell action accepted");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x016f -> B:46:0x01f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x01c7 -> B:45:0x01d7). Please report as a decompilation issue!!! */
    private final Object a(com.obric.agent.intents.skill.c.a r22, b r23, DispatchContext r24, long r25, d.c.d<? super IntentResult<Empty>> r27) {
        e r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, f.class) == false) goto L7;
        f r3 = (f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin");
        if ((r3.l & Integer.MIN_VALUE) == 0) goto L7;
        r3.l -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.j;
        Object r4 = d.c.a.b.a();
        int r5 = r3.l;
        String r6 = TAG;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r7 = r3.i;
        long r8 = r3.h;
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r3.g, Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = (Iterator) ZeusTransformUtils.preCheckCast(r3.f, Iterator.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(r3.f14959e, Collection.class, "com.obric.aiagent.plugin");
        File r12 = (File) ZeusTransformUtils.preCheckCast(r3.f14958d, File.class, "com.obric.aiagent.plugin");
        b r13 = (b) ZeusTransformUtils.preCheckCast(r3.f14957c, b.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.c.a r14 = (com.obric.agent.intents.skill.c.a) ZeusTransformUtils.preCheckCast(r3.f14956b, com.obric.agent.intents.skill.c.a.class, "com.obric.aiagent.plugin");
        e r15 = (e) ZeusTransformUtils.preCheckCast(r3.f14955a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        String r16 = TAG;
        Collection r17 = r11;
        Iterator r18 = r10;
    L45:
        com.obric.agent.intents.skill.c.a r19 = r14;
        int r110 = r7;
        r0 = r15;
        f r20 = r3;
        com.obric.agent.intents.skill.c.a r21 = r19;
        Collection r111 = r17;
        com.obric.agent.intents.skill.c.f.d r26 = (com.obric.agent.intents.skill.c.f.d) ZeusTransformUtils.preCheckCast(r2, com.obric.agent.intents.skill.c.f.d.class, "com.obric.aiagent.plugin");
        b r28 = r13;
        File r112 = r12;
        Iterator r113 = r18;
        Collection r114 = r111;
        long r115 = r8;
        Object r29 = r4;
        Collection r30 = r9;
        long r31 = r115;
    L46:
        r30.add(r26);
        r30 = r114;
        r18 = r113;
        r12 = r112;
        int r116 = r110;
        r6 = r16;
    L32:
        if (r18.hasNext() == false) goto L49;
        Object r117 = r18.next();
        r110 = r116 + 1;
        if (r116 >= 0) goto L36;
        p.c();
    L36:
        a r118 = (a) ZeusTransformUtils.preCheckCast(r117, a.class, "com.obric.aiagent.plugin");
        e r119 = f14936a;
        d r120 = r119.a(r21, r12, r118, r116);
        if (ZeusTransformUtils.instanceOf(r120, d.a.class) == false) goto L39;
        r16 = r6;
        r26 = com.obric.agent.intents.skill.c.f.f14965a.a(((d.a) ZeusTransformUtils.preCheckCast(r120, d.a.class, "com.obric.aiagent.plugin")).a(), ((d.a) ZeusTransformUtils.preCheckCast(r120, d.a.class, "com.obric.aiagent.plugin")).b());
        r112 = r12;
        r113 = r18;
        r114 = r30;
        goto L46
    L39:
        r16 = r6;
        if (ZeusTransformUtils.instanceOf(r120, d.b.class) == false) goto L48;
        c r32 = ((d.b) ZeusTransformUtils.preCheckCast(r120, d.b.class, "com.obric.aiagent.plugin")).a();
        r20.f14955a = r0;
        r20.f14956b = r21;
        r20.f14957c = r28;
        r20.f14958d = r12;
        r20.f14959e = r30;
        r20.f = r18;
        r20.g = r30;
        r20.h = r31;
        r20.i = r110;
        r20.l = 1;
        Object r33 = r119.a(r21, r32, r20);
        if (r33 != r29) goto L44;
        return r29;
    L44:
        r13 = r28;
        r2 = r33;
        r17 = r30;
        f r121 = r20;
        r15 = r0;
        r7 = r110;
        r14 = r21;
        r3 = r121;
        long r122 = r31;
        r4 = r29;
        r8 = r122;
        r9 = r17;
        goto L45
    L48:
        throw new k();
    L49:
        String r123 = r6;
        List<com.obric.agent.intents.skill.c.f.d> r34 = (List) ZeusTransformUtils.preCheckCast(r30, List.class, "com.obric.aiagent.plugin");
        if (IAppContext.Companion.isDebug() == false) goto L52;
        ILogDepend.Companion.i(r123, "export_files done uniqueId=" + r28.b() + " count=" + r34.size());
    L53:
        IntentResult<Empty> r35 = com.obric.agent.intents.skill.c.f.f14965a.a(r34);
        r0.a(r28, r31, r35, r34);
        return r35;
    L52:
        ILogDepend.Companion.i(r123, "export_files done count=" + r34.size());
        goto L53
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        List<a> r36 = r23.a();
        if (r36 != null) goto L17;
        r36 = p.b();
    L17:
        File r37 = r0.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r24.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r23.b());
        if (r37 != null) goto L22;
        IntentResult<Empty> r38 = r0.a("external cache dir unavailable");
        a(this, r23, r25, r38, null, 8, null);
        return r38;
    L22:
        if (r37.exists() == false) goto L24;
    L30:
        Iterable r39 = (Iterable) ZeusTransformUtils.preCheckCast(r36, Iterable.class, "com.obric.aiagent.plugin");
        Collection r40 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r39, 10)), Collection.class, "com.obric.aiagent.plugin");
        r18 = r39.iterator();
        r12 = r37;
        r30 = r40;
        r116 = 0;
        r28 = r23;
        r20 = r3;
        r29 = r4;
        r21 = r22;
        r31 = r25;
        goto L32
    L24:
        if (r37.mkdirs() == true) goto L30;
        if (IAppContext.Companion.isDebug() == false) goto L28;
        ILogDepend.Companion.e(TAG, "create export directory failed path=" + r37.getAbsolutePath());
    L28:
        IntentResult<Empty> r41 = r0.a("export failed");
        a(this, r23, r25, r41, null, 8, null);
        return r41;
    L7:
        r3 = new f(r0, r1);
        goto L8
    }

    static /* synthetic */ void a(e r6, b r7, long r8, IntentResult r10, List r11, int r12, Object r13) {
        List<com.obric.agent.intents.skill.c.f.d> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 8) == 0) goto L5;
        r14 = p.b();
    L5:
        r6.a(r7, r8, r10, r14);
    }

    private final void a(b r8, long r9, IntentResult<Empty> r11, List<com.obric.agent.intents.skill.c.f.d> r12) {
        List<com.obric.agent.intents.skill.c.f.d> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.e.a r0 = com.obric.agent.intents.skill.e.a.f15181a;
        String r1 = r8.b();
        long r2 = SystemClock.elapsedRealtime() - r9;
        int r4 = r11.getRet();
        List<a> r7 = r8.a();
        if (r7 != null) goto L5;
        r7 = p.b();
    L5:
        r0.b(r1, r2, r4, r7, r6);
    }

    private final d a(com.obric.agent.intents.skill.c.a r10, File r11, a r12, int r13) {
        String r0 = r12.a();
        if (r0 == null) goto L32;
        Object r5 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L32;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L12
        Object r14 = n.f(((e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin")).a(r10, r0));     // Catch: Throwable -> L12
    L14:
        Throwable r4 = n.c(r14);
        if (r4 == null) goto L18;
        f14936a.a("reject export path", "reject export path=" + r0, r4);
    L18:
        if (n.b(r14) == true) goto L21;
        r5 = r14;
    L21:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L24;
        File r16 = a(r11, a(r15, r12.b()));
        if (r16 != null) goto L30;
        return (d) ZeusTransformUtils.preCheckCast(a(1000, "invalid display_name at index=" + r13), d.class, "com.obric.aiagent.plugin");
    L30:
        return (d) ZeusTransformUtils.preCheckCast(new d.b(new c(r0, r15, r16, o.a(r12.c(), true))), d.class, "com.obric.aiagent.plugin");
    L24:
        return (d) ZeusTransformUtils.preCheckCast(a(1000, "invalid path at index=" + r13), d.class, "com.obric.aiagent.plugin");
    L12:
        th = move-exception;
        n.a r6 = n.f38560a;
        r14 = n.f(d.o.a(th));
    L32:
        return (d) ZeusTransformUtils.preCheckCast(a(1000, "path is missing at index=" + r13), d.class, "com.obric.aiagent.plugin");
    }

    private final Object a(com.obric.agent.intents.skill.c.a r19, c r20, d.c.d<? super com.obric.agent.intents.skill.c.f.d> r21) {
        e r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, g.class) == false) goto L7;
        g r3 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.aiagent.plugin");
        if ((r3.f14964e & Integer.MIN_VALUE) == 0) goto L7;
        r3.f14964e -= Integer.MIN_VALUE;
    L8:
        g r11 = r3;
        Object r2 = r11.f14962c;
        Object r4 = d.c.a.b.a();
        int r5 = r11.f14964e;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        c r6 = (c) ZeusTransformUtils.preCheckCast(r11.f14961b, c.class, "com.obric.aiagent.plugin");
        e r7 = (e) ZeusTransformUtils.preCheckCast(r11.f14960a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        c r14 = r6;
        r0 = r7;
    L23:
        com.obric.aiagent.skill.ovirt.api.b r8 = (com.obric.aiagent.skill.ovirt.api.b) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.ovirt.api.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.ovirt.api.b.a.class) == false) goto L28;
        com.obric.aiagent.skill.ovirt.api.a.e r9 = (com.obric.aiagent.skill.ovirt.api.a.e) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.ovirt.api.b.a) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.ovirt.api.b.a.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.ovirt.api.a.e.class, "com.obric.aiagent.plugin");
        com.obric.agent.intents.skill.c.f r10 = com.obric.agent.intents.skill.c.f.f14965a;
        String r12 = r9.b();
        String r13 = com.obric.aiagent.utils.b.f.f22331a.a(r9.b());
        long r15 = r9.c();
        String r16 = com.obric.aiagent.utils.b.f.f22331a.b(r9.b());
        String r17 = r14.a();
        String r18 = r9.a().getAbsolutePath();
        o.c(r18, "getAbsolutePath(...)");
        return r10.a(r12, r13, r15, r16, r17, r18, r0.a(r9.a(), r9.b(), new File(r14.c().getParentFile(), "video_covers")));
    L28:
        if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.ovirt.api.b.C0439b.class) == false) goto L30;
    L36:
        Throwable r22 = null;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.ovirt.api.b.c.class) == false) goto L39;
        com.obric.aiagent.skill.ovirt.api.b.c r23 = (com.obric.aiagent.skill.ovirt.api.b.c) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.ovirt.api.b.c.class, "com.obric.aiagent.plugin");
    L40:
        if (r23 == null) goto L42;
        r22 = r23.a();
    L42:
        if (r22 == null) goto L45;
        r0.a("export file failed", "export file failed path=" + r14.b(), r22);
    L45:
        return com.obric.agent.intents.skill.c.f.f14965a.a(1001, "export failed");
    L39:
        r23 = null;
        goto L40
    L30:
        if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.ovirt.api.b.d.class) == true) goto L36;
        if (ZeusTransformUtils.instanceOf(r8, com.obric.aiagent.skill.ovirt.api.b.c.class) == true) goto L36;
        throw new k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        if (r20.d() == false) goto L17;
    L20:
        IOVirtService.b r24 = r19.a().getFiles();
        String r25 = r19.b();
        String r26 = r20.b();
        com.obric.aiagent.skill.ovirt.api.a.d r27 = (com.obric.aiagent.skill.ovirt.api.a.d) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.ovirt.api.a.d.b(r20.c()), com.obric.aiagent.skill.ovirt.api.a.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.ovirt.api.a.c r28 = new com.obric.aiagent.skill.ovirt.api.a.c(false, r20.d(), false, 5, null);
        r11.f14960a = r0;
        r14 = r20;
        r11.f14961b = r14;
        r11.f14964e = 1;
        r2 = IOVirtService.b.a.a(r24, r25, r26, r27, r28, false, null, r11, 48, null);
        if (r2 != r4) goto L23;
        return r4;
    L17:
        if (r20.c().exists() == false) goto L20;
        return com.obric.agent.intents.skill.c.f.f14965a.a(1002, "destination already exists");
    L7:
        r3 = new g(r0, r1);
        goto L8
    }

    private final com.obric.agent.intents.skill.c.f.a a(File r5, String r6, File r7) {
        if (al.f19195a.a().u() == true) goto L5;
        return null;
    L5:
        String r1 = com.obric.aiagent.utils.b.f.f22331a.b(r6);
        n.a r3 = n.f38560a;     // Catch: Throwable -> L19
        e r4 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (com.obric.aiagent.utils.b.f.f22331a.c(r1) == false) goto L12;
        com.obric.aiagent.utils.b.a r8 = com.obric.aiagent.utils.b.b.f22315a.a(r5);     // Catch: Throwable -> L19
        if (r8 == null) goto L16;
        com.obric.agent.intents.skill.c.f.b r9 = r4.a(r8);     // Catch: Throwable -> L19
    L17:
        Object r10 = n.f(r9);     // Catch: Throwable -> L19
    L21:
        Throwable r11 = n.c(r10);
        if (r11 == null) goto L25;
        f14936a.a("extract media info failed", "extract media info failed file=" + r5.getAbsolutePath(), r11);
    L25:
        if (n.b(r10) == false) goto L27;
        r10 = null;
    L27:
        com.obric.agent.intents.skill.c.f.b r12 = (com.obric.agent.intents.skill.c.f.b) ZeusTransformUtils.preCheckCast(r10, com.obric.agent.intents.skill.c.f.b.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L30;
        return null;
    L30:
        return new com.obric.agent.intents.skill.c.f.a(r12);
    L16:
        r9 = null;
        goto L17
    L12:
        if (com.obric.aiagent.utils.b.f.f22331a.d(r1) == false) goto L16;
        com.obric.aiagent.utils.b.e r13 = com.obric.aiagent.utils.b.b.f22315a.a(r5, r4.a(r6, r7, com.obric.aiagent.utils.b.c.f22318a.a()), com.obric.aiagent.utils.b.c.f22318a.a());     // Catch: Throwable -> L19
        if (r13 == null) goto L16;
        r9 = r4.a(r13);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        n.a r14 = n.f38560a;
        r10 = n.f(d.o.a(th));
        goto L21
    }

    private final File a(String r4, File r5, com.obric.aiagent.utils.b.c r6) {
        if (r5.exists() == true) goto L9;
        if (r5.mkdirs() == true) goto L9;
        return null;
    L9:
        return new File(r5, d.o.o.c(r4, '.', r4) + "_cover_" + new SimpleDateFormat("yyMMdd_HHmmss", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis())) + '.' + r6.b());
    }

    private final com.obric.agent.intents.skill.c.f.b a(com.obric.aiagent.utils.b.a r9) {
        String r1 = "image";
        return new com.obric.agent.intents.skill.c.f.b(r1, Integer.valueOf(r9.a()), Integer.valueOf(r9.b()), null, null, 24, null);
    }

    private final com.obric.agent.intents.skill.c.f.b a(com.obric.aiagent.utils.b.e r7) {
        Integer r2 = r7.a();
        Integer r3 = r7.b();
        Long r4 = r7.c();
        com.obric.aiagent.utils.b.d r6 = r7.d();
        if (r6 == null) goto L5;
        String r0 = r6.b();
        String r1 = r6.a().getAbsolutePath();
        o.c(r1, "getAbsolutePath(...)");
        com.obric.agent.intents.skill.c.f.c r5 = new com.obric.agent.intents.skill.c.f.c(r0, r1, r6.c(), r6.d());
    L7:
        return new com.obric.agent.intents.skill.c.f.b("video", r2, r3, r4, r5);
    L5:
        r5 = null;
        goto L7
    }

    private final IntentResult<Empty> a(String r15) {
        ILogDepend.Companion.e(TAG, r15);
        return new IntentResult(-2002, null, null, r15, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    }

    private final void a(String r2, String r3, Throwable r4) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        ILogDepend.Companion.e(TAG, r3, r4);
        return;
    L5:
        ILogDepend.Companion.e(TAG, r2);
    }

    private final String a(com.obric.agent.intents.skill.c.a r5, String r6) {
        if (o.a(r6, "~") == false) goto L6;
        return y.a(r5.c(), null, 1, null).a();
    L6:
        if (d.o.o.b(r6, "~/", false, 2, null) == false) goto L9;
        return r5.c().a(d.o.o.a(r6, (CharSequence) ZeusTransformUtils.preCheckCast("~/", CharSequence.class, "com.obric.aiagent.plugin"))).a();
    L9:
        if (d.o.o.b(r6, "/", false, 2, null) == false) goto L12;
        return r5.c().c(r6).a();
    L12:
        return r5.c().a(r6).a();
    }

    private final String a(String r3, String r4) {
        String r2 = d.o.o.c(r3, '/', null, 2, null);
        if (r4 != null) goto L5;
    L16:
        return r2;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L16;
        String r5 = com.obric.aiagent.utils.b.f.f22331a.a(r2);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.aiagent.utils.b.f.f22331a.a(r4), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L13;
        return r4;
    L13:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L15;
        return r4;
    L15:
        return r4 + '.' + r5;
    }

    private final File a(File r1, String r2) {
        File r0 = new File(r1, r2);
        File r3 = r1.getCanonicalFile();
        File r4 = r0.getCanonicalFile();
        if (o.a(r4.getParentFile(), r3) == true) goto L7;
        return null;
    L7:
        return r4;
    }

    private final d.a a(int r1, String r2) {
        return new d.a(r1, r2);
    }

    private final File a(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r6 = r0;
    L6:
        File r7 = r6.getExternalCacheDir();
        if (r7 != null) goto L11;
        return null;
    L11:
        return new File(new File(r7, "omni_exports"), b(r5));
    }

    private final String b(String r1) {
        byte[] r0 = r1.getBytes(d.o.d.f38623b);
        o.c(r0, "getBytes(...)");
        String r2 = Base64.encodeToString(r0, 11);
        o.c(r2, "encodeToString(...)");
        return r2;
    }
}
