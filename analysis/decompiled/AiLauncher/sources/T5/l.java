package T5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.foundation.R$id;
import com.stepos.ailauncher.foundation.R$layout;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiLoopMarqueeTextView;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class l {
    public final LinearLayout btnDidiPillCta;
    public final TextView btnDidiPrimary;
    public final TextView btnDidiSecondary;
    public final ImageView ivDidiAuthIcon;
    public final ImageView ivDidiDriverAvatar;
    public final ImageView ivDidiPlateCar;
    public final LinearLayout llDidiAuthHeader;
    public final LinearLayout llDidiButtons;
    public final LinearLayout llDidiCtaRowValue;
    public final LinearLayout llDidiInfoRows;
    public final LinearLayout llDidiPillCta;
    public final LinearLayout llDidiPlate;
    public final LinearLayout llDidiShell;
    public final LinearLayout llDidiStoreHeader;
    public final LinearLayout llDidiTitleRow;
    private final LinearLayout rootView;
    public final ViewStub stubDidiAppStore;
    public final ViewStub stubDidiCarType;
    public final TextView tvDidiAuthSubtitle;
    public final TextView tvDidiAuthSuccess;
    public final TextView tvDidiAuthTitle;
    public final TextView tvDidiCtaAmountNumber;
    public final TextView tvDidiCtaAmountSymbol;
    public final TextView tvDidiCtaRowLabel;
    public final TextView tvDidiNote;
    public final TextView tvDidiPillLabel;
    public final TextView tvDidiPlateSubtitle;
    public final DidiLoopMarqueeTextView tvDidiPlateTitle;
    public final TextView tvDidiRoute;
    public final TextView tvDidiStoreName;
    public final DidiLoopMarqueeTextView tvDidiSummary;
    public final TextView tvDidiTitle;
    public final DidiLoopMarqueeTextView tvDidiTitleTrailing;
    public final View vDidiPillDivider;

    public l(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, ViewStub viewStub, ViewStub viewStub2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, DidiLoopMarqueeTextView didiLoopMarqueeTextView, TextView textView12, TextView textView13, DidiLoopMarqueeTextView didiLoopMarqueeTextView2, TextView textView14, DidiLoopMarqueeTextView didiLoopMarqueeTextView3, View view) {
        this.rootView = linearLayout;
        this.btnDidiPillCta = linearLayout2;
        this.btnDidiPrimary = textView;
        this.btnDidiSecondary = textView2;
        this.ivDidiAuthIcon = imageView;
        this.ivDidiDriverAvatar = imageView2;
        this.ivDidiPlateCar = imageView3;
        this.llDidiAuthHeader = linearLayout3;
        this.llDidiButtons = linearLayout4;
        this.llDidiCtaRowValue = linearLayout5;
        this.llDidiInfoRows = linearLayout6;
        this.llDidiPillCta = linearLayout7;
        this.llDidiPlate = linearLayout8;
        this.llDidiShell = linearLayout9;
        this.llDidiStoreHeader = linearLayout10;
        this.llDidiTitleRow = linearLayout11;
        this.stubDidiAppStore = viewStub;
        this.stubDidiCarType = viewStub2;
        this.tvDidiAuthSubtitle = textView3;
        this.tvDidiAuthSuccess = textView4;
        this.tvDidiAuthTitle = textView5;
        this.tvDidiCtaAmountNumber = textView6;
        this.tvDidiCtaAmountSymbol = textView7;
        this.tvDidiCtaRowLabel = textView8;
        this.tvDidiNote = textView9;
        this.tvDidiPillLabel = textView10;
        this.tvDidiPlateSubtitle = textView11;
        this.tvDidiPlateTitle = didiLoopMarqueeTextView;
        this.tvDidiRoute = textView12;
        this.tvDidiStoreName = textView13;
        this.tvDidiSummary = didiLoopMarqueeTextView2;
        this.tvDidiTitle = textView14;
        this.tvDidiTitleTrailing = didiLoopMarqueeTextView3;
        this.vDidiPillDivider = view;
    }

    public static l a(View view) {
        View viewA;
        int i10 = R$id.btnDidiPillCta;
        LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
        if (linearLayout != null) {
            i10 = R$id.btnDidiPrimary;
            TextView textView = (TextView) C5437a.a(view, i10);
            if (textView != null) {
                i10 = R$id.btnDidiSecondary;
                TextView textView2 = (TextView) C5437a.a(view, i10);
                if (textView2 != null) {
                    i10 = R$id.ivDidiAuthIcon;
                    ImageView imageView = (ImageView) C5437a.a(view, i10);
                    if (imageView != null) {
                        i10 = R$id.ivDidiDriverAvatar;
                        ImageView imageView2 = (ImageView) C5437a.a(view, i10);
                        if (imageView2 != null) {
                            i10 = R$id.ivDidiPlateCar;
                            ImageView imageView3 = (ImageView) C5437a.a(view, i10);
                            if (imageView3 != null) {
                                i10 = R$id.llDidiAuthHeader;
                                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                                if (linearLayout2 != null) {
                                    i10 = R$id.llDidiButtons;
                                    LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                                    if (linearLayout3 != null) {
                                        i10 = R$id.llDidiCtaRowValue;
                                        LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                                        if (linearLayout4 != null) {
                                            i10 = R$id.llDidiInfoRows;
                                            LinearLayout linearLayout5 = (LinearLayout) C5437a.a(view, i10);
                                            if (linearLayout5 != null) {
                                                i10 = R$id.llDidiPillCta;
                                                LinearLayout linearLayout6 = (LinearLayout) C5437a.a(view, i10);
                                                if (linearLayout6 != null) {
                                                    i10 = R$id.llDidiPlate;
                                                    LinearLayout linearLayout7 = (LinearLayout) C5437a.a(view, i10);
                                                    if (linearLayout7 != null) {
                                                        i10 = R$id.llDidiShell;
                                                        LinearLayout linearLayout8 = (LinearLayout) C5437a.a(view, i10);
                                                        if (linearLayout8 != null) {
                                                            i10 = R$id.llDidiStoreHeader;
                                                            LinearLayout linearLayout9 = (LinearLayout) C5437a.a(view, i10);
                                                            if (linearLayout9 != null) {
                                                                i10 = R$id.llDidiTitleRow;
                                                                LinearLayout linearLayout10 = (LinearLayout) C5437a.a(view, i10);
                                                                if (linearLayout10 != null) {
                                                                    i10 = R$id.stubDidiAppStore;
                                                                    ViewStub viewStub = (ViewStub) C5437a.a(view, i10);
                                                                    if (viewStub != null) {
                                                                        i10 = R$id.stubDidiCarType;
                                                                        ViewStub viewStub2 = (ViewStub) C5437a.a(view, i10);
                                                                        if (viewStub2 != null) {
                                                                            i10 = R$id.tvDidiAuthSubtitle;
                                                                            TextView textView3 = (TextView) C5437a.a(view, i10);
                                                                            if (textView3 != null) {
                                                                                i10 = R$id.tvDidiAuthSuccess;
                                                                                TextView textView4 = (TextView) C5437a.a(view, i10);
                                                                                if (textView4 != null) {
                                                                                    i10 = R$id.tvDidiAuthTitle;
                                                                                    TextView textView5 = (TextView) C5437a.a(view, i10);
                                                                                    if (textView5 != null) {
                                                                                        i10 = R$id.tvDidiCtaAmountNumber;
                                                                                        TextView textView6 = (TextView) C5437a.a(view, i10);
                                                                                        if (textView6 != null) {
                                                                                            i10 = R$id.tvDidiCtaAmountSymbol;
                                                                                            TextView textView7 = (TextView) C5437a.a(view, i10);
                                                                                            if (textView7 != null) {
                                                                                                i10 = R$id.tvDidiCtaRowLabel;
                                                                                                TextView textView8 = (TextView) C5437a.a(view, i10);
                                                                                                if (textView8 != null) {
                                                                                                    i10 = R$id.tvDidiNote;
                                                                                                    TextView textView9 = (TextView) C5437a.a(view, i10);
                                                                                                    if (textView9 != null) {
                                                                                                        i10 = R$id.tvDidiPillLabel;
                                                                                                        TextView textView10 = (TextView) C5437a.a(view, i10);
                                                                                                        if (textView10 != null) {
                                                                                                            i10 = R$id.tvDidiPlateSubtitle;
                                                                                                            TextView textView11 = (TextView) C5437a.a(view, i10);
                                                                                                            if (textView11 != null) {
                                                                                                                i10 = R$id.tvDidiPlateTitle;
                                                                                                                DidiLoopMarqueeTextView didiLoopMarqueeTextView = (DidiLoopMarqueeTextView) C5437a.a(view, i10);
                                                                                                                if (didiLoopMarqueeTextView != null) {
                                                                                                                    i10 = R$id.tvDidiRoute;
                                                                                                                    TextView textView12 = (TextView) C5437a.a(view, i10);
                                                                                                                    if (textView12 != null) {
                                                                                                                        i10 = R$id.tvDidiStoreName;
                                                                                                                        TextView textView13 = (TextView) C5437a.a(view, i10);
                                                                                                                        if (textView13 != null) {
                                                                                                                            i10 = R$id.tvDidiSummary;
                                                                                                                            DidiLoopMarqueeTextView didiLoopMarqueeTextView2 = (DidiLoopMarqueeTextView) C5437a.a(view, i10);
                                                                                                                            if (didiLoopMarqueeTextView2 != null) {
                                                                                                                                i10 = R$id.tvDidiTitle;
                                                                                                                                TextView textView14 = (TextView) C5437a.a(view, i10);
                                                                                                                                if (textView14 != null) {
                                                                                                                                    i10 = R$id.tvDidiTitleTrailing;
                                                                                                                                    DidiLoopMarqueeTextView didiLoopMarqueeTextView3 = (DidiLoopMarqueeTextView) C5437a.a(view, i10);
                                                                                                                                    if (didiLoopMarqueeTextView3 != null && (viewA = C5437a.a(view, (i10 = R$id.vDidiPillDivider))) != null) {
                                                                                                                                        return new l((LinearLayout) view, linearLayout, textView, textView2, imageView, imageView2, imageView3, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, viewStub, viewStub2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, didiLoopMarqueeTextView, textView12, textView13, didiLoopMarqueeTextView2, textView14, didiLoopMarqueeTextView3, viewA);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static l c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R$layout.view_card_didi, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.rootView;
    }
}
