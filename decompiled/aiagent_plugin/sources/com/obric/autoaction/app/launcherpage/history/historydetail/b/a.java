package com.obric.autoaction.app.launcherpage.history.historydetail.b;

import com.obric.eventkit.task.api.IEventTaskRecordApi;
import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: GetHistoryDetailUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.history.historydetail.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GetHistoryDetailUseCase.kt */
    @f(b = "GetHistoryDetailUseCase.kt", c = {13, 14}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.history.historydetail.domain.GetHistoryDetailUseCase$invoke$1")
    static final class C0539a extends l implements m<i<? super EventTaskExecutionRecord>, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f23886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f23887c;

        C0539a(long r3, d<? super C0539a> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f23886b = r3;
            super(2, r6);
        }

        public final Object a(i<? super EventTaskExecutionRecord> r3, d<? super x> r4) {
            return ((C0539a) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0539a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r5, d<?> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            C0539a r0 = new C0539a(this.f23886b, r7);
            r0.f23887c = r5;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super EventTaskExecutionRecord> r3, d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23885a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r10);
        L21:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            i r2 = (i) ZeusTransformUtils.preCheckCast(this.f23887c, i.class, "com.obric.aiagent.plugin");
            o.a(r10);
        L15:
            EventTaskExecutionRecord r11 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r10, EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");
        L17:
            d<? super x> r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23887c = null;
            this.f23885a = 2;
            if (r2.emit(r11, r4) != r0) goto L21;
            return r0;
        L10:
            o.a(r10);
            r2 = (i) ZeusTransformUtils.preCheckCast(this.f23887c, i.class, "com.obric.aiagent.plugin");
            IEventTaskRecordApi r12 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L16;
            long r6 = this.f23886b;
            d<? super EventTaskExecutionRecord> r8 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23887c = r2;
            this.f23885a = 1;
            r10 = r12.getExecutionRecordById(r6, r8);
            if (r10 != r0) goto L15;
            return r0;
        L16:
            r11 = null;
            goto L17
        }
    }

    public a() {
    }

    public final h<EventTaskExecutionRecord> a(long r2) {
        return j.a(j.a((m) ZeusTransformUtils.preCheckCast(new C0539a(r2, null), m.class, "com.obric.aiagent.plugin")), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
    }
}
