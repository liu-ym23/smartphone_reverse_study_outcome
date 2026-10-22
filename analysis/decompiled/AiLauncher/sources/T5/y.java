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
public final class y {
    public final TextView btnTransportAction;
    public final ImageView ivTransportIcon;
    public final ImageView ivTransportIllustration;
    public final LinearLayout llTransportPriceGroup;
    public final LinearLayout llTransportSubtitle;
    private final LinearLayout rootView;
    public final TextView tvArrDaySpan;
    public final TextView tvArrPlace;
    public final TextView tvArrTime;
    public final TextView tvDepPlace;
    public final TextView tvDepTime;
    public final TextView tvDuration;
    public final TextView tvTransportCabin;
    public final TextView tvTransportCurrency;
    public final TextView tvTransportDiscount;
    public final TextView tvTransportPrice;
    public final TextView tvTransportStop;
    public final TextView tvTransportTags;
    public final TextView tvTransportTitle;
    public final View vTransportSubtitleDivider;

    public y(LinearLayout linearLayout, TextView textView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, View view) {
        this.rootView = linearLayout;
        this.btnTransportAction = textView;
        this.ivTransportIcon = imageView;
        this.ivTransportIllustration = imageView2;
        this.llTransportPriceGroup = linearLayout2;
        this.llTransportSubtitle = linearLayout3;
        this.tvArrDaySpan = textView2;
        this.tvArrPlace = textView3;
        this.tvArrTime = textView4;
        this.tvDepPlace = textView5;
        this.tvDepTime = textView6;
        this.tvDuration = textView7;
        this.tvTransportCabin = textView8;
        this.tvTransportCurrency = textView9;
        this.tvTransportDiscount = textView10;
        this.tvTransportPrice = textView11;
        this.tvTransportStop = textView12;
        this.tvTransportTags = textView13;
        this.tvTransportTitle = textView14;
        this.vTransportSubtitleDivider = view;
    }

    public static y a(View view) {
        View viewA;
        int i10 = R$id.btnTransportAction;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.ivTransportIcon;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R$id.ivTransportIllustration;
                ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                if (imageView2 != null) {
                    i10 = R$id.llTransportPriceGroup;
                    LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout != null) {
                        i10 = R$id.llTransportSubtitle;
                        LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout2 != null) {
                            i10 = R$id.tvArrDaySpan;
                            TextView textView2 = (TextView) C5437a.a(view, i10);
                            if (textView2 != null) {
                                i10 = R$id.tvArrPlace;
                                TextView textView3 = (TextView) C5437a.a(view, i10);
                                if (textView3 != null) {
                                    i10 = R$id.tvArrTime;
                                    TextView textView4 = (TextView) C5437a.a(view, i10);
                                    if (textView4 != null) {
                                        i10 = R$id.tvDepPlace;
                                        TextView textView5 = (TextView) C5437a.a(view, i10);
                                        if (textView5 != null) {
                                            i10 = R$id.tvDepTime;
                                            TextView textView6 = (TextView) C5437a.a(view, i10);
                                            if (textView6 != null) {
                                                i10 = R$id.tvDuration;
                                                TextView textView7 = (TextView) C5437a.a(view, i10);
                                                if (textView7 != null) {
                                                    i10 = R$id.tvTransportCabin;
                                                    TextView textView8 = (TextView) C5437a.a(view, i10);
                                                    if (textView8 != null) {
                                                        i10 = R$id.tvTransportCurrency;
                                                        TextView textView9 = (TextView) C5437a.a(view, i10);
                                                        if (textView9 != null) {
                                                            i10 = R$id.tvTransportDiscount;
                                                            TextView textView10 = (TextView) C5437a.a(view, i10);
                                                            if (textView10 != null) {
                                                                i10 = R$id.tvTransportPrice;
                                                                TextView textView11 = (TextView) C5437a.a(view, i10);
                                                                if (textView11 != null) {
                                                                    i10 = R$id.tvTransportStop;
                                                                    TextView textView12 = (TextView) C5437a.a(view, i10);
                                                                    if (textView12 != null) {
                                                                        i10 = R$id.tvTransportTags;
                                                                        TextView textView13 = (TextView) C5437a.a(view, i10);
                                                                        if (textView13 != null) {
                                                                            i10 = R$id.tvTransportTitle;
                                                                            TextView textView14 = (TextView) C5437a.a(view, i10);
                                                                            if (textView14 != null && (viewA = C5437a.a(view, (i10 = R$id.vTransportSubtitleDivider))) != null) {
                                                                                return new y((LinearLayout) view, textView, imageView, imageView2, linearLayout, linearLayout2, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, viewA);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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

    public static y c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_transport_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
