package r6;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.task.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class g {
    public final ImageView btnBack;
    public final ImageView btnMore;
    public final TextView btnSave;
    public final EditText etContent;
    private final LinearLayout rootView;
    public final TextView tvCharCount;
    public final TextView tvTitle;

    public g(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, EditText editText, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnBack = imageView;
        this.btnMore = imageView2;
        this.btnSave = textView;
        this.etContent = editText;
        this.tvCharCount = textView2;
        this.tvTitle = textView3;
    }

    public static g a(View view) {
        int i10 = R$id.btn_back;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.btn_more;
            ImageView imageView2 = (ImageView) C5437a.a(view, i10);
            if (imageView2 != null) {
                i10 = R$id.btn_save;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    i10 = R$id.et_content;
                    EditText editText = (EditText) C5437a.a(view, i10);
                    if (editText != null) {
                        i10 = R$id.tv_char_count;
                        TextView textView2 = (TextView) C5437a.a(view, i10);
                        if (textView2 != null) {
                            i10 = R$id.tv_title;
                            TextView textView3 = (TextView) C5437a.a(view, i10);
                            if (textView3 != null) {
                                return new g((LinearLayout) view, imageView, imageView2, textView, editText, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
