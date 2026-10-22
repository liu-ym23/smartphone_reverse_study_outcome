package com.stepos.ailauncher.oobe;

import Z8.C1173v;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.PathInterpolator;
import androidx.core.view.a0;
import androidx.dynamicanimation.animation.e;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import b.AbstractC1417G;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.wake.C3119f;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.oobe.WakeAnywhereActivity;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import f6.C4059a;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import k5.C4814a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import o6.C5009a;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\u00020\u0001:\u0003TUVB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0003J%\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u0017\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0006H\u0003¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\u0003J\u0019\u0010)\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010'H\u0014¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0006H\u0014¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u0006H\u0014¢\u0006\u0004\b,\u0010\u0003J\u000f\u0010-\u001a\u00020\u0006H\u0014¢\u0006\u0004\b-\u0010\u0003R\u001a\u0010/\u001a\u00020.8\u0014X\u0094D¢\u0006\f\n\u0004\b/\u0010\u001d\u001a\u0004\b0\u00101R\u001a\u00104\u001a\b\u0012\u0004\u0012\u000203028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010\u001dR\u0016\u0010:\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010\u001dR\u0018\u0010;\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010\u001dR\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010CR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010\u001d¨\u0006W"}, d2 = {"Lcom/stepos/ailauncher/oobe/WakeAnywhereActivity;", "Lcom/stepos/ailauncher/oobe/N;", "<init>", "()V", "Landroid/content/Intent;", "intent", "LY8/t;", "v0", "(Landroid/content/Intent;)V", "n0", ExifInterface.LONGITUDE_WEST, "b0", "j0", "Landroid/view/View;", "bar", "Lkotlin/Function0;", "onEnd", "i0", "(Landroid/view/View;Lp9/a;)V", "", "from", "to", "s0", "(FFLp9/a;)V", "X", "d0", UxipConstants.f30680s, "c0", "(F)F", "Z", "", "position", "u0", "(I)V", "q0", "U", "a0", "Y", ExifInterface.LATITUDE_SOUTH, "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", UxipConstants.f30640D, "onStop", "onDestroy", "", "preventScreenCapture", "s", "()Z", "", "Lcom/stepos/ailauncher/oobe/WakeAnywhereActivity$b;", "pages", "Ljava/util/List;", "Lg6/f;", "binding", "Lg6/f;", "sheetClosed", "dismissedByAiKey", "pendingAiKeyWakeIntent", "Landroid/content/Intent;", "fromHomeLauncher", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "autoAdvanceRunnable", "Ljava/lang/Runnable;", "showSideKeyRunnable", "Lcom/stepos/ailauncher/chat/wake/f$a;", "aiKeyWakeHandler", "Lcom/stepos/ailauncher/chat/wake/f$a;", "Landroid/view/animation/PathInterpolator;", "sideKeyNudgeOut", "Landroid/view/animation/PathInterpolator;", "sideKeyNudgeBack", "Landroidx/dynamicanimation/animation/i;", "sideKeySpring", "Landroidx/dynamicanimation/animation/i;", "Landroid/animation/Animator;", "sideKeyAnimator", "Landroid/animation/Animator;", "sideKeySequenceStarted", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WakeAnywhereActivity extends N {
    private static final long AUTO_ADVANCE_FALLBACK_MS = 2000;
    private static final float DOT_ALPHA_ACTIVE = 0.9f;
    private static final float DOT_ALPHA_INACTIVE = 0.3f;
    private static final String EXTRA_FROM_HOME_LAUNCHER = "extra_from_home_launcher";
    private static final String KEY_GUIDE_LAUNCHED = "oobe_wake_anywhere_guide_launched";
    private static final float SHEET_CORNER_RADIUS_DP = 32.0f;
    private static final float SIDE_KEY_APPEAR_OFFSET_DP = 10.33f;
    private static final long SIDE_KEY_LONG_PRESS_HOLD_MS = 1000;
    private static final float SIDE_KEY_NUDGE_DP = 3.33f;
    private static final long SIDE_KEY_NUDGE_MS = 250;
    private static final long SIDE_KEY_REVEAL_DELAY_MS = 2000;
    private static final float SIDE_KEY_SPRING_DAMPING = 19.0f;
    private static final float SIDE_KEY_SPRING_STIFFNESS = 130.0f;
    private static final String TAG = "WakeAnywhereActivity";
    private g6.f binding;
    private boolean dismissedByAiKey;
    private boolean fromHomeLauncher;
    private Intent pendingAiKeyWakeIntent;
    private final boolean preventScreenCapture;
    private boolean sheetClosed;
    private Animator sideKeyAnimator;
    private boolean sideKeySequenceStarted;
    private androidx.dynamicanimation.animation.i sideKeySpring;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> SKIPPED_PACKAGES = Z8.Y.j(com.stepos.ailauncher.chat.sheet.T.PKG_PERMISSION_CONTROLLER, com.stepos.ailauncher.chat.sheet.T.PKG_MEDIA_CAMERA, com.stepos.ailauncher.chat.sheet.T.PKG_DOCUMENTS_UI, com.stepos.ailauncher.chat.sheet.T.PKG_MEDIA_GALLERY, "com.android.settings", "com.stepos.setup", "com.stepos.ability");
    private final List<GuidePage> pages = C1173v.p(new GuidePage(R$raw.oobe_wake_anywhere_long_press, R$string.oobe_wake_anywhere_caption_voice), new GuidePage(R$raw.oobe_wake_anywhere_short_press, R$string.oobe_wake_anywhere_caption_keyboard));
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Runnable autoAdvanceRunnable = new Runnable() { // from class: com.stepos.ailauncher.oobe.Q0
        @Override // java.lang.Runnable
        public final void run() {
            WakeAnywhereActivity.V(this.f27564a);
        }
    };
    private final Runnable showSideKeyRunnable = new Runnable() { // from class: com.stepos.ailauncher.oobe.R0
        @Override // java.lang.Runnable
        public final void run() {
            WakeAnywhereActivity.r0(this.f27565a);
        }
    };
    private final C3119f.a aiKeyWakeHandler = new C3119f.a() { // from class: com.stepos.ailauncher.oobe.S0
        @Override // com.stepos.ailauncher.chat.wake.C3119f.a
        public final boolean a(Intent intent) {
            return WakeAnywhereActivity.R(this.f27567a, intent);
        }
    };
    private final PathInterpolator sideKeyNudgeOut = new PathInterpolator(0.33f, 0.0f, 0.83f, 0.83f);
    private final PathInterpolator sideKeyNudgeBack = new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012R\u0014\u0010\u001e\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0012R\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u000fR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u000fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/oobe/WakeAnywhereActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "packageName", "", "fromHomeLauncher", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/String;Z)Z", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Z)Z", "TAG", "Ljava/lang/String;", "", "SHEET_CORNER_RADIUS_DP", "F", "DOT_ALPHA_ACTIVE", "DOT_ALPHA_INACTIVE", "", "AUTO_ADVANCE_FALLBACK_MS", "J", "SIDE_KEY_REVEAL_DELAY_MS", "SIDE_KEY_APPEAR_OFFSET_DP", "SIDE_KEY_NUDGE_DP", "SIDE_KEY_NUDGE_MS", "SIDE_KEY_LONG_PRESS_HOLD_MS", "SIDE_KEY_SPRING_STIFFNESS", "SIDE_KEY_SPRING_DAMPING", "KEY_GUIDE_LAUNCHED", "EXTRA_FROM_HOME_LAUNCHER", "", "SKIPPED_PACKAGES", "Ljava/util/Set;", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.oobe.WakeAnywhereActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a(Context context, boolean fromHomeLauncher) {
            Object objB;
            kotlin.jvm.internal.p.i(context, "context");
            try {
                Result.Companion companion = Result.INSTANCE;
                context.startActivity(new Intent(context, (Class<?>) WakeAnywhereActivity.class).putExtra(WakeAnywhereActivity.EXTRA_FROM_HOME_LAUNCHER, fromHomeLauncher).addFlags(872415232));
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(WakeAnywhereActivity.TAG, "launch failed", thE);
            }
            return Result.h(objB);
        }

        public final boolean b(Context context, String packageName, boolean fromHomeLauncher) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(packageName, "packageName");
            if (WakeAnywhereActivity.SKIPPED_PACKAGES.contains(packageName)) {
                Log.d(WakeAnywhereActivity.TAG, "launchOnce skipped: " + packageName + " is an in-flow system page");
                return false;
            }
            C5009a c5009a = C5009a.INSTANCE;
            if (C5009a.g(c5009a, WakeAnywhereActivity.KEY_GUIDE_LAUNCHED, false, false, 6, null)) {
                Log.d(WakeAnywhereActivity.TAG, "launchOnce skipped: already launched before");
                return false;
            }
            if (!a(context, fromHomeLauncher)) {
                return false;
            }
            C5009a.y(c5009a, WakeAnywhereActivity.KEY_GUIDE_LAUNCHED, true, false, 4, null);
            return true;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/oobe/WakeAnywhereActivity$b;", "", "", "lottie", "caption", "<init>", "(II)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.oobe.WakeAnywhereActivity$b, reason: from toString */
    public static final /* data */ class GuidePage {
        private final int caption;
        private final int lottie;

        public GuidePage(int i10, int i11) {
            this.lottie = i10;
            this.caption = i11;
        }

        /* renamed from: a, reason: from getter */
        public final int getCaption() {
            return this.caption;
        }

        /* renamed from: b, reason: from getter */
        public final int getLottie() {
            return this.lottie;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuidePage)) {
                return false;
            }
            GuidePage guidePage = (GuidePage) other;
            return this.lottie == guidePage.lottie && this.caption == guidePage.caption;
        }

        public int hashCode() {
            return (Integer.hashCode(this.lottie) * 31) + Integer.hashCode(this.caption);
        }

        public String toString() {
            return "GuidePage(lottie=" + this.lottie + ", caption=" + this.caption + ")";
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B1\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u0019J\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010\u0019J\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010\u0019R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\"R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\"R\u001c\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/oobe/WakeAnywhereActivity$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/oobe/WakeAnywhereActivity$c$a;", "", "Lcom/stepos/ailauncher/oobe/WakeAnywhereActivity$b;", "pages", "Lkotlin/Function0;", "LY8/t;", "onFirstPagePlayOnceEnd", "onFirstPageFailed", "<init>", "(Ljava/util/List;Lp9/a;Lp9/a;)V", "", "position", "p", "(I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "k", "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/oobe/WakeAnywhereActivity$c$a;", "holder", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/oobe/WakeAnywhereActivity$c$a;I)V", "l", "(Lcom/stepos/ailauncher/oobe/WakeAnywhereActivity$c$a;)V", "m", "n", "getItemCount", "()I", "r", "q", "o", "Ljava/util/List;", "Lp9/a;", "", "holders", "[Lcom/stepos/ailauncher/oobe/WakeAnywhereActivity$c$a;", "Lcom/stepos/ailauncher/oobe/Z0;", "playback", "Lcom/stepos/ailauncher/oobe/Z0;", Const.INTENT_KEY_APIKEY, "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends RecyclerView.Adapter<a> {
        private final a[] holders;
        private final InterfaceC5063a<Y8.t> onFirstPageFailed;
        private final InterfaceC5063a<Y8.t> onFirstPagePlayOnceEnd;
        private final List<GuidePage> pages;
        private final Z0 playback;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/oobe/WakeAnywhereActivity$c$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lg6/g;", "binding", "<init>", "(Lg6/g;)V", "Lg6/g;", Const.INTENT_KEY_PKGNAME, "()Lg6/g;", "", "pagePosition", "I", "c", "()I", "e", "(I)V", "", "attached", "Z", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_UMID, "(Z)V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class a extends RecyclerView.ViewHolder {
            private boolean attached;
            private final g6.g binding;
            private int pagePosition;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(g6.g binding) {
                super(binding.b());
                kotlin.jvm.internal.p.i(binding, "binding");
                this.binding = binding;
                this.pagePosition = -1;
            }

            /* renamed from: a, reason: from getter */
            public final boolean getAttached() {
                return this.attached;
            }

            /* renamed from: b, reason: from getter */
            public final g6.g getBinding() {
                return this.binding;
            }

            /* renamed from: c, reason: from getter */
            public final int getPagePosition() {
                return this.pagePosition;
            }

            public final void d(boolean z10) {
                this.attached = z10;
            }

            public final void e(int i10) {
                this.pagePosition = i10;
            }
        }

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/oobe/WakeAnywhereActivity$c$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationStart", "(Landroid/animation/Animator;)V", "onAnimationCancel", "onAnimationEnd", "", "canceled", "Z", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class b extends AnimatorListenerAdapter {
            final /* synthetic */ a $holder;
            final /* synthetic */ LottieAnimationView $lottie;
            final /* synthetic */ int $position;
            private boolean canceled;

            public b(int i10, a aVar, LottieAnimationView lottieAnimationView) {
                this.$position = i10;
                this.$holder = aVar;
                this.$lottie = lottieAnimationView;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                kotlin.jvm.internal.p.i(animation, "animation");
                this.canceled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                kotlin.jvm.internal.p.i(animation, "animation");
                if (!this.canceled && c.this.holders[this.$position] == this.$holder && this.$lottie.getProgress() >= 0.99f && this.$position == 0 && c.this.playback.getSelectedPage() == 0) {
                    c.this.onFirstPagePlayOnceEnd.invoke();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                kotlin.jvm.internal.p.i(animation, "animation");
                this.canceled = false;
            }
        }

        public c(List<GuidePage> pages, InterfaceC5063a<Y8.t> onFirstPagePlayOnceEnd, InterfaceC5063a<Y8.t> onFirstPageFailed) {
            kotlin.jvm.internal.p.i(pages, "pages");
            kotlin.jvm.internal.p.i(onFirstPagePlayOnceEnd, "onFirstPagePlayOnceEnd");
            kotlin.jvm.internal.p.i(onFirstPageFailed, "onFirstPageFailed");
            this.pages = pages;
            this.onFirstPagePlayOnceEnd = onFirstPagePlayOnceEnd;
            this.onFirstPageFailed = onFirstPageFailed;
            this.holders = new a[pages.size()];
            this.playback = new Z0(pages.size());
        }

        public static final void i(int i10, c cVar, a aVar, Throwable th) {
            Log.w(WakeAnywhereActivity.TAG, "page " + i10 + " lottie failed", th);
            if (cVar.holders[i10] == aVar && i10 == 0 && cVar.playback.getSelectedPage() == 0) {
                cVar.onFirstPageFailed.invoke();
            }
        }

        public static final void j(c cVar, int i10, a aVar, LottieAnimationView lottieAnimationView, LottieComposition lottieComposition) {
            if (cVar.holders[i10] == aVar && aVar.getPagePosition() == i10) {
                lottieAnimationView.setSpeed(Z0.INSTANCE.a(lottieComposition.getDuration()));
                lottieAnimationView.setProgress(cVar.playback.b(i10) ? 1.0f : 0.0f);
                cVar.r(aVar);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.pages.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(final a holder, final int position) {
            kotlin.jvm.internal.p.i(holder, "holder");
            o(holder);
            GuidePage guidePage = this.pages.get(position);
            final LottieAnimationView lottieIllustration = holder.getBinding().lottieIllustration;
            kotlin.jvm.internal.p.h(lottieIllustration, "lottieIllustration");
            lottieIllustration.setRepeatCount(0);
            holder.e(position);
            this.holders[position] = holder;
            lottieIllustration.setFailureListener(new LottieListener() { // from class: com.stepos.ailauncher.oobe.X0
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    WakeAnywhereActivity.c.i(position, this, holder, (Throwable) obj);
                }
            });
            lottieIllustration.addAnimatorListener(new b(position, holder, lottieIllustration));
            lottieIllustration.setAnimation(guidePage.getLottie());
            lottieIllustration.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() { // from class: com.stepos.ailauncher.oobe.Y0
                @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
                public final void onCompositionLoaded(LottieComposition lottieComposition) {
                    WakeAnywhereActivity.c.j(this.f27584a, position, holder, lottieIllustration, lottieComposition);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            kotlin.jvm.internal.p.i(parent, "parent");
            g6.g gVarC = g6.g.c(LayoutInflater.from(parent.getContext()), parent, false);
            kotlin.jvm.internal.p.h(gVarC, "inflate(...)");
            return new a(gVarC);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void onViewAttachedToWindow(a holder) {
            kotlin.jvm.internal.p.i(holder, "holder");
            super.onViewAttachedToWindow(holder);
            holder.d(true);
            r(holder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void onViewDetachedFromWindow(a holder) {
            kotlin.jvm.internal.p.i(holder, "holder");
            holder.d(false);
            q(holder);
            super.onViewDetachedFromWindow(holder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(a holder) {
            kotlin.jvm.internal.p.i(holder, "holder");
            o(holder);
            holder.d(false);
            super.onViewRecycled(holder);
        }

        public final void o(a holder) {
            LottieAnimationView lottieIllustration = holder.getBinding().lottieIllustration;
            kotlin.jvm.internal.p.h(lottieIllustration, "lottieIllustration");
            lottieIllustration.removeAllAnimatorListeners();
            lottieIllustration.removeAllLottieOnCompositionLoadedListener();
            lottieIllustration.setFailureListener(null);
            lottieIllustration.cancelAnimation();
            int pagePosition = holder.getPagePosition();
            if (Z8.r.j0(this.holders, pagePosition) == holder) {
                this.holders[pagePosition] = null;
            }
            holder.e(-1);
        }

        public final void p(int position) {
            this.playback.c(position);
            for (a aVar : Z8.r.V(this.holders)) {
                if (aVar.getPagePosition() == position) {
                    r(aVar);
                } else {
                    q(aVar);
                }
            }
        }

        public final void q(a holder) {
            LottieAnimationView lottieAnimationView = holder.getBinding().lottieIllustration;
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setProgress(this.playback.b(holder.getPagePosition()) ? 1.0f : 0.0f);
        }

        public final void r(a holder) {
            int pagePosition = holder.getPagePosition();
            LottieAnimationView lottieIllustration = holder.getBinding().lottieIllustration;
            kotlin.jvm.internal.p.h(lottieIllustration, "lottieIllustration");
            if (holder.getAttached() && Z8.r.j0(this.holders, pagePosition) == holder && lottieIllustration.getComposition() != null && this.playback.d(pagePosition)) {
                lottieIllustration.setProgress(0.0f);
                lottieIllustration.playAnimation();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/oobe/WakeAnywhereActivity$d", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends ViewOutlineProvider {
        final /* synthetic */ float $radiusPx;

        public d(float f10) {
            this.$radiusPx = f10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            int width = view.getWidth();
            int height = view.getHeight();
            float f10 = this.$radiusPx;
            outline.setRoundRect(0, 0, width, height + ((int) f10), f10);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/oobe/WakeAnywhereActivity$e", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends AbstractC1417G {
        public e() {
            super(true);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
            if (WakeAnywhereActivity.this.sheetClosed) {
                WakeAnywhereActivity.this.Z();
            } else {
                WakeAnywhereActivity.this.b0();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/oobe/WakeAnywhereActivity$f", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f extends AnimatorListenerAdapter {
        final /* synthetic */ InterfaceC5063a<Y8.t> $onEnd;

        public f(InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.$onEnd = interfaceC5063a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (WakeAnywhereActivity.this.isFinishing() || WakeAnywhereActivity.this.binding == null || WakeAnywhereActivity.this.sideKeyAnimator != animation) {
                return;
            }
            WakeAnywhereActivity.this.sideKeyAnimator = null;
            this.$onEnd.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/oobe/WakeAnywhereActivity$g", "Landroidx/viewpager2/widget/ViewPager2$i;", "", "position", "LY8/t;", "onPageSelected", "(I)V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends ViewPager2.i {
        final /* synthetic */ c $adapter;

        public g(c cVar) {
            this.$adapter = cVar;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int position) {
            WakeAnywhereActivity.this.q0(position);
            WakeAnywhereActivity.this.W();
            this.$adapter.p(position);
            WakeAnywhereActivity.this.u0(position);
        }
    }

    public static final boolean R(WakeAnywhereActivity wakeAnywhereActivity, Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        wakeAnywhereActivity.pendingAiKeyWakeIntent = new Intent(intent);
        if (!wakeAnywhereActivity.dismissedByAiKey) {
            wakeAnywhereActivity.dismissedByAiKey = true;
            wakeAnywhereActivity.v0(intent);
            Log.d(TAG, "AI key: close guide, continue wake after gone");
            wakeAnywhereActivity.Z();
        }
        return true;
    }

    public static final androidx.core.view.a0 T(int i10, View view, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(insets, "insets");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), insets.f(a0.o.e()).f41980d + i10);
        return insets;
    }

    public static final void V(WakeAnywhereActivity wakeAnywhereActivity) {
        g6.f fVar;
        if (wakeAnywhereActivity.isFinishing() || (fVar = wakeAnywhereActivity.binding) == null) {
            return;
        }
        g6.f fVar2 = null;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar = null;
        }
        if (fVar.pager.getCurrentItem() != 0) {
            return;
        }
        g6.f fVar3 = wakeAnywhereActivity.binding;
        if (fVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            fVar2 = fVar3;
        }
        fVar2.pager.m(1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        if (this.sheetClosed) {
            return;
        }
        this.sheetClosed = true;
        W();
        this.mainHandler.removeCallbacks(this.showSideKeyRunnable);
        g6.f fVar = this.binding;
        g6.f fVar2 = null;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar = null;
        }
        fVar.sheet.setVisibility(8);
        g6.f fVar3 = this.binding;
        if (fVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar3 = null;
        }
        fVar3.overlayScrim.setVisibility(8);
        if (!this.sideKeySequenceStarted) {
            j0();
            return;
        }
        g6.f fVar4 = this.binding;
        if (fVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            fVar2 = fVar4;
        }
        if (fVar2.sideKeyBar.getVisibility() != 0) {
            Z();
        }
    }

    public static final void e0(WakeAnywhereActivity wakeAnywhereActivity, View view) {
        wakeAnywhereActivity.b0();
    }

    public static final void f0(WakeAnywhereActivity wakeAnywhereActivity, View view) {
        wakeAnywhereActivity.b0();
    }

    public static final void g0(WakeAnywhereActivity wakeAnywhereActivity, View view) {
        C4059a.INSTANCE.b(wakeAnywhereActivity.fromHomeLauncher, C4059a.AIKEY_GUIDE_KNOW);
        wakeAnywhereActivity.b0();
    }

    public static final void h0(Context context, Intent intent) {
        Log.d(TAG, "AI key: continue wake after guide closed");
        WakeService.Companion companion = WakeService.INSTANCE;
        kotlin.jvm.internal.p.f(context);
        companion.J1(context, intent);
    }

    public static final Y8.t k0(final WakeAnywhereActivity wakeAnywhereActivity, final View view, final float f10) {
        wakeAnywhereActivity.i0(view, new InterfaceC5063a() { // from class: com.stepos.ailauncher.oobe.L0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeAnywhereActivity.l0(this.f27552a, f10, view);
            }
        });
        return Y8.t.f7040a;
    }

    public static final Y8.t l0(final WakeAnywhereActivity wakeAnywhereActivity, float f10, final View view) {
        wakeAnywhereActivity.s0(0.0f, f10, new InterfaceC5063a() { // from class: com.stepos.ailauncher.oobe.N0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeAnywhereActivity.m0(view, wakeAnywhereActivity);
            }
        });
        return Y8.t.f7040a;
    }

    public static final Y8.t m0(View view, WakeAnywhereActivity wakeAnywhereActivity) {
        view.setVisibility(8);
        if (wakeAnywhereActivity.sheetClosed) {
            wakeAnywhereActivity.Z();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t o0(WakeAnywhereActivity wakeAnywhereActivity) {
        if (!wakeAnywhereActivity.isFinishing() && !wakeAnywhereActivity.sheetClosed) {
            g6.f fVar = wakeAnywhereActivity.binding;
            g6.f fVar2 = null;
            if (fVar == null) {
                kotlin.jvm.internal.p.A("binding");
                fVar = null;
            }
            if (fVar.pager.getCurrentItem() == 0) {
                g6.f fVar3 = wakeAnywhereActivity.binding;
                if (fVar3 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    fVar2 = fVar3;
                }
                fVar2.pager.m(1, true);
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t p0(WakeAnywhereActivity wakeAnywhereActivity) {
        wakeAnywhereActivity.mainHandler.removeCallbacks(wakeAnywhereActivity.autoAdvanceRunnable);
        wakeAnywhereActivity.mainHandler.postDelayed(wakeAnywhereActivity.autoAdvanceRunnable, 2000L);
        return Y8.t.f7040a;
    }

    public static final void r0(WakeAnywhereActivity wakeAnywhereActivity) {
        g6.f fVar;
        if (wakeAnywhereActivity.isFinishing() || (fVar = wakeAnywhereActivity.binding) == null) {
            return;
        }
        if (!wakeAnywhereActivity.sheetClosed) {
            if (fVar == null) {
                kotlin.jvm.internal.p.A("binding");
                fVar = null;
            }
            if (fVar.pager.getCurrentItem() != 1) {
                return;
            }
        }
        wakeAnywhereActivity.j0();
    }

    public static final void t0(WakeAnywhereActivity wakeAnywhereActivity, InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        if (wakeAnywhereActivity.sideKeySpring != eVar) {
            return;
        }
        wakeAnywhereActivity.sideKeySpring = null;
        if (z10 || wakeAnywhereActivity.isFinishing()) {
            return;
        }
        interfaceC5063a.invoke();
    }

    public final void S() {
        final int i10 = (int) (getResources().getDisplayMetrics().density * 16.0f);
        g6.f fVar = this.binding;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar = null;
        }
        androidx.core.view.N.u0(fVar.sheet, new androidx.core.view.A() { // from class: com.stepos.ailauncher.oobe.W0
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return WakeAnywhereActivity.T(i10, view, a0Var);
            }
        });
    }

    public final void U() {
        androidx.core.view.Y.b(getWindow(), false);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().getDecorView().setBackgroundColor(0);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        androidx.core.view.b0 b0Var = new androidx.core.view.b0(getWindow(), getWindow().getDecorView());
        b0Var.e(false);
        b0Var.d(false);
        com.stepos.ailauncher.common.utils.H.c(getWindow(), false);
    }

    public final void W() {
        this.mainHandler.removeCallbacks(this.autoAdvanceRunnable);
    }

    public final void X() {
        Animator animator = this.sideKeyAnimator;
        if (animator != null) {
            animator.removeAllListeners();
            animator.cancel();
        }
        this.sideKeyAnimator = null;
        androidx.dynamicanimation.animation.i iVar = this.sideKeySpring;
        this.sideKeySpring = null;
        if (iVar != null) {
            iVar.d();
        }
    }

    public final void Y() {
        float f10 = getResources().getDisplayMetrics().density * SHEET_CORNER_RADIUS_DP;
        g6.f fVar = this.binding;
        g6.f fVar2 = null;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar = null;
        }
        fVar.sheet.setClipToOutline(true);
        g6.f fVar3 = this.binding;
        if (fVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            fVar2 = fVar3;
        }
        fVar2.sheet.setOutlineProvider(new d(f10));
    }

    public final void Z() {
        if (isFinishing()) {
            return;
        }
        X();
        this.mainHandler.removeCallbacksAndMessages(null);
        if (isTaskRoot()) {
            finishAndRemoveTask();
        } else {
            finish();
        }
    }

    @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
    public final void a0() {
        Class<?> cls;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(this, null);
            Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
            kotlin.jvm.internal.p.h(declaredClasses, "getDeclaredClasses(...)");
            int length = declaredClasses.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    cls = null;
                    break;
                }
                cls = declaredClasses[i10];
                String simpleName = cls.getSimpleName();
                kotlin.jvm.internal.p.h(simpleName, "getSimpleName(...)");
                if (La.H.g0(simpleName, "TranslucentConversionListener", false, 2, null)) {
                    break;
                } else {
                    i10++;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(this, null, objInvoke);
        } catch (Throwable unused) {
            Log.d(TAG, "convertToTranslucent unavailable, rely on windowIsTranslucent theme");
        }
    }

    public final float c0(float value) {
        return value * getResources().getDisplayMetrics().density;
    }

    public final void d0() {
        X();
        g6.f fVar = this.binding;
        if (fVar == null) {
            return;
        }
        g6.f fVar2 = null;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar = null;
        }
        fVar.sideKeyBar.animate().cancel();
        g6.f fVar3 = this.binding;
        if (fVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar3 = null;
        }
        fVar3.sideKeyBar.setTranslationX(0.0f);
        g6.f fVar4 = this.binding;
        if (fVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            fVar2 = fVar4;
        }
        fVar2.sideKeyBar.setVisibility(8);
    }

    public final void i0(View bar, InterfaceC5063a<Y8.t> onEnd) {
        float f10 = -c0(SIDE_KEY_NUDGE_DP);
        Property property = View.TRANSLATION_X;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(bar, (Property<View, Float>) property, 0.0f, f10);
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.setInterpolator(this.sideKeyNudgeOut);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(bar, (Property<View, Float>) property, f10, f10);
        objectAnimatorOfFloat2.setDuration(1000L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(bar, (Property<View, Float>) property, f10, 0.0f);
        objectAnimatorOfFloat3.setDuration(250L);
        objectAnimatorOfFloat3.setInterpolator(this.sideKeyNudgeBack);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(bar, (Property<View, Float>) property, 0.0f, f10);
        objectAnimatorOfFloat4.setDuration(250L);
        objectAnimatorOfFloat4.setInterpolator(this.sideKeyNudgeOut);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(bar, (Property<View, Float>) property, f10, 0.0f);
        objectAnimatorOfFloat5.setDuration(250L);
        objectAnimatorOfFloat5.setInterpolator(this.sideKeyNudgeBack);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat5);
        animatorSet.addListener(new f(onEnd));
        animatorSet.start();
        this.sideKeyAnimator = animatorSet;
    }

    public final void j0() {
        g6.f fVar;
        if (isFinishing() || (fVar = this.binding) == null || this.sideKeySequenceStarted) {
            return;
        }
        this.sideKeySequenceStarted = true;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar = null;
        }
        final View sideKeyBar = fVar.sideKeyBar;
        kotlin.jvm.internal.p.h(sideKeyBar, "sideKeyBar");
        final float fC0 = c0(SIDE_KEY_APPEAR_OFFSET_DP);
        sideKeyBar.setTranslationX(fC0);
        sideKeyBar.setVisibility(0);
        s0(fC0, 0.0f, new InterfaceC5063a() { // from class: com.stepos.ailauncher.oobe.K0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeAnywhereActivity.k0(this.f27548a, sideKeyBar, fC0);
            }
        });
    }

    public final void n0() {
        c cVar = new c(this.pages, new InterfaceC5063a() { // from class: com.stepos.ailauncher.oobe.U0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeAnywhereActivity.o0(this.f27572a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.oobe.V0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeAnywhereActivity.p0(this.f27574a);
            }
        });
        g6.f fVar = this.binding;
        g6.f fVar2 = null;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar = null;
        }
        fVar.pager.setAdapter(cVar);
        g6.f fVar3 = this.binding;
        if (fVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            fVar2 = fVar3;
        }
        fVar2.pager.j(new g(cVar));
        q0(0);
        u0(0);
    }

    @Override // com.stepos.ailauncher.oobe.N, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.fromHomeLauncher = getIntent().getBooleanExtra(EXTRA_FROM_HOME_LAUNCHER, false);
        C4059a c4059a = C4059a.INSTANCE;
        g6.f fVar = null;
        C4059a.h(c4059a, C4059a.STEP_WAKE_ANYWHERE, null, 2, null);
        c4059a.c(this.fromHomeLauncher);
        g6.f fVarB = g6.f.b(getLayoutInflater());
        kotlin.jvm.internal.p.h(fVarB, "inflate(...)");
        this.binding = fVarB;
        if (fVarB == null) {
            kotlin.jvm.internal.p.A("binding");
            fVarB = null;
        }
        setContentView(fVarB.root);
        U();
        a0();
        Y();
        S();
        n0();
        C3119f.INSTANCE.b(this.aiKeyWakeHandler);
        g6.f fVar2 = this.binding;
        if (fVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar2 = null;
        }
        fVar2.titleBar.addEndAction(com.stepos.widget.R.drawable.stepos_icon_close, getString(R$string.oobe_close), new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.J0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WakeAnywhereActivity.e0(this.f27546a, view);
            }
        });
        g6.f fVar3 = this.binding;
        if (fVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar3 = null;
        }
        fVar3.overlayScrim.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.O0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WakeAnywhereActivity.f0(this.f27560a, view);
            }
        });
        g6.f fVar4 = this.binding;
        if (fVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            fVar = fVar4;
        }
        fVar.btnGotIt.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.P0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WakeAnywhereActivity.g0(this.f27562a, view);
            }
        });
        getOnBackPressedDispatcher().m(this, new e());
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        X();
        this.mainHandler.removeCallbacksAndMessages(null);
        final Intent intent = this.pendingAiKeyWakeIntent;
        this.pendingAiKeyWakeIntent = null;
        super.onDestroy();
        if (intent != null) {
            final Context applicationContext = getApplicationContext();
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.stepos.ailauncher.oobe.T0
                @Override // java.lang.Runnable
                public final void run() {
                    WakeAnywhereActivity.h0(applicationContext, intent);
                }
            });
        }
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStart() {
        super.onStart();
        C3119f.INSTANCE.b(this.aiKeyWakeHandler);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStop() {
        C3119f c3119f = C3119f.INSTANCE;
        if (c3119f.a() == this.aiKeyWakeHandler) {
            c3119f.b(null);
        }
        super.onStop();
    }

    public final void q0(int position) {
        GuidePage guidePage = (GuidePage) Z8.F.t0(this.pages, position);
        if (guidePage == null) {
            return;
        }
        g6.f fVar = this.binding;
        g6.f fVar2 = null;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar = null;
        }
        fVar.tvCaption.setText(guidePage.getCaption());
        g6.f fVar3 = this.binding;
        if (fVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar3 = null;
        }
        fVar3.dotVoice.setAlpha(position == 0 ? 0.9f : 0.3f);
        g6.f fVar4 = this.binding;
        if (fVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            fVar2 = fVar4;
        }
        fVar2.dotKeyboard.setAlpha(position == 1 ? 0.9f : 0.3f);
    }

    @Override // com.stepos.ailauncher.oobe.N
    /* renamed from: s, reason: from getter */
    public boolean getPreventScreenCapture() {
        return this.preventScreenCapture;
    }

    public final void s0(float from, float to, final InterfaceC5063a<Y8.t> onEnd) {
        g6.f fVar = this.binding;
        if (fVar == null) {
            kotlin.jvm.internal.p.A("binding");
            fVar = null;
        }
        View sideKeyBar = fVar.sideKeyBar;
        kotlin.jvm.internal.p.h(sideKeyBar, "sideKeyBar");
        sideKeyBar.setTranslationX(from);
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(sideKeyBar, androidx.dynamicanimation.animation.e.f13690n, to);
        iVar.B(new androidx.dynamicanimation.animation.j(to).h(130.0f).f(SIDE_KEY_SPRING_DAMPING / (((float) Math.sqrt(130.0f)) * 2.0f)));
        iVar.b(new e.q() { // from class: com.stepos.ailauncher.oobe.M0
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                WakeAnywhereActivity.t0(this.f27556a, onEnd, eVar, z10, f10, f11);
            }
        });
        this.sideKeySpring = iVar;
        iVar.t();
    }

    public final void u0(int position) {
        if (this.sheetClosed) {
            return;
        }
        this.mainHandler.removeCallbacks(this.showSideKeyRunnable);
        if (position == 1) {
            this.mainHandler.postDelayed(this.showSideKeyRunnable, 2000L);
        } else {
            d0();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final void v0(Intent intent) {
        String str;
        String stringExtra = intent.getStringExtra(C4814a.PARAM_SOURCE);
        if (stringExtra != null) {
            switch (stringExtra.hashCode()) {
                case -1418033720:
                    if (!stringExtra.equals(C4814a.AI_KEY_CLICK2)) {
                    }
                    str = C4059a.AIKEY_GUIDE_REAL_CLICK;
                    C4059a.INSTANCE.b(this.fromHomeLauncher, str);
                    break;
                case 643045183:
                    if (!stringExtra.equals(C4814a.AI_KEY_LONG_CLICK_START)) {
                    }
                    str = C4059a.AIKEY_GUIDE_REAL_LONGPRESS;
                    C4059a.INSTANCE.b(this.fromHomeLauncher, str);
                    break;
                case 684453624:
                    if (!stringExtra.equals(C4814a.AI_KEY_LONG_CLICK_END)) {
                    }
                    str = C4059a.AIKEY_GUIDE_REAL_LONGPRESS;
                    C4059a.INSTANCE.b(this.fromHomeLauncher, str);
                    break;
                case 1080244305:
                    if (!stringExtra.equals("ai_key_click")) {
                    }
                    str = C4059a.AIKEY_GUIDE_REAL_CLICK;
                    C4059a.INSTANCE.b(this.fromHomeLauncher, str);
                    break;
            }
        }
    }
}
