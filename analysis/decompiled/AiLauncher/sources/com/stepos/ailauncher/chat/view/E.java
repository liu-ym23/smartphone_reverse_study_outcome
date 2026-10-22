package com.stepos.ailauncher.chat.view;

import android.view.InterfaceC1387e;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.view.Z;
import androidx.core.view.a0;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.R$dimen;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010 \u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/chat/view/E;", "Landroidx/lifecycle/e;", "Landroid/view/View;", Parameters.ROOT, "Landroid/widget/EditText;", "input", "bottomBar", "hints", "Landroidx/lifecycle/LifecycleOwner;", "owner", "<init>", "(Landroid/view/View;Landroid/widget/EditText;Landroid/view/View;Landroid/view/View;Landroidx/lifecycle/LifecycleOwner;)V", "LY8/t;", "p", "()V", "r", "onDestroy", "(Landroidx/lifecycle/LifecycleOwner;)V", "t", "", "visible", "o", "(Z)V", "Landroid/view/View;", "Landroid/widget/EditText;", "", "restMargin", "I", "disposed", "Z", "guideRestHeight", "imeVisible", "requestingKeyboard", "Landroid/view/View$OnLayoutChangeListener;", "hintLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "Ljava/lang/Runnable;", "focusRequest", "Ljava/lang/Runnable;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class E implements InterfaceC1387e {
    private final View bottomBar;
    private boolean disposed;
    private final Runnable focusRequest;
    private int guideRestHeight;
    private final View.OnLayoutChangeListener hintLayoutListener;
    private final View hints;
    private boolean imeVisible;
    private final EditText input;
    private boolean requestingKeyboard;
    private final int restMargin;
    private final View root;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/chat/view/E$a", "Landroidx/core/view/Z$b;", "Landroidx/core/view/a0;", "insets", "", "Landroidx/core/view/Z;", "runningAnimations", Const.INTENT_KEY_UMID, "(Landroidx/core/view/a0;Ljava/util/List;)Landroidx/core/view/a0;", "animation", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroidx/core/view/Z;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends Z.b {
        public a() {
            super(1);
        }

        @Override // androidx.core.view.Z.b
        public void b(androidx.core.view.Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.d() & a0.o.b()) != 0) {
                E e10 = E.this;
                androidx.core.view.a0 a0VarB = androidx.core.view.N.B(e10.root);
                boolean z10 = false;
                if (a0VarB != null && a0VarB.r(a0.o.b())) {
                    z10 = true;
                }
                e10.o(z10);
            }
        }

        @Override // androidx.core.view.Z.b
        public androidx.core.view.a0 d(androidx.core.view.a0 insets, List<androidx.core.view.Z> runningAnimations) {
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            List<androidx.core.view.Z> list = runningAnimations;
            if ((list instanceof Collection) && list.isEmpty()) {
                return insets;
            }
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if ((((androidx.core.view.Z) it.next()).d() & a0.o.b()) != 0) {
                    E.this.o(insets.f(a0.o.b()).f41980d > 0);
                }
            }
            return insets;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements View.OnLayoutChangeListener {
        public b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            if (!E.this.disposed && E.this.input.isAttachedToWindow() && E.this.requestingKeyboard) {
                if (E.this.guideRestHeight == 0) {
                    E e10 = E.this;
                    e10.guideRestHeight = e10.hints.getHeight();
                }
                E.this.input.requestFocus();
                E.this.o(true);
                com.stepos.ailauncher.chat.util.t.b(E.this.input);
            }
        }
    }

    public E(View root, EditText input, View bottomBar, View hints, LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(root, "root");
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(bottomBar, "bottomBar");
        kotlin.jvm.internal.p.i(hints, "hints");
        kotlin.jvm.internal.p.i(owner, "owner");
        this.root = root;
        this.input = input;
        this.bottomBar = bottomBar;
        this.hints = hints;
        ViewGroup.LayoutParams layoutParams = bottomBar.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        this.restMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.view.B
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                E.s(this.f25712a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.hintLayoutListener = onLayoutChangeListener;
        this.focusRequest = new Runnable() { // from class: com.stepos.ailauncher.chat.view.C
            @Override // java.lang.Runnable
            public final void run() {
                E.q(this.f25724a);
            }
        };
        owner.getLifecycle().a(this);
        hints.addOnLayoutChangeListener(onLayoutChangeListener);
        androidx.core.view.N.u0(root, new androidx.core.view.A() { // from class: com.stepos.ailauncher.chat.view.D
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return E.e(this.f25740a, view, a0Var);
            }
        });
        androidx.core.view.N.E0(root, new a());
    }

    public static final androidx.core.view.a0 e(E e10, View view, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        e10.o(insets.r(a0.o.b()));
        return insets;
    }

    public static final void q(E e10) {
        if (e10.disposed || !e10.input.isAttachedToWindow()) {
            return;
        }
        View view = e10.hints;
        if (!view.isLaidOut() || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(e10.new b());
            return;
        }
        if (!e10.disposed && e10.input.isAttachedToWindow() && e10.requestingKeyboard) {
            if (e10.guideRestHeight == 0) {
                e10.guideRestHeight = e10.hints.getHeight();
            }
            e10.input.requestFocus();
            e10.o(true);
            com.stepos.ailauncher.chat.util.t.b(e10.input);
        }
    }

    public static final void s(E e10, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        e10.t();
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void b(LifecycleOwner lifecycleOwner) {
        super.b(lifecycleOwner);
    }

    public final void o(boolean visible) {
        this.imeVisible = visible;
        ViewGroup.LayoutParams layoutParams = this.bottomBar.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int dimensionPixelSize = visible ? this.bottomBar.getResources().getDimensionPixelSize(R$dimen.ail_sheet_keyboard_gap) : this.restMargin;
        if (marginLayoutParams.bottomMargin == dimensionPixelSize) {
            return;
        }
        marginLayoutParams.bottomMargin = dimensionPixelSize;
        this.bottomBar.setLayoutParams(marginLayoutParams);
    }

    @Override // android.view.InterfaceC1387e
    public void onDestroy(LifecycleOwner owner) {
        kotlin.jvm.internal.p.i(owner, "owner");
        this.disposed = true;
        this.requestingKeyboard = false;
        this.hints.removeOnLayoutChangeListener(this.hintLayoutListener);
        this.input.removeCallbacks(this.focusRequest);
        androidx.core.view.N.u0(this.root, null);
        androidx.core.view.N.E0(this.root, null);
        owner.getLifecycle().d(this);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onPause(LifecycleOwner lifecycleOwner) {
        super.onPause(lifecycleOwner);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart(lifecycleOwner);
    }

    @Override // android.view.InterfaceC1387e
    public /* bridge */ void onStop(LifecycleOwner lifecycleOwner) {
        super.onStop(lifecycleOwner);
    }

    public final void p() {
        this.requestingKeyboard = true;
        this.input.removeCallbacks(this.focusRequest);
        this.input.post(this.focusRequest);
    }

    public final void r() {
        this.requestingKeyboard = false;
        this.input.removeCallbacks(this.focusRequest);
        com.stepos.ailauncher.chat.util.t.a(this.input);
    }

    public final void t() {
        if (this.hints.getHeight() <= 0) {
            return;
        }
        if (this.guideRestHeight == 0 || (!this.imeVisible && !this.requestingKeyboard && this.hints.getHeight() > this.guideRestHeight)) {
            this.guideRestHeight = this.hints.getHeight();
        }
        this.hints.setTranslationY((this.guideRestHeight - r0.getHeight()) / 2.0f);
    }
}
