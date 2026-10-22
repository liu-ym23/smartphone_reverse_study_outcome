package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.agentframework.uikit.IndeterminateSpinnerView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class u {
    public final TextView btnRouteAction;
    public final FrameLayout flMapSlot;
    public final ImageView ivRouteMap;
    public final LinearLayout llModeTabs;
    public final LinearLayout llRouteTags;
    public final LinearLayout llWaypoints;
    private final LinearLayout rootView;
    public final HorizontalScrollView scrollRouteTags;
    public final TextView tvRouteDistance;
    public final TextView tvRouteDuration;
    public final TextView tvRouteOrigin;
    public final TextView tvRouteSummaryDot;
    public final IndeterminateSpinnerView vRouteMapLoading;

    public u(LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, HorizontalScrollView horizontalScrollView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, IndeterminateSpinnerView indeterminateSpinnerView) {
        this.rootView = linearLayout;
        this.btnRouteAction = textView;
        this.flMapSlot = frameLayout;
        this.ivRouteMap = imageView;
        this.llModeTabs = linearLayout2;
        this.llRouteTags = linearLayout3;
        this.llWaypoints = linearLayout4;
        this.scrollRouteTags = horizontalScrollView;
        this.tvRouteDistance = textView2;
        this.tvRouteDuration = textView3;
        this.tvRouteOrigin = textView4;
        this.tvRouteSummaryDot = textView5;
        this.vRouteMapLoading = indeterminateSpinnerView;
    }

    public static u a(View view) {
        int i10 = R$id.btnRouteAction;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.flMapSlot;
            FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
            if (frameLayout != null) {
                i10 = R$id.ivRouteMap;
                ImageView imageView = (ImageView) C5437a.a(view, i10);
                if (imageView != null) {
                    i10 = R$id.llModeTabs;
                    LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout != null) {
                        i10 = R$id.llRouteTags;
                        LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout2 != null) {
                            i10 = R$id.llWaypoints;
                            LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                            if (linearLayout3 != null) {
                                i10 = R$id.scrollRouteTags;
                                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) C5437a.a(view, i10);
                                if (horizontalScrollView != null) {
                                    i10 = R$id.tvRouteDistance;
                                    TextView textView2 = (TextView) C5437a.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R$id.tvRouteDuration;
                                        TextView textView3 = (TextView) C5437a.a(view, i10);
                                        if (textView3 != null) {
                                            i10 = R$id.tvRouteOrigin;
                                            TextView textView4 = (TextView) C5437a.a(view, i10);
                                            if (textView4 != null) {
                                                i10 = R$id.tvRouteSummaryDot;
                                                TextView textView5 = (TextView) C5437a.a(view, i10);
                                                if (textView5 != null) {
                                                    i10 = R$id.vRouteMapLoading;
                                                    IndeterminateSpinnerView indeterminateSpinnerView = (IndeterminateSpinnerView) C5437a.a(view, i10);
                                                    if (indeterminateSpinnerView != null) {
                                                        return new u((LinearLayout) view, textView, frameLayout, imageView, linearLayout, linearLayout2, linearLayout3, horizontalScrollView, textView2, textView3, textView4, textView5, indeterminateSpinnerView);
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

    public static u c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_map_route, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
