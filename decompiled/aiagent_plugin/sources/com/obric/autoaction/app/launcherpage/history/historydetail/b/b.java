package com.obric.autoaction.app.launcherpage.history.historydetail.b;

import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.eventkit.task.api.IEventTaskRecordApi;
import com.obric.eventkit.task.model.EventTaskExecutionDetailRecord;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.util.List;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: GetHistoryStepUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: compiled from: GetHistoryStepUseCase.kt */
    @f(b = "GetHistoryStepUseCase.kt", c = {18, 19}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.history.historydetail.domain.GetHistoryStepUseCase$invoke$1")
    static final class a extends l implements m<i<? super List<? extends h>>, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f23889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f23890c;

        a(String r3, d<? super a> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f23889b = r3;
            super(2, r5);
        }

        public final Object a(i<? super List<? extends h>> r3, d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f23889b, r5);
            r0.f23890c = r3;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super List<? extends h>> r3, d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23888a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r11);
        L25:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            i r2 = (i) ZeusTransformUtils.preCheckCast(this.f23890c, i.class, "com.obric.aiagent.plugin");
            o.a(r11);
        L15:
            List r12 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
        L17:
            if (r12 == null) goto L20;
            List<h> r13 = c.a(r12);
            if (r13 == null) goto L20;
        L21:
            d<? super x> r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23890c = null;
            this.f23888a = 2;
            if (r2.emit(r13, r4) != r0) goto L25;
            return r0;
        L20:
            r13 = p.b();
            goto L21
        L10:
            o.a(r11);
            r2 = (i) ZeusTransformUtils.preCheckCast(this.f23890c, i.class, "com.obric.aiagent.plugin");
            IEventTaskRecordApi r14 = (IEventTaskRecordApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskRecordApi.class), IEventTaskRecordApi.class, "com.obric.aiagent.plugin");
            if (r14 == null) goto L16;
            String r6 = this.f23889b;
            d<? super List<EventTaskExecutionDetailRecord>> r9 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23890c = r2;
            this.f23888a = 1;
            r11 = r14.getExecutionDetailRecordsBySessionId(r6, 0, Integer.MAX_VALUE, r9);
            if (r11 != r0) goto L15;
            return r0;
        L16:
            r12 = null;
            goto L17
        }
    }

    public b() {
    }

    public final kotlinx.coroutines.b.h<List<h>> a(String r3) {
        d.h.b.o.e(r3, "sessionID");
        return j.a(j.a((m) ZeusTransformUtils.preCheckCast(new a(r3, null), m.class, "com.obric.aiagent.plugin")), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
    }
}
