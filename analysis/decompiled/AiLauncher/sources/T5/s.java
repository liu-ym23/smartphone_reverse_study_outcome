package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager2.widget.ViewPager2;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class s {
    public final TextView btnPoiAction;
    public final FrameLayout flGallery;
    public final FrameLayout flPoiFooter;
    public final ImageView ivGalleryClose;
    public final LinearLayout llGalleryDots;
    public final LinearLayout llPoiInfo;
    private final FrameLayout rootView;
    public final LinearLayout rowPoiAddress;
    public final LinearLayout rowPoiDistance;
    public final LinearLayout rowPoiHours;
    public final LinearLayout rowPoiPrice;
    public final LinearLayout rowPoiStatus;
    public final LinearLayout rowPoiTip;
    public final NestedScrollView scrollPoiDetail;
    public final TextView tvPoiAddress;
    public final TextView tvPoiDescription;
    public final TextView tvPoiDistance;
    public final TextView tvPoiHours;
    public final TextView tvPoiMeta;
    public final TextView tvPoiName;
    public final TextView tvPoiPrice;
    public final TextView tvPoiRating;
    public final TextView tvPoiReviewCount;
    public final TextView tvPoiStatus;
    public final TextView tvPoiTip;
    public final View vPoiBottomFade;
    public final ViewPager2 vpGallery;

    public s(FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, NestedScrollView nestedScrollView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, View view, ViewPager2 viewPager2) {
        this.rootView = frameLayout;
        this.btnPoiAction = textView;
        this.flGallery = frameLayout2;
        this.flPoiFooter = frameLayout3;
        this.ivGalleryClose = imageView;
        this.llGalleryDots = linearLayout;
        this.llPoiInfo = linearLayout2;
        this.rowPoiAddress = linearLayout3;
        this.rowPoiDistance = linearLayout4;
        this.rowPoiHours = linearLayout5;
        this.rowPoiPrice = linearLayout6;
        this.rowPoiStatus = linearLayout7;
        this.rowPoiTip = linearLayout8;
        this.scrollPoiDetail = nestedScrollView;
        this.tvPoiAddress = textView2;
        this.tvPoiDescription = textView3;
        this.tvPoiDistance = textView4;
        this.tvPoiHours = textView5;
        this.tvPoiMeta = textView6;
        this.tvPoiName = textView7;
        this.tvPoiPrice = textView8;
        this.tvPoiRating = textView9;
        this.tvPoiReviewCount = textView10;
        this.tvPoiStatus = textView11;
        this.tvPoiTip = textView12;
        this.vPoiBottomFade = view;
        this.vpGallery = viewPager2;
    }

    public static s a(View view) {
        View viewA;
        int i10 = R$id.btnPoiAction;
        TextView textView = (TextView) C5437a.a(view, i10);
        if (textView != null) {
            i10 = R$id.flGallery;
            FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
            if (frameLayout != null) {
                i10 = R$id.flPoiFooter;
                FrameLayout frameLayout2 = (FrameLayout) C5437a.a(view, i10);
                if (frameLayout2 != null) {
                    i10 = R$id.ivGalleryClose;
                    ImageView imageView = (ImageView) C5437a.a(view, i10);
                    if (imageView != null) {
                        i10 = R$id.llGalleryDots;
                        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout != null) {
                            i10 = R$id.llPoiInfo;
                            LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                            if (linearLayout2 != null) {
                                i10 = R$id.rowPoiAddress;
                                LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                                if (linearLayout3 != null) {
                                    i10 = R$id.rowPoiDistance;
                                    LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                    if (linearLayout4 != null) {
                                        i10 = R$id.rowPoiHours;
                                        LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                                        if (linearLayout5 != null) {
                                            i10 = R$id.rowPoiPrice;
                                            LinearLayout linearLayout6 = (LinearLayout) C5437a.a(view, i10);
                                            if (linearLayout6 != null) {
                                                i10 = R$id.rowPoiStatus;
                                                LinearLayout linearLayout7 = (LinearLayout) C5437a.a(view, i10);
                                                if (linearLayout7 != null) {
                                                    i10 = R$id.rowPoiTip;
                                                    LinearLayout linearLayout8 = (LinearLayout) C5437a.a(view, i10);
                                                    if (linearLayout8 != null) {
                                                        i10 = R$id.scrollPoiDetail;
                                                        NestedScrollView nestedScrollView = (NestedScrollView) C5437a.a(view, i10);
                                                        if (nestedScrollView != null) {
                                                            i10 = R$id.tvPoiAddress;
                                                            TextView textView2 = (TextView) C5437a.a(view, i10);
                                                            if (textView2 != null) {
                                                                i10 = R$id.tvPoiDescription;
                                                                TextView textView3 = (TextView) C5437a.a(view, i10);
                                                                if (textView3 != null) {
                                                                    i10 = R$id.tvPoiDistance;
                                                                    TextView textView4 = (TextView) C5437a.a(view, i10);
                                                                    if (textView4 != null) {
                                                                        i10 = R$id.tvPoiHours;
                                                                        TextView textView5 = (TextView) C5437a.a(view, i10);
                                                                        if (textView5 != null) {
                                                                            i10 = R$id.tvPoiMeta;
                                                                            TextView textView6 = (TextView) C5437a.a(view, i10);
                                                                            if (textView6 != null) {
                                                                                i10 = R$id.tvPoiName;
                                                                                TextView textView7 = (TextView) C5437a.a(view, i10);
                                                                                if (textView7 != null) {
                                                                                    i10 = R$id.tvPoiPrice;
                                                                                    TextView textView8 = (TextView) C5437a.a(view, i10);
                                                                                    if (textView8 != null) {
                                                                                        i10 = R$id.tvPoiRating;
                                                                                        TextView textView9 = (TextView) C5437a.a(view, i10);
                                                                                        if (textView9 != null) {
                                                                                            i10 = R$id.tvPoiReviewCount;
                                                                                            TextView textView10 = (TextView) C5437a.a(view, i10);
                                                                                            if (textView10 != null) {
                                                                                                i10 = R$id.tvPoiStatus;
                                                                                                TextView textView11 = (TextView) C5437a.a(view, i10);
                                                                                                if (textView11 != null) {
                                                                                                    i10 = R$id.tvPoiTip;
                                                                                                    TextView textView12 = (TextView) C5437a.a(view, i10);
                                                                                                    if (textView12 != null && (viewA = C5437a.a(view, (i10 = R$id.vPoiBottomFade))) != null) {
                                                                                                        i10 = R$id.vpGallery;
                                                                                                        ViewPager2 viewPager2 = (ViewPager2) C5437a.a(view, i10);
                                                                                                        if (viewPager2 != null) {
                                                                                                            return new s((FrameLayout) view, textView, frameLayout, frameLayout2, imageView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, nestedScrollView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, viewA, viewPager2);
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
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static s c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_map_poi_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public FrameLayout b() {
        return this.rootView;
    }
}
