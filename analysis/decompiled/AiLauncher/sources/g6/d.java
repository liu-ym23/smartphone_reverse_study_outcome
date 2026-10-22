package g6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.stepos.ailauncher.oobe.R$id;
import com.stepos.ailauncher.oobe.R$layout;
import com.stepos.widget.toolbar.StepOSTitleBar;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class d {
    public final LinearLayout btnCreate;
    public final ImageButton btnCustomSubmit;
    public final ImageButton btnNext;
    public final FrameLayout createBlock;
    public final LinearLayout customEditRow;
    public final LinearLayout customOptionRow;
    public final EditText etCustom;
    public final ImageView ivCustomCheck;
    public final ImageView ivCustomQuill;
    public final LinearLayout optionList;
    public final NestedScrollView optionScroll;
    private final ConstraintLayout rootView;
    public final StepOSTitleBar titleBar;
    public final TextView tvCompactTitle;
    public final TextView tvCreate;
    public final TextView tvCustomLabel;
    public final TextView tvQuestion;

    public d(ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageButton imageButton, ImageButton imageButton2, FrameLayout frameLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, EditText editText, ImageView imageView, ImageView imageView2, LinearLayout linearLayout4, NestedScrollView nestedScrollView, StepOSTitleBar stepOSTitleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.btnCreate = linearLayout;
        this.btnCustomSubmit = imageButton;
        this.btnNext = imageButton2;
        this.createBlock = frameLayout;
        this.customEditRow = linearLayout2;
        this.customOptionRow = linearLayout3;
        this.etCustom = editText;
        this.ivCustomCheck = imageView;
        this.ivCustomQuill = imageView2;
        this.optionList = linearLayout4;
        this.optionScroll = nestedScrollView;
        this.titleBar = stepOSTitleBar;
        this.tvCompactTitle = textView;
        this.tvCreate = textView2;
        this.tvCustomLabel = textView3;
        this.tvQuestion = textView4;
    }

    public static d a(View view) {
        int i10 = R$id.btn_create;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.btn_custom_submit;
            ImageButton imageButton = (ImageButton) C5437a.a(view, i10);
            if (imageButton != null) {
                i10 = R$id.btn_next;
                ImageButton imageButton2 = (ImageButton) C5437a.a(view, i10);
                if (imageButton2 != null) {
                    i10 = R$id.create_block;
                    FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                    if (frameLayout != null) {
                        i10 = R$id.custom_edit_row;
                        LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout2 != null) {
                            i10 = R$id.custom_option_row;
                            LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                            if (linearLayout3 != null) {
                                i10 = R$id.et_custom;
                                EditText editText = (EditText) C5437a.a(view, i10);
                                if (editText != null) {
                                    i10 = R$id.iv_custom_check;
                                    ImageView imageView = (ImageView) C5437a.a(view, i10);
                                    if (imageView != null) {
                                        i10 = R$id.iv_custom_quill;
                                        ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                        if (imageView2 != null) {
                                            i10 = R$id.option_list;
                                            LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                            if (linearLayout4 != null) {
                                                i10 = R$id.option_scroll;
                                                NestedScrollView nestedScrollView = (NestedScrollView) C5437a.a(view, i10);
                                                if (nestedScrollView != null) {
                                                    i10 = R$id.title_bar;
                                                    StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) C5437a.a(view, i10);
                                                    if (stepOSTitleBar != null) {
                                                        i10 = R$id.tv_compact_title;
                                                        TextView textView = (TextView) C5437a.a(view, i10);
                                                        if (textView != null) {
                                                            i10 = R$id.tv_create;
                                                            TextView textView2 = (TextView) C5437a.a(view, i10);
                                                            if (textView2 != null) {
                                                                i10 = R$id.tv_custom_label;
                                                                TextView textView3 = (TextView) C5437a.a(view, i10);
                                                                if (textView3 != null) {
                                                                    i10 = R$id.tv_question;
                                                                    TextView textView4 = (TextView) C5437a.a(view, i10);
                                                                    if (textView4 != null) {
                                                                        return new d((ConstraintLayout) view, linearLayout, imageButton, imageButton2, frameLayout, linearLayout2, linearLayout3, editText, imageView, imageView2, linearLayout4, nestedScrollView, stepOSTitleBar, textView, textView2, textView3, textView4);
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

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.oobe_activity_sdk_init_soul, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ConstraintLayout b() {
        return this.rootView;
    }
}
