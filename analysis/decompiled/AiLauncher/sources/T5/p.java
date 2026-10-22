package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class p {
    public final TextView btnHotelAction;
    public final FrameLayout flHotelCover;
    public final ImageView ivHotelCover;
    public final LinearLayout llHotelPriceGroup;
    private final LinearLayout rootView;
    public final TextView tvHotelCurrency;
    public final TextView tvHotelName;
    public final TextView tvHotelPrice;
    public final TextView tvHotelRating;

    public p(LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btnHotelAction = textView;
        this.flHotelCover = frameLayout;
        this.ivHotelCover = imageView;
        this.llHotelPriceGroup = linearLayout2;
        this.tvHotelCurrency = textView2;
        this.tvHotelName = textView3;
        this.tvHotelPrice = textView4;
        this.tvHotelRating = textView5;
    }

    public static p a(View view) {
        int i10 = R$id.btnHotelAction;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.flHotelCover;
            FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
            if (frameLayout != null) {
                i10 = R$id.ivHotelCover;
                ImageView imageView = (ImageView) C5437a.a(view, i10);
                if (imageView != null) {
                    i10 = R$id.llHotelPriceGroup;
                    LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout != null) {
                        i10 = R$id.tvHotelCurrency;
                        TextView textView2 = (TextView) C5437a.a(view, i10);
                        if (textView2 != null) {
                            i10 = R$id.tvHotelName;
                            TextView textView3 = (TextView) C5437a.a(view, i10);
                            if (textView3 != null) {
                                i10 = R$id.tvHotelPrice;
                                TextView textView4 = (TextView) C5437a.a(view, i10);
                                if (textView4 != null) {
                                    i10 = R$id.tvHotelRating;
                                    TextView textView5 = (TextView) C5437a.a(view, i10);
                                    if (textView5 != null) {
                                        return new p((LinearLayout) view, textView, frameLayout, imageView, linearLayout, textView2, textView3, textView4, textView5);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static p c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_hotel_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
