package g6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.stepos.ailauncher.oobe.R$id;
import com.stepos.ailauncher.oobe.R$layout;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.glass.StepOSGlassPanel;
import com.stepos.widget.toolbar.StepOSAppBarLayout;
import com.stepos.widget.toolbar.StepOSCollapsingTitleBar;
import s1.C5437a;

/* renamed from: g6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4105a {
    public final CoordinatorLayout agreementRoot;
    public final StepOSAppBarLayout appBar;
    public final StepOSButton btnLater;
    public final StepOSButton btnNext;
    public final CheckBox cbAgreeAll;
    public final CheckBox cbImprovement;
    public final CheckBox cbUserAgreement;
    public final CheckBox cbVoiceprint;
    public final StepOSCollapsingTitleBar collapsingTitleBar;
    public final LinearLayout footerContent;
    public final StepOSGlassPanel footerPanel;
    public final View overlayCbAgreeAll;
    public final View overlayCbImprovement;
    public final View overlayCbUserAgreement;
    public final View overlayCbVoiceprint;
    private final CoordinatorLayout rootView;
    public final NestedScrollView scrollContent;
    public final TextView titleSection;
    public final TextView tvCompactTitle;

    public C4105a(CoordinatorLayout coordinatorLayout, CoordinatorLayout coordinatorLayout2, StepOSAppBarLayout stepOSAppBarLayout, StepOSButton stepOSButton, StepOSButton stepOSButton2, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, StepOSCollapsingTitleBar stepOSCollapsingTitleBar, LinearLayout linearLayout, StepOSGlassPanel stepOSGlassPanel, View view, View view2, View view3, View view4, NestedScrollView nestedScrollView, TextView textView, TextView textView2) {
        this.rootView = coordinatorLayout;
        this.agreementRoot = coordinatorLayout2;
        this.appBar = stepOSAppBarLayout;
        this.btnLater = stepOSButton;
        this.btnNext = stepOSButton2;
        this.cbAgreeAll = checkBox;
        this.cbImprovement = checkBox2;
        this.cbUserAgreement = checkBox3;
        this.cbVoiceprint = checkBox4;
        this.collapsingTitleBar = stepOSCollapsingTitleBar;
        this.footerContent = linearLayout;
        this.footerPanel = stepOSGlassPanel;
        this.overlayCbAgreeAll = view;
        this.overlayCbImprovement = view2;
        this.overlayCbUserAgreement = view3;
        this.overlayCbVoiceprint = view4;
        this.scrollContent = nestedScrollView;
        this.titleSection = textView;
        this.tvCompactTitle = textView2;
    }

    public static C4105a a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
        int i10 = R$id.app_bar;
        StepOSAppBarLayout stepOSAppBarLayout = (StepOSAppBarLayout) C5437a.a(view, i10);
        if (stepOSAppBarLayout != null) {
            i10 = R$id.btn_later;
            StepOSButton stepOSButton = (StepOSButton) C5437a.a(view, i10);
            if (stepOSButton != null) {
                i10 = R$id.btn_next;
                StepOSButton stepOSButton2 = (StepOSButton) C5437a.a(view, i10);
                if (stepOSButton2 != null) {
                    i10 = R$id.cb_agree_all;
                    CheckBox checkBox = (CheckBox) C5437a.a(view, i10);
                    if (checkBox != null) {
                        i10 = R$id.cb_improvement;
                        CheckBox checkBox2 = (CheckBox) C5437a.a(view, i10);
                        if (checkBox2 != null) {
                            i10 = R$id.cb_user_agreement;
                            CheckBox checkBox3 = (CheckBox) C5437a.a(view, i10);
                            if (checkBox3 != null) {
                                i10 = R$id.cb_voiceprint;
                                CheckBox checkBox4 = (CheckBox) C5437a.a(view, i10);
                                if (checkBox4 != null) {
                                    i10 = R$id.collapsing_title_bar;
                                    StepOSCollapsingTitleBar stepOSCollapsingTitleBar = (StepOSCollapsingTitleBar) C5437a.a(view, i10);
                                    if (stepOSCollapsingTitleBar != null) {
                                        i10 = R$id.footer_content;
                                        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                                        if (linearLayout != null) {
                                            i10 = R$id.footer_panel;
                                            StepOSGlassPanel stepOSGlassPanel = (StepOSGlassPanel) C5437a.a(view, i10);
                                            if (stepOSGlassPanel != null && (viewA = C5437a.a(view, (i10 = R$id.overlay_cb_agree_all))) != null && (viewA2 = C5437a.a(view, (i10 = R$id.overlay_cb_improvement))) != null && (viewA3 = C5437a.a(view, (i10 = R$id.overlay_cb_user_agreement))) != null && (viewA4 = C5437a.a(view, (i10 = R$id.overlay_cb_voiceprint))) != null) {
                                                i10 = R$id.scroll_content;
                                                NestedScrollView nestedScrollView = (NestedScrollView) C5437a.a(view, i10);
                                                if (nestedScrollView != null) {
                                                    i10 = R$id.title_section;
                                                    TextView textView = (TextView) C5437a.a(view, i10);
                                                    if (textView != null) {
                                                        i10 = R$id.tv_compact_title;
                                                        TextView textView2 = (TextView) C5437a.a(view, i10);
                                                        if (textView2 != null) {
                                                            return new C4105a(coordinatorLayout, coordinatorLayout, stepOSAppBarLayout, stepOSButton, stepOSButton2, checkBox, checkBox2, checkBox3, checkBox4, stepOSCollapsingTitleBar, linearLayout, stepOSGlassPanel, viewA, viewA2, viewA3, viewA4, nestedScrollView, textView, textView2);
                                                        }
                                                    }
                                                }
                                            }
                                        }
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

    public static C4105a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C4105a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.oobe_activity_agreement, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public CoordinatorLayout b() {
        return this.rootView;
    }
}
