package r6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class l {
    public final TextView btnRevoke;
    public final ImageView ivAppIcon;
    private final ConstraintLayout rootView;
    public final TextView tvAppName;
    public final TextView tvAuthMethod;
    public final TextView tvAuthTime;

    public l(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.btnRevoke = textView;
        this.ivAppIcon = imageView;
        this.tvAppName = textView2;
        this.tvAuthMethod = textView3;
        this.tvAuthTime = textView4;
    }

    public static l a(View view) {
        int i10 = R$id.btn_revoke;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.iv_app_icon;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R$id.tv_app_name;
                TextView textView2 = (TextView) C5437a.a(view, i10);
                if (textView2 != null) {
                    i10 = R$id.tv_auth_method;
                    TextView textView3 = (TextView) C5437a.a(view, i10);
                    if (textView3 != null) {
                        i10 = R$id.tv_auth_time;
                        TextView textView4 = (TextView) C5437a.a(view, i10);
                        if (textView4 != null) {
                            return new l((ConstraintLayout) view, textView, imageView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static l c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.item_auth_app, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ConstraintLayout b() {
        return this.rootView;
    }
}
