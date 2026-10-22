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
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import com.stepos.ailauncher.agent.skill.widget.IndeterminateSpinnerView;
import s1.C5437a;

/* renamed from: Y4.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1121e {
    public final FrameLayout badgeFailRed;
    public final FrameLayout badgeFailWarn;
    public final FrameLayout btnAbortLink;
    public final TextView btnAuthorize;
    public final ImageView btnBack;
    public final TextView btnBackToAiSpace;
    public final TextView btnConnect;
    public final TextView btnDebugLogClear;
    public final TextView btnDebugLogClose;
    public final TextView btnDebugLogToggle;
    public final TextView btnInstallNext;
    public final TextView btnRetry;
    public final FrameLayout btnTopUninstall;
    public final FrameLayout connectedActionArea;
    public final FrameLayout dotStep1;
    public final View dotStep1Bg;
    public final ImageView dotStep1Check;
    public final IndeterminateSpinnerView dotStep1Loading;
    public final FrameLayout dotStep2;
    public final View dotStep2Bg;
    public final ImageView dotStep2Check;
    public final IndeterminateSpinnerView dotStep2Loading;
    public final FrameLayout dotStep3;
    public final View dotStep3Bg;
    public final ImageView dotStep3Check;
    public final IndeterminateSpinnerView dotStep3Loading;
    public final FrameLayout dotStep4;
    public final View dotStep4Bg;
    public final ImageView dotStep4Check;
    public final IndeterminateSpinnerView dotStep4Loading;
    public final FrameLayout flDebugLogContainer;
    public final ScrollView groupConnected;
    public final LinearLayout groupFailed;
    public final ScrollView groupIdle;
    public final LinearLayout groupInstalling;
    public final HorizontalScrollView hsvDebugLog;
    public final FrameLayout installHero;
    public final ImageView ivAuthorizeBadge;
    public final ImageView ivAuthorizeHero;
    public final ImageView ivInstallLogo;
    public final ImageView ivTopUninstall;
    public final View line12;
    public final View line23;
    public final View line34;
    public final IndeterminateSpinnerView pbAbortLink;
    public final IndeterminateSpinnerView pbTopUninstall;
    public final FrameLayout root;
    private final FrameLayout rootView;
    public final RecyclerView rvRecommendedTasks;
    public final ScrollView svDebugLog;
    public final FrameLayout topBar;
    public final TextView tvAbortLink;
    public final TextView tvConnectedTitle;
    public final TextView tvDebugLog;
    public final TextView tvFailReason;
    public final TextView tvFailTitle;
    public final ImageView tvInstallDoneBadge;
    public final TextView tvInstallSubtitle;
    public final TextView tvInstallTitle;

    public C1121e(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, FrameLayout frameLayout5, FrameLayout frameLayout6, FrameLayout frameLayout7, View view, ImageView imageView2, IndeterminateSpinnerView indeterminateSpinnerView, FrameLayout frameLayout8, View view2, ImageView imageView3, IndeterminateSpinnerView indeterminateSpinnerView2, FrameLayout frameLayout9, View view3, ImageView imageView4, IndeterminateSpinnerView indeterminateSpinnerView3, FrameLayout frameLayout10, View view4, ImageView imageView5, IndeterminateSpinnerView indeterminateSpinnerView4, FrameLayout frameLayout11, ScrollView scrollView, LinearLayout linearLayout, ScrollView scrollView2, LinearLayout linearLayout2, HorizontalScrollView horizontalScrollView, FrameLayout frameLayout12, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, View view5, View view6, View view7, IndeterminateSpinnerView indeterminateSpinnerView5, IndeterminateSpinnerView indeterminateSpinnerView6, FrameLayout frameLayout13, RecyclerView recyclerView, ScrollView scrollView3, FrameLayout frameLayout14, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, ImageView imageView10, TextView textView14, TextView textView15) {
        this.rootView = frameLayout;
        this.badgeFailRed = frameLayout2;
        this.badgeFailWarn = frameLayout3;
        this.btnAbortLink = frameLayout4;
        this.btnAuthorize = textView;
        this.btnBack = imageView;
        this.btnBackToAiSpace = textView2;
        this.btnConnect = textView3;
        this.btnDebugLogClear = textView4;
        this.btnDebugLogClose = textView5;
        this.btnDebugLogToggle = textView6;
        this.btnInstallNext = textView7;
        this.btnRetry = textView8;
        this.btnTopUninstall = frameLayout5;
        this.connectedActionArea = frameLayout6;
        this.dotStep1 = frameLayout7;
        this.dotStep1Bg = view;
        this.dotStep1Check = imageView2;
        this.dotStep1Loading = indeterminateSpinnerView;
        this.dotStep2 = frameLayout8;
        this.dotStep2Bg = view2;
        this.dotStep2Check = imageView3;
        this.dotStep2Loading = indeterminateSpinnerView2;
        this.dotStep3 = frameLayout9;
        this.dotStep3Bg = view3;
        this.dotStep3Check = imageView4;
        this.dotStep3Loading = indeterminateSpinnerView3;
        this.dotStep4 = frameLayout10;
        this.dotStep4Bg = view4;
        this.dotStep4Check = imageView5;
        this.dotStep4Loading = indeterminateSpinnerView4;
        this.flDebugLogContainer = frameLayout11;
        this.groupConnected = scrollView;
        this.groupFailed = linearLayout;
        this.groupIdle = scrollView2;
        this.groupInstalling = linearLayout2;
        this.hsvDebugLog = horizontalScrollView;
        this.installHero = frameLayout12;
        this.ivAuthorizeBadge = imageView6;
        this.ivAuthorizeHero = imageView7;
        this.ivInstallLogo = imageView8;
        this.ivTopUninstall = imageView9;
        this.line12 = view5;
        this.line23 = view6;
        this.line34 = view7;
        this.pbAbortLink = indeterminateSpinnerView5;
        this.pbTopUninstall = indeterminateSpinnerView6;
        this.root = frameLayout13;
        this.rvRecommendedTasks = recyclerView;
        this.svDebugLog = scrollView3;
        this.topBar = frameLayout14;
        this.tvAbortLink = textView9;
        this.tvConnectedTitle = textView10;
        this.tvDebugLog = textView11;
        this.tvFailReason = textView12;
        this.tvFailTitle = textView13;
        this.tvInstallDoneBadge = imageView10;
        this.tvInstallSubtitle = textView14;
        this.tvInstallTitle = textView15;
    }

    public static C1121e a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        View viewA5;
        View viewA6;
        View viewA7;
        int i10 = R$id.badge_fail_red;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null) {
            i10 = R$id.badge_fail_warn;
            FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
            if (frameLayout2 != null) {
                i10 = R$id.btn_abort_link;
                FrameLayout frameLayout3 = (FrameLayout) C5437a.a(view, i10);
                if (frameLayout3 != null) {
                    i10 = R$id.btn_authorize;
                    TextView textView = (TextView) C5437a.a(view, i10);
                    if (textView != null) {
                        i10 = R$id.btn_back;
                        ImageView imageView = (ImageView) C5437a.a(view, i10);
                        if (imageView != null) {
                            i10 = R$id.btn_back_to_ai_space;
                            TextView textView2 = (TextView) C5437a.a(view, i10);
                            if (textView2 != null) {
                                i10 = R$id.btn_connect;
                                TextView textView3 = (TextView) C5437a.a(view, i10);
                                if (textView3 != null) {
                                    i10 = R$id.btn_debug_log_clear;
                                    TextView textView4 = (TextView) C5437a.a(view, i10);
                                    if (textView4 != null) {
                                        i10 = R$id.btn_debug_log_close;
                                        TextView textView5 = (TextView) C5437a.a(view, i10);
                                        if (textView5 != null) {
                                            i10 = R$id.btn_debug_log_toggle;
                                            TextView textView6 = (TextView) C5437a.a(view, i10);
                                            if (textView6 != null) {
                                                i10 = R$id.btn_install_next;
                                                TextView textView7 = (TextView) C5437a.a(view, i10);
                                                if (textView7 != null) {
                                                    i10 = R$id.btn_retry;
                                                    TextView textView8 = (TextView) C5437a.a(view, i10);
                                                    if (textView8 != null) {
                                                        i10 = R$id.btn_top_uninstall;
                                                        FrameLayout frameLayout4 = (FrameLayout) C5437a.a(view, i10);
                                                        if (frameLayout4 != null) {
                                                            i10 = R$id.connected_action_area;
                                                            FrameLayout frameLayout5 = (FrameLayout) C5437a.a(view, i10);
                                                            if (frameLayout5 != null) {
                                                                i10 = R$id.dot_step_1;
                                                                FrameLayout frameLayout6 = (FrameLayout) C5437a.a(view, i10);
                                                                if (frameLayout6 != null && (viewA = C5437a.a(view, (i10 = R$id.dot_step_1_bg))) != null) {
                                                                    i10 = R$id.dot_step_1_check;
                                                                    ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                                                    if (imageView2 != null) {
                                                                        i10 = R$id.dot_step_1_loading;
                                                                        IndeterminateSpinnerView indeterminateSpinnerView = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                        if (indeterminateSpinnerView != null) {
                                                                            i10 = R$id.dot_step_2;
                                                                            FrameLayout frameLayout7 = (FrameLayout) C5437a.a(view, i10);
                                                                            if (frameLayout7 != null && (viewA2 = C5437a.a(view, (i10 = R$id.dot_step_2_bg))) != null) {
                                                                                i10 = R$id.dot_step_2_check;
                                                                                ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                                                                                if (imageView3 != null) {
                                                                                    i10 = R$id.dot_step_2_loading;
                                                                                    IndeterminateSpinnerView indeterminateSpinnerView2 = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                                    if (indeterminateSpinnerView2 != null) {
                                                                                        i10 = R$id.dot_step_3;
                                                                                        FrameLayout frameLayout8 = (FrameLayout) C5437a.a(view, i10);
                                                                                        if (frameLayout8 != null && (viewA3 = C5437a.a(view, (i10 = R$id.dot_step_3_bg))) != null) {
                                                                                            i10 = R$id.dot_step_3_check;
                                                                                            ImageView imageView4 = (ImageView) C5437a.a(view, i10);
                                                                                            if (imageView4 != null) {
                                                                                                i10 = R$id.dot_step_3_loading;
                                                                                                IndeterminateSpinnerView indeterminateSpinnerView3 = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                                                if (indeterminateSpinnerView3 != null) {
                                                                                                    i10 = R$id.dot_step_4;
                                                                                                    FrameLayout frameLayout9 = (FrameLayout) C5437a.a(view, i10);
                                                                                                    if (frameLayout9 != null && (viewA4 = C5437a.a(view, (i10 = R$id.dot_step_4_bg))) != null) {
                                                                                                        i10 = R$id.dot_step_4_check;
                                                                                                        ImageView imageView5 = (ImageView) C5437a.a(view, i10);
                                                                                                        if (imageView5 != null) {
                                                                                                            i10 = R$id.dot_step_4_loading;
                                                                                                            IndeterminateSpinnerView indeterminateSpinnerView4 = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                                                            if (indeterminateSpinnerView4 != null) {
                                                                                                                i10 = R$id.fl_debug_log_container;
                                                                                                                FrameLayout frameLayout10 = (FrameLayout) C5437a.a(view, i10);
                                                                                                                if (frameLayout10 != null) {
                                                                                                                    i10 = R$id.group_connected;
                                                                                                                    ScrollView scrollView = (ScrollView) C5437a.a(view, i10);
                                                                                                                    if (scrollView != null) {
                                                                                                                        i10 = R$id.group_failed;
                                                                                                                        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                                                                                                                        if (linearLayout != null) {
                                                                                                                            i10 = R$id.group_idle;
                                                                                                                            ScrollView scrollView2 = (ScrollView) C5437a.a(view, i10);
                                                                                                                            if (scrollView2 != null) {
                                                                                                                                i10 = R$id.group_installing;
                                                                                                                                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                                                                                                                                if (linearLayout2 != null) {
                                                                                                                                    i10 = R$id.hsv_debug_log;
                                                                                                                                    HorizontalScrollView horizontalScrollView = (HorizontalScrollView) C5437a.a(view, i10);
                                                                                                                                    if (horizontalScrollView != null) {
                                                                                                                                        i10 = R$id.install_hero;
                                                                                                                                        FrameLayout frameLayout11 = (FrameLayout) C5437a.a(view, i10);
                                                                                                                                        if (frameLayout11 != null) {
                                                                                                                                            i10 = R$id.iv_authorize_badge;
                                                                                                                                            ImageView imageView6 = (ImageView) C5437a.a(view, i10);
                                                                                                                                            if (imageView6 != null) {
                                                                                                                                                i10 = R$id.iv_authorize_hero;
                                                                                                                                                ImageView imageView7 = (ImageView) C5437a.a(view, i10);
                                                                                                                                                if (imageView7 != null) {
                                                                                                                                                    i10 = R$id.iv_install_logo;
                                                                                                                                                    ImageView imageView8 = (ImageView) C5437a.a(view, i10);
                                                                                                                                                    if (imageView8 != null) {
                                                                                                                                                        i10 = R$id.iv_top_uninstall;
                                                                                                                                                        ImageView imageView9 = (ImageView) C5437a.a(view, i10);
                                                                                                                                                        if (imageView9 != null && (viewA5 = C5437a.a(view, (i10 = R$id.line_1_2))) != null && (viewA6 = C5437a.a(view, (i10 = R$id.line_2_3))) != null && (viewA7 = C5437a.a(view, (i10 = R$id.line_3_4))) != null) {
                                                                                                                                                            i10 = R$id.pb_abort_link;
                                                                                                                                                            IndeterminateSpinnerView indeterminateSpinnerView5 = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                                                                                                            if (indeterminateSpinnerView5 != null) {
                                                                                                                                                                i10 = R$id.pb_top_uninstall;
                                                                                                                                                                IndeterminateSpinnerView indeterminateSpinnerView6 = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                                                                                                                if (indeterminateSpinnerView6 != null) {
                                                                                                                                                                    FrameLayout frameLayout12 = (FrameLayout) view;
                                                                                                                                                                    i10 = R$id.rv_recommended_tasks;
                                                                                                                                                                    RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
                                                                                                                                                                    if (recyclerView != null) {
                                                                                                                                                                        i10 = R$id.sv_debug_log;
                                                                                                                                                                        ScrollView scrollView3 = (ScrollView) C5437a.a(view, i10);
                                                                                                                                                                        if (scrollView3 != null) {
                                                                                                                                                                            i10 = R$id.top_bar;
                                                                                                                                                                            FrameLayout frameLayout13 = (FrameLayout) C5437a.a(view, i10);
                                                                                                                                                                            if (frameLayout13 != null) {
                                                                                                                                                                                i10 = R$id.tv_abort_link;
                                                                                                                                                                                TextView textView9 = (TextView) C5437a.a(view, i10);
                                                                                                                                                                                if (textView9 != null) {
                                                                                                                                                                                    i10 = R$id.tv_connected_title;
                                                                                                                                                                                    TextView textView10 = (TextView) C5437a.a(view, i10);
                                                                                                                                                                                    if (textView10 != null) {
                                                                                                                                                                                        i10 = R$id.tv_debug_log;
                                                                                                                                                                                        TextView textView11 = (TextView) C5437a.a(view, i10);
                                                                                                                                                                                        if (textView11 != null) {
                                                                                                                                                                                            i10 = R$id.tv_fail_reason;
                                                                                                                                                                                            TextView textView12 = (TextView) C5437a.a(view, i10);
                                                                                                                                                                                            if (textView12 != null) {
                                                                                                                                                                                                i10 = R$id.tv_fail_title;
                                                                                                                                                                                                TextView textView13 = (TextView) C5437a.a(view, i10);
                                                                                                                                                                                                if (textView13 != null) {
                                                                                                                                                                                                    i10 = R$id.tv_install_done_badge;
                                                                                                                                                                                                    ImageView imageView10 = (ImageView) C5437a.a(view, i10);
                                                                                                                                                                                                    if (imageView10 != null) {
                                                                                                                                                                                                        i10 = R$id.tv_install_subtitle;
                                                                                                                                                                                                        TextView textView14 = (TextView) C5437a.a(view, i10);
                                                                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                                                                            i10 = R$id.tv_install_title;
                                                                                                                                                                                                            TextView textView15 = (TextView) C5437a.a(view, i10);
                                                                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                                                                return new C1121e(frameLayout12, frameLayout, frameLayout2, frameLayout3, textView, imageView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, frameLayout4, frameLayout5, frameLayout6, viewA, imageView2, indeterminateSpinnerView, frameLayout7, viewA2, imageView3, indeterminateSpinnerView2, frameLayout8, viewA3, imageView4, indeterminateSpinnerView3, frameLayout9, viewA4, imageView5, indeterminateSpinnerView4, frameLayout10, scrollView, linearLayout, scrollView2, linearLayout2, horizontalScrollView, frameLayout11, imageView6, imageView7, imageView8, imageView9, viewA5, viewA6, viewA7, indeterminateSpinnerView5, indeterminateSpinnerView6, frameLayout12, recyclerView, scrollView3, frameLayout13, textView9, textView10, textView11, textView12, textView13, imageView10, textView14, textView15);
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

    public static C1121e b(LayoutInflater layoutInflater) {
        return c(layoutInflater, null, false);
    }

    public static C1121e c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_feishu_connect, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
