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
public final class j {
    public final FrameLayout flCustomContent;
    public final ImageView ivChannelLogo;
    public final LinearLayout llCardBody;
    public final LinearLayout llLinks;
    public final LinearLayout llSearchHeader;
    private final LinearLayout rootView;
    public final TextView tvCardStatus;
    public final TextView tvCardTitle;
    public final TextView tvSearchChevron;
    public final TextView tvSearchSource;
    public final TextView tvSummaryDesc;
    public final TextView tvSummaryTitle;
    public final TextView tvUpdatedAt;

    public j(LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = linearLayout;
        this.flCustomContent = frameLayout;
        this.ivChannelLogo = imageView;
        this.llCardBody = linearLayout2;
        this.llLinks = linearLayout3;
        this.llSearchHeader = linearLayout4;
        this.tvCardStatus = textView;
        this.tvCardTitle = textView2;
        this.tvSearchChevron = textView3;
        this.tvSearchSource = textView4;
        this.tvSummaryDesc = textView5;
        this.tvSummaryTitle = textView6;
        this.tvUpdatedAt = textView7;
    }

    public static j a(View view) {
        int i10 = R$id.flCustomContent;
        FrameLayout frameLayout = (FrameLayout) C5437a.a(view, i10);
        if (frameLayout != null) {
            i10 = R$id.ivChannelLogo;
            ImageView imageView = (ImageView) C5437a.a(view, i10);
            if (imageView != null) {
                i10 = R$id.llCardBody;
                LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout != null) {
                    i10 = R$id.llLinks;
                    LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout2 != null) {
                        i10 = R$id.llSearchHeader;
                        LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout3 != null) {
                            i10 = R$id.tvCardStatus;
                            TextView textView = (TextView) C5437a.a(view, i10);
                            if (textView != null) {
                                i10 = R$id.tvCardTitle;
                                TextView textView2 = (TextView) C5437a.a(view, i10);
                                if (textView2 != null) {
                                    i10 = R$id.tvSearchChevron;
                                    TextView textView3 = (TextView) C5437a.a(view, i10);
                                    if (textView3 != null) {
                                        i10 = R$id.tvSearchSource;
                                        TextView textView4 = (TextView) C5437a.a(view, i10);
                                        if (textView4 != null) {
                                            i10 = R$id.tvSummaryDesc;
                                            TextView textView5 = (TextView) C5437a.a(view, i10);
                                            if (textView5 != null) {
                                                i10 = R$id.tvSummaryTitle;
                                                TextView textView6 = (TextView) C5437a.a(view, i10);
                                                if (textView6 != null) {
                                                    i10 = R$id.tvUpdatedAt;
                                                    TextView textView7 = (TextView) C5437a.a(view, i10);
                                                    if (textView7 != null) {
                                                        return new j((LinearLayout) view, frameLayout, imageView, linearLayout, linearLayout2, linearLayout3, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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

    public static j c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_common, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
