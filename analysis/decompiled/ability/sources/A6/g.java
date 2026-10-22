package A6;

import H4.o;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import com.stepos.ability.R;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.dialog.StepOSAlertDialogLayout;

/* loaded from: classes3.dex */
public final class g extends Dialog implements DialogInterface {
    public static final /* synthetic */ int b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final f f146a;

    public g(ContextThemeWrapper contextThemeWrapper) {
        super(contextThemeWrapper, R.style.Theme_VoiceWakeup_Dialog_Confirmation);
        Context context = getContext();
        kotlin.jvm.internal.k.e(context, "getContext(...)");
        Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Dialog window is null; check the dialog theme");
        }
        this.f146a = new f(context, this, window);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        this.f146a.f134V.removeCallbacksAndMessages(null);
        super.dismiss();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        StepOSAlertDialogLayout stepOSAlertDialogLayout;
        View viewC;
        NestedScrollView nestedScrollView;
        ConstraintLayout constraintLayout;
        super.onCreate(bundle);
        f fVar = this.f146a;
        boolean z10 = fVar.e;
        fVar.b.setContentView(fVar.d);
        Window window = fVar.c;
        View viewFindViewById = window.findViewById(R.id.stepos_dialog_parent_panel);
        f.c(viewFindViewById.findViewById(R.id.stepos_dialog_top_panel));
        f.c(viewFindViewById.findViewById(R.id.stepos_dialog_scroll_view));
        f.c(viewFindViewById.findViewById(R.id.stepos_dialog_custom_panel));
        View viewFindViewById2 = viewFindViewById.findViewById(R.id.stepos_dialog_top_panel);
        View viewFindViewById3 = viewFindViewById.findViewById(R.id.stepos_dialog_content_panel);
        View viewFindViewById4 = viewFindViewById.findViewById(R.id.stepos_dialog_button_panel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById.findViewById(R.id.stepos_dialog_custom_panel);
        kotlin.jvm.internal.k.c(viewGroup);
        Window window2 = fVar.c;
        fVar.m = false;
        fVar.o = null;
        window2.setFlags(131072, 131072);
        if (fVar.n) {
            fVar.a();
        }
        viewGroup.setVisibility(8);
        NestedScrollView nestedScrollView2 = viewGroup instanceof NestedScrollView ? (NestedScrollView) viewGroup : null;
        if (nestedScrollView2 != null || (nestedScrollView2 = (NestedScrollView) fVar.c.findViewById(R.id.stepos_dialog_custom_panel)) != null) {
            nestedScrollView2.setHorizontalScrollBarEnabled(false);
            nestedScrollView2.setVerticalScrollBarEnabled(false);
            nestedScrollView2.setScrollbarFadingEnabled(false);
        }
        ViewGroup viewGroupG = f.g(viewGroup.findViewById(R.id.stepos_dialog_top_panel), viewFindViewById2);
        ViewGroup viewGroupG2 = f.g(viewGroup.findViewById(R.id.stepos_dialog_content_panel), viewFindViewById3);
        ViewGroup viewGroupG3 = f.g(viewGroup.findViewById(R.id.stepos_dialog_button_panel), viewFindViewById4);
        if (viewGroupG2 != null) {
            NestedScrollView nestedScrollView3 = (NestedScrollView) window.findViewById(R.id.stepos_dialog_scroll_view);
            fVar.f139r = nestedScrollView3;
            nestedScrollView3.setFocusable(false);
            nestedScrollView3.setNestedScrollingEnabled(false);
            viewGroupG2.setVisibility(8);
        }
        fVar.i(viewGroupG3);
        if (viewGroupG != null && (constraintLayout = (ConstraintLayout) viewGroupG.findViewById(R.id.stepos_dialog_title_template)) != null) {
            ImageView imageView = (ImageView) window.findViewById(R.id.stepos_dialog_icon);
            TextView textView = (TextView) window.findViewById(R.id.stepos_dialog_title);
            fVar.p = textView;
            textView.setText(fVar.k);
            ImageView imageView2 = (ImageView) constraintLayout.findViewById(R.id.stepos_dialog_icon_badge);
            imageView2.setOutlineProvider(new e(fVar.f136a.getResources().getDimension(R.dimen.stepos_dialog_icon_badge_corner_radius)));
            imageView2.setClipToOutline(true);
            imageView.setVisibility(8);
            fVar.e();
        }
        boolean z11 = viewGroup.getVisibility() != 8;
        boolean z12 = (viewGroupG2 == null || viewGroupG2.getVisibility() == 8) ? false : true;
        char c = (viewGroupG == null || viewGroupG.getVisibility() == 8) ? (char) 0 : (char) 1;
        boolean z13 = (viewGroupG3 == null || viewGroupG3.getVisibility() == 8) ? false : true;
        View viewFindViewById5 = viewFindViewById.findViewById(R.id.stepos_dialog_middle_panel);
        if (viewFindViewById5 != null) {
            viewFindViewById5.setVisibility((z12 || z11) ? 0 : 8);
        }
        if (c != 0 && (nestedScrollView = fVar.f139r) != null) {
            nestedScrollView.setClipToPadding(true);
        }
        if (!z11 && !z10 && viewGroupG2 != null && fVar.f139r != null) {
            int i = (z13 ? (char) 2 : (char) 0) | c;
            View viewFindViewById6 = window.findViewById(R.id.stepos_dialog_scroll_indicator_up);
            View viewFindViewById7 = window.findViewById(R.id.stepos_dialog_scroll_indicator_down);
            if (viewFindViewById6 != null && (i & 1) == 0) {
                viewGroupG2.removeView(viewFindViewById6);
                viewFindViewById6 = null;
            }
            if (viewFindViewById7 != null && (2 & i) == 0) {
                viewGroupG2.removeView(viewFindViewById7);
                viewFindViewById7 = null;
            }
            if (viewFindViewById6 != null || viewFindViewById7 != null) {
                NestedScrollView nestedScrollView4 = fVar.f139r;
                if (fVar.l == null || nestedScrollView4 == null) {
                    if (viewFindViewById6 != null) {
                        viewGroupG2.removeView(viewFindViewById6);
                    }
                    if (viewFindViewById7 != null) {
                        viewGroupG2.removeView(viewFindViewById7);
                    }
                } else {
                    nestedScrollView4.setOnScrollChangeListener(new a(0, viewFindViewById6, viewFindViewById7));
                    nestedScrollView4.post(new A4.e(nestedScrollView4, viewFindViewById6, viewFindViewById7, 2));
                }
            }
        }
        fVar.j(viewFindViewById, viewGroupG, viewFindViewById5, viewGroupG2, viewGroup, viewGroupG3);
        fVar.n = true;
        StepOSAlertDialogLayout stepOSAlertDialogLayout2 = (StepOSAlertDialogLayout) window.findViewById(R.id.stepos_dialog_parent_panel);
        if (stepOSAlertDialogLayout2 != null) {
            stepOSAlertDialogLayout2.setGlassEnabled(fVar.f122J);
            stepOSAlertDialogLayout2.setGlassEffect(fVar.f123K);
        }
        TextView textView2 = fVar.p;
        boolean z14 = textView2 != null && textView2.getVisibility() == 0;
        if (textView2 != null && z14) {
            textView2.setGravity(GravityCompat.START);
        }
        TextView textView3 = fVar.f138q;
        if (textView3 != null && textView3.getVisibility() == 0) {
            textView3.setGravity(GravityCompat.START);
        }
        ViewGroup viewGroup2 = (ViewGroup) window.findViewById(R.id.stepos_dialog_custom_panel);
        if (viewGroup2 != null && viewGroup2.getVisibility() != 8 && (viewC = o.C(viewGroup2)) != null) {
            viewC.requestFocus();
        }
        if (fVar.f116C == 0) {
            fVar.f116C = fVar.b();
        }
        if (fVar.f116C > 0 && (stepOSAlertDialogLayout = (StepOSAlertDialogLayout) window.findViewById(R.id.stepos_dialog_parent_panel)) != null) {
            stepOSAlertDialogLayout.setMaxHeight(fVar.f116C);
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = fVar.f124L;
        attributes.gravity = 80;
        attributes.y = fVar.f125M;
        window.setAttributes(attributes);
        fVar.a();
        window.setElevation(0.0f);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent event) {
        kotlin.jvm.internal.k.f(event, "event");
        f fVar = this.f146a;
        fVar.getClass();
        NestedScrollView nestedScrollView = fVar.f139r;
        return (nestedScrollView != null && nestedScrollView.executeKeyEvent(event)) || super.onKeyDown(i, event);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent event) {
        kotlin.jvm.internal.k.f(event, "event");
        f fVar = this.f146a;
        fVar.getClass();
        NestedScrollView nestedScrollView = fVar.f139r;
        return (nestedScrollView != null && nestedScrollView.executeKeyEvent(event)) || super.onKeyUp(i, event);
    }

    @Override // android.app.Dialog
    public final void onStart() {
        ViewParent parent;
        super.onStart();
        f fVar = this.f146a;
        double dCeil = fVar.k != null ? 0.106d + (Math.ceil(r0.length() / 15.0d) * 0.03d) : 0.106d;
        if (fVar.l != null) {
            dCeil += Math.ceil(r0.length() / 19.0d) * 0.023d;
        }
        if (fVar.m) {
            dCeil += 0.3d;
        }
        int i = !TextUtils.isEmpty(fVar.u) ? 1 : 0;
        if (!TextUtils.isEmpty(fVar.f144x)) {
            i |= 2;
        }
        if (!TextUtils.isEmpty(fVar.f114A)) {
            i |= 4;
        }
        int iBitCount = Integer.bitCount(i & 7) - 1;
        if (iBitCount > 0) {
            StepOSButton stepOSButton = fVar.f141t;
            if (stepOSButton == null || (parent = stepOSButton.getParent()) == null) {
                StepOSButton stepOSButton2 = fVar.f143w;
                parent = stepOSButton2 != null ? stepOSButton2.getParent() : null;
                if (parent == null) {
                    StepOSButton stepOSButton3 = fVar.f145z;
                    parent = stepOSButton3 != null ? stepOSButton3.getParent() : null;
                }
            }
            LinearLayout linearLayout = parent instanceof LinearLayout ? (LinearLayout) parent : null;
            if (linearLayout != null && linearLayout.getOrientation() == 1) {
                dCeil += iBitCount * 0.063d;
            }
        }
        View view = fVar.o;
        boolean z10 = (view == null || o.C(view) == null) ? false : true;
        int i6 = dCeil < 0.33d ? z10 ? R.style.StepOSAnimation_Dialog_Alert_Input_Short : R.style.StepOSAnimation_Dialog_Alert_Short : dCeil < 0.65d ? z10 ? R.style.StepOSAnimation_Dialog_Alert_Input_Medium : R.style.StepOSAnimation_Dialog_Alert_Medium : R.style.StepOSAnimation_Dialog_Alert_Tall;
        Window window = fVar.b.getWindow();
        if (window != null) {
            window.setWindowAnimations(i6);
        }
    }

    @Override // android.app.Dialog
    public final void onStop() {
        this.f146a.f134V.removeCallbacksAndMessages(null);
        super.onStop();
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        f fVar = this.f146a;
        fVar.k = charSequence;
        TextView textView = fVar.p;
        if (textView != null) {
            textView.setText(charSequence);
        }
        fVar.e();
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        setTitle(getContext().getText(i));
    }
}
