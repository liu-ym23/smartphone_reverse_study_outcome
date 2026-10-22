package g6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewpager2.widget.ViewPager2;
import com.stepos.ailauncher.oobe.R$id;
import com.stepos.ailauncher.oobe.R$layout;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.toolbar.StepOSTitleBar;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class f {
    public final StepOSButton btnGotIt;
    public final View dotKeyboard;
    public final View dotVoice;
    public final Guideline guideSheetTop;
    public final View overlayScrim;
    public final LinearLayout pageIndicator;
    public final ViewPager2 pager;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final ConstraintLayout sheet;
    public final View sideKeyBar;
    public final StepOSTitleBar titleBar;
    public final TextView tvCaption;
    public final TextView tvTitle;

    public f(ConstraintLayout constraintLayout, StepOSButton stepOSButton, View view, View view2, Guideline guideline, View view3, LinearLayout linearLayout, ViewPager2 viewPager2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, View view4, StepOSTitleBar stepOSTitleBar, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnGotIt = stepOSButton;
        this.dotKeyboard = view;
        this.dotVoice = view2;
        this.guideSheetTop = guideline;
        this.overlayScrim = view3;
        this.pageIndicator = linearLayout;
        this.pager = viewPager2;
        this.root = constraintLayout2;
        this.sheet = constraintLayout3;
        this.sideKeyBar = view4;
        this.titleBar = stepOSTitleBar;
        this.tvCaption = textView;
        this.tvTitle = textView2;
    }

    public static f a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        int i10 = R$id.btn_got_it;
        StepOSButton stepOSButton = (StepOSButton) C5437a.a(view, i10);
        if (stepOSButton != null && (viewA = C5437a.a(view, (i10 = R$id.dot_keyboard))) != null && (viewA2 = C5437a.a(view, (i10 = R$id.dot_voice))) != null) {
            i10 = R$id.guide_sheet_top;
            Guideline guideline = (Guideline) C5437a.a(view, i10);
            if (guideline != null && (viewA3 = C5437a.a(view, (i10 = R$id.overlay_scrim))) != null) {
                i10 = R$id.page_indicator;
                LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout != null) {
                    i10 = R$id.pager;
                    ViewPager2 viewPager2 = (ViewPager2) C5437a.a(view, i10);
                    if (viewPager2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i10 = R$id.sheet;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) C5437a.a(view, i10);
                        if (constraintLayout2 != null && (viewA4 = C5437a.a(view, (i10 = R$id.side_key_bar))) != null) {
                            i10 = R$id.title_bar;
                            StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) C5437a.a(view, i10);
                            if (stepOSTitleBar != null) {
                                i10 = R$id.tv_caption;
                                TextView textView = (TextView) C5437a.a(view, i10);
                                if (textView != null) {
                                    i10 = R$id.tv_title;
                                    TextView textView2 = (TextView) C5437a.a(view, i10);
                                    if (textView2 != null) {
                                        return new f(constraintLayout, stepOSButton, viewA, viewA2, guideline, viewA3, linearLayout, viewPager2, constraintLayout, constraintLayout2, viewA4, stepOSTitleBar, textView, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static f b(LayoutInflater layoutInflater) {
        return c(layoutInflater, null, false);
    }

    public static f c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.oobe_activity_wake_anywhere, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
