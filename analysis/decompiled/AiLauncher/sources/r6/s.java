package r6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.ailauncher.chat.view.HomeInputView;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.space.SoftLightGreetingView;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class s {
    public final LinearLayout btnAllTasks;
    public final LinearLayout chatRecommend1;
    public final LinearLayout chatRecommend2;
    public final LinearLayout chatRecommend3;
    public final LinearLayout chatRecommendChips;
    public final LinearLayout chipSuggest1;
    public final LinearLayout chipSuggest2;
    public final LinearLayout chipSuggest3;
    public final ConstraintLayout conLayoutInput;
    public final ConstraintLayout homeInputThinkingBar;
    public final ImageView homeInputThinkingIcon;
    public final ImageView homeInputThinkingStop;
    public final TextView homeInputThinkingText;
    public final ImageView ivAllTasksChevron;
    public final ImageView ivChatRecommend1;
    public final ImageView ivChatRecommend2;
    public final ImageView ivChatRecommend3;
    public final ImageView ivImeGlow;
    public final ImageView ivSuggest1;
    public final ImageView ivSuggest2;
    public final ImageView ivSuggest3;
    public final HomeInputView layoutInputBarNew;
    public final LinearLayout layoutSuggestions;
    private final ConstraintLayout rootView;
    public final TextView tvAllTask;
    public final TextView tvChatRecommend1;
    public final TextView tvChatRecommend2;
    public final TextView tvChatRecommend3;
    public final SoftLightGreetingView tvGreeting;
    public final TextView tvSuggest1;
    public final TextView tvSuggest2;
    public final TextView tvSuggest3;

    public s(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, HomeInputView homeInputView, LinearLayout linearLayout9, TextView textView2, TextView textView3, TextView textView4, TextView textView5, SoftLightGreetingView softLightGreetingView, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.btnAllTasks = linearLayout;
        this.chatRecommend1 = linearLayout2;
        this.chatRecommend2 = linearLayout3;
        this.chatRecommend3 = linearLayout4;
        this.chatRecommendChips = linearLayout5;
        this.chipSuggest1 = linearLayout6;
        this.chipSuggest2 = linearLayout7;
        this.chipSuggest3 = linearLayout8;
        this.conLayoutInput = constraintLayout2;
        this.homeInputThinkingBar = constraintLayout3;
        this.homeInputThinkingIcon = imageView;
        this.homeInputThinkingStop = imageView2;
        this.homeInputThinkingText = textView;
        this.ivAllTasksChevron = imageView3;
        this.ivChatRecommend1 = imageView4;
        this.ivChatRecommend2 = imageView5;
        this.ivChatRecommend3 = imageView6;
        this.ivImeGlow = imageView7;
        this.ivSuggest1 = imageView8;
        this.ivSuggest2 = imageView9;
        this.ivSuggest3 = imageView10;
        this.layoutInputBarNew = homeInputView;
        this.layoutSuggestions = linearLayout9;
        this.tvAllTask = textView2;
        this.tvChatRecommend1 = textView3;
        this.tvChatRecommend2 = textView4;
        this.tvChatRecommend3 = textView5;
        this.tvGreeting = softLightGreetingView;
        this.tvSuggest1 = textView6;
        this.tvSuggest2 = textView7;
        this.tvSuggest3 = textView8;
    }

    public static s a(View view) {
        int i10 = R$id.btn_all_tasks;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.chat_recommend_1;
            LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R$id.chat_recommend_2;
                LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout3 != null) {
                    i10 = R$id.chat_recommend_3;
                    LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout4 != null) {
                        i10 = R$id.chat_recommend_chips;
                        LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout5 != null) {
                            i10 = R$id.chip_suggest_1;
                            LinearLayout linearLayout6 = (LinearLayout) C5437a.a(view, i10);
                            if (linearLayout6 != null) {
                                i10 = R$id.chip_suggest_2;
                                LinearLayout linearLayout7 = (LinearLayout) C5437a.a(view, i10);
                                if (linearLayout7 != null) {
                                    i10 = R$id.chip_suggest_3;
                                    LinearLayout linearLayout8 = (LinearLayout) C5437a.a(view, i10);
                                    if (linearLayout8 != null) {
                                        i10 = R$id.con_layout_input;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) C5437a.a(view, i10);
                                        if (constraintLayout != null) {
                                            i10 = R$id.home_input_thinking_bar;
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) C5437a.a(view, i10);
                                            if (constraintLayout2 != null) {
                                                i10 = R$id.home_input_thinking_icon;
                                                ImageView imageView = (ImageView) C5437a.a(view, i10);
                                                if (imageView != null) {
                                                    i10 = R$id.home_input_thinking_stop;
                                                    ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                                    if (imageView2 != null) {
                                                        i10 = R$id.home_input_thinking_text;
                                                        TextView textView = (TextView) C5437a.a(view, i10);
                                                        if (textView != null) {
                                                            i10 = R$id.iv_all_tasks_chevron;
                                                            ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                                                            if (imageView3 != null) {
                                                                i10 = R$id.iv_chat_recommend_1;
                                                                ImageView imageView4 = (ImageView) C5437a.a(view, i10);
                                                                if (imageView4 != null) {
                                                                    i10 = R$id.iv_chat_recommend_2;
                                                                    ImageView imageView5 = (ImageView) C5437a.a(view, i10);
                                                                    if (imageView5 != null) {
                                                                        i10 = R$id.iv_chat_recommend_3;
                                                                        ImageView imageView6 = (ImageView) C5437a.a(view, i10);
                                                                        if (imageView6 != null) {
                                                                            i10 = R$id.iv_ime_glow;
                                                                            ImageView imageView7 = (ImageView) C5437a.a(view, i10);
                                                                            if (imageView7 != null) {
                                                                                i10 = R$id.iv_suggest_1;
                                                                                ImageView imageView8 = (ImageView) C5437a.a(view, i10);
                                                                                if (imageView8 != null) {
                                                                                    i10 = R$id.iv_suggest_2;
                                                                                    ImageView imageView9 = (ImageView) C5437a.a(view, i10);
                                                                                    if (imageView9 != null) {
                                                                                        i10 = R$id.iv_suggest_3;
                                                                                        ImageView imageView10 = (ImageView) C5437a.a(view, i10);
                                                                                        if (imageView10 != null) {
                                                                                            i10 = R$id.layout_input_bar_new;
                                                                                            HomeInputView homeInputView = (HomeInputView) C5437a.a(view, i10);
                                                                                            if (homeInputView != null) {
                                                                                                i10 = R$id.layout_suggestions;
                                                                                                LinearLayout linearLayout9 = (LinearLayout) C5437a.a(view, i10);
                                                                                                if (linearLayout9 != null) {
                                                                                                    i10 = R$id.tv_all_task;
                                                                                                    TextView textView2 = (TextView) C5437a.a(view, i10);
                                                                                                    if (textView2 != null) {
                                                                                                        i10 = R$id.tv_chat_recommend_1;
                                                                                                        TextView textView3 = (TextView) C5437a.a(view, i10);
                                                                                                        if (textView3 != null) {
                                                                                                            i10 = R$id.tv_chat_recommend_2;
                                                                                                            TextView textView4 = (TextView) C5437a.a(view, i10);
                                                                                                            if (textView4 != null) {
                                                                                                                i10 = R$id.tv_chat_recommend_3;
                                                                                                                TextView textView5 = (TextView) C5437a.a(view, i10);
                                                                                                                if (textView5 != null) {
                                                                                                                    i10 = R$id.tv_greeting;
                                                                                                                    SoftLightGreetingView softLightGreetingView = (SoftLightGreetingView) C5437a.a(view, i10);
                                                                                                                    if (softLightGreetingView != null) {
                                                                                                                        i10 = R$id.tv_suggest_1;
                                                                                                                        TextView textView6 = (TextView) C5437a.a(view, i10);
                                                                                                                        if (textView6 != null) {
                                                                                                                            i10 = R$id.tv_suggest_2;
                                                                                                                            TextView textView7 = (TextView) C5437a.a(view, i10);
                                                                                                                            if (textView7 != null) {
                                                                                                                                i10 = R$id.tv_suggest_3;
                                                                                                                                TextView textView8 = (TextView) C5437a.a(view, i10);
                                                                                                                                if (textView8 != null) {
                                                                                                                                    return new s((ConstraintLayout) view, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, constraintLayout, constraintLayout2, imageView, imageView2, textView, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, homeInputView, linearLayout9, textView2, textView3, textView4, textView5, softLightGreetingView, textView6, textView7, textView8);
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

    public static s c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_three_tile_overlay, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ConstraintLayout b() {
        return this.rootView;
    }
}
