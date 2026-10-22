package g6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.ailauncher.oobe.R$id;
import com.stepos.ailauncher.oobe.R$layout;
import com.stepos.widget.toolbar.StepOSTitleBar;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class e {
    public final ImageButton btnNext;
    public final EditText etUser;
    public final FrameLayout inputBlock;
    private final ConstraintLayout rootView;
    public final StepOSTitleBar titleBar;
    public final TextView tvHint;
    public final TextView tvQuestion;

    public e(ConstraintLayout constraintLayout, ImageButton imageButton, EditText editText, FrameLayout frameLayout, StepOSTitleBar stepOSTitleBar, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnNext = imageButton;
        this.etUser = editText;
        this.inputBlock = frameLayout;
        this.titleBar = stepOSTitleBar;
        this.tvHint = textView;
        this.tvQuestion = textView2;
    }

    public static e a(View view) {
        int i10 = R$id.btn_next;
        ImageButton imageButton = (ImageButton) C5437a.a(view, i10);
        if (imageButton != null) {
            i10 = R$id.et_user;
            EditText editText = (EditText) C5437a.a(view, i10);
            if (editText != null) {
                i10 = R$id.input_block;
                FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                if (frameLayout != null) {
                    i10 = R$id.title_bar;
                    StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) C5437a.a(view, i10);
                    if (stepOSTitleBar != null) {
                        i10 = R$id.tv_hint;
                        TextView textView = (TextView) C5437a.a(view, i10);
                        if (textView != null) {
                            i10 = R$id.tv_question;
                            TextView textView2 = (TextView) C5437a.a(view, i10);
                            if (textView2 != null) {
                                return new e((ConstraintLayout) view, imageButton, editText, frameLayout, stepOSTitleBar, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.oobe_activity_sdk_init_user, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ConstraintLayout b() {
        return this.rootView;
    }
}
