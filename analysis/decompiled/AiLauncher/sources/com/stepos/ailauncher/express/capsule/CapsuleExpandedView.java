package com.stepos.ailauncher.express.capsule;

import Y8.t;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Insets;
import android.graphics.Region;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.AttachedSurfaceControl;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 N2\u00020\u0001:\u0002OPBA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\u0018J\r\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010\u0018J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020%2\u0006\u0010(\u001a\u00020#H\u0016¢\u0006\u0004\b)\u0010'J\u000f\u0010*\u001a\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010\u0018J\u0017\u0010+\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b+\u0010'J\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b.\u0010 J\u0017\u00101\u001a\u0002002\u0006\u0010/\u001a\u00020\u001dH\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b3\u0010'J\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020%H\u0002¢\u0006\u0004\b\u0012\u00107J\u0017\u00108\u001a\u0002002\u0006\u00105\u001a\u000200H\u0002¢\u0006\u0004\b8\u00109R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010:R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010;R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010;R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010;R$\u0010/\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001d8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b/\u0010=\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010:¨\u0006Q"}, d2 = {"Lcom/stepos/ailauncher/express/capsule/CapsuleExpandedView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "bottomInset", "Lkotlin/Function0;", "LY8/t;", "onStop", "onTapToSend", "onOutsideTap", "<init>", "(Landroid/content/Context;ILp9/a;Lp9/a;Lp9/a;)V", "Landroid/view/ViewGroup;", "parent", "f", "(Landroid/view/ViewGroup;)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "onAttachedToWindow", "()V", "Landroid/view/WindowInsets;", "insets", "onApplyWindowInsets", "(Landroid/view/WindowInsets;)Landroid/view/WindowInsets;", "Lcom/stepos/ailauncher/express/capsule/CapsuleExpandedView$Phase;", "next", "setPhase", "(Lcom/stepos/ailauncher/express/capsule/CapsuleExpandedView$Phase;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "p", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "event", "onTouchEvent", "e", "k", "l", "()I", Const.INTENT_KEY_UMID, "phase", "", "q", "(Lcom/stepos/ailauncher/express/capsule/CapsuleExpandedView$Phase;)F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroid/view/View;", "v", "visible", "(Landroid/view/View;Z)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(F)F", "I", "Lp9/a;", UxipConstants.f30680s, "Lcom/stepos/ailauncher/express/capsule/CapsuleExpandedView$Phase;", "getPhase", "()Lcom/stepos/ailauncher/express/capsule/CapsuleExpandedView$Phase;", "night", "Z", "scrim", "Landroid/view/View;", "Landroid/widget/LinearLayout;", "statusRow", "Landroid/widget/LinearLayout;", "Lcom/stepos/ailauncher/express/capsule/s;", "thinkingDots", "Lcom/stepos/ailauncher/express/capsule/s;", "Landroid/widget/TextView;", "statusText", "Landroid/widget/TextView;", "sendBandPx", "Companion", "Phase", Const.INTENT_KEY_APIKEY, "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class CapsuleExpandedView extends FrameLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float DOTS_TEXT_GAP_DP = 6.0f;
    private static final long FADE_MS = 200;
    private static final float SCRIM_ALPHA_THINKING_NIGHT = 0.15f;
    private static final float SCRIM_ALPHA_WAKE = 0.2f;
    private static final float SCRIM_ALPHA_WAKE_NIGHT = 0.2f;
    private static final float SEND_BAND_DP = 120.0f;
    private static final float STATUS_ROW_DP = 24.0f;
    private static final String TAG = "ExpressCapsule";
    private static final float TEXT_ABOVE_BOTTOM_DP = 56.0f;
    private final int bottomInset;
    private final boolean night;
    private final InterfaceC5063a<t> onOutsideTap;
    private final InterfaceC5063a<t> onStop;
    private final InterfaceC5063a<t> onTapToSend;
    private Phase phase;
    private final View scrim;
    private int sendBandPx;
    private final LinearLayout statusRow;
    private final TextView statusText;
    private final s thinkingDots;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/express/capsule/CapsuleExpandedView$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "Prompt", "Listening", "Thinking", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Phase {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Phase[] $VALUES;
        public static final Phase Prompt = new Phase("Prompt", 0);
        public static final Phase Listening = new Phase("Listening", 1);
        public static final Phase Thinking = new Phase("Thinking", 2);

        private static final /* synthetic */ Phase[] $values() {
            return new Phase[]{Prompt, Listening, Thinking};
        }

        static {
            Phase[] phaseArr$values = $values();
            $VALUES = phaseArr$values;
            $ENTRIES = kotlin.enums.a.a(phaseArr$values);
        }

        private Phase(String str, int i10) {
        }

        public static InterfaceC4149a<Phase> getEntries() {
            return $ENTRIES;
        }

        public static Phase valueOf(String str) {
            return (Phase) Enum.valueOf(Phase.class, str);
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/express/capsule/CapsuleExpandedView$a;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Z", "", "TAG", "Ljava/lang/String;", "", "FADE_MS", "J", "", "SCRIM_ALPHA_WAKE", "F", "SCRIM_ALPHA_WAKE_NIGHT", "SCRIM_ALPHA_THINKING_NIGHT", "SEND_BAND_DP", "TEXT_ABOVE_BOTTOM_DP", "STATUS_ROW_DP", "DOTS_TEXT_GAP_DP", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.express.capsule.CapsuleExpandedView$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a() {
            return (Resources.getSystem().getConfiguration().uiMode & 48) == 32;
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Phase.values().length];
            try {
                iArr[Phase.Prompt.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Phase.Listening.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Phase.Thinking.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapsuleExpandedView(Context context, int i10, InterfaceC5063a<t> onStop, InterfaceC5063a<t> onTapToSend, InterfaceC5063a<t> onOutsideTap) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onStop, "onStop");
        kotlin.jvm.internal.p.i(onTapToSend, "onTapToSend");
        kotlin.jvm.internal.p.i(onOutsideTap, "onOutsideTap");
        this.bottomInset = i10;
        this.onStop = onStop;
        this.onTapToSend = onTapToSend;
        this.onOutsideTap = onOutsideTap;
        Phase phase = Phase.Prompt;
        this.phase = phase;
        this.night = INSTANCE.a();
        setClipChildren(false);
        setClipToPadding(false);
        View view = new View(context);
        view.setAlpha(0.0f);
        view.setBackgroundColor(-16777216);
        this.scrim = view;
        addView(view, new FrameLayout.LayoutParams(-1, -1));
        s sVar = new s(context);
        sVar.setVisibility(8);
        sVar.setImportantForAccessibility(2);
        this.thinkingDots = sVar;
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setTextSize(16.0f);
        textView.setIncludeFontPadding(false);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        this.statusText = textView;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight((int) g(24.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginEnd((int) g(6.0f));
        t tVar = t.f7040a;
        linearLayout.addView(sVar, layoutParams);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        this.statusRow = linearLayout;
        d(phase);
    }

    public static final void m(CapsuleExpandedView capsuleExpandedView) {
        capsuleExpandedView.e();
    }

    public static final void n(CapsuleExpandedView capsuleExpandedView) {
        capsuleExpandedView.e();
    }

    public static final void o(CapsuleExpandedView capsuleExpandedView) {
        capsuleExpandedView.e();
    }

    public final void d(Phase next) {
        int i10;
        this.phase = next;
        this.thinkingDots.setVisibility(next == Phase.Thinking ? 0 : 8);
        TextView textView = this.statusText;
        int i11 = b.$EnumSwitchMapping$0[next.ordinal()];
        if (i11 == 1) {
            i10 = R$string.express_capsule_listen_hint;
        } else if (i11 == 2) {
            i10 = R$string.express_capsule_listening;
        } else {
            if (i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i10 = R$string.express_capsule_generating;
        }
        textView.setText(i10);
        this.scrim.animate().cancel();
        this.scrim.animate().alpha(q(next)).setDuration(200L).start();
    }

    public final void e() {
        Object objB;
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        int iL = l();
        boolean z10 = true;
        if (iL > 0) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i10 = (getResources().getDisplayMetrics().heightPixels - iL) - iArr[1];
            if (i10 < height) {
                height = C5685n.f(i10, 0);
            }
        }
        Region region = height > 0 ? new Region(0, 0, width, height) : new Region();
        try {
            Result.Companion companion = Result.INSTANCE;
            AttachedSurfaceControl rootSurfaceControl = getRootSurfaceControl();
            if (rootSurfaceControl != null) {
                rootSurfaceControl.setTouchableRegion(region);
            } else {
                z10 = false;
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "setTouchableRegion failed", thE);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        if (((Boolean) objB).booleanValue()) {
            return;
        }
        Log.w(TAG, "touchableRegion missing, input taps still hit mask");
    }

    public final void f(ViewGroup parent) {
        kotlin.jvm.internal.p.i(parent, "parent");
        if (this.statusRow.getParent() == parent) {
            this.statusRow.bringToFront();
            return;
        }
        ViewParent parent2 = this.statusRow.getParent();
        ViewGroup viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.statusRow);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = this.bottomInset + ((int) g(56.0f));
        parent.addView(this.statusRow, layoutParams);
        this.statusRow.bringToFront();
    }

    public final float g(float v10) {
        return TypedValue.applyDimension(1, v10, getResources().getDisplayMetrics());
    }

    public final Phase getPhase() {
        return this.phase;
    }

    public final void h(View v10, boolean visible) {
        v10.animate().cancel();
        if (!visible) {
            v10.animate().alpha(0.0f).setDuration(200L).start();
            return;
        }
        v10.setAlpha(0.0f);
        v10.setVisibility(0);
        v10.animate().alpha(1.0f).setDuration(200L).start();
    }

    public final void i() {
        h(this.scrim, false);
        h(this.statusRow, false);
    }

    public final boolean j(MotionEvent ev) {
        return ev.getY() >= ((float) (getHeight() - this.sendBandPx));
    }

    public final boolean k(MotionEvent ev) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        float rawX = ev.getRawX();
        float rawY = ev.getRawY();
        if (rawX < iArr[0] || rawY < iArr[1] || rawX >= r3 + getWidth() || rawY >= iArr[1] + getHeight()) {
            return true;
        }
        int iL = l();
        if (iL <= 0) {
            return false;
        }
        int height = iArr[1] + getHeight();
        int i10 = getResources().getDisplayMetrics().heightPixels - iL;
        return height > i10 + 2 && rawY >= ((float) i10);
    }

    public final int l() {
        Insets insets;
        WindowInsets rootWindowInsets = getRootWindowInsets();
        if (rootWindowInsets != null && (insets = rootWindowInsets.getInsets(WindowInsets.Type.ime())) != null) {
            Integer numValueOf = Integer.valueOf(insets.bottom);
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
        }
        WindowManager windowManager = (WindowManager) getContext().getSystemService(WindowManager.class);
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.ime()).bottom;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        kotlin.jvm.internal.p.i(insets, "insets");
        post(new Runnable() { // from class: com.stepos.ailauncher.express.capsule.i
            @Override // java.lang.Runnable
            public final void run() {
                CapsuleExpandedView.m(this.f27105a);
            }
        });
        WindowInsets windowInsetsOnApplyWindowInsets = super.onApplyWindowInsets(insets);
        kotlin.jvm.internal.p.h(windowInsetsOnApplyWindowInsets, "onApplyWindowInsets(...)");
        return windowInsetsOnApplyWindowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        t tVar;
        super.onAttachedToWindow();
        this.scrim.animate().alpha(q(Phase.Prompt)).setDuration(200L).start();
        try {
            Result.Companion companion = Result.INSTANCE;
            WindowInsetsController windowInsetsController = getWindowInsetsController();
            if (windowInsetsController != null) {
                windowInsetsController.setSystemBarsAppearance(this.night ? 0 : 8, 8);
                tVar = t.f7040a;
            } else {
                tVar = null;
            }
            Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        post(new Runnable() { // from class: com.stepos.ailauncher.express.capsule.j
            @Override // java.lang.Runnable
            public final void run() {
                CapsuleExpandedView.n(this.f27106a);
            }
        });
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        return ev.getActionMasked() == 0 && !k(ev);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        this.sendBandPx = C5685n.f((int) g(120.0f), 1);
        post(new Runnable() { // from class: com.stepos.ailauncher.express.capsule.k
            @Override // java.lang.Runnable
            public final void run() {
                CapsuleExpandedView.o(this.f27107a);
            }
        });
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        if (event.getAction() == 4) {
            return true;
        }
        if (event.getActionMasked() != 0) {
            return false;
        }
        if (k(event)) {
            return true;
        }
        boolean zJ = j(event);
        int i10 = b.$EnumSwitchMapping$0[this.phase.ordinal()];
        if (i10 == 1 || i10 == 2) {
            (zJ ? this.onTapToSend : this.onOutsideTap).invoke();
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.onStop.invoke();
        }
        return true;
    }

    public final void p() {
        this.phase = Phase.Prompt;
        this.thinkingDots.setVisibility(8);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).animate().cancel();
        }
        this.statusRow.animate().cancel();
    }

    public final float q(Phase phase) {
        return (this.night && phase == Phase.Thinking) ? 0.15f : 0.2f;
    }

    public final void setPhase(Phase next) {
        kotlin.jvm.internal.p.i(next, "next");
        if (this.phase == next) {
            return;
        }
        d(next);
    }
}
