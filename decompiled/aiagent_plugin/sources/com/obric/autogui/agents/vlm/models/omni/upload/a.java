package com.obric.autogui.agents.vlm.models.omni.upload;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.coroutines.f.a f28528a;

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.omni.upload.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
    @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {DownloadErrorCode.ERROR_NETWORK_NO_INPUT_STREAM, DownloadErrorCode.ERROR_DB_LOCK}, d = "runExclusive", e = "com.obric.autogui.agents.vlm.models.omni.upload.DataFeedbackDrainSynchronizer")
    static final class C0711a<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f28531c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f28532d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f28533e;

        C0711a(a r3, d.c.d<? super C0711a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28532d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28531c = r3;
            this.f28533e |= Integer.MIN_VALUE;
            return this.f28532d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public a() {
        this.f28528a = kotlinx.coroutines.f.c.a(false, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.obric.autogui.agents.vlm.models.omni.upload.a] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v4, types: [kotlinx.coroutines.f.a] */
    public final <T> Object a(d.h.a.b<? super d.c.d<? super T>, ? extends Object> r8, d.c.d<? super T> r9) {
        d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, C0711a.class) == false) goto L7;
        C0711a r0 = (C0711a) ZeusTransformUtils.preCheckCast(r11, C0711a.class, "com.obric.aiagent.plugin");
        if ((r0.f28533e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f28533e -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f28531c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f28533e;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        kotlinx.coroutines.f.a r7 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f28529a, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Throwable -> L15
        a this = r7;
    L26:
        this.b(null);
        return r12;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.f.a r13 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f28530b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        r10 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r0.f28529a, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.o.a(r12);
        kotlinx.coroutines.f.a r14 = r13;
    L23:
        r0.f28529a = r14;     // Catch: Throwable -> L15
        r0.f28530b = null;     // Catch: Throwable -> L15
        r0.f28533e = 2;     // Catch: Throwable -> L15
        r12 = r10.invoke(r0);     // Catch: Throwable -> L15
        this = r14;
        if (r12 != r2) goto L26;
        return r2;
    L20:
        d.o.a(r12);
        kotlinx.coroutines.f.a r15 = this.f28528a;
        r0.f28529a = r10;
        r0.f28530b = r15;
        r0.f28533e = 1;
        Object r16 = r15.a(null, r0);
        r14 = r15;
        if (r16 != r2) goto L23;
        return r2;
    L15:
        th = move-exception;
        this.b(null);
        throw th;
    L7:
        r0 = new C0711a(this, r11);
        goto L8
    }
}
