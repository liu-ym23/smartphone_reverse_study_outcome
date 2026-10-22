package com.obric.autogui.agents.vlm.models.omni.upload.a;

import com.obric.autogui.agents.vlm.models.omni.upload.n;
import com.obric.autogui.agents.vlm.models.omni.upload.v;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.c.b.a.l;
import d.f.k;
import d.h.a.m;
import d.h.b.o;
import d.n.j;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: OmniUploadReactViewTreeLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "OmniReactViewTreeLog";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f28548a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f28549b = null;

    /* JADX INFO: compiled from: OmniUploadReactViewTreeLogger.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f28551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f28552c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f28550a, r6.f28550a) == true) goto L12;
            return false;
        L12:
            if (this.f28551b == r6.f28551b) goto L15;
            return false;
        L15:
            if (this.f28552c == r6.f28552c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f28550a.hashCode() * 31) + Integer.hashCode(this.f28551b)) * 31) + Boolean.hashCode(this.f28552c);
        }

        public String toString() {
            return "OmniUploadReactViewTreeSaveResult(fileName=" + this.f28550a + ", fileSizeBytes=" + this.f28551b + ", isNewFile=" + this.f28552c + ')';
        }

        public a(String r2, int r3, boolean r4) {
            o.e(r2, "fileName");
            this.f28550a = r2;
            this.f28551b = r3;
            this.f28552c = r4;
        }

        public final String a() {
            return this.f28550a;
        }

        public final int b() {
            return this.f28551b;
        }

        public final boolean c() {
            return this.f28552c;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            Integer r2 = ((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin")).c();
            if (r2 == null) goto L5;
            Object r5 = ZeusTransformUtils.preCheckCast(r2, Comparable.class, "com.obric.aiagent.plugin");
        L6:
            Comparable r6 = (Comparable) r5;
            Integer r7 = ((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin")).c();
            if (r7 == null) goto L9;
            Object r8 = ZeusTransformUtils.preCheckCast(r7, Comparable.class, "com.obric.aiagent.plugin");
        L11:
            return d.b.a.a(r6, (Comparable) r8);
        L9:
            r8 = ZeusTransformUtils.preCheckCast(Integer.MAX_VALUE, Comparable.class, "com.obric.aiagent.plugin");
            goto L11
        L5:
            r5 = ZeusTransformUtils.preCheckCast(Integer.MAX_VALUE, Comparable.class, "com.obric.aiagent.plugin");
            goto L6
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f28553a;

        public c(Comparator r3) {
            this.f28553a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f28553a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin")).a().getName(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin")).a().getName(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniUploadReactViewTreeLogger.kt */
    @d.c.b.a.f(b = "OmniUploadReactViewTreeLogger.kt", c = {54}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.reactviewtree.OmniUploadReactViewTreeLogger$saveReactViewTree$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f28555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f28556c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f28557d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ VHNode f28558e;
        final /* synthetic */ String f;
        final /* synthetic */ int g;
        final /* synthetic */ String h;
        final /* synthetic */ String i;
        final /* synthetic */ Integer j;
        final /* synthetic */ Integer k;
        final /* synthetic */ Integer l;
        final /* synthetic */ Closeable m;

        d(String r3, boolean r4, String r5, VHNode r6, String r7, int r8, String r9, String r10, Integer r11, Integer r12, Integer r13, Closeable r14, d.c.d<? super d> r15) {
            VHNode r16 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r6, VHNode.class, "com.obric.aiagent.plugin");
            Closeable r17 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r14, Closeable.class, "com.obric.aiagent.plugin");
            d.c.d r18 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28555b = r3;
            this.f28556c = r4;
            this.f28557d = r5;
            this.f28558e = r16;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r17;
            super(2, r18);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r18, d.c.d<?> r19) {
            d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f28555b, this.f28556c, this.f28557d, this.f28558e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, r16), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r17) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f28554a;
            if (r2 == 0) goto L11;
            if (r2 != 1) goto L10;
            d.o.a(r17);     // Catch: Throwable -> L7
        L15:
            Closeable r1 = this.m;
            if (r1 == null) goto L19;
            r1.close();
        L19:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r17);
            e r3 = e.f28548a;     // Catch: Throwable -> L7
            String r4 = this.f28555b;     // Catch: Throwable -> L7
            boolean r5 = this.f28556c;     // Catch: Throwable -> L7
            String r6 = this.f28557d;     // Catch: Throwable -> L7
            VHNode r7 = this.f28558e;     // Catch: Throwable -> L7
            String r8 = this.f;     // Catch: Throwable -> L7
            int r9 = this.g;     // Catch: Throwable -> L7
            String r10 = this.h;     // Catch: Throwable -> L7
            String r11 = this.i;     // Catch: Throwable -> L7
            Integer r12 = this.j;     // Catch: Throwable -> L7
            Integer r13 = this.k;     // Catch: Throwable -> L7
            Integer r14 = this.l;     // Catch: Throwable -> L7
            d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.f28554a = 1;     // Catch: Throwable -> L7
            if (e.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            Closeable r16 = this.m;
            if (r16 == null) goto L23;
            r16.close();
        L23:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.omni.upload.a.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OmniUploadReactViewTreeLogger.kt */
    @d.c.b.a.f(b = "OmniUploadReactViewTreeLogger.kt", c = {138}, d = "saveReactViewTreeBlocking", e = "com.obric.autogui.agents.vlm.models.omni.upload.reactviewtree.OmniUploadReactViewTreeLogger")
    static final class C0713e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28561c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28562d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f28563e;
        Object f;
        Object g;
        Object h;
        int i;
        long j;
        /* synthetic */ Object k;
        final /* synthetic */ e l;
        int m;

        C0713e(e r3, d.c.d<? super C0713e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.l = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            this.k = r14;
            this.m |= Integer.MIN_VALUE;
            return e.a(this.l, null, false, null, null, null, 0, null, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: lambda$5XHGCsDZPn_tbJyzi6m-F96AZLU, reason: not valid java name */
    public static /* synthetic */ g m782lambda$5XHGCsDZPn_tbJyzi6mF96AZLU(File r0) {
        return a(r0);
    }

    public static /* synthetic */ a lambda$B6raxB6y6QqEiGQQMPNI8yta1L4(File r0, String r1, String r2, String r3, VHNode r4, f.a r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ boolean lambda$M3E0nF1qHHXAjEjQ9b4EIAQv8Rs(String r0, String r1, g r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$fs70qMJJwh3a4-LmRQ0ZLIZ-qes, reason: not valid java name */
    public static /* synthetic */ com.obric.autogui.agents.vlm.models.omni.upload.a.c m783lambda$fs70qMJJwh3a4LmRQ0ZLIZqes() {
        return b();
    }

    private e() {
    }

    public static final /* synthetic */ Object a(e r15, String r16, boolean r17, String r18, VHNode r19, String r20, int r21, String r22, String r23, Integer r24, Integer r25, Integer r26, d.c.d r27) {
        return r15.a(r16, r17, r18, (VHNode) ZeusTransformUtils.wrapperContextForParams(r19, VHNode.class, "com.obric.aiagent.plugin"), r20, r21, r22, r23, r24, r25, r26, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r27, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f28548a = new e();
        f28549b = d.g.a($$Lambda$e$fs70qMJJwh3a4LmRQ0ZLIZqes.INSTANCE);
    }

    private final com.obric.autogui.agents.vlm.models.omni.upload.a.c a() {
        return (com.obric.autogui.agents.vlm.models.omni.upload.a.c) ZeusTransformUtils.preCheckCast(f28549b.b(), com.obric.autogui.agents.vlm.models.omni.upload.a.c.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autogui.agents.vlm.models.omni.upload.a.c b() {
        return new com.obric.autogui.agents.vlm.models.omni.upload.a.c();
    }

    public final void a(String r20, boolean r21, String r22, VHNode r23, String r24, int r25, String r26, String r27, Integer r28, Integer r29, Integer r30, Closeable r31) {
        VHNode r5 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r23, VHNode.class, "com.obric.aiagent.plugin");
        Closeable r1 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r31, Closeable.class, "com.obric.aiagent.plugin");
        o.e(r20, DBDefinition.TASK_ID);
        o.e(r24, "stepId");
        if (com.obric.autogui.common.a.h.f28984a.b() == true) goto L7;
        if (r1 == null) goto L27;
        r1.close();
        return;
    L27:
        return;
    L7:
        if (r1 != null) goto L18;
        if (r21 == true) goto L10;
    L17:
        r1 = null;
        goto L18
    L10:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L17;
        r1 = v.f28855a.e(r20);
        if (r1 != null) goto L18;
        e r2 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L28;
        Loog.INSTANCE.i(TAG, "skip saving react_view_tree after producer barrier closed, taskId=" + r20);
        return;
    L28:
        return;
    L18:
        Closeable r16 = r1;
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new d(r20, r21, r22, r5, r24, r25, r26, r27, r28, r29, r30, r16, null), m.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        if (r16 == null) goto L24;
        r16.close();
    L24:
        throw th;
    }

    private final Object a(String r36, boolean r37, String r38, VHNode r39, String r40, int r41, String r42, String r43, Integer r44, Integer r45, Integer r46, d.c.d<? super x> r47) {
        int r9 = r41;
        String r10 = r43;
        Integer r11 = r44;
        VHNode r20 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r39, VHNode.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r47, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C0713e.class) == false) goto L7;
        C0713e r3 = (C0713e) ZeusTransformUtils.preCheckCast(r2, C0713e.class, "com.obric.aiagent.plugin");
        if ((r3.m & Integer.MIN_VALUE) == 0) goto L7;
        r3.m -= Integer.MIN_VALUE;
    L8:
        C0713e r7 = r3;
        Object r4 = r7.k;
        Object r6 = d.c.a.b.a();
        int r5 = r7.m;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        long r8 = r7.j;
        int r1 = r7.i;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r7.h, String.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r7.g, String.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r7.f, String.class, "com.obric.aiagent.plugin");
        Integer r15 = (Integer) ZeusTransformUtils.preCheckCast(r7.f28563e, Integer.class, "com.obric.aiagent.plugin");
        Integer r16 = (Integer) ZeusTransformUtils.preCheckCast(r7.f28562d, Integer.class, "com.obric.aiagent.plugin");
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r7.f28561c, Integer.class, "com.obric.aiagent.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r7.f28560b, String.class, "com.obric.aiagent.plugin");
        String r19 = (String) ZeusTransformUtils.preCheckCast(r7.f28559a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L14
        Integer r110 = r16;
        String r25 = ", stepNum=";
        String r21 = r13;
        String r22 = r14;
        String r23 = ", stepId=";
        String r32 = TAG;
        Integer r111 = r15;
        r11 = r17;
        r10 = r18;
        long r0 = r8;
        r9 = r1;
    L136:
        a r24 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L109
        if (r24 == null) goto L132;
        String r26 = r32;
        long r112 = AOSystemTools.INSTANCE.nowTimeMillis();     // Catch: Throwable -> L106
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L116;
        String r113 = r12;
        Loog r27 = Loog.INSTANCE;     // Catch: Throwable -> L103
        StringBuilder r28 = new StringBuilder();     // Catch: Throwable -> L103
        r28.append("save react_view_tree success, taskId=").append(r22).append(r23).append(r19).append(r25).append(r9).append(", toolId=").append(r21).append(", actionType=").append(r10).append(", eventId=").append(r11).append(", fileName=").append(r24.a()).append(", size=").append(r24.b()).append(", isNewFile=").append(r24.c()).append(", multiStepIndex=").append(r110).append(", multiStepCount=").append(r111).append(", l=");     // Catch: Throwable -> L101
        r28.append(r112 - r0).append("ms");     // Catch: Throwable -> L101
        String r29 = r26;
        r27.i(r29, r28.toString());     // Catch: Throwable -> L99
    L99:
        th = th;
    L105:
        r12 = r113;
    L114:
        OmniDataFeedbackLog.INSTANCE.e(r29, "failed to save react_view_tree, fileName=" + r12, th);
    L101:
        th = th;
        r29 = r26;
    L103:
        th = th;
        r29 = r26;
    L116:
        return x.f38692a;
    L106:
        th = th;
    L108:
        r29 = r26;
        goto L114
    L132:
    L87:
        th = th;
    L111:
        r29 = r32;
        goto L114
    L78:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L82;
        r26 = r32;
        Loog.INSTANCE.w(r26, "failed to write react_view_tree, fileName=" + r12);     // Catch: Throwable -> L85
    L83:
        return x.f38692a;
    L85:
        th = th;
        goto L108
    L82:
        r26 = r32;
    L109:
        th = th;
    L14:
        th = th;
        r29 = TAG;
        goto L114
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r4);
        if (r37 == false) goto L21;
        String r30 = r36;
        File r114 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L26;
        r30 = null;
    L26:
        if (r42 != null) goto L28;
    L30:
        String r31 = null;
    L32:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L45;
        Loog r33 = Loog.INSTANCE;
        StringBuilder r34 = new StringBuilder().append("save react_view_tree start, taskId=").append(r30).append(", stepId=").append(r40).append(", stepNum=").append(r9).append(", toolId=").append(r31).append(", actionType=").append(r10).append(", eventId=").append(r11).append(", multiStepIndex=");
        r110 = r45;
        String r35 = TAG;
        r23 = ", stepId=";
        r111 = r46;
        StringBuilder r48 = r34.append(r110).append(", multiStepCount=").append(r111).append(", hasNode=");
        if (r20 == null) goto L36;
        boolean r49 = true;
    L37:
        StringBuilder r50 = r48.append(r49).append(", hasJournalDir=");
        r25 = ", stepNum=";
        String r51 = r38;
        CharSequence r52 = (CharSequence) ZeusTransformUtils.preCheckCast(r51, CharSequence.class, "com.obric.aiagent.plugin");
        if (r52 != null) goto L40;
    L43:
        boolean r53 = true;
    L44:
        r33.i(r35, r50.append(!r53).toString());
    L47:
        if (r30 == null) goto L117;
        if (r31 == null) goto L117;
        if (r20 == null) goto L52;
        if (r51 != null) goto L58;
    L63:
        if (r114 == null) goto L65;
        com.obric.autogui.agents.vlm.models.omni.a.g r54 = (com.obric.autogui.agents.vlm.models.omni.a.g) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.vlm.models.omni.upload.a.d.f28544b, com.obric.autogui.agents.vlm.models.omni.a.g.class, "com.obric.aiagent.plugin");
        String r55 = String.format("%03d", Arrays.copyOf(new Object[]{d.c.b.a.b.a(r41)}, 1));
        o.c(r55, "format(...)");
        String r56 = r31;
        String r210 = r30;
        r32 = r35;
        String r57 = com.obric.autogui.agents.vlm.models.omni.a.g.a(r54, r55, r30, r56, r40, null, 16, null);
        f.a r211 = new f.a(r40, d.c.b.a.b.a(r41), r43, r44, r45, r46);
        r0 = AOSystemTools.INSTANCE.nowTimeMillis();
        r7.f28559a = r40;     // Catch: Throwable -> L112
        r7.f28560b = r10;     // Catch: Throwable -> L112
        r7.f28561c = r11;     // Catch: Throwable -> L112
        r7.f28562d = r110;     // Catch: Throwable -> L112
        r7.f28563e = r111;     // Catch: Throwable -> L112
        r7.f = r210;     // Catch: Throwable -> L112
        r7.g = r56;     // Catch: Throwable -> L112
        r7.h = r57;     // Catch: Throwable -> L112
        r7.i = r9;     // Catch: Throwable -> L112
        r7.j = r0;     // Catch: Throwable -> L112
        r7.m = 1;     // Catch: Throwable -> L112
        Object r58 = a(r114, r57, r210, r56, r20, r211, r7);     // Catch: Throwable -> L112
        if (r58 != r6) goto L74;
        return r6;
    L74:
        r22 = r210;
        r12 = r57;
        r19 = r40;
        r21 = r56;
        r4 = r58;
    L112:
        th = th;
        r29 = r32;
        r12 = r57;
        goto L114
    L65:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L68;
        Loog.INSTANCE.w(r35, "skip saving react_view_tree, taskId=" + r30 + ", toolId=" + r31 + ", journalDir is null");
    L68:
        return x.f38692a;
    L58:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r51, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L61;
        r51 = null;
    L61:
        if (r51 == null) goto L63;
        r114 = new File(r51);
        goto L63
    L52:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L55;
        Loog.INSTANCE.w(r35, "skip saving react_view_tree, taskId=" + r30 + ", toolId=" + r31 + ", node is null");
    L55:
        return x.f38692a;
    L117:
        String r59 = r35;
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L121;
        Loog.INSTANCE.w(r59, "skip saving react_view_tree, taskId=" + r30 + ", toolId=" + r31);
    L121:
        return x.f38692a;
    L40:
        if (d.o.o.d(r52) == true) goto L43;
        r53 = false;
        goto L44
    L36:
        r49 = false;
        goto L37
    L45:
        r110 = r45;
        r25 = ", stepNum=";
        r23 = ", stepId=";
        r51 = r38;
        r111 = r46;
        r35 = TAG;
        goto L47
    L28:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r42, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L30;
        r31 = r42;
        goto L32
    L21:
        return x.f38692a;
    L7:
        r3 = new C0713e(this, r2);
        goto L8
    }

    private final Object a(File r9, final String r10, final String r11, final String r12, VHNode r13, final f.a r14, d.c.d<? super a> r15) {
        final VHNode r6 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r13, VHNode.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        final File r2 = com.obric.autogui.agents.vlm.models.omni.upload.a.d.f28544b.a(r9);
        return v.f28855a.a(r11, new $$Lambda$e$B6raxB6y6QqEiGQQMPNI8yta1L4(r2, r11, r12, r10, r6, r14), r8);
    }

    private static final a a(File r4, String r5, String r6, String r7, VHNode r8, f.a r9) {
        VHNode r10 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r8, VHNode.class, "com.obric.aiagent.plugin");
        if (r4.exists() == false) goto L5;
    L7:
        e r0 = f28548a;
        File r3 = r0.a(r4, r5, r6);
        if (r3 != null) goto L11;
        r3 = k.a(r4, r7);
    L11:
        if (r3.isFile() == false) goto L13;
        String r11 = k.a(r3, d.o.d.f38623b);
    L14:
        String r12 = f.f28564a.a(r11, r10, r9);
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L17;
    L20:
        boolean r14 = true;
    L21:
        if (r14 == true) goto L23;
        byte[] r15 = r12.getBytes(d.o.d.f38623b);
        o.c(r15, "getBytes(...)");
        n.a r16 = n.f28819a.a(r3, r15);
        if (r16 != null) goto L30;
        return null;
    L30:
        if (r16.a() == false) goto L32;
        r0.a().e(r5);
    L32:
        String r17 = r3.getName();
        o.c(r17, "getName(...)");
        return new a(r17, r15.length, r16.a());
    L23:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L25;
        Loog.INSTANCE.w(TAG, "serialize returned empty, taskId=" + r5 + ", toolId=" + r6);
    L25:
        return null;
    L17:
        if (d.o.o.d(r13) == true) goto L20;
        r14 = false;
        goto L21
    L13:
        r11 = null;
        goto L14
    L5:
        if (r4.mkdirs() == true) goto L7;
        return null;
    }

    private final File a(File r1, String r2, String r3) {
        final String r0 = com.obric.autogui.agents.vlm.models.omni.upload.a.d.f28544b.a(r2);
        final String r4 = com.obric.autogui.agents.vlm.models.omni.upload.a.d.f28544b.a(r3);
        File[] r5 = r1.listFiles();
        if (r5 == null) goto L15;
        j r6 = i.k(r5);
        if (r6 == null) goto L15;
        j r7 = d.n.m.e(r6, $$Lambda$e$5XHGCsDZPn_tbJyzi6mF96AZLU.INSTANCE);
        if (r7 == null) goto L15;
        j r8 = d.n.m.a(r7, new $$Lambda$e$M3E0nF1qHHXAjEjQ9b4EIAQv8Rs(r0, r4));
        if (r8 == null) goto L15;
        j r9 = d.n.m.a(r8, (Comparator) ZeusTransformUtils.preCheckCast(new c((Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.aiagent.plugin")), Comparator.class, "com.obric.aiagent.plugin"));
        if (r9 == null) goto L15;
        g r10 = (g) ZeusTransformUtils.preCheckCast(d.n.m.d(r9), g.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L15;
        return r10.a();
    L15:
        return null;
    }

    private static final g a(File r2) {
        com.obric.autogui.agents.vlm.models.omni.upload.a.d r0 = com.obric.autogui.agents.vlm.models.omni.upload.a.d.f28544b;
        o.a(r2);
        return (g) ZeusTransformUtils.preCheckCast(r0.b(r2), g.class, "com.obric.aiagent.plugin");
    }

    private static final boolean a(String r1, String r2, g r3) {
        o.e(r3, "record");
        if (o.a(r3.b(), r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(r3.e(), r2) == false) goto L7;
        return true;
    }
}
