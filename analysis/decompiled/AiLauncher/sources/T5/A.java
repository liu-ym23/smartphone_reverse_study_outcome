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
import com.stepos.ailauncher.foundation.appui.card.widget.NestedHorizontalScrollView;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class A {
    public final LinearLayout groupWeatherDailyHeader;
    public final LinearLayout groupWeatherSingleBody;
    public final FrameLayout groupWeatherSingleHeader;
    public final LinearLayout groupWeatherUvSingle;
    public final NestedHorizontalScrollView hsvWeatherHourly;
    public final ImageView ivWeatherIcon;
    public final LinearLayout llWeatherCard;
    public final LinearLayout llWeatherDaily;
    public final LinearLayout llWeatherHourly;
    private final LinearLayout rootView;
    public final TextView tvWeatherCondition;
    public final TextView tvWeatherDailyLocation;
    public final TextView tvWeatherDayLabel;
    public final TextView tvWeatherLocation;
    public final TextView tvWeatherMeta;
    public final TextView tvWeatherTemp;
    public final TextView tvWeatherTempRange;
    public final TextView tvWeatherTempUnit;
    public final TextView tvWeatherUvTipDaily;
    public final TextView tvWeatherUvTipSingle;
    public final View vWeatherBottomSpacer;
    public final View vWeatherDailyHeaderDivider;
    public final View vWeatherHourlyDivider;

    public A(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, FrameLayout frameLayout, LinearLayout linearLayout4, NestedHorizontalScrollView nestedHorizontalScrollView, ImageView imageView, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, View view, View view2, View view3) {
        this.rootView = linearLayout;
        this.groupWeatherDailyHeader = linearLayout2;
        this.groupWeatherSingleBody = linearLayout3;
        this.groupWeatherSingleHeader = frameLayout;
        this.groupWeatherUvSingle = linearLayout4;
        this.hsvWeatherHourly = nestedHorizontalScrollView;
        this.ivWeatherIcon = imageView;
        this.llWeatherCard = linearLayout5;
        this.llWeatherDaily = linearLayout6;
        this.llWeatherHourly = linearLayout7;
        this.tvWeatherCondition = textView;
        this.tvWeatherDailyLocation = textView2;
        this.tvWeatherDayLabel = textView3;
        this.tvWeatherLocation = textView4;
        this.tvWeatherMeta = textView5;
        this.tvWeatherTemp = textView6;
        this.tvWeatherTempRange = textView7;
        this.tvWeatherTempUnit = textView8;
        this.tvWeatherUvTipDaily = textView9;
        this.tvWeatherUvTipSingle = textView10;
        this.vWeatherBottomSpacer = view;
        this.vWeatherDailyHeaderDivider = view2;
        this.vWeatherHourlyDivider = view3;
    }

    public static A a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i10 = R$id.groupWeatherDailyHeader;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.groupWeatherSingleBody;
            LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R$id.groupWeatherSingleHeader;
                FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                if (frameLayout != null) {
                    i10 = R$id.groupWeatherUvSingle;
                    LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout3 != null) {
                        i10 = R$id.hsvWeatherHourly;
                        NestedHorizontalScrollView nestedHorizontalScrollView = (NestedHorizontalScrollView) C5437a.a(view, i10);
                        if (nestedHorizontalScrollView != null) {
                            i10 = R$id.ivWeatherIcon;
                            ImageView imageView = (ImageView) C5437a.a(view, i10);
                            if (imageView != null) {
                                LinearLayout linearLayout4 = (LinearLayout) view;
                                i10 = R$id.llWeatherDaily;
                                LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                                if (linearLayout5 != null) {
                                    i10 = R$id.llWeatherHourly;
                                    LinearLayout linearLayout6 = (LinearLayout) C5437a.a(view, i10);
                                    if (linearLayout6 != null) {
                                        i10 = R$id.tvWeatherCondition;
                                        TextView textView = (TextView) C5437a.a(view, i10);
                                        if (textView != null) {
                                            i10 = R$id.tvWeatherDailyLocation;
                                            TextView textView2 = (TextView) C5437a.a(view, i10);
                                            if (textView2 != null) {
                                                i10 = R$id.tvWeatherDayLabel;
                                                TextView textView3 = (TextView) C5437a.a(view, i10);
                                                if (textView3 != null) {
                                                    i10 = R$id.tvWeatherLocation;
                                                    TextView textView4 = (TextView) C5437a.a(view, i10);
                                                    if (textView4 != null) {
                                                        i10 = R$id.tvWeatherMeta;
                                                        TextView textView5 = (TextView) C5437a.a(view, i10);
                                                        if (textView5 != null) {
                                                            i10 = R$id.tvWeatherTemp;
                                                            TextView textView6 = (TextView) C5437a.a(view, i10);
                                                            if (textView6 != null) {
                                                                i10 = R$id.tvWeatherTempRange;
                                                                TextView textView7 = (TextView) C5437a.a(view, i10);
                                                                if (textView7 != null) {
                                                                    i10 = R$id.tvWeatherTempUnit;
                                                                    TextView textView8 = (TextView) C5437a.a(view, i10);
                                                                    if (textView8 != null) {
                                                                        i10 = R$id.tvWeatherUvTipDaily;
                                                                        TextView textView9 = (TextView) C5437a.a(view, i10);
                                                                        if (textView9 != null) {
                                                                            i10 = R$id.tvWeatherUvTipSingle;
                                                                            TextView textView10 = (TextView) C5437a.a(view, i10);
                                                                            if (textView10 != null && (viewA = C5437a.a(view, (i10 = R$id.vWeatherBottomSpacer))) != null && (viewA2 = C5437a.a(view, (i10 = R$id.vWeatherDailyHeaderDivider))) != null && (viewA3 = C5437a.a(view, (i10 = R$id.vWeatherHourlyDivider))) != null) {
                                                                                return new A(linearLayout4, linearLayout, linearLayout2, frameLayout, linearLayout3, nestedHorizontalScrollView, imageView, linearLayout4, linearLayout5, linearLayout6, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, viewA, viewA2, viewA3);
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

    public static A b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_weather, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }
}
