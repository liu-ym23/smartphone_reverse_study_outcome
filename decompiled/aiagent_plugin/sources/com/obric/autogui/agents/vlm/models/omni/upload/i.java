package com.obric.autogui.agents.vlm.models.omni.upload;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: OmniDataFeedbackUploadStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    private static final String TAG = "OmniUploadDataStore";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f28785a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f28786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.omni.upload.b.f f28787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.omni.upload.a.h f28788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q f28789e;
    private final com.obric.autogui.agents.vlm.models.omni.upload.b.a f;
    private final com.obric.autogui.agents.vlm.models.omni.upload.a.c g;

    /* JADX INFO: compiled from: OmniDataFeedbackUploadStore.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f28791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f28792c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private t f28793d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.obric.autogui.agents.vlm.models.omni.upload.b.e f28794e;
        private com.obric.autogui.agents.vlm.models.omni.upload.a.g f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f28790a, r6.f28790a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f28791b, r6.f28791b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f28792c, r6.f28792c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f28793d, r6.f28793d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f28794e, r6.f28794e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f28790a.hashCode() * 31) + this.f28791b.hashCode()) * 31) + this.f28792c.hashCode()) * 31;
            t r1 = this.f28793d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            com.obric.autogui.agents.vlm.models.omni.upload.b.e r5 = this.f28794e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            com.obric.autogui.agents.vlm.models.omni.upload.a.g r8 = this.f;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "Builder(taskId=" + this.f28790a + ", toolId=" + this.f28791b + ", stepId=" + this.f28792c + ", image=" + this.f28793d + ", viewTree=" + this.f28794e + ", reactViewTree=" + this.f + ')';
        }

        public a(String r2, String r3, String r4, t r5, com.obric.autogui.agents.vlm.models.omni.upload.b.e r6, com.obric.autogui.agents.vlm.models.omni.upload.a.g r7) {
            d.h.b.o.e(r2, DBDefinition.TASK_ID);
            d.h.b.o.e(r3, "toolId");
            d.h.b.o.e(r4, "stepId");
            this.f28790a = r2;
            this.f28791b = r3;
            this.f28792c = r4;
            this.f28793d = r5;
            this.f28794e = r6;
            this.f = r7;
        }

        public /* synthetic */ a(String r10, String r11, String r12, t r13, com.obric.autogui.agents.vlm.models.omni.upload.b.e r14, com.obric.autogui.agents.vlm.models.omni.upload.a.g r15, int r16, d.h.b.h r17) {
            if ((r16 & 8) == 0) goto L5;
            t r6 = null;
        L7:
            if ((r16 & 16) == 0) goto L9;
            com.obric.autogui.agents.vlm.models.omni.upload.b.e r7 = null;
        L11:
            if ((r16 & 32) == 0) goto L13;
            com.obric.autogui.agents.vlm.models.omni.upload.a.g r8 = null;
        L14:
            this(r10, r11, r12, r6, r7, r8);
            return;
        L13:
            r8 = r15;
            goto L14
        L9:
            r7 = r14;
            goto L11
        L5:
            r6 = r13;
            goto L7
        }

        public final t a() {
            return this.f28793d;
        }

        public final void a(t r1) {
            this.f28793d = r1;
        }

        public final void a(com.obric.autogui.agents.vlm.models.omni.upload.b.e r1) {
            this.f28794e = r1;
        }

        public final com.obric.autogui.agents.vlm.models.omni.upload.b.e b() {
            return this.f28794e;
        }

        public final void a(com.obric.autogui.agents.vlm.models.omni.upload.a.g r1) {
            this.f = r1;
        }

        public final com.obric.autogui.agents.vlm.models.omni.upload.a.g c() {
            return this.f;
        }

        public final com.obric.autogui.agents.vlm.models.omni.upload.h d() {
            t r0 = this.f28793d;
            if (r0 == null) goto L8;
            Integer r1 = r0.c();
            if (r1 == null) goto L8;
        L7:
            Integer r6 = r1;
        L17:
            com.obric.autogui.agents.vlm.models.omni.upload.h r2 = new com.obric.autogui.agents.vlm.models.omni.upload.h(this.f28790a, this.f28791b, this.f28792c, r6, this.f28793d, this.f28794e, this.f);
            if (r2.k() == true) goto L20;
            return null;
        L20:
            return r2;
        L8:
            com.obric.autogui.agents.vlm.models.omni.upload.b.e r3 = this.f28794e;
            if (r3 == null) goto L11;
            r1 = r3.c();
        L12:
            if (r1 != null) goto L7;
            com.obric.autogui.agents.vlm.models.omni.upload.a.g r4 = this.f;
            if (r4 == null) goto L16;
            r1 = r4.c();
            goto L7
        L16:
            r6 = null;
            goto L17
        L11:
            r1 = null;
            goto L12
        }
    }

    /* JADX INFO: compiled from: OmniDataFeedbackUploadStore.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).h()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).h()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f28795a;

        public d(Comparator r3) {
            this.f28795a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r2 = this.f28795a.compare(r3, r4);
            if (r2 != 0) goto L15;
            int r5 = ((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).d();
            if (r5 != null) goto L9;
            r5 = Integer.MAX_VALUE;
        L9:
            Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.aiagent.plugin");
            Integer r7 = ((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).d();
            if (r7 == null) goto L12;
            Object r8 = ZeusTransformUtils.preCheckCast(r7, Comparable.class, "com.obric.aiagent.plugin");
        L14:
            return d.b.a.a(r6, (Comparable) r8);
        L12:
            r8 = ZeusTransformUtils.preCheckCast(Integer.MAX_VALUE, Comparable.class, "com.obric.aiagent.plugin");
            goto L14
        L15:
            return r2;
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f28796a;

        public e(Comparator r3) {
            this.f28796a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f28796a.compare(r4, r5);
            if (r3 != 0) goto L20;
            File r6 = (File) ZeusTransformUtils.preCheckCast(d.a.p.l(((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).j()), File.class, "com.obric.aiagent.plugin");
            String r7 = null;
            if (r6 == null) goto L8;
            String r8 = r6.getName();
        L9:
            String r1 = "";
            if (r8 != null) goto L12;
            r8 = "";
        L12:
            Comparable r9 = (Comparable) ZeusTransformUtils.preCheckCast(r8, Comparable.class, "com.obric.aiagent.plugin");
            File r10 = (File) ZeusTransformUtils.preCheckCast(d.a.p.l(((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).j()), File.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L15;
            r7 = r10.getName();
        L15:
            if (r7 == null) goto L19;
            r1 = r7;
        L19:
            return d.b.a.a(r9, (Comparable) ZeusTransformUtils.preCheckCast(r1, Comparable.class, "com.obric.aiagent.plugin"));
        L8:
            r8 = null;
            goto L9
        L20:
            return r3;
        }
    }

    /* JADX INFO: compiled from: OmniDataFeedbackUploadStore.kt */
    @d.c.b.a.f(b = "OmniDataFeedbackUploadStore.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadStore$cleanupFinishedCounts$2")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Collection<String> f28798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f28799c;

        f(Collection<String> r3, i r4, d.c.d<? super f> r5) {
            Collection<String> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28798b = r6;
            this.f28799c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f28798b, this.f28799c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f28797a != 0) goto L19;
            d.o.a(r4);
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f28798b, Iterable.class, "com.obric.aiagent.plugin");
            i r3 = this.f28799c;
            Iterator r6 = r5.iterator();
        L6:
            if (r6.hasNext() == false) goto L17;
            String r0 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
            if (i.a(r3).a(r0).isEmpty() == false) goto L11;
            i.d(r3).d(r0);
        L11:
            if (i.b(r3).a(r0).isEmpty() == false) goto L14;
            i.e(r3).d(r0);
        L14:
            if (i.c(r3).a(r0).isEmpty() == false) goto L6;
            i.f(r3).d(r0);
            goto L6
        L17:
            return d.x.f38692a;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OmniDataFeedbackUploadStore.kt */
    @d.c.b.a.f(b = "OmniDataFeedbackUploadStore.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadStore$listAll$2")
    static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends com.obric.autogui.agents.vlm.models.omni.upload.h>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f28801b;

        g(i r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28801b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super List<com.obric.autogui.agents.vlm.models.omni.upload.h>> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f28801b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends com.obric.autogui.agents.vlm.models.omni.upload.h>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f28800a != 0) goto L15;
            d.o.a(r4);
            i r5 = this.f28801b;
            List<t> r0 = i.a(r5).a();
            if (com.obric.autogui.common.a.h.f28984a.a() == false) goto L7;
            List<com.obric.autogui.agents.vlm.models.omni.upload.b.e> r1 = i.b(this.f28801b).a();
        L9:
            if (com.obric.autogui.common.a.h.f28984a.b() == false) goto L11;
            List<com.obric.autogui.agents.vlm.models.omni.upload.a.g> r3 = i.c(this.f28801b).a();
        L13:
            return i.a(r5, r0, r1, r3);
        L11:
            r3 = d.a.p.b();
            goto L13
        L7:
            r1 = d.a.p.b();
            goto L9
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OmniDataFeedbackUploadStore.kt */
    @d.c.b.a.f(b = "OmniDataFeedbackUploadStore.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadStore$listByTaskId$2")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends com.obric.autogui.agents.vlm.models.omni.upload.h>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f28803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f28804c;

        h(i r3, String r4, d.c.d<? super h> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28803b = r3;
            this.f28804c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<com.obric.autogui.agents.vlm.models.omni.upload.h>> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f28803b, this.f28804c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends com.obric.autogui.agents.vlm.models.omni.upload.h>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f28802a != 0) goto L15;
            d.o.a(r4);
            i r5 = this.f28803b;
            List<t> r0 = i.a(r5).a(this.f28804c);
            if (com.obric.autogui.common.a.h.f28984a.a() == false) goto L7;
            List<com.obric.autogui.agents.vlm.models.omni.upload.b.e> r1 = i.b(this.f28803b).a(this.f28804c);
        L9:
            if (com.obric.autogui.common.a.h.f28984a.b() == false) goto L11;
            List<com.obric.autogui.agents.vlm.models.omni.upload.a.g> r3 = i.c(this.f28803b).a(this.f28804c);
        L13:
            return i.a(r5, r0, r1, r3);
        L11:
            r3 = d.a.p.b();
            goto L13
        L7:
            r1 = d.a.p.b();
            goto L9
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f28785a = new b(null);
    }

    public i() {
        this(null, null, null, null, null, null, 63, null);
    }

    private final <T> T a(T r1, T r2) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        return r2;
    }

    public i(u r2, com.obric.autogui.agents.vlm.models.omni.upload.b.f r3, com.obric.autogui.agents.vlm.models.omni.upload.a.h r4, q r5, com.obric.autogui.agents.vlm.models.omni.upload.b.a r6, com.obric.autogui.agents.vlm.models.omni.upload.a.c r7) {
        d.h.b.o.e(r2, "imageStore");
        d.h.b.o.e(r3, "viewTreeStore");
        d.h.b.o.e(r4, "reactViewTreeStore");
        d.h.b.o.e(r5, "imageCountStore");
        d.h.b.o.e(r6, "viewTreeCountStore");
        d.h.b.o.e(r7, "reactViewTreeCountStore");
        this.f28786b = r2;
        this.f28787c = r3;
        this.f28788d = r4;
        this.f28789e = r5;
        this.f = r6;
        this.g = r7;
    }

    public static final /* synthetic */ u a(i r0) {
        return r0.f28786b;
    }

    public static final /* synthetic */ List a(i r2, List r3, List r4, List r5) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.upload.b.f b(i r0) {
        return r0.f28787c;
    }

    public static final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.upload.a.h c(i r0) {
        return r0.f28788d;
    }

    public static final /* synthetic */ q d(i r0) {
        return r0.f28789e;
    }

    public static final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.upload.b.a e(i r0) {
        return r0.f;
    }

    public static final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.upload.a.c f(i r0) {
        return r0.g;
    }

    public /* synthetic */ i(u r5, com.obric.autogui.agents.vlm.models.omni.upload.b.f r6, com.obric.autogui.agents.vlm.models.omni.upload.a.h r7, q r8, com.obric.autogui.agents.vlm.models.omni.upload.b.a r9, com.obric.autogui.agents.vlm.models.omni.upload.a.c r10, int r11, d.h.b.h r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = new u(null, 1, null);
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = new com.obric.autogui.agents.vlm.models.omni.upload.b.f(null, 1, null);
    L8:
        com.obric.autogui.agents.vlm.models.omni.upload.b.f r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = new com.obric.autogui.agents.vlm.models.omni.upload.a.h(null, 1, null);
    L11:
        com.obric.autogui.agents.vlm.models.omni.upload.a.h r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = new q();
    L14:
        q r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = new com.obric.autogui.agents.vlm.models.omni.upload.b.a();
    L17:
        com.obric.autogui.agents.vlm.models.omni.upload.b.a r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = new com.obric.autogui.agents.vlm.models.omni.upload.a.c();
    L20:
        u r14 = r5;
        this(r14, r13, r0, r1, r2, r10);
    }

    public final Object a(d.c.d<? super List<com.obric.autogui.agents.vlm.models.omni.upload.h>> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r6);
    }

    public final Object a(String r5, d.c.d<? super List<com.obric.autogui.agents.vlm.models.omni.upload.h>> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    public final Object b(String r3, d.c.d<? super Integer> r4) {
        d.c.d<? super Integer> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f28789e.a(r3, r5);
    }

    public final boolean a(com.obric.autogui.agents.vlm.models.omni.upload.h r7) {
        d.h.b.o.e(r7, "record");
        t r0 = r7.e();
        boolean r2 = false;
        boolean r3 = true;
        if (r0 != null) goto L5;
    L8:
        com.obric.autogui.agents.vlm.models.omni.upload.b.e r1 = r7.f();
        if (r1 != null) goto L11;
    L14:
        com.obric.autogui.agents.vlm.models.omni.upload.a.g r8 = r7.g();
        if (r8 != null) goto L17;
        return r3;
    L17:
        if (a(r8.a()) == false) goto L20;
        this.f28788d.a((com.obric.autogui.agents.vlm.models.omni.a.h) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.agents.vlm.models.omni.a.h.class, "com.obric.aiagent.plugin"));
        r2 = r3;
    L20:
        return r2;
    L11:
        if (a(r1.a()) == false) goto L13;
        this.f28787c.a((com.obric.autogui.agents.vlm.models.omni.a.h) ZeusTransformUtils.preCheckCast(r1, com.obric.autogui.agents.vlm.models.omni.a.h.class, "com.obric.aiagent.plugin"));
        goto L14
    L13:
        r3 = false;
        goto L14
    L5:
        if (a(r0.a()) == false) goto L7;
        this.f28786b.a((com.obric.autogui.agents.vlm.models.omni.a.h) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.agents.vlm.models.omni.a.h.class, "com.obric.aiagent.plugin"));
        goto L8
    L7:
        r3 = false;
        goto L8
    }

    public final void b(com.obric.autogui.agents.vlm.models.omni.upload.h r3) {
        d.h.b.o.e(r3, "record");
        if (r3.e() == null) goto L6;
        this.f28789e.b(r3.a());
    L6:
        if (r3.f() == null) goto L9;
        this.f.b(r3.a());
    L9:
        if (r3.g() == null) goto L12;
        this.g.b(r3.a());
        return;
    }

    public final Object a(Collection<String> r5, d.c.d<? super d.x> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        Object r4 = kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r7, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r8);
        if (r4 != d.c.a.b.a()) goto L6;
        return r4;
    L6:
        return d.x.f38692a;
    }

    private final List<com.obric.autogui.agents.vlm.models.omni.upload.h> a(List<t> r21, List<com.obric.autogui.agents.vlm.models.omni.upload.b.e> r22, List<com.obric.autogui.agents.vlm.models.omni.upload.a.g> r23) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L3:
        t r7 = null;
        if (r2.hasNext() == false) goto L12;
        t r6 = (t) ZeusTransformUtils.preCheckCast(r2.next(), t.class, "com.obric.aiagent.plugin");
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.upload.g r9 = a(r6);
        Object r10 = r8.get(r9);
        if (r10 != null) goto L8;
        r10 = new a(r6.b(), r6.e(), r6.f(), null, null, null, 56, null);
        r8.put(r9, r10);
    L8:
        a r11 = (a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.aiagent.plugin");
        a r12 = (a) ZeusTransformUtils.preCheckCast(r5.get(a(r6)), a.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L11;
        r7 = r12.a();
    L11:
        r11.a((t) ZeusTransformUtils.preCheckCast(a(r7, r6), t.class, "com.obric.aiagent.plugin"));
        goto L3
    L12:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r13.hasNext() == false) goto L23;
        com.obric.autogui.agents.vlm.models.omni.upload.b.e r14 = (com.obric.autogui.agents.vlm.models.omni.upload.b.e) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.autogui.agents.vlm.models.omni.upload.b.e.class, "com.obric.aiagent.plugin");
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.upload.g r16 = a(r14);
        Object r17 = r15.get(r16);
        if (r17 != null) goto L18;
        r17 = new a(r14.b(), r14.e(), r14.f(), null, null, null, 56, null);
        r15.put(r16, r17);
    L18:
        a r18 = (a) ZeusTransformUtils.preCheckCast(r17, a.class, "com.obric.aiagent.plugin");
        a r19 = (a) ZeusTransformUtils.preCheckCast(r5.get(a(r14)), a.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L21;
        com.obric.autogui.agents.vlm.models.omni.upload.b.e r20 = r19.b();
    L22:
        r18.a((com.obric.autogui.agents.vlm.models.omni.upload.b.e) ZeusTransformUtils.preCheckCast(a(r20, r14), com.obric.autogui.agents.vlm.models.omni.upload.b.e.class, "com.obric.aiagent.plugin"));
        goto L14
    L21:
        r20 = null;
        goto L22
    L23:
        Iterator r24 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L25:
        if (r24.hasNext() == false) goto L34;
        com.obric.autogui.agents.vlm.models.omni.upload.a.g r25 = (com.obric.autogui.agents.vlm.models.omni.upload.a.g) ZeusTransformUtils.preCheckCast(r24.next(), com.obric.autogui.agents.vlm.models.omni.upload.a.g.class, "com.obric.aiagent.plugin");
        Map r26 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.upload.g r27 = a(r25);
        Object r28 = r26.get(r27);
        if (r28 != null) goto L29;
        r28 = new a(r25.b(), r25.e(), r25.f(), null, null, null, 56, null);
        r26.put(r27, r28);
    L29:
        a r29 = (a) ZeusTransformUtils.preCheckCast(r28, a.class, "com.obric.aiagent.plugin");
        a r30 = (a) ZeusTransformUtils.preCheckCast(r5.get(a(r25)), a.class, "com.obric.aiagent.plugin");
        if (r30 == null) goto L32;
        com.obric.autogui.agents.vlm.models.omni.upload.a.g r31 = r30.c();
    L33:
        r29.a((com.obric.autogui.agents.vlm.models.omni.upload.a.g) ZeusTransformUtils.preCheckCast(a(r31, r25), com.obric.autogui.agents.vlm.models.omni.upload.a.g.class, "com.obric.aiagent.plugin"));
        goto L25
    L32:
        r31 = null;
        goto L33
    L34:
        Collection r0 = r5.values();
        d.h.b.o.c(r0, "<get-values>(...)");
        Iterable r32 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r33 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r34 = r32.iterator();
    L36:
        if (r34.hasNext() == false) goto L41;
        com.obric.autogui.agents.vlm.models.omni.upload.h r35 = ((a) ZeusTransformUtils.preCheckCast(r34.next(), a.class, "com.obric.aiagent.plugin")).d();
        if (r35 == null) goto L36;
        r33.add(r35);
        goto L36
    L41:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r33, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new e((Comparator) ZeusTransformUtils.preCheckCast(new d((Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.aiagent.plugin")), Comparator.class, "com.obric.aiagent.plugin")), Comparator.class, "com.obric.aiagent.plugin"));
    }

    private final com.obric.autogui.agents.vlm.models.omni.upload.g a(t r2) {
        return new com.obric.autogui.agents.vlm.models.omni.upload.g(r2.b(), r2.e());
    }

    private final com.obric.autogui.agents.vlm.models.omni.upload.g a(com.obric.autogui.agents.vlm.models.omni.upload.b.e r2) {
        return new com.obric.autogui.agents.vlm.models.omni.upload.g(r2.b(), r2.e());
    }

    private final com.obric.autogui.agents.vlm.models.omni.upload.g a(com.obric.autogui.agents.vlm.models.omni.upload.a.g r2) {
        return new com.obric.autogui.agents.vlm.models.omni.upload.g(r2.b(), r2.e());
    }

    private final boolean a(File r4) {
        if (r4.exists() == true) goto L19;
        return true;
    L19:
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L8
        i r3 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        Object r5 = d.n.f(Boolean.valueOf(r4.delete()));     // Catch: Throwable -> L8
    L11:
        if (d.n.b(r5) == false) goto L13;
        r5 = false;
    L13:
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (r6 == false) goto L16;
    L18:
        return r6;
    L16:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L18;
        Loog.INSTANCE.w(TAG, "delete finished file failed, fileName=" + r4.getName());
    L8:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L11
    }
}
