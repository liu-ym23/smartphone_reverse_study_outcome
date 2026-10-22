package com.stepos.ailauncher.oobe;

import Ua.C1060i;
import Z8.C1168p;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.Z;
import androidx.core.view.a0;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.widget.R;
import com.stepos.widget.toolbar.StepOSTitleBar;
import f6.C4059a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 N2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J'\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u001f\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0003J\u0019\u0010#\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u0003J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010\u0003J\u001f\u0010/\u001a\u00020.2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0004H\u0002¢\u0006\u0004\b1\u0010\u0003J\u0019\u00104\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000102H\u0014¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020.2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0004H\u0014¢\u0006\u0004\b8\u0010\u0003J\u000f\u00109\u001a\u00020\u0004H\u0014¢\u0006\u0004\b9\u0010\u0003R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010AR\u0016\u0010C\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010AR\u0016\u0010L\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010AR\u0016\u0010M\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010A¨\u0006P"}, d2 = {"Lcom/stepos/ailauncher/oobe/SdkInitNameActivity;", "Lcom/stepos/ailauncher/oobe/N;", "<init>", "()V", "LY8/t;", "initView", "M", "g0", "d0", "j0", "L", "Q", "N", "", "text", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "q0", "(Ljava/lang/CharSequence;II)I", "codePoint", "P", "(I)I", "l0", "messageRes", "m0", "(I)V", "a0", "imeBottom", "navBottom", "X", "(II)V", "p0", "f0", "Landroid/text/Editable;", "o0", "(Landroid/text/Editable;)V", "c0", "", "n0", "(Ljava/lang/String;)V", ExifInterface.LATITUDE_SOUTH, "Landroid/view/MotionEvent;", "ev", "Landroid/view/View;", "view", "", ExifInterface.LONGITUDE_WEST, "(Landroid/view/MotionEvent;Landroid/view/View;)Z", "Y", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onResume", "onDestroy", "Lg6/c;", "binding", "Lg6/c;", "LUa/M;", "viewScope", "LUa/M;", "isKeyboardVisible", "Z", "imeAnimationRunning", "isNavigating", "", "lastLengthLimitToastAt", "J", "lastSubmitFailToastAt", "Landroid/widget/Toast;", "submitFailToast", "Landroid/widget/Toast;", "pendingMicDeniedSkipToast", "suppressTextInputTrack", "textInputTracked", "Companion", Const.INTENT_KEY_APIKEY, "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SdkInitNameActivity extends N {
    public static final String EXTRA_MIC_DENIED_SKIP = "extra_mic_denied_skip";
    private static final long LENGTH_LIMIT_TOAST_INTERVAL_MS = 2000;
    private static final int MAX_NAME_LENGTH = 32;
    private g6.c binding;
    private boolean imeAnimationRunning;
    private boolean isKeyboardVisible;
    private boolean isNavigating;
    private long lastLengthLimitToastAt;
    private long lastSubmitFailToastAt;
    private boolean pendingMicDeniedSkipToast;
    private Toast submitFailToast;
    private boolean suppressTextInputTrack;
    private boolean textInputTracked;
    private Ua.M viewScope;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/oobe/SdkInitNameActivity$b", "Landroidx/core/view/Z$b;", "Landroidx/core/view/Z;", "animation", "LY8/t;", "c", "(Landroidx/core/view/Z;)V", "Landroidx/core/view/a0;", "insets", "", "runningAnimations", Const.INTENT_KEY_UMID, "(Landroidx/core/view/a0;Ljava/util/List;)Landroidx/core/view/a0;", Const.INTENT_KEY_PKGNAME, "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends Z.b {
        public b() {
            super(1);
        }

        @Override // androidx.core.view.Z.b
        public void b(androidx.core.view.Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            super.b(animation);
            SdkInitNameActivity.this.imeAnimationRunning = false;
            g6.c cVar = SdkInitNameActivity.this.binding;
            if (cVar == null) {
                kotlin.jvm.internal.p.A("binding");
                cVar = null;
            }
            androidx.core.view.a0 a0VarB = androidx.core.view.N.B(cVar.b());
            if (a0VarB == null) {
                return;
            }
            int i10 = a0VarB.f(a0.o.g()).f41980d;
            SdkInitNameActivity.this.X(a0VarB.f(a0.o.b()).f41980d, i10);
        }

        @Override // androidx.core.view.Z.b
        public void c(androidx.core.view.Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.d() & a0.o.b()) != 0) {
                SdkInitNameActivity.this.imeAnimationRunning = true;
            }
        }

        @Override // androidx.core.view.Z.b
        public androidx.core.view.a0 d(androidx.core.view.a0 insets, List<androidx.core.view.Z> runningAnimations) {
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            int i10 = insets.f(a0.o.g()).f41980d;
            SdkInitNameActivity.this.X(insets.f(a0.o.b()).f41980d, i10);
            return insets;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/oobe/SdkInitNameActivity$c", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            SdkInitNameActivity.this.p0();
            SdkInitNameActivity.this.o0(s10);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    private final void L() {
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

    public static final CharSequence O(SdkInitNameActivity sdkInitNameActivity, CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        kotlin.jvm.internal.p.f(spanned);
        int iQ0 = 32 - (sdkInitNameActivity.q0(spanned, 0, i12) + sdkInitNameActivity.q0(spanned, i13, spanned.length()));
        if (iQ0 <= 0) {
            sdkInitNameActivity.l0();
            return "";
        }
        int iCharCount = i10;
        while (iCharCount < i11) {
            int iCodePointAt = Character.codePointAt(charSequence, iCharCount);
            int iP = sdkInitNameActivity.P(iCodePointAt);
            if (iP > iQ0) {
                break;
            }
            iQ0 -= iP;
            iCharCount += Character.charCount(iCodePointAt);
        }
        if (iCharCount >= i11) {
            return null;
        }
        sdkInitNameActivity.l0();
        return charSequence.subSequence(i10, iCharCount);
    }

    public static final CharSequence R(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        StringBuilder sb2 = null;
        for (int i14 = i10; i14 < i11; i14++) {
            char cCharAt = charSequence.charAt(i14);
            if (cCharAt == '\n' || cCharAt == '\r') {
                if (sb2 == null) {
                    sb2 = new StringBuilder(i11 - i10);
                    sb2.append(charSequence, i10, i14);
                }
            } else if (sb2 != null) {
                sb2.append(cCharAt);
            }
        }
        if (sb2 != null) {
            return sb2.toString();
        }
        return null;
    }

    private final void S() {
        g6.c cVar = this.binding;
        g6.c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        cVar.etName.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            g6.c cVar3 = this.binding;
            if (cVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                cVar2 = cVar3;
            }
            inputMethodManager.hideSoftInputFromWindow(cVar2.b().getWindowToken(), 0);
        }
    }

    public static final void T(SdkInitNameActivity sdkInitNameActivity, View view) {
        C4059a.e(C4059a.INSTANCE, C4059a.STEP_PREFERENCE, "back", null, 4, null);
        sdkInitNameActivity.finish();
    }

    public static final void U(SdkInitNameActivity sdkInitNameActivity, View view) {
        C4059a.e(C4059a.INSTANCE, C4059a.STEP_PREFERENCE, "skip", null, 4, null);
        O.INSTANCE.f("");
        sdkInitNameActivity.startActivity(new Intent(sdkInitNameActivity, (Class<?>) SdkInitSoulActivity.class));
    }

    public static final void V(SdkInitNameActivity sdkInitNameActivity, View view) throws Resources.NotFoundException {
        sdkInitNameActivity.c0();
    }

    public static final void Z(SdkInitNameActivity sdkInitNameActivity) {
        if (sdkInitNameActivity.isFinishing() || sdkInitNameActivity.isDestroyed()) {
            return;
        }
        Toast.makeText(sdkInitNameActivity.getApplicationContext(), R$string.oobe_mic_denied_skip, 1).show();
    }

    public static final androidx.core.view.a0 b0(SdkInitNameActivity sdkInitNameActivity, View view, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        int i10 = insets.f(a0.o.b()).f41980d;
        boolean zR = insets.r(a0.o.b());
        boolean z10 = sdkInitNameActivity.isKeyboardVisible && !zR;
        sdkInitNameActivity.isKeyboardVisible = zR;
        if (z10) {
            g6.c cVar = sdkInitNameActivity.binding;
            if (cVar == null) {
                kotlin.jvm.internal.p.A("binding");
                cVar = null;
            }
            cVar.etName.clearFocus();
        }
        view.setPadding(view.getPaddingLeft(), eVarF.f41978b, view.getPaddingRight(), eVarF.f41980d);
        if (!sdkInitNameActivity.imeAnimationRunning) {
            sdkInitNameActivity.X(i10, eVarF.f41980d);
        }
        return insets;
    }

    public static final void e0(SdkInitNameActivity sdkInitNameActivity) {
        int length;
        g6.c cVar = sdkInitNameActivity.binding;
        g6.c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        Editable text = cVar.etName.getText();
        if (text == null || (length = text.length()) <= 0) {
            return;
        }
        g6.c cVar3 = sdkInitNameActivity.binding;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            cVar2 = cVar3;
        }
        cVar2.etName.setSelection(length);
    }

    public static final boolean h0(SdkInitNameActivity sdkInitNameActivity, TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 6) {
            return false;
        }
        sdkInitNameActivity.S();
        return true;
    }

    public static final void i0(SdkInitNameActivity sdkInitNameActivity, View view, boolean z10) {
        if (z10) {
            sdkInitNameActivity.d0();
        }
    }

    private final void initView() {
        g6.c cVar = null;
        this.viewScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c()));
        L();
        Q();
        N();
        a0();
        g0();
        f0();
        j0();
        M();
        g6.c cVar2 = this.binding;
        if (cVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar2 = null;
        }
        cVar2.titleBar.addStartAction(R.drawable.stepos_icon_navigation_back, getString(R$string.oobe_back), new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.Z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkInitNameActivity.T(this.f27588a, view);
            }
        });
        g6.c cVar3 = this.binding;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar3 = null;
        }
        StepOSTitleBar stepOSTitleBar = cVar3.titleBar;
        String string = getString(R$string.oobe_skip);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        View childAt = stepOSTitleBar.addEndTextAction(string, new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkInitNameActivity.U(this.f27590a, view);
            }
        }).getChildAt(0);
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        if (textView != null) {
            textView.setTextColor(androidx.core.content.a.c(this, R$color.oobe_agreement_text_primary));
        }
        g6.c cVar4 = this.binding;
        if (cVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            cVar = cVar4;
        }
        cVar.btnNext.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                SdkInitNameActivity.V(this.f27592a, view);
            }
        });
    }

    public static final void k0(SdkInitNameActivity sdkInitNameActivity) {
        InputMethodManager inputMethodManager = (InputMethodManager) sdkInitNameActivity.getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            g6.c cVar = sdkInitNameActivity.binding;
            if (cVar == null) {
                kotlin.jvm.internal.p.A("binding");
                cVar = null;
            }
            inputMethodManager.showSoftInput(cVar.etName, 1);
        }
    }

    public final void M() {
        g6.c cVar = this.binding;
        g6.c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        cVar.etName.setTextCursorDrawable(R$drawable.oobe_name_system_cursor);
        g6.c cVar3 = this.binding;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            cVar2 = cVar3;
        }
        cVar2.etName.setCursorVisible(true);
    }

    public final void N() {
        InputFilter inputFilter = new InputFilter() { // from class: com.stepos.ailauncher.oobe.g0
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
                return SdkInitNameActivity.O(this.f27601a, charSequence, i10, i11, spanned, i12, i13);
            }
        };
        g6.c cVar = this.binding;
        g6.c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        EditText editText = cVar.etName;
        g6.c cVar3 = this.binding;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            cVar2 = cVar3;
        }
        InputFilter[] filters = cVar2.etName.getFilters();
        kotlin.jvm.internal.p.h(filters, "getFilters(...)");
        ArrayList arrayList = new ArrayList();
        for (InputFilter inputFilter2 : filters) {
            if (!(inputFilter2 instanceof InputFilter.LengthFilter)) {
                arrayList.add(inputFilter2);
            }
        }
        editText.setFilters((InputFilter[]) C1168p.F(arrayList.toArray(new InputFilter[0]), inputFilter));
    }

    public final int P(int codePoint) {
        return codePoint <= 127 ? 1 : 2;
    }

    public final void Q() {
        g6.c cVar = this.binding;
        g6.c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        cVar.etName.setSingleLine(true);
        g6.c cVar3 = this.binding;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar3 = null;
        }
        cVar3.etName.setMaxLines(1);
        InputFilter inputFilter = new InputFilter() { // from class: com.stepos.ailauncher.oobe.e0
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
                return SdkInitNameActivity.R(charSequence, i10, i11, spanned, i12, i13);
            }
        };
        g6.c cVar4 = this.binding;
        if (cVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar4 = null;
        }
        EditText editText = cVar4.etName;
        g6.c cVar5 = this.binding;
        if (cVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            cVar2 = cVar5;
        }
        InputFilter[] filters = cVar2.etName.getFilters();
        kotlin.jvm.internal.p.h(filters, "getFilters(...)");
        editText.setFilters((InputFilter[]) C1168p.F(filters, inputFilter));
    }

    public final boolean W(MotionEvent ev, View view) {
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

    public final void X(int imeBottom, int navBottom) {
        int iF = C5685n.f(imeBottom - navBottom, 0);
        g6.c cVar = this.binding;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        cVar.btnNext.setTranslationY(-iF);
    }

    public final void Y() {
        if (this.pendingMicDeniedSkipToast) {
            this.pendingMicDeniedSkipToast = false;
            g6.c cVar = this.binding;
            if (cVar == null) {
                kotlin.jvm.internal.p.A("binding");
                cVar = null;
            }
            cVar.b().post(new Runnable() { // from class: com.stepos.ailauncher.oobe.X
                @Override // java.lang.Runnable
                public final void run() {
                    SdkInitNameActivity.Z(this.f27579a);
                }
            });
        }
    }

    public final void a0() {
        androidx.core.view.Y.b(getWindow(), false);
        g6.c cVar = this.binding;
        g6.c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        androidx.core.view.N.u0(cVar.b(), new androidx.core.view.A() { // from class: com.stepos.ailauncher.oobe.h0
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return SdkInitNameActivity.b0(this.f27603a, view, a0Var);
            }
        });
        g6.c cVar3 = this.binding;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar3 = null;
        }
        androidx.core.view.N.E0(cVar3.b(), new b());
        g6.c cVar4 = this.binding;
        if (cVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            cVar2 = cVar4;
        }
        androidx.core.view.N.e0(cVar2.b());
    }

    public final void c0() throws Resources.NotFoundException {
        g6.c cVar = this.binding;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        Editable text = cVar.etName.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            Toast.makeText(this, R$string.oobe_text_empty, 0).show();
        } else if (!this.isNavigating && System.currentTimeMillis() - this.lastSubmitFailToastAt >= 2000) {
            S();
            n0(string);
        }
    }

    public final void d0() {
        g6.c cVar = this.binding;
        g6.c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        Editable text = cVar.etName.getText();
        if (text == null || text.length() == 0) {
            return;
        }
        g6.c cVar3 = this.binding;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            cVar2 = cVar3;
        }
        cVar2.etName.post(new Runnable() { // from class: com.stepos.ailauncher.oobe.Y
            @Override // java.lang.Runnable
            public final void run() {
                SdkInitNameActivity.e0(this.f27583a);
            }
        });
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
            g6.c r0 = r4.binding
            r1 = 0
            java.lang.String r2 = "binding"
            if (r0 != 0) goto L1a
            kotlin.jvm.internal.p.A(r2)
            r0 = r1
        L1a:
            android.widget.EditText r0 = r0.etName
            java.lang.String r3 = "etName"
            kotlin.jvm.internal.p.h(r0, r3)
            boolean r0 = r4.W(r5, r0)
            g6.c r3 = r4.binding
            if (r3 != 0) goto L2d
            kotlin.jvm.internal.p.A(r2)
            r3 = r1
        L2d:
            android.widget.ImageButton r3 = r3.btnNext
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L4d
            g6.c r3 = r4.binding
            if (r3 != 0) goto L3d
            kotlin.jvm.internal.p.A(r2)
            goto L3e
        L3d:
            r1 = r3
        L3e:
            android.widget.ImageButton r1 = r1.btnNext
            java.lang.String r2 = "btnNext"
            kotlin.jvm.internal.p.h(r1, r2)
            boolean r1 = r4.W(r5, r1)
            if (r1 == 0) goto L4d
            r1 = 1
            goto L4e
        L4d:
            r1 = 0
        L4e:
            if (r0 != 0) goto L55
            if (r1 != 0) goto L55
            r4.S()
        L55:
            boolean r4 = super.dispatchTouchEvent(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.oobe.SdkInitNameActivity.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void f0() {
        String strA = O.INSTANCE.a();
        if (La.H.x0(strA)) {
            return;
        }
        g6.c cVar = this.binding;
        g6.c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        Editable text = cVar.etName.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        if (kotlin.jvm.internal.p.d(string, strA)) {
            p0();
            return;
        }
        if (string.length() > 0) {
            return;
        }
        this.suppressTextInputTrack = true;
        g6.c cVar3 = this.binding;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar3 = null;
        }
        cVar3.etName.setText(strA);
        this.suppressTextInputTrack = false;
        g6.c cVar4 = this.binding;
        if (cVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar4 = null;
        }
        Editable text2 = cVar4.etName.getText();
        int length = text2 != null ? text2.length() : 0;
        if (length > 0) {
            g6.c cVar5 = this.binding;
            if (cVar5 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                cVar2 = cVar5;
            }
            cVar2.etName.setSelection(length);
        }
    }

    public final void g0() {
        g6.c cVar = this.binding;
        g6.c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        cVar.etName.addTextChangedListener(new c());
        g6.c cVar3 = this.binding;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar3 = null;
        }
        cVar3.etName.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.stepos.ailauncher.oobe.c0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                return SdkInitNameActivity.h0(this.f27594a, textView, i10, keyEvent);
            }
        });
        g6.c cVar4 = this.binding;
        if (cVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            cVar2 = cVar4;
        }
        cVar2.etName.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.stepos.ailauncher.oobe.d0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                SdkInitNameActivity.i0(this.f27596a, view, z10);
            }
        });
    }

    public final void j0() {
        g6.c cVar = this.binding;
        g6.c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        cVar.etName.requestFocus();
        g6.c cVar3 = this.binding;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            cVar2 = cVar3;
        }
        cVar2.etName.post(new Runnable() { // from class: com.stepos.ailauncher.oobe.f0
            @Override // java.lang.Runnable
            public final void run() {
                SdkInitNameActivity.k0(this.f27599a);
            }
        });
    }

    public final void l0() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastLengthLimitToastAt < 2000) {
            return;
        }
        this.lastLengthLimitToastAt = jCurrentTimeMillis;
        Toast.makeText(this, R$string.oobe_name_length_limit, 0).show();
    }

    public final void m0(int messageRes) throws Resources.NotFoundException {
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

    public final void n0(String text) throws Resources.NotFoundException {
        if (!com.stepos.agentframework.chatcore.utils.n.INSTANCE.a(this)) {
            m0(R$string.oobe_network_unavailable);
            return;
        }
        this.isNavigating = true;
        Ua.M m10 = this.viewScope;
        if (m10 != null) {
            C1060i.d(m10, null, null, new SdkInitNameActivity$textSecurityCheck$1(text, this, null), 3, null);
        }
    }

    public final void o0(Editable text) {
        if (this.suppressTextInputTrack || this.textInputTracked || text == null || La.H.x0(text)) {
            return;
        }
        this.textInputTracked = true;
        C4059a.INSTANCE.f(C4059a.QUESTION_NICKNAME, C4059a.ACTION_TEXT_INPUT);
    }

    @Override // com.stepos.ailauncher.oobe.N, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C4059a.INSTANCE.g(C4059a.STEP_PREFERENCE, getString(R$string.oobe_sdk_init_name_question));
        g6.c cVarC = g6.c.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(cVarC, "inflate(...)");
        this.binding = cVarC;
        if (cVarC == null) {
            kotlin.jvm.internal.p.A("binding");
            cVarC = null;
        }
        setContentView(cVarC.b());
        boolean z10 = false;
        if (savedInstanceState == null && getIntent().getBooleanExtra(EXTRA_MIC_DENIED_SKIP, false)) {
            z10 = true;
        }
        this.pendingMicDeniedSkipToast = z10;
        initView();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
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
        f0();
        Y();
    }

    public final void p0() {
        g6.c cVar = this.binding;
        g6.c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        ImageButton imageButton = cVar.btnNext;
        g6.c cVar3 = this.binding;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            cVar2 = cVar3;
        }
        Editable text = cVar2.etName.getText();
        imageButton.setVisibility((text == null || La.H.x0(text)) ? 8 : 0);
    }

    public final int q0(CharSequence text, int start, int end) {
        int iP = 0;
        while (start < end) {
            int iCodePointAt = Character.codePointAt(text, start);
            iP += P(iCodePointAt);
            start += Character.charCount(iCodePointAt);
        }
        return iP;
    }
}
