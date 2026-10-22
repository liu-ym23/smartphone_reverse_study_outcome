package com.obric.autogui.agents.vlm.models.omni.upload.b;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.agents.vlm.models.omni.upload.n;
import com.obric.autogui.agents.vlm.models.omni.upload.v;
import com.obric.autogui.common.a.h;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.f.k;
import d.g;
import d.h.a.m;
import d.h.b.o;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: OmniUploadViewTreeLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "OmniUploadVTLogger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f28614a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f28615b = null;

    /* JADX INFO: compiled from: OmniUploadViewTreeLogger.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f28616a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f28616a == r6.f28616a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f28616a);
        }

        public String toString() {
            return "OmniUploadViewTreeSaveResult(isNewFile=" + this.f28616a + ')';
        }

        public a(boolean r1) {
            this.f28616a = r1;
        }
    }

    /* JADX INFO: compiled from: OmniUploadViewTreeLogger.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f28618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final File f28619c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f28617a, r6.f28617a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f28618b, r6.f28618b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f28619c, r6.f28619c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f28617a.hashCode() * 31) + this.f28618b.hashCode()) * 31) + this.f28619c.hashCode();
        }

        public String toString() {
            return "UploadTarget(taskId=" + this.f28617a + ", toolId=" + this.f28618b + ", journalDir=" + this.f28619c + ')';
        }

        public b(String r2, String r3, File r4) {
            o.e(r2, DBDefinition.TASK_ID);
            o.e(r3, "toolId");
            o.e(r4, "journalDir");
            this.f28617a = r2;
            this.f28618b = r3;
            this.f28619c = r4;
        }

        public final String a() {
            return this.f28617a;
        }

        public final String b() {
            return this.f28618b;
        }

        public final File c() {
            return this.f28619c;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.omni.upload.b.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OmniUploadViewTreeLogger.kt */
    @d.c.b.a.f(b = "OmniUploadViewTreeLogger.kt", c = {62}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.viewtree.OmniUploadViewTreeLogger$saveInferenceViewTree$4")
    static final class C0716c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f28621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<ViewHierarchyDump> f28622c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f28623d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f28624e;
        final /* synthetic */ Closeable f;

        C0716c(b r3, List<ViewHierarchyDump> r4, String r5, int r6, Closeable r7, d.c.d<? super C0716c> r8) {
            List<ViewHierarchyDump> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            Closeable r10 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r7, Closeable.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28621b = r3;
            this.f28622c = r9;
            this.f28623d = r5;
            this.f28624e = r6;
            this.f = r10;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0716c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0716c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0716c(this.f28621b, this.f28622c, this.f28623d, this.f28624e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v4, types: [d.x, java.lang.Object] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28620a;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r9);     // Catch: Throwable -> L7
        L15:
            this.f.close();
            C0716c this = x.f38692a;
            return this;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r9);
            c r2 = c.f28614a;     // Catch: Throwable -> L7
            b r10 = this.f28621b;     // Catch: Throwable -> L7
            List<ViewHierarchyDump> r3 = this.f28622c;     // Catch: Throwable -> L7
            String r4 = this.f28623d;     // Catch: Throwable -> L7
            int r5 = this.f28624e;     // Catch: Throwable -> L7
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.f28620a = 1;     // Catch: Throwable -> L7
            if (c.a(r2, r10, r3, r4, r5, r6) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            this.f.close();
            throw th;
        }
    }

    /* JADX INFO: compiled from: OmniUploadViewTreeLogger.kt */
    @d.c.b.a.f(b = "OmniUploadViewTreeLogger.kt", c = {104}, d = "saveInferenceViewTreeBlocking", e = "com.obric.autogui.agents.vlm.models.omni.upload.viewtree.OmniUploadViewTreeLogger")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f28627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f28628d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f28629e;
        int f;

        d(c r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28629e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f28628d = r7;
            this.f |= Integer.MIN_VALUE;
            return c.a(this.f28629e, null, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ com.obric.autogui.agents.vlm.models.omni.upload.b.a lambda$BwgW5FKzo1ganv55pnvtnBeEuOs() {
        return b();
    }

    public static /* synthetic */ a lambda$yEZtjVAVfL0hrnp5VSGMz_KHZqI(File r0, String r1, byte[] r2, String r3) {
        return a(r0, r1, r2, r3);
    }

    private c() {
    }

    public static final /* synthetic */ Object a(c r8, b r9, List r10, String r11, int r12, d.c.d r13) {
        return r8.a(r9, (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin"), r11, r12, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f28614a = new c();
        f28615b = g.a($$Lambda$c$BwgW5FKzo1ganv55pnvtnBeEuOs.INSTANCE);
    }

    private final com.obric.autogui.agents.vlm.models.omni.upload.b.a a() {
        return (com.obric.autogui.agents.vlm.models.omni.upload.b.a) ZeusTransformUtils.preCheckCast(f28615b.b(), com.obric.autogui.agents.vlm.models.omni.upload.b.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autogui.agents.vlm.models.omni.upload.b.a b() {
        return new com.obric.autogui.agents.vlm.models.omni.upload.b.a();
    }

    public final void a(com.obric.autogui.session.a r13, List<ViewHierarchyDump> r14, String r15, int r16, String r17) {
        String r1 = r17;
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        o.e(r13, SensitiveType.SESSION);
        o.e(r15, "stepId");
        if (h.f28984a.a() == true) goto L6;
        return;
    L6:
        if (com.obric.autogui.agents.vlm.models.omni.upload.d.a(r13, TAG) == true) goto L8;
        return;
    L8:
        String r5 = r13.b();
        List r7 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L12;
        r5 = null;
    L12:
        if (r1 != null) goto L14;
    L16:
        r1 = null;
    L18:
        if (r5 == null) goto L45;
        if (r1 == null) goto L45;
        if (r2 != null) goto L23;
    L25:
        if (r7 == null) goto L27;
        b r6 = a(r13, r5, r1);
        if (r6 != null) goto L33;
        return;
    L33:
        Closeable r3 = v.f28855a.e(r5);
        if (r3 == null) goto L36;
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new C0716c(r6, r7, r15, r16, r3, null), m.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L41
        return;
    L41:
        th = move-exception;
        r3.close();
        throw th;
    L36:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L51;
        Loog.INSTANCE.i(TAG, "skip saving view tree after producer barrier closed, taskId=" + r5);
        return;
    L51:
        return;
    L27:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L50;
        Loog.INSTANCE.w(TAG, "skip saving view tree, taskId=" + r5 + ", toolId=" + r1 + ", viewHierarchy is empty");
        return;
    L50:
        return;
    L23:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L25;
        r7 = r2;
    L45:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L52;
        Loog.INSTANCE.w(TAG, "skip saving view tree, taskId=" + r5 + ", toolId=" + r1);
        return;
    L52:
        return;
    L14:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L16;
        goto L16
    }

    private final Object a(b r18, List<ViewHierarchyDump> r19, String r20, int r21, d.c.d<? super x> r22) {
        List<ViewHierarchyDump> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L7;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        if ((r3.f & Integer.MIN_VALUE) == 0) goto L7;
        r3.f -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.f28628d;
        Object r5 = d.c.a.b.a();
        int r6 = r3.f;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        long r7 = r3.f28627c;
        byte[] r1 = (byte[]) ZeusTransformUtils.preCheckCast(r3.f28626b, byte[].class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r3.f28625a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L14
    L37:
        if (((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin")) == null) goto L39;
        long r9 = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L14
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L51;
        Loog.INSTANCE.d(TAG, "fileName=" + r8 + ", size=" + r1.length + ", l=" + (r9 - r7) + "ms");     // Catch: Throwable -> L14
    L51:
        return x.f38692a;
    L39:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L42;
        Loog.INSTANCE.w(TAG, "failed to write view tree, fileName=" + r8);     // Catch: Throwable -> L14
    L42:
        return x.f38692a;
    L14:
        th = th;
    L49:
        OmniDataFeedbackLog.INSTANCE.e(TAG, "failed to save view tree, fileName=" + r8, th);
        goto L51
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r4);
        String r10 = r18.a();
        String r12 = r18.b();
        String r11 = com.obric.autogui.agents.vlm.models.omni.upload.b.d.f28630a.a(r0);
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L21;
    L24:
        boolean r14 = true;
    L25:
        if (r14 == true) goto L27;
        com.obric.autogui.agents.vlm.models.omni.a.g r15 = (com.obric.autogui.agents.vlm.models.omni.a.g) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.vlm.models.omni.upload.b.b.f28610b, com.obric.autogui.agents.vlm.models.omni.a.g.class, "com.obric.aiagent.plugin");
        String r16 = String.format("%03d", Arrays.copyOf(new Object[]{d.c.b.a.b.a(r21)}, 1));
        o.c(r16, "format(...)");
        String r17 = com.obric.autogui.agents.vlm.models.omni.a.g.a(r15, r16, r10, r12, r20, null, 16, null);
        long r23 = AOSystemTools.INSTANCE.nowTimeMillis();
        r1 = r11.getBytes(d.o.d.f38623b);     // Catch: Throwable -> L47
        o.c(r1, "getBytes(...)");     // Catch: Throwable -> L47
        File r110 = r18.c();     // Catch: Throwable -> L47
        r3.f28625a = r17;     // Catch: Throwable -> L47
        r3.f28626b = r1;     // Catch: Throwable -> L47
        r3.f28627c = r23;     // Catch: Throwable -> L47
        r3.f = 1;     // Catch: Throwable -> L47
        r4 = a(r10, r110, r17, r1, r3);     // Catch: Throwable -> L47
        if (r4 != r5) goto L35;
        return r5;
    L35:
        r8 = r17;
        r7 = r23;
    L47:
        th = th;
        r8 = r17;
        goto L49
    L27:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L30;
        Loog.INSTANCE.w(TAG, "skip saving view tree, taskId=" + r10 + ", toolId=" + r12 + ", serialize returned empty");
    L30:
        return x.f38692a;
    L21:
        if (d.o.o.d(r13) == true) goto L24;
        r14 = false;
    L7:
        r3 = new d(this, r2);
        goto L8
    }

    private final b a(com.obric.autogui.session.a r6, String r7, String r8) {
        b r1 = null;
        File r9 = r6.y().b();     // Catch: Throwable -> L10
        if (r9 != null) goto L9;
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L13;
        Loog.INSTANCE.w(TAG, "skip saving view tree, taskId=" + r7 + ", toolId=" + r8 + ", journalDir is null");     // Catch: Throwable -> L10
    L13:
    L12:
        return r1;
    L9:
        r1 = new b(r7, r8, r9);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        OmniDataFeedbackLog.INSTANCE.e(TAG, "failed to snapshot view tree target, taskId=" + r7 + ", toolId=" + r8, th);
        goto L12
    }

    private final Object a(final String r2, final File r3, final String r4, final byte[] r5, d.c.d<? super a> r6) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return v.f28855a.a(r2, new $$Lambda$c$yEZtjVAVfL0hrnp5VSGMz_KHZqI(r3, r4, r5, r2), r1);
    }

    private static final a a(File r2, String r3, byte[] r4, String r5) {
        File r6 = com.obric.autogui.agents.vlm.models.omni.upload.b.b.f28610b.a(r2);
        if (r6.exists() == false) goto L5;
    L7:
        File r7 = k.a(r6, r3);
        n.a r8 = n.f28819a.a(r7, r4);
        if (r8 != null) goto L11;
        return null;
    L11:
        if (r8.a() == false) goto L14;
        f28614a.a().e(r5);
    L14:
        return new a(r8.a());
    L5:
        if (r6.mkdirs() == true) goto L7;
        return null;
    }
}
