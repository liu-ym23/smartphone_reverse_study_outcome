package com.obric.oui.textswitcher;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.j;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.h.b.z;
import d.x;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: OTextSwitcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OTextSwitcher extends TextSwitcher {
    private final f defaultViewFactory$delegate;
    private boolean hadStart;
    private Timer mOTextSwitcherTimer;
    private final f mUiHander$delegate;
    private d oTextSwitcherSpec;
    private final OTextSwitcher$textSwitcherOnAttachStateChangeListener$1 textSwitcherOnAttachStateChangeListener;

    /* JADX INFO: compiled from: OTextSwitcher.kt */
    static final class a extends p implements d.h.a.a<ViewSwitcher.ViewFactory> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f36470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OTextSwitcher f36471b;

        a(Context r3, OTextSwitcher r4) {
            this.f36470a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            this.f36471b = r4;
            super(0);
        }

        public static /* synthetic */ View lambda$860dtbxWSWLL7UH23Ii_NEZeGto(Context r0, OTextSwitcher r1) {
            return a(r0, r1);
        }

        @Override // d.h.a.a
        public /* synthetic */ ViewSwitcher.ViewFactory invoke() {
            return a();
        }

        public final ViewSwitcher.ViewFactory a() {
            final Context r0 = this.f36470a;
            final OTextSwitcher r2 = this.f36471b;
            return new $$Lambda$OTextSwitcher$a$860dtbxWSWLL7UH23Ii_NEZeGto(r0, r2);
        }

        private static final View a(Context r9, OTextSwitcher r10) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
            o.e(r3, "$context");
            o.e(r10, "this$0");
            OTextView r11 = new OTextView(r3, null, 0, null, 14, null);
            d r0 = OTextSwitcher.access$getOTextSwitcherSpec$p(r10);
            if (r0 != null) goto L5;
            com.obric.oui.textswitcher.b r1 = null;
        L6:
            if (r1 == null) goto L13;
            Integer r2 = r1.a();
            if (r2 == null) goto L13;
            r11.setTextColor(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue());
        L13:
            if (r1 == null) goto L19;
            Float r4 = r1.b();
            if (r4 == null) goto L19;
            r11.setTextSize(1, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).floatValue());
        L19:
            boolean r5 = false;
            if (r1 == null) goto L28;
            int[] r6 = r1.c();
            if (r6 == null) goto L28;
            if (r6.length != 4) goto L28;
            r11.setPadding(r6[0], r6[1], r6[2], r6[3]);
        L28:
            r11.setGravity(16);
            r11.setSingleLine(true);
            d r12 = OTextSwitcher.access$getOTextSwitcherSpec$p(r10);
            if (r12 != null) goto L32;
        L34:
            if (r5 == false) goto L36;
            r11.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            r11.setMarqueeRepeatLimit(-1);
            r11.setSelected(true);
            r11.setHorizontallyScrolling(true);
            r11.setFocusableInTouchMode(true);
        L38:
            return (View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin");
        L36:
            r11.setEllipsize(TextUtils.TruncateAt.END);
            goto L38
        L32:
            if (r12.e() != true) goto L34;
            r5 = true;
            goto L34
        L5:
            r1 = r0.a();
            goto L6
        }
    }

    /* JADX INFO: compiled from: OTextSwitcher.kt */
    static final class b extends p implements d.h.a.a<Handler> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f36472a = null;

        static {
            f36472a = new b();
        }

        b() {
            super(0);
        }

        public final Handler a() {
            return new Handler(Looper.getMainLooper());
        }

        @Override // d.h.a.a
        public /* synthetic */ Handler invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OTextSwitcher.kt */
    public static final class c extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTextSwitcher f36473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f36474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.d f36475c;

        /* JADX INFO: renamed from: lambda$nb01-iNULWJgNY8kX-R3Ye4ratU, reason: not valid java name */
        public static /* synthetic */ void m1202lambda$nb01iNULWJgNY8kXR3Ye4ratU(ArrayList r0, z.d r1, OTextSwitcher r2) {
            a(r0, r1, r2);
        }

        c(OTextSwitcher r1, ArrayList<String> r2, z.d r3) {
            this.f36473a = r1;
            this.f36474b = r2;
            this.f36475c = r3;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Handler r0 = OTextSwitcher.access$getMUiHander(this.f36473a);
            final ArrayList<String> r1 = this.f36474b;
            final z.d r2 = this.f36475c;
            final OTextSwitcher r4 = this.f36473a;
            r0.post(new $$Lambda$OTextSwitcher$c$nb01iNULWJgNY8kXR3Ye4ratU(r1, r2, r4));
        }

        private static final void a(ArrayList r3, z.d r4, OTextSwitcher r5) {
            o.e(r4, "$index");
            o.e(r5, "this$0");
            int r1 = r3.size();     // Catch: Exception -> L11
            if (r1 > 0) goto L7;
            return;
        L7:
            if (r4.f38502a <= r1) goto L9;
            r4.f38502a %= r1;     // Catch: Exception -> L11
        L9:
            Object r6 = r3.get(r4.f38502a);     // Catch: Exception -> L11
            o.c(r6, "dataArrayList[index]");     // Catch: Exception -> L11
            OTextSwitcher.access$safeUpdateText(r5, (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L11
            r4.f38502a = (r4.f38502a + 1) % r1;     // Catch: Exception -> L11
            x r7 = x.f38692a;     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            j.a(o.a("Try exception occur ", e.getMessage()));
            Throwable r8 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");
            x r9 = x.f38692a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OTextSwitcher(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void lambda$mycTaU_oKlXc4biSi_0mXnzZd3g(ArrayList r0, OTextSwitcher r1) {
        m1201startAfterBuild$lambda11(r0, r1);
    }

    public /* synthetic */ OTextSwitcher(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ Handler access$getMUiHander(OTextSwitcher r0) {
        return r0.getMUiHander();
    }

    public static final /* synthetic */ d access$getOTextSwitcherSpec$p(OTextSwitcher r0) {
        return r0.oTextSwitcherSpec;
    }

    public static final /* synthetic */ void access$safeUpdateText(OTextSwitcher r0, String r1) {
        r0.safeUpdateText(r1);
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [com.obric.oui.textswitcher.OTextSwitcher$textSwitcherOnAttachStateChangeListener$1] */
    public OTextSwitcher(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r6);
        this.mUiHander$delegate = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(b.f36472a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.defaultViewFactory$delegate = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r5, this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        this.textSwitcherOnAttachStateChangeListener = new OTextSwitcher$textSwitcherOnAttachStateChangeListener$1(this);
    }

    private final Handler getMUiHander() {
        return (Handler) ZeusTransformUtils.preCheckCast(this.mUiHander$delegate.b(), Handler.class, "com.obric.aiagent.plugin");
    }

    private final ViewSwitcher.ViewFactory getDefaultViewFactory() {
        return (ViewSwitcher.ViewFactory) ZeusTransformUtils.preCheckCast(this.defaultViewFactory$delegate.b(), ViewSwitcher.ViewFactory.class, "com.obric.aiagent.plugin");
    }

    public void build(d r6) {
        o.e(r6, "spec");
        this.oTextSwitcherSpec = r6;
        if (getChildCount() <= 0) goto L5;
        removeAllViews();
    L5:
        d r7 = this.oTextSwitcherSpec;
        if (r7 == null) goto L32;
        x r1 = null;
        ViewSwitcher.ViewFactory r8 = r7.d();     // Catch: Exception -> L17
        if (r8 != null) goto L12;
        x r9 = null;
    L13:
        if (r9 != null) goto L15;
        setFactory(getDefaultViewFactory());     // Catch: Exception -> L17
    L15:
        x r10 = x.f38692a;     // Catch: Exception -> L17
    L19:
        Animation r11 = getInAnimation();
        if (r11 != null) goto L22;
        x r12 = null;
    L24:
        if (r12 != null) goto L26;
        setInAnimation((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.anim.o_textswitcher_vertical_in, "anim", "o_textswitcher_vertical_in"));
    L26:
        Animation r13 = getOutAnimation();
        if (r13 == null) goto L30;
        setOutAnimation(r13);
        r1 = x.f38692a;
    L30:
        if (r1 != null) goto L32;
        setOutAnimation((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.anim.o_textswitcher_vertical_out, "anim", "o_textswitcher_vertical_out"));
        goto L32
    L22:
        setInAnimation(r11);
        r12 = x.f38692a;
        goto L24
    L12:
        setFactory(r8);     // Catch: Exception -> L17
        r9 = x.f38692a;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        j.a(o.a("Try exception occur ", e.getMessage()));
        j.a(o.a("viewFratory exception occur, error msg = ", ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")).getMessage()));
        x r14 = x.f38692a;
    L32:
        removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(this.textSwitcherOnAttachStateChangeListener, View.OnAttachStateChangeListener.class, "com.obric.aiagent.plugin"));
        addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(this.textSwitcherOnAttachStateChangeListener, View.OnAttachStateChangeListener.class, "com.obric.aiagent.plugin"));
    }

    public void startAfterBuild() {
        z.d r1 = new z.d();
        d r2 = this.oTextSwitcherSpec;
        if (r2 != null) goto L5;
    L4:
        final ArrayList<String> r3 = null;
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        boolean r5 = true;
        if (r3.size() != 1) goto L24;
        d r4 = this.oTextSwitcherSpec;
        if (r4 != null) goto L16;
    L15:
        r5 = false;
    L21:
        if (r5 == false) goto L24;
        getMUiHander().post(new $$Lambda$OTextSwitcher$mycTaU_oKlXc4biSi_0mXnzZd3g(r3, this));
        return;
    L16:
        e r6 = r4.b();
        if (r6 == null) goto L15;
        if (r6.c() == true) goto L15;
    L24:
        c r7 = new c(this, r3, r1);
        d r8 = this.oTextSwitcherSpec;
        long r9 = 0;
        if (r8 != null) goto L27;
    L26:
        long r10 = r9;
        d r11 = this.oTextSwitcherSpec;
        if (r11 != null) goto L34;
    L33:
        long r12 = 1000;
    L49:
        Timer r13 = this.mOTextSwitcherTimer;     // Catch: Exception -> L46
        if (r13 == null) goto L44;
        if (r13 == null) goto L43;
        r13.cancel();     // Catch: Exception -> L46
    L43:
        this.mOTextSwitcherTimer = null;     // Catch: Exception -> L46
    L44:
        Timer r14 = new Timer();     // Catch: Exception -> L46
        this.mOTextSwitcherTimer = r14;     // Catch: Exception -> L46
        r14.schedule((TimerTask) ZeusTransformUtils.preCheckCast(r7, TimerTask.class, "com.obric.aiagent.plugin"), r10, r12);     // Catch: Exception -> L46
        x r15 = x.f38692a;     // Catch: Exception -> L46
        return;
    L46:
        e = move-exception;
        j.a(o.a("Try exception occur ", e.getMessage()));
        Throwable r16 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");
        x r17 = x.f38692a;
        return;
    L34:
        e r18 = r11.b();
        if (r18 == null) goto L33;
        r12 = r18.b();
        goto L49
    L27:
        e r19 = r8.b();
        if (r19 == null) goto L26;
        r9 = r19.a();
        goto L26
    L5:
        com.obric.oui.textswitcher.c r20 = r2.c();
        if (r20 == null) goto L4;
        r3 = r20.a();
        goto L9
    }

    /* JADX INFO: renamed from: startAfterBuild$lambda-11, reason: not valid java name */
    private static final void m1201startAfterBuild$lambda11(ArrayList r2, OTextSwitcher r3) {
        o.e(r3, "this$0");
        Object r4 = r2.get(0);     // Catch: Exception -> L5
        o.c(r4, "dataArrayList[0]");     // Catch: Exception -> L5
        r3.setCurrentText((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L5
        x r5 = x.f38692a;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        j.a(o.a("Try exception occur ", e.getMessage()));
        Throwable r6 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");
        x r7 = x.f38692a;
    }

    private final void safeUpdateText(String r3) {
        setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L5
        x r2 = x.f38692a;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        j.a(o.a("Try exception occur ", e.getMessage()));
        Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");
        x r5 = x.f38692a;
    }

    public void stopAnim() {
        this.hadStart = false;
        clearAnimation();     // Catch: Exception -> L9
        Timer r0 = this.mOTextSwitcherTimer;     // Catch: Exception -> L9
        if (r0 == null) goto L7;
        r0.cancel();     // Catch: Exception -> L9
    L7:
        this.mOTextSwitcherTimer = null;     // Catch: Exception -> L9
        x r2 = x.f38692a;     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        j.a(o.a("Try exception occur ", e.getMessage()));
        Throwable r3 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin");
        x r4 = x.f38692a;
    }
}
