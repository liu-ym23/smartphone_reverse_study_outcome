package com.stepos.ailauncher.chat.input.controller;

import android.util.Log;
import android.view.View;
import androidx.core.view.N;
import androidx.core.view.Z;
import androidx.core.view.a0;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.input.controller.I;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import q5.C5155a;
import v9.C5685n;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u00010B\u009b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\"\b\u0002\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001aR(\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001aR.\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001bR\"\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\"\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR$\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010\"\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\u001fR\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010,¨\u00061"}, d2 = {"Lcom/stepos/ailauncher/chat/input/controller/I;", "", "Landroid/view/View;", "hostView", "Lkotlin/Function2;", "", "", "LY8/t;", "onKeyboardChange", "onImeAnimationStart", "Lkotlin/Function3;", "", "onImeAnimationProgress", "Lkotlin/Function1;", "onImeRawProgress", "onImeStateReconciled", "<init>", "(Landroid/view/View;Lp9/p;Lp9/p;Lp9/q;Lp9/l;Lp9/l;)V", "q", "()V", "v", "shown", "bottomInset", "t", "(ZI)V", "Landroid/view/View;", "Lp9/p;", "Lp9/q;", "Lp9/l;", UxipConstants.f30680s, "isKeyboardShown", "Z", "u", "()Z", "lastImeEndWasHideOfVisibleIme", "getLastImeEndWasHideOfVisibleIme", "attached", "Landroidx/core/view/Z;", "activeImeAnimation", "Landroidx/core/view/Z;", "Ljava/lang/Runnable;", "reconcileWithoutAnimation", "Ljava/lang/Runnable;", "imeMaxPx", "I", "imeShowing", "cancelledShowEndGeneration", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class I {
    private static final String TAG = "KeyboardInsetsHelper";
    private Z activeImeAnimation;
    private boolean attached;
    private int cancelledShowEndGeneration;
    private final View hostView;
    private int imeMaxPx;
    private boolean imeShowing;
    private boolean isKeyboardShown;
    private boolean lastImeEndWasHideOfVisibleIme;
    private final p9.q<Float, Integer, Boolean, Y8.t> onImeAnimationProgress;
    private final p9.p<Boolean, Integer, Y8.t> onImeAnimationStart;
    private final InterfaceC5074l<Float, Y8.t> onImeRawProgress;
    private final InterfaceC5074l<Boolean, Y8.t> onImeStateReconciled;
    private final p9.p<Boolean, Integer, Y8.t> onKeyboardChange;
    private final Runnable reconcileWithoutAnimation;

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"com/stepos/ailauncher/chat/input/controller/I$b", "Landroidx/core/view/Z$b;", "Landroidx/core/view/Z;", "animation", "LY8/t;", "c", "(Landroidx/core/view/Z;)V", "Landroidx/core/view/a0;", "insets", "", "runningAnimations", Const.INTENT_KEY_UMID, "(Landroidx/core/view/a0;Ljava/util/List;)Landroidx/core/view/a0;", "Landroidx/core/view/Z$a;", "bounds", "e", "(Landroidx/core/view/Z;Landroidx/core/view/Z$a;)Landroidx/core/view/Z$a;", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends Z.b {
        public b() {
            super(0);
        }

        public static final void h(final I i10, final int i11) {
            i10.hostView.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.chat.input.controller.K
                @Override // java.lang.Runnable
                public final void run() {
                    I.b.i(i11, i10);
                }
            });
        }

        public static final void i(int i10, I i11) {
            t0.e eVarF;
            if (i10 != i11.cancelledShowEndGeneration) {
                return;
            }
            a0 a0VarB = N.B(i11.hostView);
            int i12 = (a0VarB == null || (eVarF = a0VarB.f(a0.o.b())) == null) ? 0 : eVarF.f41980d;
            i11.t(i12 > 0, i12);
        }

        @Override // androidx.core.view.Z.b
        public void b(Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.d() & a0.o.b()) == 0) {
                super.b(animation);
                return;
            }
            if (I.this.activeImeAnimation != animation) {
                return;
            }
            I.this.activeImeAnimation = null;
            Log.d(I.TAG, "insets onEnd");
            super.b(animation);
            a0 a0VarB = N.B(I.this.hostView);
            if (a0VarB == null) {
                return;
            }
            int i10 = a0VarB.f(a0.o.b()).f41980d;
            boolean z10 = i10 > 0;
            if (z10 || !I.this.imeShowing) {
                I.this.cancelledShowEndGeneration++;
                I.this.t(z10, i10);
                return;
            }
            I.this.cancelledShowEndGeneration++;
            final int i11 = I.this.cancelledShowEndGeneration;
            Log.d(I.TAG, "insets onEnd deferred (show cancelled, bottom=0)");
            View view = I.this.hostView;
            final I i12 = I.this;
            view.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.chat.input.controller.J
                @Override // java.lang.Runnable
                public final void run() {
                    I.b.h(i12, i11);
                }
            });
        }

        @Override // androidx.core.view.Z.b
        public void c(Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.d() & a0.o.b()) != 0) {
                I.this.activeImeAnimation = animation;
                I.this.cancelledShowEndGeneration++;
            }
        }

        @Override // androidx.core.view.Z.b
        public a0 d(a0 insets, List<Z> runningAnimations) {
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            Z z10 = I.this.activeImeAnimation;
            if (z10 != null) {
                List<Z> list = runningAnimations;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (((Z) it.next()) == z10) {
                            InterfaceC5074l interfaceC5074l = I.this.onImeRawProgress;
                            if (interfaceC5074l != null) {
                                interfaceC5074l.invoke(Float.valueOf(z10.b()));
                            }
                        }
                    }
                }
            }
            if (I.this.onImeAnimationProgress != null && I.this.imeMaxPx > 0) {
                int i10 = insets.f(a0.o.b()).f41980d;
                float fM = C5685n.m(i10 / I.this.imeMaxPx, 0.0f, 1.0f);
                C5155a c5155a = C5155a.INSTANCE;
                I i11 = I.this;
                if (C5155a.enabled) {
                    C4148a.d(C5155a.TAG, "[IME_PROGRESS] bottom=" + i10 + " imeMax=" + i11.imeMaxPx + " fraction=" + fM + " showing=" + i11.imeShowing, false, 4, null);
                }
                I.this.onImeAnimationProgress.invoke(Float.valueOf(fM), Integer.valueOf(i10), Boolean.valueOf(I.this.imeShowing));
            }
            return insets;
        }

        @Override // androidx.core.view.Z.b
        public Z.a e(Z animation, Z.a bounds) {
            t0.e eVarF;
            kotlin.jvm.internal.p.i(animation, "animation");
            kotlin.jvm.internal.p.i(bounds, "bounds");
            if ((animation.d() & a0.o.b()) == 0) {
                Z.a aVarE = super.e(animation, bounds);
                kotlin.jvm.internal.p.h(aVarE, "onStart(...)");
                return aVarE;
            }
            I.this.imeMaxPx = Math.max(bounds.a().f41980d, bounds.b().f41980d);
            I.this.activeImeAnimation = animation;
            a0 a0VarB = N.B(I.this.hostView);
            int i10 = (a0VarB == null || (eVarF = a0VarB.f(a0.o.b())) == null) ? 0 : eVarF.f41980d;
            I.this.imeShowing = i10 > 0;
            I.this.cancelledShowEndGeneration++;
            Log.d(I.TAG, "insets onStart showing=" + I.this.imeShowing + " imeMax=" + I.this.imeMaxPx + " targetImeBottom=" + i10 + " duration=" + animation.a());
            C5155a c5155a = C5155a.INSTANCE;
            I i11 = I.this;
            if (C5155a.enabled) {
                C4148a.k(C5155a.TAG, "[IME_START] showing=" + i11.imeShowing + " imeMax=" + i11.imeMaxPx + " targetImeBottom=" + i10 + " boundsLower=" + bounds.a().f41980d + " boundsUpper=" + bounds.b().f41980d + " duration=" + animation.a(), false, 4, null);
            }
            p9.p pVar = I.this.onImeAnimationStart;
            if (pVar != null) {
                pVar.invoke(Boolean.valueOf(I.this.imeShowing), Integer.valueOf(I.this.imeMaxPx));
            }
            Z.a aVarE2 = super.e(animation, bounds);
            kotlin.jvm.internal.p.h(aVarE2, "onStart(...)");
            return aVarE2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public I(View hostView, p9.p<? super Boolean, ? super Integer, Y8.t> onKeyboardChange, p9.p<? super Boolean, ? super Integer, Y8.t> pVar, p9.q<? super Float, ? super Integer, ? super Boolean, Y8.t> qVar, InterfaceC5074l<? super Float, Y8.t> interfaceC5074l, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l2) {
        kotlin.jvm.internal.p.i(hostView, "hostView");
        kotlin.jvm.internal.p.i(onKeyboardChange, "onKeyboardChange");
        this.hostView = hostView;
        this.onKeyboardChange = onKeyboardChange;
        this.onImeAnimationStart = pVar;
        this.onImeAnimationProgress = qVar;
        this.onImeRawProgress = interfaceC5074l;
        this.onImeStateReconciled = interfaceC5074l2;
        this.reconcileWithoutAnimation = new Runnable() { // from class: com.stepos.ailauncher.chat.input.controller.F
            @Override // java.lang.Runnable
            public final void run() {
                I.w(this.f25379a);
            }
        };
    }

    public static final a0 r(I i10, View view, a0 insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        i10.hostView.removeCallbacks(i10.reconcileWithoutAnimation);
        if (i10.activeImeAnimation == null) {
            i10.hostView.post(i10.reconcileWithoutAnimation);
        }
        return insets;
    }

    public static final void s(I i10) {
        N.e0(i10.hostView);
    }

    public static final void w(I i10) {
        a0 a0VarB;
        if (i10.attached && i10.hostView.isAttachedToWindow() && i10.activeImeAnimation == null && (a0VarB = N.B(i10.hostView)) != null) {
            int i11 = a0VarB.f(a0.o.b()).f41980d;
            if ((i11 > 0) != i10.isKeyboardShown) {
                boolean z10 = i11 > 0;
                i10.isKeyboardShown = z10;
                InterfaceC5074l<Boolean, Y8.t> interfaceC5074l = i10.onImeStateReconciled;
                if (interfaceC5074l != null) {
                    interfaceC5074l.invoke(Boolean.valueOf(z10));
                }
            }
        }
    }

    public final void q() {
        if (this.attached) {
            return;
        }
        this.attached = true;
        N.E0(this.hostView, new b());
        N.u0(this.hostView, new androidx.core.view.A() { // from class: com.stepos.ailauncher.chat.input.controller.G
            @Override // androidx.core.view.A
            public final a0 a(View view, a0 a0Var) {
                return I.r(this.f25380a, view, a0Var);
            }
        });
        this.hostView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.input.controller.H
            @Override // java.lang.Runnable
            public final void run() {
                I.s(this.f25381a);
            }
        });
    }

    public final void t(boolean shown, int bottomInset) {
        this.isKeyboardShown = shown;
        if (shown) {
            Log.i(TAG, "keyboard show, height: " + bottomInset);
        } else {
            Log.i(TAG, "keyboard hide");
        }
        C5155a c5155a = C5155a.INSTANCE;
        if (C5155a.enabled) {
            C4148a.k(C5155a.TAG, "[IME_END] shown=" + this.isKeyboardShown + " bottomInset=" + bottomInset, false, 4, null);
        }
        this.lastImeEndWasHideOfVisibleIme = (shown || this.imeShowing || this.imeMaxPx <= 0) ? false : true;
        this.onKeyboardChange.invoke(Boolean.valueOf(shown), Integer.valueOf(bottomInset));
        this.lastImeEndWasHideOfVisibleIme = false;
        if (this.onImeAnimationProgress != null && this.imeMaxPx > 0) {
            float f10 = shown ? 1.0f : 0.0f;
            if (C5155a.enabled) {
                C4148a.k(C5155a.TAG, "[IME_END_FINAL] force fraction=" + f10 + " showing=" + shown, false, 4, null);
            }
            this.onImeAnimationProgress.invoke(Float.valueOf(f10), Integer.valueOf(bottomInset), Boolean.valueOf(shown));
        }
        this.imeMaxPx = 0;
    }

    /* renamed from: u, reason: from getter */
    public final boolean getIsKeyboardShown() {
        return this.isKeyboardShown;
    }

    public final void v() {
        a0 a0VarB = N.B(this.hostView);
        if (a0VarB == null) {
            return;
        }
        int i10 = a0VarB.f(a0.o.b()).f41980d;
        boolean z10 = i10 > 0;
        boolean z11 = this.isKeyboardShown;
        if (z10 == z11) {
            return;
        }
        if (!z10 && z11 && this.imeMaxPx > 0) {
            Log.i(TAG, "reconcileKeyboardShownFromInsets skip snap during ime animation showing=" + this.imeShowing + " bottomInset=" + i10);
            return;
        }
        Log.i(TAG, "reconcileKeyboardShownFromInsets: corrected " + z11 + " -> " + z10 + " bottomInset=" + i10);
        this.isKeyboardShown = z10;
    }
}
