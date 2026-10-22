package com.obric.autoaction.app.launcherpage.history.historydetail;

import androidx.lifecycle.aj;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.history.historydetail.a.c;
import com.obric.autoaction.app.launcherpage.history.historydetail.a.e;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.a.q;
import d.o;
import d.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.x;

/* JADX INFO: compiled from: HistoryDetailViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.history.historydetail.b.b f23872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.history.historydetail.b.a f23873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x<com.obric.autoaction.app.launcherpage.history.historydetail.a> f23874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ak<com.obric.autoaction.app.launcherpage.history.historydetail.a> f23875d;

    /* JADX INFO: compiled from: HistoryDetailViewModel.kt */
    @f(b = "HistoryDetailViewModel.kt", c = {37}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.history.historydetail.HistoryDetailViewModel$init$1")
    static final class a extends l implements m<am, d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f23877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f23878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f23879d;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.history.historydetail.b$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: HistoryDetailViewModel.kt */
        @f(b = "HistoryDetailViewModel.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.history.historydetail.HistoryDetailViewModel$init$1$1")
        static final class AnonymousClass1 extends l implements q<EventTaskExecutionRecord, List<? extends h>, d<? super com.obric.autoaction.app.launcherpage.history.historydetail.a.c>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f23880a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f23881b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f23882c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ b f23883d;

            AnonymousClass1(b r3, d<? super AnonymousClass1> r4) {
                d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                this.f23883d = r3;
                super(3, r5);
            }

            public final Object a(EventTaskExecutionRecord r3, List<? extends h> r4, d<? super com.obric.autoaction.app.launcherpage.history.historydetail.a.c> r5) {
                List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
                d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.f23883d, r7);
                r0.f23881b = r3;
                r0.f23882c = r6;
                return r0.invokeSuspend(d.x.f38692a);
            }

            @Override // d.h.a.q
            public /* synthetic */ Object invoke(EventTaskExecutionRecord r3, List<? extends h> r4, d<? super com.obric.autoaction.app.launcherpage.history.historydetail.a.c> r5) {
                return a((EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r3, EventTaskExecutionRecord.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f23880a != 0) goto L7;
                o.a(r4);
                EventTaskExecutionRecord r5 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(this.f23881b, EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");
                List r0 = (List) ZeusTransformUtils.preCheckCast(this.f23882c, List.class, "com.obric.aiagent.plugin");
                return new com.obric.autoaction.app.launcherpage.history.historydetail.a.c(b.a(this.f23883d, r5, r0));
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        a(b r3, long r4, String r6, d<? super a> r7) {
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            this.f23877b = r3;
            this.f23878c = r4;
            this.f23879d = r6;
            super(2, r8);
        }

        public final Object a(am r3, d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<d.x> create(Object r8, d<?> r9) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new a(this.f23877b, this.f23878c, this.f23879d, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23876a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            kotlinx.coroutines.b.h r8 = j.b(b.a(this.f23877b).a(this.f23878c), b.b(this.f23877b).a(this.f23879d), (q) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f23877b, null), q.class, "com.obric.aiagent.plugin"));
            final b r3 = this.f23877b;
            i r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r3), i.class, "com.obric.aiagent.plugin");
            d<? super d.x> r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23876a = 1;
            if (r8.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.history.historydetail.b.a a(b r0) {
        return r0.f23873b;
    }

    public static final /* synthetic */ List a(b r2, EventTaskExecutionRecord r3, List r4) {
        return r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.history.historydetail.b.b b(b r0) {
        return r0.f23872a;
    }

    public static final /* synthetic */ x c(b r0) {
        return r0.f23874c;
    }

    public /* synthetic */ b(com.obric.autoaction.app.launcherpage.history.historydetail.b.b r1, com.obric.autoaction.app.launcherpage.history.historydetail.b.a r2, int r3, d.h.b.h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = new com.obric.autoaction.app.launcherpage.history.historydetail.b.b();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = new com.obric.autoaction.app.launcherpage.history.historydetail.b.a();
    L8:
        this(r1, r2);
    }

    public b(com.obric.autoaction.app.launcherpage.history.historydetail.b.b r2, com.obric.autoaction.app.launcherpage.history.historydetail.b.a r3) {
        d.h.b.o.e(r2, "getHistoryStepList");
        d.h.b.o.e(r3, "getHistoryDetail");
        this.f23872a = r2;
        this.f23873b = r3;
        x<com.obric.autoaction.app.launcherpage.history.historydetail.a> r4 = kotlinx.coroutines.b.am.a(com.obric.autoaction.app.launcherpage.history.historydetail.a.b.f23854a);
        this.f23874c = r4;
        this.f23875d = (ak) ZeusTransformUtils.preCheckCast(r4, ak.class, "com.obric.aiagent.plugin");
    }

    public final ak<com.obric.autoaction.app.launcherpage.history.historydetail.a> b() {
        return this.f23875d;
    }

    public final void a(long r10, String r12) {
        d.h.b.o.e(r12, "sessionID");
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new a(this, r10, r12, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final List<h> a(EventTaskExecutionRecord r10, List<? extends h> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L5;
        List<h> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r0.add(new e(p.a(ZeusTransformUtils.mapRes(R.string.history_detail_query_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_detail_query_title"), null, 1, null)));
        String r3 = r10.getQuery();
        String r7 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r0.add(new c(r3));
        r0.add(new e(p.a(ZeusTransformUtils.mapRes(R.string.history_detail_result_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_detail_result_title"), null, 1, null)));
        String r4 = r10.getResultMessage();
        if (r4 == null) goto L13;
        r7 = r4;
    L13:
        r0.add(new c(r7));
        if (r12.isEmpty() == true) goto L17;
        r0.add(new e(p.a(ZeusTransformUtils.mapRes(R.string.history_detail_process_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_detail_process_title"), null, 1, null)));
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin"));
        d.m<Integer, String> r9 = a(r10.getResultCode());
        r0.add(new com.obric.autoaction.app.launcherpage.history.historydetail.a.h((Integer) ZeusTransformUtils.preCheckCast(r9.a(), Integer.class, "com.obric.aiagent.plugin"), null, (String) ZeusTransformUtils.preCheckCast(r9.b(), String.class, "com.obric.aiagent.plugin"), 3));
        r0.add(new com.obric.autoaction.app.launcherpage.history.historydetail.a.a(p.a(ZeusTransformUtils.mapRes(R.string.history_detail_bottom_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "history_detail_bottom_tips"), null, 1, null)));
    L17:
        return r0;
    L5:
        return d.a.p.b();
    }

    private final d.m<Integer, String> a(int r5) {
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L19;
        if (r5 == 3) goto L18;
        if (r5 == 4) goto L17;
        return s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_history_fail, "drawable", "ic_history_fail")), p.a(com.obric.autoaction.app.launcherpage.module.a.a.h.a.f24019a.a(), null, 1, null));
    L17:
        return s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_history_fail, "drawable", "ic_history_fail")), p.a(com.obric.autoaction.app.launcherpage.module.a.a.h.a.f24022d.a(), null, 1, null));
    L18:
        return s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_history_fail, "drawable", "ic_history_fail")), p.a(com.obric.autoaction.app.launcherpage.module.a.a.h.a.f24022d.a(), null, 1, null));
    L19:
        return s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_history_manual_finish, "drawable", "ic_history_manual_finish")), p.a(com.obric.autoaction.app.launcherpage.module.a.a.h.a.f24023e.a(), null, 1, null));
    L15:
        return s.a(Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_history_success, "drawable", "ic_history_success")), p.a(com.obric.autoaction.app.launcherpage.module.a.a.h.a.f24021c.a(), null, 1, null));
    }
}
