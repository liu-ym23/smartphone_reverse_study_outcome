package com.stepos.ailauncher.express.capsule;

import Y8.t;
import android.content.Context;
import android.graphics.Region;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Log;
import android.view.AttachedSurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.manager.U0;
import com.stepos.ailauncher.chat.voice.longpress.V;
import com.stepos.ailauncher.chat.voice.motionkit.VoiceListenAnimation;
import com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService;
import com.stepos.ailauncher.express.capsule.CapsuleExpandedView;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0017\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Y2\u00020\u0001:\u0001ZBk\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0010J\r\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u0010J\r\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u0010J\r\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u0010J\u000f\u0010\u001e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\u0010J\u000f\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010\u0010J\u000f\u0010 \u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010\u0010J\u000f\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0005H\u0002¢\u0006\u0004\b+\u0010\u0010J\u000f\u0010,\u001a\u00020\u0005H\u0002¢\u0006\u0004\b,\u0010\u0010J\u000f\u0010-\u001a\u00020$H\u0002¢\u0006\u0004\b-\u0010&J\u000f\u0010.\u001a\u00020\u0005H\u0002¢\u0006\u0004\b.\u0010\u0010J\u0011\u00100\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0005H\u0002¢\u0006\u0004\b2\u0010\u0010J\u000f\u00103\u001a\u00020\u0005H\u0002¢\u0006\u0004\b3\u0010\u0010J\u000f\u00104\u001a\u00020\u0005H\u0002¢\u0006\u0004\b4\u0010\u0010J\u000f\u00105\u001a\u00020\u0005H\u0002¢\u0006\u0004\b5\u0010\u0010J\u000f\u00106\u001a\u00020\u000bH\u0002¢\u0006\u0004\b6\u0010\u0014J\u0017\u00107\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020$H\u0002¢\u0006\u0004\b7\u00108R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00109R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010:R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010:R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010:R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010:R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010:R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010D\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010R\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010PR\u0016\u0010X\u001a\u0004\u0018\u00010U8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010W¨\u0006["}, d2 = {"Lcom/stepos/ailauncher/express/capsule/h;", "", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "LY8/t;", "onVoice", "onStop", "onTapToSend", "onOutsideTap", "onVoiceSessionEnded", "", "canRestoreIdle", "<init>", "(Landroid/content/Context;Lp9/a;Lp9/a;Lp9/a;Lp9/a;Lp9/a;Lp9/a;)V", "H", "()V", "G", "z", "D", "()Z", "C", "N", "", "pcm", "x", "([S)V", "v", "w", "t", "I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "r", "", "B", "()Ljava/lang/String;", "", ExifInterface.LONGITUDE_EAST, "()I", "Landroid/view/View;", "mask", "J", "(Landroid/view/View;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "F", "l", "p", "Landroid/widget/FrameLayout;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Landroid/widget/FrameLayout;", "q", "o", "n", "P", "m", "s", "(I)I", "Landroid/content/Context;", "Lp9/a;", "Landroid/view/WindowManager;", "wm", "Landroid/view/WindowManager;", "Landroid/os/Handler;", "main", "Landroid/os/Handler;", "Lcom/stepos/ailauncher/express/capsule/CapsuleExpandedView;", "expandedView", "Lcom/stepos/ailauncher/express/capsule/CapsuleExpandedView;", "listenEffectHost", "Landroid/widget/FrameLayout;", "Lcom/stepos/ailauncher/express/capsule/q;", "bottomBlur", "Lcom/stepos/ailauncher/express/capsule/q;", "Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation;", "listenAnim", "Lcom/stepos/ailauncher/chat/voice/motionkit/VoiceListenAnimation;", "Lcom/stepos/ailauncher/chat/voice/longpress/V;", "amplitudeDriver", "Lcom/stepos/ailauncher/chat/voice/longpress/V;", SpriteEventAction.AGENT_THINKING_START, "Z", "Ljava/lang/Runnable;", "collapseRunnable", "Ljava/lang/Runnable;", "idleShown", "Lcom/stepos/ailauncher/contract/api/homebar/IHomeBarSysUiService;", "y", "()Lcom/stepos/ailauncher/contract/api/homebar/IHomeBarSysUiService;", "homeBar", "Companion", Const.INTENT_KEY_APIKEY, "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h {
    private static final long EFFECT_EXIT_MS = 450;
    private static final int MIN_BOTTOM_MARGIN_DP = 10;
    private static final float PROMPT_DIM_VOLUME = 0.12f;
    private static final long STATE_FADE_MS = 200;
    private static final String TAG = "ExpressCapsule";
    private static final float THINKING_DIM_INTEN = 0.85f;
    private static final float THINKING_DIM_VOLUME = 0.28f;
    private static final float THINKING_SPEED = 0.4f;
    private V amplitudeDriver;
    private q bottomBlur;
    private final InterfaceC5063a<Boolean> canRestoreIdle;
    private Runnable collapseRunnable;
    private final Context context;
    private CapsuleExpandedView expandedView;
    private boolean idleShown;
    private VoiceListenAnimation listenAnim;
    private FrameLayout listenEffectHost;
    private final Handler main;
    private final InterfaceC5063a<t> onOutsideTap;
    private final InterfaceC5063a<t> onStop;
    private final InterfaceC5063a<t> onTapToSend;
    private final InterfaceC5063a<t> onVoice;
    private final InterfaceC5063a<t> onVoiceSessionEnded;
    private boolean thinking;
    private final WindowManager wm;

    public h(Context context, InterfaceC5063a<t> onVoice, InterfaceC5063a<t> onStop, InterfaceC5063a<t> onTapToSend, InterfaceC5063a<t> onOutsideTap, InterfaceC5063a<t> onVoiceSessionEnded, InterfaceC5063a<Boolean> canRestoreIdle) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onVoice, "onVoice");
        kotlin.jvm.internal.p.i(onStop, "onStop");
        kotlin.jvm.internal.p.i(onTapToSend, "onTapToSend");
        kotlin.jvm.internal.p.i(onOutsideTap, "onOutsideTap");
        kotlin.jvm.internal.p.i(onVoiceSessionEnded, "onVoiceSessionEnded");
        kotlin.jvm.internal.p.i(canRestoreIdle, "canRestoreIdle");
        this.context = context;
        this.onVoice = onVoice;
        this.onStop = onStop;
        this.onTapToSend = onTapToSend;
        this.onOutsideTap = onOutsideTap;
        this.onVoiceSessionEnded = onVoiceSessionEnded;
        this.canRestoreIdle = canRestoreIdle;
        Object systemService = context.getSystemService("window");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.wm = (WindowManager) systemService;
        this.main = new Handler(Looper.getMainLooper());
        IHomeBarSysUiService iHomeBarSysUiServiceY = y();
        if (iHomeBarSysUiServiceY != null) {
            iHomeBarSysUiServiceY.setOnHomeBarCapsuleClickListener(new InterfaceC5063a() { // from class: com.stepos.ailauncher.express.capsule.f
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return h.h(this.f27103a);
                }
            });
        }
        r();
    }

    public static final void K(final h hVar, final View view) {
        Object objB;
        Object objB2;
        if (hVar.expandedView != view) {
            return;
        }
        final FrameLayout frameLayoutJ = hVar.j();
        if (frameLayoutJ == null) {
            frameLayoutJ = (FrameLayout) view;
        }
        CapsuleExpandedView capsuleExpandedView = view instanceof CapsuleExpandedView ? (CapsuleExpandedView) view : null;
        if (capsuleExpandedView != null) {
            capsuleExpandedView.f(frameLayoutJ);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new VoiceListenAnimation(frameLayoutJ));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(TAG, "VoiceListenAnimation create failed", thE);
            return;
        }
        VoiceListenAnimation voiceListenAnimation = (VoiceListenAnimation) objB;
        hVar.listenAnim = voiceListenAnimation;
        hVar.thinking = false;
        V v10 = new V(frameLayoutJ, new InterfaceC5074l() { // from class: com.stepos.ailauncher.express.capsule.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.L(this.f27098a, ((Float) obj).floatValue());
            }
        });
        hVar.amplitudeDriver = v10;
        v10.h();
        v10.g(PROMPT_DIM_VOLUME);
        try {
            voiceListenAnimation.C0(VoiceListenAnimation.PlayMask.LISTEN);
            objB2 = Result.b(t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB2);
        if (thE2 != null) {
            Log.e(TAG, "VoiceListenAnimation.play(LISTEN) failed", thE2);
            v10.i();
            if (hVar.amplitudeDriver == v10) {
                hVar.amplitudeDriver = null;
            }
            voiceListenAnimation.f0();
            if (hVar.listenAnim == voiceListenAnimation) {
                hVar.listenAnim = null;
            }
        }
        frameLayoutJ.post(new Runnable() { // from class: com.stepos.ailauncher.express.capsule.d
            @Override // java.lang.Runnable
            public final void run() {
                h.M(view, frameLayoutJ);
            }
        });
    }

    public static final t L(h hVar, float f10) {
        VoiceListenAnimation voiceListenAnimation;
        if (!hVar.thinking && (voiceListenAnimation = hVar.listenAnim) != null) {
            voiceListenAnimation.S0(f10);
        }
        return t.f7040a;
    }

    public static final void M(View view, FrameLayout frameLayout) {
        CapsuleExpandedView capsuleExpandedView = view instanceof CapsuleExpandedView ? (CapsuleExpandedView) view : null;
        if (capsuleExpandedView != null) {
            capsuleExpandedView.f(frameLayout);
        }
    }

    public static final void O(h hVar, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        hVar.F();
    }

    public static final t h(h hVar) {
        Log.d(TAG, "setOnHomeBarCapsuleClicked");
        if (hVar.expandedView == null) {
            hVar.onVoice.invoke();
        }
        return t.f7040a;
    }

    public static final void k(h hVar, FrameLayout frameLayout) {
        t tVar;
        try {
            Result.Companion companion = Result.INSTANCE;
            AttachedSurfaceControl rootSurfaceControl = frameLayout.getRootSurfaceControl();
            if (rootSurfaceControl != null) {
                rootSurfaceControl.setTouchableRegion(new Region());
                tVar = t.f7040a;
            } else {
                tVar = null;
            }
            Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public static final void u(h hVar) {
        hVar.collapseRunnable = null;
        hVar.n();
        if (!hVar.canRestoreIdle.invoke().booleanValue()) {
            hVar.r();
        } else if (!hVar.idleShown) {
            hVar.I();
        }
        hVar.onVoiceSessionEnded.invoke();
    }

    public final void A() {
        this.idleShown = false;
        IHomeBarSysUiService iHomeBarSysUiServiceY = y();
        if (iHomeBarSysUiServiceY != null) {
            iHomeBarSysUiServiceY.showHomeBarCapsule(true, null);
        }
    }

    public final String B() {
        String string = this.context.getString(U0.INSTANCE.o() ? R$string.express_capsule_idle_hint : R$string.express_capsule_idle_hint_new);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        return string;
    }

    public final boolean C() {
        return this.expandedView != null;
    }

    public final boolean D() {
        return this.idleShown || this.expandedView != null;
    }

    public final int E() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Integer.valueOf(this.wm.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.navigationBars()).bottom));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = 0;
        }
        return Math.max(((Number) objB).intValue(), s(10));
    }

    public final void F() {
        int iL;
        Object objB;
        q qVar = this.bottomBlur;
        if (qVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = qVar.getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null || layoutParams2.height == (iL = l())) {
            return;
        }
        layoutParams2.height = iL;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.wm.updateViewLayout(qVar, layoutParams2);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "relayout bottom blur failed", thE);
        }
    }

    public final void G() {
        if (C()) {
            return;
        }
        if (!m()) {
            Log.w(TAG, "replayIdle skip: no overlay permission (canDrawOverlays=false)");
            return;
        }
        boolean z10 = this.idleShown;
        this.idleShown = false;
        I();
        if (z10) {
            return;
        }
        J5.a.INSTANCE.b();
    }

    public final void H() {
        if (D()) {
            return;
        }
        if (!m()) {
            Log.w(TAG, "show skip: no overlay permission (canDrawOverlays=false)");
        } else {
            I();
            J5.a.INSTANCE.b();
        }
    }

    public final void I() {
        if (this.idleShown) {
            return;
        }
        this.idleShown = true;
        IHomeBarSysUiService iHomeBarSysUiServiceY = y();
        if (iHomeBarSysUiServiceY != null) {
            iHomeBarSysUiServiceY.showHomeBarCapsule(true, B());
        }
    }

    public final void J(final View mask) {
        i();
        mask.post(new Runnable() { // from class: com.stepos.ailauncher.express.capsule.b
            @Override // java.lang.Runnable
            public final void run() {
                h.K(this.f27096a, mask);
            }
        });
    }

    public final boolean N() {
        Object objB;
        if (!this.idleShown) {
            return false;
        }
        A();
        n();
        CapsuleExpandedView capsuleExpandedView = new CapsuleExpandedView(this.context, E(), this.onStop, this.onTapToSend, this.onOutsideTap);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2038, -2130443480, -3);
        layoutParams.gravity = 8388659;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.setFitInsetsTypes(0);
        layoutParams.layoutInDisplayCutoutMode = 1;
        layoutParams.windowAnimations = 0;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.wm.addView(capsuleExpandedView, layoutParams);
            this.expandedView = capsuleExpandedView;
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(TAG, "startVoice: addView failed -> 退回 IDLE", thE);
        }
        if (this.expandedView == null) {
            I();
            this.onVoiceSessionEnded.invoke();
            return false;
        }
        capsuleExpandedView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.express.capsule.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                h.O(this.f27095a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        this.thinking = false;
        P();
        J(capsuleExpandedView);
        return true;
    }

    public final void P() {
        Object systemService = this.context.getSystemService("vibrator");
        Vibrator vibrator = systemService instanceof Vibrator ? (Vibrator) systemService : null;
        if (vibrator == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            vibrator.vibrate(VibrationEffect.createOneShot(50L, -1));
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void i() {
        Object objB;
        p();
        q qVar = new q(this.context);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, l(), 2012, 16778008, -3);
        layoutParams.gravity = 80;
        layoutParams.setFitInsetsTypes(0);
        layoutParams.layoutInDisplayCutoutMode = 1;
        layoutParams.windowAnimations = 0;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.wm.addView(qVar, layoutParams);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "bottom blur above IME failed", thE);
        }
        if (Result.h(objB)) {
            this.bottomBlur = qVar;
        }
    }

    public final FrameLayout j() {
        Object objB;
        FrameLayout frameLayout = this.listenEffectHost;
        this.listenEffectHost = null;
        if (frameLayout != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.wm.removeView(frameLayout);
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        final FrameLayout frameLayout2 = new FrameLayout(this.context);
        frameLayout2.setImportantForAccessibility(2);
        frameLayout2.setClipChildren(false);
        frameLayout2.setClipToPadding(false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2012, 16778008, -3);
        layoutParams.gravity = 8388659;
        layoutParams.setFitInsetsTypes(0);
        layoutParams.layoutInDisplayCutoutMode = 1;
        layoutParams.windowAnimations = 0;
        try {
            Result.Companion companion3 = Result.INSTANCE;
            this.wm.addView(frameLayout2, layoutParams);
            objB = Result.b(t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "listen effect above IME failed", thE);
        }
        if (!Result.h(objB)) {
            return null;
        }
        this.listenEffectHost = frameLayout2;
        frameLayout2.post(new Runnable() { // from class: com.stepos.ailauncher.express.capsule.e
            @Override // java.lang.Runnable
            public final void run() {
                h.k(this.f27101a, frameLayout2);
            }
        });
        return frameLayout2;
    }

    public final int l() {
        return C5685n.f((int) (this.wm.getCurrentWindowMetrics().getBounds().height() * 0.3846154f), 1);
    }

    public final boolean m() {
        return Settings.canDrawOverlays(this.context);
    }

    public final void n() {
        p();
        o();
        CapsuleExpandedView capsuleExpandedView = this.expandedView;
        if (capsuleExpandedView == null) {
            return;
        }
        this.expandedView = null;
        capsuleExpandedView.p();
        try {
            Result.Companion companion = Result.INSTANCE;
            this.wm.removeView(capsuleExpandedView);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void o() {
        this.thinking = false;
        V v10 = this.amplitudeDriver;
        if (v10 != null) {
            v10.i();
        }
        this.amplitudeDriver = null;
        VoiceListenAnimation voiceListenAnimation = this.listenAnim;
        if (voiceListenAnimation != null) {
            voiceListenAnimation.f0();
        }
        this.listenAnim = null;
        q();
    }

    public final void p() {
        q qVar = this.bottomBlur;
        if (qVar == null) {
            return;
        }
        this.bottomBlur = null;
        qVar.t();
        try {
            Result.Companion companion = Result.INSTANCE;
            this.wm.removeView(qVar);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void q() {
        p();
        FrameLayout frameLayout = this.listenEffectHost;
        if (frameLayout == null) {
            return;
        }
        this.listenEffectHost = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.wm.removeView(frameLayout);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void r() {
        this.idleShown = false;
        IHomeBarSysUiService iHomeBarSysUiServiceY = y();
        if (iHomeBarSysUiServiceY != null) {
            iHomeBarSysUiServiceY.showHomeBarCapsule(false, null);
        }
    }

    public final int s(int v10) {
        return (int) (v10 * this.context.getResources().getDisplayMetrics().density);
    }

    public final void t() {
        CapsuleExpandedView capsuleExpandedView = this.expandedView;
        if (capsuleExpandedView != null && this.collapseRunnable == null) {
            VoiceListenAnimation voiceListenAnimation = this.listenAnim;
            if (voiceListenAnimation != null) {
                voiceListenAnimation.I0();
            }
            if (this.canRestoreIdle.invoke().booleanValue()) {
                I();
            }
            q qVar = this.bottomBlur;
            if (qVar != null) {
                qVar.p();
            }
            capsuleExpandedView.i();
            long j10 = this.listenAnim != null ? EFFECT_EXIT_MS : 200L;
            Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.express.capsule.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.u(this.f27104a);
                }
            };
            this.main.postDelayed(runnable, j10);
            this.collapseRunnable = runnable;
        }
    }

    public final void v() {
        CapsuleExpandedView capsuleExpandedView;
        if (this.thinking || (capsuleExpandedView = this.expandedView) == null) {
            return;
        }
        capsuleExpandedView.setPhase(CapsuleExpandedView.Phase.Listening);
    }

    public final void w() {
        CapsuleExpandedView capsuleExpandedView = this.expandedView;
        if (capsuleExpandedView == null) {
            return;
        }
        this.thinking = true;
        V v10 = this.amplitudeDriver;
        if (v10 != null) {
            v10.i();
        }
        VoiceListenAnimation voiceListenAnimation = this.listenAnim;
        if (voiceListenAnimation != null) {
            voiceListenAnimation.R0(0.4f);
            voiceListenAnimation.S0(0.28f);
            voiceListenAnimation.getAudioWave().b(0.85f);
        }
        capsuleExpandedView.setPhase(CapsuleExpandedView.Phase.Thinking);
    }

    public final void x(short[] pcm) {
        kotlin.jvm.internal.p.i(pcm, "pcm");
        if (this.thinking) {
            return;
        }
        float fA = l.INSTANCE.a(pcm);
        V v10 = this.amplitudeDriver;
        if (v10 != null) {
            v10.g(Math.max(fA, PROMPT_DIM_VOLUME));
            return;
        }
        VoiceListenAnimation voiceListenAnimation = this.listenAnim;
        if (voiceListenAnimation != null) {
            voiceListenAnimation.S0(Math.max(fA, PROMPT_DIM_VOLUME));
        }
    }

    public final IHomeBarSysUiService y() {
        return (IHomeBarSysUiService) D5.a.INSTANCE.a(IHomeBarSysUiService.class);
    }

    public final void z() {
        Runnable runnable = this.collapseRunnable;
        if (runnable != null) {
            this.main.removeCallbacks(runnable);
        }
        this.collapseRunnable = null;
        n();
        r();
        this.onVoiceSessionEnded.invoke();
    }
}
