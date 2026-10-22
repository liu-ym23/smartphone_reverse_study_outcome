package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class n {
    public final AppCompatCheckBox cbDidiCarType;
    public final ImageView ivDidiCarTypeImage;
    private final LinearLayout rootView;
    public final TextView tvDidiCarTypeName;
    public final TextView tvDidiCarTypeOriginPrice;
    public final TextView tvDidiCarTypePrice;

    public n(LinearLayout linearLayout, AppCompatCheckBox appCompatCheckBox, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.cbDidiCarType = appCompatCheckBox;
        this.ivDidiCarTypeImage = imageView;
        this.tvDidiCarTypeName = textView;
        this.tvDidiCarTypeOriginPrice = textView2;
        this.tvDidiCarTypePrice = textView3;
    }

    public static n a(View view) {
        int i10 = R$id.cbDidiCarType;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) C5437a.a(view, i10);
        if (appCompatCheckBox != null) {
            i10 = R$id.ivDidiCarTypeImage;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R$id.tvDidiCarTypeName;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    i10 = R$id.tvDidiCarTypeOriginPrice;
                    TextView textView2 = (TextView) C5437a.a(view, i10);
                    if (textView2 != null) {
                        i10 = R$id.tvDidiCarTypePrice;
                        TextView textView3 = (TextView) C5437a.a(view, i10);
                        if (textView3 != null) {
                            return new n((LinearLayout) view, appCompatCheckBox, imageView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static n c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_didi_cartype_row, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
