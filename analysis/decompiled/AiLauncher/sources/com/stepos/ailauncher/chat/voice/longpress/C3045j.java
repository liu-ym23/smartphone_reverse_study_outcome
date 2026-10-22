package com.stepos.ailauncher.chat.voice.longpress;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.voice.longpress.Q;
import com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation;
import com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001Q\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bB/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00072\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001f\u001a\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00070\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0007H\u0016¢\u0006\u0004\b(\u0010\u000eJ\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010\u000eJ\u000f\u0010*\u001a\u00020\u0007H\u0016¢\u0006\u0004\b*\u0010\u000eJ\u0017\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0005H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0007H\u0002¢\u0006\u0004\b.\u0010\u000eJ\u000f\u0010/\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u0010\u000eJ\u000f\u00100\u001a\u00020\u0007H\u0002¢\u0006\u0004\b0\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109R\u0016\u0010;\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00109R$\u0010?\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b?\u00109\u001a\u0004\b?\u0010\fR\u0018\u0010@\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00101R\u0018\u0010A\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00109R\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u00109R\u0016\u0010H\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u00109R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020J0I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR&\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00070\u001c0I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010LR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\fR\u0014\u0010V\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\f¨\u0006W"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/j;", "Lcom/stepos/ailauncher/chat/voice/longpress/Q$a;", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "Lkotlin/Function0;", "", "canCancelListening", "LY8/t;", "onBackdropTap", "<init>", "(Landroid/view/View;Lp9/a;Lp9/a;)V", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()V", "e", "Lcom/stepos/ailauncher/speech/dialog/c;", "view", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/speech/dialog/c;)V", "", "hintRes", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)V", "", "text", "l", "(Ljava/lang/CharSequence;)V", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/voice/longpress/RecordingExitResult;", "onFinished", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lp9/l;)V", "withKeyFeedback", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)Z", "", "volume", "k", "(F)V", Const.INTENT_KEY_PKGNAME, "release", "f", "hidden", "x", "(Z)V", "t", "w", "s", "Landroid/view/View;", "Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation;", "animation", "Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation;", "Lcom/stepos/ailauncher/chat/voice/longpress/A;", "overlay", "Lcom/stepos/ailauncher/chat/voice/longpress/A;", "starting", "Z", "pendingKeyFeedback", "pendingVolume", "F", "externallyManagedHint", UxipConstants.f30680s, "isFinalizing", "waitingView", "recordingHintView", "Lcom/stepos/ailauncher/speech/dialog/c;", "homeBarHidden", "Lcom/stepos/ailauncher/chat/voice/longpress/V;", "amplitudeDriver", "Lcom/stepos/ailauncher/chat/voice/longpress/V;", "releasing", "keyFeedbackStarted", "", "Lcom/stepos/ailauncher/chat/voice/longpress/j$a;", "clipStates", "Ljava/util/List;", "exitCallbacks", "Ljava/lang/Runnable;", "cleanup", "Ljava/lang/Runnable;", "com/stepos/ailauncher/chat/voice/longpress/j$b", "detachListener", "Lcom/stepos/ailauncher/chat/voice/longpress/j$b;", "c", "isListening", "isRunning", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.longpress.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3045j implements Q.a {
    private final V amplitudeDriver;
    private final View anchor;
    private VoiceListenAnimation animation;
    private final Runnable cleanup;
    private final List<ClipState> clipStates;
    private final b detachListener;
    private final List<InterfaceC5074l<RecordingExitResult, Y8.t>> exitCallbacks;
    private boolean externallyManagedHint;
    private boolean homeBarHidden;
    private boolean isFinalizing;
    private boolean keyFeedbackStarted;
    private final A overlay;
    private boolean pendingKeyFeedback;
    private float pendingVolume;
    private com.stepos.ailauncher.speech.dialog.c recordingHintView;
    private boolean releasing;
    private boolean starting;
    private View waitingView;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/j$a;", "", "Landroid/view/ViewGroup;", "view", "", "children", "padding", "<init>", "(Landroid/view/ViewGroup;ZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroid/view/ViewGroup;", "c", "()Landroid/view/ViewGroup;", "Z", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.longpress.j$a, reason: from toString */
    public static final /* data */ class ClipState {
        private final boolean children;
        private final boolean padding;
        private final ViewGroup view;

        public ClipState(ViewGroup view, boolean z10, boolean z11) {
            kotlin.jvm.internal.p.i(view, "view");
            this.view = view;
            this.children = z10;
            this.padding = z11;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getChildren() {
            return this.children;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getPadding() {
            return this.padding;
        }

        /* renamed from: c, reason: from getter */
        public final ViewGroup getView() {
            return this.view;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClipState)) {
                return false;
            }
            ClipState clipState = (ClipState) other;
            return kotlin.jvm.internal.p.d(this.view, clipState.view) && this.children == clipState.children && this.padding == clipState.padding;
        }

        public int hashCode() {
            return (((this.view.hashCode() * 31) + Boolean.hashCode(this.children)) * 31) + Boolean.hashCode(this.padding);
        }

        public String toString() {
            return "ClipState(view=" + this.view + ", children=" + this.children + ", padding=" + this.padding + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/voice/longpress/j$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.longpress.j$b */
    public static final class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            C3045j.this.f();
        }
    }

    public C3045j(View anchor, final InterfaceC5063a<Boolean> canCancelListening, InterfaceC5063a<Y8.t> onBackdropTap) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(canCancelListening, "canCancelListening");
        kotlin.jvm.internal.p.i(onBackdropTap, "onBackdropTap");
        this.anchor = anchor;
        this.overlay = new A(anchor, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(C3045j.u(this.f26470a, canCancelListening));
            }
        }, onBackdropTap);
        this.amplitudeDriver = new V(anchor, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.longpress.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C3045j.q(this.f26472a, ((Float) obj).floatValue());
            }
        });
        this.clipStates = new ArrayList();
        this.exitCallbacks = new ArrayList();
        this.cleanup = new Runnable() { // from class: com.stepos.ailauncher.chat.voice.longpress.i
            @Override // java.lang.Runnable
            public final void run() {
                C3045j.r(this.f26473a);
            }
        };
        this.detachListener = new b();
    }

    public static final Y8.t q(C3045j c3045j, float f10) {
        VoiceListenAnimation voiceListenAnimation = c3045j.animation;
        if (voiceListenAnimation != null) {
            voiceListenAnimation.S0(f10);
        }
        return Y8.t.f7040a;
    }

    public static final void r(C3045j c3045j) {
        c3045j.s();
    }

    public static final boolean u(C3045j c3045j, InterfaceC5063a interfaceC5063a) {
        return c3045j.c() && ((Boolean) interfaceC5063a.invoke()).booleanValue();
    }

    public static final Y8.t v(C3045j c3045j, FrameLayout frameLayout) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            c3045j.t();
            VoiceListenAnimation voiceListenAnimation = new VoiceListenAnimation(frameLayout);
            c3045j.animation = voiceListenAnimation;
            c3045j.starting = false;
            voiceListenAnimation.S0(0.0f);
            voiceListenAnimation.C0(c3045j.pendingKeyFeedback ? VoiceListenAnimation.PlayMask.BOTH : VoiceListenAnimation.PlayMask.LISTEN);
            com.stepos.ailauncher.speech.dialog.c cVar = c3045j.recordingHintView;
            if (cVar != null) {
                cVar.bringToFront();
            }
            if (!c3045j.isFinalizing) {
                c3045j.amplitudeDriver.h();
                c3045j.amplitudeDriver.g(c3045j.pendingVolume);
            }
            c3045j.keyFeedbackStarted = c3045j.pendingKeyFeedback;
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e("FullScreenVoiceListen", "Unable to start listening effect", thE);
            c3045j.f();
        }
        return Y8.t.f7040a;
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public boolean a() {
        if (!c()) {
            return false;
        }
        this.isFinalizing = true;
        w();
        b();
        this.amplitudeDriver.i();
        this.pendingVolume = 0.0f;
        VoiceListenAnimation voiceListenAnimation = this.animation;
        if (voiceListenAnimation != null) {
            voiceListenAnimation.S0(0.0f);
        }
        float f10 = this.anchor.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(this.anchor.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        Context context = this.anchor.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        VoiceWaitingDotsView voiceWaitingDotsView = new VoiceWaitingDotsView(context, null, 2, null);
        voiceWaitingDotsView.setAlpha(0.9f);
        voiceWaitingDotsView.setImportantForAccessibility(2);
        int i10 = (int) (24 * f10);
        linearLayout.addView(voiceWaitingDotsView, new LinearLayout.LayoutParams(i10, i10));
        TextView textView = new TextView(this.anchor.getContext());
        textView.setText(R$string.full_screen_asr_waiting);
        textView.setTextSize(16.0f);
        textView.setTextColor(-1);
        textView.setAlpha(0.7f);
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart((int) (6 * f10));
        Y8.t tVar = Y8.t.f7040a;
        linearLayout.addView(textView, layoutParams);
        FrameLayout foreground = this.overlay.getForeground();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, i10, 80);
        layoutParams2.bottomMargin = (int) (84 * f10);
        foreground.addView(linearLayout, layoutParams2);
        this.waitingView = linearLayout;
        return true;
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public void b() {
        this.pendingKeyFeedback = false;
        this.keyFeedbackStarted = false;
        VoiceListenAnimation voiceListenAnimation = this.animation;
        if (voiceListenAnimation != null) {
            voiceListenAnimation.e1();
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public boolean c() {
        return ((!this.starting && this.animation == null) || this.releasing || this.isFinalizing) ? false : true;
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public void d(com.stepos.ailauncher.speech.dialog.c view) {
        kotlin.jvm.internal.p.i(view, "view");
        if (this.recordingHintView != view) {
            w();
        }
        this.externallyManagedHint = true;
        view.q();
        this.recordingHintView = view;
        if (this.overlay.getForeground().isAttachedToWindow()) {
            t();
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public void e() {
        this.overlay.z();
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public void f() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        List listM1 = Z8.F.m1(this.exitCallbacks);
        this.exitCallbacks.clear();
        x(false);
        this.isFinalizing = false;
        w();
        View view = this.waitingView;
        if (view != null && (viewPropertyAnimatorAnimate = view.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        View view2 = this.waitingView;
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view2);
            }
        }
        this.waitingView = null;
        this.amplitudeDriver.i();
        this.anchor.removeCallbacks(this.cleanup);
        this.anchor.removeOnAttachStateChangeListener(this.detachListener);
        VoiceListenAnimation voiceListenAnimation = this.animation;
        if (voiceListenAnimation != null) {
            voiceListenAnimation.f0();
        }
        this.overlay.n();
        this.starting = false;
        this.pendingVolume = 0.0f;
        this.pendingKeyFeedback = false;
        this.animation = null;
        this.releasing = false;
        this.keyFeedbackStarted = false;
        for (ClipState clipState : this.clipStates) {
            clipState.getView().setClipChildren(clipState.getChildren());
            clipState.getView().setClipToPadding(clipState.getPadding());
        }
        this.clipStates.clear();
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            ((InterfaceC5074l) it.next()).invoke(RecordingExitResult.INTERRUPTED);
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public void g(InterfaceC5074l<? super RecordingExitResult, Y8.t> onFinished) {
        kotlin.jvm.internal.p.i(onFinished, "onFinished");
        this.exitCallbacks.add(onFinished);
        this.isFinalizing = false;
        if (this.starting || this.animation == null || !ValueAnimator.areAnimatorsEnabled()) {
            s();
        } else {
            release();
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public boolean h(boolean withKeyFeedback) {
        if (c()) {
            if (this.starting) {
                this.pendingKeyFeedback = this.pendingKeyFeedback || withKeyFeedback;
                return true;
            }
            if (withKeyFeedback && !this.keyFeedbackStarted) {
                VoiceListenAnimation voiceListenAnimation = this.animation;
                if (voiceListenAnimation != null) {
                    voiceListenAnimation.D0();
                }
                this.keyFeedbackStarted = true;
            }
            return true;
        }
        f();
        if (!this.anchor.isAttachedToWindow() || this.anchor.getWindowToken() == null) {
            return false;
        }
        final FrameLayout content = this.overlay.getContent();
        ViewGroup viewGroup = content;
        for (int i10 = 0; i10 < 4; i10++) {
            if (viewGroup != null) {
                this.clipStates.add(new ClipState(viewGroup, viewGroup.getClipChildren(), viewGroup.getClipToPadding()));
                ViewParent parent = viewGroup.getParent();
                viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            }
        }
        this.anchor.addOnAttachStateChangeListener(this.detachListener);
        this.starting = true;
        this.pendingKeyFeedback = withKeyFeedback;
        x(true);
        boolean zV = this.overlay.v(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C3045j.v(this.f26466a, content);
            }
        });
        if (!zV) {
            f();
        }
        return zV;
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public void i(int hintRes) {
        if (!c() || this.externallyManagedHint) {
            return;
        }
        com.stepos.ailauncher.speech.dialog.c cVar = this.recordingHintView;
        if (cVar == null) {
            Context context = this.anchor.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            cVar = new com.stepos.ailauncher.speech.dialog.c(context);
            cVar.setSwipeToCancelEnabled(false);
            cVar.setListeningTip(true);
            cVar.q();
            this.recordingHintView = cVar;
        }
        cVar.setRecordingHint(this.anchor.getContext().getText(hintRes));
        t();
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public boolean isRunning() {
        return this.starting || this.animation != null;
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public void j() {
        if (this.isFinalizing) {
            this.isFinalizing = false;
            release();
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public void k(float volume) {
        this.pendingVolume = volume;
        if (c()) {
            this.amplitudeDriver.g(volume);
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public void l(CharSequence text) {
        com.stepos.ailauncher.speech.dialog.c cVar;
        if (!c() || (cVar = this.recordingHintView) == null) {
            return;
        }
        cVar.setCountdownHint(text);
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.a
    public void release() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator viewPropertyAnimatorAnimate2;
        ViewPropertyAnimator viewPropertyAnimatorAlpha2;
        ViewPropertyAnimator duration2;
        ViewPropertyAnimator interpolator2;
        if (this.isFinalizing) {
            return;
        }
        if (this.starting) {
            f();
            return;
        }
        VoiceListenAnimation voiceListenAnimation = this.animation;
        if (voiceListenAnimation == null || this.releasing) {
            return;
        }
        this.releasing = true;
        this.amplitudeDriver.i();
        this.overlay.o();
        com.stepos.ailauncher.speech.dialog.c cVar = this.recordingHintView;
        if (cVar != null && (viewPropertyAnimatorAnimate2 = cVar.animate()) != null && (viewPropertyAnimatorAlpha2 = viewPropertyAnimatorAnimate2.alpha(0.0f)) != null && (duration2 = viewPropertyAnimatorAlpha2.setDuration(150L)) != null && (interpolator2 = duration2.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f))) != null) {
            interpolator2.start();
        }
        View view = this.waitingView;
        if (view != null && (viewPropertyAnimatorAnimate = view.animate()) != null && (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(0.0f)) != null && (duration = viewPropertyAnimatorAlpha.setDuration(150L)) != null && (interpolator = duration.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f))) != null) {
            interpolator.start();
        }
        voiceListenAnimation.I0();
        this.anchor.postDelayed(this.cleanup, Math.max((long) Math.ceil(((this.keyFeedbackStarted ? b9.c.g(voiceListenAnimation.getAudioWave().a(), voiceListenAnimation.getWaterDrop().a(), voiceListenAnimation.getGlow().a(), voiceListenAnimation.getGlowRipple().a()) : Math.max(voiceListenAnimation.getAudioWave().a(), voiceListenAnimation.getWaterDrop().a())) * 1000.0d) / C5685n.e(voiceListenAnimation.getSpeed(), 0.01f)), 150L));
    }

    public final void s() {
        List listM1 = Z8.F.m1(this.exitCallbacks);
        this.exitCallbacks.clear();
        f();
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            ((InterfaceC5074l) it.next()).invoke(RecordingExitResult.COMPLETED);
        }
    }

    public final void t() {
        com.stepos.ailauncher.speech.dialog.c cVar = this.recordingHintView;
        if (cVar == null) {
            return;
        }
        if (cVar.getParent() != this.overlay.getForeground()) {
            ViewParent parent = cVar.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(cVar);
            }
            this.overlay.getForeground().addView(cVar, new ViewGroup.LayoutParams(-1, -1));
        }
        cVar.bringToFront();
    }

    public final void w() {
        com.stepos.ailauncher.speech.dialog.c cVar = this.recordingHintView;
        if (cVar != null) {
            cVar.animate().cancel();
            ViewParent parent = cVar.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(cVar);
            }
        }
        this.recordingHintView = null;
        this.externallyManagedHint = false;
    }

    public final void x(boolean hidden) {
        IHomeBarSysUiService iHomeBarSysUiService;
        if (this.homeBarHidden == hidden || (iHomeBarSysUiService = (IHomeBarSysUiService) D5.a.INSTANCE.a(IHomeBarSysUiService.class)) == null) {
            return;
        }
        iHomeBarSysUiService.showHomeBarCapsule(hidden, null);
        this.homeBarHidden = hidden;
    }
}
