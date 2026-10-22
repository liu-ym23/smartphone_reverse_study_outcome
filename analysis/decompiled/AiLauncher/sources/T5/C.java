package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class C {
    public final ImageView ivHourlyIcon;
    private final LinearLayout rootView;
    public final Space spaceHourlyFill;
    public final TextView tvHourlyPop;
    public final TextView tvHourlyTemp;
    public final TextView tvHourlyTime;

    public C(LinearLayout linearLayout, ImageView imageView, Space space, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.ivHourlyIcon = imageView;
        this.spaceHourlyFill = space;
        this.tvHourlyPop = textView;
        this.tvHourlyTemp = textView2;
        this.tvHourlyTime = textView3;
    }

    public static C a(View view) {
        int i10 = R$id.ivHourlyIcon;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.spaceHourlyFill;
            Space space = (Space) C5437a.a(view, i10);
            if (space != null) {
                i10 = R$id.tvHourlyPop;
                TextView textView = (TextView) C5437a.a(view, i10);
                if (textView != null) {
                    i10 = R$id.tvHourlyTemp;
                    TextView textView2 = (TextView) C5437a.a(view, i10);
                    if (textView2 != null) {
                        i10 = R$id.tvHourlyTime;
                        TextView textView3 = (TextView) C5437a.a(view, i10);
                        if (textView3 != null) {
                            return new C((LinearLayout) view, imageView, space, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static C c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_weather_hourly_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
