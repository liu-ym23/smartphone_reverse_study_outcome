package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import com.stepos.ailauncher.agent.skill.widget.IndeterminateSpinnerView;
import com.stepos.ailauncher.agent.skill.widget.ProgressSplitTextView;
import s1.C5437a;

/* renamed from: Y4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1117a {
    public final FrameLayout actionArea;
    public final LinearLayout barInstallSuccess;
    public final ProgressSplitTextView btnBottom;
    public final TextView btnDebugLogClear;
    public final TextView btnDebugLogClose;
    public final TextView btnDebugLogToggle;
    public final TextView btnReadmeViewFull;
    public final FrameLayout btnTopUninstall;
    public final LinearLayout cardReadme;
    public final LinearLayout containerSkills;
    public final FrameLayout flDebugLogContainer;
    public final FrameLayout flDescriptionWrap;
    public final FrameLayout footerContainer;
    public final HorizontalScrollView hsvDebugLog;
    public final ImageView ivBack;
    public final ImageView ivSkillIcon;
    public final ImageView ivTopUninstall;
    public final LinearLayout llDescriptionToggle;
    public final LinearLayout llUpdateBanner;
    public final IndeterminateSpinnerView pbBottom;
    public final IndeterminateSpinnerView pbTopUninstall;
    public final FrameLayout root;
    private final FrameLayout rootView;
    public final C rowCategory;
    public final C rowCreated;
    public final C rowDownload;
    public final C rowUpdated;
    public final C rowVersion;
    public final ScrollView scrollView;
    public final ScrollView svDebugLog;
    public final LinearLayout toolbar;
    public final TextView tvDebugLog;
    public final TextView tvDescription;
    public final TextView tvDescriptionToggle;
    public final TextView tvMeta;
    public final TextView tvReadme;
    public final TextView tvReadmeSectionTitle;
    public final TextView tvSkillIconChar;
    public final TextView tvSkillSectionTitle;
    public final TextView tvStatusBadge;
    public final TextView tvTitle;
    public final TextView tvUpdateBannerTitle;
    public final View vBottomMask;
    public final View vDescriptionFade;
    public final View vTopMask;

    public C1117a(FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, ProgressSplitTextView progressSplitTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, FrameLayout frameLayout3, LinearLayout linearLayout2, LinearLayout linearLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5, FrameLayout frameLayout6, HorizontalScrollView horizontalScrollView, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout4, LinearLayout linearLayout5, IndeterminateSpinnerView indeterminateSpinnerView, IndeterminateSpinnerView indeterminateSpinnerView2, FrameLayout frameLayout7, C c10, C c11, C c12, C c13, C c14, ScrollView scrollView, ScrollView scrollView2, LinearLayout linearLayout6, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, View view, View view2, View view3) {
        this.rootView = frameLayout;
        this.actionArea = frameLayout2;
        this.barInstallSuccess = linearLayout;
        this.btnBottom = progressSplitTextView;
        this.btnDebugLogClear = textView;
        this.btnDebugLogClose = textView2;
        this.btnDebugLogToggle = textView3;
        this.btnReadmeViewFull = textView4;
        this.btnTopUninstall = frameLayout3;
        this.cardReadme = linearLayout2;
        this.containerSkills = linearLayout3;
        this.flDebugLogContainer = frameLayout4;
        this.flDescriptionWrap = frameLayout5;
        this.footerContainer = frameLayout6;
        this.hsvDebugLog = horizontalScrollView;
        this.ivBack = imageView;
        this.ivSkillIcon = imageView2;
        this.ivTopUninstall = imageView3;
        this.llDescriptionToggle = linearLayout4;
        this.llUpdateBanner = linearLayout5;
        this.pbBottom = indeterminateSpinnerView;
        this.pbTopUninstall = indeterminateSpinnerView2;
        this.root = frameLayout7;
        this.rowCategory = c10;
        this.rowCreated = c11;
        this.rowDownload = c12;
        this.rowUpdated = c13;
        this.rowVersion = c14;
        this.scrollView = scrollView;
        this.svDebugLog = scrollView2;
        this.toolbar = linearLayout6;
        this.tvDebugLog = textView5;
        this.tvDescription = textView6;
        this.tvDescriptionToggle = textView7;
        this.tvMeta = textView8;
        this.tvReadme = textView9;
        this.tvReadmeSectionTitle = textView10;
        this.tvSkillIconChar = textView11;
        this.tvSkillSectionTitle = textView12;
        this.tvStatusBadge = textView13;
        this.tvTitle = textView14;
        this.tvUpdateBannerTitle = textView15;
        this.vBottomMask = view;
        this.vDescriptionFade = view2;
        this.vTopMask = view3;
    }

    public static C1117a a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i10 = R$id.action_area;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null) {
            i10 = R$id.bar_install_success;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                i10 = R$id.btn_bottom;
                ProgressSplitTextView progressSplitTextView = (ProgressSplitTextView) C5437a.a(view, i10);
                if (progressSplitTextView != null) {
                    i10 = R$id.btn_debug_log_clear;
                    TextView textView = (TextView) C5437a.a(view, i10);
                    if (textView != null) {
                        i10 = R$id.btn_debug_log_close;
                        TextView textView2 = (TextView) C5437a.a(view, i10);
                        if (textView2 != null) {
                            i10 = R$id.btn_debug_log_toggle;
                            TextView textView3 = (TextView) C5437a.a(view, i10);
                            if (textView3 != null) {
                                i10 = R$id.btn_readme_view_full;
                                TextView textView4 = (TextView) C5437a.a(view, i10);
                                if (textView4 != null) {
                                    i10 = R$id.btn_top_uninstall;
                                    FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
                                    if (frameLayout2 != null) {
                                        i10 = R$id.card_readme;
                                        LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                                        if (linearLayout2 != null) {
                                            i10 = R$id.container_skills;
                                            LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                                            if (linearLayout3 != null) {
                                                i10 = R$id.fl_debug_log_container;
                                                FrameLayout frameLayout3 = (FrameLayout) C5437a.a(view, i10);
                                                if (frameLayout3 != null) {
                                                    i10 = R$id.fl_description_wrap;
                                                    FrameLayout frameLayout4 = (FrameLayout) C5437a.a(view, i10);
                                                    if (frameLayout4 != null) {
                                                        i10 = R$id.footer_container;
                                                        FrameLayout frameLayout5 = (FrameLayout) C5437a.a(view, i10);
                                                        if (frameLayout5 != null) {
                                                            i10 = R$id.hsv_debug_log;
                                                            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) C5437a.a(view, i10);
                                                            if (horizontalScrollView != null) {
                                                                i10 = R$id.iv_back;
                                                                ImageView imageView = (ImageView) C5437a.a(view, i10);
                                                                if (imageView != null) {
                                                                    i10 = R$id.iv_skill_icon;
                                                                    ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                                                    if (imageView2 != null) {
                                                                        i10 = R$id.iv_top_uninstall;
                                                                        ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                                                                        if (imageView3 != null) {
                                                                            i10 = R$id.ll_description_toggle;
                                                                            LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                                                            if (linearLayout4 != null) {
                                                                                i10 = R$id.ll_update_banner;
                                                                                LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                                                                                if (linearLayout5 != null) {
                                                                                    i10 = R$id.pb_bottom;
                                                                                    IndeterminateSpinnerView indeterminateSpinnerView = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                                    if (indeterminateSpinnerView != null) {
                                                                                        i10 = R$id.pb_top_uninstall;
                                                                                        IndeterminateSpinnerView indeterminateSpinnerView2 = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                                        if (indeterminateSpinnerView2 != null) {
                                                                                            FrameLayout frameLayout6 = (FrameLayout) view;
                                                                                            i10 = R$id.row_category;
                                                                                            View viewA4 = C5437a.a(view, i10);
                                                                                            if (viewA4 != null) {
                                                                                                C cA = C.a(viewA4);
                                                                                                i10 = R$id.row_created;
                                                                                                View viewA5 = C5437a.a(view, i10);
                                                                                                if (viewA5 != null) {
                                                                                                    C cA2 = C.a(viewA5);
                                                                                                    i10 = R$id.row_download;
                                                                                                    View viewA6 = C5437a.a(view, i10);
                                                                                                    if (viewA6 != null) {
                                                                                                        C cA3 = C.a(viewA6);
                                                                                                        i10 = R$id.row_updated;
                                                                                                        View viewA7 = C5437a.a(view, i10);
                                                                                                        if (viewA7 != null) {
                                                                                                            C cA4 = C.a(viewA7);
                                                                                                            i10 = R$id.row_version;
                                                                                                            View viewA8 = C5437a.a(view, i10);
                                                                                                            if (viewA8 != null) {
                                                                                                                C cA5 = C.a(viewA8);
                                                                                                                i10 = R$id.scroll_view;
                                                                                                                ScrollView scrollView = (ScrollView) C5437a.a(view, i10);
                                                                                                                if (scrollView != null) {
                                                                                                                    i10 = R$id.sv_debug_log;
                                                                                                                    ScrollView scrollView2 = (ScrollView) C5437a.a(view, i10);
                                                                                                                    if (scrollView2 != null) {
                                                                                                                        i10 = R$id.toolbar;
                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) C5437a.a(view, i10);
                                                                                                                        if (linearLayout6 != null) {
                                                                                                                            i10 = R$id.tv_debug_log;
                                                                                                                            TextView textView5 = (TextView) C5437a.a(view, i10);
                                                                                                                            if (textView5 != null) {
                                                                                                                                i10 = R$id.tv_description;
                                                                                                                                TextView textView6 = (TextView) C5437a.a(view, i10);
                                                                                                                                if (textView6 != null) {
                                                                                                                                    i10 = R$id.tv_description_toggle;
                                                                                                                                    TextView textView7 = (TextView) C5437a.a(view, i10);
                                                                                                                                    if (textView7 != null) {
                                                                                                                                        i10 = R$id.tv_meta;
                                                                                                                                        TextView textView8 = (TextView) C5437a.a(view, i10);
                                                                                                                                        if (textView8 != null) {
                                                                                                                                            i10 = R$id.tv_readme;
                                                                                                                                            TextView textView9 = (TextView) C5437a.a(view, i10);
                                                                                                                                            if (textView9 != null) {
                                                                                                                                                i10 = R$id.tv_readme_section_title;
                                                                                                                                                TextView textView10 = (TextView) C5437a.a(view, i10);
                                                                                                                                                if (textView10 != null) {
                                                                                                                                                    i10 = R$id.tv_skill_icon_char;
                                                                                                                                                    TextView textView11 = (TextView) C5437a.a(view, i10);
                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                        i10 = R$id.tv_skill_section_title;
                                                                                                                                                        TextView textView12 = (TextView) C5437a.a(view, i10);
                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                            i10 = R$id.tv_status_badge;
                                                                                                                                                            TextView textView13 = (TextView) C5437a.a(view, i10);
                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                i10 = R$id.tv_title;
                                                                                                                                                                TextView textView14 = (TextView) C5437a.a(view, i10);
                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                    i10 = R$id.tv_update_banner_title;
                                                                                                                                                                    TextView textView15 = (TextView) C5437a.a(view, i10);
                                                                                                                                                                    if (textView15 != null && (viewA = C5437a.a(view, (i10 = R$id.v_bottom_mask))) != null && (viewA2 = C5437a.a(view, (i10 = R$id.v_description_fade))) != null && (viewA3 = C5437a.a(view, (i10 = R$id.v_top_mask))) != null) {
                                                                                                                                                                        return new C1117a(frameLayout6, frameLayout, linearLayout, progressSplitTextView, textView, textView2, textView3, textView4, frameLayout2, linearLayout2, linearLayout3, frameLayout3, frameLayout4, frameLayout5, horizontalScrollView, imageView, imageView2, imageView3, linearLayout4, linearLayout5, indeterminateSpinnerView, indeterminateSpinnerView2, frameLayout6, cA, cA2, cA3, cA4, cA5, scrollView, scrollView2, linearLayout6, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, viewA, viewA2, viewA3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static C1117a b(LayoutInflater layoutInflater) {
        return c(layoutInflater, null, false);
    }

    public static C1117a c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_agent_market_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
