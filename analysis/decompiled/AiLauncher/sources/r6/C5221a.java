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

/* renamed from: r6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5221a {
    public final ImageView btnBack;
    public final ImageView btnRestore;
    public final TextView btnSave;
    public final EditText etContent;
    private final LinearLayout rootView;
    public final TextView tvDescription;
    public final TextView tvTitle;

    public C5221a(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, EditText editText, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnBack = imageView;
        this.btnRestore = imageView2;
        this.btnSave = textView;
        this.etContent = editText;
        this.tvDescription = textView2;
        this.tvTitle = textView3;
    }

    public static C5221a a(View view) {
        int i10 = R$id.btn_back;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.btn_restore;
            ImageView imageView2 = (ImageView) C5437a.a(view, i10);
            if (imageView2 != null) {
                i10 = R$id.btn_save;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    i10 = R$id.et_content;
                    EditText editText = (EditText) C5437a.a(view, i10);
                    if (editText != null) {
                        i10 = R$id.tv_description;
                        TextView textView2 = (TextView) C5437a.a(view, i10);
                        if (textView2 != null) {
                            i10 = R$id.tv_title;
                            TextView textView3 = (TextView) C5437a.a(view, i10);
                            if (textView3 != null) {
                                return new C5221a((LinearLayout) view, imageView, imageView2, textView, editText, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static C5221a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C5221a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_agent_file_edit, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
