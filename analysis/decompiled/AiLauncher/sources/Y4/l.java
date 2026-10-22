package Y4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class l {
    private final FrameLayout rootView;
    public final LinearLayout sheetCardOther;
    public final LinearLayout sheetCardStep;
    public final LinearLayout sheetPanel;
    public final TextView tvSheetOtherDesc;
    public final TextView tvSheetOtherTitle;
    public final TextView tvSheetStepDesc;
    public final TextView tvSheetStepTitle;

    public l(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = frameLayout;
        this.sheetCardOther = linearLayout;
        this.sheetCardStep = linearLayout2;
        this.sheetPanel = linearLayout3;
        this.tvSheetOtherDesc = textView;
        this.tvSheetOtherTitle = textView2;
        this.tvSheetStepDesc = textView3;
        this.tvSheetStepTitle = textView4;
    }

    public static l a(View view) {
        int i10 = R$id.sheet_card_other;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.sheet_card_step;
            LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R$id.sheet_panel;
                LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout3 != null) {
                    i10 = R$id.tv_sheet_other_desc;
                    TextView textView = (TextView) C5437a.a(view, i10);
                    if (textView != null) {
                        i10 = R$id.tv_sheet_other_title;
                        TextView textView2 = (TextView) C5437a.a(view, i10);
                        if (textView2 != null) {
                            i10 = R$id.tv_sheet_step_desc;
                            TextView textView3 = (TextView) C5437a.a(view, i10);
                            if (textView3 != null) {
                                i10 = R$id.tv_sheet_step_title;
                                TextView textView4 = (TextView) C5437a.a(view, i10);
                                if (textView4 != null) {
                                    return new l((FrameLayout) view, linearLayout, linearLayout2, linearLayout3, textView, textView2, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static l c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.dialog_add_agent, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
