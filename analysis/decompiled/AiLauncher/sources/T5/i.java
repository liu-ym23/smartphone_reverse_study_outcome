package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class i {
    public final EditText etKeyFieldValue;
    public final ImageView ivKeyFieldEye;
    public final LinearLayout llKeyFieldRow;
    private final LinearLayout rootView;
    public final TextView tvKeyFieldLabel;

    public i(LinearLayout linearLayout, EditText editText, ImageView imageView, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.etKeyFieldValue = editText;
        this.ivKeyFieldEye = imageView;
        this.llKeyFieldRow = linearLayout2;
        this.tvKeyFieldLabel = textView;
    }

    public static i a(View view) {
        int i10 = R$id.etKeyFieldValue;
        EditText editText = (EditText) C5437a.a(view, i10);
        if (editText != null) {
            i10 = R$id.ivKeyFieldEye;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R$id.llKeyFieldRow;
                LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout != null) {
                    i10 = R$id.tvKeyFieldLabel;
                    TextView textView = (TextView) C5437a.a(view, i10);
                    if (textView != null) {
                        return new i((LinearLayout) view, editText, imageView, linearLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static i c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_auther_key_field, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
