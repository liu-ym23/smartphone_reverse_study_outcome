package r6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.stepos.ailauncher.chat.view.LauncherChatLayout;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.chat.TaskInputView;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class b {
    public final LinearLayout actionBtnGroup;
    public final LinearLayout bottomContainer;
    public final View bottomScrim;
    public final LinearLayout chatPanel;
    public final LottieAnimationView chipLottie;
    public final FrameLayout contentHost;
    public final FrameLayout drawerHandleArea;
    public final TaskInputView inputViewTask;
    public final ImageView ivBack;
    public final ImageView ivDownload;
    public final ImageView ivFullscreen;
    public final ImageView ivMore;
    public final ImageView ivPartNext;
    public final ImageView ivPartPrev;
    public final ImageView ivStatus;
    public final LinearLayout llCurrentStatus;
    public final LinearLayout llFloatcardInputContainer;
    public final ConstraintLayout rlTop;
    private final FrameLayout rootView;
    public final View sheetScrim;
    public final ViewStub stubResultContent;
    public final LauncherChatLayout taskChatLayout;
    public final View topScrim;
    public final TextView tvCurrentTaskTitle;
    public final View vSpeechBg;
    public final LinearLayout versionBtnGroup;

    public b(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, View view, LinearLayout linearLayout3, LottieAnimationView lottieAnimationView, FrameLayout frameLayout2, FrameLayout frameLayout3, TaskInputView taskInputView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, LinearLayout linearLayout4, LinearLayout linearLayout5, ConstraintLayout constraintLayout, View view2, ViewStub viewStub, LauncherChatLayout launcherChatLayout, View view3, TextView textView, View view4, LinearLayout linearLayout6) {
        this.rootView = frameLayout;
        this.actionBtnGroup = linearLayout;
        this.bottomContainer = linearLayout2;
        this.bottomScrim = view;
        this.chatPanel = linearLayout3;
        this.chipLottie = lottieAnimationView;
        this.contentHost = frameLayout2;
        this.drawerHandleArea = frameLayout3;
        this.inputViewTask = taskInputView;
        this.ivBack = imageView;
        this.ivDownload = imageView2;
        this.ivFullscreen = imageView3;
        this.ivMore = imageView4;
        this.ivPartNext = imageView5;
        this.ivPartPrev = imageView6;
        this.ivStatus = imageView7;
        this.llCurrentStatus = linearLayout4;
        this.llFloatcardInputContainer = linearLayout5;
        this.rlTop = constraintLayout;
        this.sheetScrim = view2;
        this.stubResultContent = viewStub;
        this.taskChatLayout = launcherChatLayout;
        this.topScrim = view3;
        this.tvCurrentTaskTitle = textView;
        this.vSpeechBg = view4;
        this.versionBtnGroup = linearLayout6;
    }

    public static b a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        int i10 = R$id.action_btn_group;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.bottom_container;
            LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout2 != null && (viewA = C5437a.a(view, (i10 = R$id.bottomScrim))) != null) {
                i10 = R$id.chatPanel;
                LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout3 != null) {
                    i10 = R$id.chip_lottie;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) C5437a.a(view, i10);
                    if (lottieAnimationView != null) {
                        i10 = R$id.contentHost;
                        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                        if (frameLayout != null) {
                            i10 = R$id.drawerHandleArea;
                            FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
                            if (frameLayout2 != null) {
                                i10 = R$id.input_view_task;
                                TaskInputView taskInputView = (TaskInputView) C5437a.a(view, i10);
                                if (taskInputView != null) {
                                    i10 = R$id.iv_back;
                                    ImageView imageView = (ImageView) C5437a.a(view, i10);
                                    if (imageView != null) {
                                        i10 = R$id.ivDownload;
                                        ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                        if (imageView2 != null) {
                                            i10 = R$id.ivFullscreen;
                                            ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                                            if (imageView3 != null) {
                                                i10 = R$id.ivMore;
                                                ImageView imageView4 = (ImageView) C5437a.a(view, i10);
                                                if (imageView4 != null) {
                                                    i10 = R$id.ivPartNext;
                                                    ImageView imageView5 = (ImageView) C5437a.a(view, i10);
                                                    if (imageView5 != null) {
                                                        i10 = R$id.ivPartPrev;
                                                        ImageView imageView6 = (ImageView) C5437a.a(view, i10);
                                                        if (imageView6 != null) {
                                                            i10 = R$id.ivStatus;
                                                            ImageView imageView7 = (ImageView) C5437a.a(view, i10);
                                                            if (imageView7 != null) {
                                                                i10 = R$id.ll_current_status;
                                                                LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                                                if (linearLayout4 != null) {
                                                                    i10 = R$id.ll_floatcard_input_container;
                                                                    LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                                                                    if (linearLayout5 != null) {
                                                                        i10 = R$id.rl_top;
                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) C5437a.a(view, i10);
                                                                        if (constraintLayout != null && (viewA2 = C5437a.a(view, (i10 = R$id.sheetScrim))) != null) {
                                                                            i10 = R$id.stubResultContent;
                                                                            ViewStub viewStub = (ViewStub) C5437a.a(view, i10);
                                                                            if (viewStub != null) {
                                                                                i10 = R$id.taskChatLayout;
                                                                                LauncherChatLayout launcherChatLayout = (LauncherChatLayout) C5437a.a(view, i10);
                                                                                if (launcherChatLayout != null && (viewA3 = C5437a.a(view, (i10 = R$id.topScrim))) != null) {
                                                                                    i10 = R$id.tv_current_task_title;
                                                                                    TextView textView = (TextView) C5437a.a(view, i10);
                                                                                    if (textView != null && (viewA4 = C5437a.a(view, (i10 = R$id.v_speech_bg))) != null) {
                                                                                        i10 = R$id.version_btn_group;
                                                                                        LinearLayout linearLayout6 = (LinearLayout) C5437a.a(view, i10);
                                                                                        if (linearLayout6 != null) {
                                                                                            return new b((FrameLayout) view, linearLayout, linearLayout2, viewA, linearLayout3, lottieAnimationView, frameLayout, frameLayout2, taskInputView, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, linearLayout4, linearLayout5, constraintLayout, viewA2, viewStub, launcherChatLayout, viewA3, textView, viewA4, linearLayout6);
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

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
