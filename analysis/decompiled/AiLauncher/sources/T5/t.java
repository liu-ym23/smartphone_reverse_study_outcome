package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.stepos.agentframework.uikit.IndeterminateSpinnerView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.MapAspectFrameLayout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class t {
    public final FrameLayout flPoiDetail;
    public final MapAspectFrameLayout flPoiListMap;
    public final FrameLayout flPoiMarkerOverlay;
    public final ImageView ivPoiListMap;
    private final LinearLayout rootView;
    public final IndeterminateSpinnerView vPoiListMapLoading;
    public final ViewPager2 vpPoiCards;

    public t(LinearLayout linearLayout, FrameLayout frameLayout, MapAspectFrameLayout mapAspectFrameLayout, FrameLayout frameLayout2, ImageView imageView, IndeterminateSpinnerView indeterminateSpinnerView, ViewPager2 viewPager2) {
        this.rootView = linearLayout;
        this.flPoiDetail = frameLayout;
        this.flPoiListMap = mapAspectFrameLayout;
        this.flPoiMarkerOverlay = frameLayout2;
        this.ivPoiListMap = imageView;
        this.vPoiListMapLoading = indeterminateSpinnerView;
        this.vpPoiCards = viewPager2;
    }

    public static t a(View view) {
        int i10 = R$id.flPoiDetail;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null) {
            i10 = R$id.flPoiListMap;
            MapAspectFrameLayout mapAspectFrameLayout = (MapAspectFrameLayout) C5437a.a(view, i10);
            if (mapAspectFrameLayout != null) {
                i10 = R$id.flPoiMarkerOverlay;
                FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
                if (frameLayout2 != null) {
                    i10 = R$id.ivPoiListMap;
                    ImageView imageView = (ImageView) C5437a.a(view, i10);
                    if (imageView != null) {
                        i10 = R$id.vPoiListMapLoading;
                        IndeterminateSpinnerView indeterminateSpinnerView = (IndeterminateSpinnerView) C5437a.a(view, i10);
                        if (indeterminateSpinnerView != null) {
                            i10 = R$id.vpPoiCards;
                            ViewPager2 viewPager2 = (ViewPager2) C5437a.a(view, i10);
                            if (viewPager2 != null) {
                                return new t((LinearLayout) view, frameLayout, mapAspectFrameLayout, frameLayout2, imageView, indeterminateSpinnerView, viewPager2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static t c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_map_poi_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
