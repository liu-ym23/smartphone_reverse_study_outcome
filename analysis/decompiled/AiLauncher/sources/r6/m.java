package r6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class m {
    public final ImageView btnToggleKey;
    public final EditText etKeyInput;
    public final LinearLayout layoutKeyField;
    private final LinearLayout rootView;
    public final TextView tvKeyLabel;
    public final TextView tvMaskedKey;

    public m(LinearLayout linearLayout, ImageView imageView, EditText editText, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnToggleKey = imageView;
        this.etKeyInput = editText;
        this.layoutKeyField = linearLayout2;
        this.tvKeyLabel = textView;
        this.tvMaskedKey = textView2;
    }

    public static m a(View view) {
        int i10 = R$id.btn_toggle_key;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.et_key_input;
            EditText editText = (EditText) C5437a.a(view, i10);
            if (editText != null) {
                i10 = R$id.layout_key_field;
                LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout != null) {
                    i10 = R$id.tv_key_label;
                    TextView textView = (TextView) C5437a.a(view, i10);
                    if (textView != null) {
                        i10 = R$id.tv_masked_key;
                        TextView textView2 = (TextView) C5437a.a(view, i10);
                        if (textView2 != null) {
                            return new m((LinearLayout) view, imageView, editText, linearLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static m c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_auth_key_field, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
