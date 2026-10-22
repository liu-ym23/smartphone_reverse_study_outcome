package l5;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.view.ProgressSplitTextView;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class c {
    public final NestedScrollView appDetailScroll;
    public final LinearLayout appHeader;
    public final LinearLayout appIntro;
    public final LinearLayout appStats;
    public final LinearLayout assetInfoCard;
    public final View bottomChromeBlur;
    public final ImageView btnBack;
    public final ProgressSplitTextView btnInstall;
    public final ImageView btnMore;
    public final LinearLayout cardAssetInfo;
    public final FrameLayout detailTopBar;
    public final ImageView ivAppIcon;
    private final FrameLayout rootView;
    public final LinearLayout rowInfoCategory;
    public final LinearLayout rowInfoCreated;
    public final LinearLayout rowInfoDownloads;
    public final LinearLayout rowInfoUpdated;
    public final LinearLayout rowInfoVersion;
    public final RecyclerView rvAppScreenshots;
    public final View topChromeBlur;
    public final TextView tvAppDesc;
    public final TextView tvAppName;
    public final TextView tvAppSubtitle;
    public final TextView tvAssetInfoTitle;
    public final TextView tvInfoCategory;
    public final TextView tvInfoCreated;
    public final TextView tvInfoDownloads;
    public final TextView tvInfoUpdated;
    public final TextView tvInfoVersion;
    public final TextView tvStatDownloadsValue;
    public final TextView tvStatSizeValue;
    public final TextView tvStatUpdatedValue;

    public c(FrameLayout frameLayout, NestedScrollView nestedScrollView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, View view, ImageView imageView, ProgressSplitTextView progressSplitTextView, ImageView imageView2, LinearLayout linearLayout5, FrameLayout frameLayout2, ImageView imageView3, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, RecyclerView recyclerView, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = frameLayout;
        this.appDetailScroll = nestedScrollView;
        this.appHeader = linearLayout;
        this.appIntro = linearLayout2;
        this.appStats = linearLayout3;
        this.assetInfoCard = linearLayout4;
        this.bottomChromeBlur = view;
        this.btnBack = imageView;
        this.btnInstall = progressSplitTextView;
        this.btnMore = imageView2;
        this.cardAssetInfo = linearLayout5;
        this.detailTopBar = frameLayout2;
        this.ivAppIcon = imageView3;
        this.rowInfoCategory = linearLayout6;
        this.rowInfoCreated = linearLayout7;
        this.rowInfoDownloads = linearLayout8;
        this.rowInfoUpdated = linearLayout9;
        this.rowInfoVersion = linearLayout10;
        this.rvAppScreenshots = recyclerView;
        this.topChromeBlur = view2;
        this.tvAppDesc = textView;
        this.tvAppName = textView2;
        this.tvAppSubtitle = textView3;
        this.tvAssetInfoTitle = textView4;
        this.tvInfoCategory = textView5;
        this.tvInfoCreated = textView6;
        this.tvInfoDownloads = textView7;
        this.tvInfoUpdated = textView8;
        this.tvInfoVersion = textView9;
        this.tvStatDownloadsValue = textView10;
        this.tvStatSizeValue = textView11;
        this.tvStatUpdatedValue = textView12;
    }

    public static c a(View view) {
        View viewA;
        View viewA2;
        int i10 = R$id.appDetailScroll;
        NestedScrollView nestedScrollView = (NestedScrollView) C5437a.a(view, i10);
        if (nestedScrollView != null) {
            i10 = R$id.appHeader;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                i10 = R$id.appIntro;
                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout2 != null) {
                    i10 = R$id.appStats;
                    LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout3 != null) {
                        i10 = R$id.assetInfoCard;
                        LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout4 != null && (viewA = C5437a.a(view, (i10 = R$id.bottomChromeBlur))) != null) {
                            i10 = R$id.btnBack;
                            ImageView imageView = (ImageView) C5437a.a(view, i10);
                            if (imageView != null) {
                                i10 = R$id.btnInstall;
                                ProgressSplitTextView progressSplitTextView = (ProgressSplitTextView) C5437a.a(view, i10);
                                if (progressSplitTextView != null) {
                                    i10 = R$id.btnMore;
                                    ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                                    if (imageView2 != null) {
                                        i10 = R$id.cardAssetInfo;
                                        LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                                        if (linearLayout5 != null) {
                                            i10 = R$id.detailTopBar;
                                            FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
                                            if (frameLayout != null) {
                                                i10 = R$id.ivAppIcon;
                                                ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                                                if (imageView3 != null) {
                                                    i10 = R$id.rowInfoCategory;
                                                    LinearLayout linearLayout6 = (LinearLayout) C5437a.a(view, i10);
                                                    if (linearLayout6 != null) {
                                                        i10 = R$id.rowInfoCreated;
                                                        LinearLayout linearLayout7 = (LinearLayout) C5437a.a(view, i10);
                                                        if (linearLayout7 != null) {
                                                            i10 = R$id.rowInfoDownloads;
                                                            LinearLayout linearLayout8 = (LinearLayout) C5437a.a(view, i10);
                                                            if (linearLayout8 != null) {
                                                                i10 = R$id.rowInfoUpdated;
                                                                LinearLayout linearLayout9 = (LinearLayout) C5437a.a(view, i10);
                                                                if (linearLayout9 != null) {
                                                                    i10 = R$id.rowInfoVersion;
                                                                    LinearLayout linearLayout10 = (LinearLayout) C5437a.a(view, i10);
                                                                    if (linearLayout10 != null) {
                                                                        i10 = R$id.rvAppScreenshots;
                                                                        RecyclerView recyclerView = (RecyclerView) C5437a.a(view, i10);
                                                                        if (recyclerView != null && (viewA2 = C5437a.a(view, (i10 = R$id.topChromeBlur))) != null) {
                                                                            i10 = R$id.tvAppDesc;
                                                                            TextView textView = (TextView) C5437a.a(view, i10);
                                                                            if (textView != null) {
                                                                                i10 = R$id.tvAppName;
                                                                                TextView textView2 = (TextView) C5437a.a(view, i10);
                                                                                if (textView2 != null) {
                                                                                    i10 = R$id.tvAppSubtitle;
                                                                                    TextView textView3 = (TextView) C5437a.a(view, i10);
                                                                                    if (textView3 != null) {
                                                                                        i10 = R$id.tvAssetInfoTitle;
                                                                                        TextView textView4 = (TextView) C5437a.a(view, i10);
                                                                                        if (textView4 != null) {
                                                                                            i10 = R$id.tvInfoCategory;
                                                                                            TextView textView5 = (TextView) C5437a.a(view, i10);
                                                                                            if (textView5 != null) {
                                                                                                i10 = R$id.tvInfoCreated;
                                                                                                TextView textView6 = (TextView) C5437a.a(view, i10);
                                                                                                if (textView6 != null) {
                                                                                                    i10 = R$id.tvInfoDownloads;
                                                                                                    TextView textView7 = (TextView) C5437a.a(view, i10);
                                                                                                    if (textView7 != null) {
                                                                                                        i10 = R$id.tvInfoUpdated;
                                                                                                        TextView textView8 = (TextView) C5437a.a(view, i10);
                                                                                                        if (textView8 != null) {
                                                                                                            i10 = R$id.tvInfoVersion;
                                                                                                            TextView textView9 = (TextView) C5437a.a(view, i10);
                                                                                                            if (textView9 != null) {
                                                                                                                i10 = R$id.tvStatDownloadsValue;
                                                                                                                TextView textView10 = (TextView) C5437a.a(view, i10);
                                                                                                                if (textView10 != null) {
                                                                                                                    i10 = R$id.tvStatSizeValue;
                                                                                                                    TextView textView11 = (TextView) C5437a.a(view, i10);
                                                                                                                    if (textView11 != null) {
                                                                                                                        i10 = R$id.tvStatUpdatedValue;
                                                                                                                        TextView textView12 = (TextView) C5437a.a(view, i10);
                                                                                                                        if (textView12 != null) {
                                                                                                                            return new c((FrameLayout) view, nestedScrollView, linearLayout, linearLayout2, linearLayout3, linearLayout4, viewA, imageView, progressSplitTextView, imageView2, linearLayout5, frameLayout, imageView3, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, recyclerView, viewA2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }
}
