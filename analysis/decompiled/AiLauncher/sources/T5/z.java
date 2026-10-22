package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class z {
    public final TextView btnComboAction;
    public final LinearLayout llComboHotel;
    public final LinearLayout llComboTransport;
    private final LinearLayout rootView;
    public final TextView tvComboHotelSub;
    public final TextView tvComboHotelTitle;
    public final TextView tvComboTotalPrice;
    public final TextView tvComboTransportSub;
    public final TextView tvComboTransportTitle;

    public z(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.btnComboAction = textView;
        this.llComboHotel = linearLayout2;
        this.llComboTransport = linearLayout3;
        this.tvComboHotelSub = textView2;
        this.tvComboHotelTitle = textView3;
        this.tvComboTotalPrice = textView4;
        this.tvComboTransportSub = textView5;
        this.tvComboTransportTitle = textView6;
    }

    public static z a(View view) {
        int i10 = R$id.btnComboAction;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.llComboHotel;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                i10 = R$id.llComboTransport;
                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout2 != null) {
                    i10 = R$id.tvComboHotelSub;
                    TextView textView2 = (TextView) C5437a.a(view, i10);
                    if (textView2 != null) {
                        i10 = R$id.tvComboHotelTitle;
                        TextView textView3 = (TextView) C5437a.a(view, i10);
                        if (textView3 != null) {
                            i10 = R$id.tvComboTotalPrice;
                            TextView textView4 = (TextView) C5437a.a(view, i10);
                            if (textView4 != null) {
                                i10 = R$id.tvComboTransportSub;
                                TextView textView5 = (TextView) C5437a.a(view, i10);
                                if (textView5 != null) {
                                    i10 = R$id.tvComboTransportTitle;
                                    TextView textView6 = (TextView) C5437a.a(view, i10);
                                    if (textView6 != null) {
                                        return new z((LinearLayout) view, textView, linearLayout, linearLayout2, textView2, textView3, textView4, textView5, textView6);
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

    public static z b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_trip_combo, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
