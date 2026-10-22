package com.obric.autoaction.presentation.function;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.presentation.view.PlayerBubble;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: UIHandUseAutoResume.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "HandUseAutoResume";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24940a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f24941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PlayerBubble f24942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<? extends com.obric.autoaction.presentation.function.a.c> f24943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final am f24944e;
    private final long f;
    private ca g;
    private CharSequence h;

    /* JADX INFO: compiled from: UIHandUseAutoResume.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: UIHandUseAutoResume.kt */
    @f(b = "UIHandUseAutoResume.kt", c = {74}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.function.UIHandUseAutoResume$attachToJob$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f24946b;

        b(c r3, d<? super b> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f24946b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f24946b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24945a;
            if (r1 == 0) goto L8;
            if (r1 == 1) goto L8;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
        L10:
            if (c.a(this.f24946b) == false) goto L12;
            long r3 = c.b(this.f24946b);
            d r7 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f24945a = 1;
            if (ax.a(r3, r7) != r0) goto L10;
            return r0;
        L12:
            return x.f38692a;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.function.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UIHandUseAutoResume.kt */
    @f(b = "UIHandUseAutoResume.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.presentation.function.UIHandUseAutoResume$withBubble$1")
    static final class C0582c extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f24948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<PlayerBubble, x> f24949c;

        C0582c(c r3, d.h.a.b<? super PlayerBubble, x> r4, d<? super C0582c> r5) {
            d.h.a.b<PlayerBubble, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f24948b = r3;
            this.f24949c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((C0582c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0582c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0582c(this.f24948b, this.f24949c, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f24947a != 0) goto L10;
            o.a(r2);
            PlayerBubble r3 = c.c(this.f24948b);
            if (r3 == null) goto L7;
            this.f24949c.invoke(r3);
            return x.f38692a;
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f24940a = new a(null);
    }

    public static /* synthetic */ x lambda$KzBAQKN8gc4JEYpJOxvfbuKtkVc(PlayerBubble r0) {
        return b(r0);
    }

    public static /* synthetic */ x lambda$a5tGF4m7sh2dvGrGF5LqJskzGZE(c r0, long r1, PlayerBubble r3) {
        return a(r0, r1, r3);
    }

    /* JADX INFO: renamed from: lambda$jp42U8zZsPTeJGZfslK7L-pphE4, reason: not valid java name */
    public static /* synthetic */ x m620lambda$jp42U8zZsPTeJGZfslK7LpphE4(PlayerBubble r0) {
        return a(r0);
    }

    public c(Context r3, PlayerBubble r4, Class<? extends com.obric.autoaction.presentation.function.a.c> r5, am r6, long r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        am r9 = (am) ZeusTransformUtils.wrapperContextForParams(r6, am.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "context");
        d.h.b.o.e(r5, "countdownJobType");
        d.h.b.o.e(r9, "coroutineScope");
        this.f24941b = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.f24942c = r4;
        this.f24943d = r5;
        this.f24944e = r9;
        this.f = r7;
    }

    public /* synthetic */ c(Context r10, PlayerBubble r11, Class r12, am r13, long r14, int r16, h r17) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        am r6 = (am) ZeusTransformUtils.wrapperContextForParams(r13, am.class, "com.obric.aiagent.plugin");
        if ((r16 & 16) == 0) goto L5;
        long r7 = 1000;
    L6:
        this(r3, r11, r12, r6, r7);
        return;
    L5:
        r7 = r14;
        goto L6
    }

    public static final /* synthetic */ boolean a(c r0) {
        return r0.e();
    }

    public static final /* synthetic */ long b(c r2) {
        return r2.f;
    }

    public static final /* synthetic */ PlayerBubble c(c r0) {
        return r0.f24942c;
    }

    public final Context getContext() {
        return this.f24941b;
    }

    public final void a(boolean r3) {
        com.obric.autoaction.presentation.function.a.a.f24922a.a(this.f24943d, r3);
        a();
    }

    public final void a() {
        if (com.obric.autoaction.presentation.function.a.a.f24922a.c(this.f24943d) != null) goto L6;
        Loog.INSTANCE.w(TAG, "attachToJob: the job is not running; skipped.");
        return;
    L6:
        ca r0 = this.g;
        if (r0 == null) goto L9;
        ca.a.a(r0, null, 1, null);
    L9:
        this.g = i.a(this.f24944e, null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void b() {
        if (com.obric.autoaction.presentation.function.a.a.f24922a.c(this.f24943d) != null) goto L6;
        Loog.INSTANCE.w(TAG, "detachToJob: the job is not running; skipped.");
        return;
    L6:
        ca r2 = this.g;
        if (r2 == null) goto L10;
        ca.a.a(r2, null, 1, null);
        return;
    }

    private final boolean e() {
        com.obric.autoaction.presentation.function.a.c r0 = com.obric.autoaction.presentation.function.a.a.f24922a.c(this.f24943d);
        if (r0 != null) goto L6;
        a(0);
        return false;
    L6:
        long r4 = r0.a();
        if (r4 != 0) goto L10;
        a(0);
        return false;
    L10:
        a(r4);
        return true;
    }

    private final void a(final long r5) {
        if (r5 < (((long) ZeusTransformUtils.getResources(this.f24941b, "com.obric.aiagent.plugin").getInteger(ZeusTransformUtils.mapRes(R.integer.player_handuse_autoresume_countdown_secs, WsChannelMultiProcessSharedProvider.INT_TYPE, "player_handuse_autoresume_countdown_secs"))) * 1000)) goto L5;
    L8:
        a($$Lambda$c$jp42U8zZsPTeJGZfslK7LpphE4.INSTANCE);
        return;
    L5:
        if (r5 == 0) goto L8;
        a(new $$Lambda$c$a5tGF4m7sh2dvGrGF5LqJskzGZE(this, r5));
    }

    private static final x a(PlayerBubble r1) {
        d.h.b.o.e(r1, "$this$withBubble");
        r1.collapseBubble();
        return x.f38692a;
    }

    private static final x a(c r2, long r3, PlayerBubble r5) {
        d.h.b.o.e(r5, "$this$withBubble");
        r5.expandBubble(r2.a(((int) (r3 / 1000)) + 1));
        return x.f38692a;
    }

    public final void c() {
        ca r0 = this.g;
        boolean r1 = true;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        this.g = null;
        com.obric.autoaction.presentation.function.a.a.f24922a.a(this.f24943d);
        PlayerBubble r2 = this.f24942c;
        if (r2 != null) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == false) goto L14;
        a($$Lambda$c$KzBAQKN8gc4JEYpJOxvfbuKtkVc.INSTANCE);
        Loog.INSTANCE.d(TAG, "stopped auto resume countdown");
        return;
    L14:
        return;
    L8:
        if (r2.isInExpansionStatus() != true) goto L10;
        goto L10
    }

    private static final x b(PlayerBubble r1) {
        d.h.b.o.e(r1, "$this$withBubble");
        r1.collapseBubble();
        return x.f38692a;
    }

    public final void d() {
        com.obric.autoaction.presentation.function.a.c r0 = com.obric.autoaction.presentation.function.a.a.f24922a.c(this.f24943d);
        if (r0 != null) goto L6;
        Loog.INSTANCE.w(TAG, "resumeDirectly: the job is not running. create a new one and run it directly.");
        ((com.obric.autoaction.presentation.function.a.c) ZeusTransformUtils.preCheckCast(this.f24943d.newInstance(), com.obric.autoaction.presentation.function.a.c.class, "com.obric.aiagent.plugin")).d();
        return;
    L6:
        r0.d();
    }

    private final CharSequence a(int r8) {
        if (this.h != null) goto L5;
        this.h = (CharSequence) ZeusTransformUtils.preCheckCast(this.f24941b.getString(ZeusTransformUtils.mapRes(R.string.auto_floating_expand_almost_resumed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_floating_expand_almost_resumed")), CharSequence.class, "com.obric.aiagent.plugin");
    L5:
        SpannableStringBuilder r0 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast(this.f24941b.getString(ZeusTransformUtils.mapRes(R.string.auto_floating_expand_almost_resumed_countdown, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_floating_expand_almost_resumed_countdown"), new Object[]{Integer.valueOf(r8)}), CharSequence.class, "com.obric.aiagent.plugin"));
        r0.setSpan(new ForegroundColorSpan(this.f24941b.getColor(ZeusTransformUtils.mapRes(R.color.oui_text_3, "color", "oui_text_3"))), 0, r0.length(), 33);
        SpannableStringBuilder r7 = new SpannableStringBuilder(this.h).append(' ').append((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r7, "append(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final void a(d.h.a.b<? super PlayerBubble, x> r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new C0582c(this, r6, null), m.class, "com.obric.aiagent.plugin"));
    }
}
