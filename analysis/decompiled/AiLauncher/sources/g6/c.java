package g6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.ailauncher.oobe.R$id;
import com.stepos.ailauncher.oobe.R$layout;
import com.stepos.widget.toolbar.StepOSTitleBar;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class c {
    public final ImageButton btnNext;
    public final EditText etName;
    private final ConstraintLayout rootView;
    public final StepOSTitleBar titleBar;
    public final TextView tvQuestion;

    public c(ConstraintLayout constraintLayout, ImageButton imageButton, EditText editText, StepOSTitleBar stepOSTitleBar, TextView textView) {
        this.rootView = constraintLayout;
        this.btnNext = imageButton;
        this.etName = editText;
        this.titleBar = stepOSTitleBar;
        this.tvQuestion = textView;
    }

    public static c a(View view) {
        int i10 = R$id.btn_next;
        ImageButton imageButton = (ImageButton) C5437a.a(view, i10);
        if (imageButton != null) {
            i10 = R$id.et_name;
            EditText editText = (EditText) C5437a.a(view, i10);
            if (editText != null) {
                i10 = R$id.title_bar;
                StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) C5437a.a(view, i10);
                if (stepOSTitleBar != null) {
                    i10 = R$id.tv_question;
                    TextView textView = (TextView) C5437a.a(view, i10);
                    if (textView != null) {
                        return new c((ConstraintLayout) view, imageButton, editText, stepOSTitleBar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.oobe_activity_sdk_init_name, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ConstraintLayout b() {
        return this.rootView;
    }
}
