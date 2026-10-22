package com.stepos.ailauncher.agent.aispace.connect;

import android.content.Context;
import android.content.ContextWrapper;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import b.AbstractC1417G;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import p7.AppUI;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J_\u0010\u0014\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010 \u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/k;", "", "<init>", "()V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "Landroid/view/ViewGroup;", "host", "", "title", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "protocolLabel", "entryType", "Lkotlin/Function0;", "LY8/t;", "onProtocol", "onAgree", "onCancel", "k", "(Landroid/view/ViewGroup;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/a;Lp9/a;Lp9/a;)V", "Landroid/view/View;", "overlay", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/view/View;)V", "Landroid/content/Context;", "context", "Lb/q;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;)Lb/q;", "label", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;Lp9/a;)Ljava/lang/CharSequence;", "showingOverlay", "Landroid/view/View;", "Lb/G;", "backCallback", "Lb/G;", "dismissAsCancel", "Lp9/a;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2213k {
    public static final C2213k INSTANCE = new C2213k();
    private static AbstractC1417G backCallback;
    private static InterfaceC5063a<Y8.t> dismissAsCancel;
    private static View showingOverlay;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/agent/aispace/connect/k$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.k$a */
    public static final class a extends ClickableSpan {
        final /* synthetic */ InterfaceC5063a<Y8.t> $onProtocol;

        public a(InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.$onProtocol = interfaceC5063a;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.p.i(widget, "widget");
            this.$onProtocol.invoke();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.p.i(ds, "ds");
            ds.setColor(-14652161);
            ds.setUnderlineText(false);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/agent/aispace/connect/k$b", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "()Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.k$b */
    public static final class b implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ Y4.m $binding;
        final /* synthetic */ int $scrollMaxPx;

        public b(Y4.m mVar, int i10) {
            this.$binding = mVar;
            this.$scrollMaxPx = i10;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.$binding.scrollAuthContent.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.$binding.scrollAuthContent.getHeight() <= this.$scrollMaxPx) {
                return true;
            }
            ScrollView scrollView = this.$binding.scrollAuthContent;
            ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
            layoutParams.height = this.$scrollMaxPx;
            scrollView.setLayoutParams(layoutParams);
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/agent/aispace/connect/k$c", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.k$c */
    public static final class c extends AbstractC1417G {
        public c() {
            super(true);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
            C2213k.INSTANCE.h();
        }
    }

    public static final void l(Ref$BooleanRef ref$BooleanRef, FrameLayout frameLayout, InterfaceC5063a<Y8.t> interfaceC5063a, InterfaceC5063a<Y8.t> interfaceC5063a2, boolean z10) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        W4.c.INSTANCE.h(z10);
        INSTANCE.i(frameLayout);
        if (z10) {
            interfaceC5063a.invoke();
        } else {
            interfaceC5063a2.invoke();
        }
    }

    public static final Y8.t m(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final Y8.t n(Ref$BooleanRef ref$BooleanRef, FrameLayout frameLayout, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2) {
        l(ref$BooleanRef, frameLayout, interfaceC5063a, interfaceC5063a2, false);
        return Y8.t.f7040a;
    }

    public static final void o(Ref$BooleanRef ref$BooleanRef, FrameLayout frameLayout, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, View view) {
        l(ref$BooleanRef, frameLayout, interfaceC5063a, interfaceC5063a2, false);
    }

    public static final void p(View view) {
    }

    public static final void q(Ref$BooleanRef ref$BooleanRef, FrameLayout frameLayout, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, View view) {
        l(ref$BooleanRef, frameLayout, interfaceC5063a, interfaceC5063a2, false);
    }

    public static final void r(Ref$BooleanRef ref$BooleanRef, FrameLayout frameLayout, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, View view) {
        l(ref$BooleanRef, frameLayout, interfaceC5063a, interfaceC5063a2, true);
    }

    public final CharSequence g(String content, String label, InterfaceC5063a<Y8.t> onProtocol) {
        SpannableString spannableString = new SpannableString(content);
        int iU0 = La.H.u0(content, label, 0, false, 6, null);
        if (iU0 < 0) {
            return spannableString;
        }
        spannableString.setSpan(new a(onProtocol), iU0, label.length() + iU0, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), iU0, label.length() + iU0, 33);
        return spannableString;
    }

    public final boolean h() {
        InterfaceC5063a<Y8.t> interfaceC5063a = dismissAsCancel;
        if (interfaceC5063a == null) {
            return false;
        }
        interfaceC5063a.invoke();
        return true;
    }

    public final void i(View overlay) {
        if (showingOverlay == overlay) {
            showingOverlay = null;
        }
        dismissAsCancel = null;
        AbstractC1417G abstractC1417G = backCallback;
        if (abstractC1417G != null) {
            abstractC1417G.remove();
        }
        backCallback = null;
        ViewParent parent = overlay.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(overlay);
        }
    }

    public final b.q j(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof b.q) {
                return (b.q) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public final void k(ViewGroup host, CharSequence title, String content, String protocolLabel, String entryType, final InterfaceC5063a<Y8.t> onProtocol, final InterfaceC5063a<Y8.t> onAgree, final InterfaceC5063a<Y8.t> onCancel) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(protocolLabel, "protocolLabel");
        kotlin.jvm.internal.p.i(entryType, "entryType");
        kotlin.jvm.internal.p.i(onProtocol, "onProtocol");
        kotlin.jvm.internal.p.i(onAgree, "onAgree");
        kotlin.jvm.internal.p.i(onCancel, "onCancel");
        Y4.m mVarC = Y4.m.c(LayoutInflater.from(host.getContext()), host, false);
        kotlin.jvm.internal.p.h(mVarC, "inflate(...)");
        final FrameLayout frameLayoutB = mVarC.b();
        kotlin.jvm.internal.p.h(frameLayoutB, "getRoot(...)");
        mVarC.tvAuthTitle.setText(title);
        TextView textView = mVarC.tvAuthContent;
        textView.setText(INSTANCE.g(content, protocolLabel, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C2213k.m(onProtocol);
            }
        }));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        mVarC.scrollAuthContent.getViewTreeObserver().addOnPreDrawListener(new b(mVarC, (int) (360 * host.getResources().getDisplayMetrics().density)));
        showingOverlay = frameLayoutB;
        Context context = host.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        b.q qVarJ = j(context);
        if (qVarJ != null && (onBackPressedDispatcher = qVarJ.getOnBackPressedDispatcher()) != null) {
            AbstractC1417G abstractC1417G = backCallback;
            if (abstractC1417G != null) {
                abstractC1417G.remove();
            }
            c cVar = new c();
            onBackPressedDispatcher.n(cVar);
            backCallback = cVar;
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        dismissAsCancel = new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C2213k.n(ref$BooleanRef, frameLayoutB, onAgree, onCancel);
            }
        };
        frameLayoutB.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2213k.o(ref$BooleanRef, frameLayoutB, onAgree, onCancel, view);
            }
        });
        mVarC.authPanel.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2213k.p(view);
            }
        });
        mVarC.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2213k.q(ref$BooleanRef, frameLayoutB, onAgree, onCancel, view);
            }
        });
        mVarC.btnConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2213k.r(ref$BooleanRef, frameLayoutB, onAgree, onCancel, view);
            }
        });
        host.addView(frameLayoutB);
        W4.c.INSTANCE.i(entryType);
    }
}
