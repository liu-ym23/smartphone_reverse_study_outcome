package com.stepos.ailauncher.oobe;

import Ua.C1060i;
import Z8.C1168p;
import Z8.C1173v;
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
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.Z;
import androidx.core.view.a0;
import androidx.core.widget.NestedScrollView;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.widget.R;
import com.stepos.widget.toolbar.StepOSTitleBar;
import f6.C4059a;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\r\u0018\u0000 \u0083\u00012\u00020\u0001:\u0004\u0084\u0001\u0085\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J!\u0010\u0011\u001a\u00020\u00042\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J'\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001fH\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\u0003J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u001fH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0003J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0004H\u0002¢\u0006\u0004\b0\u0010\u0003J\u001f\u00103\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u001fH\u0002¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u001fH\u0002¢\u0006\u0004\b6\u0010*J\u000f\u00107\u001a\u00020\u001fH\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u001fH\u0002¢\u0006\u0004\b9\u00108J\u0017\u0010:\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u001fH\u0002¢\u0006\u0004\b:\u0010*J\u000f\u0010;\u001a\u00020\u0013H\u0002¢\u0006\u0004\b;\u0010<J\u001f\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00130=j\b\u0012\u0004\u0012\u00020\u0013`>H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0004H\u0002¢\u0006\u0004\bA\u0010\u0003J\u000f\u0010B\u001a\u00020\u0004H\u0002¢\u0006\u0004\bB\u0010\u0003J\u000f\u0010C\u001a\u00020\u0004H\u0002¢\u0006\u0004\bC\u0010\u0003J\u000f\u0010D\u001a\u00020\u0004H\u0002¢\u0006\u0004\bD\u0010\u0003J%\u0010F\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0004H\u0002¢\u0006\u0004\bH\u0010\u0003J\u000f\u0010I\u001a\u00020\u0004H\u0002¢\u0006\u0004\bI\u0010\u0003J\u000f\u0010J\u001a\u00020\u0004H\u0002¢\u0006\u0004\bJ\u0010\u0003J\u001f\u0010P\u001a\u00020O2\u0006\u0010L\u001a\u00020K2\u0006\u0010N\u001a\u00020MH\u0002¢\u0006\u0004\bP\u0010QJ\u0019\u0010T\u001a\u00020\u00042\b\u0010S\u001a\u0004\u0018\u00010RH\u0014¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001a\u00020O2\u0006\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\u0004H\u0014¢\u0006\u0004\bX\u0010\u0003R\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010b\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010f\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010eR\u0016\u0010g\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010i\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010hR\u0016\u0010j\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010hR\u0014\u0010l\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010n\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010`R\u0016\u0010p\u001a\u00020o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010qR\u0018\u0010t\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010v\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010eR$\u0010w\u001a\u0012\u0012\u0004\u0012\u00020\u00130=j\b\u0012\u0004\u0012\u00020\u0013`>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00070y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010|\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010`R\u0016\u0010}\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010`R\u0016\u0010~\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010`R\u0016\u0010\u007f\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010`R\u0017\u0010\u0082\u0001\u001a\u00020O8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u0086\u0001"}, d2 = {"Lcom/stepos/ailauncher/oobe/SdkInitSoulActivity;", "Lcom/stepos/ailauncher/oobe/N;", "<init>", "()V", "LY8/t;", "initView", "V0", "Lcom/stepos/ailauncher/oobe/SdkInitSoulActivity$b;", "option", "d1", "(Lcom/stepos/ailauncher/oobe/SdkInitSoulActivity$b;)V", "O0", "X0", "s0", "v0", "Lkotlin/Function0;", "onCommitted", "n0", "(Lp9/a;)V", "", "text", "e0", "(Ljava/lang/String;)V", "c1", "Landroid/text/Editable;", "e1", "(Landroid/text/Editable;)V", "h0", "q0", "f0", "", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "g1", "(Ljava/lang/CharSequence;II)I", "codePoint", "l0", "(I)I", "Z0", "messageRes", SdCardDbCreator.FIELD_LASTLOC_ID, "(I)V", "E0", "", "fraction", "i0", "(F)V", "j0", "imeBottom", "navBottom", "C0", "(II)V", "extraLift", "k0", "x0", "()I", "D0", "N0", "I0", "()Ljava/lang/String;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "m0", "()Ljava/util/LinkedHashSet;", "J0", "f1", "G0", "u0", "onPass", "b1", "(Ljava/lang/String;Lp9/a;)V", "K0", "L0", "w0", "Landroid/view/MotionEvent;", "ev", "Landroid/view/View;", "view", "", "B0", "(Landroid/view/MotionEvent;Landroid/view/View;)Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onResume", "Lg6/d;", "binding", "Lg6/d;", "LUa/M;", "viewScope", "LUa/M;", "isKeyboardVisible", "Z", "Landroidx/core/view/Z;", "activeImeAnimation", "Landroidx/core/view/Z;", "imeExtraLift", "I", "imeStartOptionTop", "imeContentOffset", "F", "imeStartQuestionAlpha", "imeStartCompactAlpha", "", "optionLocation", "[I", "isNavigating", "", "lastLengthLimitToastAt", "J", "lastSubmitFailToastAt", "Landroid/widget/Toast;", "submitFailToast", "Landroid/widget/Toast;", "optionScrollIdlePaddingBottom", "selectedTexts", "Ljava/util/LinkedHashSet;", "", "options", "Ljava/util/List;", "customCommitted", "committingCustom", "suppressTextInputTrack", "textInputTracked", "t0", "()Z", "imeAnimationRunning", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SdkInitSoulActivity extends N {
    private static final long LENGTH_LIMIT_TOAST_INTERVAL_MS = 2000;
    private static final int MAX_CUSTOM_LENGTH = 26;
    private androidx.core.view.Z activeImeAnimation;
    private g6.d binding;
    private boolean committingCustom;
    private boolean customCommitted;
    private float imeContentOffset;
    private int imeExtraLift;
    private float imeStartCompactAlpha;
    private int imeStartOptionTop;
    private boolean isKeyboardVisible;
    private boolean isNavigating;
    private long lastLengthLimitToastAt;
    private long lastSubmitFailToastAt;
    private int optionScrollIdlePaddingBottom;
    private Toast submitFailToast;
    private boolean suppressTextInputTrack;
    private boolean textInputTracked;
    private Ua.M viewScope;
    private static final List<Integer> OPTION_LABELS = C1173v.p(Integer.valueOf(R$string.oobe_user_opt_detailed), Integer.valueOf(R$string.oobe_user_opt_formal), Integer.valueOf(R$string.oobe_user_opt_concise), Integer.valueOf(R$string.oobe_user_opt_lively), Integer.valueOf(R$string.oobe_user_opt_casual));
    private float imeStartQuestionAlpha = 1.0f;
    private final int[] optionLocation = new int[2];
    private final LinkedHashSet<String> selectedTexts = new LinkedHashSet<>();
    private final List<Option> options = new ArrayList();

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/oobe/SdkInitSoulActivity$b;", "", "Landroid/view/View;", "container", "Landroid/widget/TextView;", "label", "Landroid/widget/ImageView;", "check", "<init>", "(Landroid/view/View;Landroid/widget/TextView;Landroid/widget/ImageView;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/view/View;", Const.INTENT_KEY_PKGNAME, "()Landroid/view/View;", "Landroid/widget/TextView;", "c", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", Const.INTENT_KEY_APIKEY, "()Landroid/widget/ImageView;", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.oobe.SdkInitSoulActivity$b, reason: from toString */
    public static final /* data */ class Option {
        private final ImageView check;
        private final View container;
        private final TextView label;

        public Option(View container, TextView label, ImageView check) {
            kotlin.jvm.internal.p.i(container, "container");
            kotlin.jvm.internal.p.i(label, "label");
            kotlin.jvm.internal.p.i(check, "check");
            this.container = container;
            this.label = label;
            this.check = check;
        }

        /* renamed from: a, reason: from getter */
        public final ImageView getCheck() {
            return this.check;
        }

        /* renamed from: b, reason: from getter */
        public final View getContainer() {
            return this.container;
        }

        /* renamed from: c, reason: from getter */
        public final TextView getLabel() {
            return this.label;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Option)) {
                return false;
            }
            Option option = (Option) other;
            return kotlin.jvm.internal.p.d(this.container, option.container) && kotlin.jvm.internal.p.d(this.label, option.label) && kotlin.jvm.internal.p.d(this.check, option.check);
        }

        public int hashCode() {
            return (((this.container.hashCode() * 31) + this.label.hashCode()) * 31) + this.check.hashCode();
        }

        public String toString() {
            return "Option(container=" + this.container + ", label=" + this.label + ", check=" + this.check + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements View.OnLayoutChangeListener {
        public c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            SdkInitSoulActivity sdkInitSoulActivity = SdkInitSoulActivity.this;
            sdkInitSoulActivity.k0(sdkInitSoulActivity.imeExtraLift);
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"com/stepos/ailauncher/oobe/SdkInitSoulActivity$d", "Landroidx/core/view/Z$b;", "Landroidx/core/view/Z;", "animation", "LY8/t;", "c", "(Landroidx/core/view/Z;)V", "Landroidx/core/view/Z$a;", "bounds", "e", "(Landroidx/core/view/Z;Landroidx/core/view/Z$a;)Landroidx/core/view/Z$a;", "Landroidx/core/view/a0;", "insets", "", "runningAnimations", Const.INTENT_KEY_UMID, "(Landroidx/core/view/a0;Ljava/util/List;)Landroidx/core/view/a0;", Const.INTENT_KEY_PKGNAME, "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends Z.b {
        public d() {
            super(1);
        }

        @Override // androidx.core.view.Z.b
        public void b(androidx.core.view.Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            super.b(animation);
            if (animation != SdkInitSoulActivity.this.activeImeAnimation) {
                return;
            }
            SdkInitSoulActivity.this.i0(1.0f);
            g6.d dVar = null;
            SdkInitSoulActivity.this.activeImeAnimation = null;
            g6.d dVar2 = SdkInitSoulActivity.this.binding;
            if (dVar2 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                dVar = dVar2;
            }
            androidx.core.view.a0 a0VarB = androidx.core.view.N.B(dVar.b());
            if (a0VarB == null) {
                return;
            }
            int i10 = a0VarB.f(a0.o.g()).f41980d;
            SdkInitSoulActivity.this.C0(a0VarB.f(a0.o.b()).f41980d, i10);
        }

        @Override // androidx.core.view.Z.b
        public void c(androidx.core.view.Z animation) {
            float alpha;
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.d() & a0.o.b()) != 0) {
                SdkInitSoulActivity.this.activeImeAnimation = animation;
                g6.d dVar = SdkInitSoulActivity.this.binding;
                g6.d dVar2 = null;
                if (dVar == null) {
                    kotlin.jvm.internal.p.A("binding");
                    dVar = null;
                }
                dVar.optionList.getLocationInWindow(SdkInitSoulActivity.this.optionLocation);
                SdkInitSoulActivity sdkInitSoulActivity = SdkInitSoulActivity.this;
                sdkInitSoulActivity.imeStartOptionTop = sdkInitSoulActivity.optionLocation[1];
                SdkInitSoulActivity sdkInitSoulActivity2 = SdkInitSoulActivity.this;
                g6.d dVar3 = sdkInitSoulActivity2.binding;
                if (dVar3 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    dVar3 = null;
                }
                float alpha2 = 0.0f;
                if (dVar3.tvQuestion.getVisibility() == 0) {
                    g6.d dVar4 = SdkInitSoulActivity.this.binding;
                    if (dVar4 == null) {
                        kotlin.jvm.internal.p.A("binding");
                        dVar4 = null;
                    }
                    alpha = dVar4.tvQuestion.getAlpha();
                } else {
                    alpha = 0.0f;
                }
                sdkInitSoulActivity2.imeStartQuestionAlpha = alpha;
                SdkInitSoulActivity sdkInitSoulActivity3 = SdkInitSoulActivity.this;
                g6.d dVar5 = sdkInitSoulActivity3.binding;
                if (dVar5 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    dVar5 = null;
                }
                if (dVar5.tvCompactTitle.getVisibility() == 0) {
                    g6.d dVar6 = SdkInitSoulActivity.this.binding;
                    if (dVar6 == null) {
                        kotlin.jvm.internal.p.A("binding");
                    } else {
                        dVar2 = dVar6;
                    }
                    alpha2 = dVar2.tvCompactTitle.getAlpha();
                }
                sdkInitSoulActivity3.imeStartCompactAlpha = alpha2;
            }
        }

        @Override // androidx.core.view.Z.b
        public androidx.core.view.a0 d(androidx.core.view.a0 insets, List<androidx.core.view.Z> runningAnimations) {
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            int i10 = insets.f(a0.o.g()).f41980d;
            SdkInitSoulActivity.this.C0(insets.f(a0.o.b()).f41980d, i10);
            androidx.core.view.Z z10 = SdkInitSoulActivity.this.activeImeAnimation;
            if (z10 != null) {
                SdkInitSoulActivity sdkInitSoulActivity = SdkInitSoulActivity.this;
                if (runningAnimations.contains(z10)) {
                    sdkInitSoulActivity.i0(z10.c());
                }
            }
            return insets;
        }

        @Override // androidx.core.view.Z.b
        public Z.a e(androidx.core.view.Z animation, Z.a bounds) throws Resources.NotFoundException {
            kotlin.jvm.internal.p.i(animation, "animation");
            kotlin.jvm.internal.p.i(bounds, "bounds");
            if (animation != SdkInitSoulActivity.this.activeImeAnimation) {
                return bounds;
            }
            g6.d dVar = SdkInitSoulActivity.this.binding;
            g6.d dVar2 = null;
            if (dVar == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar = null;
            }
            dVar.optionScroll.getChildAt(0).setTranslationY(0.0f);
            SdkInitSoulActivity sdkInitSoulActivity = SdkInitSoulActivity.this;
            sdkInitSoulActivity.N0(sdkInitSoulActivity.imeExtraLift);
            g6.d dVar3 = SdkInitSoulActivity.this.binding;
            if (dVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                dVar2 = dVar3;
            }
            dVar2.optionList.getLocationInWindow(SdkInitSoulActivity.this.optionLocation);
            SdkInitSoulActivity.this.imeContentOffset = r5.imeStartOptionTop - SdkInitSoulActivity.this.optionLocation[1];
            SdkInitSoulActivity.this.i0(0.0f);
            return bounds;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) throws Resources.NotFoundException {
            view.removeOnLayoutChangeListener(this);
            if (SdkInitSoulActivity.this.t0()) {
                return;
            }
            SdkInitSoulActivity sdkInitSoulActivity = SdkInitSoulActivity.this;
            sdkInitSoulActivity.N0(sdkInitSoulActivity.imeExtraLift);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/ailauncher/oobe/SdkInitSoulActivity$f", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            g6.d dVar = SdkInitSoulActivity.this.binding;
            if (dVar == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar = null;
            }
            dVar.btnCustomSubmit.setVisibility((s10 == null || La.H.x0(s10)) ? 8 : 0);
            SdkInitSoulActivity.this.f1();
            SdkInitSoulActivity.this.e1(s10);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    public static final void A0(SdkInitSoulActivity sdkInitSoulActivity, View view) throws Resources.NotFoundException {
        sdkInitSoulActivity.G0();
    }

    private final boolean B0(MotionEvent ev, View view) {
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
    public final void C0(int imeBottom, int navBottom) {
        int iF = C5685n.f(imeBottom - navBottom, 0);
        g6.d dVar = this.binding;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        dVar.btnNext.setTranslationY(-iF);
    }

    private final void E0() {
        androidx.core.view.Y.b(getWindow(), false);
        g6.d dVar = this.binding;
        g6.d dVar2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        androidx.core.view.N.u0(dVar.b(), new androidx.core.view.A() { // from class: com.stepos.ailauncher.oobe.t0
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return SdkInitSoulActivity.F0(this.f27635a, view, a0Var);
            }
        });
        g6.d dVar3 = this.binding;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar3 = null;
        }
        androidx.core.view.N.E0(dVar3.b(), new d());
        g6.d dVar4 = this.binding;
        if (dVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            dVar2 = dVar4;
        }
        androidx.core.view.N.e0(dVar2.b());
    }

    public static final androidx.core.view.a0 F0(SdkInitSoulActivity sdkInitSoulActivity, View view, androidx.core.view.a0 insets) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        int i10 = insets.f(a0.o.b()).f41980d;
        boolean zR = insets.r(a0.o.b());
        boolean z10 = sdkInitSoulActivity.isKeyboardVisible && !zR;
        sdkInitSoulActivity.isKeyboardVisible = zR;
        g6.d dVar = null;
        if (z10) {
            g6.d dVar2 = sdkInitSoulActivity.binding;
            if (dVar2 == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar2 = null;
            }
            dVar2.etCustom.clearFocus();
        }
        view.setPadding(view.getPaddingLeft(), eVarF.f41978b, view.getPaddingRight(), eVarF.f41980d);
        sdkInitSoulActivity.imeExtraLift = C5685n.f(i10 - eVarF.f41980d, 0);
        sdkInitSoulActivity.j0();
        sdkInitSoulActivity.k0(sdkInitSoulActivity.imeExtraLift);
        if (!sdkInitSoulActivity.t0()) {
            sdkInitSoulActivity.C0(i10, eVarF.f41980d);
            g6.d dVar3 = sdkInitSoulActivity.binding;
            if (dVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                dVar = dVar3;
            }
            NestedScrollView optionScroll = dVar.optionScroll;
            kotlin.jvm.internal.p.h(optionScroll, "optionScroll");
            if (!optionScroll.isLaidOut() || optionScroll.isLayoutRequested()) {
                optionScroll.addOnLayoutChangeListener(sdkInitSoulActivity.new e());
            } else if (!sdkInitSoulActivity.t0()) {
                sdkInitSoulActivity.N0(sdkInitSoulActivity.imeExtraLift);
                return insets;
            }
        }
        return insets;
    }

    private final void G0() throws Resources.NotFoundException {
        if (this.isNavigating || this.committingCustom) {
            return;
        }
        if (this.selectedTexts.isEmpty()) {
            Toast.makeText(this, R$string.oobe_text_empty, 0).show();
        } else {
            if (I0().length() > 0) {
                n0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.oobe.s0
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return SdkInitSoulActivity.H0(this.f27633a);
                    }
                });
                return;
            }
            w0();
            this.isNavigating = true;
            u0();
        }
    }

    public static final Y8.t H0(SdkInitSoulActivity sdkInitSoulActivity) {
        sdkInitSoulActivity.isNavigating = true;
        sdkInitSoulActivity.u0();
        return Y8.t.f7040a;
    }

    public static final void M0(SdkInitSoulActivity sdkInitSoulActivity) {
        InputMethodManager inputMethodManager = (InputMethodManager) sdkInitSoulActivity.getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            g6.d dVar = sdkInitSoulActivity.binding;
            if (dVar == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar = null;
            }
            inputMethodManager.showSoftInput(dVar.etCustom, 1);
        }
    }

    public static final void P0(SdkInitSoulActivity sdkInitSoulActivity, View view) {
        sdkInitSoulActivity.X0();
    }

    public static final void Q0(SdkInitSoulActivity sdkInitSoulActivity, View view) throws Resources.NotFoundException {
        o0(sdkInitSoulActivity, null, 1, null);
    }

    public static final void R0(SdkInitSoulActivity sdkInitSoulActivity, View view) {
        sdkInitSoulActivity.c1();
    }

    public static final void S0(SdkInitSoulActivity sdkInitSoulActivity, View view) {
        sdkInitSoulActivity.s0();
    }

    public static final boolean T0(SdkInitSoulActivity sdkInitSoulActivity, TextView textView, int i10, KeyEvent keyEvent) throws Resources.NotFoundException {
        if (i10 != 6) {
            return false;
        }
        g6.d dVar = sdkInitSoulActivity.binding;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        Editable text = dVar.etCustom.getText();
        if (text == null || La.H.x0(text)) {
            sdkInitSoulActivity.w0();
        } else {
            o0(sdkInitSoulActivity, null, 1, null);
        }
        return true;
    }

    public static final void U0(SdkInitSoulActivity sdkInitSoulActivity, View view, boolean z10) {
        if (z10) {
            return;
        }
        g6.d dVar = sdkInitSoulActivity.binding;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        Editable text = dVar.etCustom.getText();
        if (text == null || La.H.x0(text)) {
            sdkInitSoulActivity.v0();
        }
    }

    public static final void W0(SdkInitSoulActivity sdkInitSoulActivity, Option option, View view) throws Resources.NotFoundException {
        sdkInitSoulActivity.d1(option);
    }

    public static final void Y0(SdkInitSoulActivity sdkInitSoulActivity) {
        InputMethodManager inputMethodManager = (InputMethodManager) sdkInitSoulActivity.getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            g6.d dVar = sdkInitSoulActivity.binding;
            if (dVar == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar = null;
            }
            inputMethodManager.showSoftInput(dVar.etCustom, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(int messageRes) throws Resources.NotFoundException {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1(Editable text) {
        if (this.suppressTextInputTrack || this.textInputTracked || text == null || La.H.x0(text)) {
            return;
        }
        this.textInputTracked = true;
        C4059a.INSTANCE.f(C4059a.QUESTION_COMMON_STYLE, C4059a.ACTION_TEXT_INPUT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1() {
        boolean zIsEmpty = this.selectedTexts.isEmpty();
        g6.d dVar = this.binding;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        dVar.btnNext.setVisibility(!zIsEmpty ? 0 : 8);
    }

    public static final CharSequence g0(SdkInitSoulActivity sdkInitSoulActivity, CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        kotlin.jvm.internal.p.f(spanned);
        int iG1 = 26 - (sdkInitSoulActivity.g1(spanned, 0, i12) + sdkInitSoulActivity.g1(spanned, i13, spanned.length()));
        if (iG1 <= 0) {
            sdkInitSoulActivity.Z0();
            return "";
        }
        int iCharCount = i10;
        while (iCharCount < i11) {
            int iCodePointAt = Character.codePointAt(charSequence, iCharCount);
            int iL0 = sdkInitSoulActivity.l0(iCodePointAt);
            if (iL0 > iG1) {
                break;
            }
            iG1 -= iL0;
            iCharCount += Character.charCount(iCodePointAt);
        }
        if (iCharCount >= i11) {
            return null;
        }
        sdkInitSoulActivity.Z0();
        return charSequence.subSequence(i10, iCharCount);
    }

    private final int g1(CharSequence text, int start, int end) {
        int iL0 = 0;
        while (start < end) {
            int iCodePointAt = Character.codePointAt(text, start);
            iL0 += l0(iCodePointAt);
            start += Character.charCount(iCodePointAt);
        }
        return iL0;
    }

    private final void h0() {
        androidx.core.view.Y.b(getWindow(), false);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().setNavigationBarContrastEnforced(false);
        androidx.core.view.b0 b0Var = new androidx.core.view.b0(getWindow(), getWindow().getDecorView());
        b0Var.e(false);
        b0Var.d(false);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() & (-8209));
        com.stepos.ailauncher.common.utils.H.d(getWindow());
        com.stepos.ailauncher.common.utils.H.c(getWindow(), false);
    }

    private final void initView() {
        g6.d dVar = null;
        this.viewScope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c()));
        h0();
        V0();
        O0();
        g6.d dVar2 = this.binding;
        if (dVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar2 = null;
        }
        this.optionScrollIdlePaddingBottom = dVar2.optionScroll.getPaddingBottom();
        E0();
        g6.d dVar3 = this.binding;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar3 = null;
        }
        dVar3.titleBar.addStartAction(R.drawable.stepos_icon_navigation_back, getString(R$string.oobe_back), new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkInitSoulActivity.y0(this.f27605a, view);
            }
        });
        g6.d dVar4 = this.binding;
        if (dVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar4 = null;
        }
        StepOSTitleBar stepOSTitleBar = dVar4.titleBar;
        String string = getString(R$string.oobe_skip);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        View childAt = stepOSTitleBar.addEndTextAction(string, new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkInitSoulActivity.z0(this.f27628a, view);
            }
        }).getChildAt(0);
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        if (textView != null) {
            textView.setTextColor(androidx.core.content.a.c(this, R$color.oobe_agreement_text_primary));
        }
        g6.d dVar5 = this.binding;
        if (dVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar5 = null;
        }
        dVar5.btnNext.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                SdkInitSoulActivity.A0(this.f27631a, view);
            }
        });
        g6.d dVar6 = this.binding;
        if (dVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            dVar = dVar6;
        }
        StepOSTitleBar titleBar = dVar.titleBar;
        kotlin.jvm.internal.p.h(titleBar, "titleBar");
        if (!titleBar.isLaidOut() || titleBar.isLayoutRequested()) {
            titleBar.addOnLayoutChangeListener(new c());
        } else {
            k0(this.imeExtraLift);
        }
    }

    private final int l0(int codePoint) {
        return codePoint <= 127 ? 1 : 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void o0(SdkInitSoulActivity sdkInitSoulActivity, InterfaceC5063a interfaceC5063a, int i10, Object obj) throws Resources.NotFoundException {
        if ((i10 & 1) != 0) {
            interfaceC5063a = null;
        }
        sdkInitSoulActivity.n0(interfaceC5063a);
    }

    public static final Y8.t p0(SdkInitSoulActivity sdkInitSoulActivity, String str, InterfaceC5063a interfaceC5063a) {
        sdkInitSoulActivity.e0(str);
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    private final void q0() {
        g6.d dVar = this.binding;
        g6.d dVar2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        dVar.etCustom.setSingleLine(true);
        g6.d dVar3 = this.binding;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar3 = null;
        }
        dVar3.etCustom.setMaxLines(1);
        InputFilter inputFilter = new InputFilter() { // from class: com.stepos.ailauncher.oobe.n0
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
                return SdkInitSoulActivity.r0(charSequence, i10, i11, spanned, i12, i13);
            }
        };
        g6.d dVar4 = this.binding;
        if (dVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar4 = null;
        }
        EditText editText = dVar4.etCustom;
        g6.d dVar5 = this.binding;
        if (dVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            dVar2 = dVar5;
        }
        InputFilter[] filters = dVar2.etCustom.getFilters();
        kotlin.jvm.internal.p.h(filters, "getFilters(...)");
        editText.setFilters((InputFilter[]) C1168p.F(filters, inputFilter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence r0(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
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

    private final void w0() {
        g6.d dVar = this.binding;
        g6.d dVar2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        dVar.etCustom.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            g6.d dVar3 = this.binding;
            if (dVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                dVar2 = dVar3;
            }
            inputMethodManager.hideSoftInputFromWindow(dVar2.b().getWindowToken(), 0);
        }
    }

    public static final void y0(SdkInitSoulActivity sdkInitSoulActivity, View view) {
        C4059a.e(C4059a.INSTANCE, C4059a.STEP_PREFERENCE, "back", null, 4, null);
        sdkInitSoulActivity.finish();
    }

    public static final void z0(SdkInitSoulActivity sdkInitSoulActivity, View view) {
        C4059a.e(C4059a.INSTANCE, C4059a.STEP_PREFERENCE, "skip", null, 4, null);
        sdkInitSoulActivity.J0();
        sdkInitSoulActivity.startActivity(new Intent(sdkInitSoulActivity, (Class<?>) SdkInitUserActivity.class));
    }

    public final int D0() {
        int iIntValue;
        g6.d dVar = this.binding;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        Integer numValueOf = Integer.valueOf(dVar.btnNext.getHeight());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            iIntValue = numValueOf.intValue();
        } else {
            g6.d dVar2 = this.binding;
            if (dVar2 == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar2 = null;
            }
            Integer numValueOf2 = Integer.valueOf(dVar2.btnNext.getLayoutParams().height);
            Integer num = numValueOf2.intValue() > 0 ? numValueOf2 : null;
            iIntValue = num != null ? num.intValue() : 0;
        }
        return iIntValue + getResources().getDimensionPixelSize(R$dimen.oobe_name_next_margin_idle);
    }

    public final String I0() {
        String string;
        if (this.customCommitted) {
            return "";
        }
        g6.d dVar = this.binding;
        String string2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        if (dVar.customEditRow.getVisibility() != 0) {
            return "";
        }
        g6.d dVar2 = this.binding;
        if (dVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar2 = null;
        }
        Editable text = dVar2.etCustom.getText();
        if (text != null && (string = text.toString()) != null) {
            string2 = La.H.D1(string).toString();
        }
        return string2 == null ? "" : string2;
    }

    public final void J0() {
        O.INSTANCE.g(m0());
    }

    public final void K0() {
        this.committingCustom = false;
        this.isNavigating = false;
        g6.d dVar = this.binding;
        g6.d dVar2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        dVar.btnCustomSubmit.setEnabled(true);
        g6.d dVar3 = this.binding;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            dVar2 = dVar3;
        }
        dVar2.btnNext.setEnabled(true);
        L0();
    }

    public final void L0() {
        if (this.customCommitted) {
            return;
        }
        g6.d dVar = this.binding;
        g6.d dVar2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        if (dVar.customEditRow.getVisibility() != 0) {
            return;
        }
        g6.d dVar3 = this.binding;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar3 = null;
        }
        dVar3.etCustom.requestFocus();
        g6.d dVar4 = this.binding;
        if (dVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            dVar2 = dVar4;
        }
        dVar2.etCustom.post(new Runnable() { // from class: com.stepos.ailauncher.oobe.p0
            @Override // java.lang.Runnable
            public final void run() {
                SdkInitSoulActivity.M0(this.f27626a);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0050, code lost:
    
        r6 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N0(int r6) throws android.content.res.Resources.NotFoundException {
        /*
            r5 = this;
            g6.d r0 = r5.binding
            java.lang.String r1 = "binding"
            r2 = 0
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.p.A(r1)
            r0 = r2
        Lb:
            androidx.core.widget.NestedScrollView r0 = r0.optionScroll
            java.lang.String r3 = "optionScroll"
            kotlin.jvm.internal.p.h(r0, r3)
            r3 = 0
            if (r6 > 0) goto L20
            int r5 = r0.getScrollY()
            if (r5 == 0) goto L7c
            r0.scrollTo(r3, r3)
            return
        L20:
            g6.d r6 = r5.binding
            if (r6 != 0) goto L28
            kotlin.jvm.internal.p.A(r1)
            r6 = r2
        L28:
            android.widget.FrameLayout r6 = r6.createBlock
            java.lang.String r1 = "createBlock"
            kotlin.jvm.internal.p.h(r6, r1)
            int r1 = r6.getHeight()
            if (r1 != 0) goto L36
            goto L7c
        L36:
            android.content.res.Resources r5 = r5.getResources()
            int r1 = com.stepos.ailauncher.oobe.R$dimen.oobe_soul_ime_option_gap
            int r5 = r5.getDimensionPixelSize(r1)
            int r1 = r6.getBottom()
            android.view.ViewParent r6 = r6.getParent()
            boolean r4 = r6 instanceof android.view.View
            if (r4 == 0) goto L4f
            android.view.View r6 = (android.view.View) r6
            goto L50
        L4f:
            r6 = r2
        L50:
            if (r6 == 0) goto L64
            if (r6 == r0) goto L64
            int r4 = r6.getTop()
            int r1 = r1 + r4
            android.view.ViewParent r6 = r6.getParent()
            boolean r4 = r6 instanceof android.view.View
            if (r4 == 0) goto L4f
            android.view.View r6 = (android.view.View) r6
            goto L50
        L64:
            int r6 = r0.getHeight()
            int r2 = r0.getPaddingBottom()
            int r6 = r6 - r2
            int r1 = r1 + r5
            int r1 = r1 - r6
            int r5 = v9.C5685n.f(r1, r3)
            int r6 = r0.getScrollY()
            if (r6 == r5) goto L7c
            r0.scrollTo(r3, r5)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.oobe.SdkInitSoulActivity.N0(int):void");
    }

    public final void O0() {
        f0();
        q0();
        g6.d dVar = this.binding;
        g6.d dVar2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        dVar.btnCreate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkInitSoulActivity.P0(this.f27637a, view);
            }
        });
        g6.d dVar3 = this.binding;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar3 = null;
        }
        dVar3.btnCustomSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                SdkInitSoulActivity.Q0(this.f27639a, view);
            }
        });
        g6.d dVar4 = this.binding;
        if (dVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar4 = null;
        }
        dVar4.customOptionRow.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkInitSoulActivity.R0(this.f27643a, view);
            }
        });
        g6.d dVar5 = this.binding;
        if (dVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar5 = null;
        }
        dVar5.ivCustomQuill.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkInitSoulActivity.S0(this.f27645a, view);
            }
        });
        g6.d dVar6 = this.binding;
        if (dVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar6 = null;
        }
        dVar6.etCustom.addTextChangedListener(new f());
        g6.d dVar7 = this.binding;
        if (dVar7 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar7 = null;
        }
        dVar7.etCustom.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.stepos.ailauncher.oobe.y0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                return SdkInitSoulActivity.T0(this.f27647a, textView, i10, keyEvent);
            }
        });
        g6.d dVar8 = this.binding;
        if (dVar8 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            dVar2 = dVar8;
        }
        dVar2.etCustom.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.stepos.ailauncher.oobe.j0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                SdkInitSoulActivity.U0(this.f27607a, view, z10);
            }
        });
    }

    public final void V0() {
        g6.d dVar = this.binding;
        g6.d dVar2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        LinearLayout optionList = dVar.optionList;
        kotlin.jvm.internal.p.h(optionList, "optionList");
        g6.d dVar3 = this.binding;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            dVar2 = dVar3;
        }
        int iIndexOfChild = optionList.indexOfChild(dVar2.createBlock);
        int i10 = 0;
        for (Object obj : OPTION_LABELS) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            int iIntValue = ((Number) obj).intValue();
            View viewInflate = getLayoutInflater().inflate(R$layout.oobe_item_soul_option, (ViewGroup) optionList, false);
            TextView textView = (TextView) viewInflate.findViewById(R$id.tv_label);
            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.iv_check);
            textView.setText(iIntValue);
            kotlin.jvm.internal.p.f(viewInflate);
            kotlin.jvm.internal.p.f(textView);
            kotlin.jvm.internal.p.f(imageView);
            final Option option = new Option(viewInflate, textView, imageView);
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.oobe.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    SdkInitSoulActivity.W0(this.f27610a, option, view);
                }
            });
            this.options.add(option);
            optionList.addView(viewInflate, i10 + iIndexOfChild);
            i10 = i11;
        }
    }

    public final void X0() {
        g6.d dVar = this.binding;
        g6.d dVar2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        dVar.btnCreate.setVisibility(8);
        g6.d dVar3 = this.binding;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar3 = null;
        }
        dVar3.customOptionRow.setVisibility(8);
        g6.d dVar4 = this.binding;
        if (dVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar4 = null;
        }
        dVar4.customEditRow.setVisibility(0);
        g6.d dVar5 = this.binding;
        if (dVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar5 = null;
        }
        dVar5.etCustom.requestFocus();
        f1();
        g6.d dVar6 = this.binding;
        if (dVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            dVar2 = dVar6;
        }
        dVar2.etCustom.post(new Runnable() { // from class: com.stepos.ailauncher.oobe.l0
            @Override // java.lang.Runnable
            public final void run() {
                SdkInitSoulActivity.Y0(this.f27613a);
            }
        });
    }

    public final void Z0() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastLengthLimitToastAt < 2000) {
            return;
        }
        this.lastLengthLimitToastAt = jCurrentTimeMillis;
        Toast.makeText(this, R$string.oobe_name_length_limit, 0).show();
    }

    public final void b1(String text, InterfaceC5063a<Y8.t> onPass) throws Resources.NotFoundException {
        if (!com.stepos.agentframework.chatcore.utils.n.INSTANCE.a(this)) {
            a1(R$string.oobe_network_unavailable);
            return;
        }
        this.committingCustom = true;
        g6.d dVar = this.binding;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        dVar.btnCustomSubmit.setEnabled(false);
        g6.d dVar2 = this.binding;
        if (dVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar2 = null;
        }
        dVar2.btnNext.setEnabled(false);
        Ua.M m10 = this.viewScope;
        if (m10 == null) {
            K0();
        } else {
            C1060i.d(m10, null, null, new SdkInitSoulActivity$textSecurityCheck$1(text, this, onPass, null), 3, null);
        }
    }

    public final void c1() {
        if (this.customCommitted) {
            if (this.isKeyboardVisible) {
                w0();
            }
            g6.d dVar = this.binding;
            g6.d dVar2 = null;
            if (dVar == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar = null;
            }
            String string = dVar.tvCustomLabel.getText().toString();
            boolean zContains = this.selectedTexts.contains(string);
            boolean z10 = !zContains;
            g6.d dVar3 = this.binding;
            if (dVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar3 = null;
            }
            dVar3.customOptionRow.setSelected(z10);
            g6.d dVar4 = this.binding;
            if (dVar4 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                dVar2 = dVar4;
            }
            dVar2.ivCustomCheck.setImageResource(!zContains ? R$drawable.ic_oobe_soul_checked : R$drawable.ic_oobe_soul_unchecked);
            if (zContains) {
                this.selectedTexts.remove(string);
                C4059a.INSTANCE.f(C4059a.QUESTION_COMMON_STYLE, C4059a.ACTION_TAG_UNSELECT);
            } else {
                this.selectedTexts.add(string);
                C4059a.INSTANCE.f(C4059a.QUESTION_COMMON_STYLE, C4059a.ACTION_TAG_SELECT);
            }
            f1();
        }
    }

    public final void d1(Option option) throws Resources.NotFoundException {
        if (I0().length() > 0) {
            o0(this, null, 1, null);
        } else if (this.isKeyboardVisible) {
            w0();
        }
        String string = option.getLabel().getText().toString();
        boolean zContains = this.selectedTexts.contains(string);
        option.getContainer().setSelected(!zContains);
        option.getCheck().setImageResource(!zContains ? R$drawable.ic_oobe_soul_checked : R$drawable.ic_oobe_soul_unchecked);
        if (zContains) {
            this.selectedTexts.remove(string);
            C4059a.INSTANCE.f(C4059a.QUESTION_COMMON_STYLE, C4059a.ACTION_TAG_UNSELECT);
        } else {
            this.selectedTexts.add(string);
            C4059a.INSTANCE.f(C4059a.QUESTION_COMMON_STYLE, C4059a.ACTION_TAG_SELECT);
        }
        f1();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0097  */
    @Override // android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.p.i(r8, r0)
            int r0 = r8.getAction()
            if (r0 != 0) goto Lcf
            boolean r0 = r7.isKeyboardVisible
            if (r0 == 0) goto Lcf
            g6.d r0 = r7.binding
            r1 = 0
            java.lang.String r2 = "binding"
            if (r0 != 0) goto L1a
            kotlin.jvm.internal.p.A(r2)
            r0 = r1
        L1a:
            android.widget.LinearLayout r0 = r0.customEditRow
            int r0 = r0.getVisibility()
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L3b
            g6.d r0 = r7.binding
            if (r0 != 0) goto L2c
            kotlin.jvm.internal.p.A(r2)
            r0 = r1
        L2c:
            android.widget.LinearLayout r0 = r0.customEditRow
            java.lang.String r5 = "customEditRow"
            kotlin.jvm.internal.p.h(r0, r5)
            boolean r0 = r7.B0(r8, r0)
            if (r0 == 0) goto L3b
            r0 = r4
            goto L3c
        L3b:
            r0 = r3
        L3c:
            g6.d r5 = r7.binding
            if (r5 != 0) goto L44
            kotlin.jvm.internal.p.A(r2)
            r5 = r1
        L44:
            android.widget.ImageButton r5 = r5.btnCustomSubmit
            int r5 = r5.getVisibility()
            if (r5 != 0) goto L63
            g6.d r5 = r7.binding
            if (r5 != 0) goto L54
            kotlin.jvm.internal.p.A(r2)
            r5 = r1
        L54:
            android.widget.ImageButton r5 = r5.btnCustomSubmit
            java.lang.String r6 = "btnCustomSubmit"
            kotlin.jvm.internal.p.h(r5, r6)
            boolean r5 = r7.B0(r8, r5)
            if (r5 == 0) goto L63
            r5 = r4
            goto L64
        L63:
            r5 = r3
        L64:
            g6.d r6 = r7.binding
            if (r6 != 0) goto L6c
            kotlin.jvm.internal.p.A(r2)
            r6 = r1
        L6c:
            android.widget.ImageButton r6 = r6.btnNext
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L8c
            g6.d r6 = r7.binding
            if (r6 != 0) goto L7c
            kotlin.jvm.internal.p.A(r2)
            goto L7d
        L7c:
            r1 = r6
        L7d:
            android.widget.ImageButton r1 = r1.btnNext
            java.lang.String r2 = "btnNext"
            kotlin.jvm.internal.p.h(r1, r2)
            boolean r1 = r7.B0(r8, r1)
            if (r1 == 0) goto L8c
            r1 = r4
            goto L8d
        L8c:
            r1 = r3
        L8d:
            java.lang.String r2 = r7.I0()
            int r2 = r2.length()
            if (r2 <= 0) goto Lc4
            java.util.List<com.stepos.ailauncher.oobe.SdkInitSoulActivity$b> r2 = r7.options
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r6 = r2 instanceof java.util.Collection
            if (r6 == 0) goto La9
            r6 = r2
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto La9
            goto Lc4
        La9:
            java.util.Iterator r2 = r2.iterator()
        Lad:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto Lc4
            java.lang.Object r6 = r2.next()
            com.stepos.ailauncher.oobe.SdkInitSoulActivity$b r6 = (com.stepos.ailauncher.oobe.SdkInitSoulActivity.Option) r6
            android.view.View r6 = r6.getContainer()
            boolean r6 = r7.B0(r8, r6)
            if (r6 == 0) goto Lad
            r3 = r4
        Lc4:
            if (r0 != 0) goto Lcf
            if (r5 != 0) goto Lcf
            if (r1 != 0) goto Lcf
            if (r3 != 0) goto Lcf
            r7.w0()
        Lcf:
            boolean r7 = super.dispatchTouchEvent(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.oobe.SdkInitSoulActivity.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void e0(String text) {
        this.customCommitted = true;
        this.selectedTexts.add(text);
        g6.d dVar = this.binding;
        g6.d dVar2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        dVar.tvCustomLabel.setText(text);
        g6.d dVar3 = this.binding;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar3 = null;
        }
        dVar3.customEditRow.setVisibility(8);
        g6.d dVar4 = this.binding;
        if (dVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar4 = null;
        }
        dVar4.btnCreate.setVisibility(8);
        g6.d dVar5 = this.binding;
        if (dVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar5 = null;
        }
        dVar5.customOptionRow.setVisibility(0);
        g6.d dVar6 = this.binding;
        if (dVar6 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar6 = null;
        }
        dVar6.customOptionRow.setSelected(true);
        g6.d dVar7 = this.binding;
        if (dVar7 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar7 = null;
        }
        dVar7.ivCustomCheck.setImageResource(R$drawable.ic_oobe_soul_checked);
        this.suppressTextInputTrack = true;
        g6.d dVar8 = this.binding;
        if (dVar8 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            dVar2 = dVar8;
        }
        dVar2.etCustom.setText("");
        this.suppressTextInputTrack = false;
        w0();
        f1();
        C4059a.INSTANCE.f(C4059a.QUESTION_COMMON_STYLE, C4059a.ACTION_CUSTOM_ADD);
    }

    public final void f0() {
        InputFilter inputFilter = new InputFilter() { // from class: com.stepos.ailauncher.oobe.m0
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
                return SdkInitSoulActivity.g0(this.f27615a, charSequence, i10, i11, spanned, i12, i13);
            }
        };
        g6.d dVar = this.binding;
        g6.d dVar2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        EditText editText = dVar.etCustom;
        g6.d dVar3 = this.binding;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            dVar2 = dVar3;
        }
        InputFilter[] filters = dVar2.etCustom.getFilters();
        kotlin.jvm.internal.p.h(filters, "getFilters(...)");
        ArrayList arrayList = new ArrayList();
        for (InputFilter inputFilter2 : filters) {
            if (!(inputFilter2 instanceof InputFilter.LengthFilter)) {
                arrayList.add(inputFilter2);
            }
        }
        editText.setFilters((InputFilter[]) C1168p.F(arrayList.toArray(new InputFilter[0]), inputFilter));
    }

    public final void i0(float fraction) {
        float fM = C5685n.m(fraction, 0.0f, 1.0f);
        g6.d dVar = this.binding;
        g6.d dVar2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        dVar.optionScroll.getChildAt(0).setTranslationY(this.imeContentOffset * (1.0f - fM));
        boolean z10 = this.isKeyboardVisible;
        float f10 = z10 ? 0.0f : 1.0f;
        float f11 = z10 ? 1.0f : 0.0f;
        g6.d dVar3 = this.binding;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar3 = null;
        }
        TextView textView = dVar3.tvQuestion;
        float f12 = this.imeStartQuestionAlpha;
        textView.setAlpha(f12 + ((f10 - f12) * fM));
        g6.d dVar4 = this.binding;
        if (dVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            dVar2 = dVar4;
        }
        TextView textView2 = dVar2.tvCompactTitle;
        float f13 = this.imeStartCompactAlpha;
        textView2.setAlpha(f13 + ((f11 - f13) * fM));
    }

    public final void j0() {
        boolean z10 = this.isKeyboardVisible;
        g6.d dVar = null;
        if (z10) {
            g6.d dVar2 = this.binding;
            if (dVar2 == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar2 = null;
            }
            dVar2.tvQuestion.setVisibility(8);
            g6.d dVar3 = this.binding;
            if (dVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar3 = null;
            }
            dVar3.tvCompactTitle.setVisibility(0);
            g6.d dVar4 = this.binding;
            if (dVar4 == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar4 = null;
            }
            dVar4.titleBar.setTitleTextColor(androidx.core.content.a.c(this, android.R.color.transparent));
        } else {
            g6.d dVar5 = this.binding;
            if (dVar5 == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar5 = null;
            }
            dVar5.tvQuestion.setVisibility(0);
            g6.d dVar6 = this.binding;
            if (dVar6 == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar6 = null;
            }
            dVar6.tvCompactTitle.setVisibility(8);
            g6.d dVar7 = this.binding;
            if (dVar7 == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar7 = null;
            }
            dVar7.titleBar.setTitle(getString(R$string.oobe_sdk_init_soul_step));
            g6.d dVar8 = this.binding;
            if (dVar8 == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar8 = null;
            }
            dVar8.titleBar.setTitleTextColor(androidx.core.content.a.c(this, R$color.oobe_step_text));
        }
        if (!t0()) {
            g6.d dVar9 = this.binding;
            if (dVar9 == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar9 = null;
            }
            dVar9.tvQuestion.setAlpha(z10 ? 0.0f : 1.0f);
            g6.d dVar10 = this.binding;
            if (dVar10 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                dVar = dVar10;
            }
            dVar.tvCompactTitle.setAlpha(z10 ? 1.0f : 0.0f);
        }
        f1();
    }

    public final void k0(int extraLift) {
        g6.d dVar = this.binding;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        NestedScrollView optionScroll = dVar.optionScroll;
        kotlin.jvm.internal.p.h(optionScroll, "optionScroll");
        int iX0 = extraLift > 0 ? x0() : 0;
        g6.d dVar2 = this.binding;
        if (dVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar2 = null;
        }
        Integer numValueOf = Integer.valueOf(dVar2.titleBar.getHeight());
        Integer num = numValueOf.intValue() > 0 ? numValueOf : null;
        int iF = C5685n.f((num != null ? num.intValue() : getResources().getDimensionPixelSize(R.dimen.stepos_titlebar_collapsed_height)) - iX0, 0);
        int iD0 = extraLift > 0 ? extraLift + iX0 + D0() : this.optionScrollIdlePaddingBottom;
        if (optionScroll.getPaddingTop() == iF && optionScroll.getPaddingBottom() == iD0) {
            return;
        }
        optionScroll.setPadding(optionScroll.getPaddingLeft(), iF, optionScroll.getPaddingRight(), iD0);
    }

    public final LinkedHashSet<String> m0() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(this.selectedTexts);
        String strI0 = I0();
        if (strI0.length() > 0) {
            linkedHashSet.add(strI0);
        }
        return linkedHashSet;
    }

    public final void n0(final InterfaceC5063a<Y8.t> onCommitted) throws Resources.NotFoundException {
        String string;
        g6.d dVar = this.binding;
        final String string2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        Editable text = dVar.etCustom.getText();
        if (text != null && (string = text.toString()) != null) {
            string2 = La.H.D1(string).toString();
        }
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() == 0) {
            Toast.makeText(this, R$string.oobe_text_empty, 0).show();
        } else {
            if (this.committingCustom || this.customCommitted || this.isNavigating || System.currentTimeMillis() - this.lastSubmitFailToastAt < 2000) {
                return;
            }
            b1(string2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.oobe.o0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return SdkInitSoulActivity.p0(this.f27618a, string2, onCommitted);
                }
            });
        }
    }

    @Override // com.stepos.ailauncher.oobe.N, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C4059a.INSTANCE.g(C4059a.STEP_PREFERENCE, getString(R$string.oobe_sdk_init_soul_question));
        g6.d dVarC = g6.d.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(dVarC, "inflate(...)");
        this.binding = dVarC;
        if (dVarC == null) {
            kotlin.jvm.internal.p.A("binding");
            dVarC = null;
        }
        setContentView(dVarC.b());
        initView();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isNavigating = false;
    }

    public final void s0() {
        if (this.customCommitted) {
            g6.d dVar = this.binding;
            g6.d dVar2 = null;
            if (dVar == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar = null;
            }
            String string = dVar.tvCustomLabel.getText().toString();
            this.selectedTexts.remove(string);
            this.customCommitted = false;
            this.suppressTextInputTrack = true;
            g6.d dVar3 = this.binding;
            if (dVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
                dVar3 = null;
            }
            dVar3.etCustom.setText(string);
            this.suppressTextInputTrack = false;
            g6.d dVar4 = this.binding;
            if (dVar4 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                dVar2 = dVar4;
            }
            dVar2.etCustom.setSelection(string.length());
            X0();
        }
    }

    public final boolean t0() {
        return this.activeImeAnimation != null;
    }

    public final void u0() {
        J0();
        C4059a.INSTANCE.d(C4059a.STEP_PREFERENCE, "next", Z8.F.A0(m0(), Const.STR_MART_COMMA, null, null, 0, null, null, 62, null));
        startActivity(new Intent(this, (Class<?>) SdkInitUserActivity.class));
    }

    public final void v0() {
        if (this.customCommitted) {
            return;
        }
        g6.d dVar = this.binding;
        g6.d dVar2 = null;
        if (dVar == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar = null;
        }
        dVar.customEditRow.setVisibility(8);
        g6.d dVar3 = this.binding;
        if (dVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            dVar3 = null;
        }
        dVar3.btnCustomSubmit.setVisibility(8);
        g6.d dVar4 = this.binding;
        if (dVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            dVar2 = dVar4;
        }
        dVar2.btnCreate.setVisibility(0);
        f1();
    }

    public final int x0() {
        return getResources().getDimensionPixelSize(R$dimen.oobe_soul_ime_content_extra);
    }
}
