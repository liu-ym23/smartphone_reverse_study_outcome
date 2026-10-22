package com.obric.autogui.platforms.tools.input;

import android.app.assist.AssistStructure;
import android.os.SystemClock;
import android.view.KeyEvent;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.input.CoordinateScrollResult;
import com.obric.autogui.common.api.platform.input.IAutoActionInputApi;
import com.obric.autogui.common.api.platform.input.InjectEventContext;
import com.obric.autogui.common.api.platform.input.InjectTextResponse;
import com.obric.autogui.common.api.platform.input.InjectTextResponseListener;
import com.obric.autogui.common.api.platform.input.InjectTextResponseType;
import com.obric.autogui.common.api.platform.input.InputTextResult;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.l.n;
import d.x;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: InjectingInputApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements IAutoActionInputApi {
    private static final String TAG = "InjectingInputApiImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30242a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ExecutorService f30243d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.platforms.tools.input.d f30244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<InjectTextResponseListener, com.obric.framework.inputmethod.api.b> f30245c;

    /* JADX INFO: compiled from: InjectingInputApiImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.input.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: InjectingInputApiImpl.kt */
    public /* synthetic */ class C0810b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30246a = null;

        static {
            int[] r0 = new int[com.obric.framework.inputmethod.api.d.values().length];
            r0[com.obric.framework.inputmethod.api.d.f33239a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[com.obric.framework.inputmethod.api.d.f33240b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[com.obric.framework.inputmethod.api.d.f33241c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[com.obric.framework.inputmethod.api.d.f33242d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f30246a = r0;
        }
    }

    /* JADX INFO: compiled from: InjectingInputApiImpl.kt */
    public static final class c extends com.obric.framework.inputmethod.api.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InjectTextResponseListener f30247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f30248b;

        c(InjectTextResponseListener r3, b r4) {
            this.f30247a = (InjectTextResponseListener) ZeusTransformUtils.wrapperContextForParams(r3, InjectTextResponseListener.class, "com.obric.aiagent.plugin");
            this.f30248b = r4;
        }

        @Override // com.obric.framework.inputmethod.api.b
        public void a(com.obric.framework.inputmethod.api.d r11, AssistStructure r12) {
            o.e(r11, "type");
            long r1 = SystemClock.elapsedRealtime();
            List r4 = null;
            Object r5 = null;
            if (r12 != null) goto L30;
        L18:
            long r0 = n.a(SystemClock.elapsedRealtime() - r1, 0);
            if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L28;
            Loog r2 = Loog.INSTANCE;
            StringBuilder r6 = new StringBuilder().append("[OAutoActionEffect] injectText callback snapshot copied, type=").append(r11).append(", viewtree_available=");
            int r7 = 0;
            if (r12 == null) goto L23;
            boolean r13 = true;
        L24:
            StringBuilder r14 = r6.append(r13).append(", input_node_count=");
            if (r4 == null) goto L27;
            r7 = r4.size();
        L27:
            r2.d(b.TAG, r14.append(r7).append(", elapsed_ms=").append(r0).toString());
            goto L28
        L23:
            r13 = false;
        L28:
            this.f30247a.onResponse(new InjectTextResponse(b.a(this.f30248b, r11), r4));
            return;
        L30:
            d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L6
            c r9 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
            Object r10 = d.n.f(com.obric.autogui.platforms.tools.input.a.f30241a.a(r12));     // Catch: Throwable -> L6
        L8:
            Throwable r15 = d.n.c(r10);
            if (r15 == null) goto L14;
            if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L14;
            Loog.INSTANCE.w(b.TAG, "[OAutoActionEffect] injectText callback snapshot copy failed, type=" + r11 + ", error_type=" + r15.getClass().getSimpleName(), r15);
        L14:
            if (d.n.b(r10) == true) goto L17;
            r5 = r10;
        L17:
            r4 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
        L6:
            th = move-exception;
            d.n.a r16 = d.n.f38560a;
            r10 = d.n.f(d.o.a(th));
            goto L8
        }
    }

    /* JADX INFO: compiled from: InjectingInputApiImpl.kt */
    @f(b = "InjectingInputApiImpl.kt", c = {57}, d = "scrollAtCoordinate", e = "com.obric.autogui.platforms.tools.input.InjectingInputApiImpl")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f30249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f30250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f30251c;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30250b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.f30249a = r8;
            this.f30251c |= Integer.MIN_VALUE;
            return this.f30250b.scrollAtCoordinate(0, 0.0f, 0.0f, 0, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: InjectingInputApiImpl.kt */
    @f(b = "InjectingInputApiImpl.kt", c = {58}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.input.InjectingInputApiImpl$scrollAtCoordinate$2")
    static final class e extends l implements m<am, d.c.d<? super CoordinateScrollResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f30253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f30254c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f30255d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f30256e;
        final /* synthetic */ int f;

        e(int r3, float r4, float r5, int r6, int r7, d.c.d<? super e> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30253b = r3;
            this.f30254c = r4;
            this.f30255d = r5;
            this.f30256e = r6;
            this.f = r7;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super CoordinateScrollResult> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f30253b, this.f30254c, this.f30255d, this.f30256e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super CoordinateScrollResult> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30252a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L11:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            com.obric.autogui.platforms.tools.internal.a.d r2 = com.obric.autogui.platforms.tools.internal.a.d.f30319a;
            int r12 = this.f30253b;
            float r3 = this.f30254c;
            float r4 = this.f30255d;
            int r5 = this.f30256e;
            int r6 = this.f;
            ExecutorService r7 = b.a();
            o.c(r7, "access$getCoordinateScrollCallbackExecutor$cp(...)");
            Executor r8 = (Executor) ZeusTransformUtils.preCheckCast(r7, Executor.class, "com.obric.aiagent.plugin");
            d.c.d<? super CoordinateScrollResult> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30252a = 1;
            r11 = r2.a(r12, r3, r4, r5, r6, r8, r9);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$ngokFcE_C2ZGy7e6b-4MwuY53sg, reason: not valid java name */
    public static /* synthetic */ Thread m860lambda$ngokFcE_C2ZGy7e6b4MwuY53sg(Runnable r0) {
        return a(r0);
    }

    public b() {
        this.f30244b = new com.obric.autogui.platforms.tools.input.d();
        this.f30245c = new ConcurrentHashMap();
    }

    public static final /* synthetic */ InjectTextResponseType a(b r0, com.obric.framework.inputmethod.api.d r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ ExecutorService a() {
        return f30243d;
    }

    static {
        f30242a = new a(null);
        f30243d = Executors.newSingleThreadExecutor($$Lambda$b$ngokFcE_C2ZGy7e6b4MwuY53sg.INSTANCE);
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "ao-coordinate-scroll-callback");
        r0.setDaemon(true);
        return r0;
    }

    @Override // com.obric.autogui.common.api.platform.input.IAutoActionInputApi
    public Object scrollAtCoordinate(int r16, float r17, float r18, int r19, int r20, d.c.d<? super CoordinateScrollResult> r21) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L7;
        d r2 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        if ((r2.f30251c & Integer.MIN_VALUE) == 0) goto L7;
        r2.f30251c -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f30249a;
        Object r3 = d.c.a.b.a();
        int r4 = r2.f30251c;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        d.o.a(r1);
    L17:
        CoordinateScrollResult r5 = (CoordinateScrollResult) ZeusTransformUtils.preCheckCast(r1, CoordinateScrollResult.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L20;
        return r5;
    L20:
        return CoordinateScrollResult.Companion.fromFrameworkCode(-5);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r1);
        m r6 = (m) ZeusTransformUtils.preCheckCast(new e(r16, r17, r18, r19, r20, null), m.class, "com.obric.aiagent.plugin");
        r2.f30251c = 1;
        r1 = dg.b(5000, r6, r2);
        if (r1 != r3) goto L17;
        return r3;
    L7:
        r2 = new d(this, r0);
        goto L8
    }

    @Override // com.obric.autogui.common.api.platform.input.IAutoActionInputApi
    public Object swipeV3Tail(int r9, d.m<Float, Float> r10, d.m<Float, Float> r11, d.c.d<? super com.obric.autogui.common.e> r12) {
        d.c.d<? super com.obric.autogui.common.e> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.platforms.tools.input.inject.c.f30293a.a(r9, ((Number) ZeusTransformUtils.preCheckCast(r10.a(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r10.b(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r11.a(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r11.b(), Number.class, "com.obric.aiagent.plugin")).floatValue(), r7);
    }

    @Override // com.obric.autogui.common.api.platform.input.IAutoActionInputApi
    public Object swipe(d.m<Float, Float> r12, d.m<Float, Float> r13, long r14, boolean r16, d.c.d<? super com.obric.autogui.common.e> r17) {
        d.c.d<? super com.obric.autogui.common.e> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.autogui.platforms.tools.input.inject.b.f30268a.a(((Number) ZeusTransformUtils.preCheckCast(r12.a(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r12.b(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r13.a(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r13.b(), Number.class, "com.obric.aiagent.plugin")).floatValue(), r14, r16, r10);
    }

    @Override // com.obric.autogui.common.api.platform.input.IAutoActionInputApi
    public Object tap(float r8, float r9, long r10, InjectEventContext.Context r12, d.c.d<? super com.obric.autogui.common.e> r13) {
        d.c.d<? super com.obric.autogui.common.e> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L6;
        Loog.INSTANCE.d(TAG, "[TapInput] received x=" + r8 + ", y=" + r9 + ", duration=" + r10);
    L6:
        return new com.obric.autogui.platforms.tools.input.inject.d().a(r8, r9, r10, r12, r6);
    }

    @Override // com.obric.autogui.common.api.platform.input.IAutoActionInputApi
    public Object inputText(AOOperatingSpace r3, String r4, boolean r5, d.c.d<? super InputTextResult> r6) {
        AOOperatingSpace r7 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d.c.d<? super InputTextResult> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f30244b.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), r7, r5, r8);
    }

    @Override // com.obric.autogui.common.api.platform.input.IAutoActionInputApi
    public boolean registerInjectTextResponseListener(InjectTextResponseListener r5) {
        InjectTextResponseListener r6 = (InjectTextResponseListener) ZeusTransformUtils.wrapperContextForParams(r5, InjectTextResponseListener.class, "com.obric.aiagent.plugin");
        o.e(r6, "listener");
        c r0 = new c(r6, this);
        if (((com.obric.framework.inputmethod.api.b) ZeusTransformUtils.preCheckCast(this.f30245c.putIfAbsent(r6, r0), com.obric.framework.inputmethod.api.b.class, "com.obric.aiagent.plugin")) == null) goto L6;
        return true;
    L6:
        boolean r1 = com.obric.autogui.platforms.tools.internal.a.g.f30334a.a((com.obric.framework.inputmethod.api.b) ZeusTransformUtils.preCheckCast(r0, com.obric.framework.inputmethod.api.b.class, "com.obric.aiagent.plugin"));
        if (r1 == true) goto L9;
        this.f30245c.remove(r6, r0);
    L9:
        return r1;
    }

    @Override // com.obric.autogui.common.api.platform.input.IAutoActionInputApi
    public boolean unregisterInjectTextResponseListener(InjectTextResponseListener r4) {
        InjectTextResponseListener r5 = (InjectTextResponseListener) ZeusTransformUtils.wrapperContextForParams(r4, InjectTextResponseListener.class, "com.obric.aiagent.plugin");
        o.e(r5, "listener");
        com.obric.framework.inputmethod.api.b r0 = (com.obric.framework.inputmethod.api.b) ZeusTransformUtils.preCheckCast(this.f30245c.get(r5), com.obric.framework.inputmethod.api.b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return false;
    L6:
        boolean r1 = com.obric.autogui.platforms.tools.internal.a.g.f30334a.b(r0);
        if (r1 == false) goto L9;
        this.f30245c.remove(r5, r0);
    L9:
        return r1;
    }

    @Override // com.obric.autogui.common.api.platform.input.IAutoActionInputApi
    public com.obric.autogui.common.e key(AOOperatingSpace r3, int r4) {
        AOOperatingSpace r5 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        o.e(r5, "space");
        if (ZeusTransformUtils.instanceOf(r5, DisplayOperatingSpace.class) == true) goto L7;
        return com.obric.autogui.common.e.f29014b.b("Only DisplayOperatingSpace is supported.");
    L7:
        return key(((DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r5, DisplayOperatingSpace.class, "com.obric.aiagent.plugin")).getDisplayAccessor(), r4);
    }

    @Override // com.obric.autogui.common.api.platform.input.IAutoActionInputApi
    public com.obric.autogui.common.e key(DisplayAccessor r8, int r9) {
        DisplayAccessor r7 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r8, DisplayAccessor.class, "com.obric.aiagent.plugin");
        o.e(r7, "displayAccessor");
        long r3 = SystemClock.uptimeMillis();
        if (com.obric.autogui.platforms.tools.input.inject.a.f30267a.a(r9, r7.getDisplayId(), r3, r3 + ((long) 16)) == false) goto L6;
        return com.obric.autogui.common.e.f29014b.a();
    L6:
        return com.obric.autogui.common.e.f29014b.b("Failed to press key " + r9 + '.');
    }

    @Override // com.obric.autogui.common.api.platform.input.IAutoActionInputApi
    public com.obric.autogui.common.e key(DisplayAccessor r2, KeyEvent r3) {
        DisplayAccessor r1 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r2, DisplayAccessor.class, "com.obric.aiagent.plugin");
        o.e(r1, "displayAccessor");
        o.e(r3, "keyEvent");
        if (com.obric.autogui.platforms.tools.input.inject.a.f30267a.a(r1.getDisplayId(), r3) == false) goto L6;
        return com.obric.autogui.common.e.f29014b.a();
    L6:
        return com.obric.autogui.common.e.f29014b.b("Failed to inject key event " + r3 + '.');
    }

    private final InjectTextResponseType a(com.obric.framework.inputmethod.api.d r1) {
        int r0 = C0810b.f30246a[r1.ordinal()];
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L18;
        if (r0 != 4) goto L12;
        return InjectTextResponseType.UNKNOWN;
    L12:
        throw new k();
    L18:
        return InjectTextResponseType.SECURE;
    L19:
        return InjectTextResponseType.ABNORMAL;
    L16:
        return InjectTextResponseType.NORMAL;
    }
}
