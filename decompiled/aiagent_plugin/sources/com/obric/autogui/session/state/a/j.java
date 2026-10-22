package com.obric.autogui.session.state.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.impl.applist.black.r;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.obric.autogui.common.api.space.IOperatingSpaceManager;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.oui.dialog.base.AbstractDialog;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import d.x;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: StatePreparing.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends com.obric.autogui.session.state.a {
    private static final String TAG = "S-Prep";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f31252b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f31253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m f31254d;

    /* JADX INFO: compiled from: StatePreparing.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31255a = null;

        static {
            int[] r0 = new int[IAutoActionRemoteAgentApi.ErrorType.values().length];
            r0[IAutoActionRemoteAgentApi.ErrorType.NetworkError.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[IAutoActionRemoteAgentApi.ErrorType.ClientError.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[IAutoActionRemoteAgentApi.ErrorType.ServiceError.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[IAutoActionRemoteAgentApi.ErrorType.QueueFull.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[IAutoActionRemoteAgentApi.ErrorType.ApiError.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f31255a = r0;
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    @d.c.b.a.f(b = "StatePreparing.kt", c = {122}, d = "changeTo", e = "com.obric.autogui.session.state.impl.StatePreparing")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ j f31259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31260e;

        c(j r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31259d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31258c = r3;
            this.f31260e |= Integer.MIN_VALUE;
            return this.f31259d.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    @d.c.b.a.f(b = "StatePreparing.kt", c = {287}, d = "checkPreparing", e = "com.obric.autogui.session.state.impl.StatePreparing")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31263c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ j f31264d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31265e;

        d(j r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31264d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31263c = r3;
            this.f31265e |= Integer.MIN_VALUE;
            return j.b(this.f31264d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    @d.c.b.a.f(b = "StatePreparing.kt", c = {292}, d = "invokeSuspend", e = "com.obric.autogui.session.state.impl.StatePreparing$checkPreparing$2")
    static final class e extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f31267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.f<com.obric.autogui.common.e> f31268c;

        e(z.f<com.obric.autogui.common.e> r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31268c = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super Boolean> r3) {
            return ((e) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f31268c, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31267b;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            z.f<com.obric.autogui.common.e> r2 = (z.f) ZeusTransformUtils.preCheckCast(this.f31266a, z.f.class, "com.obric.aiagent.plugin");
            d.o.a(r6);
            T r7 = r6;
        L12:
            r2.f38504a = r7;
            return d.c.b.a.b.a(!((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(this.f31268c.f38504a, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin")).g());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            z.f<com.obric.autogui.common.e> r8 = this.f31268c;
            com.obric.autogui.session.state.c r3 = com.obric.autogui.session.state.c.f31395a;
            d.c.d<? super com.obric.autogui.common.e> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31266a = r8;
            this.f31267b = 1;
            Object r5 = r3.a(r4);
            if (r5 != r0) goto L11;
            return r0;
        L11:
            r2 = r8;
            r7 = r5;
            goto L12
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    @d.c.b.a.f(b = "StatePreparing.kt", c = {67}, d = "createSpace", e = "com.obric.autogui.session.state.impl.StatePreparing")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f31271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31272d;

        f(j r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31271c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31270b = r3;
            this.f31272d |= Integer.MIN_VALUE;
            return j.a(this.f31271c, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    @d.c.b.a.f(b = "StatePreparing.kt", c = {461}, d = "invokeSuspend", e = "com.obric.autogui.session.state.impl.StatePreparing$enterProcessingDirectly$1")
    static final class g extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f31274b;

        g(j r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31274b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((g) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f31274b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31273a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r12);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r12);
            Loog.INSTANCE.i(j.TAG, "no-need to queue; enter OPERATING directly");
            com.obric.autogui.session.state.b r13 = this.f31274b.e();
            BizStatus r2 = BizStatus.OPERATING;
            BizStatus.StatusChangedReasonStruct r10 = new BizStatus.StatusChangedReasonStruct(com.obric.autogui.session.state.a.h.b.f31241a.a(), null, null, null, 14, null);
            d.c.d<? super com.obric.autogui.common.e> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31273a = 1;
            if (r13.a(r2, r10, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    @d.c.b.a.f(b = "StatePreparing.kt", c = {308}, d = "enterQueueState", e = "com.obric.autogui.session.state.impl.StatePreparing")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f31277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31278d;

        h(j r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31277c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31276b = r3;
            this.f31278d |= Integer.MIN_VALUE;
            return j.c(this.f31277c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    @d.c.b.a.f(b = "StatePreparing.kt", c = {180}, d = "invokeSuspend", e = "com.obric.autogui.session.state.impl.StatePreparing$initializeVirtualDisplayRecordSet$2")
    static final class i extends d.c.b.a.l implements d.h.a.b<d.c.d<? super com.obric.autogui.session.state.a.f>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f31280b;

        i(j r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31280b = r3;
            super(1, r5);
        }

        public static /* synthetic */ x lambda$jYjQLa3ALxYmRB6T1gSH_l8pfUo(DisplayOperatingSpace r0, j r1) {
            return a(r0, r1);
        }

        public final Object a(d.c.d<? super com.obric.autogui.session.state.a.f> r3) {
            return ((i) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f31280b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super com.obric.autogui.session.state.a.f> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31279a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            com.obric.autogui.common.d r7 = (com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin");
            IOperatingSpaceManager.OpSpaceCreationResult r2 = (IOperatingSpaceManager.OpSpaceCreationResult) ZeusTransformUtils.preCheckCast(r7.a(), IOperatingSpaceManager.OpSpaceCreationResult.class, "com.obric.aiagent.plugin");
            Integer r3 = null;
            if (r2 == null) goto L14;
            AOOperatingSpace r4 = r2.getSpace();
        L16:
            if (ZeusTransformUtils.instanceOf(r4, DisplayOperatingSpace.class) == false) goto L18;
            final DisplayOperatingSpace r5 = (DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r4, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        L19:
            j.a(this.f31280b, com.obric.autogui.session.state.a.n.f31348b, r5);
            com.obric.autogui.common.e r8 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r7, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L22;
            r3 = d.c.b.a.b.a(r5.getDisplayId());
        L22:
            com.obric.autogui.session.state.a.n r9 = com.obric.autogui.session.state.a.n.f31348b;
            final j r10 = this.f31280b;
            return new com.obric.autogui.session.state.a.f(r8, r3, r9, new $$Lambda$j$i$jYjQLa3ALxYmRB6T1gSH_l8pfUo(r5, r10));
        L18:
            r5 = null;
            goto L19
        L14:
            r4 = null;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            j r11 = this.f31280b;
            com.obric.autogui.session.a r12 = r11.d();
            d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31279a = 1;
            r6 = j.a(r11, r12, r13);
            if (r6 != r0) goto L11;
            return r0;
        }

        private static final x a(DisplayOperatingSpace r2, j r3) {
            DisplayOperatingSpace r4 = (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r2, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L6;
            j.a(r3, r4);
        L6:
            return x.f38692a;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.session.state.a.j$j, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StatePreparing.kt */
    @d.c.b.a.f(b = "StatePreparing.kt", c = {196}, d = "invokeSuspend", e = "com.obric.autogui.session.state.impl.StatePreparing$initializeVirtualDisplayRecordSet$3")
    static final class C0855j extends d.c.b.a.l implements d.h.a.m<Integer, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ int f31282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f31283c;

        C0855j(j r3, d.c.d<? super C0855j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31283c = r3;
            super(2, r5);
        }

        public final Object a(int r3, d.c.d<? super Boolean> r4) {
            d.c.d<?> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return ((C0855j) ZeusTransformUtils.preCheckCast(create(Integer.valueOf(r3), r5), C0855j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            C0855j r0 = new C0855j(this.f31283c, r5);
            r0.f31282b = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue();
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Integer r3, d.c.d<? super Boolean> r4) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31281a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            int r11 = this.f31282b;
            com.obric.autogui.agents.vlm.models.impl.applist.black.p r2 = com.obric.autogui.agents.vlm.models.impl.applist.black.p.f27502a;
            String r3 = this.f31283c.d().a();
            r r4 = new r(this.f31283c.d().b(), this.f31283c.d().a(), this.f31283c.d().l().getLaunchOrigin(), this.f31283c.d().c());
            d.c.d<? super Boolean> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31281a = 1;
            r10 = r2.a(r11, r3, r4, r5);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    /* synthetic */ class k extends d.h.b.l implements d.h.a.a<Boolean> {
        k(Object r8) {
            super(0, r8, com.obric.autogui.session.state.termination.a.class, "isTerminationActive", "isTerminationActive()Z", 0);
        }

        public final Boolean a() {
            return Boolean.valueOf(((com.obric.autogui.session.state.termination.a) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.autogui.session.state.termination.a.class, "com.obric.aiagent.plugin")).e());
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    @d.c.b.a.f(b = "StatePreparing.kt", c = {163}, d = "invokeSuspend", e = "com.obric.autogui.session.state.impl.StatePreparing$initializeVirtualDisplayRecordSet$awaitPreloadedDisplay$1")
    static final class l extends d.c.b.a.l implements d.h.a.b<d.c.d<? super com.obric.autogui.session.state.a.f>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.d.m f31285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f31286c;

        l(com.obric.autogui.session.d.m r3, j r4, d.c.d<? super l> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31285b = r3;
            this.f31286c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super com.obric.autogui.session.state.a.f> r3) {
            return ((l) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f31285b, this.f31286c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super com.obric.autogui.session.state.a.f> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31284a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L11:
            com.obric.autogui.common.e r2 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
            if (r2.g() == false) goto L14;
            DisplayOperatingSpace r9 = this.f31285b.h();
        L15:
            j.a(this.f31286c, com.obric.autogui.session.state.a.n.f31347a, r9);
            if (r9 == null) goto L18;
            Integer r3 = d.c.b.a.b.a(r9.getDisplayId());
        L20:
            return new com.obric.autogui.session.state.a.f(r2, r3, com.obric.autogui.session.state.a.n.f31347a, null, 8, null);
        L18:
            r3 = null;
            goto L20
        L14:
            r9 = null;
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            com.obric.autogui.session.d.m r10 = this.f31285b;
            d.c.d<? super com.obric.autogui.common.e> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31284a = 1;
            r8 = r10.a(r4);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    public static final class m implements IAutoActionRemoteAgentApi.QueueStateUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.a f31287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.state.b f31288b;

        /* JADX INFO: compiled from: StatePreparing.kt */
        @d.c.b.a.f(b = "StatePreparing.kt", c = {AbstractDialog.HORIZONTAL_MAX_WIDTH}, d = "onQueueCompleted", e = "com.obric.autogui.session.state.impl.StatePreparing$mQueueStateUpdateListener$1")
        static final class a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f31289a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f31290b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ m f31291c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int f31292d;

            a(m r3, d.c.d<? super a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31291c = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f31290b = r3;
                this.f31292d |= Integer.MIN_VALUE;
                return m.a(this.f31291c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: StatePreparing.kt */
        @d.c.b.a.f(b = "StatePreparing.kt", c = {411}, d = "invokeSuspend", e = "com.obric.autogui.session.state.impl.StatePreparing$mQueueStateUpdateListener$1$onQueueStateUpdated$1")
        static final class b extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f31293a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.session.a f31294b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ IAutoActionRemoteAgentApi.QueueStateUpdation f31295c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ m f31296d;

            b(com.obric.autogui.session.a r3, IAutoActionRemoteAgentApi.QueueStateUpdation r4, m r5, d.c.d<? super b> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31294b = r3;
                this.f31295c = r4;
                this.f31296d = r5;
                super(1, r7);
            }

            public final Object a(d.c.d<? super x> r3) {
                return ((b) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f31294b, this.f31295c, this.f31296d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f31293a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L19:
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                if (this.f31294b.K() == true) goto L12;
                Loog.INSTANCE.i(j.TAG, "[CANCELLED-QUEUE] the session is cancelled while queue-state is updated to " + this.f31295c + ", which is ignored.");
                return x.f38692a;
            L12:
                Loog.INSTANCE.i(j.TAG, "[QUEUE] queue-state updated: " + this.f31295c);
                if (this.f31295c.isQueueCompleted() == false) goto L17;
                m r7 = this.f31296d;
                d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f31293a = 1;
                if (m.a(r7, r2) != r0) goto L19;
                return r0;
            L17:
                m.a(this.f31296d, this.f31295c.getQueuePosition());
                goto L19
            }
        }

        m(com.obric.autogui.session.a r1, com.obric.autogui.session.state.b r2) {
            this.f31287a = r1;
            this.f31288b = r2;
        }

        public static final /* synthetic */ Object a(m r2, d.c.d r3) {
            return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ void a(m r0, int r1) {
            r0.a(r1);
        }

        @Override // com.obric.autogui.common.api.agent.remote.IAutoActionRemoteAgentApi.QueueStateUpdateListener
        public void onQueueStateUpdated(IAutoActionRemoteAgentApi.QueueStateUpdation r5) {
            d.h.b.o.e(r5, "queueState");
            this.f31287a.h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new b(this.f31287a, r5, this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        }

        private final Object a(d.c.d<? super x> r13) {
            d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r14, a.class) == false) goto L7;
            a r0 = (a) ZeusTransformUtils.preCheckCast(r14, a.class, "com.obric.aiagent.plugin");
            if ((r0.f31292d & Integer.MIN_VALUE) == 0) goto L7;
            r0.f31292d -= Integer.MIN_VALUE;
        L8:
            Object r15 = r0.f31290b;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f31292d;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            m this = (m) ZeusTransformUtils.preCheckCast(r0.f31289a, m.class, "com.obric.aiagent.plugin");
            d.o.a(r15);
        L21:
            com.obric.autogui.session.c.a.b(this.f31287a.O(), "ses_prepare", "enter", 0, 4, null);
            return x.f38692a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r15);
            Loog.INSTANCE.i(j.TAG, "[QUEUE] (ses/" + this.f31287a.a() + ") completed queue. entering OPERATING.");
            this.f31287a.b(false);
            com.obric.autogui.b.a.f28928a.onQueueStatusChanged(this.f31287a.d(), new QueueStatus(0, true));
            com.obric.autogui.session.c.a.b(this.f31287a.O(), "ses_queue", "update", 0, 4, null);
            com.obric.autogui.session.state.a r16 = this.f31288b.e();
            if (r16.b() == BizStatus.PREPARING) goto L18;
            Loog.INSTANCE.e(j.TAG, " - current-state is not PREPARING --> (" + r16.b() + ')');
            return x.f38692a;
        L18:
            com.obric.autogui.session.c.a.a(this.f31287a.O(), "ses_prepare", "enter", 0, 4, null);
            com.obric.autogui.session.state.b r17 = this.f31288b;
            BizStatus r1 = BizStatus.OPERATING;
            BizStatus.StatusChangedReasonStruct r4 = new BizStatus.StatusChangedReasonStruct(com.obric.autogui.session.state.a.h.b.f31241a.a(), null, null, null, 14, null);
            r0.f31289a = this;
            r0.f31292d = 1;
            if (r17.a(r1, r4, r0) != r2) goto L21;
            return r2;
        L7:
            r0 = new a(this, r14);
            goto L8
        }

        private final void a(int r4) {
            com.obric.autogui.b.a.f28928a.onQueueStatusChanged(this.f31287a.d(), new QueueStatus(r4, false));
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    @d.c.b.a.f(b = "StatePreparing.kt", c = {481}, d = "invokeSuspend", e = "com.obric.autogui.session.state.impl.StatePreparing$observeVDVisible$1")
    static final class n extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31297a;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class a implements kotlinx.coroutines.b.h<IAutoActionPresentationApi.PlayerVisibility> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f31299a;

            /* JADX INFO: renamed from: com.obric.autogui.session.state.a.j$n$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements kotlinx.coroutines.b.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.b.i f31300a;

                /* JADX INFO: renamed from: com.obric.autogui.session.state.a.j$n$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "StatePreparing.kt", c = {219}, d = "emit", e = "com.obric.autogui.session.state.impl.StatePreparing$observeVDVisible$1$invokeSuspend$$inlined$map$1$2")
                public static final class C08561 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f31301a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f31302b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f31303c;

                    public C08561(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f31303c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f31301a = r3;
                        this.f31302b |= Integer.MIN_VALUE;
                        return this.f31303c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(kotlinx.coroutines.b.i r3) {
                    this.f31300a = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C08561.class) == false) goto L7;
                    C08561 r0 = (C08561) ZeusTransformUtils.preCheckCast(r8, C08561.class, "com.obric.aiagent.plugin");
                    if ((r0.f31302b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f31302b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f31301a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f31302b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L18:
                    return x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    kotlinx.coroutines.b.i r5 = this.f31300a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    IAutoActionPresentationApi.PlayerVisibility r11 = ((GlobalUIContext) ZeusTransformUtils.preCheckCast(r6, GlobalUIContext.class, "com.obric.aiagent.plugin")).getPlayer().getVisible();
                    r0.f31302b = 1;
                    if (r5.emit(r11, r0) != r2) goto L18;
                    return r2;
                L7:
                    r0 = new C08561(this, r8);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.b.h r3) {
                this.f31299a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(kotlinx.coroutines.b.i<? super IAutoActionPresentationApi.PlayerVisibility> r3, d.c.d r4) {
                kotlinx.coroutines.b.i r5 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f31299a.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return x.f38692a;
            }
        }

        n(d.c.d<? super n> r3) {
            super(1, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((n) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31297a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.h r7 = kotlinx.coroutines.b.j.b((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState(), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"));
            kotlinx.coroutines.b.i r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(AnonymousClass1.f31298a, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31297a = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    @d.c.b.a.f(b = "StatePreparing.kt", c = {262}, d = "invokeSuspend", e = "com.obric.autogui.session.state.impl.StatePreparing$onEnter$1")
    static final class o extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f31305b;

        o(j r3, d.c.d<? super o> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31305b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((o) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f31305b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31304a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            com.obric.autogui.session.c.a.a(this.f31305b.d().O(), "ses_queue", "all", 0, 4, null);
            j r11 = this.f31305b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31304a = 1;
            if (j.a(r11, r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: StatePreparing.kt */
    @d.c.b.a.f(b = "StatePreparing.kt", c = {269, 275}, d = "prepare", e = "com.obric.autogui.session.state.impl.StatePreparing")
    static final class p extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f31308c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31309d;

        p(j r3, d.c.d<? super p> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31308c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31307b = r3;
            this.f31309d |= Integer.MIN_VALUE;
            return j.a(this.f31308c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f31252b = new a(null);
    }

    public static /* synthetic */ x lambda$UNwPzNpdEgCUAfszYsMCcZf2tgI(j r0) {
        return a(r0);
    }

    public static final /* synthetic */ Object a(j r2, com.obric.autogui.session.a r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(j r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(j r2, DisplayOperatingSpace r3) {
        r2.a((DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, DisplayOperatingSpace.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(j r2, com.obric.autogui.session.state.a.n r3, DisplayOperatingSpace r4) {
        r2.a(r3, (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, DisplayOperatingSpace.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(j r2, d.c.d r3) {
        return r2.c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object c(j r2, d.c.d r3) {
        return r2.d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public j(com.obric.autogui.session.state.b r9, com.obric.autogui.session.a r10) {
        d.h.b.o.e(r9, "machine");
        d.h.b.o.e(r10, SensitiveType.SESSION);
        super(BizStatus.PREPARING, r10, r9, false, 8, null);
        this.f31254d = new m(r10, r9);
    }

    private final Object a(com.obric.autogui.session.a r22, d.c.d<? super com.obric.autogui.common.d<IOperatingSpaceManager.OpSpaceCreationResult>> r23) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L7;
        f r2 = (f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.aiagent.plugin");
        if ((r2.f31272d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f31272d -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f31270b;
        Object r3 = d.c.a.b.a();
        int r4 = r2.f31272d;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        com.obric.autogui.session.a r5 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r2.f31269a, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        d.o.a(r1);     // Catch: Throwable -> L14
        com.obric.autogui.session.a r10 = r5;
    L51:
        IOperatingSpaceManager.OpSpaceCreationResult r6 = (IOperatingSpaceManager.OpSpaceCreationResult) ZeusTransformUtils.preCheckCast(r1, IOperatingSpaceManager.OpSpaceCreationResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        if (r6.getStatus() == IOperatingSpaceManager.OpSpaceCreationResult.Status.Success) goto L33;
        Loog.INSTANCE.e(TAG, "Failed to create Space, status=" + r6.getStatus());
        if (r10.o() == null) goto L32;
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "space_creation", r6.getStatus().name(), r10, null, null, null, null, null, null, null, null, 2040, null);
    L32:
        return com.obric.autogui.common.d.f29012a.a("");
    L33:
        AOOperatingSpace r7 = r6.getSpace();
        if (r7 == null) goto L37;
        r10.a(r7);
    L37:
        return com.obric.autogui.common.d.f29012a.a(r6);
    L38:
        th = th;
        com.obric.autogui.session.a r9 = r10;
    L44:
        Loog.INSTANCE.e(TAG, "Failed to create Space. e=" + th, th);
        if (r9.o() == null) goto L48;
        com.obric.autogui.session.b.e.a(com.obric.autogui.session.b.e.f30776a, "space_creation", "Exception", r9, null, null, null, null, null, null, null, th, DownloadErrorCode.ERROR_DB_READONLY, null);
    L48:
        return com.obric.autogui.common.d.f29012a.a("");
    L14:
        th = th;
        r9 = r5;
        goto L44
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r1);
        OperatingSpaceManager r8 = OperatingSpaceManager.INSTANCE;     // Catch: Throwable -> L42
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r22.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        CCLifecycleListener r12 = (CCLifecycleListener) ZeusTransformUtils.preCheckCast(r22.o(), CCLifecycleListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        r9 = r22;
        r2.f31269a = r9;     // Catch: Throwable -> L40
        r2.f31272d = 1;     // Catch: Throwable -> L40
        r1 = r8.createSpace(r11, r12, r2);     // Catch: Throwable -> L40
        if (r1 != r3) goto L24;
        return r3;
    L24:
        r10 = r9;
    L40:
        th = th;
    L42:
        th = th;
        r9 = r22;
    L7:
        r2 = new f(this, r0);
        goto L8
    }

    @Override // com.obric.autogui.session.state.a
    public Object a(com.obric.autogui.session.state.a r13, d.c.d<? super com.obric.autogui.common.e> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r15, c.class, "com.obric.aiagent.plugin");
        if ((r0.f31260e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31260e -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f31258c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31260e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r13 = (com.obric.autogui.session.state.a) ZeusTransformUtils.preCheckCast(r0.f31257b, com.obric.autogui.session.state.a.class, "com.obric.aiagent.plugin");
        j this = (j) ZeusTransformUtils.preCheckCast(r0.f31256a, j.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L23:
        com.obric.autogui.session.state.a.p r17 = (com.obric.autogui.session.state.a.p) ZeusTransformUtils.preCheckCast(r16, com.obric.autogui.session.state.a.p.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, com.obric.autogui.session.state.a.p.a.class) == false) goto L32;
        if (((com.obric.autogui.session.state.a.p.a) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.session.state.a.p.a.class, "com.obric.aiagent.plugin")).c() != q.f31370d) goto L30;
        Loog.INSTANCE.i(TAG, "event=vd_record_set_gate_cancelled source=" + ((com.obric.autogui.session.state.a.p.a) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.session.state.a.p.a.class, "com.obric.aiagent.plugin")).b().a() + " reason=" + ((com.obric.autogui.session.state.a.p.a) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.session.state.a.p.a.class, "com.obric.aiagent.plugin")).a().h());
        return ((com.obric.autogui.session.state.a.p.a) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.session.state.a.p.a.class, "com.obric.aiagent.plugin")).a();
    L30:
        return this.a(((com.obric.autogui.session.state.a.p.a) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.session.state.a.p.a.class, "com.obric.aiagent.plugin")).a(), ((com.obric.autogui.session.state.a.p.a) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.session.state.a.p.a.class, "com.obric.aiagent.plugin")).b(), ((com.obric.autogui.session.state.a.p.a) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.session.state.a.p.a.class, "com.obric.aiagent.plugin")).c());
    L32:
        if (ZeusTransformUtils.instanceOf(r17, com.obric.autogui.session.state.a.p.b.class) == false) goto L35;
        Loog.INSTANCE.i(TAG, "event=vd_record_set_gate_succeeded source=" + ((com.obric.autogui.session.state.a.p.b) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.session.state.a.p.b.class, "com.obric.aiagent.plugin")).b().a() + " displayId=" + ((com.obric.autogui.session.state.a.p.b) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.session.state.a.p.b.class, "com.obric.aiagent.plugin")).a());
        this.a((com.obric.autogui.session.state.a.h) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.session.state.a.h.class, "com.obric.aiagent.plugin"));
    L37:
        return com.obric.autogui.common.e.f29014b.a();
    L35:
        throw new d.k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r16);
        if (ZeusTransformUtils.instanceOf(r13, com.obric.autogui.session.state.a.h.class) == false) goto L37;
        if (d().k().j() == false) goto L20;
        com.obric.autogui.common.e r18 = com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_operating_space_creation_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_operating_space_creation_failed"), null, 2, null);
        Loog.INSTANCE.e(TAG, "preloaded Computer Control space was closed before operating");
        com.obric.autogui.session.state.d.f31396a.a(d(), r18, 100002);
        AOUserInterfaceTools.showAppToast$default(AOUserInterfaceTools.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.agent_operating_space_creation_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_operating_space_creation_failed"), false, 4, null);
        return r18;
    L20:
        com.obric.autogui.session.c.a.b(d().O(), "ses_queue", "all", 0, 4, null);
        r0.f31256a = this;
        r0.f31257b = r13;
        r0.f31260e = 1;
        r16 = a(r0);
        if (r16 != r2) goto L23;
        return r2;
    L7:
        r0 = new c(this, r15);
        goto L8
    }

    private final Object a(d.c.d<? super com.obric.autogui.session.state.a.p> r10) {
        d.c.d<? super com.obric.autogui.session.state.a.p> r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.d.m r0 = d().k().c();
        if (r0 != null) goto L5;
        d.h.a.b r4 = null;
    L7:
        return new com.obric.autogui.session.state.a.o(r4, (d.h.a.b) ZeusTransformUtils.preCheckCast(new i(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0855j(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(new k(d().J()), d.h.a.a.class, "com.obric.aiagent.plugin"), new $$Lambda$j$UNwPzNpdEgCUAfszYsMCcZf2tgI(this)).a(r11);
    L5:
        r4 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new l(r0, this, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        goto L7
    }

    private static final x a(j r1) {
        com.obric.autogui.agents.vlm.models.impl.applist.black.p.f27502a.a(r1.d().a());
        return x.f38692a;
    }

    private final void a(com.obric.autogui.session.state.a.n r3, DisplayOperatingSpace r4) {
        DisplayOperatingSpace r2 = (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        Loog.INSTANCE.i(TAG, "event=vd_record_set_gate_started source=" + r3.a() + " displayId=" + r2.getDisplayId());
    }

    private final com.obric.autogui.common.e a(com.obric.autogui.common.e r7, com.obric.autogui.session.state.a.n r8, q r9) {
        Loog r0 = Loog.INSTANCE;
        StringBuilder r10 = new StringBuilder().append("event=vd_startup_gate_failed source=").append(r8.a()).append(" stage=");
        String r1 = r9.name().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r1, "toLowerCase(...)");
        r0.e(TAG, r10.append(r1).append(" reason=").append(r7.h()).toString());
        com.obric.autogui.session.state.d.f31396a.a(d(), r7, 100002);
        if (r9 != q.f31367a) goto L5;
        AOUserInterfaceTools.showAppToast$default(AOUserInterfaceTools.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.agent_operating_space_creation_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_operating_space_creation_failed"), false, 4, null);
    L5:
        return r7;
    }

    private final void a(DisplayOperatingSpace r3) {
        DisplayOperatingSpace r4 = (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        com.obric.autogui.util.f.f31548a.a();
        com.obric.autogui.util.f.f31548a.a(r4.getSpaceId());
        j();
        com.obric.autogui.util.c.f31500a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.session.state.a, com.obric.autogui.util.c.a, com.obric.autogui.util.c.b
    public void b(com.obric.autogui.util.c.b r4) {
        com.obric.autogui.util.c.b r5 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "fromState");
        super.b(r5);
        d().h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new o(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final Object b(d.c.d<? super x> r15) {
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, p.class) == false) goto L7;
        p r0 = (p) ZeusTransformUtils.preCheckCast(r16, p.class, "com.obric.aiagent.plugin");
        if ((r0.f31309d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31309d -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f31307b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31309d;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        d.o.a(r17);
    L26:
        com.obric.autogui.common.e r14 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r14.g() == true) goto L30;
        Loog.INSTANCE.e(TAG, "cannot enter queue state (" + r14 + "); proceeded to [Finish]");
        return x.f38692a;
    L30:
        Loog.INSTANCE.i(TAG, "nw & enter queue seems normal; entered PREPARING");
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        j this = (j) ZeusTransformUtils.preCheckCast(r0.f31306a, j.class, "com.obric.aiagent.plugin");
        d.o.a(r17);
    L19:
        com.obric.autogui.common.e r18 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r17, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r18.g() == true) goto L23;
        Loog.INSTANCE.e(TAG, "prepare failed (" + r18 + "); proceeded to [Finish]");
        return x.f38692a;
    L23:
        r0.f31306a = null;
        r0.f31309d = 2;
        r17 = this.d(r0);
        if (r17 != r2) goto L26;
        return r2;
    L16:
        d.o.a(r17);
        com.obric.autogui.session.c.a.a(d().O(), "ses_queue", "enqueue", 0, 4, null);
        r0.f31306a = this;
        r0.f31309d = 1;
        r17 = c(r0);
        if (r17 != r2) goto L19;
        return r2;
    L7:
        r0 = new p(this, r16);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, com.obric.autogui.common.e] */
    private final Object c(d.c.d<? super com.obric.autogui.common.e> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r12, d.class, "com.obric.aiagent.plugin");
        if ((r0.f31265e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31265e -= Integer.MIN_VALUE;
    L8:
        d r8 = r0;
        Object r13 = r8.f31263c;
        Object r1 = d.c.a.b.a();
        int r2 = r8.f31265e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        z.f r10 = (z.f) ZeusTransformUtils.preCheckCast(r8.f31262b, z.f.class, "com.obric.aiagent.plugin");
        j r3 = (j) ZeusTransformUtils.preCheckCast(r8.f31261a, j.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L18:
        com.obric.autogui.common.e r14 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r10.f38504a, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r14.g() == true) goto L23;
        com.obric.autogui.session.state.d.f31396a.a(r3.d(), r14, 101001);
        return r10.f38504a;
    L23:
        return com.obric.autogui.common.e.f29014b.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        z.f r15 = new z.f();
        r15.f38504a = com.obric.autogui.common.e.f29014b.a();
        com.obric.autogui.util.a r4 = com.obric.autogui.util.a.f31488a;
        d.h.a.b<? super d.c.d<? super Boolean>, ? extends Object> r7 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new e(r15, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r8.f31261a = this;
        r8.f31262b = r15;
        r8.f31265e = 1;
        if (r4.a("prep-check-linkage", 3, 5000, r7, r8) != r1) goto L17;
        return r1;
    L17:
        r3 = this;
        r10 = r15;
    L7:
        r0 = new d(this, r12);
        goto L8
    }

    private final Object d(d.c.d<? super com.obric.autogui.common.e> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r15, h.class, "com.obric.aiagent.plugin");
        if ((r0.f31278d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31278d -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f31276b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31278d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        j this = (j) ZeusTransformUtils.preCheckCast(r0.f31275a, j.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L17:
        IAutoActionRemoteAgentApi.QueueStateEnteringResult r17 = (IAutoActionRemoteAgentApi.QueueStateEnteringResult) ZeusTransformUtils.preCheckCast(r16, IAutoActionRemoteAgentApi.QueueStateEnteringResult.class, "com.obric.aiagent.plugin");
        if (r17.getErrorType() == IAutoActionRemoteAgentApi.ErrorType.Succeeded) goto L38;
        int r18 = b.f31255a[r17.getErrorType().ordinal()];
        if (r18 != 1) goto L22;
        int r19 = ZeusTransformUtils.mapRes(R.string.agent_queue_net_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_queue_net_error");
    L35:
        String r110 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.d().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r19);
        d.h.b.o.c(r110, "getString(...)");
        AOUserInterfaceTools.INSTANCE.showAppToast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.d().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.aiagent.plugin"));
        com.obric.autogui.session.state.d.f31396a.a(this.d(), com.obric.autogui.common.e.f29014b.c(r110), 103001);
        return com.obric.autogui.common.e.f29014b.b();
    L22:
        if (r18 != 2) goto L24;
        r19 = ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error");
        goto L35
    L24:
        if (r18 != 3) goto L26;
        r19 = ZeusTransformUtils.mapRes(R.string.agent_queue_start_exception, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_queue_start_exception");
        goto L35
    L26:
        if (r18 != 4) goto L28;
        r19 = ZeusTransformUtils.mapRes(R.string.agent_queue_queue_full, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_queue_queue_full");
        goto L35
    L28:
        if (r18 == 5) goto L30;
        r19 = ZeusTransformUtils.mapRes(R.string.agent_queue_terminated, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_queue_terminated");
        goto L35
    L30:
        r19 = ZeusTransformUtils.mapRes(R.string.agent_queue_api_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_queue_api_error");
        goto L35
    L38:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.d().b(), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L40;
        boolean r1 = true;
    L41:
        if (r1 == false) goto L43;
        this.a(this.d(), r17.isQueueNeeded());
    L43:
        IAutoActionTrackingApi r5 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r7 = new JSONObject();
        r7.put("need_queue", r17.isQueueNeeded());
        r7.put("enqueue_succeeded", true);
        r7.put("enqueued_with_size", r17.getInitQueueSize());
        com.obric.autogui.session.c.b.a(r7, this.d());
        x r4 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r5, "session_enqueued", r7, false, false, null, 28, null);
        com.obric.autogui.session.c.a.b(this.d().O(), "ses_queue", "enqueue", 0, 4, null);
        if (r17.isQueueNeeded() == true) goto L46;
        this.a();
    L48:
        return com.obric.autogui.common.e.f29014b.a();
    L46:
        com.obric.autogui.session.c.a.a(this.d().O(), "ses_queue", "update", 0, 4, null);
        this.f31253c = true;
        com.obric.autogui.b.a.f28928a.onQueueStatusChanged(this.d().d(), new QueueStatus(r17.getInitQueueSize(), false));
        goto L48
    L40:
        r1 = false;
        goto L41
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r16);
        com.obric.autogui.session.state.a.b r111 = com.obric.autogui.session.state.a.b.f31222a;
        IAutoActionRemoteAgentApi.QueueStateUpdateListener r6 = (IAutoActionRemoteAgentApi.QueueStateUpdateListener) ZeusTransformUtils.preCheckCast(this.f31254d, IAutoActionRemoteAgentApi.QueueStateUpdateListener.class, "com.obric.aiagent.plugin");
        r0.f31275a = this;
        r0.f31278d = 1;
        r16 = r111.enterQueueState(r6, r0);
        if (r16 != r2) goto L17;
        return r2;
    L7:
        r0 = new h(this, r15);
        goto L8
    }

    private final void a(com.obric.autogui.session.a r4, boolean r5) {
        Loog.INSTANCE.i(TAG, " - SessionId ready; SesId=" + r4.b() + "; NeedQueue=" + r5);
        r4.a(r5);
        r4.b(r5);
        com.obric.autogui.b.a.f28928a.onSessionEnqueued(r4.d());
        e().b().a(r4);
    }

    private final void a() {
        d().h().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new g(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final void a(com.obric.autogui.session.state.a.h r2) {
        DisplayedAppInfo r0 = d().H();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f31253c == false) goto L8;
        Loog.INSTANCE.i(TAG, " - [BringTask] ignored captured top-task because we've really enqueued.");
        return;
    L8:
        r2.a(r0);
    }

    private final void j() {
        d().m().a().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new n(null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }
}
