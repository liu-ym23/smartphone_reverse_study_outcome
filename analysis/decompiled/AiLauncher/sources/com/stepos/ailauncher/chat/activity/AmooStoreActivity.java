package com.stepos.ailauncher.chat.activity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Lifecycle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.broadcast.RecentsWindowMonitor;
import com.stepos.ailauncher.chat.fragment.AmooStoreFragment;
import com.stepos.ailauncher.chat.manager.AmooStoreBadgeState;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.sheet.SheetExitAnim;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 J2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0015J\u0019\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0014¢\u0006\u0004\b \u0010\u0003J\u000f\u0010\"\u001a\u00020!H\u0014¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0010H\u0014¢\u0006\u0004\b$\u0010\u0019J\u000f\u0010%\u001a\u00020\u0010H\u0014¢\u0006\u0004\b%\u0010\u0019J\u000f\u0010&\u001a\u00020\u0004H\u0014¢\u0006\u0004\b&\u0010\u0015J\u000f\u0010'\u001a\u00020\u0004H\u0014¢\u0006\u0004\b'\u0010\u0015J\u000f\u0010)\u001a\u00020(H\u0014¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0004H\u0014¢\u0006\u0004\b+\u0010\u0015J\u000f\u0010,\u001a\u00020\u0004H\u0014¢\u0006\u0004\b,\u0010\u0015J\u000f\u0010-\u001a\u00020\u0004H\u0014¢\u0006\u0004\b-\u0010\u0015J\u000f\u0010/\u001a\u00020.H\u0014¢\u0006\u0004\b/\u00100J\u0019\u00101\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b1\u0010\u001fJ\u000f\u00102\u001a\u00020\u0006H\u0014¢\u0006\u0004\b2\u0010\u0003J\u000f\u00103\u001a\u00020\u0006H\u0014¢\u0006\u0004\b3\u0010\u0003J\u0017\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0004H\u0016¢\u0006\u0004\b5\u0010\bJ\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\u0003R\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00108R\u0016\u0010:\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00108R\u0016\u0010=\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010DR\u0014\u0010F\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010DR \u0010H\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006L"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/AmooStoreActivity;", "Lcom/stepos/ailauncher/sheet/S;", "<init>", "()V", "", "animate", "LY8/t;", "J4", "(Z)V", "Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$RecentsState;", "prev", "P4", "(Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$RecentsState;)V", "T4", "W4", "S4", "", "reason", "V4", "(Ljava/lang/String;)V", "X4", "()Z", "M4", "N4", "Y4", "()Ljava/lang/String;", "H4", "L4", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Landroidx/fragment/app/Fragment;", "s4", "()Landroidx/fragment/app/Fragment;", "z4", "f4", "Z3", "L1", "Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "x1", "()Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "i1", "j1", "t3", "", "j2", "()I", "y4", "onResume", "onPause", "hasFocus", "onWindowFocusChanged", "E3", "coveredByThirdParty", "Z", "recentsHiddenUnder3rd", "lastRecentsState", "Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$RecentsState;", "idleFromPeek", "restoreGeneration", "I", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "restoreIfLandedRunnable", "Ljava/lang/Runnable;", "markCoveredRunnable", "clearCoveredRunnable", "Lkotlin/Function1;", "recentsListener", "Lp9/l;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmooStoreActivity extends com.stepos.ailauncher.sheet.S {
    private static final long BRING_FRONT_STABLE_MS = 560;
    private static final long CLEAR_COVERED_DELAY_MS = 300;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long MARK_COVERED_DELAY_MS = 120;
    private static final long PEEK_FADE_MS = 180;
    private static final String TAG = "AmooStoreActivity";
    private boolean coveredByThirdParty;
    private boolean idleFromPeek;
    private boolean recentsHiddenUnder3rd;
    private int restoreGeneration;
    private RecentsWindowMonitor.RecentsState lastRecentsState = RecentsWindowMonitor.INSTANCE.h();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Runnable restoreIfLandedRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.activity.a
        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            AmooStoreActivity.U4(this.f24792a);
        }
    };
    private final Runnable markCoveredRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.activity.b
        @Override // java.lang.Runnable
        public final void run() {
            AmooStoreActivity.O4(this.f24796a);
        }
    };
    private final Runnable clearCoveredRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.activity.c
        @Override // java.lang.Runnable
        public final void run() {
            AmooStoreActivity.I4(this.f24800a);
        }
    };
    private final InterfaceC5074l<RecentsWindowMonitor.RecentsState, Y8.t> recentsListener = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.activity.d
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return AmooStoreActivity.R4(this.f24804a, (RecentsWindowMonitor.RecentsState) obj);
        }
    };

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/AmooStoreActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "", "TAG", "Ljava/lang/String;", "", "PEEK_FADE_MS", "J", "MARK_COVERED_DELAY_MS", "CLEAR_COVERED_DELAY_MS", "BRING_FRONT_STABLE_MS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.activity.AmooStoreActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            C2739j.C(context, new Intent(context, (Class<?>) AmooStoreActivity.class), null, 4, null);
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecentsWindowMonitor.RecentsState.values().length];
            try {
                iArr[RecentsWindowMonitor.RecentsState.PEEK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecentsWindowMonitor.RecentsState.OVERVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RecentsWindowMonitor.RecentsState.IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void I4(AmooStoreActivity amooStoreActivity) {
        if (amooStoreActivity.isFinishing() || amooStoreActivity.isDestroyed()) {
            return;
        }
        RecentsWindowMonitor recentsWindowMonitor = RecentsWindowMonitor.INSTANCE;
        if (recentsWindowMonitor.h() != RecentsWindowMonitor.RecentsState.IDLE) {
            amooStoreActivity.N4("clearCovered skip recents=" + recentsWindowMonitor.h());
            return;
        }
        if (!amooStoreActivity.hasWindowFocus()) {
            amooStoreActivity.N4("clearCovered skip no-focus");
            return;
        }
        if (amooStoreActivity.L4()) {
            amooStoreActivity.N4("clearCovered skip still-3rd");
        } else {
            if (amooStoreActivity.getHiddenForRecentsPeek()) {
                amooStoreActivity.N4("clearCovered skip still-hidden");
                return;
            }
            amooStoreActivity.coveredByThirdParty = false;
            amooStoreActivity.recentsHiddenUnder3rd = false;
            amooStoreActivity.N4("clearCovered ok");
        }
    }

    public static final void K4(AmooStoreActivity amooStoreActivity) {
        if (amooStoreActivity.isFinishing() || amooStoreActivity.isDestroyed() || !amooStoreActivity.getHiddenForRecentsPeek()) {
            return;
        }
        amooStoreActivity.O0();
    }

    public static final void O4(AmooStoreActivity amooStoreActivity) {
        if (amooStoreActivity.isFinishing() || amooStoreActivity.isDestroyed() || amooStoreActivity.getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED) || RecentsWindowMonitor.INSTANCE.h() != RecentsWindowMonitor.RecentsState.IDLE || !amooStoreActivity.L4()) {
            return;
        }
        amooStoreActivity.coveredByThirdParty = true;
        amooStoreActivity.N4("markCovered delayed-after-pause");
    }

    public static final void Q4(int i10, AmooStoreActivity amooStoreActivity) throws Resources.NotFoundException {
        if (i10 != amooStoreActivity.restoreGeneration) {
            return;
        }
        amooStoreActivity.T4();
    }

    public static final Y8.t R4(AmooStoreActivity amooStoreActivity, RecentsWindowMonitor.RecentsState state) {
        kotlin.jvm.internal.p.i(state, "state");
        RecentsWindowMonitor.RecentsState recentsState = amooStoreActivity.lastRecentsState;
        amooStoreActivity.lastRecentsState = state;
        amooStoreActivity.N4("recents " + recentsState + " → " + state);
        int i10 = b.$EnumSwitchMapping$0[state.ordinal()];
        if (i10 == 1) {
            amooStoreActivity.H4();
            amooStoreActivity.mainHandler.removeCallbacks(amooStoreActivity.restoreIfLandedRunnable);
            amooStoreActivity.J4(true);
        } else if (i10 == 2) {
            amooStoreActivity.H4();
            amooStoreActivity.mainHandler.removeCallbacks(amooStoreActivity.restoreIfLandedRunnable);
            amooStoreActivity.J4(false);
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            amooStoreActivity.P4(recentsState);
        }
        return Y8.t.f7040a;
    }

    public static final void U4(AmooStoreActivity amooStoreActivity) throws Resources.NotFoundException {
        amooStoreActivity.S4();
    }

    @Override // com.stepos.ailauncher.sheet.O
    public void E3() throws Resources.NotFoundException {
        if (X4()) {
            M4("restoreAfterRecentsPeek");
        } else {
            V4("restoreAfterRecentsPeek");
        }
    }

    public final void H4() {
        this.restoreGeneration++;
    }

    public final void J4(boolean animate) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        if (!this.coveredByThirdParty) {
            N4("hide skip !covered animate=" + animate);
            return;
        }
        this.recentsHiddenUnder3rd = true;
        if (getHiddenForRecentsPeek()) {
            if (animate) {
                return;
            }
            O0();
            return;
        }
        Window window = getWindow();
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        R0();
        window.addFlags(16);
        decorView.animate().cancel();
        if (!animate) {
            O0();
            C4148a.k(TAG, "recents hide pixels (under3rd, overview)", false, 4, null);
            return;
        }
        if (decorView.getVisibility() != 0) {
            decorView.setVisibility(0);
        }
        if (decorView.getAlpha() <= 0.01f) {
            decorView.setAlpha(1.0f);
        }
        decorView.animate().alpha(0.0f).setDuration(180L).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.e
            @Override // java.lang.Runnable
            public final void run() {
                AmooStoreActivity.K4(this.f24811a);
            }
        }).start();
        C4148a.k(TAG, "recents hide pixels early (under3rd)", false, 4, null);
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean L1() {
        return true;
    }

    public final boolean L4() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        ComponentName componentName;
        String packageName;
        try {
            ActivityManager activityManager = (ActivityManager) getSystemService(ActivityManager.class);
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && (runningTaskInfo = (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks)) != null && (componentName = runningTaskInfo.topActivity) != null && (packageName = componentName.getPackageName()) != null && !kotlin.jvm.internal.p.d(packageName, getPackageName())) {
                if (!kotlin.jvm.internal.p.d(packageName, "com.android.launcher3")) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final void M4(String reason) {
        Window window;
        if (isFinishing() || isDestroyed() || !getHiddenForRecentsPeek() || (window = getWindow()) == null) {
            return;
        }
        window.addFlags(16);
        O0();
        N4(reason + " keep-hidden");
    }

    public final void N4(String reason) {
        Object objB;
        Window window = getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        RecentsWindowMonitor.RecentsState recentsStateH = RecentsWindowMonitor.INSTANCE.h();
        RecentsWindowMonitor.RecentsState recentsState = this.lastRecentsState;
        boolean z10 = this.coveredByThirdParty;
        boolean z11 = this.recentsHiddenUnder3rd;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(getHiddenForRecentsPeek()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        boolean z12 = this.idleFromPeek;
        boolean zHasWindowFocus = hasWindowFocus();
        Lifecycle.State state = getLifecycle().getState();
        String strY4 = Y4();
        Integer numValueOf = decorView != null ? Integer.valueOf(decorView.getVisibility()) : null;
        Float fValueOf = decorView != null ? Float.valueOf(decorView.getAlpha()) : null;
        C4148a.k(TAG, reason + " | recents=" + recentsStateH + " last=" + recentsState + " covered=" + z10 + " hiddenUnder3rd=" + z11 + " peekHidden=" + objB + " idleFromPeek=" + z12 + " focus=" + zHasWindowFocus + " life=" + state + " top=" + strY4 + " decorVis=" + numValueOf + " decorA=" + fValueOf + " keepHidden=" + X4(), false, 4, null);
    }

    public final void P4(RecentsWindowMonitor.RecentsState prev) {
        boolean z10 = prev == RecentsWindowMonitor.RecentsState.PEEK;
        this.idleFromPeek = z10;
        N4("onRecentsIdle from=" + prev + " idleFromPeek=" + z10);
        int i10 = b.$EnumSwitchMapping$0[prev.ordinal()];
        if (i10 == 1) {
            if (this.recentsHiddenUnder3rd && getHiddenForRecentsPeek()) {
                M4("CANCEL_GESTURE");
                return;
            }
            return;
        }
        if (i10 != 2) {
            return;
        }
        if (this.recentsHiddenUnder3rd && getHiddenForRecentsPeek()) {
            W4();
            final int i11 = this.restoreGeneration + 1;
            this.restoreGeneration = i11;
            this.mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.activity.f
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    AmooStoreActivity.Q4(i11, this);
                }
            }, BRING_FRONT_STABLE_MS);
            C4148a.k(TAG, "EXIT_RECENTS → wait 560ms to confirm land", false, 4, null);
            return;
        }
        N4("EXIT skip hiddenUnder3rd=" + this.recentsHiddenUnder3rd + " peekHidden=" + getHiddenForRecentsPeek());
    }

    public final void S4() throws Resources.NotFoundException {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        RecentsWindowMonitor.RecentsState recentsState = this.lastRecentsState;
        if (recentsState != RecentsWindowMonitor.RecentsState.IDLE) {
            N4("land-check skip last=" + recentsState);
            return;
        }
        if (!getHiddenForRecentsPeek()) {
            N4("land-check skip already-visible");
            return;
        }
        if (L4()) {
            M4("land-check");
        } else if (hasWindowFocus()) {
            V4("land-check");
        } else {
            N4("land-check skip no-focus");
        }
    }

    public final void T4() throws Resources.NotFoundException {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        RecentsWindowMonitor.RecentsState recentsState = this.lastRecentsState;
        if (recentsState != RecentsWindowMonitor.RecentsState.IDLE) {
            N4("EXIT stable skip last=" + recentsState);
            return;
        }
        if (X4()) {
            M4("EXIT_RECENTS");
        } else {
            V4("EXIT_RECENTS");
        }
    }

    public final void V4(String reason) throws Resources.NotFoundException {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.recentsHiddenUnder3rd = false;
        this.idleFromPeek = false;
        this.coveredByThirdParty = false;
        if (getHiddenForRecentsPeek()) {
            super.E3();
            C4148a.k(TAG, reason + " → full restore", false, 4, null);
        }
    }

    public final void W4() {
        this.mainHandler.removeCallbacks(this.restoreIfLandedRunnable);
        if (!this.recentsHiddenUnder3rd || !getHiddenForRecentsPeek()) {
            N4("scheduleLand skip hiddenUnder3rd=" + this.recentsHiddenUnder3rd + " peekHidden=" + getHiddenForRecentsPeek());
            return;
        }
        RecentsWindowMonitor recentsWindowMonitor = RecentsWindowMonitor.INSTANCE;
        if (recentsWindowMonitor.h() == RecentsWindowMonitor.RecentsState.IDLE) {
            N4("scheduleLand in 300ms");
            this.mainHandler.postDelayed(this.restoreIfLandedRunnable, 300L);
            return;
        }
        N4("scheduleLand skip recents=" + recentsWindowMonitor.h());
    }

    public final boolean X4() {
        if (!this.recentsHiddenUnder3rd) {
            return false;
        }
        if (this.lastRecentsState != RecentsWindowMonitor.RecentsState.IDLE) {
            return true;
        }
        return L4();
    }

    public final String Y4() {
        String packageName;
        ComponentName componentName;
        String shortClassName;
        ComponentName componentName2;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        try {
            ActivityManager activityManager = (ActivityManager) getSystemService(ActivityManager.class);
            ActivityManager.RunningTaskInfo runningTaskInfo = (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null) ? null : (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks);
            String str = "?";
            if (runningTaskInfo == null || (componentName2 = runningTaskInfo.topActivity) == null || (packageName = componentName2.getPackageName()) == null) {
                packageName = "?";
            }
            if (runningTaskInfo != null && (componentName = runningTaskInfo.topActivity) != null && (shortClassName = componentName.getShortClassName()) != null) {
                str = shortClassName;
            }
            return packageName + "/" + str;
        } catch (Throwable th) {
            return "err:" + th.getMessage();
        }
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean Z3() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public String f4() {
        String name = AmooStoreActivity.class.getName();
        kotlin.jvm.internal.p.h(name, "getName(...)");
        return name;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean i1() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean j1() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public int j2() {
        if (get_layerIndex() > 1) {
            return 0;
        }
        return super.j2();
    }

    @Override // com.stepos.ailauncher.sheet.O, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Result.Companion companion = Result.INSTANCE;
            setRecentsScreenshotEnabled(false);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        RecentsWindowMonitor.INSTANCE.c(this.recentsListener);
        N4("onCreate");
    }

    @Override // com.stepos.ailauncher.sheet.O, androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        RecentsWindowMonitor.INSTANCE.q(this.recentsListener);
        this.mainHandler.removeCallbacks(this.markCoveredRunnable);
        this.mainHandler.removeCallbacks(this.clearCoveredRunnable);
        this.mainHandler.removeCallbacks(this.restoreIfLandedRunnable);
        H4();
        super.onDestroy();
    }

    @Override // com.stepos.ailauncher.sheet.O, androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        this.mainHandler.removeCallbacks(this.clearCoveredRunnable);
        this.mainHandler.removeCallbacks(this.restoreIfLandedRunnable);
        if (L4()) {
            this.coveredByThirdParty = true;
        }
        N4("onPause");
        this.mainHandler.removeCallbacks(this.markCoveredRunnable);
        this.mainHandler.postDelayed(this.markCoveredRunnable, 120L);
        super.onPause();
        AmooStoreBadgeState.INSTANCE.g();
    }

    @Override // com.stepos.ailauncher.sheet.O, androidx.fragment.app.r, android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        this.mainHandler.removeCallbacks(this.markCoveredRunnable);
        boolean z10 = RecentsWindowMonitor.INSTANCE.h() != RecentsWindowMonitor.RecentsState.IDLE;
        N4("onResume recentsBusy=" + z10);
        if (this.coveredByThirdParty && z10) {
            J4(false);
        }
        super.onResume();
        AmooStoreBadgeState.INSTANCE.h();
        if (this.coveredByThirdParty && z10) {
            J4(false);
        } else {
            if (z10) {
                return;
            }
            W4();
        }
    }

    @Override // com.stepos.ailauncher.sheet.O, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) throws Resources.NotFoundException {
        super.onWindowFocusChanged(hasFocus);
        this.mainHandler.removeCallbacks(this.clearCoveredRunnable);
        N4("onWindowFocus hasFocus=" + hasFocus);
        if (hasFocus) {
            if (this.coveredByThirdParty && RecentsWindowMonitor.INSTANCE.h() != RecentsWindowMonitor.RecentsState.IDLE) {
                J4(false);
            } else {
                W4();
                this.mainHandler.postDelayed(this.clearCoveredRunnable, 300L);
            }
        }
    }

    @Override // com.stepos.ailauncher.sheet.S
    public Fragment s4() {
        return AmooStoreFragment.INSTANCE.a();
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean t3() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public SheetExitAnim x1() {
        return SheetExitAnim.SLIDE_DOWN;
    }

    @Override // com.stepos.ailauncher.sheet.S
    public void y4(Bundle savedInstanceState) {
        t4().I(com.stepos.ailauncher.sheet.nav.c.INSTANCE.b());
        M1().setPadding(0, 0, 0, M1().getPaddingBottom());
        Y1().setBackgroundResource(R$drawable.bg_amoo_store_panel);
    }

    @Override // com.stepos.ailauncher.sheet.S
    public String z4() {
        return AmooStoreFragment.TAG;
    }
}
