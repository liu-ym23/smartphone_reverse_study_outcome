package com.stepos.ailauncher.oobe;

import Ua.C1060i;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.Z;
import androidx.core.view.a0;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.oobe.SdkInitUserActivity;
import com.stepos.widget.R;
import com.stepos.widget.toolbar.StepOSTitleBar;
import f6.C4059a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 N2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r*\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u0015\u0010\u0019\u001a\u00020\u0018*\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u001f\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u0019\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001dH\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010\u0003J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010\u0003J\u001f\u00101\u001a\u00020\u00182\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u0019\u00105\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u000103H\u0014¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00182\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0004H\u0014¢\u0006\u0004\b9\u0010\u0003J\u000f\u0010:\u001a\u00020\u0004H\u0014¢\u0006\u0004\b:\u0010\u0003R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00101R\u0016\u0010B\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00101R\u0016\u0010C\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00101R\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u00101¨\u0006P"}, d2 = {"Lcom/stepos/ailauncher/oobe/SdkInitUserActivity;", "Lcom/stepos/ailauncher/oobe/N;", "<init>", "()V", "LY8/t;", "initView", "j0", "", ChatTracker.STAGE_FULL, "n0", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "O", "(Le9/c;)Ljava/lang/Object;", "", "l0", "(Ljava/lang/String;)Ljava/util/List;", "N", "e0", "f0", "R", "M", "o0", "i0", "Landroid/text/Editable;", "", "Y", "(Landroid/text/Editable;)Z", "P", "b0", "", "imeBottom", "navBottom", "a0", "(II)V", "p0", "text", "m0", "(Landroid/text/Editable;)V", "messageRes", "h0", "(I)V", "d0", "k0", "(Ljava/lang/String;)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/MotionEvent;", "ev", "Landroid/view/View;", "view", "Z", "(Landroid/view/MotionEvent;Landroid/view/View;)Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onResume", "onDestroy", "Lg6/e;", "binding", "Lg6/e;", "LUa/M;", "viewScope", "LUa/M;", "isKeyboardVisible", "imeAnimationRunning", "isNavigating", "", "lastSubmitFailToastAt", "J", "Landroid/widget/Toast;", "submitFailToast", "Landroid/widget/Toast;", "Lkotlinx/coroutines/g;", "hintTypingJob", "Lkotlinx/coroutines/g;", "textInputTracked", "Companion", Const.INTENT_KEY_APIKEY, "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SdkInitUserActivity extends N {
    private static final long HINT_DELETE_MS = 35;
    private static final long HINT_HOLD_MS = 1400;
    private static final long HINT_LOOP_GAP_MS = 400;
    private static final long HINT_TYPE_MS = 70;
    private static final int MAX_INPUT_LINES = 3;
    private static final long SUBMIT_FAIL_TOAST_INTERVAL_MS = 2000;
    private g6.e binding;
    private kotlinx.coroutines.g hintTypingJob;
    private boolean imeAnimationRunning;
    private boolean isKeyboardVisible;
    private boolean isNavigating;
    private long lastSubmitFailToastAt;
    private Toast submitFailToast;
    private boolean textInputTracked;
    private Ua.M viewScope;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/oobe/SdkInitUserActivity$b", "Landroidx/core/view/Z$b;", "Landroidx/core/view/Z;", "animation", "LY8/t;", "c", "(Landroidx/core/view/Z;)V", "Landroidx/core/view/a0;", "insets", "", "runningAnimations", Const.INTENT_KEY_UMID, "(Landroidx/core/view/a0;Ljava/util/List;)Landroidx/core/view/a0;", Const.INTENT_KEY_PKGNAME, "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends Z.b {
        public b() {
            super(1);
        }

        @Override // androidx.core.view.Z.b
        public void b(androidx.core.view.Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            super.b(animation);
            SdkInitUserActivity.this.imeAnimationRunning = false;
            g6.e eVar = SdkInitUserActivity.this.binding;
            if (eVar == null) {
                kotlin.jvm.internal.p.A("binding");
                eVar = null;
            }
            androidx.core.view.a0 a0VarB = androidx.core.view.N.B(eVar.b());
            if (a0VarB == null) {
                return;
            }
            int i10 = a0VarB.f(a0.o.g()).f41980d;
            SdkInitUserActivity.this.a0(a0VarB.f(a0.o.b()).f41980d, i10);
        }

        @Override // androidx.core.view.Z.b
        public void c(androidx.core.view.Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.d() & a0.o.b()) != 0) {
                SdkInitUserActivity.this.imeAnimationRunning = true;
            }
        }

        @Override // androidx.core.view.Z.b
        public androidx.core.view.a0 d(androidx.core.view.a0 insets, List<androidx.core.view.Z> runningAnimations) {
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            int i10 = insets.f(a0.o.g()).f41980d;
            SdkInitUserActivity.this.a0(insets.f(a0.o.b()).f41980d, i10);
            return insets;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/oobe/SdkInitUserActivity$c", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements TextWatcher {
        public c() {
        }

        public static final void b(SdkInitUserActivity sdkInitUserActivity) throws Resources.NotFoundException {
            sdkInitUserActivity.o0();
            sdkInitUserActivity.i0();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) throws Resources.NotFoundException {
            SdkInitUserActivity.this.p0();
            SdkInitUserActivity.this.m0(s10);
            g6.e eVar = SdkInitUserActivity.this.binding;
            if (eVar == null) {
                kotlin.jvm.internal.p.A("binding");
                eVar = null;
            }
            EditText etUser = eVar.etUser;
            kotlin.jvm.internal.p.h(etUser, "etUser");
            if (etUser.getLayout() != null) {
                SdkInitUserActivity.this.o0();
                SdkInitUserActivity.this.i0();
            } else {
                final SdkInitUserActivity sdkInitUserActivity = SdkInitUserActivity.this;
                etUser.post(new Runnable() { // from class: com.stepos.ailauncher.oobe.H0
                    @Override // java.lang.Runnable
                    public final void run() throws Resources.NotFoundException {
                        SdkInitUserActivity.c.b(sdkInitUserActivity);
                    }
                });
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    private final void M() {
        int iC = androidx.core.content.a.c(this, R$color.oobe_dark_bg);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(iC);
        getWindow().setNavigationBarColor(iC);
        androidx.core.view.b0 b0Var = new androidx.core.view.b0(getWindow(), getWindow().getDecorView());
        b0Var.e(false);
        b0Var.d(false);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() & (-8209));
        com.stepos.ailauncher.common.utils.H.c(getWindow(), false);
    }

    public static final boolean Q(View view, MotionEvent motionEvent) {
        if (view.canScrollVertically(1) || view.canScrollVertically(-1)) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 1 || actionMasked == 3) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return false;
    }

    public static final void S(SdkInitUserActivity sdkInitUserActivity) {
        InputMethodManager inputMethodManager = (InputMethodManager) sdkInitUserActivity.getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            g6.e eVar = sdkInitUserActivity.binding;
            if (eVar == null) {
                kotlin.jvm.internal.p.A("binding");
                eVar = null;
            }
            inputMethodManager.showSoftInput(eVar.etUser, 1);
        }
    }

    private final void T() {
        g6.e eVar = this.binding;
        g6.e eVar2 = null;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar = null;
        }
        eVar.etUser.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            g6.e eVar3 = this.binding;
            if (eVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                eVar2 = eVar3;
            }
            inputMethodManager.hideSoftInputFromWindow(eVar2.b().getWindowToken(), 0);
        }
    }

    public static final void U(SdkInitUserActivity sdkInitUserActivity, View view) {
        sdkInitUserActivity.R();
    }

    public static final void V(SdkInitUserActivity sdkInitUserActivity, View view) {
        C4059a.e(C4059a.INSTANCE, C4059a.STEP_PREFERENCE, "back", null, 4, null);
        sdkInitUserActivity.finish();
    }

    public static final void W(SdkInitUserActivity sdkInitUserActivity, View view) {
        C4059a.e(C4059a.INSTANCE, C4059a.STEP_PREFERENCE, "skip", null, 4, null);
        sdkInitUserActivity.startActivity(new Intent(sdkInitUserActivity, (Class<?>) AgentConfigActivity.class));
    }

    public static final void X(SdkInitUserActivity sdkInitUserActivity, View view) throws Resources.NotFoundException {
        sdkInitUserActivity.d0();
    }

    private final boolean Z(MotionEvent ev, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float rawX = ev.getRawX();
        float rawY = ev.getRawY();
        if (rawX >= iArr[0] && rawX <= r2 + view.getWidth()) {
            if (rawY >= iArr[1] && rawY <= r4 + view.getHeight()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(int imeBottom, int navBottom) {
        int iF = C5685n.f(imeBottom - navBottom, 0);
        g6.e eVar = this.binding;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar = null;
        }
        eVar.btnNext.setTranslationY(-iF);
    }

    private final void b0() {
        androidx.core.view.Y.b(getWindow(), false);
        g6.e eVar = this.binding;
        g6.e eVar2 = null;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar = null;
        }
        androidx.core.view.N.u0(eVar.b(), new androidx.core.view.A() { // from class: com.stepos.ailauncher.oobe.D0
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return SdkInitUserActivity.c0(this.f27536a, view, a0Var);
            }
        });
        g6.e eVar3 = this.binding;
        if (eVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar3 = null;
        }
        androidx.core.view.N.E0(eVar3.b(), new b());
        g6.e eVar4 = this.binding;
        if (eVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            eVar2 = eVar4;
        }
        androidx.core.view.N.e0(eVar2.b());
    }

    public static final androidx.core.view.a0 c0(SdkInitUserActivity sdkInitUserActivity, View view, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        int i10 = insets.f(a0.o.b()).f41980d;
        boolean zR = insets.r(a0.o.b());
        boolean z10 = sdkInitUserActivity.isKeyboardVisible && !zR;
        sdkInitUserActivity.isKeyboardVisible = zR;
        if (z10) {
            g6.e eVar = sdkInitUserActivity.binding;
            if (eVar == null) {
                kotlin.jvm.internal.p.A("binding");
                eVar = null;
            }
            eVar.etUser.clearFocus();
        }
        view.setPadding(view.getPaddingLeft(), eVarF.f41978b, view.getPaddingRight(), eVarF.f41980d);
        if (!sdkInitUserActivity.imeAnimationRunning) {
            sdkInitUserActivity.a0(i10, eVarF.f41980d);
        }
        return insets;
    }

    private final void d0() throws Resources.NotFoundException {
        g6.e eVar = this.binding;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar = null;
        }
        Editable text = eVar.etUser.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        if (La.H.x0(string)) {
            Toast.makeText(this, R$string.oobe_text_empty, 0).show();
        } else if (!this.isNavigating && System.currentTimeMillis() - this.lastSubmitFailToastAt >= 2000) {
            T();
            k0(string);
        }
    }

    private final void f0() {
        g6.e eVar = this.binding;
        g6.e eVar2 = null;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar = null;
        }
        eVar.etUser.requestFocus();
        g6.e eVar3 = this.binding;
        if (eVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            eVar2 = eVar3;
        }
        eVar2.etUser.post(new Runnable() { // from class: com.stepos.ailauncher.oobe.F0
            @Override // java.lang.Runnable
            public final void run() {
                SdkInitUserActivity.g0(this.f27539a);
            }
        });
    }

    public static final void g0(SdkInitUserActivity sdkInitUserActivity) {
        InputMethodManager inputMethodManager = (InputMethodManager) sdkInitUserActivity.getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            g6.e eVar = sdkInitUserActivity.binding;
            if (eVar == null) {
                kotlin.jvm.internal.p.A("binding");
                eVar = null;
            }
            inputMethodManager.showSoftInput(eVar.etUser, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(int messageRes) throws Resources.NotFoundException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastSubmitFailToastAt < 2000) {
            return;
        }
        this.lastSubmitFailToastAt = jCurrentTimeMillis;
        Toast toast = this.submitFailToast;
        if (toast != null) {
            toast.cancel();
        }
        Toast toastMakeText = Toast.makeText(this, messageRes, 0);
        toastMakeText.show();
        this.submitFailToast = toastMakeText;
    }

    private final void initView() throws Resources.NotFoundException {
        g6.e eVar = null;
        this.viewScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c()));
        M();
        P();
        b0();
        e0();
        f0();
        N();
        g6.e eVar2 = this.binding;
        if (eVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar2 = null;
        }
        eVar2.tvHint.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkInitUserActivity.U(this.f27649a, view);
            }
        });
        g6.e eVar3 = this.binding;
        if (eVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar3 = null;
        }
        eVar3.titleBar.addStartAction(R.drawable.stepos_icon_navigation_back, getString(R$string.oobe_back), new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.A0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkInitUserActivity.V(this.f27530a, view);
            }
        });
        g6.e eVar4 = this.binding;
        if (eVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar4 = null;
        }
        StepOSTitleBar stepOSTitleBar = eVar4.titleBar;
        String string = getString(R$string.oobe_skip);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        View childAt = stepOSTitleBar.addEndTextAction(string, new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.B0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkInitUserActivity.W(this.f27532a, view);
            }
        }).getChildAt(0);
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        if (textView != null) {
            textView.setTextColor(androidx.core.content.a.c(this, R$color.oobe_agreement_text_primary));
        }
        g6.e eVar5 = this.binding;
        if (eVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            eVar = eVar5;
        }
        eVar.btnNext.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.C0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                SdkInitUserActivity.X(this.f27534a, view);
            }
        });
        j0();
    }

    private final void k0(String text) throws Resources.NotFoundException {
        if (!com.stepos.agentframework.chatcore.utils.n.INSTANCE.a(this)) {
            h0(R$string.oobe_network_unavailable);
            return;
        }
        this.isNavigating = true;
        Ua.M m10 = this.viewScope;
        if (m10 != null) {
            C1060i.d(m10, null, null, new SdkInitUserActivity$textSecurityCheck$1(text, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(Editable text) {
        if (this.textInputTracked || text == null || La.H.x0(text)) {
            return;
        }
        this.textInputTracked = true;
        C4059a.INSTANCE.f(C4059a.QUESTION_MORE, C4059a.ACTION_TEXT_INPUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0() {
        g6.e eVar = this.binding;
        g6.e eVar2 = null;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar = null;
        }
        ImageButton imageButton = eVar.btnNext;
        g6.e eVar3 = this.binding;
        if (eVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            eVar2 = eVar3;
        }
        Editable text = eVar2.etUser.getText();
        imageButton.setVisibility((text == null || La.H.x0(text)) ? 8 : 0);
    }

    public final void N() {
        g6.e eVar = this.binding;
        g6.e eVar2 = null;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar = null;
        }
        eVar.etUser.setTextCursorDrawable(R$drawable.oobe_name_system_cursor);
        g6.e eVar3 = this.binding;
        if (eVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            eVar2 = eVar3;
        }
        eVar2.etUser.setCursorVisible(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O(e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.stepos.ailauncher.oobe.SdkInitUserActivity$deleteHint$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.ailauncher.oobe.SdkInitUserActivity$deleteHint$1 r0 = (com.stepos.ailauncher.oobe.SdkInitUserActivity$deleteHint$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.oobe.SdkInitUserActivity$deleteHint$1 r0 = new com.stepos.ailauncher.oobe.SdkInitUserActivity$deleteHint$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            java.lang.String r3 = "binding"
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.C4849c.b(r9)
            r9 = r2
            goto L56
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            kotlin.C4849c.b(r9)
            g6.e r9 = r8.binding
            if (r9 != 0) goto L44
            kotlin.jvm.internal.p.A(r3)
            r9 = r5
        L44:
            android.widget.TextView r9 = r9.tvHint
            java.lang.CharSequence r9 = r9.getText()
            if (r9 == 0) goto L51
            java.lang.String r9 = r9.toString()
            goto L52
        L51:
            r9 = r5
        L52:
            if (r9 != 0) goto L56
            java.lang.String r9 = ""
        L56:
            int r2 = r9.length()
            if (r2 <= 0) goto L8c
            int r2 = r9.length()
            r6 = -1
            int r2 = r9.offsetByCodePoints(r2, r6)
            r6 = 0
            java.lang.String r9 = r9.substring(r6, r2)
            java.lang.String r6 = "substring(...)"
            kotlin.jvm.internal.p.h(r9, r6)
            g6.e r6 = r8.binding
            if (r6 != 0) goto L78
            kotlin.jvm.internal.p.A(r3)
            r6 = r5
        L78:
            android.widget.TextView r6 = r6.tvHint
            r6.setText(r9)
            r0.L$0 = r9
            r0.I$0 = r2
            r0.label = r4
            r6 = 35
            java.lang.Object r2 = Ua.U.a(r6, r0)
            if (r2 != r1) goto L56
            return r1
        L8c:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.oobe.SdkInitUserActivity.O(e9.c):java.lang.Object");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void P() {
        g6.e eVar = this.binding;
        g6.e eVar2 = null;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar = null;
        }
        eVar.etUser.setMaxLines(3);
        g6.e eVar3 = this.binding;
        if (eVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar3 = null;
        }
        eVar3.etUser.setHorizontallyScrolling(false);
        g6.e eVar4 = this.binding;
        if (eVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            eVar2 = eVar4;
        }
        eVar2.etUser.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.oobe.E0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return SdkInitUserActivity.Q(view, motionEvent);
            }
        });
    }

    public final void R() {
        g6.e eVar = this.binding;
        g6.e eVar2 = null;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar = null;
        }
        eVar.etUser.requestFocus();
        g6.e eVar3 = this.binding;
        if (eVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            eVar2 = eVar3;
        }
        eVar2.etUser.post(new Runnable() { // from class: com.stepos.ailauncher.oobe.G0
            @Override // java.lang.Runnable
            public final void run() {
                SdkInitUserActivity.S(this.f27541a);
            }
        });
    }

    public final boolean Y(Editable editable) {
        return editable != null && BaseInputConnection.getComposingSpanStart(editable) >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    @Override // android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.p.i(r5, r0)
            int r0 = r5.getAction()
            if (r0 != 0) goto L55
            boolean r0 = r4.isKeyboardVisible
            if (r0 == 0) goto L55
            g6.e r0 = r4.binding
            r1 = 0
            java.lang.String r2 = "binding"
            if (r0 != 0) goto L1a
            kotlin.jvm.internal.p.A(r2)
            r0 = r1
        L1a:
            android.widget.FrameLayout r0 = r0.inputBlock
            java.lang.String r3 = "inputBlock"
            kotlin.jvm.internal.p.h(r0, r3)
            boolean r0 = r4.Z(r5, r0)
            g6.e r3 = r4.binding
            if (r3 != 0) goto L2d
            kotlin.jvm.internal.p.A(r2)
            r3 = r1
        L2d:
            android.widget.ImageButton r3 = r3.btnNext
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L4d
            g6.e r3 = r4.binding
            if (r3 != 0) goto L3d
            kotlin.jvm.internal.p.A(r2)
            goto L3e
        L3d:
            r1 = r3
        L3e:
            android.widget.ImageButton r1 = r1.btnNext
            java.lang.String r2 = "btnNext"
            kotlin.jvm.internal.p.h(r1, r2)
            boolean r1 = r4.Z(r5, r1)
            if (r1 == 0) goto L4d
            r1 = 1
            goto L4e
        L4d:
            r1 = 0
        L4e:
            if (r0 != 0) goto L55
            if (r1 != 0) goto L55
            r4.T()
        L55:
            boolean r4 = super.dispatchTouchEvent(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.oobe.SdkInitUserActivity.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void e0() {
        g6.e eVar = this.binding;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar = null;
        }
        eVar.etUser.addTextChangedListener(new c());
    }

    public final void i0() throws Resources.NotFoundException {
        g6.e eVar = this.binding;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar = null;
        }
        EditText etUser = eVar.etUser;
        kotlin.jvm.internal.p.h(etUser, "etUser");
        Layout layout = etUser.getLayout();
        if (layout == null) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.oobe_user_input_max_height);
        ViewGroup.LayoutParams layoutParams = etUser.getLayoutParams();
        if (layout.getLineCount() >= 3) {
            if (layoutParams.height != dimensionPixelSize) {
                layoutParams.height = dimensionPixelSize;
                etUser.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        if (Y(etUser.getEditableText()) || layoutParams.height == -2) {
            return;
        }
        layoutParams.height = -2;
        etUser.setLayoutParams(layoutParams);
    }

    public final void j0() throws Resources.NotFoundException {
        String[] stringArray = getResources().getStringArray(R$array.oobe_sdk_init_user_hints);
        kotlin.jvm.internal.p.h(stringArray, "getStringArray(...)");
        ArrayList arrayList = new ArrayList();
        for (String str : stringArray) {
            kotlin.jvm.internal.p.f(str);
            if (str.length() > 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        g6.e eVar = this.binding;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar = null;
        }
        eVar.tvHint.setText("");
        kotlinx.coroutines.g gVar = this.hintTypingJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        Ua.M m10 = this.viewScope;
        this.hintTypingJob = m10 != null ? C1060i.d(m10, null, null, new SdkInitUserActivity$startHintTypewriter$1(this, arrayList, null), 3, null) : null;
    }

    public final List<String> l0(String str) {
        ArrayList arrayList = new ArrayList(str.length());
        int i10 = 0;
        while (i10 < str.length()) {
            int iCharCount = Character.charCount(Character.codePointAt(str, i10)) + i10;
            String strSubstring = str.substring(i10, iCharCount);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            arrayList.add(strSubstring);
            i10 = iCharCount;
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n0(java.lang.String r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.stepos.ailauncher.oobe.SdkInitUserActivity$typeHint$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.ailauncher.oobe.SdkInitUserActivity$typeHint$1 r0 = (com.stepos.ailauncher.oobe.SdkInitUserActivity$typeHint$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.oobe.SdkInitUserActivity$typeHint$1 r0 = new com.stepos.ailauncher.oobe.SdkInitUserActivity$typeHint$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r9 = r0.L$4
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r0.L$3
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r2 = r0.L$2
            java.lang.StringBuilder r2 = (java.lang.StringBuilder) r2
            java.lang.Object r4 = r0.L$1
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r10)
            r10 = r5
            goto L5a
        L3e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L46:
            kotlin.C4849c.b(r10)
            java.util.List r10 = r8.l0(r9)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.util.Iterator r4 = r10.iterator()
            r7 = r10
            r10 = r9
            r9 = r4
            r4 = r7
        L5a:
            boolean r5 = r9.hasNext()
            if (r5 == 0) goto L99
            java.lang.Object r5 = r9.next()
            java.lang.String r5 = (java.lang.String) r5
            r2.append(r5)
            g6.e r6 = r8.binding
            if (r6 != 0) goto L73
            java.lang.String r6 = "binding"
            kotlin.jvm.internal.p.A(r6)
            r6 = 0
        L73:
            android.widget.TextView r6 = r6.tvHint
            r6.setText(r2)
            java.lang.Object r6 = g9.h.a(r10)
            r0.L$0 = r6
            java.lang.Object r6 = g9.h.a(r4)
            r0.L$1 = r6
            r0.L$2 = r2
            r0.L$3 = r9
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$4 = r5
            r0.label = r3
            r5 = 70
            java.lang.Object r5 = Ua.U.a(r5, r0)
            if (r5 != r1) goto L5a
            return r1
        L99:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.oobe.SdkInitUserActivity.n0(java.lang.String, e9.c):java.lang.Object");
    }

    public final void o0() {
        int lineCount;
        g6.e eVar = this.binding;
        if (eVar == null) {
            kotlin.jvm.internal.p.A("binding");
            eVar = null;
        }
        EditText etUser = eVar.etUser;
        kotlin.jvm.internal.p.h(etUser, "etUser");
        Layout layout = etUser.getLayout();
        if (layout != null && (lineCount = layout.getLineCount()) >= 1) {
            if (!Y(etUser.getEditableText()) || lineCount > 1) {
                int i10 = lineCount > 1 ? 8388659 : 17;
                if (etUser.getGravity() != i10) {
                    etUser.setGravity(i10);
                }
            }
        }
    }

    @Override // com.stepos.ailauncher.oobe.N, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        super.onCreate(savedInstanceState);
        C4059a.INSTANCE.g(C4059a.STEP_PREFERENCE, getString(R$string.oobe_sdk_init_user_question));
        g6.e eVarC = g6.e.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(eVarC, "inflate(...)");
        this.binding = eVarC;
        if (eVarC == null) {
            kotlin.jvm.internal.p.A("binding");
            eVarC = null;
        }
        setContentView(eVarC.b());
        initView();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        kotlinx.coroutines.g gVar = this.hintTypingJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        Ua.M m10 = this.viewScope;
        if (m10 != null) {
            kotlinx.coroutines.d.e(m10, null, 1, null);
        }
        this.viewScope = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isNavigating = false;
    }
}
