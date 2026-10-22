package com.obric.autoaction.app.launcherpage.detail.shortcut.a;

import android.util.EventsUtils;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.utils.k;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.database.service.EventTaskService;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.api.IEventTaskExecutionApi;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.EventTaskResult;
import com.obric.eventkit.task.model.EventTaskSpec;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskSpec;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: ShortcutTaskDetailRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.autoaction.app.launcherpage.detail.base.a.b<ShortcutTask, ShortcutTaskSpec> {
    private static final String TAG = "ShortcutTaskRepo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0516a f23481a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.detail.base.a.c f23482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.module.datasource.b f23483c;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.shortcut.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShortcutTaskDetailRepository.kt */
    public static final class C0516a {
        public /* synthetic */ C0516a(h r1) {
            this();
        }

        private C0516a() {
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskDetailRepository.kt */
    @d.c.b.a.f(b = "ShortcutTaskDetailRepository.kt", c = {51, 53, 56, 56, 59, 67}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.shortcut.repository.ShortcutTaskDetailRepository$add$1")
    static final class b extends l implements m<i<? super EventTaskResult>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ShortcutTaskSpec f23485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f23486c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f23487d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f23488e;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.shortcut.a.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ShortcutTaskDetailRepository.kt */
        @d.c.b.a.f(b = "ShortcutTaskDetailRepository.kt", c = {61, 65, 65}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.shortcut.repository.ShortcutTaskDetailRepository$add$1$result$1")
        static final class C0517a extends l implements m<am, d.c.d<? super EventTaskResult>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f23489a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f23490b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f23491c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f23492d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f23493e;
            final /* synthetic */ ShortcutTaskSpec f;
            private /* synthetic */ Object g;

            /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.shortcut.a.a$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ShortcutTaskDetailRepository.kt */
            @d.c.b.a.f(b = "ShortcutTaskDetailRepository.kt", c = {60}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.shortcut.repository.ShortcutTaskDetailRepository$add$1$result$1$extDeferred$1")
            static final class C0518a extends l implements m<am, d.c.d<? super Map<String, ? extends String>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f23494a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f23495b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f23496c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ ShortcutTaskSpec f23497d;

                C0518a(String r3, String r4, ShortcutTaskSpec r5, d.c.d<? super C0518a> r6) {
                    d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f23495b = r3;
                    this.f23496c = r4;
                    this.f23497d = r5;
                    super(2, r7);
                }

                public final Object a(am r3, d.c.d<? super Map<String, String>> r4) {
                    return ((C0518a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0518a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
                    d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new C0518a(this.f23495b, this.f23496c, this.f23497d, r6), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(am r3, d.c.d<? super Map<String, ? extends String>> r4) {
                    return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r8) {
                    Object r0 = d.c.a.b.a();
                    int r1 = this.f23494a;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    o.a(r8);
                L11:
                    return r8;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    o.a(r8);
                    k r9 = k.f24509a;
                    String r2 = this.f23495b;
                    String r3 = this.f23496c;
                    Map<String, String> r4 = this.f23497d.getExt();
                    d.c.d<? super Map<String, String>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f23494a = 1;
                    r8 = r9.a(r2, r3, r4, r5);
                    if (r8 != r0) goto L11;
                    return r0;
                }
            }

            C0517a(a r3, String r4, String r5, ShortcutTaskSpec r6, d.c.d<? super C0517a> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23491c = r3;
                this.f23492d = r4;
                this.f23493e = r5;
                this.f = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super EventTaskResult> r4) {
                return ((C0517a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0517a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
                C0517a r11 = new C0517a(this.f23491c, this.f23492d, this.f23493e, this.f, r7);
                r11.g = r9;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super EventTaskResult> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r23) {
                Object r1 = d.c.a.b.a();
                int r2 = this.f23490b;
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L11;
                if (r2 == 2) goto L10;
                if (r2 != 3) goto L9;
                o.a(r23);
                Object r0 = r23;
            L29:
                return (EventTaskResult) ZeusTransformUtils.preCheckCast(r0, EventTaskResult.class, "com.obric.aiagent.plugin");
            L9:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L10:
                ShortcutTaskSpec r3 = (ShortcutTaskSpec) ZeusTransformUtils.preCheckCast(this.f23489a, ShortcutTaskSpec.class, "com.obric.aiagent.plugin");
                IEventTaskApi r4 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(this.g, IEventTaskApi.class, "com.obric.aiagent.plugin");
                o.a(r23);
                ShortcutTaskSpec r8 = r3;
                Object r5 = r23;
            L25:
                EventTaskSpec r6 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(ShortcutTaskSpec.copy$default(r8, null, null, null, null, null, null, null, (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin"), null, null, null, 1919, null), EventTaskSpec.class, "com.obric.aiagent.plugin");
                d.c.d<? super EventTaskResult> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.g = null;
                this.f23489a = null;
                this.f23490b = 3;
                r0 = r4.addEventTask(r6, r7);
                if (r0 != r1) goto L29;
                return r1;
            L11:
                au r9 = (au) ZeusTransformUtils.preCheckCast(this.g, au.class, "com.obric.aiagent.plugin");
                o.a(r23);
                Object r10 = r23;
            L15:
                EventTaskResult r11 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.b.a((com.obric.autoaction.app.launcherpage.detail.base.a.d) ZeusTransformUtils.preCheckCast(r10, com.obric.autoaction.app.launcherpage.detail.base.a.d.class, "com.obric.aiagent.plugin"));
                if (r11 == null) goto L19;
                ca.a.a((ca) ZeusTransformUtils.preCheckCast(r9, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
                return r11;
            L19:
                IEventTaskApi r12 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
                if (r12 == null) goto L30;
                r8 = this.f;
                d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.g = r12;
                this.f23489a = r8;
                this.f23490b = 2;
                r5 = r9.a(r13);
                if (r5 != r1) goto L24;
                return r1;
            L24:
                r4 = r12;
                goto L25
            L30:
                return null;
            L12:
                o.a(r23);
                r9 = kotlinx.coroutines.i.b((am) ZeusTransformUtils.preCheckCast(this.g, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new C0518a(this.f23492d, this.f23493e, this.f, null), m.class, "com.obric.aiagent.plugin"), 3, null);
                com.obric.autoaction.app.launcherpage.detail.base.a.c r14 = a.a(this.f23491c);
                String r15 = this.f23492d;
                String r16 = this.f23493e;
                d.c.d<? super com.obric.autoaction.app.launcherpage.detail.base.a.d> r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.g = r9;
                this.f23490b = 1;
                r10 = r14.a(r15, r16, "shortcut", r17);
                if (r10 != r1) goto L15;
                return r1;
            }
        }

        b(ShortcutTaskSpec r3, a r4, String r5, d.c.d<? super b> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23485b = r3;
            this.f23486c = r4;
            this.f23487d = r5;
            super(2, r7);
        }

        public final Object a(i<? super EventTaskResult> r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f23485b, this.f23486c, this.f23487d, r7);
            r0.f23488e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super EventTaskResult> r3, d.c.d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r2 = 0;
            switch(this.f23484a) {
                case 0: goto L12;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            o.a(r14);
        L45:
            return x.f38692a;
        L7:
            i r1 = (i) ZeusTransformUtils.preCheckCast(this.f23488e, i.class, "com.obric.aiagent.plugin");
            o.a(r14);
        L41:
            EventTaskResult r15 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r14, EventTaskResult.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23488e = null;
            this.f23484a = 6;
            if (r1.emit(r15, r3) != r0) goto L45;
            return r0;
        L8:
            o.a(r14);
        L37:
            return x.f38692a;
        L9:
            r1 = (i) ZeusTransformUtils.preCheckCast(this.f23488e, i.class, "com.obric.aiagent.plugin");
            o.a(r14);
        L31:
            EventTaskResult r16 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.b.a((com.obric.autoaction.app.launcherpage.detail.base.a.d) ZeusTransformUtils.preCheckCast(r14, com.obric.autoaction.app.launcherpage.detail.base.a.d.class, "com.obric.aiagent.plugin"));
            if (r16 == null) goto L38;
            this.f23488e = null;
            this.f23484a = 4;
            if (r1.emit(r16, this) != r0) goto L37;
            return r0;
        L38:
            m r17 = (m) ZeusTransformUtils.preCheckCast(new C0517a(this.f23486c, this.f23487d, com.obric.autoaction.app.launcherpage.detail.shortcut.data.e.a(this.f23485b), this.f23485b, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23488e = r1;
            this.f23484a = 5;
            r14 = an.a(r17, r4);
            if (r14 != r0) goto L41;
            return r0;
        L10:
            o.a(r14);
        L27:
            return x.f38692a;
        L11:
            r1 = (i) ZeusTransformUtils.preCheckCast(this.f23488e, i.class, "com.obric.aiagent.plugin");
            o.a(r14);
        L17:
            List r8 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
        L19:
            if (r8 == null) goto L22;
            r2 = r8.size();
        L22:
            if (r2 < 100) goto L28;
            EventTaskResult r18 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.b.a(this.f23485b, ZeusTransformUtils.mapRes(R.string.shortcut_count_exceed_limit, WsChannelMultiProcessSharedProvider.STRING_TYPE, "shortcut_count_exceed_limit"));
            d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23488e = null;
            this.f23484a = 2;
            if (r1.emit(r18, r5) != r0) goto L27;
            return r0;
        L28:
            com.obric.autoaction.app.launcherpage.detail.base.a.c r6 = a.a(this.f23486c);
            ShortcutTaskSpec r7 = this.f23485b;
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23488e = r1;
            this.f23484a = 3;
            r14 = com.obric.autoaction.app.launcherpage.detail.base.a.c.a(r6, r7, r8, null, r10, 4, null);
            if (r14 != r0) goto L31;
            return r0;
        L12:
            o.a(r14);
            r1 = (i) ZeusTransformUtils.preCheckCast(this.f23488e, i.class, "com.obric.aiagent.plugin");
            IEventTaskApi r19 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r19 == null) goto L18;
            d.c.d<? super List<? extends EventTask>> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23488e = r1;
            this.f23484a = 1;
            r14 = r19.getEventTasksByType(3, 0, Integer.MAX_VALUE, r9);
            if (r14 != r0) goto L17;
            return r0;
        L18:
            r8 = null;
            goto L19
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskDetailRepository.kt */
    @d.c.b.a.f(b = "ShortcutTaskDetailRepository.kt", c = {93, 94}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.shortcut.repository.ShortcutTaskDetailRepository$delete$1")
    static final class c extends l implements m<i<? super EventTaskResult>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f23499b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f23500c;

        c(String r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23499b = r3;
            super(2, r5);
        }

        public final Object a(i<? super EventTaskResult> r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f23499b, r5);
            r0.f23500c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super EventTaskResult> r3, d.c.d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23498a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            o.a(r10);
        L21:
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            i r2 = (i) ZeusTransformUtils.preCheckCast(this.f23500c, i.class, "com.obric.aiagent.plugin");
            o.a(r10);
        L15:
            EventTaskResult r11 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r10, EventTaskResult.class, "com.obric.aiagent.plugin");
        L17:
            d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23500c = null;
            this.f23498a = 2;
            if (r2.emit(r11, r4) != r0) goto L21;
            return r0;
        L10:
            o.a(r10);
            r2 = (i) ZeusTransformUtils.preCheckCast(this.f23500c, i.class, "com.obric.aiagent.plugin");
            EventTaskService r12 = (EventTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(EventTaskService.class), EventTaskService.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L16;
            String[] r6 = {this.f23499b};
            d.c.d<? super EventTaskResult> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23500c = r2;
            this.f23498a = 1;
            r10 = r12.removeEventTask(r6, r7);
            if (r10 != r0) goto L15;
            return r0;
        L16:
            r11 = null;
            goto L17
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskDetailRepository.kt */
    @d.c.b.a.f(b = "ShortcutTaskDetailRepository.kt", c = {47}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.shortcut.repository.ShortcutTaskDetailRepository$getTask$2")
    static final class d extends l implements m<am, d.c.d<? super ShortcutTask>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f23502b;

        d(String r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23502b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super ShortcutTask> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f23502b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super ShortcutTask> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23501a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L13:
            EventTask r6 = (EventTask) ZeusTransformUtils.preCheckCast(r7, EventTask.class, "com.obric.aiagent.plugin");
        L16:
            if (ZeusTransformUtils.instanceOf(r6, ShortcutTask.class) == true) goto L18;
            return null;
        L18:
            return (ShortcutTask) ZeusTransformUtils.preCheckCast(r6, ShortcutTask.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            IEventTaskApi r8 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L14;
            String r2 = this.f23502b;
            d.c.d<? super EventTask> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23501a = 1;
            r7 = r8.getEventTask(r2, r5);
            if (r7 != r0) goto L13;
            return r0;
        L14:
            r6 = null;
            goto L16
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskDetailRepository.kt */
    @d.c.b.a.f(b = "ShortcutTaskDetailRepository.kt", c = {106, 109, 110}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.shortcut.repository.ShortcutTaskDetailRepository$historyCount$1")
    static final class e extends l implements m<i<? super String>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f23504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f23505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f23506d;

        e(String r3, a r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23504b = r3;
            this.f23505c = r4;
            super(2, r6);
        }

        public final Object a(i<? super String> r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            e r0 = new e(this.f23504b, this.f23505c, r6);
            r0.f23506d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super String> r3, d.c.d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23503a;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            o.a(r9);
        L38:
            return x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            i r2 = (i) ZeusTransformUtils.preCheckCast(this.f23506d, i.class, "com.obric.aiagent.plugin");
            o.a(r9);
        L30:
            int r10 = ((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin")).size();
            if (r10 < 1000) goto L33;
            String r11 = "999+";
        L34:
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23506d = null;
            this.f23503a = 3;
            if (r2.emit(r11, r3) != r0) goto L38;
            return r0;
        L33:
            r11 = String.valueOf(r10);
            goto L34
        L11:
            o.a(r9);
        L26:
            return x.f38692a;
        L12:
            o.a(r9);
            r2 = (i) ZeusTransformUtils.preCheckCast(this.f23506d, i.class, "com.obric.aiagent.plugin");
            String r12 = this.f23504b;
            if (r12 != null) goto L15;
        L20:
            r12 = null;
        L21:
            if (r12 != null) goto L27;
            d.c.d<? super x> r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23503a = 1;
            if (r2.emit("0", r13) != r0) goto L26;
            return r0;
        L27:
            com.obric.autoaction.app.launcherpage.module.datasource.b r5 = a.b(this.f23505c);
            d.c.d<? super List<com.obric.autoaction.app.launcherpage.module.datasource.d>> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23506d = r2;
            this.f23503a = 2;
            r9 = r5.b(r12, r7);
            if (r9 != r0) goto L30;
            return r0;
        L15:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L17;
            boolean r8 = true;
        L18:
            if (r8 == false) goto L20;
        L17:
            r8 = false;
            goto L18
        }
    }

    /* JADX INFO: compiled from: ShortcutTaskDetailRepository.kt */
    @d.c.b.a.f(b = "ShortcutTaskDetailRepository.kt", c = {76, 77, 77, 80, EventsUtils.FEAT_TYPE_PROC_FREQUENT_RESTART}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.shortcut.repository.ShortcutTaskDetailRepository$update$1")
    static final class f extends l implements m<i<? super EventTaskResult>, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f23508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ShortcutTaskSpec f23509c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f23510d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f23511e;
        private /* synthetic */ Object f;

        /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.shortcut.a.a$f$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ShortcutTaskDetailRepository.kt */
        @d.c.b.a.f(b = "ShortcutTaskDetailRepository.kt", c = {82, 86, 86}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.shortcut.repository.ShortcutTaskDetailRepository$update$1$result$1")
        static final class C0519a extends l implements m<am, d.c.d<? super EventTaskResult>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f23512a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f23513b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f23514c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f23515d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f23516e;
            final /* synthetic */ String f;
            final /* synthetic */ String g;
            final /* synthetic */ ShortcutTaskSpec h;
            private /* synthetic */ Object i;

            /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.shortcut.a.a$f$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ShortcutTaskDetailRepository.kt */
            @d.c.b.a.f(b = "ShortcutTaskDetailRepository.kt", c = {81}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.detail.shortcut.repository.ShortcutTaskDetailRepository$update$1$result$1$extDeferred$1")
            static final class C0520a extends l implements m<am, d.c.d<? super Map<String, ? extends String>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f23517a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f23518b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f23519c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ ShortcutTaskSpec f23520d;

                C0520a(String r3, String r4, ShortcutTaskSpec r5, d.c.d<? super C0520a> r6) {
                    d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f23518b = r3;
                    this.f23519c = r4;
                    this.f23520d = r5;
                    super(2, r7);
                }

                public final Object a(am r3, d.c.d<? super Map<String, String>> r4) {
                    return ((C0520a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0520a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
                    d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new C0520a(this.f23518b, this.f23519c, this.f23520d, r6), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(am r3, d.c.d<? super Map<String, ? extends String>> r4) {
                    return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r8) {
                    Object r0 = d.c.a.b.a();
                    int r1 = this.f23517a;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    o.a(r8);
                L11:
                    return r8;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    o.a(r8);
                    k r9 = k.f24509a;
                    String r2 = this.f23518b;
                    String r3 = this.f23519c;
                    Map<String, String> r4 = this.f23520d.getExt();
                    d.c.d<? super Map<String, String>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f23517a = 1;
                    r8 = r9.a(r2, r3, r4, r5);
                    if (r8 != r0) goto L11;
                    return r0;
                }
            }

            C0519a(a r3, String r4, String r5, String r6, ShortcutTaskSpec r7, d.c.d<? super C0519a> r8) {
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                this.f23515d = r3;
                this.f23516e = r4;
                this.f = r5;
                this.g = r6;
                this.h = r7;
                super(2, r9);
            }

            public final Object a(am r3, d.c.d<? super EventTaskResult> r4) {
                return ((C0519a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0519a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r10, d.c.d<?> r11) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
                C0519a r12 = new C0519a(this.f23515d, this.f23516e, this.f, this.g, this.h, r8);
                r12.i = r10;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super EventTaskResult> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r23) {
                Object r1 = d.c.a.b.a();
                int r2 = this.f23514c;
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L11;
                if (r2 == 2) goto L10;
                if (r2 != 3) goto L9;
                o.a(r23);
                Object r0 = r23;
            L29:
                return (EventTaskResult) ZeusTransformUtils.preCheckCast(r0, EventTaskResult.class, "com.obric.aiagent.plugin");
            L9:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L10:
                ShortcutTaskSpec r3 = (ShortcutTaskSpec) ZeusTransformUtils.preCheckCast(this.f23513b, ShortcutTaskSpec.class, "com.obric.aiagent.plugin");
                String r4 = (String) ZeusTransformUtils.preCheckCast(this.f23512a, String.class, "com.obric.aiagent.plugin");
                IEventTaskApi r5 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(this.i, IEventTaskApi.class, "com.obric.aiagent.plugin");
                o.a(r23);
                ShortcutTaskSpec r8 = r3;
                Object r6 = r23;
            L25:
                EventTaskSpec r7 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(ShortcutTaskSpec.copy$default(r8, null, null, null, null, null, null, null, (Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin"), null, null, null, 1919, null), EventTaskSpec.class, "com.obric.aiagent.plugin");
                d.c.d<? super EventTaskResult> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.i = null;
                this.f23512a = null;
                this.f23513b = null;
                this.f23514c = 3;
                r0 = r5.updateEventTask(r4, r7, r9);
                if (r0 != r1) goto L29;
                return r1;
            L11:
                au r10 = (au) ZeusTransformUtils.preCheckCast(this.i, au.class, "com.obric.aiagent.plugin");
                o.a(r23);
                Object r11 = r23;
            L15:
                EventTaskResult r12 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.b.a((com.obric.autoaction.app.launcherpage.detail.base.a.d) ZeusTransformUtils.preCheckCast(r11, com.obric.autoaction.app.launcherpage.detail.base.a.d.class, "com.obric.aiagent.plugin"));
                if (r12 == null) goto L19;
                ca.a.a((ca) ZeusTransformUtils.preCheckCast(r10, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
                return r12;
            L19:
                r5 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
                if (r5 == null) goto L30;
                String r13 = this.g;
                ShortcutTaskSpec r14 = this.h;
                d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.i = r5;
                this.f23512a = r13;
                this.f23513b = r14;
                this.f23514c = 2;
                r6 = r10.a(r15);
                if (r6 != r1) goto L24;
                return r1;
            L24:
                r4 = r13;
                r8 = r14;
                goto L25
            L30:
                return null;
            L12:
                o.a(r23);
                r10 = kotlinx.coroutines.i.b((am) ZeusTransformUtils.preCheckCast(this.i, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new C0520a(this.f23516e, this.f, this.h, null), m.class, "com.obric.aiagent.plugin"), 3, null);
                com.obric.autoaction.app.launcherpage.detail.base.a.c r16 = a.a(this.f23515d);
                String r17 = this.f23516e;
                String r18 = this.f;
                d.c.d<? super com.obric.autoaction.app.launcherpage.detail.base.a.d> r19 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.i = r10;
                this.f23514c = 1;
                r11 = r16.a(r17, r18, "shortcut", r19);
                if (r11 != r1) goto L15;
                return r1;
            }
        }

        f(a r3, ShortcutTaskSpec r4, String r5, String r6, d.c.d<? super f> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23508b = r3;
            this.f23509c = r4;
            this.f23510d = r5;
            this.f23511e = r6;
            super(2, r8);
        }

        public final Object a(i<? super EventTaskResult> r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            f r11 = new f(this.f23508b, this.f23509c, this.f23510d, this.f23511e, r7);
            r11.f = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(i<? super EventTaskResult> r3, d.c.d<? super x> r4) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f23507a;
            if (r2 == 0) goto L16;
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L14;
            if (r2 == 3) goto L13;
            if (r2 == 4) goto L12;
            if (r2 != 5) goto L11;
            o.a(r18);
        L40:
            return x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            i r3 = (i) ZeusTransformUtils.preCheckCast(this.f, i.class, "com.obric.aiagent.plugin");
            o.a(r18);
            Object r4 = r18;
        L36:
            EventTaskResult r5 = (EventTaskResult) ZeusTransformUtils.preCheckCast(r4, EventTaskResult.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = null;
            this.f23507a = 5;
            if (r3.emit(r5, r6) != r1) goto L40;
            return r1;
        L13:
            o.a(r18);
        L32:
            return x.f38692a;
        L14:
            r3 = (i) ZeusTransformUtils.preCheckCast(this.f, i.class, "com.obric.aiagent.plugin");
            o.a(r18);
            Object r7 = r18;
        L26:
            EventTaskResult r8 = com.obric.autoaction.app.launcherpage.detail.shortcut.a.b.a((com.obric.autoaction.app.launcherpage.detail.base.a.d) ZeusTransformUtils.preCheckCast(r7, com.obric.autoaction.app.launcherpage.detail.base.a.d.class, "com.obric.aiagent.plugin"));
            if (r8 == null) goto L33;
            this.f = null;
            this.f23507a = 3;
            if (r3.emit(r8, this) != r1) goto L32;
            return r1;
        L33:
            m r9 = (m) ZeusTransformUtils.preCheckCast(new C0519a(this.f23508b, this.f23511e, com.obric.autoaction.app.launcherpage.detail.shortcut.data.e.a(this.f23509c), this.f23510d, this.f23509c, null), m.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            this.f23507a = 4;
            r4 = an.a(r9, r10);
            if (r4 != r1) goto L36;
            return r1;
        L15:
            r3 = (i) ZeusTransformUtils.preCheckCast(this.f, i.class, "com.obric.aiagent.plugin");
            o.a(r18);
            Object r11 = r18;
        L21:
            List<? extends EventTask> r12 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
        L23:
            com.obric.autoaction.app.launcherpage.detail.base.a.c r13 = a.a(this.f23508b);
            ShortcutTaskSpec r14 = this.f23509c;
            String r15 = this.f23510d;
            d.c.d<? super com.obric.autoaction.app.launcherpage.detail.base.a.d> r16 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            this.f23507a = 2;
            r7 = r13.a(r14, r12, r15, r16);
            if (r7 != r1) goto L26;
            return r1;
        L16:
            o.a(r18);
            r3 = (i) ZeusTransformUtils.preCheckCast(this.f, i.class, "com.obric.aiagent.plugin");
            IEventTaskApi r17 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
            if (r17 == null) goto L22;
            d.c.d<? super List<? extends EventTask>> r19 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            this.f23507a = 1;
            r11 = r17.getEventTasksByType(3, 0, Integer.MAX_VALUE, r19);
            if (r11 != r1) goto L21;
            return r1;
        L22:
            r12 = null;
            goto L23
        }
    }

    static {
        f23481a = new C0516a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public a(com.obric.autoaction.app.launcherpage.detail.base.a.c r3, com.obric.autoaction.app.launcherpage.module.datasource.b r4) {
        com.obric.autoaction.app.launcherpage.module.datasource.b r5 = (com.obric.autoaction.app.launcherpage.module.datasource.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.module.datasource.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "validator");
        d.h.b.o.e(r5, "timerTaskRepo");
        this.f23482b = r3;
        this.f23483c = r5;
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.a.c a(a r0) {
        return r0.f23482b;
    }

    public static final /* synthetic */ com.obric.autoaction.app.launcherpage.module.datasource.b b(a r0) {
        return r0.f23483c;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.a.b
    public /* synthetic */ Object a(String r3, EventTask r4, d.c.d r5) {
        d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return a(r3, (ShortcutTask) ZeusTransformUtils.preCheckCast(r4, ShortcutTask.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.a.b
    public /* synthetic */ kotlinx.coroutines.b.h a(EventTaskSpec r3, String r4, String r5) {
        return a((ShortcutTaskSpec) ZeusTransformUtils.preCheckCast(r3, ShortcutTaskSpec.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.a.b
    public /* synthetic */ kotlinx.coroutines.b.h update(String r3, EventTaskSpec r4, String r5, boolean r6) {
        return update(r3, (ShortcutTaskSpec) ZeusTransformUtils.preCheckCast(r4, ShortcutTaskSpec.class, "com.obric.aiagent.plugin"), r5, r6);
    }

    public /* synthetic */ a(com.obric.autoaction.app.launcherpage.detail.base.a.c r2, com.obric.autoaction.app.launcherpage.module.datasource.b r3, int r4, h r5) {
        com.obric.autoaction.app.launcherpage.module.datasource.b r6 = (com.obric.autoaction.app.launcherpage.module.datasource.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.module.datasource.b.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = new com.obric.autoaction.app.launcherpage.detail.base.a.c();
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = (com.obric.autoaction.app.launcherpage.module.datasource.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.datasource.i(), com.obric.autoaction.app.launcherpage.module.datasource.b.class, "com.obric.aiagent.plugin");
    L8:
        this(r2, r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.a.b
    public Object a(String r4, d.c.d<? super ShortcutTask> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new d(r4, null), m.class, "com.obric.aiagent.plugin"), r3);
    }

    public kotlinx.coroutines.b.h<EventTaskResult> a(ShortcutTaskSpec r2, String r3, String r4) {
        d.h.b.o.e(r2, "spec");
        d.h.b.o.e(r3, "oldQuery");
        return j.a(j.a((m) ZeusTransformUtils.preCheckCast(new b(r2, this, r3, null), m.class, "com.obric.aiagent.plugin")), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
    }

    public kotlinx.coroutines.b.h<EventTaskResult> update(String r7, ShortcutTaskSpec r8, String r9, boolean r10) {
        d.h.b.o.e(r7, DBDefinition.TASK_ID);
        d.h.b.o.e(r8, "spec");
        d.h.b.o.e(r9, "oldQuery");
        return j.a(j.a((m) ZeusTransformUtils.preCheckCast(new f(this, r8, r7, r9, null), m.class, "com.obric.aiagent.plugin")), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.a.b
    public kotlinx.coroutines.b.h<EventTaskResult> delete(String r3) {
        d.h.b.o.e(r3, DBDefinition.TASK_ID);
        return j.a(j.a((m) ZeusTransformUtils.preCheckCast(new c(r3, null), m.class, "com.obric.aiagent.plugin")), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
    }

    public Object a(String r3, ShortcutTask r4, d.c.d<? super x> r5) {
        d.c.d<? super x> r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "testRun, taskId: " + r3);
        if (r3 == null) goto L5;
        IEventTaskExecutionApi r6 = (IEventTaskExecutionApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskExecutionApi.class), IEventTaskExecutionApi.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L14;
        Object r7 = r6.scheduleShortcutTask(r3, "shortcut_detail", r2);
        if (r7 != d.c.a.b.a()) goto L12;
        return r7;
    L12:
        return x.f38692a;
    L14:
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.a.b
    public kotlinx.coroutines.b.h<String> a(String r3) {
        return j.a(j.a((m) ZeusTransformUtils.preCheckCast(new e(r3, this, null), m.class, "com.obric.aiagent.plugin")), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
    }
}
