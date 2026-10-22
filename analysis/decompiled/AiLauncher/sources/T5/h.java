package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class h {
    public final TextView btnKeyDialogCancel;
    public final TextView btnKeyDialogConfirm;
    public final EditText etKeyDialogInput;
    public final FrameLayout flKeyDialogScrim;
    public final LinearLayout llKeyDialogPanel;
    private final FrameLayout rootView;
    public final TextView tvKeyDialogTitle;

    public h(FrameLayout frameLayout, TextView textView, TextView textView2, EditText editText, FrameLayout frameLayout2, LinearLayout linearLayout, TextView textView3) {
        this.rootView = frameLayout;
        this.btnKeyDialogCancel = textView;
        this.btnKeyDialogConfirm = textView2;
        this.etKeyDialogInput = editText;
        this.flKeyDialogScrim = frameLayout2;
        this.llKeyDialogPanel = linearLayout;
        this.tvKeyDialogTitle = textView3;
    }

    public static h a(View view) {
        int i10 = R$id.btnKeyDialogCancel;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.btnKeyDialogConfirm;
            TextView textView2 = (TextView) C5437a.a(view, i10);
            if (textView2 != null) {
                i10 = R$id.etKeyDialogInput;
                EditText editText = (EditText) C5437a.a(view, i10);
                if (editText != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i10 = R$id.llKeyDialogPanel;
                    LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout != null) {
                        i10 = R$id.tvKeyDialogTitle;
                        TextView textView3 = (TextView) C5437a.a(view, i10);
                        if (textView3 != null) {
                            return new h(frameLayout, textView, textView2, editText, frameLayout, linearLayout, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_auther_key_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
