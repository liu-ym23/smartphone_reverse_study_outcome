package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import com.stepos.ailauncher.agent.skill.widget.IndeterminateSpinnerView;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class k {
    public final FrameLayout badgeFailRed;
    public final FrameLayout btnAbortLink;
    public final ImageView btnBack;
    public final TextView btnBackToScan;
    public final TextView btnConnect;
    public final TextView btnICompleted;
    public final FrameLayout btnQrRefresh;
    public final TextView btnRetry;
    public final FrameLayout btnSaveQr;
    public final FrameLayout btnTopUninstall;
    public final TextView btnWecomDebugLogClear;
    public final TextView btnWecomDebugLogClose;
    public final TextView btnWecomDebugLogToggle;
    public final FrameLayout connectedActionArea;
    public final FrameLayout flWecomDebugLogContainer;
    public final LinearLayout groupConnected;
    public final LinearLayout groupFailed;
    public final ScrollView groupIdle;
    public final LinearLayout groupInstalling;
    public final LinearLayout groupQr;
    public final LinearLayout groupSteps;
    public final ImageView ivQr;
    public final ImageView ivTopUninstall;
    public final IndeterminateSpinnerView pbAbortLink;
    public final IndeterminateSpinnerView pbTopUninstall;
    public final FrameLayout root;
    private final FrameLayout rootView;
    public final RecyclerView rvRecommendedTasks;
    public final FrameLayout topBar;
    public final TextView tvAbortLink;
    public final TextView tvConnectedTitle;
    public final TextView tvFailReason;
    public final TextView tvFailTitle;
    public final ImageView tvInstallDoneBadge;
    public final TextView tvInstallingSubtitle;
    public final TextView tvInstallingTitle;
    public final TextView tvWecomDebugLog;
    public final View wecomDotStep1Bg;
    public final ImageView wecomDotStep1Check;
    public final IndeterminateSpinnerView wecomDotStep1Loading;
    public final View wecomDotStep2Bg;
    public final ImageView wecomDotStep2Check;
    public final IndeterminateSpinnerView wecomDotStep2Loading;
    public final View wecomDotStep3Bg;
    public final ImageView wecomDotStep3Check;
    public final IndeterminateSpinnerView wecomDotStep3Loading;
    public final View wecomLine12;
    public final View wecomLine23;

    public k(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, TextView textView, TextView textView2, TextView textView3, FrameLayout frameLayout4, TextView textView4, FrameLayout frameLayout5, FrameLayout frameLayout6, TextView textView5, TextView textView6, TextView textView7, FrameLayout frameLayout7, FrameLayout frameLayout8, LinearLayout linearLayout, LinearLayout linearLayout2, ScrollView scrollView, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, ImageView imageView2, ImageView imageView3, IndeterminateSpinnerView indeterminateSpinnerView, IndeterminateSpinnerView indeterminateSpinnerView2, FrameLayout frameLayout9, RecyclerView recyclerView, FrameLayout frameLayout10, TextView textView8, TextView textView9, TextView textView10, TextView textView11, ImageView imageView4, TextView textView12, TextView textView13, TextView textView14, View view, ImageView imageView5, IndeterminateSpinnerView indeterminateSpinnerView3, View view2, ImageView imageView6, IndeterminateSpinnerView indeterminateSpinnerView4, View view3, ImageView imageView7, IndeterminateSpinnerView indeterminateSpinnerView5, View view4, View view5) {
        this.rootView = frameLayout;
        this.badgeFailRed = frameLayout2;
        this.btnAbortLink = frameLayout3;
        this.btnBack = imageView;
        this.btnBackToScan = textView;
        this.btnConnect = textView2;
        this.btnICompleted = textView3;
        this.btnQrRefresh = frameLayout4;
        this.btnRetry = textView4;
        this.btnSaveQr = frameLayout5;
        this.btnTopUninstall = frameLayout6;
        this.btnWecomDebugLogClear = textView5;
        this.btnWecomDebugLogClose = textView6;
        this.btnWecomDebugLogToggle = textView7;
        this.connectedActionArea = frameLayout7;
        this.flWecomDebugLogContainer = frameLayout8;
        this.groupConnected = linearLayout;
        this.groupFailed = linearLayout2;
        this.groupIdle = scrollView;
        this.groupInstalling = linearLayout3;
        this.groupQr = linearLayout4;
        this.groupSteps = linearLayout5;
        this.ivQr = imageView2;
        this.ivTopUninstall = imageView3;
        this.pbAbortLink = indeterminateSpinnerView;
        this.pbTopUninstall = indeterminateSpinnerView2;
        this.root = frameLayout9;
        this.rvRecommendedTasks = recyclerView;
        this.topBar = frameLayout10;
        this.tvAbortLink = textView8;
        this.tvConnectedTitle = textView9;
        this.tvFailReason = textView10;
        this.tvFailTitle = textView11;
        this.tvInstallDoneBadge = imageView4;
        this.tvInstallingSubtitle = textView12;
        this.tvInstallingTitle = textView13;
        this.tvWecomDebugLog = textView14;
        this.wecomDotStep1Bg = view;
        this.wecomDotStep1Check = imageView5;
        this.wecomDotStep1Loading = indeterminateSpinnerView3;
        this.wecomDotStep2Bg = view2;
        this.wecomDotStep2Check = imageView6;
        this.wecomDotStep2Loading = indeterminateSpinnerView4;
        this.wecomDotStep3Bg = view3;
        this.wecomDotStep3Check = imageView7;
        this.wecomDotStep3Loading = indeterminateSpinnerView5;
        this.wecomLine12 = view4;
        this.wecomLine23 = view5;
    }

    public static k a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        View viewA5;
        int i10 = R$id.badge_fail_red;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null) {
            i10 = R$id.btn_abort_link;
            FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
            if (frameLayout2 != null) {
                i10 = R$id.btn_back;
                ImageView imageView = (ImageView) C5437a.a(view, i10);
                if (imageView != null) {
                    i10 = R$id.btn_back_to_scan;
                    TextView textView = (TextView) C5437a.a(view, i10);
                    if (textView != null) {
                        i10 = R$id.btn_connect;
                        TextView textView2 = (TextView) C5437a.a(view, i10);
                        if (textView2 != null) {
                            i10 = R$id.btn_i_completed;
                            TextView textView3 = (TextView) C5437a.a(view, i10);
                            if (textView3 != null) {
                                i10 = R$id.btn_qr_refresh;
                                FrameLayout frameLayout3 = (FrameLayout) C5437a.a(view, i10);
                                if (frameLayout3 != null) {
                                    i10 = R$id.btn_retry;
                                    TextView textView4 = (TextView) C5437a.a(view, i10);
                                    if (textView4 != null) {
                                        i10 = R$id.btn_save_qr;
                                        FrameLayout frameLayout4 = (FrameLayout) C5437a.a(view, i10);
                                        if (frameLayout4 != null) {
                                            i10 = R$id.btn_top_uninstall;
                                            FrameLayout frameLayout5 = (FrameLayout) C5437a.a(view, i10);
                                            if (frameLayout5 != null) {
                                                i10 = R$id.btn_wecom_debug_log_clear;
                                                TextView textView5 = (TextView) C5437a.a(view, i10);
                                                if (textView5 != null) {
                                                    i10 = R$id.btn_wecom_debug_log_close;
                                                    TextView textView6 = (TextView) C5437a.a(view, i10);
                                                    if (textView6 != null) {
                                                        i10 = R$id.btn_wecom_debug_log_toggle;
                                                        TextView textView7 = (TextView) C5437a.a(view, i10);
                                                        if (textView7 != null) {
                                                            i10 = R$id.connected_action_area;
                                                            FrameLayout frameLayout6 = (FrameLayout) C5437a.a(view, i10);
                                                            if (frameLayout6 != null) {
                                                                i10 = R$id.fl_wecom_debug_log_container;
                                                                FrameLayout frameLayout7 = (FrameLayout) C5437a.a(view, i10);
                                                                if (frameLayout7 != null) {
                                                                    i10 = R$id.group_connected;
                                                                    LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                                                                    if (linearLayout != null) {
                                                                        i10 = R$id.group_failed;
                                                                        LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                                                                        if (linearLayout2 != null) {
                                                                            i10 = R$id.group_idle;
                                                                            ScrollView scrollView = (ScrollView) C5437a.a(view, i10);
                                                                            if (scrollView != null) {
                                                                                i10 = R$id.group_installing;
                                                                                LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                                                                                if (linearLayout3 != null) {
                                                                                    i10 = R$id.group_qr;
                                                                                    LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                                                                    if (linearLayout4 != null) {
                                                                                        i10 = R$id.group_steps;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                                                                                        if (linearLayout5 != null) {
                                                                                            i10 = R$id.iv_qr;
                                                                                            ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                                                                            if (imageView2 != null) {
                                                                                                i10 = R$id.iv_top_uninstall;
                                                                                                ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                                                                                                if (imageView3 != null) {
                                                                                                    i10 = R$id.pb_abort_link;
                                                                                                    IndeterminateSpinnerView indeterminateSpinnerView = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                                                    if (indeterminateSpinnerView != null) {
                                                                                                        i10 = R$id.pb_top_uninstall;
                                                                                                        IndeterminateSpinnerView indeterminateSpinnerView2 = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                                                        if (indeterminateSpinnerView2 != null) {
                                                                                                            FrameLayout frameLayout8 = (FrameLayout) view;
                                                                                                            i10 = R$id.rv_recommended_tasks;
                                                                                                            RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
                                                                                                            if (recyclerView != null) {
                                                                                                                i10 = R$id.top_bar;
                                                                                                                FrameLayout frameLayout9 = (FrameLayout) C5437a.a(view, i10);
                                                                                                                if (frameLayout9 != null) {
                                                                                                                    i10 = R$id.tv_abort_link;
                                                                                                                    TextView textView8 = (TextView) C5437a.a(view, i10);
                                                                                                                    if (textView8 != null) {
                                                                                                                        i10 = R$id.tv_connected_title;
                                                                                                                        TextView textView9 = (TextView) C5437a.a(view, i10);
                                                                                                                        if (textView9 != null) {
                                                                                                                            i10 = R$id.tv_fail_reason;
                                                                                                                            TextView textView10 = (TextView) C5437a.a(view, i10);
                                                                                                                            if (textView10 != null) {
                                                                                                                                i10 = R$id.tv_fail_title;
                                                                                                                                TextView textView11 = (TextView) C5437a.a(view, i10);
                                                                                                                                if (textView11 != null) {
                                                                                                                                    i10 = R$id.tv_install_done_badge;
                                                                                                                                    ImageView imageView4 = (ImageView) C5437a.a(view, i10);
                                                                                                                                    if (imageView4 != null) {
                                                                                                                                        i10 = R$id.tv_installing_subtitle;
                                                                                                                                        TextView textView12 = (TextView) C5437a.a(view, i10);
                                                                                                                                        if (textView12 != null) {
                                                                                                                                            i10 = R$id.tv_installing_title;
                                                                                                                                            TextView textView13 = (TextView) C5437a.a(view, i10);
                                                                                                                                            if (textView13 != null) {
                                                                                                                                                i10 = R$id.tv_wecom_debug_log;
                                                                                                                                                TextView textView14 = (TextView) C5437a.a(view, i10);
                                                                                                                                                if (textView14 != null && (viewA = C5437a.a(view, (i10 = R$id.wecom_dot_step_1_bg))) != null) {
                                                                                                                                                    i10 = R$id.wecom_dot_step_1_check;
                                                                                                                                                    ImageView imageView5 = (ImageView) C5437a.a(view, i10);
                                                                                                                                                    if (imageView5 != null) {
                                                                                                                                                        i10 = R$id.wecom_dot_step_1_loading;
                                                                                                                                                        IndeterminateSpinnerView indeterminateSpinnerView3 = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                                                                                                        if (indeterminateSpinnerView3 != null && (viewA2 = C5437a.a(view, (i10 = R$id.wecom_dot_step_2_bg))) != null) {
                                                                                                                                                            i10 = R$id.wecom_dot_step_2_check;
                                                                                                                                                            ImageView imageView6 = (ImageView) C5437a.a(view, i10);
                                                                                                                                                            if (imageView6 != null) {
                                                                                                                                                                i10 = R$id.wecom_dot_step_2_loading;
                                                                                                                                                                IndeterminateSpinnerView indeterminateSpinnerView4 = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                                                                                                                if (indeterminateSpinnerView4 != null && (viewA3 = C5437a.a(view, (i10 = R$id.wecom_dot_step_3_bg))) != null) {
                                                                                                                                                                    i10 = R$id.wecom_dot_step_3_check;
                                                                                                                                                                    ImageView imageView7 = (ImageView) C5437a.a(view, i10);
                                                                                                                                                                    if (imageView7 != null) {
                                                                                                                                                                        i10 = R$id.wecom_dot_step_3_loading;
                                                                                                                                                                        IndeterminateSpinnerView indeterminateSpinnerView5 = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                                                                                                                                        if (indeterminateSpinnerView5 != null && (viewA4 = C5437a.a(view, (i10 = R$id.wecom_line_12))) != null && (viewA5 = C5437a.a(view, (i10 = R$id.wecom_line_23))) != null) {
                                                                                                                                                                            return new k(frameLayout8, frameLayout, frameLayout2, imageView, textView, textView2, textView3, frameLayout3, textView4, frameLayout4, frameLayout5, textView5, textView6, textView7, frameLayout6, frameLayout7, linearLayout, linearLayout2, scrollView, linearLayout3, linearLayout4, linearLayout5, imageView2, imageView3, indeterminateSpinnerView, indeterminateSpinnerView2, frameLayout8, recyclerView, frameLayout9, textView8, textView9, textView10, textView11, imageView4, textView12, textView13, textView14, viewA, imageView5, indeterminateSpinnerView3, viewA2, imageView6, indeterminateSpinnerView4, viewA3, imageView7, indeterminateSpinnerView5, viewA4, viewA5);
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

    public static k b(LayoutInflater layoutInflater) {
        return c(layoutInflater, null, false);
    }

    public static k c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_wecom_connect, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
