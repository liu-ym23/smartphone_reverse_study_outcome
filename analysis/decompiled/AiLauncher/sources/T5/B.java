package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class B {
    public final ImageView ivDailyIcon;
    private final LinearLayout rootView;
    public final TextView tvDailyCondition;
    public final TextView tvDailyDate;
    public final TextView tvDailyPop;
    public final TextView tvDailyTempRange;
    public final TextView tvDailyWeek;
    public final View vDailyDivider;

    public B(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.rootView = linearLayout;
        this.ivDailyIcon = imageView;
        this.tvDailyCondition = textView;
        this.tvDailyDate = textView2;
        this.tvDailyPop = textView3;
        this.tvDailyTempRange = textView4;
        this.tvDailyWeek = textView5;
        this.vDailyDivider = view;
    }

    public static B a(View view) {
        View viewA;
        int i10 = R$id.ivDailyIcon;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.tvDailyCondition;
            TextView textView = (TextView) C5437a.a(view, i10);
            if (textView != null) {
                i10 = R$id.tvDailyDate;
                TextView textView2 = (TextView) C5437a.a(view, i10);
                if (textView2 != null) {
                    i10 = R$id.tvDailyPop;
                    TextView textView3 = (TextView) C5437a.a(view, i10);
                    if (textView3 != null) {
                        i10 = R$id.tvDailyTempRange;
                        TextView textView4 = (TextView) C5437a.a(view, i10);
                        if (textView4 != null) {
                            i10 = R$id.tvDailyWeek;
                            TextView textView5 = (TextView) C5437a.a(view, i10);
                            if (textView5 != null && (viewA = C5437a.a(view, (i10 = R$id.vDailyDivider))) != null) {
                                return new B((LinearLayout) view, imageView, textView, textView2, textView3, textView4, textView5, viewA);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static B c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_weather_daily_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
