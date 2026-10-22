package g6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.ailauncher.oobe.R$id;
import com.stepos.ailauncher.oobe.R$layout;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.glass.StepOSGlassPanel;
import com.stepos.widget.toolbar.StepOSTitleBar;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class b {
    public final Barrier bottomAnchor;
    public final StepOSButton btnFinish;
    public final ConstraintLayout configRoot;
    public final LinearLayout contentBlock;
    public final LinearLayout footerContent;
    public final StepOSGlassPanel footerPanel;
    private final ConstraintLayout rootView;
    public final StepOSTitleBar titleBar;
    public final TextView tvDesc;
    public final TextView tvTime;
    public final TextView tvTitle;
    public final WebView videoMascot;

    public b(ConstraintLayout constraintLayout, Barrier barrier, StepOSButton stepOSButton, ConstraintLayout constraintLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, StepOSGlassPanel stepOSGlassPanel, StepOSTitleBar stepOSTitleBar, TextView textView, TextView textView2, TextView textView3, WebView webView) {
        this.rootView = constraintLayout;
        this.bottomAnchor = barrier;
        this.btnFinish = stepOSButton;
        this.configRoot = constraintLayout2;
        this.contentBlock = linearLayout;
        this.footerContent = linearLayout2;
        this.footerPanel = stepOSGlassPanel;
        this.titleBar = stepOSTitleBar;
        this.tvDesc = textView;
        this.tvTime = textView2;
        this.tvTitle = textView3;
        this.videoMascot = webView;
    }

    public static b a(View view) {
        int i10 = R$id.bottom_anchor;
        Barrier barrier = (Barrier) C5437a.a(view, i10);
        if (barrier != null) {
            i10 = R$id.btn_finish;
            StepOSButton stepOSButton = (StepOSButton) C5437a.a(view, i10);
            if (stepOSButton != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i10 = R$id.content_block;
                LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout != null) {
                    i10 = R$id.footer_content;
                    LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout2 != null) {
                        i10 = R$id.footer_panel;
                        StepOSGlassPanel stepOSGlassPanel = (StepOSGlassPanel) C5437a.a(view, i10);
                        if (stepOSGlassPanel != null) {
                            i10 = R$id.title_bar;
                            StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) C5437a.a(view, i10);
                            if (stepOSTitleBar != null) {
                                i10 = R$id.tv_desc;
                                TextView textView = (TextView) C5437a.a(view, i10);
                                if (textView != null) {
                                    i10 = R$id.tv_time;
                                    TextView textView2 = (TextView) C5437a.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R$id.tv_title;
                                        TextView textView3 = (TextView) C5437a.a(view, i10);
                                        if (textView3 != null) {
                                            i10 = R$id.video_mascot;
                                            WebView webView = (WebView) C5437a.a(view, i10);
                                            if (webView != null) {
                                                return new b(constraintLayout, barrier, stepOSButton, constraintLayout, linearLayout, linearLayout2, stepOSGlassPanel, stepOSTitleBar, textView, textView2, textView3, webView);
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

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.oobe_activity_oobe_agent_config, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ConstraintLayout b() {
        return this.rootView;
    }
}
