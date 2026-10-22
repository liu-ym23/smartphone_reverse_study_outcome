package com.stepos.ailauncher.speech.dialog;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.container.glass.h;
import com.stepos.ailauncher.speech.R$drawable;
import com.stepos.ailauncher.speech.R$id;
import com.stepos.ailauncher.speech.R$layout;
import com.stepos.ailauncher.speech.R$string;
import com.stepos.ailauncher.speech.dialog.a;
import com.stepos.ailauncher.speech.view.DotWaveVoiceView;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.d;
import y7.E;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0017\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 p2\u00020\u00012\u00020\u0002:\u0001qB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u0017\u0010\u001c\u001a\u00020\u00112\b\b\u0001\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001c\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001c\u0010 J\r\u0010!\u001a\u00020\u0011¢\u0006\u0004\b!\u0010\u0013J\u0017\u0010$\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b&\u0010%J\u0015\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u001a¢\u0006\u0004\b(\u0010\u001dJ\u0015\u0010*\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\t¢\u0006\u0004\b*\u0010\u0018J\u0019\u0010-\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u0015\u00100\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\t¢\u0006\u0004\b0\u0010\u0018J\u0017\u00103\u001a\u00020\u00112\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b5\u00106J\u0015\u00108\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u001a¢\u0006\u0004\b8\u0010\u001dJ\u0017\u00109\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b9\u0010\u0018J\u001d\u0010;\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u001a¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0011H\u0016¢\u0006\u0004\b=\u0010\u0013J\u000f\u0010>\u001a\u00020\tH\u0016¢\u0006\u0004\b>\u0010?J\u0011\u0010A\u001a\u0004\u0018\u00010@H\u0016¢\u0006\u0004\bA\u0010BR\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010CR\u0016\u0010D\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010HR\u0016\u0010J\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010K\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010HR\"\u0010L\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bL\u0010?\"\u0004\bN\u0010\u0018R\u0016\u0010O\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010P\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010MR\u0016\u0010Q\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010MR\u0016\u0010R\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010MR\u0016\u0010S\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010MR\u0018\u0010T\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010V\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Y\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\"\u0010^\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010E\u001a\u0004\b_\u0010`\"\u0004\ba\u0010\u001dR\"\u0010b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010E\u001a\u0004\bc\u0010`\"\u0004\bd\u0010\u001dR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\"\u0010h\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010M\u001a\u0004\bi\u0010?\"\u0004\bj\u0010\u0018R*\u0010l\u001a\u00020\t2\u0006\u0010k\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010M\u001a\u0004\bm\u0010?\"\u0004\bn\u0010\u0018R\u0016\u0010o\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010E¨\u0006r"}, d2 = {"Lcom/stepos/ailauncher/speech/dialog/c;", "Landroid/widget/FrameLayout;", "Lcom/stepos/ailauncher/speech/dialog/a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/MotionEvent;", "event", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/MotionEvent;)Z", "Landroid/view/View;", "anchorView", "Landroid/view/ViewGroup;", "k", "(Landroid/view/View;)Landroid/view/ViewGroup;", "LY8/t;", "c", "()V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "cancel", "p", "(Z)V", "onTouchEvent", "", "resId", "setWindowBackground", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "q", "", "text", "setRecordingHint", "(Ljava/lang/CharSequence;)V", "setCountdownHint", "px", "setTipBottomSpace", d.EXTRA_ENABLED, "setSwipeToCancelEnabled", "Lcom/stepos/ailauncher/speech/dialog/a$a;", "listener", "l", "(Lcom/stepos/ailauncher/speech/dialog/a$a;)Lcom/stepos/ailauncher/speech/dialog/a;", "listening", "setListeningTip", "", "audioData", "o", "([S)V", "m", "(Landroid/view/View;)V", "y", "n", "setCancelState", "dp", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;I)I", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "Landroid/widget/TextView;", "getTipView", "()Landroid/widget/TextView;", "Lcom/stepos/ailauncher/speech/dialog/a$a;", "cancelThresholdPx", "I", "", "startY", "F", "startX", "lastX", "lastY", "isInCancelState", "Z", "setInCancelState", "isTouchStarted", "externalTouchStarted", "swipeToCancelEnabled", "listeningMode", "fullScreenPresentation", "recordingHint", "Ljava/lang/CharSequence;", "countdownHint", "tipView", "Landroid/widget/TextView;", "rootContainer", "Landroid/view/View;", "Lcom/stepos/ailauncher/speech/view/DotWaveVoiceView;", "waveformView", "Lcom/stepos/ailauncher/speech/view/DotWaveVoiceView;", "contentWidth", "getContentWidth", "()I", "setContentWidth", "transitionY", "getTransitionY", "setTransitionY", "Ly7/E;", "waveformGlassHandle", "Ly7/E;", "waveformGlassEnabled", "getWaveformGlassEnabled", "setWaveformGlassEnabled", UxipConstants.f30680s, "waveformVisible", "getWaveformVisible", "setWaveformVisible", "tipBottomSpace", "Companion", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c extends FrameLayout implements a {
    private static final String TAG = "SpeechRecordingView";
    private int cancelThresholdPx;
    private int contentWidth;
    private CharSequence countdownHint;
    private boolean externalTouchStarted;
    private boolean fullScreenPresentation;
    private boolean isInCancelState;
    private boolean isTouchStarted;
    private float lastX;
    private float lastY;
    private a.InterfaceC0324a listener;
    private boolean listeningMode;
    private CharSequence recordingHint;
    private View rootContainer;
    private float startX;
    private float startY;
    private boolean swipeToCancelEnabled;
    private int tipBottomSpace;
    private TextView tipView;
    private int transitionY;
    private boolean waveformGlassEnabled;
    private E waveformGlassHandle;
    private DotWaveVoiceView waveformView;
    private boolean waveformVisible;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/speech/dialog/c$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            p.i(v10, "v");
            v10.removeOnAttachStateChangeListener(this);
            c.this.j();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        p.i(context, "context");
        this.swipeToCancelEnabled = true;
        this.waveformGlassEnabled = true;
        this.waveformVisible = true;
        LayoutInflater.from(context).inflate(R$layout.speech_dialog_layout, (ViewGroup) this, true);
        this.tipView = (TextView) findViewById(R$id.speech_tv_tip);
        this.waveformView = (DotWaveVoiceView) findViewById(R$id.speech_waveform);
        this.rootContainer = findViewById(R$id.speech_root);
        this.cancelThresholdPx = (int) ((context.getResources().getDisplayMetrics().density * 70.0f) + 0.5f);
        setCancelState(false);
        setClickable(true);
        setFocusable(false);
        c();
    }

    public static final void f(c cVar) {
        ViewParent parent = cVar.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(cVar);
        }
    }

    public final void c() {
        int i10;
        int iG;
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        if (this.fullScreenPresentation || (i10 = this.contentWidth) <= 0) {
            i10 = -1;
        }
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(i10, -2);
        }
        layoutParams2.width = i10;
        layoutParams2.height = -2;
        layoutParams2.gravity = 81;
        if (this.fullScreenPresentation) {
            Context context = getContext();
            p.h(context, "getContext(...)");
            iG = g(context, 84);
        } else {
            iG = this.transitionY;
        }
        layoutParams2.bottomMargin = iG;
        childAt.setLayoutParams(layoutParams2);
    }

    public final void d() {
        DotWaveVoiceView dotWaveVoiceView;
        if (this.waveformGlassEnabled && (dotWaveVoiceView = this.waveformView) != null) {
            j();
            E eM = h.m(h.INSTANCE, dotWaveVoiceView, false, Float.valueOf(28.0f), null, false, 24, null);
            if (eM == null) {
                return;
            }
            this.waveformGlassHandle = eM;
            dotWaveVoiceView.addOnAttachStateChangeListener(new b());
        }
    }

    public void e() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        DotWaveVoiceView dotWaveVoiceView = this.waveformView;
        if (dotWaveVoiceView != null) {
            dotWaveVoiceView.y();
        }
        j();
        if (viewGroup == null) {
            return;
        }
        a.InterfaceC0324a interfaceC0324a = this.listener;
        if (interfaceC0324a != null) {
            interfaceC0324a.onDismiss();
        }
        post(new Runnable() { // from class: com.stepos.ailauncher.speech.dialog.b
            @Override // java.lang.Runnable
            public final void run() {
                c.f(this.f28330a);
            }
        });
    }

    public final int g(Context context, int dp) {
        p.i(context, "context");
        return (int) TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }

    public final int getContentWidth() {
        return this.contentWidth;
    }

    public TextView getTipView() {
        return this.tipView;
    }

    public final int getTransitionY() {
        return this.transitionY;
    }

    public final boolean getWaveformGlassEnabled() {
        return this.waveformGlassEnabled;
    }

    public final boolean getWaveformVisible() {
        return this.waveformVisible;
    }

    public final boolean h(MotionEvent event) {
        DotWaveVoiceView dotWaveVoiceView = this.waveformView;
        if (dotWaveVoiceView == null) {
            return false;
        }
        int[] iArr = new int[2];
        dotWaveVoiceView.getLocationOnScreen(iArr);
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        if (rawX >= iArr[0] && rawX < r3 + dotWaveVoiceView.getWidth()) {
            if (rawY >= iArr[1] && rawY < r1 + dotWaveVoiceView.getHeight()) {
                return true;
            }
        }
        return false;
    }

    public boolean i() {
        return isAttachedToWindow() && getParent() != null;
    }

    public final void j() {
        h.INSTANCE.F(this.waveformGlassHandle);
        this.waveformGlassHandle = null;
    }

    public final ViewGroup k(View anchorView) {
        View rootView = anchorView.getRootView();
        View viewFindViewById = rootView != null ? rootView.findViewById(R.id.content) : null;
        ViewGroup viewGroup = viewFindViewById instanceof ViewGroup ? (ViewGroup) viewFindViewById : null;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView instanceof ViewGroup) {
            return (ViewGroup) rootView;
        }
        return null;
    }

    public a l(a.InterfaceC0324a listener) {
        this.listener = listener;
        return this;
    }

    public final void m(View anchorView) {
        p.i(anchorView, "anchorView");
        if (getParent() != null) {
            return;
        }
        ViewGroup viewGroupK = k(anchorView);
        if (viewGroupK == null) {
            Log.w(TAG, "show: no host container found, abort");
            return;
        }
        c();
        viewGroupK.addView(this, new FrameLayout.LayoutParams(-1, -1));
        Log.d(TAG, "show recording view: transitionY=" + this.transitionY + " width=" + this.contentWidth);
        if (this.waveformVisible) {
            DotWaveVoiceView dotWaveVoiceView = this.waveformView;
            if (dotWaveVoiceView != null) {
                dotWaveVoiceView.x();
            }
            d();
        }
    }

    public final void n(int y10) {
        if (this.transitionY == y10) {
            return;
        }
        this.transitionY = y10;
        c();
    }

    public void o(short[] audioData) {
        DotWaveVoiceView dotWaveVoiceView;
        p.i(audioData, "audioData");
        if (!this.waveformVisible || (dotWaveVoiceView = this.waveformView) == null) {
            return;
        }
        dotWaveVoiceView.j(audioData);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        p.i(event, "event");
        if (this.listeningMode) {
            return h(event);
        }
        return true;
    }

    public final void p(boolean cancel) {
        DotWaveVoiceView dotWaveVoiceView = this.waveformView;
        if (dotWaveVoiceView != null) {
            int i10 = this.tipBottomSpace;
            Context context = dotWaveVoiceView != null ? dotWaveVoiceView.getContext() : null;
            p.f(context);
            dotWaveVoiceView.setBackgroundResource(i10 > g(context, 10) ? cancel ? R$drawable.speech_bg_input_box_cancel_noborder : R$drawable.speech_bg_transparent : cancel ? R$drawable.speech_bg_input_box_cancel : R$drawable.speech_bg_transparent);
        }
    }

    public final void q() {
        this.fullScreenPresentation = true;
        setWaveformVisible(false);
        DotWaveVoiceView dotWaveVoiceView = this.waveformView;
        if (dotWaveVoiceView != null) {
            dotWaveVoiceView.setVisibility(8);
        }
        View view = this.rootContainer;
        if (view != null) {
            view.setBackground(null);
        }
        TextView textView = this.tipView;
        if (textView != null) {
            textView.setTextSize(16.0f);
            textView.setTextColor(-1);
            textView.setAlpha(0.7f);
            textView.setIncludeFontPadding(false);
            textView.setPadding(0, 0, 0, 0);
        }
        c();
    }

    public void setCancelState(boolean cancel) {
        CharSequence text;
        boolean z10 = cancel && this.swipeToCancelEnabled && !this.listeningMode;
        this.isInCancelState = z10;
        TextView textView = this.tipView;
        if (textView != null) {
            if (z10 || ((text = this.countdownHint) == null && this.recordingHint == null)) {
                text = getContext().getText(this.listeningMode ? R$string.speech_listening : z10 ? R$string.speech_release_to_cancel : this.swipeToCancelEnabled ? R$string.speech_release_to_send_swipe_up_to_cancel : R$string.speech_release_to_send);
            } else if (text == null) {
                text = this.recordingHint;
            }
            textView.setText(text);
        }
        try {
            p(z10);
            TextView textView2 = this.tipView;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor(z10 ? "#832525" : "#FFFFFF"));
            }
        } catch (Exception unused) {
        }
        DotWaveVoiceView dotWaveVoiceView = this.waveformView;
        if (z10) {
            if (dotWaveVoiceView != null) {
                dotWaveVoiceView.k();
            }
        } else if (dotWaveVoiceView != null) {
            dotWaveVoiceView.v();
        }
    }

    public final void setContentWidth(int i10) {
        this.contentWidth = i10;
    }

    public final void setCountdownHint(CharSequence text) {
        this.countdownHint = text;
        setCancelState(this.isInCancelState);
    }

    public final void setInCancelState(boolean z10) {
        this.isInCancelState = z10;
    }

    public final void setListeningTip(boolean listening) {
        if (this.listeningMode == listening) {
            return;
        }
        this.listeningMode = listening;
        this.recordingHint = null;
        this.countdownHint = null;
        setCancelState(this.isInCancelState);
    }

    public final void setRecordingHint(CharSequence text) {
        this.recordingHint = text;
        setCancelState(this.isInCancelState);
    }

    public final void setSwipeToCancelEnabled(boolean enabled) {
        if (this.swipeToCancelEnabled == enabled) {
            return;
        }
        this.swipeToCancelEnabled = enabled;
        if (enabled || !this.isInCancelState) {
            setCancelState(this.isInCancelState);
        } else {
            setCancelState(false);
        }
    }

    public final void setTipBottomSpace(int px) {
        if (this.fullScreenPresentation) {
            return;
        }
        TextView textView = this.tipView;
        if (textView != null) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), px);
        }
        if (this.tipBottomSpace != px) {
            this.tipBottomSpace = px;
            p(this.isInCancelState);
        }
    }

    public final void setTransitionY(int i10) {
        this.transitionY = i10;
    }

    public final void setWaveformGlassEnabled(boolean z10) {
        this.waveformGlassEnabled = z10;
    }

    public final void setWaveformVisible(boolean z10) {
        this.waveformVisible = z10;
        DotWaveVoiceView dotWaveVoiceView = this.waveformView;
        if (dotWaveVoiceView != null) {
            dotWaveVoiceView.setAlpha(z10 ? 1.0f : 0.0f);
        }
        if (!z10) {
            DotWaveVoiceView dotWaveVoiceView2 = this.waveformView;
            if (dotWaveVoiceView2 != null) {
                dotWaveVoiceView2.y();
            }
            j();
            return;
        }
        if (i()) {
            DotWaveVoiceView dotWaveVoiceView3 = this.waveformView;
            if (dotWaveVoiceView3 != null) {
                dotWaveVoiceView3.x();
            }
            d();
        }
    }

    public final void setWindowBackground(int resId) {
        View view = this.rootContainer;
        if (view != null) {
            view.setBackgroundResource(resId);
        }
    }

    public final void setWindowBackground(Drawable drawable) {
        View view = this.rootContainer;
        if (view != null) {
            view.setBackground(drawable);
        }
    }
}
