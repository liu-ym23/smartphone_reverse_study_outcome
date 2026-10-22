package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class p {
    public final ImageButton btnClear;
    public final TextView btnRenameCancel;
    public final TextView btnRenameConfirm;
    public final EditText etRename;
    public final LinearLayout renamePanel;
    private final FrameLayout rootView;

    public p(FrameLayout frameLayout, ImageButton imageButton, TextView textView, TextView textView2, EditText editText, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.btnClear = imageButton;
        this.btnRenameCancel = textView;
        this.btnRenameConfirm = textView2;
        this.etRename = editText;
        this.renamePanel = linearLayout;
    }

    public static p a(View view) {
        int i10 = R$id.btn_clear;
        ImageButton imageButton = (ImageButton) C5437a.a(view, i10);
        if (imageButton != null) {
            i10 = R$id.btn_rename_cancel;
            TextView textView = (TextView) C5437a.a(view, i10);
            if (textView != null) {
                i10 = R$id.btn_rename_confirm;
                TextView textView2 = (TextView) C5437a.a(view, i10);
                if (textView2 != null) {
                    i10 = R$id.et_rename;
                    EditText editText = (EditText) C5437a.a(view, i10);
                    if (editText != null) {
                        i10 = R$id.rename_panel;
                        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout != null) {
                            return new p((FrameLayout) view, imageButton, textView, textView2, editText, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static p c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.dialog_rename_device, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
