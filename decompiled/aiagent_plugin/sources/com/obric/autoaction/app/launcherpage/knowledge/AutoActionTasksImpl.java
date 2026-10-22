package com.obric.autoaction.app.launcherpage.knowledge;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tasks.IAutoActionTasksApi;
import com.obric.event.task.base.report.k;
import com.obric.eventkit.ITaskManagerApi;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bs;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: AutoActionTasksImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionTasksImpl implements IAutoActionTasksApi {
    public static final a Companion = null;
    private static final String TAG = "AutoActionTasksImpl";

    /* JADX INFO: compiled from: AutoActionTasksImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AutoActionTasksImpl.kt */
    @f(b = "AutoActionTasksImpl.kt", c = {28, 32}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.knowledge.AutoActionTasksImpl$onReceiveKnowledge$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f23892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f23893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f23894d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f23895e;
        final /* synthetic */ String f;

        b(String r3, int r4, String r5, String r6, d<? super b> r7) {
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            this.f23893c = r3;
            this.f23894d = r4;
            this.f23895e = r5;
            this.f = r6;
            super(2, r8);
        }

        private static final String a() {
            return "fetchKnowledge succeeded retryCount=0";
        }

        /* JADX INFO: renamed from: lambda$YSfPTNTY-bhGOm17eCmeiUBmRr4, reason: not valid java name */
        public static /* synthetic */ String m519lambda$YSfPTNTYbhGOm17eCmeiUBmRr4(String r0, String r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ String lambda$_ERPLJ_n5smZMG5LAp62oPgtgSE() {
            return a();
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r8, d<?> r9) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f23893c, this.f23894d, this.f23895e, this.f, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r23) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f23892b;
            boolean r6 = true;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            o.a(r23);
        L25:
            Loog r3 = Loog.INSTANCE;
            final String r4 = this.f23895e;
            final String r0 = this.f;
            r3.ip(AutoActionTasksImpl.TAG, new $$Lambda$AutoActionTasksImpl$b$YSfPTNTYbhGOm17eCmeiUBmRr4(r4, r0), $$Lambda$AutoActionTasksImpl$b$_ERPLJ_n5smZMG5LAp62oPgtgSE.INSTANCE);
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ITaskManagerApi r5 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(this.f23891a, ITaskManagerApi.class, "com.obric.aiagent.plugin");
            o.a(r23);
            Object r8 = r23;
        L16:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() != true) goto L18;
            ITaskManagerApi r9 = r5;
        L19:
            if (r6 == true) goto L22;
            Loog.INSTANCE.i(AutoActionTasksImpl.TAG, "onReceiveKnowledge skipped, auto learn disabled, taskId:" + this.f23893c + ", taskType:" + this.f23894d);
            return x.f38692a;
        L22:
            String r10 = this.f23893c;
            int r11 = this.f23894d;
            String r13 = this.f23895e;
            Integer r14 = d.c.b.a.b.a(0);
            String r7 = this.f;
            d r19 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23891a = null;
            this.f23892b = 2;
            if (ITaskManagerApi.b.a(r9, r10, r11, null, r13, r14, false, null, r7, true, r19, 64, null) != r1) goto L25;
            return r1;
        L18:
            r9 = r5;
            r6 = false;
            goto L19
        L10:
            o.a(r23);
            r5 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L18;
            String r12 = this.f23893c;
            d<? super Boolean> r15 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23891a = r5;
            this.f23892b = 1;
            r8 = r5.isKnowledgeLearningSwitchOn(r12, r15);
            if (r8 != r1) goto L16;
            return r1;
        }

        private static final String a(String r2, String r3) {
            StringBuilder r4 = new StringBuilder().append("fetchKnowledge succeeded  retryCount=0, knowledge:").append(r2).append(", evolutionInfoIsEmpty:");
            CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L5;
        L8:
            boolean r6 = true;
        L10:
            return r4.append(r6).toString();
        L5:
            if (r5.length() == 0) goto L8;
            r6 = false;
            goto L10
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoActionTasksImpl() {
    }

    @Override // com.obric.autogui.common.api.platform.tasks.IAutoActionTasksApi
    public void onReceiveKnowledge(String r10, int r11, String r12, String r13) {
        d.h.b.o.e(r10, DBDefinition.TASK_ID);
        d.h.b.o.e(r12, "knowledge");
        k.f32860a.a(true, "", true, 0);
        i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r10, r11, r12, r13, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
