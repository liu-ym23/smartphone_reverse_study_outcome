package com.obric.autogui.agents.vlm.models.omni.a;

import com.bytedance.keva.Keva;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: DataFeedbackUploadCountStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<String, String> f28136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Keva f28137e;
    private final Object f;

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.omni.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataFeedbackUploadCountStore.kt */
    @d.c.b.a.f(b = "DataFeedbackUploadCountStore.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.feedback.DataFeedbackUploadCountStore$getTaskDataCount$2")
    static final class C0710a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f28139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f28140c;

        C0710a(a r3, String r4, d.c.d<? super C0710a> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28139b = r3;
            this.f28140c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((C0710a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0710a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0710a(this.f28139b, this.f28140c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f28138a != 0) goto L7;
            o.a(r2);
            return this.f28139b.c(this.f28140c);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public a(String r3, String r4, String r5, d.h.a.b<? super String, String> r6, Keva r7) {
        d.h.a.b<String, String> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "repoName");
        d.h.b.o.e(r4, "keyPrefix");
        d.h.b.o.e(r5, "tag");
        d.h.b.o.e(r8, "taskIdNormalizer");
        d.h.b.o.e(r7, "keva");
        this.f28133a = r3;
        this.f28134b = r4;
        this.f28135c = r5;
        this.f28136d = r8;
        this.f28137e = r7;
        this.f = b.f28141a.a(r3);
    }

    public /* synthetic */ a(String r7, String r8, String r9, d.h.a.b r10, Keva r11, int r12, d.h.b.h r13) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r12 & 16) == 0) goto L5;
        r11 = Keva.getRepo(r7, 0);
    L5:
        this(r7, r8, r9, r4, r11);
    }

    public final int a(String r7) {
        d.h.b.o.e(r7, DBDefinition.TASK_ID);
        String r8 = e(r7);
        if (r8 != null) goto L5;
        return 0;
    L5:
        Object r1 = this.f;
        monitor-enter(r1);
    L21:
        th = move-exception;
        throw th;
    L8:
        int r0 = d.l.n.c(f(r8), 0) + 1;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L14
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        r3.f28137e.storeInt(r3.g(r8), r0);     // Catch: Throwable -> L14
        OmniDataFeedbackLog r4 = OmniDataFeedbackLog.INSTANCE;     // Catch: Throwable -> L14
        String r5 = r3.f28135c;     // Catch: Throwable -> L14
        if (r4.isVerboseLogEnabled() == false) goto L12;
        Loog.INSTANCE.i(r5, "data count increased, taskId=" + r8 + ", count=" + r0);     // Catch: Throwable -> L14
    L12:
        Object r6 = d.n.f(x.f38692a);     // Catch: Throwable -> L14
    L16:
        Throwable r9 = d.n.c(r6);     // Catch: Throwable -> L21
        if (r9 == null) goto L19;
        OmniDataFeedbackLog.INSTANCE.e(this.f28135c, "write data count failed, taskId=" + r8, r9);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r1);
        return r0;
    L14:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;     // Catch: Throwable -> L21
        r6 = d.n.f(o.a(th));     // Catch: Throwable -> L21
        goto L16
    }

    public final int b(String r8) {
        d.h.b.o.e(r8, DBDefinition.TASK_ID);
        String r9 = e(r8);
        int r1 = 0;
        if (r9 != null) goto L5;
        return 0;
    L5:
        Object r2 = this.f;
        monitor-enter(r2);
        String r3 = g(r9);     // Catch: Throwable -> L36
        d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L10
        Object r5 = d.n.f(Boolean.valueOf(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f28137e.contains(r3)));     // Catch: Throwable -> L10
    L12:
        Throwable r6 = d.n.c(r5);     // Catch: Throwable -> L36
        if (r6 == null) goto L15;
        OmniDataFeedbackLog.INSTANCE.e(this.f28135c, "read data count failed, taskId=" + r9, r6);     // Catch: Throwable -> L36
    L34:
        monitor-exit(r2);
        return r1;
    L15:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L34;
        r1 = d.l.n.c(d.l.n.c(f(r9), 0) - 1, 0);     // Catch: Throwable -> L36
        d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L28
        a r0 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        if (r1 != 0) goto L23;
        r0.f28137e.erase(r3);     // Catch: Throwable -> L28
        OmniDataFeedbackLog r10 = OmniDataFeedbackLog.INSTANCE;     // Catch: Throwable -> L28
        String r11 = r0.f28135c;     // Catch: Throwable -> L28
        if (r10.isVerboseLogEnabled() == false) goto L26;
        Loog.INSTANCE.i(r11, "data count decreased to zero and removed, taskId=" + r9);     // Catch: Throwable -> L28
    L26:
        Object r12 = d.n.f(x.f38692a);     // Catch: Throwable -> L28
    L30:
        Throwable r13 = d.n.c(r12);     // Catch: Throwable -> L36
        if (r13 == null) goto L34;
        OmniDataFeedbackLog.INSTANCE.e(this.f28135c, "decrease data count failed, taskId=" + r9, r13);     // Catch: Throwable -> L36
        goto L34
    L23:
        r0.f28137e.storeInt(r3, r1);     // Catch: Throwable -> L28
        OmniDataFeedbackLog r14 = OmniDataFeedbackLog.INSTANCE;     // Catch: Throwable -> L28
        String r15 = r0.f28135c;     // Catch: Throwable -> L28
        if (r14.isVerboseLogEnabled() == false) goto L26;
        Loog.INSTANCE.i(r15, "data count decreased, taskId=" + r9 + ", count=" + r1);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        d.n.a r16 = d.n.f38560a;     // Catch: Throwable -> L36
        r12 = d.n.f(o.a(th));     // Catch: Throwable -> L36
        goto L30
    L10:
        th = move-exception;
        d.n.a r17 = d.n.f38560a;     // Catch: Throwable -> L36
        r5 = d.n.f(o.a(th));     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    }

    public final Object a(String r5, d.c.d<? super Integer> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0710a(this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
    }

    public final Integer c(String r5) {
        d.h.b.o.e(r5, DBDefinition.TASK_ID);
        String r6 = e(r5);
        Integer r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        Object r1 = this.f;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f28137e.contains(g(r6)) == false) goto L11;
        r0 = Integer.valueOf(d.l.n.c(f(r6), 0));     // Catch: Throwable -> L13
    L11:
        monitor-exit(r1);
        return r0;
    }

    public final void d(String r6) {
        d.h.b.o.e(r6, DBDefinition.TASK_ID);
        String r7 = e(r6);
        if (r7 != null) goto L5;
        return;
    L5:
        Object r0 = this.f;
        monitor-enter(r0);
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L12
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        r2.f28137e.erase(r2.g(r7));     // Catch: Throwable -> L12
        OmniDataFeedbackLog r3 = OmniDataFeedbackLog.INSTANCE;     // Catch: Throwable -> L12
        String r4 = r2.f28135c;     // Catch: Throwable -> L12
        if (r3.isVerboseLogEnabled() == false) goto L10;
        Loog.INSTANCE.i(r4, "data count removed, taskId=" + r7);     // Catch: Throwable -> L12
    L10:
        Object r5 = d.n.f(x.f38692a);     // Catch: Throwable -> L12
    L14:
        Throwable r8 = d.n.c(r5);     // Catch: Throwable -> L19
        if (r8 == null) goto L17;
        OmniDataFeedbackLog.INSTANCE.e(this.f28135c, "remove data count failed, taskId=" + r7, r8);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r0);
        return;
    L19:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L19
        r5 = d.n.f(o.a(th));     // Catch: Throwable -> L19
        goto L14
    }

    private final String e(String r3) {
        String r2 = this.f28136d.invoke(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString());
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
        r2 = null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    }

    private final int f(String r7) {
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L5
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = d.n.f(Integer.valueOf(r3.f28137e.getInt(r3.g(r7), 0)));     // Catch: Throwable -> L5
    L7:
        Throwable r5 = d.n.c(r4);
        if (r5 == null) goto L12;
        OmniDataFeedbackLog.INSTANCE.e(this.f28135c, "read data count failed, taskId=" + r7, r5);
        r4 = 0;
    L12:
        return ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue();
    L5:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r4 = d.n.f(o.a(th));
        goto L7
    }

    private final String g(String r2) {
        return this.f28134b + r2;
    }
}
